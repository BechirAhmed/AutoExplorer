package auto.explorer.view.check;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;

import auto.explorer.R;
import auto.explorer.base.BaseAdditionalEquipment;

/**
 * Created by Eugene on 23.10.2016
 */

public class SeatHeating extends BaseAdditionalEquipment {

    public SeatHeating(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView.setText(R.string.check_seat_heating);
        check(searchProfile.isSeatHeating());
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        check(searchProfile.isSeatHeating());
    }

    protected void updateRemoteConfig() {
        searchProfile.setSeatHeating(checkBox.isChecked());
    }
}
