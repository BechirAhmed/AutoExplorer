package auto.explorer.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import auto.explorer.R;
import auto.explorer.base.ExplorerCheckButton;
import auto.explorer.interfaces.CanClearSearchProfile;

/**
 * Created by Eugene on 23.10.2016
 */

public class ExtColor extends ExplorerCheckButton implements CanClearSearchProfile {

    public ExtColor(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ExtColor);
        final int color = a.getColor(R.styleable.ExtColor_label_color, Color.BLACK);
        final String text = a.getString(R.styleable.ExtColor_label_text);
        final TextView textView = (TextView) findViewById(R.id.explorerCheckTextView);
        textView.setTextColor(color);
        textView.setText(text);
        a.recycle();
        checkBox.setTag(getTag());
    }

    public void setCheckBoxListener(@NonNull View.OnClickListener checkBoxListener) {
        checkBox.setOnClickListener(checkBoxListener);
    }

    public String getColorTag() {
        return checkBox.getTag().toString();
    }

    @Override
    public void clearSearchProfile() {
        checkBox.setChecked(false);
    }
}