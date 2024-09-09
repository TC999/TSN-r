package com.qq.e.comm.plugin.i0.l.k;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class c {

    /* renamed from: e  reason: collision with root package name */
    private static final ExecutorService f44326e = Executors.newFixedThreadPool(4);

    /* renamed from: a  reason: collision with root package name */
    private final int f44327a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f44328b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f44329c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f44330d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f44331c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f44332d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f44333e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f44334f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ C0846c f44335g;

        a(b bVar, String str, String str2, int i4, C0846c c0846c) {
            this.f44331c = bVar;
            this.f44332d = str;
            this.f44333e = str2;
            this.f44334f = i4;
            this.f44335g = c0846c;
        }

        @Override // java.lang.Runnable
        public void run() {
            Exception exc;
            d dVar = null;
            try {
                exc = null;
                dVar = c.this.a(this.f44331c, this.f44332d, this.f44333e, this.f44334f);
            } catch (Exception e4) {
                exc = new Exception(e4);
            }
            synchronized (this.f44335g) {
                this.f44335g.f44340c++;
                if (this.f44335g.f44338a == null) {
                    this.f44335g.f44338a = dVar;
                }
                if (this.f44335g.f44339b == null) {
                    this.f44335g.f44339b = exc;
                }
                if (this.f44335g.f44340c == c.this.f44328b.length || this.f44335g.f44338a != null) {
                    this.f44335g.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        Queue<Runnable> f44337a = new ConcurrentLinkedQueue();

        b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Runnable runnable) {
            if (runnable != null) {
                this.f44337a.offer(runnable);
            }
        }

        void a() {
            while (true) {
                Runnable poll = this.f44337a.poll();
                if (poll == null) {
                    return;
                }
                poll.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.i0.l.k.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class C0846c {

        /* renamed from: a  reason: collision with root package name */
        d f44338a;

        /* renamed from: b  reason: collision with root package name */
        Exception f44339b;

        /* renamed from: c  reason: collision with root package name */
        int f44340c = 0;

        C0846c() {
        }
    }

    public c(String[] strArr, int i4, int i5, ExecutorService executorService) {
        if (strArr != null && strArr.length > 1 && executorService == null) {
            executorService = f44326e;
        }
        this.f44327a = i4;
        this.f44330d = i5 <= 0 ? 8 : i5;
        this.f44328b = strArr;
        this.f44329c = executorService;
    }

    abstract d a(b bVar, String str, String str2, int i4) throws Exception;

    public h[] a(g gVar) throws Exception {
        d a4 = a(gVar.f44361a);
        if (a4 != null) {
            List<h> a5 = a4.a();
            if (a5 == null || a5.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (h hVar : a5) {
                if (hVar.a() || hVar.c() || hVar.b() || hVar.f44363b == this.f44327a) {
                    arrayList.add(hVar);
                }
            }
            return (h[]) arrayList.toArray(new h[0]);
        }
        throw new IOException("response is null");
    }

    private d a(String str) throws Exception {
        return a(str, this.f44327a);
    }

    private d a(String str, int i4) throws Exception {
        String[] strArr = this.f44328b;
        if (strArr != null && strArr.length != 0) {
            if (str != null && str.length() != 0) {
                b bVar = new b();
                if (this.f44328b.length != 1 && this.f44329c != null) {
                    C0846c c0846c = new C0846c();
                    for (String str2 : this.f44328b) {
                        this.f44329c.submit(new a(bVar, str2, str, i4, c0846c));
                    }
                    synchronized (c0846c) {
                        try {
                            c0846c.wait(this.f44330d * 1000);
                        } catch (InterruptedException unused) {
                        }
                    }
                    bVar.a();
                    Exception exc = c0846c.f44339b;
                    if (exc != null && c0846c.f44338a == null) {
                        throw exc;
                    }
                    return c0846c.f44338a;
                }
                d dVar = null;
                for (String str3 : this.f44328b) {
                    dVar = a(bVar, str3, str, i4);
                    if (dVar != null) {
                        break;
                    }
                }
                return dVar;
            }
            throw new IOException("host can not empty");
        }
        throw new IOException("server can not empty");
    }
}
