package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.aa */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12786aa {

    /* renamed from: W */
    private static final Map<String, String> f36397W = new HashMap();

    /* renamed from: aq */
    private static C12786aa f36398aq = null;

    /* renamed from: D */
    public boolean f36402D;

    /* renamed from: E */
    public String f36403E;

    /* renamed from: F */
    public String f36404F;

    /* renamed from: G */
    public String f36405G;

    /* renamed from: H */
    public String f36406H;

    /* renamed from: J */
    public boolean f36408J;

    /* renamed from: O */
    public final SharedPreferences f36413O;

    /* renamed from: P */
    public final SharedPreferences f36414P;

    /* renamed from: X */
    private final Context f36421X;

    /* renamed from: Y */
    private String f36422Y;

    /* renamed from: Z */
    private String f36423Z;

    /* renamed from: aa */
    private String f36425aa;

    /* renamed from: aj */
    private String f36434aj;

    /* renamed from: c */
    public String f36450c;

    /* renamed from: d */
    public final String f36451d;

    /* renamed from: e */
    public String f36452e;

    /* renamed from: k */
    public final String f36458k;

    /* renamed from: o */
    public String f36462o;

    /* renamed from: p */
    public int f36463p;

    /* renamed from: q */
    public String f36464q;

    /* renamed from: r */
    public String f36465r;

    /* renamed from: s */
    public String f36466s;

    /* renamed from: v */
    public List<String> f36469v;

    /* renamed from: f */
    public boolean f36453f = true;

    /* renamed from: g */
    public final String f36454g = "com.tencent.bugly";

    /* renamed from: h */
    public String f36455h = "4.1.9.3";

    /* renamed from: i */
    public final String f36456i = "";
    @Deprecated

    /* renamed from: j */
    public final String f36457j = "";

    /* renamed from: l */
    public String f36459l = "unknown";

    /* renamed from: ab */
    private String f36426ab = "unknown";

    /* renamed from: ac */
    private String f36427ac = "";

    /* renamed from: m */
    public long f36460m = 0;

    /* renamed from: ad */
    private String f36428ad = null;

    /* renamed from: ae */
    private long f36429ae = -1;

    /* renamed from: af */
    private long f36430af = -1;

    /* renamed from: ag */
    private long f36431ag = -1;

    /* renamed from: ah */
    private String f36432ah = null;

    /* renamed from: ai */
    private String f36433ai = null;

    /* renamed from: ak */
    private Map<String, PlugInBean> f36435ak = null;

    /* renamed from: n */
    public boolean f36461n = false;

    /* renamed from: al */
    private String f36436al = null;

    /* renamed from: am */
    private Boolean f36437am = null;

    /* renamed from: an */
    private String f36438an = null;

    /* renamed from: t */
    public String f36467t = null;

    /* renamed from: u */
    public String f36468u = null;

    /* renamed from: ao */
    private Map<String, PlugInBean> f36439ao = null;

    /* renamed from: ap */
    private Map<String, PlugInBean> f36440ap = null;

    /* renamed from: w */
    public int f36470w = -1;

    /* renamed from: x */
    public int f36471x = -1;

    /* renamed from: ar */
    private final Map<String, String> f36441ar = new HashMap();

    /* renamed from: as */
    private final Map<String, String> f36442as = new HashMap();

    /* renamed from: at */
    private final Map<String, String> f36443at = new HashMap();

    /* renamed from: y */
    public String f36472y = "unknown";

    /* renamed from: z */
    public long f36473z = 0;

    /* renamed from: A */
    public long f36399A = 0;

    /* renamed from: B */
    public long f36400B = 0;

    /* renamed from: C */
    public long f36401C = 0;

    /* renamed from: I */
    public boolean f36407I = false;

    /* renamed from: K */
    public HashMap<String, String> f36409K = new HashMap<>();

    /* renamed from: L */
    public List<String> f36410L = new ArrayList();

    /* renamed from: M */
    public boolean f36411M = false;

    /* renamed from: N */
    public InterfaceC12905q f36412N = null;

    /* renamed from: Q */
    public boolean f36415Q = true;

    /* renamed from: R */
    public boolean f36416R = true;

    /* renamed from: S */
    public boolean f36417S = false;

    /* renamed from: au */
    private final Object f36444au = new Object();

    /* renamed from: T */
    public final Object f36418T = new Object();

    /* renamed from: av */
    private final Object f36445av = new Object();

    /* renamed from: aw */
    private final Object f36446aw = new Object();

    /* renamed from: U */
    public final Object f36419U = new Object();

    /* renamed from: V */
    public final Object f36420V = new Object();

    /* renamed from: ax */
    private final Object f36447ax = new Object();

    /* renamed from: ay */
    private final List<Integer> f36448ay = new ArrayList();

    /* renamed from: a */
    public final long f36424a = System.currentTimeMillis();

    /* renamed from: b */
    public final byte f36449b = 1;

    private C12786aa(Context context) {
        this.f36434aj = null;
        this.f36462o = null;
        this.f36464q = null;
        this.f36465r = null;
        this.f36466s = null;
        this.f36469v = null;
        this.f36402D = false;
        this.f36403E = null;
        this.f36404F = null;
        this.f36405G = null;
        this.f36406H = "";
        this.f36408J = false;
        this.f36421X = C12828ap.m15844a(context);
        PackageInfo m15474b = C12924z.m15474b(context);
        if (m15474b != null) {
            try {
                String str = m15474b.versionName;
                this.f36462o = str;
                this.f36403E = str;
                this.f36404F = Integer.toString(m15474b.versionCode);
            } catch (Throwable th) {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f36450c = C12924z.m15476a(context);
        this.f36451d = C12924z.m15478a(Process.myPid());
        this.f36464q = C12924z.m15473c(context);
        this.f36458k = "Android " + C12787ab.m15971b() + ",level " + C12787ab.m15969c();
        Map<String, String> m15472d = C12924z.m15472d(context);
        if (m15472d != null) {
            try {
                this.f36469v = C12924z.m15475a(m15472d);
                String str2 = m15472d.get("BUGLY_APPID");
                if (str2 != null) {
                    this.f36465r = str2;
                    m16003b("APP_ID", str2);
                }
                String str3 = m15472d.get("BUGLY_APP_VERSION");
                if (str3 != null) {
                    this.f36462o = str3;
                }
                String str4 = m15472d.get("BUGLY_APP_CHANNEL");
                if (str4 != null) {
                    this.f36466s = str4;
                }
                String str5 = m15472d.get("BUGLY_ENABLE_DEBUG");
                if (str5 != null) {
                    this.f36402D = str5.equalsIgnoreCase("true");
                }
                String str6 = m15472d.get("com.tencent.rdm.uuid");
                if (str6 != null) {
                    this.f36405G = str6;
                }
                String str7 = m15472d.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str7)) {
                    this.f36463p = Integer.parseInt(str7);
                }
                String str8 = m15472d.get("BUGLY_AREA");
                if (str8 != null) {
                    this.f36406H = str8;
                }
            } catch (Throwable th2) {
                if (!C12820al.m15877a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.f36408J = true;
                C12820al.m15874c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (C12904p.f36892c) {
                th3.printStackTrace();
            }
        }
        this.f36413O = C12828ap.m15832a("BUGLY_COMMON_VALUES", context);
        this.f36414P = C12828ap.m15832a("BUGLY_RESERVED_VALUES", context);
        this.f36434aj = C12787ab.m15972a(context);
        m16014E();
        C12820al.m15874c("com info create end", new Object[0]);
    }

    /* renamed from: B */
    public static int m16017B() {
        return C12787ab.m15969c();
    }

    @Deprecated
    /* renamed from: C */
    public static boolean m16016C() {
        C12820al.m15878a("Detect if the emulator is unavailable", new Object[0]);
        return false;
    }

    @Deprecated
    /* renamed from: D */
    public static boolean m16015D() {
        C12820al.m15878a("Detect if the device hook is unavailable", new Object[0]);
        return false;
    }

    /* renamed from: E */
    private void m16014E() {
        try {
            for (Map.Entry<String, ?> entry : this.f36414P.getAll().entrySet()) {
                C12820al.m15874c("put reserved request data from sp, key:%s value:%s", entry.getKey(), entry.getValue());
                m16006a(entry.getKey(), entry.getValue().toString(), false);
            }
            for (Map.Entry<String, String> entry2 : f36397W.entrySet()) {
                C12820al.m15874c("put reserved request data from cache, key:%s value:%s", entry2.getKey(), entry2.getValue());
                m16006a(entry2.getKey(), entry2.getValue(), true);
            }
            f36397W.clear();
        } catch (Throwable th) {
            C12820al.m15875b(th);
        }
    }

    /* renamed from: F */
    private String m16013F() {
        if (TextUtils.isEmpty(this.f36428ad)) {
            this.f36428ad = C12828ap.m15808d("androidid", null);
        }
        return this.f36428ad;
    }

    /* renamed from: G */
    private static String m16012G() {
        String uuid = UUID.randomUUID().toString();
        return !C12828ap.m15817b(uuid) ? uuid.replaceAll("-", "") : uuid;
    }

    /* renamed from: b */
    public static synchronized C12786aa m16005b() {
        C12786aa c12786aa;
        synchronized (C12786aa.class) {
            c12786aa = f36398aq;
        }
        return c12786aa;
    }

    @Deprecated
    /* renamed from: n */
    public static String m15986n() {
        return "";
    }

    /* renamed from: A */
    public final synchronized Map<String, PlugInBean> m16018A() {
        Map<String, PlugInBean> map;
        map = this.f36439ao;
        Map<String, PlugInBean> map2 = this.f36440ap;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    /* renamed from: a */
    public final boolean m16011a() {
        boolean z = this.f36448ay.size() > 0;
        C12820al.m15874c("isAppForeground:%s", Boolean.valueOf(z));
        return z;
    }

    /* renamed from: c */
    public final void m16002c() {
        synchronized (this.f36444au) {
            this.f36422Y = UUID.randomUUID().toString();
        }
    }

    /* renamed from: d */
    public final String m16000d() {
        String str;
        synchronized (this.f36444au) {
            if (this.f36422Y == null) {
                m16002c();
            }
            str = this.f36422Y;
        }
        return str;
    }

    /* renamed from: e */
    public final String m15998e() {
        if (!C12828ap.m15817b(this.f36452e)) {
            return this.f36452e;
        }
        return this.f36465r;
    }

    /* renamed from: f */
    public final String m15996f() {
        String str;
        synchronized (this.f36420V) {
            str = this.f36459l;
        }
        return str;
    }

    /* renamed from: g */
    public final String m15994g() {
        String str = this.f36425aa;
        if (str != null) {
            return str;
        }
        String m15808d = C12828ap.m15808d("deviceId", null);
        this.f36425aa = m15808d;
        if (m15808d != null) {
            return m15808d;
        }
        String m16013F = m16013F();
        this.f36425aa = m16013F;
        if (TextUtils.isEmpty(m16013F)) {
            this.f36425aa = m16012G();
        }
        String str2 = this.f36425aa;
        if (str2 != null) {
            C12828ap.m15811c("deviceId", str2);
            return this.f36425aa;
        }
        return "";
    }

    /* renamed from: h */
    public final synchronized String m15992h() {
        String str = this.f36423Z;
        if (str != null) {
            return str;
        }
        String m15808d = C12828ap.m15808d("deviceModel", null);
        this.f36423Z = m15808d;
        if (m15808d != null) {
            C12820al.m15874c("collect device model from sp:%s", m15808d);
            return this.f36423Z;
        } else if (!this.f36461n) {
            C12820al.m15874c("not allow collect device model", new Object[0]);
            return CommonNetImpl.FAIL;
        } else {
            String m15973a = C12787ab.m15973a();
            this.f36423Z = m15973a;
            C12820al.m15874c("collect device model:%s", m15973a);
            C12828ap.m15811c("deviceModel", this.f36423Z);
            return this.f36423Z;
        }
    }

    /* renamed from: i */
    public final synchronized String m15991i() {
        return this.f36427ac;
    }

    /* renamed from: j */
    public final long m15990j() {
        if (this.f36429ae <= 0) {
            this.f36429ae = C12787ab.m15966e();
        }
        return this.f36429ae;
    }

    /* renamed from: k */
    public final long m15989k() {
        if (this.f36430af <= 0) {
            this.f36430af = C12787ab.m15962i();
        }
        return this.f36430af;
    }

    /* renamed from: l */
    public final long m15988l() {
        if (this.f36431ag <= 0) {
            this.f36431ag = C12787ab.m15960k();
        }
        return this.f36431ag;
    }

    /* renamed from: m */
    public final String m15987m() {
        if (!TextUtils.isEmpty(this.f36433ai)) {
            C12820al.m15874c("get cpu type from so:%s", this.f36433ai);
            return this.f36433ai;
        } else if (TextUtils.isEmpty(this.f36434aj)) {
            return "unknown";
        } else {
            C12820al.m15874c("get cpu type from lib dir:%s", this.f36434aj);
            return this.f36434aj;
        }
    }

    /* renamed from: o */
    public final String m15985o() {
        try {
            Map<String, ?> all = this.f36421X.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.f36418T) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        this.f36409K.put(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
        } catch (Throwable th) {
            C12820al.m15877a(th);
        }
        if (!this.f36409K.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry2 : this.f36409K.entrySet()) {
                sb.append("[");
                sb.append(entry2.getKey());
                sb.append(",");
                sb.append(entry2.getValue());
                sb.append("] ");
            }
            C12820al.m15874c("SDK_INFO = %s", sb.toString());
            m16003b("SDK_INFO", sb.toString());
            return sb.toString();
        }
        C12820al.m15874c("SDK_INFO is empty", new Object[0]);
        return null;
    }

    /* renamed from: p */
    public final synchronized Map<String, PlugInBean> m15984p() {
        Map<String, PlugInBean> map = this.f36435ak;
        if (map != null && map.size() > 0) {
            HashMap hashMap = new HashMap(this.f36435ak.size());
            hashMap.putAll(this.f36435ak);
            return hashMap;
        }
        return null;
    }

    /* renamed from: q */
    public final String m15983q() {
        if (this.f36436al == null) {
            this.f36436al = C12787ab.m15958m();
        }
        return this.f36436al;
    }

    /* renamed from: r */
    public final Boolean m15982r() {
        if (this.f36437am == null) {
            this.f36437am = Boolean.valueOf(C12787ab.m15954q());
        }
        return this.f36437am;
    }

    /* renamed from: s */
    public final String m15981s() {
        if (this.f36438an == null) {
            String str = C12787ab.m15957n();
            this.f36438an = str;
            C12820al.m15878a("ROM ID: %s", str);
        }
        return this.f36438an;
    }

    /* renamed from: t */
    public final Map<String, String> m15980t() {
        synchronized (this.f36445av) {
            if (this.f36441ar.size() <= 0) {
                return null;
            }
            return new HashMap(this.f36441ar);
        }
    }

    /* renamed from: u */
    public final void m15979u() {
        synchronized (this.f36445av) {
            this.f36441ar.clear();
        }
    }

    /* renamed from: v */
    public final int m15978v() {
        int size;
        synchronized (this.f36445av) {
            size = this.f36441ar.size();
        }
        return size;
    }

    /* renamed from: w */
    public final Set<String> m15977w() {
        Set<String> keySet;
        synchronized (this.f36445av) {
            keySet = this.f36441ar.keySet();
        }
        return keySet;
    }

    /* renamed from: x */
    public final Map<String, String> m15976x() {
        synchronized (this.f36447ax) {
            if (this.f36442as.size() <= 0) {
                return null;
            }
            return new HashMap(this.f36442as);
        }
    }

    /* renamed from: y */
    public final Map<String, String> m15975y() {
        synchronized (this.f36446aw) {
            if (this.f36443at.size() <= 0) {
                return null;
            }
            return new HashMap(this.f36443at);
        }
    }

    /* renamed from: z */
    public final int m15974z() {
        int i;
        synchronized (this.f36419U) {
            i = this.f36470w;
        }
        return i;
    }

    /* renamed from: b */
    public final void m16004b(String str) {
        C12820al.m15878a("change deviceModel，old:%s new:%s", this.f36423Z, str);
        this.f36423Z = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C12828ap.m15811c("deviceModel", str);
    }

    /* renamed from: a */
    public final void m16010a(int i, boolean z) {
        C12820al.m15874c("setActivityForeState, hash:%s isFore:%s", Integer.valueOf(i), Boolean.valueOf(z));
        if (z) {
            this.f36448ay.add(Integer.valueOf(i));
        } else {
            this.f36448ay.remove(Integer.valueOf(i));
            this.f36448ay.remove((Object) 0);
        }
        InterfaceC12905q interfaceC12905q = this.f36412N;
        if (interfaceC12905q != null) {
            interfaceC12905q.setNativeIsAppForeground(this.f36448ay.size() > 0);
        }
    }

    /* renamed from: c */
    public final synchronized void m16001c(String str) {
        this.f36426ab = String.valueOf(str);
    }

    /* renamed from: e */
    public final void m15997e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f36433ai = str.trim();
    }

    /* renamed from: f */
    public final String m15995f(String str) {
        String remove;
        if (C12828ap.m15817b(str)) {
            C12820al.m15873d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.f36445av) {
            remove = this.f36441ar.remove(str);
        }
        return remove;
    }

    /* renamed from: b */
    public final void m16003b(String str, String str2) {
        if (C12828ap.m15817b(str) || C12828ap.m15817b(str2)) {
            C12820al.m15873d("server key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.f36446aw) {
            this.f36443at.put(str, str2);
        }
    }

    /* renamed from: d */
    public final synchronized void m15999d(String str) {
        this.f36427ac = String.valueOf(str);
    }

    /* renamed from: a */
    public static synchronized C12786aa m16009a(Context context) {
        C12786aa c12786aa;
        synchronized (C12786aa.class) {
            if (f36398aq == null) {
                f36398aq = new C12786aa(context);
            }
            c12786aa = f36398aq;
        }
        return c12786aa;
    }

    /* renamed from: g */
    public final String m15993g(String str) {
        String str2;
        if (C12828ap.m15817b(str)) {
            C12820al.m15873d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.f36445av) {
            str2 = this.f36441ar.get(str);
        }
        return str2;
    }

    /* renamed from: a */
    public final void m16008a(String str) {
        this.f36425aa = str;
        if (!TextUtils.isEmpty(str)) {
            C12828ap.m15811c("deviceId", str);
        }
        synchronized (this.f36447ax) {
            this.f36442as.put("E8", str);
        }
    }

    /* renamed from: a */
    public final void m16007a(String str, String str2) {
        if (C12828ap.m15817b(str) || C12828ap.m15817b(str2)) {
            C12820al.m15873d("key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.f36445av) {
            this.f36441ar.put(str, str2);
        }
    }

    /* renamed from: a */
    private void m16006a(String str, String str2, boolean z) {
        if (C12828ap.m15817b(str)) {
            C12820al.m15873d("key should not be empty %s", str);
            return;
        }
        C12820al.m15874c("putExtraRequestData key:%s value:%s save:%s", str, str2, Boolean.valueOf(z));
        synchronized (this.f36447ax) {
            if (TextUtils.isEmpty(str2)) {
                this.f36442as.remove(str);
                this.f36414P.edit().remove(str).apply();
            } else {
                this.f36442as.put(str, str2);
                if (z) {
                    this.f36414P.edit().putString(str, str2).apply();
                }
            }
        }
    }
}
