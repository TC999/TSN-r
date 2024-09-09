package rx.subscriptions;

import java.util.concurrent.Future;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: Subscriptions.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final b f64363a = new b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Subscriptions.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        final Future<?> f64364a;

        public a(Future<?> future) {
            this.f64364a = future;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f64364a.isCancelled();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f64364a.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Subscriptions.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b implements m {
        b() {
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.m
        public void unsubscribe() {
        }
    }

    private f() {
        throw new IllegalStateException("No instances!");
    }

    public static m a(rx.functions.a aVar) {
        return rx.subscriptions.a.b(aVar);
    }

    public static m b() {
        return rx.subscriptions.a.a();
    }

    public static m c(Future<?> future) {
        return new a(future);
    }

    public static rx.subscriptions.b d(m... mVarArr) {
        return new rx.subscriptions.b(mVarArr);
    }

    public static m e() {
        return f64363a;
    }
}
