package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.at;
import com.baidu.mobads.sdk.internal.bv;
import com.baidu.mobads.sdk.internal.cs;
import com.baidu.mobads.sdk.internal.dm;
import com.baidu.mobads.sdk.internal.p;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class XAdNativeResponse implements NativeResponse {
    private static final String TAG = "NativeResponse";
    private boolean isDownloadApp;
    private int mAdActionType = 1;
    private NativeResponse.AdDislikeListener mAdDislikeListener;
    private a mAdInstanceInfo;
    private NativeResponse.AdInteractionListener mAdInteractionListener;
    private NativeResponse.AdPrivacyListener mAdPrivacyListener;
    private NativeResponse.AdShakeViewListener mAdShakeViewListener;
    private NativeResponse.AdShakeViewListener mCouponFloatViewListener;
    private NativeResponse.CustomizeMediaPlayer mCustomizeMediaPlayer;
    private Context mCxt;
    private dm mFeedsProd;
    private cs mUriUtils;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static class DislikeInfo implements DislikeEvent {
        private String dislikeName;
        private int dislikeType;

        private DislikeInfo() {
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public String getDislikeName() {
            return this.dislikeName;
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public int getDislikeType() {
            return this.dislikeType;
        }
    }

    public XAdNativeResponse(Context context, dm dmVar, a aVar) {
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mAdInstanceInfo = aVar;
        this.mFeedsProd = dmVar;
        if (aVar.p() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = cs.a();
    }

    private int getActionType() {
        return this.mAdInstanceInfo.p();
    }

    private IAdInterListener getAdInterListener() {
        dm dmVar = this.mFeedsProd;
        if (dmVar != null) {
            return dmVar.f12484k;
        }
        return null;
    }

    private String getProd() {
        dm dmVar = this.mFeedsProd;
        return dmVar != null ? dmVar.f() : "";
    }

    private View renderNativeView(String str, JSONObject jSONObject) {
        try {
            jSONObject.put("viewId", str);
            jSONObject.put("msg", "renderNativeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            HashMap hashMap = new HashMap();
            this.mFeedsProd.a(jSONObject, hashMap);
            Object obj = hashMap.get(str);
            if (obj instanceof View) {
                return (View) obj;
            }
            return null;
        } catch (Throwable th) {
            bv a4 = bv.a();
            a4.c("NativeResponse", "renderNativeView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingSuccess(String str) {
        biddingSuccess(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void cancelAppDownload() {
        if (this.mCxt == null || !this.isDownloadApp || this.mFeedsProd == null) {
            return;
        }
        JSONObject T = this.mAdInstanceInfo.T();
        try {
            T.put("pk", getAppPackage());
            T.put("msg", "cancelDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void clearImpressionTaskWhenBack() {
        dm dmVar = this.mFeedsProd;
        if (dmVar != null) {
            dmVar.p();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void dislikeClick(DislikeEvent dislikeEvent) {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null || !(dislikeEvent instanceof DislikeInfo)) {
            return;
        }
        JSONObject T = aVar.T();
        try {
            T.put("dislike_type", dislikeEvent.getDislikeType());
            T.put("msg", "dislike_click");
        } catch (Exception unused) {
        }
        this.mFeedsProd.a(T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void functionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        String D = aVar.D();
        JSONObject T = this.mAdInstanceInfo.T();
        try {
            T.put("function_link", D);
            T.put("msg", "functionClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getActButtonString() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            JSONObject T = aVar.T();
            try {
                T.put("msg", "creative_call");
                T.put("creative_type", "cta_get");
            } catch (Exception unused) {
            }
            this.mFeedsProd.a(T);
            return this.mAdInstanceInfo.M();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getAdActionType() {
        return this.mAdActionType;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Object getAdDataForKey(String str) {
        if (this.mAdInstanceInfo != null) {
            if (ConstantAd.KEY_CACHE_AD.equals(str)) {
                return this.mAdInstanceInfo.U();
            }
            if ("dp_id".equals(str)) {
                return this.mAdInstanceInfo.V();
            }
            return this.mAdInstanceInfo.a(str);
        }
        return null;
    }

    public NativeResponse.AdDislikeListener getAdDislikeListener() {
        return this.mAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdLogoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.h() : "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdMaterialType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return NativeResponse.MaterialType.NORMAL.getValue();
        }
        if ("video".equals(aVar.x())) {
            return NativeResponse.MaterialType.VIDEO.getValue();
        }
        if ("html".equals(this.mAdInstanceInfo.x())) {
            return NativeResponse.MaterialType.HTML.getValue();
        }
        return NativeResponse.MaterialType.NORMAL.getValue();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppFunctionLink() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.D() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPackage() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.m() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPermissionLink() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.E() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPrivacyLink() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.C() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public long getAppSize() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.j();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppVersion() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.A() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBaiduLogoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.i() : "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBrandName() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.g() : "";
    }

    public List<String> getBtnStyleColors() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.O();
        }
        return null;
    }

    public int getBtnStyleType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.N();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerHeight() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.s();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerSizeType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.t();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerWidth() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.r();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.CustomizeMediaPlayer getCustomizeMediaPlayer() {
        a aVar;
        if (this.mCustomizeMediaPlayer == null && (aVar = this.mAdInstanceInfo) != null && aVar.S() == 1) {
            this.mCustomizeMediaPlayer = new p(this.mFeedsProd, this.mAdInstanceInfo);
        }
        return this.mCustomizeMediaPlayer;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getDesc() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.b() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<DislikeEvent> getDislikeList() {
        ArrayList arrayList = new ArrayList();
        if (this.mAdInstanceInfo != null && this.mFeedsProd != null) {
            try {
                HashMap hashMap = new HashMap();
                JSONObject T = this.mAdInstanceInfo.T();
                T.put("msg", "dislike_mapping");
                this.mFeedsProd.a(T, hashMap);
                Object obj = hashMap.get("dislike_data");
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    for (String str : map.keySet()) {
                        DislikeInfo dislikeInfo = new DislikeInfo();
                        dislikeInfo.dislikeName = str;
                        dislikeInfo.dislikeType = ((Integer) map.get(str)).intValue();
                        arrayList.add(dislikeInfo);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDownloadStatus() {
        Context context;
        if (!this.isDownloadApp || (context = this.mCxt) == null) {
            return -1;
        }
        return at.a(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(StubApp.getOrigApplicationContext(this.mCxt.getApplicationContext()), getAppPackage());
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDuration() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.w();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getECPMLevel() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.z() : "";
    }

    public JSONObject getExtraParams() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.I();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Map<String, String> getExtras() {
        HashMap hashMap = new HashMap();
        dm dmVar = this.mFeedsProd;
        if (dmVar != null) {
            hashMap.put("appsid", dmVar.f12488o);
        }
        return hashMap;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getHtmlSnippet() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.o() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getIconUrl() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            String c4 = aVar.c();
            return TextUtils.isEmpty(c4) ? this.mAdInstanceInfo.d() : c4;
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getImageUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.d() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicHeight() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicWidth() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }

    public String getMarketingDesc() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.K() : "";
    }

    public String getMarketingICONUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.J() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getMarketingPendant() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.L() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.MaterialType getMaterialType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return NativeResponse.MaterialType.NORMAL;
        }
        if ("video".equals(aVar.x())) {
            return NativeResponse.MaterialType.VIDEO;
        }
        if ("html".equals(this.mAdInstanceInfo.x())) {
            return NativeResponse.MaterialType.HTML;
        }
        return NativeResponse.MaterialType.NORMAL;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<String> getMultiPicUrls() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.G();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getPublisher() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.B() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getStyleType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.u();
        }
        return 0;
    }

    public List<String> getThirdTrackers(String str) {
        if (this.mAdInstanceInfo == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject P = this.mAdInstanceInfo.P();
            if (P != null) {
                Iterator<String> keys = P.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals(str)) {
                        JSONArray optJSONArray = P.optJSONArray(next);
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            arrayList.add(optJSONArray.optString(i4));
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getTitle() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.a() : "";
    }

    public String getUniqueId() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.H() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getVideoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.n() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public WebView getWebView() {
        dm dmVar = this.mFeedsProd;
        if (dmVar != null) {
            return (WebView) dmVar.w();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleClick(View view) {
        handleClick(view, -1);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAdAvailable(Context context) {
        return this.mAdInstanceInfo != null && System.currentTimeMillis() - this.mAdInstanceInfo.y() <= this.mAdInstanceInfo.F();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAutoPlay() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null && aVar.k() == 1;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNeedDownloadApp() {
        return this.isDownloadApp;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNonWifiAutoPlay() {
        a aVar = this.mAdInstanceInfo;
        return aVar == null || aVar.l() == 1;
    }

    public int isRegionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.Q();
        }
        return 2;
    }

    public int isShowDialog() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.R();
        }
        return 2;
    }

    public void onADExposed() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposed();
        }
    }

    public void onADExposureFailed(int i4) {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposureFailed(i4);
        }
    }

    public void onADFunctionClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADFunctionClick();
        }
    }

    public void onADPermissionShow(boolean z3) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            if (z3) {
                adPrivacyListener.onADPermissionShow();
            } else {
                adPrivacyListener.onADPermissionClose();
            }
        }
    }

    public void onADPrivacyClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADPrivacyClick();
        }
    }

    public void onADStatusChanged() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADStatusChanged();
        }
    }

    public void onAdClick() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClick();
        }
    }

    public void onAdDownloadWindow(boolean z3) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener == null || !(adPrivacyListener instanceof NativeResponse.AdDownloadWindowListener)) {
            return;
        }
        if (z3) {
            ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowShow();
        } else {
            ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowClose();
        }
    }

    public void onAdUnionClick() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdUnionClick();
        }
    }

    public void onCouponFloatDismiss() {
        NativeResponse.AdShakeViewListener adShakeViewListener = this.mCouponFloatViewListener;
        if (adShakeViewListener != null) {
            adShakeViewListener.onDismiss();
        }
    }

    public void onShakeViewDismiss() {
        NativeResponse.AdShakeViewListener adShakeViewListener = this.mAdShakeViewListener;
        if (adShakeViewListener != null) {
            adShakeViewListener.onDismiss();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void pauseAppDownload() {
        if (this.mCxt == null || !this.isDownloadApp || this.mFeedsProd == null) {
            return;
        }
        JSONObject T = this.mAdInstanceInfo.T();
        try {
            T.put("pk", getAppPackage());
            T.put("msg", "pauseDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void permissionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        String E = aVar.E();
        JSONObject T = this.mAdInstanceInfo.T();
        try {
            T.put("permissionUrl", E);
            T.put("msg", "permissionClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(T);
    }

    public void preloadVideoMaterial() {
        a aVar;
        if (this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject T = aVar.T();
        try {
            T.put("msg", "preloadVideoMaterial");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void privacyClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        String C = aVar.C();
        JSONObject T = this.mAdInstanceInfo.T();
        try {
            T.put("privacy_link", C);
            T.put("msg", "privacyClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void recordImpression(View view) {
        a aVar;
        dm dmVar = this.mFeedsProd;
        if (dmVar == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        dmVar.a(view, aVar.T());
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void registerViewForInteraction(View view, List<View> list, List<View> list2, NativeResponse.AdInteractionListener adInteractionListener) {
        this.mAdInteractionListener = adInteractionListener;
        if (this.mFeedsProd != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("adView", view);
                hashMap.put("clickViews", list);
                hashMap.put("creativeViews", list2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "registerViewForInteraction");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bv a4 = bv.a();
                a4.c("NativeResponse", "registerViewForInteraction failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderCouponFloatView(NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd != null) {
            try {
                this.mCouponFloatViewListener = adShakeViewListener;
                return renderNativeView("native_coupon_float_icon", new JSONObject());
            } catch (Throwable th) {
                bv a4 = bv.a();
                a4.c("NativeResponse", "renderCouponFloatView failed: " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderFlipPageView() {
        if (this.mFeedsProd != null) {
            try {
                return renderNativeView("native_coupon_flip_page", new JSONObject());
            } catch (Throwable th) {
                bv a4 = bv.a();
                a4.c("NativeResponse", "renderFlipPageView failed: " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderShakeView(int i4, int i5, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd != null) {
            try {
                this.mAdShakeViewListener = adShakeViewListener;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "renderShakeView");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("w", i4);
                jSONObject.put("h", i5);
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                HashMap hashMap = new HashMap();
                this.mFeedsProd.a(jSONObject, hashMap);
                Object obj = hashMap.get("shake_view");
                if (obj instanceof View) {
                    return (View) obj;
                }
                return null;
            } catch (Throwable th) {
                bv a4 = bv.a();
                a4.c("NativeResponse", "renderShakeView failed: " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderSlideView(int i4, int i5, int i6, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd != null) {
            try {
                this.mAdShakeViewListener = adShakeViewListener;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("w", i4);
                jSONObject.put("h", i5);
                jSONObject.put("repeat", i6);
                return renderNativeView("native_slide_view", jSONObject);
            } catch (Throwable th) {
                bv a4 = bv.a();
                a4.c("NativeResponse", "renderSlideView failed: " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void resumeAppDownload() {
        a aVar;
        if (!this.isDownloadApp || this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject T = aVar.T();
        try {
            T.put("msg", "resumeDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(T);
    }

    public void setAdActionType(int i4) {
        this.mAdActionType = i4;
    }

    public void setAdDislikeListener(NativeResponse.AdDislikeListener adDislikeListener) {
        this.mAdDislikeListener = adDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void setAdPrivacyListener(NativeResponse.AdPrivacyListener adPrivacyListener) {
        this.mAdPrivacyListener = adPrivacyListener;
    }

    public void setIsDownloadApp(boolean z3) {
        this.isDownloadApp = z3;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void stopNativeView(View view) {
        if (this.mFeedsProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "stopNativeView");
                jSONObject.put("uniqueId", getUniqueId());
                HashMap hashMap = new HashMap();
                hashMap.put("native_view", view);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bv a4 = bv.a();
                a4.c("NativeResponse", "stopNativeView failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void unionLogoClick() {
        cs csVar;
        if (this.mFeedsProd == null || (csVar = this.mUriUtils) == null) {
            return;
        }
        String c4 = csVar.c("http://union.baidu.com/");
        JSONObject T = this.mAdInstanceInfo.T();
        try {
            T.put("unionUrl", c4);
            T.put("msg", "unionLogoClick");
        } catch (Throwable unused) {
        }
        this.mFeedsProd.a(T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dm dmVar;
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || (dmVar = this.mFeedsProd) == null) {
            return;
        }
        dmVar.a(aVar.H(), false, str, linkedHashMap);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingSuccess(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dm dmVar;
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || (dmVar = this.mFeedsProd) == null) {
            return;
        }
        dmVar.a(aVar.H(), true, str, linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleClick(View view, int i4) {
        handleClick(view, i4, false);
    }

    void handleClick(View view, boolean z3) {
        handleClick(view, -1, z3);
    }

    void handleClick(View view, int i4, boolean z3) {
        a aVar;
        if (this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject T = aVar.T();
        try {
            T.put("progress", i4);
            T.put("use_dialog_frame", z3);
            T.put("isDownloadApp", this.isDownloadApp);
        } catch (Throwable unused) {
        }
        this.mFeedsProd.b(view, T);
    }
}
