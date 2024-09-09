package rx.internal.operators;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: NotificationLite.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f63440a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f63441b = new b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: NotificationLite.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements Serializable {
        private static final long serialVersionUID = 1;

        a() {
        }

        public String toString() {
            return "Notification=>Completed";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: NotificationLite.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class b implements Serializable {
        private static final long serialVersionUID = 2;

        b() {
        }

        public String toString() {
            return "Notification=>NULL";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: NotificationLite.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: a  reason: collision with root package name */
        final Throwable f63442a;

        public c(Throwable th) {
            this.f63442a = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.f63442a;
        }
    }

    private v() {
    }

    public static <T> boolean a(rx.f<? super T> fVar, Object obj) {
        if (obj == f63440a) {
            fVar.onCompleted();
            return true;
        } else if (obj == f63441b) {
            fVar.onNext(null);
            return false;
        } else if (obj != null) {
            if (obj.getClass() == c.class) {
                fVar.onError(((c) obj).f63442a);
                return true;
            }
            fVar.onNext(obj);
            return false;
        } else {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
    }

    public static Object b() {
        return f63440a;
    }

    public static Object c(Throwable th) {
        return new c(th);
    }

    public static Throwable d(Object obj) {
        return ((c) obj).f63442a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T e(Object obj) {
        if (obj == f63441b) {
            return null;
        }
        return obj;
    }

    public static boolean f(Object obj) {
        return obj == f63440a;
    }

    public static boolean g(Object obj) {
        return obj instanceof c;
    }

    public static boolean h(Object obj) {
        return (obj == null || g(obj) || f(obj)) ? false : true;
    }

    public static boolean i(Object obj) {
        return obj == f63441b;
    }

    public static <T> Object j(T t3) {
        return t3 == null ? f63441b : t3;
    }
}
