package cn.jpush.android.g;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.asus.push.IAIDLInvoke;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class e implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f4206a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f4207b;

    private e(d dVar) {
        this.f4207b = dVar;
        this.f4206a = new LinkedBlockingQueue<>(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(d dVar, byte b4) {
        this(dVar);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            a.f4204a.set(false);
            cn.jpush.android.i.b.b("ServiceConnection", "onServiceConnected:" + componentName);
            if (iBinder != null) {
                this.f4206a.put(iBinder);
            } else {
                cn.jpush.android.i.b.g("ServiceConnection", "onServiceConnected, but IBinder is null.");
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        a.f4204a.set(false);
        d.a(this.f4207b, (IAIDLInvoke) null);
        cn.jpush.android.i.b.g("ServiceConnection", "onServiceDisconnected:" + componentName);
    }
}
