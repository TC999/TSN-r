package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import ms.bz.bd.c.Pgl.u0;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class t0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f61460a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f61461b = new LinkedBlockingQueue<>(1024);

    /* renamed from: c  reason: collision with root package name */
    ServiceConnection f61462c = new pgla();

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                t0.this.f61461b.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public t0(Context context) {
        this.f61460a = context;
    }

    public void a(u0.pblb pblbVar) {
        try {
            this.f61460a.getPackageManager().getPackageInfo((String) pblk.a(16777217, 0, 0L, "3074b2", new byte[]{33, 61, 73, 14, 92, 54, 37, 2, 40, 105, 49, 51, 10, 115, 72, 53, 32, 29, 99, 105, 39, 60, 80, 65, 79, 60, 20, 56, 66}), 0);
        } catch (Exception unused) {
        }
        Intent intent = new Intent();
        intent.setAction((String) pblk.a(16777217, 0, 0L, "19d989", new byte[]{35, 52, 26, 3, 6, 61, 39, 11, 123, 100, 51, 58, 89, 76, 4, 58, 59, 23, 59, 39, 1, 24, 52, 104, 52, 29, 13, 60, 28, 77}));
        intent.setComponent(new ComponentName((String) pblk.a(16777217, 0, 0L, "92f8a4", new byte[]{43, 63, 24, 2, 95, 48, 47, 0, 121, 101, 59, 49, 91, Byte.MAX_VALUE, 75, 51, 42, 31, 50, 101, 45, 62, 1, 77, 76, 58, 30, 58, 19}), (String) pblk.a(16777217, 0, 0L, "47f6be", new byte[]{38, 58, 24, 12, 92, 97, 34, 5, 121, 107, 54, 52, 91, 113, 72, 98, 39, 26, 50, 107, 32, 59, 1, 67, 79, 107, 19, 63, 19, 40, 22, 32, 5, 82, 81, 119, 58, 19, 57, 114, 36, 39, 12, 102, 116, 86, 4, 19, 37, 112, 44, 54, 16})));
        if (this.f61460a.bindService(intent, this.f61462c, 1)) {
            try {
                String c4 = new c1(this.f61461b.take()).c();
                if (pblbVar != null) {
                    pblbVar.c(c4);
                }
            } catch (Exception unused2) {
            } catch (Throwable th) {
                this.f61460a.unbindService(this.f61462c);
                throw th;
            }
            this.f61460a.unbindService(this.f61462c);
        }
    }
}
