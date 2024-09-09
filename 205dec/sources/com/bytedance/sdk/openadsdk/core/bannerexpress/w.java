package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.eq.ck;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.sr;
import com.bytedance.sdk.openadsdk.core.nativeexpress.w;
import com.bytedance.sdk.openadsdk.core.p.w.c;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.w.c.xv.sr;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.sdk.openadsdk.core.nativeexpress.w implements n.c {

    /* renamed from: a  reason: collision with root package name */
    private n f32012a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    protected c f32013c;

    /* renamed from: f  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.p.w.c f32014f;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.ui.c f32016k;

    /* renamed from: q  reason: collision with root package name */
    private volatile View f32017q;

    /* renamed from: r  reason: collision with root package name */
    protected WeakReference<BannerExpressBackupView> f32018r;
    protected com.bytedance.sdk.openadsdk.ys.w.xv.w sr;

    /* renamed from: t  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.s.c.w.c.c f32020t;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.c ux;

    /* renamed from: w  reason: collision with root package name */
    protected final Context f32022w;
    protected me xv;
    private String ys = "banner_ad";
    private final Queue<Long> fp = new LinkedList();
    private Double ia = null;

    /* renamed from: s  reason: collision with root package name */
    private boolean f32019s = false;
    private boolean fz = false;

    /* renamed from: u  reason: collision with root package name */
    private AtomicBoolean f32021u = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private AtomicBoolean f32015i = new AtomicBoolean(false);

    public w(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.f32022w = context;
        this.xv = meVar;
        this.sr = wVar;
        c(context, meVar, wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        n nVar = this.f32012a;
        if (nVar != null) {
            nVar.removeCallbacksAndMessages(null);
        }
    }

    private void bk() {
        sr.c(this.f32022w).c(this.sr, 1, null, new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.w.5
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.sr.c
            public void c(List<me> list) {
                if (list == null || list.isEmpty()) {
                    w.this.k();
                    return;
                }
                me meVar = list.get(0);
                w wVar = w.this;
                wVar.f32013c.c(meVar, wVar.sr);
                w.this.w(meVar);
                w.this.f32013c.xv();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.sr.c
            public void c() {
                w.this.k();
            }
        }, 5000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        n nVar;
        if (this.f32017q == null || !this.f32017q.isShown() || (nVar = this.f32012a) == null) {
            return;
        }
        nVar.removeCallbacksAndMessages(null);
        this.f32012a.sendEmptyMessageDelayed(112201, this.bk);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public ux ev() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.ys.w.w.sr f() {
        me meVar = this.xv;
        if (meVar == null || meVar.ve() == null) {
            return null;
        }
        this.xv.ve().w(this.ys);
        return new com.bytedance.sdk.openadsdk.core.dislike.xv.c(this.xv.ve());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w
    public me gd() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public Map<String, Object> r() {
        me meVar = this.xv;
        if (meVar != null) {
            return meVar.tc();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void sr() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = this.f32016k;
        if (cVar != null) {
            cVar.c(this.f32013c);
        }
        this.f32013c.ux();
        com.bytedance.sdk.openadsdk.core.ux.sr.c().c(this.xv).c(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void ux() {
        super.ux();
        c cVar = this.f32013c;
        if (cVar != null) {
            cVar.sr();
        }
        n nVar = this.f32012a;
        if (nVar != null) {
            nVar.removeCallbacksAndMessages(null);
            this.f32012a = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int xv() {
        me meVar = this.xv;
        if (meVar == null) {
            return -1;
        }
        return meVar.v();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int w() {
        me meVar = this.xv;
        if (meVar == null) {
            return -1;
        }
        return meVar.tz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(me meVar) {
        Queue<Long> queue = this.fp;
        if (queue == null || queue.size() <= 0 || meVar == null) {
            return;
        }
        try {
            long longValue = this.fp.poll().longValue();
            if (longValue > 0) {
                com.bytedance.sdk.openadsdk.core.a.xv.c((System.currentTimeMillis() - longValue) + "", meVar, this.ys);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void w(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        if (this.f32016k == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar2 = new com.bytedance.sdk.openadsdk.core.dislike.ui.c(activity, this.xv.ve(), this.ys, false);
            this.f32016k = cVar2;
            com.bytedance.sdk.openadsdk.core.dislike.xv.c(activity, cVar2, this.xv);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar3 = this.f32016k;
        if (cVar3 != null) {
            cVar3.c(this.f32013c);
        }
        this.f32016k.c(cVar);
        c cVar4 = this.f32013c;
        if (cVar4 == null || cVar4.getCurView() == null) {
            return;
        }
        this.f32013c.getCurView().setDislike(this.f32016k);
    }

    public void c(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        c cVar = new c(context, meVar, wVar);
        this.f32013c = cVar;
        c(cVar.getCurView(), this.xv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public View c() {
        com.bytedance.sdk.openadsdk.core.ux.sr.c().c(this.xv).c(1);
        return this.f32013c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.c c4 = com.bytedance.sdk.openadsdk.core.nativeexpress.c.c(wVar);
        this.ux = c4;
        this.f32013c.setExpressInteractionListener(c4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.c c4 = com.bytedance.sdk.openadsdk.core.nativeexpress.c.c(cVar);
        this.ux = c4;
        this.f32013c.setExpressInteractionListener(c4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(me meVar) {
        if (this.f32013c.getNextView() == null || !this.f32013c.w()) {
            return;
        }
        c(this.f32013c.getNextView(), meVar.ve());
        c(this.f32013c.getNextView(), meVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
        com.bytedance.sdk.openadsdk.core.p.w.c c4 = c.C0501c.c(wVar);
        this.f32014f = c4;
        w.c cVar = this.gd;
        if (cVar != null) {
            cVar.c(c4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> w(NativeExpressView nativeExpressView, me meVar) {
        HashMap hashMap = new HashMap();
        ls.c(hashMap, this.xv, nativeExpressView);
        c cVar = this.f32013c;
        if (cVar != null && cVar.getCurView() != null && u.sr(meVar)) {
            hashMap.put("openPlayableLandingPage", this.f32013c.getCurView().i());
        }
        return hashMap;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        if (cVar == null || activity == null) {
            return;
        }
        this.f32020t = cVar;
        w(activity, cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(String str) {
        com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w
    protected void c(Dialog dialog) {
        if (dialog == null) {
            a.xv("dialog is null, please check");
            return;
        }
        c cVar = this.f32013c;
        if (cVar == null || cVar.getCurView() == null) {
            return;
        }
        this.f32013c.getCurView().setOuterDislike(dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
        this.ia = d4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public ev c(Activity activity) {
        if (this.f32016k == null) {
            w(activity, (com.bytedance.sdk.openadsdk.s.c.w.c.c) null);
        }
        return this.f32016k;
    }

    private com.bytedance.sdk.openadsdk.core.p.w.xv c(me meVar) {
        if (meVar.v() == 4) {
            return com.bytedance.sdk.openadsdk.core.p.xv.c(this.f32022w, meVar, this.ys);
        }
        return null;
    }

    private void c(NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar) {
        if (wVar == null) {
            return;
        }
        if (this.f32020t != null) {
            this.f32016k.c(wVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.f32016k);
            }
        }
        if (this.f34209p != null) {
            c(wVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.f34209p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    public void c(final NativeExpressView nativeExpressView, final me meVar) {
        if (nativeExpressView == null || meVar == null) {
            return;
        }
        this.xv = meVar;
        final com.bytedance.sdk.openadsdk.core.p.w.xv c4 = c(meVar);
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.w.xv() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.w.1
            @Override // com.bytedance.sdk.component.adexpress.w.xv
            public boolean c(ViewGroup viewGroup, int i4) {
                try {
                    ((NativeExpressView) viewGroup).s();
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(viewGroup.getContext());
                    bannerExpressBackupView.c(w.this.xv, (NativeExpressView) viewGroup, c4);
                    bannerExpressBackupView.setDislikeInner(w.this.f32016k);
                    bannerExpressBackupView.setDislikeOuter(((com.bytedance.sdk.openadsdk.core.nativeexpress.w) w.this).f34209p);
                    w wVar = w.this;
                    if (wVar.xv != null) {
                        wVar.c(meVar.ve());
                    }
                    w.this.f32018r = new WeakReference<>(bannerExpressBackupView);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        if (c4 != null) {
            c4.sr();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                c4.c((Activity) nativeExpressView.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.core.a.xv.c(meVar);
        EmptyView c5 = c(nativeExpressView);
        if (c5 == null) {
            EmptyView emptyView = new EmptyView(this.f32022w, nativeExpressView, meVar.ek());
            emptyView.setPreloadMainKey(this.xv);
            nativeExpressView.addView(emptyView);
            c5 = emptyView;
        }
        this.f32017q = c5;
        c5.setCallback(new EmptyView.c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.w.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(boolean z3) {
                a.w("checkWebViewIsTransparent", "TAG=" + w.this.ys + ",onWindowFocusChanged....hasWindowFocus=" + z3);
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = c4;
                if (xvVar != null) {
                    if (z3) {
                        if (xvVar != null) {
                            xvVar.sr();
                        }
                    } else if (xvVar != null) {
                        xvVar.ux();
                    }
                }
                if (z3) {
                    w.this.k();
                    a.w("TTBannerExpressAd", "\u83b7\u5f97\u7126\u70b9\uff0c\u5f00\u59cb\u8ba1\u65f6");
                } else {
                    a.w("TTBannerExpressAd", "\u5931\u53bb\u7126\u70b9\uff0c\u505c\u6b62\u8ba1\u65f6");
                    w.this.a();
                }
                w.this.c(z3, meVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void w() {
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = c4;
                if (xvVar != null) {
                    xvVar.f();
                }
                w.this.xv(meVar);
                w.this.f32021u.set(false);
                w.this.f32015i.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c() {
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = c4;
                if (xvVar != null) {
                    xvVar.xv();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(View view) {
                a.w("TTBannerExpressAd", "ExpressView SHOW");
                if (w.this.fp != null) {
                    w.this.fp.offer(Long.valueOf(System.currentTimeMillis()));
                }
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = c4;
                if (xvVar != null) {
                    xvVar.xv();
                }
                Map w3 = w.this.w(nativeExpressView, meVar);
                w.this.f32021u.set(true);
                if (!w.this.f32015i.get()) {
                    com.bytedance.sdk.openadsdk.core.a.xv.c(meVar, w.this.ys, w3, w.this.ia);
                }
                com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar = w.this.ux;
                if (cVar != null) {
                    cVar.w(view, meVar.v());
                }
                w.this.k();
                w.this.ev.getAndSet(true);
                c cVar2 = w.this.f32013c;
                if (cVar2 == null || cVar2.getCurView() == null) {
                    return;
                }
                w.this.f32013c.getCurView().ia();
                w.this.f32013c.getCurView().ys();
            }
        });
        f fVar = new f(this.f32022w, meVar, this.ys, 2);
        final com.bytedance.sdk.openadsdk.core.w.c.xv.sr srVar = (com.bytedance.sdk.openadsdk.core.w.c.xv.sr) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class);
        srVar.c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.w.3
            @Override // com.bytedance.sdk.openadsdk.core.w.c.xv.sr.c
            public boolean c() {
                srVar.w(w.this.w(nativeExpressView, meVar));
                srVar.c(w.this.ys);
                srVar.c(w.this.ia);
                boolean z3 = w.this.f32021u.get();
                w.this.f32015i.set(!z3);
                return z3;
            }
        });
        fVar.c(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(c4);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this);
        nativeExpressView.setClickListener(fVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.ux uxVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.ux(this.f32022w, meVar, this.ys, 2);
        final com.bytedance.sdk.openadsdk.core.w.c.xv.sr srVar2 = (com.bytedance.sdk.openadsdk.core.w.c.xv.sr) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class);
        srVar2.c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.w.4
            @Override // com.bytedance.sdk.openadsdk.core.w.c.xv.sr.c
            public boolean c() {
                srVar2.w(w.this.w(nativeExpressView, meVar));
                srVar2.c(w.this.ys);
                srVar2.c(w.this.ia);
                boolean z3 = w.this.f32021u.get();
                w.this.f32015i.set(!z3);
                return z3;
            }
        });
        uxVar.c(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(c4);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this);
        nativeExpressView.setClickCreativeListener(uxVar);
        c(c4, nativeExpressView);
        c5.setNeedCheckingShow(true);
    }

    private void c(com.bytedance.sdk.openadsdk.core.p.w.xv xvVar, NativeExpressView nativeExpressView) {
        if (xvVar == null || nativeExpressView == null) {
            return;
        }
        me meVar = this.xv;
        w.c cVar = new w.c(this.f32014f, meVar != null ? meVar.jr() : "");
        this.gd = cVar;
        xvVar.c(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z3, me meVar) {
        Queue<Long> queue = this.fp;
        if (queue == null) {
            return;
        }
        try {
            if (z3) {
                queue.offer(Long.valueOf(System.currentTimeMillis()));
            } else if (queue.size() > 0) {
                long longValue = this.fp.poll().longValue();
                com.bytedance.sdk.openadsdk.core.a.xv.c((System.currentTimeMillis() - longValue) + "", meVar, this.ys);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private EmptyView c(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            try {
                View childAt = viewGroup.getChildAt(i4);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(int i4) {
        if (i4 <= 0) {
            return;
        }
        this.ys = "slide_banner_ad";
        c(this.f32013c.getCurView(), this.xv);
        this.f32013c.setDuration(1000);
        if (i4 < 30000) {
            i4 = 30000;
        } else if (i4 > 120000) {
            i4 = 120000;
        }
        this.bk = i4;
        this.f32012a = new n(Looper.getMainLooper(), this);
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what == 112201 && this.f32017q != null && this.f32017q.isShown()) {
            bk();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
        if (this.f32019s) {
            return;
        }
        ck.c(this.xv, d4);
        this.f32019s = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
        if (this.fz) {
            return;
        }
        ck.c(this.xv, d4, str, str2);
        this.fz = true;
    }
}
