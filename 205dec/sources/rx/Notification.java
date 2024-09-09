package rx;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Notification<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final Notification<Void> f62050d = new Notification<>(Kind.OnCompleted, null, null);

    /* renamed from: a  reason: collision with root package name */
    private final Kind f62051a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f62052b;

    /* renamed from: c  reason: collision with root package name */
    private final T f62053c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    private Notification(Kind kind, T t3, Throwable th) {
        this.f62053c = t3;
        this.f62052b = th;
        this.f62051a = kind;
    }

    public static <T> Notification<T> b() {
        return (Notification<T>) f62050d;
    }

    @Deprecated
    public static <T> Notification<T> c(Class<T> cls) {
        return (Notification<T>) f62050d;
    }

    public static <T> Notification<T> d(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> e(T t3) {
        return new Notification<>(Kind.OnNext, t3, null);
    }

    public void a(f<? super T> fVar) {
        Kind kind = this.f62051a;
        if (kind == Kind.OnNext) {
            fVar.onNext(h());
        } else if (kind == Kind.OnCompleted) {
            fVar.onCompleted();
        } else {
            fVar.onError(g());
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.f() == f()) {
            T t3 = this.f62053c;
            T t4 = notification.f62053c;
            if (t3 == t4 || (t3 != null && t3.equals(t4))) {
                Throwable th = this.f62052b;
                Throwable th2 = notification.f62052b;
                return th == th2 || (th != null && th.equals(th2));
            }
            return false;
        }
        return false;
    }

    public Kind f() {
        return this.f62051a;
    }

    public Throwable g() {
        return this.f62052b;
    }

    public T h() {
        return this.f62053c;
    }

    public int hashCode() {
        int hashCode = f().hashCode();
        if (j()) {
            hashCode = (hashCode * 31) + h().hashCode();
        }
        return i() ? (hashCode * 31) + g().hashCode() : hashCode;
    }

    public boolean i() {
        return l() && this.f62052b != null;
    }

    public boolean j() {
        return m() && this.f62053c != null;
    }

    public boolean k() {
        return f() == Kind.OnCompleted;
    }

    public boolean l() {
        return f() == Kind.OnError;
    }

    public boolean m() {
        return f() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(' ');
        sb.append(f());
        if (j()) {
            sb.append(' ');
            sb.append(h());
        }
        if (i()) {
            sb.append(' ');
            sb.append(g().getMessage());
        }
        sb.append(']');
        return sb.toString();
    }
}
