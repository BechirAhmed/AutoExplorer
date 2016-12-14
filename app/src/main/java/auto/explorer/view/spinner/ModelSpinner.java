package auto.explorer.view.spinner;

import android.content.Context;
import android.util.AttributeSet;

import java.util.ArrayList;

import auto.explorer.R;
import auto.explorer.base.ExplorerSpinner;

public class ModelSpinner extends ExplorerSpinner {

    public ModelSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) updateAdapter();
    }

    public void updateAdapter() {
        final ArrayList<String> list = globalConfig.autoMap.get(searchProfile.getMark());
        createAdapter(getContext(), R.layout.spinner_item_model, list);
    }
}
