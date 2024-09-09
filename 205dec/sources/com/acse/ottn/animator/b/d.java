package com.acse.ottn.animator.b;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class d<T, V> {

    /* renamed from: a  reason: collision with root package name */
    private final String f4949a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<V> f4950b;

    public d(Class<V> cls, String str) {
        this.f4949a = str;
        this.f4950b = cls;
    }

    public static <T, V> d<T, V> a(Class<T> cls, Class<V> cls2, String str) {
        return new e(cls, cls2, str);
    }

    public abstract V a(T t3);

    public String a() {
        return this.f4949a;
    }

    public void a(T t3, V v3) {
        throw new UnsupportedOperationException("Property " + a() + " is read-only");
    }

    public Class<V> b() {
        return this.f4950b;
    }

    public boolean c() {
        return false;
    }
}
