package auto.explorer.view.check;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;

import auto.explorer.R;
import auto.explorer.base.BaseAdditionalEquipment;

/**
 * Created by Eugene on 23.10.2016
 */

public class WithPhoto extends BaseAdditionalEquipment {

    public WithPhoto(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView.setText(R.string.check_with_photo);
        check(searchProfile.isWithPhoto());
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        check(searchProfile.isWithPhoto());
    }

    protected void updateRemoteConfig() {
        searchProfile.setWithPhoto(checkBox.isChecked());
    }
}
