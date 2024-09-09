package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: RefCountSubscription.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class d implements m {

    /* renamed from: c  reason: collision with root package name */
    static final b f64356c = new b(false, 0);

    /* renamed from: a  reason: collision with root package name */
    private final m f64357a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<b> f64358b = new AtomicReference<>(f64356c);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RefCountSubscription.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a extends AtomicInteger implements m {
        private static final long serialVersionUID = 7005765588239987643L;

        /* renamed from: a  reason: collision with root package name */
        final d f64359a;

        public a(d dVar) {
            this.f64359a = dVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get() != 0;
        }

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.f64359a.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RefCountSubscription.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final boolean f64360a;

        /* renamed from: b  reason: collision with root package name */
        final int f64361b;

        b(boolean z3, int i4) {
            this.f64360a = z3;
            this.f64361b = i4;
        }

        b a() {
            return new b(this.f64360a, this.f64361b + 1);
        }

        b b() {
            return new b(this.f64360a, this.f64361b - 1);
        }

        b c() {
            return new b(true, this.f64361b);
        }
    }

    public d(m mVar) {
        if (mVar != null) {
            this.f64357a = mVar;
            return;
        }
        throw new IllegalArgumentException("s");
    }

    private void d(b bVar) {
        if (bVar.f64360a && bVar.f64361b == 0) {
            this.f64357a.unsubscribe();
        }
    }

    public m a() {
        b bVar;
        AtomicReference<b> atomicReference = this.f64358b;
        do {
            bVar = atomicReference.get();
            if (bVar.f64360a) {
                return f.e();
            }
        } while (!atomicReference.compareAndSet(bVar, bVar.a()));
        return new a(this);
    }

    void b() {
        b bVar;
        b b4;
        AtomicReference<b> atomicReference = this.f64358b;
        do {
            bVar = atomicReference.get();
            b4 = bVar.b();
        } while (!atomicReference.compareAndSet(bVar, b4));
        d(b4);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f64358b.get().f64360a;
    }

    @Override // rx.m
    public void unsubscribe() {
        b bVar;
        b c4;
        AtomicReference<b> atomicReference = this.f64358b;
        do {
            bVar = atomicReference.get();
            if (bVar.f64360a) {
                return;
            }
            c4 = bVar.c();
        } while (!atomicReference.compareAndSet(bVar, c4));
        d(c4);
    }
}
