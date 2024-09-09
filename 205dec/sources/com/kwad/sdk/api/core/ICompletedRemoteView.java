package com.kwad.sdk.api.core;

import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.annotation.Keep;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface ICompletedRemoteView {
    @KsAdSdkDynamicApi
    @Keep
    RemoteViews build();

    @KsAdSdkDynamicApi
    @Keep
    void setIcon(@DrawableRes int i4);

    @KsAdSdkDynamicApi
    @Keep
    void setIcon(Bitmap bitmap);

    @KsAdSdkDynamicApi
    @Keep
    void setInstallText(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setName(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setSize(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setStatus(String str);
}
