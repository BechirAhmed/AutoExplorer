package auto.explorer.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import auto.explorer.R;
import auto.explorer.model.CurrentState;
import auto.explorer.util.Const;

/**
 * Created by Eugene on 09.11.2016
 */

public class ExplorerNavView extends NavigationView implements DrawerLayout.DrawerListener {

    public ExplorerNavView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void update(@NonNull String tag) {
        switch (tag) {
            case Const.SEARCH_FRAGMENT:
                getMenu().findItem(R.id.nav_search).setChecked(true);
                break;
            case Const.CARDS_FRAGMENT:
                getMenu().findItem(R.id.nav_search).setChecked(true);
                break;
            case Const.DETAILS_FRAGMENT:
                getMenu().findItem(R.id.nav_search).setChecked(true);
                break;
            case Const.FAV_FRAGMENT:
                getMenu().findItem(R.id.nav_favorites).setChecked(true);
                break;
            case Const.PROFILES_FRAGMENT:
                getMenu().findItem(R.id.nav_search_profiles).setChecked(true);
                break;
            case Const.SETTINGS_FRAGMENT:
                getMenu().findItem(R.id.nav_settings).setChecked(true);
                break;
            default:
        }
    }

    private void updateFavCount() {
        final ViewGroup actionView = (ViewGroup) getMenu().findItem(R.id.nav_favorites).getActionView();
        final TextView tv = (TextView) actionView.getChildAt(0);
        final int size = CurrentState.getInstance().getFavList().size();
        if (size == 0) {
            tv.setVisibility(GONE);
        } else {
            tv.setVisibility(VISIBLE);
            tv.setText(String.valueOf(size));
        }
    }

    private void updateProfileCount() {
        final ViewGroup actionView = (ViewGroup) getMenu().findItem(R.id.nav_search_profiles).getActionView();
        final TextView tv = (TextView) actionView.getChildAt(0);
        final int size = CurrentState.getInstance().getProfilesList().size();
        if (size == 0) {
            tv.setVisibility(GONE);
        } else {
            tv.setVisibility(VISIBLE);
            tv.setText(String.valueOf(size));
        }
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
    }

    @Override
    public void onDrawerOpened(View drawerView) {
    }

    @Override
    public void onDrawerClosed(View drawerView) {
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        updateFavCount();
        updateProfileCount();
    }
}