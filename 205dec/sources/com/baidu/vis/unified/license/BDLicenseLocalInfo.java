package com.baidu.vis.unified.license;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BDLicenseLocalInfo {
    public int algorithmId;
    public String deviceId;
    public String fingerVersion;
    public String licenseKey;
    public String licenseSdkVersion;
    public String md5;
    public String packageName;

    public BDLicenseLocalInfo(String str, int i4, String str2, String str3, String str4, String str5, String str6) {
        this.licenseKey = str;
        this.algorithmId = i4;
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
