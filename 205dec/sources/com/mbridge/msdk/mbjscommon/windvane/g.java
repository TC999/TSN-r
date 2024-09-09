package com.mbridge.msdk.mbjscommon.windvane;

import android.content.Context;
import java.util.HashMap;

/* compiled from: WindVaneApiManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Class> f40346a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Context f40347b;

    /* renamed from: c  reason: collision with root package name */
    private Object f40348c;

    /* renamed from: d  reason: collision with root package name */
    private WindVaneWebView f40349d;

    public g(Context context, WindVaneWebView windVaneWebView) {
        this.f40347b = context;
        this.f40349d = windVaneWebView;
        a(MvBridge.class);
        try {
            a((Class) Class.forName("com.mbridge.msdk.offerwall.jscommon.OfferWall"));
        } catch (ClassNotFoundException unused) {
        }
        try {
            a((Class) Class.forName("com.mbridge.msdk.interstitial.jscommon.interstitial"));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            a((Class) Class.forName("com.mbridge.msdk.video.js.bridge.RewardJs"));
        } catch (ClassNotFoundException unused3) {
        }
        try {
            a((Class) Class.forName("com.mbridge.msdk.video.js.bridge.VideoBridge"));
        } catch (ClassNotFoundException unused4) {
        }
        try {
            a((Class) Class.forName("com.mbridge.msdk.mbjscommon.confirmation.bridge.ConfirmationJsBridgePlugin"));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            a((Class) Class.forName("com.mbridge.msdk.mbjscommon.authority.jscommon.PrivateAuthorityJSBridge"));
        } catch (ClassNotFoundException unused5) {
        }
        try {
            a((Class) Class.forName("com.mbridge.msdk.interactiveads.jscommon.Interactive"));
        } catch (ClassNotFoundException unused6) {
        }
        try {
            a((Class) Class.forName("com.mbridge.msdk.mbjscommon.mraid.MraidJSBridge"));
        } catch (ClassNotFoundException unused7) {
        }
        try {
            a((Class) Class.forName("com.mbridge.msdk.mbjscommon.bridge.BannerJSPlugin"));
        } catch (ClassNotFoundException unused8) {
        }
        try {
            a((Class) Class.forName("com.mbridge.msdk.splash.js.SplashJs"));
        } catch (ClassNotFoundException unused9) {
        }
        try {
            a((Class) Class.forName("com.mbridge.msdk.mbjscommon.webEnvCheck.WebGLCheckjs"));
        } catch (ClassNotFoundException unused10) {
        }
    }

    public final void a(Context context) {
        this.f40347b = context;
    }

    public final void a(Object obj) {
        this.f40348c = obj;
    }

    private Object a(String str, WindVaneWebView windVaneWebView, Context context) {
        Class cls = f40346a.get(str);
        if (cls != null) {
            try {
                if (j.class.isAssignableFrom(cls)) {
                    j jVar = (j) cls.newInstance();
                    jVar.initialize(context, windVaneWebView);
                    jVar.initialize(this.f40348c, windVaneWebView);
                    return jVar;
                }
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public final void a(Class cls) {
        if (f40346a == null) {
            f40346a = new HashMap<>();
        }
        f40346a.put(cls.getSimpleName(), cls);
    }

    public final Object a(String str) {
        if (f40346a == null) {
            f40346a = new HashMap<>();
        }
        return a(str, this.f40349d, this.f40347b);
    }
}
