package com.qq.e.comm.plugin.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.o.a;
import com.qq.e.comm.plugin.util.a1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.i2;
import com.qq.e.comm.plugin.util.p;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.x1;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f44194a = {"tbopen://m.taobao.com", "taobao://m.taobao.com"};

    /* renamed from: b  reason: collision with root package name */
    private static long f44195b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements p.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f44196a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f44197b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicLong f44198c;

        a(boolean z3, ApkDownloadTask apkDownloadTask, AtomicLong atomicLong) {
            this.f44196a = z3;
            this.f44197b = apkDownloadTask;
            this.f44198c = atomicLong;
        }

        @Override // com.qq.e.comm.plugin.util.p.i
        public void a() {
            com.qq.e.comm.plugin.n0.v.a(1100921, null, 3);
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean b() {
            return true;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean c() {
            if (this.f44196a) {
                com.qq.e.comm.plugin.n0.w.b.a(4002016, this.f44197b, this.f44198c.get());
            }
            com.qq.e.comm.plugin.n0.v.a(1100921, null, 1);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f44199a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f44200b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f44201c;

        b(int i4, Context context, ApkDownloadTask apkDownloadTask) {
            this.f44199a = i4;
            this.f44200b = context;
            this.f44201c = apkDownloadTask;
        }

        @Override // com.qq.e.comm.plugin.o.a.b
        public void a() {
            com.qq.e.comm.plugin.n0.v.a(1100917, null, Integer.valueOf(this.f44199a));
        }

        @Override // com.qq.e.comm.plugin.o.a.b
        public void b() {
            com.qq.e.comm.plugin.n0.v.a(1100916, null, Integer.valueOf(this.f44199a));
            u.b(this.f44200b, this.f44201c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements p.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f44202a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f44203b;

        c(ApkDownloadTask apkDownloadTask, Context context) {
            this.f44202a = apkDownloadTask;
            this.f44203b = context;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean b() {
            boolean a4 = u.a(this.f44202a.r());
            d1.a("open opt onForeground is:" + this.f44202a.r() + " launched:" + a4, new Object[0]);
            if (a4) {
                return true;
            }
            boolean a5 = u.a();
            d1.a("open opt background to foreground dialog:" + a5, new Object[0]);
            com.qq.e.comm.plugin.n0.w.b.a(this.f44202a.r()).f41953i = 3;
            u.b(this.f44203b, this.f44202a, a5, 3);
            return true;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean c() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f44204c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f44205d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f44206e;

        d(long j4, ApkDownloadTask apkDownloadTask, Context context) {
            this.f44204c = j4;
            this.f44205d = apkDownloadTask;
            this.f44206e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a("open opt delay open app:" + this.f44204c, new Object[0]);
            if (System.currentTimeMillis() - u.f44195b < this.f44204c / 3) {
                d1.a("open opt delay return:" + u.f44195b, new Object[0]);
                return;
            }
            long unused = u.f44195b = System.currentTimeMillis();
            com.qq.e.comm.plugin.n0.w.b.a(this.f44205d.r()).f41953i = 6;
            u.b(this.f44206e, this.f44205d, true, 4);
        }
    }

    private static boolean c() {
        return !com.qq.e.comm.plugin.m0.b.a("soate") && com.qq.e.comm.plugin.t.c.a("alaai", "APP", "", 1) == 1;
    }

    private static boolean d() {
        return com.qq.e.comm.plugin.t.c.a("oabd", "APP", "", 0) == 1;
    }

    private static boolean e() {
        return com.qq.e.comm.plugin.t.c.a("oabfd", "APP", "", 0) == 1;
    }

    private static boolean f() {
        return com.qq.e.comm.plugin.t.c.a("oafd", "APP", "", 0) == 1;
    }

    public static boolean g() {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("oappo", 1);
        if (a4 == 1) {
            return true;
        }
        return a4 != 0 && com.qq.e.comm.plugin.t.a.b().a(String.valueOf(a4), 1) == 1;
    }

    static /* synthetic */ boolean a() {
        return e();
    }

    public static Intent b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent();
        intent.setData(parse);
        intent.setAction("android.intent.action.VIEW");
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    private static void d(ApkDownloadTask apkDownloadTask) {
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        if (com.qq.e.comm.plugin.util.p.b().c()) {
            boolean f4 = f();
            d1.a("open opt foreground is show dialog:" + f4, new Object[0]);
            b(a4, apkDownloadTask, f4, 1);
            return;
        }
        com.qq.e.comm.plugin.util.k.a();
        boolean d4 = d();
        b(a4, apkDownloadTask, d4, 2);
        boolean c4 = com.qq.e.comm.plugin.util.p.b().c();
        d1.a("open opt background is show dialog:" + d4 + " foreground:" + c4, new Object[0]);
        if (c4) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            c(a4, apkDownloadTask);
        } else {
            d(a4, apkDownloadTask);
        }
    }

    private static void c(Context context, ApkDownloadTask apkDownloadTask) {
        long a4 = com.qq.e.comm.plugin.d0.a.d().f().a("oappdt", 0) * 1000;
        if (a4 <= 0) {
            return;
        }
        d1.a("open opt start delay:" + a4, new Object[0]);
        p0.a(new d(a4, apkDownloadTask, context), a4);
    }

    public static void a(Intent intent, String str, String str2, boolean z3) {
        int a4;
        if (intent != null) {
            if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || (a4 = com.qq.e.comm.plugin.t.c.a("oaoiafc", "", 0, com.qq.e.comm.plugin.t.a.b().a())) == 0) {
                return;
            }
            int i4 = a4 % 10;
            int i5 = a4 / 10;
            boolean z4 = TextUtils.equals("com.taobao.taobao", str) || x1.b(str2, f44194a);
            if (!z3 || (i4 != 2 && (i4 != 1 || !z4))) {
                if (z3) {
                    return;
                }
                if (i5 != 2 && (i5 != 1 || !z4)) {
                    return;
                }
            }
            intent.addFlags(805339136);
            d1.a("Intent\u6210\u529f\u6dfb\u52a0Flag", new Object[0]);
        }
    }

    public static void c(ApkDownloadTask apkDownloadTask) {
        b(com.qq.e.comm.plugin.d0.a.d().a(), apkDownloadTask);
    }

    public static boolean b(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e4) {
                com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(9120011);
                com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
                dVar.a("ot", e4.toString());
                eVar.a(dVar);
                com.qq.e.comm.plugin.n0.v.a(eVar);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, ApkDownloadTask apkDownloadTask) {
        String f4 = apkDownloadTask.f();
        boolean c4 = i2.c(f4);
        com.qq.e.comm.plugin.n0.c a4 = com.qq.e.comm.plugin.n0.c.a(apkDownloadTask.v());
        if (c4) {
            com.qq.e.comm.plugin.n0.w.b.a(4002014, apkDownloadTask, 0L);
        } else {
            com.qq.e.comm.plugin.n0.v.a(1100515, a4);
        }
        AtomicLong atomicLong = new AtomicLong(0L);
        if (!com.qq.e.comm.plugin.util.p.b().a((p.i) new a(c4, apkDownloadTask, atomicLong))) {
            com.qq.e.comm.plugin.n0.v.a(1100921, null, 2);
        }
        atomicLong.set(System.currentTimeMillis());
        if (!b(context, a(context, apkDownloadTask.r(), f4)) && !b(context, a(context, apkDownloadTask.r()))) {
            com.qq.e.comm.plugin.apkmanager.x.d.a(apkDownloadTask, false);
            if (c4) {
                com.qq.e.comm.plugin.n0.w.b.a(4002024, apkDownloadTask, 0L);
            } else {
                com.qq.e.comm.plugin.n0.v.a(1100517, a4);
            }
            return false;
        }
        com.qq.e.comm.plugin.apkmanager.x.d.a(apkDownloadTask, true);
        if (c4) {
            com.qq.e.comm.plugin.n0.w.b.a(4002015, apkDownloadTask, 0L);
        } else {
            com.qq.e.comm.plugin.n0.v.a(1100516, a4);
        }
        if (c4 && !a(apkDownloadTask, 4)) {
            com.qq.e.comm.plugin.l0.a.a(apkDownloadTask.c());
        }
        return true;
    }

    private static void d(Context context, ApkDownloadTask apkDownloadTask) {
        com.qq.e.comm.plugin.util.p.b().a(new c(apkDownloadTask, context));
    }

    public static Intent a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.qq.e.comm.plugin.d0.a.d().f().a("ecglifp", 1) == 1) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268435456);
            }
            return launchIntentForPackage;
        }
        return null;
    }

    public static Intent a(Context context, String str, String str2) {
        Intent b4 = i2.c(str2) ? b(context, str2) : null;
        Intent intent = a(context, b4) != null ? b4 : null;
        return intent == null ? a(context, str) : intent;
    }

    static ResolveInfo a(Context context, Intent intent) {
        if (context == null || intent == null) {
            return null;
        }
        return context.getPackageManager().resolveActivity(intent, 65536);
    }

    public static boolean a(String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        int i4 = a4.getApplicationInfo().targetSdkVersion;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            return true;
        }
        try {
            if (i5 >= 29 && i4 >= 29) {
                File parentFile = a4.getExternalFilesDir(null).getParentFile();
                String parent = parentFile != null ? parentFile.getParent() : null;
                file = new File(parent + File.separator + str);
            } else {
                String path = Environment.getExternalStorageDirectory().getPath();
                file = new File(path, "android/data/" + str);
            }
        } catch (Exception e4) {
            d1.a("open opt error", e4);
        }
        if (file.exists()) {
            long lastModified = file.lastModified();
            if (com.qq.e.comm.plugin.util.o.b()) {
                PackageInfo packageInfo = a4.getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    if (packageInfo.lastUpdateTime < lastModified) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, ApkDownloadTask apkDownloadTask, boolean z3, int i4) {
        com.qq.e.comm.plugin.n0.v.a(1100925, null, Integer.valueOf(i4));
        if (z3) {
            com.qq.e.comm.plugin.n0.v.a(1100915, null, Integer.valueOf(i4));
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(apkDownloadTask.p()) ? "\u5e94\u7528" : apkDownloadTask.p();
            com.qq.e.comm.plugin.o.a.a(String.format("%s\u5df2\u5b89\u88c5\u5b8c\u6210\uff0c\u662f\u5426\u7acb\u5373\u6253\u5f00\uff1f", objArr), new b(i4, context, apkDownloadTask));
            return;
        }
        b(context, apkDownloadTask);
    }

    public static void a(ApkDownloadTask apkDownloadTask) {
        if (apkDownloadTask != null && c()) {
            b(apkDownloadTask);
        }
    }

    private static void b(ApkDownloadTask apkDownloadTask) {
        if (g()) {
            d(apkDownloadTask);
        } else {
            c(apkDownloadTask);
        }
    }

    public static boolean a(ApkDownloadTask apkDownloadTask, int i4) {
        Object remove;
        if (apkDownloadTask == null) {
            return false;
        }
        String d4 = apkDownloadTask.d("launchParam");
        if (TextUtils.isEmpty(d4)) {
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(d4).optJSONObject("reportUrl");
            if (optJSONObject != null && (remove = optJSONObject.remove(String.valueOf(i4))) != null) {
                a1.a(remove.toString());
                return true;
            }
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
        return false;
    }
}
