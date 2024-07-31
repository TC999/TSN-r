package com.amap.api.col.p0463l;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0463l.AbstractC1840if;
import com.amap.api.col.p0463l.HttpUrlUtil;
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

/* renamed from: com.amap.api.col.3l.f4 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AuthConfigManager {

    /* renamed from: D */
    private static volatile boolean f4095D = false;

    /* renamed from: a */
    public static int f4097a = -1;

    /* renamed from: b */
    public static String f4098b = "";

    /* renamed from: c */
    private static String f4099c = "6";

    /* renamed from: d */
    private static String f4100d = "4";

    /* renamed from: e */
    private static String f4101e = "9";

    /* renamed from: f */
    private static String f4102f = "8";

    /* renamed from: g */
    public static Context f4103g = null;

    /* renamed from: h */
    private static volatile boolean f4104h = true;

    /* renamed from: i */
    private static Vector<C1806f> f4105i = new Vector<>();

    /* renamed from: j */
    private static Map<String, Integer> f4106j = new HashMap();

    /* renamed from: k */
    private static String f4107k = null;

    /* renamed from: l */
    private static long f4108l = 0;

    /* renamed from: m */
    public static volatile boolean f4109m = false;

    /* renamed from: n */
    private static volatile ConcurrentHashMap<String, C1808h> f4110n = new ConcurrentHashMap<>(8);

    /* renamed from: o */
    private static volatile ConcurrentHashMap<String, Long> f4111o = new ConcurrentHashMap<>(8);

    /* renamed from: p */
    private static volatile ConcurrentHashMap<String, C1805e> f4112p = new ConcurrentHashMap<>(8);

    /* renamed from: q */
    private static boolean f4113q = false;

    /* renamed from: r */
    private static boolean f4114r = false;

    /* renamed from: s */
    public static int f4115s = 5000;

    /* renamed from: t */
    public static boolean f4116t = true;

    /* renamed from: u */
    public static boolean f4117u = false;

    /* renamed from: v */
    private static int f4118v = 3;

    /* renamed from: w */
    public static boolean f4119w = true;

    /* renamed from: x */
    public static boolean f4120x = false;

    /* renamed from: y */
    private static int f4121y = 3;

    /* renamed from: z */
    public static boolean f4122z = false;

    /* renamed from: A */
    private static ConcurrentHashMap<String, Boolean> f4092A = new ConcurrentHashMap<>();

    /* renamed from: B */
    private static ConcurrentHashMap<String, Boolean> f4093B = new ConcurrentHashMap<>();

    /* renamed from: C */
    private static ArrayList<HttpUrlUtil.C1960a> f4094C = new ArrayList<>();

    /* renamed from: E */
    private static Queue<HttpUrlUtil.C1962c> f4096E = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1799a extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ String f4123a;

        /* renamed from: b */
        final /* synthetic */ String f4124b;

        /* renamed from: c */
        final /* synthetic */ String f4125c;

        /* renamed from: d */
        final /* synthetic */ String f4126d;

        C1799a(String str, String str2, String str3, String str4) {
            this.f4123a = str;
            this.f4124b = str2;
            this.f4125c = str3;
            this.f4126d = str4;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            C1805e c1805e = (C1805e) AuthConfigManager.f4112p.get(this.f4123a);
            if (c1805e == null) {
                return;
            }
            InterfaceC1800b interfaceC1800b = c1805e.f4147c;
            C1801c m55062b = AuthConfigManager.m55062b(AuthConfigManager.f4103g, c1805e.f4145a, c1805e.f4146b, this.f4124b, this.f4125c, this.f4126d);
            if (m55062b == null || interfaceC1800b == null) {
                return;
            }
            interfaceC1800b.mo51311a(m55062b);
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1800b {
        /* renamed from: a */
        void mo51311a(C1801c c1801c);
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1801c {
        @Deprecated

        /* renamed from: a */
        public JSONObject f4127a;
        @Deprecated

        /* renamed from: b */
        public JSONObject f4128b;

        /* renamed from: c */
        public String f4129c;

        /* renamed from: d */
        public int f4130d = -1;

        /* renamed from: e */
        public long f4131e = 0;

        /* renamed from: f */
        public JSONObject f4132f;

        /* renamed from: g */
        public C1802a f4133g;

        /* renamed from: h */
        public C1803b f4134h;

        /* renamed from: i */
        private boolean f4135i;

        /* compiled from: AuthConfigManager.java */
        /* renamed from: com.amap.api.col.3l.f4$c$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        public static class C1802a {

            /* renamed from: a */
            public boolean f4136a;

            /* renamed from: b */
            public boolean f4137b;

            /* renamed from: c */
            public JSONObject f4138c;
        }

        /* compiled from: AuthConfigManager.java */
        /* renamed from: com.amap.api.col.3l.f4$c$b */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        public static class C1803b {

            /* renamed from: a */
            public boolean f4139a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1804d extends BinaryRequest {

        /* renamed from: i */
        private String f4140i;

        /* renamed from: j */
        private Map<String, String> f4141j;

        /* renamed from: k */
        private String f4142k;

        /* renamed from: p */
        private String f4143p;

        /* renamed from: q */
        private String f4144q;

        C1804d(Context context, SDKInfo sDKInfo, String str, Map<String, String> map, String str2, String str3, String str4) {
            super(context, sDKInfo);
            this.f4140i = str;
            this.f4141j = map;
            this.f4142k = str2;
            this.f4143p = str3;
            this.f4144q = str4;
            setHttpProtocol(AbstractC1840if.EnumC1843c.HTTPS);
            setDegradeAbility(AbstractC1840if.EnumC1841a.FIX);
        }

        /* renamed from: m */
        private static String m55036m(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        @Override // com.amap.api.col.p0463l.BinaryRequest
        /* renamed from: c */
        public final byte[] mo51373c() {
            return null;
        }

        @Override // com.amap.api.col.p0463l.BinaryRequest
        /* renamed from: d */
        public final byte[] mo51370d() {
            String m54796Z = DeviceInfo.m54796Z(((BinaryRequest) this).f5132a);
            if (!TextUtils.isEmpty(m54796Z)) {
                m54796Z = C1849l4.m54583d(new StringBuilder(m54796Z).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f4140i) ? "" : this.f4140i);
            hashMap.put("plattype", FaceEnvironment.f8430OS);
            hashMap.put("ccver", "1");
            hashMap.put("product", ((BinaryRequest) this).f5133b.m54400a());
            hashMap.put(ConstantHelper.LOG_VS, ((BinaryRequest) this).f5133b.m54396e());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", m54796Z);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.f4141j;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.f4141j);
            }
            hashMap.put("abitype", C1925p4.m54200d(((BinaryRequest) this).f5132a));
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, ((BinaryRequest) this).f5133b.m54394g());
            return C1925p4.m54189o(C1925p4.m54198f(hashMap));
        }

        @Override // com.amap.api.col.p0463l.BinaryRequest
        /* renamed from: e */
        protected final String mo54104e() {
            return SocializeConstants.PROTOCOL_VERSON;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final String getIPDNSName() {
            if (!TextUtils.isEmpty(this.f4144q)) {
                return this.f4144q;
            }
            return super.getIPDNSName();
        }

        @Override // com.amap.api.col.p0463l.IPV6Request, com.amap.api.col.p0463l.AbstractC1840if
        public final String getIPV6URL() {
            return m55036m("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.f4143p);
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final Map<String, String> getRequestHead() {
            if (TextUtils.isEmpty(this.f4144q)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f4144q);
            return hashMap;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final String getURL() {
            return m55036m("https://restsdk.amap.com/v3/iasdkauth", this.f4142k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1805e {

        /* renamed from: a */
        SDKInfo f4145a;

        /* renamed from: b */
        String f4146b;

        /* renamed from: c */
        InterfaceC1800b f4147c;

        private C1805e() {
        }

        /* synthetic */ C1805e(byte b) {
            this();
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$f */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1806f {

        /* renamed from: a */
        private String f4148a;

        /* renamed from: b */
        private String f4149b;

        /* renamed from: c */
        private AtomicInteger f4150c;

        public C1806f(String str, String str2, int i) {
            this.f4148a = str;
            this.f4149b = str2;
            this.f4150c = new AtomicInteger(i);
        }

        /* renamed from: d */
        public static C1806f m55032d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new C1806f(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }

        /* renamed from: a */
        public final int m55035a() {
            AtomicInteger atomicInteger = this.f4150c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        /* renamed from: c */
        public final void m55033c(String str) {
            this.f4149b = str;
        }

        /* renamed from: e */
        public final String m55031e() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f4148a);
                jSONObject.put("f", this.f4149b);
                jSONObject.put("h", this.f4150c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$g */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1807g {

        /* renamed from: a */
        public static boolean f4151a = true;

        /* renamed from: b */
        public static boolean f4152b = false;

        /* renamed from: c */
        public static boolean f4153c = true;

        /* renamed from: d */
        public static int f4154d;

        /* renamed from: e */
        public static boolean f4155e;

        /* renamed from: f */
        public static int f4156f;
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$h */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1808h {

        /* renamed from: a */
        public long f4157a;

        /* renamed from: b */
        public String f4158b;

        C1808h(Long l, String str) {
            this.f4157a = 0L;
            this.f4158b = "";
            this.f4157a = l.longValue();
            this.f4158b = str;
        }
    }

    /* renamed from: A */
    public static SDKInfo m55087A(String str) {
        C1805e c1805e = f4112p.get(str);
        if (c1805e != null) {
            return c1805e.f4145a;
        }
        return null;
    }

    /* renamed from: B */
    private static String m55086B(String str, String str2) {
        String m54585b = C1849l4.m54585b(str.getBytes());
        return str2 + "_" + m54585b;
    }

    /* renamed from: C */
    private static String m55085C(List<String> list) {
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

    /* renamed from: D */
    public static void m55084D(Context context) {
        if (context == null) {
            return;
        }
        f4104h = SPUtil.m55223l(context, "open_common", "a2", true);
    }

    /* renamed from: E */
    public static void m55083E(HttpUrlUtil.C1962c c1962c) {
        synchronized (f4094C) {
            boolean z = false;
            for (int i = 0; i < f4094C.size(); i++) {
                HttpUrlUtil.C1960a c1960a = f4094C.get(i);
                if (c1962c.f5493c.equals(c1960a.f5480b) && c1962c.f5494d.equals(c1960a.f5483e)) {
                    int i2 = c1962c.f5503m;
                    int i3 = c1960a.f5484f;
                    if (i2 == i3) {
                        if (i3 == 1) {
                            c1960a.f5487i = ((c1960a.f5488j.get() * c1960a.f5487i) + c1962c.f5496f) / (c1960a.f5488j.get() + 1);
                        }
                        c1960a.f5488j.getAndIncrement();
                        z = true;
                    }
                }
            }
            if (!z) {
                f4094C.add(new HttpUrlUtil.C1960a(c1962c));
            }
            HttpUrlUtil.m53751s();
        }
    }

    /* renamed from: F */
    public static synchronized void m55082F(String str, boolean z) {
        synchronized (AuthConfigManager.class) {
            m55046r(str, z, null, null, null);
        }
    }

    /* renamed from: G */
    public static boolean m55081G() {
        Integer num;
        Context context = f4103g;
        if (context == null) {
            return false;
        }
        String m54798X = DeviceInfo.m54798X(context);
        return (TextUtils.isEmpty(m54798X) || (num = f4106j.get(m54798X.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    /* renamed from: H */
    public static String m55080H(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + ";15K;16H;17I;1A4;17S;183";
    }

    /* renamed from: I */
    private static void m55079I(Context context) {
        if (context == null) {
            return;
        }
        f4116t = SPUtil.m55223l(context, "open_common", "a13", true);
        f4119w = SPUtil.m55223l(context, "open_common", "a6", true);
        f4117u = SPUtil.m55223l(context, "open_common", "a7", false);
        f4115s = SPUtil.m55234a(context, "open_common", "a8", 5000);
        f4118v = SPUtil.m55234a(context, "open_common", "a9", 3);
        f4120x = SPUtil.m55223l(context, "open_common", "a10", false);
        f4121y = SPUtil.m55234a(context, "open_common", "a11", 3);
        f4122z = SPUtil.m55223l(context, "open_common", "a12", false);
    }

    /* renamed from: J */
    public static void m55078J(HttpUrlUtil.C1962c c1962c) {
        if (c1962c != null && f4122z) {
            synchronized (f4096E) {
                f4096E.offer(c1962c);
                HttpUrlUtil.m53751s();
            }
        }
    }

    /* renamed from: K */
    public static boolean m55077K() {
        Integer num;
        Context context = f4103g;
        if (context == null) {
            return false;
        }
        String m54798X = DeviceInfo.m54798X(context);
        return (TextUtils.isEmpty(m54798X) || (num = f4106j.get(m54798X.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    /* renamed from: L */
    public static void m55076L() {
        try {
            C1806f m55059e = m55059e(f4103g, "IPV6_CONFIG_NAME", "open_common");
            String m54201c = C1925p4.m54201c(System.currentTimeMillis(), "yyyyMMdd");
            if (!m54201c.equals(m55059e.f4149b)) {
                m55059e.m55033c(m54201c);
                m55059e.f4150c.set(0);
            }
            m55059e.f4150c.incrementAndGet();
            m55051m(f4103g, "IPV6_CONFIG_NAME", "open_common", m55059e);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: M */
    private static void m55075M(Context context) {
        try {
            if (f4113q) {
                return;
            }
            ConstConfig.f3921e = SPUtil.m55223l(context, "open_common", "a4", true);
            ConstConfig.f3922f = SPUtil.m55223l(context, "open_common", "a5", true);
            f4113q = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: N */
    public static synchronized boolean m55074N(String str) {
        synchronized (AuthConfigManager.class) {
            try {
            } finally {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f4112p == null) {
                return false;
            }
            if (f4111o == null) {
                f4111o = new ConcurrentHashMap<>(8);
            }
            if (f4112p.containsKey(str) && !f4111o.containsKey(str)) {
                f4111o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    /* renamed from: O */
    public static void m55073O() {
        if (f4109m) {
            return;
        }
        try {
            Context context = f4103g;
            if (context == null) {
                return;
            }
            f4109m = true;
            HttpsDecisionUtil.m54673a().m54671c(context);
            m55084D(context);
            m55079I(context);
            C1807g.f4151a = SPUtil.m55223l(context, "open_common", "ucf", C1807g.f4151a);
            C1807g.f4152b = SPUtil.m55223l(context, "open_common", "fsv2", C1807g.f4152b);
            C1807g.f4153c = SPUtil.m55223l(context, "open_common", "usc", C1807g.f4153c);
            C1807g.f4154d = SPUtil.m55234a(context, "open_common", "umv", C1807g.f4154d);
            C1807g.f4155e = SPUtil.m55223l(context, "open_common", "ust", C1807g.f4155e);
            C1807g.f4156f = SPUtil.m55234a(context, "open_common", "ustv", C1807g.f4156f);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: P */
    private static void m55072P(Context context) {
        try {
            if (f4114r) {
                return;
            }
            AAIDConfig.f5175d = m55040x(SPUtil.m55220o(context, "open_common", "a16", ""), true);
            AAIDConfig.f5173b = SPUtil.m55233b(context, "open_common", "a17", AAIDConfig.f5172a);
            f4114r = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: Q */
    public static synchronized void m55071Q(String str) {
        synchronized (AuthConfigManager.class) {
            if (f4111o == null) {
                return;
            }
            if (f4111o.containsKey(str)) {
                f4111o.remove(str);
            }
        }
    }

    /* renamed from: R */
    public static synchronized C1808h m55070R(String str) {
        synchronized (AuthConfigManager.class) {
            try {
                if (f4110n == null) {
                    f4110n = new ConcurrentHashMap<>(8);
                }
                if (f4110n.containsKey(str)) {
                    return f4110n.get(str);
                }
                return new C1808h(0L, "");
            }
        }
    }

    /* renamed from: S */
    public static HttpUrlUtil.C1960a m55069S() {
        if (f4095D) {
            return null;
        }
        synchronized (f4094C) {
            if (f4095D) {
                return null;
            }
            Collections.sort(f4094C);
            if (f4094C.size() > 0) {
                HttpUrlUtil.C1960a clone = f4094C.get(0).clone();
                f4095D = true;
                return clone;
            }
            return null;
        }
    }

    /* renamed from: T */
    public static HttpUrlUtil.C1962c m55068T() {
        synchronized (f4096E) {
            HttpUrlUtil.C1962c poll = f4096E.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    /* renamed from: U */
    public static boolean m55067U(String str) {
        C1806f m55059e;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (f4116t) {
                if (f4092A.get(str) == null) {
                    Context context = f4103g;
                    if (context == null || (m55059e = m55059e(context, m55086B(str, "a14"), "open_common")) == null) {
                        return true;
                    }
                    return m55059e.m55035a() < f4118v;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: W */
    public static boolean m55065W(String str) {
        C1806f m55059e;
        if (!TextUtils.isEmpty(str) && f4120x) {
            if (f4093B.get(str) == null) {
                Context context = f4103g;
                if (context == null || (m55059e = m55059e(context, m55086B(str, "a15"), "open_common")) == null) {
                    return true;
                }
                return m55059e.m55035a() < f4121y;
            }
            return false;
        }
        return false;
    }

    /* renamed from: X */
    private static void m55064X() {
        try {
            Context context = f4103g;
            if (context != null) {
                String m54798X = DeviceInfo.m54798X(context);
                if (!TextUtils.isEmpty(f4107k) && !TextUtils.isEmpty(m54798X) && f4107k.equals(m54798X) && System.currentTimeMillis() - f4108l < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(m54798X)) {
                    f4107k = m54798X;
                }
            } else if (System.currentTimeMillis() - f4108l < 10000) {
                return;
            }
            f4108l = System.currentTimeMillis();
            f4106j.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!m55039y((Inet6Address) address)) {
                                i |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!m55039y(inet4Address) && !inet4Address.getHostAddress().startsWith(C1925p4.m54183u("FMTkyLjE2OC40My4"))) {
                                i |= 1;
                            }
                        }
                    }
                    if (i != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            f4106j.put("WIFI", Integer.valueOf(i));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            f4106j.put("MOBILE", Integer.valueOf(i));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "at", "ipstack");
        }
    }

    /* renamed from: a */
    public static long m55063a(List<String> list) {
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
    public static C1801c m55062b(Context context, SDKInfo sDKInfo, String str, String str2, String str3, String str4) {
        return m55060d(context, sDKInfo, str, null, str2, str3, str4);
    }

    /* renamed from: c */
    public static C1801c m55061c(Context context, SDKInfo sDKInfo, String str, Map<String, String> map) {
        return m55038z(context, sDKInfo, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019b  */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [com.amap.api.col.3l.f4$c] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.p0463l.AuthConfigManager.C1801c m55060d(android.content.Context r23, com.amap.api.col.p0463l.SDKInfo r24, java.lang.String r25, java.util.Map<java.lang.String, java.lang.String> r26, java.lang.String r27, java.lang.String r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.AuthConfigManager.m55060d(android.content.Context, com.amap.api.col.3l.o4, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.3l.f4$c");
    }

    /* renamed from: e */
    private static synchronized C1806f m55059e(Context context, String str, String str2) {
        C1806f c1806f;
        synchronized (AuthConfigManager.class) {
            if (!TextUtils.isEmpty(str)) {
                for (int i = 0; i < f4105i.size(); i++) {
                    c1806f = f4105i.get(i);
                    if (c1806f != null && str.equals(c1806f.f4148a)) {
                        break;
                    }
                }
            }
            c1806f = null;
            if (c1806f != null) {
                return c1806f;
            }
            if (context == null) {
                return null;
            }
            C1806f m55032d = C1806f.m55032d(SPUtil.m55220o(context, str2, str, ""));
            String m54201c = C1925p4.m54201c(System.currentTimeMillis(), "yyyyMMdd");
            if (m55032d == null) {
                m55032d = new C1806f(str, m54201c, 0);
            }
            if (!m54201c.equals(m55032d.f4149b)) {
                m55032d.m55033c(m54201c);
                m55032d.f4150c.set(0);
            }
            f4105i.add(m55032d);
            return m55032d;
        }
    }

    /* renamed from: f */
    public static String m55058f(String str) {
        C1805e c1805e;
        if (!f4112p.containsKey(str) || (c1805e = f4112p.get(str)) == null) {
            return null;
        }
        return c1805e.f4146b;
    }

    /* renamed from: g */
    public static void m55057g(Context context) {
        if (context != null) {
            f4103g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    /* renamed from: h */
    private static void m55056h(Context context, SDKInfo sDKInfo, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", sDKInfo.m54400a());
        hashMap.put("amap_sdk_version", sDKInfo.m54395f());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            StatisticsEntity statisticsEntity = new StatisticsEntity(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O001");
            statisticsEntity.m55025a(jSONObject);
            StatisticsManager.m54911d(statisticsEntity, context);
        } catch (AMapCoreException unused) {
        }
    }

    /* renamed from: i */
    public static synchronized void m55055i(Context context, SDKInfo sDKInfo, String str, InterfaceC1800b interfaceC1800b) {
        synchronized (AuthConfigManager.class) {
            if (context == null || sDKInfo == null) {
                return;
            }
            try {
                if (f4103g == null) {
                    f4103g = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                String m54400a = sDKInfo.m54400a();
                if (TextUtils.isEmpty(m54400a)) {
                    return;
                }
                m55050n(sDKInfo);
                if (f4112p == null) {
                    f4112p = new ConcurrentHashMap<>(8);
                }
                if (f4111o == null) {
                    f4111o = new ConcurrentHashMap<>(8);
                }
                if (f4110n == null) {
                    f4110n = new ConcurrentHashMap<>(8);
                }
                if (!f4112p.containsKey(m54400a)) {
                    C1805e c1805e = new C1805e((byte) 0);
                    c1805e.f4145a = sDKInfo;
                    c1805e.f4146b = str;
                    c1805e.f4147c = interfaceC1800b;
                    f4112p.put(m54400a, c1805e);
                    long m55233b = SPUtil.m55233b(f4103g, "open_common", m54400a, 0L);
                    Context context2 = f4103g;
                    f4110n.put(m54400a, new C1808h(Long.valueOf(m55233b), SPUtil.m55220o(context2, "open_common", m54400a + "lct-info", "")));
                    m55075M(f4103g);
                    m55072P(f4103g);
                }
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, "at", "rglc");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x02b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0299 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m55054j(android.content.Context r18, com.amap.api.col.p0463l.SDKInfo r19, java.lang.String r20, com.amap.api.col.p0463l.AuthConfigManager.C1801c r21, org.json.JSONObject r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 803
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.AuthConfigManager.m55054j(android.content.Context, com.amap.api.col.3l.o4, java.lang.String, com.amap.api.col.3l.f4$c, org.json.JSONObject):void");
    }

    /* renamed from: k */
    private static void m55053k(Context context, SDKInfo sDKInfo, Throwable th) {
        m55056h(context, sDKInfo, th.getMessage());
    }

    /* renamed from: l */
    public static void m55052l(Context context, String str) {
        C1780e4.m55248b(context, str);
    }

    /* renamed from: m */
    private static void m55051m(Context context, String str, String str2, C1806f c1806f) {
        if (c1806f == null || TextUtils.isEmpty(c1806f.f4148a)) {
            return;
        }
        String m55031e = c1806f.m55031e();
        if (TextUtils.isEmpty(m55031e) || context == null) {
            return;
        }
        SharedPreferences.Editor m55232c = SPUtil.m55232c(context, str2);
        m55232c.putString(str, m55031e);
        SPUtil.m55229f(m55232c);
    }

    /* renamed from: n */
    private static void m55050n(SDKInfo sDKInfo) {
        if (sDKInfo != null) {
            try {
                if (TextUtils.isEmpty(sDKInfo.m54400a())) {
                    return;
                }
                String m54395f = sDKInfo.m54395f();
                if (TextUtils.isEmpty(m54395f)) {
                    m54395f = sDKInfo.m54396e();
                }
                if (TextUtils.isEmpty(m54395f)) {
                    return;
                }
                ConstConfig.m55236b(sDKInfo.m54400a(), m54395f);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: o */
    public static void m55049o(HttpUrlUtil.C1962c c1962c) {
        if (c1962c == null || f4103g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", c1962c.f5493c);
        hashMap.put("hostname", c1962c.f5495e);
        hashMap.put("path", c1962c.f5494d);
        hashMap.put("csid", c1962c.f5491a);
        hashMap.put("degrade", String.valueOf(c1962c.f5492b.m54697a()));
        hashMap.put("errorcode", String.valueOf(c1962c.f5503m));
        hashMap.put("errorsubcode", String.valueOf(c1962c.f5504n));
        hashMap.put("connecttime", String.valueOf(c1962c.f5498h));
        hashMap.put("writetime", String.valueOf(c1962c.f5499i));
        hashMap.put("readtime", String.valueOf(c1962c.f5500j));
        hashMap.put("datasize", String.valueOf(c1962c.f5502l));
        hashMap.put("totaltime", String.valueOf(c1962c.f5496f));
        String jSONObject = new JSONObject(hashMap).toString();
        "--埋点--".concat(String.valueOf(jSONObject));
        HttpUrlUtil.m53751s();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            StatisticsEntity statisticsEntity = new StatisticsEntity(f4103g, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O008");
            statisticsEntity.m55025a(jSONObject);
            StatisticsManager.m54911d(statisticsEntity, f4103g);
        } catch (AMapCoreException unused) {
        }
    }

    /* renamed from: p */
    private static synchronized void m55048p(String str, long j, String str2) {
        synchronized (AuthConfigManager.class) {
            try {
                if (f4112p != null && f4112p.containsKey(str)) {
                    if (f4110n == null) {
                        f4110n = new ConcurrentHashMap<>(8);
                    }
                    f4110n.put(str, new C1808h(Long.valueOf(j), str2));
                    Context context = f4103g;
                    if (context != null) {
                        SharedPreferences.Editor m55232c = SPUtil.m55232c(context, "open_common");
                        SPUtil.m55226i(m55232c, str, j);
                        SPUtil.m55225j(m55232c, str + "lct-info", str2);
                        SPUtil.m55229f(m55232c);
                    }
                }
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, "at", "ucut");
            }
        }
    }

    /* renamed from: q */
    private static void m55047q(String str, String str2) {
        C1806f m55059e = m55059e(f4103g, str, str2);
        String m54201c = C1925p4.m54201c(System.currentTimeMillis(), "yyyyMMdd");
        if (!m54201c.equals(m55059e.f4149b)) {
            m55059e.m55033c(m54201c);
            m55059e.f4150c.set(0);
        }
        m55059e.f4150c.incrementAndGet();
        m55051m(f4103g, str, str2, m55059e);
    }

    /* renamed from: r */
    public static synchronized void m55046r(String str, boolean z, String str2, String str3, String str4) {
        synchronized (AuthConfigManager.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f4111o == null) {
                    f4111o = new ConcurrentHashMap<>(8);
                }
                f4111o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (f4112p == null) {
                    return;
                }
                if (f4112p.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z) {
                        HttpLimitUtil.m53851j(true, str);
                    }
                    ThreadPool.m53398h().m55654b(new C1799a(str, str2, str3, str4));
                }
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, "at", "lca");
            }
        }
    }

    /* renamed from: s */
    public static void m55045s(String str, boolean z, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str) || f4103g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", String.valueOf(z));
        hashMap.put("ant", DeviceInfo.m54809M(f4103g) == 0 ? "0" : "1");
        if (z3) {
            hashMap.put("type", z ? f4101e : f4102f);
        } else {
            hashMap.put("type", z ? f4099c : f4100d);
        }
        hashMap.put("status", z2 ? "0" : "1");
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            StatisticsEntity statisticsEntity = new StatisticsEntity(f4103g, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O002");
            statisticsEntity.m55025a(jSONObject);
            StatisticsManager.m54911d(statisticsEntity, f4103g);
        } catch (AMapCoreException unused) {
        }
    }

    /* renamed from: t */
    public static void m55044t(boolean z, HttpUrlUtil.C1960a c1960a) {
        if (!f4095D || c1960a == null) {
            return;
        }
        synchronized (f4094C) {
            if (z) {
                Iterator<HttpUrlUtil.C1960a> it = f4094C.iterator();
                while (it.hasNext()) {
                    HttpUrlUtil.C1960a next = it.next();
                    if (next.f5480b.equals(c1960a.f5480b) && next.f5483e.equals(c1960a.f5483e) && next.f5484f == c1960a.f5484f) {
                        if (next.f5488j == c1960a.f5488j) {
                            it.remove();
                            HttpUrlUtil.m53751s();
                        } else {
                            next.f5488j.set(next.f5488j.get() - c1960a.f5488j.get());
                            HttpUrlUtil.m53751s();
                        }
                    }
                }
            }
            f4095D = false;
            Iterator<HttpUrlUtil.C1960a> it2 = f4094C.iterator();
            HttpUrlUtil.m53751s();
            while (it2.hasNext()) {
                HttpUrlUtil.C1960a next2 = it2.next();
                String str = next2.f5483e;
                R8$$SyntheticClass.m60055a(next2.f5488j);
                HttpUrlUtil.m53751s();
            }
            HttpUrlUtil.m53751s();
        }
    }

    /* renamed from: u */
    public static void m55043u(boolean z, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            HttpUrlUtil.m53751s();
            if (f4116t || z) {
                if ((f4120x || !z) && !TextUtils.isEmpty(str)) {
                    if (!z) {
                        if (f4092A.get(str) != null) {
                            return;
                        }
                        f4092A.put(str, Boolean.TRUE);
                        m55047q(m55086B(str, "a14"), "open_common");
                    } else if (f4093B.get(str) != null) {
                    } else {
                        f4093B.put(str, Boolean.TRUE);
                        m55047q(m55086B(str, "a15"), "open_common");
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: v */
    public static boolean m55042v() {
        C1806f m55059e;
        if (f4103g != null) {
            m55064X();
            if (!m55077K()) {
                return false;
            }
            if (m55081G()) {
                return true;
            }
        }
        return f4104h && (m55059e = m55059e(f4103g, "IPV6_CONFIG_NAME", "open_common")) != null && m55059e.m55035a() < 5;
    }

    /* renamed from: w */
    public static synchronized boolean m55041w(String str, long j) {
        synchronized (AuthConfigManager.class) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            C1808h m55070R = m55070R(str);
            long j2 = 0;
            if (j != (m55070R != null ? m55070R.f4157a : 0L)) {
                if (f4111o != null && f4111o.containsKey(str)) {
                    j2 = f4111o.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - j2 > 30000) {
                    z = true;
                }
            }
            return z;
        }
    }

    /* renamed from: x */
    public static boolean m55040x(String str, boolean z) {
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

    /* renamed from: y */
    private static boolean m55039y(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    /* renamed from: z */
    private static C1801c m55038z(Context context, SDKInfo sDKInfo, String str, Map<String, String> map) {
        return m55060d(context, sDKInfo, str, map, null, null, null);
    }
}
