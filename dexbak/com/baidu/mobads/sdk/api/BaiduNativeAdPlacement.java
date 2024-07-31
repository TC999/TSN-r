package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.C2573a;
import java.lang.ref.WeakReference;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaiduNativeAdPlacement {
    private String apid;
    private String mAppsid;
    private boolean mClicked;
    private boolean mWinSended;
    C2573a mAdElementInfo = null;
    private boolean mRequestStarted = false;
    private WeakReference<BaiduNativeH5AdView> mWeakAdView = null;
    private int feedSessionId = 0;
    private int feedPositionId = 1;
    private int feedSequenceId = 1;

    public BaiduNativeH5AdView getAdView() {
        WeakReference<BaiduNativeH5AdView> weakReference = this.mWeakAdView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getApId() {
        return this.apid;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPosistionId() {
        return this.feedPositionId;
    }

    public boolean getRequestStarted() {
        return this.mRequestStarted;
    }

    public C2573a getResponse() {
        return this.mAdElementInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSequenceId() {
        return this.feedSequenceId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSessionId() {
        return this.feedSessionId;
    }

    public boolean hasValidResponse() {
        return this.mAdElementInfo != null && isAdAvailable();
    }

    protected boolean isAdAvailable() {
        return (this.mAdElementInfo != null && ((System.currentTimeMillis() - this.mAdElementInfo.m51078y()) > 1800000L ? 1 : ((System.currentTimeMillis() - this.mAdElementInfo.m51078y()) == 1800000L ? 0 : -1)) <= 0) && !this.mClicked;
    }

    public boolean isAdDataLoaded() {
        BaiduNativeH5AdView adView = getAdView();
        if (adView != null) {
            return adView.isAdDataLoaded();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isWinSended() {
        return this.mWinSended;
    }

    public void setAdResponse(C2573a c2573a) {
        this.mWinSended = false;
        this.mAdElementInfo = c2573a;
    }

    public void setAdView(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.mWeakAdView = new WeakReference<>(baiduNativeH5AdView);
    }

    public void setApId(String str) {
        this.apid = str;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void setClicked(boolean z) {
        this.mClicked = z;
    }

    public void setPositionId(int i) {
        if (i < 1) {
            return;
        }
        this.feedPositionId = i;
    }

    public void setRequestStarted(boolean z) {
        this.mRequestStarted = z;
    }

    public void setSessionId(int i) {
        if (i < 1) {
            return;
        }
        this.feedSessionId = i;
        this.feedSequenceId = BaiduNativeFeedSession.getInstance().getSequenceId(i);
    }

    public void setWinSended(boolean z) {
        this.mWinSended = z;
    }
}
