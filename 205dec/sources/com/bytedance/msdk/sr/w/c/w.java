package com.bytedance.msdk.sr.w.c;

import android.content.Context;
import android.os.Looper;
import com.bytedance.msdk.adapter.sr.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.msdk.sr.w.c {
    @Override // com.bytedance.msdk.sr.w.c
    protected void ys() {
        f.c(new Runnable() { // from class: com.bytedance.msdk.sr.w.c.w.3
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.msdk.sr.w.c) w.this).xv != null) {
                    ((com.bytedance.msdk.sr.w.c) w.this).xv.c();
                }
            }
        });
    }

    @Override // com.bytedance.msdk.sr.w.c
    protected void c(Context context) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.msdk.sr.w.c.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.gd();
                w.this.f();
                w.this.r();
                ((com.bytedance.msdk.sr.w.c) w.this).f28406c.set(true);
                w.this.fp();
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
        f.sr(new Runnable() { // from class: com.bytedance.msdk.sr.w.c.w.2
            @Override // java.lang.Runnable
            public void run() {
                w.this.k();
                w.this.bk();
                w.this.ev();
                w.this.p();
                w.this.a();
                com.bytedance.msdk.sr.w.c.t();
                com.bytedance.msdk.sr.w.c(context);
                ((com.bytedance.msdk.sr.w.c) w.this).f28408w.set(true);
                w.this.fp();
            }
        });
    }

    @Override // com.bytedance.msdk.sr.w.c
    protected void xv(Context context) {
        ys();
        w(context);
        c(context);
    }
}
