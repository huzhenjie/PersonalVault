package com.scrat.personalvault.moudle;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.scrat.lib.framework.BaseActivity;
import com.scrat.personalvault.MainActivity;
import com.scrat.personalvault.R;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViewById(R.id.app_name).postDelayed(() -> {
            MainActivity.show(SplashActivity.this);
            finish();
        }, 1000L);
    }
}
