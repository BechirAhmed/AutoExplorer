package auto.explorer.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.Locale;

import auto.explorer.MainActivity;
import auto.explorer.R;
import auto.explorer.model.Car;
import auto.explorer.model.CurrentState;
import auto.explorer.util.Const;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.text.TextUtils.isEmpty;
import static android.view.View.GONE;
import static auto.explorer.util.Util.isFavoriteExist;

/**
 * Created by Eugene on 19.10.2016
 */

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.ViewHolder> {

    private final MainActivity context;
    private final ArrayList<Car> carList;
    private final Callback listener;
    @BindDimen(R.dimen.card_view_bottom_margin) int marginFromBottom;
    @BindDimen(R.dimen.card_view_side_margins) int defaultBottomMargin;
    @BindDrawable(R.drawable.ic_fav_activated_card) Drawable inFavIcon;
    @BindDrawable(R.drawable.ic_fav_card) Drawable notInFavIcon;

    public SearchResultsAdapter(MainActivity context, ArrayList<Car> carList, @NonNull Callback listener) {
        this.context = context;
        this.carList = carList;
        this.listener = listener;
        ButterKnife.bind(this, context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int id = asTiles() ? R.layout.fragment_search_rv_item_tile : R.layout.fragment_search_rv_item;
        final View v = LayoutInflater.from(context).inflate(id, parent, false);
        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int pos) {
        listener.showSearchButton(pos >= carList.size() - 1);
        final Car car = carList.get(pos);
        setCounter(h.counter, car.getPhotosQty());
        final String posterUrl = car.getPosterUrl();
        if (isEmpty(posterUrl)) {
            Glide.with(context).load(R.drawable.placeholder_no_photo).asBitmap().format(DecodeFormat.PREFER_ARGB_8888)
                    .diskCacheStrategy(DiskCacheStrategy.ALL).into(h.poster);
        } else {
            Glide.with(context).load(posterUrl).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.placeholder).crossFade().into(h.poster);
        }
        h.title.setText(car.getTitle());
        h.price.setText(car.getPrice());
        setText(h.manufactured, car.getManufactured());
        setText(h.mileage, car.getMileage());
        setText(h.power, car.getPower());
        setText(h.fuel, car.getFuelType());
        setText(h.equip, car.getEquip());
        setText(h.seller, car.getSeller());
        setText(h.address, car.getAddress());
        setHeart(h.heart, car);
        //
        final MarginLayoutParams lp = (MarginLayoutParams) h.itemView.getLayoutParams();
        lp.bottomMargin = pos >= carList.size() - listener.getColumn() ? marginFromBottom : defaultBottomMargin;
    }

    @Override
    public void onViewAttachedToWindow(ViewHolder h) {
        super.onViewAttachedToWindow(h);
    }

    private void setCounter(@Nullable TextView tv, int qty) {
        if (tv == null) return;
        if (qty < 2) {
            tv.setVisibility(GONE);
        } else {
            tv.setVisibility(View.VISIBLE);
            tv.setText(String.format(Locale.ROOT, "1/%d", qty));
        }
    }

    private void setText(@Nullable TextView tv, String str) {
        if (tv != null) tv.setText(str);
    }

    private boolean asTiles() {
        return CurrentState.getInstance().getSettings().isShowAsTiles();
    }

    private void setHeart(ImageView iv, @NonNull Car car) {
        if (isEmpty(car.getLinkToDetails())) {
            iv.setVisibility(GONE);
        } else {
            iv.setVisibility(View.VISIBLE);
            final int pos = isFavoriteExist(car);
            iv.setImageDrawable(pos == Const.NOT_EXIST ? notInFavIcon : inFavIcon);
        }
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnLayoutChangeListener {
        private final Callback listener;
        @Nullable @BindView(R.id.carouselCounter) TextView counter;
        @BindView(R.id.cardViewHeart) ImageView heart;
        @BindView(R.id.cardViewPoster) ImageView poster;
        @BindView(R.id.cardViewTitle) TextView title;
        @BindView(R.id.cardViewPrice) TextView price;
        @Nullable @BindView(R.id.cardViewYear) TextView manufactured;
        @Nullable @BindView(R.id.cardViewMile) TextView mileage;
        @Nullable @BindView(R.id.cardViewPower) TextView power;
        @Nullable @BindView(R.id.cardViewFuel) TextView fuel;
        @Nullable @BindView(R.id.cardViewEquip) TextView equip;
        @Nullable @BindView(R.id.cardViewSeller) TextView seller;
        @Nullable @BindView(R.id.cardViewAddress) TextView address;

        ViewHolder(@NonNull View v, @NonNull Callback listener) {
            super(v);
            this.listener = listener;
            ButterKnife.bind(this, v);
            poster.addOnLayoutChangeListener(this);
        }

        @OnClick(R.id.cardView)
        void onCardClick() {
            if (listener != null) listener.showCarDetailFragment(getAdapterPosition());
        }

        @OnClick(R.id.cardViewHeart)
        void onHeartClick() {
            if (listener != null) listener.heartClick(getAdapterPosition());
        }

        @Override
        public void onLayoutChange(View imageView, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
            ViewGroup.LayoutParams lp = imageView.getLayoutParams();
            lp.height = (int) (imageView.getMeasuredWidth() / 1.33333f);
            imageView.setLayoutParams(lp);
        }
    }

    public interface Callback extends AdapterBaseInterface {
        void showSearchButton(boolean show);

        void showCarDetailFragment(int pos);

        void heartClick(int pos);
    }
}