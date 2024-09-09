package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.dz;
import com.amap.api.col.s.x2;
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
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AuthConfigManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class y0 {
    private static volatile boolean D = false;

    /* renamed from: a  reason: collision with root package name */
    public static int f10475a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static String f10476b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f10477c = "6";

    /* renamed from: d  reason: collision with root package name */
    private static String f10478d = "4";

    /* renamed from: e  reason: collision with root package name */
    private static String f10479e = "9";

    /* renamed from: f  reason: collision with root package name */
    private static String f10480f = "8";

    /* renamed from: g  reason: collision with root package name */
    public static Context f10481g = null;

    /* renamed from: h  reason: collision with root package name */
    private static volatile boolean f10482h = true;

    /* renamed from: i  reason: collision with root package name */
    private static Vector<f> f10483i = new Vector<>();

    /* renamed from: j  reason: collision with root package name */
    private static Map<String, Integer> f10484j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private static String f10485k = null;

    /* renamed from: l  reason: collision with root package name */
    private static long f10486l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static volatile boolean f10487m = false;

    /* renamed from: n  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, h> f10488n = new ConcurrentHashMap<>(8);

    /* renamed from: o  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f10489o = new ConcurrentHashMap<>(8);

    /* renamed from: p  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, e> f10490p = new ConcurrentHashMap<>(8);

    /* renamed from: q  reason: collision with root package name */
    private static boolean f10491q = false;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f10492r = false;

    /* renamed from: s  reason: collision with root package name */
    public static int f10493s = 5000;

    /* renamed from: t  reason: collision with root package name */
    public static boolean f10494t = true;

    /* renamed from: u  reason: collision with root package name */
    public static boolean f10495u = false;

    /* renamed from: v  reason: collision with root package name */
    private static int f10496v = 3;

    /* renamed from: w  reason: collision with root package name */
    public static boolean f10497w = true;

    /* renamed from: x  reason: collision with root package name */
    public static boolean f10498x = false;

    /* renamed from: y  reason: collision with root package name */
    private static int f10499y = 3;

    /* renamed from: z  reason: collision with root package name */
    public static boolean f10500z = false;
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> B = new ConcurrentHashMap<>();
    private static ArrayList<x2.a> C = new ArrayList<>();
    private static Queue<x2.c> E = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AuthConfigManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends z3 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10501b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10502c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f10503d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f10504e;

        a(String str, String str2, String str3, String str4) {
            this.f10501b = str;
            this.f10502c = str2;
            this.f10503d = str3;
            this.f10504e = str4;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            e eVar = (e) y0.f10490p.get(this.f10501b);
            if (eVar == null) {
                return;
            }
            b bVar = eVar.f10525c;
            c b4 = y0.b(y0.f10481g, eVar.f10523a, eVar.f10524b, this.f10502c, this.f10503d, this.f10504e);
            if (b4 == null || bVar == null) {
                return;
            }
            bVar.a(b4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AuthConfigManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface b {
        void a(c cVar);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AuthConfigManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f10505a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f10506b;

        /* renamed from: c  reason: collision with root package name */
        public String f10507c;

        /* renamed from: d  reason: collision with root package name */
        public int f10508d = -1;

        /* renamed from: e  reason: collision with root package name */
        public long f10509e = 0;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f10510f;

        /* renamed from: g  reason: collision with root package name */
        public a f10511g;

        /* renamed from: h  reason: collision with root package name */
        public b f10512h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f10513i;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: AuthConfigManager.java */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f10514a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f10515b;

            /* renamed from: c  reason: collision with root package name */
            public JSONObject f10516c;
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: AuthConfigManager.java */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public boolean f10517a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AuthConfigManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class d extends v2 {

        /* renamed from: p  reason: collision with root package name */
        private String f10518p;

        /* renamed from: q  reason: collision with root package name */
        private Map<String, String> f10519q;

        /* renamed from: r  reason: collision with root package name */
        private String f10520r;

        /* renamed from: s  reason: collision with root package name */
        private String f10521s;

        /* renamed from: t  reason: collision with root package name */
        private String f10522t;

        d(Context context, i1 i1Var, String str, String str2, String str3, String str4) {
            super(context, i1Var);
            this.f10518p = str;
            this.f10519q = null;
            this.f10520r = str2;
            this.f10521s = str3;
            this.f10522t = str4;
            g(dz.c.HTTPS);
            e(dz.a.FIX);
        }

        private static String P(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        @Override // com.amap.api.col.s.v2
        public final byte[] L() {
            String K = c1.K(this.f10343m);
            if (!TextUtils.isEmpty(K)) {
                K = g1.a(new StringBuilder(K).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f10518p) ? "" : this.f10518p);
            hashMap.put("plattype", "android");
            hashMap.put("ccver", "1");
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, this.f10344n.d());
            hashMap.put("version", this.f10344n.e());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", K);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.f10519q;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.f10519q);
            }
            hashMap.put("abitype", j1.d(this.f10343m));
            hashMap.put("ext", this.f10344n.g());
            return j1.o(j1.f(hashMap));
        }

        @Override // com.amap.api.col.s.v2
        protected final String M() {
            return "3.0";
        }

        @Override // com.amap.api.col.s.f1, com.amap.api.col.s.dz
        public final String a() {
            return P("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.f10521s);
        }

        @Override // com.amap.api.col.s.dz
        public final String h() {
            return P("https://restsdk.amap.com/v3/iasdkauth", this.f10520r);
        }

        @Override // com.amap.api.col.s.dz
        public final Map<String, String> p() {
            if (TextUtils.isEmpty(this.f10522t)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f10522t);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.col.s.dz
        public final String r() {
            if (!TextUtils.isEmpty(this.f10522t)) {
                return this.f10522t;
            }
            return super.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AuthConfigManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        i1 f10523a;

        /* renamed from: b  reason: collision with root package name */
        String f10524b;

        /* renamed from: c  reason: collision with root package name */
        b f10525c;

        private e() {
        }

        /* synthetic */ e(byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AuthConfigManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private String f10526a;

        /* renamed from: b  reason: collision with root package name */
        private String f10527b;

        /* renamed from: c  reason: collision with root package name */
        private AtomicInteger f10528c;

        public f(String str, String str2, int i4) {
            this.f10526a = str;
            this.f10527b = str2;
            this.f10528c = new AtomicInteger(i4);
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
            AtomicInteger atomicInteger = this.f10528c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void c(String str) {
            this.f10527b = str;
        }

        public final String e() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f10526a);
                jSONObject.put("f", this.f10527b);
                jSONObject.put("h", this.f10528c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AuthConfigManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f10529a = true;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f10530b = false;

        /* renamed from: c  reason: collision with root package name */
        public static boolean f10531c = true;

        /* renamed from: d  reason: collision with root package name */
        public static int f10532d;

        /* renamed from: e  reason: collision with root package name */
        public static boolean f10533e;

        /* renamed from: f  reason: collision with root package name */
        public static int f10534f;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AuthConfigManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public long f10535a;

        /* renamed from: b  reason: collision with root package name */
        public String f10536b;

        h(Long l4, String str) {
            this.f10535a = 0L;
            this.f10536b = "";
            this.f10535a = l4.longValue();
            this.f10536b = str;
        }
    }

    private static void A(Context context) {
        if (context == null) {
            return;
        }
        f10482h = j2.l(context, "open_common", "a2", true);
    }

    public static void B(x2.c cVar) {
        synchronized (C) {
            boolean z3 = false;
            for (int i4 = 0; i4 < C.size(); i4++) {
                x2.a aVar = C.get(i4);
                if (cVar.f10424c.equals(aVar.f10411b) && cVar.f10425d.equals(aVar.f10414e)) {
                    int i5 = cVar.f10434m;
                    int i6 = aVar.f10415f;
                    if (i5 == i6) {
                        if (i6 == 1) {
                            aVar.f10418i = ((aVar.f10419j.get() * aVar.f10418i) + cVar.f10427f) / (aVar.f10419j.get() + 1);
                        }
                        aVar.f10419j.getAndIncrement();
                        z3 = true;
                    }
                }
            }
            if (!z3) {
                C.add(new x2.a(cVar));
            }
            x2.i();
        }
    }

    public static synchronized void C(String str, boolean z3) {
        synchronized (y0.class) {
            o(str, z3, null, null, null);
        }
    }

    public static boolean D() {
        Integer num;
        Context context = f10481g;
        if (context == null) {
            return false;
        }
        String I = c1.I(context);
        return (TextUtils.isEmpty(I) || (num = f10484j.get(I.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static String E(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + ";15K;16H;17I;1A4;17S;183";
    }

    public static void F() {
        try {
            f c4 = c(f10481g, "IPV6_CONFIG_NAME", "open_common");
            String c5 = j1.c(System.currentTimeMillis(), "yyyyMMdd");
            if (!c5.equals(c4.f10527b)) {
                c4.c(c5);
                c4.f10528c.set(0);
            }
            c4.f10528c.incrementAndGet();
            j(f10481g, "IPV6_CONFIG_NAME", "open_common", c4);
        } catch (Throwable unused) {
        }
    }

    private static void G(Context context) {
        if (context == null) {
            return;
        }
        f10494t = j2.l(context, "open_common", "a13", true);
        f10497w = j2.l(context, "open_common", "a6", true);
        f10495u = j2.l(context, "open_common", "a7", false);
        f10493s = j2.a(context, "open_common", "a8", 5000);
        f10496v = j2.a(context, "open_common", "a9", 3);
        f10498x = j2.l(context, "open_common", "a10", false);
        f10499y = j2.a(context, "open_common", "a11", 3);
        f10500z = j2.l(context, "open_common", "a12", false);
    }

    public static void H(x2.c cVar) {
        if (cVar != null && f10500z) {
            synchronized (E) {
                E.offer(cVar);
                x2.i();
            }
        }
    }

    public static void I() {
        if (f10487m) {
            return;
        }
        try {
            Context context = f10481g;
            if (context == null) {
                return;
            }
            f10487m = true;
            e1.a().c(context);
            A(context);
            G(context);
            g.f10529a = j2.l(context, "open_common", "ucf", g.f10529a);
            g.f10530b = j2.l(context, "open_common", "fsv2", g.f10530b);
            g.f10531c = j2.l(context, "open_common", "usc", g.f10531c);
            g.f10532d = j2.a(context, "open_common", "umv", g.f10532d);
            g.f10533e = j2.l(context, "open_common", "ust", g.f10533e);
            g.f10534f = j2.a(context, "open_common", "ustv", g.f10534f);
        } catch (Throwable unused) {
        }
    }

    private static void J(Context context) {
        try {
            if (f10491q) {
                return;
            }
            s1.f10198e = j2.l(context, "open_common", "a4", true);
            s1.f10199f = j2.l(context, "open_common", "a5", true);
            f10491q = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized boolean K(String str) {
        synchronized (y0.class) {
            try {
            } finally {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f10490p == null) {
                return false;
            }
            if (f10489o == null) {
                f10489o = new ConcurrentHashMap<>(8);
            }
            if (f10490p.containsKey(str) && !f10489o.containsKey(str)) {
                f10489o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    public static x2.a L() {
        if (D) {
            return null;
        }
        synchronized (C) {
            if (D) {
                return null;
            }
            Collections.sort(C);
            if (C.size() > 0) {
                x2.a clone = C.get(0).clone();
                D = true;
                return clone;
            }
            return null;
        }
    }

    private static void M(Context context) {
        try {
            if (f10492r) {
                return;
            }
            l1.f9996d = u(j2.o(context, "open_common", "a16", ""), true);
            l1.f9994b = j2.b(context, "open_common", "a17", l1.f9993a);
            f10492r = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized void N(String str) {
        synchronized (y0.class) {
            if (f10489o == null) {
                return;
            }
            if (f10489o.containsKey(str)) {
                f10489o.remove(str);
            }
        }
    }

    public static synchronized h O(String str) {
        synchronized (y0.class) {
            try {
                if (f10488n == null) {
                    f10488n = new ConcurrentHashMap<>(8);
                }
                if (f10488n.containsKey(str)) {
                    return f10488n.get(str);
                }
                return new h(0L, "");
            }
        }
    }

    public static x2.c P() {
        synchronized (E) {
            x2.c poll = E.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    public static boolean R(String str) {
        f c4;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (f10494t) {
                if (A.get(str) == null) {
                    Context context = f10481g;
                    if (context == null || (c4 = c(context, y(str, "a14"), "open_common")) == null) {
                        return true;
                    }
                    return c4.a() < f10496v;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void S() {
        try {
            Context context = f10481g;
            if (context != null) {
                String I = c1.I(context);
                if (!TextUtils.isEmpty(f10485k) && !TextUtils.isEmpty(I) && f10485k.equals(I) && System.currentTimeMillis() - f10486l < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(I)) {
                    f10485k = I;
                }
            } else if (System.currentTimeMillis() - f10486l < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                return;
            }
            f10486l = System.currentTimeMillis();
            f10484j.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i4 = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!v((Inet6Address) address)) {
                                i4 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!v(inet4Address) && !inet4Address.getHostAddress().startsWith(j1.t("FMTkyLjE2OC40My4"))) {
                                i4 |= 1;
                            }
                        }
                    }
                    if (i4 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            f10484j.put("WIFI", Integer.valueOf(i4));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            f10484j.put("MOBILE", Integer.valueOf(i4));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            d2.e(th, "at", "ipstack");
        }
    }

    public static boolean T(String str) {
        f c4;
        if (!TextUtils.isEmpty(str) && f10498x) {
            if (B.get(str) == null) {
                Context context = f10481g;
                if (context == null || (c4 = c(context, y(str, "a15"), "open_common")) == null) {
                    return true;
                }
                return c4.a() < f10499y;
            }
            return false;
        }
        return false;
    }

    private static boolean U() {
        Integer num;
        Context context = f10481g;
        if (context == null) {
            return false;
        }
        String I = c1.I(context);
        return (TextUtils.isEmpty(I) || (num = f10484j.get(I.toUpperCase())) == null || num.intValue() != 2) ? false : true;
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

    public static c b(Context context, i1 i1Var, String str, String str2, String str3, String str4) {
        return w(context, i1Var, str, str2, str3, str4);
    }

    private static synchronized f c(Context context, String str, String str2) {
        f fVar;
        synchronized (y0.class) {
            if (!TextUtils.isEmpty(str)) {
                for (int i4 = 0; i4 < f10483i.size(); i4++) {
                    fVar = f10483i.get(i4);
                    if (fVar != null && str.equals(fVar.f10526a)) {
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
            f d4 = f.d(j2.o(context, str2, str, ""));
            String c4 = j1.c(System.currentTimeMillis(), "yyyyMMdd");
            if (d4 == null) {
                d4 = new f(str, c4, 0);
            }
            if (!c4.equals(d4.f10527b)) {
                d4.c(c4);
                d4.f10528c.set(0);
            }
            f10483i.add(d4);
            return d4;
        }
    }

    public static String d(String str) {
        e eVar;
        if (!f10490p.containsKey(str) || (eVar = f10490p.get(str)) == null) {
            return null;
        }
        return eVar.f10524b;
    }

    public static void e(Context context) {
        if (context != null) {
            f10481g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private static void f(Context context, i1 i1Var, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", i1Var.d());
        hashMap.put("amap_sdk_version", i1Var.f());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            g3 g3Var = new g3(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O001");
            g3Var.a(jSONObject);
            h3.d(g3Var, context);
        } catch (bv unused) {
        }
    }

    public static synchronized void g(Context context, i1 i1Var, String str, b bVar) {
        synchronized (y0.class) {
            if (context == null || i1Var == null) {
                return;
            }
            try {
                if (f10481g == null) {
                    f10481g = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                String d4 = i1Var.d();
                if (TextUtils.isEmpty(d4)) {
                    return;
                }
                k(i1Var);
                if (f10490p == null) {
                    f10490p = new ConcurrentHashMap<>(8);
                }
                if (f10489o == null) {
                    f10489o = new ConcurrentHashMap<>(8);
                }
                if (f10488n == null) {
                    f10488n = new ConcurrentHashMap<>(8);
                }
                if (!f10490p.containsKey(d4)) {
                    e eVar = new e((byte) 0);
                    eVar.f10523a = i1Var;
                    eVar.f10524b = str;
                    eVar.f10525c = bVar;
                    f10490p.put(d4, eVar);
                    long b4 = j2.b(f10481g, "open_common", d4, 0L);
                    Context context2 = f10481g;
                    f10488n.put(d4, new h(Long.valueOf(b4), j2.o(context2, "open_common", d4 + "lct-info", "")));
                    J(f10481g);
                    M(f10481g);
                }
            } catch (Throwable th) {
                d2.e(th, "at", "rglc");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x02b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0299 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(android.content.Context r18, com.amap.api.col.s.i1 r19, java.lang.String r20, com.amap.api.col.s.y0.c r21, org.json.JSONObject r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 803
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.y0.h(android.content.Context, com.amap.api.col.s.i1, java.lang.String, com.amap.api.col.s.y0$c, org.json.JSONObject):void");
    }

    private static void i(Context context, i1 i1Var, Throwable th) {
        f(context, i1Var, th.getMessage());
    }

    private static void j(Context context, String str, String str2, f fVar) {
        if (fVar == null || TextUtils.isEmpty(fVar.f10526a)) {
            return;
        }
        String e4 = fVar.e();
        if (TextUtils.isEmpty(e4) || context == null) {
            return;
        }
        SharedPreferences.Editor c4 = j2.c(context, str2);
        c4.putString(str, e4);
        j2.f(c4);
    }

    private static void k(i1 i1Var) {
        if (i1Var != null) {
            try {
                if (TextUtils.isEmpty(i1Var.d())) {
                    return;
                }
                String f4 = i1Var.f();
                if (TextUtils.isEmpty(f4)) {
                    f4 = i1Var.e();
                }
                if (TextUtils.isEmpty(f4)) {
                    return;
                }
                s1.b(i1Var.d(), f4);
            } catch (Throwable unused) {
            }
        }
    }

    public static void l(x2.c cVar) {
        if (cVar == null || f10481g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", cVar.f10424c);
        hashMap.put("hostname", cVar.f10426e);
        hashMap.put("path", cVar.f10425d);
        hashMap.put("csid", cVar.f10422a);
        hashMap.put("degrade", String.valueOf(cVar.f10423b.a()));
        hashMap.put("errorcode", String.valueOf(cVar.f10434m));
        hashMap.put("errorsubcode", String.valueOf(cVar.f10435n));
        hashMap.put("connecttime", String.valueOf(cVar.f10429h));
        hashMap.put("writetime", String.valueOf(cVar.f10430i));
        hashMap.put("readtime", String.valueOf(cVar.f10431j));
        hashMap.put("datasize", String.valueOf(cVar.f10433l));
        hashMap.put("totaltime", String.valueOf(cVar.f10427f));
        String jSONObject = new JSONObject(hashMap).toString();
        "--\u57cb\u70b9--".concat(String.valueOf(jSONObject));
        x2.i();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            g3 g3Var = new g3(f10481g, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O008");
            g3Var.a(jSONObject);
            h3.d(g3Var, f10481g);
        } catch (bv unused) {
        }
    }

    private static synchronized void m(String str, long j4, String str2) {
        synchronized (y0.class) {
            try {
                if (f10490p != null && f10490p.containsKey(str)) {
                    if (f10488n == null) {
                        f10488n = new ConcurrentHashMap<>(8);
                    }
                    f10488n.put(str, new h(Long.valueOf(j4), str2));
                    Context context = f10481g;
                    if (context != null) {
                        SharedPreferences.Editor c4 = j2.c(context, "open_common");
                        j2.i(c4, str, j4);
                        j2.j(c4, str + "lct-info", str2);
                        j2.f(c4);
                    }
                }
            } catch (Throwable th) {
                d2.e(th, "at", "ucut");
            }
        }
    }

    private static void n(String str, String str2) {
        f c4 = c(f10481g, str, str2);
        String c5 = j1.c(System.currentTimeMillis(), "yyyyMMdd");
        if (!c5.equals(c4.f10527b)) {
            c4.c(c5);
            c4.f10528c.set(0);
        }
        c4.f10528c.incrementAndGet();
        j(f10481g, str, str2, c4);
    }

    public static synchronized void o(String str, boolean z3, String str2, String str3, String str4) {
        synchronized (y0.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f10489o == null) {
                    f10489o = new ConcurrentHashMap<>(8);
                }
                f10489o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (f10490p == null) {
                    return;
                }
                if (f10490p.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z3) {
                        w2.j(true, str);
                    }
                    y3.e().c(new a(str, str2, str3, str4));
                }
            } catch (Throwable th) {
                d2.e(th, "at", "lca");
            }
        }
    }

    public static void p(String str, boolean z3, boolean z4, boolean z5) {
        if (TextUtils.isEmpty(str) || f10481g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", String.valueOf(z3));
        hashMap.put("ant", c1.D(f10481g) == 0 ? "0" : "1");
        if (z5) {
            hashMap.put("type", z3 ? f10479e : f10480f);
        } else {
            hashMap.put("type", z3 ? f10477c : f10478d);
        }
        hashMap.put("status", z4 ? "0" : "1");
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            g3 g3Var = new g3(f10481g, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O002");
            g3Var.a(jSONObject);
            h3.d(g3Var, f10481g);
        } catch (bv unused) {
        }
    }

    public static void q(boolean z3, x2.a aVar) {
        if (!D || aVar == null) {
            return;
        }
        synchronized (C) {
            if (z3) {
                Iterator<x2.a> it = C.iterator();
                while (it.hasNext()) {
                    x2.a next = it.next();
                    if (next.f10411b.equals(aVar.f10411b) && next.f10414e.equals(aVar.f10414e) && next.f10415f == aVar.f10415f) {
                        if (next.f10419j == aVar.f10419j) {
                            it.remove();
                            x2.i();
                        } else {
                            next.f10419j.set(next.f10419j.get() - aVar.f10419j.get());
                            x2.i();
                        }
                    }
                }
            }
            D = false;
            Iterator<x2.a> it2 = C.iterator();
            x2.i();
            while (it2.hasNext()) {
                x2.a next2 = it2.next();
                String str = next2.f10414e;
                com.amap.api.col.p0003l.f4.a(next2.f10419j);
                x2.i();
            }
            x2.i();
        }
    }

    public static void r(boolean z3, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            x2.i();
            if (f10494t || z3) {
                if ((f10498x || !z3) && !TextUtils.isEmpty(str)) {
                    if (!z3) {
                        if (A.get(str) != null) {
                            return;
                        }
                        A.put(str, Boolean.TRUE);
                        n(y(str, "a14"), "open_common");
                    } else if (B.get(str) != null) {
                    } else {
                        B.put(str, Boolean.TRUE);
                        n(y(str, "a15"), "open_common");
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean s() {
        f c4;
        if (f10481g != null) {
            S();
            if (!D()) {
                return false;
            }
            if (U()) {
                return true;
            }
        }
        return f10482h && (c4 = c(f10481g, "IPV6_CONFIG_NAME", "open_common")) != null && c4.a() < 5;
    }

    public static synchronized boolean t(String str, long j4) {
        synchronized (y0.class) {
            boolean z3 = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            h O = O(str);
            long j5 = 0;
            if (j4 != (O != null ? O.f10535a : 0L)) {
                if (f10489o != null && f10489o.containsKey(str)) {
                    j5 = f10489o.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - j5 > PolicyConfig.mServerBusyRetryBaseInternal) {
                    z3 = true;
                }
            }
            return z3;
        }
    }

    public static boolean u(String str, boolean z3) {
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

    private static boolean v(InetAddress inetAddress) {
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.s.y0.c w(android.content.Context r22, com.amap.api.col.s.i1 r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.y0.w(android.content.Context, com.amap.api.col.s.i1, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.s.y0$c");
    }

    public static i1 x(String str) {
        e eVar = f10490p.get(str);
        if (eVar != null) {
            return eVar.f10523a;
        }
        return null;
    }

    private static String y(String str, String str2) {
        String b4 = g1.b(str.getBytes());
        return str2 + "_" + b4;
    }

    private static String z(List<String> list) {
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
