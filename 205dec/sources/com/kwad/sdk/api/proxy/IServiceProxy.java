package com.kwad.sdk.api.proxy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IServiceProxy extends IComponentProxy {
    @KsAdSdkDynamicApi
    @Keep
    IBinder onBind(@NonNull Service service, Intent intent);

    @KsAdSdkDynamicApi
    @Keep
    void onCreate(@NonNull Service service);

    @KsAdSdkDynamicApi
    @Keep
    void onDestroy(@NonNull Service service);

    @KsAdSdkDynamicApi
    @Keep
    void onRebind(@NonNull Service service, Intent intent);

    @KsAdSdkDynamicApi
    @Keep
    int onStartCommand(@NonNull Service service, Intent intent, int i4, int i5);

    boolean onUnbind(Service service, Intent intent);
}
