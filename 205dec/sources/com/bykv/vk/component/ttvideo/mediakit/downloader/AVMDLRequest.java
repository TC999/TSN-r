package com.bykv.vk.component.ttvideo.mediakit.downloader;

import com.bytedance.sdk.component.w.c.fp;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVMDLRequest {
    public static final int UrlStateIsForbidden = 1;
    public static final int UrlStateIsNormal = 0;
    public HashMap<String, String> headers;
    public int mCurlUrlIndex;
    public int mMaxTryCout;
    public int mOpenTimeOut;
    public int mRWTimeOut;
    public int[] mUrlErrCount;
    public int[] mUrlState;
    public long reqOff;
    public fp response;
    public long size;
    public String[] urls;

    public AVMDLRequest() {
        this.urls = null;
        this.headers = new HashMap<>();
        this.reqOff = -1L;
        this.size = 0L;
        this.response = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = 0;
        this.mOpenTimeOut = 10;
        this.mRWTimeOut = 10;
    }

    public AVMDLRequest(long j4, long j5, String[] strArr, Object obj, int i4, int i5, int i6) {
        this.urls = strArr;
        this.headers = (HashMap) obj;
        this.reqOff = j4;
        this.size = j5;
        this.response = null;
        this.mUrlState = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = i4;
        this.mOpenTimeOut = i5;
        this.mRWTimeOut = i6;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.mUrlState = new int[strArr.length];
        int i7 = 0;
        while (true) {
            int[] iArr = this.mUrlState;
            if (i7 >= iArr.length) {
                break;
            }
            iArr[i7] = 0;
            i7++;
        }
        this.mUrlErrCount = new int[this.urls.length];
        int i8 = 0;
        while (true) {
            int[] iArr2 = this.mUrlErrCount;
            if (i8 >= iArr2.length) {
                return;
            }
            iArr2[i8] = 0;
            i8++;
        }
    }

    public AVMDLRequest(long j4, long j5, String[] strArr, HashMap<String, String> hashMap) {
        this.urls = strArr;
        this.headers = hashMap;
        this.reqOff = j4;
        this.size = j5;
        this.response = null;
        this.mUrlState = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = 0;
        this.mOpenTimeOut = 10;
        this.mRWTimeOut = 10;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.mUrlState = new int[strArr.length];
        int i4 = 0;
        while (true) {
            int[] iArr = this.mUrlState;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = 0;
            i4++;
        }
    }
}
