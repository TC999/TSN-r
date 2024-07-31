package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.w */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeAmb<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Iterable<? extends Observable<? extends T>> f46052a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeAmb.java */
    /* renamed from: rx.internal.operators.w$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15930a implements Action0 {

        /* renamed from: a */
        final /* synthetic */ C15933d f46053a;

        C15930a(C15933d c15933d) {
            this.f46053a = c15933d;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            C15932c<T> c15932c = this.f46053a.get();
            if (c15932c != null) {
                c15932c.unsubscribe();
            }
            OnSubscribeAmb.m1029j(this.f46053a.f46060a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeAmb.java */
    /* renamed from: rx.internal.operators.w$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15931b implements Producer {

        /* renamed from: a */
        final /* synthetic */ C15933d f46055a;

        C15931b(C15933d c15933d) {
            this.f46055a = c15933d;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            C15932c<T> c15932c = this.f46055a.get();
            if (c15932c != null) {
                c15932c.m1026H(j);
                return;
            }
            for (C15932c<T> c15932c2 : this.f46055a.f46060a) {
                if (!c15932c2.isUnsubscribed()) {
                    if (this.f46055a.get() == c15932c2) {
                        c15932c2.m1026H(j);
                        return;
                    }
                    c15932c2.m1026H(j);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeAmb.java */
    /* renamed from: rx.internal.operators.w$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15932c<T> extends Subscriber<T> {

        /* renamed from: a */
        private final Subscriber<? super T> f46057a;

        /* renamed from: b */
        private final C15933d<T> f46058b;

        /* renamed from: c */
        private boolean f46059c;

        C15932c(long j, Subscriber<? super T> subscriber, C15933d<T> c15933d) {
            this.f46057a = subscriber;
            this.f46058b = c15933d;
            request(j);
        }

        /* renamed from: G */
        private boolean m1027G() {
            if (this.f46059c) {
                return true;
            }
            if (this.f46058b.get() == this) {
                this.f46059c = true;
                return true;
            } else if (this.f46058b.compareAndSet(null, this)) {
                this.f46058b.m1024b(this);
                this.f46059c = true;
                return true;
            } else {
                this.f46058b.m1025a();
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: H */
        public void m1026H(long j) {
            request(j);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (m1027G()) {
                this.f46057a.onCompleted();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (m1027G()) {
                this.f46057a.onError(th);
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (m1027G()) {
                this.f46057a.onNext(t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeAmb.java */
    /* renamed from: rx.internal.operators.w$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15933d<T> extends AtomicReference<C15932c<T>> {

        /* renamed from: a */
        final Collection<C15932c<T>> f46060a = new ConcurrentLinkedQueue();

        C15933d() {
        }

        /* renamed from: a */
        public void m1025a() {
            C15932c<T> c15932c = get();
            if (c15932c != null) {
                m1024b(c15932c);
            }
        }

        /* renamed from: b */
        public void m1024b(C15932c<T> c15932c) {
            for (C15932c<T> c15932c2 : this.f46060a) {
                if (c15932c2 != c15932c) {
                    c15932c2.unsubscribe();
                }
            }
            this.f46060a.clear();
        }
    }

    private OnSubscribeAmb(Iterable<? extends Observable<? extends T>> iterable) {
        this.f46052a = iterable;
    }

    /* renamed from: a */
    public static <T> Observable.InterfaceC15567a<T> m1038a(Iterable<? extends Observable<? extends T>> iterable) {
        return new OnSubscribeAmb(iterable);
    }

    /* renamed from: b */
    public static <T> Observable.InterfaceC15567a<T> m1037b(Observable<? extends T> observable, Observable<? extends T> observable2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        return m1038a(arrayList);
    }

    /* renamed from: c */
    public static <T> Observable.InterfaceC15567a<T> m1036c(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        return m1038a(arrayList);
    }

    /* renamed from: d */
    public static <T> Observable.InterfaceC15567a<T> m1035d(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        return m1038a(arrayList);
    }

    /* renamed from: e */
    public static <T> Observable.InterfaceC15567a<T> m1034e(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        return m1038a(arrayList);
    }

    /* renamed from: f */
    public static <T> Observable.InterfaceC15567a<T> m1033f(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        return m1038a(arrayList);
    }

    /* renamed from: g */
    public static <T> Observable.InterfaceC15567a<T> m1032g(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        return m1038a(arrayList);
    }

    /* renamed from: h */
    public static <T> Observable.InterfaceC15567a<T> m1031h(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        arrayList.add(observable8);
        return m1038a(arrayList);
    }

    /* renamed from: i */
    public static <T> Observable.InterfaceC15567a<T> m1030i(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        arrayList.add(observable8);
        arrayList.add(observable9);
        return m1038a(arrayList);
    }

    /* renamed from: j */
    static <T> void m1029j(Collection<C15932c<T>> collection) {
        if (collection.isEmpty()) {
            return;
        }
        for (C15932c<T> c15932c : collection) {
            c15932c.unsubscribe();
        }
        collection.clear();
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        C15933d c15933d = new C15933d();
        subscriber.add(Subscriptions.m346a(new C15930a(c15933d)));
        for (Observable<? extends T> observable : this.f46052a) {
            if (subscriber.isUnsubscribed()) {
                break;
            }
            C15932c<T> c15932c = new C15932c<>(0L, subscriber, c15933d);
            c15933d.f46060a.add(c15932c);
            C15932c<T> c15932c2 = c15933d.get();
            if (c15932c2 != null) {
                c15933d.m1024b(c15932c2);
                return;
            }
            observable.m1822I6(c15932c);
        }
        if (subscriber.isUnsubscribed()) {
            m1029j(c15933d.f46060a);
        }
        subscriber.setProducer(new C15931b(c15933d));
    }
}
