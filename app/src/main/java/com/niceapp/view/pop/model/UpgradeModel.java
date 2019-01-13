package com.niceapp.view.pop.model;


import java.io.Serializable;

public class UpgradeModel implements Serializable {

    private boolean isForceUpgrade;//是否强更
    private String upgradeContent;
    private String upgradeTitle;
    private String versionName;
    private int versionCode;
    private boolean isManual;

    public UpgradeModel() {
    }

    public boolean isForceUpgrade() {
        return isForceUpgrade;
    }

    public void setForceUpgrade(boolean forceUpgrade) {
        isForceUpgrade = forceUpgrade;
    }

    public String getUpgradeContent() {
        return upgradeContent;
    }

    public void setUpgradeContent(String upgradeContent) {
        this.upgradeContent = upgradeContent;
    }

    public String getUpgradeTitle() {
        return upgradeTitle;
    }

    public void setUpgradeTitle(String upgradeTitle) {
        this.upgradeTitle = upgradeTitle;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public void setIsManual(boolean isManual) {
        this.isManual = isManual;
    }

    public boolean getIsManual() {
        return isManual;
    }
}
