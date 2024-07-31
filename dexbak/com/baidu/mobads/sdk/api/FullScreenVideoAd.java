package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.C2693dk;
import com.baidu.mobads.sdk.internal.C2701ds;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FullScreenVideoAd {
    private static final String TAG = "FullScreenVideoAd";
    private C2701ds mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface FullScreenVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener) {
        this(context, str, fullScreenVideoAdListener, false);
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50470a(true, str);
        }
    }

    public String getBiddingToken() {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            return c2701ds.m50806m();
        }
        return null;
    }

    public String getECPMLevel() {
        C2701ds c2701ds = this.mAdProd;
        return c2701ds != null ? c2701ds.m50464h() : "";
    }

    public boolean isReady() {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            return c2701ds.m50466g();
        }
        return false;
    }

    public synchronized void load() {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.mo50356a();
        }
    }

    public void loadBiddingAd(String str) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50811c(str);
        }
    }

    public void setAppSid(String str) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50809h(str);
        }
    }

    public void setBidFloor(int i) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.f8671p = i;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50814b(str);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        C2701ds c2701ds;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (c2701ds = this.mAdProd) == null) {
            return;
        }
        c2701ds.m50474a(requestParameters);
    }

    public synchronized void show() {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50467f();
        }
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, boolean z) {
        this.mContext = context;
        C2693dk c2693dk = new C2693dk(context, str, z);
        this.mAdProd = c2693dk;
        c2693dk.mo50473a(fullScreenVideoAdListener);
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50469a(false, str, hashMap);
        }
    }

    public synchronized void show(Context context) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50475a(context);
        }
    }
}
