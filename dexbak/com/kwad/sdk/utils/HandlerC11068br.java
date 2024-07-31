package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Message;
import com.kwad.sdk.core.p397e.C10331c;
import java.lang.ref.WeakReference;

/* renamed from: com.kwad.sdk.utils.br */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class HandlerC11068br extends Handler {
    private WeakReference<InterfaceC11069a> aRc;

    /* renamed from: com.kwad.sdk.utils.br$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11069a {
        /* renamed from: a */
        void mo23849a(Message message);
    }

    public HandlerC11068br(InterfaceC11069a interfaceC11069a) {
        this.aRc = new WeakReference<>(interfaceC11069a);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        WeakReference<InterfaceC11069a> weakReference;
        InterfaceC11069a interfaceC11069a;
        try {
            weakReference = this.aRc;
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
        if (weakReference == null || (interfaceC11069a = weakReference.get()) == null) {
            return;
        }
        interfaceC11069a.mo23849a(message);
        super.handleMessage(message);
    }
}
