package com.trello.rxlifecycle2;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RxLifecycle.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: RxLifecycle.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a<R> implements Predicate<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f52402a;

        a(Object obj) {
            this.f52402a = obj;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(R r3) throws Exception {
            return r3.equals(this.f52402a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: RxLifecycle.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class b<R> implements BiFunction<R, R, Boolean> {
        b() {
        }

        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a */
        public Boolean apply(R r3, R r4) throws Exception {
            return Boolean.valueOf(r4.equals(r3));
        }
    }

    private d() {
        throw new AssertionError("No instances");
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> c<T> a(@Nonnull Observable<R> observable) {
        return new c<>(observable);
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> c<T> b(@Nonnull Observable<R> observable, @Nonnull Function<R, R> function) {
        p1.a.a(observable, "lifecycle == null");
        p1.a.a(function, "correspondingEvents == null");
        return a(d(observable.share(), function));
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> c<T> c(@Nonnull Observable<R> observable, @Nonnull R r3) {
        p1.a.a(observable, "lifecycle == null");
        p1.a.a(r3, "event == null");
        return a(e(observable, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <R> Observable<Boolean> d(Observable<R> observable, Function<R, R> function) {
        return Observable.combineLatest(observable.take(1L).map(function), observable.skip(1L), new b()).onErrorReturn(com.trello.rxlifecycle2.a.f52368a).filter(com.trello.rxlifecycle2.a.f52369b);
    }

    private static <R> Observable<R> e(Observable<R> observable, R r3) {
        return observable.filter(new a(r3));
    }
}
