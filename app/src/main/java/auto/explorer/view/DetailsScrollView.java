package auto.explorer.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import auto.explorer.R;
import auto.explorer.model.Car;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.text.TextUtils.isEmpty;
import static android.text.TextUtils.join;

/**
 * Created by Eugene on 20.11.2016
 */

public class DetailsScrollView extends ScrollView {

    @BindView(R.id.detailsMarker) View marker;
    @BindView(R.id.detailsTitle) TextView title;
    @BindView(R.id.detailsPrice) TextView price;
    @BindView(R.id.detailsMile) TextView mileage;
    @BindView(R.id.detailsYear) TextView year;
    @BindView(R.id.detailsFuel) TextView fuel;
    @BindView(R.id.detailsPower) TextView power;
    @BindView(R.id.detailsConsumption) TextView consumption;
    @BindView(R.id.detailsTransmission) TextView gear;
    @BindView(R.id.detailsOwnerQty) TextView owner;
    @BindView(R.id.detailsExtColor) TextView extColor;
    @BindView(R.id.detailsSeller) TextView seller;

    public DetailsScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.fragment_car_detail_scroll_view, this);
        ButterKnife.bind(this, this);
    }

    public void update(@NonNull Car car) {
        title.setText(car.getTitle());
        price.setText(car.getPrice());
        mileage.setText(car.getMileage());
        year.setText(car.getManufactured());
        fuel.setText(car.getFuelType());
        power.setText(car.getPower());
        consumption.setText(car.getDetailConsumption().isEmpty() ? "" : join(",\n", car.getDetailConsumption()));
        gear.setText(car.getDetailGear());
        owner.setText(car.getDetailOwner());
        extColor.setText(car.getDetailExtColor());
        seller(car);
        additionalEquip(car);
        description(car);
    }

    private void description(@NonNull Car car) {
        if (isEmpty(car.getDetailDescription())) {
            findViewById(R.id.detailsDescriptionRow).setVisibility(GONE);
        } else {
            final TextView desc = (TextView) findViewById(R.id.detailsDescription);
            //noinspection deprecation
            desc.setText(Html.fromHtml(car.getDetailDescription()));
        }
    }

    private void seller(@NonNull Car car) {
        final ArrayList<String> sellerInfo = getSellerInfo(car);
        if (sellerInfo.isEmpty()) {
            seller.setText("");
        } else {
            marker.setVisibility(VISIBLE);
            seller.setText(join(",\n", sellerInfo));
        }
    }

    private void additionalEquip(@NonNull Car car) {
        final ArrayList<String> eq = car.getDetailEquipment();
        if (eq.isEmpty()) {
            findViewById(R.id.detailsEquipRow).setVisibility(GONE);
        } else {
            Collections.sort(eq);
            final TextView equip = (TextView) findViewById(R.id.detailsEquip);
            equip.setText(join(", ", eq));
        }
    }

    @NonNull
    private static ArrayList<String> getSellerInfo(@NonNull Car car) {
        final ArrayList<String> list = new ArrayList<>();
        if (!isEmpty(car.getDetailSellerName())) list.add(car.getDetailSellerName());
        if (!isEmpty(car.getDetailSellerPhone())) list.add(car.getDetailSellerPhone());
        if (!isEmpty(car.getDetailSellerAddress())) list.add(car.getDetailSellerAddress());
        return list;
    }
}