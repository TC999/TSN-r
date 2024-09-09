package com.bytedance.msdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.o;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.x;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTAppDialogClickListener;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.pangle.TTPangleSDKInitManager;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class TTMediationAdSdk {
    private static void a() {
        ITTAdapterConfiguration value;
        try {
            Map<String, ITTAdapterConfiguration> c4 = b.c();
            if (c4 == null || c4.size() <= 0) {
                return;
            }
            for (Map.Entry<String, ITTAdapterConfiguration> entry : c4.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.setPrivacyConfig(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean configLoadSuccess() {
        return a.f().q();
    }

    public static String getAppId() {
        return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c();
    }

    public static String getAppName() {
        return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().g();
    }

    public static String getSdkVersion() {
        return "2.9.2.1";
    }

    public static String getZbh(Context context) {
        return o.a();
    }

    public static void initUnityForBanner(Activity activity) {
        b.a(activity);
    }

    public static void initialize(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig == null) {
            Log.d("TTMediationSDK_SDK_Init", "TTMediationAdSdk\u521d\u59cb\u5316\u5931\u8d25\uff0cTTAdConfig\u4e0d\u80fd\u662fnull");
            return;
        }
        if (tTAdConfig.isDebug()) {
            Logger.openDebugMode();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.a.c();
        }
        if (context == null) {
            Logger.d("TTMediationSDK_SDK_Init", "TTMediationAdSdk\u521d\u59cb\u5316\u5931\u8d25\uff0ccontext\u4e0d\u80fd\u662fnull");
            return;
        }
        Logger.e("TTMediationSDK_SDK_Init", "msdk_init.............");
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(System.currentTimeMillis());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(tTAdConfig.getAppId());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().b(tTAdConfig.getAppName());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c(tTAdConfig.isPangleAllowShowNotify());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().d(tTAdConfig.isPangleAllowShowPageWhenScreenLock());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().b(tTAdConfig.getPangleTitleBarTheme());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(tTAdConfig.getPangleDirectDownloadNetworkType());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(tTAdConfig.getPangleNeedClearTaskReset());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().f(tTAdConfig.isPangleUseTextureView());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().e(tTAdConfig.isPanglePaid());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().e(tTAdConfig.getPublisherDid());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().b(tTAdConfig.isOpenAdnTest());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c(tTAdConfig.getPangleData());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(tTAdConfig.getExtraData());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(tTAdConfig.getPangleCustomController());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(tTAdConfig.getPrivacyConfig());
        a();
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(tTAdConfig.allowBaiduSdkReadDeviceId());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(tTAdConfig.getAdapterConfigurationClasses());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().b(tTAdConfig.getMediatedNetworkConfigurations());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c(tTAdConfig.getRequestOptions());
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(tTAdConfig.getUserInfoForSegment(), true);
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(tTAdConfig.getPanglePluginUpdateConfig());
        b.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        g.c();
        if (x.b(context)) {
            g.a();
        }
    }

    public static boolean isAdapterVersionFit(String str, String str2) {
        return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a.b(str, str2);
    }

    public static boolean isAdnVersionFit(String str, String str2) {
        return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a.c(str, str2);
    }

    public static boolean isUITest() {
        return a.f().z();
    }

    public static void registerConfigCallback(TTSettingConfigCallback tTSettingConfigCallback) {
        a.f().a(tTSettingConfigCallback);
    }

    public static void requestPermissionIfNecessary(Context context) {
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 3);
        if (context != null) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c.a(context, intent, null);
        }
    }

    public static void setPulisherDid(String str) {
        Logger.d("TTMediationSDK", "app\u8fd0\u884c\u4e2dsetPulisherDid: " + str);
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().e(str);
    }

    public static void setThemeStatus(int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put(TTBaseAdapterConfiguration.TT_MSDK_THEME_STATUS, Integer.valueOf(i4));
        Map<String, ITTAdapterConfiguration> c4 = b.c();
        if (c4 == null || c4.size() == 0) {
            return;
        }
        for (ITTAdapterConfiguration iTTAdapterConfiguration : c4.values()) {
            if (iTTAdapterConfiguration != null) {
                iTTAdapterConfiguration.setThemeStatus(hashMap);
            }
        }
    }

    public static void setUserInfoForSegment(UserInfoForSegment userInfoForSegment) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(userInfoForSegment, false);
    }

    public static int showOpenOrInstallAppDialog(TTAppDialogClickListener tTAppDialogClickListener) {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        Map<String, ITTAdapterConfiguration> c4 = b.c();
        if (c4 == null || c4.size() == 0 || (iTTAdapterConfiguration = c4.get(DefaultAdapterClasses.getClassNameByAdnName("gdt"))) == null) {
            return 0;
        }
        return iTTAdapterConfiguration.showOpenOrInstallAppDialog(tTAppDialogClickListener);
    }

    public static void unregisterConfigCallback(TTSettingConfigCallback tTSettingConfigCallback) {
        a.f().b(tTSettingConfigCallback);
    }

    public static void updatePangleConfig(TTAdConfig tTAdConfig) {
        if (tTAdConfig == null) {
            return;
        }
        if (!TextUtils.isEmpty(tTAdConfig.getPangleData())) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c(tTAdConfig.getPangleData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getPangleKeywords())) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().d(tTAdConfig.getPangleKeywords());
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().d(tTAdConfig.getExtraData());
    }

    public static void updatePanglePaid(boolean z3) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().e(z3);
    }

    public static void updatePrivacyConfig(TTPrivacyConfig tTPrivacyConfig) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a(tTPrivacyConfig);
        TTPangleSDKInitManager.updatePangleData("personal_ads_type", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isLimitPersonalAds() ? "0" : "1");
        a();
    }

    public static void requestPermissionIfNecessary(Context context, int[] iArr) {
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra(TTDelegateActivity.INTENT_PERMISSIONS, iArr);
        if (context != null) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c.a(context, intent, null);
        }
    }
}
