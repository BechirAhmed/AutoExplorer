package auto.explorer.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import auto.explorer.R;
import auto.explorer.base.ExplorerCheckButton;
import auto.explorer.fragment.SearchFragment;
import auto.explorer.interfaces.CallbackWithSearchFragment;
import auto.explorer.interfaces.CanClearSearchProfile;

/**
 * Created by Eugene on 23.10.2016
 */

public class ExtColorMetallic extends ExplorerCheckButton implements View.OnClickListener, CanClearSearchProfile, CallbackWithSearchFragment {

    private SearchFragment listener;

    public ExtColorMetallic(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ((TextView) findViewById(R.id.explorerCheckTextView)).setText(R.string.color_metallic);
        check(searchProfile.isMetallic());
        checkBox.setOnClickListener(this);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        check(searchProfile.isMetallic());
    }

    @Override
    public void onClick(View v) {
        updateRemoteConfig();
    }

    @Override
    public void clearSearchProfile() {
        checkBox.setChecked(false);
        updateRemoteConfig();
    }

    private void updateRemoteConfig() {
        searchProfile.setMetallic(checkBox.isChecked());
        if (listener != null) listener.checkSavedProfiles();
    }

    @Override
    public void setListener(SearchFragment listener) {
        this.listener = listener;
    }
}
