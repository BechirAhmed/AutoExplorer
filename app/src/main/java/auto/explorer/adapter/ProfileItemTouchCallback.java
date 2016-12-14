package auto.explorer.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;

/**
 * Created by Eugene on 25.11.2016
 */

public class ProfileItemTouchCallback extends Callback {

    private final ProfileItemTouchHelperAdapter adapter;

    public ProfileItemTouchCallback(ProfilesAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        adapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder vh, int actionState) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            if (vh instanceof ProfileItemTouchHelperHolder) {
                ProfileItemTouchHelperHolder itemViewHolder = (ProfileItemTouchHelperHolder) vh;
                itemViewHolder.onItemSelected();
            }
        }
        super.onSelectedChanged(vh, actionState);
    }

    @Override
    public void clearView(RecyclerView rv, RecyclerView.ViewHolder vh) {
        super.clearView(rv, vh);
        if (vh instanceof ProfileItemTouchHelperHolder) {
            ProfileItemTouchHelperHolder itemViewHolder = (ProfileItemTouchHelperHolder) vh;
            itemViewHolder.onItemClear();
        }
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }
}