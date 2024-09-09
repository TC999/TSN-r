package rx.schedulers;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: Timestamped.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private final long f64256a;

    /* renamed from: b  reason: collision with root package name */
    private final T f64257b;

    public f(long j4, T t3) {
        this.f64257b = t3;
        this.f64256a = j4;
    }

    public long a() {
        return this.f64256a;
    }

    public T b() {
        return this.f64257b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof f)) {
            f fVar = (f) obj;
            if (this.f64256a == fVar.f64256a) {
                T t3 = this.f64257b;
                T t4 = fVar.f64257b;
                if (t3 == t4) {
                    return true;
                }
                if (t3 != null && t3.equals(t4)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f64256a;
        int i4 = (((int) (j4 ^ (j4 >>> 32))) + 31) * 31;
        T t3 = this.f64257b;
        return i4 + (t3 == null ? 0 : t3.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f64256a), this.f64257b.toString());
    }
}
