package rx.observers;

import java.util.concurrent.atomic.AtomicReference;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: AsyncCompletableSubscriber.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class b implements rx.d, m {

    /* renamed from: b  reason: collision with root package name */
    static final a f64162b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<m> f64163a = new AtomicReference<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncCompletableSubscriber.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a implements m {
        a() {
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.m
        public void unsubscribe() {
        }
    }

    @Override // rx.d
    public final void a(m mVar) {
        if (!this.f64163a.compareAndSet(null, mVar)) {
            mVar.unsubscribe();
            if (this.f64163a.get() != f64162b) {
                rx.plugins.c.I(new IllegalStateException("Subscription already set!"));
                return;
            }
            return;
        }
        onStart();
    }

    protected final void b() {
        this.f64163a.set(f64162b);
    }

    @Override // rx.m
    public final boolean isUnsubscribed() {
        return this.f64163a.get() == f64162b;
    }

    protected void onStart() {
    }

    @Override // rx.m
    public final void unsubscribe() {
        m andSet;
        m mVar = this.f64163a.get();
        a aVar = f64162b;
        if (mVar == aVar || (andSet = this.f64163a.getAndSet(aVar)) == null || andSet == aVar) {
            return;
        }
        andSet.unsubscribe();
    }
}
