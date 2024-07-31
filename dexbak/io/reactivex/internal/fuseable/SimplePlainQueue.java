package io.reactivex.internal.fuseable;

import io.reactivex.annotations.Nullable;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface SimplePlainQueue<T> extends SimpleQueue<T> {
    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    T poll();
}
