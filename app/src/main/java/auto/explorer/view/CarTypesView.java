package auto.explorer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import auto.explorer.R;
import auto.explorer.base.TintedImageView;
import auto.explorer.interfaces.CanClearSearchProfile;
import auto.explorer.model.CurrentState;

public class CarTypesView extends RelativeLayout implements CanClearSearchProfile, View.OnClickListener {

    private ViewGroup grid;
    private TintedImageView expandButton;


    public CarTypesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.car_types_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        grid = (ViewGroup) findViewById(R.id.gridCarTypesCheckboxes);
        expandButton = (TintedImageView) findViewById(R.id.collapseExpand);
        expandButton.setOnClickListener(this);
        expandButton.setChecked(CurrentState.getInstance().isAdvSearchCarTypeCollapsed());
        updateLayout();
    }

    @Override
    public void clearSearchProfile() {
        CurrentState.getInstance().getSearchProfile().getCarTypes().clear();
    }

    @Override
    public void onClick(View view) {
        collapse();
    }

    private void collapse() {
        expandButton.setChecked(!expandButton.isChecked());
        CurrentState.getInstance().setAdvSearchCarTypeCollapsed(expandButton.isChecked());
        updateLayout();
    }

    private void updateLayout() {
        if (expandButton.isChecked()) grid.setVisibility(GONE);
        else grid.setVisibility(VISIBLE);
    }
}
