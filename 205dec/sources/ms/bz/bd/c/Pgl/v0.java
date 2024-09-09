package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import ms.bz.bd.c.Pgl.u0;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class v0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f61467a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f61468b = new LinkedBlockingQueue<>(1024);

    /* renamed from: c  reason: collision with root package name */
    ServiceConnection f61469c = new pgla();

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                v0.this.f61468b.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public v0(Context context) {
        this.f61467a = context;
    }

    public void a(u0.pblb pblbVar) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 != 28 && i4 < 33) {
            try {
                this.f61467a.getPackageManager().getPackageInfo((String) pblk.a(16777217, 0, 0L, "241367", new byte[]{32, 57, 79, 9, 1, 53, 48, 2, 101, 106, 109, 62, 85, 78, 13}), 0);
            } catch (Exception unused) {
            }
            Intent intent = new Intent((String) pblk.a(16777217, 0, 0L, "9fa349", new byte[]{43, 107, 31, 9, 30, 33, 62, 78, 35, 45, 39, 116, 23, 73, 15, 43, 44, 78, 51, 102, 102, 75, 34, 98, 37, 7, 30, 116, 15, 80, 13, 86, 36, 110, 40, 11}));
            intent.setPackage((String) pblk.a(16777217, 0, 0L, "d24522", new byte[]{118, 63, 74, 15, 5, 48, 102, 4, 96, 108, 59, 56, 80, 72, 9}));
            if (this.f61467a.bindService(intent, this.f61469c, 1)) {
                try {
                    String c4 = new d1(this.f61468b.take()).c();
                    if (pblbVar != null) {
                        pblbVar.c(c4);
                    }
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    this.f61467a.unbindService(this.f61469c);
                    throw th;
                }
                this.f61467a.unbindService(this.f61469c);
            }
        }
    }
}
