package auto.explorer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.util.ArrayList;

import auto.explorer.fragment.FavFragment;
import auto.explorer.fragment.ProfilesFragment;
import auto.explorer.fragment.SearchFragment;
import auto.explorer.fragment.SettingsFragment;
import auto.explorer.model.Car;
import auto.explorer.model.CurrentState;
import auto.explorer.model.SearchProfile;
import auto.explorer.model.Settings;
import auto.explorer.util.Const;
import auto.explorer.view.ExplorerNavView;
import auto.explorer.view.SubtitleTextView;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
import static android.text.TextUtils.isEmpty;
import static auto.explorer.util.Const.PREFS_NAME;
import static auto.explorer.util.Const.PREF_FAV_LIST;
import static auto.explorer.util.Const.PREF_PROFILES_LIST;
import static auto.explorer.util.Const.PREF_SETTINGS;

/**
 * Created by Eugene on 19.10.2016
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.toolbarSubtitle) SubtitleTextView subtitle;
    @BindView(R.id.nav_view)
    ExplorerNavView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final boolean isPhone = getResources().getBoolean(R.bool.isPhone);
        if (isPhone) setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDrawer(toolbar);
        showSearchFragment();
    }

    private void initDrawer(Toolbar toolbar) {
        navView.setNavigationItemSelectedListener(this);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, android.R.string.ok, android.R.string.ok);
        toggle.setToolbarNavigationClickListener(this);
        drawer.addDrawerListener(toggle);
        drawer.addDrawerListener(navView);
        toggle.syncState();
        //
        final View hv = navView.getHeaderView(0);
        if (hv != null) {
            final TextView v = (TextView) hv.findViewById(R.id.versionName);
            if (v != null) v.setText(String.format("v %s", BuildConfig.VERSION_NAME));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        final ArrayList<Car> favList = CurrentState.getInstance().getFavList();
        SharedPreferences sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        final String favJson = sp.getString(PREF_FAV_LIST, null);
        if (!isEmpty(favJson)) {
            try {
                ArrayList<Car> list = new Gson().fromJson(favJson, Const.carListTypeToken);
                favList.clear();
                favList.addAll(list);
            } catch (JsonParseException e) {
                //
            }
        }
        final ArrayList<SearchProfile> profilesList = CurrentState.getInstance().getProfilesList();
        final String profilesJson = sp.getString(PREF_PROFILES_LIST, null);
        if (!isEmpty(profilesJson)) {
            try {
                ArrayList<SearchProfile> list = new Gson().fromJson(profilesJson, Const.profilesListTypeToken);
                profilesList.clear();
                profilesList.addAll(list);
            } catch (JsonParseException e) {
                //
            }
        }
        // settings
        String sett = sp.getString(PREF_SETTINGS, null);
        if (isEmpty(sett)) {
            CurrentState.getInstance().setSettings(new Settings());
        } else {
            try {
                Settings settings = new Gson().fromJson(sett, Settings.class);
                CurrentState.getInstance().setSettings(settings);
            } catch (JsonParseException e) {
                //
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        final ArrayList<Car> favList = CurrentState.getInstance().getFavList();
        final ArrayList<SearchProfile> profilesList = CurrentState.getInstance().getProfilesList();
        SharedPreferences.Editor edit = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        edit.putString(PREF_FAV_LIST, new Gson().toJson(favList));
        edit.putString(PREF_PROFILES_LIST, new Gson().toJson(profilesList)).apply();
        edit.putString(PREF_SETTINGS, new Gson().toJson(CurrentState.getInstance().getSettings())).apply();
    }

    @Override
    public void onClick(View view) {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void updateSubtitleAndNavView(@NonNull String tag) {
        if (subtitle != null) subtitle.update(tag);
        if (navView != null) navView.update(tag);
    }

    @SuppressLint("CommitTransaction")
    public FragmentTransaction getTransaction() {
        return getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_search:
                clearBackStack();
                break;
            case R.id.nav_favorites:
                showFavFragment();
                break;
            case R.id.nav_search_profiles:
                showProfilesFragment();
                break;
            case R.id.nav_settings:
                showSettingsFragment();
                break;
        }
        drawer.closeDrawers();
        return false;
    }

    private void showSearchFragment() {
        getTransaction().replace(R.id.mainFragContainer, new SearchFragment(), Const.SEARCH_FRAGMENT).commit();
    }

    private void showFavFragment() {
        clearBackStack();
        getTransaction()
                .replace(R.id.mainFragContainer, new FavFragment(), Const.FAV_FRAGMENT)
                .addToBackStack(Const.FAV_FRAGMENT).commit();
    }

    private void showProfilesFragment() {
        clearBackStack();
        getTransaction()
                .replace(R.id.mainFragContainer, new ProfilesFragment(), Const.PROFILES_FRAGMENT)
                .addToBackStack(Const.PROFILES_FRAGMENT).commit();
    }

    private void showSettingsFragment() {
        clearBackStack();
        getTransaction()
                .replace(R.id.mainFragContainer, new SettingsFragment(), Const.SETTINGS_FRAGMENT)
                .addToBackStack(Const.SETTINGS_FRAGMENT).commit();
    }

    private void clearBackStack() {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void callToOwner(@NonNull String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
        startActivity(intent);
    }

    public View getRootView() {
        return drawer;
    }
}