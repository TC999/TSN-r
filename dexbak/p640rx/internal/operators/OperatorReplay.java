package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.OnErrorThrowable;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Func0;
import p640rx.functions.Func1;
import p640rx.internal.util.OpenHashSet;
import p640rx.observables.ConnectableObservable;
import p640rx.schedulers.Timestamped;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.t2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorReplay<T> extends ConnectableObservable<T> implements Subscription {

    /* renamed from: e */
    static final Func0 f45898e = new C15884a();

    /* renamed from: b */
    final Observable<? extends T> f45899b;

    /* renamed from: c */
    final AtomicReference<C15897l<T>> f45900c;

    /* renamed from: d */
    final Func0<? extends InterfaceC15896k<T>> f45901d;

    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15884a implements Func0 {
        C15884a() {
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public Object call() {
            return new C15901o(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15885b<R> implements Observable.InterfaceC15567a<R> {

        /* renamed from: a */
        final /* synthetic */ Func0 f45902a;

        /* renamed from: b */
        final /* synthetic */ Func1 f45903b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorReplay.java */
        /* renamed from: rx.internal.operators.t2$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15886a implements Action1<Subscription> {

            /* renamed from: a */
            final /* synthetic */ Subscriber f45904a;

            C15886a(Subscriber subscriber) {
                this.f45904a = subscriber;
            }

            @Override // p640rx.functions.Action1
            public void call(Subscription subscription) {
                this.f45904a.add(subscription);
            }
        }

        C15885b(Func0 func0, Func1 func1) {
            this.f45902a = func0;
            this.f45903b = func1;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super R> subscriber) {
            try {
                ConnectableObservable connectableObservable = (ConnectableObservable) this.f45902a.call();
                ((Observable) this.f45903b.call(connectableObservable)).m1551q5(subscriber);
                connectableObservable.mo692z7(new C15886a(subscriber));
            } catch (Throwable th) {
                C15575a.m1473f(th, subscriber);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15887c implements Observable.InterfaceC15567a<T> {

        /* renamed from: a */
        final /* synthetic */ Observable f45906a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorReplay.java */
        /* renamed from: rx.internal.operators.t2$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15888a extends Subscriber<T> {

            /* renamed from: a */
            final /* synthetic */ Subscriber f45907a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C15888a(Subscriber subscriber, Subscriber subscriber2) {
                super(subscriber);
                this.f45907a = subscriber2;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                this.f45907a.onCompleted();
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                this.f45907a.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(T t) {
                this.f45907a.onNext(t);
            }
        }

        C15887c(Observable observable) {
            this.f45906a = observable;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            this.f45906a.m1822I6(new C15888a(subscriber, subscriber));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15889d extends ConnectableObservable<T> {

        /* renamed from: b */
        final /* synthetic */ ConnectableObservable f45909b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15889d(Observable.InterfaceC15567a interfaceC15567a, ConnectableObservable connectableObservable) {
            super(interfaceC15567a);
            this.f45909b = connectableObservable;
        }

        @Override // p640rx.observables.ConnectableObservable
        /* renamed from: z7 */
        public void mo692z7(Action1<? super Subscription> action1) {
            this.f45909b.mo692z7(action1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15890e implements Func0<InterfaceC15896k<T>> {

        /* renamed from: a */
        final /* synthetic */ int f45910a;

        C15890e(int i) {
            this.f45910a = i;
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public InterfaceC15896k<T> call() {
            return new C15900n(this.f45910a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15891f implements Func0<InterfaceC15896k<T>> {

        /* renamed from: a */
        final /* synthetic */ int f45911a;

        /* renamed from: b */
        final /* synthetic */ long f45912b;

        /* renamed from: c */
        final /* synthetic */ Scheduler f45913c;

        C15891f(int i, long j, Scheduler scheduler) {
            this.f45911a = i;
            this.f45912b = j;
            this.f45913c = scheduler;
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public InterfaceC15896k<T> call() {
            return new C15899m(this.f45911a, this.f45912b, this.f45913c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15892g implements Observable.InterfaceC15567a<T> {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f45914a;

        /* renamed from: b */
        final /* synthetic */ Func0 f45915b;

        C15892g(AtomicReference atomicReference, Func0 func0) {
            this.f45914a = atomicReference;
            this.f45915b = func0;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            C15897l c15897l;
            while (true) {
                c15897l = (C15897l) this.f45914a.get();
                if (c15897l != null) {
                    break;
                }
                C15897l c15897l2 = new C15897l((InterfaceC15896k) this.f45915b.call());
                c15897l2.m1068H();
                if (this.f45914a.compareAndSet(c15897l, c15897l2)) {
                    c15897l = c15897l2;
                    break;
                }
            }
            C15894i<T> c15894i = new C15894i<>(c15897l, subscriber);
            c15897l.m1070F(c15894i);
            subscriber.add(c15894i);
            c15897l.f45930a.mo1058a(c15894i);
            subscriber.setProducer(c15894i);
        }
    }

    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15893h<T> extends AtomicReference<C15895j> implements InterfaceC15896k<T> {
        private static final long serialVersionUID = 2346567790059478686L;

        /* renamed from: a */
        C15895j f45916a;

        /* renamed from: b */
        int f45917b;

        /* renamed from: c */
        long f45918c;

        public C15893h() {
            C15895j c15895j = new C15895j(null, 0L);
            this.f45916a = c15895j;
            set(c15895j);
        }

        @Override // p640rx.internal.operators.OperatorReplay.InterfaceC15896k
        /* renamed from: a */
        public final void mo1058a(C15894i<T> c15894i) {
            Subscriber<? super T> subscriber;
            C15895j c15895j;
            synchronized (c15894i) {
                if (c15894i.f45924e) {
                    c15894i.f45925f = true;
                    return;
                }
                c15894i.f45924e = true;
                while (!c15894i.isUnsubscribed()) {
                    C15895j c15895j2 = (C15895j) c15894i.m1072b();
                    if (c15895j2 == null) {
                        c15895j2 = mo1062e();
                        c15894i.f45922c = c15895j2;
                        c15894i.m1073a(c15895j2.f45927b);
                    }
                    if (c15894i.isUnsubscribed() || (subscriber = c15894i.f45921b) == null) {
                        return;
                    }
                    long j = c15894i.get();
                    long j2 = 0;
                    while (j2 != j && (c15895j = c15895j2.get()) != null) {
                        Object mo1061h = mo1061h(c15895j.f45926a);
                        try {
                            if (NotificationLite.m1052a(subscriber, mo1061h)) {
                                c15894i.f45922c = null;
                                return;
                            }
                            j2++;
                            if (c15894i.isUnsubscribed()) {
                                return;
                            }
                            c15895j2 = c15895j;
                        } catch (Throwable th) {
                            c15894i.f45922c = null;
                            C15575a.m1474e(th);
                            c15894i.unsubscribe();
                            if (NotificationLite.m1046g(mo1061h) || NotificationLite.m1047f(mo1061h)) {
                                return;
                            }
                            subscriber.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.m1048e(mo1061h)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        c15894i.f45922c = c15895j2;
                        if (j != Long.MAX_VALUE) {
                            c15894i.m1071d(j2);
                        }
                    }
                    synchronized (c15894i) {
                        if (!c15894i.f45925f) {
                            c15894i.f45924e = false;
                            return;
                        }
                        c15894i.f45925f = false;
                    }
                }
            }
        }

        /* renamed from: b */
        final void m1080b(C15895j c15895j) {
            this.f45916a.set(c15895j);
            this.f45916a = c15895j;
            this.f45917b++;
        }

        /* renamed from: c */
        final void m1079c(Collection<? super T> collection) {
            C15895j mo1062e = mo1062e();
            while (true) {
                mo1062e = mo1062e.get();
                if (mo1062e == null) {
                    return;
                }
                Object mo1061h = mo1061h(mo1062e.f45926a);
                if (NotificationLite.m1047f(mo1061h) || NotificationLite.m1046g(mo1061h)) {
                    return;
                }
                collection.add((Object) NotificationLite.m1048e(mo1061h));
            }
        }

        @Override // p640rx.internal.operators.OperatorReplay.InterfaceC15896k
        public final void complete() {
            Object mo1063d = mo1063d(NotificationLite.m1051b());
            long j = this.f45918c + 1;
            this.f45918c = j;
            m1080b(new C15895j(mo1063d, j));
            mo1060m();
        }

        /* renamed from: d */
        Object mo1063d(Object obj) {
            return obj;
        }

        /* renamed from: e */
        C15895j mo1062e() {
            return get();
        }

        @Override // p640rx.internal.operators.OperatorReplay.InterfaceC15896k
        public final void error(Throwable th) {
            Object mo1063d = mo1063d(NotificationLite.m1050c(th));
            long j = this.f45918c + 1;
            this.f45918c = j;
            m1080b(new C15895j(mo1063d, j));
            mo1060m();
        }

        /* renamed from: f */
        boolean m1078f() {
            Object obj = this.f45916a.f45926a;
            return obj != null && NotificationLite.m1047f(mo1061h(obj));
        }

        /* renamed from: g */
        boolean m1077g() {
            Object obj = this.f45916a.f45926a;
            return obj != null && NotificationLite.m1046g(mo1061h(obj));
        }

        /* renamed from: h */
        Object mo1061h(Object obj) {
            return obj;
        }

        /* renamed from: i */
        final void m1076i() {
            C15895j c15895j = get().get();
            if (c15895j != null) {
                this.f45917b--;
                m1074k(c15895j);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        /* renamed from: j */
        final void m1075j(int i) {
            C15895j c15895j = get();
            while (i > 0) {
                c15895j = c15895j.get();
                i--;
                this.f45917b--;
            }
            m1074k(c15895j);
        }

        /* renamed from: k */
        final void m1074k(C15895j c15895j) {
            set(c15895j);
        }

        /* renamed from: l */
        void mo1059l() {
        }

        /* renamed from: m */
        void mo1060m() {
        }

        @Override // p640rx.internal.operators.OperatorReplay.InterfaceC15896k
        public final void next(T t) {
            Object mo1063d = mo1063d(NotificationLite.m1043j(t));
            long j = this.f45918c + 1;
            this.f45918c = j;
            m1080b(new C15895j(mo1063d, j));
            mo1059l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15894i<T> extends AtomicLong implements Producer, Subscription {

        /* renamed from: g */
        static final long f45919g = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;

        /* renamed from: a */
        final C15897l<T> f45920a;

        /* renamed from: b */
        Subscriber<? super T> f45921b;

        /* renamed from: c */
        Object f45922c;

        /* renamed from: d */
        final AtomicLong f45923d = new AtomicLong();

        /* renamed from: e */
        boolean f45924e;

        /* renamed from: f */
        boolean f45925f;

        public C15894i(C15897l<T> c15897l, Subscriber<? super T> subscriber) {
            this.f45920a = c15897l;
            this.f45921b = subscriber;
        }

        /* renamed from: a */
        void m1073a(long j) {
            long j2;
            long j3;
            do {
                j2 = this.f45923d.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!this.f45923d.compareAndSet(j2, j3));
        }

        /* renamed from: b */
        <U> U m1072b() {
            return (U) this.f45922c;
        }

        /* renamed from: d */
        public long m1071d(long j) {
            long j2;
            long j3;
            if (j > 0) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j3 = j2 - j;
                    if (j3 < 0) {
                        throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                    }
                } while (!compareAndSet(j2, j3));
                return j3;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            long j2;
            long j3;
            if (j < 0) {
                return;
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 >= 0 && j == 0) {
                    return;
                }
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j2, j3));
            m1073a(j);
            this.f45920a.m1066J(this);
            this.f45920a.f45930a.mo1058a(this);
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.f45920a.m1065K(this);
            this.f45920a.m1066J(this);
            this.f45921b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15895j extends AtomicReference<C15895j> {
        private static final long serialVersionUID = 245354315435971818L;

        /* renamed from: a */
        final Object f45926a;

        /* renamed from: b */
        final long f45927b;

        public C15895j(Object obj, long j) {
            this.f45926a = obj;
            this.f45927b = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$k */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15896k<T> {
        /* renamed from: a */
        void mo1058a(C15894i<T> c15894i);

        void complete();

        void error(Throwable th);

        void next(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$l */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15897l<T> extends Subscriber<T> implements Subscription {

        /* renamed from: p */
        static final C15894i[] f45928p = new C15894i[0];

        /* renamed from: q */
        static final C15894i[] f45929q = new C15894i[0];

        /* renamed from: a */
        final InterfaceC15896k<T> f45930a;

        /* renamed from: b */
        boolean f45931b;

        /* renamed from: c */
        volatile boolean f45932c;

        /* renamed from: f */
        volatile long f45935f;

        /* renamed from: g */
        long f45936g;

        /* renamed from: i */
        boolean f45938i;

        /* renamed from: j */
        boolean f45939j;

        /* renamed from: k */
        long f45940k;

        /* renamed from: l */
        long f45941l;

        /* renamed from: m */
        volatile Producer f45942m;

        /* renamed from: n */
        List<C15894i<T>> f45943n;

        /* renamed from: o */
        boolean f45944o;

        /* renamed from: d */
        final OpenHashSet<C15894i<T>> f45933d = new OpenHashSet<>();

        /* renamed from: e */
        C15894i<T>[] f45934e = f45928p;

        /* renamed from: h */
        final AtomicBoolean f45937h = new AtomicBoolean();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorReplay.java */
        /* renamed from: rx.internal.operators.t2$l$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15898a implements Action0 {
            C15898a() {
            }

            @Override // p640rx.functions.Action0
            public void call() {
                if (C15897l.this.f45932c) {
                    return;
                }
                synchronized (C15897l.this.f45933d) {
                    if (!C15897l.this.f45932c) {
                        C15897l.this.f45933d.m841h();
                        C15897l.this.f45935f++;
                        C15897l.this.f45932c = true;
                    }
                }
            }
        }

        public C15897l(InterfaceC15896k<T> interfaceC15896k) {
            this.f45930a = interfaceC15896k;
            request(0L);
        }

        /* renamed from: F */
        boolean m1070F(C15894i<T> c15894i) {
            c15894i.getClass();
            if (this.f45932c) {
                return false;
            }
            synchronized (this.f45933d) {
                if (this.f45932c) {
                    return false;
                }
                this.f45933d.m848a(c15894i);
                this.f45935f++;
                return true;
            }
        }

        /* renamed from: G */
        C15894i<T>[] m1069G() {
            C15894i<T>[] c15894iArr;
            synchronized (this.f45933d) {
                C15894i<T>[] m840i = this.f45933d.m840i();
                int length = m840i.length;
                c15894iArr = new C15894i[length];
                System.arraycopy(m840i, 0, c15894iArr, 0, length);
            }
            return c15894iArr;
        }

        /* renamed from: H */
        void m1068H() {
            add(Subscriptions.m346a(new C15898a()));
        }

        /* renamed from: I */
        void m1067I(long j, long j2) {
            long j3 = this.f45941l;
            Producer producer = this.f45942m;
            long j4 = j - j2;
            if (j4 == 0) {
                if (j3 == 0 || producer == null) {
                    return;
                }
                this.f45941l = 0L;
                producer.request(j3);
                return;
            }
            this.f45940k = j;
            if (producer == null) {
                long j5 = j3 + j4;
                if (j5 < 0) {
                    j5 = Long.MAX_VALUE;
                }
                this.f45941l = j5;
            } else if (j3 != 0) {
                this.f45941l = 0L;
                producer.request(j3 + j4);
            } else {
                producer.request(j4);
            }
        }

        /* renamed from: J */
        void m1066J(C15894i<T> c15894i) {
            C15894i<T>[] m1069G;
            long j;
            List<C15894i<T>> list;
            boolean z;
            long j2;
            C15894i<T>[] m1069G2;
            if (isUnsubscribed()) {
                return;
            }
            synchronized (this) {
                if (this.f45938i) {
                    if (c15894i != null) {
                        List list2 = this.f45943n;
                        if (list2 == null) {
                            list2 = new ArrayList();
                            this.f45943n = list2;
                        }
                        list2.add(c15894i);
                    } else {
                        this.f45944o = true;
                    }
                    this.f45939j = true;
                    return;
                }
                this.f45938i = true;
                long j3 = this.f45940k;
                if (c15894i != null) {
                    j = Math.max(j3, c15894i.f45923d.get());
                } else {
                    long j4 = j3;
                    for (C15894i<T> c15894i2 : m1069G()) {
                        if (c15894i2 != null) {
                            j4 = Math.max(j4, c15894i2.f45923d.get());
                        }
                    }
                    j = j4;
                }
                m1067I(j, j3);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.f45939j) {
                            this.f45938i = false;
                            return;
                        }
                        this.f45939j = false;
                        list = this.f45943n;
                        this.f45943n = null;
                        z = this.f45944o;
                        this.f45944o = false;
                    }
                    long j5 = this.f45940k;
                    if (list != null) {
                        j2 = j5;
                        for (C15894i<T> c15894i3 : list) {
                            j2 = Math.max(j2, c15894i3.f45923d.get());
                        }
                    } else {
                        j2 = j5;
                    }
                    if (z) {
                        for (C15894i<T> c15894i4 : m1069G()) {
                            if (c15894i4 != null) {
                                j2 = Math.max(j2, c15894i4.f45923d.get());
                            }
                        }
                    }
                    m1067I(j2, j5);
                }
            }
        }

        /* renamed from: K */
        void m1065K(C15894i<T> c15894i) {
            if (this.f45932c) {
                return;
            }
            synchronized (this.f45933d) {
                if (this.f45932c) {
                    return;
                }
                this.f45933d.m843f(c15894i);
                if (this.f45933d.m846c()) {
                    this.f45934e = f45928p;
                }
                this.f45935f++;
            }
        }

        /* renamed from: L */
        void m1064L() {
            C15894i<T>[] c15894iArr = this.f45934e;
            if (this.f45936g != this.f45935f) {
                synchronized (this.f45933d) {
                    c15894iArr = this.f45934e;
                    C15894i<T>[] m840i = this.f45933d.m840i();
                    int length = m840i.length;
                    if (c15894iArr.length != length) {
                        c15894iArr = new C15894i[length];
                        this.f45934e = c15894iArr;
                    }
                    System.arraycopy(m840i, 0, c15894iArr, 0, length);
                    this.f45936g = this.f45935f;
                }
            }
            InterfaceC15896k<T> interfaceC15896k = this.f45930a;
            for (C15894i<T> c15894i : c15894iArr) {
                if (c15894i != null) {
                    interfaceC15896k.mo1058a(c15894i);
                }
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45931b) {
                return;
            }
            this.f45931b = true;
            try {
                this.f45930a.complete();
                m1064L();
            } finally {
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45931b) {
                return;
            }
            this.f45931b = true;
            try {
                this.f45930a.error(th);
                m1064L();
            } finally {
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45931b) {
                return;
            }
            this.f45930a.next(t);
            m1064L();
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            if (this.f45942m == null) {
                this.f45942m = producer;
                m1066J(null);
                m1064L();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$m */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15899m<T> extends C15893h<T> {
        private static final long serialVersionUID = 3457957419649567404L;

        /* renamed from: d */
        final Scheduler f45946d;

        /* renamed from: e */
        final long f45947e;

        /* renamed from: f */
        final int f45948f;

        public C15899m(int i, long j, Scheduler scheduler) {
            this.f45946d = scheduler;
            this.f45948f = i;
            this.f45947e = j;
        }

        @Override // p640rx.internal.operators.OperatorReplay.C15893h
        /* renamed from: d */
        Object mo1063d(Object obj) {
            return new Timestamped(this.f45946d.mo462b(), obj);
        }

        @Override // p640rx.internal.operators.OperatorReplay.C15893h
        /* renamed from: e */
        C15895j mo1062e() {
            C15895j c15895j;
            long mo462b = this.f45946d.mo462b() - this.f45947e;
            C15895j c15895j2 = get();
            C15895j c15895j3 = c15895j2.get();
            while (true) {
                C15895j c15895j4 = c15895j3;
                c15895j = c15895j2;
                c15895j2 = c15895j4;
                if (c15895j2 == null) {
                    break;
                }
                Object obj = c15895j2.f45926a;
                Object mo1061h = mo1061h(obj);
                if (NotificationLite.m1047f(mo1061h) || NotificationLite.m1046g(mo1061h) || ((Timestamped) obj).m452a() > mo462b) {
                    break;
                }
                c15895j3 = c15895j2.get();
            }
            return c15895j;
        }

        @Override // p640rx.internal.operators.OperatorReplay.C15893h
        /* renamed from: h */
        Object mo1061h(Object obj) {
            return ((Timestamped) obj).m451b();
        }

        @Override // p640rx.internal.operators.OperatorReplay.C15893h
        /* renamed from: l */
        void mo1059l() {
            C15895j c15895j;
            long mo462b = this.f45946d.mo462b() - this.f45947e;
            C15895j c15895j2 = get();
            C15895j c15895j3 = c15895j2.get();
            int i = 0;
            while (true) {
                C15895j c15895j4 = c15895j3;
                c15895j = c15895j2;
                c15895j2 = c15895j4;
                if (c15895j2 != null) {
                    int i2 = this.f45917b;
                    if (i2 > this.f45948f) {
                        i++;
                        this.f45917b = i2 - 1;
                        c15895j3 = c15895j2.get();
                    } else if (((Timestamped) c15895j2.f45926a).m452a() > mo462b) {
                        break;
                    } else {
                        i++;
                        this.f45917b--;
                        c15895j3 = c15895j2.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                m1074k(c15895j);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
            m1074k(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
            return;
         */
        @Override // p640rx.internal.operators.OperatorReplay.C15893h
        /* renamed from: m */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void mo1060m() {
            /*
                r10 = this;
                rx.h r0 = r10.f45946d
                long r0 = r0.mo462b()
                long r2 = r10.f45947e
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                rx.internal.operators.t2$j r2 = (p640rx.internal.operators.OperatorReplay.C15895j) r2
                java.lang.Object r3 = r2.get()
                rx.internal.operators.t2$j r3 = (p640rx.internal.operators.OperatorReplay.C15895j) r3
                r4 = 0
            L16:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L3a
                int r5 = r10.f45917b
                r6 = 1
                if (r5 <= r6) goto L3a
                java.lang.Object r5 = r2.f45926a
                rx.schedulers.f r5 = (p640rx.schedulers.Timestamped) r5
                long r7 = r5.m452a()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L3a
                int r4 = r4 + 1
                int r3 = r10.f45917b
                int r3 = r3 - r6
                r10.f45917b = r3
                java.lang.Object r3 = r2.get()
                rx.internal.operators.t2$j r3 = (p640rx.internal.operators.OperatorReplay.C15895j) r3
                goto L16
            L3a:
                if (r4 == 0) goto L3f
                r10.m1074k(r3)
            L3f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p640rx.internal.operators.OperatorReplay.C15899m.mo1060m():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$n */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15900n<T> extends C15893h<T> {
        private static final long serialVersionUID = -5898283885385201806L;

        /* renamed from: d */
        final int f45949d;

        public C15900n(int i) {
            this.f45949d = i;
        }

        @Override // p640rx.internal.operators.OperatorReplay.C15893h
        /* renamed from: l */
        void mo1059l() {
            if (this.f45917b > this.f45949d) {
                m1076i();
            }
        }
    }

    /* compiled from: OperatorReplay.java */
    /* renamed from: rx.internal.operators.t2$o */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15901o<T> extends ArrayList<Object> implements InterfaceC15896k<T> {
        private static final long serialVersionUID = 7063189396499112664L;

        /* renamed from: a */
        volatile int f45950a;

        public C15901o(int i) {
            super(i);
        }

        @Override // p640rx.internal.operators.OperatorReplay.InterfaceC15896k
        /* renamed from: a */
        public void mo1058a(C15894i<T> c15894i) {
            synchronized (c15894i) {
                if (c15894i.f45924e) {
                    c15894i.f45925f = true;
                    return;
                }
                c15894i.f45924e = true;
                while (!c15894i.isUnsubscribed()) {
                    int i = this.f45950a;
                    Integer num = (Integer) c15894i.m1072b();
                    int intValue = num != null ? num.intValue() : 0;
                    Subscriber<? super T> subscriber = c15894i.f45921b;
                    if (subscriber == null) {
                        return;
                    }
                    long j = c15894i.get();
                    long j2 = 0;
                    while (j2 != j && intValue < i) {
                        Object obj = get(intValue);
                        try {
                            if (NotificationLite.m1052a(subscriber, obj) || c15894i.isUnsubscribed()) {
                                return;
                            }
                            intValue++;
                            j2++;
                        } catch (Throwable th) {
                            C15575a.m1474e(th);
                            c15894i.unsubscribe();
                            if (NotificationLite.m1046g(obj) || NotificationLite.m1047f(obj)) {
                                return;
                            }
                            subscriber.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.m1048e(obj)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        c15894i.f45922c = Integer.valueOf(intValue);
                        if (j != Long.MAX_VALUE) {
                            c15894i.m1071d(j2);
                        }
                    }
                    synchronized (c15894i) {
                        if (!c15894i.f45925f) {
                            c15894i.f45924e = false;
                            return;
                        }
                        c15894i.f45925f = false;
                    }
                }
            }
        }

        @Override // p640rx.internal.operators.OperatorReplay.InterfaceC15896k
        public void complete() {
            add(NotificationLite.m1051b());
            this.f45950a++;
        }

        @Override // p640rx.internal.operators.OperatorReplay.InterfaceC15896k
        public void error(Throwable th) {
            add(NotificationLite.m1050c(th));
            this.f45950a++;
        }

        @Override // p640rx.internal.operators.OperatorReplay.InterfaceC15896k
        public void next(T t) {
            add(NotificationLite.m1043j(t));
            this.f45950a++;
        }
    }

    private OperatorReplay(Observable.InterfaceC15567a<T> interfaceC15567a, Observable<? extends T> observable, AtomicReference<C15897l<T>> atomicReference, Func0<? extends InterfaceC15896k<T>> func0) {
        super(interfaceC15567a);
        this.f45899b = observable;
        this.f45900c = atomicReference;
        this.f45901d = func0;
    }

    /* renamed from: B7 */
    public static <T> ConnectableObservable<T> m1087B7(Observable<? extends T> observable) {
        return m1083F7(observable, f45898e);
    }

    /* renamed from: C7 */
    public static <T> ConnectableObservable<T> m1086C7(Observable<? extends T> observable, int i) {
        if (i == Integer.MAX_VALUE) {
            return m1087B7(observable);
        }
        return m1083F7(observable, new C15890e(i));
    }

    /* renamed from: D7 */
    public static <T> ConnectableObservable<T> m1085D7(Observable<? extends T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1084E7(observable, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    /* renamed from: E7 */
    public static <T> ConnectableObservable<T> m1084E7(Observable<? extends T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return m1083F7(observable, new C15891f(i, timeUnit.toMillis(j), scheduler));
    }

    /* renamed from: F7 */
    static <T> ConnectableObservable<T> m1083F7(Observable<? extends T> observable, Func0<? extends InterfaceC15896k<T>> func0) {
        AtomicReference atomicReference = new AtomicReference();
        return new OperatorReplay(new C15892g(atomicReference, func0), observable, atomicReference, func0);
    }

    /* renamed from: G7 */
    public static <T, U, R> Observable<R> m1082G7(Func0<? extends ConnectableObservable<U>> func0, Func1<? super Observable<U>, ? extends Observable<R>> func1) {
        return Observable.m1830H6(new C15885b(func0, func1));
    }

    /* renamed from: H7 */
    public static <T> ConnectableObservable<T> m1081H7(ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        return new C15889d(new C15887c(connectableObservable.m1833H3(scheduler)), connectableObservable);
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        C15897l<T> c15897l = this.f45900c.get();
        return c15897l == null || c15897l.isUnsubscribed();
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        this.f45900c.lazySet(null);
    }

    @Override // p640rx.observables.ConnectableObservable
    /* renamed from: z7 */
    public void mo692z7(Action1<? super Subscription> action1) {
        C15897l<T> c15897l;
        while (true) {
            c15897l = this.f45900c.get();
            if (c15897l != null && !c15897l.isUnsubscribed()) {
                break;
            }
            C15897l<T> c15897l2 = new C15897l<>(this.f45901d.call());
            c15897l2.m1068H();
            if (this.f45900c.compareAndSet(c15897l, c15897l2)) {
                c15897l = c15897l2;
                break;
            }
        }
        boolean z = true;
        z = (c15897l.f45937h.get() || !c15897l.f45937h.compareAndSet(false, true)) ? false : false;
        action1.call(c15897l);
        if (z) {
            this.f45899b.m1822I6(c15897l);
        }
    }
}
