package p640rx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p603i2.AssertableSubscriberObservable;
import p640rx.BackpressureOverflow;
import p640rx.Emitter;
import p640rx.annotations.Beta;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.OnErrorFailedException;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Action2;
import p640rx.functions.Actions;
import p640rx.functions.C15576a0;
import p640rx.functions.Func0;
import p640rx.functions.Func1;
import p640rx.functions.Func2;
import p640rx.functions.Func3;
import p640rx.functions.Func4;
import p640rx.functions.Func5;
import p640rx.functions.Func6;
import p640rx.functions.Func7;
import p640rx.functions.Func8;
import p640rx.functions.Func9;
import p640rx.functions.FuncN;
import p640rx.internal.operators.CachedObservable;
import p640rx.internal.operators.EmptyObservableHolder;
import p640rx.internal.operators.NeverObservableHolder;
import p640rx.internal.operators.OnSubscribeAmb;
import p640rx.internal.operators.OnSubscribeCollect;
import p640rx.internal.operators.OnSubscribeCombineLatest;
import p640rx.internal.operators.OnSubscribeConcatMap;
import p640rx.internal.operators.OnSubscribeCreate;
import p640rx.internal.operators.OnSubscribeDefer;
import p640rx.internal.operators.OnSubscribeDelaySubscription;
import p640rx.internal.operators.OnSubscribeDelaySubscriptionOther;
import p640rx.internal.operators.OnSubscribeDelaySubscriptionWithSelector;
import p640rx.internal.operators.OnSubscribeDetach;
import p640rx.internal.operators.OnSubscribeDoOnEach;
import p640rx.internal.operators.OnSubscribeFilter;
import p640rx.internal.operators.OnSubscribeFlatMapCompletable;
import p640rx.internal.operators.OnSubscribeFlatMapSingle;
import p640rx.internal.operators.OnSubscribeFlattenIterable;
import p640rx.internal.operators.OnSubscribeFromArray;
import p640rx.internal.operators.OnSubscribeFromCallable;
import p640rx.internal.operators.OnSubscribeFromIterable;
import p640rx.internal.operators.OnSubscribeGroupJoin;
import p640rx.internal.operators.OnSubscribeJoin;
import p640rx.internal.operators.OnSubscribeLift;
import p640rx.internal.operators.OnSubscribeMap;
import p640rx.internal.operators.OnSubscribeRange;
import p640rx.internal.operators.OnSubscribeRedo;
import p640rx.internal.operators.OnSubscribeReduce;
import p640rx.internal.operators.OnSubscribeReduceSeed;
import p640rx.internal.operators.OnSubscribeSingle;
import p640rx.internal.operators.OnSubscribeSkipTimed;
import p640rx.internal.operators.OnSubscribeSwitchIfEmpty;
import p640rx.internal.operators.OnSubscribeTakeLastOne;
import p640rx.internal.operators.OnSubscribeThrow;
import p640rx.internal.operators.OnSubscribeTimerOnce;
import p640rx.internal.operators.OnSubscribeTimerPeriodically;
import p640rx.internal.operators.OnSubscribeToMap;
import p640rx.internal.operators.OnSubscribeToMultimap;
import p640rx.internal.operators.OnSubscribeToObservableFuture;
import p640rx.internal.operators.OnSubscribeUsing;
import p640rx.internal.operators.OperatorAll;
import p640rx.internal.operators.OperatorAny;
import p640rx.internal.operators.OperatorAsObservable;
import p640rx.internal.operators.OperatorBufferWithSingleObservable;
import p640rx.internal.operators.OperatorBufferWithSize;
import p640rx.internal.operators.OperatorBufferWithStartEndObservable;
import p640rx.internal.operators.OperatorBufferWithTime;
import p640rx.internal.operators.OperatorCast;
import p640rx.internal.operators.OperatorDebounceWithSelector;
import p640rx.internal.operators.OperatorDebounceWithTime;
import p640rx.internal.operators.OperatorDelay;
import p640rx.internal.operators.OperatorDelayWithSelector;
import p640rx.internal.operators.OperatorDematerialize;
import p640rx.internal.operators.OperatorDistinct;
import p640rx.internal.operators.OperatorDistinctUntilChanged;
import p640rx.internal.operators.OperatorDoAfterTerminate;
import p640rx.internal.operators.OperatorDoOnRequest;
import p640rx.internal.operators.OperatorDoOnSubscribe;
import p640rx.internal.operators.OperatorDoOnUnsubscribe;
import p640rx.internal.operators.OperatorEagerConcatMap;
import p640rx.internal.operators.OperatorElementAt;
import p640rx.internal.operators.OperatorGroupBy;
import p640rx.internal.operators.OperatorIgnoreElements;
import p640rx.internal.operators.OperatorMapNotification;
import p640rx.internal.operators.OperatorMapPair;
import p640rx.internal.operators.OperatorMaterialize;
import p640rx.internal.operators.OperatorMerge;
import p640rx.internal.operators.OperatorObserveOn;
import p640rx.internal.operators.OperatorOnBackpressureBuffer;
import p640rx.internal.operators.OperatorOnBackpressureDrop;
import p640rx.internal.operators.OperatorOnBackpressureLatest;
import p640rx.internal.operators.OperatorOnErrorResumeNextViaFunction;
import p640rx.internal.operators.OperatorPublish;
import p640rx.internal.operators.OperatorReplay;
import p640rx.internal.operators.OperatorRetryWithPredicate;
import p640rx.internal.operators.OperatorSampleWithObservable;
import p640rx.internal.operators.OperatorSampleWithTime;
import p640rx.internal.operators.OperatorScan;
import p640rx.internal.operators.OperatorSequenceEqual;
import p640rx.internal.operators.OperatorSerialize;
import p640rx.internal.operators.OperatorSingle;
import p640rx.internal.operators.OperatorSkip;
import p640rx.internal.operators.OperatorSkipLast;
import p640rx.internal.operators.OperatorSkipLastTimed;
import p640rx.internal.operators.OperatorSkipUntil;
import p640rx.internal.operators.OperatorSkipWhile;
import p640rx.internal.operators.OperatorSubscribeOn;
import p640rx.internal.operators.OperatorSwitch;
import p640rx.internal.operators.OperatorTake;
import p640rx.internal.operators.OperatorTakeLast;
import p640rx.internal.operators.OperatorTakeLastTimed;
import p640rx.internal.operators.OperatorTakeTimed;
import p640rx.internal.operators.OperatorTakeUntil;
import p640rx.internal.operators.OperatorTakeUntilPredicate;
import p640rx.internal.operators.OperatorTakeWhile;
import p640rx.internal.operators.OperatorThrottleFirst;
import p640rx.internal.operators.OperatorTimeInterval;
import p640rx.internal.operators.OperatorTimeout;
import p640rx.internal.operators.OperatorTimeoutWithSelector;
import p640rx.internal.operators.OperatorTimestamp;
import p640rx.internal.operators.OperatorToObservableList;
import p640rx.internal.operators.OperatorToObservableSortedList;
import p640rx.internal.operators.OperatorUnsubscribeOn;
import p640rx.internal.operators.OperatorWindowWithObservable;
import p640rx.internal.operators.OperatorWindowWithObservableFactory;
import p640rx.internal.operators.OperatorWindowWithSize;
import p640rx.internal.operators.OperatorWindowWithStartEndObservable;
import p640rx.internal.operators.OperatorWindowWithTime;
import p640rx.internal.operators.OperatorWithLatestFrom;
import p640rx.internal.operators.OperatorWithLatestFromMany;
import p640rx.internal.operators.OperatorZip;
import p640rx.internal.operators.OperatorZipIterable;
import p640rx.internal.util.ActionNotificationObserver;
import p640rx.internal.util.ActionObserver;
import p640rx.internal.util.ActionSubscriber;
import p640rx.internal.util.InternalObservableUtils;
import p640rx.internal.util.ObserverSubscriber;
import p640rx.internal.util.RxRingBuffer;
import p640rx.internal.util.ScalarSynchronousObservable;
import p640rx.internal.util.UtilityFunctions;
import p640rx.observables.AsyncOnSubscribe;
import p640rx.observables.BlockingObservable;
import p640rx.observables.ConnectableObservable;
import p640rx.observables.GroupedObservable;
import p640rx.observables.SyncOnSubscribe;
import p640rx.observers.AssertableSubscriber;
import p640rx.observers.SafeSubscriber;
import p640rx.plugins.RxJavaHooks;
import p640rx.schedulers.Schedulers;
import p640rx.schedulers.TimeInterval;
import p640rx.schedulers.Timestamped;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Observable<T> {

    /* renamed from: a */
    final InterfaceC15567a<T> f44784a;

    /* compiled from: Observable.java */
    /* renamed from: rx.e$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15567a<T> extends Action1<Subscriber<? super T>> {
    }

    /* compiled from: Observable.java */
    /* renamed from: rx.e$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15568b<R, T> extends Func1<Subscriber<? super R>, Subscriber<? super T>> {
    }

    /* compiled from: Observable.java */
    /* renamed from: rx.e$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15569c<T, R> extends Func1<Observable<T>, Observable<R>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Observable(InterfaceC15567a<T> interfaceC15567a) {
        this.f44784a = interfaceC15567a;
    }

    /* renamed from: A0 */
    public static <T> Observable<T> m1888A0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return m1524u0(m1754R2(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    /* renamed from: A3 */
    public static <T> Observable<T> m1885A3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return m1521u3(m1762Q2(observable, observable2, observable3, observable4, observable5, observable6));
    }

    /* renamed from: A5 */
    public static <T> Observable<T> m1883A5(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.m1690Z2(OperatorSwitch.m1228a(false));
    }

    /* renamed from: B0 */
    public static <T> Observable<T> m1881B0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return m1524u0(m1746S2(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    /* renamed from: B3 */
    public static <T> Observable<T> m1878B3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return m1521u3(m1754R2(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    /* renamed from: B5 */
    public static <T> Observable<T> m1876B5(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.m1690Z2(OperatorSwitch.m1228a(true));
    }

    /* renamed from: C0 */
    public static <T> Observable<T> m1874C0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return m1524u0(m1738T2(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    /* renamed from: C3 */
    public static <T> Observable<T> m1871C3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return m1521u3(m1746S2(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    /* renamed from: D0 */
    public static <T> Observable<T> m1867D0(Iterable<? extends Observable<? extends T>> iterable) {
        return m1860E0(m1522u2(iterable));
    }

    /* renamed from: D3 */
    public static <T> Observable<T> m1864D3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return m1521u3(m1738T2(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    /* renamed from: E0 */
    public static <T> Observable<T> m1860E0(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.m1684a1(UtilityFunctions.m803c());
    }

    /* renamed from: F */
    public static <T> Observable<T> m1853F(Iterable<? extends Observable<? extends T>> iterable) {
        return m1830H6(OnSubscribeAmb.m1038a(iterable));
    }

    /* renamed from: F0 */
    public static <T> Observable<T> m1852F0(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m1860E0(m1794M2(observable, observable2));
    }

    /* renamed from: F2 */
    public static Observable<Long> m1850F2(long j, long j2, TimeUnit timeUnit) {
        return m1842G2(j, j2, timeUnit, Schedulers.m479a());
    }

    /* renamed from: G */
    public static <T> Observable<T> m1845G(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m1830H6(OnSubscribeAmb.m1037b(observable, observable2));
    }

    /* renamed from: G0 */
    public static <T> Observable<T> m1844G0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return m1860E0(m1786N2(observable, observable2, observable3));
    }

    /* renamed from: G2 */
    public static Observable<Long> m1842G2(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return m1830H6(new OnSubscribeTimerPeriodically(j, j2, timeUnit, scheduler));
    }

    /* renamed from: G3 */
    public static <T> Observable<T> m1841G3() {
        return NeverObservableHolder.instance();
    }

    /* renamed from: H */
    public static <T> Observable<T> m1837H(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return m1830H6(OnSubscribeAmb.m1036c(observable, observable2, observable3));
    }

    /* renamed from: H0 */
    public static <T> Observable<T> m1836H0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return m1860E0(m1778O2(observable, observable2, observable3, observable4));
    }

    /* renamed from: H2 */
    public static Observable<Long> m1834H2(long j, TimeUnit timeUnit) {
        return m1842G2(j, j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: H6 */
    public static <T> Observable<T> m1830H6(InterfaceC15567a<T> interfaceC15567a) {
        return new Observable<>(RxJavaHooks.m578G(interfaceC15567a));
    }

    /* renamed from: I */
    public static <T> Observable<T> m1829I(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return m1830H6(OnSubscribeAmb.m1035d(observable, observable2, observable3, observable4));
    }

    /* renamed from: I0 */
    public static <T> Observable<T> m1828I0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return m1860E0(m1770P2(observable, observable2, observable3, observable4, observable5));
    }

    /* renamed from: I2 */
    public static Observable<Long> m1826I2(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1842G2(j, j, timeUnit, scheduler);
    }

    /* renamed from: J */
    public static <T> Observable<T> m1821J(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return m1830H6(OnSubscribeAmb.m1034e(observable, observable2, observable3, observable4, observable5));
    }

    /* renamed from: J0 */
    public static <T> Observable<T> m1820J0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return m1860E0(m1762Q2(observable, observable2, observable3, observable4, observable5, observable6));
    }

    /* renamed from: K */
    public static <T> Observable<T> m1813K(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return m1830H6(OnSubscribeAmb.m1033f(observable, observable2, observable3, observable4, observable5, observable6));
    }

    /* renamed from: K0 */
    public static <T> Observable<T> m1812K0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return m1860E0(m1754R2(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    /* renamed from: K6 */
    public static <T, Resource> Observable<T> m1806K6(Func0<Resource> func0, Func1<? super Resource, ? extends Observable<? extends T>> func1, Action1<? super Resource> action1) {
        return m1798L6(func0, func1, action1, false);
    }

    /* renamed from: L */
    public static <T> Observable<T> m1805L(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return m1830H6(OnSubscribeAmb.m1032g(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    /* renamed from: L0 */
    public static <T> Observable<T> m1804L0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return m1860E0(m1746S2(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    /* renamed from: L2 */
    public static <T> Observable<T> m1802L2(T t) {
        return ScalarSynchronousObservable.m819v7(t);
    }

    /* renamed from: L4 */
    public static <T> Observable<Boolean> m1800L4(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m1792M4(observable, observable2, InternalObservableUtils.OBJECT_EQUALS);
    }

    /* renamed from: L6 */
    public static <T, Resource> Observable<T> m1798L6(Func0<Resource> func0, Func1<? super Resource, ? extends Observable<? extends T>> func1, Action1<? super Resource> action1, boolean z) {
        return m1830H6(new OnSubscribeUsing(func0, func1, action1, z));
    }

    /* renamed from: M */
    public static <T> Observable<T> m1797M(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return m1830H6(OnSubscribeAmb.m1031h(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    /* renamed from: M0 */
    public static <T> Observable<T> m1796M0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return m1860E0(m1738T2(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    /* renamed from: M2 */
    public static <T> Observable<T> m1794M2(T t, T t2) {
        return m1493y2(new Object[]{t, t2});
    }

    /* renamed from: M4 */
    public static <T> Observable<Boolean> m1792M4(Observable<? extends T> observable, Observable<? extends T> observable2, Func2<? super T, ? super T, Boolean> func2) {
        return OperatorSequenceEqual.m991b(observable, observable2, func2);
    }

    /* renamed from: N */
    public static <T> Observable<T> m1789N(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return m1830H6(OnSubscribeAmb.m1030i(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    /* renamed from: N0 */
    public static <T> Observable<T> m1788N0(Iterable<? extends Observable<? extends T>> iterable) {
        return m1522u2(iterable).m1676b1(UtilityFunctions.m803c());
    }

    /* renamed from: N2 */
    public static <T> Observable<T> m1786N2(T t, T t2, T t3) {
        return m1493y2(new Object[]{t, t2, t3});
    }

    /* renamed from: O0 */
    public static <T> Observable<T> m1780O0(Iterable<? extends Observable<? extends T>> iterable, int i) {
        return m1522u2(iterable).m1668c1(UtilityFunctions.m803c(), i);
    }

    /* renamed from: O2 */
    public static <T> Observable<T> m1778O2(T t, T t2, T t3, T t4) {
        return m1493y2(new Object[]{t, t2, t3, t4});
    }

    /* renamed from: P0 */
    public static <T> Observable<T> m1772P0(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.m1676b1(UtilityFunctions.m803c());
    }

    /* renamed from: P2 */
    public static <T> Observable<T> m1770P2(T t, T t2, T t3, T t4, T t5) {
        return m1493y2(new Object[]{t, t2, t3, t4, t5});
    }

    /* renamed from: Q0 */
    public static <T> Observable<T> m1764Q0(Observable<? extends Observable<? extends T>> observable, int i) {
        return (Observable<T>) observable.m1668c1(UtilityFunctions.m803c(), i);
    }

    /* renamed from: Q2 */
    public static <T> Observable<T> m1762Q2(T t, T t2, T t3, T t4, T t5, T t6) {
        return m1493y2(new Object[]{t, t2, t3, t4, t5, t6});
    }

    /* renamed from: R0 */
    public static <T> Observable<T> m1756R0(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m1788N0(Arrays.asList(observable, observable2));
    }

    /* renamed from: R2 */
    public static <T> Observable<T> m1754R2(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        return m1493y2(new Object[]{t, t2, t3, t4, t5, t6, t7});
    }

    /* renamed from: S0 */
    public static <T> Observable<T> m1748S0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return m1788N0(Arrays.asList(observable, observable2, observable3));
    }

    /* renamed from: S1 */
    public static <T> Observable<T> m1747S1() {
        return EmptyObservableHolder.instance();
    }

    /* renamed from: S2 */
    public static <T> Observable<T> m1746S2(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        return m1493y2(new Object[]{t, t2, t3, t4, t5, t6, t7, t8});
    }

    /* renamed from: T0 */
    public static <T> Observable<T> m1740T0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return m1788N0(Arrays.asList(observable, observable2, observable3, observable4));
    }

    /* renamed from: T1 */
    public static <T> Observable<T> m1739T1(Throwable th) {
        return m1830H6(new OnSubscribeThrow(th));
    }

    /* renamed from: T2 */
    public static <T> Observable<T> m1738T2(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return m1493y2(new Object[]{t, t2, t3, t4, t5, t6, t7, t8, t9});
    }

    /* renamed from: U0 */
    public static <T> Observable<T> m1732U0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return m1788N0(Arrays.asList(observable, observable2, observable3, observable4, observable5));
    }

    /* renamed from: U2 */
    public static <T> Observable<T> m1730U2(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        return m1493y2(new Object[]{t, t2, t3, t4, t5, t6, t7, t8, t9, t10});
    }

    /* renamed from: V0 */
    public static <T> Observable<T> m1724V0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return m1788N0(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6));
    }

    /* renamed from: W0 */
    public static <T> Observable<T> m1716W0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return m1788N0(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    /* renamed from: X0 */
    public static <T> Observable<T> m1708X0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return m1788N0(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    /* renamed from: Y0 */
    public static <T> Observable<T> m1700Y0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return m1788N0(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    /* renamed from: a4 */
    public static Observable<Integer> m1681a4(int i, int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                return m1747S1();
            }
            if (i <= (Integer.MAX_VALUE - i2) + 1) {
                if (i2 == 1) {
                    return m1802L2(Integer.valueOf(i));
                }
                return m1830H6(new OnSubscribeRange(i, (i2 - 1) + i));
            }
            throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
        }
        throw new IllegalArgumentException("Count can not be negative");
    }

    /* renamed from: b4 */
    public static Observable<Integer> m1673b4(int i, int i2, Scheduler scheduler) {
        return m1681a4(i, i2).m1511v5(scheduler);
    }

    /* renamed from: c3 */
    private <R> Observable<R> m1666c3(Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
        return m1690Z2(new OperatorMapNotification(func1, func12, func0));
    }

    /* renamed from: e3 */
    public static <T> Observable<T> m1649e3(Iterable<? extends Observable<? extends T>> iterable) {
        return m1633g3(m1522u2(iterable));
    }

    /* renamed from: f3 */
    public static <T> Observable<T> m1641f3(Iterable<? extends Observable<? extends T>> iterable, int i) {
        return m1625h3(m1522u2(iterable), i);
    }

    /* renamed from: g3 */
    public static <T> Observable<T> m1633g3(Observable<? extends Observable<? extends T>> observable) {
        if (observable.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) observable).m816y7(UtilityFunctions.m803c());
        }
        return (Observable<T>) observable.m1690Z2(OperatorMerge.m1178a(false));
    }

    /* renamed from: h0 */
    public static <T, R> Observable<R> m1628h0(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        return m1830H6(new OnSubscribeCombineLatest(iterable, funcN));
    }

    /* renamed from: h3 */
    public static <T> Observable<T> m1625h3(Observable<? extends Observable<? extends T>> observable, int i) {
        if (observable.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) observable).m816y7(UtilityFunctions.m803c());
        }
        return (Observable<T>) observable.m1690Z2(OperatorMerge.m1177b(false, i));
    }

    /* renamed from: i0 */
    public static <T, R> Observable<R> m1620i0(List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN) {
        return m1830H6(new OnSubscribeCombineLatest(list, funcN));
    }

    /* renamed from: i3 */
    public static <T> Observable<T> m1617i3(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m1553q3(new Observable[]{observable, observable2});
    }

    /* renamed from: i7 */
    public static <R> Observable<R> m1613i7(Iterable<? extends Observable<?>> iterable, FuncN<? extends R> funcN) {
        ArrayList arrayList = new ArrayList();
        for (Observable<?> observable : iterable) {
            arrayList.add(observable);
        }
        return m1802L2(arrayList.toArray(new Observable[arrayList.size()])).m1690Z2(new OperatorZip(funcN));
    }

    /* renamed from: j0 */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> m1612j0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return m1620i0(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), C15576a0.m1456n(func9));
    }

    @Deprecated
    /* renamed from: j1 */
    public static <T> Observable<T> m1611j1(InterfaceC15567a<T> interfaceC15567a) {
        return new Observable<>(RxJavaHooks.m578G(interfaceC15567a));
    }

    /* renamed from: j3 */
    public static <T> Observable<T> m1609j3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return m1553q3(new Observable[]{observable, observable2, observable3});
    }

    /* renamed from: j7 */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> m1605j7(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return m1802L2(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9}).m1690Z2(new OperatorZip(func9));
    }

    /* renamed from: k0 */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> m1604k0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return m1620i0(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8), C15576a0.m1457m(func8));
    }

    /* renamed from: k1 */
    public static <T> Observable<T> m1603k1(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        return m1830H6(new OnSubscribeCreate(action1, backpressureMode));
    }

    /* renamed from: k3 */
    public static <T> Observable<T> m1601k3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return m1553q3(new Observable[]{observable, observable2, observable3, observable4});
    }

    /* renamed from: k7 */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> m1597k7(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return m1802L2(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8}).m1690Z2(new OperatorZip(func8));
    }

    /* renamed from: l0 */
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> m1596l0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return m1620i0(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7), C15576a0.m1458l(func7));
    }

    @Beta
    /* renamed from: l1 */
    public static <S, T> Observable<T> m1595l1(AsyncOnSubscribe<S, T> asyncOnSubscribe) {
        return m1830H6(asyncOnSubscribe);
    }

    /* renamed from: l3 */
    public static <T> Observable<T> m1593l3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return m1553q3(new Observable[]{observable, observable2, observable3, observable4, observable5});
    }

    @Deprecated
    /* renamed from: l6 */
    public static Observable<Long> m1590l6(long j, long j2, TimeUnit timeUnit) {
        return m1842G2(j, j2, timeUnit, Schedulers.m479a());
    }

    /* renamed from: l7 */
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> m1589l7(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return m1802L2(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7}).m1690Z2(new OperatorZip(func7));
    }

    /* renamed from: m0 */
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> m1588m0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return m1620i0(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6), C15576a0.m1459k(func6));
    }

    /* renamed from: m1 */
    public static <S, T> Observable<T> m1587m1(SyncOnSubscribe<S, T> syncOnSubscribe) {
        return m1830H6(syncOnSubscribe);
    }

    /* renamed from: m3 */
    public static <T> Observable<T> m1585m3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return m1553q3(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6});
    }

    @Deprecated
    /* renamed from: m6 */
    public static Observable<Long> m1582m6(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return m1842G2(j, j2, timeUnit, scheduler);
    }

    /* renamed from: m7 */
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> m1581m7(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return m1802L2(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6}).m1690Z2(new OperatorZip(func6));
    }

    /* renamed from: n0 */
    public static <T1, T2, T3, T4, T5, R> Observable<R> m1580n0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return m1620i0(Arrays.asList(observable, observable2, observable3, observable4, observable5), C15576a0.m1460j(func5));
    }

    /* renamed from: n3 */
    public static <T> Observable<T> m1577n3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return m1553q3(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7});
    }

    /* renamed from: n6 */
    public static Observable<Long> m1574n6(long j, TimeUnit timeUnit) {
        return m1566o6(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: n7 */
    public static <T1, T2, T3, T4, T5, R> Observable<R> m1573n7(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return m1802L2(new Observable[]{observable, observable2, observable3, observable4, observable5}).m1690Z2(new OperatorZip(func5));
    }

    /* renamed from: o0 */
    public static <T1, T2, T3, T4, R> Observable<R> m1572o0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return m1620i0(Arrays.asList(observable, observable2, observable3, observable4), C15576a0.m1461i(func4));
    }

    /* renamed from: o3 */
    public static <T> Observable<T> m1569o3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return m1553q3(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8});
    }

    /* renamed from: o6 */
    public static Observable<Long> m1566o6(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1830H6(new OnSubscribeTimerOnce(j, timeUnit, scheduler));
    }

    /* renamed from: o7 */
    public static <T1, T2, T3, T4, R> Observable<R> m1565o7(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return m1802L2(new Observable[]{observable, observable2, observable3, observable4}).m1690Z2(new OperatorZip(func4));
    }

    /* renamed from: p0 */
    public static <T1, T2, T3, R> Observable<R> m1564p0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return m1620i0(Arrays.asList(observable, observable2, observable3), C15576a0.m1462h(func3));
    }

    /* renamed from: p3 */
    public static <T> Observable<T> m1561p3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return m1553q3(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9});
    }

    /* renamed from: p7 */
    public static <T1, T2, T3, R> Observable<R> m1557p7(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return m1802L2(new Observable[]{observable, observable2, observable3}).m1690Z2(new OperatorZip(func3));
    }

    /* renamed from: q0 */
    public static <T1, T2, R> Observable<R> m1556q0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return m1620i0(Arrays.asList(observable, observable2), C15576a0.m1463g(func2));
    }

    /* renamed from: q3 */
    public static <T> Observable<T> m1553q3(Observable<? extends T>[] observableArr) {
        return m1633g3(m1493y2(observableArr));
    }

    /* renamed from: q7 */
    public static <T1, T2, R> Observable<R> m1549q7(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return m1802L2(new Observable[]{observable, observable2}).m1690Z2(new OperatorZip(func2));
    }

    /* renamed from: r0 */
    public static <T, R> Observable<R> m1548r0(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        return m1830H6(new OnSubscribeCombineLatest(null, iterable, funcN, RxRingBuffer.f46509d, true));
    }

    /* renamed from: r1 */
    public static <T> Observable<T> m1547r1(Func0<Observable<T>> func0) {
        return m1830H6(new OnSubscribeDefer(func0));
    }

    /* renamed from: r3 */
    public static <T> Observable<T> m1545r3(Observable<? extends T>[] observableArr, int i) {
        return m1625h3(m1493y2(observableArr), i);
    }

    /* renamed from: r5 */
    static <T> Subscription m1543r5(Subscriber<? super T> subscriber, Observable<T> observable) {
        if (subscriber != null) {
            if (observable.f44784a != null) {
                subscriber.onStart();
                if (!(subscriber instanceof SafeSubscriber)) {
                    subscriber = new SafeSubscriber(subscriber);
                }
                try {
                    RxJavaHooks.m570O(observable, observable.f44784a).call(subscriber);
                    return RxJavaHooks.m571N(subscriber);
                } catch (Throwable th) {
                    C15575a.m1474e(th);
                    if (subscriber.isUnsubscribed()) {
                        RxJavaHooks.m576I(RxJavaHooks.m573L(th));
                    } else {
                        try {
                            subscriber.onError(RxJavaHooks.m573L(th));
                        } catch (Throwable th2) {
                            C15575a.m1474e(th2);
                            OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                            RxJavaHooks.m573L(onErrorFailedException);
                            throw onErrorFailedException;
                        }
                    }
                    return Subscriptions.m342e();
                }
            }
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        throw new IllegalArgumentException("subscriber can not be null");
    }

    /* renamed from: r7 */
    public static <R> Observable<R> m1541r7(Observable<? extends Observable<?>> observable, FuncN<? extends R> funcN) {
        return observable.m1518u6().m1674b3(InternalObservableUtils.TO_ARRAY).m1690Z2(new OperatorZip(funcN));
    }

    /* renamed from: s3 */
    public static <T> Observable<T> m1537s3(Iterable<? extends Observable<? extends T>> iterable) {
        return m1521u3(m1522u2(iterable));
    }

    /* renamed from: s7 */
    public static <R> Observable<R> m1533s7(Observable<?>[] observableArr, FuncN<? extends R> funcN) {
        return m1802L2(observableArr).m1690Z2(new OperatorZip(funcN));
    }

    /* renamed from: t0 */
    public static <T> Observable<T> m1532t0(Iterable<? extends Observable<? extends T>> iterable) {
        return m1524u0(m1522u2(iterable));
    }

    /* renamed from: t3 */
    public static <T> Observable<T> m1529t3(Iterable<? extends Observable<? extends T>> iterable, int i) {
        return m1513v3(m1522u2(iterable), i);
    }

    /* renamed from: u0 */
    public static <T> Observable<T> m1524u0(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.m1692Z0(UtilityFunctions.m803c());
    }

    /* renamed from: u2 */
    public static <T> Observable<T> m1522u2(Iterable<? extends T> iterable) {
        return m1830H6(new OnSubscribeFromIterable(iterable));
    }

    /* renamed from: u3 */
    public static <T> Observable<T> m1521u3(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.m1690Z2(OperatorMerge.m1178a(true));
    }

    /* renamed from: v0 */
    public static <T> Observable<T> m1516v0(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m1524u0(m1794M2(observable, observable2));
    }

    /* renamed from: v2 */
    public static <T> Observable<T> m1514v2(Future<? extends T> future) {
        return m1830H6(OnSubscribeToObservableFuture.m1200a(future));
    }

    /* renamed from: v3 */
    public static <T> Observable<T> m1513v3(Observable<? extends Observable<? extends T>> observable, int i) {
        return (Observable<T>) observable.m1690Z2(OperatorMerge.m1177b(true, i));
    }

    /* renamed from: w0 */
    public static <T> Observable<T> m1509w0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return m1524u0(m1786N2(observable, observable2, observable3));
    }

    /* renamed from: w2 */
    public static <T> Observable<T> m1507w2(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return m1830H6(OnSubscribeToObservableFuture.m1199b(future, j, timeUnit));
    }

    /* renamed from: w3 */
    public static <T> Observable<T> m1506w3(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m1521u3(m1794M2(observable, observable2));
    }

    /* renamed from: x0 */
    public static <T> Observable<T> m1502x0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return m1524u0(m1778O2(observable, observable2, observable3, observable4));
    }

    /* renamed from: x2 */
    public static <T> Observable<T> m1500x2(Future<? extends T> future, Scheduler scheduler) {
        return m1830H6(OnSubscribeToObservableFuture.m1200a(future)).m1511v5(scheduler);
    }

    /* renamed from: x3 */
    public static <T> Observable<T> m1499x3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return m1521u3(m1786N2(observable, observable2, observable3));
    }

    /* renamed from: y0 */
    public static <T> Observable<T> m1495y0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return m1524u0(m1770P2(observable, observable2, observable3, observable4, observable5));
    }

    /* renamed from: y2 */
    public static <T> Observable<T> m1493y2(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return m1747S1();
        }
        if (length == 1) {
            return m1802L2(tArr[0]);
        }
        return m1830H6(new OnSubscribeFromArray(tArr));
    }

    /* renamed from: y3 */
    public static <T> Observable<T> m1492y3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return m1521u3(m1778O2(observable, observable2, observable3, observable4));
    }

    /* renamed from: z0 */
    public static <T> Observable<T> m1488z0(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return m1524u0(m1762Q2(observable, observable2, observable3, observable4, observable5, observable6));
    }

    /* renamed from: z2 */
    public static <T> Observable<T> m1486z2(Callable<? extends T> callable) {
        return m1830H6(new OnSubscribeFromCallable(callable));
    }

    /* renamed from: z3 */
    public static <T> Observable<T> m1485z3(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return m1521u3(m1770P2(observable, observable2, observable3, observable4, observable5));
    }

    /* renamed from: A1 */
    public final <T2> Observable<T2> m1887A1() {
        return (Observable<T2>) m1690Z2(OperatorDematerialize.m1006a());
    }

    /* renamed from: A2 */
    public final <K> Observable<GroupedObservable<K, T>> m1886A2(Func1<? super T, ? extends K> func1) {
        return (Observable<GroupedObservable<K, T>>) m1690Z2(new OperatorGroupBy(func1));
    }

    /* renamed from: A4 */
    public final ConnectableObservable<T> m1884A4(Scheduler scheduler) {
        return OperatorReplay.m1081H7(m1528t4(), scheduler);
    }

    /* renamed from: A6 */
    public final <K, V> Observable<Map<K, Collection<V>>> m1882A6(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0) {
        return m1830H6(new OnSubscribeToMultimap(this, func1, func12, func0));
    }

    /* renamed from: B1 */
    public final Observable<T> m1880B1() {
        return (Observable<T>) m1690Z2(OperatorDistinct.m993a());
    }

    /* renamed from: B2 */
    public final <K, R> Observable<GroupedObservable<K, R>> m1879B2(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends R> func12) {
        return (Observable<R>) m1690Z2(new OperatorGroupBy(func1, func12));
    }

    /* renamed from: B4 */
    public final Observable<T> m1877B4() {
        return OnSubscribeRedo.m1016h(this);
    }

    /* renamed from: B6 */
    public final <K, V> Observable<Map<K, Collection<V>>> m1875B6(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0, Func1<? super K, ? extends Collection<V>> func13) {
        return m1830H6(new OnSubscribeToMultimap(this, func1, func12, func0, func13));
    }

    /* renamed from: C1 */
    public final <U> Observable<T> m1873C1(Func1<? super T, ? extends U> func1) {
        return (Observable<T>) m1690Z2(new OperatorDistinct(func1));
    }

    /* renamed from: C2 */
    public final <K, R> Observable<GroupedObservable<K, R>> m1872C2(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends R> func12, Func1<Action1<K>, Map<K, Object>> func13) {
        if (func13 != null) {
            return (Observable<R>) m1690Z2(new OperatorGroupBy(func1, func12, func13));
        }
        throw new NullPointerException("evictingMapFactory cannot be null");
    }

    /* renamed from: C4 */
    public final Observable<T> m1870C4(long j) {
        return OnSubscribeRedo.m1015i(this, j);
    }

    /* renamed from: C5 */
    public final Observable<T> m1869C5(int i) {
        return (Observable<T>) m1690Z2(new OperatorTake(i));
    }

    /* renamed from: C6 */
    public Single<T> m1868C6() {
        return new Single<>(OnSubscribeSingle.m1319a(this));
    }

    /* renamed from: D1 */
    public final Observable<T> m1866D1() {
        return (Observable<T>) m1690Z2(OperatorDistinctUntilChanged.m971a());
    }

    /* renamed from: D2 */
    public final <T2, D1, D2, R> Observable<R> m1865D2(Observable<T2> observable, Func1<? super T, ? extends Observable<D1>> func1, Func1<? super T2, ? extends Observable<D2>> func12, Func2<? super T, ? super Observable<T2>, ? extends R> func2) {
        return m1830H6(new OnSubscribeGroupJoin(this, observable, func1, func12, func2));
    }

    /* renamed from: D4 */
    public final Observable<T> m1863D4(Func2<Integer, Throwable, Boolean> func2) {
        return (Observable<T>) m1849F3().m1690Z2(new OperatorRetryWithPredicate(func2));
    }

    /* renamed from: D5 */
    public final Observable<T> m1862D5(long j, TimeUnit timeUnit) {
        return m1855E5(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: D6 */
    public final Observable<List<T>> m1861D6() {
        return (Observable<List<T>>) m1690Z2(new OperatorToObservableSortedList(10));
    }

    /* renamed from: E1 */
    public final <U> Observable<T> m1859E1(Func1<? super T, ? extends U> func1) {
        return (Observable<T>) m1690Z2(new OperatorDistinctUntilChanged(func1));
    }

    /* renamed from: E2 */
    public final Observable<T> m1858E2() {
        return (Observable<T>) m1690Z2(OperatorIgnoreElements.m1229a());
    }

    /* renamed from: E3 */
    public final Observable<T> m1857E3(Observable<? extends T> observable) {
        return m1617i3(this, observable);
    }

    /* renamed from: E4 */
    public final Observable<T> m1856E4(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        return OnSubscribeRedo.m1014j(this, InternalObservableUtils.createRetryDematerializer(func1));
    }

    /* renamed from: E5 */
    public final Observable<T> m1855E5(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) m1690Z2(new OperatorTakeTimed(j, timeUnit, scheduler));
    }

    /* renamed from: E6 */
    public final Observable<List<T>> m1854E6(int i) {
        return (Observable<List<T>>) m1690Z2(new OperatorToObservableSortedList(i));
    }

    /* renamed from: F1 */
    public final Observable<T> m1851F1(Func2<? super T, ? super T, Boolean> func2) {
        return (Observable<T>) m1690Z2(new OperatorDistinctUntilChanged(func2));
    }

    /* renamed from: F3 */
    public final Observable<Observable<T>> m1849F3() {
        return m1802L2(this);
    }

    /* renamed from: F4 */
    public final Observable<T> m1848F4(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return OnSubscribeRedo.m1013k(this, InternalObservableUtils.createRetryDematerializer(func1), scheduler);
    }

    /* renamed from: F5 */
    public final Observable<T> m1847F5(Func1<? super T, Boolean> func1) {
        return m1723V1(func1).m1869C5(1);
    }

    /* renamed from: F6 */
    public final Observable<List<T>> m1846F6(Func2<? super T, ? super T, Integer> func2) {
        return (Observable<List<T>>) m1690Z2(new OperatorToObservableSortedList(func2, 10));
    }

    /* renamed from: G1 */
    public final Observable<T> m1843G1(Action0 action0) {
        return (Observable<T>) m1690Z2(new OperatorDoAfterTerminate(action0));
    }

    /* renamed from: G4 */
    public final Observable<T> m1840G4(long j, TimeUnit timeUnit) {
        return m1832H4(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: G5 */
    public final Observable<T> m1839G5(int i) {
        if (i == 0) {
            return m1858E2();
        }
        if (i == 1) {
            return m1830H6(new OnSubscribeTakeLastOne(this));
        }
        return (Observable<T>) m1690Z2(new OperatorTakeLast(i));
    }

    /* renamed from: G6 */
    public final Observable<List<T>> m1838G6(Func2<? super T, ? super T, Integer> func2, int i) {
        return (Observable<List<T>>) m1690Z2(new OperatorToObservableSortedList(func2, i));
    }

    /* renamed from: H1 */
    public final Observable<T> m1835H1(Action0 action0) {
        return m1830H6(new OnSubscribeDoOnEach(this, new ActionObserver(Actions.m1455a(), Actions.m1455a(), action0)));
    }

    /* renamed from: H3 */
    public final Observable<T> m1833H3(Scheduler scheduler) {
        return m1825I3(scheduler, RxRingBuffer.f46509d);
    }

    /* renamed from: H4 */
    public final Observable<T> m1832H4(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) m1690Z2(new OperatorSampleWithTime(j, timeUnit, scheduler));
    }

    /* renamed from: H5 */
    public final Observable<T> m1831H5(int i, long j, TimeUnit timeUnit) {
        return m1823I5(i, j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: I1 */
    public final Observable<T> m1827I1(Observer<? super T> observer) {
        return m1830H6(new OnSubscribeDoOnEach(this, observer));
    }

    /* renamed from: I3 */
    public final Observable<T> m1825I3(Scheduler scheduler, int i) {
        return m1809K3(scheduler, false, i);
    }

    /* renamed from: I4 */
    public final <U> Observable<T> m1824I4(Observable<U> observable) {
        return (Observable<T>) m1690Z2(new OperatorSampleWithObservable(observable));
    }

    /* renamed from: I5 */
    public final Observable<T> m1823I5(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) m1690Z2(new OperatorTakeLastTimed(i, j, timeUnit, scheduler));
    }

    /* renamed from: I6 */
    public final Subscription m1822I6(Subscriber<? super T> subscriber) {
        try {
            subscriber.onStart();
            RxJavaHooks.m570O(this, this.f44784a).call(subscriber);
            return RxJavaHooks.m571N(subscriber);
        } catch (Throwable th) {
            C15575a.m1474e(th);
            try {
                subscriber.onError(RxJavaHooks.m573L(th));
                return Subscriptions.m342e();
            } catch (Throwable th2) {
                C15575a.m1474e(th2);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                RxJavaHooks.m573L(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    /* renamed from: J1 */
    public final Observable<T> m1819J1(Action1<Notification<? super T>> action1) {
        return m1830H6(new OnSubscribeDoOnEach(this, new ActionNotificationObserver(action1)));
    }

    /* renamed from: J2 */
    public final Observable<Boolean> m1818J2() {
        return m1690Z2(InternalObservableUtils.IS_EMPTY);
    }

    /* renamed from: J3 */
    public final Observable<T> m1817J3(Scheduler scheduler, boolean z) {
        return m1809K3(scheduler, z, RxRingBuffer.f46509d);
    }

    /* renamed from: J4 */
    public final <R> Observable<R> m1816J4(R r, Func2<R, ? super T, R> func2) {
        return m1690Z2(new OperatorScan(r, func2));
    }

    /* renamed from: J5 */
    public final Observable<T> m1815J5(long j, TimeUnit timeUnit) {
        return m1807K5(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: J6 */
    public final Observable<T> m1814J6(Scheduler scheduler) {
        return (Observable<T>) m1690Z2(new OperatorUnsubscribeOn(scheduler));
    }

    /* renamed from: K1 */
    public final Observable<T> m1811K1(Action1<? super Throwable> action1) {
        return m1830H6(new OnSubscribeDoOnEach(this, new ActionObserver(Actions.m1455a(), action1, Actions.m1455a())));
    }

    /* renamed from: K2 */
    public final <TRight, TLeftDuration, TRightDuration, R> Observable<R> m1810K2(Observable<TRight> observable, Func1<T, Observable<TLeftDuration>> func1, Func1<TRight, Observable<TRightDuration>> func12, Func2<T, TRight, R> func2) {
        return m1830H6(new OnSubscribeJoin(this, observable, func1, func12, func2));
    }

    /* renamed from: K3 */
    public final Observable<T> m1809K3(Scheduler scheduler, boolean z, int i) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).m815z7(scheduler);
        }
        return (Observable<T>) m1690Z2(new OperatorObserveOn(scheduler, z, i));
    }

    /* renamed from: K4 */
    public final Observable<T> m1808K4(Func2<T, T, T> func2) {
        return (Observable<T>) m1690Z2(new OperatorScan(func2));
    }

    /* renamed from: K5 */
    public final Observable<T> m1807K5(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) m1690Z2(new OperatorTakeLastTimed(j, timeUnit, scheduler));
    }

    /* renamed from: L1 */
    public final Observable<T> m1803L1(Action1<? super T> action1) {
        return m1830H6(new OnSubscribeDoOnEach(this, new ActionObserver(action1, Actions.m1455a(), Actions.m1455a())));
    }

    /* renamed from: L3 */
    public final <R> Observable<R> m1801L3(Class<R> cls) {
        return m1723V1(InternalObservableUtils.isInstanceOf(cls)).m1644f0(cls);
    }

    /* renamed from: L5 */
    public final Observable<List<T>> m1799L5(int i) {
        return m1839G5(i).m1518u6();
    }

    /* renamed from: M1 */
    public final Observable<T> m1795M1(Action1<? super Long> action1) {
        return (Observable<T>) m1690Z2(new OperatorDoOnRequest(action1));
    }

    /* renamed from: M3 */
    public final Observable<T> m1793M3() {
        return (Observable<T>) m1690Z2(OperatorOnBackpressureBuffer.m1136a());
    }

    /* renamed from: M5 */
    public final Observable<List<T>> m1791M5(int i, long j, TimeUnit timeUnit) {
        return m1831H5(i, j, timeUnit).m1518u6();
    }

    /* renamed from: M6 */
    public final Observable<Observable<T>> m1790M6(int i) {
        return m1782N6(i, i);
    }

    /* renamed from: N1 */
    public final Observable<T> m1787N1(Action0 action0) {
        return (Observable<T>) m1690Z2(new OperatorDoOnSubscribe(action0));
    }

    /* renamed from: N3 */
    public final Observable<T> m1785N3(long j) {
        return (Observable<T>) m1690Z2(new OperatorOnBackpressureBuffer(j));
    }

    /* renamed from: N4 */
    public final Observable<T> m1784N4() {
        return (Observable<T>) m1690Z2(OperatorSerialize.m970a());
    }

    /* renamed from: N5 */
    public final Observable<List<T>> m1783N5(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1823I5(i, j, timeUnit, scheduler).m1518u6();
    }

    /* renamed from: N6 */
    public final Observable<Observable<T>> m1782N6(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("count > 0 required but it was " + i);
        } else if (i2 > 0) {
            return (Observable<Observable<T>>) m1690Z2(new OperatorWindowWithSize(i, i2));
        } else {
            throw new IllegalArgumentException("skip > 0 required but it was " + i2);
        }
    }

    /* renamed from: O */
    public final Observable<T> m1781O(Observable<? extends T> observable) {
        return m1845G(this, observable);
    }

    /* renamed from: O1 */
    public final Observable<T> m1779O1(Action0 action0) {
        return m1830H6(new OnSubscribeDoOnEach(this, new ActionObserver(Actions.m1455a(), Actions.m1453c(action0), action0)));
    }

    /* renamed from: O3 */
    public final Observable<T> m1777O3(long j, Action0 action0) {
        return (Observable<T>) m1690Z2(new OperatorOnBackpressureBuffer(j, action0));
    }

    /* renamed from: O4 */
    public final Observable<T> m1776O4() {
        return m1689Z3().m697A7();
    }

    /* renamed from: O5 */
    public final Observable<List<T>> m1775O5(long j, TimeUnit timeUnit) {
        return m1815J5(j, timeUnit).m1518u6();
    }

    /* renamed from: O6 */
    public final Observable<Observable<T>> m1774O6(long j, long j2, TimeUnit timeUnit) {
        return m1766P6(j, j2, timeUnit, Integer.MAX_VALUE, Schedulers.m479a());
    }

    /* renamed from: P */
    public final Observable<T> m1773P() {
        return (Observable<T>) m1690Z2(OperatorAsObservable.m1148a());
    }

    /* renamed from: P1 */
    public final Observable<T> m1771P1(Action0 action0) {
        return (Observable<T>) m1690Z2(new OperatorDoOnUnsubscribe(action0));
    }

    /* renamed from: P3 */
    public final Observable<T> m1769P3(long j, Action0 action0, BackpressureOverflow.InterfaceC15500d interfaceC15500d) {
        return (Observable<T>) m1690Z2(new OperatorOnBackpressureBuffer(j, action0, interfaceC15500d));
    }

    /* renamed from: P4 */
    public final Observable<T> m1768P4() {
        return (Observable<T>) m1690Z2(OperatorSingle.m1317a());
    }

    /* renamed from: P5 */
    public final Observable<List<T>> m1767P5(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1807K5(j, timeUnit, scheduler).m1518u6();
    }

    /* renamed from: P6 */
    public final Observable<Observable<T>> m1766P6(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler) {
        return (Observable<Observable<T>>) m1690Z2(new OperatorWindowWithTime(j, j2, timeUnit, i, scheduler));
    }

    /* renamed from: Q */
    public final Observable<List<T>> m1765Q(int i) {
        return m1757R(i, i);
    }

    /* renamed from: Q1 */
    public final Observable<T> m1763Q1(int i) {
        return (Observable<T>) m1690Z2(new OperatorElementAt(i));
    }

    /* renamed from: Q3 */
    public final Observable<T> m1761Q3() {
        return (Observable<T>) m1690Z2(OperatorOnBackpressureDrop.m1120a());
    }

    /* renamed from: Q4 */
    public final Observable<T> m1760Q4(Func1<? super T, Boolean> func1) {
        return m1723V1(func1).m1768P4();
    }

    /* renamed from: Q5 */
    public final <E> Observable<T> m1759Q5(Observable<? extends E> observable) {
        return (Observable<T>) m1690Z2(new OperatorTakeUntil(observable));
    }

    /* renamed from: Q6 */
    public final Observable<Observable<T>> m1758Q6(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return m1766P6(j, j2, timeUnit, Integer.MAX_VALUE, scheduler);
    }

    /* renamed from: R */
    public final Observable<List<T>> m1757R(int i, int i2) {
        return (Observable<List<T>>) m1690Z2(new OperatorBufferWithSize(i, i2));
    }

    /* renamed from: R1 */
    public final Observable<T> m1755R1(int i, T t) {
        return (Observable<T>) m1690Z2(new OperatorElementAt(i, t));
    }

    /* renamed from: R3 */
    public final Observable<T> m1753R3(Action1<? super T> action1) {
        return (Observable<T>) m1690Z2(new OperatorOnBackpressureDrop(action1));
    }

    /* renamed from: R4 */
    public final Observable<T> m1752R4(T t) {
        return (Observable<T>) m1690Z2(new OperatorSingle(t));
    }

    /* renamed from: R5 */
    public final Observable<T> m1751R5(Func1<? super T, Boolean> func1) {
        return (Observable<T>) m1690Z2(new OperatorTakeUntilPredicate(func1));
    }

    /* renamed from: R6 */
    public final Observable<Observable<T>> m1750R6(long j, TimeUnit timeUnit) {
        return m1758Q6(j, j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: S */
    public final Observable<List<T>> m1749S(long j, long j2, TimeUnit timeUnit) {
        return m1741T(j, j2, timeUnit, Schedulers.m479a());
    }

    /* renamed from: S3 */
    public final Observable<T> m1745S3() {
        return (Observable<T>) m1690Z2(OperatorOnBackpressureLatest.m1116a());
    }

    /* renamed from: S4 */
    public final Observable<T> m1744S4(T t, Func1<? super T, Boolean> func1) {
        return m1723V1(func1).m1752R4(t);
    }

    /* renamed from: S5 */
    public final Observable<T> m1743S5(Func1<? super T, Boolean> func1) {
        return (Observable<T>) m1690Z2(new OperatorTakeWhile(func1));
    }

    /* renamed from: S6 */
    public final Observable<Observable<T>> m1742S6(long j, TimeUnit timeUnit, int i) {
        return m1734T6(j, timeUnit, i, Schedulers.m479a());
    }

    /* renamed from: T */
    public final Observable<List<T>> m1741T(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<List<T>>) m1690Z2(new OperatorBufferWithTime(j, j2, timeUnit, Integer.MAX_VALUE, scheduler));
    }

    /* renamed from: T3 */
    public final Observable<T> m1737T3(Observable<? extends T> observable) {
        return (Observable<T>) m1690Z2(OperatorOnErrorResumeNextViaFunction.m1105b(observable));
    }

    /* renamed from: T4 */
    public final Observable<T> m1736T4(int i) {
        return (Observable<T>) m1690Z2(new OperatorSkip(i));
    }

    /* renamed from: T5 */
    public final AssertableSubscriber<T> m1735T5() {
        AssertableSubscriberObservable m12694F = AssertableSubscriberObservable.m12694F(Long.MAX_VALUE);
        m1559p5(m12694F);
        return m12694F;
    }

    /* renamed from: T6 */
    public final Observable<Observable<T>> m1734T6(long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
        return m1766P6(j, j, timeUnit, i, scheduler);
    }

    /* renamed from: U */
    public final Observable<List<T>> m1733U(long j, TimeUnit timeUnit) {
        return m1717W(j, timeUnit, Integer.MAX_VALUE, Schedulers.m479a());
    }

    /* renamed from: U1 */
    public final Observable<Boolean> m1731U1(Func1<? super T, Boolean> func1) {
        return m1690Z2(new OperatorAny(func1, false));
    }

    /* renamed from: U3 */
    public final Observable<T> m1729U3(Func1<? super Throwable, ? extends Observable<? extends T>> func1) {
        return (Observable<T>) m1690Z2(new OperatorOnErrorResumeNextViaFunction(func1));
    }

    /* renamed from: U4 */
    public final Observable<T> m1728U4(long j, TimeUnit timeUnit) {
        return m1720V4(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: U5 */
    public final AssertableSubscriber<T> m1727U5(long j) {
        AssertableSubscriberObservable m12694F = AssertableSubscriberObservable.m12694F(j);
        m1559p5(m12694F);
        return m12694F;
    }

    /* renamed from: U6 */
    public final Observable<Observable<T>> m1726U6(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1734T6(j, timeUnit, Integer.MAX_VALUE, scheduler);
    }

    /* renamed from: V */
    public final Observable<List<T>> m1725V(long j, TimeUnit timeUnit, int i) {
        return (Observable<List<T>>) m1690Z2(new OperatorBufferWithTime(j, j, timeUnit, i, Schedulers.m479a()));
    }

    /* renamed from: V1 */
    public final Observable<T> m1723V1(Func1<? super T, Boolean> func1) {
        return m1830H6(new OnSubscribeFilter(this, func1));
    }

    /* renamed from: V2 */
    public final Observable<T> m1722V2() {
        return m1839G5(1).m1768P4();
    }

    /* renamed from: V3 */
    public final Observable<T> m1721V3(Func1<? super Throwable, ? extends T> func1) {
        return (Observable<T>) m1690Z2(OperatorOnErrorResumeNextViaFunction.m1104c(func1));
    }

    /* renamed from: V4 */
    public final Observable<T> m1720V4(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1830H6(new OnSubscribeSkipTimed(this, j, timeUnit, scheduler));
    }

    /* renamed from: V5 */
    public final Observable<T> m1719V5(long j, TimeUnit timeUnit) {
        return m1711W5(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: V6 */
    public final <U> Observable<Observable<T>> m1718V6(Observable<U> observable) {
        return (Observable<Observable<T>>) m1690Z2(new OperatorWindowWithObservable(observable));
    }

    /* renamed from: W */
    public final Observable<List<T>> m1717W(long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
        return (Observable<List<T>>) m1690Z2(new OperatorBufferWithTime(j, j, timeUnit, i, scheduler));
    }

    @Deprecated
    /* renamed from: W1 */
    public final Observable<T> m1715W1(Action0 action0) {
        return (Observable<T>) m1690Z2(new OperatorDoAfterTerminate(action0));
    }

    /* renamed from: W2 */
    public final Observable<T> m1714W2(Func1<? super T, Boolean> func1) {
        return m1723V1(func1).m1839G5(1).m1768P4();
    }

    /* renamed from: W3 */
    public final Observable<T> m1713W3(Observable<? extends T> observable) {
        return (Observable<T>) m1690Z2(OperatorOnErrorResumeNextViaFunction.m1106a(observable));
    }

    /* renamed from: W4 */
    public final Observable<T> m1712W4(int i) {
        return (Observable<T>) m1690Z2(new OperatorSkipLast(i));
    }

    /* renamed from: W5 */
    public final Observable<T> m1711W5(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) m1690Z2(new OperatorThrottleFirst(j, timeUnit, scheduler));
    }

    /* renamed from: W6 */
    public final <TOpening, TClosing> Observable<Observable<T>> m1710W6(Observable<? extends TOpening> observable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> func1) {
        return (Observable<Observable<T>>) m1690Z2(new OperatorWindowWithStartEndObservable(observable, func1));
    }

    /* renamed from: X */
    public final Observable<List<T>> m1709X(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1741T(j, j, timeUnit, scheduler);
    }

    /* renamed from: X1 */
    public final Observable<T> m1707X1() {
        return m1869C5(1).m1768P4();
    }

    /* renamed from: X2 */
    public final Observable<T> m1706X2(T t) {
        return m1839G5(1).m1752R4(t);
    }

    /* renamed from: X3 */
    public final Observable<T> m1705X3() {
        return m1830H6(new OnSubscribeDetach(this));
    }

    /* renamed from: X4 */
    public final Observable<T> m1704X4(long j, TimeUnit timeUnit) {
        return m1696Y4(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: X5 */
    public final Observable<T> m1703X5(long j, TimeUnit timeUnit) {
        return m1840G4(j, timeUnit);
    }

    /* renamed from: X6 */
    public final <TClosing> Observable<Observable<T>> m1702X6(Func0<? extends Observable<? extends TClosing>> func0) {
        return (Observable<Observable<T>>) m1690Z2(new OperatorWindowWithObservableFactory(func0));
    }

    /* renamed from: Y */
    public final <B> Observable<List<T>> m1701Y(Observable<B> observable) {
        return m1693Z(observable, 16);
    }

    /* renamed from: Y1 */
    public final Observable<T> m1699Y1(Func1<? super T, Boolean> func1) {
        return m1847F5(func1).m1768P4();
    }

    /* renamed from: Y2 */
    public final Observable<T> m1698Y2(T t, Func1<? super T, Boolean> func1) {
        return m1723V1(func1).m1839G5(1).m1752R4(t);
    }

    /* renamed from: Y3 */
    public final <R> Observable<R> m1697Y3(Func1<? super Observable<T>, ? extends Observable<R>> func1) {
        return OperatorPublish.m1102B7(this, func1);
    }

    /* renamed from: Y4 */
    public final Observable<T> m1696Y4(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) m1690Z2(new OperatorSkipLastTimed(j, timeUnit, scheduler));
    }

    /* renamed from: Y5 */
    public final Observable<T> m1695Y5(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1832H4(j, timeUnit, scheduler);
    }

    /* renamed from: Y6 */
    public final <R> Observable<R> m1694Y6(Iterable<Observable<?>> iterable, FuncN<R> funcN) {
        return m1830H6(new OperatorWithLatestFromMany(this, null, iterable, funcN));
    }

    /* renamed from: Z */
    public final <B> Observable<List<T>> m1693Z(Observable<B> observable, int i) {
        return (Observable<List<T>>) m1690Z2(new OperatorBufferWithSingleObservable(observable, i));
    }

    /* renamed from: Z0 */
    public final <R> Observable<R> m1692Z0(Func1<? super T, ? extends Observable<? extends R>> func1) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).m816y7(func1);
        }
        return m1830H6(new OnSubscribeConcatMap(this, func1, 2, 0));
    }

    /* renamed from: Z1 */
    public final Observable<T> m1691Z1(T t) {
        return m1869C5(1).m1752R4(t);
    }

    /* renamed from: Z2 */
    public final <R> Observable<R> m1690Z2(InterfaceC15568b<? extends R, ? super T> interfaceC15568b) {
        return m1830H6(new OnSubscribeLift(this.f44784a, interfaceC15568b));
    }

    /* renamed from: Z3 */
    public final ConnectableObservable<T> m1689Z3() {
        return OperatorPublish.m1100D7(this);
    }

    /* renamed from: Z4 */
    public final <U> Observable<T> m1688Z4(Observable<U> observable) {
        return (Observable<T>) m1690Z2(new OperatorSkipUntil(observable));
    }

    /* renamed from: Z5 */
    public final Observable<T> m1687Z5(long j, TimeUnit timeUnit) {
        return m1579n1(j, timeUnit);
    }

    /* renamed from: Z6 */
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> m1686Z6(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Func9<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, R> func9) {
        return m1830H6(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8}, null, C15576a0.m1456n(func9)));
    }

    /* renamed from: a0 */
    public final <TOpening, TClosing> Observable<List<T>> m1685a0(Observable<? extends TOpening> observable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> func1) {
        return (Observable<List<T>>) m1690Z2(new OperatorBufferWithStartEndObservable(observable, func1));
    }

    /* renamed from: a1 */
    public final <R> Observable<R> m1684a1(Func1<? super T, ? extends Observable<? extends R>> func1) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).m816y7(func1);
        }
        return m1830H6(new OnSubscribeConcatMap(this, func1, 2, 2));
    }

    /* renamed from: a2 */
    public final Observable<T> m1683a2(T t, Func1<? super T, Boolean> func1) {
        return m1847F5(func1).m1752R4(t);
    }

    /* renamed from: a3 */
    public final Observable<T> m1682a3(int i) {
        return m1869C5(i);
    }

    /* renamed from: a5 */
    public final Observable<T> m1680a5(Func1<? super T, Boolean> func1) {
        return (Observable<T>) m1690Z2(new OperatorSkipWhile(OperatorSkipWhile.m1261a(func1)));
    }

    /* renamed from: a6 */
    public final Observable<T> m1679a6(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1571o1(j, timeUnit, scheduler);
    }

    /* renamed from: a7 */
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> m1678a7(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Func8<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, R> func8) {
        return m1830H6(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7}, null, C15576a0.m1457m(func8)));
    }

    /* renamed from: b0 */
    public final <TClosing> Observable<List<T>> m1677b0(Func0<? extends Observable<? extends TClosing>> func0) {
        return (Observable<List<T>>) m1690Z2(new OperatorBufferWithSingleObservable(func0, 16));
    }

    /* renamed from: b1 */
    public final <R> Observable<R> m1676b1(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return m1668c1(func1, RxRingBuffer.f46509d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b2 */
    public final <R> Observable<R> m1675b2(Func1<? super T, ? extends Observable<? extends R>> func1) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).m816y7(func1);
        }
        return m1633g3(m1674b3(func1));
    }

    /* renamed from: b3 */
    public final <R> Observable<R> m1674b3(Func1<? super T, ? extends R> func1) {
        return m1830H6(new OnSubscribeMap(this, func1));
    }

    /* renamed from: b5 */
    public final Observable<T> m1672b5() {
        return (Observable<T>) m1861D6().m1602k2(UtilityFunctions.m803c());
    }

    /* renamed from: b6 */
    public final Observable<TimeInterval<T>> m1671b6() {
        return m1663c6(Schedulers.m479a());
    }

    /* renamed from: b7 */
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> m1670b7(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Func7<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, R> func7) {
        return m1830H6(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5, observable6}, null, C15576a0.m1458l(func7)));
    }

    /* renamed from: c0 */
    public final Observable<T> m1669c0() {
        return CachedObservable.m1239v7(this);
    }

    /* renamed from: c1 */
    public final <R> Observable<R> m1668c1(Func1<? super T, ? extends Observable<? extends R>> func1, int i) {
        if (i >= 1) {
            return m1690Z2(new OperatorEagerConcatMap(func1, i, Integer.MAX_VALUE));
        }
        throw new IllegalArgumentException("capacityHint > 0 required but it was " + i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c2 */
    public final <R> Observable<R> m1667c2(Func1<? super T, ? extends Observable<? extends R>> func1, int i) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).m816y7(func1);
        }
        return m1625h3(m1674b3(func1), i);
    }

    /* renamed from: c4 */
    public final Observable<T> m1665c4(int i) {
        if (i > 0) {
            return (Observable<T>) m1690Z2(OperatorObserveOn.m1147a(i));
        }
        throw new IllegalArgumentException("n > 0 required but it was " + i);
    }

    /* renamed from: c5 */
    public final Observable<T> m1664c5(Func2<? super T, ? super T, Integer> func2) {
        return (Observable<T>) m1846F6(func2).m1602k2(UtilityFunctions.m803c());
    }

    /* renamed from: c6 */
    public final Observable<TimeInterval<T>> m1663c6(Scheduler scheduler) {
        return (Observable<TimeInterval<T>>) m1690Z2(new OperatorTimeInterval(scheduler));
    }

    /* renamed from: c7 */
    public final <T1, T2, T3, T4, T5, R> Observable<R> m1662c7(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Func6<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, R> func6) {
        return m1830H6(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5}, null, C15576a0.m1459k(func6)));
    }

    /* renamed from: d */
    public final Observable<Boolean> m1661d(Func1<? super T, Boolean> func1) {
        return m1690Z2(new OperatorAll(func1));
    }

    @Deprecated
    /* renamed from: d0 */
    public final Observable<T> m1660d0(int i) {
        return m1652e0(i);
    }

    /* renamed from: d1 */
    public final <R> Observable<R> m1659d1(Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
        if (i < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required but it was " + i);
        } else if (i2 >= 1) {
            return m1690Z2(new OperatorEagerConcatMap(func1, i, i2));
        } else {
            throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d2 */
    public final <R> Observable<R> m1658d2(Func1<? super T, ? extends Observable<? extends R>> func1, Func1<? super Throwable, ? extends Observable<? extends R>> func12, Func0<? extends Observable<? extends R>> func0) {
        return m1633g3(m1666c3(func1, func12, func0));
    }

    /* renamed from: d3 */
    public final Observable<Notification<T>> m1657d3() {
        return (Observable<Notification<T>>) m1690Z2(OperatorMaterialize.m1187a());
    }

    /* renamed from: d4 */
    public final <R> Observable<R> m1656d4(R r, Func2<R, ? super T, R> func2) {
        return m1830H6(new OnSubscribeReduceSeed(this, r, func2));
    }

    /* renamed from: d5 */
    public final Observable<T> m1655d5(Iterable<T> iterable) {
        return m1516v0(m1522u2(iterable), this);
    }

    /* renamed from: d6 */
    public final Observable<T> m1654d6(long j, TimeUnit timeUnit) {
        return m1638f6(j, timeUnit, null, Schedulers.m479a());
    }

    /* renamed from: d7 */
    public final <T1, T2, T3, T4, R> Observable<R> m1653d7(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Func5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> func5) {
        return m1830H6(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4}, null, C15576a0.m1460j(func5)));
    }

    /* renamed from: e0 */
    public final Observable<T> m1652e0(int i) {
        return CachedObservable.m1238w7(this, i);
    }

    /* renamed from: e1 */
    public final <R> Observable<R> m1651e1(Func1<? super T, ? extends Iterable<? extends R>> func1) {
        return OnSubscribeFlattenIterable.m1192a(this, func1, RxRingBuffer.f46509d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e2 */
    public final <R> Observable<R> m1650e2(Func1<? super T, ? extends Observable<? extends R>> func1, Func1<? super Throwable, ? extends Observable<? extends R>> func12, Func0<? extends Observable<? extends R>> func0, int i) {
        return m1625h3(m1666c3(func1, func12, func0), i);
    }

    /* renamed from: e4 */
    public final Observable<T> m1648e4(Func2<T, T, T> func2) {
        return m1830H6(new OnSubscribeReduce(this, func2));
    }

    /* renamed from: e5 */
    public final Observable<T> m1647e5(T t) {
        return m1516v0(m1802L2(t), this);
    }

    /* renamed from: e6 */
    public final Observable<T> m1646e6(long j, TimeUnit timeUnit, Observable<? extends T> observable) {
        return m1638f6(j, timeUnit, observable, Schedulers.m479a());
    }

    /* renamed from: e7 */
    public final <T1, T2, T3, R> Observable<R> m1645e7(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Func4<? super T, ? super T1, ? super T2, ? super T3, R> func4) {
        return m1830H6(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3}, null, C15576a0.m1461i(func4)));
    }

    /* renamed from: f0 */
    public final <R> Observable<R> m1644f0(Class<R> cls) {
        return m1690Z2(new OperatorCast(cls));
    }

    /* renamed from: f1 */
    public final Observable<T> m1643f1(Observable<? extends T> observable) {
        return m1516v0(this, observable);
    }

    /* renamed from: f2 */
    public final <U, R> Observable<R> m1642f2(Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
        return m1633g3(m1690Z2(new OperatorMapPair(func1, func2)));
    }

    /* renamed from: f4 */
    public final Observable<T> m1640f4() {
        return OnSubscribeRedo.m1022b(this);
    }

    /* renamed from: f5 */
    public final Observable<T> m1639f5(T t, T t2) {
        return m1516v0(m1794M2(t, t2), this);
    }

    /* renamed from: f6 */
    public final Observable<T> m1638f6(long j, TimeUnit timeUnit, Observable<? extends T> observable, Scheduler scheduler) {
        return (Observable<T>) m1690Z2(new OperatorTimeout(j, timeUnit, observable, scheduler));
    }

    /* renamed from: f7 */
    public final <T1, T2, R> Observable<R> m1637f7(Observable<T1> observable, Observable<T2> observable2, Func3<? super T, ? super T1, ? super T2, R> func3) {
        return m1830H6(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2}, null, C15576a0.m1462h(func3)));
    }

    /* renamed from: g0 */
    public final <R> Observable<R> m1636g0(Func0<R> func0, Action2<R, ? super T> action2) {
        return m1830H6(new OnSubscribeCollect(this, func0, action2));
    }

    /* renamed from: g1 */
    public final Observable<Boolean> m1635g1(Object obj) {
        return m1731U1(InternalObservableUtils.equalsWith(obj));
    }

    /* renamed from: g2 */
    public final <U, R> Observable<R> m1634g2(Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2, int i) {
        return m1625h3(m1690Z2(new OperatorMapPair(func1, func2)), i);
    }

    /* renamed from: g4 */
    public final Observable<T> m1632g4(long j) {
        return OnSubscribeRedo.m1021c(this, j);
    }

    /* renamed from: g5 */
    public final Observable<T> m1631g5(T t, T t2, T t3) {
        return m1516v0(m1786N2(t, t2, t3), this);
    }

    /* renamed from: g6 */
    public final Observable<T> m1630g6(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1638f6(j, timeUnit, null, scheduler);
    }

    /* renamed from: g7 */
    public final <U, R> Observable<R> m1629g7(Observable<? extends U> observable, Func2<? super T, ? super U, ? extends R> func2) {
        return m1690Z2(new OperatorWithLatestFrom(observable, func2));
    }

    /* renamed from: h1 */
    public final Observable<Integer> m1627h1() {
        return m1656d4(0, InternalObservableUtils.COUNTER);
    }

    /* renamed from: h2 */
    public final Observable<T> m1626h2(Func1<? super T, ? extends Completable> func1) {
        return m1610j2(func1, false, Integer.MAX_VALUE);
    }

    /* renamed from: h4 */
    public final Observable<T> m1624h4(long j, Scheduler scheduler) {
        return OnSubscribeRedo.m1020d(this, j, scheduler);
    }

    /* renamed from: h5 */
    public final Observable<T> m1623h5(T t, T t2, T t3, T t4) {
        return m1516v0(m1778O2(t, t2, t3, t4), this);
    }

    /* renamed from: h6 */
    public final <U, V> Observable<T> m1622h6(Func0<? extends Observable<U>> func0, Func1<? super T, ? extends Observable<V>> func1) {
        return m1614i6(func0, func1, null);
    }

    /* renamed from: h7 */
    public final <R> Observable<R> m1621h7(Observable<?>[] observableArr, FuncN<R> funcN) {
        return m1830H6(new OperatorWithLatestFromMany(this, observableArr, null, funcN));
    }

    /* renamed from: i1 */
    public final Observable<Long> m1619i1() {
        return m1656d4(0L, InternalObservableUtils.LONG_COUNTER);
    }

    /* renamed from: i2 */
    public final Observable<T> m1618i2(Func1<? super T, ? extends Completable> func1, boolean z) {
        return m1610j2(func1, z, Integer.MAX_VALUE);
    }

    /* renamed from: i4 */
    public final Observable<T> m1616i4(Scheduler scheduler) {
        return OnSubscribeRedo.m1019e(this, scheduler);
    }

    /* renamed from: i5 */
    public final Observable<T> m1615i5(T t, T t2, T t3, T t4, T t5) {
        return m1516v0(m1770P2(t, t2, t3, t4, t5), this);
    }

    /* renamed from: i6 */
    public final <U, V> Observable<T> m1614i6(Func0<? extends Observable<U>> func0, Func1<? super T, ? extends Observable<V>> func1, Observable<? extends T> observable) {
        if (func1 != null) {
            return (Observable<T>) m1690Z2(new OperatorTimeoutWithSelector(func0, func1, observable));
        }
        throw new NullPointerException("timeoutSelector is null");
    }

    /* renamed from: j2 */
    public final Observable<T> m1610j2(Func1<? super T, ? extends Completable> func1, boolean z, int i) {
        return m1830H6(new OnSubscribeFlatMapCompletable(this, func1, z, i));
    }

    /* renamed from: j4 */
    public final Observable<T> m1608j4(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
        return OnSubscribeRedo.m1018f(this, InternalObservableUtils.createRepeatDematerializer(func1));
    }

    /* renamed from: j5 */
    public final Observable<T> m1607j5(T t, T t2, T t3, T t4, T t5, T t6) {
        return m1516v0(m1762Q2(t, t2, t3, t4, t5, t6), this);
    }

    /* renamed from: j6 */
    public final <V> Observable<T> m1606j6(Func1<? super T, ? extends Observable<V>> func1) {
        return m1614i6(null, func1, null);
    }

    /* renamed from: k2 */
    public final <R> Observable<R> m1602k2(Func1<? super T, ? extends Iterable<? extends R>> func1) {
        return m1594l2(func1, RxRingBuffer.f46509d);
    }

    /* renamed from: k4 */
    public final Observable<T> m1600k4(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return OnSubscribeRedo.m1017g(this, InternalObservableUtils.createRepeatDematerializer(func1), scheduler);
    }

    /* renamed from: k5 */
    public final Observable<T> m1599k5(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        return m1516v0(m1754R2(t, t2, t3, t4, t5, t6, t7), this);
    }

    /* renamed from: k6 */
    public final <V> Observable<T> m1598k6(Func1<? super T, ? extends Observable<V>> func1, Observable<? extends T> observable) {
        return m1614i6(null, func1, observable);
    }

    /* renamed from: l2 */
    public final <R> Observable<R> m1594l2(Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        return OnSubscribeFlattenIterable.m1192a(this, func1, i);
    }

    /* renamed from: l4 */
    public final <R> Observable<R> m1592l4(Func1<? super Observable<T>, ? extends Observable<R>> func1) {
        return OperatorReplay.m1082G7(InternalObservableUtils.createReplaySupplier(this), func1);
    }

    /* renamed from: l5 */
    public final Observable<T> m1591l5(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        return m1516v0(m1746S2(t, t2, t3, t4, t5, t6, t7, t8), this);
    }

    /* renamed from: m2 */
    public final <U, R> Observable<R> m1586m2(Func1<? super T, ? extends Iterable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
        return m1642f2(OperatorMapPair.m1198a(func1), func2);
    }

    /* renamed from: m4 */
    public final <R> Observable<R> m1584m4(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i) {
        return OperatorReplay.m1082G7(InternalObservableUtils.createReplaySupplier(this, i), func1);
    }

    /* renamed from: m5 */
    public final Observable<T> m1583m5(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return m1516v0(m1738T2(t, t2, t3, t4, t5, t6, t7, t8, t9), this);
    }

    /* renamed from: n1 */
    public final Observable<T> m1579n1(long j, TimeUnit timeUnit) {
        return m1571o1(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: n2 */
    public final <U, R> Observable<R> m1578n2(Func1<? super T, ? extends Iterable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2, int i) {
        return m1634g2(OperatorMapPair.m1198a(func1), func2, i);
    }

    /* renamed from: n4 */
    public final <R> Observable<R> m1576n4(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i, long j, TimeUnit timeUnit) {
        return m1568o4(func1, i, j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: n5 */
    public final Observable<T> m1575n5(Observable<T> observable) {
        return m1516v0(observable, this);
    }

    /* renamed from: o1 */
    public final Observable<T> m1571o1(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) m1690Z2(new OperatorDebounceWithTime(j, timeUnit, scheduler));
    }

    /* renamed from: o2 */
    public final <R> Observable<R> m1570o2(Func1<? super T, ? extends Single<? extends R>> func1) {
        return m1554q2(func1, false, Integer.MAX_VALUE);
    }

    /* renamed from: o4 */
    public final <R> Observable<R> m1568o4(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        if (i >= 0) {
            return OperatorReplay.m1082G7(InternalObservableUtils.createReplaySupplier(this, i, j, timeUnit, scheduler), func1);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    /* renamed from: o5 */
    public final Subscription m1567o5() {
        return m1551q5(new ActionSubscriber(Actions.m1455a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.m1455a()));
    }

    /* renamed from: p1 */
    public final <U> Observable<T> m1563p1(Func1<? super T, ? extends Observable<U>> func1) {
        return (Observable<T>) m1690Z2(new OperatorDebounceWithSelector(func1));
    }

    /* renamed from: p2 */
    public final <R> Observable<R> m1562p2(Func1<? super T, ? extends Single<? extends R>> func1, boolean z) {
        return m1554q2(func1, z, Integer.MAX_VALUE);
    }

    /* renamed from: p4 */
    public final <R> Observable<R> m1560p4(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i, Scheduler scheduler) {
        return OperatorReplay.m1082G7(InternalObservableUtils.createReplaySupplier(this, i), InternalObservableUtils.createReplaySelectorAndObserveOn(func1, scheduler));
    }

    /* renamed from: p5 */
    public final Subscription m1559p5(Observer<? super T> observer) {
        if (observer instanceof Subscriber) {
            return m1551q5((Subscriber) observer);
        }
        if (observer != null) {
            return m1551q5(new ObserverSubscriber(observer));
        }
        throw new NullPointerException("observer is null");
    }

    /* renamed from: p6 */
    public final Observable<Timestamped<T>> m1558p6() {
        return m1550q6(Schedulers.m479a());
    }

    /* renamed from: q1 */
    public final Observable<T> m1555q1(T t) {
        return m1497x5(m1802L2(t));
    }

    /* renamed from: q2 */
    public final <R> Observable<R> m1554q2(Func1<? super T, ? extends Single<? extends R>> func1, boolean z, int i) {
        return m1830H6(new OnSubscribeFlatMapSingle(this, func1, z, i));
    }

    /* renamed from: q4 */
    public final <R> Observable<R> m1552q4(Func1<? super Observable<T>, ? extends Observable<R>> func1, long j, TimeUnit timeUnit) {
        return m1544r4(func1, j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: q5 */
    public final Subscription m1551q5(Subscriber<? super T> subscriber) {
        return m1543r5(subscriber, this);
    }

    /* renamed from: q6 */
    public final Observable<Timestamped<T>> m1550q6(Scheduler scheduler) {
        return (Observable<Timestamped<T>>) m1690Z2(new OperatorTimestamp(scheduler));
    }

    /* renamed from: r2 */
    public final void m1546r2(Action1<? super T> action1) {
        m1535s5(action1);
    }

    /* renamed from: r4 */
    public final <R> Observable<R> m1544r4(Func1<? super Observable<T>, ? extends Observable<R>> func1, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return OperatorReplay.m1082G7(InternalObservableUtils.createReplaySupplier(this, j, timeUnit, scheduler), func1);
    }

    /* renamed from: r6 */
    public final <R> R m1542r6(Func1<? super Observable<T>, R> func1) {
        return func1.call(this);
    }

    /* renamed from: s0 */
    public <R> Observable<R> m1540s0(InterfaceC15569c<? super T, ? extends R> interfaceC15569c) {
        return (Observable) interfaceC15569c.call(this);
    }

    /* renamed from: s1 */
    public final Observable<T> m1539s1(long j, TimeUnit timeUnit) {
        return m1531t1(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: s2 */
    public final void m1538s2(Action1<? super T> action1, Action1<Throwable> action12) {
        m1527t5(action1, action12);
    }

    /* renamed from: s4 */
    public final <R> Observable<R> m1536s4(Func1<? super Observable<T>, ? extends Observable<R>> func1, Scheduler scheduler) {
        return OperatorReplay.m1082G7(InternalObservableUtils.createReplaySupplier(this), InternalObservableUtils.createReplaySelectorAndObserveOn(func1, scheduler));
    }

    /* renamed from: s5 */
    public final Subscription m1535s5(Action1<? super T> action1) {
        if (action1 != null) {
            return m1551q5(new ActionSubscriber(action1, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.m1455a()));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    /* renamed from: s6 */
    public final BlockingObservable<T> m1534s6() {
        return BlockingObservable.m717g(this);
    }

    /* renamed from: t1 */
    public final Observable<T> m1531t1(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) m1690Z2(new OperatorDelay(j, timeUnit, scheduler));
    }

    /* renamed from: t2 */
    public final void m1530t2(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        m1519u5(action1, action12, action0);
    }

    /* renamed from: t4 */
    public final ConnectableObservable<T> m1528t4() {
        return OperatorReplay.m1087B7(this);
    }

    /* renamed from: t5 */
    public final Subscription m1527t5(Action1<? super T> action1, Action1<Throwable> action12) {
        if (action1 != null) {
            if (action12 != null) {
                return m1551q5(new ActionSubscriber(action1, action12, Actions.m1455a()));
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    /* renamed from: t6 */
    public Completable m1526t6() {
        return Completable.m1962J(this);
    }

    /* renamed from: t7 */
    public final <T2, R> Observable<R> m1525t7(Iterable<? extends T2> iterable, Func2<? super T, ? super T2, ? extends R> func2) {
        return m1690Z2(new OperatorZipIterable(iterable, func2));
    }

    /* renamed from: u1 */
    public final <U, V> Observable<T> m1523u1(Func0<? extends Observable<U>> func0, Func1<? super T, ? extends Observable<V>> func1) {
        return (Observable<T>) m1487z1(func0).m1690Z2(new OperatorDelayWithSelector(this, func1));
    }

    /* renamed from: u4 */
    public final ConnectableObservable<T> m1520u4(int i) {
        return OperatorReplay.m1086C7(this, i);
    }

    /* renamed from: u5 */
    public final Subscription m1519u5(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        if (action1 != null) {
            if (action12 != null) {
                if (action0 != null) {
                    return m1551q5(new ActionSubscriber(action1, action12, action0));
                }
                throw new IllegalArgumentException("onComplete can not be null");
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    /* renamed from: u6 */
    public final Observable<List<T>> m1518u6() {
        return (Observable<List<T>>) m1690Z2(OperatorToObservableList.m1040a());
    }

    /* renamed from: u7 */
    public final <T2, R> Observable<R> m1517u7(Observable<? extends T2> observable, Func2<? super T, ? super T2, ? extends R> func2) {
        return m1549q7(this, observable, func2);
    }

    /* renamed from: v1 */
    public final <U> Observable<T> m1515v1(Func1<? super T, ? extends Observable<U>> func1) {
        return (Observable<T>) m1690Z2(new OperatorDelayWithSelector(this, func1));
    }

    /* renamed from: v4 */
    public final ConnectableObservable<T> m1512v4(int i, long j, TimeUnit timeUnit) {
        return m1505w4(i, j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: v5 */
    public final Observable<T> m1511v5(Scheduler scheduler) {
        return m1504w5(scheduler, !(this.f44784a instanceof OnSubscribeCreate));
    }

    /* renamed from: v6 */
    public final <K> Observable<Map<K, T>> m1510v6(Func1<? super T, ? extends K> func1) {
        return m1830H6(new OnSubscribeToMap(this, func1, UtilityFunctions.m803c()));
    }

    /* renamed from: w1 */
    public final Observable<T> m1508w1(long j, TimeUnit timeUnit) {
        return m1501x1(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: w4 */
    public final ConnectableObservable<T> m1505w4(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        if (i >= 0) {
            return OperatorReplay.m1084E7(this, j, timeUnit, scheduler, i);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    /* renamed from: w5 */
    public final Observable<T> m1504w5(Scheduler scheduler, boolean z) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).m815z7(scheduler);
        }
        return m1830H6(new OperatorSubscribeOn(this, scheduler, z));
    }

    /* renamed from: w6 */
    public final <K, V> Observable<Map<K, V>> m1503w6(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        return m1830H6(new OnSubscribeToMap(this, func1, func12));
    }

    /* renamed from: x1 */
    public final Observable<T> m1501x1(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1830H6(new OnSubscribeDelaySubscription(this, j, timeUnit, scheduler));
    }

    /* renamed from: x4 */
    public final ConnectableObservable<T> m1498x4(int i, Scheduler scheduler) {
        return OperatorReplay.m1081H7(m1520u4(i), scheduler);
    }

    /* renamed from: x5 */
    public final Observable<T> m1497x5(Observable<? extends T> observable) {
        if (observable != null) {
            return m1830H6(new OnSubscribeSwitchIfEmpty(this, observable));
        }
        throw new NullPointerException("alternate is null");
    }

    /* renamed from: x6 */
    public final <K, V> Observable<Map<K, V>> m1496x6(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, V>> func0) {
        return m1830H6(new OnSubscribeToMap(this, func1, func12, func0));
    }

    /* renamed from: y1 */
    public final <U> Observable<T> m1494y1(Observable<U> observable) {
        observable.getClass();
        return m1830H6(new OnSubscribeDelaySubscriptionOther(this, observable));
    }

    /* renamed from: y4 */
    public final ConnectableObservable<T> m1491y4(long j, TimeUnit timeUnit) {
        return m1484z4(j, timeUnit, Schedulers.m479a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: y5 */
    public final <R> Observable<R> m1490y5(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return m1883A5(m1674b3(func1));
    }

    /* renamed from: y6 */
    public final <K> Observable<Map<K, Collection<T>>> m1489y6(Func1<? super T, ? extends K> func1) {
        return m1830H6(new OnSubscribeToMultimap(this, func1, UtilityFunctions.m803c()));
    }

    /* renamed from: z1 */
    public final <U> Observable<T> m1487z1(Func0<? extends Observable<U>> func0) {
        return m1830H6(new OnSubscribeDelaySubscriptionWithSelector(this, func0));
    }

    /* renamed from: z4 */
    public final ConnectableObservable<T> m1484z4(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return OperatorReplay.m1085D7(this, j, timeUnit, scheduler);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: z5 */
    public final <R> Observable<R> m1483z5(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return m1876B5(m1674b3(func1));
    }

    /* renamed from: z6 */
    public final <K, V> Observable<Map<K, Collection<V>>> m1482z6(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        return m1830H6(new OnSubscribeToMultimap(this, func1, func12));
    }
}
