package com.baidu.vis.unified.license;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BDLicenseAuthInfo {
    public int algorithmId;
    public String deviceId;
    public long expireTime;
    public String functionList;
    public String licenseKey;
    public String md5;
    public String packageName;

    public BDLicenseAuthInfo(String str, int i, String str2, String str3, String str4, long j, String str5) {
        this.licenseKey = str;
        this.algorithmId = i;
        this.packageName = str2;
        this.md5 = str3;
        this.deviceId = str4;
        this.expireTime = j;
        this.functionList = str5;
    }

    public String toString() {
        return "licenseKey:" + this.licenseKey + ",algorithmId:" + this.algorithmId + ";packageName:" + this.packageName + ",md5:" + this.md5 + ";deviceId:" + this.deviceId + ",expireTime:" + this.expireTime + ";functionList:" + this.functionList;
    }
}
