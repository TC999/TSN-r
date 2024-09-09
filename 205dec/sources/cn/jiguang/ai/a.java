package cn.jiguang.ai;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    String f2246a;

    /* renamed from: b  reason: collision with root package name */
    String f2247b;

    /* renamed from: c  reason: collision with root package name */
    T f2248c;

    /* renamed from: d  reason: collision with root package name */
    boolean f2249d;

    /* renamed from: e  reason: collision with root package name */
    boolean f2250e;

    public a(String str, String str2, T t3) {
        this.f2246a = str;
        this.f2247b = str2;
        if (t3 == null) {
            throw new IllegalArgumentException("default value can not be null");
        }
        this.f2248c = t3;
    }

    public static a<Long> a() {
        return new a("cn.jiguang.sdk.user.profile", "key_rid_time", 0L).k();
    }

    public static a<String> b() {
        return new a<>("cn.jiguang.sdk.device", "di_ml", "");
    }

    public static a<String> c() {
        return new a<>("cn.jiguang.sdk.device", "di_mft", "");
    }

    public static a<String> d() {
        return new a<>("cn.jiguang.sdk.device", "di_rm", "");
    }

    public static a<String> e() {
        return new a<>("cn.jiguang.sdk.device", "di_ov", "");
    }

    private a<T> k() {
        this.f2249d = true;
        return this;
    }

    public a<T> a(T t3) {
        this.f2248c = t3;
        return this;
    }

    public String f() {
        return this.f2246a;
    }

    public String g() {
        return this.f2247b;
    }

    public T h() {
        return this.f2248c;
    }

    public boolean i() {
        return this.f2249d;
    }

    public boolean j() {
        return this.f2250e;
    }
}
