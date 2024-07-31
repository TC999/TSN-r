package com.bytedance.msdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.InitChecker;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.InitHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.ActivityUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.OAIDHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTProcessUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.NetClient;
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

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class TTMediationAdSdk {
    /* renamed from: a */
    private static void m37461a() {
        ITTAdapterConfiguration value;
        try {
            Map<String, ITTAdapterConfiguration> m59273c = InitHelper.m59273c();
            if (m59273c == null || m59273c.size() <= 0) {
                return;
            }
            for (Map.Entry<String, ITTAdapterConfiguration> entry : m59273c.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.setPrivacyConfig(SdkGlobalInfo.m59939B().m59897p());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean configLoadSuccess() {
        return InternalContainer.m59943f().m59730q();
    }

    public static String getAppId() {
        return SdkGlobalInfo.m59939B().m59921c();
    }

    public static String getAppName() {
        return SdkGlobalInfo.m59939B().m59907g();
    }

    public static String getSdkVersion() {
        return "2.9.2.1";
    }

    public static String getZbh(Context context) {
        return OAIDHelper.m59164a();
    }

    public static void initUnityForBanner(Activity activity) {
        InitHelper.m59281a(activity);
    }

    public static void initialize(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig == null) {
            Log.d("TTMediationSDK_SDK_Init", "TTMediationAdSdk初始化失败，TTAdConfig不能是null");
            return;
        }
        if (tTAdConfig.isDebug()) {
            Logger.openDebugMode();
            NetClient.m59081c();
        }
        if (context == null) {
            Logger.m37562d("TTMediationSDK_SDK_Init", "TTMediationAdSdk初始化失败，context不能是null");
            return;
        }
        Logger.m37557e("TTMediationSDK_SDK_Init", "msdk_init.............");
        SdkGlobalInfo.m59939B().m59936a(System.currentTimeMillis());
        SdkGlobalInfo.m59939B().m59932a(tTAdConfig.getAppId());
        SdkGlobalInfo.m59939B().m59924b(tTAdConfig.getAppName());
        SdkGlobalInfo.m59939B().m59918c(tTAdConfig.isPangleAllowShowNotify());
        SdkGlobalInfo.m59939B().m59914d(tTAdConfig.isPangleAllowShowPageWhenScreenLock());
        SdkGlobalInfo.m59939B().m59925b(tTAdConfig.getPangleTitleBarTheme());
        SdkGlobalInfo.m59939B().m59928a(tTAdConfig.getPangleDirectDownloadNetworkType());
        SdkGlobalInfo.m59939B().m59927a(tTAdConfig.getPangleNeedClearTaskReset());
        SdkGlobalInfo.m59939B().m59908f(tTAdConfig.isPangleUseTextureView());
        SdkGlobalInfo.m59939B().m59911e(tTAdConfig.isPanglePaid());
        SdkGlobalInfo.m59939B().m59912e(tTAdConfig.getPublisherDid());
        SdkGlobalInfo.m59939B().m59922b(tTAdConfig.isOpenAdnTest());
        SdkGlobalInfo.m59939B().m59920c(tTAdConfig.getPangleData());
        SdkGlobalInfo.m59939B().m59931a(tTAdConfig.getExtraData());
        SdkGlobalInfo.m59939B().m59933a(tTAdConfig.getPangleCustomController());
        SdkGlobalInfo.m59939B().m59935a(tTAdConfig.getPrivacyConfig());
        m37461a();
        SdkGlobalInfo.m59939B().m59929a(tTAdConfig.allowBaiduSdkReadDeviceId());
        SdkGlobalInfo.m59939B().m59930a(tTAdConfig.getAdapterConfigurationClasses());
        SdkGlobalInfo.m59939B().m59923b(tTAdConfig.getMediatedNetworkConfigurations());
        SdkGlobalInfo.m59939B().m59919c(tTAdConfig.getRequestOptions());
        SdkGlobalInfo.m59939B().m59934a(tTAdConfig.getUserInfoForSegment(), true);
        SdkGlobalInfo.m59939B().m59937a(tTAdConfig.getPanglePluginUpdateConfig());
        InitHelper.m59280a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        AdEventUtil.m59302c();
        if (TTProcessUtils.m59091b(context)) {
            AdEventUtil.m59332a();
        }
    }

    public static boolean isAdapterVersionFit(String str, String str2) {
        return InitChecker.m59287b(str, str2);
    }

    public static boolean isAdnVersionFit(String str, String str2) {
        return InitChecker.m59285c(str, str2);
    }

    public static boolean isUITest() {
        return InternalContainer.m59943f().m59721z();
    }

    public static void registerConfigCallback(TTSettingConfigCallback tTSettingConfigCallback) {
        InternalContainer.m59943f().m59764a(tTSettingConfigCallback);
    }

    public static void requestPermissionIfNecessary(Context context) {
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 3);
        if (context != null) {
            ActivityUtil.m59251a(context, intent, null);
        }
    }

    public static void setPulisherDid(String str) {
        Logger.m37562d("TTMediationSDK", "app运行中setPulisherDid: " + str);
        SdkGlobalInfo.m59939B().m59912e(str);
    }

    public static void setThemeStatus(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(TTBaseAdapterConfiguration.TT_MSDK_THEME_STATUS, Integer.valueOf(i));
        Map<String, ITTAdapterConfiguration> m59273c = InitHelper.m59273c();
        if (m59273c == null || m59273c.size() == 0) {
            return;
        }
        for (ITTAdapterConfiguration iTTAdapterConfiguration : m59273c.values()) {
            if (iTTAdapterConfiguration != null) {
                iTTAdapterConfiguration.setThemeStatus(hashMap);
            }
        }
    }

    public static void setUserInfoForSegment(UserInfoForSegment userInfoForSegment) {
        SdkGlobalInfo.m59939B().m59934a(userInfoForSegment, false);
    }

    public static int showOpenOrInstallAppDialog(TTAppDialogClickListener tTAppDialogClickListener) {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        Map<String, ITTAdapterConfiguration> m59273c = InitHelper.m59273c();
        if (m59273c == null || m59273c.size() == 0 || (iTTAdapterConfiguration = m59273c.get(DefaultAdapterClasses.getClassNameByAdnName("gdt"))) == null) {
            return 0;
        }
        return iTTAdapterConfiguration.showOpenOrInstallAppDialog(tTAppDialogClickListener);
    }

    public static void unregisterConfigCallback(TTSettingConfigCallback tTSettingConfigCallback) {
        InternalContainer.m59943f().m59755b(tTSettingConfigCallback);
    }

    public static void updatePangleConfig(TTAdConfig tTAdConfig) {
        if (tTAdConfig == null) {
            return;
        }
        if (!TextUtils.isEmpty(tTAdConfig.getPangleData())) {
            SdkGlobalInfo.m59939B().m59920c(tTAdConfig.getPangleData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getPangleKeywords())) {
            SdkGlobalInfo.m59939B().m59916d(tTAdConfig.getPangleKeywords());
        }
        SdkGlobalInfo.m59939B().m59915d(tTAdConfig.getExtraData());
    }

    public static void updatePanglePaid(boolean z) {
        SdkGlobalInfo.m59939B().m59911e(z);
    }

    public static void updatePrivacyConfig(TTPrivacyConfig tTPrivacyConfig) {
        SdkGlobalInfo.m59939B().m59935a(tTPrivacyConfig);
        TTPangleSDKInitManager.updatePangleData("personal_ads_type", SdkGlobalInfo.m59939B().m59897p().isLimitPersonalAds() ? "0" : "1");
        m37461a();
    }

    public static void requestPermissionIfNecessary(Context context, int[] iArr) {
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra(TTDelegateActivity.INTENT_PERMISSIONS, iArr);
        if (context != null) {
            ActivityUtil.m59251a(context, intent, null);
        }
    }
}
