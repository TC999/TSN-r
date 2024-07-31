package com.bytedance.msdk.adapter.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class WeakHandler extends Handler {

    /* renamed from: a */
    private final WeakReference<IHandler> f21529a;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface IHandler {
        void handleMsg(Message message);
    }

    public WeakHandler(IHandler iHandler) {
        this.f21529a = new WeakReference<>(iHandler);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IHandler iHandler = this.f21529a.get();
        if (iHandler == null || message == null) {
            return;
        }
        iHandler.handleMsg(message);
    }

    public WeakHandler(Looper looper, IHandler iHandler) {
        super(looper);
        this.f21529a = new WeakReference<>(iHandler);
    }
}
