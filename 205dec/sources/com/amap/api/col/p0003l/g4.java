package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.v6;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.stub.StubApp;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AuthConfigManager.java */
/* renamed from: com.amap.api.col.3l.g4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g4 {
    private static volatile boolean D = false;

    /* renamed from: a  reason: collision with root package name */
    public static int f7809a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static String f7810b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f7811c = "6";

    /* renamed from: d  reason: collision with root package name */
    private static String f7812d = "4";

    /* renamed from: e  reason: collision with root package name */
    private static String f7813e = "9";

    /* renamed from: f  reason: collision with root package name */
    private static String f7814f = "8";

    /* renamed from: g  reason: collision with root package name */
    public static Context f7815g = null;

    /* renamed from: h  reason: collision with root package name */
    private static volatile boolean f7816h = true;

    /* renamed from: i  reason: collision with root package name */
    private static Vector<f> f7817i = new Vector<>();

    /* renamed from: j  reason: collision with root package name */
    private static Map<String, Integer> f7818j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private static String f7819k = null;

    /* renamed from: l  reason: collision with root package name */
    private static long f7820l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static volatile boolean f7821m = false;

    /* renamed from: n  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, h> f7822n = new ConcurrentHashMap<>(8);

    /* renamed from: o  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f7823o = new ConcurrentHashMap<>(8);

    /* renamed from: p  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, e> f7824p = new ConcurrentHashMap<>(8);

    /* renamed from: q  reason: collision with root package name */
    private static boolean f7825q = false;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f7826r = false;

    /* renamed from: s  reason: collision with root package name */
    public static int f7827s = 5000;

    /* renamed from: t  reason: collision with root package name */
    public static boolean f7828t = true;

    /* renamed from: u  reason: collision with root package name */
    public static boolean f7829u = false;

    /* renamed from: v  reason: collision with root package name */
    private static int f7830v = 3;

    /* renamed from: w  reason: collision with root package name */
    public static boolean f7831w = true;

    /* renamed from: x  reason: collision with root package name */
    public static boolean f7832x = false;

    /* renamed from: y  reason: collision with root package name */
    private static int f7833y = 3;

    /* renamed from: z  reason: collision with root package name */
    public static boolean f7834z = false;
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> B = new ConcurrentHashMap<>();
    private static ArrayList<v6.a> C = new ArrayList<>();
    private static Queue<v6.c> E = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.g4$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7835a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7836b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f7837c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f7838d;

        a(String str, String str2, String str3, String str4) {
            this.f7835a = str;
            this.f7836b = str2;
            this.f7837c = str3;
            this.f7838d = str4;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            e eVar = (e) g4.f7824p.get(this.f7835a);
            if (eVar == null) {
                return;
            }
            b bVar = eVar.f7859c;
            c b4 = g4.b(g4.f7815g, eVar.f7857a, eVar.f7858b, this.f7836b, this.f7837c, this.f7838d);
            if (b4 == null || bVar == null) {
                return;
            }
            bVar.a(b4);
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.g4$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface b {
        void a(c cVar);
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.g4$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f7839a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f7840b;

        /* renamed from: c  reason: collision with root package name */
        public String f7841c;

        /* renamed from: d  reason: collision with root package name */
        public int f7842d = -1;

        /* renamed from: e  reason: collision with root package name */
        public long f7843e = 0;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f7844f;

        /* renamed from: g  reason: collision with root package name */
        public a f7845g;

        /* renamed from: h  reason: collision with root package name */
        public b f7846h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f7847i;

        /* compiled from: AuthConfigManager.java */
        /* renamed from: com.amap.api.col.3l.g4$c$a */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f7848a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f7849b;

            /* renamed from: c  reason: collision with root package name */
            public JSONObject f7850c;
        }

        /* compiled from: AuthConfigManager.java */
        /* renamed from: com.amap.api.col.3l.g4$c$b */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public boolean f7851a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.g4$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class d extends r6 {

        /* renamed from: i  reason: collision with root package name */
        private String f7852i;

        /* renamed from: j  reason: collision with root package name */
        private Map<String, String> f7853j;

        /* renamed from: k  reason: collision with root package name */
        private String f7854k;

        /* renamed from: p  reason: collision with root package name */
        private String f7855p;

        /* renamed from: q  reason: collision with root package name */
        private String f7856q;

        d(Context context, p4 p4Var, String str, Map<String, String> map, String str2, String str3, String str4) {
            super(context, p4Var);
            this.f7852i = str;
            this.f7853j = map;
            this.f7854k = str2;
            this.f7855p = str3;
            this.f7856q = str4;
            setHttpProtocol(Cif.c.HTTPS);
            setDegradeAbility(Cif.a.FIX);
        }

        private static String m(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        @Override // com.amap.api.col.p0003l.r6
        public final byte[] c() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.r6
        public final byte[] d() {
            String Z = i4.Z(((r6) this).f8906a);
            if (!TextUtils.isEmpty(Z)) {
                Z = m4.d(new StringBuilder(Z).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f7852i) ? "" : this.f7852i);
            hashMap.put("plattype", "android");
            hashMap.put("ccver", "1");
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, ((r6) this).f8907b.a());
            hashMap.put("version", ((r6) this).f8907b.e());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", Z);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.f7853j;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.f7853j);
            }
            hashMap.put("abitype", q4.d(((r6) this).f8906a));
            hashMap.put("ext", ((r6) this).f8907b.g());
            return q4.o(q4.f(hashMap));
        }

        @Override // com.amap.api.col.p0003l.r6
        protected final String e() {
            return "3.0";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.col.p0003l.Cif
        public final String getIPDNSName() {
            if (!TextUtils.isEmpty(this.f7856q)) {
                return this.f7856q;
            }
            return super.getIPDNSName();
        }

        @Override // com.amap.api.col.p0003l.l4, com.amap.api.col.p0003l.Cif
        public final String getIPV6URL() {
            return m("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.f7855p);
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final Map<String, String> getRequestHead() {
            if (TextUtils.isEmpty(this.f7856q)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f7856q);
            return hashMap;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            return m("https://restsdk.amap.com/v3/iasdkauth", this.f7854k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.g4$e */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        p4 f7857a;

        /* renamed from: b  reason: collision with root package name */
        String f7858b;

        /* renamed from: c  reason: collision with root package name */
        b f7859c;

        private e() {
        }

        /* synthetic */ e(byte b4) {
            this();
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.g4$f */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private String f7860a;

        /* renamed from: b  reason: collision with root package name */
        private String f7861b;

        /* renamed from: c  reason: collision with root package name */
        private AtomicInteger f7862c;

        public f(String str, String str2, int i4) {
            this.f7860a = str;
            this.f7861b = str2;
            this.f7862c = new AtomicInteger(i4);
        }

        public static f d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new f(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.f7862c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void c(String str) {
            this.f7861b = str;
        }

        public final String e() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f7860a);
                jSONObject.put("f", this.f7861b);
                jSONObject.put("h", this.f7862c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.g4$g */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f7863a = true;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f7864b = false;

        /* renamed from: c  reason: collision with root package name */
        public static boolean f7865c = true;

        /* renamed from: d  reason: collision with root package name */
        public static int f7866d;

        /* renamed from: e  reason: collision with root package name */
        public static boolean f7867e;

        /* renamed from: f  reason: collision with root package name */
        public static int f7868f;
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.g4$h */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public long f7869a;

        /* renamed from: b  reason: collision with root package name */
        public String f7870b;

        h(Long l4, String str) {
            this.f7869a = 0L;
            this.f7870b = "";
            this.f7869a = l4.longValue();
            this.f7870b = str;
        }
    }

    public static p4 A(String str) {
        e eVar = f7824p.get(str);
        if (eVar != null) {
            return eVar.f7857a;
        }
        return null;
    }

    private static String B(String str, String str2) {
        String b4 = m4.b(str.getBytes());
        return str2 + "_" + b4;
    }

    private static String C(List<String> list) {
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

    public static void D(Context context) {
        if (context == null) {
            return;
        }
        f7816h = f6.l(context, "open_common", "a2", true);
    }

    public static void E(v6.c cVar) {
        synchronized (C) {
            boolean z3 = false;
            for (int i4 = 0; i4 < C.size(); i4++) {
                v6.a aVar = C.get(i4);
                if (cVar.f9269c.equals(aVar.f9256b) && cVar.f9270d.equals(aVar.f9259e)) {
                    int i5 = cVar.f9279m;
                    int i6 = aVar.f9260f;
                    if (i5 == i6) {
                        if (i6 == 1) {
                            aVar.f9263i = ((aVar.f9264j.get() * aVar.f9263i) + cVar.f9272f) / (aVar.f9264j.get() + 1);
                        }
                        aVar.f9264j.getAndIncrement();
                        z3 = true;
                    }
                }
            }
            if (!z3) {
                C.add(new v6.a(cVar));
            }
            v6.s();
        }
    }

    public static synchronized void F(String str, boolean z3) {
        synchronized (g4.class) {
            r(str, z3, null, null, null);
        }
    }

    public static boolean G() {
        Integer num;
        Context context = f7815g;
        if (context == null) {
            return false;
        }
        String X = i4.X(context);
        return (TextUtils.isEmpty(X) || (num = f7818j.get(X.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    public static String H(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + ";15K;16H;17I;1A4;17S;183";
    }

    private static void I(Context context) {
        if (context == null) {
            return;
        }
        f7828t = f6.l(context, "open_common", "a13", true);
        f7831w = f6.l(context, "open_common", "a6", true);
        f7829u = f6.l(context, "open_common", "a7", false);
        f7827s = f6.a(context, "open_common", "a8", 5000);
        f7830v = f6.a(context, "open_common", "a9", 3);
        f7832x = f6.l(context, "open_common", "a10", false);
        f7833y = f6.a(context, "open_common", "a11", 3);
        f7834z = f6.l(context, "open_common", "a12", false);
    }

    public static void J(v6.c cVar) {
        if (cVar != null && f7834z) {
            synchronized (E) {
                E.offer(cVar);
                v6.s();
            }
        }
    }

    public static boolean K() {
        Integer num;
        Context context = f7815g;
        if (context == null) {
            return false;
        }
        String X = i4.X(context);
        return (TextUtils.isEmpty(X) || (num = f7818j.get(X.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static void L() {
        try {
            f e4 = e(f7815g, "IPV6_CONFIG_NAME", "open_common");
            String c4 = q4.c(System.currentTimeMillis(), "yyyyMMdd");
            if (!c4.equals(e4.f7861b)) {
                e4.c(c4);
                e4.f7862c.set(0);
            }
            e4.f7862c.incrementAndGet();
            m(f7815g, "IPV6_CONFIG_NAME", "open_common", e4);
        } catch (Throwable unused) {
        }
    }

    private static void M(Context context) {
        try {
            if (f7825q) {
                return;
            }
            f5.f7710e = f6.l(context, "open_common", "a4", true);
            f5.f7711f = f6.l(context, "open_common", "a5", true);
            f7825q = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized boolean N(String str) {
        synchronized (g4.class) {
            try {
            } finally {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f7824p == null) {
                return false;
            }
            if (f7823o == null) {
                f7823o = new ConcurrentHashMap<>(8);
            }
            if (f7824p.containsKey(str) && !f7823o.containsKey(str)) {
                f7823o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    public static void O() {
        if (f7821m) {
            return;
        }
        try {
            Context context = f7815g;
            if (context == null) {
                return;
            }
            f7821m = true;
            k4.a().c(context);
            D(context);
            I(context);
            g.f7863a = f6.l(context, "open_common", "ucf", g.f7863a);
            g.f7864b = f6.l(context, "open_common", "fsv2", g.f7864b);
            g.f7865c = f6.l(context, "open_common", "usc", g.f7865c);
            g.f7866d = f6.a(context, "open_common", "umv", g.f7866d);
            g.f7867e = f6.l(context, "open_common", "ust", g.f7867e);
            g.f7868f = f6.a(context, "open_common", "ustv", g.f7868f);
        } catch (Throwable unused) {
        }
    }

    private static void P(Context context) {
        try {
            if (f7826r) {
                return;
            }
            s4.f8938d = x(f6.o(context, "open_common", "a16", ""), true);
            s4.f8936b = f6.b(context, "open_common", "a17", s4.f8935a);
            f7826r = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized void Q(String str) {
        synchronized (g4.class) {
            if (f7823o == null) {
                return;
            }
            if (f7823o.containsKey(str)) {
                f7823o.remove(str);
            }
        }
    }

    public static synchronized h R(String str) {
        synchronized (g4.class) {
            try {
                if (f7822n == null) {
                    f7822n = new ConcurrentHashMap<>(8);
                }
                if (f7822n.containsKey(str)) {
                    return f7822n.get(str);
                }
                return new h(0L, "");
            }
        }
    }

    public static v6.a S() {
        if (D) {
            return null;
        }
        synchronized (C) {
            if (D) {
                return null;
            }
            Collections.sort(C);
            if (C.size() > 0) {
                v6.a clone = C.get(0).clone();
                D = true;
                return clone;
            }
            return null;
        }
    }

    public static v6.c T() {
        synchronized (E) {
            v6.c poll = E.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    public static boolean U(String str) {
        f e4;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (f7828t) {
                if (A.get(str) == null) {
                    Context context = f7815g;
                    if (context == null || (e4 = e(context, B(str, "a14"), "open_common")) == null) {
                        return true;
                    }
                    return e4.a() < f7830v;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean W(String str) {
        f e4;
        if (!TextUtils.isEmpty(str) && f7832x) {
            if (B.get(str) == null) {
                Context context = f7815g;
                if (context == null || (e4 = e(context, B(str, "a15"), "open_common")) == null) {
                    return true;
                }
                return e4.a() < f7833y;
            }
            return false;
        }
        return false;
    }

    private static void X() {
        try {
            Context context = f7815g;
            if (context != null) {
                String X = i4.X(context);
                if (!TextUtils.isEmpty(f7819k) && !TextUtils.isEmpty(X) && f7819k.equals(X) && System.currentTimeMillis() - f7820l < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(X)) {
                    f7819k = X;
                }
            } else if (System.currentTimeMillis() - f7820l < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                return;
            }
            f7820l = System.currentTimeMillis();
            f7818j.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i4 = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!y((Inet6Address) address)) {
                                i4 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!y(inet4Address) && !inet4Address.getHostAddress().startsWith(q4.u("FMTkyLjE2OC40My4"))) {
                                i4 |= 1;
                            }
                        }
                    }
                    if (i4 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            f7818j.put("WIFI", Integer.valueOf(i4));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            f7818j.put("MOBILE", Integer.valueOf(i4));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            q5.e(th, "at", "ipstack");
        }
    }

    public static long a(List<String> list) {
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
            } catch (Exception e4) {
                e4.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public static c b(Context context, p4 p4Var, String str, String str2, String str3, String str4) {
        return d(context, p4Var, str, null, str2, str3, str4);
    }

    public static c c(Context context, p4 p4Var, String str, Map<String, String> map) {
        return z(context, p4Var, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019d  */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [com.amap.api.col.3l.g4$c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.p0003l.g4.c d(android.content.Context r23, com.amap.api.col.p0003l.p4 r24, java.lang.String r25, java.util.Map<java.lang.String, java.lang.String> r26, java.lang.String r27, java.lang.String r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.g4.d(android.content.Context, com.amap.api.col.3l.p4, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.3l.g4$c");
    }

    private static synchronized f e(Context context, String str, String str2) {
        f fVar;
        synchronized (g4.class) {
            if (!TextUtils.isEmpty(str)) {
                for (int i4 = 0; i4 < f7817i.size(); i4++) {
                    fVar = f7817i.get(i4);
                    if (fVar != null && str.equals(fVar.f7860a)) {
                        break;
                    }
                }
            }
            fVar = null;
            if (fVar != null) {
                return fVar;
            }
            if (context == null) {
                return null;
            }
            f d4 = f.d(f6.o(context, str2, str, ""));
            String c4 = q4.c(System.currentTimeMillis(), "yyyyMMdd");
            if (d4 == null) {
                d4 = new f(str, c4, 0);
            }
            if (!c4.equals(d4.f7861b)) {
                d4.c(c4);
                d4.f7862c.set(0);
            }
            f7817i.add(d4);
            return d4;
        }
    }

    public static String f(String str) {
        e eVar;
        if (!f7824p.containsKey(str) || (eVar = f7824p.get(str)) == null) {
            return null;
        }
        return eVar.f7858b;
    }

    public static void g(Context context) {
        if (context != null) {
            f7815g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private static void h(Context context, p4 p4Var, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", p4Var.a());
        hashMap.put("amap_sdk_version", p4Var.f());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            g7 g7Var = new g7(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O001");
            g7Var.a(jSONObject);
            h7.d(g7Var, context);
        } catch (fk unused) {
        }
    }

    public static synchronized void i(Context context, p4 p4Var, String str, b bVar) {
        synchronized (g4.class) {
            if (context == null || p4Var == null) {
                return;
            }
            try {
                if (f7815g == null) {
                    f7815g = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                String a4 = p4Var.a();
                if (TextUtils.isEmpty(a4)) {
                    return;
                }
                n(p4Var);
                if (f7824p == null) {
                    f7824p = new ConcurrentHashMap<>(8);
                }
                if (f7823o == null) {
                    f7823o = new ConcurrentHashMap<>(8);
                }
                if (f7822n == null) {
                    f7822n = new ConcurrentHashMap<>(8);
                }
                if (!f7824p.containsKey(a4)) {
                    e eVar = new e((byte) 0);
                    eVar.f7857a = p4Var;
                    eVar.f7858b = str;
                    eVar.f7859c = bVar;
                    f7824p.put(a4, eVar);
                    long b4 = f6.b(f7815g, "open_common", a4, 0L);
                    Context context2 = f7815g;
                    f7822n.put(a4, new h(Long.valueOf(b4), f6.o(context2, "open_common", a4 + "lct-info", "")));
                    M(f7815g);
                    P(f7815g);
                }
            } catch (Throwable th) {
                q5.e(th, "at", "rglc");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x02f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x029f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(android.content.Context r18, com.amap.api.col.p0003l.p4 r19, java.lang.String r20, com.amap.api.col.p0003l.g4.c r21, org.json.JSONObject r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 809
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.g4.j(android.content.Context, com.amap.api.col.3l.p4, java.lang.String, com.amap.api.col.3l.g4$c, org.json.JSONObject):void");
    }

    private static void k(Context context, p4 p4Var, Throwable th) {
        h(context, p4Var, th.getMessage());
    }

    public static void l(Context context, String str) {
        e4.b(context, str);
    }

    private static void m(Context context, String str, String str2, f fVar) {
        if (fVar == null || TextUtils.isEmpty(fVar.f7860a)) {
            return;
        }
        String e4 = fVar.e();
        if (TextUtils.isEmpty(e4) || context == null) {
            return;
        }
        SharedPreferences.Editor c4 = f6.c(context, str2);
        c4.putString(str, e4);
        f6.f(c4);
    }

    private static void n(p4 p4Var) {
        if (p4Var != null) {
            try {
                if (TextUtils.isEmpty(p4Var.a())) {
                    return;
                }
                String f4 = p4Var.f();
                if (TextUtils.isEmpty(f4)) {
                    f4 = p4Var.e();
                }
                if (TextUtils.isEmpty(f4)) {
                    return;
                }
                f5.b(p4Var.a(), f4);
            } catch (Throwable unused) {
            }
        }
    }

    public static void o(v6.c cVar) {
        if (cVar == null || f7815g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", cVar.f9269c);
        hashMap.put("hostname", cVar.f9271e);
        hashMap.put("path", cVar.f9270d);
        hashMap.put("csid", cVar.f9267a);
        hashMap.put("degrade", String.valueOf(cVar.f9268b.a()));
        hashMap.put("errorcode", String.valueOf(cVar.f9279m));
        hashMap.put("errorsubcode", String.valueOf(cVar.f9280n));
        hashMap.put("connecttime", String.valueOf(cVar.f9274h));
        hashMap.put("writetime", String.valueOf(cVar.f9275i));
        hashMap.put("readtime", String.valueOf(cVar.f9276j));
        hashMap.put("datasize", String.valueOf(cVar.f9278l));
        hashMap.put("totaltime", String.valueOf(cVar.f9272f));
        String jSONObject = new JSONObject(hashMap).toString();
        "--\u57cb\u70b9--".concat(String.valueOf(jSONObject));
        v6.s();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            g7 g7Var = new g7(f7815g, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O008");
            g7Var.a(jSONObject);
            h7.d(g7Var, f7815g);
        } catch (fk unused) {
        }
    }

    private static synchronized void p(String str, long j4, String str2) {
        synchronized (g4.class) {
            try {
                if (f7824p != null && f7824p.containsKey(str)) {
                    if (f7822n == null) {
                        f7822n = new ConcurrentHashMap<>(8);
                    }
                    f7822n.put(str, new h(Long.valueOf(j4), str2));
                    Context context = f7815g;
                    if (context != null) {
                        SharedPreferences.Editor c4 = f6.c(context, "open_common");
                        f6.i(c4, str, j4);
                        f6.j(c4, str + "lct-info", str2);
                        f6.f(c4);
                    }
                }
            } catch (Throwable th) {
                q5.e(th, "at", "ucut");
            }
        }
    }

    private static void q(String str, String str2) {
        f e4 = e(f7815g, str, str2);
        String c4 = q4.c(System.currentTimeMillis(), "yyyyMMdd");
        if (!c4.equals(e4.f7861b)) {
            e4.c(c4);
            e4.f7862c.set(0);
        }
        e4.f7862c.incrementAndGet();
        m(f7815g, str, str2, e4);
    }

    public static synchronized void r(String str, boolean z3, String str2, String str3, String str4) {
        synchronized (g4.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f7823o == null) {
                    f7823o = new ConcurrentHashMap<>(8);
                }
                f7823o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (f7824p == null) {
                    return;
                }
                if (f7824p.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z3) {
                        u6.j(true, str);
                    }
                    z7.h().b(new a(str, str2, str3, str4));
                }
            } catch (Throwable th) {
                q5.e(th, "at", "lca");
            }
        }
    }

    public static void s(String str, boolean z3, boolean z4, boolean z5) {
        if (TextUtils.isEmpty(str) || f7815g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", String.valueOf(z3));
        hashMap.put("ant", i4.M(f7815g) == 0 ? "0" : "1");
        if (z5) {
            hashMap.put("type", z3 ? f7813e : f7814f);
        } else {
            hashMap.put("type", z3 ? f7811c : f7812d);
        }
        hashMap.put("status", z4 ? "0" : "1");
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            g7 g7Var = new g7(f7815g, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O002");
            g7Var.a(jSONObject);
            h7.d(g7Var, f7815g);
        } catch (fk unused) {
        }
    }

    public static void t(boolean z3, v6.a aVar) {
        if (!D || aVar == null) {
            return;
        }
        synchronized (C) {
            if (z3) {
                Iterator<v6.a> it = C.iterator();
                while (it.hasNext()) {
                    v6.a next = it.next();
                    if (next.f9256b.equals(aVar.f9256b) && next.f9259e.equals(aVar.f9259e) && next.f9260f == aVar.f9260f) {
                        if (next.f9264j == aVar.f9264j) {
                            it.remove();
                            v6.s();
                        } else {
                            next.f9264j.set(next.f9264j.get() - aVar.f9264j.get());
                            v6.s();
                        }
                    }
                }
            }
            D = false;
            Iterator<v6.a> it2 = C.iterator();
            v6.s();
            while (it2.hasNext()) {
                v6.a next2 = it2.next();
                String str = next2.f9259e;
                f4.a(next2.f9264j);
                v6.s();
            }
            v6.s();
        }
    }

    public static void u(boolean z3, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            v6.s();
            if (f7828t || z3) {
                if ((f7832x || !z3) && !TextUtils.isEmpty(str)) {
                    if (!z3) {
                        if (A.get(str) != null) {
                            return;
                        }
                        A.put(str, Boolean.TRUE);
                        q(B(str, "a14"), "open_common");
                    } else if (B.get(str) != null) {
                    } else {
                        B.put(str, Boolean.TRUE);
                        q(B(str, "a15"), "open_common");
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean v() {
        f e4;
        if (f7815g != null) {
            X();
            if (!K()) {
                return false;
            }
            if (G()) {
                return true;
            }
        }
        return f7816h && (e4 = e(f7815g, "IPV6_CONFIG_NAME", "open_common")) != null && e4.a() < 5;
    }

    public static synchronized boolean w(String str, long j4) {
        synchronized (g4.class) {
            boolean z3 = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            h R = R(str);
            long j5 = 0;
            if (j4 != (R != null ? R.f7869a : 0L)) {
                if (f7823o != null && f7823o.containsKey(str)) {
                    j5 = f7823o.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - j5 > PolicyConfig.mServerBusyRetryBaseInternal) {
                    z3 = true;
                }
            }
            return z3;
        }
    }

    public static boolean x(String str, boolean z3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z3;
            }
            String[] split = URLDecoder.decode(str).split(TTPathConst.sSeparator);
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z3;
        }
    }

    private static boolean y(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    private static c z(Context context, p4 p4Var, String str, Map<String, String> map) {
        return d(context, p4Var, str, map, null, null, null);
    }
}
