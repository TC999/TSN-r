package com.acse.ottn.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
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
