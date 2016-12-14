package auto.explorer.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import java.text.DecimalFormat;

import auto.explorer.R;
import auto.explorer.base.ExplorerTextView;
import auto.explorer.model.CurrentState;
import auto.explorer.util.Const;

/**
 * Created by Eugene on 26.10.2016
 */

public class SubtitleTextView extends ExplorerTextView {

    private static final DecimalFormat df = new DecimalFormat(",###");
    private final String text;

    public SubtitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        text = getResources().getString(R.string.search_result_count);
    }

    public void update(@NonNull String tag) {
        switch (tag) {
            case Const.SEARCH_FRAGMENT:
                hide();
                break;
            case Const.CARDS_FRAGMENT:
                showCardsFrag();
                break;
            case Const.DETAILS_FRAGMENT:
                hide();
                break;
            case Const.FAV_FRAGMENT:
                hide();
                break;
            case Const.SETTINGS_FRAGMENT:
                showSettingsFrag();
                break;
            default:
                hide();
        }
    }

    private void hide() {
        setVisibility(GONE);
    }

    private void showCardsFrag() {
        setVisibility(VISIBLE);
        final CurrentState cs = CurrentState.getInstance();
        final String total = df.format(cs.getTotalFound());
        final String showed = df.format(cs.getCarList().size());
        setText(String.format(text, showed, total));
    }

    private void showSettingsFrag() {
        setVisibility(VISIBLE);
        setText(R.string.settings);
    }
}
