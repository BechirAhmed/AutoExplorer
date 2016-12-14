package auto.explorer.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import auto.explorer.R;
import auto.explorer.fragment.SearchFragment;
import auto.explorer.interfaces.CallbackWithSearchFragment;
import auto.explorer.interfaces.CanClearSearchProfile;

/**
 * Created by Eugene on 23.10.2016
 */

public abstract class BaseAdditionalEquipment extends ExplorerCheckButton implements View.OnClickListener, CanClearSearchProfile, CallbackWithSearchFragment {

    protected TextView textView;
    private SearchFragment listener;

    public BaseAdditionalEquipment(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView = (TextView) findViewById(R.id.explorerCheckTextView);
        checkBox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        updateRemoteConfig();
        if (listener != null) listener.checkSavedProfiles();
    }

    @Override
    public void clearSearchProfile() {
        checkBox.setChecked(false);
        updateRemoteConfig();
    }

    protected abstract void updateRemoteConfig();

    @Override
    public void setListener(SearchFragment listener) {
        this.listener = listener;
    }
}
