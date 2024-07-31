package com.kwad.sdk.api.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractKsNativeAd implements KsNativeAd {
    @KsAdSdkDynamicApi
    @Keep
    public abstract Bitmap getSdkLogo();

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getVideoView(Context context, boolean z) {
        return getVideoView2(Wrapper.wrapContextIfNeed(context), z);
    }

    @KsAdSdkDynamicApi
    @Keep
    protected abstract View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkDynamicApi
    @Keep
    protected abstract View getVideoView2(Context context, boolean z);

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getVideoView(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        return getVideoView2(Wrapper.wrapContextIfNeed(context), ksAdVideoPlayConfig);
    }
}
