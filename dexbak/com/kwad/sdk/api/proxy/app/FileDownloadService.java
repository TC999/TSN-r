package com.kwad.sdk.api.proxy.app;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyService;
import com.kwad.sdk.api.proxy.IServiceProxy;

@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FileDownloadService {

    @Keep
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class SeparateProcessService extends BaseProxyService {
        @Override // com.kwad.sdk.api.proxy.BaseProxyService
        @NonNull
        public IServiceProxy getDelegate(Context context) {
            return (IServiceProxy) Loader.get().newComponentProxy(context, SeparateProcessService.class, this);
        }
    }

    @Keep
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class SharedMainProcessService extends BaseProxyService {
        @Override // com.kwad.sdk.api.proxy.BaseProxyService
        @NonNull
        public IServiceProxy getDelegate(Context context) {
            return (IServiceProxy) Loader.get().newComponentProxy(context, SharedMainProcessService.class, this);
        }
    }
}
