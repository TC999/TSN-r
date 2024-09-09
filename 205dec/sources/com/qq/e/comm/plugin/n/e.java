package com.qq.e.comm.plugin.n;

import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.i.u;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o.a;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Comparator<ApkDownloadTask> {
        a(e eVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ApkDownloadTask apkDownloadTask, ApkDownloadTask apkDownloadTask2) {
            int i4 = (apkDownloadTask.e() > apkDownloadTask2.e() ? 1 : (apkDownloadTask.e() == apkDownloadTask2.e() ? 0 : -1));
            if (i4 > 0) {
                return -1;
            }
            return i4 < 0 ? 1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f44721a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f44722b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ GDTAppDialogClickListener f44723c;

        b(e eVar, int i4, ApkDownloadTask apkDownloadTask, GDTAppDialogClickListener gDTAppDialogClickListener) {
            this.f44721a = i4;
            this.f44722b = apkDownloadTask;
            this.f44723c = gDTAppDialogClickListener;
        }

        @Override // com.qq.e.comm.plugin.o.a.b
        public void a() {
            this.f44723c.onButtonClick(2);
            v.a(1130031, new com.qq.e.comm.plugin.n0.c().a(this.f44722b.a()), Integer.valueOf(this.f44721a));
        }

        @Override // com.qq.e.comm.plugin.o.a.b
        public void b() {
            if (this.f44721a == 2) {
                com.qq.e.comm.plugin.n0.w.b.a(this.f44722b.r()).f41953i = 4;
                u.c(this.f44722b);
            } else {
                com.qq.e.comm.plugin.n0.w.b.a(this.f44722b.r()).f41948d = 4;
                d.b(this.f44722b);
            }
            this.f44723c.onButtonClick(1);
            v.a(1130030, new com.qq.e.comm.plugin.n0.c().a(this.f44722b.a()), Integer.valueOf(this.f44721a));
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private static final e f44724a = new e(null);
    }

    /* synthetic */ e(a aVar) {
        this();
    }

    private int a() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("cnic", 3);
    }

    public static e b() {
        return c.f44724a;
    }

    private int c() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("iooao", 2);
    }

    private e() {
    }

    private static boolean b(ApkDownloadTask apkDownloadTask, int i4) {
        int o4 = apkDownloadTask.o();
        return (i4 & 2) != 0 && (o4 == 1 || o4 == 8) && com.qq.e.comm.plugin.apkmanager.x.b.b(com.qq.e.comm.plugin.d0.a.d().a(), apkDownloadTask.r()) && !u.a(apkDownloadTask.r());
    }

    public int a(GDTAppDialogClickListener gDTAppDialogClickListener) {
        int i4;
        v.a(1130028, new com.qq.e.comm.plugin.n0.c());
        if (gDTAppDialogClickListener == null) {
            GDTLogger.e("showOpenOrInstallAppDialog\u4f20\u5165\u7684listener\u53c2\u6570\u4e3anull");
            return 0;
        }
        int a4 = a();
        if (a4 <= 0) {
            return 0;
        }
        List<ApkDownloadTask> b4 = k.e().b();
        if (d.a(b4)) {
            return 0;
        }
        a(b4, a4);
        Collections.sort(b4, new a(this));
        ApkDownloadTask apkDownloadTask = null;
        for (ApkDownloadTask apkDownloadTask2 : b4) {
            d1.a("retain hint task:" + apkDownloadTask2.toString(), new Object[0]);
            if (!d.c(apkDownloadTask2) && !apkDownloadTask2.y()) {
                if (c() == 1) {
                    if (a(apkDownloadTask2, a4)) {
                        apkDownloadTask = apkDownloadTask2;
                        i4 = 1;
                        break;
                    } else if (b(apkDownloadTask2, a4)) {
                        i4 = 2;
                        apkDownloadTask = apkDownloadTask2;
                        break;
                    }
                } else if (b(apkDownloadTask2, a4)) {
                    i4 = 2;
                    apkDownloadTask = apkDownloadTask2;
                    break;
                } else if (a(apkDownloadTask2, a4)) {
                    apkDownloadTask = apkDownloadTask2;
                    i4 = 1;
                    break;
                }
            }
        }
        i4 = 0;
        if (apkDownloadTask == null) {
            return 0;
        }
        apkDownloadTask.a(true);
        k.e().d(apkDownloadTask);
        a(apkDownloadTask, i4, gDTAppDialogClickListener);
        return i4;
    }

    private void a(List<ApkDownloadTask> list, int i4) {
        boolean z3 = true;
        for (ApkDownloadTask apkDownloadTask : list) {
            if (b(apkDownloadTask, i4) || a(apkDownloadTask, i4)) {
                if (!apkDownloadTask.y() && !d.c(apkDownloadTask)) {
                    z3 = false;
                }
            }
        }
        if (z3) {
            for (ApkDownloadTask apkDownloadTask2 : list) {
                apkDownloadTask2.a(false);
                k.e().d(apkDownloadTask2);
            }
        }
    }

    private static boolean a(ApkDownloadTask apkDownloadTask, int i4) {
        return (i4 & 1) != 0 && apkDownloadTask.o() == 8 && com.qq.e.comm.plugin.apkmanager.x.b.d(apkDownloadTask) && !com.qq.e.comm.plugin.apkmanager.x.b.b(com.qq.e.comm.plugin.d0.a.d().a(), apkDownloadTask.r()) && com.qq.e.comm.plugin.apkmanager.x.b.a(d.a(apkDownloadTask), apkDownloadTask.r(), com.qq.e.comm.plugin.d0.a.d().a());
    }

    private void a(ApkDownloadTask apkDownloadTask, int i4, GDTAppDialogClickListener gDTAppDialogClickListener) {
        String str;
        String str2;
        String p3 = apkDownloadTask.p();
        if (i4 == 1) {
            Object[] objArr = new Object[1];
            if (TextUtils.isEmpty(p3)) {
                p3 = "\u5e94\u7528";
            }
            objArr[0] = p3;
            str = String.format("\u60a8\u5df2\u4e0b\u8f7d\"%s\"\u73b0\u5728\u8981\u5b89\u88c5\u5417\uff1f", objArr);
            str2 = "\u5b89\u88c5";
        } else if (i4 == 2) {
            Object[] objArr2 = new Object[1];
            if (TextUtils.isEmpty(p3)) {
                p3 = "\u5e94\u7528";
            }
            objArr2[0] = p3;
            str = String.format("\u60a8\u5df2\u5b89\u88c5\"%s\"\u73b0\u5728\u8981\u6253\u5f00\u5417\uff1f", objArr2);
            str2 = "\u6253\u5f00";
        } else {
            str = "";
            str2 = "\u786e\u5b9a";
        }
        v.a(1130029, new com.qq.e.comm.plugin.n0.c().a(apkDownloadTask.a()), Integer.valueOf(i4));
        com.qq.e.comm.plugin.o.a.a(str, str2, "\u53d6\u6d88", new b(this, i4, apkDownloadTask, gDTAppDialogClickListener));
    }
}
