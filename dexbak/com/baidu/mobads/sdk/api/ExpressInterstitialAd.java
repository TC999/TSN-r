package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.mobads.sdk.internal.C2573a;
import com.baidu.mobads.sdk.internal.C2607aw;
import com.baidu.mobads.sdk.internal.C2671cq;
import com.baidu.mobads.sdk.internal.C2690dh;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ExpressInterstitialAd {
    private InterstitialAdDislikeListener mAdDislikeListener;
    private String mAdPlaceId;
    private String mAppsid;
    private int mBidFloor;
    private Context mContext;
    private ExpressInterstitialListener mExpressInterstitialListener;
    private int mHeight;
    private InterAdDownloadWindowListener mInterAdDownloadWindowListener;
    private C2690dh mNativeInterstitialAdProd;
    private RequestParameters mRequestParameters;
    private boolean mUseDialogContainer;
    private boolean mUseDialogFrame;
    private int mWidth;
    private boolean onlyFetchAd;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();

        void onADPrivacyClose();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterstitialAdDislikeListener {
        void interstitialAdDislikeClick();
    }

    public ExpressInterstitialAd(Context context, String str) {
        this(context, str, 500, 600);
    }

    private void initNativeInterstitialAdProd() {
        C2671cq c2671cq = new C2671cq(this.mContext);
        c2671cq.m50591a(new C2671cq.InterfaceC2672a() { // from class: com.baidu.mobads.sdk.api.ExpressInterstitialAd.1
            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                if (ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                    ExpressInterstitialAd.this.mNativeInterstitialAdProd.m50803p();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                return i == 4;
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onLayoutComplete(int i, int i2) {
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onWindowFocusChanged(boolean z) {
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onWindowVisibilityChanged(int i) {
            }
        });
        this.mNativeInterstitialAdProd = new C2690dh(this.mContext, c2671cq, this.mAdPlaceId);
        if (!TextUtils.isEmpty(this.mAppsid)) {
            this.mNativeInterstitialAdProd.f8670o = this.mAppsid;
        }
        C2690dh c2690dh = this.mNativeInterstitialAdProd;
        c2690dh.f8671p = this.mBidFloor;
        c2690dh.f8959q = this.onlyFetchAd;
        c2690dh.m50546a(this.mExpressInterstitialListener);
        this.mNativeInterstitialAdProd.m50548a(this.mInterAdDownloadWindowListener);
        this.mNativeInterstitialAdProd.m50547a(this.mAdDislikeListener);
        this.mNativeInterstitialAdProd.m50541c(this.mUseDialogFrame);
        this.mNativeInterstitialAdProd.m50540d(this.mUseDialogContainer);
        RequestParameters requestParameters = this.mRequestParameters;
        if (requestParameters != null) {
            this.mNativeInterstitialAdProd.m50545a(requestParameters);
        }
    }

    private void reallyLoad() {
        initNativeInterstitialAdProd();
        this.mNativeInterstitialAdProd.mo50356a();
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        C2690dh c2690dh = this.mNativeInterstitialAdProd;
        if (c2690dh != null) {
            c2690dh.m50543a(true, str);
        }
    }

    public void destroy() {
        C2690dh c2690dh = this.mNativeInterstitialAdProd;
        if (c2690dh == null) {
            return;
        }
        c2690dh.m50810e();
    }

    public Object getAdDataForKey(String str) {
        C2690dh c2690dh = this.mNativeInterstitialAdProd;
        if (c2690dh != null) {
            return c2690dh.m50544a(str);
        }
        return null;
    }

    public String getBiddingToken() {
        this.onlyFetchAd = true;
        initNativeInterstitialAdProd();
        return this.mNativeInterstitialAdProd.m50806m();
    }

    public String getECPMLevel() {
        C2573a m50536x;
        C2690dh c2690dh = this.mNativeInterstitialAdProd;
        return (c2690dh == null || (m50536x = c2690dh.m50536x()) == null) ? "" : m50536x.m51077z();
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        C2690dh c2690dh = this.mNativeInterstitialAdProd;
        if (c2690dh == null || (iAdInterListener = c2690dh.f8666k) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public void load() {
        if (this.mContext == null) {
            C2607aw.m50919c().mo50861e("ExpressInterstitialAd", "请传一个非空的context再进行load");
            return;
        }
        this.onlyFetchAd = true;
        reallyLoad();
    }

    public void loadBiddingAd(String str) {
        C2690dh c2690dh = this.mNativeInterstitialAdProd;
        if (c2690dh != null) {
            c2690dh.m50811c(str);
        }
    }

    public void setAdDislikeListener(InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.mAdDislikeListener = interstitialAdDislikeListener;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    @Deprecated
    public void setBiddingData(String str) {
        C2690dh c2690dh = this.mNativeInterstitialAdProd;
        if (c2690dh != null) {
            c2690dh.m50814b(str);
        }
    }

    public void setDialogFrame(boolean z) {
        this.mUseDialogFrame = z;
    }

    public void setDownloadListener(InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.mInterAdDownloadWindowListener = interAdDownloadWindowListener;
    }

    public void setLoadListener(ExpressInterstitialListener expressInterstitialListener) {
        this.mExpressInterstitialListener = expressInterstitialListener;
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.mRequestParameters = requestParameters;
    }

    public void show() {
        C2690dh c2690dh = this.mNativeInterstitialAdProd;
        if (c2690dh == null) {
            return;
        }
        if (c2690dh.m50538g()) {
            this.mNativeInterstitialAdProd.m50537h();
        } else {
            this.mNativeInterstitialAdProd.mo50509f((IOAdEvent) null);
        }
    }

    public void useUseDialogContainer(boolean z) {
        this.mUseDialogContainer = z;
    }

    public ExpressInterstitialAd(Context context, String str, int i, int i2) {
        this.mUseDialogFrame = false;
        this.mBidFloor = -1;
        this.mUseDialogContainer = false;
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        C2690dh c2690dh = this.mNativeInterstitialAdProd;
        if (c2690dh != null) {
            c2690dh.m50542a(false, str, hashMap);
        }
    }

    public void show(Activity activity) {
        C2690dh c2690dh = this.mNativeInterstitialAdProd;
        if (c2690dh == null) {
            return;
        }
        c2690dh.m50827a(activity);
        show();
    }
}
