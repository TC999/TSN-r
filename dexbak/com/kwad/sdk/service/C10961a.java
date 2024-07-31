package com.kwad.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.AbstractC9667a;
import com.kwad.sdk.C9774c;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
import com.kwad.sdk.p443m.AbstractC10859a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.kwad.sdk.service.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10961a extends AbstractC10859a {
    private C9774c aNQ;
    private Service aNS;
    private final Map<String, Integer> aNR = new ConcurrentHashMap();
    private final HandlerC10962a aNT = new HandlerC10962a(this);

    /* renamed from: com.kwad.sdk.service.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class HandlerC10962a extends Handler {
        final WeakReference<C10961a> aNU;

        public HandlerC10962a(C10961a c10961a) {
            this.aNU = new WeakReference<>(c10961a);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            C10961a c10961a = this.aNU.get();
            if (c10961a != null && message.what == 1) {
                if (c10961a.aNQ != null && c10961a.aNQ.m27784xR()) {
                    c10961a.aNS.stopSelf();
                } else {
                    sendEmptyMessageDelayed(1, 30000L);
                }
            }
        }
    }

    /* renamed from: g */
    private void m24355g(Intent intent) {
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
                this.aNR.put(stringExtra, Integer.valueOf(this.aNQ.m27798a(downloadRequest, (AbstractC9667a) null)));
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
                    C9774c.m27795bS(stringExtra2);
                }
            }
        } catch (Exception unused) {
        }
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        C10973b.m24291a(DownloadService.class, C10961a.class);
    }

    @Override // com.kwad.sdk.p443m.AbstractC10859a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.aNS = service;
        this.aNQ = C9774c.m27790xL();
        this.aNT.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.p443m.AbstractC10859a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        m24355g(intent);
        return super.onStartCommand(service, intent, i, i2);
    }
}
