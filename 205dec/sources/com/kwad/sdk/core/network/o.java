package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class o<R extends f, T extends BaseResultData> implements g<R, T> {
    @Override // com.kwad.sdk.core.network.g
    public void onError(@NonNull R r3, int i4, String str) {
    }

    @Override // com.kwad.sdk.core.network.g
    public void onStartRequest(@NonNull R r3) {
    }

    @Override // com.kwad.sdk.core.network.g
    public void onSuccess(@NonNull R r3, @NonNull T t3) {
    }
}
