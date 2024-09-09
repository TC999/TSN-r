package com.bykv.vk.component.ttvideo.mediakit.net;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVMDLDNSInfo {
    public String mErrorStr;
    public long mExpiredTime;
    public String mExtraInfo;
    public String mHost;
    public String[] mHosts;
    public String mId;
    public String mIpList;
    public int mType;

    public AVMDLDNSInfo(int i4, String[] strArr, String str, long j4, String str2) {
        this.mType = i4;
        this.mHosts = strArr;
        this.mIpList = str;
        this.mExpiredTime = j4;
        this.mId = str2;
    }

    public AVMDLDNSInfo(int i4, String str, String str2, long j4, String str3) {
        this.mType = i4;
        this.mHost = str;
        this.mIpList = str2;
        this.mExpiredTime = j4;
        this.mId = str3;
    }

    public AVMDLDNSInfo(int i4, String str, String str2, long j4, String str3, String str4) {
        this.mType = i4;
        this.mHost = str;
        this.mIpList = str2;
        this.mExpiredTime = j4;
        this.mId = str3;
        this.mErrorStr = str4;
    }
}
