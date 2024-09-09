package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n extends Handler {

    /* renamed from: c  reason: collision with root package name */
    protected WeakReference<c> f30203c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Message message);
    }

    public n(c cVar) {
        if (cVar != null) {
            this.f30203c = new WeakReference<>(cVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        c cVar;
        WeakReference<c> weakReference = this.f30203c;
        if (weakReference == null || (cVar = weakReference.get()) == null || message == null) {
            return;
        }
        cVar.c(message);
    }

    public n(Looper looper, c cVar) {
        super(looper);
        if (cVar != null) {
            this.f30203c = new WeakReference<>(cVar);
        }
    }
}
