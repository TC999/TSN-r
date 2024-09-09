package com.bytedance.sdk.component.adexpress.w;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.w.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fp implements p {

    /* renamed from: c  reason: collision with root package name */
    private Context f29450c;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f29451f = new AtomicBoolean(false);
    private bk sr;
    private ScheduledFuture<?> ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.ux.c f29452w;
    private ev xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        p.c f29455c;
        private int xv;

        public c(int i4, p.c cVar) {
            this.xv = i4;
            this.f29455c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.xv == 1) {
                com.bytedance.sdk.component.utils.a.w("RenderInterceptor", "WebView Render timeout");
                fp.this.f29452w.c(true);
                fp.this.c(this.f29455c, 107, null);
            }
        }
    }

    public fp(Context context, bk bkVar, com.bytedance.sdk.component.adexpress.ux.c cVar, ev evVar) {
        this.f29450c = context;
        this.sr = bkVar;
        this.xv = evVar;
        this.f29452w = cVar;
        cVar.c(this.xv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        try {
            ScheduledFuture<?> scheduledFuture = this.ux;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.ux.cancel(false);
                this.ux = null;
            }
            com.bytedance.sdk.component.utils.a.w("RenderInterceptor", "WebView Render cancel timeout timer");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public com.bytedance.sdk.component.adexpress.ux.c w() {
        return this.f29452w;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p
    public boolean c(final p.c cVar) {
        int f4 = this.sr.f();
        if (f4 < 0) {
            c(cVar, 107, "time is " + f4);
        } else {
            this.ux = com.bytedance.sdk.component.adexpress.sr.xv.c(new c(1, cVar), f4, TimeUnit.MILLISECONDS);
            this.f29452w.c(new r() { // from class: com.bytedance.sdk.component.adexpress.w.fp.1
                @Override // com.bytedance.sdk.component.adexpress.w.r
                public void c(View view, t tVar) {
                    ys w3;
                    fp.this.xv();
                    if (cVar.xv() || (w3 = cVar.w()) == null) {
                        return;
                    }
                    w3.c(fp.this.f29452w, tVar);
                    cVar.c(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.w.r
                public void c(int i4, String str) {
                    fp.this.c(cVar, i4, str);
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p
    public void c() {
        this.f29452w.sr();
        xv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(p.c cVar, int i4, String str) {
        ys w3;
        if (cVar.xv() || this.f29451f.get()) {
            return;
        }
        xv();
        this.sr.ux().c(i4, str);
        if (cVar.w(this)) {
            cVar.c(this);
        } else if (cVar.xv() || (w3 = cVar.w()) == null) {
            return;
        } else {
            cVar.c(true);
            w3.a_(i4);
        }
        this.f29451f.getAndSet(true);
    }
}
