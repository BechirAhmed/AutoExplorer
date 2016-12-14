package auto.explorer.view.spinner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import auto.explorer.util.Const;
import auto.explorer.R;
import auto.explorer.base.ExplorerSpinner;

import static android.graphics.PorterDuff.Mode.SRC_ATOP;
import static auto.explorer.model.GlobalConfig.getInstance;

public class EcoFilterSpinner extends ExplorerSpinner implements AdapterView.OnItemSelectedListener {

    public EcoFilterSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) return;
        adapter = new EcoFilterAdapter(context, R.layout.spinner_item_eco_filter, R.id.text1, getInstance().ecoFilterList);
        adapter.setDropDownViewResource(R.layout.spinner_drop_down_eco_filter);
        setAdapter(adapter);
        setOnItemSelectedListener(this);
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        setSelection(getSpinnerAdapter().getPosition(searchProfile.getEcoFilter()));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        searchProfile.setEcoFilter(pos == 0 ? Const.ALL : globalConfig.ecoFilterList.get(pos));
        if (listener != null) listener.checkSavedProfiles();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private static class EcoFilterAdapter extends ArrayAdapter<String> {

        EcoFilterAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @NonNull
        @Override
        public View getView(int pos, View convertView, @NonNull ViewGroup parent) {
            final View view = super.getView(pos, convertView, parent);
            setBackDrawable(view, pos);
            return view;
        }

        @Override
        public View getDropDownView(int pos, View convertView, @NonNull ViewGroup parent) {
            final View view = super.getDropDownView(pos, convertView, parent);
            setBackDrawable(view, pos);
            return view;
        }

        private static void setBackDrawable(View view, int pos) {
            final TextView tv = (TextView) view.findViewById(R.id.text1);
            if (pos == 0) {
                tv.setTextColor(0xDE000000);
                tv.setBackground(null);
            } else {
                final Drawable d = ContextCompat.getDrawable(view.getContext(), R.drawable.eco_filter_background);
                d.setColorFilter(getColor(pos), SRC_ATOP);
                tv.setTextColor(0xFFFFFFFF);
                tv.setBackground(d);
            }
        }

        private static int getColor(int pos) {
            return pos == 1 ? 0xFF42A31C : pos == 2 ? 0xFFFFD700 : 0xFFE63228;
        }
    }


}