package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* renamed from: com.kwad.sdk.core.network.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10439o<R extends InterfaceC10420f, T extends BaseResultData> implements InterfaceC10421g<R, T> {
    @Override // com.kwad.sdk.core.network.InterfaceC10421g
    public void onError(@NonNull R r, int i, String str) {
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10421g
    public void onStartRequest(@NonNull R r) {
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10421g
    public void onSuccess(@NonNull R r, @NonNull T t) {
    }
}
