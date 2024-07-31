package com.acse.ottn.animator.p032b;

/* renamed from: com.acse.ottn.animator.b.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC1373d<T, V> {

    /* renamed from: a */
    private final String f2407a;

    /* renamed from: b */
    private final Class<V> f2408b;

    public AbstractC1373d(Class<V> cls, String str) {
        this.f2407a = str;
        this.f2408b = cls;
    }

    /* renamed from: a */
    public static <T, V> AbstractC1373d<T, V> m57006a(Class<T> cls, Class<V> cls2, String str) {
        return new C1374e(cls, cls2, str);
    }

    /* renamed from: a */
    public abstract V mo57003a(T t);

    /* renamed from: a */
    public String m57007a() {
        return this.f2407a;
    }

    /* renamed from: a */
    public void mo57002a(T t, V v) {
        throw new UnsupportedOperationException("Property " + m57007a() + " is read-only");
    }

    /* renamed from: b */
    public Class<V> m57005b() {
        return this.f2408b;
    }

    /* renamed from: c */
    public boolean mo57001c() {
        return false;
    }
}
