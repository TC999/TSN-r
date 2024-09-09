package com.bytedance.pangle.sdk.component.log.impl.track;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TrackInfo {
    private String mId;
    private boolean mReplaceHolder;
    private int mRetryCount;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackInfo(String str, String str2, boolean z3, int i4) {
        this.mId = str;
        this.mUrl = str2;
        this.mReplaceHolder = z3;
        this.mRetryCount = i4;
    }

    public String getId() {
        return this.mId;
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isReplaceHolder() {
        return this.mReplaceHolder;
    }

    public void setRetryCount(int i4) {
        this.mRetryCount = i4;
    }
}
