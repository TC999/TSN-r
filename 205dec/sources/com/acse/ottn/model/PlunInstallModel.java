package com.acse.ottn.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class PlunInstallModel {
    private String appName;
    private boolean isInstallPlun;
    private boolean isNewApk;
    private String packageName;
    private String version;

    public String getAppName() {
        return this.appName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isInstallApk() {
        return this.isInstallPlun;
    }

    public boolean isNewApk() {
        return this.isNewApk;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setInstallApk(boolean z3) {
        this.isInstallPlun = z3;
    }

    public void setNewApk(boolean z3) {
        this.isNewApk = z3;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
