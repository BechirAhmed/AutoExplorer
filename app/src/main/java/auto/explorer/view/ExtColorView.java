package auto.explorer.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import auto.explorer.R;
import auto.explorer.base.TintedImageView;
import auto.explorer.fragment.SearchFragment;
import auto.explorer.interfaces.CallbackWithSearchFragment;
import auto.explorer.interfaces.CanClearSearchProfile;
import auto.explorer.model.CurrentState;

public class ExtColorView extends RelativeLayout implements CanClearSearchProfile, View.OnClickListener, CallbackWithSearchFragment {

    private ViewGroup grid;
    private TintedImageView expandButton;
    private SearchFragment listener;

    public ExtColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.ext_color_view, this);
        grid = (ViewGroup) findViewById(R.id.gridColoredCheckboxes);
        updateColorCheckBoxes();
        expandButton = (TintedImageView) findViewById(R.id.collapseExpand);
        expandButton.setOnClickListener(this);
        expandButton.setChecked(CurrentState.getInstance().isAdvSearchColorViewCollapsed());
        updateLayout();
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        updateColorCheckBoxes();
    }

    private void updateColorCheckBoxes() {
        final ArrayList<String> extColors = CurrentState.getInstance().getSearchProfile().getExtColors();
        for (int i = 0; i < grid.getChildCount(); i++) {
            final View view = grid.getChildAt(i);
            if (view instanceof ExtColor) {
                final ExtColor chk = (ExtColor) view;
                chk.check(extColors.contains(chk.getColorTag()));
                chk.setCheckBoxListener(this);
            }
        }
    }

    @Override
    public void clearSearchProfile() {
        CurrentState.getInstance().getSearchProfile().getExtColors().clear();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.collapseExpand) collapse();
        else checkButton(view);
    }

    private void checkButton(View view) {
        final CheckBox checkBox = (CheckBox) view;
        final ArrayList<String> extColors = CurrentState.getInstance().getSearchProfile().getExtColors();
        final String tag = view.getTag().toString();
        if (checkBox.isChecked()) extColors.add(tag);
        else extColors.remove(tag);
        if (listener != null) listener.checkSavedProfiles();
    }

    private void collapse() {
        expandButton.setChecked(!expandButton.isChecked());
        CurrentState.getInstance().setAdvSearchColorViewCollapsed(expandButton.isChecked());
        updateLayout();
    }

    private void updateLayout() {
        if (expandButton.isChecked()) grid.setVisibility(GONE);
        else grid.setVisibility(VISIBLE);
    }

    @Override
    public void setListener(SearchFragment listener) {
        this.listener = listener;
    }
}
