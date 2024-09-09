package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.k;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.w;
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
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTPangleSDKInitManager {
    public static final int ADN_INIT_ERROR_NO_APPID = 1;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f27105a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f27106b;

    /* renamed from: c  reason: collision with root package name */
    private static final List<ThirdSdkInit.InitCallback> f27107c = new CopyOnWriteArrayList();

    /* renamed from: d  reason: collision with root package name */
    private static TTAdSdk.InitCallback f27108d = new TTAdSdk.InitCallback() { // from class: com.bytedance.msdk.adapter.pangle.TTPangleSDKInitManager.1
        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i4, String str) {
            g.a(3, "error:error_code:" + i4 + ",errorMsg:" + str, b.g(), "pangle");
            TTPangleSDKInitManager.h(i4, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            Logger.e("TTMediationSDK_P", "pangle_init_ success.........:");
            TTPangleSDKInitManager.g();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final TTCustomController f27109e = new TTCustomController() { // from class: com.bytedance.msdk.adapter.pangle.TTPangleSDKInitManager.2
        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i() != null) {
                return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i().alist();
            }
            return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().appList();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i() != null) {
                return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i().getDevImei();
            }
            return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().getDevImei();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevOaid() {
            if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i() != null) {
                return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i().getDevOaid();
            }
            return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().getDevOaid();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public LocationProvider getTTLocation() {
            if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i() != null) {
                return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i().getTTLocation();
            }
            if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().getTTLocation() != null) {
                return new TTLocation(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().getTTLocation().getLatitude(), bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().getTTLocation().getLongitude());
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i() != null) {
                return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i().isCanUseLocation();
            }
            return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUseLocation();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i() != null) {
                return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i().isCanUsePhoneState();
            }
            return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUsePhoneState();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i() != null) {
                return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i().isCanUseWifiState();
            }
            return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUseWifiState();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWriteExternal() {
            if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i() != null) {
                return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().i().isCanUseWriteExternal();
            }
            return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUseWriteExternal();
        }
    };

    private static TTAdConfig a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c();
        }
        l();
        return new TTAdConfig.Builder().appId(str).useTextureView(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().z()).appName(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().g()).paid(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().y()).titleBarTheme(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().m()).allowShowNotify(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().w()).allowShowPageWhenScreenLock(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().x()).debug(Logger.isDebug()).directDownloadNetworkType(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().n()).supportMultiProcess(false).data(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().j()).needClearTaskReset(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().l()).customController(f27109e).keywords(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().k()).build();
    }

    private static String b(String str, String str2, String str3) {
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
                boolean z3 = false;
                int i4 = 0;
                while (true) {
                    if (i4 < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                        if (optJSONObject != null && str2.equals(optJSONObject.getString("name"))) {
                            optJSONObject.put("value", str3);
                            z3 = true;
                            break;
                        }
                        i4++;
                    } else {
                        break;
                    }
                }
                if (!z3) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", str2);
                    jSONObject.put("value", str3);
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return str;
    }

    private static void e(Context context, TTAdConfig tTAdConfig) {
        try {
            TTAdSdk.init(context, tTAdConfig);
            g();
        } catch (Throwable th) {
            h(AdError.ERROR_CODE_ADAPTER_CONFIGURATION_ERROR, "pangle");
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(AdSlot.Builder builder, String str) {
        TTAdSdk.updatePaid(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().y());
        if (builder != null) {
            builder.setUserData(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        for (ThirdSdkInit.InitCallback initCallback : f27107c) {
            if (initCallback != null) {
                initCallback.success();
            }
        }
        f27107c.clear();
    }

    public static TTAdManager get() {
        if (!hasPangleSdkInit()) {
            ThirdSdkInit.initTTPangleSDK(a.d());
        }
        return TTAdSdk.getAdManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(int i4, String str) {
        for (ThirdSdkInit.InitCallback initCallback : f27107c) {
            if (initCallback != null) {
                initCallback.fail(i4, str);
            }
        }
        f27107c.clear();
        f27106b = true;
        f27105a = false;
    }

    public static boolean hasPangleSdkInit() {
        boolean z3;
        synchronized (ThirdSdkInit.class) {
            z3 = f27105a;
        }
        return z3;
    }

    private static void i(Context context, String str) {
        synchronized (ThirdSdkInit.class) {
            Logger.e("TTMediationSDK_P", "pangle doInit pangleInit=" + f27105a);
            if (!f27105a) {
                if (TextUtils.isEmpty(str)) {
                    Logger.e("TTMediationSDK_P", "pangle_init_error.........:appId\u4e3a\u7a7a");
                    g.a(1, "appId\u4e3a\u7a7a", b.g(), "pangle");
                    return;
                }
                f27105a = true;
                w.j();
                if (isPanglePluginSdk()) {
                    TTAdSdk.init(context, a(context, str), f27108d);
                } else {
                    e(context, a(context, str));
                }
            } else if (TTAdSdk.isInitSuccess()) {
                g();
            } else if (f27106b) {
                h(AdError.ERROR_CODE_ADAPTER_CONFIGURATION_ERROR, "pangle");
            }
            if (TextUtils.isEmpty(k.d(context))) {
                k.a(context, w.b());
            }
        }
    }

    public static void initTTPangleSDK(Context context, String str, ThirdSdkInit.InitCallback initCallback) {
        f27107c.add(initCallback);
        try {
            if (TextUtils.isEmpty(str)) {
                str = ThirdSdkInit.getTTPangleAppId();
            }
            i(context, str);
        } catch (Throwable th) {
            synchronized (ThirdSdkInit.class) {
                f27105a = false;
                f27106b = false;
                g.a(2, "\u521d\u59cb\u5316\u629b\u51fa\u5f02\u5e38", b.g(), "pangle");
                th.printStackTrace();
                Logger.e("TTMediationSDK_SDK_Init", "TTSDK \u521d\u59cb\u5316\u5931\u8d25\u3002\u3002 e=" + th.toString());
            }
        }
    }

    public static boolean isPanglePluginSdk() {
        boolean z3 = false;
        try {
            Class<?> cls = Class.forName("com.bytedance.sdk.openadsdk.TTAdConstant");
            Field declaredField = cls.getDeclaredField("IS_P");
            declaredField.setAccessible(true);
            z3 = ((Boolean) declaredField.get(cls)).booleanValue();
            Logger.e("TTMediationSDK_SDK_Init", "\u7a7f\u5c71\u7532\u7248\u672c\uff1aisP=" + z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> j() {
        return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k() {
        return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().j();
    }

    private static void l() {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c(b(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().j(), "personal_ads_type", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isLimitPersonalAds() ? "0" : "1"));
    }

    public static void updatePangleData(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String b4 = b(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().j(), str, str2);
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c(b4);
        TTAdSdk.updateAdConfig(new TTAdConfig.Builder().data(b4).build());
    }
}
