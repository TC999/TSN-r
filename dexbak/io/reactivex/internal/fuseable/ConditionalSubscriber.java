package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface ConditionalSubscriber<T> extends FlowableSubscriber<T> {
    boolean tryOnNext(T t);
}
