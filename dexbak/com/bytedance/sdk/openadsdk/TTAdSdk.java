package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTCodeGroupRit;
import com.bytedance.sdk.openadsdk.api.AbstractC6281ok;
import com.bytedance.sdk.openadsdk.api.C6280bl;
import com.bytedance.sdk.openadsdk.api.plugin.C6325n;
import com.bytedance.sdk.openadsdk.live.C6424a;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.MediationManagerVisitor;
import com.umeng.analytics.pro.CoreProtocolImpl;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    /* renamed from: a */
    private static TTAdConfig f22344a;

    /* renamed from: ok */
    private static final AbstractC6281ok f22345ok = new C6325n();

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface Callback extends InitCallback {
    }

    @Deprecated
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InitCallback {
        void fail(int i, String str);

        void success();
    }

    public static TTAdManager getAdManager() {
        AbstractC6281ok abstractC6281ok = f22345ok;
        if (abstractC6281ok != null) {
            return abstractC6281ok.mo36592a();
        }
        return null;
    }

    public static void getCodeGroupRit(final long j, final TTCodeGroupRit.TTCodeGroupRitListener tTCodeGroupRitListener) {
        AbstractC6281ok abstractC6281ok = f22345ok;
        if (abstractC6281ok != null) {
            abstractC6281ok.mo36592a().register(new CodeGroupRitObject() { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.1
                @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
                public long getCodeGroupId() {
                    return j;
                }

                @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
                public TTCodeGroupRit.TTCodeGroupRitListener getListener() {
                    return tTCodeGroupRitListener;
                }
            });
        } else if (tTCodeGroupRitListener != null) {
            tTCodeGroupRitListener.onFail(CoreProtocolImpl.C13167a.f38402d, "please init sdk first!");
        }
    }

    public static IMediationManager getMediationManager() {
        if (f22345ok != null) {
            return MediationManagerVisitor.getInstance().getMediationManager();
        }
        return null;
    }

    public static boolean init(Context context, TTAdConfig tTAdConfig) {
        f22344a = tTAdConfig;
        m36795ok(context, tTAdConfig);
        return true;
    }

    @Deprecated
    public static boolean isInitSuccess() {
        AbstractC6281ok abstractC6281ok = f22345ok;
        if (abstractC6281ok != null) {
            return abstractC6281ok.mo36587ok();
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
        AbstractC6281ok abstractC6281ok = f22345ok;
        if (abstractC6281ok != null) {
            return abstractC6281ok.mo36587ok();
        }
        return false;
    }

    /* renamed from: ok */
    private static void m36795ok(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            C6280bl.m36768ok();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            C6280bl.m36766ok("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        m36794ok(context, "Context is null, please check.");
        m36794ok(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    public static void start(Callback callback) {
        m36794ok(f22344a, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        AbstractC6281ok abstractC6281ok = f22345ok;
        if (abstractC6281ok == null) {
            callback.fail(CoreProtocolImpl.C13167a.f38402d, "Load initializer failed");
        } else {
            abstractC6281ok.m36759ok(TTAppContextHolder.getContext(), f22344a, callback);
        }
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        AbstractC6281ok.AbstractC6284bl mo36592a;
        if (tTAdConfig == null || (mo36592a = f22345ok.mo36592a()) == null) {
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
        mo36592a.getExtra(ValueSet.class, bundle);
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        if (tTAdConfig == null) {
            return;
        }
        C6424a.m36314ok().m36311ok(tTAdConfig.getInjectionAuth());
    }

    public static void updatePaid(boolean z) {
        AbstractC6281ok.AbstractC6284bl mo36592a = f22345ok.mo36592a();
        if (mo36592a == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        mo36592a.getExtra(ValueSet.class, bundle);
    }

    /* renamed from: ok */
    private static void m36794ok(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
