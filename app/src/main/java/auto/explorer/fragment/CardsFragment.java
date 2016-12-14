package auto.explorer.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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
import auto.explorer.adapter.SearchResultsAdapter;
import auto.explorer.model.Car;
import auto.explorer.model.CurrentState;
import auto.explorer.parser.CanReceiveSearchResult;
import auto.explorer.parser.RequestParserHelper;
import auto.explorer.util.Util;
import auto.explorer.view.MoreResultsButton;
import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static auto.explorer.util.Const.DETAILS_FRAGMENT;
import static auto.explorer.util.Const.NOT_EXIST;

/**
 * Created by Eugene on 19.10.2016
 */

public class CardsFragment extends BaseFragment implements SearchResultsAdapter.Callback, CanReceiveSearchResult {

    @BindView(R.id.moreResultsButton) MoreResultsButton nextPageButton;
    @BindDrawable(R.drawable.ic_cards_list) Drawable icCards;
    @BindDrawable(R.drawable.ic_cards_tiles) Drawable icTiles;
    private CurrentState currentState;
    private MenuItem itemViewMode;

    public CardsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sb) {
        currentState = CurrentState.getInstance();
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_cards, container, false);
            ButterKnife.bind(this, view);
            nextPageButton.updateButtonCaption();
            rv = (RecyclerView) view.findViewById(R.id.carRv);
            rv.setAdapter(new SearchResultsAdapter(activity, currentState.getCarList(), this));
        }
        rv.getAdapter().notifyDataSetChanged();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        applyOrientation();
    }

    @Override
    public void showSearchButton(boolean show) {
        if (show) nextPageButton.show();
        else nextPageButton.hide();
    }

    @Override
    public void onSearchCompleted(ArrayList<Car> cars) {
        nextPageButton.setInProgress(false);
        updateSubtitleAndNavView();
        if (cars.isEmpty()) noResults();
        else hasResults(cars);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_cards, menu);
        itemViewMode = menu.findItem(R.id.menu_view_mode);
        updateItem();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        final int id = item.getItemId();
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

    @OnClick(R.id.moreResultsButton)
    void onClickMoreResult() {
        nextPageButton.setInProgress(true);
        final int page = currentState.getCurrentPage() + 1;
        currentState.setCurrentPage(page);
        currentState.setTotalFound(0);
        RequestParserHelper.getInstance().searchCars(CurrentState.getInstance().getSearchProfile(), page, this, nextPageButton);
    }

    private void hasResults(ArrayList<Car> cars) {
        final ArrayList<Car> carList = currentState.getCarList();
        carList.addAll(cars);
        Log.i("***", "CARDS FRAGMENT list size " + carList.size());
        updateSubtitleAndNavView();
        rv.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showCarDetailFragment(int pos) {
        if (activity != null) activity.getTransaction()
                .replace(R.id.mainFragContainer, DetailFragment.newInstance(pos, false), DETAILS_FRAGMENT)
                .addToBackStack(DETAILS_FRAGMENT).commit();
    }

    @Override
    public void heartClick(int pos) {
        final Car car = currentState.getCarList().get(pos);
        final ArrayList<Car> favList = currentState.getFavList();
        final int posInFav = Util.isFavoriteExist(car);
        if (posInFav == NOT_EXIST) favList.add(car);
        else favList.remove(posInFav);
        rv.getAdapter().notifyItemChanged(pos);
    }

    private void noResults() {
        Toast.makeText(getContext(), "No results. Not realized yet. We are sorry.", Toast.LENGTH_LONG).show();
    }
}