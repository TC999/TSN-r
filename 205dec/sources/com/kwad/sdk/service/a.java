package com.kwad.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends com.kwad.sdk.m.a {
    private com.kwad.sdk.c aNQ;
    private Service aNS;
    private final Map<String, Integer> aNR = new ConcurrentHashMap();
    private final HandlerC0720a aNT = new HandlerC0720a(this);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.kwad.sdk.service.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class HandlerC0720a extends Handler {
        final WeakReference<a> aNU;

        public HandlerC0720a(a aVar) {
            this.aNU = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = this.aNU.get();
            if (aVar != null && message.what == 1) {
                if (aVar.aNQ != null && aVar.aNQ.xR()) {
                    aVar.aNS.stopSelf();
                } else {
                    sendEmptyMessageDelayed(1, PolicyConfig.mServerBusyRetryBaseInternal);
                }
            }
        }
    }

    private void g(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            int intExtra = intent.getIntExtra("download_service_type_tag", 0);
            String stringExtra = intent.getStringExtra("download_service_id_tag");
            DownloadTask.DownloadRequest downloadRequest = (DownloadTask.DownloadRequest) intent.getSerializableExtra("download_service_args_tag");
            Integer num = TextUtils.isEmpty(stringExtra) ? null : this.aNR.get(stringExtra);
            int intValue = num != null ? num.intValue() : 0;
            if (intExtra == 1) {
                this.aNR.put(stringExtra, Integer.valueOf(this.aNQ.a(downloadRequest, (com.kwad.sdk.a) null)));
            } else if (intExtra == 2) {
                this.aNQ.pause(intValue);
            } else if (intExtra == 3) {
                this.aNQ.resume(intValue);
            } else if (intExtra != 4) {
            } else {
                if (intValue != 0) {
                    this.aNQ.cancel(intValue);
                    return;
                }
                String stringExtra2 = intent.getStringExtra("download_service_path");
                if (stringExtra2 != null) {
                    com.kwad.sdk.c.bS(stringExtra2);
                }
            }
        } catch (Exception unused) {
        }
    }

    @InvokeBy(invokerClass = b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        b.a(DownloadService.class, a.class);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.aNS = service;
        this.aNQ = com.kwad.sdk.c.xL();
        this.aNT.sendEmptyMessageDelayed(1, PolicyConfig.mServerBusyRetryBaseInternal);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i4, int i5) {
        g(intent);
        return super.onStartCommand(service, intent, i4, i5);
    }
}
