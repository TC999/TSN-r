package p640rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.exceptions.MissingBackpressureException;
import p640rx.functions.Action0;
import p640rx.internal.schedulers.ImmediateScheduler;
import p640rx.internal.schedulers.TrampolineScheduler;
import p640rx.internal.util.RxRingBuffer;
import p640rx.internal.util.atomic.SpscAtomicArrayQueue;
import p640rx.internal.util.unsafe.C16092z;
import p640rx.internal.util.unsafe.UnsafeAccess;
import p640rx.plugins.RxJavaHooks;
import p640rx.schedulers.Schedulers;

/* renamed from: rx.internal.operators.n2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorObserveOn<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    private final Scheduler f45565a;

    /* renamed from: b */
    private final boolean f45566b;

    /* renamed from: c */
    private final int f45567c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorObserveOn.java */
    /* renamed from: rx.internal.operators.n2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15800a implements Observable.InterfaceC15568b<T, T> {

        /* renamed from: a */
        final /* synthetic */ int f45568a;

        C15800a(int i) {
            this.f45568a = i;
        }

        @Override // p640rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Subscriber) ((Subscriber) obj));
        }

        public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
            C15801b c15801b = new C15801b(Schedulers.m476d(), subscriber, false, this.f45568a);
            c15801b.m1145G();
            return c15801b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorObserveOn.java */
    /* renamed from: rx.internal.operators.n2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15801b<T> extends Subscriber<T> implements Action0 {

        /* renamed from: a */
        final Subscriber<? super T> f45569a;

        /* renamed from: b */
        final Scheduler.AbstractC15607a f45570b;

        /* renamed from: c */
        final boolean f45571c;

        /* renamed from: d */
        final Queue<Object> f45572d;

        /* renamed from: e */
        final int f45573e;

        /* renamed from: f */
        volatile boolean f45574f;

        /* renamed from: g */
        final AtomicLong f45575g = new AtomicLong();

        /* renamed from: h */
        final AtomicLong f45576h = new AtomicLong();

        /* renamed from: i */
        Throwable f45577i;

        /* renamed from: j */
        long f45578j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorObserveOn.java */
        /* renamed from: rx.internal.operators.n2$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15802a implements Producer {
            C15802a() {
            }

            @Override // p640rx.Producer
            public void request(long j) {
                if (j > 0) {
                    BackpressureUtils.m1335b(C15801b.this.f45575g, j);
                    C15801b.this.m1144H();
                }
            }
        }

        public C15801b(Scheduler scheduler, Subscriber<? super T> subscriber, boolean z, int i) {
            this.f45569a = subscriber;
            this.f45570b = scheduler.mo450a();
            this.f45571c = z;
            i = i <= 0 ? RxRingBuffer.f46509d : i;
            this.f45573e = i - (i >> 2);
            if (UnsafeAccess.m759f()) {
                this.f45572d = new C16092z(i);
            } else {
                this.f45572d = new SpscAtomicArrayQueue(i);
            }
            request(i);
        }

        /* renamed from: F */
        boolean m1146F(boolean z, boolean z2, Subscriber<? super T> subscriber, Queue<Object> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (z) {
                if (this.f45571c) {
                    if (z2) {
                        Throwable th = this.f45577i;
                        try {
                            if (th != null) {
                                subscriber.onError(th);
                            } else {
                                subscriber.onCompleted();
                            }
                            return false;
                        } finally {
                        }
                    }
                    return false;
                }
                Throwable th2 = this.f45577i;
                if (th2 != null) {
                    queue.clear();
                    try {
                        subscriber.onError(th2);
                        return true;
                    } finally {
                    }
                } else if (z2) {
                    try {
                        subscriber.onCompleted();
                        return true;
                    } finally {
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        /* renamed from: G */
        void m1145G() {
            Subscriber<? super T> subscriber = this.f45569a;
            subscriber.setProducer(new C15802a());
            subscriber.add(this.f45570b);
            subscriber.add(this);
        }

        /* renamed from: H */
        protected void m1144H() {
            if (this.f45576h.getAndIncrement() == 0) {
                this.f45570b.mo456d(this);
            }
        }

        @Override // p640rx.functions.Action0
        public void call() {
            long j = this.f45578j;
            Queue<Object> queue = this.f45572d;
            Subscriber<? super T> subscriber = this.f45569a;
            long j2 = 1;
            do {
                long j3 = this.f45575g.get();
                while (j3 != j) {
                    boolean z = this.f45574f;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (m1146F(z, z2, subscriber, queue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext((Object) NotificationLite.m1048e(poll));
                    j++;
                    if (j == this.f45573e) {
                        j3 = BackpressureUtils.m1328i(this.f45575g, j);
                        request(j);
                        j = 0;
                    }
                }
                if (j3 == j && m1146F(this.f45574f, queue.isEmpty(), subscriber, queue)) {
                    return;
                }
                this.f45578j = j;
                j2 = this.f45576h.addAndGet(-j2);
            } while (j2 != 0);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (isUnsubscribed() || this.f45574f) {
                return;
            }
            this.f45574f = true;
            m1144H();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (!isUnsubscribed() && !this.f45574f) {
                this.f45577i = th;
                this.f45574f = true;
                m1144H();
                return;
            }
            RxJavaHooks.m576I(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (isUnsubscribed() || this.f45574f) {
                return;
            }
            if (!this.f45572d.offer(NotificationLite.m1043j(t))) {
                onError(new MissingBackpressureException());
            } else {
                m1144H();
            }
        }
    }

    public OperatorObserveOn(Scheduler scheduler, boolean z) {
        this(scheduler, z, RxRingBuffer.f46509d);
    }

    /* renamed from: a */
    public static <T> Observable.InterfaceC15568b<T, T> m1147a(int i) {
        return new C15800a(i);
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorObserveOn(Scheduler scheduler, boolean z, int i) {
        this.f45565a = scheduler;
        this.f45566b = z;
        this.f45567c = i <= 0 ? RxRingBuffer.f46509d : i;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler scheduler = this.f45565a;
        if ((scheduler instanceof ImmediateScheduler) || (scheduler instanceof TrampolineScheduler)) {
            return subscriber;
        }
        C15801b c15801b = new C15801b(scheduler, subscriber, this.f45566b, this.f45567c);
        c15801b.m1145G();
        return c15801b;
    }
}
