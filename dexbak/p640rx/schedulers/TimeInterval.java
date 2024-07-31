package p640rx.schedulers;

/* renamed from: rx.schedulers.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class TimeInterval<T> {

    /* renamed from: a */
    private final long f46985a;

    /* renamed from: b */
    private final T f46986b;

    public TimeInterval(long j, T t) {
        this.f46986b = t;
        this.f46985a = j;
    }

    /* renamed from: a */
    public long m454a() {
        return this.f46985a;
    }

    /* renamed from: b */
    public T m453b() {
        return this.f46986b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TimeInterval timeInterval = (TimeInterval) obj;
            if (this.f46985a != timeInterval.f46985a) {
                return false;
            }
            T t = this.f46986b;
            if (t == null) {
                if (timeInterval.f46986b != null) {
                    return false;
                }
            } else if (!t.equals(timeInterval.f46986b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f46985a;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.f46986b;
        return i + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.f46985a + ", value=" + this.f46986b + "]";
    }
}
