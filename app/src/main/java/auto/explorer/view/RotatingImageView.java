package auto.explorer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import auto.explorer.R;

/**
 * Created by Eugene on 20.10.2016
 */

public class RotatingImageView extends ImageView {

    private final Animation animation;

    public RotatingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        animation = AnimationUtils.loadAnimation(context, R.anim.rotate);
    }

    public void startProgress() {
        startAnimation(animation);
    }

    public void stopProgress() {
        clearAnimation();
    }
}
