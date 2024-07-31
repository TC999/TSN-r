package p640rx.observables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.annotations.Beta;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Action2;
import p640rx.functions.Action3;
import p640rx.functions.Func0;
import p640rx.functions.Func1;
import p640rx.functions.Func3;
import p640rx.internal.operators.BufferUntilSubscriber;
import p640rx.observers.SerializedObserver;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.CompositeSubscription;

@Beta
/* renamed from: rx.observables.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AsyncOnSubscribe<S, T> implements Observable.InterfaceC15567a<T> {

    /* compiled from: AsyncOnSubscribe.java */
    /* renamed from: rx.observables.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16093a implements Func3<S, Long, Observer<Observable<? extends T>>, S> {

        /* renamed from: a */
        final /* synthetic */ Action3 f46816a;

        C16093a(Action3 action3) {
            this.f46816a = action3;
        }

        @Override // p640rx.functions.Func3
        public /* bridge */ /* synthetic */ Object call(Object obj, Long l, Object obj2) {
            return call((C16093a) obj, l, (Observer) ((Observer) obj2));
        }

        public S call(S s, Long l, Observer<Observable<? extends T>> observer) {
            this.f46816a.call(s, l, observer);
            return s;
        }
    }

    /* compiled from: AsyncOnSubscribe.java */
    /* renamed from: rx.observables.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16094b implements Func3<S, Long, Observer<Observable<? extends T>>, S> {

        /* renamed from: a */
        final /* synthetic */ Action3 f46817a;

        C16094b(Action3 action3) {
            this.f46817a = action3;
        }

        @Override // p640rx.functions.Func3
        public /* bridge */ /* synthetic */ Object call(Object obj, Long l, Object obj2) {
            return call((C16094b) obj, l, (Observer) ((Observer) obj2));
        }

        public S call(S s, Long l, Observer<Observable<? extends T>> observer) {
            this.f46817a.call(s, l, observer);
            return s;
        }
    }

    /* compiled from: AsyncOnSubscribe.java */
    /* renamed from: rx.observables.a$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16095c implements Func3<Void, Long, Observer<Observable<? extends T>>, Void> {

        /* renamed from: a */
        final /* synthetic */ Action2 f46818a;

        C16095c(Action2 action2) {
            this.f46818a = action2;
        }

        @Override // p640rx.functions.Func3
        public /* bridge */ /* synthetic */ Void call(Void r1, Long l, Object obj) {
            return call(r1, l, (Observer) ((Observer) obj));
        }

        public Void call(Void r2, Long l, Observer<Observable<? extends T>> observer) {
            this.f46818a.call(l, observer);
            return r2;
        }
    }

    /* compiled from: AsyncOnSubscribe.java */
    /* renamed from: rx.observables.a$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16096d implements Func3<Void, Long, Observer<Observable<? extends T>>, Void> {

        /* renamed from: a */
        final /* synthetic */ Action2 f46819a;

        C16096d(Action2 action2) {
            this.f46819a = action2;
        }

        @Override // p640rx.functions.Func3
        public /* bridge */ /* synthetic */ Void call(Void r1, Long l, Object obj) {
            return call(r1, l, (Observer) ((Observer) obj));
        }

        public Void call(Void r1, Long l, Observer<Observable<? extends T>> observer) {
            this.f46819a.call(l, observer);
            return null;
        }
    }

    /* compiled from: AsyncOnSubscribe.java */
    /* renamed from: rx.observables.a$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16097e implements Action1<Void> {

        /* renamed from: a */
        final /* synthetic */ Action0 f46820a;

        C16097e(Action0 action0) {
            this.f46820a = action0;
        }

        @Override // p640rx.functions.Action1
        public void call(Void r1) {
            this.f46820a.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncOnSubscribe.java */
    /* renamed from: rx.observables.a$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16098f extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f46821a;

        /* renamed from: b */
        final /* synthetic */ C16101i f46822b;

        C16098f(Subscriber subscriber, C16101i c16101i) {
            this.f46821a = subscriber;
            this.f46822b = c16101i;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46821a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46821a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46821a.onNext(t);
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f46822b.m729J(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncOnSubscribe.java */
    /* renamed from: rx.observables.a$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16099g implements Func1<Observable<T>, Observable<T>> {
        C16099g() {
        }

        @Override // p640rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Observable) ((Observable) obj));
        }

        public Observable<T> call(Observable<T> observable) {
            return observable.m1793M3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncOnSubscribe.java */
    /* renamed from: rx.observables.a$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16101i<S, T> implements Producer, Subscription, Observer<Observable<? extends T>> {

        /* renamed from: b */
        private final AsyncOnSubscribe<S, T> f46829b;

        /* renamed from: e */
        private boolean f46832e;

        /* renamed from: f */
        private boolean f46833f;

        /* renamed from: g */
        private S f46834g;

        /* renamed from: h */
        private final C16104j<Observable<T>> f46835h;

        /* renamed from: i */
        boolean f46836i;

        /* renamed from: j */
        List<Long> f46837j;

        /* renamed from: k */
        Producer f46838k;

        /* renamed from: l */
        long f46839l;

        /* renamed from: d */
        final CompositeSubscription f46831d = new CompositeSubscription();

        /* renamed from: c */
        private final SerializedObserver<Observable<? extends T>> f46830c = new SerializedObserver<>(this);

        /* renamed from: a */
        final AtomicBoolean f46828a = new AtomicBoolean();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AsyncOnSubscribe.java */
        /* renamed from: rx.observables.a$i$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C16102a extends Subscriber<T> {

            /* renamed from: a */
            long f46840a;

            /* renamed from: b */
            final /* synthetic */ long f46841b;

            /* renamed from: c */
            final /* synthetic */ BufferUntilSubscriber f46842c;

            C16102a(long j, BufferUntilSubscriber bufferUntilSubscriber) {
                this.f46841b = j;
                this.f46842c = bufferUntilSubscriber;
                this.f46840a = j;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                this.f46842c.onCompleted();
                long j = this.f46840a;
                if (j > 0) {
                    C16101i.this.m730I(j);
                }
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                this.f46842c.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(T t) {
                this.f46840a--;
                this.f46842c.onNext(t);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AsyncOnSubscribe.java */
        /* renamed from: rx.observables.a$i$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C16103b implements Action0 {

            /* renamed from: a */
            final /* synthetic */ Subscriber f46844a;

            C16103b(Subscriber subscriber) {
                this.f46844a = subscriber;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C16101i.this.f46831d.m361G(this.f46844a);
            }
        }

        public C16101i(AsyncOnSubscribe<S, T> asyncOnSubscribe, S s, C16104j<Observable<T>> c16104j) {
            this.f46829b = asyncOnSubscribe;
            this.f46834g = s;
            this.f46835h = c16104j;
        }

        /* renamed from: F */
        private void m733F(Throwable th) {
            if (this.f46832e) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f46832e = true;
            this.f46835h.onError(th);
            m726d();
        }

        /* renamed from: K */
        private void m728K(Observable<? extends T> observable) {
            BufferUntilSubscriber m1256x7 = BufferUntilSubscriber.m1256x7();
            C16102a c16102a = new C16102a(this.f46839l, m1256x7);
            this.f46831d.m359a(c16102a);
            observable.m1779O1(new C16103b(c16102a)).m1551q5(c16102a);
            this.f46835h.onNext(m1256x7);
        }

        /* renamed from: G */
        public void m732G(long j) {
            this.f46834g = this.f46829b.mo735h(this.f46834g, j, this.f46830c);
        }

        @Override // p640rx.Observer
        /* renamed from: H */
        public void onNext(Observable<? extends T> observable) {
            if (!this.f46833f) {
                this.f46833f = true;
                if (this.f46832e) {
                    return;
                }
                m728K(observable);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        /* renamed from: I */
        public void m730I(long j) {
            if (j == 0) {
                return;
            }
            if (j >= 0) {
                synchronized (this) {
                    if (this.f46836i) {
                        List list = this.f46837j;
                        if (list == null) {
                            list = new ArrayList();
                            this.f46837j = list;
                        }
                        list.add(Long.valueOf(j));
                        return;
                    }
                    this.f46836i = true;
                    if (m727L(j)) {
                        return;
                    }
                    while (true) {
                        synchronized (this) {
                            List<Long> list2 = this.f46837j;
                            if (list2 == null) {
                                this.f46836i = false;
                                return;
                            }
                            this.f46837j = null;
                            for (Long l : list2) {
                                if (m727L(l.longValue())) {
                                    return;
                                }
                            }
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Request can't be negative! " + j);
            }
        }

        /* renamed from: J */
        void m729J(Producer producer) {
            if (this.f46838k == null) {
                this.f46838k = producer;
                return;
            }
            throw new IllegalStateException("setConcatProducer may be called at most once!");
        }

        /* renamed from: L */
        boolean m727L(long j) {
            if (isUnsubscribed()) {
                m726d();
                return true;
            }
            try {
                this.f46833f = false;
                this.f46839l = j;
                m732G(j);
                if (!this.f46832e && !isUnsubscribed()) {
                    if (this.f46833f) {
                        return false;
                    }
                    m733F(new IllegalStateException("No events emitted!"));
                    return true;
                }
                m726d();
                return true;
            } catch (Throwable th) {
                m733F(th);
                return true;
            }
        }

        /* renamed from: d */
        void m726d() {
            this.f46831d.unsubscribe();
            try {
                this.f46829b.mo734i(this.f46834g);
            } catch (Throwable th) {
                m733F(th);
            }
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46828a.get();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (!this.f46832e) {
                this.f46832e = true;
                this.f46835h.onCompleted();
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (!this.f46832e) {
                this.f46832e = true;
                this.f46835h.onError(th);
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // p640rx.Producer
        public void request(long j) {
            boolean z;
            if (j == 0) {
                return;
            }
            if (j >= 0) {
                synchronized (this) {
                    z = true;
                    if (this.f46836i) {
                        List list = this.f46837j;
                        if (list == null) {
                            list = new ArrayList();
                            this.f46837j = list;
                        }
                        list.add(Long.valueOf(j));
                    } else {
                        this.f46836i = true;
                        z = false;
                    }
                }
                this.f46838k.request(j);
                if (z || m727L(j)) {
                    return;
                }
                while (true) {
                    synchronized (this) {
                        List<Long> list2 = this.f46837j;
                        if (list2 == null) {
                            this.f46836i = false;
                            return;
                        }
                        this.f46837j = null;
                        for (Long l : list2) {
                            if (m727L(l.longValue())) {
                                return;
                            }
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Request can't be negative! " + j);
            }
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (this.f46828a.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.f46836i) {
                        ArrayList arrayList = new ArrayList();
                        this.f46837j = arrayList;
                        arrayList.add(0L);
                        return;
                    }
                    this.f46836i = true;
                    m726d();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncOnSubscribe.java */
    /* renamed from: rx.observables.a$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16104j<T> extends Observable<T> implements Observer<T> {

        /* renamed from: b */
        private final C16105a<T> f46846b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AsyncOnSubscribe.java */
        /* renamed from: rx.observables.a$j$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C16105a<T> implements Observable.InterfaceC15567a<T> {

            /* renamed from: a */
            Subscriber<? super T> f46847a;

            C16105a() {
            }

            @Override // p640rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber) ((Subscriber) obj));
            }

            public void call(Subscriber<? super T> subscriber) {
                synchronized (this) {
                    if (this.f46847a == null) {
                        this.f46847a = subscriber;
                    } else {
                        subscriber.onError(new IllegalStateException("There can be only one subscriber"));
                    }
                }
            }
        }

        protected C16104j(C16105a<T> c16105a) {
            super(c16105a);
            this.f46846b = c16105a;
        }

        /* renamed from: v7 */
        public static <T> C16104j<T> m725v7() {
            return new C16104j<>(new C16105a());
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46846b.f46847a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46846b.f46847a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46846b.f46847a.onNext(t);
        }
    }

    /* renamed from: a */
    public static <S, T> AsyncOnSubscribe<S, T> m742a(Func0<? extends S> func0, Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3) {
        return new C16100h(func0, new C16093a(action3));
    }

    /* renamed from: b */
    public static <S, T> AsyncOnSubscribe<S, T> m741b(Func0<? extends S> func0, Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3, Action1<? super S> action1) {
        return new C16100h(func0, new C16094b(action3), action1);
    }

    /* renamed from: c */
    public static <S, T> AsyncOnSubscribe<S, T> m740c(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
        return new C16100h(func0, func3);
    }

    /* renamed from: d */
    public static <S, T> AsyncOnSubscribe<S, T> m739d(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
        return new C16100h(func0, func3, action1);
    }

    /* renamed from: e */
    public static <T> AsyncOnSubscribe<Void, T> m738e(Action2<Long, ? super Observer<Observable<? extends T>>> action2) {
        return new C16100h(new C16095c(action2));
    }

    /* renamed from: f */
    public static <T> AsyncOnSubscribe<Void, T> m737f(Action2<Long, ? super Observer<Observable<? extends T>>> action2, Action0 action0) {
        return new C16100h(new C16096d(action2), new C16097e(action0));
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    /* renamed from: g */
    protected abstract S mo736g();

    /* renamed from: h */
    protected abstract S mo735h(S s, long j, Observer<Observable<? extends T>> observer);

    /* renamed from: i */
    protected void mo734i(S s) {
    }

    public final void call(Subscriber<? super T> subscriber) {
        try {
            S mo736g = mo736g();
            C16104j m725v7 = C16104j.m725v7();
            C16101i c16101i = new C16101i(this, mo736g, m725v7);
            C16098f c16098f = new C16098f(subscriber, c16101i);
            m725v7.m1793M3().m1692Z0(new C16099g()).m1822I6(c16098f);
            subscriber.add(c16098f);
            subscriber.add(c16101i);
            subscriber.setProducer(c16101i);
        } catch (Throwable th) {
            subscriber.onError(th);
        }
    }

    /* compiled from: AsyncOnSubscribe.java */
    /* renamed from: rx.observables.a$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16100h<S, T> extends AsyncOnSubscribe<S, T> {

        /* renamed from: a */
        private final Func0<? extends S> f46825a;

        /* renamed from: b */
        private final Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> f46826b;

        /* renamed from: c */
        private final Action1<? super S> f46827c;

        C16100h(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
            this.f46825a = func0;
            this.f46826b = func3;
            this.f46827c = action1;
        }

        @Override // p640rx.observables.AsyncOnSubscribe, p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            super.call((Subscriber) ((Subscriber) obj));
        }

        @Override // p640rx.observables.AsyncOnSubscribe
        /* renamed from: g */
        protected S mo736g() {
            Func0<? extends S> func0 = this.f46825a;
            if (func0 == null) {
                return null;
            }
            return func0.call();
        }

        @Override // p640rx.observables.AsyncOnSubscribe
        /* renamed from: h */
        protected S mo735h(S s, long j, Observer<Observable<? extends T>> observer) {
            return this.f46826b.call(s, Long.valueOf(j), observer);
        }

        @Override // p640rx.observables.AsyncOnSubscribe
        /* renamed from: i */
        protected void mo734i(S s) {
            Action1<? super S> action1 = this.f46827c;
            if (action1 != null) {
                action1.call(s);
            }
        }

        public C16100h(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
            this(func0, func3, null);
        }

        public C16100h(Func3<S, Long, Observer<Observable<? extends T>>, S> func3, Action1<? super S> action1) {
            this(null, func3, action1);
        }

        public C16100h(Func3<S, Long, Observer<Observable<? extends T>>, S> func3) {
            this(null, func3, null);
        }
    }
}
