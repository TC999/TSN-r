package com.kwad.framework.filedownloader.p349b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwad.framework.filedownloader.p349b.InterfaceC9440a;
import com.kwad.framework.filedownloader.p351d.C9461a;
import com.kwad.framework.filedownloader.p351d.C9464c;
import com.kwad.framework.filedownloader.p353f.C9499e;
import com.kwad.framework.filedownloader.p353f.C9501f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* renamed from: com.kwad.framework.filedownloader.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9445c implements InterfaceC9440a {
    private volatile Thread afv;
    private Handler handler;
    private volatile List<Integer> aft = new CopyOnWriteArrayList();
    private AtomicInteger afu = new AtomicInteger();
    private final C9442b afq = new C9442b();
    private final C9447d afr = new C9447d();
    private final long afs = C9499e.m28530wN().ain;

    public C9445c() {
        HandlerThread handlerThread = new HandlerThread(C9501f.m28504bx("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwad.framework.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    if (C9445c.this.afv != null) {
                        LockSupport.unpark(C9445c.this.afv);
                        C9445c.m28801a(C9445c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    C9445c.this.afu.set(i);
                    C9445c.this.m28799bp(i);
                    C9445c.this.aft.add(Integer.valueOf(i));
                    return false;
                } finally {
                    C9445c.this.afu.set(0);
                    if (C9445c.this.afv != null) {
                        LockSupport.unpark(C9445c.this.afv);
                        C9445c.m28801a(C9445c.this, (Thread) null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bp */
    public void m28799bp(int i) {
        this.afr.mo28782b(this.afq.mo28780bk(i));
        List<C9461a> mo28779bl = this.afq.mo28779bl(i);
        this.afr.mo28778bm(i);
        for (C9461a c9461a : mo28779bl) {
            this.afr.mo28784a(c9461a);
        }
    }

    /* renamed from: bq */
    private boolean m28798bq(int i) {
        return !this.aft.contains(Integer.valueOf(i));
    }

    /* renamed from: br */
    private void m28797br(int i) {
        this.handler.removeMessages(i);
        if (this.afu.get() == i) {
            this.afv = Thread.currentThread();
            this.handler.sendEmptyMessage(0);
            LockSupport.park();
            return;
        }
        m28799bp(i);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bj */
    public final void mo28781bj(int i) {
        this.handler.sendEmptyMessageDelayed(i, this.afs);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bk */
    public final C9464c mo28780bk(int i) {
        return this.afq.mo28780bk(i);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bl */
    public final List<C9461a> mo28779bl(int i) {
        return this.afq.mo28779bl(i);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bm */
    public final void mo28778bm(int i) {
        this.afq.mo28778bm(i);
        if (m28798bq(i)) {
            return;
        }
        this.afr.mo28778bm(i);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bn */
    public final boolean mo28777bn(int i) {
        this.afr.mo28777bn(i);
        return this.afq.mo28777bn(i);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bo */
    public final void mo28776bo(int i) {
        this.afq.mo28776bo(i);
        if (m28798bq(i)) {
            return;
        }
        this.afr.mo28776bo(i);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    public final void clear() {
        this.afq.clear();
        this.afr.clear();
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: d */
    public final void mo28774d(int i, long j) {
        this.afq.mo28774d(i, j);
        if (m28798bq(i)) {
            m28797br(i);
        }
        this.afr.mo28774d(i, j);
        this.aft.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: s */
    public final void mo28768s(int i, int i2) {
        this.afq.mo28768s(i, i2);
        if (m28798bq(i)) {
            return;
        }
        this.afr.mo28768s(i, i2);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: vf */
    public final InterfaceC9440a.InterfaceC9441a mo28767vf() {
        C9447d c9447d = this.afr;
        C9442b c9442b = this.afq;
        return c9447d.m28787a(c9442b.afn, c9442b.afo);
    }

    /* renamed from: a */
    static /* synthetic */ Thread m28801a(C9445c c9445c, Thread thread) {
        c9445c.afv = null;
        return null;
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: b */
    public final void mo28783b(int i, long j) {
        this.afq.mo28783b(i, j);
        if (m28798bq(i)) {
            return;
        }
        this.afr.mo28783b(i, j);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: c */
    public final void mo28775c(int i, long j) {
        this.afq.mo28775c(i, j);
        if (m28798bq(i)) {
            this.handler.removeMessages(i);
            if (this.afu.get() == i) {
                this.afv = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.aft.remove(Integer.valueOf(i));
        }
        this.afr.mo28775c(i, j);
        this.aft.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28784a(C9461a c9461a) {
        this.afq.mo28784a(c9461a);
        if (m28798bq(c9461a.getId())) {
            return;
        }
        this.afr.mo28784a(c9461a);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: b */
    public final void mo28782b(C9464c c9464c) {
        this.afq.mo28782b(c9464c);
        if (m28798bq(c9464c.getId())) {
            return;
        }
        this.afr.mo28782b(c9464c);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28795a(int i, int i2, long j) {
        this.afq.mo28795a(i, i2, j);
        if (m28798bq(i)) {
            return;
        }
        this.afr.mo28795a(i, i2, j);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28791a(int i, String str, long j, long j2, int i2) {
        this.afq.mo28791a(i, str, j, j2, i2);
        if (m28798bq(i)) {
            return;
        }
        this.afr.mo28791a(i, str, j, j2, i2);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28794a(int i, long j, String str, String str2) {
        this.afq.mo28794a(i, j, str, str2);
        if (m28798bq(i)) {
            return;
        }
        this.afr.mo28794a(i, j, str, str2);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28790a(int i, Throwable th) {
        this.afq.mo28790a(i, th);
        if (m28798bq(i)) {
            return;
        }
        this.afr.mo28790a(i, th);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28789a(int i, Throwable th, long j) {
        this.afq.mo28789a(i, th, j);
        if (m28798bq(i)) {
            m28797br(i);
        }
        this.afr.mo28789a(i, th, j);
        this.aft.remove(Integer.valueOf(i));
    }
}
