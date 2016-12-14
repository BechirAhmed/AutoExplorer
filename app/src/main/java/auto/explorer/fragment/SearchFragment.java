package auto.explorer.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import auto.explorer.R;
import auto.explorer.dialog.ClearSearchProfileDialog;
import auto.explorer.interfaces.CallbackWithSearchFragment;
import auto.explorer.model.Car;
import auto.explorer.model.SearchProfile;
import auto.explorer.parser.CanReceiveSearchResult;
import auto.explorer.parser.RequestParserHelper;
import auto.explorer.util.Const;
import auto.explorer.view.MoreResultsButton;
import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.design.widget.Snackbar.LENGTH_SHORT;
import static android.support.design.widget.Snackbar.make;

/**
 * Created by Eugene on 19.10.2016
 */

public class SearchFragment extends BaseFragment implements CanReceiveSearchResult {

    @BindView(R.id.moreResultsButton) MoreResultsButton nextPageButton;
    @BindView(R.id.detailsCover) View cover;
    @BindDrawable(R.drawable.ic_add_search_profile) Drawable icProfile;
    @BindDrawable(R.drawable.ic_add_search_profile_activated) Drawable icProfileActivated;
    private MenuItem menuProfileItem;

    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sb) {
        currentState.setCurrentPage(0);
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_search, container, false);
            ButterKnife.bind(this, view);
            nextPageButton.updateButtonCaption();
            if (view instanceof ViewGroup) recursivelyIterate((ViewGroup) view);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) checkSavedProfiles();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        menuProfileItem = menu.findItem(R.id.menu_add_search_profile);
        checkSavedProfiles();
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void checkSavedProfiles() {
        if (view != null) {
            view.getHandler().removeCallbacks(action);
            view.getHandler().postDelayed(action, 250);
        }
    }

    private final Runnable action = new Runnable() {
        @Override
        public void run() {
            final SearchProfile sp = currentState.getSearchProfile();
            if (!sp.equals(SearchProfile.DEFAULT)) {
                if (!menuProfileItem.isVisible()) menuProfileItem.setVisible(true);
                final boolean contains = currentState.getProfilesList().contains(sp);
                updateMenuProfileIcon(contains);
            } else {
                if (menuProfileItem.isVisible()) menuProfileItem.setVisible(false);
            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        final int id = item.getItemId();
        if (id == R.id.menu_search_clear_params) {
            new ClearSearchProfileDialog(this, view).show();
        } else if (id == R.id.menu_add_search_profile) {
            final ArrayList<SearchProfile> profilesList = currentState.getProfilesList();
            final boolean contains = profilesList.contains(currentState.getSearchProfile());
            if (contains) {
                make(activity.getRootView(), R.string.snack_search_profile_deleted, LENGTH_SHORT).show();
                profilesList.remove(currentState.getSearchProfile());
            } else {
                make(activity.getRootView(), R.string.snack_search_profile_saved, LENGTH_SHORT).show();
                profilesList.add(0, SearchProfile.getDeepClone(currentState.getSearchProfile()));
            }
            if (menuProfileItem != null) updateMenuProfileIcon(!contains);
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateMenuProfileIcon(boolean exist) {
        menuProfileItem.setIcon(exist ? icProfileActivated : icProfile);
    }

    @OnClick(R.id.moreResultsButton)
    void onClickMoreResults() {
        cover.setVisibility(View.VISIBLE);
        nextPageButton.setInProgress(true);
        currentState.setCurrentPage(1);
        currentState.setTotalFound(0);
        RequestParserHelper.getInstance().searchCars(currentState.getSearchProfile(), 1, this, nextPageButton);
    }

    @Override
    public void onSearchCompleted(ArrayList<Car> cars) {
        cover.postDelayed(hideCover, 500);
        nextPageButton.setInProgress(false);
        if (cars.isEmpty()) noResults();
        else hasResults(cars);
    }

    private void hasResults(ArrayList<Car> cars) {
        final ArrayList<Car> carList = currentState.getCarList();
        carList.clear();
        carList.addAll(cars);
        Log.i("***", "car list size " + carList.size());
        if (activity != null)
            activity.getTransaction().replace(R.id.mainFragContainer, new CardsFragment(), Const.CARDS_FRAGMENT)
                    .addToBackStack(Const.CARDS_FRAGMENT).commit();
    }

    // TODO вероятно надо добавить в парсере, если там прилетает исключение при подключении, значит нет инета, надо считать сколько их прилетело
    private void noResults() {
        Toast.makeText(getContext(), "No results. Not realized yet. We are sorry.", Toast.LENGTH_LONG).show();
    }

    private final Runnable hideCover = new Runnable() {
        @Override
        public void run() {
            cover.setVisibility(View.GONE);
        }
    };

    private void recursivelyIterate(ViewGroup container) {
        for (int i = 0; i < container.getChildCount(); i++) {
            final View v = container.getChildAt(i);
            if (v instanceof ViewGroup) recursivelyIterate((ViewGroup) v);
            if (v instanceof CallbackWithSearchFragment) {
                ((CallbackWithSearchFragment) v).setListener(this);
            }
        }
    }
}
