package auto.explorer.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import auto.explorer.R;
import auto.explorer.fragment.SearchFragment;
import auto.explorer.interfaces.CallbackWithSearchFragment;
import auto.explorer.interfaces.CanClearSearchProfile;
import auto.explorer.model.CurrentState;

/**
 * Created by Eugene on 23.10.2016
 */

public class CarType extends LinearLayout implements View.OnClickListener, CanClearSearchProfile, CallbackWithSearchFragment {

    private final ArrayList<String> carTypes = CurrentState.getInstance().getSearchProfile().getCarTypes();
    private CheckBox checkBox;
    private final String carType;
    private SearchFragment listener;

    public CarType(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs.getIdAttribute() == null) setId(View.generateViewId());
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CarType);
        carType = a.getString(R.styleable.CarType_car_type);
        final int id = a.getResourceId(R.styleable.CarType_car_icon, -1);
        final Drawable icon = id == -1 ? null : ContextCompat.getDrawable(context, id);
        a.recycle();
        inflate(context, R.layout.check_button_with_icon, this);
        checkBox = (CheckBox) findViewById(R.id.explorerCheckBox);
        checkBox.setOnClickListener(this);
        ((TextView) findViewById(R.id.explorerCheckTextView)).setText(carType);
        ((ImageView) findViewById(R.id.explorerCheckIcon)).setImageDrawable(icon);
        check(carTypes.contains(carType));
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        check(carTypes.contains(carType));
    }

    @Override
    public void onClick(View v) {
        final CheckBox checkBox = (CheckBox) v;
        if (checkBox.isChecked()) carTypes.add(carType);
        else carTypes.remove(carType);
        if (listener != null) listener.checkSavedProfiles();
    }

    @Override
    public void clearSearchProfile() {
        checkBox.setChecked(false);
        carTypes.remove(carType);
    }

    private void check(final boolean state) {
            checkBox.post(new Runnable() {
                @Override
                public void run() {
                    checkBox.setChecked(state);
                }
            });
    }

    @Override
    public void setListener(SearchFragment listener) {
        this.listener = listener;
    }
}
