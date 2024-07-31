package p640rx;

import io.netty.handler.codec.http.HttpConstants;

/* renamed from: rx.Notification */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Notification<T> {

    /* renamed from: d */
    private static final Notification<Void> f44619d = new Notification<>(Kind.OnCompleted, null, null);

    /* renamed from: a */
    private final Kind f44620a;

    /* renamed from: b */
    private final Throwable f44621b;

    /* renamed from: c */
    private final T f44622c;

    /* renamed from: rx.Notification$Kind */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.f44622c = t;
        this.f44621b = th;
        this.f44620a = kind;
    }

    /* renamed from: b */
    public static <T> Notification<T> m2005b() {
        return (Notification<T>) f44619d;
    }

    @Deprecated
    /* renamed from: c */
    public static <T> Notification<T> m2004c(Class<T> cls) {
        return (Notification<T>) f44619d;
    }

    /* renamed from: d */
    public static <T> Notification<T> m2003d(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    /* renamed from: e */
    public static <T> Notification<T> m2002e(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    /* renamed from: a */
    public void m2006a(Observer<? super T> observer) {
        Kind kind = this.f44620a;
        if (kind == Kind.OnNext) {
            observer.onNext(m1999h());
        } else if (kind == Kind.OnCompleted) {
            observer.onCompleted();
        } else {
            observer.onError(m2000g());
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
        if (notification.m2001f() == m2001f()) {
            T t = this.f44622c;
            T t2 = notification.f44622c;
            if (t == t2 || (t != null && t.equals(t2))) {
                Throwable th = this.f44621b;
                Throwable th2 = notification.f44621b;
                return th == th2 || (th != null && th.equals(th2));
            }
            return false;
        }
        return false;
    }

    /* renamed from: f */
    public Kind m2001f() {
        return this.f44620a;
    }

    /* renamed from: g */
    public Throwable m2000g() {
        return this.f44621b;
    }

    /* renamed from: h */
    public T m1999h() {
        return this.f44622c;
    }

    public int hashCode() {
        int hashCode = m2001f().hashCode();
        if (m1997j()) {
            hashCode = (hashCode * 31) + m1999h().hashCode();
        }
        return m1998i() ? (hashCode * 31) + m2000g().hashCode() : hashCode;
    }

    /* renamed from: i */
    public boolean m1998i() {
        return m1995l() && this.f44621b != null;
    }

    /* renamed from: j */
    public boolean m1997j() {
        return m1994m() && this.f44622c != null;
    }

    /* renamed from: k */
    public boolean m1996k() {
        return m2001f() == Kind.OnCompleted;
    }

    /* renamed from: l */
    public boolean m1995l() {
        return m2001f() == Kind.OnError;
    }

    /* renamed from: m */
    public boolean m1994m() {
        return m2001f() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(HttpConstants.SP_CHAR);
        sb.append(m2001f());
        if (m1997j()) {
            sb.append(HttpConstants.SP_CHAR);
            sb.append(m1999h());
        }
        if (m1998i()) {
            sb.append(HttpConstants.SP_CHAR);
            sb.append(m2000g().getMessage());
        }
        sb.append(']');
        return sb.toString();
    }
}
