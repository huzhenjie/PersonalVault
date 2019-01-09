package com.scrat.personalvault.moudle.pincode.model;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.util.Log;

import com.scrat.personalvault.BR;
import com.scrat.personalvault.R;

public class PinCodeViewModel extends BaseObservable {
    private Context ctx;
    private String currPwd;
    private PinCodeMode pinCodeMode;

    public PinCodeViewModel(Context ctx) {
        this.ctx = ctx;
        this.currPwd = "";
    }

    public PinCodeViewModel setPinCodeMode(PinCodeMode pinCodeMode) {
        this.pinCodeMode = pinCodeMode;
        return this;
    }

    void append(String pwdKey) {
        currPwd += pwdKey;
        notifyChange();
        if (currPwd.length() >= 6) {
            // check your pwd logic
            currPwd = "";
        }
    }

    void deleteLastPwdKey() {
        if (TextUtils.isEmpty(currPwd)) {
            return;
        }
        currPwd = currPwd.substring(0, currPwd.length() - 1);
        notifyChange();
    }

    public String getTitle() {
        if (pinCodeMode == null) {
            return ctx.getString(R.string.enter_your_pwd);
        }
        switch (pinCodeMode) {
            case RESET_PWD:
                return ctx.getString(R.string.enter_a_new_pwd);
            case VERIFY_PWD:
            default:
                return ctx.getString(R.string.enter_your_pwd);
        }
    }

    public int getCurrPwdLength() {
        if (currPwd == null) {
            return 0;
        }
        return currPwd.length();
    }

    public boolean showBackBtn() {
        return pinCodeMode != null && pinCodeMode != PinCodeMode.VERIFY_PWD;
    }

    public boolean showMoreBtn() {
        return true;
    }

    public boolean showForgotPwdBtn() {
        return true;
    }
}
