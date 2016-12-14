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

public class MileageFromSpinner extends ExplorerSpinner implements AdapterView.OnItemSelectedListener {

    public MileageFromSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) return;
        createAdapter(context, R.layout.spinner_item_mileage_from, getInstance().mileageList);
        setOnItemSelectedListener(this);
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        setSelection(getSpinnerAdapter().getPosition(searchProfile.getMileageFrom()));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        searchProfile.setMileageFrom(pos == 0 ? Const.ALL : globalConfig.mileageList.get(pos));
        if (listener != null) listener.checkSavedProfiles();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}