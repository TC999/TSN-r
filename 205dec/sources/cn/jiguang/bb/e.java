package cn.jiguang.bb;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.ax.d;
import com.acse.ottn.c4;
import com.acse.ottn.f3;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f2554a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f2555b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f2556c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f2557d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f2558e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f2559f = "";

    /* renamed from: g  reason: collision with root package name */
    private static String f2560g = "";

    /* renamed from: h  reason: collision with root package name */
    private static String f2561h = "";

    public static String a(final Context context) {
        try {
            Object b4 = cn.jiguang.ax.d.b(context, 1019, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.bb.e.1
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return e.f2554a;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = e.f2554a = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    String t3 = cn.jiguang.ag.a.t(context);
                    if (TextUtils.isEmpty(t3)) {
                        return "";
                    }
                    String lowerCase = t3.toLowerCase();
                    if (lowerCase.contains("huawei")) {
                        return e.b();
                    }
                    if (lowerCase.contains("honor")) {
                        return e.c();
                    }
                    if (lowerCase.contains("xiaomi") || lowerCase.contains("blackshark")) {
                        return e.d();
                    }
                    if (lowerCase.contains("meizu")) {
                        return e.e();
                    }
                    if (lowerCase.contains("oppo") || lowerCase.contains("realme")) {
                        cn.jiguang.w.a.b("JRomVersionHelper", " getMethodValue getOppoVersion  ");
                        return e.f();
                    } else if (lowerCase.contains("vivo")) {
                        return e.g();
                    } else {
                        if (lowerCase.contains("oneplus")) {
                            return e.h();
                        }
                        return null;
                    }
                }
            });
            if (b4 instanceof String) {
                f2554a = (String) b4;
            }
        } catch (Throwable unused) {
        }
        return f2554a;
    }

    static /* synthetic */ String b() {
        return k();
    }

    private static String b(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod(f3.f5657f, String.class).invoke(cls, str);
            cn.jiguang.w.a.e("JRomVersionHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            cn.jiguang.w.a.h("JRomVersionHelper", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    static /* synthetic */ String c() {
        return i();
    }

    static /* synthetic */ String d() {
        return o();
    }

    static /* synthetic */ String e() {
        return n();
    }

    static /* synthetic */ String f() {
        return m();
    }

    static /* synthetic */ String g() {
        return l();
    }

    static /* synthetic */ String h() {
        return p();
    }

    private static String i() {
        if (TextUtils.isEmpty(f2561h)) {
            String b4 = b("ro.build.display.id");
            f2561h = b4;
            return b4;
        }
        return f2561h;
    }

    private static boolean j() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return c4.f5363a.equalsIgnoreCase((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable th) {
            cn.jiguang.w.a.b("JRomVersionHelper", "isHarmonyOS throwable=" + th);
            return false;
        }
    }

    private static String k() {
        String str;
        if (TextUtils.isEmpty(f2555b)) {
            if (j()) {
                f2555b = b("hw_sc.build.platform.version");
            }
            if (TextUtils.isEmpty(f2555b)) {
                str = b("ro.build.version.emui");
            } else {
                str = "harmony_os_" + f2555b;
            }
            f2555b = str;
            return f2555b;
        }
        return f2555b;
    }

    private static String l() {
        if (TextUtils.isEmpty(f2557d)) {
            String b4 = b("ro.vivo.os.build.display.id");
            f2557d = b4;
            return b4;
        }
        return f2557d;
    }

    private static String m() {
        if (TextUtils.isEmpty(f2556c)) {
            String b4 = b("ro.build.version.oplusrom");
            f2556c = b4;
            if (TextUtils.isEmpty(b4)) {
                f2556c = b("ro.build.version.opporom");
            }
            return f2556c;
        }
        return f2556c;
    }

    private static String n() {
        if (TextUtils.isEmpty(f2560g)) {
            String b4 = b("ro.build.display.id");
            f2560g = b4;
            return b4;
        }
        return f2560g;
    }

    private static String o() {
        if (TextUtils.isEmpty(f2559f)) {
            String b4 = b("ro.miui.ui.version.name");
            f2559f = b4;
            return b4;
        }
        return f2559f;
    }

    private static String p() {
        if (TextUtils.isEmpty(f2558e)) {
            String b4 = b("ro.rom.version");
            f2558e = b4;
            return b4;
        }
        return f2558e;
    }
}
