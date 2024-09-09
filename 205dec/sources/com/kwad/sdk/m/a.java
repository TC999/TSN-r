package com.kwad.sdk.m;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.proxy.BaseProxyService;
import com.kwad.sdk.api.proxy.IServiceProxy;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a implements IServiceProxy {

    /* renamed from: com.kwad.sdk.m.a$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass1 extends com.kwad.sdk.core.c.d {
        final /* synthetic */ List aOn;

        AnonymousClass1(List list) {
            this.aOn = list;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityCreated */
        public final void a(Activity activity, Bundle bundle) {
            super.a(activity, bundle);
            try {
                a.a(activity, this.aOn);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.e(a.TAG, Log.getStackTraceString(th));
            }
        }
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
        if (service instanceof BaseProxyService) {
            return ((BaseProxyService) service).superOnStartCommand(intent, i4, i5);
        }
        throw new RuntimeException(service + " must be AbstractServiceProxy");
    }

    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public boolean onUnbind(Service service, Intent intent) {
        if (service instanceof BaseProxyService) {
            return ((BaseProxyService) service).superOnUnbind(intent);
        }
        throw new RuntimeException(service + " must be AbstractServiceProxy");
    }
}
