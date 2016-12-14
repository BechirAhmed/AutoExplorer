package auto.explorer.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import auto.explorer.MainActivity;
import auto.explorer.R;
import auto.explorer.adapter.AdapterBaseInterface;
import auto.explorer.model.CurrentState;

/**
 * Created by Eugene on 10.11.2016
 */

public class BaseFragment extends Fragment implements AdapterBaseInterface {

    protected MainActivity activity;
    protected View view;
    protected RecyclerView rv;
    protected int column;
    protected CurrentState currentState;

    public BaseFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        currentState = CurrentState.getInstance();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) activity = (MainActivity) context;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateSubtitleAndNavView();
        if (rv != null) rv.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (rv != null) applyOrientation();
    }

    protected void applyOrientation() {
        if (rv == null) return;
        final boolean showAsTiles = currentState.getSettings().isShowAsTiles();
        final Resources res = rv.getResources();
        rv.setHasFixedSize(true);
        if (res.getBoolean(R.bool.isPhone)) {
            phone(showAsTiles);
        } else {
            tablet(showAsTiles, res);
        }
    }

    private void phone(boolean showAsTiles) {
        if (showAsTiles) {
            if (column != 2) rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
            column = 2;
        } else {
            if (column != 1) rv.setLayoutManager(new LinearLayoutManager(getContext()));
            column = 1;
        }
    }

    private void tablet(boolean showAsTiles, Resources res) {
        int nc = res.getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? 1 : 2;
        if (showAsTiles) nc *= 2;
        if (nc != column) {
            rv.setLayoutManager(new GridLayoutManager(getContext(), nc));
            column = nc;
        }
    }

    protected void updateSubtitleAndNavView() {
        if (activity != null) activity.updateSubtitleAndNavView(getTag());
    }

    @Override
    public int getColumn() {
        return column;
    }
}