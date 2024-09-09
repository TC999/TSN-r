package com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive;

import android.content.Context;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.msdk.api.AdError;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.eq.n;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.fz;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.PullToRefreshHorizontalRecyclerView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.w;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.ys.w.w.ys;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ExpressOnePointFiveView extends LinearLayout implements w.c {
    private static long bk;

    /* renamed from: a  reason: collision with root package name */
    private int f34118a;

    /* renamed from: c  reason: collision with root package name */
    protected String f34119c;
    private float ev;

    /* renamed from: f  reason: collision with root package name */
    private PullToRefreshHorizontalRecyclerView f34120f;
    private com.bytedance.sdk.openadsdk.ls.c.w.c.w fp;
    private final AtomicBoolean fz;
    private float gd;
    private com.bytedance.sdk.openadsdk.ls.c.w.c.xv ia;

    /* renamed from: k  reason: collision with root package name */
    private f f34121k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.component.widget.recycler.ux f34122p;

    /* renamed from: r  reason: collision with root package name */
    private TextView f34123r;

    /* renamed from: s  reason: collision with root package name */
    private c f34124s;
    private com.bytedance.sdk.openadsdk.ys.w.xv.w sr;

    /* renamed from: t  reason: collision with root package name */
    private int f34125t;
    private com.bytedance.sdk.openadsdk.ys.w.xv.w ux;

    /* renamed from: w  reason: collision with root package name */
    private List<ys> f34126w;
    private List<me> xv;
    private int ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void w(int i4);

        void w(boolean z3);
    }

    public ExpressOnePointFiveView(Context context, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, List<me> list) {
        super(context);
        this.f34126w = new CopyOnWriteArrayList();
        this.f34125t = 0;
        this.ys = 0;
        this.f34119c = "embeded_ad";
        this.fz = new AtomicBoolean(false);
        this.sr = wVar;
        c(context);
        this.xv = list;
        w(list);
    }

    private int getLastMetaCommerceType() {
        try {
            List<me> list = this.xv;
            me meVar = list.get(list.size() - 1);
            if (meVar == null) {
                return 2;
            }
            String yw = meVar.yw();
            int kp = meVar.kp();
            if (TTLiveCommerceHelper.getInstance().getLiveSdkStatus() == 2) {
                if (TTLiveCommerceHelper.getInstance().isSdkLiveRoomType(yw, kp)) {
                    return 1;
                }
            }
            return 2;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr() {
        try {
            List<ys> list = this.f34126w;
            ys ysVar = list.get(list.size() - 1);
            NativeExpressView nativeExpressView = (NativeExpressView) ysVar.c();
            if (nativeExpressView != null) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("refer", "left_slip");
                if (nativeExpressView.getClickListener() != null) {
                    ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) nativeExpressView.getClickListener().c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
                    nativeExpressView.getClickListener().c(nativeExpressView, new gd());
                    com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar = this.fp;
                    if (wVar != null) {
                        wVar.onAdClicked(nativeExpressView, ysVar.xv());
                    }
                } else if (nativeExpressView.getClickCreativeListener() != null) {
                    ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) nativeExpressView.getClickCreativeListener().c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
                    nativeExpressView.getClickCreativeListener().c(nativeExpressView, new gd());
                    com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar2 = this.fp;
                    if (wVar2 != null) {
                        wVar2.onAdClicked(nativeExpressView, ysVar.xv());
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void ux() {
        List<ys> list = this.f34126w;
        if (list != null) {
            for (ys ysVar : list) {
                if (ysVar != null) {
                    try {
                        ysVar.ux();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
            this.f34126w.clear();
        }
    }

    public ys getCurrentCompletelyVisibleAd() {
        try {
            if (this.f34122p != null) {
                return this.f34126w.get(getCurrentCompletelyVisibleAdPosition());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int getCurrentCompletelyVisibleAdPosition() {
        try {
            com.bytedance.sdk.component.widget.recycler.ux uxVar = this.f34122p;
            if (uxVar != null) {
                int k4 = uxVar.k();
                a.w("ExpressOnePointFiveView", "current complete visible, pos: " + k4);
                if (k4 == -1) {
                    int p3 = this.f34122p.p();
                    a.sr("ExpressOnePointFiveView", "complete -1, so current visible, pos: " + p3);
                    return p3;
                }
                return k4;
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getShowAdCount() {
        f fVar = this.f34121k;
        if (fVar != null) {
            return fVar.sr();
        }
        return 0;
    }

    public void setExpressInteractionListener(com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar) {
        this.fp = wVar;
    }

    public void setRefreshListener(c cVar) {
        this.f34124s = cVar;
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar) {
        this.ia = xvVar;
    }

    private void w(List<me> list) {
        this.f34126w.clear();
        for (int i4 = 0; i4 < this.xv.size(); i4++) {
            try {
                this.f34126w.add(null);
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        this.f34126w.set(0, c(list.get(0), 0));
    }

    private void xv() {
        com.bytedance.sdk.component.widget.recycler.ux uxVar = new com.bytedance.sdk.component.widget.recycler.ux(getContext());
        this.f34122p = uxVar;
        uxVar.c(0);
        this.f34120f.setLayoutManager(this.f34122p);
        this.f34121k = new f(getContext(), this, this.f34125t, this.ys);
        this.f34120f.getRecyclerView().setAdapter(this.f34121k);
        this.f34120f.getRecyclerView().setItemAnimator(new com.bytedance.sdk.component.widget.recycler.xv());
        this.f34120f.getRecyclerView().getItemAnimator().c(0L);
        this.f34120f.getRecyclerView().setHasFixedSize(true);
        new sr().c(this.f34120f.getRecyclerView());
        this.f34120f.setOnPullToBottomListener(new PullToRefreshHorizontalRecyclerView.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.ExpressOnePointFiveView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.PullToRefreshHorizontalRecyclerView.c
            public void c() {
                if (ExpressOnePointFiveView.w(500L)) {
                    return;
                }
                if (ExpressOnePointFiveView.this.f34118a == 1) {
                    ExpressOnePointFiveView.this.sr();
                } else {
                    ExpressOnePointFiveView.this.w(false);
                }
            }
        });
        this.f34122p.w(false);
        this.f34121k.c(new f.w() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.ExpressOnePointFiveView.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.f.w
            public void c() {
                if (ExpressOnePointFiveView.this.f34118a == 2) {
                    ExpressOnePointFiveView.this.w(true);
                }
            }
        });
        this.f34120f.getRecyclerView().c(new RecyclerView.t() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.ExpressOnePointFiveView.3
            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.t
            public void c(RecyclerView recyclerView, int i4, int i5) {
                super.c(recyclerView, i4, i5);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.t
            public void c(RecyclerView recyclerView, int i4) {
                if (i4 == 0) {
                    try {
                        ExpressOnePointFiveView.this.w(ExpressOnePointFiveView.this.getCurrentCompletelyVisibleAdPosition() + 2);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        });
    }

    private void c(Context context) {
        addView(com.bytedance.sdk.openadsdk.res.ux.te(context));
        this.f34120f = (PullToRefreshHorizontalRecyclerView) findViewById(2114387790);
        this.f34123r = (TextView) findViewById(2114387676);
        w();
        xv();
    }

    private void w() {
        com.bytedance.sdk.openadsdk.ys.w.xv.w wVar = this.sr;
        if (wVar == null) {
            return;
        }
        this.ev = wVar.p();
        float k4 = this.sr.k();
        this.gd = k4;
        int i4 = (int) (((this.ev - 6.0f) / 3.0f) * 2.0f);
        this.f34125t = i4;
        if (k4 == 0.0f) {
            this.ys = (i4 * 16) / 9;
        } else {
            this.ys = (int) (k4 - 52.0f);
        }
        this.f34120f.setLayoutParams(new LinearLayout.LayoutParams(xk.ux(getContext(), this.ev), xk.ux(getContext(), this.ys)));
        c(this.sr);
    }

    public void c(boolean z3) {
        String str;
        if (this.f34121k == null || this.f34123r == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.w wVar = this.sr;
        boolean z4 = true;
        if (wVar == null || wVar.p() <= 0.0f) {
            if (this.fp == null || z3) {
                return;
            }
            xv(AdError.ERROR_CODE_ADSLOT_SIZE_EMPTY);
            this.fp.onRenderFail(this, p.c(AdError.ERROR_CODE_ADSLOT_SIZE_EMPTY), AdError.ERROR_CODE_ADSLOT_SIZE_EMPTY);
            return;
        }
        List<ys> list = this.f34126w;
        if (list != null && list.size() != 0) {
            z4 = false;
        }
        if (z4) {
            if (this.fp == null || z3) {
                return;
            }
            xv(AdError.ERROR_CODE_ADCOUNT_ERROR);
            this.fp.onRenderFail(this, p.c(AdError.ERROR_CODE_ADCOUNT_ERROR), AdError.ERROR_CODE_ADCOUNT_ERROR);
            return;
        }
        if (!z3) {
            for (int i4 = 0; i4 < this.f34126w.size(); i4++) {
                ys ysVar = this.f34126w.get(i4);
                if (ysVar != null) {
                    c(ysVar, i4);
                }
            }
            xv(this.f34126w);
        }
        this.f34118a = getLastMetaCommerceType();
        try {
            this.f34120f.getRecyclerView().setItemViewCacheSize(this.f34126w.size());
            this.f34121k.c(this.xv, this.f34126w, this.f34118a);
            this.f34120f.getRecyclerView().c(0);
            me meVar = this.xv.get(0);
            if (meVar == null || meVar.nh() == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.u.xk nh = meVar.nh();
            TextView textView = this.f34123r;
            if (nh != null && nh.w() != null) {
                str = nh.w();
                textView.setText(str);
            }
            str = "";
            textView.setText(str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void xv(List<ys> list) {
        ys next;
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.size() <= 2) {
            Iterator<ys> it = list.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                try {
                    next.c().setTag(2114387466, Boolean.TRUE);
                    next.sr();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return;
        }
        for (int i4 = 0; i4 < 2; i4++) {
            ys ysVar = list.get(i4);
            if (ysVar == null) {
                return;
            }
            try {
                ysVar.c().setTag(2114387466, Boolean.TRUE);
                ysVar.sr();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i4) {
        try {
            if (i4 < this.f34126w.size()) {
                ys ysVar = this.f34126w.get(i4);
                if (ysVar == null) {
                    ysVar = c(this.xv.get(i4), i4);
                    this.f34126w.set(i4, ysVar);
                }
                if (ysVar == null) {
                    return;
                }
                Object tag = ysVar.c().getTag(2114387466);
                a.sr("ExpressOnePointFiveView", "nextPosition: " + i4 + "  isRendered: " + tag);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    return;
                }
                ysVar.c().setTag(2114387466, Boolean.TRUE);
                ysVar.sr();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void xv(final int i4) {
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.ExpressOnePointFiveView.4
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("err_code", i4);
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("express_onepointfive_render_error").c(5).xv(ExpressOnePointFiveView.this.sr == null ? "" : ExpressOnePointFiveView.this.sr.f()).w(jSONObject.toString());
            }
        }, "express_onepointfive_render_error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z3) {
        try {
            c cVar = this.f34124s;
            if (cVar != null) {
                cVar.w(z3);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(long j4) {
        boolean z3 = SystemClock.uptimeMillis() - bk <= j4;
        bk = SystemClock.uptimeMillis();
        return z3;
    }

    private void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        w.c w3 = n.w(wVar);
        w3.w(this.ys);
        w3.c(this.f34125t);
        this.ux = w3.c();
    }

    public List<ys> c(List<me> list) {
        if (list == null || list.size() == 0 || this.ux == null) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        int min = Math.min(list.size(), 2);
        for (int i4 = 0; i4 < min; i4++) {
            ys c4 = c(list.get(i4), i4);
            if (c4 != null) {
                copyOnWriteArrayList.add(c4);
            }
        }
        xv(copyOnWriteArrayList);
        return copyOnWriteArrayList;
    }

    private void c(ys ysVar, int i4) {
        ysVar.c(new w(this, i4, this.fp));
        ysVar.c(new xv(this, i4, this.ia));
    }

    public void c(List<me> list, List<ys> list2) {
        if (this.f34126w != null) {
            ux();
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (i4 < list2.size()) {
                    this.f34126w.add(list2.get(i4));
                } else {
                    this.f34126w.add(null);
                }
            }
        }
        List<me> list3 = this.xv;
        if (list3 != null) {
            list3.clear();
            this.xv.addAll(list);
        }
        int showAdCount = getShowAdCount();
        c(true);
        c cVar = this.f34124s;
        if (cVar != null) {
            cVar.w(showAdCount);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.w.c
    public void c(int i4) {
        if (this.fz.get() || i4 != 0 || this.fp == null) {
            return;
        }
        this.fz.set(true);
        this.fp.onRenderSuccess(this, this.ev, this.gd);
        w(1);
        w(2);
    }

    public void c() {
        try {
            ux();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            removeAllViews();
            this.f34124s = null;
            this.fp = null;
            this.ia = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public ys c(me meVar, int i4) {
        ys fzVar;
        if (meVar == null) {
            return null;
        }
        if (ng.bk(meVar) != null) {
            fzVar = new j(getContext(), meVar, this.ux);
        } else {
            fzVar = new fz(getContext(), meVar, this.ux);
        }
        c(fzVar, i4);
        return fzVar;
    }
}
