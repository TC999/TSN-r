package rx.schedulers;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: TimeInterval.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final long f64254a;

    /* renamed from: b  reason: collision with root package name */
    private final T f64255b;

    public e(long j4, T t3) {
        this.f64255b = t3;
        this.f64254a = j4;
    }

    public long a() {
        return this.f64254a;
    }

    public T b() {
        return this.f64255b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            e eVar = (e) obj;
            if (this.f64254a != eVar.f64254a) {
                return false;
            }
            T t3 = this.f64255b;
            if (t3 == null) {
                if (eVar.f64255b != null) {
                    return false;
                }
            } else if (!t3.equals(eVar.f64255b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f64254a;
        int i4 = (((int) (j4 ^ (j4 >>> 32))) + 31) * 31;
        T t3 = this.f64255b;
        return i4 + (t3 == null ? 0 : t3.hashCode());
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.f64254a + ", value=" + this.f64255b + "]";
    }
}
