package auto.explorer.view.spinner;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import auto.explorer.R;
import auto.explorer.base.ExplorerSpinner;
import auto.explorer.fragment.SearchFragment;
import auto.explorer.interfaces.CallbackWithSearchFragment;
import auto.explorer.model.CurrentState;
import auto.explorer.model.SearchProfile;
import auto.explorer.util.Const;

import static auto.explorer.model.GlobalConfig.getInstance;

/**
 * Created by Eugene on 15.10.2016
 */

public class LandPlzRadiusView extends LinearLayout implements AdapterView.OnItemSelectedListener, CallbackWithSearchFragment {

    private ExplorerSpinner land;
    private ExplorerSpinner plz;
    private ExplorerSpinner radius;
    private SearchFragment listener;

    public LandPlzRadiusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.land_plz_radius_view, this);
        init();
    }

    private void init() {
        super.onFinishInflate();
        land = (ExplorerSpinner) findViewById(R.id.spinnerLand);
        plz = (ExplorerSpinner) findViewById(R.id.spinnerPLZ);
        radius = (ExplorerSpinner) findViewById(R.id.spinnerRadius);
        // TODO temporary disabled
//        plz.getSelectedView().setEnabled(false);
        plz.setEnabled(false);
        plz.setVisibility(GONE);
//        radius.getSelectedView().setEnabled(false);
        radius.setEnabled(false);
        radius.setVisibility(GONE);
        //
        if (isInEditMode()) return;
        land.createAdapter(getContext(), R.layout.spinner_item_land, getInstance().landList);
        plz.createAdapter(getContext(), R.layout.spinner_item_plz, getInstance().plzList);
        radius.createAdapter(getContext(), R.layout.spinner_item_radius, getInstance().radiusList);
        land.setOnItemSelectedListener(this);
        plz.setOnItemSelectedListener(this);
        radius.setOnItemSelectedListener(this);
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        final SearchProfile sp = CurrentState.getInstance().getSearchProfile();
        land.post(new Runnable() {
            @Override
            public void run() {
                land.setSelection(land.getSpinnerAdapter().getPosition(sp.getLand()));
            }
        });
//        plz.setSelection(plz.getSpinnerAdapter().getPosition(sp.getPlz()));
//        radius.setSelection(radius.getSpinnerAdapter().getPosition(sp.getRadius()));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        final SearchProfile sp = CurrentState.getInstance().getSearchProfile();
        if (parent.equals(land)) {
            sp.setLand(pos == 0 ? Const.ALL : land.getAdapter().getItem(pos).toString());
        } else if (parent.equals(plz)) {
            sp.setPlz(pos == 0 ? Const.ALL : plz.getAdapter().getItem(pos).toString());
        } else {
            sp.setRadius(pos == 0 ? Const.ALL : radius.getAdapter().getItem(pos).toString());
        }
        if (listener != null) listener.checkSavedProfiles();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void setListener(SearchFragment listener) {
        this.listener = listener;
    }
}
