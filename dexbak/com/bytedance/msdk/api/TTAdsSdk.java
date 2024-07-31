package com.bytedance.msdk.api;

import android.app.Activity;
import android.content.Context;

@Deprecated
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class TTAdsSdk {
    public static boolean configLoadSuccess() {
        return TTMediationAdSdk.configLoadSuccess();
    }

    public static String getSdkVersion() {
        return TTMediationAdSdk.getSdkVersion();
    }

    public static void initUnityForBanner(Activity activity) {
        TTMediationAdSdk.initUnityForBanner(activity);
    }

    public static void initialize(Context context, TTAdConfig tTAdConfig) {
        TTMediationAdSdk.initialize(context, tTAdConfig);
    }

    public static void registerConfigCallback(TTSettingConfigCallback tTSettingConfigCallback) {
        TTMediationAdSdk.registerConfigCallback(tTSettingConfigCallback);
    }

    public static void requestPermissionIfNecessary(Context context) {
        TTMediationAdSdk.requestPermissionIfNecessary(context);
    }

    public static void unregisterConfigCallback(TTSettingConfigCallback tTSettingConfigCallback) {
        TTMediationAdSdk.unregisterConfigCallback(tTSettingConfigCallback);
    }

    public static void updatePangleConfig(TTAdConfig tTAdConfig) {
        TTMediationAdSdk.updatePangleConfig(tTAdConfig);
    }

    public static void updatePanglePaid(boolean z) {
        TTMediationAdSdk.updatePanglePaid(z);
    }
}
