package io.reactivex;

import io.reactivex.annotations.NonNull;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface SingleOnSubscribe<T> {
    void subscribe(@NonNull SingleEmitter<T> singleEmitter) throws Exception;
}
