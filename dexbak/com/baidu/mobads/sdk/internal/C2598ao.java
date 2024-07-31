package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.C2594an;
import com.baidu.mobads.sdk.internal.C2645c;

/* renamed from: com.baidu.mobads.sdk.internal.ao */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2598ao {

    /* renamed from: a */
    private static final String f8598a = "PluginLoader";

    /* renamed from: b */
    private static ClassLoader f8599b;

    /* renamed from: com.baidu.mobads.sdk.internal.ao$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2599a {
        /* renamed from: a */
        void mo50651a();
    }

    /* renamed from: a */
    public static void m50995a(double d, C2594an.InterfaceC2596b interfaceC2596b, InterfaceC2599a interfaceC2599a) {
        InterfaceC2722s interfaceC2722s = (InterfaceC2722s) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8795a).m50975a();
        if (interfaceC2722s != null) {
            interfaceC2722s.startLoadRemotePhp(d, interfaceC2596b);
        } else if (interfaceC2599a != null) {
            interfaceC2599a.mo50651a();
        }
    }

    /* renamed from: b */
    public static void m50983b(int i) {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50334b(i);
        }
    }

    /* renamed from: c */
    public static Activity m50981c() {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            return interfaceC2723t.m50332c();
        }
        return null;
    }

    /* renamed from: d */
    public static boolean m50980d() {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            return interfaceC2723t.m50331d();
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m50979e() {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            return interfaceC2723t.m50330e();
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m50978f() {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            return interfaceC2723t.m50329f();
        }
        C2607aw.m50919c().mo50864e("未能初始化小说sdk，请检查小说包和广告sdk是否匹配");
        return false;
    }

    /* renamed from: g */
    public static void m50977g() {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50328g();
        }
    }

    /* renamed from: h */
    public static void m50976h() {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50345a();
        }
    }

    /* renamed from: b */
    public static void m50984b() {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50335b();
        }
    }

    /* renamed from: a */
    public static boolean m50996a() {
        return C2659cl.f8840d.booleanValue();
    }

    /* renamed from: a */
    public static ClassLoader m50987a(String str, String str2, String str3, ClassLoader classLoader) {
        InterfaceC2722s interfaceC2722s;
        if (m50996a()) {
            if (f8599b == null && (interfaceC2722s = (InterfaceC2722s) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8795a).m50975a()) != null) {
                f8599b = interfaceC2722s.getClassLoaderFromJar(str, str2, str3, classLoader);
            }
            return f8599b;
        }
        return classLoader;
    }

    /* renamed from: b */
    public static void m50982b(int i, int i2) {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50343a(i, i2);
        }
    }

    /* renamed from: a */
    public static void m50989a(Context context, String str, String str2) {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50339a(context, str, str2);
        }
    }

    /* renamed from: a */
    public static void m50988a(InterfaceC2724u interfaceC2724u) {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50338a(interfaceC2724u);
        }
    }

    /* renamed from: a */
    public static void m50994a(int i) {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50344a(i);
        }
    }

    /* renamed from: a */
    public static void m50992a(int i, boolean z) {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50342a(i, z);
        }
    }

    /* renamed from: a */
    public static View m50991a(Context context) {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            return interfaceC2723t.m50341a(context);
        }
        return null;
    }

    /* renamed from: a */
    public static void m50990a(Context context, String str) {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50340a(context, str);
        }
    }

    /* renamed from: a */
    public static void m50986a(boolean z) {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50337a(z);
        }
    }

    /* renamed from: a */
    public static void m50993a(int i, int i2) {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50333b(i, i2);
        }
    }

    /* renamed from: a */
    public static void m50985a(boolean z, int i, int i2, int i3) {
        InterfaceC2723t interfaceC2723t = (InterfaceC2723t) C2645c.m50655a().m50654a(C2645c.InterfaceC2646a.f8796b).m50975a();
        if (interfaceC2723t != null) {
            interfaceC2723t.m50336a(z, i, i2, i3);
        }
    }
}
