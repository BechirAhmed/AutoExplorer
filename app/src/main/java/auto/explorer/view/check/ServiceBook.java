package auto.explorer.view.check;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;

import auto.explorer.R;
import auto.explorer.base.BaseAdditionalEquipment;

/**
 * Created by Eugene on 23.10.2016
 */

public class ServiceBook extends BaseAdditionalEquipment {

    public ServiceBook(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView.setText(R.string.check_service_book);
        check(searchProfile.isServiceBook());
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        check(searchProfile.isServiceBook());
    }

    protected void updateRemoteConfig() {
        searchProfile.setServiceBook(checkBox.isChecked());
    }
}
