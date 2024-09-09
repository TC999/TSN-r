package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import ms.bz.bd.c.Pgl.u0;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class w0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f61471a;

    /* renamed from: b  reason: collision with root package name */
    e1 f61472b;

    /* renamed from: c  reason: collision with root package name */
    ServiceConnection f61473c = new pgla();

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w0.this.f61472b = new e1(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public w0(Context context) {
        this.f61471a = context;
    }

    public void a(u0.pblb pblbVar) {
        Intent intent = new Intent();
        intent.setClassName((String) pblk.a(16777217, 0, 0L, "11eb46", new byte[]{35, 60, 27, 88, 17, 52, 59, 94, 48, 55, 54, 58, 21, 19, 2, 37, 33, 21, 38, 36, 41, 48, 19}), (String) pblk.a(16777217, 0, 0L, "70fd19", new byte[]{37, 61, 24, 94, 20, 59, 61, 95, 51, 49, 48, 59, 22, 21, 7, 42, 39, 20, 37, 34, 47, 49, 16, 94, 42, 43, 34, 24, 52, 49, 47, 54, 38, 21, 28, 56, 61, 18, 50}));
        if (this.f61471a.bindService(intent, this.f61473c, 1)) {
            try {
                e1 e1Var = this.f61472b;
                if (e1Var != null) {
                    String c4 = e1Var.c();
                    if (pblbVar != null) {
                        pblbVar.c(c4);
                    }
                }
            } catch (Throwable unused) {
            }
            this.f61471a.unbindService(this.f61473c);
        }
    }
}
