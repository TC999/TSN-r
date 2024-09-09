package com.baidu.mobads.sdk.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.stub.StubApp;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class cb {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12588a = "ApkLoader";

    /* renamed from: b  reason: collision with root package name */
    protected static Thread.UncaughtExceptionHandler f12589b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f12590c = "__badApkVersion__9.35";

    /* renamed from: d  reason: collision with root package name */
    public static final String f12591d = "previousProxyVersion";

    /* renamed from: e  reason: collision with root package name */
    protected static final String f12592e = "__xadsdk__remote__final__";

    /* renamed from: f  reason: collision with root package name */
    protected static final String f12593f = "bdxadsdk.jar";

    /* renamed from: g  reason: collision with root package name */
    protected static final String f12594g = "__xadsdk__remote__final__builtin__.jar";

    /* renamed from: h  reason: collision with root package name */
    protected static final String f12595h = "__xadsdk__remote__final__builtinversion__.jar";

    /* renamed from: i  reason: collision with root package name */
    protected static final String f12596i = "__xadsdk__remote__final__downloaded__.jar";

    /* renamed from: j  reason: collision with root package name */
    protected static final String f12597j = "__xadsdk__remote__final__running__.jar";

    /* renamed from: k  reason: collision with root package name */
    public static final String f12598k = "OK";

    /* renamed from: l  reason: collision with root package name */
    public static final String f12599l = "ERROR";

    /* renamed from: m  reason: collision with root package name */
    public static final String f12600m = "APK_INFO";

    /* renamed from: n  reason: collision with root package name */
    public static final String f12601n = "CODE";

    /* renamed from: o  reason: collision with root package name */
    public static final String f12602o = "success";

    /* renamed from: p  reason: collision with root package name */
    protected static volatile bq f12603p = null;

    /* renamed from: q  reason: collision with root package name */
    protected static volatile bq f12604q = null;

    /* renamed from: r  reason: collision with root package name */
    protected static volatile Class f12605r = null;

    /* renamed from: s  reason: collision with root package name */
    protected static String f12606s = null;

    /* renamed from: t  reason: collision with root package name */
    protected static final Handler f12607t = new cc(Looper.getMainLooper());

    /* renamed from: x  reason: collision with root package name */
    private static final String f12608x = "baidu_sdk_remote";
    private boolean A;
    private CopyOnWriteArrayList<c> B;
    private c C;

    /* renamed from: u  reason: collision with root package name */
    protected Handler f12609u;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: v  reason: collision with root package name */
    protected final Handler f12610v;

    /* renamed from: w  reason: collision with root package name */
    private bz f12611w;

    /* renamed from: y  reason: collision with root package name */
    private final Context f12612y;

    /* renamed from: z  reason: collision with root package name */
    private bv f12613z;

    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private static final long f12614a = 2978543166232984104L;

        public a(String str) {
            bv.a().c(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private static final long f12615a = -7838296421993681751L;

        public b(String str) {
            bv.a().c(str);
        }
    }

    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface c {
        void a(boolean z3);
    }

    public cb(Activity activity) {
        this(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            File[] listFiles = this.f12612y.getFilesDir().listFiles();
            int i4 = 0;
            while (listFiles != null) {
                if (i4 >= listFiles.length) {
                    return;
                }
                if (listFiles[i4].getAbsolutePath().contains(f12592e) && listFiles[i4].getAbsolutePath().endsWith("dex")) {
                    listFiles[i4].delete();
                }
                i4++;
            }
        } catch (Exception e4) {
            bv.a().c(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences m() {
        return this.f12612y.getSharedPreferences(x.aN, 0);
    }

    private boolean n() {
        String string = m().getString("previousProxyVersion", null);
        return string == null || !string.equals(a());
    }

    private boolean o() {
        try {
            if (!bt.a(c())) {
                if (!bt.a(f())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e4) {
            this.f12613z.a(e4);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        bu buVar = new bu(f(), this.f12612y);
        if (bt.a(buVar)) {
            try {
                if (!n()) {
                    synchronized (this) {
                        bv bvVar = this.f12613z;
                        bvVar.a("ApkLoader", "loadDownloadedOrBuiltInApk len=" + buVar.length() + ", path=" + buVar.getAbsolutePath());
                        b(buVar);
                        double d4 = (double) m().getFloat(f12590c, -1.0f);
                        bv bvVar2 = this.f12613z;
                        bvVar2.a("ApkLoader", "downloadedApkFile.getApkVersion(): " + buVar.c() + ", badApkVersion: " + d4);
                        if (buVar.c() != d4) {
                            bv bvVar3 = this.f12613z;
                            bvVar3.a("ApkLoader", "loaded: " + buVar.getPath());
                        } else {
                            throw new a("downloaded file marked bad, drop it and use built-in");
                        }
                    }
                    return true;
                }
                throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            } catch (a e4) {
                bv bvVar4 = this.f12613z;
                bvVar4.a("ApkLoader", "load downloaded apk failed: " + e4.toString() + ", fallback to built-in");
                if (buVar.exists()) {
                    buVar.delete();
                }
                k();
                return false;
            }
        }
        return false;
    }

    public final String a() {
        return "9.35";
    }

    public int h() {
        return StubApp.getOrigApplicationContext(this.f12612y.getApplicationContext()).getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    public IXAdContainerFactory i() {
        return a(f12603p);
    }

    public IXAdContainerFactory j() {
        return a(f12604q);
    }

    protected void k() {
        if (f12603p != null) {
            f12603p.b();
            f12603p = null;
        }
    }

    public cb(Context context) {
        this.f12613z = bv.a();
        this.A = false;
        this.f12609u = f12607t;
        this.B = new CopyOnWriteArrayList<>();
        this.f12610v = new cd(this, Looper.getMainLooper());
        this.f12612y = context;
        c(context);
        if (f12589b == null) {
            f12589b = cp.a(context);
            cp.a(context).a(new ce(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cp) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(f12589b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String f() {
        if (TextUtils.isEmpty(f12606s)) {
            return "";
        }
        return f12606s + f12596i;
    }

    protected void e() {
        this.f12613z.a("ApkLoader", "start load assets file");
        d(this.f12612y);
        String c4 = c();
        bu buVar = new bu(c4, this.f12612y);
        if (bt.a(buVar)) {
            this.f12613z.a("ApkLoader", "assets file can read ,will use it ");
            if (c(buVar)) {
                b(true);
                return;
            }
            return;
        }
        throw new b("loadBuiltInApk failed: " + c4);
    }

    protected void g() {
        if (h() != 2 ? p() : false) {
            this.f12613z.a("ApkLoader", "load downloaded file success,use it");
            b(true);
            return;
        }
        this.f12613z.a("ApkLoader", "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e4) {
            bv bvVar = this.f12613z;
            bvVar.a("ApkLoader", "loadBuiltInApk failed: " + e4.toString());
            throw new a("load built-in apk failed" + e4.toString());
        }
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(f12606s)) {
            File dir = context.getDir(f12608x, 0);
            f12606s = dir.getAbsolutePath() + TTPathConst.sSeparator;
        }
    }

    protected static String d() {
        if (TextUtils.isEmpty(f12606s)) {
            return "";
        }
        return f12606s + f12595h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        new File(f()).delete();
    }

    private static synchronized void d(Context context) {
        synchronized (cb.class) {
            try {
                String c4 = c();
                double b4 = b(c4);
                bv a4 = bv.a();
                a4.a("ApkLoader", "copy assets,compare version=" + Double.valueOf("9.35") + "remote=" + b4);
                if (Double.valueOf("9.35").doubleValue() != b4) {
                    bu buVar = new bu(c4, context);
                    if (buVar.exists()) {
                        buVar.delete();
                    }
                    bt.a(context, f12593f, c4);
                }
            } catch (Exception e4) {
                throw new b("loadBuiltInApk failed: " + e4.toString());
            }
        }
    }

    private void b(bu buVar) {
        bv bvVar = this.f12613z;
        bvVar.a("ApkLoader", "len=" + buVar.length() + ", path=" + buVar.getAbsolutePath());
        if (f12603p == null) {
            String a4 = a(this.f12612y);
            bu buVar2 = new bu(a4, this.f12612y);
            if (buVar2.exists()) {
                buVar2.delete();
            }
            try {
                bt.a(new FileInputStream(buVar), a4);
            } catch (Exception e4) {
                this.f12613z.c(e4);
            }
            f12603p = new bq(buVar2.b(), this.f12612y);
            try {
                IXAdContainerFactory a5 = f12603p.a();
                bv bvVar2 = this.f12613z;
                bvVar2.a("ApkLoader", "preloaded apk.version=" + a5.getRemoteVersion());
                return;
            } catch (a e5) {
                bv bvVar3 = this.f12613z;
                bvVar3.a("ApkLoader", "preload local apk " + buVar.getAbsolutePath() + " failed, msg:" + e5.getMessage() + ", v=" + f12603p.f12520b);
                a(e5.getMessage());
                throw e5;
            }
        }
        bv bvVar4 = this.f12613z;
        bvVar4.a("ApkLoader", "mApkBuilder already initialized, version: " + f12603p.f12520b);
    }

    protected static String c() {
        if (TextUtils.isEmpty(f12606s)) {
            return "";
        }
        return f12606s + f12594g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(9)
    public void a(String str) {
        if (f12603p != null) {
            SharedPreferences.Editor edit = m().edit();
            edit.putFloat(f12590c, (float) f12603p.f12520b);
            edit.apply();
        }
    }

    private boolean c(bu buVar) {
        synchronized (this) {
            b(buVar);
            bv bvVar = this.f12613z;
            bvVar.a("ApkLoader", "loaded: " + buVar.getPath());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z3) {
        Message obtainMessage = this.f12609u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z3);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.f12609u.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z3) {
        double d4;
        if (z3) {
            try {
                d4 = f12603p.f12520b;
            } catch (Exception unused) {
                return;
            }
        } else {
            d4 = 0.0d;
        }
        ao.a(d4, new ch(this, d4), new ci(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bu buVar) {
        Class<?> b4 = buVar.b();
        synchronized (this) {
            f12604q = new bq(b4, this.f12612y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z3, String str) {
        try {
            cp.a(this.f12612y).c();
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (int i4 = 0; i4 < this.B.size(); i4++) {
                    c cVar = this.B.get(i4);
                    if (cVar != null) {
                        cVar.a(z3);
                    }
                }
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.B;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z3) {
        if (!z3 && !o()) {
            this.A = true;
        } else {
            a(z3, z3 ? "apk Successfully Loaded" : "apk Load Failed");
        }
        if (this.A) {
            be.a().a((i) new cf(this, z3));
        } else {
            be.a().a(new cg(this, z3), 5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.f12609u = handler;
        if (f12603p == null) {
            g();
        } else {
            b(true);
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f12606s)) {
            File dir = context.getDir(f12608x, 0);
            f12606s = dir.getAbsolutePath() + TTPathConst.sSeparator;
        }
        if (TextUtils.isEmpty(f12606s)) {
            return "";
        }
        return f12606s + f12597j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bz bzVar) {
        if (bzVar.a().booleanValue()) {
            bx a4 = bx.a(this.f12612y, bzVar, f12606s, this.f12610v);
            if (!a4.isAlive()) {
                this.f12613z.a("ApkLoader", "XApkDownloadThread starting ...");
                a4.start();
                return;
            }
            this.f12613z.a("ApkLoader", "XApkDownloadThread already started");
            a4.a(bzVar.c());
        }
    }

    public static double b(Context context) {
        try {
            c(context);
            double b4 = b(f());
            String d4 = d();
            if (Double.valueOf("9.35").doubleValue() > b(d4)) {
                bu buVar = new bu(d4, context);
                if (buVar.exists()) {
                    buVar.delete();
                }
                bt.a(context, f12593f, d4);
            }
            return Math.max(b4, b(d()));
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        be.a().a((i) new cj(this, cVar, handler));
    }

    public void a(c cVar) {
        a(cVar, f12607t);
    }

    private IXAdContainerFactory a(bq bqVar) {
        if (bqVar != null) {
            try {
                return bqVar.a();
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static double b(String str) {
        JarFile jarFile = null;
        try {
            try {
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (co.f12660d.booleanValue()) {
            File file = new File(str);
            if (bt.a(file)) {
                JarFile jarFile2 = new JarFile(file);
                try {
                    double parseDouble = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                    if (parseDouble > 0.0d) {
                        try {
                            jarFile2.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        return parseDouble;
                    }
                    jarFile = jarFile2;
                } catch (Exception unused2) {
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    return 0.0d;
                } catch (Throwable th2) {
                    th = th2;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (jarFile != null) {
                jarFile.close();
            }
            return 0.0d;
        }
        return Double.valueOf("9.35").doubleValue();
    }
}
