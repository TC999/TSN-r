package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.bb;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.bv;
import com.baidu.mobads.sdk.internal.ct;
import com.baidu.mobads.sdk.internal.dj;
import com.baidu.mobads.sdk.internal.dw;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SplashAd {
    private static final int BOTTOM_VIEW_ID = 4097;
    public static final String KEY_BIDFAIL_ADN = "adn";
    public static final String KEY_BIDFAIL_ECPM = "ecpm";
    public static final String KEY_DISPLAY_DOWNLOADINFO = "displayDownloadInfo";
    public static final String KEY_FETCHAD = "fetchAd";
    public static final String KEY_LOAD_AFTER_CACHE_END = "loadAfterCacheEnd";
    public static final String KEY_POPDIALOG_DOWNLOAD = "use_dialog_frame";
    public static final String KEY_PREFER_FULLSCREEN = "prefer_fullscreen";
    public static final String KEY_SHAKE_LOGO_SIZE = "shake_logo_size";
    public static final String KEY_TIMEOUT = "timeout";
    public static final String KEY_TWIST_BG_COLOR = "twist_bg_color";
    public static final String KEY_TWIST_LOGO_HEIGHT_DP = "twist_logo_height_dp";
    public static final String KEY_USE_ADAPTIVE_AD = "adaptive_ad";
    private static final int RT_SPLASH_LOAD_AD_TIMEOUT = 4200;
    private String mAdPlaceId;
    private dw mAdProd;
    private String mAppSid;
    private int mBidFloor;
    private Context mContext;
    private Boolean mDisplayClickRegion;
    private boolean mDisplayDownInfo;
    private SplashAdDownloadDialogListener mDownloadDialogListener;
    private boolean mFetchAd;
    private boolean mFetchNotShow;
    private boolean mIsAdaptiveSplashAd;
    private Boolean mLimitRegionClick;
    private SplashAdListener mListener;
    private RequestParameters mParameter;
    private Boolean mPopDialogIfDL;
    private int mShakeLogoSize;
    private int mTimeout;
    private int mTipStyle;
    protected int mTwistBgColor;
    protected int mTwistLogoHeightDp;
    private ViewGroup mViewParent;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnFinishListener {
        void onFinishActivity();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface SplashAdDownloadDialogListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADFunctionLpClose();

        void onADFunctionLpShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyLpClose();

        void onADPrivacyLpShow();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface SplashCardAdListener {
        void onCardClick();

        void onCardClose();

        void onCardShow();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface SplashFocusAdListener {
        void onAdClick();

        void onAdClose();

        void onAdIconShow();

        void onLpClosed();
    }

    public SplashAd(Context context, String str, SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener);
    }

    private void addZeroPxSurfaceViewAvoidBlink(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Exception e4) {
            bv.a().a(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdFailed(String str) {
        if (this.mListener != null) {
            sendSplashFailedLog(str);
            this.mListener.onAdFailed(str);
        }
    }

    public static void registerEnterTransition(Activity activity, SplashFocusAdListener splashFocusAdListener) {
        dw.a(activity, (JSONObject) null, splashFocusAdListener);
    }

    private void sendSplashFailedLog(String str) {
        try {
            dw dwVar = this.mAdProd;
            if (dwVar != null) {
                dwVar.a(str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void sendSplashLog(ViewGroup viewGroup, View view) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            boolean z3 = true;
            sb.append(viewGroup == null);
            sb.append("");
            hashMap.put("adContainer", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            if (!this.mIsAdaptiveSplashAd || view != null) {
                z3 = false;
            }
            sb2.append(z3);
            sb2.append("");
            hashMap.put("isAdaptive", sb2.toString());
            hashMap.put("mFetchNotShow", this.mFetchNotShow + "");
            if (this.mAdProd != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", "sendSplashLog");
                } catch (JSONException e4) {
                    bv.a().a(e4);
                }
                this.mAdProd.a(jSONObject, hashMap);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private void setAppLogo(Object obj) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_type", "splash_logo");
                HashMap hashMap = new HashMap();
                hashMap.put("appLogo", obj);
                this.mAdProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bv.a().d(th);
            }
        }
    }

    private final void setAppLogoData(byte[] bArr) {
        setAppLogo(bArr);
    }

    private final void setAppLogoId(int i4) {
        setAppLogo(Integer.valueOf(i4));
    }

    private final void showWithBottomView(ViewGroup viewGroup, View view) {
        sendSplashLog(viewGroup, view);
        this.mViewParent = viewGroup;
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("\u4f20\u5165\u5bb9\u5668\u4e0d\u53ef\u4ee5\u4e3a\u7a7a");
                this.mListener.onAdFailed("\u4f20\u5165\u5bb9\u5668\u4e0d\u53ef\u4ee5\u4e3a\u7a7a");
            }
        } else if (this.mIsAdaptiveSplashAd && view == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("\u4f7f\u7528\u81ea\u9002\u5e94\u5f00\u5c4f\u5e7f\u544a\u80fd\u529b, \u9700\u8981\u4f7f\u7528showWithBottomView\u65b9\u6cd5\u5e76\u4f20\u5165\u5408\u9002\u5c3a\u5bf8\u7684\u5e95\u90e8logo");
                this.mListener.onAdFailed("\u4f7f\u7528\u81ea\u9002\u5e94\u5f00\u5c4f\u5e7f\u544a\u80fd\u529b, \u9700\u8981\u4f7f\u7528showWithBottomView\u65b9\u6cd5\u5e76\u4f20\u5165\u5408\u9002\u5c3a\u5bf8\u7684\u5e95\u90e8logo");
            }
        } else if (!this.mFetchNotShow) {
            dw dwVar = this.mAdProd;
            if (dwVar != null) {
                dwVar.r();
            }
            callAdFailed("\u5c55\u73b0\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0load");
        } else {
            this.mFetchNotShow = false;
            dw dwVar2 = this.mAdProd;
            if (dwVar2 != null) {
                final ct ctVar = new ct(this.mContext);
                ctVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                if (view != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    view.setId(4097);
                    ctVar.addView(view, layoutParams);
                }
                ctVar.a(new ct.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.2
                    private boolean mIsFirstOnLayout = true;

                    @Override // com.baidu.mobads.sdk.internal.ct.a
                    public void onAttachedToWindow() {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.o();
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.ct.a
                    public void onDetachedFromWindow() {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.p();
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.ct.a
                    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
                        return false;
                    }

                    @Override // com.baidu.mobads.sdk.internal.ct.a
                    public void onLayoutComplete(int i4, int i5) {
                        if (this.mIsFirstOnLayout) {
                            if (SplashAd.this.mAdProd != null) {
                                SplashAd.this.mAdProd.f12840r = false;
                                SplashAd.this.mFetchNotShow = false;
                                this.mIsFirstOnLayout = false;
                                SplashAd.this.mAdProd.a(ctVar);
                                SplashAd.this.mAdProd.f();
                                return;
                            }
                            SplashAd.this.callAdFailed("\u5c55\u73b0\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5splashAd\u53c2\u6570\u662f\u5426\u6b63\u786e");
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.ct.a
                    public void onWindowFocusChanged(boolean z3) {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.a(z3);
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.ct.a
                    public void onWindowVisibilityChanged(int i4) {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.b(i4);
                        }
                    }
                });
                this.mViewParent.addView(ctVar);
                return;
            }
            if (dwVar2 != null) {
                dwVar2.r();
            }
            callAdFailed("\u5c55\u73b0\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5splashAd\u53c2\u6570\u662f\u5426\u6b63\u786e");
        }
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        biddingSuccess(str, null);
    }

    public void destroy() {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.e();
        }
        this.mListener = null;
    }

    public void finishAndJump(Intent intent) {
        finishAndJump(intent, null);
    }

    public Object getAdDataForKey(String str) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            return dwVar.j(str);
        }
        return null;
    }

    public String getBiddingToken() {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.r();
            this.mAdProd = null;
        }
        float e4 = bb.e(this.mContext);
        Rect a4 = bb.a(this.mContext);
        int width = a4.width();
        int height = a4.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e4);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e4);
            }
        }
        int i4 = height;
        int i5 = width;
        if (i5 >= 200.0f * e4 && i4 >= e4 * 150.0f) {
            dw dwVar2 = new dw(this.mContext, this.mAdPlaceId, i5, i4, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
            this.mAdProd = dwVar2;
            dwVar2.d(this.mShakeLogoSize);
            this.mAdProd.a(this.mTwistLogoHeightDp);
            this.mAdProd.c(this.mTwistBgColor);
            this.mAdProd.h(this.mAppSid);
            dw dwVar3 = this.mAdProd;
            dwVar3.f12489p = this.mBidFloor;
            dwVar3.f12840r = true;
            RequestParameters requestParameters2 = this.mParameter;
            if (requestParameters2 != null) {
                dwVar3.a(requestParameters2);
            }
            this.mAdProd.a(this.mListener);
            this.mFetchNotShow = true;
            this.mAdProd.a(this.mDownloadDialogListener);
            return this.mAdProd.m();
        }
        bv.a().c(dj.a().a(br.SHOW_STANDARD_UNFIT, "\u5f00\u5c4f\u663e\u793a\u533a\u57df\u592a\u5c0f,\u5bbd\u5ea6\u81f3\u5c11200dp,\u9ad8\u5ea6\u81f3\u5c11150dp"));
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdDismissed();
        }
        return null;
    }

    public String getECPMLevel() {
        a h4;
        dw dwVar = this.mAdProd;
        return (dwVar == null || (h4 = dwVar.h()) == null) ? "" : h4.z();
    }

    public final boolean hasSplashCardView() {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            return dwVar.g();
        }
        return false;
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        dw dwVar = this.mAdProd;
        if (dwVar == null || (iAdInterListener = dwVar.f12484k) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public final void load() {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.r();
            this.mAdProd = null;
        }
        float e4 = bb.e(this.mContext);
        Rect a4 = bb.a(this.mContext);
        int width = a4.width();
        int height = a4.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e4);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e4);
            }
        }
        int i4 = height;
        int i5 = width;
        if (i5 >= 200.0f * e4 && i4 >= e4 * 150.0f) {
            dw dwVar2 = new dw(this.mContext, this.mAdPlaceId, i5, i4, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
            this.mAdProd = dwVar2;
            dwVar2.d(this.mShakeLogoSize);
            this.mAdProd.a(this.mTwistLogoHeightDp);
            this.mAdProd.c(this.mTwistBgColor);
            this.mAdProd.h(this.mAppSid);
            dw dwVar3 = this.mAdProd;
            dwVar3.f12489p = this.mBidFloor;
            dwVar3.f12840r = true;
            RequestParameters requestParameters2 = this.mParameter;
            if (requestParameters2 != null) {
                dwVar3.a(requestParameters2);
            }
            this.mAdProd.a(this.mListener);
            this.mFetchNotShow = true;
            this.mAdProd.a(this.mDownloadDialogListener);
            this.mAdProd.a();
            return;
        }
        bv.a().c(dj.a().a(br.SHOW_STANDARD_UNFIT, "\u5f00\u5c4f\u663e\u793a\u533a\u57df\u592a\u5c0f,\u5bbd\u5ea6\u81f3\u5c11200dp,\u9ad8\u5ea6\u81f3\u5c11150dp"));
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    public void loadAndShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("\u4f20\u5165\u5bb9\u5668\u4e0d\u53ef\u4ee5\u4e3a\u7a7a");
                this.mListener.onAdFailed("\u4f20\u5165\u5bb9\u5668\u4e0d\u53ef\u4ee5\u4e3a\u7a7a");
            }
        } else if (this.mIsAdaptiveSplashAd) {
            if (this.mListener != null) {
                sendSplashFailedLog("\u4f7f\u7528\u81ea\u9002\u5e94\u5f00\u5c4f\u5e7f\u544a\u80fd\u529b, \u9700\u8981\u4f7f\u7528showWithBottomView\u65b9\u6cd5\u5e76\u4f20\u5165\u5408\u9002\u5c3a\u5bf8\u7684\u5e95\u90e8logo");
                this.mListener.onAdFailed("\u4f7f\u7528\u81ea\u9002\u5e94\u5f00\u5c4f\u5e7f\u544a\u80fd\u529b, \u9700\u8981\u4f7f\u7528showWithBottomView\u65b9\u6cd5\u5e76\u4f20\u5165\u5408\u9002\u5c3a\u5bf8\u7684\u5e95\u90e8logo");
            }
        } else {
            addZeroPxSurfaceViewAvoidBlink(viewGroup, this.mContext);
            final ct ctVar = new ct(this.mContext);
            ctVar.a(new ct.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.3
                @Override // com.baidu.mobads.sdk.internal.ct.a
                public void onAttachedToWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.o();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.ct.a
                public void onDetachedFromWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.p();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.ct.a
                public boolean onKeyDown(int i4, KeyEvent keyEvent) {
                    return false;
                }

                @Override // com.baidu.mobads.sdk.internal.ct.a
                public void onLayoutComplete(int i4, int i5) {
                    if (SplashAd.this.mAdProd != null) {
                        return;
                    }
                    float e4 = bb.e(SplashAd.this.mContext);
                    if (SplashAd.this.mParameter != null && SplashAd.this.mParameter.isCustomSize()) {
                        if (SplashAd.this.mParameter.getWidth() > 0) {
                            i4 = (int) (SplashAd.this.mParameter.getWidth() * e4);
                        }
                        if (SplashAd.this.mParameter.getHeight() > 0) {
                            i5 = (int) (SplashAd.this.mParameter.getHeight() * e4);
                        }
                    }
                    int i6 = i4;
                    int i7 = i5;
                    if (i6 >= 200.0f * e4 && i7 >= e4 * 150.0f) {
                        SplashAd.this.mAdProd = new dw(SplashAd.this.mContext, SplashAd.this.mAdPlaceId, i6, i7, SplashAd.this.mTipStyle, SplashAd.this.mTimeout, SplashAd.this.mDisplayDownInfo, SplashAd.this.mPopDialogIfDL.booleanValue(), SplashAd.this.mDisplayClickRegion.booleanValue(), SplashAd.this.mLimitRegionClick.booleanValue());
                        SplashAd.this.mAdProd.a(ctVar);
                        SplashAd.this.mAdProd.d(SplashAd.this.mShakeLogoSize);
                        SplashAd.this.mAdProd.a(SplashAd.this.mTwistLogoHeightDp);
                        SplashAd.this.mAdProd.c(SplashAd.this.mTwistBgColor);
                        SplashAd.this.mAdProd.h(SplashAd.this.mAppSid);
                        SplashAd.this.mAdProd.f12489p = SplashAd.this.mBidFloor;
                        SplashAd.this.mAdProd.a(SplashAd.this.mListener);
                        if (SplashAd.this.mParameter != null) {
                            SplashAd.this.mAdProd.a(SplashAd.this.mParameter);
                        }
                        SplashAd.this.mAdProd.f12840r = false;
                        SplashAd.this.mAdProd.a(SplashAd.this.mDownloadDialogListener);
                        SplashAd.this.mAdProd.a();
                        return;
                    }
                    bv.a().c(dj.a().a(br.SHOW_STANDARD_UNFIT, "\u5f00\u5c4f\u663e\u793a\u533a\u57df\u592a\u5c0f,\u5bbd\u5ea6\u81f3\u5c11200dp,\u9ad8\u5ea6\u81f3\u5c11150dp"));
                    if (SplashAd.this.mListener == null || !(SplashAd.this.mListener instanceof SplashInteractionListener)) {
                        return;
                    }
                    ((SplashInteractionListener) SplashAd.this.mListener).onAdDismissed();
                }

                @Override // com.baidu.mobads.sdk.internal.ct.a
                public void onWindowFocusChanged(boolean z3) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.a(z3);
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.ct.a
                public void onWindowVisibilityChanged(int i4) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.b(i4);
                    }
                }
            });
            ctVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(ctVar);
        }
    }

    public void loadBiddingAd(String str) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.c(str);
        }
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i4) {
        this.mBidFloor = i4;
    }

    @Deprecated
    public void setBiddingData(String str) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.b(str);
        }
    }

    public void setDownloadDialogListener(SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.mDownloadDialogListener = splashAdDownloadDialogListener;
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(splashAdDownloadDialogListener);
        }
    }

    public void setListener(SplashAdListener splashAdListener) {
        this.mListener = splashAdListener;
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(splashAdListener);
        }
    }

    public final void show(ViewGroup viewGroup) {
        showWithBottomView(viewGroup, null);
    }

    public final boolean showSplashCardView(Activity activity, SplashCardAdListener splashCardAdListener) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(splashCardAdListener);
            return this.mAdProd.b(activity);
        }
        return false;
    }

    public SplashAd(Context context, String str, RequestParameters requestParameters, SplashAdListener splashAdListener) {
        this.mTipStyle = 4;
        this.mFetchAd = true;
        this.mFetchNotShow = false;
        this.mDisplayDownInfo = true;
        this.mPopDialogIfDL = Boolean.FALSE;
        Boolean bool = Boolean.TRUE;
        this.mLimitRegionClick = bool;
        this.mDisplayClickRegion = bool;
        this.mTimeout = 4200;
        this.mShakeLogoSize = 60;
        this.mTwistLogoHeightDp = 67;
        this.mTwistBgColor = -16777216;
        this.mIsAdaptiveSplashAd = false;
        this.mBidFloor = -1;
        this.mListener = new SplashInteractionListener() { // from class: com.baidu.mobads.sdk.api.SplashAd.1
            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdExposed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdSkip() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
            }
        };
        this.mContext = context;
        this.mAdPlaceId = str;
        if (splashAdListener != null) {
            this.mListener = splashAdListener;
        }
        if (TextUtils.isEmpty(str)) {
            sendSplashFailedLog("\u8bf7\u60a8\u8f93\u5165\u6b63\u786e\u7684\u5e7f\u544a\u4f4dID");
            this.mListener.onAdFailed("\u8bf7\u60a8\u8f93\u5165\u6b63\u786e\u7684\u5e7f\u544a\u4f4dID");
            return;
        }
        this.mParameter = requestParameters;
        if (requestParameters == null || requestParameters.getExtras() == null) {
            return;
        }
        String str2 = this.mParameter.getExtras().get("fetchAd");
        if (!TextUtils.isEmpty(str2)) {
            this.mFetchAd = Boolean.parseBoolean(str2);
        }
        String str3 = this.mParameter.getExtras().get("displayDownloadInfo");
        if (!TextUtils.isEmpty(str3)) {
            this.mDisplayDownInfo = Boolean.parseBoolean(str3);
        }
        String str4 = this.mParameter.getExtras().get("use_dialog_frame");
        if (!TextUtils.isEmpty(str4)) {
            this.mPopDialogIfDL = Boolean.valueOf(str4);
        }
        String str5 = this.mParameter.getExtras().get("shake_logo_size");
        if (!TextUtils.isEmpty(str5)) {
            this.mShakeLogoSize = Integer.parseInt(str5);
        }
        String str6 = this.mParameter.getExtras().get("twist_logo_height_dp");
        if (!TextUtils.isEmpty(str6)) {
            this.mTwistLogoHeightDp = Integer.parseInt(str6);
        }
        String str7 = this.mParameter.getExtras().get("twist_bg_color");
        if (!TextUtils.isEmpty(str7)) {
            this.mTwistBgColor = Integer.parseInt(str7);
        }
        String str8 = this.mParameter.getExtras().get("timeout");
        if (!TextUtils.isEmpty(str8)) {
            this.mTimeout = Integer.parseInt(str8);
        }
        String str9 = this.mParameter.getExtras().get("adaptive_ad");
        if (TextUtils.isEmpty(str9)) {
            return;
        }
        this.mIsAdaptiveSplashAd = Boolean.parseBoolean(str9);
    }

    public static void registerEnterTransition(Activity activity, SplashFocusParams splashFocusParams, SplashFocusAdListener splashFocusAdListener) {
        dw.a(activity, splashFocusParams != null ? splashFocusParams.getFocusParams() : null, splashFocusAdListener);
    }

    public void biddingFail(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(false, str, linkedHashMap);
        }
    }

    public void biddingSuccess(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(true, str, linkedHashMap);
        }
    }

    public void finishAndJump(Intent intent, OnFinishListener onFinishListener) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(intent, onFinishListener);
        }
    }

    public static void registerEnterTransition(Activity activity, int i4, int i5, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i4);
            jSONObject.put("bottom_margin", i5);
        } catch (JSONException e4) {
            bv.a().a(e4);
        }
        dw.a(activity, jSONObject, splashFocusAdListener);
    }

    @Deprecated
    public static void registerEnterTransition(Activity activity, int i4, int i5, int i6, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i4);
            jSONObject.put("bottom_margin", i5);
            jSONObject.put("anim_offset_y", i6);
        } catch (JSONException e4) {
            bv.a().a(e4);
        }
        dw.a(activity, jSONObject, splashFocusAdListener);
    }
}
