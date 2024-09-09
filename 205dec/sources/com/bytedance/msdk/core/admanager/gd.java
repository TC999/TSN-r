package com.bytedance.msdk.core.admanager;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.core.views.RefreshableBannerView;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {
    private final Handler ev;

    /* renamed from: f  reason: collision with root package name */
    private xv f27710f;
    private final com.bytedance.msdk.api.sr.c.c.c fp;
    private final Handler gd;
    private final Runnable ia;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.c.sr f27711k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.c.c f27712p;

    /* renamed from: r  reason: collision with root package name */
    private RefreshableBannerView f27713r;
    private com.bytedance.msdk.api.c.w sr;
    private xv ux;

    /* renamed from: w  reason: collision with root package name */
    private final SoftReference<Context> f27715w;
    private final String xv;
    private final View.OnAttachStateChangeListener ys;

    /* renamed from: c  reason: collision with root package name */
    private int f27709c = 0;

    /* renamed from: a  reason: collision with root package name */
    private SoftReference<Activity> f27708a = new SoftReference<>(null);
    private SoftReference<com.bytedance.sdk.openadsdk.s.c.w.c.c> bk = new SoftReference<>(null);

    /* renamed from: t  reason: collision with root package name */
    private SoftReference<TTDislikeDialogAbstract> f27714t = new SoftReference<>(null);

    /* renamed from: com.bytedance.msdk.core.admanager.gd$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            gd.this.gd.post(new Runnable() { // from class: com.bytedance.msdk.core.admanager.gd.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (gd.this.f27709c == 0 || gd.this.f27710f == null) {
                        return;
                    }
                    View c4 = gd.this.f27710f.c((Context) gd.this.f27715w.get());
                    if (c4 == null) {
                        if (gd.this.f27710f != null) {
                            gd.this.f27710f.w();
                        }
                        gd.this.fp();
                    } else {
                        gd gdVar = gd.this;
                        gdVar.w(gdVar.f27710f);
                        if (gd.this.f27713r != null) {
                            gd.this.f27713r.c(c4);
                        }
                        gd.this.gd.postDelayed(new Runnable() { // from class: com.bytedance.msdk.core.admanager.gd.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (gd.this.ux != null) {
                                    gd.this.ux.w();
                                }
                                gd gdVar2 = gd.this;
                                gdVar2.ux = gdVar2.f27710f;
                                gd.this.fp();
                            }
                        }, 250L);
                    }
                    gd.this.t();
                }
            });
        }
    }

    public gd(Context context, String str) {
        View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.bytedance.msdk.core.admanager.gd.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (gd.this.f27709c == 0) {
                    return;
                }
                gd.this.fp();
                gd.this.t();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                gd.this.ys();
            }
        };
        this.ys = onAttachStateChangeListener;
        this.fp = new com.bytedance.msdk.api.sr.c.c.c() { // from class: com.bytedance.msdk.core.admanager.gd.2
            @Override // com.bytedance.msdk.api.sr.c.c.c
            public void a_(com.bytedance.msdk.api.c cVar) {
                if (gd.this.f27712p != null) {
                    gd.this.f27712p.a_(cVar);
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.c.c
            public void c() {
                if (gd.this.f27712p != null) {
                    gd.this.f27712p.c();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.c.c
            public void i_() {
                gd.this.ys();
                if (gd.this.f27712p != null) {
                    gd.this.f27712p.i_();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.c.c
            public void j_() {
                if (gd.this.f27712p != null) {
                    gd.this.f27712p.j_();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.c.c
            public void k_() {
                if (gd.this.f27712p != null) {
                    gd.this.f27712p.k_();
                }
            }
        };
        this.ia = new AnonymousClass3();
        this.f27715w = new SoftReference<>(context);
        this.xv = str;
        this.ux = new xv(context, str);
        if (context != null) {
            RefreshableBannerView refreshableBannerView = new RefreshableBannerView(context);
            this.f27713r = refreshableBannerView;
            refreshableBannerView.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f27713r.setVisibilityChangeListener(new RefreshableBannerView.c() { // from class: com.bytedance.msdk.core.admanager.gd.4
                @Override // com.bytedance.msdk.core.views.RefreshableBannerView.c
                public void c(boolean z3) {
                    if (z3) {
                        if (gd.this.f27709c == 0) {
                            return;
                        }
                        gd.this.t();
                        return;
                    }
                    gd.this.ys();
                }
            });
        }
        this.ev = new Handler(com.bytedance.msdk.adapter.sr.f.w());
        this.gd = new Handler(Looper.getMainLooper());
        c(this.ux);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp() {
        Context context;
        SoftReference<Context> softReference = this.f27715w;
        if (softReference == null || (context = softReference.get()) == null) {
            return;
        }
        xv xvVar = new xv(context, this.xv);
        this.f27710f = xvVar;
        xvVar.c(this.fp);
        this.f27710f.c(this.f27711k);
        c(this.f27710f);
        this.f27710f.c(this.sr, (com.bytedance.msdk.api.sr.c.c.w) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.ev.removeCallbacksAndMessages(null);
        this.ev.postDelayed(this.ia, this.f27709c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ys() {
        this.ev.removeCallbacksAndMessages(null);
    }

    public int a() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            return xvVar.eu();
        }
        return -1;
    }

    public com.bytedance.sdk.openadsdk.ys.w.w.sr bk() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            return xvVar.p();
        }
        return null;
    }

    public com.bytedance.msdk.api.xv k() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            return xvVar.gd();
        }
        return null;
    }

    public List<com.bytedance.msdk.api.xv> ev() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            return xvVar.bw();
        }
        return null;
    }

    public Map<String, Object> f() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            return xvVar.ta();
        }
        return new HashMap();
    }

    public com.bytedance.msdk.api.xv gd() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            return xvVar.x();
        }
        return null;
    }

    public List<com.bytedance.msdk.api.xv> p() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            return xvVar.m();
        }
        return null;
    }

    public List<com.bytedance.msdk.api.w> r() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            return xvVar.wo();
        }
        return new ArrayList();
    }

    public boolean sr() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            return xvVar.f();
        }
        return false;
    }

    @Nullable
    public View ux() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.w((com.bytedance.msdk.c.ux) null);
            View c4 = this.ux.c(this.f27715w.get());
            if (c4 != null && this.f27713r != null) {
                w(this.ux);
                this.f27713r.removeAllViews();
                ViewParent parent = c4.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(c4);
                }
                this.f27713r.addView(c4);
                return this.f27713r;
            }
        }
        return null;
    }

    public void xv() {
        this.gd.removeCallbacksAndMessages(null);
        ys();
        RefreshableBannerView refreshableBannerView = this.f27713r;
        if (refreshableBannerView != null) {
            refreshableBannerView.removeOnAttachStateChangeListener(this.ys);
        }
        xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.w();
        }
        xv xvVar2 = this.f27710f;
        if (xvVar2 != null) {
            xvVar2.w();
        }
    }

    private void c(@Nullable xv xvVar) {
        com.bytedance.msdk.core.k.w ux = xvVar.ux();
        if (ux != null) {
            int gd = ux.gd(1);
            if (gd >= 10000 && gd <= 180000) {
                this.f27709c = gd;
                com.bytedance.msdk.adapter.sr.xv.c("TMe", "---==-----banner\u8f6e\u64ad\u65f6\u95f4\uff1a" + this.f27709c);
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.c("TMe", "---==-----banner\u8f6e\u64ad\u65f6\u95f4\u4e0b\u53d1\u4e0d\u572810*1000\uff5e180*1000\u8303\u56f4\u5185\uff1a" + gd + "\uff0c\u7981\u6b62banner\u8f6e\u64ad");
        }
    }

    public void w() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.h_();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(@NonNull xv xvVar) {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f27714t.get();
        if (tTDislikeDialogAbstract != null) {
            xvVar.c(tTDislikeDialogAbstract);
        }
        Activity activity = this.f27708a.get();
        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar = this.bk.get();
        if (activity == null || cVar == null) {
            return;
        }
        xvVar.c(activity, cVar);
    }

    public void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.c.w wVar2) {
        if (this.ux != null) {
            this.sr = wVar;
            if (!com.bytedance.msdk.core.c.w().c(this.ux.pr(), 1) && wVar2 != null) {
                wVar2.c(new com.bytedance.msdk.api.c(840031, com.bytedance.msdk.api.c.c(840031)));
            } else if (com.bytedance.msdk.core.c.w().k()) {
                this.ux.c(this.sr.ia());
                this.ux.c(this.sr, wVar2);
            } else if (wVar2 != null) {
                wVar2.c(new com.bytedance.msdk.api.c(840032, com.bytedance.msdk.api.c.c(840032)));
            }
        }
    }

    public void c(com.bytedance.msdk.api.sr.c.c.c cVar) {
        this.f27712p = cVar;
        xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.c(this.fp);
        }
    }

    public void c(com.bytedance.msdk.api.sr.c.c.sr srVar) {
        this.f27711k = srVar;
        xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.c(srVar);
        }
    }

    public void c() {
        xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.r();
        }
    }

    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        this.f27708a = new SoftReference<>(activity);
        this.bk = new SoftReference<>(cVar);
    }

    public void c(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        this.f27714t = new SoftReference<>(tTDislikeDialogAbstract);
    }

    public com.bytedance.sdk.openadsdk.ys.w.w.ev c(Activity activity) {
        xv xvVar = this.ux;
        if (xvVar != null) {
            return xvVar.c(activity);
        }
        return null;
    }

    public void c(String str) {
        xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.a_(str);
        }
    }
}
