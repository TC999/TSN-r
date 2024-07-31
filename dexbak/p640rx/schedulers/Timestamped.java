package p640rx.schedulers;

/* renamed from: rx.schedulers.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Timestamped<T> {

    /* renamed from: a */
    private final long f46987a;

    /* renamed from: b */
    private final T f46988b;

    public Timestamped(long j, T t) {
        this.f46988b = t;
        this.f46987a = j;
    }

    /* renamed from: a */
    public long m452a() {
        return this.f46987a;
    }

    /* renamed from: b */
    public T m451b() {
        return this.f46988b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Timestamped)) {
            Timestamped timestamped = (Timestamped) obj;
            if (this.f46987a == timestamped.f46987a) {
                T t = this.f46988b;
                T t2 = timestamped.f46988b;
                if (t == t2) {
                    return true;
                }
                if (t != null && t.equals(t2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f46987a;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.f46988b;
        return i + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f46987a), this.f46988b.toString());
    }
}
