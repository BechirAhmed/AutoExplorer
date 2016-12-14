package auto.explorer.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import auto.explorer.R;
import auto.explorer.adapter.FavAdapter;
import auto.explorer.adapter.FavItemTouchCallback;
import auto.explorer.dialog.DelFavDialog;
import auto.explorer.dialog.DeleteAllFavDialog;
import auto.explorer.model.CurrentState;
import butterknife.BindDrawable;
import butterknife.ButterKnife;

import static auto.explorer.util.Const.DETAILS_FRAGMENT;

/**
 * Created by Eugene on 19.10.2016
 */

public class FavFragment extends BaseFragment implements FavAdapter.Callback {

    @BindDrawable(R.drawable.ic_cards_list) Drawable icCards;
    @BindDrawable(R.drawable.ic_cards_tiles) Drawable icTiles;
    private MenuItem deleteAllItem;
    private MenuItem itemViewMode;

    public FavFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sb) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_fav, container, false);
            ButterKnife.bind(this, view);
            final View favEmptyStateLayout = view.findViewById(R.id.favEmptyStateLayout);
            rv = (RecyclerView) view.findViewById(R.id.favRv);
            applyOrientation();
            final FavAdapter adapter = new FavAdapter(activity, this, favEmptyStateLayout);
            rv.setAdapter(adapter);
            final ItemTouchHelper touchHelper = new ItemTouchHelper(new FavItemTouchCallback(adapter));
            touchHelper.attachToRecyclerView(rv);
        }
        rv.getAdapter().notifyDataSetChanged();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_fav, menu);
        deleteAllItem = menu.findItem(R.id.menu_fav_delete_all);
        deleteAllItem.setEnabled(!CurrentState.getInstance().getFavList().isEmpty());
        itemViewMode = menu.findItem(R.id.menu_view_mode);
        updateItem();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        final int id = item.getItemId();
        if (id == R.id.menu_fav_delete_all) showDeleteAllDialog();
        if (id == R.id.menu_view_mode) {
            boolean b = currentState.getSettings().isShowAsTiles();
            currentState.getSettings().setShowAsTiles(!b);
            updateItem();
            applyOrientation();
            rv.setRecycledViewPool(new RecyclerView.RecycledViewPool());
            rv.getAdapter().notifyDataSetChanged();
        }
        return true;
    }

    private void updateItem() {
        if (itemViewMode != null) {
            if (currentState.getSettings().isShowAsTiles()) {
                itemViewMode.setIcon(icCards);
            } else {
                itemViewMode.setIcon(icTiles);
            }
        }
    }

    private void showDeleteAllDialog() {
        new DeleteAllFavDialog(getContext(), deleteAllItem, rv.getAdapter()).show();
    }

    @Override
    public void showCarDetailFragment(int pos) {
        if (activity != null) {
            activity.getTransaction()
                    .replace(R.id.mainFragContainer, DetailFragment.newInstance(pos, true), DETAILS_FRAGMENT)
                    .addToBackStack(DETAILS_FRAGMENT).commit();
        }
    }

    @Override
    public void trashClick(int pos) {
        new DelFavDialog(getContext(), deleteAllItem, pos, rv.getAdapter()).show();
    }
}