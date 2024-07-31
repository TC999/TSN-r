package io.reactivex;

import io.reactivex.annotations.NonNull;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface SingleTransformer<Upstream, Downstream> {
    @NonNull
    SingleSource<Downstream> apply(@NonNull Single<Upstream> single);
}
