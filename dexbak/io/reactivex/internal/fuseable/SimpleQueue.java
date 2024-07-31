package io.reactivex.internal.fuseable;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(@NonNull T t);

    boolean offer(@NonNull T t, @NonNull T t2);

    @Nullable
    T poll() throws Exception;
}