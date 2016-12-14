package auto.explorer.view.check;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;

import auto.explorer.R;
import auto.explorer.base.BaseAdditionalEquipment;

/**
 * Created by Eugene on 23.10.2016
 */

public class StartStopAuto extends BaseAdditionalEquipment {

    public StartStopAuto(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView.setText(R.string.check_start_stop_auto);
        check(searchProfile.isStartStopAuto());
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        check(searchProfile.isStartStopAuto());
    }

    protected void updateRemoteConfig() {
        searchProfile.setStartStopAuto(checkBox.isChecked());
    }
}
