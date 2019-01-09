package com.scrat.personalvault.data.storage;

public class PwdInfo {
    private String title;
    private String accountName;
    private String password;

    public String getTitle() {
        return title;
    }

    public PwdInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public PwdInfo setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PwdInfo setPassword(String password) {
        this.password = password;
        return this;
    }
}
