package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b0;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.p;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r;
import com.bytedance.msdk.api.TTPrivacyConfig;
import com.bytedance.msdk.api.UserInfoForSegment;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: SdkGlobalInfo.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b {

    /* renamed from: x  reason: collision with root package name */
    private static final b f258x = new b();

    /* renamed from: c  reason: collision with root package name */
    private String[] f261c;

    /* renamed from: d  reason: collision with root package name */
    private String f262d;

    /* renamed from: e  reason: collision with root package name */
    private String f263e;

    /* renamed from: i  reason: collision with root package name */
    private String f267i;

    /* renamed from: k  reason: collision with root package name */
    private boolean f269k;

    /* renamed from: l  reason: collision with root package name */
    private String f270l;

    /* renamed from: m  reason: collision with root package name */
    private Map<String, String> f271m;

    /* renamed from: n  reason: collision with root package name */
    private String f272n;

    /* renamed from: o  reason: collision with root package name */
    private TTCustomController f273o;

    /* renamed from: p  reason: collision with root package name */
    private String f274p;

    /* renamed from: t  reason: collision with root package name */
    private UserInfoForSegment f278t;

    /* renamed from: w  reason: collision with root package name */
    private int[] f281w;

    /* renamed from: a  reason: collision with root package name */
    private int f259a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f260b = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f264f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f265g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f266h = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f268j = true;

    /* renamed from: q  reason: collision with root package name */
    private Set<String> f275q = new HashSet();

    /* renamed from: r  reason: collision with root package name */
    private Map<String, Map<String, String>> f276r = new HashMap();

    /* renamed from: s  reason: collision with root package name */
    private Map<String, Map<String, String>> f277s = new HashMap();

    /* renamed from: u  reason: collision with root package name */
    private long f279u = -1;

    /* renamed from: v  reason: collision with root package name */
    private TTPrivacyConfig f280v = new TTPrivacyConfig();

    private b() {
    }

    public static b B() {
        return f258x;
    }

    public boolean A() {
        return ("com.header.app.untext".equals(a.d().getPackageName()) && "5001121".equals(this.f262d)) || ("com.bytedance.mediation_demo".equals(a.d().getPackageName()) && "5001121".equals(this.f262d));
    }

    public void a(int i4) {
    }

    public void a(long j4) {
        try {
            r a4 = r.a("tt_sdk_settings", a.d());
            if (a4.a("first_install_time", -1L) == -1) {
                this.f279u = j4;
                a4.b("first_install_time", j4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void b(boolean z3) {
        this.f269k = z3;
    }

    public String c() {
        return this.f262d;
    }

    public boolean d() {
        return this.f268j;
    }

    public void e(boolean z3) {
        this.f266h = z3;
    }

    public long f() {
        long j4 = this.f279u;
        if (j4 != -1) {
            return j4;
        }
        try {
            r a4 = r.a("tt_sdk_settings", a.d());
            long a5 = a4.a("first_install_time", -1L);
            if (a5 == -1) {
                long currentTimeMillis = System.currentTimeMillis();
                a4.b("first_install_time", currentTimeMillis);
                this.f279u = currentTimeMillis;
                return currentTimeMillis;
            }
            this.f279u = a5;
            return a5;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0L;
        }
    }

    public String g() {
        return this.f263e;
    }

    public Map<String, Map<String, String>> h() {
        return this.f276r;
    }

    @Deprecated
    public TTCustomController i() {
        return this.f273o;
    }

    public String j() {
        return this.f270l;
    }

    public String k() {
        return this.f272n;
    }

    public String[] l() {
        return this.f261c;
    }

    public int m() {
        return this.f259a;
    }

    public int[] n() {
        return this.f281w;
    }

    public String o() {
        if (("com.header.app.untext".equals(a.d().getPackageName()) && "5001121".equals(this.f262d)) || ("com.bytedance.mediation_demo".equals(a.d().getPackageName()) && "5001121".equals(this.f262d))) {
            try {
                return r.a("tt_mediation_ppe_info", a.d()).d("tt_ppe_content");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public TTPrivacyConfig p() {
        return this.f280v;
    }

    public String q() {
        return this.f267i;
    }

    public Map<String, Map<String, String>> r() {
        return this.f277s;
    }

    public UserInfoForSegment s() {
        return this.f278t;
    }

    public boolean t() {
        return "5001121".equals(this.f262d) || "5001121".equals(this.f262d);
    }

    public boolean u() {
        String a4 = b0.a();
        return "com.header.app.untext".equals(a4) || "com.bytedance.mediation_demo".equals(a4);
    }

    public boolean v() {
        return this.f269k;
    }

    public boolean w() {
        return this.f264f;
    }

    public boolean x() {
        return this.f265g;
    }

    public boolean y() {
        return this.f266h;
    }

    public boolean z() {
        return this.f260b;
    }

    private static void g(String str) {
        p.a(str, "name\u4e0d\u80fd\u4e3a\u7a7a");
    }

    public void b(String str) {
        g(str);
        this.f263e = str;
    }

    public void c(String str) {
        this.f270l = str;
    }

    public void d(Map<String, String> map) {
        if (this.f271m == null) {
            this.f271m = new HashMap();
        }
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f271m.putAll(map);
    }

    public void e(String str) {
        this.f267i = str;
    }

    public void c(boolean z3) {
        this.f264f = z3;
    }

    public Map e() {
        return this.f271m;
    }

    public void b(int i4) {
        this.f259a = i4;
    }

    public void c(Map<String, Map<String, String>> map) {
        if (map != null) {
            this.f277s.putAll(map);
        }
    }

    public String b() {
        if (!TextUtils.isEmpty(this.f274p)) {
            return this.f274p;
        }
        String b4 = r.a((String) null, a.d()).b();
        this.f274p = b4;
        if (!TextUtils.isEmpty(b4)) {
            return this.f274p;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        r.a((String) null, a.d()).e(valueOf);
        this.f274p = valueOf;
        return valueOf;
    }

    public void a(String str) {
        f(str);
        this.f262d = str;
    }

    public void d(boolean z3) {
        this.f265g = z3;
    }

    public void d(String str) {
        this.f272n = str;
    }

    public void a(boolean z3) {
        this.f268j = z3;
    }

    public void a(Map<String, String> map) {
        this.f271m = map;
    }

    public void f(boolean z3) {
        this.f260b = z3;
    }

    private static void f(String str) {
        p.a(str, "appid\u4e0d\u80fd\u4e3a\u7a7a");
    }

    @Deprecated
    public void a(TTCustomController tTCustomController) {
        this.f273o = tTCustomController;
    }

    public void a(int... iArr) {
        this.f281w = iArr;
    }

    public void a(String[] strArr) {
        this.f261c = strArr;
    }

    public Set<String> a() {
        return this.f275q;
    }

    public void b(Map<String, Map<String, String>> map) {
        if (map != null) {
            this.f276r.putAll(map);
        }
    }

    public void a(Set<String> set) {
        if (set != null) {
            this.f275q.addAll(set);
        }
    }

    public void a(UserInfoForSegment userInfoForSegment, boolean z3) {
        boolean equals;
        if (!z3) {
            UserInfoForSegment userInfoForSegment2 = this.f278t;
            if (userInfoForSegment2 == null && userInfoForSegment == null) {
                equals = true;
            } else {
                equals = (userInfoForSegment2 == null || userInfoForSegment == null) ? false : userInfoForSegment2.equals(userInfoForSegment);
            }
            this.f278t = userInfoForSegment;
            if (equals) {
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b.a(a.f()).d().a();
            return;
        }
        this.f278t = userInfoForSegment;
    }

    public void a(TTPrivacyConfig tTPrivacyConfig) {
        if (tTPrivacyConfig != null) {
            this.f280v = tTPrivacyConfig;
        }
    }
}
