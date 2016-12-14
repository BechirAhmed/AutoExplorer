package auto.explorer.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.text.TextUtils.isEmpty;
import static android.view.View.GONE;
import static java.util.Collections.swap;

/**
 * Created by Eugene on 19.10.2016
 */

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> implements FavItemTouchHelperAdapter {

    private final Context context;
    private final Callback listener;
    private final View favEmptyStateLayout;
    private final ArrayList<Car> carList;
    @BindDrawable(R.drawable.ic_trash) Drawable trash;

    public FavAdapter(@NonNull MainActivity context, @NonNull Callback listener, @NonNull View favEmptyStateLayout) {
        this.context = context;
        this.listener = listener;
        this.favEmptyStateLayout = favEmptyStateLayout;
        this.carList = CurrentState.getInstance().getFavList();
        ButterKnife.bind(this, context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int id = asTiles() ? R.layout.fragment_search_rv_item_tile : R.layout.fragment_search_rv_item;
        final View v = LayoutInflater.from(context).inflate(id, parent, false);
        return new ViewHolder(v, listener, trash);
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int pos) {
        final Car car = carList.get(pos);
        setCounter(h.counter, car.getPhotos().size());
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

    @Override
    public int getItemCount() {
        int count = carList == null ? 0 : carList.size();
        if (count == 0) favEmptyStateLayout.setVisibility(View.VISIBLE);
        else favEmptyStateLayout.setVisibility(GONE);
        return count;
    }

    @Override
    public void onItemDismiss(int position) {
        carList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMove(int fPos, int tPos) {
        if (fPos < tPos) {
            for (int i = fPos; i < tPos; i++) swap(carList, i, i + 1);
        } else {
            for (int i = fPos; i > tPos; i--) swap(carList, i, i - 1);
        }
        notifyItemMoved(fPos, tPos);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements FavItemTouchHelperHolder, View.OnLayoutChangeListener {
        private final Callback listener;
        @BindView(R.id.cardView) CardView cardView;
        @Nullable @BindView(R.id.carouselCounter) TextView counter;
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

        ViewHolder(@NonNull View v, @NonNull Callback listener, Drawable trash) {
            super(v);
            this.listener = listener;
            ButterKnife.bind(this, v);
            final ImageView heart = ButterKnife.findById(v, R.id.cardViewHeart);
            heart.setImageDrawable(trash);
            poster.addOnLayoutChangeListener(this);
        }

        @OnClick(R.id.cardView)
        void onCardClick() {
            if (listener != null) listener.showCarDetailFragment(getAdapterPosition());
        }

        @OnClick(R.id.cardViewHeart)
        void onTrashClick() {
            if (listener != null) listener.trashClick(getAdapterPosition());
        }

        @Override
        public void onItemSelected() {
            cardView.setCardBackgroundColor(0xffd4ffd4);
        }

        @Override
        public void onItemClear() {
            cardView.setCardBackgroundColor(0xffffffff);
        }

        @Override
        public void onLayoutChange(View imageView, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
            ViewGroup.LayoutParams lp = imageView.getLayoutParams();
            lp.height = (int) (imageView.getMeasuredWidth() / 1.33333f);
            imageView.setLayoutParams(lp);
        }
    }

    public interface Callback extends AdapterBaseInterface {

        void showCarDetailFragment(int pos);

        void trashClick(int pos);
    }
}