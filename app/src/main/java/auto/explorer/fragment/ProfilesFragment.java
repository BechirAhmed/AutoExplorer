package auto.explorer.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import auto.explorer.R;
import auto.explorer.adapter.ProfileItemTouchCallback;
import auto.explorer.adapter.ProfilesAdapter;
import auto.explorer.dialog.DelProfileDialog;
import auto.explorer.dialog.DeleteAllProfilesDialog;
import auto.explorer.model.CurrentState;
import auto.explorer.model.SearchProfile;

/**
 * Created by Eugene on 19.10.2016
 */

public class ProfilesFragment extends BaseFragment implements ProfilesAdapter.Callback {

    private MenuItem deleteAllItem;

    public ProfilesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sb) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_profiles, container, false);
            final View profilesEmptyStateLayout = view.findViewById(R.id.profilesEmptyStateLayout);
            rv = (RecyclerView) view.findViewById(R.id.profilesRv);
            applyOrientation();
            final ProfilesAdapter adapter = new ProfilesAdapter(getContext(), this, profilesEmptyStateLayout);
            rv.setAdapter(adapter);
            final ItemTouchHelper touchHelper = new ItemTouchHelper(new ProfileItemTouchCallback(adapter));
            touchHelper.attachToRecyclerView(rv);
        }
        rv.getAdapter().notifyDataSetChanged();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (rv != null) rv.setLayoutManager(new LinearLayoutManager(activity));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_profiles, menu);
        deleteAllItem = menu.findItem(R.id.menu_profiles_delete_all);
        deleteAllItem.setEnabled(!CurrentState.getInstance().getProfilesList().isEmpty());
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        final int id = item.getItemId();
        if (id == R.id.menu_profiles_delete_all) showDeleteAllDialog();
        return super.onOptionsItemSelected(item);
    }

    private void showDeleteAllDialog() {
        new DeleteAllProfilesDialog(getContext(), deleteAllItem, rv.getAdapter()).show();
    }

    @Override
    public void loadProfile(int pos) {
        final SearchProfile p = currentState.getProfilesList().get(pos);
        SearchProfile.copy(p, currentState.getSearchProfile());
        activity.getSupportFragmentManager().popBackStack();
    }

    @Override
    public void trashClick(int pos) {
        new DelProfileDialog(getContext(), deleteAllItem, pos, rv.getAdapter()).show();
    }
}