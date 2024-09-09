package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.loader.Wrapper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class AbstractKsDrawAd implements KsDrawAd {
    @Override // com.kwad.sdk.api.KsDrawAd
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getDrawView(Context context) {
        return getDrawView2(Wrapper.wrapContextIfNeed(context));
    }

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    protected abstract View getDrawView2(Context context);
}
