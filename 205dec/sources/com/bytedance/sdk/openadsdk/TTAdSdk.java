package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTCodeGroupRit;
import com.bytedance.sdk.openadsdk.api.bl;
import com.bytedance.sdk.openadsdk.api.ok;
import com.bytedance.sdk.openadsdk.api.plugin.n;
import com.bytedance.sdk.openadsdk.live.a;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.MediationManagerVisitor;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class TTAdSdk {
    public static final String BRANCH = "v5900_csjm";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle.m";
    public static final String C_H = "2a17075";
    public static final int EXT_API_VERSION_CODE = 999;
    public static final boolean INCLUDE_LIVE = true;
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final boolean IS_BOOST = false;
    public static final boolean IS_P = true;
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final int SDK_VERSION_CODE = 5908;
    public static final String SDK_VERSION_NAME = "5.9.0.8";
    public static final String S_C = "main";

    /* renamed from: a  reason: collision with root package name */
    private static TTAdConfig f31357a;
    private static final ok ok = new n();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface Callback extends InitCallback {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
    @Deprecated
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface InitCallback {
        void fail(int i4, String str);

        void success();
    }

    public static TTAdManager getAdManager() {
        ok okVar = ok;
        if (okVar != null) {
            return okVar.a();
        }
        return null;
    }

    public static void getCodeGroupRit(final long j4, final TTCodeGroupRit.TTCodeGroupRitListener tTCodeGroupRitListener) {
        ok okVar = ok;
        if (okVar != null) {
            okVar.a().register(new CodeGroupRitObject() { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.1
                @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
                public long getCodeGroupId() {
                    return j4;
                }

                @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
                public TTCodeGroupRit.TTCodeGroupRitListener getListener() {
                    return tTCodeGroupRitListener;
                }
            });
        } else if (tTCodeGroupRitListener != null) {
            tTCodeGroupRitListener.onFail(4100, "please init sdk first!");
        }
    }

    public static IMediationManager getMediationManager() {
        if (ok != null) {
            return MediationManagerVisitor.getInstance().getMediationManager();
        }
        return null;
    }

    public static boolean init(Context context, TTAdConfig tTAdConfig) {
        f31357a = tTAdConfig;
        ok(context, tTAdConfig);
        return true;
    }

    @Deprecated
    public static boolean isInitSuccess() {
        ok okVar = ok;
        if (okVar != null) {
            return okVar.ok();
        }
        return false;
    }

    public static boolean isOnePointFiveAdType(TTNativeExpressAd tTNativeExpressAd) {
        Map<String, Object> mediaExtraInfo;
        if (tTNativeExpressAd == null) {
            mediaExtraInfo = null;
        } else {
            try {
                mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (mediaExtraInfo == null || !mediaExtraInfo.containsKey("_tt_ad_type_onepointfive")) {
            return false;
        }
        return ((Boolean) mediaExtraInfo.get("_tt_ad_type_onepointfive")).booleanValue();
    }

    public static boolean isSdkReady() {
        ok okVar = ok;
        if (okVar != null) {
            return okVar.ok();
        }
        return false;
    }

    private static void ok(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            bl.ok();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            bl.ok("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        ok(context, "Context is null, please check.");
        ok(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    public static void start(Callback callback) {
        ok(f31357a, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        ok okVar = ok;
        if (okVar == null) {
            callback.fail(4100, "Load initializer failed");
        } else {
            okVar.ok(TTAppContextHolder.getContext(), f31357a, callback);
        }
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        ok.bl a4;
        if (tTAdConfig == null || (a4 = ok.a()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (bundle.keySet().isEmpty()) {
            return;
        }
        a4.getExtra(ValueSet.class, bundle);
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        if (tTAdConfig == null) {
            return;
        }
        a.ok().ok(tTAdConfig.getInjectionAuth());
    }

    public static void updatePaid(boolean z3) {
        ok.bl a4 = ok.a();
        if (a4 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z3);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        a4.getExtra(ValueSet.class, bundle);
    }

    private static void ok(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
