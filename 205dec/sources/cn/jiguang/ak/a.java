package cn.jiguang.ak;

import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.X509TrustManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f2254a;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f2257d;

    /* renamed from: f  reason: collision with root package name */
    private Object f2259f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2260g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2261h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2262i;

    /* renamed from: m  reason: collision with root package name */
    private X509TrustManager f2266m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2267n;

    /* renamed from: o  reason: collision with root package name */
    private HostnameVerifier f2268o;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2263j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2264k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2265l = false;

    /* renamed from: b  reason: collision with root package name */
    private int f2255b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f2256c = -1;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f2258e = new HashMap();

    public a(String str) {
        this.f2254a = str;
    }

    public String a() {
        return this.f2254a;
    }

    public void a(Object obj) {
        this.f2259f = obj;
    }

    public void a(String str, String str2) {
        this.f2258e.put(str, str2);
    }

    public int b() {
        return this.f2255b;
    }

    public int c() {
        return this.f2256c;
    }

    public Object d() {
        return this.f2259f;
    }

    public boolean e() {
        return this.f2260g;
    }

    public boolean f() {
        return this.f2261h;
    }

    public boolean g() {
        return this.f2262i;
    }

    public boolean h() {
        return this.f2265l;
    }

    public X509TrustManager i() {
        return this.f2266m;
    }

    public boolean j() {
        return this.f2267n;
    }

    public HostnameVerifier k() {
        return this.f2268o;
    }

    public Map<String, String> l() {
        return this.f2257d;
    }

    public Map<String, String> m() {
        return this.f2258e;
    }

    public boolean n() {
        return this.f2263j;
    }

    public boolean o() {
        return this.f2264k;
    }
}
