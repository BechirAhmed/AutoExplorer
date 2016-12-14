package auto.explorer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import auto.explorer.R;
import auto.explorer.base.ExplorerTextView;
import auto.explorer.model.CurrentState;
import auto.explorer.model.SearchProfile;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.text.TextUtils.join;
import static android.view.View.GONE;
import static auto.explorer.util.Util.diff;
import static java.util.Collections.swap;

/**
 * Created by Eugene on 19.10.2016
 */

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesAdapter.ViewHolder> implements ProfileItemTouchHelperAdapter {

    private final Context context;
    private final View profilesEmptyStateLayout;
    private final Callback listener;
    private final ArrayList<SearchProfile> profilesList;
    private final SearchProfile dsp; // default search profile

    public ProfilesAdapter(@NonNull Context context, @NonNull Callback listener, View profilesEmptyStateLayout) {
        this.context = context;
        this.profilesEmptyStateLayout = profilesEmptyStateLayout;
        profilesList = CurrentState.getInstance().getProfilesList();
        this.listener = listener;
        dsp = new SearchProfile();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(context).inflate(R.layout.fragment_profile_rv_item, parent, false);
        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int pos) {
        final SearchProfile sp = profilesList.get(pos);
        fillHolder(h, sp, dsp);
    }

    @Override
    public int getItemCount() {
        int count = profilesList == null ? 0 : profilesList.size();
        if (count == 0) profilesEmptyStateLayout.setVisibility(View.VISIBLE);
        else profilesEmptyStateLayout.setVisibility(GONE);
        return count;
    }

    @Override
    public void onItemMove(int fPos, int tPos) {
        if (fPos < tPos) {
            for (int i = fPos; i < tPos; i++) swap(profilesList, i, i + 1);
        } else {
            for (int i = fPos; i > tPos; i--) swap(profilesList, i, i - 1);
        }
        notifyItemMoved(fPos, tPos);
    }

    @Override
    public void onItemDismiss(int position) {
        profilesList.remove(position);
        notifyItemRemoved(position);
    }

    private void fillHolder(ViewHolder h, @NonNull SearchProfile sp, @NonNull SearchProfile dsp) {
        h.mark.setText(diff(dsp.getMark(), sp.getMark()));
        h.model.setText(diff(dsp.getModel(), sp.getModel()));
        h.priceFrom.setText(diff(dsp.getPriceFrom(), sp.getPriceFrom()));
        h.priceUntil.setText(diff(dsp.getPriceUntil(), sp.getPriceUntil()));
        h.manFrom.setText(diff(dsp.getManFrom(), sp.getManFrom()));
        h.manUntil.setText(diff(dsp.getManUntil(), sp.getManUntil()));
        h.mileageFrom.setText(diff(dsp.getMileageFrom(), sp.getMileageFrom()));
        h.mileageUntil.setText(diff(dsp.getMileageUntil(), sp.getMileageUntil()));
        h.fuel.setText(diff(dsp.getFuelType(), sp.getFuelType()));
        h.gear.setText(diff(dsp.getGearType(), sp.getGearType()));
        h.powerFrom.setText(diff(dsp.getPowerFrom(), sp.getPowerFrom()));
        h.powerUntil.setText(diff(dsp.getPowerUntil(), sp.getPowerUntil()));
        h.land.setText(diff(dsp.getLand(), sp.getLand()));
        h.sort.setText(diff(dsp.getSortType(), sp.getSortType()));
        h.profileExtColor.setText(sp.getExtColors().isEmpty() ? "" : join(", ", sp.getExtColors()));
        h.profileCarType.setText(sp.getCarTypes().isEmpty() ? "" : join(", ", sp.getCarTypes()));
        h.profileOwnerQty.setText(diff(dsp.getOwnerQty(), sp.getOwnerQty()));
        h.profileDamaged.setText(diff(dsp.getDamagedCars(), sp.getDamagedCars()));
        h.profileEcoClass.setText(diff(dsp.getEcoClass(), sp.getEcoClass()));
        h.profileEcoFilter.setText(diff(dsp.getEcoFilter(), sp.getEcoFilter()));
        h.profileSeller.setText(diff(dsp.getProvider(), sp.getProvider()));
        h.profileAdAge.setText(diff(dsp.getAdAge(), sp.getAdAge()));
        h.profileInterior.setText(diff(dsp.getInteriorEquip(), sp.getInteriorEquip()));
        h.profileOther.setText(getOther(sp));
    }

    @NonNull
    private String getOther(SearchProfile sp) {
        final ArrayList<String> list = new ArrayList<>();
        if (sp.isServiceBook()) list.add(getStr(R.string.check_service_book));
        if (sp.isInspection()) list.add(getStr(R.string.check_inspection));
        if (sp.isWithPhoto()) list.add(getStr(R.string.check_with_photo));
        if (sp.isWarranty()) list.add(getStr(R.string.check_warranty));
        if (sp.isAllWheelDrive()) list.add(getStr(R.string.check_all_wheel_drive));
        if (sp.isParkAssistant()) list.add(getStr(R.string.check_park_assistant));
        if (sp.isHeadUpDisplay()) list.add(getStr(R.string.check_head_up_display));
        if (sp.isConditioner()) list.add(getStr(R.string.check_conditioner));
        if (sp.isNavSystem()) list.add(getStr(R.string.check_nav_system));
        if (sp.isSunRoof()) list.add(getStr(R.string.check_sun_roof));
        if (sp.isSeatHeating()) list.add(getStr(R.string.check_seat_heating));
        if (sp.isTrackingAssist()) list.add(getStr(R.string.check_tracking_assist));
        if (sp.isHeating()) list.add(getStr(R.string.check_heating));
        if (sp.isStartStopAuto()) list.add(getStr(R.string.check_start_stop_auto));
        return join(", ", list);
    }

    @NonNull
    private String getStr(@StringRes int id) {
        return context.getResources().getString(id);
    }

    public interface Callback extends AdapterBaseInterface {

        void loadProfile(int pos);

        void trashClick(int pos);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements ProfileItemTouchHelperHolder {

        private final Callback listener;
        @BindView(R.id.cardViewProfileMark) ExplorerTextView mark;
        @BindView(R.id.cardViewProfileModel) ExplorerTextView model;
        @BindView(R.id.cardViewProfilePriceFrom) ExplorerTextView priceFrom;
        @BindView(R.id.cardViewProfilePriceUntil) ExplorerTextView priceUntil;
        @BindView(R.id.cardViewProfileManFrom) ExplorerTextView manFrom;
        @BindView(R.id.cardViewProfileManUntil) ExplorerTextView manUntil;
        @BindView(R.id.cardViewProfileMileageFrom) ExplorerTextView mileageFrom;
        @BindView(R.id.cardViewProfileMileageUntil) ExplorerTextView mileageUntil;
        @BindView(R.id.cardViewProfileFuel) ExplorerTextView fuel;
        @BindView(R.id.cardViewProfileGear) ExplorerTextView gear;
        @BindView(R.id.cardViewProfilePowerFrom) ExplorerTextView powerFrom;
        @BindView(R.id.cardViewProfilePowerUntil) ExplorerTextView powerUntil;
        @BindView(R.id.cardViewProfileLand) ExplorerTextView land;
        @BindView(R.id.cardViewProfileSort) ExplorerTextView sort;
        @BindView(R.id.cardViewProfileExtColor) ExplorerTextView profileExtColor;
        @BindView(R.id.cardViewProfileCarType) ExplorerTextView profileCarType;
        @BindView(R.id.cardViewProfileOwnerQty) ExplorerTextView profileOwnerQty;
        @BindView(R.id.cardViewProfileDamaged) ExplorerTextView profileDamaged;
        @BindView(R.id.cardViewProfileEcoClass) ExplorerTextView profileEcoClass;
        @BindView(R.id.cardViewProfileEcoFilter) ExplorerTextView profileEcoFilter;
        @BindView(R.id.cardViewProfileSeller) ExplorerTextView profileSeller;
        @BindView(R.id.cardViewProfileAdAge) ExplorerTextView profileAdAge;
        @BindView(R.id.cardViewProfileInterior) ExplorerTextView profileInterior;
        @BindView(R.id.cardViewProfileOther) ExplorerTextView profileOther;
        @BindView(R.id.cardViewProfileTrash) ImageView profileTrash;
        @BindView(R.id.cardView) CardView cardView;

        ViewHolder(@NonNull View v, @NonNull Callback listener) {
            super(v);
            this.listener = listener;
            ButterKnife.bind(this, v);
        }

        @OnClick(R.id.cardView)
        void onCardClick() {
            if (listener != null) listener.loadProfile(getAdapterPosition());
        }

        @OnClick(R.id.cardViewProfileTrash)
        void onTrashClick() {
            if (listener != null) listener.trashClick(getAdapterPosition());
        }

        @Override
        public void onItemSelected() {
            cardView.setCardBackgroundColor(0xffd4ffd4);
        }

        @Override
        public void onItemClear() {
            cardView.setCardBackgroundColor(0xffffffff);
        }

    }
}
