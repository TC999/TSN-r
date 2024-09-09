package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeRefCount.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.observables.c<? extends T> f63681a;

    /* renamed from: b  reason: collision with root package name */
    volatile rx.subscriptions.b f63682b = new rx.subscriptions.b();

    /* renamed from: c  reason: collision with root package name */
    final AtomicInteger f63683c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    final ReentrantLock f63684d = new ReentrantLock();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeRefCount.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.functions.b<rx.m> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f63685a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f63686b;

        a(rx.l lVar, AtomicBoolean atomicBoolean) {
            this.f63685a = lVar;
            this.f63686b = atomicBoolean;
        }

        @Override // rx.functions.b
        public void call(rx.m mVar) {
            try {
                z0.this.f63682b.a(mVar);
                z0 z0Var = z0.this;
                z0Var.c(this.f63685a, z0Var.f63682b);
            } finally {
                z0.this.f63684d.unlock();
                this.f63686b.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeRefCount.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f63688a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f63689b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.l lVar, rx.l lVar2, rx.subscriptions.b bVar) {
            super(lVar);
            this.f63688a = lVar2;
            this.f63689b = bVar;
        }

        void g() {
            z0.this.f63684d.lock();
            try {
                if (z0.this.f63682b == this.f63689b) {
                    if (z0.this.f63681a instanceof rx.m) {
                        ((rx.m) z0.this.f63681a).unsubscribe();
                    }
                    z0.this.f63682b.unsubscribe();
                    z0.this.f63682b = new rx.subscriptions.b();
                    z0.this.f63683c.set(0);
                }
            } finally {
                z0.this.f63684d.unlock();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            g();
            this.f63688a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            g();
            this.f63688a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f63688a.onNext(t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeRefCount.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class c implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f63691a;

        c(rx.subscriptions.b bVar) {
            this.f63691a = bVar;
        }

        @Override // rx.functions.a
        public void call() {
            z0.this.f63684d.lock();
            try {
                if (z0.this.f63682b == this.f63691a && z0.this.f63683c.decrementAndGet() == 0) {
                    if (z0.this.f63681a instanceof rx.m) {
                        ((rx.m) z0.this.f63681a).unsubscribe();
                    }
                    z0.this.f63682b.unsubscribe();
                    z0.this.f63682b = new rx.subscriptions.b();
                }
            } finally {
                z0.this.f63684d.unlock();
            }
        }
    }

    public z0(rx.observables.c<? extends T> cVar) {
        this.f63681a = cVar;
    }

    private rx.m b(rx.subscriptions.b bVar) {
        return rx.subscriptions.f.a(new c(bVar));
    }

    private rx.functions.b<rx.m> d(rx.l<? super T> lVar, AtomicBoolean atomicBoolean) {
        return new a(lVar, atomicBoolean);
    }

    void c(rx.l<? super T> lVar, rx.subscriptions.b bVar) {
        lVar.add(b(bVar));
        this.f63681a.I6(new b(lVar, lVar, bVar));
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        boolean z3;
        this.f63684d.lock();
        if (this.f63683c.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f63681a.z7(d(lVar, atomicBoolean));
                if (z3) {
                    return;
                }
                return;
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
        try {
            c(lVar, this.f63682b);
        } finally {
            this.f63684d.unlock();
        }
    }
}
