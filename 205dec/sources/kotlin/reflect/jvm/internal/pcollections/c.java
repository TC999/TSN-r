package kotlin.reflect.jvm.internal.pcollections;

/* compiled from: IntTree.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class c<V> {

    /* renamed from: f  reason: collision with root package name */
    static final c<Object> f58620f = new c<>();

    /* renamed from: a  reason: collision with root package name */
    private final long f58621a;

    /* renamed from: b  reason: collision with root package name */
    private final V f58622b;

    /* renamed from: c  reason: collision with root package name */
    private final c<V> f58623c;

    /* renamed from: d  reason: collision with root package name */
    private final c<V> f58624d;

    /* renamed from: e  reason: collision with root package name */
    private final int f58625e;

    private c() {
        this.f58625e = 0;
        this.f58621a = 0L;
        this.f58622b = null;
        this.f58623c = null;
        this.f58624d = null;
    }

    private long b() {
        c<V> cVar = this.f58623c;
        if (cVar.f58625e == 0) {
            return this.f58621a;
        }
        return cVar.b() + this.f58621a;
    }

    private static <V> c<V> e(long j4, V v3, c<V> cVar, c<V> cVar2) {
        int i4 = ((c) cVar).f58625e;
        int i5 = ((c) cVar2).f58625e;
        if (i4 + i5 > 1) {
            if (i4 >= i5 * 5) {
                c<V> cVar3 = ((c) cVar).f58623c;
                c<V> cVar4 = ((c) cVar).f58624d;
                if (((c) cVar4).f58625e < ((c) cVar3).f58625e * 2) {
                    long j5 = ((c) cVar).f58621a;
                    return new c<>(j5 + j4, ((c) cVar).f58622b, cVar3, new c(-j5, v3, cVar4.g(((c) cVar4).f58621a + j5), cVar2));
                }
                c<V> cVar5 = ((c) cVar4).f58623c;
                c<V> cVar6 = ((c) cVar4).f58624d;
                long j6 = ((c) cVar4).f58621a;
                long j7 = ((c) cVar).f58621a + j6 + j4;
                V v4 = ((c) cVar4).f58622b;
                c cVar7 = new c(-j6, ((c) cVar).f58622b, cVar3, cVar5.g(((c) cVar5).f58621a + j6));
                long j8 = ((c) cVar).f58621a;
                long j9 = ((c) cVar4).f58621a;
                return new c<>(j7, v4, cVar7, new c((-j8) - j9, v3, cVar6.g(((c) cVar6).f58621a + j9 + j8), cVar2));
            } else if (i5 >= i4 * 5) {
                c<V> cVar8 = ((c) cVar2).f58623c;
                c<V> cVar9 = ((c) cVar2).f58624d;
                if (((c) cVar8).f58625e < ((c) cVar9).f58625e * 2) {
                    long j10 = ((c) cVar2).f58621a;
                    return new c<>(j10 + j4, ((c) cVar2).f58622b, new c(-j10, v3, cVar, cVar8.g(((c) cVar8).f58621a + j10)), cVar9);
                }
                c<V> cVar10 = ((c) cVar8).f58623c;
                c<V> cVar11 = ((c) cVar8).f58624d;
                long j11 = ((c) cVar8).f58621a;
                long j12 = ((c) cVar2).f58621a;
                long j13 = j11 + j12 + j4;
                V v5 = ((c) cVar8).f58622b;
                c cVar12 = new c((-j12) - j11, v3, cVar, cVar10.g(((c) cVar10).f58621a + j11 + j12));
                long j14 = ((c) cVar8).f58621a;
                return new c<>(j13, v5, cVar12, new c(-j14, ((c) cVar2).f58622b, cVar11.g(((c) cVar11).f58621a + j14), cVar9));
            }
        }
        return new c<>(j4, v3, cVar, cVar2);
    }

    private c<V> f(c<V> cVar, c<V> cVar2) {
        return (cVar == this.f58623c && cVar2 == this.f58624d) ? this : e(this.f58621a, this.f58622b, cVar, cVar2);
    }

    private c<V> g(long j4) {
        return (this.f58625e == 0 || j4 == this.f58621a) ? this : new c<>(j4, this.f58622b, this.f58623c, this.f58624d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V a(long j4) {
        if (this.f58625e == 0) {
            return null;
        }
        long j5 = this.f58621a;
        if (j4 < j5) {
            return this.f58623c.a(j4 - j5);
        }
        if (j4 > j5) {
            return this.f58624d.a(j4 - j5);
        }
        return this.f58622b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<V> c(long j4) {
        if (this.f58625e == 0) {
            return this;
        }
        long j5 = this.f58621a;
        if (j4 < j5) {
            return f(this.f58623c.c(j4 - j5), this.f58624d);
        }
        if (j4 > j5) {
            return f(this.f58623c, this.f58624d.c(j4 - j5));
        }
        c<V> cVar = this.f58623c;
        if (cVar.f58625e == 0) {
            c<V> cVar2 = this.f58624d;
            return cVar2.g(cVar2.f58621a + j5);
        }
        c<V> cVar3 = this.f58624d;
        if (cVar3.f58625e == 0) {
            return cVar.g(cVar.f58621a + j5);
        }
        long b4 = cVar3.b();
        long j6 = this.f58621a;
        long j7 = b4 + j6;
        V a4 = this.f58624d.a(j7 - j6);
        c<V> c4 = this.f58624d.c(j7 - this.f58621a);
        c<V> g4 = c4.g((c4.f58621a + this.f58621a) - j7);
        c<V> cVar4 = this.f58623c;
        return e(j7, a4, cVar4.g((cVar4.f58621a + this.f58621a) - j7), g4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<V> d(long j4, V v3) {
        if (this.f58625e == 0) {
            return new c<>(j4, v3, this, this);
        }
        long j5 = this.f58621a;
        if (j4 < j5) {
            return f(this.f58623c.d(j4 - j5, v3), this.f58624d);
        }
        if (j4 > j5) {
            return f(this.f58623c, this.f58624d.d(j4 - j5, v3));
        }
        return v3 == this.f58622b ? this : new c<>(j4, v3, this.f58623c, this.f58624d);
    }

    private c(long j4, V v3, c<V> cVar, c<V> cVar2) {
        this.f58621a = j4;
        this.f58622b = v3;
        this.f58623c = cVar;
        this.f58624d = cVar2;
        this.f58625e = cVar.f58625e + 1 + cVar2.f58625e;
    }
}
