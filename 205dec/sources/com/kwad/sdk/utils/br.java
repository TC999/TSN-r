package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class br extends Handler {
    private WeakReference<a> aRc;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(Message message);
    }

    public br(a aVar) {
        this.aRc = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        WeakReference<a> weakReference;
        a aVar;
        try {
            weakReference = this.aRc;
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            return;
        }
        aVar.a(message);
        super.handleMessage(message);
    }
}
