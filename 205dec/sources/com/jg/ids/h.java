package com.jg.ids;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: E:\TSN-r\205dec\93344.dex */
final class h implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ g f37827a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f37827a = gVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f37827a.a(iBinder);
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
