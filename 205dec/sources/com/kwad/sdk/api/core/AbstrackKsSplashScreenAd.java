package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.loader.Wrapper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class AbstrackKsSplashScreenAd implements KsSplashScreenAd {
    @Override // com.kwad.sdk.api.KsSplashScreenAd
    @Nullable
    @KsAdSdkDynamicApi
    public View getView(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        return getView2(Wrapper.wrapContextIfNeed(context), splashScreenAdInteractionListener);
    }

    @Nullable
    @KsAdSdkDynamicApi
    public abstract View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener);
}