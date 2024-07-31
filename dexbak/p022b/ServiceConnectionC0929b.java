package p022b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: b.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ServiceConnectionC0929b implements ServiceConnection {

    /* renamed from: c */
    public static final ThreadPoolExecutor f234c = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: a */
    public boolean f235a = false;

    /* renamed from: b */
    public final LinkedBlockingQueue<IBinder> f236b = new LinkedBlockingQueue<>(1);

    /* renamed from: b.b$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0930a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ IBinder f237a;

        public RunnableC0930a(IBinder iBinder) {
            this.f237a = iBinder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                System.currentTimeMillis();
                ServiceConnectionC0929b.this.f236b.offer(this.f237a);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        f234c.execute(new RunnableC0930a(iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        System.currentTimeMillis();
    }
}
