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
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.internal.C2573a;
import com.baidu.mobads.sdk.internal.C2610ay;
import com.baidu.mobads.sdk.internal.C2634bs;
import com.baidu.mobads.sdk.internal.C2671cq;
import com.baidu.mobads.sdk.internal.C2689dg;
import com.baidu.mobads.sdk.internal.C2702dt;
import com.baidu.mobads.sdk.internal.EnumC2629bo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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
    private C2702dt mAdProd;
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

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnFinishListener {
        void onFinishActivity();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface SplashCardAdListener {
        void onCardClick();

        void onCardClose();

        void onCardShow();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
        } catch (Exception e) {
            C2634bs.m50744a().m50738a(e);
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
        C2702dt.m50458a(activity, (JSONObject) null, splashFocusAdListener);
    }

    private void sendSplashFailedLog(String str) {
        try {
            C2702dt c2702dt = this.mAdProd;
            if (c2702dt != null) {
                c2702dt.m50448a(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendSplashLog(ViewGroup viewGroup, View view) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            sb.append(viewGroup == null);
            sb.append("");
            hashMap.put("adContainer", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            if (!this.mIsAdaptiveSplashAd || view != null) {
                z = false;
            }
            sb2.append(z);
            sb2.append("");
            hashMap.put("isAdaptive", sb2.toString());
            hashMap.put("mFetchNotShow", this.mFetchNotShow + "");
            if (this.mAdProd != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", "sendSplashLog");
                } catch (JSONException e) {
                    C2634bs.m50744a().m50738a(e);
                }
                this.mAdProd.m50818a(jSONObject, hashMap);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setAppLogo(Object obj) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_type", "splash_logo");
                HashMap hashMap = new HashMap();
                hashMap.put("appLogo", obj);
                this.mAdProd.m50818a(jSONObject, hashMap);
            } catch (Throwable th) {
                C2634bs.m50744a().m50725d(th);
            }
        }
    }

    private final void setAppLogoData(byte[] bArr) {
        setAppLogo(bArr);
    }

    private final void setAppLogoId(int i) {
        setAppLogo(Integer.valueOf(i));
    }

    private final void showWithBottomView(ViewGroup viewGroup, View view) {
        sendSplashLog(viewGroup, view);
        this.mViewParent = viewGroup;
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
            }
        } else if (this.mIsAdaptiveSplashAd && view == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
            }
        } else {
            C2702dt c2702dt = this.mAdProd;
            if (c2702dt != null) {
                final C2671cq c2671cq = new C2671cq(this.mContext);
                c2671cq.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                if (view != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    view.setId(4097);
                    c2671cq.addView(view, layoutParams);
                }
                c2671cq.m50591a(new C2671cq.InterfaceC2672a() { // from class: com.baidu.mobads.sdk.api.SplashAd.2
                    @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                    public void onAttachedToWindow() {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.m50804o();
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                    public void onDetachedFromWindow() {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.m50803p();
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                    public boolean onKeyDown(int i, KeyEvent keyEvent) {
                        return false;
                    }

                    @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                    public void onLayoutComplete(int i, int i2) {
                        if (!SplashAd.this.mFetchNotShow) {
                            if (SplashAd.this.mAdProd != null) {
                                SplashAd.this.mAdProd.m50802r();
                            }
                            SplashAd.this.callAdFailed("展现失败，请重新load");
                        } else if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.f9054r = false;
                            SplashAd.this.mFetchNotShow = false;
                            SplashAd.this.mAdProd.m50456a(c2671cq);
                            SplashAd.this.mAdProd.m50432f();
                        } else {
                            SplashAd.this.callAdFailed("展现失败，请检查splashAd参数是否正确");
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                    public void onWindowFocusChanged(boolean z) {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.m50817a(z);
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                    public void onWindowVisibilityChanged(int i) {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.m50816b(i);
                        }
                    }
                });
                this.mViewParent.addView(c2671cq);
                return;
            }
            if (c2702dt != null) {
                c2702dt.m50802r();
            }
            callAdFailed("展现失败，请检查splashAd参数是否正确");
        }
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            c2702dt.m50446a(true, str);
        }
    }

    public void destroy() {
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            c2702dt.m50810e();
        }
        this.mListener = null;
    }

    public void finishAndJump(Intent intent) {
        finishAndJump(intent, null);
    }

    public Object getAdDataForKey(String str) {
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            return c2702dt.m50426j(str);
        }
        return null;
    }

    public String getBiddingToken() {
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            c2702dt.m50802r();
            this.mAdProd = null;
        }
        float m50847e = C2610ay.m50847e(this.mContext);
        Rect m50855a = C2610ay.m50855a(this.mContext);
        int width = m50855a.width();
        int height = m50855a.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * m50847e);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * m50847e);
            }
        }
        int i = height;
        int i2 = width;
        if (i2 >= 200.0f * m50847e && i >= m50847e * 150.0f) {
            C2702dt c2702dt2 = new C2702dt(this.mContext, this.mAdPlaceId, i2, i, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
            this.mAdProd = c2702dt2;
            c2702dt2.m50435d(this.mShakeLogoSize);
            this.mAdProd.m50460a(this.mTwistLogoHeightDp);
            this.mAdProd.m50439c(this.mTwistBgColor);
            this.mAdProd.m50809h(this.mAppSid);
            C2702dt c2702dt3 = this.mAdProd;
            c2702dt3.f8671p = this.mBidFloor;
            c2702dt3.f9054r = true;
            RequestParameters requestParameters2 = this.mParameter;
            if (requestParameters2 != null) {
                c2702dt3.m50454a(requestParameters2);
            }
            this.mAdProd.m50450a(this.mListener);
            this.mFetchNotShow = true;
            this.mAdProd.m50453a(this.mDownloadDialogListener);
            return this.mAdProd.m50806m();
        }
        C2634bs.m50744a().m50731c(C2689dg.m50553a().m50552a(EnumC2629bo.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdDismissed();
        }
        return null;
    }

    public String getECPMLevel() {
        C2573a m50428h;
        C2702dt c2702dt = this.mAdProd;
        return (c2702dt == null || (m50428h = c2702dt.m50428h()) == null) ? "" : m50428h.m51077z();
    }

    public final boolean hasSplashCardView() {
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            return c2702dt.m50430g();
        }
        return false;
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt == null || (iAdInterListener = c2702dt.f8666k) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public final void load() {
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            c2702dt.m50802r();
            this.mAdProd = null;
        }
        float m50847e = C2610ay.m50847e(this.mContext);
        Rect m50855a = C2610ay.m50855a(this.mContext);
        int width = m50855a.width();
        int height = m50855a.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * m50847e);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * m50847e);
            }
        }
        int i = height;
        int i2 = width;
        if (i2 >= 200.0f * m50847e && i >= m50847e * 150.0f) {
            C2702dt c2702dt2 = new C2702dt(this.mContext, this.mAdPlaceId, i2, i, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
            this.mAdProd = c2702dt2;
            c2702dt2.m50435d(this.mShakeLogoSize);
            this.mAdProd.m50460a(this.mTwistLogoHeightDp);
            this.mAdProd.m50439c(this.mTwistBgColor);
            this.mAdProd.m50809h(this.mAppSid);
            C2702dt c2702dt3 = this.mAdProd;
            c2702dt3.f8671p = this.mBidFloor;
            c2702dt3.f9054r = true;
            RequestParameters requestParameters2 = this.mParameter;
            if (requestParameters2 != null) {
                c2702dt3.m50454a(requestParameters2);
            }
            this.mAdProd.m50450a(this.mListener);
            this.mFetchNotShow = true;
            this.mAdProd.m50453a(this.mDownloadDialogListener);
            this.mAdProd.mo50356a();
            return;
        }
        C2634bs.m50744a().m50731c(C2689dg.m50553a().m50552a(EnumC2629bo.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    public void loadAndShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
            }
        } else if (this.mIsAdaptiveSplashAd) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
            }
        } else {
            addZeroPxSurfaceViewAvoidBlink(viewGroup, this.mContext);
            final C2671cq c2671cq = new C2671cq(this.mContext);
            c2671cq.m50591a(new C2671cq.InterfaceC2672a() { // from class: com.baidu.mobads.sdk.api.SplashAd.3
                @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                public void onAttachedToWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.m50804o();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                public void onDetachedFromWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.m50803p();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                public boolean onKeyDown(int i, KeyEvent keyEvent) {
                    return false;
                }

                @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                public void onLayoutComplete(int i, int i2) {
                    if (SplashAd.this.mAdProd != null) {
                        return;
                    }
                    float m50847e = C2610ay.m50847e(SplashAd.this.mContext);
                    if (SplashAd.this.mParameter != null && SplashAd.this.mParameter.isCustomSize()) {
                        if (SplashAd.this.mParameter.getWidth() > 0) {
                            i = (int) (SplashAd.this.mParameter.getWidth() * m50847e);
                        }
                        if (SplashAd.this.mParameter.getHeight() > 0) {
                            i2 = (int) (SplashAd.this.mParameter.getHeight() * m50847e);
                        }
                    }
                    int i3 = i;
                    int i4 = i2;
                    if (i3 >= 200.0f * m50847e && i4 >= m50847e * 150.0f) {
                        SplashAd.this.mAdProd = new C2702dt(SplashAd.this.mContext, SplashAd.this.mAdPlaceId, i3, i4, SplashAd.this.mTipStyle, SplashAd.this.mTimeout, SplashAd.this.mDisplayDownInfo, SplashAd.this.mPopDialogIfDL.booleanValue(), SplashAd.this.mDisplayClickRegion.booleanValue(), SplashAd.this.mLimitRegionClick.booleanValue());
                        SplashAd.this.mAdProd.m50456a(c2671cq);
                        SplashAd.this.mAdProd.m50435d(SplashAd.this.mShakeLogoSize);
                        SplashAd.this.mAdProd.m50460a(SplashAd.this.mTwistLogoHeightDp);
                        SplashAd.this.mAdProd.m50439c(SplashAd.this.mTwistBgColor);
                        SplashAd.this.mAdProd.m50809h(SplashAd.this.mAppSid);
                        SplashAd.this.mAdProd.f8671p = SplashAd.this.mBidFloor;
                        SplashAd.this.mAdProd.m50450a(SplashAd.this.mListener);
                        if (SplashAd.this.mParameter != null) {
                            SplashAd.this.mAdProd.m50454a(SplashAd.this.mParameter);
                        }
                        SplashAd.this.mAdProd.f9054r = false;
                        SplashAd.this.mAdProd.m50453a(SplashAd.this.mDownloadDialogListener);
                        SplashAd.this.mAdProd.mo50356a();
                        return;
                    }
                    C2634bs.m50744a().m50731c(C2689dg.m50553a().m50552a(EnumC2629bo.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                    if (SplashAd.this.mListener == null || !(SplashAd.this.mListener instanceof SplashInteractionListener)) {
                        return;
                    }
                    ((SplashInteractionListener) SplashAd.this.mListener).onAdDismissed();
                }

                @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                public void onWindowFocusChanged(boolean z) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.m50817a(z);
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
                public void onWindowVisibilityChanged(int i) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.m50816b(i);
                    }
                }
            });
            c2671cq.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(c2671cq);
        }
    }

    public void loadBiddingAd(String str) {
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            c2702dt.m50811c(str);
        }
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    @Deprecated
    public void setBiddingData(String str) {
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            c2702dt.m50814b(str);
        }
    }

    public void setDownloadDialogListener(SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.mDownloadDialogListener = splashAdDownloadDialogListener;
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            c2702dt.m50453a(splashAdDownloadDialogListener);
        }
    }

    public void setListener(SplashAdListener splashAdListener) {
        this.mListener = splashAdListener;
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            c2702dt.m50450a(splashAdListener);
        }
    }

    public final void show(ViewGroup viewGroup) {
        showWithBottomView(viewGroup, null);
    }

    public final boolean showSplashCardView(Activity activity, SplashCardAdListener splashCardAdListener) {
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            c2702dt.m50452a(splashCardAdListener);
            return this.mAdProd.m50444b(activity);
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
        this.mTwistBgColor = ViewCompat.MEASURED_STATE_MASK;
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

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
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
            sendSplashFailedLog("请您输入正确的广告位ID");
            this.mListener.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        this.mParameter = requestParameters;
        if (requestParameters == null || requestParameters.getExtras() == null) {
            return;
        }
        String str2 = this.mParameter.getExtras().get(KEY_FETCHAD);
        if (!TextUtils.isEmpty(str2)) {
            this.mFetchAd = Boolean.parseBoolean(str2);
        }
        String str3 = this.mParameter.getExtras().get(KEY_DISPLAY_DOWNLOADINFO);
        if (!TextUtils.isEmpty(str3)) {
            this.mDisplayDownInfo = Boolean.parseBoolean(str3);
        }
        String str4 = this.mParameter.getExtras().get(KEY_POPDIALOG_DOWNLOAD);
        if (!TextUtils.isEmpty(str4)) {
            this.mPopDialogIfDL = Boolean.valueOf(str4);
        }
        String str5 = this.mParameter.getExtras().get(KEY_SHAKE_LOGO_SIZE);
        if (!TextUtils.isEmpty(str5)) {
            this.mShakeLogoSize = Integer.parseInt(str5);
        }
        String str6 = this.mParameter.getExtras().get(KEY_TWIST_LOGO_HEIGHT_DP);
        if (!TextUtils.isEmpty(str6)) {
            this.mTwistLogoHeightDp = Integer.parseInt(str6);
        }
        String str7 = this.mParameter.getExtras().get(KEY_TWIST_BG_COLOR);
        if (!TextUtils.isEmpty(str7)) {
            this.mTwistBgColor = Integer.parseInt(str7);
        }
        String str8 = this.mParameter.getExtras().get("timeout");
        if (!TextUtils.isEmpty(str8)) {
            this.mTimeout = Integer.parseInt(str8);
        }
        String str9 = this.mParameter.getExtras().get(KEY_USE_ADAPTIVE_AD);
        if (TextUtils.isEmpty(str9)) {
            return;
        }
        this.mIsAdaptiveSplashAd = Boolean.parseBoolean(str9);
    }

    public static void registerEnterTransition(Activity activity, SplashFocusParams splashFocusParams, SplashFocusAdListener splashFocusAdListener) {
        C2702dt.m50458a(activity, splashFocusParams != null ? splashFocusParams.getFocusParams() : null, splashFocusAdListener);
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            c2702dt.m50445a(false, str, hashMap);
        }
    }

    public void finishAndJump(Intent intent, OnFinishListener onFinishListener) {
        C2702dt c2702dt = this.mAdProd;
        if (c2702dt != null) {
            c2702dt.m50457a(intent, onFinishListener);
        }
    }

    public static void registerEnterTransition(Activity activity, int i, int i2, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i);
            jSONObject.put("bottom_margin", i2);
        } catch (JSONException e) {
            C2634bs.m50744a().m50738a(e);
        }
        C2702dt.m50458a(activity, jSONObject, splashFocusAdListener);
    }

    @Deprecated
    public static void registerEnterTransition(Activity activity, int i, int i2, int i3, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i);
            jSONObject.put("bottom_margin", i2);
            jSONObject.put("anim_offset_y", i3);
        } catch (JSONException e) {
            C2634bs.m50744a().m50738a(e);
        }
        C2702dt.m50458a(activity, jSONObject, splashFocusAdListener);
    }
}
