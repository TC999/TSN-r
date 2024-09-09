package com.jg.ids;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ a f37808a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Looper looper) {
        super(looper);
        this.f37808a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            this.f37808a.a(message);
        } catch (Throwable th) {
        }
    }
}
