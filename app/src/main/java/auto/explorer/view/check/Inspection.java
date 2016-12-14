package auto.explorer.view.check;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;

import auto.explorer.R;
import auto.explorer.base.BaseAdditionalEquipment;

/**
 * Created by Eugene on 23.10.2016
 */

public class Inspection extends BaseAdditionalEquipment {

    public Inspection(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView.setText(R.string.check_inspection);
        check(searchProfile.isInspection());
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        check(searchProfile.isInspection());
    }

    protected void updateRemoteConfig() {
        searchProfile.setInspection(checkBox.isChecked());
    }
}
