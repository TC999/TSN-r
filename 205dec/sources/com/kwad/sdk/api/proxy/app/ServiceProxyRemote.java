package com.kwad.sdk.api.proxy.app;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyService;
import com.kwad.sdk.api.proxy.IServiceProxy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ServiceProxyRemote extends BaseProxyService {

    /* renamed from: com.kwad.sdk.api.proxy.app.ServiceProxyRemote$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class AnonymousClass1 implements IServiceProxy {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.proxy.IServiceProxy
        public IBinder onBind(@NonNull Service service, Intent intent) {
            return null;
        }

        @Override // com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(@NonNull Service service) {
        }

        @Override // com.kwad.sdk.api.proxy.IServiceProxy
        public void onDestroy(@NonNull Service service) {
        }

        @Override // com.kwad.sdk.api.proxy.IServiceProxy
        public void onRebind(@NonNull Service service, Intent intent) {
        }

        @Override // com.kwad.sdk.api.proxy.IServiceProxy
        public int onStartCommand(@NonNull Service service, Intent intent, int i4, int i5) {
            return 0;
        }

        @Override // com.kwad.sdk.api.proxy.IServiceProxy
        public boolean onUnbind(Service service, Intent intent) {
            return false;
        }
    }

    @Override // com.kwad.sdk.api.proxy.BaseProxyService
    @NonNull
    public IServiceProxy getDelegate(Context context) {
        return (IServiceProxy) Loader.get().newComponentProxy(context, ServiceProxyRemote.class, this);
    }
}
