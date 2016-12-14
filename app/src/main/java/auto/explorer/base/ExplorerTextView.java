package auto.explorer.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import auto.explorer.ExplorerApplication;

/**
 * Created by Eugene on 15.10.2016
 */

public class ExplorerTextView extends TextView {

    public ExplorerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) init(context, attrs);
    }

    private void init(Context c, AttributeSet a) {
        setTypeface(((ExplorerApplication) c.getApplicationContext()).getTypeface(a));
    }
}