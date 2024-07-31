package com.acse.ottn.model;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class PhoneAppList {
    String appName;
    String appPackageName;

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppPackageName(String str) {
        this.appPackageName = str;
    }

    public String toString() {
        return "PhoneAppList{appName='" + this.appName + "', appPackageName='" + this.appPackageName + "'}";
    }
}
