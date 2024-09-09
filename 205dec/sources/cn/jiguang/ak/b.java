package cn.jiguang.ak;

import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f2269a;

    /* renamed from: b  reason: collision with root package name */
    private String f2270b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f2271c;

    /* renamed from: d  reason: collision with root package name */
    private int f2272d;

    /* renamed from: e  reason: collision with root package name */
    private long f2273e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2274f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2275g;

    /* renamed from: h  reason: collision with root package name */
    private int f2276h;

    /* renamed from: i  reason: collision with root package name */
    private int f2277i;

    public b() {
        this.f2276h = -1;
        this.f2277i = -1;
        this.f2271c = new HashMap();
    }

    public b(String str) {
        this.f2276h = -1;
        this.f2277i = -1;
        this.f2269a = str;
        this.f2272d = 0;
        this.f2274f = false;
        this.f2275g = false;
        this.f2271c = new HashMap();
    }

    public b a(boolean z3) {
        this.f2274f = z3;
        return this;
    }

    public String a() {
        return this.f2270b;
    }

    public void a(int i4) {
        this.f2276h = i4;
    }

    public void a(long j4) {
        this.f2275g = true;
        this.f2273e = j4;
    }

    public void a(String str) {
        this.f2270b = str;
    }

    public void a(Map<String, Object> map) {
        this.f2271c = map;
    }

    public int b() {
        return this.f2276h;
    }

    public void b(int i4) {
        this.f2277i = i4;
    }

    public void c(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("The type of HttpResponse cannot be smaller than 0.");
        }
        this.f2272d = i4;
    }

    public String toString() {
        return "HttpResponse{responseBody='" + this.f2270b + "', responseCode=" + this.f2276h + '}';
    }
}
