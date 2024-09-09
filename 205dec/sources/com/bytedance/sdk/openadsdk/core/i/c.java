package com.bytedance.sdk.openadsdk.core.i;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.ia;
import com.bytedance.sdk.openadsdk.core.eq.ck;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.gb;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.fz;
import com.bytedance.sdk.openadsdk.core.nativeexpress.u;
import com.bytedance.sdk.openadsdk.core.p.w.c;
import com.bytedance.sdk.openadsdk.core.p.w.xv;
import com.bytedance.sdk.openadsdk.core.u.a;
import com.bytedance.sdk.openadsdk.core.u.ba;
import com.bytedance.sdk.openadsdk.core.u.ev;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.sr;
import com.bytedance.sdk.openadsdk.n.gd;
import com.bytedance.sdk.openadsdk.ys.w.f;
import com.bytedance.sdk.openadsdk.ys.w.ux;
import com.bytedance.sdk.openadsdk.ys.w.w.bk;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends ux {

    /* renamed from: c  reason: collision with root package name */
    private final j f33742c;
    private w ev;

    /* renamed from: f  reason: collision with root package name */
    private int f33743f;
    private com.bytedance.sdk.openadsdk.j.c.w.c.c fz;
    private PlayableFeedWebView gb;
    private f gd;

    /* renamed from: j  reason: collision with root package name */
    private boolean f33745j;

    /* renamed from: k  reason: collision with root package name */
    private View f33746k;

    /* renamed from: n  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.j f33747n;

    /* renamed from: p  reason: collision with root package name */
    private ViewGroup f33748p;

    /* renamed from: r  reason: collision with root package name */
    private int f33750r;

    /* renamed from: s  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.j.c.w.c.w f33751s;
    private ev sr;

    /* renamed from: t  reason: collision with root package name */
    private float f33752t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f33753u;
    private com.bytedance.sdk.openadsdk.ys.w.w.ux ux;

    /* renamed from: w  reason: collision with root package name */
    private final me f33754w;
    private final Context xv;
    private float ys;

    /* renamed from: a  reason: collision with root package name */
    private boolean f33741a = false;
    private boolean bk = true;
    private AtomicBoolean fp = new AtomicBoolean(false);
    private AtomicBoolean ia = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private boolean f33744i = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f33749q = false;
    private WeakReference<NativeVideoTsView> ls = null;
    private com.bytedance.sdk.openadsdk.j.c.w.c.c ck = null;

    public c(Context context, me meVar, int i4, w wVar, boolean z3) {
        ia.c(meVar, "materialMeta\u4e0d\u80fd\u4e3anull");
        this.f33745j = z3;
        this.f33754w = meVar;
        if (context == null) {
            this.xv = ls.getContext();
        } else {
            this.xv = context;
        }
        this.f33743f = i4;
        this.ev = wVar;
        j jVar = new j(this.xv, this, meVar, c(i4));
        this.f33742c = jVar;
        jVar.c(i4);
        this.gd = c(meVar);
    }

    private boolean ba() {
        me meVar = this.f33754w;
        if (meVar == null || meVar.v() == 5) {
            return false;
        }
        if (this.f33750r == 0) {
            this.f33750r = wv.gd(this.f33754w);
        }
        return ls.w().ev(this.f33750r) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 5 ? i4 != 6 ? i4 != 9 ? "embeded_ad" : "draw_ad" : "stream" : "embeded_ad" : "interaction" : "banner_ad";
    }

    private void eq() {
        ViewGroup viewGroup = this.f33748p;
        if (viewGroup == null || this.gd == null || this.f33746k == null) {
            return;
        }
        viewGroup.removeAllViews();
        if (this.f33746k.getParent() != null) {
            ((ViewGroup) this.f33746k.getParent()).removeAllViews();
        }
        this.f33748p.addView(this.f33746k);
    }

    private void y() {
        com.bytedance.sdk.openadsdk.j.c.w.c.w wVar;
        if (this.gd == null) {
            com.bytedance.sdk.openadsdk.j.c.w.c.w wVar2 = this.f33751s;
            if (wVar2 != null) {
                wVar2.onRenderSuccess(this.f33748p, this.ev.p(), this.ev.k(), false);
            }
        } else if (this.fp.get() && (wVar = this.f33751s) != null) {
            wVar.onRenderSuccess(this.f33746k, this.f33752t, this.ys, this.ia.get());
        } else {
            this.gd.c(new com.bytedance.sdk.openadsdk.ls.c.w.c.w(null) { // from class: com.bytedance.sdk.openadsdk.core.i.c.4
                @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
                public void onAdClicked(View view, int i4) {
                    if (c.this.fz != null) {
                        c.this.fz.onAdClicked(view, c.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
                public void onAdShow(View view, int i4) {
                    if (c.this.fz != null) {
                        c.this.fz.onAdShow(c.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
                public void onRenderFail(View view, String str, int i4) {
                    c.this.fp.set(true);
                    c cVar = c.this;
                    cVar.f33746k = cVar.f33748p;
                    c cVar2 = c.this;
                    cVar2.f33752t = cVar2.ev.p();
                    c cVar3 = c.this;
                    cVar3.ys = cVar3.ev.k();
                    if (c.this.f33751s != null) {
                        c.this.f33751s.onRenderSuccess(c.this.f33748p, c.this.ev.p(), c.this.ev.k(), false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
                public void onRenderSuccess(View view, float f4, float f5) {
                    c.this.fp.set(true);
                    c.this.ia.set(true);
                    c.this.f33746k = view;
                    c.this.f33752t = f4;
                    c.this.ys = f5;
                    if (c.this.f33751s != null) {
                        c.this.f33751s.onRenderSuccess(view, f4, f5, true);
                    }
                }
            });
            this.gd.sr();
        }
    }

    private void z() {
        if (this.f33745j) {
            c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int a() {
        if (this.f33754w.ix() != null) {
            return this.f33754w.ix().r();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String bk() {
        return this.f33754w.yh();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar, sr srVar) {
    }

    public boolean ck() {
        return this.f33741a;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int fp() {
        me meVar = this.f33754w;
        if (meVar == null) {
            return -1;
        }
        return meVar.v();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux gb() {
        return new MediationNativeManagerDefault();
    }

    public Context getContext() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public View i() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int ia() {
        me meVar = this.f33754w;
        if (meVar == null) {
            return -1;
        }
        return meVar.tz();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void j() {
        y();
        com.bytedance.sdk.openadsdk.core.ux.sr.c().c(this.f33754w).c(this.f33743f).w(this.f33750r);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int k() {
        if (this.f33754w.ix() != null) {
            return this.f33754w.ix().f();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void ls() {
        f fVar = this.gd;
        if (fVar != null) {
            fVar.ux();
        }
        me meVar = this.f33754w;
        if (meVar != null) {
            gb.c(meVar.iy());
        }
        j jVar = this.f33742c;
        if (jVar != null) {
            jVar.w();
        }
        PlayableFeedWebView playableFeedWebView = this.gb;
        if (playableFeedWebView != null) {
            playableFeedWebView.gd();
        }
    }

    public boolean n() {
        return this.bk;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int p() {
        if (this.f33754w.ix() != null) {
            return this.f33754w.ix().ux();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public Map<String, Object> q() {
        me meVar = this.f33754w;
        if (meVar != null) {
            return meVar.tc();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.sr s() {
        me meVar = this.f33754w;
        if (meVar == null || meVar.ve() == null) {
            return null;
        }
        this.f33754w.ve().w(c(this.f33743f));
        return new com.bytedance.sdk.openadsdk.core.dislike.xv.c(this.f33754w.ve());
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public bk t() {
        if (!com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f33754w)) {
            return this.f33754w.kr() == null ? com.bytedance.sdk.openadsdk.core.u.gb.c(0, 0, "", 0.0d) : com.bytedance.sdk.openadsdk.core.u.gb.c(this.f33754w.kr());
        } else if (TextUtils.isEmpty(ba.gd(this.f33754w))) {
            return com.bytedance.sdk.openadsdk.core.u.gb.c(0, 0, "", 0.0d);
        } else {
            return com.bytedance.sdk.openadsdk.core.u.gb.c(ba.k(this.f33754w), ba.p(this.f33754w), ba.gd(this.f33754w), 0.0d);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.ux u() {
        j jVar;
        final xv c4;
        if (this.gd == null || !this.fp.get()) {
            if (this.ux == null && (jVar = this.f33742c) != null && (c4 = jVar.c()) != null) {
                this.ux = new com.bytedance.sdk.openadsdk.ys.w.w.ux() { // from class: com.bytedance.sdk.openadsdk.core.i.c.2
                    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ux
                    public void c() {
                        int p3;
                        xv xvVar = c4;
                        if ((xvVar instanceof com.bytedance.sdk.openadsdk.core.p.xv.f) && (1 == (p3 = ((com.bytedance.sdk.openadsdk.core.p.xv.f) xvVar).p()) || 4 == p3 || 6 == p3 || 7 == p3)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("downloadstatuscontroller_type", 1);
                            c cVar = c.this;
                            String c5 = cVar.c(cVar.f33743f);
                            ev.c cVar2 = new ev.c();
                            float f4 = xk.f(c.this.xv);
                            com.bytedance.sdk.openadsdk.core.a.xv.c("click", c.this.f33754w, cVar2.c(f4).c(xk.ev(c.this.xv)).w(xk.r(c.this.xv)).c(), c5, true, hashMap, 1, false);
                        }
                        c4.c(me.ux(c.this.f33754w));
                    }

                    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ux
                    public void w() {
                        c4.r();
                    }
                };
            }
            return this.ux;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public List<bk> ys() {
        ArrayList arrayList = new ArrayList();
        if (this.f33754w.nc() != null && !this.f33754w.nc().isEmpty()) {
            for (com.bytedance.sdk.openadsdk.core.u.gb gbVar : this.f33754w.nc()) {
                bk c4 = com.bytedance.sdk.openadsdk.core.u.gb.c(gbVar);
                if (c4 != null) {
                    arrayList.add(c4);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context] */
    private void sr(Activity activity) {
        Context context = this.xv;
        Activity activity2 = activity;
        if (context instanceof Activity) {
            activity2 = activity;
            if (!((Activity) context).isFinishing()) {
                activity2 = this.xv;
            }
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.c(activity2, this.f33754w.ve(), c(this.f33743f), false);
        this.sr = cVar;
        com.bytedance.sdk.openadsdk.core.dislike.xv.c(activity2, cVar, this.f33754w);
    }

    private NativeVideoTsView xv(ViewGroup viewGroup) {
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if ("ado_tag".equals(childAt.getTag()) && (childAt instanceof NativeVideoTsView)) {
                return (NativeVideoTsView) childAt;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String ev() {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f33754w)) {
            return ba.f(this.f33754w);
        }
        if (!TextUtils.isEmpty(this.f33754w.ny())) {
            return this.f33754w.ny();
        }
        return this.f33754w.ju();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public Bitmap f() {
        me meVar = this.f33754w;
        if (meVar == null) {
            return BitmapFactory.decodeResource(this.xv.getResources(), i.sr(ls.getContext(), "tt_ad_logo_new"));
        }
        String ez = meVar.ez();
        if (TextUtils.isEmpty(ez)) {
            return BitmapFactory.decodeResource(this.xv.getResources(), i.sr(ls.getContext(), "tt_ad_logo_new"));
        }
        if (this.f33753u == null) {
            this.f33753u = new TextView(ls.getContext());
            this.f33753u.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        xk.c(this.f33753u, ez, ls.getContext());
        return xk.r(this.f33753u);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String gd() {
        return this.f33754w.dk();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String r() {
        me meVar = this.f33754w;
        if (meVar == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            return ba.xv(this.f33754w);
        }
        if (this.f33754w.ix() != null && !TextUtils.isEmpty(this.f33754w.ix().xv())) {
            return this.f33754w.ix().xv();
        }
        if (!TextUtils.isEmpty(bk())) {
            return bk();
        }
        return this.f33754w.ny();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public bk ux() {
        me meVar = this.f33754w;
        if (meVar == null) {
            return com.bytedance.sdk.openadsdk.core.u.gb.c(0, 0, "", 0.0d);
        }
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            if (TextUtils.isEmpty(ba.ev(this.f33754w))) {
                return com.bytedance.sdk.openadsdk.core.u.gb.c(0, 0, "", 0.0d);
            }
            return com.bytedance.sdk.openadsdk.core.u.gb.c(ba.bk(this.f33754w), ba.a(this.f33754w), ba.ev(this.f33754w), 0.0d);
        } else if (ng.bk(this.f33754w) != null) {
            return com.bytedance.sdk.openadsdk.core.u.gb.c(ng.xv(this.f33754w), ng.sr(this.f33754w), ng.w(this.f33754w), 0.0d);
        } else {
            return com.bytedance.sdk.openadsdk.core.u.gb.c(0, 0, "", 0.0d);
        }
    }

    private PlayableFeedWebView w(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if ("easy_pfwv".equals(childAt.getTag()) && (childAt instanceof PlayableFeedWebView)) {
                return (PlayableFeedWebView) childAt;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar) {
        boolean z3 = false;
        ia.c(viewGroup != null || this.ia.get(), "container\u4e0d\u80fd\u4e3anull");
        ia.c((view != null || this.ia.get()) ? true : true, "clickView\u4e0d\u80fd\u4e3anull");
        this.f33748p = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        c(viewGroup, arrayList, null, cVar);
    }

    public me sr() {
        return this.f33754w;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void xv(Activity activity) {
        f fVar = this.gd;
        if (fVar != null) {
            fVar.w(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    /* renamed from: w */
    public a fz() {
        me meVar = this.f33754w;
        if (meVar == null || meVar.v() != 4) {
            return null;
        }
        return new a(this.f33754w);
    }

    private void xv(boolean z3) {
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(this.f33743f, this.f33754w, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void w(Activity activity) {
        if (activity != null) {
            this.f33742c.c(activity);
        }
    }

    public j xv() {
        return this.f33742c;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar) {
        boolean z3 = false;
        ia.c(viewGroup != null || this.ia.get(), "container\u4e0d\u80fd\u4e3anull");
        ia.c(list != null || this.ia.get(), "clickView\u4e0d\u80fd\u4e3anull");
        if (list != null && list.size() > 0) {
            z3 = true;
        }
        ia.c(z3, "clickViews\u6570\u91cf\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e1");
        this.f33748p = viewGroup;
        c(viewGroup, list, list2, null, cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.ux
    public void w(final Dialog dialog, final int[] iArr) {
        f fVar = this.gd;
        if (fVar != null) {
            fVar.c(dialog, iArr);
        }
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.i.c.3
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    com.bytedance.sdk.openadsdk.core.dislike.xv.w ve = c.this.f33754w != null ? c.this.f33754w.ve() : null;
                    if (ve != null) {
                        com.bytedance.sdk.openadsdk.core.dislike.c.w.c(ve, dialog, iArr);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void w(boolean z3) {
        this.f33741a = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
        j jVar = this.f33742c;
        if (jVar != null) {
            jVar.c(d4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar) {
        boolean z3 = false;
        ia.c(viewGroup != null || this.ia.get(), "container\u4e0d\u80fd\u4e3anull");
        ia.c(list != null || this.ia.get(), "clickView\u4e0d\u80fd\u4e3anull");
        if (list != null && list.size() > 0) {
            z3 = true;
        }
        ia.c(z3, "clickViews\u6570\u91cf\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e1");
        this.f33748p = viewGroup;
        c(viewGroup, null, list, list2, view, cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar) {
        boolean z3 = false;
        ia.c(viewGroup != null || this.ia.get(), "container\u4e0d\u80fd\u4e3anull");
        ia.c(list2 != null || this.ia.get(), "clickView\u4e0d\u80fd\u4e3anull");
        if (list2 != null && list2.size() > 0) {
            z3 = true;
        }
        ia.c(z3, "clickViews\u6570\u91cf\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e1");
        this.f33748p = viewGroup;
        c(viewGroup, list, list2, list3, (List<View>) null, view, cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar) {
        int i4;
        List<View> list5 = list3;
        boolean z3 = false;
        ia.c(viewGroup != null || this.ia.get(), "container\u4e0d\u80fd\u4e3anull");
        ia.c(list2 != null || this.ia.get(), "clickView\u4e0d\u80fd\u4e3anull");
        ia.c(list2 != null && list2.size() > 0, "clickViews\u6570\u91cf\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e1");
        this.f33748p = viewGroup;
        this.fz = cVar;
        if (list5 != null && list3.size() > 0) {
            z3 = true;
        }
        xv(z3);
        if (ba()) {
            list5 = c(list2, list3);
        }
        List<View> list6 = list5;
        if (this.ia.get() && ((i4 = this.f33743f) == 5 || i4 == 1 || i4 == 9)) {
            eq();
        }
        if (!this.ia.get()) {
            this.f33742c.c(viewGroup, list, list2, list6, list4, view, cVar, this.ck);
            c(viewGroup);
        }
        com.bytedance.sdk.openadsdk.ys.w.w.ev evVar = this.sr;
        if (evVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.c) {
            ((com.bytedance.sdk.openadsdk.core.dislike.ui.c) evVar).c(this.f33748p);
        }
        z();
    }

    private List<View> c(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                linkedList.add(list.get(i4));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                linkedList.add(list2.get(i5));
            }
        }
        return linkedList;
    }

    public void c(WeakReference<NativeVideoTsView> weakReference) {
        this.ls = weakReference;
    }

    public void c() {
        ViewGroup viewGroup = this.f33748p;
        if (viewGroup == null) {
            return;
        }
        if (this.f33747n == null) {
            this.f33747n = new com.bytedance.sdk.openadsdk.core.u.j(this.f33754w, viewGroup);
        }
        if (TextUtils.isEmpty(this.f33747n.c())) {
            return;
        }
        int w3 = this.f33747n.w();
        NativeVideoTsView nativeVideoTsView = null;
        if (!me.w(this.f33754w)) {
            if (this.f33747n.w() != 0) {
                com.bytedance.sdk.component.utils.a.w("xeasy", "no add");
                return;
            }
        } else {
            WeakReference<NativeVideoTsView> weakReference = this.ls;
            if (weakReference != null && weakReference.get() != null) {
                nativeVideoTsView = this.ls.get();
            } else {
                com.bytedance.sdk.component.utils.a.w("xeasy", "wa v");
                return;
            }
        }
        if (w3 == 0) {
            ViewGroup viewGroup2 = this.f33748p;
            if ((viewGroup2 instanceof FrameLayout) || (viewGroup2 instanceof RelativeLayout)) {
                PlayableFeedWebView w4 = w(viewGroup2);
                this.gb = w4;
                if (w4 != null) {
                    return;
                }
                PlayableFeedWebView playableFeedWebView = new PlayableFeedWebView(this.xv, this.f33754w, this.f33747n, nativeVideoTsView, this.f33748p);
                this.gb = playableFeedWebView;
                this.f33748p.addView(playableFeedWebView);
                if (nativeVideoTsView != null) {
                    nativeVideoTsView.setPlayableFeedWebView(this.gb);
                }
                com.bytedance.sdk.component.utils.a.w("xeasy", "add con ");
            }
        } else if (w3 == 1) {
            PlayableFeedWebView w5 = w(nativeVideoTsView);
            this.gb = w5;
            if (w5 != null) {
                return;
            }
            PlayableFeedWebView playableFeedWebView2 = new PlayableFeedWebView(this.xv, this.f33754w, this.f33747n, nativeVideoTsView, this.f33748p);
            this.gb = playableFeedWebView2;
            if (nativeVideoTsView != null) {
                nativeVideoTsView.c(playableFeedWebView2);
            }
            com.bytedance.sdk.component.utils.a.w("xeasy", "add v");
        } else if (w3 != 2) {
        } else {
            PlayableFeedWebView w6 = w(nativeVideoTsView);
            this.gb = w6;
            if (w6 != null) {
                return;
            }
            PlayableFeedWebView playableFeedWebView3 = new PlayableFeedWebView(this.xv, this.f33754w, this.f33747n, nativeVideoTsView, this.f33748p);
            this.gb = playableFeedWebView3;
            if (nativeVideoTsView != null) {
                nativeVideoTsView.c(playableFeedWebView3, this.f33748p);
            }
            com.bytedance.sdk.component.utils.a.w("xeasy", "add vc");
        }
    }

    void c(ViewGroup viewGroup) {
        if (viewGroup != null && this.f33745j && gd.c(this.f33754w)) {
            NativeVideoTsView xv = xv(viewGroup);
            if (xv != null) {
                if (5 == this.f33743f) {
                    xv.setIsAutoPlay(this.f33741a ? this.ev.r() : this.bk);
                    return;
                } else {
                    xv.setIsAutoPlay(this.bk);
                    return;
                }
            }
            NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.xv, this.f33754w, false, false, wv.w(this.f33743f), false, false);
            if (5 == this.f33743f) {
                nativeVideoTsView.setIsAutoPlay(this.f33741a ? this.ev.r() : this.bk);
            } else {
                nativeVideoTsView.setIsAutoPlay(this.bk);
            }
            nativeVideoTsView.setTag("ado_tag");
            nativeVideoTsView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            viewGroup.addView(nativeVideoTsView);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
        ia.c(wVar, "downloadListener\u4e0d\u80fd\u4e3anull");
        this.f33742c.c(c.C0501c.c(wVar));
        f fVar = this.gd;
        if (fVar != null) {
            fVar.c(wVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.ev c(Activity activity) {
        if (this.gd != null && this.ia.get()) {
            return this.gd.c(activity);
        }
        if (this.sr == null) {
            sr(activity);
        }
        return this.sr;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.ux
    public com.bytedance.sdk.openadsdk.ys.w.w.ev c(final Dialog dialog, int[] iArr) {
        if (dialog != null) {
            com.bytedance.sdk.openadsdk.core.dislike.c.w.c(this.f33754w.ve(), dialog, iArr);
            return new com.bytedance.sdk.openadsdk.ys.w.w.ev() { // from class: com.bytedance.sdk.openadsdk.core.i.c.1
                @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
                public void c() {
                    if ((dialog.getContext() instanceof Activity) && !((Activity) dialog.getContext()).isFinishing()) {
                        dialog.show();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
                public void c(com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
                }

                @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
                public void c(String str) {
                }

                @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
                public void w() {
                }

                @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
                public boolean xv() {
                    return false;
                }
            };
        }
        throw new IllegalArgumentException("dialog is null, please check");
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(com.bytedance.sdk.openadsdk.j.c.w.c.w wVar) {
        this.f33751s = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        f fVar;
        if (cVar == null || activity == null || (fVar = this.gd) == null) {
            return;
        }
        fVar.c(activity, cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(String str) {
        com.bytedance.sdk.openadsdk.core.a.xv.w(this.f33754w, str);
    }

    private f c(me meVar) {
        me meVar2 = this.f33754w;
        if (meVar2 == null || meVar2.y() != 2) {
            return null;
        }
        boolean z3 = ng.bk(meVar) != null;
        int i4 = this.f33743f;
        if (i4 == 1) {
            if (z3) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.xv(this.xv, meVar, this.ev);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.w(this.xv, meVar, this.ev);
        } else if (i4 != 5) {
            if (i4 != 9) {
                return null;
            }
            return new u(this.xv, meVar, this.ev);
        } else if (z3) {
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.j(this.xv, meVar, this.ev);
        } else {
            return new fz(this.xv, meVar, this.ev);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
        if (this.f33744i) {
            return;
        }
        ck.c(this.f33754w, d4);
        this.f33744i = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
        if (this.f33749q) {
            return;
        }
        ck.c(this.f33754w, d4, str, str2);
        this.f33749q = true;
    }

    public void c(boolean z3) {
        this.bk = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
        me meVar = this.f33754w;
        if (meVar != null) {
            gb.c(meVar.iy(), cVar);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.j.c.w.c.c cVar) {
        this.ck = cVar;
    }
}
