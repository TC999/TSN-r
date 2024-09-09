package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.eq.ck;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.nativeexpress.w;
import com.bytedance.sdk.openadsdk.core.p.w.c;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.w.c.xv.sr;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fz extends w {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p.w.xv f34060a;

    /* renamed from: c  reason: collision with root package name */
    protected NativeExpressView f34061c;

    /* renamed from: f  reason: collision with root package name */
    private c f34062f;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.ui.c f34063k;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p.w.c f34064r;
    protected WeakReference<k> ux;

    /* renamed from: w  reason: collision with root package name */
    protected final Context f34067w;
    protected me xv;
    protected String sr = "embeded_ad";
    private long bk = 0;

    /* renamed from: t  reason: collision with root package name */
    private Double f34066t = null;
    private boolean ys = false;
    private boolean fp = false;
    private AtomicBoolean ia = new AtomicBoolean(false);

    /* renamed from: s  reason: collision with root package name */
    private AtomicBoolean f34065s = new AtomicBoolean(false);

    public fz(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.f34067w = context;
        this.xv = meVar;
        c(context, meVar, wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> k() {
        HashMap hashMap = new HashMap();
        ls.c(hashMap, this.xv, this.f34061c);
        if (this.f34061c != null && com.bytedance.sdk.openadsdk.core.eq.u.sr(this.xv)) {
            hashMap.put("openPlayableLandingPage", this.f34061c.i());
        }
        return hashMap;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w
    public me gd() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux ev() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.ys.w.w.sr f() {
        me meVar = this.xv;
        if (meVar == null || meVar.ve() == null) {
            return null;
        }
        this.xv.ve().w(this.sr);
        return new com.bytedance.sdk.openadsdk.core.dislike.xv.c(this.xv.ve());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public Map<String, Object> r() {
        me meVar = this.xv;
        if (meVar != null) {
            Map<String, Object> tc = meVar.tc();
            if (tc == null) {
                tc = new HashMap<>();
            }
            if (!tc.containsKey("live_room_id")) {
                tc.put("live_room_id", this.xv.yw());
            }
            if (!tc.containsKey("live_interaction_type")) {
                tc.put("live_interaction_type", Integer.valueOf(this.xv.kp()));
            }
            if (this.xv.nh() != null && !tc.containsKey("group_info")) {
                tc.put("group_info", this.xv.nh().sr());
            }
            return tc;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void sr() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = this.f34063k;
        if (cVar != null) {
            cVar.c(this.f34061c);
        }
        this.f34061c.fp();
        com.bytedance.sdk.openadsdk.core.ux.sr.c().c(this.xv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void ux() {
        super.ux();
        NativeExpressView nativeExpressView = this.f34061c;
        if (nativeExpressView != null) {
            nativeExpressView.a();
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f34060a;
        if (xvVar != null) {
            xvVar.f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int w() {
        me meVar = this.xv;
        if (meVar == null) {
            return -1;
        }
        return meVar.tz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int xv() {
        me meVar = this.xv;
        if (meVar == null) {
            return -1;
        }
        return meVar.v();
    }

    public void c(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, meVar, wVar, this.sr);
        this.f34061c = nativeExpressView;
        c(nativeExpressView, this.xv);
    }

    private void w(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        if (this.f34063k == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar2 = new com.bytedance.sdk.openadsdk.core.dislike.ui.c(activity, this.xv.ve(), this.sr, false);
            this.f34063k = cVar2;
            com.bytedance.sdk.openadsdk.core.dislike.xv.c(activity, cVar2, this.xv);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar3 = this.f34063k;
        if (cVar3 != null) {
            cVar3.c(this.f34061c);
        }
        this.f34063k.c(cVar);
        NativeExpressView nativeExpressView = this.f34061c;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.f34063k);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public View c() {
        com.bytedance.sdk.openadsdk.core.ux.sr.c().c(this.xv);
        return this.f34061c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar) {
        c c4 = c.c(wVar);
        this.f34062f = c4;
        this.f34061c.setExpressInteractionListener(c4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar) {
        c c4 = c.c(cVar);
        this.f34062f = c4;
        this.f34061c.setExpressInteractionListener(c4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
        com.bytedance.sdk.openadsdk.core.p.w.c c4 = c.C0501c.c(wVar);
        this.f34064r = c4;
        w.c cVar = this.gd;
        if (cVar != null) {
            cVar.c(c4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
        this.f34066t = d4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        if (cVar == null || activity == null) {
            return;
        }
        w(activity, cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(String str) {
        com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w
    protected void c(Dialog dialog) {
        if (dialog == null) {
            com.bytedance.sdk.component.utils.a.xv("dialog is null, please check");
            return;
        }
        NativeExpressView nativeExpressView = this.f34061c;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(dialog);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.ys.w.w.ev c(Activity activity) {
        if (this.f34063k == null) {
            w(activity, null);
        }
        return this.f34063k;
    }

    private com.bytedance.sdk.openadsdk.core.p.w.xv c(me meVar) {
        NativeExpressView nativeExpressView;
        if (meVar.v() == 4) {
            if (meVar.dd() && (nativeExpressView = this.f34061c) != null && nativeExpressView.u()) {
                return new com.bytedance.sdk.openadsdk.core.p.c(this.f34067w, meVar, this.sr);
            }
            return com.bytedance.sdk.openadsdk.core.p.xv.c(this.f34067w, meVar, this.sr);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    public void c(NativeExpressView nativeExpressView, final me meVar) {
        this.xv = meVar;
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.w.xv() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.fz.1
            @Override // com.bytedance.sdk.component.adexpress.w.xv
            public boolean c(ViewGroup viewGroup, int i4) {
                try {
                    ((NativeExpressView) viewGroup).s();
                    k kVar = new k(viewGroup.getContext());
                    com.bytedance.sdk.openadsdk.core.video.sr.c.c(Integer.valueOf(meVar.hashCode()), fz.this);
                    fz fzVar = fz.this;
                    kVar.c(fzVar.xv, (NativeExpressView) viewGroup, fzVar.f34060a);
                    kVar.setDislikeInner(fz.this.f34063k);
                    kVar.setDislikeOuter(fz.this.f34209p);
                    fz fzVar2 = fz.this;
                    me meVar2 = fzVar2.xv;
                    if (meVar2 != null) {
                        fzVar2.c(meVar2.ve());
                    }
                    fz.this.ux = new WeakReference<>(kVar);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.p.w.xv c4 = c(meVar);
        this.f34060a = c4;
        if (c4 != null) {
            c4.sr();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.f34060a.c((Activity) nativeExpressView.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.core.a.xv.c(meVar);
        EmptyView c5 = c(nativeExpressView);
        if (c5 == null) {
            EmptyView emptyView = new EmptyView(this.f34067w, nativeExpressView, meVar != null ? meVar.ek() : 1000);
            emptyView.setPreloadMainKey(this.xv);
            nativeExpressView.addView(emptyView);
            c5 = emptyView;
        }
        c5.setCallback(new EmptyView.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.fz.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(boolean z3) {
                if (fz.this.f34060a != null) {
                    if (z3) {
                        if (fz.this.f34060a != null) {
                            fz.this.f34060a.sr();
                        }
                    } else if (fz.this.f34060a != null) {
                        fz.this.f34060a.ux();
                    }
                }
                fz fzVar = fz.this;
                fzVar.bk = com.bytedance.sdk.openadsdk.core.a.xv.c(fzVar.bk, z3, meVar, fz.this.sr);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void w() {
                if (fz.this.f34060a != null) {
                    fz.this.f34060a.f();
                }
                fz fzVar = fz.this;
                fzVar.bk = com.bytedance.sdk.openadsdk.core.a.xv.c(fzVar.bk, meVar, fz.this.sr);
                fz.this.ia.set(false);
                fz.this.f34065s.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c() {
                if (fz.this.f34060a != null) {
                    fz.this.f34060a.xv();
                    fz.this.f34060a.c(fz.this.gd);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(View view) {
                fz.this.bk = System.currentTimeMillis();
                com.bytedance.sdk.component.utils.a.w("TTNativeExpressAd", "ExpressView SHOW");
                Map k4 = fz.this.k();
                fz.this.ia.set(true);
                if (!fz.this.f34065s.get()) {
                    me meVar2 = meVar;
                    fz fzVar = fz.this;
                    com.bytedance.sdk.openadsdk.core.a.xv.c(meVar2, fzVar.sr, k4, fzVar.f34066t);
                }
                if (fz.this.f34062f != null) {
                    fz.this.f34062f.w(view, meVar.v());
                }
                fz.this.ev.getAndSet(true);
                NativeExpressView nativeExpressView2 = fz.this.f34061c;
                if (nativeExpressView2 != null) {
                    nativeExpressView2.ia();
                    fz.this.f34061c.ys();
                }
            }
        });
        Context context = this.f34067w;
        String str = this.sr;
        f fVar = new f(context, meVar, str, wv.c(str));
        c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        fVar.c(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f34060a);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this);
        this.f34061c.setClickListener(fVar);
        Context context2 = this.f34067w;
        String str2 = this.sr;
        ux uxVar = new ux(context2, meVar, str2, wv.c(str2));
        c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        uxVar.c(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f34060a);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this);
        this.f34061c.setClickCreativeListener(uxVar);
        c(this.f34060a, this.f34061c);
        c5.setNeedCheckingShow(true);
    }

    public void c(final com.bytedance.sdk.openadsdk.core.w.c.xv.sr srVar) {
        srVar.c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.fz.3
            @Override // com.bytedance.sdk.openadsdk.core.w.c.xv.sr.c
            public boolean c() {
                srVar.w(fz.this.k());
                srVar.c(fz.this.sr);
                srVar.c(fz.this.f34066t);
                boolean z3 = fz.this.ia.get();
                fz.this.f34065s.set(!z3);
                return z3;
            }
        });
    }

    private void c(com.bytedance.sdk.openadsdk.core.p.w.xv xvVar, NativeExpressView nativeExpressView) {
        if (xvVar == null || nativeExpressView == null) {
            return;
        }
        me meVar = this.xv;
        w.c cVar = new w.c(this.f34064r, meVar != null ? meVar.jr() : "");
        this.gd = cVar;
        xvVar.c(cVar);
    }

    private EmptyView c(ViewGroup viewGroup) {
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
        if (this.ys) {
            return;
        }
        ck.c(this.xv, d4);
        this.ys = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
        if (this.fp) {
            return;
        }
        ck.c(this.xv, d4, str, str2);
        this.fp = true;
    }
}
