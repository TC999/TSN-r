package com.mbridge.msdk.mbjscommon.windvane;

import android.content.Context;
import java.util.HashMap;

/* renamed from: com.mbridge.msdk.mbjscommon.windvane.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class WindVaneApiManager {

    /* renamed from: a */
    private static HashMap<String, Class> f31574a = new HashMap<>();

    /* renamed from: b */
    private Context f31575b;

    /* renamed from: c */
    private Object f31576c;

    /* renamed from: d */
    private WindVaneWebView f31577d;

    public WindVaneApiManager(Context context, WindVaneWebView windVaneWebView) {
        this.f31575b = context;
        this.f31577d = windVaneWebView;
        m21391a(MvBridge.class);
        try {
            m21391a((Class) Class.forName("com.mbridge.msdk.offerwall.jscommon.OfferWall"));
        } catch (ClassNotFoundException unused) {
        }
        try {
            m21391a((Class) Class.forName("com.mbridge.msdk.interstitial.jscommon.interstitial"));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            m21391a((Class) Class.forName("com.mbridge.msdk.video.js.bridge.RewardJs"));
        } catch (ClassNotFoundException unused3) {
        }
        try {
            m21391a((Class) Class.forName("com.mbridge.msdk.video.js.bridge.VideoBridge"));
        } catch (ClassNotFoundException unused4) {
        }
        try {
            m21391a((Class) Class.forName("com.mbridge.msdk.mbjscommon.confirmation.bridge.ConfirmationJsBridgePlugin"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            m21391a((Class) Class.forName("com.mbridge.msdk.mbjscommon.authority.jscommon.PrivateAuthorityJSBridge"));
        } catch (ClassNotFoundException unused5) {
        }
        try {
            m21391a((Class) Class.forName("com.mbridge.msdk.interactiveads.jscommon.Interactive"));
        } catch (ClassNotFoundException unused6) {
        }
        try {
            m21391a((Class) Class.forName("com.mbridge.msdk.mbjscommon.mraid.MraidJSBridge"));
        } catch (ClassNotFoundException unused7) {
        }
        try {
            m21391a((Class) Class.forName("com.mbridge.msdk.mbjscommon.bridge.BannerJSPlugin"));
        } catch (ClassNotFoundException unused8) {
        }
        try {
            m21391a((Class) Class.forName("com.mbridge.msdk.splash.js.SplashJs"));
        } catch (ClassNotFoundException unused9) {
        }
        try {
            m21391a((Class) Class.forName("com.mbridge.msdk.mbjscommon.webEnvCheck.WebGLCheckjs"));
        } catch (ClassNotFoundException unused10) {
        }
    }

    /* renamed from: a */
    public final void m21392a(Context context) {
        this.f31575b = context;
    }

    /* renamed from: a */
    public final void m21390a(Object obj) {
        this.f31576c = obj;
    }

    /* renamed from: a */
    private Object m21388a(String str, WindVaneWebView windVaneWebView, Context context) {
        Class cls = f31574a.get(str);
        if (cls != null) {
            try {
                if (WindVanePlugin.class.isAssignableFrom(cls)) {
                    WindVanePlugin windVanePlugin = (WindVanePlugin) cls.newInstance();
                    windVanePlugin.initialize(context, windVaneWebView);
                    windVanePlugin.initialize(this.f31576c, windVaneWebView);
                    return windVanePlugin;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void m21391a(Class cls) {
        if (f31574a == null) {
            f31574a = new HashMap<>();
        }
        f31574a.put(cls.getSimpleName(), cls);
    }

    /* renamed from: a */
    public final Object m21389a(String str) {
        if (f31574a == null) {
            f31574a = new HashMap<>();
        }
        return m21388a(str, this.f31577d, this.f31575b);
    }
}
