package com.kwad.framework.filedownloader.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c implements a {
    private volatile Thread afv;
    private Handler handler;
    private volatile List<Integer> aft = new CopyOnWriteArrayList();
    private AtomicInteger afu = new AtomicInteger();
    private final b afq = new b();
    private final d afr = new d();
    private final long afs = com.kwad.framework.filedownloader.f.e.wN().ain;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.bx("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwad.framework.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i4 = message.what;
                if (i4 == 0) {
                    if (c.this.afv != null) {
                        LockSupport.unpark(c.this.afv);
                        c.a(c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    c.this.afu.set(i4);
                    c.this.bp(i4);
                    c.this.aft.add(Integer.valueOf(i4));
                    return false;
                } finally {
                    c.this.afu.set(0);
                    if (c.this.afv != null) {
                        LockSupport.unpark(c.this.afv);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i4) {
        this.afr.b(this.afq.bk(i4));
        List<com.kwad.framework.filedownloader.d.a> bl = this.afq.bl(i4);
        this.afr.bm(i4);
        for (com.kwad.framework.filedownloader.d.a aVar : bl) {
            this.afr.a(aVar);
        }
    }

    private boolean bq(int i4) {
        return !this.aft.contains(Integer.valueOf(i4));
    }

    private void br(int i4) {
        this.handler.removeMessages(i4);
        if (this.afu.get() == i4) {
            this.afv = Thread.currentThread();
            this.handler.sendEmptyMessage(0);
            LockSupport.park();
            return;
        }
        bp(i4);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bj(int i4) {
        this.handler.sendEmptyMessageDelayed(i4, this.afs);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bk(int i4) {
        return this.afq.bk(i4);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bl(int i4) {
        return this.afq.bl(i4);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bm(int i4) {
        this.afq.bm(i4);
        if (bq(i4)) {
            return;
        }
        this.afr.bm(i4);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bn(int i4) {
        this.afr.bn(i4);
        return this.afq.bn(i4);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bo(int i4) {
        this.afq.bo(i4);
        if (bq(i4)) {
            return;
        }
        this.afr.bo(i4);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        this.afq.clear();
        this.afr.clear();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i4, long j4) {
        this.afq.d(i4, j4);
        if (bq(i4)) {
            br(i4);
        }
        this.afr.d(i4, j4);
        this.aft.remove(Integer.valueOf(i4));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void s(int i4, int i5) {
        this.afq.s(i4, i5);
        if (bq(i4)) {
            return;
        }
        this.afr.s(i4, i5);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0667a vf() {
        d dVar = this.afr;
        b bVar = this.afq;
        return dVar.a(bVar.afn, bVar.afo);
    }

    static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.afv = null;
        return null;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i4, long j4) {
        this.afq.b(i4, j4);
        if (bq(i4)) {
            return;
        }
        this.afr.b(i4, j4);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i4, long j4) {
        this.afq.c(i4, j4);
        if (bq(i4)) {
            this.handler.removeMessages(i4);
            if (this.afu.get() == i4) {
                this.afv = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.aft.remove(Integer.valueOf(i4));
        }
        this.afr.c(i4, j4);
        this.aft.remove(Integer.valueOf(i4));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        this.afq.a(aVar);
        if (bq(aVar.getId())) {
            return;
        }
        this.afr.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        this.afq.b(cVar);
        if (bq(cVar.getId())) {
            return;
        }
        this.afr.b(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i4, int i5, long j4) {
        this.afq.a(i4, i5, j4);
        if (bq(i4)) {
            return;
        }
        this.afr.a(i4, i5, j4);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i4, String str, long j4, long j5, int i5) {
        this.afq.a(i4, str, j4, j5, i5);
        if (bq(i4)) {
            return;
        }
        this.afr.a(i4, str, j4, j5, i5);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i4, long j4, String str, String str2) {
        this.afq.a(i4, j4, str, str2);
        if (bq(i4)) {
            return;
        }
        this.afr.a(i4, j4, str, str2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i4, Throwable th) {
        this.afq.a(i4, th);
        if (bq(i4)) {
            return;
        }
        this.afr.a(i4, th);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i4, Throwable th, long j4) {
        this.afq.a(i4, th, j4);
        if (bq(i4)) {
            br(i4);
        }
        this.afr.a(i4, th, j4);
        this.aft.remove(Integer.valueOf(i4));
    }
}
