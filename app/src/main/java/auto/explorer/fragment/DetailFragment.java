package auto.explorer.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import auto.explorer.R;
import auto.explorer.adapter.DetailPagerAdapter;
import auto.explorer.model.Car;
import auto.explorer.parser.RequestParserHelper;
import auto.explorer.util.Const;
import auto.explorer.view.DetailsScrollView;
import auto.explorer.view.RotatingImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.v4.content.ContextCompat.getDrawable;
import static android.text.TextUtils.isEmpty;
import static android.view.View.INVISIBLE;
import static auto.explorer.model.CurrentState.getInstance;
import static auto.explorer.util.Const.CAR_POS_IN_LIST;
import static auto.explorer.util.Const.NOT_EXIST;
import static auto.explorer.util.Util.isFavoriteExist;

public class DetailFragment extends BaseFragment implements RequestParserHelper.DetailPageLoadListener, PopupMenu.OnMenuItemClickListener {

    @BindView(R.id.detailsMarker) View marker;
    @BindView(R.id.detailsProgress) RotatingImageView progress;
    @BindView(R.id.detailsScrollView) DetailsScrollView detailsScrollView;
    @BindView(R.id.pagerPhotoCounter) TextView photoCounter;
    private Car car;
    private Menu menu;
    private ArrayList<String> phones;
    private DetailPagerAdapter adapter;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(int pos, boolean fromFav) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(CAR_POS_IN_LIST, pos);
        if (fromFav) args.putBoolean(Const.GET_FROM_FAV, true);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            int pos = getArguments().getInt(CAR_POS_IN_LIST);
            final boolean fromFav = getArguments().getBoolean(Const.GET_FROM_FAV);
            if (fromFav) car = getInstance().getFavList().get(pos);
            else car = getInstance().getCarList().get(pos);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_car_detail, container, false);
            ButterKnife.bind(this, view);
            marker.setVisibility(INVISIBLE);
            progress.setVisibility(View.GONE);
            photoCounter.setVisibility(View.GONE);
            requestDetails();
            final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
            adapter = new DetailPagerAdapter(car, photoCounter, activity);
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(adapter);
            updateSubtitleAndNavView();
        }
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        this.menu = menu;
        menu.clear();
        inflater.inflate(R.menu.menu_details, menu);
        updateHeart();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (activity == null) return true;
        switch (item.getItemId()) {
            case R.id.menu_details_call:
                if (phones.size() > 1) showPhonesPopup();
                else activity.callToOwner(phones.get(0));
                break;
            case R.id.menu_details_favorite:
                favClick();
                break;
            case R.id.menu_details_share:
                shareClick();
                break;
        }
        return true;
    }

    private void showPhonesPopup() {
        final View anchorView = activity.findViewById(R.id.menu_details_call);
        final Spinner spinner = new Spinner(activity);
        spinner.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary));
        spinner.setAdapter(new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, phones));
        final PopupMenu popupMenu = new PopupMenu(activity, anchorView);
        popupMenu.setOnMenuItemClickListener(this);
        final Menu menu = popupMenu.getMenu();
        for (String p : phones) menu.add(p);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        CharSequence title = menuItem.getTitle();
        if (title != null) activity.callToOwner(title.toString());
        return true;
    }

    private void requestDetails() {
        if (!isEmpty(car.getLinkToDetails())) {
            progress.setVisibility(View.VISIBLE);
            progress.startProgress();
            RequestParserHelper.getInstance().loadCarDetail(car, this);
        }
    }

    @Override
    public void onCarDetailPageLoad() {
        if (view != null) {
            progress.stopProgress();
            progress.setVisibility(View.GONE);
            adapter.update();
            detailsScrollView.update(car);
            if (menu != null) updateMenu();
        }
    }

    private void updateHeart() {
        final MenuItem item = menu.findItem(R.id.menu_details_favorite);
        if (item != null) {
            final int pos = isFavoriteExist(car);
            int id = pos != NOT_EXIST ? R.drawable.ic_fav_activated_toolbar : R.drawable.ic_fav_toolbar;
            item.setIcon(getDrawable(activity, id));
        }
    }

    private void updateMenu() {
        makePhoneList();
        if (phones != null && !phones.isEmpty()) {
            final MenuItem item = menu.findItem(R.id.menu_details_call);
            if (item != null) item.setVisible(true);
        }
    }

    private void favClick() {
        final ArrayList<Car> favList = getInstance().getFavList();
        final int pos = isFavoriteExist(car);
        if (pos == NOT_EXIST) favList.add(0, car);
        else favList.remove(pos);
        updateHeart();
    }

    private void shareClick() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TITLE, getString(R.string.action_share_title));
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, car.getTitle());
        sendIntent.putExtra(Intent.EXTRA_TEXT, car.getLinkToDetails());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void makePhoneList() {
        if (!isEmpty(car.getDetailSellerPhone())) {
            phones = new ArrayList<>();
            final String[] arr = car.getDetailSellerPhone().split(",");
            for (String s : arr) {
                String p = s.replaceAll("[^+\\d]", "");
                if (!p.isEmpty()) phones.add(p);
            }
            Log.i("***", "phone list: " + phones.size() + "\n" + car.getDetailSellerPhone());
        }
    }

    @OnClick(R.id.detailsMarker)
    void onMarkerClick() {
        Log.i("***", "MARKER CLICK");
        Uri gmmIntentUri = Uri.parse("geo:0,0?z=10&q=" + car.getDetailSellerAddress().replaceAll("\n", ""));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
            Log.i("***", "MAP INTENT");
            getContext().startActivity(mapIntent);
        }
    }
}
