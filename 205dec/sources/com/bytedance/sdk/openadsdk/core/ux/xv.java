package com.bytedance.sdk.openadsdk.core.ux;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.yu;
import f0.a;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static a f35107c;

    public static void c(w wVar) {
        if (sr() == null) {
            com.bytedance.sdk.component.utils.a.w("ACL", "service is null");
            return;
        }
        com.bytedance.sdk.component.utils.a.w("ACL", "service is not null");
        c.c(wVar);
    }

    private static a sr() {
        if (f35107c == null) {
            f35107c = yu.c().ux();
        }
        return f35107c;
    }

    public static void ux(String str, String str2) {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.ux(str, str2);
    }

    public static void w(String str, String str2) {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.w(str, str2);
    }

    public static void xv(String str, String str2) {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.xv(str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.w(str, str2, th);
    }

    public static void xv() {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.w();
    }

    public static void sr(String str, String str2) {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.sr(str, str2);
    }

    public static void c() {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.c();
    }

    public static void w() {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.xv();
    }

    public static void c(int i4) {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.c(i4);
    }

    public static void c(String str, String str2) {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.c(str, str2);
    }

    public static void c(String str, String str2, Throwable th) {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.c(str, str2, th);
    }

    public static void c(String str, Throwable th) {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.w(str, th);
    }

    public static boolean c(Context context, JSONObject jSONObject) {
        a sr = sr();
        if (sr == null) {
            return false;
        }
        sr.b(context, jSONObject);
        return true;
    }

    public static void c(Context context, String str, String str2) {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.c(context, str, str2);
    }

    public static void c(String str) {
        a sr = sr();
        if (sr == null) {
            return;
        }
        sr.c(str);
    }
}
