package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface KsInitCallback {
    void onFail(int i, String str);

    void onSuccess();
}
