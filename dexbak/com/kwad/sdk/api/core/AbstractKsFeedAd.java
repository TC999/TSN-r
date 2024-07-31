package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractKsFeedAd implements KsFeedAd {
    @Override // com.kwad.sdk.api.KsFeedAd
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getFeedView(Context context) {
        return getFeedView2(Wrapper.wrapContextIfNeed(context));
    }

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    protected abstract View getFeedView2(Context context);
}
