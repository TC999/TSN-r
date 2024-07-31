package com.kwad.sdk.collector.p371b;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.C9796d;
import com.kwad.sdk.collector.model.InterfaceC9808b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p443m.AbstractC10859a;
import com.kwad.sdk.service.C10973b;
import com.kwad.sdk.utils.C11024aq;
import com.kwad.sdk.utils.C11082f;
import com.kwad.sdk.utils.C11126t;
import com.kwad.sdk.utils.SystemUtil;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* renamed from: com.kwad.sdk.collector.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9787a extends AbstractC10859a {
    private static AtomicBoolean anJ = new AtomicBoolean(false);
    public static volatile Message anK;
    private HandlerC9789a anH = new HandlerC9789a((byte) 0);
    private Messenger anI = new Messenger(this.anH);

    /* renamed from: com.kwad.sdk.collector.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class HandlerC9789a extends Handler {
        private WeakReference<Service> anM;

        private HandlerC9789a() {
        }

        /* renamed from: a */
        public final void m27771a(@Nullable Service service) {
            if (service != null) {
                this.anM = new WeakReference<>(service);
            } else {
                this.anM = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            C10331c.m26254d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.anM;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!C9787a.m27779AF().get()) {
                C10331c.m26254d("RemoteService", "save buffered message");
                C9787a.anK = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i = message.what;
            C10331c.m26254d("RemoteService", "handleMessage what: " + i);
            if (i != 100) {
                return;
            }
            final Bundle bundle = new Bundle();
            C11082f.m23816a(service, new C11082f.InterfaceC11090b() { // from class: com.kwad.sdk.collector.b.a.a.1
                @Override // com.kwad.sdk.utils.C11082f.InterfaceC11090b
                /* renamed from: u */
                public final void mo23792u(List<InterfaceC9808b> list) {
                    C10331c.m26254d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                    if (list != null && !list.isEmpty()) {
                        C10331c.m26254d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray m23801L = C11082f.C11089a.m23801L(list);
                        String jSONArray = m23801L != null ? m23801L.toString() : null;
                        C10331c.m26254d("RemoteService", "resultJson :" + jSONArray);
                        if (jSONArray != null) {
                            AppStatusRules m23828KR = C11082f.m23828KR();
                            ArrayList<AppStatusRules.Strategy> allStrategy = m23828KR != null ? m23828KR.getAllStrategy() : null;
                            String jSONArray2 = allStrategy != null ? C11126t.m23681O(allStrategy).toString() : null;
                            bundle.putString("resultJson", jSONArray);
                            bundle.putString("allStrategyJson", jSONArray2);
                        }
                    }
                    try {
                        Message obtain = Message.obtain();
                        obtain.what = 101;
                        obtain.setData(bundle);
                        messenger.send(obtain);
                    } catch (RemoteException unused) {
                    }
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    for (InterfaceC9808b interfaceC9808b : list) {
                        interfaceC9808b.destroy();
                    }
                }
            });
        }

        /* synthetic */ HandlerC9789a(byte b) {
            this();
        }
    }

    /* renamed from: AF */
    public static AtomicBoolean m27779AF() {
        return anJ;
    }

    /* renamed from: aO */
    private static boolean m27774aO(Context context) {
        String processName = C11024aq.getProcessName(context);
        return (processName == null || context.getPackageName().equals(processName)) ? false : true;
    }

    /* renamed from: b */
    public static void m27773b(@NonNull Context context, ServiceConnection serviceConnection) {
        C10331c.m26254d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        try {
            C10973b.m24291a(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), C9787a.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.p443m.AbstractC10859a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return this.anI.getBinder();
    }

    @Override // com.kwad.sdk.p443m.AbstractC10859a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(C11024aq.getProcessName(StubApp.getOrigApplicationContext(service.getApplicationContext())));
            } catch (Exception e) {
                C10331c.m26254d("RemoteService", "WebView has already been initialized " + e.getMessage());
            }
        }
        C10331c.m26254d("RemoteService", "onCreate processName:" + C11024aq.getProcessName(service));
        if (!SystemUtil.isInMainProcess(service)) {
            C9796d.m27762a(service, new C9796d.InterfaceC9798a() { // from class: com.kwad.sdk.collector.b.a.1
                @Override // com.kwad.sdk.collector.C9796d.InterfaceC9798a
                /* renamed from: cq */
                public final void mo27756cq(String str) {
                    C10331c.m26250e("RemoteService", "onLoadError: " + str);
                    C9787a.anJ.set(false);
                }

                @Override // com.kwad.sdk.collector.C9796d.InterfaceC9798a
                public final void onLoaded() {
                    C10331c.m26254d("RemoteService", "onLoaded");
                    C9787a.anJ.set(true);
                    if (C9787a.anK != null) {
                        C9787a.this.anH.handleMessage(C9787a.anK);
                        C9787a.anK = null;
                    }
                }
            });
        } else {
            anJ.set(true);
        }
        this.anH.m27771a(service);
    }

    @Override // com.kwad.sdk.p443m.AbstractC10859a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        super.onDestroy(service);
        C10331c.m26254d("RemoteService", "onDestroy");
        this.anH.m27771a(null);
        if (m27774aO(service)) {
            C10331c.m26254d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }

    /* renamed from: a */
    public static void m27778a(@NonNull Context context, ServiceConnection serviceConnection) {
        C10331c.m26254d("RemoteService", "bindASService");
        context.bindService(new Intent(context, ServiceProxyRemote.class), serviceConnection, 1);
    }
}
