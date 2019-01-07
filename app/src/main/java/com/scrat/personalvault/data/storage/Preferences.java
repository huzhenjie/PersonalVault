package com.scrat.personalvault.data.storage;

import android.content.Context;

import com.scrat.lib.framework.BaseSharedPreferences;

public class Preferences extends BaseSharedPreferences {
    private static final String FILE_NAME = "conf";

    private static class SingletonHolder {
        private static Preferences instance = new Preferences();
    }

    public static Preferences getInstance() {
        return SingletonHolder.instance;
    }

    public void init(Context applicationContext) {
        init(applicationContext, FILE_NAME);
    }

}
