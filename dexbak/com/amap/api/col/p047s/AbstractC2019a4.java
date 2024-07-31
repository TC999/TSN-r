package com.amap.api.col.p047s;

import com.amap.api.col.p047s.AbstractRunnableC2229z3;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: BasePool.java */
/* renamed from: com.amap.api.col.s.a4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC2019a4 {

    /* renamed from: a */
    protected ThreadPoolExecutor f5886a;

    /* renamed from: b */
    private ConcurrentHashMap<AbstractRunnableC2229z3, Future<?>> f5887b = new ConcurrentHashMap<>();

    /* renamed from: c */
    protected AbstractRunnableC2229z3.InterfaceC2230a f5888c = new C2020a();

    /* compiled from: BasePool.java */
    /* renamed from: com.amap.api.col.s.a4$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C2020a implements AbstractRunnableC2229z3.InterfaceC2230a {
        C2020a() {
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3.InterfaceC2230a
        /* renamed from: a */
        public final void mo52170a(AbstractRunnableC2229z3 abstractRunnableC2229z3) {
            AbstractC2019a4.this.m53248a(abstractRunnableC2229z3);
        }
    }

    /* renamed from: b */
    private synchronized void m53247b(AbstractRunnableC2229z3 abstractRunnableC2229z3, Future<?> future) {
        try {
            this.f5887b.put(abstractRunnableC2229z3, future);
        } catch (Throwable th) {
            C2060g2.m52972o(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    /* renamed from: d */
    private synchronized boolean m53245d(AbstractRunnableC2229z3 abstractRunnableC2229z3) {
        boolean z;
        try {
            z = this.f5887b.containsKey(abstractRunnableC2229z3);
        } catch (Throwable th) {
            C2060g2.m52972o(th, "TPool", "contain");
            th.printStackTrace();
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    protected final synchronized void m53248a(AbstractRunnableC2229z3 abstractRunnableC2229z3) {
        try {
            this.f5887b.remove(abstractRunnableC2229z3);
        } catch (Throwable th) {
            C2060g2.m52972o(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public final void m53246c(AbstractRunnableC2229z3 abstractRunnableC2229z3) {
        ThreadPoolExecutor threadPoolExecutor;
        if (m53245d(abstractRunnableC2229z3) || (threadPoolExecutor = this.f5886a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        abstractRunnableC2229z3.f6829a = this.f5888c;
        try {
            Future<?> submit = this.f5886a.submit(abstractRunnableC2229z3);
            if (submit == null) {
                return;
            }
            m53247b(abstractRunnableC2229z3, submit);
        } catch (RejectedExecutionException e) {
            C2060g2.m52972o(e, "TPool", "addTask");
        }
    }
}
