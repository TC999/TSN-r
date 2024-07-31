package com.mbridge.msdk.mbjscommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;

/* renamed from: com.mbridge.msdk.mbjscommon.webEnvCheck.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MBWebViewChecker {

    /* renamed from: a */
    private static volatile Boolean f31531a;

    /* renamed from: b */
    private static volatile Handler f31532b;

    /* renamed from: c */
    private static Boolean f31533c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m21403c(Context context) {
        WebView webView;
        try {
            webView = new WebView(context);
        } catch (Exception unused) {
            webView = null;
        }
        return webView != null;
    }

    /* renamed from: a */
    public static boolean m21406a(final Context context) {
        Setting setting;
        try {
            setting = SettingManager.m23261a().m23241g(MBSDKContext.m22865f().m22860k());
        } catch (Exception unused) {
            setting = null;
        }
        if (setting != null) {
            f31533c = Boolean.valueOf(setting.m23332d());
        } else {
            f31533c = Boolean.FALSE;
        }
        Boolean bool = f31533c;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f31531a == null) {
                try {
                    f31531a = Boolean.valueOf(m21403c(context));
                } catch (Exception unused2) {
                    f31531a = Boolean.FALSE;
                }
            }
            if (f31531a == null) {
                f31531a = new Boolean(false);
            }
            return f31531a.booleanValue();
        }
        if (f31531a == null && f31532b == null) {
            f31532b = new Handler(Looper.getMainLooper());
            f31532b.post(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.webEnvCheck.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (MBWebViewChecker.f31531a == null) {
                        try {
                            Boolean unused3 = MBWebViewChecker.f31531a = Boolean.valueOf(MBWebViewChecker.m21403c(context));
                        } catch (Exception unused4) {
                            Boolean unused5 = MBWebViewChecker.f31531a = Boolean.FALSE;
                        }
                    }
                }
            });
        }
        if (f31531a == null) {
            return true;
        }
        return f31531a.booleanValue();
    }
}
