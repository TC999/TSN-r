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
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

/* renamed from: com.baidu.mobads.sdk.internal.by */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2640by {

    /* renamed from: a */
    public static final String f8763a = "ApkLoader";

    /* renamed from: b */
    protected static Thread.UncaughtExceptionHandler f8764b = null;

    /* renamed from: c */
    public static final String f8765c = "__badApkVersion__9.332";

    /* renamed from: d */
    public static final String f8766d = "previousProxyVersion";

    /* renamed from: e */
    protected static final String f8767e = "__xadsdk__remote__final__";

    /* renamed from: f */
    protected static final String f8768f = "bdxadsdk.jar";

    /* renamed from: g */
    protected static final String f8769g = "__xadsdk__remote__final__builtin__.jar";

    /* renamed from: h */
    protected static final String f8770h = "__xadsdk__remote__final__builtinversion__.jar";

    /* renamed from: i */
    protected static final String f8771i = "__xadsdk__remote__final__downloaded__.jar";

    /* renamed from: j */
    protected static final String f8772j = "__xadsdk__remote__final__running__.jar";

    /* renamed from: k */
    public static final String f8773k = "OK";

    /* renamed from: l */
    public static final String f8774l = "ERROR";

    /* renamed from: m */
    public static final String f8775m = "APK_INFO";

    /* renamed from: n */
    public static final String f8776n = "CODE";

    /* renamed from: o */
    public static final String f8777o = "success";

    /* renamed from: p */
    protected static volatile C2628bn f8778p = null;

    /* renamed from: q */
    protected static volatile C2628bn f8779q = null;

    /* renamed from: r */
    protected static volatile Class f8780r = null;

    /* renamed from: s */
    protected static String f8781s = null;

    /* renamed from: t */
    protected static final Handler f8782t = new HandlerC2644bz(Looper.getMainLooper());

    /* renamed from: x */
    private static final String f8783x = "baidu_sdk_remote";

    /* renamed from: A */
    private boolean f8784A;

    /* renamed from: B */
    private CopyOnWriteArrayList<InterfaceC2643c> f8785B;

    /* renamed from: C */
    private InterfaceC2643c f8786C;

    /* renamed from: u */
    protected Handler f8787u;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: v */
    protected final Handler f8788v;

    /* renamed from: w */
    private C2638bw f8789w;

    /* renamed from: y */
    private final Context f8790y;

    /* renamed from: z */
    private C2634bs f8791z;

    /* renamed from: com.baidu.mobads.sdk.internal.by$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C2641a extends Exception {

        /* renamed from: a */
        private static final long f8792a = 2978543166232984104L;

        public C2641a(String str) {
            C2634bs.m50744a().m50731c(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.mobads.sdk.internal.by$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C2642b extends Exception {

        /* renamed from: a */
        private static final long f8793a = -7838296421993681751L;

        public C2642b(String str) {
            C2634bs.m50744a().m50731c(str);
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.by$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2643c {
        /* renamed from: a */
        void mo50656a(boolean z);
    }

    public C2640by(Activity activity) {
        this(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m50661l() {
        try {
            File[] listFiles = this.f8790y.getFilesDir().listFiles();
            int i = 0;
            while (listFiles != null) {
                if (i >= listFiles.length) {
                    return;
                }
                if (listFiles[i].getAbsolutePath().contains(f8767e) && listFiles[i].getAbsolutePath().endsWith("dex")) {
                    listFiles[i].delete();
                }
                i++;
            }
        } catch (Exception e) {
            C2634bs.m50744a().m50729c(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public SharedPreferences m50660m() {
        return this.f8790y.getSharedPreferences(C2736x.f9274aM, 0);
    }

    /* renamed from: n */
    private boolean m50659n() {
        String string = m50660m().getString(f8766d, null);
        return string == null || !string.equals(m50706a());
    }

    /* renamed from: o */
    private boolean m50658o() {
        try {
            if (!C2631bq.m50756a(m50681c())) {
                if (!C2631bq.m50756a(m50669f())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            this.f8791z.m50738a(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public boolean m50657p() {
        C2632br c2632br = new C2632br(m50669f(), this.f8790y);
        if (C2631bq.m50758a(c2632br)) {
            try {
                if (!m50659n()) {
                    synchronized (this) {
                        C2634bs c2634bs = this.f8791z;
                        c2634bs.m50740a(f8763a, "loadDownloadedOrBuiltInApk len=" + c2632br.length() + ", path=" + c2632br.getAbsolutePath());
                        m50688b(c2632br);
                        double d = (double) m50660m().getFloat(f8765c, -1.0f);
                        C2634bs c2634bs2 = this.f8791z;
                        c2634bs2.m50740a(f8763a, "downloadedApkFile.getApkVersion(): " + c2632br.m50747c() + ", badApkVersion: " + d);
                        if (c2632br.m50747c() != d) {
                            C2634bs c2634bs3 = this.f8791z;
                            c2634bs3.m50740a(f8763a, "loaded: " + c2632br.getPath());
                        } else {
                            throw new C2641a("downloaded file marked bad, drop it and use built-in");
                        }
                    }
                    return true;
                }
                throw new C2641a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            } catch (C2641a e) {
                C2634bs c2634bs4 = this.f8791z;
                c2634bs4.m50740a(f8763a, "load downloaded apk failed: " + e.toString() + ", fallback to built-in");
                if (c2632br.exists()) {
                    c2632br.delete();
                }
                m50662k();
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final String m50706a() {
        return "9.332";
    }

    /* renamed from: h */
    public int m50665h() {
        return StubApp.getOrigApplicationContext(this.f8790y.getApplicationContext()).getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    /* renamed from: i */
    public IXAdContainerFactory m50664i() {
        return m50704a(f8778p);
    }

    /* renamed from: j */
    public IXAdContainerFactory m50663j() {
        return m50704a(f8779q);
    }

    /* renamed from: k */
    protected void m50662k() {
        if (f8778p != null) {
            f8778p.m50779b();
            f8778p = null;
        }
    }

    public C2640by(Context context) {
        this.f8791z = C2634bs.m50744a();
        this.f8784A = false;
        this.f8787u = f8782t;
        this.f8785B = new CopyOnWriteArrayList<>();
        this.f8788v = new HandlerC2647ca(this, Looper.getMainLooper());
        this.f8790y = context;
        m50680c(context);
        if (f8764b == null) {
            f8764b = C2660cm.m50631a(context);
            C2660cm.m50631a(context).m50630a(new C2648cb(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof C2660cm) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(f8764b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public static String m50669f() {
        if (TextUtils.isEmpty(f8781s)) {
            return "";
        }
        return f8781s + f8771i;
    }

    /* renamed from: e */
    protected void m50671e() {
        this.f8791z.m50740a(f8763a, "start load assets file");
        m50674d(this.f8790y);
        String m50681c = m50681c();
        C2632br c2632br = new C2632br(m50681c, this.f8790y);
        if (C2631bq.m50758a(c2632br)) {
            this.f8791z.m50740a(f8763a, "assets file can read ,will use it ");
            if (m50679c(c2632br)) {
                m50682b(true);
                return;
            }
            return;
        }
        throw new C2642b("loadBuiltInApk failed: " + m50681c);
    }

    /* renamed from: g */
    protected void m50667g() {
        if (m50665h() != 2 ? m50657p() : false) {
            this.f8791z.m50740a(f8763a, "load downloaded file success,use it");
            m50682b(true);
            return;
        }
        this.f8791z.m50740a(f8763a, "no downloaded file yet, use built-in apk file");
        try {
            m50671e();
        } catch (C2642b e) {
            C2634bs c2634bs = this.f8791z;
            c2634bs.m50740a(f8763a, "loadBuiltInApk failed: " + e.toString());
            throw new C2641a("load built-in apk failed" + e.toString());
        }
    }

    /* renamed from: c */
    private static void m50680c(Context context) {
        if (TextUtils.isEmpty(f8781s)) {
            File dir = context.getDir(f8783x, 0);
            f8781s = dir.getAbsolutePath() + "/";
        }
    }

    /* renamed from: d */
    protected static String m50675d() {
        if (TextUtils.isEmpty(f8781s)) {
            return "";
        }
        return f8781s + f8770h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m50690b() {
        new File(m50669f()).delete();
    }

    /* renamed from: d */
    private static synchronized void m50674d(Context context) {
        synchronized (C2640by.class) {
            try {
                String m50681c = m50681c();
                double m50683b = m50683b(m50681c);
                C2634bs m50744a = C2634bs.m50744a();
                m50744a.m50740a(f8763a, "copy assets,compare version=" + Double.valueOf("9.332") + "remote=" + m50683b);
                if (Double.valueOf("9.332").doubleValue() != m50683b) {
                    C2632br c2632br = new C2632br(m50681c, context);
                    if (c2632br.exists()) {
                        c2632br.delete();
                    }
                    C2631bq.m50759a(context, f8768f, m50681c);
                }
            } catch (Exception e) {
                throw new C2642b("loadBuiltInApk failed: " + e.toString());
            }
        }
    }

    /* renamed from: b */
    private void m50688b(C2632br c2632br) {
        C2634bs c2634bs = this.f8791z;
        c2634bs.m50740a(f8763a, "len=" + c2632br.length() + ", path=" + c2632br.getAbsolutePath());
        if (f8778p == null) {
            String m50705a = m50705a(this.f8790y);
            C2632br c2632br2 = new C2632br(m50705a, this.f8790y);
            if (c2632br2.exists()) {
                c2632br2.delete();
            }
            try {
                C2631bq.m50757a(new FileInputStream(c2632br), m50705a);
            } catch (Exception e) {
                this.f8791z.m50729c(e);
            }
            f8778p = new C2628bn(c2632br2.m50750b(), this.f8790y);
            try {
                IXAdContainerFactory m50780a = f8778p.m50780a();
                C2634bs c2634bs2 = this.f8791z;
                c2634bs2.m50740a(f8763a, "preloaded apk.version=" + m50780a.getRemoteVersion());
                return;
            } catch (C2641a e2) {
                C2634bs c2634bs3 = this.f8791z;
                c2634bs3.m50740a(f8763a, "preload local apk " + c2632br.getAbsolutePath() + " failed, msg:" + e2.getMessage() + ", v=" + f8778p.f8701b);
                m50693a(e2.getMessage());
                throw e2;
            }
        }
        C2634bs c2634bs4 = this.f8791z;
        c2634bs4.m50740a(f8763a, "mApkBuilder already initialized, version: " + f8778p.f8701b);
    }

    /* renamed from: c */
    protected static String m50681c() {
        if (TextUtils.isEmpty(f8781s)) {
            return "";
        }
        return f8781s + f8769g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(9)
    /* renamed from: a */
    public void m50693a(String str) {
        if (f8778p != null) {
            SharedPreferences.Editor edit = m50660m().edit();
            edit.putFloat(f8765c, (float) f8778p.f8701b);
            edit.apply();
        }
    }

    /* renamed from: c */
    private boolean m50679c(C2632br c2632br) {
        synchronized (this) {
            m50688b(c2632br);
            C2634bs c2634bs = this.f8791z;
            c2634bs.m50740a(f8763a, "loaded: " + c2632br.getPath());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50692a(boolean z) {
        Message obtainMessage = this.f8787u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.f8787u.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m50676c(boolean z) {
        double d;
        if (z) {
            try {
                d = f8778p.f8701b;
            } catch (Exception unused) {
                return;
            }
        } else {
            d = Utils.DOUBLE_EPSILON;
        }
        C2598ao.m50995a(d, new C2651ce(this, d), new C2652cf(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50703a(C2632br c2632br) {
        Class<?> m50750b = c2632br.m50750b();
        synchronized (this) {
            f8779q = new C2628bn(m50750b, this.f8790y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m50691a(boolean z, String str) {
        try {
            C2660cm.m50631a(this.f8790y).m50621c();
            CopyOnWriteArrayList<InterfaceC2643c> copyOnWriteArrayList = this.f8785B;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (int i = 0; i < this.f8785B.size(); i++) {
                    InterfaceC2643c interfaceC2643c = this.f8785B.get(i);
                    if (interfaceC2643c != null) {
                        interfaceC2643c.mo50656a(z);
                    }
                }
            }
            CopyOnWriteArrayList<InterfaceC2643c> copyOnWriteArrayList2 = this.f8785B;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m50682b(boolean z) {
        if (!z && !m50658o()) {
            this.f8784A = true;
        } else {
            m50691a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        }
        if (this.f8784A) {
            C2614bb.m50841a().m50840a((AbstractRunnableC2710i) new C2649cc(this, z));
        } else {
            C2614bb.m50841a().m50838a(new C2650cd(this, z), 5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m50687b(InterfaceC2643c interfaceC2643c, Handler handler) {
        CopyOnWriteArrayList<InterfaceC2643c> copyOnWriteArrayList = this.f8785B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(interfaceC2643c)) {
            this.f8785B.add(interfaceC2643c);
        }
        this.f8787u = handler;
        if (f8778p == null) {
            m50667g();
        } else {
            m50682b(true);
        }
    }

    /* renamed from: a */
    public static String m50705a(Context context) {
        if (TextUtils.isEmpty(f8781s)) {
            File dir = context.getDir(f8783x, 0);
            f8781s = dir.getAbsolutePath() + "/";
        }
        if (TextUtils.isEmpty(f8781s)) {
            return "";
        }
        return f8781s + f8772j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50702a(C2638bw c2638bw) {
        if (c2638bw.m50714a().booleanValue()) {
            C2636bu m50720a = C2636bu.m50720a(this.f8790y, c2638bw, f8781s, this.f8788v);
            if (!m50720a.isAlive()) {
                this.f8791z.m50740a(f8763a, "XApkDownloadThread starting ...");
                m50720a.start();
                return;
            }
            this.f8791z.m50740a(f8763a, "XApkDownloadThread already started");
            m50720a.m50717a(c2638bw.m50712c());
        }
    }

    /* renamed from: b */
    public static double m50689b(Context context) {
        try {
            m50680c(context);
            double m50683b = m50683b(m50669f());
            String m50675d = m50675d();
            if (Double.valueOf("9.332").doubleValue() > m50683b(m50675d)) {
                C2632br c2632br = new C2632br(m50675d, context);
                if (c2632br.exists()) {
                    c2632br.delete();
                }
                C2631bq.m50759a(context, f8768f, m50675d);
            }
            return Math.max(m50683b, m50683b(m50675d()));
        } catch (Exception unused) {
            return Utils.DOUBLE_EPSILON;
        }
    }

    @TargetApi(9)
    /* renamed from: a */
    public void m50700a(InterfaceC2643c interfaceC2643c, Handler handler) {
        C2614bb.m50841a().m50840a((AbstractRunnableC2710i) new C2653cg(this, interfaceC2643c, handler));
    }

    /* renamed from: a */
    public void m50701a(InterfaceC2643c interfaceC2643c) {
        m50700a(interfaceC2643c, f8782t);
    }

    /* renamed from: a */
    private IXAdContainerFactory m50704a(C2628bn c2628bn) {
        if (c2628bn != null) {
            try {
                return c2628bn.m50780a();
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static double m50683b(String str) {
        JarFile jarFile = null;
        try {
            try {
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (C2659cl.f8840d.booleanValue()) {
            File file = new File(str);
            if (C2631bq.m50758a(file)) {
                JarFile jarFile2 = new JarFile(file);
                try {
                    double parseDouble = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                    if (parseDouble > Utils.DOUBLE_EPSILON) {
                        try {
                            jarFile2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return parseDouble;
                    }
                    jarFile = jarFile2;
                } catch (Exception unused2) {
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    return Utils.DOUBLE_EPSILON;
                } catch (Throwable th2) {
                    th = th2;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (jarFile != null) {
                jarFile.close();
            }
            return Utils.DOUBLE_EPSILON;
        }
        return Double.valueOf("9.332").doubleValue();
    }
}
