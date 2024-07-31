package p640rx.internal.operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.MissingBackpressureException;

/* renamed from: rx.internal.operators.p1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorBufferWithSize<T> implements Observable.InterfaceC15568b<List<T>, T> {

    /* renamed from: a */
    final int f45679a;

    /* renamed from: b */
    final int f45680b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorBufferWithSize.java */
    /* renamed from: rx.internal.operators.p1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15827a<T> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super List<T>> f45681a;

        /* renamed from: b */
        final int f45682b;

        /* renamed from: c */
        List<T> f45683c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorBufferWithSize.java */
        /* renamed from: rx.internal.operators.p1$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15828a implements Producer {
            C15828a() {
            }

            @Override // p640rx.Producer
            public void request(long j) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= required but it was " + j);
                } else if (j != 0) {
                    C15827a.this.request(BackpressureUtils.m1334c(j, C15827a.this.f45682b));
                }
            }
        }

        public C15827a(Subscriber<? super List<T>> subscriber, int i) {
            this.f45681a = subscriber;
            this.f45682b = i;
            request(0L);
        }

        /* renamed from: G */
        Producer m1127G() {
            return new C15828a();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            List<T> list = this.f45683c;
            if (list != null) {
                this.f45681a.onNext(list);
            }
            this.f45681a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45683c = null;
            this.f45681a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            List list = this.f45683c;
            if (list == null) {
                list = new ArrayList(this.f45682b);
                this.f45683c = list;
            }
            list.add(t);
            if (list.size() == this.f45682b) {
                this.f45683c = null;
                this.f45681a.onNext(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorBufferWithSize.java */
    /* renamed from: rx.internal.operators.p1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15829b<T> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super List<T>> f45685a;

        /* renamed from: b */
        final int f45686b;

        /* renamed from: c */
        final int f45687c;

        /* renamed from: d */
        long f45688d;

        /* renamed from: e */
        final ArrayDeque<List<T>> f45689e = new ArrayDeque<>();

        /* renamed from: f */
        final AtomicLong f45690f = new AtomicLong();

        /* renamed from: g */
        long f45691g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorBufferWithSize.java */
        /* renamed from: rx.internal.operators.p1$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15830a extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = -4015894850868853147L;

            C15830a() {
            }

            @Override // p640rx.Producer
            public void request(long j) {
                C15829b c15829b = C15829b.this;
                if (!BackpressureUtils.m1330g(c15829b.f45690f, j, c15829b.f45689e, c15829b.f45685a) || j == 0) {
                    return;
                }
                if (!get() && compareAndSet(false, true)) {
                    c15829b.request(BackpressureUtils.m1336a(BackpressureUtils.m1334c(c15829b.f45687c, j - 1), c15829b.f45686b));
                } else {
                    c15829b.request(BackpressureUtils.m1334c(c15829b.f45687c, j));
                }
            }
        }

        public C15829b(Subscriber<? super List<T>> subscriber, int i, int i2) {
            this.f45685a = subscriber;
            this.f45686b = i;
            this.f45687c = i2;
            request(0L);
        }

        /* renamed from: H */
        Producer m1124H() {
            return new C15830a();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            long j = this.f45691g;
            if (j != 0) {
                if (j > this.f45690f.get()) {
                    Subscriber<? super List<T>> subscriber = this.f45685a;
                    subscriber.onError(new MissingBackpressureException("More produced than requested? " + j));
                    return;
                }
                this.f45690f.addAndGet(-j);
            }
            BackpressureUtils.m1333d(this.f45690f, this.f45689e, this.f45685a);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45689e.clear();
            this.f45685a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            long j = this.f45688d;
            if (j == 0) {
                this.f45689e.offer(new ArrayList(this.f45686b));
            }
            long j2 = j + 1;
            if (j2 == this.f45687c) {
                this.f45688d = 0L;
            } else {
                this.f45688d = j2;
            }
            Iterator<List<T>> it = this.f45689e.iterator();
            while (it.hasNext()) {
                it.next().add(t);
            }
            List<T> peek = this.f45689e.peek();
            if (peek == null || peek.size() != this.f45686b) {
                return;
            }
            this.f45689e.poll();
            this.f45691g++;
            this.f45685a.onNext(peek);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorBufferWithSize.java */
    /* renamed from: rx.internal.operators.p1$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15831c<T> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super List<T>> f45693a;

        /* renamed from: b */
        final int f45694b;

        /* renamed from: c */
        final int f45695c;

        /* renamed from: d */
        long f45696d;

        /* renamed from: e */
        List<T> f45697e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorBufferWithSize.java */
        /* renamed from: rx.internal.operators.p1$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15832a extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = 3428177408082367154L;

            C15832a() {
            }

            @Override // p640rx.Producer
            public void request(long j) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                } else if (j != 0) {
                    C15831c c15831c = C15831c.this;
                    if (!get() && compareAndSet(false, true)) {
                        c15831c.request(BackpressureUtils.m1336a(BackpressureUtils.m1334c(j, c15831c.f45694b), BackpressureUtils.m1334c(c15831c.f45695c - c15831c.f45694b, j - 1)));
                    } else {
                        c15831c.request(BackpressureUtils.m1334c(j, c15831c.f45695c));
                    }
                }
            }
        }

        public C15831c(Subscriber<? super List<T>> subscriber, int i, int i2) {
            this.f45693a = subscriber;
            this.f45694b = i;
            this.f45695c = i2;
            request(0L);
        }

        /* renamed from: H */
        Producer m1121H() {
            return new C15832a();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            List<T> list = this.f45697e;
            if (list != null) {
                this.f45697e = null;
                this.f45693a.onNext(list);
            }
            this.f45693a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45697e = null;
            this.f45693a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            long j = this.f45696d;
            List list = this.f45697e;
            if (j == 0) {
                list = new ArrayList(this.f45694b);
                this.f45697e = list;
            }
            long j2 = j + 1;
            if (j2 == this.f45695c) {
                this.f45696d = 0L;
            } else {
                this.f45696d = j2;
            }
            if (list != null) {
                list.add(t);
                if (list.size() == this.f45694b) {
                    this.f45697e = null;
                    this.f45693a.onNext(list);
                }
            }
        }
    }

    public OperatorBufferWithSize(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("count must be greater than 0");
        }
        if (i2 > 0) {
            this.f45679a = i;
            this.f45680b = i2;
            return;
        }
        throw new IllegalArgumentException("skip must be greater than 0");
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        int i = this.f45680b;
        int i2 = this.f45679a;
        if (i == i2) {
            C15827a c15827a = new C15827a(subscriber, i2);
            subscriber.add(c15827a);
            subscriber.setProducer(c15827a.m1127G());
            return c15827a;
        } else if (i > i2) {
            C15831c c15831c = new C15831c(subscriber, i2, i);
            subscriber.add(c15831c);
            subscriber.setProducer(c15831c.m1121H());
            return c15831c;
        } else {
            C15829b c15829b = new C15829b(subscriber, i2, i);
            subscriber.add(c15829b);
            subscriber.setProducer(c15829b.m1124H());
            return c15829b;
        }
    }
}
