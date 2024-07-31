package com.amap.api.col.p047s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p047s.AbstractC2044dz;
import com.amap.api.col.p047s.C2202x2;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.mbridge.msdk.MBridgeConstans;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import p011a.R8$$SyntheticClass;

/* compiled from: AuthConfigManager.java */
/* renamed from: com.amap.api.col.s.y0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2212y0 {

    /* renamed from: D */
    private static volatile boolean f6750D = false;

    /* renamed from: a */
    public static int f6752a = -1;

    /* renamed from: b */
    public static String f6753b = "";

    /* renamed from: c */
    private static String f6754c = "6";

    /* renamed from: d */
    private static String f6755d = "4";

    /* renamed from: e */
    private static String f6756e = "9";

    /* renamed from: f */
    private static String f6757f = "8";

    /* renamed from: g */
    public static Context f6758g = null;

    /* renamed from: h */
    private static volatile boolean f6759h = true;

    /* renamed from: i */
    private static Vector<C2220f> f6760i = new Vector<>();

    /* renamed from: j */
    private static Map<String, Integer> f6761j = new HashMap();

    /* renamed from: k */
    private static String f6762k = null;

    /* renamed from: l */
    private static long f6763l = 0;

    /* renamed from: m */
    public static volatile boolean f6764m = false;

    /* renamed from: n */
    private static volatile ConcurrentHashMap<String, C2222h> f6765n = new ConcurrentHashMap<>(8);

    /* renamed from: o */
    private static volatile ConcurrentHashMap<String, Long> f6766o = new ConcurrentHashMap<>(8);

    /* renamed from: p */
    private static volatile ConcurrentHashMap<String, C2219e> f6767p = new ConcurrentHashMap<>(8);

    /* renamed from: q */
    private static boolean f6768q = false;

    /* renamed from: r */
    private static boolean f6769r = false;

    /* renamed from: s */
    public static int f6770s = 5000;

    /* renamed from: t */
    public static boolean f6771t = true;

    /* renamed from: u */
    public static boolean f6772u = false;

    /* renamed from: v */
    private static int f6773v = 3;

    /* renamed from: w */
    public static boolean f6774w = true;

    /* renamed from: x */
    public static boolean f6775x = false;

    /* renamed from: y */
    private static int f6776y = 3;

    /* renamed from: z */
    public static boolean f6777z = false;

    /* renamed from: A */
    private static ConcurrentHashMap<String, Boolean> f6747A = new ConcurrentHashMap<>();

    /* renamed from: B */
    private static ConcurrentHashMap<String, Boolean> f6748B = new ConcurrentHashMap<>();

    /* renamed from: C */
    private static ArrayList<C2202x2.C2203a> f6749C = new ArrayList<>();

    /* renamed from: E */
    private static Queue<C2202x2.C2205c> f6751E = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.s.y0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2213a extends AbstractRunnableC2229z3 {

        /* renamed from: b */
        final /* synthetic */ String f6778b;

        /* renamed from: c */
        final /* synthetic */ String f6779c;

        /* renamed from: d */
        final /* synthetic */ String f6780d;

        /* renamed from: e */
        final /* synthetic */ String f6781e;

        C2213a(String str, String str2, String str3, String str4) {
            this.f6778b = str;
            this.f6779c = str2;
            this.f6780d = str3;
            this.f6781e = str4;
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            C2219e c2219e = (C2219e) C2212y0.f6767p.get(this.f6778b);
            if (c2219e == null) {
                return;
            }
            InterfaceC2214b interfaceC2214b = c2219e.f6802c;
            C2215c m52230b = C2212y0.m52230b(C2212y0.f6758g, c2219e.f6800a, c2219e.f6801b, this.f6779c, this.f6780d, this.f6781e);
            if (m52230b == null || interfaceC2214b == null) {
                return;
            }
            interfaceC2214b.mo52205a(m52230b);
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.s.y0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2214b {
        /* renamed from: a */
        void mo52205a(C2215c c2215c);
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.s.y0$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2215c {
        @Deprecated

        /* renamed from: a */
        public JSONObject f6782a;
        @Deprecated

        /* renamed from: b */
        public JSONObject f6783b;

        /* renamed from: c */
        public String f6784c;

        /* renamed from: d */
        public int f6785d = -1;

        /* renamed from: e */
        public long f6786e = 0;

        /* renamed from: f */
        public JSONObject f6787f;

        /* renamed from: g */
        public C2216a f6788g;

        /* renamed from: h */
        public C2217b f6789h;

        /* renamed from: i */
        private boolean f6790i;

        /* compiled from: AuthConfigManager.java */
        /* renamed from: com.amap.api.col.s.y0$c$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static class C2216a {

            /* renamed from: a */
            public boolean f6791a;

            /* renamed from: b */
            public boolean f6792b;

            /* renamed from: c */
            public JSONObject f6793c;
        }

        /* compiled from: AuthConfigManager.java */
        /* renamed from: com.amap.api.col.s.y0$c$b */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static class C2217b {

            /* renamed from: a */
            public boolean f6794a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.s.y0$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2218d extends AbstractC2188v2 {

        /* renamed from: p */
        private String f6795p;

        /* renamed from: q */
        private Map<String, String> f6796q;

        /* renamed from: r */
        private String f6797r;

        /* renamed from: s */
        private String f6798s;

        /* renamed from: t */
        private String f6799t;

        C2218d(Context context, C2073i1 c2073i1, String str, String str2, String str3, String str4) {
            super(context, c2073i1);
            this.f6795p = str;
            this.f6796q = null;
            this.f6797r = str2;
            this.f6798s = str3;
            this.f6799t = str4;
            m53061g(AbstractC2044dz.EnumC2047c.HTTPS);
            m53063e(AbstractC2044dz.EnumC2045a.FIX);
        }

        /* renamed from: P */
        private static String m52201P(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        @Override // com.amap.api.col.p047s.AbstractC2188v2
        /* renamed from: L */
        public final byte[] mo52203L() {
            String m53193K = C2023c1.m53193K(this.f6615m);
            if (!TextUtils.isEmpty(m53193K)) {
                m53193K = C2059g1.m52992a(new StringBuilder(m53193K).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f6795p) ? "" : this.f6795p);
            hashMap.put("plattype", FaceEnvironment.f8430OS);
            hashMap.put("ccver", "1");
            hashMap.put("product", this.f6616n.m52918d());
            hashMap.put(ConstantHelper.LOG_VS, this.f6616n.m52917e());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", m53193K);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.f6796q;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.f6796q);
            }
            hashMap.put("abitype", C2079j1.m52873d(this.f6615m));
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, this.f6616n.m52915g());
            return C2079j1.m52862o(C2079j1.m52871f(hashMap));
        }

        @Override // com.amap.api.col.p047s.AbstractC2188v2
        /* renamed from: M */
        protected final String mo52202M() {
            return SocializeConstants.PROTOCOL_VERSON;
        }

        @Override // com.amap.api.col.p047s.AbstractC2054f1, com.amap.api.col.p047s.AbstractC2044dz
        /* renamed from: a */
        public final String mo52200a() {
            return m52201P("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.f6798s);
        }

        @Override // com.amap.api.col.p047s.AbstractC2044dz
        /* renamed from: h */
        public final String mo52180h() {
            return m52201P("https://restsdk.amap.com/v3/iasdkauth", this.f6797r);
        }

        @Override // com.amap.api.col.p047s.AbstractC2044dz
        /* renamed from: p */
        public final Map<String, String> mo52199p() {
            if (TextUtils.isEmpty(this.f6799t)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f6799t);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.col.p047s.AbstractC2044dz
        /* renamed from: r */
        public final String mo52198r() {
            if (!TextUtils.isEmpty(this.f6799t)) {
                return this.f6799t;
            }
            return super.mo52198r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.s.y0$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2219e {

        /* renamed from: a */
        C2073i1 f6800a;

        /* renamed from: b */
        String f6801b;

        /* renamed from: c */
        InterfaceC2214b f6802c;

        private C2219e() {
        }

        /* synthetic */ C2219e(byte b) {
            this();
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.s.y0$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2220f {

        /* renamed from: a */
        private String f6803a;

        /* renamed from: b */
        private String f6804b;

        /* renamed from: c */
        private AtomicInteger f6805c;

        public C2220f(String str, String str2, int i) {
            this.f6803a = str;
            this.f6804b = str2;
            this.f6805c = new AtomicInteger(i);
        }

        /* renamed from: d */
        public static C2220f m52194d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new C2220f(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }

        /* renamed from: a */
        public final int m52197a() {
            AtomicInteger atomicInteger = this.f6805c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        /* renamed from: c */
        public final void m52195c(String str) {
            this.f6804b = str;
        }

        /* renamed from: e */
        public final String m52193e() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f6803a);
                jSONObject.put("f", this.f6804b);
                jSONObject.put("h", this.f6805c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.s.y0$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2221g {

        /* renamed from: a */
        public static boolean f6806a = true;

        /* renamed from: b */
        public static boolean f6807b = false;

        /* renamed from: c */
        public static boolean f6808c = true;

        /* renamed from: d */
        public static int f6809d;

        /* renamed from: e */
        public static boolean f6810e;

        /* renamed from: f */
        public static int f6811f;
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.s.y0$h */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2222h {

        /* renamed from: a */
        public long f6812a;

        /* renamed from: b */
        public String f6813b;

        C2222h(Long l, String str) {
            this.f6812a = 0L;
            this.f6813b = "";
            this.f6812a = l.longValue();
            this.f6813b = str;
        }
    }

    /* renamed from: A */
    private static void m52252A(Context context) {
        if (context == null) {
            return;
        }
        f6759h = C2080j2.m52839l(context, "open_common", "a2", true);
    }

    /* renamed from: B */
    public static void m52251B(C2202x2.C2205c c2205c) {
        synchronized (f6749C) {
            boolean z = false;
            for (int i = 0; i < f6749C.size(); i++) {
                C2202x2.C2203a c2203a = f6749C.get(i);
                if (c2205c.f6696c.equals(c2203a.f6683b) && c2205c.f6697d.equals(c2203a.f6686e)) {
                    int i2 = c2205c.f6706m;
                    int i3 = c2203a.f6687f;
                    if (i2 == i3) {
                        if (i3 == 1) {
                            c2203a.f6690i = ((c2203a.f6691j.get() * c2203a.f6690i) + c2205c.f6699f) / (c2203a.f6691j.get() + 1);
                        }
                        c2203a.f6691j.getAndIncrement();
                        z = true;
                    }
                }
            }
            if (!z) {
                f6749C.add(new C2202x2.C2203a(c2205c));
            }
            C2202x2.m52305i();
        }
    }

    /* renamed from: C */
    public static synchronized void m52250C(String str, boolean z) {
        synchronized (C2212y0.class) {
            m52217o(str, z, null, null, null);
        }
    }

    /* renamed from: D */
    public static boolean m52249D() {
        Integer num;
        Context context = f6758g;
        if (context == null) {
            return false;
        }
        String m53195I = C2023c1.m53195I(context);
        return (TextUtils.isEmpty(m53195I) || (num = f6761j.get(m53195I.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    /* renamed from: E */
    public static String m52248E(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + ";15K;16H;17I;1A4;17S;183";
    }

    /* renamed from: F */
    public static void m52247F() {
        try {
            C2220f m52229c = m52229c(f6758g, "IPV6_CONFIG_NAME", "open_common");
            String m52874c = C2079j1.m52874c(System.currentTimeMillis(), "yyyyMMdd");
            if (!m52874c.equals(m52229c.f6804b)) {
                m52229c.m52195c(m52874c);
                m52229c.f6805c.set(0);
            }
            m52229c.f6805c.incrementAndGet();
            m52222j(f6758g, "IPV6_CONFIG_NAME", "open_common", m52229c);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: G */
    private static void m52246G(Context context) {
        if (context == null) {
            return;
        }
        f6771t = C2080j2.m52839l(context, "open_common", "a13", true);
        f6774w = C2080j2.m52839l(context, "open_common", "a6", true);
        f6772u = C2080j2.m52839l(context, "open_common", "a7", false);
        f6770s = C2080j2.m52850a(context, "open_common", "a8", 5000);
        f6773v = C2080j2.m52850a(context, "open_common", "a9", 3);
        f6775x = C2080j2.m52839l(context, "open_common", "a10", false);
        f6776y = C2080j2.m52850a(context, "open_common", "a11", 3);
        f6777z = C2080j2.m52839l(context, "open_common", "a12", false);
    }

    /* renamed from: H */
    public static void m52245H(C2202x2.C2205c c2205c) {
        if (c2205c != null && f6777z) {
            synchronized (f6751E) {
                f6751E.offer(c2205c);
                C2202x2.m52305i();
            }
        }
    }

    /* renamed from: I */
    public static void m52244I() {
        if (f6764m) {
            return;
        }
        try {
            Context context = f6758g;
            if (context == null) {
                return;
            }
            f6764m = true;
            C2048e1.m53039a().m53037c(context);
            m52252A(context);
            m52246G(context);
            C2221g.f6806a = C2080j2.m52839l(context, "open_common", "ucf", C2221g.f6806a);
            C2221g.f6807b = C2080j2.m52839l(context, "open_common", "fsv2", C2221g.f6807b);
            C2221g.f6808c = C2080j2.m52839l(context, "open_common", "usc", C2221g.f6808c);
            C2221g.f6809d = C2080j2.m52850a(context, "open_common", "umv", C2221g.f6809d);
            C2221g.f6810e = C2080j2.m52839l(context, "open_common", "ust", C2221g.f6810e);
            C2221g.f6811f = C2080j2.m52850a(context, "open_common", "ustv", C2221g.f6811f);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: J */
    private static void m52243J(Context context) {
        try {
            if (f6768q) {
                return;
            }
            C2139s1.f6470e = C2080j2.m52839l(context, "open_common", "a4", true);
            C2139s1.f6471f = C2080j2.m52839l(context, "open_common", "a5", true);
            f6768q = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: K */
    public static synchronized boolean m52242K(String str) {
        synchronized (C2212y0.class) {
            try {
            } finally {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f6767p == null) {
                return false;
            }
            if (f6766o == null) {
                f6766o = new ConcurrentHashMap<>(8);
            }
            if (f6767p.containsKey(str) && !f6766o.containsKey(str)) {
                f6766o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    /* renamed from: L */
    public static C2202x2.C2203a m52241L() {
        if (f6750D) {
            return null;
        }
        synchronized (f6749C) {
            if (f6750D) {
                return null;
            }
            Collections.sort(f6749C);
            if (f6749C.size() > 0) {
                C2202x2.C2203a clone = f6749C.get(0).clone();
                f6750D = true;
                return clone;
            }
            return null;
        }
    }

    /* renamed from: M */
    private static void m52240M(Context context) {
        try {
            if (f6769r) {
                return;
            }
            C2089l1.f6268d = m52211u(C2080j2.m52836o(context, "open_common", "a16", ""), true);
            C2089l1.f6266b = C2080j2.m52849b(context, "open_common", "a17", C2089l1.f6265a);
            f6769r = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: N */
    public static synchronized void m52239N(String str) {
        synchronized (C2212y0.class) {
            if (f6766o == null) {
                return;
            }
            if (f6766o.containsKey(str)) {
                f6766o.remove(str);
            }
        }
    }

    /* renamed from: O */
    public static synchronized C2222h m52238O(String str) {
        synchronized (C2212y0.class) {
            try {
                if (f6765n == null) {
                    f6765n = new ConcurrentHashMap<>(8);
                }
                if (f6765n.containsKey(str)) {
                    return f6765n.get(str);
                }
                return new C2222h(0L, "");
            }
        }
    }

    /* renamed from: P */
    public static C2202x2.C2205c m52237P() {
        synchronized (f6751E) {
            C2202x2.C2205c poll = f6751E.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    /* renamed from: R */
    public static boolean m52235R(String str) {
        C2220f m52229c;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (f6771t) {
                if (f6747A.get(str) == null) {
                    Context context = f6758g;
                    if (context == null || (m52229c = m52229c(context, m52207y(str, "a14"), "open_common")) == null) {
                        return true;
                    }
                    return m52229c.m52197a() < f6773v;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: S */
    private static void m52234S() {
        try {
            Context context = f6758g;
            if (context != null) {
                String m53195I = C2023c1.m53195I(context);
                if (!TextUtils.isEmpty(f6762k) && !TextUtils.isEmpty(m53195I) && f6762k.equals(m53195I) && System.currentTimeMillis() - f6763l < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(m53195I)) {
                    f6762k = m53195I;
                }
            } else if (System.currentTimeMillis() - f6763l < 10000) {
                return;
            }
            f6763l = System.currentTimeMillis();
            f6761j.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!m52210v((Inet6Address) address)) {
                                i |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!m52210v(inet4Address) && !inet4Address.getHostAddress().startsWith(C2079j1.m52857t("FMTkyLjE2OC40My4"))) {
                                i |= 1;
                            }
                        }
                    }
                    if (i != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            f6761j.put("WIFI", Integer.valueOf(i));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            f6761j.put("MOBILE", Integer.valueOf(i));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C2041d2.m53085e(th, "at", "ipstack");
        }
    }

    /* renamed from: T */
    public static boolean m52233T(String str) {
        C2220f m52229c;
        if (!TextUtils.isEmpty(str) && f6775x) {
            if (f6748B.get(str) == null) {
                Context context = f6758g;
                if (context == null || (m52229c = m52229c(context, m52207y(str, "a15"), "open_common")) == null) {
                    return true;
                }
                return m52229c.m52197a() < f6776y;
            }
            return false;
        }
        return false;
    }

    /* renamed from: U */
    private static boolean m52232U() {
        Integer num;
        Context context = f6758g;
        if (context == null) {
            return false;
        }
        String m53195I = C2023c1.m53195I(context);
        return (TextUtils.isEmpty(m53195I) || (num = f6761j.get(m53195I.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    /* renamed from: a */
    public static long m52231a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    String str = list.get(0);
                    if (TextUtils.isEmpty(str)) {
                        return 0L;
                    }
                    return Long.valueOf(str).longValue();
                }
                return 0L;
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    /* renamed from: b */
    public static C2215c m52230b(Context context, C2073i1 c2073i1, String str, String str2, String str3, String str4) {
        return m52209w(context, c2073i1, str, str2, str3, str4);
    }

    /* renamed from: c */
    private static synchronized C2220f m52229c(Context context, String str, String str2) {
        C2220f c2220f;
        synchronized (C2212y0.class) {
            if (!TextUtils.isEmpty(str)) {
                for (int i = 0; i < f6760i.size(); i++) {
                    c2220f = f6760i.get(i);
                    if (c2220f != null && str.equals(c2220f.f6803a)) {
                        break;
                    }
                }
            }
            c2220f = null;
            if (c2220f != null) {
                return c2220f;
            }
            if (context == null) {
                return null;
            }
            C2220f m52194d = C2220f.m52194d(C2080j2.m52836o(context, str2, str, ""));
            String m52874c = C2079j1.m52874c(System.currentTimeMillis(), "yyyyMMdd");
            if (m52194d == null) {
                m52194d = new C2220f(str, m52874c, 0);
            }
            if (!m52874c.equals(m52194d.f6804b)) {
                m52194d.m52195c(m52874c);
                m52194d.f6805c.set(0);
            }
            f6760i.add(m52194d);
            return m52194d;
        }
    }

    /* renamed from: d */
    public static String m52228d(String str) {
        C2219e c2219e;
        if (!f6767p.containsKey(str) || (c2219e = f6767p.get(str)) == null) {
            return null;
        }
        return c2219e.f6801b;
    }

    /* renamed from: e */
    public static void m52227e(Context context) {
        if (context != null) {
            f6758g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    /* renamed from: f */
    private static void m52226f(Context context, C2073i1 c2073i1, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", c2073i1.m52918d());
        hashMap.put("amap_sdk_version", c2073i1.m52916f());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            C2064g3 c2064g3 = new C2064g3(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O001");
            c2064g3.m52971a(jSONObject);
            C2070h3.m52943d(c2064g3, context);
        } catch (C2022bv unused) {
        }
    }

    /* renamed from: g */
    public static synchronized void m52225g(Context context, C2073i1 c2073i1, String str, InterfaceC2214b interfaceC2214b) {
        synchronized (C2212y0.class) {
            if (context == null || c2073i1 == null) {
                return;
            }
            try {
                if (f6758g == null) {
                    f6758g = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                String m52918d = c2073i1.m52918d();
                if (TextUtils.isEmpty(m52918d)) {
                    return;
                }
                m52221k(c2073i1);
                if (f6767p == null) {
                    f6767p = new ConcurrentHashMap<>(8);
                }
                if (f6766o == null) {
                    f6766o = new ConcurrentHashMap<>(8);
                }
                if (f6765n == null) {
                    f6765n = new ConcurrentHashMap<>(8);
                }
                if (!f6767p.containsKey(m52918d)) {
                    C2219e c2219e = new C2219e((byte) 0);
                    c2219e.f6800a = c2073i1;
                    c2219e.f6801b = str;
                    c2219e.f6802c = interfaceC2214b;
                    f6767p.put(m52918d, c2219e);
                    long m52849b = C2080j2.m52849b(f6758g, "open_common", m52918d, 0L);
                    Context context2 = f6758g;
                    f6765n.put(m52918d, new C2222h(Long.valueOf(m52849b), C2080j2.m52836o(context2, "open_common", m52918d + "lct-info", "")));
                    m52243J(f6758g);
                    m52240M(f6758g);
                }
            } catch (Throwable th) {
                C2041d2.m53085e(th, "at", "rglc");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x02b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0299 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m52224h(android.content.Context r18, com.amap.api.col.p047s.C2073i1 r19, java.lang.String r20, com.amap.api.col.p047s.C2212y0.C2215c r21, org.json.JSONObject r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 803
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.C2212y0.m52224h(android.content.Context, com.amap.api.col.s.i1, java.lang.String, com.amap.api.col.s.y0$c, org.json.JSONObject):void");
    }

    /* renamed from: i */
    private static void m52223i(Context context, C2073i1 c2073i1, Throwable th) {
        m52226f(context, c2073i1, th.getMessage());
    }

    /* renamed from: j */
    private static void m52222j(Context context, String str, String str2, C2220f c2220f) {
        if (c2220f == null || TextUtils.isEmpty(c2220f.f6803a)) {
            return;
        }
        String m52193e = c2220f.m52193e();
        if (TextUtils.isEmpty(m52193e) || context == null) {
            return;
        }
        SharedPreferences.Editor m52848c = C2080j2.m52848c(context, str2);
        m52848c.putString(str, m52193e);
        C2080j2.m52845f(m52848c);
    }

    /* renamed from: k */
    private static void m52221k(C2073i1 c2073i1) {
        if (c2073i1 != null) {
            try {
                if (TextUtils.isEmpty(c2073i1.m52918d())) {
                    return;
                }
                String m52916f = c2073i1.m52916f();
                if (TextUtils.isEmpty(m52916f)) {
                    m52916f = c2073i1.m52917e();
                }
                if (TextUtils.isEmpty(m52916f)) {
                    return;
                }
                C2139s1.m52469b(c2073i1.m52918d(), m52916f);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: l */
    public static void m52220l(C2202x2.C2205c c2205c) {
        if (c2205c == null || f6758g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", c2205c.f6696c);
        hashMap.put("hostname", c2205c.f6698e);
        hashMap.put("path", c2205c.f6697d);
        hashMap.put("csid", c2205c.f6694a);
        hashMap.put("degrade", String.valueOf(c2205c.f6695b.m53048a()));
        hashMap.put("errorcode", String.valueOf(c2205c.f6706m));
        hashMap.put("errorsubcode", String.valueOf(c2205c.f6707n));
        hashMap.put("connecttime", String.valueOf(c2205c.f6701h));
        hashMap.put("writetime", String.valueOf(c2205c.f6702i));
        hashMap.put("readtime", String.valueOf(c2205c.f6703j));
        hashMap.put("datasize", String.valueOf(c2205c.f6705l));
        hashMap.put("totaltime", String.valueOf(c2205c.f6699f));
        String jSONObject = new JSONObject(hashMap).toString();
        "--埋点--".concat(String.valueOf(jSONObject));
        C2202x2.m52305i();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            C2064g3 c2064g3 = new C2064g3(f6758g, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O008");
            c2064g3.m52971a(jSONObject);
            C2070h3.m52943d(c2064g3, f6758g);
        } catch (C2022bv unused) {
        }
    }

    /* renamed from: m */
    private static synchronized void m52219m(String str, long j, String str2) {
        synchronized (C2212y0.class) {
            try {
                if (f6767p != null && f6767p.containsKey(str)) {
                    if (f6765n == null) {
                        f6765n = new ConcurrentHashMap<>(8);
                    }
                    f6765n.put(str, new C2222h(Long.valueOf(j), str2));
                    Context context = f6758g;
                    if (context != null) {
                        SharedPreferences.Editor m52848c = C2080j2.m52848c(context, "open_common");
                        C2080j2.m52842i(m52848c, str, j);
                        C2080j2.m52841j(m52848c, str + "lct-info", str2);
                        C2080j2.m52845f(m52848c);
                    }
                }
            } catch (Throwable th) {
                C2041d2.m53085e(th, "at", "ucut");
            }
        }
    }

    /* renamed from: n */
    private static void m52218n(String str, String str2) {
        C2220f m52229c = m52229c(f6758g, str, str2);
        String m52874c = C2079j1.m52874c(System.currentTimeMillis(), "yyyyMMdd");
        if (!m52874c.equals(m52229c.f6804b)) {
            m52229c.m52195c(m52874c);
            m52229c.f6805c.set(0);
        }
        m52229c.f6805c.incrementAndGet();
        m52222j(f6758g, str, str2, m52229c);
    }

    /* renamed from: o */
    public static synchronized void m52217o(String str, boolean z, String str2, String str3, String str4) {
        synchronized (C2212y0.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f6766o == null) {
                    f6766o = new ConcurrentHashMap<>(8);
                }
                f6766o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (f6767p == null) {
                    return;
                }
                if (f6767p.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z) {
                        C2193w2.m52351j(true, str);
                    }
                    C2225y3.m52184e().m53246c(new C2213a(str, str2, str3, str4));
                }
            } catch (Throwable th) {
                C2041d2.m53085e(th, "at", "lca");
            }
        }
    }

    /* renamed from: p */
    public static void m52216p(String str, boolean z, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str) || f6758g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", String.valueOf(z));
        hashMap.put("ant", C2023c1.m53200D(f6758g) == 0 ? "0" : "1");
        if (z3) {
            hashMap.put("type", z ? f6756e : f6757f);
        } else {
            hashMap.put("type", z ? f6754c : f6755d);
        }
        hashMap.put("status", z2 ? "0" : "1");
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            C2064g3 c2064g3 = new C2064g3(f6758g, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O002");
            c2064g3.m52971a(jSONObject);
            C2070h3.m52943d(c2064g3, f6758g);
        } catch (C2022bv unused) {
        }
    }

    /* renamed from: q */
    public static void m52215q(boolean z, C2202x2.C2203a c2203a) {
        if (!f6750D || c2203a == null) {
            return;
        }
        synchronized (f6749C) {
            if (z) {
                Iterator<C2202x2.C2203a> it = f6749C.iterator();
                while (it.hasNext()) {
                    C2202x2.C2203a next = it.next();
                    if (next.f6683b.equals(c2203a.f6683b) && next.f6686e.equals(c2203a.f6686e) && next.f6687f == c2203a.f6687f) {
                        if (next.f6691j == c2203a.f6691j) {
                            it.remove();
                            C2202x2.m52305i();
                        } else {
                            next.f6691j.set(next.f6691j.get() - c2203a.f6691j.get());
                            C2202x2.m52305i();
                        }
                    }
                }
            }
            f6750D = false;
            Iterator<C2202x2.C2203a> it2 = f6749C.iterator();
            C2202x2.m52305i();
            while (it2.hasNext()) {
                C2202x2.C2203a next2 = it2.next();
                String str = next2.f6686e;
                R8$$SyntheticClass.m60055a(next2.f6691j);
                C2202x2.m52305i();
            }
            C2202x2.m52305i();
        }
    }

    /* renamed from: r */
    public static void m52214r(boolean z, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            C2202x2.m52305i();
            if (f6771t || z) {
                if ((f6775x || !z) && !TextUtils.isEmpty(str)) {
                    if (!z) {
                        if (f6747A.get(str) != null) {
                            return;
                        }
                        f6747A.put(str, Boolean.TRUE);
                        m52218n(m52207y(str, "a14"), "open_common");
                    } else if (f6748B.get(str) != null) {
                    } else {
                        f6748B.put(str, Boolean.TRUE);
                        m52218n(m52207y(str, "a15"), "open_common");
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: s */
    public static boolean m52213s() {
        C2220f m52229c;
        if (f6758g != null) {
            m52234S();
            if (!m52249D()) {
                return false;
            }
            if (m52232U()) {
                return true;
            }
        }
        return f6759h && (m52229c = m52229c(f6758g, "IPV6_CONFIG_NAME", "open_common")) != null && m52229c.m52197a() < 5;
    }

    /* renamed from: t */
    public static synchronized boolean m52212t(String str, long j) {
        synchronized (C2212y0.class) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            C2222h m52238O = m52238O(str);
            long j2 = 0;
            if (j != (m52238O != null ? m52238O.f6812a : 0L)) {
                if (f6766o != null && f6766o.containsKey(str)) {
                    j2 = f6766o.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - j2 > 30000) {
                    z = true;
                }
            }
            return z;
        }
    }

    /* renamed from: u */
    public static boolean m52211u(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z;
        }
    }

    /* renamed from: v */
    private static boolean m52210v(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018c  */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [com.amap.api.col.s.y0$c] */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.p047s.C2212y0.C2215c m52209w(android.content.Context r22, com.amap.api.col.p047s.C2073i1 r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.C2212y0.m52209w(android.content.Context, com.amap.api.col.s.i1, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.s.y0$c");
    }

    /* renamed from: x */
    public static C2073i1 m52208x(String str) {
        C2219e c2219e = f6767p.get(str);
        if (c2219e != null) {
            return c2219e.f6800a;
        }
        return null;
    }

    /* renamed from: y */
    private static String m52207y(String str, String str2) {
        String m52991b = C2059g1.m52991b(str.getBytes());
        return str2 + "_" + m52991b;
    }

    /* renamed from: z */
    private static String m52206z(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    String str = list.get(0);
                    return !TextUtils.isEmpty(str) ? str : "";
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }
}
