package com.baidu.vis.unified.license;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BDLicenseLocalInfo {
    public int algorithmId;
    public String deviceId;
    public String fingerVersion;
    public String licenseKey;
    public String licenseSdkVersion;
    public String md5;
    public String packageName;

    public BDLicenseLocalInfo(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        this.licenseKey = str;
        this.algorithmId = i;
        this.packageName = str2;
        this.md5 = str3;
        this.deviceId = str4;
        this.fingerVersion = str5;
        this.licenseSdkVersion = str6;
    }

    public String toString() {
        return "licenseKey:" + this.licenseKey + ",algorithmId:" + this.algorithmId + ";packageName:" + this.packageName + ",md5:" + this.md5 + ";deviceId:" + this.deviceId + ",fingerVersion:" + this.fingerVersion + ";licenseSdkVersion:" + this.licenseSdkVersion;
    }
}
