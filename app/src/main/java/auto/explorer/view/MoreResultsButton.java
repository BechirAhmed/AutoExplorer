package auto.explorer.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Locale;

import auto.explorer.R;
import auto.explorer.model.CurrentState;
import auto.explorer.parser.RequestParserHelper;
import auto.explorer.util.Const;

/**
 * Created by Eugene on 17.10.2016
 */

public class MoreResultsButton extends FrameLayout implements RequestParserHelper.TaskCompleteListener {

    private boolean animationStarted = false;
    private boolean inProgress;
    private RotatingImageView progressView;
    private TextView nextPageTextView;
    private TextView progressTextView;
    private int counter;

    public MoreResultsButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.more_results_button, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        progressView = (RotatingImageView) findViewById(R.id.moreResultsProgressView);
        nextPageTextView = (TextView) findViewById(R.id.nextPageTextView);
        progressTextView = (TextView) findViewById(R.id.progressTextView);
        hideProgress();
        updateButtonCaption();
    }

    public void show() {
        getHandler().removeCallbacks(actionHide);
        getHandler().removeCallbacks(actionShow);
        getHandler().postDelayed(actionShow, 250);
    }

    public void hide() {
        if (inProgress) return;
        getHandler().removeCallbacks(actionHide);
        getHandler().removeCallbacks(actionShow);
        getHandler().postDelayed(actionHide, 250);
    }

    private final Runnable actionShow = new Runnable() {
        @Override
        public void run() {
            if (getVisibility() == GONE) {
                setVisibility(View.VISIBLE);
                final ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
                final ValueAnimator animator = ValueAnimator.ofInt(-getMeasuredHeight(), 0);
                animator.setDuration(300);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        lp.setMargins(0, 0, 0, (int) animation.getAnimatedValue());
                        setLayoutParams(lp);
                    }
                });
                animator.start();
            }
        }
    };

    private final Runnable actionHide = new Runnable() {
        @Override
        public void run() {
            if (getVisibility() != GONE && !animationStarted) {
                final ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
                final ValueAnimator animator = ValueAnimator.ofInt(0, -getMeasuredHeight());
                animator.setDuration(250);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        lp.setMargins(0, 0, 0, (int) animation.getAnimatedValue());
                        setLayoutParams(lp);
                    }
                });

                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        animationStarted = true;
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animationStarted = false;
                        setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                });
                animator.start();
            }
        }
    };

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
        if (inProgress) showProgress();
        else hideProgress();
    }

    private void showProgress() {
        setClickable(false);
        setEnabled(false);
        counter = 0;
        progressTextView.setVisibility(VISIBLE);
        progressTextView.post(update);
        nextPageTextView.setVisibility(GONE);
        progressView.setVisibility(VISIBLE);
        progressView.startProgress();
    }

    private void hideProgress() {
        progressView.stopProgress();
        progressView.setVisibility(GONE);
        nextPageTextView.setVisibility(VISIBLE);
        progressTextView.setVisibility(GONE);
        setClickable(true);
        setEnabled(true);
    }

    @Override
    public void onTaskComplete() {
        counter++;
        progressTextView.post(update);
    }

    private final Runnable update = new Runnable() {
        @Override
        public void run() {
            final int percent = counter * 100 / Const.PARSERS_QTY;
            progressTextView.setText(String.format(Locale.ROOT, "%d %%", percent));
        }
    };

    public void updateButtonCaption() {
        nextPageTextView.setText(getResources().getString(CurrentState.getInstance().getCurrentPage() == 0 ? R.string.search : R.string.next_page));
    }
}