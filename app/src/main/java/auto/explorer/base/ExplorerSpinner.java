package auto.explorer.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Field;
import java.util.ArrayList;

import auto.explorer.R;
import auto.explorer.fragment.SearchFragment;
import auto.explorer.interfaces.CallbackWithSearchFragment;
import auto.explorer.interfaces.CanClearSearchProfile;
import auto.explorer.model.CurrentState;
import auto.explorer.model.GlobalConfig;
import auto.explorer.model.SearchProfile;

import static auto.explorer.util.Const.SPINNER_MAX_DROP_DOWN_ITEMS;

public class ExplorerSpinner extends Spinner implements CanClearSearchProfile, CallbackWithSearchFragment {

    protected SearchProfile searchProfile = CurrentState.getInstance().getSearchProfile();
    protected GlobalConfig globalConfig = GlobalConfig.getInstance();
    protected ArrayAdapter<String> adapter;
    protected SearchFragment listener;

    public ExplorerSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean performClick() {
        if (getAdapter() != null) {
            final int count = getAdapter().getCount();
            fuckSpinner(this, count > SPINNER_MAX_DROP_DOWN_ITEMS ? SPINNER_MAX_DROP_DOWN_ITEMS : count);
        }
        return super.performClick();
    }

    private static void fuckSpinner(Spinner spinner, int size) {
        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);
            android.widget.ListPopupWindow popupWindow = (android.widget.ListPopupWindow) popup.get(spinner);
            popupWindow.setHeight(spinner.getResources().getDimensionPixelSize(R.dimen.spinner_height) * size);
        } catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException e) {//
        }
    }

    public void createAdapter(Context context, int item, ArrayList<String> list) {
        adapter = new ArrayAdapter<>(context, item, R.id.text1, list);
        adapter.setDropDownViewResource(R.layout.spinner_drop_down);
        setAdapter(adapter);
    }

    @Override
    public void clearSearchProfile() {
        setSelection(0);
    }

    @Override
    public void setListener(SearchFragment listener) {
        this.listener = listener;
    }

    public ArrayAdapter<String> getSpinnerAdapter() {
        return adapter;
    }
}
