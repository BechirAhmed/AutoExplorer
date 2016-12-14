package auto.explorer.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import auto.explorer.R;
import auto.explorer.model.CurrentState;
import auto.explorer.model.SearchProfile;

/**
 * Created by Eugene on 23.10.2016
 */

public class ExplorerCheckButton extends LinearLayout {

    protected final SearchProfile searchProfile = CurrentState.getInstance().getSearchProfile();
    protected CheckBox checkBox;

    public ExplorerCheckButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.check_button, this);
        checkBox = (CheckBox) findViewById(R.id.explorerCheckBox);
    }

    public void check(final boolean state) {
        checkBox.post(new Runnable() {
            @Override
            public void run() {
                checkBox.setChecked(state);
            }
        });
    }
}
