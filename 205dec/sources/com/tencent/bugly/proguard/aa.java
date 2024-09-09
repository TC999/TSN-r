package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class aa {
    private static final Map<String, String> W = new HashMap();
    private static aa aq = null;
    public boolean D;
    public String E;
    public String F;
    public String G;
    public String H;
    public boolean J;
    public final SharedPreferences O;
    public final SharedPreferences P;
    private final Context X;
    private String Y;
    private String Z;
    private String aa;
    private String aj;

    /* renamed from: c  reason: collision with root package name */
    public String f50824c;

    /* renamed from: d  reason: collision with root package name */
    public final String f50825d;

    /* renamed from: e  reason: collision with root package name */
    public String f50826e;

    /* renamed from: k  reason: collision with root package name */
    public final String f50832k;

    /* renamed from: o  reason: collision with root package name */
    public String f50836o;

    /* renamed from: p  reason: collision with root package name */
    public int f50837p;

    /* renamed from: q  reason: collision with root package name */
    public String f50838q;

    /* renamed from: r  reason: collision with root package name */
    public String f50839r;

    /* renamed from: s  reason: collision with root package name */
    public String f50840s;

    /* renamed from: v  reason: collision with root package name */
    public List<String> f50843v;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50827f = true;

    /* renamed from: g  reason: collision with root package name */
    public final String f50828g = "com.tencent.bugly";

    /* renamed from: h  reason: collision with root package name */
    public String f50829h = "4.1.9.3";

    /* renamed from: i  reason: collision with root package name */
    public final String f50830i = "";
    @Deprecated

    /* renamed from: j  reason: collision with root package name */
    public final String f50831j = "";

    /* renamed from: l  reason: collision with root package name */
    public String f50833l = "unknown";
    private String ab = "unknown";
    private String ac = "";

    /* renamed from: m  reason: collision with root package name */
    public long f50834m = 0;
    private String ad = null;
    private long ae = -1;
    private long af = -1;
    private long ag = -1;
    private String ah = null;
    private String ai = null;
    private Map<String, PlugInBean> ak = null;

    /* renamed from: n  reason: collision with root package name */
    public boolean f50835n = false;
    private String al = null;
    private Boolean am = null;
    private String an = null;

    /* renamed from: t  reason: collision with root package name */
    public String f50841t = null;

    /* renamed from: u  reason: collision with root package name */
    public String f50842u = null;
    private Map<String, PlugInBean> ao = null;
    private Map<String, PlugInBean> ap = null;

    /* renamed from: w  reason: collision with root package name */
    public int f50844w = -1;

    /* renamed from: x  reason: collision with root package name */
    public int f50845x = -1;
    private final Map<String, String> ar = new HashMap();
    private final Map<String, String> as = new HashMap();
    private final Map<String, String> at = new HashMap();

    /* renamed from: y  reason: collision with root package name */
    public String f50846y = "unknown";

    /* renamed from: z  reason: collision with root package name */
    public long f50847z = 0;
    public long A = 0;
    public long B = 0;
    public long C = 0;
    public boolean I = false;
    public HashMap<String, String> K = new HashMap<>();

    /* renamed from: L  reason: collision with root package name */
    public List<String> f50821L = new ArrayList();
    public boolean M = false;
    public q N = null;
    public boolean Q = true;
    public boolean R = true;
    public boolean S = false;
    private final Object au = new Object();
    public final Object T = new Object();
    private final Object av = new Object();
    private final Object aw = new Object();
    public final Object U = new Object();
    public final Object V = new Object();
    private final Object ax = new Object();
    private final List<Integer> ay = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public final long f50822a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public final byte f50823b = 1;

    private aa(Context context) {
        this.aj = null;
        this.f50836o = null;
        this.f50838q = null;
        this.f50839r = null;
        this.f50840s = null;
        this.f50843v = null;
        this.D = false;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = "";
        this.J = false;
        this.X = ap.a(context);
        PackageInfo b4 = z.b(context);
        if (b4 != null) {
            try {
                String str = b4.versionName;
                this.f50836o = str;
                this.E = str;
                this.F = Integer.toString(b4.versionCode);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f50824c = z.a(context);
        this.f50825d = z.a(Process.myPid());
        this.f50838q = z.c(context);
        this.f50832k = "Android " + ab.b() + ",level " + ab.c();
        Map<String, String> d4 = z.d(context);
        if (d4 != null) {
            try {
                this.f50843v = z.a(d4);
                String str2 = d4.get("BUGLY_APPID");
                if (str2 != null) {
                    this.f50839r = str2;
                    b("APP_ID", str2);
                }
                String str3 = d4.get("BUGLY_APP_VERSION");
                if (str3 != null) {
                    this.f50836o = str3;
                }
                String str4 = d4.get("BUGLY_APP_CHANNEL");
                if (str4 != null) {
                    this.f50840s = str4;
                }
                String str5 = d4.get("BUGLY_ENABLE_DEBUG");
                if (str5 != null) {
                    this.D = str5.equalsIgnoreCase("true");
                }
                String str6 = d4.get("com.tencent.rdm.uuid");
                if (str6 != null) {
                    this.G = str6;
                }
                String str7 = d4.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str7)) {
                    this.f50837p = Integer.parseInt(str7);
                }
                String str8 = d4.get("BUGLY_AREA");
                if (str8 != null) {
                    this.H = str8;
                }
            } catch (Throwable th2) {
                if (!al.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.J = true;
                al.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (p.f51258c) {
                th3.printStackTrace();
            }
        }
        this.O = ap.a("BUGLY_COMMON_VALUES", context);
        this.P = ap.a("BUGLY_RESERVED_VALUES", context);
        this.aj = ab.a(context);
        E();
        al.c("com info create end", new Object[0]);
    }

    public static int B() {
        return ab.c();
    }

    @Deprecated
    public static boolean C() {
        al.a("Detect if the emulator is unavailable", new Object[0]);
        return false;
    }

    @Deprecated
    public static boolean D() {
        al.a("Detect if the device hook is unavailable", new Object[0]);
        return false;
    }

    private void E() {
        try {
            for (Map.Entry<String, ?> entry : this.P.getAll().entrySet()) {
                al.c("put reserved request data from sp, key:%s value:%s", entry.getKey(), entry.getValue());
                a(entry.getKey(), entry.getValue().toString(), false);
            }
            for (Map.Entry<String, String> entry2 : W.entrySet()) {
                al.c("put reserved request data from cache, key:%s value:%s", entry2.getKey(), entry2.getValue());
                a(entry2.getKey(), entry2.getValue(), true);
            }
            W.clear();
        } catch (Throwable th) {
            al.b(th);
        }
    }

    private String F() {
        if (TextUtils.isEmpty(this.ad)) {
            this.ad = ap.d("androidid", null);
        }
        return this.ad;
    }

    private static String G() {
        String uuid = UUID.randomUUID().toString();
        return !ap.b(uuid) ? uuid.replaceAll("-", "") : uuid;
    }

    public static synchronized aa b() {
        aa aaVar;
        synchronized (aa.class) {
            aaVar = aq;
        }
        return aaVar;
    }

    @Deprecated
    public static String n() {
        return "";
    }

    public final synchronized Map<String, PlugInBean> A() {
        Map<String, PlugInBean> map;
        map = this.ao;
        Map<String, PlugInBean> map2 = this.ap;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public final boolean a() {
        boolean z3 = this.ay.size() > 0;
        al.c("isAppForeground:%s", Boolean.valueOf(z3));
        return z3;
    }

    public final void c() {
        synchronized (this.au) {
            this.Y = UUID.randomUUID().toString();
        }
    }

    public final String d() {
        String str;
        synchronized (this.au) {
            if (this.Y == null) {
                c();
            }
            str = this.Y;
        }
        return str;
    }

    public final String e() {
        if (!ap.b(this.f50826e)) {
            return this.f50826e;
        }
        return this.f50839r;
    }

    public final String f() {
        String str;
        synchronized (this.V) {
            str = this.f50833l;
        }
        return str;
    }

    public final String g() {
        String str = this.aa;
        if (str != null) {
            return str;
        }
        String d4 = ap.d("deviceId", null);
        this.aa = d4;
        if (d4 != null) {
            return d4;
        }
        String F = F();
        this.aa = F;
        if (TextUtils.isEmpty(F)) {
            this.aa = G();
        }
        String str2 = this.aa;
        if (str2 != null) {
            ap.c("deviceId", str2);
            return this.aa;
        }
        return "";
    }

    public final synchronized String h() {
        String str = this.Z;
        if (str != null) {
            return str;
        }
        String d4 = ap.d("deviceModel", null);
        this.Z = d4;
        if (d4 != null) {
            al.c("collect device model from sp:%s", d4);
            return this.Z;
        } else if (!this.f50835n) {
            al.c("not allow collect device model", new Object[0]);
            return "fail";
        } else {
            String a4 = ab.a();
            this.Z = a4;
            al.c("collect device model:%s", a4);
            ap.c("deviceModel", this.Z);
            return this.Z;
        }
    }

    public final synchronized String i() {
        return this.ac;
    }

    public final long j() {
        if (this.ae <= 0) {
            this.ae = ab.e();
        }
        return this.ae;
    }

    public final long k() {
        if (this.af <= 0) {
            this.af = ab.i();
        }
        return this.af;
    }

    public final long l() {
        if (this.ag <= 0) {
            this.ag = ab.k();
        }
        return this.ag;
    }

    public final String m() {
        if (!TextUtils.isEmpty(this.ai)) {
            al.c("get cpu type from so:%s", this.ai);
            return this.ai;
        } else if (TextUtils.isEmpty(this.aj)) {
            return "unknown";
        } else {
            al.c("get cpu type from lib dir:%s", this.aj);
            return this.aj;
        }
    }

    public final String o() {
        try {
            Map<String, ?> all = this.X.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.T) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        this.K.put(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
        } catch (Throwable th) {
            al.a(th);
        }
        if (!this.K.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry2 : this.K.entrySet()) {
                sb.append("[");
                sb.append(entry2.getKey());
                sb.append(",");
                sb.append(entry2.getValue());
                sb.append("] ");
            }
            al.c("SDK_INFO = %s", sb.toString());
            b("SDK_INFO", sb.toString());
            return sb.toString();
        }
        al.c("SDK_INFO is empty", new Object[0]);
        return null;
    }

    public final synchronized Map<String, PlugInBean> p() {
        Map<String, PlugInBean> map = this.ak;
        if (map != null && map.size() > 0) {
            HashMap hashMap = new HashMap(this.ak.size());
            hashMap.putAll(this.ak);
            return hashMap;
        }
        return null;
    }

    public final String q() {
        if (this.al == null) {
            this.al = ab.m();
        }
        return this.al;
    }

    public final Boolean r() {
        if (this.am == null) {
            this.am = Boolean.valueOf(ab.q());
        }
        return this.am;
    }

    public final String s() {
        if (this.an == null) {
            String str = ab.n();
            this.an = str;
            al.a("ROM ID: %s", str);
        }
        return this.an;
    }

    public final Map<String, String> t() {
        synchronized (this.av) {
            if (this.ar.size() <= 0) {
                return null;
            }
            return new HashMap(this.ar);
        }
    }

    public final void u() {
        synchronized (this.av) {
            this.ar.clear();
        }
    }

    public final int v() {
        int size;
        synchronized (this.av) {
            size = this.ar.size();
        }
        return size;
    }

    public final Set<String> w() {
        Set<String> keySet;
        synchronized (this.av) {
            keySet = this.ar.keySet();
        }
        return keySet;
    }

    public final Map<String, String> x() {
        synchronized (this.ax) {
            if (this.as.size() <= 0) {
                return null;
            }
            return new HashMap(this.as);
        }
    }

    public final Map<String, String> y() {
        synchronized (this.aw) {
            if (this.at.size() <= 0) {
                return null;
            }
            return new HashMap(this.at);
        }
    }

    public final int z() {
        int i4;
        synchronized (this.U) {
            i4 = this.f50844w;
        }
        return i4;
    }

    public final void b(String str) {
        al.a("change deviceModel\uff0cold:%s new:%s", this.Z, str);
        this.Z = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ap.c("deviceModel", str);
    }

    public final void a(int i4, boolean z3) {
        al.c("setActivityForeState, hash:%s isFore:%s", Integer.valueOf(i4), Boolean.valueOf(z3));
        if (z3) {
            this.ay.add(Integer.valueOf(i4));
        } else {
            this.ay.remove(Integer.valueOf(i4));
            this.ay.remove((Object) 0);
        }
        q qVar = this.N;
        if (qVar != null) {
            qVar.setNativeIsAppForeground(this.ay.size() > 0);
        }
    }

    public final synchronized void c(String str) {
        this.ab = String.valueOf(str);
    }

    public final void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ai = str.trim();
    }

    public final String f(String str) {
        String remove;
        if (ap.b(str)) {
            al.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.av) {
            remove = this.ar.remove(str);
        }
        return remove;
    }

    public final void b(String str, String str2) {
        if (ap.b(str) || ap.b(str2)) {
            al.d("server key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.aw) {
            this.at.put(str, str2);
        }
    }

    public final synchronized void d(String str) {
        this.ac = String.valueOf(str);
    }

    public static synchronized aa a(Context context) {
        aa aaVar;
        synchronized (aa.class) {
            if (aq == null) {
                aq = new aa(context);
            }
            aaVar = aq;
        }
        return aaVar;
    }

    public final String g(String str) {
        String str2;
        if (ap.b(str)) {
            al.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.av) {
            str2 = this.ar.get(str);
        }
        return str2;
    }

    public final void a(String str) {
        this.aa = str;
        if (!TextUtils.isEmpty(str)) {
            ap.c("deviceId", str);
        }
        synchronized (this.ax) {
            this.as.put("E8", str);
        }
    }

    public final void a(String str, String str2) {
        if (ap.b(str) || ap.b(str2)) {
            al.d("key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.av) {
            this.ar.put(str, str2);
        }
    }

    private void a(String str, String str2, boolean z3) {
        if (ap.b(str)) {
            al.d("key should not be empty %s", str);
            return;
        }
        al.c("putExtraRequestData key:%s value:%s save:%s", str, str2, Boolean.valueOf(z3));
        synchronized (this.ax) {
            if (TextUtils.isEmpty(str2)) {
                this.as.remove(str);
                this.P.edit().remove(str).apply();
            } else {
                this.as.put(str, str2);
                if (z3) {
                    this.P.edit().putString(str, str2).apply();
                }
            }
        }
    }
}
