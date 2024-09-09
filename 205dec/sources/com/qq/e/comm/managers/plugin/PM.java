package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class PM {
    public static final int CALL_START_BY_DEV = 1;

    /* renamed from: r  reason: collision with root package name */
    private static final Map<Class<?>, String> f41643r = new b();

    /* renamed from: b  reason: collision with root package name */
    private final Context f41645b;

    /* renamed from: c  reason: collision with root package name */
    private String f41646c;

    /* renamed from: d  reason: collision with root package name */
    private File f41647d;

    /* renamed from: e  reason: collision with root package name */
    private volatile int f41648e;

    /* renamed from: f  reason: collision with root package name */
    private DexClassLoader f41649f;

    /* renamed from: g  reason: collision with root package name */
    private RandomAccessFile f41650g;

    /* renamed from: h  reason: collision with root package name */
    private FileLock f41651h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f41652i;

    /* renamed from: j  reason: collision with root package name */
    private final f f41653j;

    /* renamed from: k  reason: collision with root package name */
    private volatile POFactory f41654k;

    /* renamed from: l  reason: collision with root package name */
    private int f41655l;

    /* renamed from: m  reason: collision with root package name */
    private Future<Boolean> f41656m;

    /* renamed from: o  reason: collision with root package name */
    private boolean f41658o;

    /* renamed from: p  reason: collision with root package name */
    private String f41659p;

    /* renamed from: q  reason: collision with root package name */
    private JSONObject f41660q;

    /* renamed from: a  reason: collision with root package name */
    final ExecutorService f41644a = Executors.newSingleThreadExecutor();

    /* renamed from: n  reason: collision with root package name */
    private boolean f41657n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a implements Callable<Boolean> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            if (!PM.this.f41652i) {
                PM pm = PM.this;
                pm.f41652i = pm.tryLockUpdate();
            }
            if (PM.b(PM.this)) {
                PM.c(PM.this);
            }
            PM.this.f41655l = (int) (System.currentTimeMillis() - currentTimeMillis);
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class b extends HashMap<Class<?>, String> {
        b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(Context context, f fVar) {
        this.f41645b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f41653j = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        d();
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.f41659p);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.f41646c);
            jSONObject.put("appId", com.qq.e.comm.managers.a.b().a());
            jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.f41645b));
            jSONObject.put("ict", this.f41655l);
            jSONObject.put("mup", this.f41652i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private boolean b() {
        if (this.f41652i) {
            try {
                Context context = this.f41645b;
                com.qq.e.comm.managers.plugin.b.a(context, h.e(context), h.f(this.f41645b));
                this.f41646c = Sig.ASSET_PLUGIN_SIG;
                this.f41647d = h.e(this.f41645b);
                this.f41648e = SDKStatus.getBuildInPluginVersion();
                return true;
            } catch (Throwable th) {
                GDTLogger.e("\u63d2\u4ef6\u521d\u59cb\u5316\u5931\u8d25 ");
                com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (r5.b() != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean b(com.qq.e.comm.managers.plugin.PM r5) {
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
            com.qq.e.comm.util.GDTLogger.d(r2)     // Catch: java.lang.Throwable -> L32
            boolean r2 = r5.c()     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L2a
            boolean r5 = r5.b()     // Catch: java.lang.Throwable -> L32
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
            java.lang.String r2 = "\u63d2\u4ef6\u52a0\u8f7d\u51fa\u73b0\u5f02\u5e38"
            com.qq.e.comm.util.GDTLogger.e(r2, r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r5.getMessage()     // Catch: java.lang.Throwable -> L56
            com.qq.e.comm.managers.plugin.a.a(r5, r2)     // Catch: java.lang.Throwable -> L56
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L44:
            r5.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.qq.e.comm.util.GDTLogger.d(r5)
            return r1
        L56:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.b(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    static void c(PM pm) {
        pm.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("PluginFile:\t");
        File file = pm.f41647d;
        sb.append(file == null ? "null" : file.getAbsolutePath());
        GDTLogger.d(sb.toString());
        if (pm.f41646c == null || pm.f41647d == null) {
            pm.f41649f = null;
            return;
        }
        try {
            pm.f41649f = new DexClassLoader(pm.f41647d.getAbsolutePath(), h.a(pm.f41645b).getAbsolutePath(), null, pm.getClass().getClassLoader());
            f fVar = pm.f41653j;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Throwable th) {
            GDTLogger.e("\u63d2\u4ef6ClassLoader\u6784\u9020\u53d1\u751f\u5f02\u5e38", th);
            f fVar2 = pm.f41653j;
            if (fVar2 != null) {
                fVar2.b();
            }
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    private boolean c() {
        if (this.f41658o) {
            return false;
        }
        if (this.f41652i) {
            g gVar = new g(h.c(this.f41645b), h.d(this.f41645b));
            if (gVar.a()) {
                boolean a4 = gVar.a(h.e(this.f41645b), h.f(this.f41645b));
                GDTLogger.d("NextExist,Updated=" + a4);
            }
        }
        g gVar2 = new g(h.e(this.f41645b), h.f(this.f41645b));
        if (gVar2.a()) {
            if (gVar2.c() >= SDKStatus.getBuildInPluginVersion()) {
                this.f41646c = gVar2.b();
                this.f41648e = gVar2.c();
                this.f41647d = h.e(this.f41645b);
                this.f41659p = gVar2.d();
                this.f41657n = true;
                return true;
            }
            GDTLogger.d("last updated plugin version =" + this.f41648e + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
            return false;
        }
        return false;
    }

    private void d() {
        this.f41657n = false;
        SharedPreferences sharedPreferences = this.f41645b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            this.f41658o = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("\u52a0\u8f7d\u672c\u5730\u63d2\u4ef6");
        }
        this.f41656m = this.f41644a.submit(new a());
    }

    public <T> T getFactory(Class<T> cls) throws e {
        Future<Boolean> future = this.f41656m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f41649f;
        StringBuilder sb = new StringBuilder();
        sb.append("PluginClassLoader is parent");
        sb.append(PM.class.getClassLoader() == classLoader);
        GDTLogger.d(sb.toString());
        if (classLoader == null) {
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = f41643r.get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.f41645b, a()));
            GDTLogger.d("ServiceDelegateFactory =" + cast);
            return cast;
        } catch (Throwable th) {
            throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public POFactory getPOFactory() throws e {
        return getPOFactory(true, false);
    }

    public POFactory getPOFactory(boolean z3, boolean z4) throws e {
        if (this.f41654k == null) {
            synchronized (this) {
                if (this.f41654k == null) {
                    try {
                        this.f41654k = (POFactory) getFactory(POFactory.class);
                    } catch (e e4) {
                        if (!this.f41657n) {
                            throw e4;
                        }
                        GDTLogger.e("\u63d2\u4ef6\u52a0\u8f7d\u9519\u8bef\uff0c\u56de\u9000\u5230\u5185\u7f6e\u7248\u672c");
                        this.f41658o = true;
                        d();
                        this.f41654k = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        if (z3 && this.f41654k != null) {
            this.f41654k.start(getStartCaller(z4 ? 0 : 2));
        }
        return this.f41654k;
    }

    public int getPluginVersion() {
        Future<Boolean> future = this.f41656m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.f41648e;
    }

    public JSONObject getStartCaller(int i4) {
        if (this.f41660q == null) {
            this.f41660q = new JSONObject();
        }
        try {
            this.f41660q.put("scr", i4);
        } catch (JSONException unused) {
        }
        return this.f41660q;
    }

    public boolean tryLockUpdate() {
        try {
            File b4 = h.b(this.f41645b);
            if (!b4.exists()) {
                b4.createNewFile();
                h.a("lock", b4);
            }
            if (b4.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(b4, "rw");
                this.f41650g = randomAccessFile;
                FileLock tryLock = randomAccessFile.getChannel().tryLock();
                this.f41651h = tryLock;
                if (tryLock != null) {
                    this.f41650g.writeByte(37);
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
