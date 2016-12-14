package auto.explorer.dialog;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;

import auto.explorer.R;
import auto.explorer.base.ExplorerAlertDialog;
import auto.explorer.fragment.SearchFragment;
import auto.explorer.interfaces.CanClearSearchProfile;

/**
 * Created by Eugene on 16.10.2016
 */

public class ClearSearchProfileDialog extends ExplorerAlertDialog implements DialogInterface.OnClickListener {

    private final SearchFragment frag;
    private ViewGroup container;

    public ClearSearchProfileDialog(SearchFragment frag, View container) {
        super(container.getContext());
        this.frag = frag;
        if (container instanceof ViewGroup) this.container = (ViewGroup) container;
        setTitle(R.string.reset_search_params);
        setMessage(R.string.reset_search_params_msg);
        setPositiveButton(R.string.reset, this);
        setNegativeButton(R.string.dialog_negative_btn, null);
    }

    private void recursivelyIterate(ViewGroup container) {
        for (int i = 0; i < container.getChildCount(); i++) {
            final View v = container.getChildAt(i);
            if (v instanceof ViewGroup) recursivelyIterate((ViewGroup) v);
            if (v instanceof CanClearSearchProfile) {
                ((CanClearSearchProfile) v).clearSearchProfile();
            }
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (container != null) recursivelyIterate(container);
        frag.checkSavedProfiles();
    }
}