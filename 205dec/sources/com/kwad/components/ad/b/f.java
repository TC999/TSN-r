package com.kwad.components.ad.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface f extends com.kwad.sdk.components.a {
    void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener);

    void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener);
}