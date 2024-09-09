package kotlin.reflect.jvm.internal.pcollections;

/* compiled from: IntTreePMap.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class d<V> {

    /* renamed from: b  reason: collision with root package name */
    private static final d<Object> f58626b = new d<>(c.f58620f);

    /* renamed from: a  reason: collision with root package name */
    private final c<V> f58627a;

    private d(c<V> cVar) {
        this.f58627a = cVar;
    }

    public static <V> d<V> a() {
        return (d<V>) f58626b;
    }

    private d<V> e(c<V> cVar) {
        return cVar == this.f58627a ? this : new d<>(cVar);
    }

    public V b(int i4) {
        return this.f58627a.a(i4);
    }

    public d<V> c(int i4) {
        return e(this.f58627a.c(i4));
    }

    public d<V> d(int i4, V v3) {
        return e(this.f58627a.d(i4, v3));
    }
}
