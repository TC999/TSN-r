package rx;

import rx.exceptions.MissingBackpressureException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BackpressureOverflow.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d f62054a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f62055b;

    /* renamed from: c  reason: collision with root package name */
    public static final d f62056c;

    /* renamed from: d  reason: collision with root package name */
    public static final d f62057d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BackpressureOverflow.java */
    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class C1258a implements d {

        /* renamed from: a  reason: collision with root package name */
        static final C1258a f62058a = new C1258a();

        private C1258a() {
        }

        @Override // rx.a.d
        public boolean a() {
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BackpressureOverflow.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        static final b f62059a = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean a() {
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BackpressureOverflow.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        static final c f62060a = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BackpressureOverflow.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface d {
        boolean a() throws MissingBackpressureException;
    }

    static {
        c cVar = c.f62060a;
        f62054a = cVar;
        f62055b = cVar;
        f62056c = b.f62059a;
        f62057d = C1258a.f62058a;
    }

    private a() {
        throw new IllegalStateException("No instances!");
    }
}
