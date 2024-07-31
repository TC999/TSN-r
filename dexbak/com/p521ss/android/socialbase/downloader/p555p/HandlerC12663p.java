package com.p521ss.android.socialbase.downloader.p555p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: com.ss.android.socialbase.downloader.p.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HandlerC12663p extends Handler {

    /* renamed from: ok */
    private final WeakReference<InterfaceC12664ok> f35728ok;

    /* renamed from: com.ss.android.socialbase.downloader.p.p$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12664ok {
        /* renamed from: ok */
        void mo16744ok(Message message);
    }

    public HandlerC12663p(Looper looper, InterfaceC12664ok interfaceC12664ok) {
        super(looper);
        this.f35728ok = new WeakReference<>(interfaceC12664ok);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        InterfaceC12664ok interfaceC12664ok = this.f35728ok.get();
        if (interfaceC12664ok == null || message == null) {
            return;
        }
        interfaceC12664ok.mo16744ok(message);
    }
}
