package com.mbridge.msdk.mbjscommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.mbridge.msdk.c.b;

/* compiled from: MBWebViewChecker.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Boolean f40303a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Handler f40304b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f40305c;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context) {
        WebView webView;
        try {
            webView = new WebView(context);
        } catch (Exception unused) {
            webView = null;
        }
        return webView != null;
    }

    public static boolean a(final Context context) {
        com.mbridge.msdk.c.a aVar;
        try {
            aVar = b.a().g(com.mbridge.msdk.foundation.controller.a.f().k());
        } catch (Exception unused) {
            aVar = null;
        }
        if (aVar != null) {
            f40305c = Boolean.valueOf(aVar.d());
        } else {
            f40305c = Boolean.FALSE;
        }
        Boolean bool = f40305c;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f40303a == null) {
                try {
                    f40303a = Boolean.valueOf(c(context));
                } catch (Exception unused2) {
                    f40303a = Boolean.FALSE;
                }
            }
            if (f40303a == null) {
                f40303a = new Boolean(false);
            }
            return f40303a.booleanValue();
        }
        if (f40303a == null && f40304b == null) {
            f40304b = new Handler(Looper.getMainLooper());
            f40304b.post(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.webEnvCheck.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.f40303a == null) {
                        try {
                            Boolean unused3 = a.f40303a = Boolean.valueOf(a.c(context));
                        } catch (Exception unused4) {
                            Boolean unused5 = a.f40303a = Boolean.FALSE;
                        }
                    }
                }
            });
        }
        if (f40303a == null) {
            return true;
        }
        return f40303a.booleanValue();
    }
}
