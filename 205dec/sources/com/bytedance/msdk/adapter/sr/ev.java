package com.bytedance.msdk.adapter.sr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends Handler {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<c> f27205c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Message message);
    }

    public ev(Looper looper, c cVar) {
        super(looper);
        this.f27205c = new WeakReference<>(cVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        c cVar = this.f27205c.get();
        if (cVar == null || message == null) {
            return;
        }
        cVar.c(message);
    }
}
