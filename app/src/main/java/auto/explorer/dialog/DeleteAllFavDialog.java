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

public class DeleteAllFavDialog extends ExplorerAlertDialog implements DialogInterface.OnClickListener {

    private final MenuItem item;
    private final RecyclerView.Adapter adapter;

    public DeleteAllFavDialog(Context context, MenuItem item, RecyclerView.Adapter adapter) {
        super(context);
        this.item = item;
        this.adapter = adapter;
        setTitle(R.string.del_all_fav_dialog_title);
        setMessage(R.string.del_all_fav_dialog_msg);
        setPositiveButton(R.string.del_all_fav_dialog_positive, this);
        setNegativeButton(R.string.dialog_negative_btn, null);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        CurrentState.getInstance().getFavList().clear();
        adapter.notifyDataSetChanged();
        item.setEnabled(false);
    }
}