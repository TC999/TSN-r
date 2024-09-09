package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.ct;
import com.baidu.mobads.sdk.internal.dk;
import java.util.LinkedHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ExpressInterstitialAd {
    private InterstitialAdDislikeListener mAdDislikeListener;
    private String mAdPlaceId;
    private String mAppsid;
    private int mBidFloor;
    private Context mContext;
    private ExpressInterstitialListener mExpressInterstitialListener;
    private int mHeight;
    private InterAdDownloadWindowListener mInterAdDownloadWindowListener;
    private dk mNativeInterstitialAdProd;
    private RequestParameters mRequestParameters;
    private boolean mUseDialogContainer;
    private boolean mUseDialogFrame;
    private int mWidth;
    private boolean onlyFetchAd;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface InterAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();

        void onADPrivacyClose();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface InterstitialAdDislikeListener {
        void interstitialAdDislikeClick();
    }

    public ExpressInterstitialAd(Context context, String str) {
        this(context, str, 500, 600);
    }

    private void initNativeInterstitialAdProd() {
        ct ctVar = new ct(this.mContext);
        ctVar.a(new ct.a() { // from class: com.baidu.mobads.sdk.api.ExpressInterstitialAd.1
            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                if (ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                    ExpressInterstitialAd.this.mNativeInterstitialAdProd.p();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public boolean onKeyDown(int i4, KeyEvent keyEvent) {
                return i4 == 4;
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onLayoutComplete(int i4, int i5) {
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowFocusChanged(boolean z3) {
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowVisibilityChanged(int i4) {
            }
        });
        this.mNativeInterstitialAdProd = new dk(this.mContext, ctVar, this.mAdPlaceId);
        if (!TextUtils.isEmpty(this.mAppsid)) {
            this.mNativeInterstitialAdProd.f12488o = this.mAppsid;
        }
        dk dkVar = this.mNativeInterstitialAdProd;
        dkVar.f12489p = this.mBidFloor;
        dkVar.f12767q = this.onlyFetchAd;
        dkVar.a(this.mExpressInterstitialListener);
        this.mNativeInterstitialAdProd.a(this.mInterAdDownloadWindowListener);
        this.mNativeInterstitialAdProd.a(this.mAdDislikeListener);
        this.mNativeInterstitialAdProd.c(this.mUseDialogFrame);
        this.mNativeInterstitialAdProd.d(this.mUseDialogContainer);
        RequestParameters requestParameters = this.mRequestParameters;
        if (requestParameters != null) {
            this.mNativeInterstitialAdProd.a(requestParameters);
        }
    }

    private void reallyLoad() {
        initNativeInterstitialAdProd();
        this.mNativeInterstitialAdProd.a();
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        biddingSuccess(str, null);
    }

    public void destroy() {
        dk dkVar = this.mNativeInterstitialAdProd;
        if (dkVar == null) {
            return;
        }
        dkVar.e();
    }

    public Object getAdDataForKey(String str) {
        dk dkVar = this.mNativeInterstitialAdProd;
        if (dkVar != null) {
            return dkVar.a(str);
        }
        return null;
    }

    public String getBiddingToken() {
        this.onlyFetchAd = true;
        initNativeInterstitialAdProd();
        return this.mNativeInterstitialAdProd.m();
    }

    public String getECPMLevel() {
        a x3;
        dk dkVar = this.mNativeInterstitialAdProd;
        return (dkVar == null || (x3 = dkVar.x()) == null) ? "" : x3.z();
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        dk dkVar = this.mNativeInterstitialAdProd;
        if (dkVar == null || (iAdInterListener = dkVar.f12484k) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public void load() {
        if (this.mContext == null) {
            az.c().e("ExpressInterstitialAd", "\u8bf7\u4f20\u4e00\u4e2a\u975e\u7a7a\u7684context\u518d\u8fdb\u884cload");
            return;
        }
        this.onlyFetchAd = true;
        reallyLoad();
    }

    public void loadBiddingAd(String str) {
        dk dkVar = this.mNativeInterstitialAdProd;
        if (dkVar != null) {
            dkVar.c(str);
        }
    }

    public void setAdDislikeListener(InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.mAdDislikeListener = interstitialAdDislikeListener;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void setBidFloor(int i4) {
        this.mBidFloor = i4;
    }

    @Deprecated
    public void setBiddingData(String str) {
        dk dkVar = this.mNativeInterstitialAdProd;
        if (dkVar != null) {
            dkVar.b(str);
        }
    }

    public void setDialogFrame(boolean z3) {
        this.mUseDialogFrame = z3;
    }

    public void setDownloadListener(InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.mInterAdDownloadWindowListener = interAdDownloadWindowListener;
    }

    public void setLoadListener(ExpressInterstitialListener expressInterstitialListener) {
        this.mExpressInterstitialListener = expressInterstitialListener;
        dk dkVar = this.mNativeInterstitialAdProd;
        if (dkVar != null) {
            dkVar.a(expressInterstitialListener);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.mRequestParameters = requestParameters;
    }

    public void show() {
        dk dkVar = this.mNativeInterstitialAdProd;
        if (dkVar == null) {
            return;
        }
        if (dkVar.g()) {
            this.mNativeInterstitialAdProd.h();
        } else {
            this.mNativeInterstitialAdProd.f((IOAdEvent) null);
        }
    }

    public void useUseDialogContainer(boolean z3) {
        this.mUseDialogContainer = z3;
    }

    public ExpressInterstitialAd(Context context, String str, int i4, int i5) {
        this.mUseDialogFrame = false;
        this.mBidFloor = -1;
        this.mUseDialogContainer = false;
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mWidth = i4;
        this.mHeight = i5;
    }

    public void biddingFail(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dk dkVar = this.mNativeInterstitialAdProd;
        if (dkVar != null) {
            dkVar.a(false, str, linkedHashMap);
        }
    }

    public void biddingSuccess(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dk dkVar = this.mNativeInterstitialAdProd;
        if (dkVar != null) {
            dkVar.a(true, str, linkedHashMap);
        }
    }

    public void show(Activity activity) {
        dk dkVar = this.mNativeInterstitialAdProd;
        if (dkVar == null) {
            return;
        }
        dkVar.a(activity);
        show();
    }
}
