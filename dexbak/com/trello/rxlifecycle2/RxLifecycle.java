package com.trello.rxlifecycle2;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import p657x0.C16238a;

/* renamed from: com.trello.rxlifecycle2.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RxLifecycle {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: RxLifecycle.java */
    /* renamed from: com.trello.rxlifecycle2.d$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13096a<R> implements Predicate<R> {

        /* renamed from: a */
        final /* synthetic */ Object f37504a;

        C13096a(Object obj) {
            this.f37504a = obj;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(R r) throws Exception {
            return r.equals(this.f37504a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: RxLifecycle.java */
    /* renamed from: com.trello.rxlifecycle2.d$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13097b<R> implements BiFunction<R, R, Boolean> {
        C13097b() {
        }

        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a */
        public Boolean apply(R r, R r2) throws Exception {
            return Boolean.valueOf(r2.equals(r));
        }
    }

    private RxLifecycle() {
        throw new AssertionError("No instances");
    }

    @Nonnull
    @CheckReturnValue
    /* renamed from: a */
    public static <T, R> LifecycleTransformer<T> m14873a(@Nonnull Observable<R> observable) {
        return new LifecycleTransformer<>(observable);
    }

    @Nonnull
    @CheckReturnValue
    /* renamed from: b */
    public static <T, R> LifecycleTransformer<T> m14872b(@Nonnull Observable<R> observable, @Nonnull Function<R, R> function) {
        C16238a.m40a(observable, "lifecycle == null");
        C16238a.m40a(function, "correspondingEvents == null");
        return m14873a(m14870d(observable.share(), function));
    }

    @Nonnull
    @CheckReturnValue
    /* renamed from: c */
    public static <T, R> LifecycleTransformer<T> m14871c(@Nonnull Observable<R> observable, @Nonnull R r) {
        C16238a.m40a(observable, "lifecycle == null");
        C16238a.m40a(r, "event == null");
        return m14873a(m14869e(observable, r));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    private static <R> Observable<Boolean> m14870d(Observable<R> observable, Function<R, R> function) {
        return Observable.combineLatest(observable.take(1L).map(function), observable.skip(1L), new C13097b()).onErrorReturn(Functions.f37470a).filter(Functions.f37471b);
    }

    /* renamed from: e */
    private static <R> Observable<R> m14869e(Observable<R> observable, R r) {
        return observable.filter(new C13096a(r));
    }
}
