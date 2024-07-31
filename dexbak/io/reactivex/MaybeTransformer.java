package io.reactivex;

import io.reactivex.annotations.NonNull;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface MaybeTransformer<Upstream, Downstream> {
    @NonNull
    MaybeSource<Downstream> apply(@NonNull Maybe<Upstream> maybe);
}
