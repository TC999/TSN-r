package com.trello.rxlifecycle2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import javax.annotation.ParametersAreNonnullByDefault;
import org.reactivestreams.Publisher;
import p657x0.C16238a;

@ParametersAreNonnullByDefault
/* renamed from: com.trello.rxlifecycle2.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class LifecycleTransformer<T> implements ObservableTransformer<T, T>, FlowableTransformer<T, T>, SingleTransformer<T, T>, MaybeTransformer<T, T>, CompletableTransformer {

    /* renamed from: a */
    final Observable<?> f37487a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LifecycleTransformer(Observable<?> observable) {
        C16238a.m40a(observable, "observable == null");
        this.f37487a = observable;
    }

    @Override // io.reactivex.ObservableTransformer
    public ObservableSource<T> apply(Observable<T> observable) {
        return observable.takeUntil(this.f37487a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LifecycleTransformer.class != obj.getClass()) {
            return false;
        }
        return this.f37487a.equals(((LifecycleTransformer) obj).f37487a);
    }

    public int hashCode() {
        return this.f37487a.hashCode();
    }

    public String toString() {
        return "LifecycleTransformer{observable=" + this.f37487a + '}';
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return flowable.takeUntil(this.f37487a.toFlowable(BackpressureStrategy.LATEST));
    }

    @Override // io.reactivex.SingleTransformer
    public SingleSource<T> apply(Single<T> single) {
        return single.takeUntil(this.f37487a.firstOrError());
    }

    @Override // io.reactivex.MaybeTransformer
    public MaybeSource<T> apply(Maybe<T> maybe) {
        return maybe.takeUntil(this.f37487a.firstElement());
    }

    @Override // io.reactivex.CompletableTransformer
    public CompletableSource apply(Completable completable) {
        return Completable.ambArray(completable, this.f37487a.flatMapCompletable(Functions.f37472c));
    }
}
