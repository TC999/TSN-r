package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.z;
import com.stub.StubApp;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestQueue.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39620a = "j";

    /* renamed from: b  reason: collision with root package name */
    private final Context f39621b;

    /* renamed from: c  reason: collision with root package name */
    private final c f39622c;

    /* renamed from: e  reason: collision with root package name */
    private ExecutorService f39624e;

    /* renamed from: d  reason: collision with root package name */
    private final Set<i> f39623d = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f39625f = new AtomicInteger();

    public j(Context context) {
        z a4 = z.a();
        if (a4.a("c_v_r_q_t", true)) {
            try {
                this.f39624e = new ThreadPoolExecutor(a4.a("v_r_q_c_s", 10), a4.a("v_r_q_m_s", 25), a4.a("v_r_q_c_t", 15), TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } catch (Exception unused) {
                this.f39624e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
            }
        } else {
            this.f39624e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
        }
        this.f39621b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f39622c = new d(new Handler(Looper.getMainLooper()));
    }

    public final void a(final i iVar) {
        iVar.a(this);
        synchronized (this) {
            this.f39623d.add(iVar);
        }
        iVar.a(this.f39625f.incrementAndGet());
        String str = f39620a;
        x.b(str, "add-to-queue request=" + iVar.b());
        this.f39624e.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.j.1
            @Override // java.lang.Runnable
            public final void run() {
                new h(j.this.f39621b, null, j.this.f39622c).a(iVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(i iVar) {
        synchronized (this) {
            this.f39623d.remove(iVar);
        }
    }
}
