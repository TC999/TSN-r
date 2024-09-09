package com.ss.android.downloadlib.r;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class bk extends Handler {

    /* renamed from: c  reason: collision with root package name */
    WeakReference<c> f48915c;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface c {
        void c(Message message);
    }

    public bk(Looper looper, c cVar) {
        super(looper);
        this.f48915c = new WeakReference<>(cVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        c cVar = this.f48915c.get();
        if (cVar == null || message == null) {
            return;
        }
        cVar.c(message);
    }
}
