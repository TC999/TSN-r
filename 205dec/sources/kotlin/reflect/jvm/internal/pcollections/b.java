package kotlin.reflect.jvm.internal.pcollections;

import org.jetbrains.annotations.NotNull;

/* compiled from: HashPMap.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b<K, V> {

    /* renamed from: c  reason: collision with root package name */
    private static final b<Object, Object> f58617c = new b<>(d.a(), 0);

    /* renamed from: a  reason: collision with root package name */
    private final d<a<e<K, V>>> f58618a;

    /* renamed from: b  reason: collision with root package name */
    private final int f58619b;

    private b(d<a<e<K, V>>> dVar, int i4) {
        this.f58618a = dVar;
        this.f58619b = i4;
    }

    private static /* synthetic */ void a(int i4) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i4 != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    @NotNull
    public static <K, V> b<K, V> c() {
        b<K, V> bVar = (b<K, V>) f58617c;
        if (bVar == null) {
            a(0);
        }
        return bVar;
    }

    private a<e<K, V>> e(int i4) {
        a<e<K, V>> b4 = this.f58618a.b(i4);
        return b4 == null ? a.c() : b4;
    }

    private static <K, V> int f(a<e<K, V>> aVar, Object obj) {
        int i4 = 0;
        while (aVar != null && aVar.size() > 0) {
            if (aVar.f58613a.f58628a.equals(obj)) {
                return i4;
            }
            aVar = aVar.f58614b;
            i4++;
        }
        return -1;
    }

    public boolean b(Object obj) {
        return f(e(obj.hashCode()), obj) != -1;
    }

    public V d(Object obj) {
        for (a e4 = e(obj.hashCode()); e4 != null && e4.size() > 0; e4 = e4.f58614b) {
            e eVar = (e) e4.f58613a;
            if (eVar.f58628a.equals(obj)) {
                return eVar.f58629b;
            }
        }
        return null;
    }

    @NotNull
    public b<K, V> g(Object obj) {
        a<e<K, V>> e4 = e(obj.hashCode());
        int f4 = f(e4, obj);
        if (f4 == -1) {
            return this;
        }
        a<e<K, V>> k4 = e4.k(f4);
        if (k4.size() == 0) {
            return new b<>(this.f58618a.c(obj.hashCode()), this.f58619b - 1);
        }
        return new b<>(this.f58618a.d(obj.hashCode(), k4), this.f58619b - 1);
    }

    @NotNull
    public b<K, V> h(K k4, V v3) {
        a<e<K, V>> e4 = e(k4.hashCode());
        int size = e4.size();
        int f4 = f(e4, k4);
        if (f4 != -1) {
            e4 = e4.k(f4);
        }
        a<e<K, V>> m4 = e4.m(new e<>(k4, v3));
        return new b<>(this.f58618a.d(k4.hashCode(), m4), (this.f58619b - size) + m4.size());
    }

    public int i() {
        return this.f58619b;
    }
}
