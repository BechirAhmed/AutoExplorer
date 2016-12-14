package auto.explorer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import auto.explorer.R;
import auto.explorer.base.TintedImageView;
import auto.explorer.model.CurrentState;

/**
 * Created by Eugene on 24.10.2016
 */

public class SearchDetailsLayout extends LinearLayout implements View.OnClickListener {

    private View collapsedLayout;
    private TintedImageView collapseButton;

    public SearchDetailsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.details_layout, this);
        collapsedLayout = findViewById(R.id.collapsedLayout);
        collapseButton = (TintedImageView) findViewById(R.id.collapseExpand);
        collapseButton.setOnClickListener(this);
        collapseButton.setChecked(CurrentState.getInstance().isAdvSearchCollapsed());
        updateLayout();
    }

    @Override
    public void onClick(View v) {
        collapseButton.setChecked(!collapseButton.isChecked());
        CurrentState.getInstance().setAdvSearchCollapsed(collapseButton.isChecked());
        updateLayout();
    }

    private void updateLayout() {
        if (collapseButton.isChecked()) collapsedLayout.setVisibility(GONE);
        else collapsedLayout.setVisibility(VISIBLE);
    }
}
