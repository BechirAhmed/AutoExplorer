package auto.explorer.base;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.design.widget.CheckableImageButton;
import android.util.AttributeSet;

import auto.explorer.R;

/**
 * Created by Eugene on 16.10.2016
 */

/**
 * Because on Pre-Lollipop devices ImageView can't be tinted with color selector
 **/
public class TintedImageView extends CheckableImageButton {

    private ColorStateList tint;

    public TintedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TintedImageView);
        tint = a.getColorStateList(R.styleable.TintedImageView_tint);
        a.recycle();
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (tint != null && tint.isStateful())
            updateTintColor();
    }

    private void updateTintColor() {
        int color = tint.getColorForState(getDrawableState(), 0);
        setColorFilter(color);
    }
}
