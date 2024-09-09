package com.bytedance.pangle.sdk.component.log.impl.core.thread;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AdEventUploadResult {
    public final boolean mIsDataError;
    public final String mLogid;
    public final String mMsg;
    public final int mStatusCode;
    public final boolean mSuccess;

    public AdEventUploadResult(boolean z3, int i4, String str, boolean z4, String str2) {
        this.mSuccess = z3;
        this.mStatusCode = i4;
        this.mMsg = str;
        this.mIsDataError = z4;
        this.mLogid = str2;
    }
}
