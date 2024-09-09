package com.bytedance.msdk.adapter.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class WeakHandler extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<IHandler> f27247a;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface IHandler {
        void handleMsg(Message message);
    }

    public WeakHandler(IHandler iHandler) {
        this.f27247a = new WeakReference<>(iHandler);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IHandler iHandler = this.f27247a.get();
        if (iHandler == null || message == null) {
            return;
        }
        iHandler.handleMsg(message);
    }

    public WeakHandler(Looper looper, IHandler iHandler) {
        super(looper);
        this.f27247a = new WeakReference<>(iHandler);
    }
}
