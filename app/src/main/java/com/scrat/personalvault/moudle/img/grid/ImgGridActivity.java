package com.scrat.personalvault.moudle.img.grid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.scrat.personalvault.framework.common.BaseActivity;

public class ImgGridActivity extends BaseActivity {

    public static void show(Activity activity, int requestCode) {
        Intent i = new Intent(activity, ImgGridActivity.class);
        activity.startActivityForResult(i, requestCode);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
