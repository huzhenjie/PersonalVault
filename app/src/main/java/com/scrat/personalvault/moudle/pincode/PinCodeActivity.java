package com.scrat.personalvault.moudle.pincode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.scrat.lib.framework.BaseActivity;
import com.scrat.personalvault.R;
import com.scrat.personalvault.databinding.ActivityPinCodeBinding;
import com.scrat.personalvault.moudle.pincode.model.PinCodeHandler;
import com.scrat.personalvault.moudle.pincode.model.PinCodeMode;
import com.scrat.personalvault.moudle.pincode.model.PinCodeViewModel;

public class PinCodeActivity extends BaseActivity {
    private static final String DATA = "data";

    public static void show(Activity activity, int requestCode, PinCodeMode mode) {
        Intent i = new Intent(activity, PinCodeActivity.class);
        i.putExtra(DATA, mode);
        activity.startActivityForResult(i, requestCode);
    }

    private ActivityPinCodeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pin_code);
        PinCodeMode mode = (PinCodeMode) getIntent().getSerializableExtra(DATA);
        PinCodeViewModel viewModel = new PinCodeViewModel(getApplicationContext())
                .setPinCodeMode(mode);
        binding.setItem(viewModel);
        PinCodeHandler handler = new PinCodeHandler(viewModel);
        binding.setHandler(handler);

    }
}
