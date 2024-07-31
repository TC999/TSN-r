package com.p518qq.p519e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.p518qq.p519e.comm.constants.Sig;
import com.p518qq.p519e.comm.managers.C11815a;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.p520pi.POFactory;
import com.p518qq.p519e.comm.util.GDTLogger;
import com.stub.StubApp;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.plugin.PM */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11819PM {
    public static final int CALL_START_BY_DEV = 1;

    /* renamed from: r */
    private static final Map<Class<?>, String> f32909r = new C11821b();

    /* renamed from: b */
    private final Context f32911b;

    /* renamed from: c */
    private String f32912c;

    /* renamed from: d */
    private File f32913d;

    /* renamed from: e */
    private volatile int f32914e;

    /* renamed from: f */
    private DexClassLoader f32915f;

    /* renamed from: g */
    private RandomAccessFile f32916g;

    /* renamed from: h */
    private FileLock f32917h;

    /* renamed from: i */
    private boolean f32918i;

    /* renamed from: j */
    private final InterfaceC11829f f32919j;

    /* renamed from: k */
    private volatile POFactory f32920k;

    /* renamed from: l */
    private int f32921l;

    /* renamed from: m */
    private Future<Boolean> f32922m;

    /* renamed from: o */
    private boolean f32924o;

    /* renamed from: p */
    private String f32925p;

    /* renamed from: q */
    private JSONObject f32926q;

    /* renamed from: a */
    final ExecutorService f32910a = Executors.newSingleThreadExecutor();

    /* renamed from: n */
    private boolean f32923n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qq.e.comm.managers.plugin.PM$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class CallableC11820a implements Callable<Boolean> {
        CallableC11820a() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            if (!C11819PM.this.f32918i) {
                C11819PM c11819pm = C11819PM.this;
                c11819pm.f32918i = c11819pm.tryLockUpdate();
            }
            if (C11819PM.m20340b(C11819PM.this)) {
                C11819PM.m20338c(C11819PM.this);
            }
            C11819PM.this.f32921l = (int) (System.currentTimeMillis() - currentTimeMillis);
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.qq.e.comm.managers.plugin.PM$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C11821b extends HashMap<Class<?>, String> {
        C11821b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public C11819PM(Context context, InterfaceC11829f interfaceC11829f) {
        this.f32911b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f32919j = interfaceC11829f;
        C11823b.m20335a(context);
        m20337d();
    }

    /* renamed from: a */
    private JSONObject m20345a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.f32925p);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.f32912c);
            jSONObject.put("appId", C11815a.m20349b().m20354a());
            jSONObject.put("pn", C11823b.m20335a(this.f32911b));
            jSONObject.put("ict", this.f32921l);
            jSONObject.put("mup", this.f32918i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    private boolean m20341b() {
        if (this.f32918i) {
            try {
                Context context = this.f32911b;
                C11823b.m20334a(context, C11831h.m20310e(context), C11831h.m20309f(this.f32911b));
                this.f32912c = Sig.ASSET_PLUGIN_SIG;
                this.f32913d = C11831h.m20310e(this.f32911b);
                this.f32914e = SDKStatus.getBuildInPluginVersion();
                return true;
            } catch (Throwable th) {
                GDTLogger.m20307e("插件初始化失败 ");
                C11822a.m20336a(th, th.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (r5.m20341b() != false) goto L12;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean m20340b(com.p518qq.p519e.comm.managers.plugin.C11819PM r5) {
        /*
            java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
            r5.getClass()
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L32
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L32
            com.p518qq.p519e.comm.util.GDTLogger.m20308d(r2)     // Catch: java.lang.Throwable -> L32
            boolean r2 = r5.m20339c()     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L2a
            boolean r5 = r5.m20341b()     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L2c
        L2a:
            r5 = 1
            r1 = 1
        L2c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L44
        L32:
            r5 = move-exception
            java.lang.String r2 = "插件加载出现异常"
            com.p518qq.p519e.comm.util.GDTLogger.m20306e(r2, r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r5.getMessage()     // Catch: java.lang.Throwable -> L56
            com.p518qq.p519e.comm.managers.plugin.C11822a.m20336a(r5, r2)     // Catch: java.lang.Throwable -> L56
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L44:
            r5.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.p518qq.p519e.comm.util.GDTLogger.m20308d(r5)
            return r1
        L56:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.p518qq.p519e.comm.util.GDTLogger.m20308d(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p518qq.p519e.comm.managers.plugin.C11819PM.m20340b(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    /* renamed from: c */
    static void m20338c(C11819PM c11819pm) {
        c11819pm.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("PluginFile:\t");
        File file = c11819pm.f32913d;
        sb.append(file == null ? "null" : file.getAbsolutePath());
        GDTLogger.m20308d(sb.toString());
        if (c11819pm.f32912c == null || c11819pm.f32913d == null) {
            c11819pm.f32915f = null;
            return;
        }
        try {
            c11819pm.f32915f = new DexClassLoader(c11819pm.f32913d.getAbsolutePath(), C11831h.m20318a(c11819pm.f32911b).getAbsolutePath(), null, c11819pm.getClass().getClassLoader());
            InterfaceC11829f interfaceC11829f = c11819pm.f32919j;
            if (interfaceC11829f != null) {
                interfaceC11829f.m20327a();
            }
        } catch (Throwable th) {
            GDTLogger.m20306e("插件ClassLoader构造发生异常", th);
            InterfaceC11829f interfaceC11829f2 = c11819pm.f32919j;
            if (interfaceC11829f2 != null) {
                interfaceC11829f2.m20326b();
            }
            C11822a.m20336a(th, th.getMessage());
        }
    }

    /* renamed from: c */
    private boolean m20339c() {
        if (this.f32924o) {
            return false;
        }
        if (this.f32918i) {
            C11830g c11830g = new C11830g(C11831h.m20312c(this.f32911b), C11831h.m20311d(this.f32911b));
            if (c11830g.m20325a()) {
                boolean m20323a = c11830g.m20323a(C11831h.m20310e(this.f32911b), C11831h.m20309f(this.f32911b));
                GDTLogger.m20308d("NextExist,Updated=" + m20323a);
            }
        }
        C11830g c11830g2 = new C11830g(C11831h.m20310e(this.f32911b), C11831h.m20309f(this.f32911b));
        if (c11830g2.m20325a()) {
            if (c11830g2.m20321c() >= SDKStatus.getBuildInPluginVersion()) {
                this.f32912c = c11830g2.m20322b();
                this.f32914e = c11830g2.m20321c();
                this.f32913d = C11831h.m20310e(this.f32911b);
                this.f32925p = c11830g2.m20320d();
                this.f32923n = true;
                return true;
            }
            GDTLogger.m20308d("last updated plugin version =" + this.f32914e + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
            return false;
        }
        return false;
    }

    /* renamed from: d */
    private void m20337d() {
        this.f32923n = false;
        SharedPreferences sharedPreferences = this.f32911b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            this.f32924o = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.m20307e("加载本地插件");
        }
        this.f32922m = this.f32910a.submit(new CallableC11820a());
    }

    public <T> T getFactory(Class<T> cls) throws C11828e {
        Future<Boolean> future = this.f32922m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        GDTLogger.m20308d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? C11819PM.class.getClassLoader() : this.f32915f;
        StringBuilder sb = new StringBuilder();
        sb.append("PluginClassLoader is parent");
        sb.append(C11819PM.class.getClassLoader() == classLoader);
        GDTLogger.m20308d(sb.toString());
        if (classLoader == null) {
            throw new C11828e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = f32909r.get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new C11828e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.f32911b, m20345a()));
            GDTLogger.m20308d("ServiceDelegateFactory =" + cast);
            return cast;
        } catch (Throwable th) {
            throw new C11828e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public POFactory getPOFactory() throws C11828e {
        return getPOFactory(true, false);
    }

    public POFactory getPOFactory(boolean z, boolean z2) throws C11828e {
        if (this.f32920k == null) {
            synchronized (this) {
                if (this.f32920k == null) {
                    try {
                        this.f32920k = (POFactory) getFactory(POFactory.class);
                    } catch (C11828e e) {
                        if (!this.f32923n) {
                            throw e;
                        }
                        GDTLogger.m20307e("插件加载错误，回退到内置版本");
                        this.f32924o = true;
                        m20337d();
                        this.f32920k = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        if (z && this.f32920k != null) {
            this.f32920k.start(getStartCaller(z2 ? 0 : 2));
        }
        return this.f32920k;
    }

    public int getPluginVersion() {
        Future<Boolean> future = this.f32922m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.f32914e;
    }

    public JSONObject getStartCaller(int i) {
        if (this.f32926q == null) {
            this.f32926q = new JSONObject();
        }
        try {
            this.f32926q.put("scr", i);
        } catch (JSONException unused) {
        }
        return this.f32926q;
    }

    public boolean tryLockUpdate() {
        try {
            File m20313b = C11831h.m20313b(this.f32911b);
            if (!m20313b.exists()) {
                m20313b.createNewFile();
                C11831h.m20314a("lock", m20313b);
            }
            if (m20313b.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(m20313b, "rw");
                this.f32916g = randomAccessFile;
                FileLock tryLock = randomAccessFile.getChannel().tryLock();
                this.f32917h = tryLock;
                if (tryLock != null) {
                    this.f32916g.writeByte(37);
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
