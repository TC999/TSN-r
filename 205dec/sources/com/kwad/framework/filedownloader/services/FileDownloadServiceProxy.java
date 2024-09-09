package com.kwad.framework.filedownloader.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwad.sdk.utils.aq;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicImpl(FileDownloadService.class)
@Keep
@SuppressLint({"Registered"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class FileDownloadServiceProxy extends com.kwad.sdk.m.a {
    private static final String TAG = "filedownloader";
    public Service context;
    private i handler;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkDynamicImpl(FileDownloadService.SeparateProcessService.class)
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class SeparateProcessServiceProxy extends FileDownloadServiceProxy {
        @Override // com.kwad.framework.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    WebView.setDataDirectorySuffix(aq.getProcessName(service.getApplicationContext()));
                } catch (Exception unused) {
                }
            }
            super.onCreate(service);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkDynamicImpl(FileDownloadService.SharedMainProcessService.class)
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class SharedMainProcessServiceProxy extends FileDownloadServiceProxy {
        @Override // com.kwad.framework.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            super.onCreate(service);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(FileDownloadService.SeparateProcessService.class, SeparateProcessServiceProxy.class);
        com.kwad.sdk.service.b.a(FileDownloadService.SharedMainProcessService.class, SharedMainProcessServiceProxy.class);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(Service service, Intent intent) {
        return this.handler.wC();
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.context = service;
        com.kwad.framework.filedownloader.f.c.am(service);
        try {
            com.kwad.framework.filedownloader.f.f.bM(com.kwad.framework.filedownloader.f.e.wN().aim);
            com.kwad.framework.filedownloader.f.f.V(com.kwad.framework.filedownloader.f.e.wN().ain);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
        g gVar = new g();
        if (com.kwad.framework.filedownloader.f.e.wN().aip) {
            this.handler = new e(new WeakReference(this), gVar);
        } else {
            this.handler = new d(new WeakReference(this), gVar);
        }
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        this.handler.onDestroy();
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i4, int i5) {
        this.handler.wB();
        return 2;
    }
}
