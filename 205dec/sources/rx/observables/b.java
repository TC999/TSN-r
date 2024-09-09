package rx.observables;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.p;
import rx.internal.operators.v;
import rx.internal.util.n;
import rx.l;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: BlockingObservable.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class b<T> {

    /* renamed from: b  reason: collision with root package name */
    static final Object f64117b = new Object();

    /* renamed from: c  reason: collision with root package name */
    static final Object f64118c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final Object f64119d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final rx.e<? extends T> f64120a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BlockingObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class a extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f64121a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference f64122b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64123c;

        a(CountDownLatch countDownLatch, AtomicReference atomicReference, rx.functions.b bVar) {
            this.f64121a = countDownLatch;
            this.f64122b = atomicReference;
            this.f64123c = bVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f64121a.countDown();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64122b.set(th);
            this.f64121a.countDown();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f64123c.call(t3);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BlockingObservable.java */
    /* renamed from: rx.observables.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class C1320b implements Iterable<T> {
        C1320b() {
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return b.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BlockingObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class c extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f64126a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference f64127b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicReference f64128c;

        c(CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f64126a = countDownLatch;
            this.f64127b = atomicReference;
            this.f64128c = atomicReference2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f64126a.countDown();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64127b.set(th);
            this.f64126a.countDown();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f64128c.set(t3);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BlockingObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class d extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Throwable[] f64130a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f64131b;

        d(Throwable[] thArr, CountDownLatch countDownLatch) {
            this.f64130a = thArr;
            this.f64131b = countDownLatch;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f64131b.countDown();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64130a[0] = th;
            this.f64131b.countDown();
        }

        @Override // rx.f
        public void onNext(T t3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BlockingObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class e extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BlockingQueue f64133a;

        e(BlockingQueue blockingQueue) {
            this.f64133a = blockingQueue;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f64133a.offer(v.b());
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64133a.offer(v.c(th));
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f64133a.offer(v.j(t3));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BlockingObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class f extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BlockingQueue f64135a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.g[] f64136b;

        f(BlockingQueue blockingQueue, rx.g[] gVarArr) {
            this.f64135a = blockingQueue;
            this.f64136b = gVarArr;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f64135a.offer(v.b());
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64135a.offer(v.c(th));
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f64135a.offer(v.j(t3));
        }

        @Override // rx.l
        public void onStart() {
            this.f64135a.offer(b.f64117b);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f64136b[0] = gVar;
            this.f64135a.offer(b.f64118c);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BlockingObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class g implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BlockingQueue f64138a;

        g(BlockingQueue blockingQueue) {
            this.f64138a = blockingQueue;
        }

        @Override // rx.functions.a
        public void call() {
            this.f64138a.offer(b.f64119d);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BlockingObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class h implements rx.functions.b<Throwable> {
        h() {
        }

        @Override // rx.functions.b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BlockingObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class i implements rx.f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64141a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64142b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f64143c;

        i(rx.functions.b bVar, rx.functions.b bVar2, rx.functions.a aVar) {
            this.f64141a = bVar;
            this.f64142b = bVar2;
            this.f64143c = aVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f64143c.call();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64142b.call(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f64141a.call(t3);
        }
    }

    private b(rx.e<? extends T> eVar) {
        this.f64120a = eVar;
    }

    private T a(rx.e<? extends T> eVar) {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        rx.internal.util.d.a(countDownLatch, eVar.q5(new c(countDownLatch, atomicReference2, atomicReference)));
        if (atomicReference2.get() != null) {
            rx.exceptions.a.c((Throwable) atomicReference2.get());
        }
        return (T) atomicReference.get();
    }

    public static <T> b<T> g(rx.e<? extends T> eVar) {
        return new b<>(eVar);
    }

    public Iterable<T> A() {
        return new C1320b();
    }

    public T b() {
        return a(this.f64120a.X1());
    }

    public T c(p<? super T, Boolean> pVar) {
        return a(this.f64120a.Y1(pVar));
    }

    public T d(T t3) {
        return a(this.f64120a.b3(n.c()).Z1(t3));
    }

    public T e(T t3, p<? super T, Boolean> pVar) {
        return a(this.f64120a.V1(pVar).b3(n.c()).Z1(t3));
    }

    public void f(rx.functions.b<? super T> bVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        rx.internal.util.d.a(countDownLatch, this.f64120a.q5(new a(countDownLatch, atomicReference, bVar)));
        if (atomicReference.get() != null) {
            rx.exceptions.a.c((Throwable) atomicReference.get());
        }
    }

    public Iterator<T> h() {
        return rx.internal.operators.f.a(this.f64120a);
    }

    public T i() {
        return a(this.f64120a.V2());
    }

    public T j(p<? super T, Boolean> pVar) {
        return a(this.f64120a.W2(pVar));
    }

    public T k(T t3) {
        return a(this.f64120a.b3(n.c()).X2(t3));
    }

    public T l(T t3, p<? super T, Boolean> pVar) {
        return a(this.f64120a.V1(pVar).b3(n.c()).X2(t3));
    }

    public Iterable<T> m() {
        return rx.internal.operators.b.a(this.f64120a);
    }

    public Iterable<T> n(T t3) {
        return rx.internal.operators.c.a(this.f64120a, t3);
    }

    public Iterable<T> o() {
        return rx.internal.operators.d.a(this.f64120a);
    }

    public T p() {
        return a(this.f64120a.P4());
    }

    public T q(p<? super T, Boolean> pVar) {
        return a(this.f64120a.Q4(pVar));
    }

    public T r(T t3) {
        return a(this.f64120a.b3(n.c()).R4(t3));
    }

    public T s(T t3, p<? super T, Boolean> pVar) {
        return a(this.f64120a.V1(pVar).b3(n.c()).R4(t3));
    }

    public void t() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = {null};
        rx.internal.util.d.a(countDownLatch, this.f64120a.q5(new d(thArr, countDownLatch)));
        Throwable th = thArr[0];
        if (th != null) {
            rx.exceptions.a.c(th);
        }
    }

    public void u(rx.f<? super T> fVar) {
        Object poll;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        m q5 = this.f64120a.q5(new e(linkedBlockingQueue));
        do {
            try {
                poll = linkedBlockingQueue.poll();
                if (poll == null) {
                    poll = linkedBlockingQueue.take();
                }
            } catch (InterruptedException e4) {
                Thread.currentThread().interrupt();
                fVar.onError(e4);
                return;
            } finally {
                q5.unsubscribe();
            }
        } while (!v.a(fVar, poll));
    }

    public void v(l<? super T> lVar) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        rx.g[] gVarArr = {null};
        f fVar = new f(linkedBlockingQueue, gVarArr);
        lVar.add(fVar);
        lVar.add(rx.subscriptions.f.a(new g(linkedBlockingQueue)));
        this.f64120a.q5(fVar);
        while (!lVar.isUnsubscribed()) {
            try {
                try {
                    Object poll = linkedBlockingQueue.poll();
                    if (poll == null) {
                        poll = linkedBlockingQueue.take();
                    }
                    if (lVar.isUnsubscribed() || poll == f64119d) {
                        break;
                    } else if (poll == f64117b) {
                        lVar.onStart();
                    } else if (poll == f64118c) {
                        lVar.setProducer(gVarArr[0]);
                    } else if (v.a(lVar, poll)) {
                        return;
                    }
                } catch (InterruptedException e4) {
                    Thread.currentThread().interrupt();
                    lVar.onError(e4);
                }
            } finally {
                fVar.unsubscribe();
            }
        }
    }

    public void w(rx.functions.b<? super T> bVar) {
        y(bVar, new h(), rx.functions.m.a());
    }

    public void x(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2) {
        y(bVar, bVar2, rx.functions.m.a());
    }

    public void y(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        u(new i(bVar, bVar2, aVar));
    }

    public Future<T> z() {
        return rx.internal.operators.e.a(this.f64120a);
    }
}
