package auto.explorer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.Locale;

import auto.explorer.MainActivity;
import auto.explorer.R;
import auto.explorer.adapter.DetailPagerAdapter;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * Created by Eugene on 30.11.2016
 */

public class FullScreenPhoto extends Dialog implements DialogInterface.OnDismissListener, ViewPager.OnPageChangeListener, View.OnClickListener {

    private final DetailPagerAdapter adapter;
    private final MainActivity activity;
    private final TextView counterTextView;
    private final ViewPager pager;
    private final int orient;

    public FullScreenPhoto(Context context, DetailPagerAdapter adapter, int pos, MainActivity activity) {
        super(context, R.style.FullScreenDialog);
        this.adapter = adapter;
        this.activity = activity;
        setContentView(R.layout.dialog_full_photo);
        final Window window = getWindow();
        if (window != null) window.setLayout(MATCH_PARENT, MATCH_PARENT);
        findViewById(R.id.dialogBackButton).setOnClickListener(this);
        counterTextView = (TextView) findViewById(R.id.dialogCounter);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter.setShowPalette(false);
        adapter.setFullScreen(true);
        pager.setAdapter(adapter);
        setOnDismissListener(this);
        pager.setCurrentItem(pos);
        pager.addOnPageChangeListener(this);
        onPageSelected(pos);
        orient = activity.getRequestedOrientation();
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        adapter.setShowPalette(true);
        adapter.setFullScreen(false);
        pager.removeOnPageChangeListener(this);
        activity.setRequestedOrientation(orient);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        counterTextView.setText(String.format(Locale.ROOT, "%d / %d", position + 1, adapter.getCount()));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        dismiss();
    }
}
