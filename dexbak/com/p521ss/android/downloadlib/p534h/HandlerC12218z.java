package com.p521ss.android.downloadlib.p534h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: com.ss.android.downloadlib.h.z */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HandlerC12218z extends Handler {

    /* renamed from: ok */
    WeakReference<InterfaceC12219ok> f34495ok;

    /* renamed from: com.ss.android.downloadlib.h.z$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12219ok {
        /* renamed from: ok */
        void mo18671ok(Message message);
    }

    public HandlerC12218z(Looper looper, InterfaceC12219ok interfaceC12219ok) {
        super(looper);
        this.f34495ok = new WeakReference<>(interfaceC12219ok);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        InterfaceC12219ok interfaceC12219ok = this.f34495ok.get();
        if (interfaceC12219ok == null || message == null) {
            return;
        }
        interfaceC12219ok.mo18671ok(message);
    }
}
