package p640rx.internal.util;

import java.util.List;
import java.util.concurrent.TimeUnit;
import p640rx.Notification;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.exceptions.OnErrorNotImplementedException;
import p640rx.functions.Action1;
import p640rx.functions.Action2;
import p640rx.functions.Func0;
import p640rx.functions.Func1;
import p640rx.functions.Func2;
import p640rx.internal.operators.OperatorAny;
import p640rx.observables.ConnectableObservable;

/* renamed from: rx.internal.util.InternalObservableUtils */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public enum InternalObservableUtils {
    ;
    
    public static final C16036h LONG_COUNTER = new C16036h();
    public static final C16034f OBJECT_EQUALS = new C16034f();
    public static final C16045q TO_ARRAY = new C16045q();
    static final C16043o RETURNS_VOID = new C16043o();
    public static final C16035g COUNTER = new C16035g();
    static final C16033e ERROR_EXTRACTOR = new C16033e();
    public static final Action1<Throwable> ERROR_NOT_IMPLEMENTED = new Action1<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        @Override // p640rx.functions.Action1
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final Observable.InterfaceC15568b<Boolean, Object> IS_EMPTY = new OperatorAny(UtilityFunctions.m804b(), true);

    /* renamed from: rx.internal.util.InternalObservableUtils$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16029a<T, R> implements Func2<R, T, R> {

        /* renamed from: a */
        final Action2<R, ? super T> f46430a;

        public C16029a(Action2<R, ? super T> action2) {
            this.f46430a = action2;
        }

        @Override // p640rx.functions.Func2
        public R call(R r, T t) {
            this.f46430a.call(r, t);
            return r;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16030b implements Func1<Object, Boolean> {

        /* renamed from: a */
        final Object f46431a;

        public C16030b(Object obj) {
            this.f46431a = obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p640rx.functions.Func1
        public Boolean call(Object obj) {
            Object obj2 = this.f46431a;
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16032d implements Func1<Object, Boolean> {

        /* renamed from: a */
        final Class<?> f46432a;

        public C16032d(Class<?> cls) {
            this.f46432a = cls;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p640rx.functions.Func1
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.f46432a.isInstance(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16033e implements Func1<Notification<?>, Throwable> {
        C16033e() {
        }

        @Override // p640rx.functions.Func1
        public Throwable call(Notification<?> notification) {
            return notification.m2000g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16034f implements Func2<Object, Object, Boolean> {
        C16034f() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p640rx.functions.Func2
        public Boolean call(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16035g implements Func2<Integer, Object, Integer> {
        C16035g() {
        }

        @Override // p640rx.functions.Func2
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16036h implements Func2<Long, Object, Long> {
        C16036h() {
        }

        @Override // p640rx.functions.Func2
        public Long call(Long l, Object obj) {
            return Long.valueOf(l.longValue() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16037i implements Func1<Observable<? extends Notification<?>>, Observable<?>> {

        /* renamed from: a */
        final Func1<? super Observable<? extends Void>, ? extends Observable<?>> f46433a;

        public C16037i(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
            this.f46433a = func1;
        }

        @Override // p640rx.functions.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return this.f46433a.call(observable.m1674b3(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16038j<T> implements Func0<ConnectableObservable<T>> {

        /* renamed from: a */
        private final Observable<T> f46434a;

        /* renamed from: b */
        private final int f46435b;

        C16038j(Observable<T> observable, int i) {
            this.f46434a = observable;
            this.f46435b = i;
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.f46434a.m1520u4(this.f46435b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$k */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16039k<T> implements Func0<ConnectableObservable<T>> {

        /* renamed from: a */
        private final TimeUnit f46436a;

        /* renamed from: b */
        private final Observable<T> f46437b;

        /* renamed from: c */
        private final long f46438c;

        /* renamed from: d */
        private final Scheduler f46439d;

        C16039k(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f46436a = timeUnit;
            this.f46437b = observable;
            this.f46438c = j;
            this.f46439d = scheduler;
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.f46437b.m1484z4(this.f46438c, this.f46436a, this.f46439d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$l */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16040l<T> implements Func0<ConnectableObservable<T>> {

        /* renamed from: a */
        private final Observable<T> f46440a;

        C16040l(Observable<T> observable) {
            this.f46440a = observable;
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.f46440a.m1528t4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$m */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16041m<T> implements Func0<ConnectableObservable<T>> {

        /* renamed from: a */
        private final long f46441a;

        /* renamed from: b */
        private final TimeUnit f46442b;

        /* renamed from: c */
        private final Scheduler f46443c;

        /* renamed from: d */
        private final int f46444d;

        /* renamed from: e */
        private final Observable<T> f46445e;

        C16041m(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f46441a = j;
            this.f46442b = timeUnit;
            this.f46443c = scheduler;
            this.f46444d = i;
            this.f46445e = observable;
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.f46445e.m1505w4(this.f46444d, this.f46441a, this.f46442b, this.f46443c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$n */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16042n implements Func1<Observable<? extends Notification<?>>, Observable<?>> {

        /* renamed from: a */
        final Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> f46446a;

        public C16042n(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
            this.f46446a = func1;
        }

        @Override // p640rx.functions.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return this.f46446a.call(observable.m1674b3(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$o */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16043o implements Func1<Object, Void> {
        C16043o() {
        }

        @Override // p640rx.functions.Func1
        public Void call(Object obj) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$p */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16044p<T, R> implements Func1<Observable<T>, Observable<R>> {

        /* renamed from: a */
        final Func1<? super Observable<T>, ? extends Observable<R>> f46447a;

        /* renamed from: b */
        final Scheduler f46448b;

        public C16044p(Func1<? super Observable<T>, ? extends Observable<R>> func1, Scheduler scheduler) {
            this.f46447a = func1;
            this.f46448b = scheduler;
        }

        @Override // p640rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Observable) ((Observable) obj));
        }

        public Observable<R> call(Observable<T> observable) {
            return this.f46447a.call(observable).m1833H3(this.f46448b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.util.InternalObservableUtils$q */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16045q implements Func1<List<? extends Observable<?>>, Observable<?>[]> {
        C16045q() {
        }

        @Override // p640rx.functions.Func1
        public Observable<?>[] call(List<? extends Observable<?>> list) {
            return (Observable[]) list.toArray(new Observable[list.size()]);
        }
    }

    public static <T, R> Func2<R, T, R> createCollectorCaller(Action2<R, ? super T> action2) {
        return new C16029a(action2);
    }

    public static Func1<Observable<? extends Notification<?>>, Observable<?>> createRepeatDematerializer(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
        return new C16037i(func1);
    }

    public static <T, R> Func1<Observable<T>, Observable<R>> createReplaySelectorAndObserveOn(Func1<? super Observable<T>, ? extends Observable<R>> func1, Scheduler scheduler) {
        return new C16044p(func1, scheduler);
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> observable) {
        return new C16040l(observable);
    }

    public static Func1<Observable<? extends Notification<?>>, Observable<?>> createRetryDematerializer(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        return new C16042n(func1);
    }

    public static Func1<Object, Boolean> equalsWith(Object obj) {
        return new C16030b(obj);
    }

    public static Func1<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new C16032d(cls);
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> observable, int i) {
        return new C16038j(observable, i);
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new C16039k(observable, j, timeUnit, scheduler);
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new C16041m(observable, i, j, timeUnit, scheduler);
    }
}
