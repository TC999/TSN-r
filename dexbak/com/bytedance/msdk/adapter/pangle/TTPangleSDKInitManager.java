package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.InitHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IdUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTPangleUtil;
import com.bytedance.msdk.adapter.ThirdSdkInit;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTPangleSDKInitManager {
    public static final int ADN_INIT_ERROR_NO_APPID = 1;

    /* renamed from: a */
    private static boolean f21495a;

    /* renamed from: b */
    private static boolean f21496b;

    /* renamed from: c */
    private static final List<ThirdSdkInit.InitCallback> f21497c = new CopyOnWriteArrayList();

    /* renamed from: d */
    private static TTAdSdk.InitCallback f21498d = new TTAdSdk.InitCallback() { // from class: com.bytedance.msdk.adapter.pangle.TTPangleSDKInitManager.1
        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i, String str) {
            AdEventUtil.m59330a(3, "error:error_code:" + i + ",errorMsg:" + str, InitHelper.m59269g(), "pangle");
            TTPangleSDKInitManager.m37574h(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            Logger.m37557e("TTMediationSDK_P", "pangle_init_ success.........:");
            TTPangleSDKInitManager.m37575g();
        }
    };

    /* renamed from: e */
    private static final TTCustomController f21499e = new TTCustomController() { // from class: com.bytedance.msdk.adapter.pangle.TTPangleSDKInitManager.2
        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            if (SdkGlobalInfo.m59939B().m59904i() != null) {
                return SdkGlobalInfo.m59939B().m59904i().alist();
            }
            return SdkGlobalInfo.m59939B().m59897p().appList();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            if (SdkGlobalInfo.m59939B().m59904i() != null) {
                return SdkGlobalInfo.m59939B().m59904i().getDevImei();
            }
            return SdkGlobalInfo.m59939B().m59897p().getDevImei();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevOaid() {
            if (SdkGlobalInfo.m59939B().m59904i() != null) {
                return SdkGlobalInfo.m59939B().m59904i().getDevOaid();
            }
            return SdkGlobalInfo.m59939B().m59897p().getDevOaid();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public LocationProvider getTTLocation() {
            if (SdkGlobalInfo.m59939B().m59904i() != null) {
                return SdkGlobalInfo.m59939B().m59904i().getTTLocation();
            }
            if (SdkGlobalInfo.m59939B().m59897p().getTTLocation() != null) {
                return new TTLocation(SdkGlobalInfo.m59939B().m59897p().getTTLocation().getLatitude(), SdkGlobalInfo.m59939B().m59897p().getTTLocation().getLongitude());
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            if (SdkGlobalInfo.m59939B().m59904i() != null) {
                return SdkGlobalInfo.m59939B().m59904i().isCanUseLocation();
            }
            return SdkGlobalInfo.m59939B().m59897p().isCanUseLocation();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            if (SdkGlobalInfo.m59939B().m59904i() != null) {
                return SdkGlobalInfo.m59939B().m59904i().isCanUsePhoneState();
            }
            return SdkGlobalInfo.m59939B().m59897p().isCanUsePhoneState();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            if (SdkGlobalInfo.m59939B().m59904i() != null) {
                return SdkGlobalInfo.m59939B().m59904i().isCanUseWifiState();
            }
            return SdkGlobalInfo.m59939B().m59897p().isCanUseWifiState();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWriteExternal() {
            if (SdkGlobalInfo.m59939B().m59904i() != null) {
                return SdkGlobalInfo.m59939B().m59904i().isCanUseWriteExternal();
            }
            return SdkGlobalInfo.m59939B().m59897p().isCanUseWriteExternal();
        }
    };

    /* renamed from: a */
    private static TTAdConfig m37581a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = SdkGlobalInfo.m59939B().m59921c();
        }
        m37570l();
        return new TTAdConfig.Builder().appId(str).useTextureView(SdkGlobalInfo.m59939B().m59887z()).appName(SdkGlobalInfo.m59939B().m59907g()).paid(SdkGlobalInfo.m59939B().m59888y()).titleBarTheme(SdkGlobalInfo.m59939B().m59900m()).allowShowNotify(SdkGlobalInfo.m59939B().m59890w()).allowShowPageWhenScreenLock(SdkGlobalInfo.m59939B().m59889x()).debug(Logger.isDebug()).directDownloadNetworkType(SdkGlobalInfo.m59939B().m59899n()).supportMultiProcess(false).data(SdkGlobalInfo.m59939B().m59903j()).needClearTaskReset(SdkGlobalInfo.m59939B().m59901l()).customController(f21499e).keywords(SdkGlobalInfo.m59939B().m59902k()).build();
    }

    /* renamed from: b */
    private static String m37580b(String str, String str2, String str3) {
        JSONArray jSONArray;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONArray = new JSONArray(str);
                    } catch (JSONException unused) {
                        jSONArray = new JSONArray();
                    }
                } else {
                    jSONArray = new JSONArray();
                }
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null && str2.equals(optJSONObject.getString("name"))) {
                            optJSONObject.put(DomainCampaignEx.LOOPBACK_VALUE, str3);
                            z = true;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (!z) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", str2);
                    jSONObject.put(DomainCampaignEx.LOOPBACK_VALUE, str3);
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    /* renamed from: e */
    private static void m37577e(Context context, TTAdConfig tTAdConfig) {
        try {
            TTAdSdk.init(context, tTAdConfig);
            m37575g();
        } catch (Throwable th) {
            m37574h(AdError.ERROR_CODE_ADAPTER_CONFIGURATION_ERROR, "pangle");
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static void m37576f(AdSlot.Builder builder, String str) {
        TTAdSdk.updatePaid(SdkGlobalInfo.m59939B().m59888y());
        if (builder != null) {
            builder.setUserData(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static void m37575g() {
        for (ThirdSdkInit.InitCallback initCallback : f21497c) {
            if (initCallback != null) {
                initCallback.success();
            }
        }
        f21497c.clear();
    }

    public static TTAdManager get() {
        if (!hasPangleSdkInit()) {
            ThirdSdkInit.initTTPangleSDK(InternalContainer.m59945d());
        }
        return TTAdSdk.getAdManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static void m37574h(int i, String str) {
        for (ThirdSdkInit.InitCallback initCallback : f21497c) {
            if (initCallback != null) {
                initCallback.fail(i, str);
            }
        }
        f21497c.clear();
        f21496b = true;
        f21495a = false;
    }

    public static boolean hasPangleSdkInit() {
        boolean z;
        synchronized (ThirdSdkInit.class) {
            z = f21495a;
        }
        return z;
    }

    /* renamed from: i */
    private static void m37573i(Context context, String str) {
        synchronized (ThirdSdkInit.class) {
            Logger.m37557e("TTMediationSDK_P", "pangle doInit pangleInit=" + f21495a);
            if (!f21495a) {
                if (TextUtils.isEmpty(str)) {
                    Logger.m37557e("TTMediationSDK_P", "pangle_init_error.........:appId为空");
                    AdEventUtil.m59330a(1, "appId为空", InitHelper.m59269g(), "pangle");
                    return;
                }
                f21495a = true;
                TTPangleUtil.m59094j();
                if (isPanglePluginSdk()) {
                    TTAdSdk.init(context, m37581a(context, str), f21498d);
                } else {
                    m37577e(context, m37581a(context, str));
                }
            } else if (TTAdSdk.isInitSuccess()) {
                m37575g();
            } else if (f21496b) {
                m37574h(AdError.ERROR_CODE_ADAPTER_CONFIGURATION_ERROR, "pangle");
            }
            if (TextUtils.isEmpty(IdUtils.m59191d(context))) {
                IdUtils.m59200a(context, TTPangleUtil.m59104b());
            }
        }
    }

    public static void initTTPangleSDK(Context context, String str, ThirdSdkInit.InitCallback initCallback) {
        f21497c.add(initCallback);
        try {
            if (TextUtils.isEmpty(str)) {
                str = ThirdSdkInit.getTTPangleAppId();
            }
            m37573i(context, str);
        } catch (Throwable th) {
            synchronized (ThirdSdkInit.class) {
                f21495a = false;
                f21496b = false;
                AdEventUtil.m59330a(2, "初始化抛出异常", InitHelper.m59269g(), "pangle");
                th.printStackTrace();
                Logger.m37557e("TTMediationSDK_SDK_Init", "TTSDK 初始化失败。。 e=" + th.toString());
            }
        }
    }

    public static boolean isPanglePluginSdk() {
        boolean z = false;
        try {
            Class<?> cls = Class.forName("com.bytedance.sdk.openadsdk.TTAdConstant");
            Field declaredField = cls.getDeclaredField("IS_P");
            declaredField.setAccessible(true);
            z = ((Boolean) declaredField.get(cls)).booleanValue();
            Logger.m37557e("TTMediationSDK_SDK_Init", "穿山甲版本：isP=" + z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static Map<String, String> m37572j() {
        return SdkGlobalInfo.m59939B().m59913e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static String m37571k() {
        return SdkGlobalInfo.m59939B().m59903j();
    }

    /* renamed from: l */
    private static void m37570l() {
        SdkGlobalInfo.m59939B().m59920c(m37580b(SdkGlobalInfo.m59939B().m59903j(), "personal_ads_type", SdkGlobalInfo.m59939B().m59897p().isLimitPersonalAds() ? "0" : "1"));
    }

    public static void updatePangleData(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String m37580b = m37580b(SdkGlobalInfo.m59939B().m59903j(), str, str2);
        SdkGlobalInfo.m59939B().m59920c(m37580b);
        TTAdSdk.updateAdConfig(new TTAdConfig.Builder().data(m37580b).build());
    }
}
