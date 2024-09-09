package com.acse.ottn;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class b3<T, V> {

    /* renamed from: a  reason: collision with root package name */
    public final String f5203a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<V> f5204b;

    public b3(Class<V> cls, String str) {
        this.f5203a = str;
        this.f5204b = cls;
    }

    public static <T, V> b3<T, V> a(Class<T> cls, Class<V> cls2, String str) {
        return new f3(cls, cls2, str);
    }

    public abstract V a(T t3);

    public Class<V> b() {
        return this.f5204b;
    }

    public boolean c() {
        return false;
    }

    public void a(T t3, V v3) {
        throw new UnsupportedOperationException("Property " + a() + " is read-only");
    }

    public String a() {
        return this.f5203a;
    }
}
