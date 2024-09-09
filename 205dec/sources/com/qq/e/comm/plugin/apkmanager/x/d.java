package com.qq.e.comm.plugin.apkmanager.x;

import android.text.TextUtils;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.c;
import com.qq.e.comm.plugin.n0.h;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.q0;
import com.qq.e.comm.plugin.util.u1;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends com.qq.e.comm.plugin.n0.w.b {

    /* renamed from: b  reason: collision with root package name */
    private static final long f41942b = (((com.qq.e.comm.plugin.d0.a.d().f().a("appito", "", 15) * 1000) * 60) * 60) * 24;

    public static void c(int i4, ApkDownloadTask apkDownloadTask) {
        b(i4, apkDownloadTask, b(apkDownloadTask.r()));
    }

    public static boolean d() {
        long a4 = u1.a("app_installed_time", 0L);
        return a4 != 0 && System.currentTimeMillis() - a4 < f41942b;
    }

    public static boolean e() {
        return u1.a("haingogd", false);
    }

    public static void f() {
        u1.b("ainsc", u1.a("ainsc", 0) + 1);
        u1.b("ainst", System.currentTimeMillis());
    }

    public static void g() {
        u1.b("haingogd", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        u1.b("app_installed_time", System.currentTimeMillis());
    }

    public static void i() {
        int i4 = ((((d() ? 1 : 2) * 10) + (c() ? 1 : 2)) * 10) + (e() ? 1 : 2);
        int b4 = b();
        if (b4 >= 100) {
            b4 = 100;
        }
        v.a(9200003, null, Integer.valueOf(i4), Integer.valueOf(b4), null);
    }

    public static void b(int i4, ApkDownloadTask apkDownloadTask, int i5) {
        v.a(i4, c(apkDownloadTask), Integer.valueOf(c(apkDownloadTask.r())), Integer.valueOf(i5), null);
    }

    public static void a(int i4, String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("msg", str);
        v.a(9130009, null, Integer.valueOf(i4), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.qq.e.comm.plugin.n0.c c(ApkDownloadTask apkDownloadTask) {
        return com.qq.e.comm.plugin.n0.c.a(apkDownloadTask.v());
    }

    private static int c(String str) {
        int a4 = e.a();
        if (TextUtils.isEmpty(str)) {
            return a4;
        }
        f a5 = com.qq.e.comm.plugin.n0.w.b.a(str);
        return a4 + (a5.f41950f * 10) + (a5.f41948d * 100);
    }

    public static void b(ApkDownloadTask apkDownloadTask, int i4, int i5, String str, long j4) {
        com.qq.e.comm.plugin.n0.c c4 = c(apkDownloadTask);
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("msg", str);
        dVar.a("url", apkDownloadTask.s());
        dVar.a("pkgName", apkDownloadTask.r());
        dVar.a("data", Long.valueOf(j4));
        v.a(9120021, c4, Integer.valueOf(i4), Integer.valueOf(i5), dVar);
    }

    public static void a(int i4, ApkDownloadTask apkDownloadTask) {
        if (apkDownloadTask == null) {
            apkDownloadTask = new ApkDownloadTask("");
        }
        a(i4, Integer.valueOf(apkDownloadTask.x() ? 1 : 0), apkDownloadTask);
    }

    private static boolean c() {
        long a4 = u1.a("ainst", 0L);
        if (a4 == 0) {
            return false;
        }
        if (System.currentTimeMillis() - a4 < f41942b) {
            return true;
        }
        if (u1.a("ainsc", 0) > 0) {
            u1.b("ainsc", 0);
        }
        return false;
    }

    public static void a(int i4, Integer num, ApkDownloadTask apkDownloadTask) {
        if (apkDownloadTask == null) {
            apkDownloadTask = new ApkDownloadTask("");
        }
        v.a(i4, c(apkDownloadTask), num, Integer.valueOf(b(apkDownloadTask.r())), null);
    }

    protected static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        f a4 = com.qq.e.comm.plugin.n0.w.b.a(str);
        return a4.f41953i + (a4.f41952h * 10) + (a4.f41951g * 100) + (a4.f41949e * 1000) + ((a4.f44821a ? 2 : 1) * 10000);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final c.a f41943a;

        /* renamed from: b  reason: collision with root package name */
        private final ApkDownloadTask f41944b;

        /* renamed from: c  reason: collision with root package name */
        private final long f41945c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final String f41946d;

        public a(ApkDownloadTask apkDownloadTask, c.a aVar) {
            this.f41943a = aVar;
            this.f41944b = apkDownloadTask;
            this.f41946d = apkDownloadTask.r();
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public void a(int i4, String str, boolean z3) {
            c.a aVar = this.f41943a;
            if (aVar != null) {
                aVar.a(i4, str, z3);
            }
            if (i4 == 0) {
                if (this.f41944b.b("appStore") == 0) {
                    d.h();
                    d.b(this.f41944b, this.f41946d);
                }
                d.c(1100906, this.f41944b);
                h hVar = new h(2030016);
                hVar.b((System.currentTimeMillis() - this.f41945c) / 1000);
                hVar.a(d.c(this.f41944b));
                v.a(hVar);
            }
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public boolean a() {
            c.a aVar = this.f41943a;
            return aVar != null && aVar.a();
        }
    }

    public static void a(String str, int i4, com.qq.e.comm.plugin.n0.c cVar) {
        v.a(i4, cVar, Integer.valueOf(com.qq.e.comm.plugin.n0.w.b.a(str).f41951g), Integer.valueOf(b(str)), null);
    }

    public static void a(ApkDownloadTask apkDownloadTask, boolean z3) {
        String r3 = apkDownloadTask.r();
        if (TextUtils.isEmpty(r3)) {
            return;
        }
        a(r3, c(apkDownloadTask), z3);
    }

    public static void a(String str, com.qq.e.comm.plugin.n0.c cVar, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        v.a(z3 ? 1100907 : 1100924, cVar, Integer.valueOf(c(str)), Integer.valueOf(b(str)), null);
    }

    public static int b() {
        return u1.a("ainsc", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void b(ApkDownloadTask apkDownloadTask, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("apksiw", "");
        if (TextUtils.isEmpty(b4)) {
            return;
        }
        String a4 = b.a(com.qq.e.comm.plugin.d0.a.d().a(), str);
        int i4 = 1;
        if (TextUtils.isEmpty(a4)) {
            v.a(9200015, null, 0, 1, new com.qq.e.comm.plugin.n0.d().a("pkgName", apkDownloadTask.r()));
        } else if (!TextUtils.equals(a4, com.qq.e.comm.plugin.d0.a.d().b().b())) {
            com.qq.e.comm.plugin.n0.c c4 = c(apkDownloadTask);
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("msg", a4);
            dVar.a("url", apkDownloadTask.s());
            dVar.a("pkgName", apkDownloadTask.r());
            String[] c5 = q0.c();
            if (c5 != null && c5.length > 0) {
                for (String str2 : c5) {
                    if (TextUtils.equals(str2, a4)) {
                        v.a(9200015, c4, 2, 2, dVar);
                        return;
                    }
                }
                i4 = 3;
            }
            String[] split = b4.split(":");
            if (split == null || split.length <= 0) {
                return;
            }
            if (TextUtils.isEmpty(split[0]) || !a4.contains(split[0])) {
                if (split.length < 2 || !split[2].contains(a4)) {
                    if (TextUtils.equals(a4, apkDownloadTask.r())) {
                        i4 = 4;
                    }
                    v.a(9200015, c4, Integer.valueOf(i4), 2, dVar);
                }
            }
        }
    }

    public static void a(int i4, String str, ApkDownloadTask apkDownloadTask, File file) {
        int length;
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("download_scene", Integer.valueOf(com.qq.e.comm.plugin.n0.w.b.a(apkDownloadTask.r()).f44822b));
        if ((i4 == 0 || i4 == 9) && file != null && file.exists() && (length = (int) (file.length() >> 10)) > 0) {
            dVar.a("as", Integer.valueOf(length));
        }
        if (!TextUtils.isEmpty(str)) {
            dVar.a("msg", str);
        } else if (i4 != 0) {
            dVar.a("msg", "code=" + i4);
        }
        v.a(i4 == 0 ? 1100903 : i4 == 7 ? 1100931 : i4 == 8 ? 1100932 : i4 == 9 ? 1100933 : 1100904, c(apkDownloadTask), Integer.valueOf(apkDownloadTask.x() ? 1 : 0), Integer.valueOf(b(apkDownloadTask.r())), dVar);
    }

    public static void a(ApkDownloadTask apkDownloadTask, int i4, int i5, String str, long j4) {
        com.qq.e.comm.plugin.n0.c c4 = c(apkDownloadTask);
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("msg", str);
        dVar.a("url", apkDownloadTask.s());
        dVar.a("pkgName", apkDownloadTask.r());
        dVar.a("data", Long.valueOf(j4));
        v.a(9120019, c4, Integer.valueOf(i5), Integer.valueOf(i4), dVar);
    }

    public static void a(ApkDownloadTask apkDownloadTask, int i4, String str) {
        com.qq.e.comm.plugin.n0.c c4 = c(apkDownloadTask);
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("msg", str);
        dVar.a("url", apkDownloadTask.s());
        dVar.a("pkgName", apkDownloadTask.r());
        v.a(1100938, c4, 0, Integer.valueOf(i4), dVar);
    }

    public static void a(ApkDownloadTask apkDownloadTask, long j4, long j5) {
        com.qq.e.comm.plugin.n0.c c4 = c(apkDownloadTask);
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("msg", Long.valueOf(j4));
        dVar.a("url", apkDownloadTask.s());
        dVar.a("pkgName", apkDownloadTask.r());
        dVar.a("data", Long.valueOf(j5));
        v.a(9120022, c4, 0, 0, dVar);
    }

    public static void a(ApkDownloadTask apkDownloadTask, int i4, int i5, int i6, com.qq.e.comm.plugin.n0.d dVar) {
        v.a(i4, c(apkDownloadTask), Integer.valueOf(i5), Integer.valueOf(i6), dVar);
    }
}
