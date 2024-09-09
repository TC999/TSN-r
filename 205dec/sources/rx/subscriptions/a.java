package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: BooleanSubscription.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class a implements m {

    /* renamed from: b  reason: collision with root package name */
    static final rx.functions.a f64351b = new C1328a();

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<rx.functions.a> f64352a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BooleanSubscription.java */
    /* renamed from: rx.subscriptions.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class C1328a implements rx.functions.a {
        C1328a() {
        }

        @Override // rx.functions.a
        public void call() {
        }
    }

    public a() {
        this.f64352a = new AtomicReference<>();
    }

    public static a a() {
        return new a();
    }

    public static a b(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f64352a.get() == f64351b;
    }

    @Override // rx.m
    public void unsubscribe() {
        rx.functions.a andSet;
        rx.functions.a aVar = this.f64352a.get();
        rx.functions.a aVar2 = f64351b;
        if (aVar == aVar2 || (andSet = this.f64352a.getAndSet(aVar2)) == null || andSet == aVar2) {
            return;
        }
        andSet.call();
    }

    private a(rx.functions.a aVar) {
        this.f64352a = new AtomicReference<>(aVar);
    }
}
