package com.qq.e.comm.plugin.i0;

import com.qq.e.comm.plugin.i0.c;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.g2;
import com.qq.e.comm.plugin.util.h2;
import com.qq.e.comm.plugin.util.o;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d implements com.qq.e.comm.plugin.i0.c {

    /* renamed from: c  reason: collision with root package name */
    private static final com.qq.e.comm.plugin.i0.c f44225c = new d();

    /* renamed from: b  reason: collision with root package name */
    private PriorityBlockingQueue<Runnable> f44227b = new PriorityBlockingQueue<>(15);

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f44226a = new ThreadPoolExecutor(5, 10, 180, TimeUnit.SECONDS, this.f44227b, new a(this));

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements ThreadFactory {
        a(d dVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_NET_THREAD");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b<T> extends FutureTask<T> implements Comparable<b<T>> {

        /* renamed from: c  reason: collision with root package name */
        private final c.a f44228c;

        public b(Callable<T> callable, c.a aVar) {
            super(callable);
            this.f44228c = aVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b<T> bVar) {
            if (bVar == null) {
                return 1;
            }
            return this.f44228c.a() - bVar.f44228c.a();
        }
    }

    private d() {
    }

    public static com.qq.e.comm.plugin.i0.c a() {
        return f44225c;
    }

    @Override // com.qq.e.comm.plugin.i0.c
    public Future<com.qq.e.comm.plugin.i0.n.g> a(com.qq.e.comm.plugin.i0.n.f fVar) {
        return a(fVar, c.a.f44222e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements Callable<com.qq.e.comm.plugin.i0.n.g> {

        /* renamed from: a  reason: collision with root package name */
        final com.qq.e.comm.plugin.i0.n.f f44229a;

        /* renamed from: b  reason: collision with root package name */
        final com.qq.e.comm.plugin.i0.b f44230b;

        public c(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.b bVar) {
            this.f44229a = fVar;
            this.f44230b = bVar;
        }

        private com.qq.e.comm.plugin.i0.n.g b() throws Exception {
            ArrayList arrayList = new ArrayList();
            if (o.a()) {
                arrayList.add(new com.qq.e.comm.plugin.i0.m.d());
            }
            if (this.f44229a.a() && g2.a().c()) {
                arrayList.add(new com.qq.e.comm.plugin.i0.m.b());
                h2.a(9130015);
            }
            arrayList.add(new com.qq.e.comm.plugin.i0.m.c());
            return new com.qq.e.comm.plugin.i0.a(0, arrayList, this.f44229a).a(this.f44229a);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public com.qq.e.comm.plugin.i0.n.g call() throws Exception {
            com.qq.e.comm.plugin.i0.n.g gVar;
            Exception exc = null;
            try {
                gVar = b();
            } catch (Exception e4) {
                gVar = null;
                exc = e4;
            }
            if (exc == null) {
                com.qq.e.comm.plugin.i0.b bVar = this.f44230b;
                if (bVar != null) {
                    bVar.a(this.f44229a, gVar);
                }
                if (this.f44229a.e()) {
                    gVar.close();
                }
            } else {
                if (gVar != null) {
                    gVar.close();
                }
                if (this.f44230b != null) {
                    d1.a("NetworkClientException", exc);
                    this.f44230b.a(this.f44229a, exc);
                } else {
                    throw exc;
                }
            }
            return gVar;
        }

        public c(com.qq.e.comm.plugin.i0.n.f fVar) {
            this(fVar, null);
        }
    }

    @Override // com.qq.e.comm.plugin.i0.c
    public Future<com.qq.e.comm.plugin.i0.n.g> a(com.qq.e.comm.plugin.i0.n.f fVar, c.a aVar) {
        b bVar = new b(new c(fVar), aVar);
        this.f44226a.execute(bVar);
        d1.a("QueueSize:" + this.f44227b.size(), new Object[0]);
        return bVar;
    }

    @Override // com.qq.e.comm.plugin.i0.c
    public void a(com.qq.e.comm.plugin.i0.n.f fVar, c.a aVar, com.qq.e.comm.plugin.i0.b bVar) {
        a(fVar, aVar, bVar, this.f44226a);
    }

    public void a(com.qq.e.comm.plugin.i0.n.f fVar, c.a aVar, com.qq.e.comm.plugin.i0.b bVar, Executor executor) {
        if (executor == null) {
            d1.a("Submit failed for no executor");
            return;
        }
        executor.execute(new b(new c(fVar, bVar), aVar));
        d1.a("QueueSize:" + this.f44227b.size(), new Object[0]);
    }
}
