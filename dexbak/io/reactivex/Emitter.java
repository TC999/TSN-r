package io.reactivex;

import io.reactivex.annotations.NonNull;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface Emitter<T> {
    void onComplete();

    void onError(@NonNull Throwable th);

    void onNext(@NonNull T t);
}
