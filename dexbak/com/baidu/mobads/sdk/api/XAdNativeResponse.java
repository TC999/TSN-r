package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.internal.C2573a;
import com.baidu.mobads.sdk.internal.C2601aq;
import com.baidu.mobads.sdk.internal.C2634bs;
import com.baidu.mobads.sdk.internal.C2670cp;
import com.baidu.mobads.sdk.internal.C2692dj;
import com.baidu.mobads.sdk.internal.C2719p;
import com.stub.StubApp;
import com.umeng.analytics.pro.UContent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class XAdNativeResponse implements NativeResponse {
    private static final String TAG = "NativeResponse";
    private boolean isDownloadApp;
    private int mAdActionType = 1;
    private NativeResponse.AdDislikeListener mAdDislikeListener;
    private C2573a mAdInstanceInfo;
    private NativeResponse.AdInteractionListener mAdInteractionListener;
    private NativeResponse.AdPrivacyListener mAdPrivacyListener;
    private NativeResponse.AdShakeViewListener mAdShakeViewListener;
    private NativeResponse.CustomizeMediaPlayer mCustomizeMediaPlayer;
    private Context mCxt;
    private C2692dj mFeedsProd;
    private C2670cp mUriUtils;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    public XAdNativeResponse(Context context, C2692dj c2692dj, C2573a c2573a) {
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mAdInstanceInfo = c2573a;
        this.mFeedsProd = c2692dj;
        if (c2573a.m51087p() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = C2670cp.m50608a();
    }

    private int getActionType() {
        return this.mAdInstanceInfo.m51087p();
    }

    private IAdInterListener getAdInterListener() {
        C2692dj c2692dj = this.mFeedsProd;
        if (c2692dj != null) {
            return c2692dj.f8666k;
        }
        return null;
    }

    private String getProd() {
        C2692dj c2692dj = this.mFeedsProd;
        return c2692dj != null ? c2692dj.m50510f() : "";
    }

    private View renderNativeView(String str, JSONObject jSONObject) {
        try {
            jSONObject.put("viewId", str);
            jSONObject.put("msg", "renderNativeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            HashMap hashMap = new HashMap();
            this.mFeedsProd.m50818a(jSONObject, hashMap);
            Object obj = hashMap.get(str);
            if (obj instanceof View) {
                return (View) obj;
            }
            return null;
        } catch (Throwable th) {
            C2634bs m50744a = C2634bs.m50744a();
            m50744a.m50728c(TAG, "renderNativeView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingSuccess(String str) {
        C2692dj c2692dj;
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a == null || (c2692dj = this.mFeedsProd) == null) {
            return;
        }
        c2692dj.m50821a(c2573a.m51122H(), true, str);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void cancelAppDownload() {
        if (this.mCxt == null || !this.isDownloadApp || this.mFeedsProd == null) {
            return;
        }
        JSONObject m51110T = this.mAdInstanceInfo.m51110T();
        try {
            m51110T.put(UContent.f38088S, getAppPackage());
            m51110T.put("msg", "cancelDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.m50819a(m51110T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void clearImpressionTaskWhenBack() {
        C2692dj c2692dj = this.mFeedsProd;
        if (c2692dj != null) {
            c2692dj.m50803p();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void dislikeClick(DislikeEvent dislikeEvent) {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a == null || this.mFeedsProd == null || !(dislikeEvent instanceof DislikeInfo)) {
            return;
        }
        JSONObject m51110T = c2573a.m51110T();
        try {
            m51110T.put("dislike_type", dislikeEvent.getDislikeType());
            m51110T.put("msg", "dislike_click");
        } catch (Exception unused) {
        }
        this.mFeedsProd.m50819a(m51110T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void functionClick() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a == null || this.mFeedsProd == null) {
            return;
        }
        String m51126D = c2573a.m51126D();
        JSONObject m51110T = this.mAdInstanceInfo.m51110T();
        try {
            m51110T.put("function_link", m51126D);
            m51110T.put("msg", "functionClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.m50819a(m51110T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getActButtonString() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            JSONObject m51110T = c2573a.m51110T();
            try {
                m51110T.put("msg", "creative_call");
                m51110T.put("creative_type", "cta_get");
            } catch (Exception unused) {
            }
            this.mFeedsProd.m50819a(m51110T);
            return this.mAdInstanceInfo.m51117M();
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
            if ("request_id".equals(str)) {
                return this.mAdInstanceInfo.m51109U();
            }
            if ("dp_id".equals(str)) {
                return this.mAdInstanceInfo.m51108V();
            }
            return this.mAdInstanceInfo.m51105a(str);
        }
        return null;
    }

    public NativeResponse.AdDislikeListener getAdDislikeListener() {
        return this.mAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdLogoUrl() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51095h() : "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdMaterialType() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a == null) {
            return NativeResponse.MaterialType.NORMAL.getValue();
        }
        if ("video".equals(c2573a.m51079x())) {
            return NativeResponse.MaterialType.VIDEO.getValue();
        }
        if (C2573a.f8447f.equals(this.mAdInstanceInfo.m51079x())) {
            return NativeResponse.MaterialType.HTML.getValue();
        }
        return NativeResponse.MaterialType.NORMAL.getValue();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppFunctionLink() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51126D() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPackage() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51090m() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPermissionLink() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51125E() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPrivacyLink() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51127C() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public long getAppSize() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51093j();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppVersion() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51129A() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBaiduLogoUrl() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51094i() : "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBrandName() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51096g() : "";
    }

    public List<String> getBtnStyleColors() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51115O();
        }
        return null;
    }

    public int getBtnStyleType() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51116N();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerHeight() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51084s();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerSizeType() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51083t();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerWidth() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51085r();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.CustomizeMediaPlayer getCustomizeMediaPlayer() {
        C2573a c2573a;
        if (this.mCustomizeMediaPlayer == null && (c2573a = this.mAdInstanceInfo) != null && c2573a.m51111S() == 1) {
            this.mCustomizeMediaPlayer = new C2719p(this.mFeedsProd, this.mAdInstanceInfo);
        }
        return this.mCustomizeMediaPlayer;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getDesc() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51101b() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<DislikeEvent> getDislikeList() {
        ArrayList arrayList = new ArrayList();
        if (this.mAdInstanceInfo != null && this.mFeedsProd != null) {
            try {
                HashMap hashMap = new HashMap();
                JSONObject m51110T = this.mAdInstanceInfo.m51110T();
                m51110T.put("msg", "dislike_mapping");
                this.mFeedsProd.m50818a(m51110T, hashMap);
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
        return C2601aq.m50973a(StubApp.getOrigApplicationContext(context.getApplicationContext())).m50972a(StubApp.getOrigApplicationContext(this.mCxt.getApplicationContext()), getAppPackage());
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDuration() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51080w();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getECPMLevel() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51077z() : "";
    }

    public JSONObject getExtraParams() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51121I();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Map<String, String> getExtras() {
        HashMap hashMap = new HashMap();
        C2692dj c2692dj = this.mFeedsProd;
        if (c2692dj != null) {
            hashMap.put("appsid", c2692dj.f8670o);
        }
        return hashMap;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getHtmlSnippet() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51088o() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getIconUrl() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            String m51100c = c2573a.m51100c();
            return TextUtils.isEmpty(m51100c) ? this.mAdInstanceInfo.m51099d() : m51100c;
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getImageUrl() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51099d() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicHeight() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51097f();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicWidth() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51098e();
        }
        return 0;
    }

    public String getMarketingDesc() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51119K() : "";
    }

    public String getMarketingICONUrl() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51120J() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getMarketingPendant() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51118L() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.MaterialType getMaterialType() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a == null) {
            return NativeResponse.MaterialType.NORMAL;
        }
        if ("video".equals(c2573a.m51079x())) {
            return NativeResponse.MaterialType.VIDEO;
        }
        if (C2573a.f8447f.equals(this.mAdInstanceInfo.m51079x())) {
            return NativeResponse.MaterialType.HTML;
        }
        return NativeResponse.MaterialType.NORMAL;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<String> getMultiPicUrls() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51123G();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getPublisher() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51128B() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getStyleType() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51082u();
        }
        return 0;
    }

    public List<String> getThirdTrackers(String str) {
        if (this.mAdInstanceInfo == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject m51114P = this.mAdInstanceInfo.m51114P();
            if (m51114P != null) {
                Iterator<String> keys = m51114P.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals(str)) {
                        JSONArray optJSONArray = m51114P.optJSONArray(next);
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.optString(i));
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
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51107a() : "";
    }

    public String getUniqueId() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51122H() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getVideoUrl() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null ? c2573a.m51089n() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public WebView getWebView() {
        C2692dj c2692dj = this.mFeedsProd;
        if (c2692dj != null) {
            return (WebView) c2692dj.mo50557w();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleClick(View view) {
        handleClick(view, -1);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAdAvailable(Context context) {
        return this.mAdInstanceInfo != null && System.currentTimeMillis() - this.mAdInstanceInfo.m51078y() <= this.mAdInstanceInfo.m51124F();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAutoPlay() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a != null && c2573a.m51092k() == 1;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNeedDownloadApp() {
        return this.isDownloadApp;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNonWifiAutoPlay() {
        C2573a c2573a = this.mAdInstanceInfo;
        return c2573a == null || c2573a.m51091l() == 1;
    }

    public int isRegionClick() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51113Q();
        }
        return 2;
    }

    public int isShowDialog() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a != null) {
            return c2573a.m51112R();
        }
        return 2;
    }

    public void onADExposed() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposed();
        }
    }

    public void onADExposureFailed(int i) {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposureFailed(i);
        }
    }

    public void onADFunctionClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADFunctionClick();
        }
    }

    public void onADPermissionShow(boolean z) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            if (z) {
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

    public void onAdDownloadWindow(boolean z) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener == null || !(adPrivacyListener instanceof NativeResponse.AdDownloadWindowListener)) {
            return;
        }
        if (z) {
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
        JSONObject m51110T = this.mAdInstanceInfo.m51110T();
        try {
            m51110T.put(UContent.f38088S, getAppPackage());
            m51110T.put("msg", "pauseDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.m50819a(m51110T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void permissionClick() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a == null || this.mFeedsProd == null) {
            return;
        }
        String m51125E = c2573a.m51125E();
        JSONObject m51110T = this.mAdInstanceInfo.m51110T();
        try {
            m51110T.put("permissionUrl", m51125E);
            m51110T.put("msg", "permissionClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.m50819a(m51110T);
    }

    public void preloadVideoMaterial() {
        C2573a c2573a;
        if (this.mFeedsProd == null || (c2573a = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject m51110T = c2573a.m51110T();
        try {
            m51110T.put("msg", "preloadVideoMaterial");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.m50819a(m51110T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void privacyClick() {
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a == null || this.mFeedsProd == null) {
            return;
        }
        String m51127C = c2573a.m51127C();
        JSONObject m51110T = this.mAdInstanceInfo.m51110T();
        try {
            m51110T.put("privacy_link", m51127C);
            m51110T.put("msg", "privacyClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.m50819a(m51110T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void recordImpression(View view) {
        C2573a c2573a;
        C2692dj c2692dj = this.mFeedsProd;
        if (c2692dj == null || (c2573a = this.mAdInstanceInfo) == null) {
            return;
        }
        c2692dj.m50826a(view, c2573a.m51110T());
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
                this.mFeedsProd.m50818a(jSONObject, hashMap);
            } catch (Throwable th) {
                C2634bs m50744a = C2634bs.m50744a();
                m50744a.m50728c(TAG, "registerViewForInteraction failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderShakeView(int i, int i2, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd != null) {
            try {
                this.mAdShakeViewListener = adShakeViewListener;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "renderShakeView");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i);
                jSONObject.put("h", i2);
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                HashMap hashMap = new HashMap();
                this.mFeedsProd.m50818a(jSONObject, hashMap);
                Object obj = hashMap.get("shake_view");
                if (obj instanceof View) {
                    return (View) obj;
                }
                return null;
            } catch (Throwable th) {
                C2634bs m50744a = C2634bs.m50744a();
                m50744a.m50728c(TAG, "renderShakeView failed: " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderSlideView(int i, int i2, int i3, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd != null) {
            try {
                this.mAdShakeViewListener = adShakeViewListener;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i);
                jSONObject.put("h", i2);
                jSONObject.put("repeat", i3);
                return renderNativeView("native_slide_view", jSONObject);
            } catch (Throwable th) {
                C2634bs m50744a = C2634bs.m50744a();
                m50744a.m50728c(TAG, "renderSlideView failed: " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void resumeAppDownload() {
        C2573a c2573a;
        if (!this.isDownloadApp || this.mFeedsProd == null || (c2573a = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject m51110T = c2573a.m51110T();
        try {
            m51110T.put("msg", "resumeDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.m50819a(m51110T);
    }

    public void setAdActionType(int i) {
        this.mAdActionType = i;
    }

    public void setAdDislikeListener(NativeResponse.AdDislikeListener adDislikeListener) {
        this.mAdDislikeListener = adDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void setAdPrivacyListener(NativeResponse.AdPrivacyListener adPrivacyListener) {
        this.mAdPrivacyListener = adPrivacyListener;
    }

    public void setIsDownloadApp(boolean z) {
        this.isDownloadApp = z;
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
                this.mFeedsProd.m50818a(jSONObject, hashMap);
            } catch (Throwable th) {
                C2634bs m50744a = C2634bs.m50744a();
                m50744a.m50728c(TAG, "stopNativeView failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void unionLogoClick() {
        C2670cp c2670cp;
        if (this.mFeedsProd == null || (c2670cp = this.mUriUtils) == null) {
            return;
        }
        String m50598c = c2670cp.m50598c("http://union.baidu.com/");
        JSONObject m51110T = this.mAdInstanceInfo.m51110T();
        try {
            m51110T.put("unionUrl", m50598c);
            m51110T.put("msg", "unionLogoClick");
        } catch (Throwable unused) {
        }
        this.mFeedsProd.m50819a(m51110T);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        C2692dj c2692dj;
        C2573a c2573a = this.mAdInstanceInfo;
        if (c2573a == null || (c2692dj = this.mFeedsProd) == null) {
            return;
        }
        c2692dj.m50820a(c2573a.m51122H(), false, str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleClick(View view, int i) {
        handleClick(view, i, false);
    }

    void handleClick(View view, boolean z) {
        handleClick(view, -1, z);
    }

    void handleClick(View view, int i, boolean z) {
        C2573a c2573a;
        if (this.mFeedsProd == null || (c2573a = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject m51110T = c2573a.m51110T();
        try {
            m51110T.put(NotificationCompat.CATEGORY_PROGRESS, i);
            m51110T.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, z);
            m51110T.put("isDownloadApp", this.isDownloadApp);
        } catch (Throwable unused) {
        }
        this.mFeedsProd.m50815b(view, m51110T);
    }
}
