package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import com.bytedance.sdk.openadsdk.ys.w.w.f;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import xyz.adscope.ad.control.interaction.view.InteractionCommon;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends ev {

    /* renamed from: c  reason: collision with root package name */
    private final Context f33138c;
    private SoftReference<View> ev;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f33139f;
    private w gd;

    /* renamed from: p  reason: collision with root package name */
    private InterfaceC0490c f33140p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f33141r;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.w sr;
    private TTDislikeToast ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.xv.w f33142w;
    private xv xv;

    /* renamed from: com.bytedance.sdk.openadsdk.core.dislike.ui.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0490c {
        void c();

        void c(int i4, String str, boolean z3);

        void w();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w extends Handler {

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Context> f33149c;

        public w(Context context) {
            this.f33149c = new WeakReference<>(context);
        }
    }

    public c(Context context, com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar, String str, boolean z3) {
        this.f33139f = new AtomicBoolean(false);
        wVar.w(str);
        wVar.c("other");
        this.f33138c = context;
        if (context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            a.xv("Dislike \u521d\u59cb\u5316\u5fc5\u987b\u4f7f\u7528activity,\u8bf7\u5728TTAdManager.createAdNative(activity)\u4e2d\u4f20\u5165");
            return;
        }
        this.f33142w = wVar;
        this.f33141r = z3;
        sr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar = this.f33142w;
        if (wVar == null) {
            return;
        }
        final String r3 = wVar.r();
        if ("slide_banner_ad".equals(r3) || "banner_ad".equals(r3) || "embeded_ad".equals(r3)) {
            if (this.ev.get() != null && this.f33142w.ev()) {
                this.ev.get().setVisibility(8);
            }
            if (this.gd == null) {
                this.gd = new w(this.f33138c);
            }
            this.gd.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f33142w.w(InteractionCommon.DISLIKE_TYPE_EXECUTION);
                    if (c.this.ev == null || c.this.ev.get() == null || !((View) c.this.ev.get()).isShown()) {
                        com.bytedance.sdk.openadsdk.core.dislike.c.c.c().c(c.this.f33138c, c.this.f33142w, "close_success");
                    } else {
                        com.bytedance.sdk.openadsdk.core.dislike.c.c.c().c(c.this.f33138c, c.this.f33142w, "close_fail");
                    }
                    c.this.f33142w.w(r3);
                }
            }, 500L);
        }
    }

    private void sr() {
        ViewGroup viewGroup;
        xv xvVar = new xv(this.f33138c, this.f33142w);
        this.xv = xvVar;
        xvVar.c(new com.bytedance.sdk.openadsdk.core.dislike.w.xv() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.c.1
            @Override // com.bytedance.sdk.openadsdk.core.dislike.w.xv
            public void c() {
                c.this.ux();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.w.xv
            public void w() {
                a.w("TTAdDislikeImpl", "onDislikeShow: ");
                if (c.this.f33140p != null) {
                    c.this.f33140p.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.w.xv
            public void xv() {
                a.f("TTAdDislikeImpl", "onDislikeHide: ");
                try {
                    if (c.this.f33140p == null || c.this.xv()) {
                        return;
                    }
                    c.this.f33140p.w();
                } catch (Throwable th) {
                    a.xv("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.w.xv
            public void c(int i4, f fVar) {
                try {
                    if (!fVar.f()) {
                        if (c.this.f33140p != null) {
                            c.this.f33140p.c(i4, fVar.w(), c.this.f33142w != null ? c.this.f33142w.ev() : false);
                        }
                        c.this.f33139f.set(true);
                        if (c.this.ux != null) {
                            c.this.ux.c();
                        }
                        c.this.f();
                    }
                    a.f("TTAdDislikeImpl", "onDislikeSelected: " + i4 + ", " + fVar.w());
                } catch (Throwable th) {
                    a.xv("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.dislike.ui.w wVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.w(this.f33138c, this.f33142w);
        this.sr = wVar;
        wVar.c(new com.bytedance.sdk.openadsdk.core.dislike.w.w() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.c.2
            @Override // com.bytedance.sdk.openadsdk.core.dislike.w.w
            public void c() {
                a.w("TTAdDislikeImpl", "onDislikeCommentShow: ");
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.w.w
            public void w() {
                a.w("TTAdDislikeImpl", "onDislikeCommentHide: ");
                try {
                    if (c.this.f33139f.get()) {
                        return;
                    }
                    c.this.xv.show();
                } catch (Throwable th) {
                    a.xv("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.w.w
            public void c(int i4, f fVar) {
                try {
                    if (fVar.f()) {
                        return;
                    }
                    if (c.this.f33140p != null) {
                        c.this.f33140p.c(i4, fVar.w(), c.this.f33142w != null ? c.this.f33142w.ev() : false);
                    }
                    c.this.f33139f.set(true);
                    if (c.this.ux != null) {
                        c.this.ux.c();
                    }
                    c.this.f();
                } catch (Throwable th) {
                    a.xv("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }
        });
        if ((this.f33138c instanceof Activity) && this.f33141r) {
            this.ux = new TTDislikeToast(this.f33138c);
            Window window = ((Activity) this.f33138c).getWindow();
            if (window == null || (viewGroup = (ViewGroup) window.getDecorView()) == null) {
                return;
            }
            viewGroup.addView(this.ux);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux() {
        Context context = this.f33138c;
        if ((context instanceof Activity) && (!((Activity) context).isFinishing()) && !this.sr.isShowing()) {
            this.sr.show();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
    public void c() {
        TTDislikeToast tTDislikeToast;
        Context context = this.f33138c;
        boolean z3 = (context instanceof Activity) && !((Activity) context).isFinishing();
        if (this.f33139f.get() && this.f33141r && (tTDislikeToast = this.ux) != null) {
            tTDislikeToast.w();
        } else if (!z3 || xv()) {
        } else {
            this.xv.show();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
    public void w() {
        if (this.f33138c instanceof Activity) {
            xv xvVar = this.xv;
            if (xvVar != null) {
                xvVar.hide();
            }
            com.bytedance.sdk.openadsdk.core.dislike.ui.w wVar = this.sr;
            if (wVar != null) {
                wVar.c();
            }
            TTDislikeToast tTDislikeToast = this.ux;
            if (tTDislikeToast != null) {
                tTDislikeToast.xv();
            }
            this.f33139f.set(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
    public boolean xv() {
        if (this.f33138c instanceof Activity) {
            xv xvVar = this.xv;
            boolean isShowing = xvVar != null ? xvVar.isShowing() : false;
            com.bytedance.sdk.openadsdk.core.dislike.ui.w wVar = this.sr;
            return wVar != null ? isShowing | wVar.isShowing() : isShowing;
        }
        return false;
    }

    public void c(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar) {
        if ((this.f33138c instanceof Activity) && wVar != null) {
            this.xv.c(wVar);
            this.sr.c(wVar);
        }
    }

    public c(Context context, com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar, boolean z3) {
        this(context, wVar, null, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
    public void c(final com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        this.f33140p = new InterfaceC0490c() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.c.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
            public void c() {
                com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
            public void w() {
                com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onCancel();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
            public void c(int i4, String str, boolean z3) {
                com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onSelected(i4, str, z3);
                }
            }
        };
    }

    public void c(InterfaceC0490c interfaceC0490c) {
        this.f33140p = interfaceC0490c;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
    public void c(String str) {
        com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar = this.f33142w;
        if (wVar != null) {
            wVar.c(str);
        }
    }

    public void c(View view) {
        this.ev = new SoftReference<>(view);
    }

    public void c(com.bytedance.sdk.openadsdk.core.dislike.w.c cVar) {
        com.bytedance.sdk.openadsdk.core.dislike.ui.w wVar = this.sr;
        if (wVar != null) {
            wVar.c(cVar);
        }
    }
}
