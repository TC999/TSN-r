package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableOnSubscribeMergeDelayErrorIterable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q implements b.j0 {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<? extends rx.b> f63150a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableOnSubscribeMergeDelayErrorIterable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f63151a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Queue f63152b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f63153c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ rx.d f63154d;

        a(rx.subscriptions.b bVar, Queue queue, AtomicInteger atomicInteger, rx.d dVar) {
            this.f63151a = bVar;
            this.f63152b = queue;
            this.f63153c = atomicInteger;
            this.f63154d = dVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f63151a.a(mVar);
        }

        void b() {
            if (this.f63153c.decrementAndGet() == 0) {
                if (this.f63152b.isEmpty()) {
                    this.f63154d.onCompleted();
                } else {
                    this.f63154d.onError(n.a(this.f63152b));
                }
            }
        }

        @Override // rx.d
        public void onCompleted() {
            b();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f63152b.offer(th);
            b();
        }
    }

    public q(Iterable<? extends rx.b> iterable) {
        this.f63150a = iterable;
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        Queue cVar;
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        dVar.a(bVar);
        try {
            Iterator<? extends rx.b> it = this.f63150a.iterator();
            if (it == null) {
                dVar.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(1);
            if (rx.internal.util.unsafe.n0.f()) {
                cVar = new rx.internal.util.unsafe.o();
            } else {
                cVar = new rx.internal.util.atomic.c();
            }
            Queue queue = cVar;
            while (!bVar.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            if (queue.isEmpty()) {
                                dVar.onCompleted();
                                return;
                            } else {
                                dVar.onError(n.a(queue));
                                return;
                            }
                        }
                        return;
                    } else if (bVar.isUnsubscribed()) {
                        return;
                    } else {
                        try {
                            rx.b next = it.next();
                            if (bVar.isUnsubscribed()) {
                                return;
                            }
                            if (next == null) {
                                queue.offer(new NullPointerException("A completable source is null"));
                                if (atomicInteger.decrementAndGet() == 0) {
                                    if (queue.isEmpty()) {
                                        dVar.onCompleted();
                                        return;
                                    } else {
                                        dVar.onError(n.a(queue));
                                        return;
                                    }
                                }
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            next.G0(new a(bVar, queue, atomicInteger, dVar));
                        } catch (Throwable th) {
                            queue.offer(th);
                            if (atomicInteger.decrementAndGet() == 0) {
                                if (queue.isEmpty()) {
                                    dVar.onCompleted();
                                    return;
                                } else {
                                    dVar.onError(n.a(queue));
                                    return;
                                }
                            }
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    queue.offer(th2);
                    if (atomicInteger.decrementAndGet() == 0) {
                        if (queue.isEmpty()) {
                            dVar.onCompleted();
                            return;
                        } else {
                            dVar.onError(n.a(queue));
                            return;
                        }
                    }
                    return;
                }
            }
        } catch (Throwable th3) {
            dVar.onError(th3);
        }
    }
}
