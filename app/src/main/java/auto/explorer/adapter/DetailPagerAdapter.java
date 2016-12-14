package auto.explorer.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import auto.explorer.MainActivity;
import auto.explorer.R;
import auto.explorer.dialog.FullScreenPhoto;
import auto.explorer.model.Car;

import static android.text.TextUtils.isEmpty;

/**
 * Created by Eugene on 03.11.2016
 */

public class DetailPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private final ArrayList<String> gallery = new ArrayList<>();
    private final Car car;
    private final TextView photoCounter;
    private final MainActivity activity;
    private boolean showPalette = true;
    private boolean updated;
    private int pos;
    private boolean fullScreen;

    public DetailPagerAdapter(Car car, TextView photoCounter, MainActivity activity) {
        this.car = car;
        this.photoCounter = photoCounter;
        this.activity = activity;
        gallery.add("");
    }

    @Override
    public Object instantiateItem(ViewGroup container, int pos) {
        final Context context = container.getContext();
        final ImageView iv = new ImageView(context);
        iv.setOnClickListener(this);
        iv.setImageResource(R.drawable.placeholder);
        final String link = gallery.get(pos);
        if (isEmpty(link)) {
            int id = link == null ? R.drawable.placeholder_no_photo : R.drawable.placeholder;
            Glide.with(context).load(id).asBitmap().format(DecodeFormat.PREFER_ARGB_8888)
                    .diskCacheStrategy(DiskCacheStrategy.ALL).into(iv);
        } else {
            Glide.with(context).load(link).asBitmap().format(DecodeFormat.PREFER_ARGB_8888)
                    .diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.placeholder)
                    .animate(android.R.anim.fade_in)
                    .into(new BitmapImageViewTarget(iv) {
                        @Override
                        public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> anim) {
                            super.onResourceReady(bitmap, anim);
                            if (showPalette) {
                                palette(bitmap, iv);
                            }
                        }
                    });
        }
        container.addView(iv, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return iv;
    }

    private void palette(Bitmap bitmap, final ImageView iv) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette p) {
                int bc = Color.WHITE;
                Palette.Swatch swatch = p.getDominantSwatch();
                if (swatch == null) {
                    List<Palette.Swatch> swatches = p.getSwatches();
                    if (!swatches.isEmpty()) bc = swatches.get(0).getRgb();
                } else {
                    bc = swatch.getRgb();
                }
                iv.setBackgroundColor(bc);
            }
        });
    }

    @Override
    public int getCount() {
        return gallery.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        this.pos = position;
        if (gallery.size() < 2) {
            photoCounter.setVisibility(View.GONE);
        } else {
            photoCounter.setVisibility(View.VISIBLE);
            photoCounter.setText(String.format(Locale.ROOT, "%d/%d", position + 1, gallery.size()));
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    public void update() {
        gallery.clear();
        if (car.getPhotos().isEmpty()) {
            if (isEmpty(car.getPosterUrl())) gallery.add(null);
            else gallery.add(car.getPosterUrl());
        } else {
            gallery.addAll(car.getPhotos());
        }
        notifyDataSetChanged();
        onPageSelected(0);
        updated = true;
    }

    @Override
    public void onClick(View view) {
        if (!updated || fullScreen) return;
        new FullScreenPhoto(view.getContext(), this, pos, activity).show();
    }

    public void setShowPalette(boolean showPalette) {
        this.showPalette = showPalette;
    }

    public void setFullScreen(boolean fullScreen) {
        this.fullScreen = fullScreen;
    }
}