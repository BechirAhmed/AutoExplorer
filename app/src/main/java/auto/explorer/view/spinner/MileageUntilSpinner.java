package auto.explorer.view.spinner;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

import auto.explorer.R;
import auto.explorer.base.ExplorerSpinner;
import auto.explorer.util.Const;

import static auto.explorer.model.GlobalConfig.getInstance;

public class MileageUntilSpinner extends ExplorerSpinner implements AdapterView.OnItemSelectedListener {

    public MileageUntilSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) return;
        createAdapter(context, R.layout.spinner_item_mileage_until, getInstance().mileageList);
        setOnItemSelectedListener(this);
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        setSelection(getSpinnerAdapter().getPosition(searchProfile.getMileageUntil()));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        searchProfile.setMileageUntil(pos == 0 ? Const.ALL : globalConfig.mileageList.get(pos));
        if (listener != null) listener.checkSavedProfiles();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}