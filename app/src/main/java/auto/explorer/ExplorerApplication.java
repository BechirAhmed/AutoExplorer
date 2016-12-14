package auto.explorer;

import android.app.Application;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import static auto.explorer.util.Const.textStyleAttr;

/**
 * Created by Eugene on 15.10.2016
 */

public class ExplorerApplication extends Application {

    private Typeface typefaceRegular;
    private Typeface typefaceBold;

    @Override
    public void onCreate() {
        super.onCreate();
        typefaceRegular = Typeface.createFromAsset(getAssets(), "font/RobotoCondensed-Regular.ttf");
        typefaceBold = Typeface.createFromAsset(getAssets(), "font/RobotoCondensed-Bold.ttf");
    }

    public Typeface getTypeface(AttributeSet attrs) {
        TypedArray ta = obtainStyledAttributes(attrs, textStyleAttr);
        final int style = ta.getInt(0, Typeface.NORMAL);
        ta.recycle();
        return style == Typeface.NORMAL ? typefaceRegular : typefaceBold;
    }
}
