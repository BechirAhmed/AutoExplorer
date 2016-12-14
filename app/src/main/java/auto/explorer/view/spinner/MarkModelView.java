package auto.explorer.view.spinner;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import auto.explorer.R;
import auto.explorer.fragment.SearchFragment;
import auto.explorer.interfaces.CallbackWithSearchFragment;
import auto.explorer.model.CurrentState;
import auto.explorer.model.GlobalConfig;
import auto.explorer.model.SearchProfile;

import static auto.explorer.util.Const.ALL;

/**
 * Created by Eugene on 15.10.2016
 */

public class MarkModelView extends LinearLayout implements AdapterView.OnItemSelectedListener, CallbackWithSearchFragment {

    private MarkSpinner markSpinner;
    private ModelSpinner modelSpinner;
    private SearchProfile searchProfile;
    private SearchFragment listener;

    public MarkModelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.mark_model_view, this);
        markSpinner = (MarkSpinner) findViewById(R.id.spinnerMark);
        modelSpinner = (ModelSpinner) findViewById(R.id.spinnerModel);
        markSpinner.setOnItemSelectedListener(this);
        modelSpinner.setOnItemSelectedListener(this);
        searchProfile = CurrentState.getInstance().getSearchProfile();
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        init();
    }

    private void init() {
        markSpinner.setOnItemSelectedListener(null);
        modelSpinner.setOnItemSelectedListener(null);
        final GlobalConfig globalConfig = GlobalConfig.getInstance();
        final int posMark = globalConfig.getMarks().indexOf(searchProfile.getMark());
        modelSpinner.updateAdapter();
        final int posModel = globalConfig.autoMap.get(searchProfile.getMark()).indexOf(searchProfile.getModel());
        markSpinner.post(new Runnable() {
            @Override
            public void run() {
                markSpinner.setSelection(posMark);
                modelSpinner.setSelection(posModel);
                markSpinner.setOnItemSelectedListener(MarkModelView.this);
                modelSpinner.setOnItemSelectedListener(MarkModelView.this);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if (parent.equals(markSpinner)) {
            final String mark = parent.getSelectedItem().toString();
            if (!mark.equals(searchProfile.getMark())) {
                searchProfile.setMark(mark);
                searchProfile.setModel(ALL);
                modelSpinner.updateAdapter();
            }
        } else {
            searchProfile.setModel(parent.getSelectedItem().toString());
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