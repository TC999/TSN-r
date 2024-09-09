package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.b;
import rx.exceptions.CompositeException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableOnSubscribeMerge.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n implements b.j0 {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<rx.b> f62979a;

    /* renamed from: b  reason: collision with root package name */
    final int f62980b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f62981c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableOnSubscribeMerge.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends rx.l<rx.b> {

        /* renamed from: a  reason: collision with root package name */
        final rx.d f62982a;

        /* renamed from: c  reason: collision with root package name */
        final boolean f62984c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f62985d;

        /* renamed from: b  reason: collision with root package name */
        final rx.subscriptions.b f62983b = new rx.subscriptions.b();

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f62988g = new AtomicInteger(1);

        /* renamed from: f  reason: collision with root package name */
        final AtomicBoolean f62987f = new AtomicBoolean();

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<Queue<Throwable>> f62986e = new AtomicReference<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CompletableOnSubscribeMerge.java */
        /* renamed from: rx.internal.operators.n$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1287a implements rx.d {

            /* renamed from: a  reason: collision with root package name */
            rx.m f62989a;

            /* renamed from: b  reason: collision with root package name */
            boolean f62990b;

            C1287a() {
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f62989a = mVar;
                a.this.f62983b.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                if (this.f62990b) {
                    return;
                }
                this.f62990b = true;
                a.this.f62983b.g(this.f62989a);
                a.this.J();
                if (a.this.f62985d) {
                    return;
                }
                a.this.request(1L);
            }

            @Override // rx.d
            public void onError(Throwable th) {
                if (this.f62990b) {
                    rx.plugins.c.I(th);
                    return;
                }
                this.f62990b = true;
                a.this.f62983b.g(this.f62989a);
                a.this.x().offer(th);
                a.this.J();
                a aVar = a.this;
                if (!aVar.f62984c || aVar.f62985d) {
                    return;
                }
                a.this.request(1L);
            }
        }

        public a(rx.d dVar, int i4, boolean z3) {
            this.f62982a = dVar;
            this.f62984c = z3;
            if (i4 == Integer.MAX_VALUE) {
                request(Long.MAX_VALUE);
            } else {
                request(i4);
            }
        }

        @Override // rx.f
        /* renamed from: I */
        public void onNext(rx.b bVar) {
            if (this.f62985d) {
                return;
            }
            this.f62988g.getAndIncrement();
            bVar.G0(new C1287a());
        }

        void J() {
            Queue<Throwable> queue;
            if (this.f62988g.decrementAndGet() == 0) {
                Queue<Throwable> queue2 = this.f62986e.get();
                if (queue2 != null && !queue2.isEmpty()) {
                    Throwable a4 = n.a(queue2);
                    if (this.f62987f.compareAndSet(false, true)) {
                        this.f62982a.onError(a4);
                        return;
                    } else {
                        rx.plugins.c.I(a4);
                        return;
                    }
                }
                this.f62982a.onCompleted();
            } else if (this.f62984c || (queue = this.f62986e.get()) == null || queue.isEmpty()) {
            } else {
                Throwable a5 = n.a(queue);
                if (this.f62987f.compareAndSet(false, true)) {
                    this.f62982a.onError(a5);
                } else {
                    rx.plugins.c.I(a5);
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62985d) {
                return;
            }
            this.f62985d = true;
            J();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62985d) {
                rx.plugins.c.I(th);
                return;
            }
            x().offer(th);
            this.f62985d = true;
            J();
        }

        Queue<Throwable> x() {
            Queue<Throwable> queue = this.f62986e.get();
            if (queue != null) {
                return queue;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            return this.f62986e.compareAndSet(null, concurrentLinkedQueue) ? concurrentLinkedQueue : this.f62986e.get();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(rx.e<? extends rx.b> eVar, int i4, boolean z3) {
        this.f62979a = eVar;
        this.f62980b = i4;
        this.f62981c = z3;
    }

    public static Throwable a(Queue<Throwable> queue) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Throwable poll = queue.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (Throwable) arrayList.get(0);
        }
        return new CompositeException(arrayList);
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        a aVar = new a(dVar, this.f62980b, this.f62981c);
        dVar.a(aVar);
        this.f62979a.I6(aVar);
    }
}
