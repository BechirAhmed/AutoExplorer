package auto.explorer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import auto.explorer.R;
import auto.explorer.base.TintedImageView;
import auto.explorer.model.CurrentState;

public class EquipmentView extends RelativeLayout implements View.OnClickListener {

    private ViewGroup grid;
    private TintedImageView expandButton;

    public EquipmentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.equipment_view, this);
        grid = (ViewGroup) findViewById(R.id.equipLayout);
        expandButton = (TintedImageView) findViewById(R.id.collapseExpand);
        expandButton.setOnClickListener(this);
        expandButton.setChecked(CurrentState.getInstance().isAdvSearchEquipCollapsed());
        updateLayout();
    }

    @Override
    public void onClick(View view) {
        collapse();
    }

    private void collapse() {
        expandButton.setChecked(!expandButton.isChecked());
        CurrentState.getInstance().setAdvSearchEquipCollapsed(expandButton.isChecked());
        updateLayout();
    }

    private void updateLayout() {
        if (expandButton.isChecked()) grid.setVisibility(GONE);
        else grid.setVisibility(VISIBLE);
    }
}
