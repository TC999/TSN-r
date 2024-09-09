package com.bytedance.sdk.openadsdk.core.ugeno.w;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.w.bk;
import com.bytedance.sdk.component.adexpress.w.ev;
import com.bytedance.sdk.component.adexpress.w.p;
import com.bytedance.sdk.component.adexpress.w.r;
import com.bytedance.sdk.component.adexpress.w.t;
import com.bytedance.sdk.component.adexpress.w.ys;
import com.bytedance.sdk.component.utils.a;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements p {

    /* renamed from: c  reason: collision with root package name */
    private Context f35044c;
    private ScheduledFuture<?> sr;
    private AtomicBoolean ux = new AtomicBoolean(false);

    /* renamed from: w  reason: collision with root package name */
    private xv f35045w;
    private bk xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        p.c f35048c;
        private int xv;

        c(int i4, p.c cVar) {
            this.xv = i4;
            this.f35048c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.xv == 1) {
                a.w("RenderInterceptor", "ugen Render timeout");
                sr.this.f35045w.c(true);
                sr.this.c(this.f35048c, 137);
            }
        }
    }

    public sr(Context context, xv xvVar, ev evVar, bk bkVar) {
        this.f35044c = context;
        this.f35045w = xvVar;
        this.xv = bkVar;
        this.f35045w.c(evVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p
    public void c() {
    }

    private void w() {
        try {
            ScheduledFuture<?> scheduledFuture = this.sr;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.sr.cancel(false);
                this.sr = null;
            }
            a.w("RenderInterceptor", "ugen Render cancel timeout timer");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p
    public boolean c(final p.c cVar) {
        int f4 = this.xv.f();
        if (f4 < 0) {
            c(cVar, 137);
        } else {
            this.sr = com.bytedance.sdk.component.gd.ev.sr().schedule(new c(1, cVar), f4, TimeUnit.MILLISECONDS);
            this.f35045w.c(new r() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.w.sr.1
                @Override // com.bytedance.sdk.component.adexpress.w.r
                public void c(View view, t tVar) {
                    if (cVar.xv()) {
                        return;
                    }
                    com.bytedance.adsdk.ugeno.w.p pVar = new com.bytedance.adsdk.ugeno.w.p();
                    pVar.b(0);
                    ((com.bytedance.sdk.openadsdk.core.ugeno.w.c) sr.this.xv).n().c(pVar);
                    sr.this.xv.ux().s();
                    ys w3 = cVar.w();
                    if (w3 == null) {
                        return;
                    }
                    w3.c(sr.this.f35045w, tVar);
                    cVar.c(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.w.r
                public void c(int i4, String str) {
                    ys w3;
                    com.bytedance.adsdk.ugeno.w.p pVar = new com.bytedance.adsdk.ugeno.w.p();
                    pVar.b(i4);
                    ((com.bytedance.sdk.openadsdk.core.ugeno.w.c) sr.this.xv).n().c(pVar);
                    if (cVar.w(sr.this)) {
                        cVar.c(sr.this);
                    } else if (cVar.xv() || (w3 = cVar.w()) == null) {
                    } else {
                        w3.a_(i4);
                    }
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(p.c cVar, int i4) {
        ys w3;
        if (cVar.xv() || this.ux.get()) {
            return;
        }
        w();
        com.bytedance.adsdk.ugeno.w.p pVar = new com.bytedance.adsdk.ugeno.w.p();
        pVar.b(i4);
        ((com.bytedance.sdk.openadsdk.core.ugeno.w.c) this.xv).n().c(pVar);
        if (cVar.w(this)) {
            cVar.c(this);
        } else if (cVar.xv() || (w3 = cVar.w()) == null) {
            return;
        } else {
            cVar.c(true);
            w3.a_(i4);
        }
        this.ux.getAndSet(true);
    }
}
