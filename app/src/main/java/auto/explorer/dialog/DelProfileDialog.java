package auto.explorer.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import auto.explorer.R;
import auto.explorer.base.ExplorerAlertDialog;
import auto.explorer.model.CurrentState;

/**
 * Created by Eugene on 16.10.2016
 */

public class DelProfileDialog extends ExplorerAlertDialog implements DialogInterface.OnClickListener {

    private final MenuItem item;
    private final int pos;
    private final RecyclerView.Adapter adapter;

    public DelProfileDialog(Context context, MenuItem item, int pos, RecyclerView.Adapter adapter) {
        super(context);
        this.item = item;
        this.pos = pos;
        this.adapter = adapter;
        setTitle(R.string.del_profiles_dialog_title);
        setMessage(R.string.del_profiles_dialog_msg);
        setPositiveButton(R.string.del_profiles_dialog_positive, this);
        setNegativeButton(R.string.dialog_negative_btn, null);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        CurrentState.getInstance().getProfilesList().remove(pos);
        adapter.notifyItemRemoved(pos);
        item.setEnabled(adapter.getItemCount() > 0);
    }
}