package p640rx.internal.operators;

import java.io.Serializable;
import p640rx.Observer;

/* renamed from: rx.internal.operators.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class NotificationLite {

    /* renamed from: a */
    private static final Object f46009a = new C15917a();

    /* renamed from: b */
    private static final Object f46010b = new C15918b();

    /* compiled from: NotificationLite.java */
    /* renamed from: rx.internal.operators.v$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15917a implements Serializable {
        private static final long serialVersionUID = 1;

        C15917a() {
        }

        public String toString() {
            return "Notification=>Completed";
        }
    }

    /* compiled from: NotificationLite.java */
    /* renamed from: rx.internal.operators.v$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15918b implements Serializable {
        private static final long serialVersionUID = 2;

        C15918b() {
        }

        public String toString() {
            return "Notification=>NULL";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NotificationLite.java */
    /* renamed from: rx.internal.operators.v$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15919c implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: a */
        final Throwable f46011a;

        public C15919c(Throwable th) {
            this.f46011a = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.f46011a;
        }
    }

    private NotificationLite() {
    }

    /* renamed from: a */
    public static <T> boolean m1052a(Observer<? super T> observer, Object obj) {
        if (obj == f46009a) {
            observer.onCompleted();
            return true;
        } else if (obj == f46010b) {
            observer.onNext(null);
            return false;
        } else if (obj != null) {
            if (obj.getClass() == C15919c.class) {
                observer.onError(((C15919c) obj).f46011a);
                return true;
            }
            observer.onNext(obj);
            return false;
        } else {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
    }

    /* renamed from: b */
    public static Object m1051b() {
        return f46009a;
    }

    /* renamed from: c */
    public static Object m1050c(Throwable th) {
        return new C15919c(th);
    }

    /* renamed from: d */
    public static Throwable m1049d(Object obj) {
        return ((C15919c) obj).f46011a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public static <T> T m1048e(Object obj) {
        if (obj == f46010b) {
            return null;
        }
        return obj;
    }

    /* renamed from: f */
    public static boolean m1047f(Object obj) {
        return obj == f46009a;
    }

    /* renamed from: g */
    public static boolean m1046g(Object obj) {
        return obj instanceof C15919c;
    }

    /* renamed from: h */
    public static boolean m1045h(Object obj) {
        return (obj == null || m1046g(obj) || m1047f(obj)) ? false : true;
    }

    /* renamed from: i */
    public static boolean m1044i(Object obj) {
        return obj == f46010b;
    }

    /* renamed from: j */
    public static <T> Object m1043j(T t) {
        return t == null ? f46010b : t;
    }
}
