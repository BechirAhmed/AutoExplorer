package auto.explorer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import auto.explorer.model.GlobalConfig;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
import static java.lang.System.currentTimeMillis;

public class SplashActivity extends AppCompatActivity {

    private long started;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isPhone = getResources().getBoolean(R.bool.isPhone);
        if (isPhone) setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        started = currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                GlobalConfig.init(SplashActivity.this);
            }
        }).start();
    }

    public void onGlobalConfigCreated() {
        long remain = 3500 - (currentTimeMillis() - started);
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, remain < 100 ? 100 : remain);
    }

}