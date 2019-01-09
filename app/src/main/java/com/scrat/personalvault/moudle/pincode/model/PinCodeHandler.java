package com.scrat.personalvault.moudle.pincode.model;

public class PinCodeHandler {
    private PinCodeViewModel viewModel;

    public PinCodeHandler(PinCodeViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void handlePinCode(String pwdKey) {
        viewModel.append(pwdKey);
    }

    public void handleDeleteLastKey() {
        viewModel.deleteLastPwdKey();
    }
}
