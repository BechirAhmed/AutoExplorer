package auto.explorer.view.check;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;

import auto.explorer.R;
import auto.explorer.base.BaseAdditionalEquipment;

/**
 * Created by Eugene on 23.10.2016
 */

public class AllWheelDrive extends BaseAdditionalEquipment {

    public AllWheelDrive(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView.setText(R.string.check_all_wheel_drive);
        check(searchProfile.isAllWheelDrive());
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        check(searchProfile.isAllWheelDrive());
    }

    protected void updateRemoteConfig() {
        searchProfile.setAllWheelDrive(checkBox.isChecked());
    }
}
