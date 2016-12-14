package auto.explorer.view.spinner;

import android.content.Context;
import android.util.AttributeSet;

import auto.explorer.R;
import auto.explorer.base.ExplorerSpinner;

public class MarkSpinner extends ExplorerSpinner {

    public MarkSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) createAdapter(getContext(), R.layout.spinner_item_marka, globalConfig.getMarks());
    }
}
