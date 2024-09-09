package com.qq.e.comm.plugin.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class q2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final WeakReference<a> f46576a;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a {
        void handleMessage(Message message);
    }

    public q2(a aVar, Looper looper) {
        super(looper);
        this.f46576a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.f46576a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.handleMessage(message);
    }
}
