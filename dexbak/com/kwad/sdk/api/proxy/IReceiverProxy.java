package com.kwad.sdk.api.proxy;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IReceiverProxy extends IComponentProxy {
    @KsAdSdkDynamicApi
    @Keep
    void onReceive(Context context, Intent intent);
}
