package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ys.c;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w extends com.bytedance.sdk.openadsdk.ys.w.f {

    /* renamed from: c  reason: collision with root package name */
    private int[] f34208c;
    public AtomicBoolean ev = new AtomicBoolean(false);
    protected c gd;

    /* renamed from: p  reason: collision with root package name */
    protected Dialog f34209p;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements com.bytedance.sdk.openadsdk.core.p.w.c {

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<com.bytedance.sdk.openadsdk.core.p.w.c> f34211c;

        /* renamed from: w  reason: collision with root package name */
        private String f34212w;

        public c(com.bytedance.sdk.openadsdk.core.p.w.c cVar, String str) {
            this.f34212w = "";
            this.f34211c = new WeakReference<>(cVar);
            this.f34212w = str;
        }

        public void c(com.bytedance.sdk.openadsdk.core.p.w.c cVar) {
            this.f34211c = new WeakReference<>(cVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void w(long j4, long j5, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.p.w.c> weakReference = this.f34211c;
            if (weakReference != null && weakReference.get() != null) {
                this.f34211c.get().w(j4, j5, str, str2);
            }
            if (j4 > 0) {
                c.C0525c.c(this.f34212w, 2, (int) ((j5 * 100) / j4));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void xv(long j4, long j5, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.p.w.c> weakReference = this.f34211c;
            if (weakReference != null && weakReference.get() != null) {
                this.f34211c.get().xv(j4, j5, str, str2);
            }
            if (j4 > 0) {
                c.C0525c.c(this.f34212w, 4, (int) ((j5 * 100) / j4));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c() {
            WeakReference<com.bytedance.sdk.openadsdk.core.p.w.c> weakReference = this.f34211c;
            if (weakReference != null && weakReference.get() != null) {
                this.f34211c.get().c();
            }
            c.C0525c.c(this.f34212w, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(long j4, long j5, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.p.w.c> weakReference = this.f34211c;
            if (weakReference != null && weakReference.get() != null) {
                this.f34211c.get().c(j4, j5, str, str2);
            }
            if (j4 > 0) {
                c.C0525c.c(this.f34212w, 3, (int) ((j5 * 100) / j4));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(long j4, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.p.w.c> weakReference = this.f34211c;
            if (weakReference != null && weakReference.get() != null) {
                this.f34211c.get().c(j4, str, str2);
            }
            c.C0525c.c(this.f34212w, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.p.w.c> weakReference = this.f34211c;
            if (weakReference != null && weakReference.get() != null) {
                this.f34211c.get().c(str, str2);
            }
            c.C0525c.c(this.f34212w, 6, 100);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public View c() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.ys.w.w.ev c(Activity activity) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
    }

    protected void c(Dialog dialog) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.f
    public void c(Dialog dialog, int[] iArr) {
        this.f34209p = dialog;
        this.f34208c = iArr;
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.w.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (w.this.gd() != null) {
                        w wVar = w.this;
                        wVar.c(wVar.gd().ve());
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable unused) {
        }
        c(this.f34209p);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.ys.w.w.sr f() {
        return null;
    }

    public abstract me gd();

    public com.bytedance.sdk.openadsdk.core.multipro.w.c p() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public Map<String, Object> r() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void sr() {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void ux() {
        if (gd() != null) {
            gb.c(gd().iy());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int w() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void w(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int xv() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar) {
        Dialog dialog;
        if (wVar == null || (dialog = this.f34209p) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.c.w.c(wVar, dialog, this.f34208c);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
        if (gd() != null) {
            gb.c(gd().iy(), cVar);
        }
    }
}
