package com.bytedance.msdk.sr.w.c;

import android.content.Context;
import android.os.Looper;
import com.bytedance.msdk.adapter.sr.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.msdk.sr.w.c {
    @Override // com.bytedance.msdk.sr.w.c
    protected void ys() {
        f.c(new Runnable() { // from class: com.bytedance.msdk.sr.w.c.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.msdk.sr.w.c) c.this).xv != null) {
                    ((com.bytedance.msdk.sr.w.c) c.this).xv.c();
                }
            }
        });
    }

    @Override // com.bytedance.msdk.sr.w.c
    protected void c(Context context) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.msdk.sr.w.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.gd();
                c.this.f();
                c.this.r();
                ((com.bytedance.msdk.sr.w.c) c.this).f28406c.set(true);
                c.this.fp();
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            f.xv(runnable);
        }
    }

    @Override // com.bytedance.msdk.sr.w.c
    protected void w(final Context context) {
        f.sr(new Runnable() { // from class: com.bytedance.msdk.sr.w.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.k();
                c.this.bk();
                c.this.ev();
                c.this.ys();
                c.this.p();
                c.this.a();
                com.bytedance.msdk.sr.w.c.t();
                com.bytedance.msdk.sr.w.c(context);
                ((com.bytedance.msdk.sr.w.c) c.this).f28408w.set(true);
                c.this.fp();
            }
        });
    }

    @Override // com.bytedance.msdk.sr.w.c
    protected void xv(Context context) {
        w(context);
        c(context);
    }
}
