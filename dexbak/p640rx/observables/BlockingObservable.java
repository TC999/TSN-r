package p640rx.observables;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.OnErrorNotImplementedException;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Actions;
import p640rx.functions.Func1;
import p640rx.internal.operators.BlockingOperatorLatest;
import p640rx.internal.operators.BlockingOperatorMostRecent;
import p640rx.internal.operators.BlockingOperatorNext;
import p640rx.internal.operators.BlockingOperatorToFuture;
import p640rx.internal.operators.BlockingOperatorToIterator;
import p640rx.internal.operators.NotificationLite;
import p640rx.internal.util.BlockingUtils;
import p640rx.internal.util.UtilityFunctions;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.observables.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BlockingObservable<T> {

    /* renamed from: b */
    static final Object f46848b = new Object();

    /* renamed from: c */
    static final Object f46849c = new Object();

    /* renamed from: d */
    static final Object f46850d = new Object();

    /* renamed from: a */
    private final Observable<? extends T> f46851a;

    /* compiled from: BlockingObservable.java */
    /* renamed from: rx.observables.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16106a extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ CountDownLatch f46852a;

        /* renamed from: b */
        final /* synthetic */ AtomicReference f46853b;

        /* renamed from: c */
        final /* synthetic */ Action1 f46854c;

        C16106a(CountDownLatch countDownLatch, AtomicReference atomicReference, Action1 action1) {
            this.f46852a = countDownLatch;
            this.f46853b = atomicReference;
            this.f46854c = action1;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46852a.countDown();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46853b.set(th);
            this.f46852a.countDown();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46854c.call(t);
        }
    }

    /* compiled from: BlockingObservable.java */
    /* renamed from: rx.observables.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16107b implements Iterable<T> {
        C16107b() {
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return BlockingObservable.this.m716h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlockingObservable.java */
    /* renamed from: rx.observables.b$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16108c extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ CountDownLatch f46857a;

        /* renamed from: b */
        final /* synthetic */ AtomicReference f46858b;

        /* renamed from: c */
        final /* synthetic */ AtomicReference f46859c;

        C16108c(CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f46857a = countDownLatch;
            this.f46858b = atomicReference;
            this.f46859c = atomicReference2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46857a.countDown();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46858b.set(th);
            this.f46857a.countDown();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46859c.set(t);
        }
    }

    /* compiled from: BlockingObservable.java */
    /* renamed from: rx.observables.b$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16109d extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Throwable[] f46861a;

        /* renamed from: b */
        final /* synthetic */ CountDownLatch f46862b;

        C16109d(Throwable[] thArr, CountDownLatch countDownLatch) {
            this.f46861a = thArr;
            this.f46862b = countDownLatch;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46862b.countDown();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46861a[0] = th;
            this.f46862b.countDown();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlockingObservable.java */
    /* renamed from: rx.observables.b$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16110e extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ BlockingQueue f46864a;

        C16110e(BlockingQueue blockingQueue) {
            this.f46864a = blockingQueue;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46864a.offer(NotificationLite.m1051b());
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46864a.offer(NotificationLite.m1050c(th));
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46864a.offer(NotificationLite.m1043j(t));
        }
    }

    /* compiled from: BlockingObservable.java */
    /* renamed from: rx.observables.b$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16111f extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ BlockingQueue f46866a;

        /* renamed from: b */
        final /* synthetic */ Producer[] f46867b;

        C16111f(BlockingQueue blockingQueue, Producer[] producerArr) {
            this.f46866a = blockingQueue;
            this.f46867b = producerArr;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46866a.offer(NotificationLite.m1051b());
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46866a.offer(NotificationLite.m1050c(th));
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46866a.offer(NotificationLite.m1043j(t));
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            this.f46866a.offer(BlockingObservable.f46848b);
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f46867b[0] = producer;
            this.f46866a.offer(BlockingObservable.f46849c);
        }
    }

    /* compiled from: BlockingObservable.java */
    /* renamed from: rx.observables.b$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16112g implements Action0 {

        /* renamed from: a */
        final /* synthetic */ BlockingQueue f46869a;

        C16112g(BlockingQueue blockingQueue) {
            this.f46869a = blockingQueue;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            this.f46869a.offer(BlockingObservable.f46850d);
        }
    }

    /* compiled from: BlockingObservable.java */
    /* renamed from: rx.observables.b$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16113h implements Action1<Throwable> {
        C16113h() {
        }

        @Override // p640rx.functions.Action1
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlockingObservable.java */
    /* renamed from: rx.observables.b$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16114i implements Observer<T> {

        /* renamed from: a */
        final /* synthetic */ Action1 f46872a;

        /* renamed from: b */
        final /* synthetic */ Action1 f46873b;

        /* renamed from: c */
        final /* synthetic */ Action0 f46874c;

        C16114i(Action1 action1, Action1 action12, Action0 action0) {
            this.f46872a = action1;
            this.f46873b = action12;
            this.f46874c = action0;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46874c.call();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46873b.call(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46872a.call(t);
        }
    }

    private BlockingObservable(Observable<? extends T> observable) {
        this.f46851a = observable;
    }

    /* renamed from: a */
    private T m723a(Observable<? extends T> observable) {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        BlockingUtils.m872a(countDownLatch, observable.m1551q5(new C16108c(countDownLatch, atomicReference2, atomicReference)));
        if (atomicReference2.get() != null) {
            C15575a.m1476c((Throwable) atomicReference2.get());
        }
        return (T) atomicReference.get();
    }

    /* renamed from: g */
    public static <T> BlockingObservable<T> m717g(Observable<? extends T> observable) {
        return new BlockingObservable<>(observable);
    }

    /* renamed from: A */
    public Iterable<T> m724A() {
        return new C16107b();
    }

    /* renamed from: b */
    public T m722b() {
        return m723a(this.f46851a.m1707X1());
    }

    /* renamed from: c */
    public T m721c(Func1<? super T, Boolean> func1) {
        return m723a(this.f46851a.m1699Y1(func1));
    }

    /* renamed from: d */
    public T m720d(T t) {
        return m723a(this.f46851a.m1674b3(UtilityFunctions.m803c()).m1691Z1(t));
    }

    /* renamed from: e */
    public T m719e(T t, Func1<? super T, Boolean> func1) {
        return m723a(this.f46851a.m1723V1(func1).m1674b3(UtilityFunctions.m803c()).m1691Z1(t));
    }

    /* renamed from: f */
    public void m718f(Action1<? super T> action1) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        BlockingUtils.m872a(countDownLatch, this.f46851a.m1551q5(new C16106a(countDownLatch, atomicReference, action1)));
        if (atomicReference.get() != null) {
            C15575a.m1476c((Throwable) atomicReference.get());
        }
    }

    /* renamed from: h */
    public Iterator<T> m716h() {
        return BlockingOperatorToIterator.m1266a(this.f46851a);
    }

    /* renamed from: i */
    public T m715i() {
        return m723a(this.f46851a.m1722V2());
    }

    /* renamed from: j */
    public T m714j(Func1<? super T, Boolean> func1) {
        return m723a(this.f46851a.m1714W2(func1));
    }

    /* renamed from: k */
    public T m713k(T t) {
        return m723a(this.f46851a.m1674b3(UtilityFunctions.m803c()).m1706X2(t));
    }

    /* renamed from: l */
    public T m712l(T t, Func1<? super T, Boolean> func1) {
        return m723a(this.f46851a.m1723V1(func1).m1674b3(UtilityFunctions.m803c()).m1706X2(t));
    }

    /* renamed from: m */
    public Iterable<T> m711m() {
        return BlockingOperatorLatest.m1306a(this.f46851a);
    }

    /* renamed from: n */
    public Iterable<T> m710n(T t) {
        return BlockingOperatorMostRecent.m1299a(this.f46851a, t);
    }

    /* renamed from: o */
    public Iterable<T> m709o() {
        return BlockingOperatorNext.m1281a(this.f46851a);
    }

    /* renamed from: p */
    public T m708p() {
        return m723a(this.f46851a.m1768P4());
    }

    /* renamed from: q */
    public T m707q(Func1<? super T, Boolean> func1) {
        return m723a(this.f46851a.m1760Q4(func1));
    }

    /* renamed from: r */
    public T m706r(T t) {
        return m723a(this.f46851a.m1674b3(UtilityFunctions.m803c()).m1752R4(t));
    }

    /* renamed from: s */
    public T m705s(T t, Func1<? super T, Boolean> func1) {
        return m723a(this.f46851a.m1723V1(func1).m1674b3(UtilityFunctions.m803c()).m1752R4(t));
    }

    /* renamed from: t */
    public void m704t() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = {null};
        BlockingUtils.m872a(countDownLatch, this.f46851a.m1551q5(new C16109d(thArr, countDownLatch)));
        Throwable th = thArr[0];
        if (th != null) {
            C15575a.m1476c(th);
        }
    }

    /* renamed from: u */
    public void m703u(Observer<? super T> observer) {
        Object poll;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        Subscription m1551q5 = this.f46851a.m1551q5(new C16110e(linkedBlockingQueue));
        do {
            try {
                poll = linkedBlockingQueue.poll();
                if (poll == null) {
                    poll = linkedBlockingQueue.take();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                observer.onError(e);
                return;
            } finally {
                m1551q5.unsubscribe();
            }
        } while (!NotificationLite.m1052a(observer, poll));
    }

    /* renamed from: v */
    public void m702v(Subscriber<? super T> subscriber) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        Producer[] producerArr = {null};
        C16111f c16111f = new C16111f(linkedBlockingQueue, producerArr);
        subscriber.add(c16111f);
        subscriber.add(Subscriptions.m346a(new C16112g(linkedBlockingQueue)));
        this.f46851a.m1551q5(c16111f);
        while (!subscriber.isUnsubscribed()) {
            try {
                try {
                    Object poll = linkedBlockingQueue.poll();
                    if (poll == null) {
                        poll = linkedBlockingQueue.take();
                    }
                    if (subscriber.isUnsubscribed() || poll == f46850d) {
                        break;
                    } else if (poll == f46848b) {
                        subscriber.onStart();
                    } else if (poll == f46849c) {
                        subscriber.setProducer(producerArr[0]);
                    } else if (NotificationLite.m1052a(subscriber, poll)) {
                        return;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    subscriber.onError(e);
                }
            } finally {
                c16111f.unsubscribe();
            }
        }
    }

    /* renamed from: w */
    public void m701w(Action1<? super T> action1) {
        m699y(action1, new C16113h(), Actions.m1455a());
    }

    /* renamed from: x */
    public void m700x(Action1<? super T> action1, Action1<? super Throwable> action12) {
        m699y(action1, action12, Actions.m1455a());
    }

    /* renamed from: y */
    public void m699y(Action1<? super T> action1, Action1<? super Throwable> action12, Action0 action0) {
        m703u(new C16114i(action1, action12, action0));
    }

    /* renamed from: z */
    public Future<T> m698z() {
        return BlockingOperatorToFuture.m1275a(this.f46851a);
    }
}
