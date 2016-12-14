package auto.explorer.view.check;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;

import auto.explorer.R;
import auto.explorer.base.BaseAdditionalEquipment;

/**
 * Created by Eugene on 23.10.2016
 */

public class HeadUpDisplay extends BaseAdditionalEquipment {

    public HeadUpDisplay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView.setText(R.string.check_head_up_display);
        check(searchProfile.isHeadUpDisplay());
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        check(searchProfile.isHeadUpDisplay());
    }

    protected void updateRemoteConfig() {
        searchProfile.setHeadUpDisplay(checkBox.isChecked());
    }
}
