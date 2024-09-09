package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.an;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12391a = "PluginLoader";

    /* renamed from: b  reason: collision with root package name */
    private static ClassLoader f12392b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a();
    }

    public static void a(double d4, an.b bVar, a aVar) {
        s sVar = (s) c.a().a("remote_adserv").a();
        if (sVar != null) {
            sVar.startLoadRemotePhp(d4, bVar);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public static void b(int i4) {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.b(i4);
        }
    }

    public static Activity c() {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            return tVar.c();
        }
        return null;
    }

    public static boolean d() {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            return tVar.d();
        }
        return false;
    }

    public static boolean e() {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            return tVar.e();
        }
        return false;
    }

    public static boolean f() {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            return tVar.f();
        }
        az.c().e("\u672a\u80fd\u521d\u59cb\u5316\u5c0f\u8bf4sdk\uff0c\u8bf7\u68c0\u67e5\u5c0f\u8bf4\u5305\u548c\u5e7f\u544asdk\u662f\u5426\u5339\u914d");
        return false;
    }

    public static void g() {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.g();
        }
    }

    public static void h() {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.a();
        }
    }

    public static void b() {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.b();
        }
    }

    public static boolean a() {
        return co.f12660d.booleanValue();
    }

    public static ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        s sVar;
        if (a()) {
            if (f12392b == null && (sVar = (s) c.a().a("remote_adserv").a()) != null) {
                f12392b = sVar.getClassLoaderFromJar(str, str2, str3, classLoader);
            }
            return f12392b;
        }
        return classLoader;
    }

    public static void b(int i4, int i5) {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.a(i4, i5);
        }
    }

    public static void a(Context context, String str, String str2) {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.a(context, str, str2);
        }
    }

    public static void a(u uVar) {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.a(uVar);
        }
    }

    public static void a(int i4) {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.a(i4);
        }
    }

    public static void a(int i4, boolean z3) {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.a(i4, z3);
        }
    }

    public static View a(Context context) {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            return tVar.a(context);
        }
        return null;
    }

    public static void a(Context context, String str) {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.a(context, str);
        }
    }

    public static void a(boolean z3) {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.a(z3);
        }
    }

    public static void a(int i4, int i5) {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.b(i4, i5);
        }
    }

    public static void a(boolean z3, int i4, int i5, int i6) {
        t tVar = (t) c.a().a("remote_novel").a();
        if (tVar != null) {
            tVar.a(z3, i4, i5, i6);
        }
    }
}
