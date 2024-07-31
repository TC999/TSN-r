package com.kwad.framework.filedownloader.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.framework.filedownloader.p353f.C9499e;
import com.kwad.framework.filedownloader.p353f.C9501f;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwad.sdk.p443m.AbstractC10859a;
import com.kwad.sdk.service.C10973b;
import com.kwad.sdk.utils.C11024aq;
import java.lang.ref.WeakReference;

@KsAdSdkDynamicImpl(FileDownloadService.class)
@Keep
@SuppressLint({"Registered"})
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FileDownloadServiceProxy extends AbstractC10859a {
    private static final String TAG = "filedownloader";
    public Service context;
    private InterfaceC9575i handler;

    @KsAdSdkDynamicImpl(FileDownloadService.SeparateProcessService.class)
    @Keep
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class SeparateProcessServiceProxy extends FileDownloadServiceProxy {
        @Override // com.kwad.framework.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.p443m.AbstractC10859a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    WebView.setDataDirectorySuffix(C11024aq.getProcessName(service.getApplicationContext()));
                } catch (Exception unused) {
                }
            }
            super.onCreate(service);
        }
    }

    @KsAdSdkDynamicImpl(FileDownloadService.SharedMainProcessService.class)
    @Keep
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class SharedMainProcessServiceProxy extends FileDownloadServiceProxy {
        @Override // com.kwad.framework.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.p443m.AbstractC10859a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            super.onCreate(service);
        }
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        C10973b.m24291a(FileDownloadService.SeparateProcessService.class, SeparateProcessServiceProxy.class);
        C10973b.m24291a(FileDownloadService.SharedMainProcessService.class, SharedMainProcessServiceProxy.class);
    }

    @Override // com.kwad.sdk.p443m.AbstractC10859a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(Service service, Intent intent) {
        return this.handler.mo28355wC();
    }

    @Override // com.kwad.sdk.p443m.AbstractC10859a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.context = service;
        C9492c.m28545am(service);
        try {
            C9501f.m28511bM(C9499e.m28530wN().aim);
            C9501f.m28526V(C9499e.m28530wN().ain);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        C9573g c9573g = new C9573g();
        if (C9499e.m28530wN().aip) {
            this.handler = new BinderC9570e(new WeakReference(this), c9573g);
        } else {
            this.handler = new BinderC9569d(new WeakReference(this), c9573g);
        }
    }

    @Override // com.kwad.sdk.p443m.AbstractC10859a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        this.handler.onDestroy();
    }

    @Override // com.kwad.sdk.p443m.AbstractC10859a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        this.handler.mo28356wB();
        return 2;
    }
}
