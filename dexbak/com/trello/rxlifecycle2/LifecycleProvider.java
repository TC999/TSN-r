package com.trello.rxlifecycle2;

import io.reactivex.Observable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

/* renamed from: com.trello.rxlifecycle2.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface LifecycleProvider<E> {
    @Nonnull
    @CheckReturnValue
    /* renamed from: I */
    <T> LifecycleTransformer<T> mo14877I(@Nonnull E e);

    @Nonnull
    @CheckReturnValue
    /* renamed from: n */
    Observable<E> mo14875n();

    @Nonnull
    @CheckReturnValue
    /* renamed from: t */
    <T> LifecycleTransformer<T> mo14874t();
}
