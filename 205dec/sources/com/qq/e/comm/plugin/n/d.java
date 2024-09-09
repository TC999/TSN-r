package com.qq.e.comm.plugin.n;

import android.text.TextUtils;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.c;
import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.apkmanager.n;
import com.qq.e.comm.plugin.i.u;
import com.qq.e.comm.plugin.n0.h;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.a1;
import com.qq.e.comm.plugin.util.b2;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final b2 f44718a = new b2(Math.max(com.qq.e.comm.plugin.d0.a.d().f().a("downloaded_not_installed_limit_num", 2048), 5));

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f44719a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f44720b;

        a(ApkDownloadTask apkDownloadTask, ApkDownloadTask apkDownloadTask2) {
            this.f44719a = apkDownloadTask;
            this.f44720b = apkDownloadTask2;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public void a(int i4, String str, boolean z3) {
            if (i4 != 0 || this.f44719a == null) {
                return;
            }
            d1.a("ApkInstallWorker tip install SUCCESS", new Object[0]);
            JSONObject l4 = this.f44719a.l();
            if (l4 != null) {
                try {
                    JSONObject optJSONObject = l4.optJSONObject("reportUrl");
                    String optString = optJSONObject == null ? null : optJSONObject.optString(String.valueOf(2));
                    if (TextUtils.isEmpty(optString)) {
                        com.qq.e.comm.plugin.apkmanager.x.a.a(this.f44719a, true);
                    } else {
                        a1.a(optString + "&tips_install=1", true, null);
                    }
                } catch (Exception e4) {
                    d1.a("\u5b89\u88c5\u8f6c\u5316\u4e0a\u62a5\u9519\u8bef", e4);
                    com.qq.e.comm.plugin.apkmanager.x.a.a(this.f44719a, true);
                }
            } else {
                com.qq.e.comm.plugin.apkmanager.x.a.a(this.f44719a, true);
            }
            com.qq.e.comm.plugin.n0.w.b.a(this.f44720b.r()).f41953i = 5;
            u.a(this.f44720b);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public boolean a() {
            return true;
        }
    }

    public static boolean a(long j4, long j5, ApkDownloadTask apkDownloadTask) {
        h hVar = new h(2020035);
        long j6 = j5 - j4;
        hVar.b(j6);
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        cVar.a(apkDownloadTask.a());
        hVar.a(cVar);
        v.a(hVar);
        return j6 >= ((long) com.qq.e.comm.plugin.d0.a.d().f().a("apk_downloaded_inter_time", 43200000));
    }

    public static void b(List<ApkDownloadTask> list) {
        boolean z3;
        int i4 = 0;
        while (true) {
            if (i4 >= list.size()) {
                z3 = true;
                break;
            } else if (!list.get(i4).y()) {
                z3 = false;
                break;
            } else {
                i4++;
            }
        }
        if (z3) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                ApkDownloadTask apkDownloadTask = list.get(i5);
                apkDownloadTask.a(false);
                k.e().d(apkDownloadTask);
            }
        }
    }

    public static boolean c(ApkDownloadTask apkDownloadTask) {
        return System.currentTimeMillis() - apkDownloadTask.e() >= ((long) com.qq.e.comm.plugin.d0.a.d().f().a("apk_downloaded_time", 172800000));
    }

    public static boolean d() {
        return f44718a.b();
    }

    public static com.qq.e.comm.plugin.n.a d(ApkDownloadTask apkDownloadTask) {
        return new com.qq.e.comm.plugin.n.a(apkDownloadTask.r(), apkDownloadTask.u(), apkDownloadTask.g(), apkDownloadTask.p(), apkDownloadTask.k(), apkDownloadTask);
    }

    private static void c() {
        List<ApkDownloadTask> c4;
        if (com.qq.e.comm.plugin.d0.a.d().f().a("aiirc", 1) == 0 || (c4 = k.e().c()) == null || c4.isEmpty()) {
            return;
        }
        for (ApkDownloadTask apkDownloadTask : c4) {
            if (!c(apkDownloadTask)) {
                String r3 = apkDownloadTask.r();
                if (com.qq.e.comm.plugin.apkmanager.x.b.b(com.qq.e.comm.plugin.d0.a.d().a(), r3)) {
                    k.e().a(r3, 1);
                    com.qq.e.comm.plugin.apkmanager.x.a.c(apkDownloadTask);
                    com.qq.e.comm.plugin.n0.w.b.a(r3).f41948d = 11;
                    com.qq.e.comm.plugin.n0.w.b.a(4001011, apkDownloadTask, 1, 0);
                    com.qq.e.comm.plugin.apkmanager.x.d.c(1100906, apkDownloadTask);
                }
            }
        }
    }

    public static boolean a(List<ApkDownloadTask> list) {
        return list == null || list.size() == 0;
    }

    public static File a(ApkDownloadTask apkDownloadTask) {
        return com.qq.e.comm.plugin.apkmanager.x.b.b(apkDownloadTask);
    }

    public static void a() {
        c();
        b();
    }

    public static void b(ApkDownloadTask apkDownloadTask) {
        n nVar = new n(com.qq.e.comm.plugin.d0.a.d().a(), apkDownloadTask);
        nVar.a(new a(apkDownloadTask, apkDownloadTask));
        File a4 = a(apkDownloadTask);
        if (a4 != null) {
            nVar.a(a4);
        }
    }

    private static void b() {
        List<ApkDownloadTask> d4 = k.e().d();
        if (d4 == null || d4.isEmpty()) {
            return;
        }
        for (ApkDownloadTask apkDownloadTask : d4) {
            if (!c(apkDownloadTask)) {
                String r3 = apkDownloadTask.r();
                if (com.qq.e.comm.plugin.apkmanager.w.d.d(com.qq.e.comm.plugin.apkmanager.w.b.a().d(com.qq.e.comm.plugin.d0.a.d().a(), r3))) {
                    k.e().a(r3, 8);
                    com.qq.e.comm.plugin.apkmanager.x.a.a(apkDownloadTask);
                    v.a(1100934, (com.qq.e.comm.plugin.n0.c) null);
                }
            }
        }
    }
}
