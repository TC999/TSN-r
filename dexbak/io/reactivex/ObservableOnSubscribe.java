package io.reactivex;

import io.reactivex.annotations.NonNull;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface ObservableOnSubscribe<T> {
    void subscribe(@NonNull ObservableEmitter<T> observableEmitter) throws Exception;
}
