package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameOptimizedController;
import com.stub.StubApp;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.mbridge.msdk.foundation.same.net.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RequestQueue {

    /* renamed from: a */
    private static final String f30847a = "j";

    /* renamed from: b */
    private final Context f30848b;

    /* renamed from: c */
    private final Delivery f30849c;

    /* renamed from: e */
    private ExecutorService f30851e;

    /* renamed from: d */
    private final Set<AbstractC11354i> f30850d = new HashSet();

    /* renamed from: f */
    private final AtomicInteger f30852f = new AtomicInteger();

    public RequestQueue(Context context) {
        SameOptimizedController m21727a = SameOptimizedController.m21727a();
        if (m21727a.m21724a("c_v_r_q_t", true)) {
            try {
                this.f30851e = new ThreadPoolExecutor(m21727a.m21726a("v_r_q_c_s", 10), m21727a.m21726a("v_r_q_m_s", 25), m21727a.m21726a("v_r_q_c_t", 15), TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } catch (Exception unused) {
                this.f30851e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
            }
        } else {
            this.f30851e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
        }
        this.f30848b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f30849c = new ExecutorDelivery(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: a */
    public final void m22180a(final AbstractC11354i abstractC11354i) {
        abstractC11354i.m22203a(this);
        synchronized (this) {
            this.f30850d.add(abstractC11354i);
        }
        abstractC11354i.m22210a(this.f30852f.incrementAndGet());
        String str = f30847a;
        SameLogTool.m21736b(str, "add-to-queue request=" + abstractC11354i.m22198b());
        this.f30851e.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.j.1
            @Override // java.lang.Runnable
            public final void run() {
                new NetworkDispatcher(RequestQueue.this.f30848b, null, RequestQueue.this.f30849c).m22212a(abstractC11354i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m22178b(AbstractC11354i abstractC11354i) {
        synchronized (this) {
            this.f30850d.remove(abstractC11354i);
        }
    }
}
