package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableOnSubscribeMergeDelayErrorArray.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p implements b.j0 {

    /* renamed from: a  reason: collision with root package name */
    final rx.b[] f63083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableOnSubscribeMergeDelayErrorArray.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f63084a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Queue f63085b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f63086c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ rx.d f63087d;

        a(rx.subscriptions.b bVar, Queue queue, AtomicInteger atomicInteger, rx.d dVar) {
            this.f63084a = bVar;
            this.f63085b = queue;
            this.f63086c = atomicInteger;
            this.f63087d = dVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f63084a.a(mVar);
        }

        void b() {
            if (this.f63086c.decrementAndGet() == 0) {
                if (this.f63085b.isEmpty()) {
                    this.f63087d.onCompleted();
                } else {
                    this.f63087d.onError(n.a(this.f63085b));
                }
            }
        }

        @Override // rx.d
        public void onCompleted() {
            b();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f63085b.offer(th);
            b();
        }
    }

    public p(rx.b[] bVarArr) {
        this.f63083a = bVarArr;
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        rx.b[] bVarArr;
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        AtomicInteger atomicInteger = new AtomicInteger(this.f63083a.length + 1);
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        dVar.a(bVar);
        for (rx.b bVar2 : this.f63083a) {
            if (bVar.isUnsubscribed()) {
                return;
            }
            if (bVar2 == null) {
                concurrentLinkedQueue.offer(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                bVar2.G0(new a(bVar, concurrentLinkedQueue, atomicInteger, dVar));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            if (concurrentLinkedQueue.isEmpty()) {
                dVar.onCompleted();
            } else {
                dVar.onError(n.a(concurrentLinkedQueue));
            }
        }
    }
}
