package com.jg.ids;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public abstract class g extends f {

    /* renamed from: b  reason: collision with root package name */
    private ServiceConnection f37825b;

    protected abstract Intent a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(IBinder iBinder);

    public g(Context context) {
        super(context);
        this.f37825b = new h(this);
        if (c() && d()) {
            try {
                this.f37822a.bindService(a(), this.f37825b, 1);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        try {
            this.f37822a.unbindService(this.f37825b);
        } catch (Throwable th) {
        }
    }
}
