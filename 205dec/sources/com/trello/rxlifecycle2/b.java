package com.trello.rxlifecycle2;

import io.reactivex.Observable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LifecycleProvider.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface b<E> {
    @Nonnull
    @CheckReturnValue
    <T> c<T> I(@Nonnull E e4);

    @Nonnull
    @CheckReturnValue
    Observable<E> n();

    @Nonnull
    @CheckReturnValue
    <T> c<T> t();
}
