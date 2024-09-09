package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.dn;
import com.baidu.mobads.sdk.internal.dv;
import java.util.LinkedHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FullScreenVideoAd {
    private static final String TAG = "FullScreenVideoAd";
    private dv mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface FullScreenVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f4);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f4);

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
        biddingSuccess(str, null);
    }

    public String getBiddingToken() {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            return dvVar.m();
        }
        return null;
    }

    public String getECPMLevel() {
        dv dvVar = this.mAdProd;
        return dvVar != null ? dvVar.h() : "";
    }

    public boolean isReady() {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            return dvVar.g();
        }
        return false;
    }

    public synchronized void load() {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.a();
        }
    }

    public void loadBiddingAd(String str) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.c(str);
        }
    }

    public void setAppSid(String str) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.h(str);
        }
    }

    public void setBidFloor(int i4) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.f12489p = i4;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.b(str);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        dv dvVar;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (dvVar = this.mAdProd) == null) {
            return;
        }
        dvVar.a(requestParameters);
    }

    public synchronized void show() {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.f();
        }
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, boolean z3) {
        this.mContext = context;
        dn dnVar = new dn(context, str, z3);
        this.mAdProd = dnVar;
        dnVar.a(fullScreenVideoAdListener);
    }

    public void biddingFail(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.a(false, str, linkedHashMap);
        }
    }

    public void biddingSuccess(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.a(true, str, linkedHashMap);
        }
    }

    public synchronized void show(Context context) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.a(context);
        }
    }
}
