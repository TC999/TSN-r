package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.ux.c;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.eq.n;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.ExpressOnePointFiveView;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.wv;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class q extends w implements ExpressOnePointFiveView.c {

    /* renamed from: c  reason: collision with root package name */
    protected final Context f34168c;

    /* renamed from: f  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.ys.w.xv.w f34169f;
    private me fp;

    /* renamed from: k  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.ls.c.w.c.xv f34170k;

    /* renamed from: r  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.ys.w.xv.w f34171r;
    protected List<me> sr;
    protected ExpressOnePointFiveView ux;

    /* renamed from: w  reason: collision with root package name */
    protected List<me> f34173w;
    protected List<com.bytedance.sdk.openadsdk.ys.w.w.ys> xv;
    private long bk = 0;

    /* renamed from: t  reason: collision with root package name */
    private final AtomicBoolean f34172t = new AtomicBoolean(false);
    private Double ys = null;

    /* renamed from: a  reason: collision with root package name */
    protected String f34167a = "embeded_ad";

    public q(Context context, List<me> list, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.f34168c = context;
        this.f34173w = list;
        this.f34169f = wVar;
        ExpressOnePointFiveView expressOnePointFiveView = new ExpressOnePointFiveView(context, wVar, list);
        this.ux = expressOnePointFiveView;
        c(expressOnePointFiveView);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux ev() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.ys.w.w.sr f() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w
    public me gd() {
        List<me> list = this.f34173w;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.f34173w.get(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public Map<String, Object> r() {
        HashMap hashMap = new HashMap();
        hashMap.put("_tt_ad_type_onepointfive", Boolean.TRUE);
        try {
            List<me> list = this.f34173w;
            boolean z3 = true;
            me meVar = list.get(list.size() - 1);
            if (TTLiveCommerceHelper.getInstance().getLiveSdkStatus() != 2 || !TTLiveCommerceHelper.getInstance().isSdkLiveRoomType(meVar)) {
                z3 = false;
            }
            hashMap.put("live_support_saas_live", Boolean.valueOf(z3));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void sr() {
        try {
            ExpressOnePointFiveView expressOnePointFiveView = this.ux;
            if (expressOnePointFiveView != null) {
                expressOnePointFiveView.c(false);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void ux() {
        super.ux();
        ExpressOnePointFiveView expressOnePointFiveView = this.ux;
        if (expressOnePointFiveView != null) {
            expressOnePointFiveView.c();
        }
        c(this.xv);
        List<me> list = this.f34173w;
        if (list != null) {
            list.clear();
            this.f34173w = null;
        }
        List<me> list2 = this.sr;
        if (list2 != null) {
            list2.clear();
            this.sr = null;
        }
        this.fp = null;
        this.f34170k = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int xv() {
        com.bytedance.sdk.openadsdk.ys.w.w.ys currentCompletelyVisibleAd;
        ExpressOnePointFiveView expressOnePointFiveView = this.ux;
        if (expressOnePointFiveView == null || (currentCompletelyVisibleAd = expressOnePointFiveView.getCurrentCompletelyVisibleAd()) == null) {
            return -1;
        }
        return currentCompletelyVisibleAd.xv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int w() {
        com.bytedance.sdk.openadsdk.ys.w.w.ys currentCompletelyVisibleAd;
        ExpressOnePointFiveView expressOnePointFiveView = this.ux;
        if (expressOnePointFiveView == null || (currentCompletelyVisibleAd = expressOnePointFiveView.getCurrentCompletelyVisibleAd()) == null) {
            return -1;
        }
        return currentCompletelyVisibleAd.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(boolean z3) {
        List<me> list;
        if (this.ux == null || z3 || (list = this.f34173w) == null) {
            return;
        }
        try {
            list.clear();
            this.f34173w.addAll(this.sr);
            this.ux.c(this.sr, this.xv);
            this.sr = null;
            this.xv = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.ExpressOnePointFiveView.c
    public void w(int i4) {
        this.bk = c(this.bk, i4, this.fp, this.f34167a);
        c((View) this.ux);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.ExpressOnePointFiveView.c
    public void w(final boolean z3) {
        if (this.xv != null) {
            if (z3) {
                return;
            }
            xv(false);
        } else if (this.f34172t.get()) {
        } else {
            this.f34172t.set(true);
            if (this.f34171r == null) {
                this.f34171r = c(this.f34169f);
            }
            final long currentTimeMillis = System.currentTimeMillis();
            wv wvVar = new wv();
            wvVar.f34867r = 2;
            com.bytedance.sdk.openadsdk.core.ls.c().c(this.f34171r, wvVar, 5, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.2
                @Override // com.bytedance.sdk.openadsdk.core.ck.w
                public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar) {
                    if (q.this.f34172t.getAndSet(false)) {
                        wVar.c(i4);
                        com.bytedance.sdk.openadsdk.core.u.w.c(wVar);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ck.w
                public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar) {
                    if (cVar.w() == null || cVar.w().isEmpty()) {
                        if (q.this.f34172t.getAndSet(false)) {
                            wVar.c(-3);
                            com.bytedance.sdk.openadsdk.core.u.w.c(wVar);
                            return;
                        }
                        return;
                    }
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(cVar.w());
                    q qVar = q.this;
                    qVar.c(qVar.f34171r, copyOnWriteArrayList);
                    q.this.c(cVar, copyOnWriteArrayList, z3, currentTimeMillis);
                }
            });
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void c(ExpressOnePointFiveView expressOnePointFiveView) {
        this.ux.setRefreshListener(this);
        EmptyView emptyView = new EmptyView(this.f34168c, expressOnePointFiveView, 1000);
        expressOnePointFiveView.addView(emptyView);
        emptyView.setCallback(new EmptyView.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.1
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(boolean z3) {
                q qVar = q.this;
                qVar.bk = qVar.c(qVar.bk, z3, q.this.f34167a);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void w() {
                try {
                    q qVar = q.this;
                    if (qVar.ux == null || qVar.f34173w == null) {
                        return;
                    }
                    long j4 = qVar.bk;
                    int showAdCount = q.this.ux.getShowAdCount();
                    q qVar2 = q.this;
                    qVar.bk = qVar.c(j4, showAdCount, qVar2.f34173w.get(qVar2.ux.getCurrentCompletelyVisibleAdPosition()), q.this.f34167a);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(View view) {
                q.this.c(view);
            }
        });
        emptyView.setNeedCheckingShow(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        this.bk = System.currentTimeMillis();
    }

    public long c(long j4, boolean z3, String str) {
        if (z3) {
            return System.currentTimeMillis();
        }
        try {
            return c(j4, this.ux.getShowAdCount(), this.f34173w.get(this.ux.getCurrentCompletelyVisibleAdPosition()), str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0L;
        }
    }

    public long c(long j4, int i4, me meVar, String str) {
        if (j4 > 0) {
            try {
                com.bytedance.sdk.openadsdk.core.a.xv.c(System.currentTimeMillis() - j4, i4, meVar, str);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return 0L;
        }
        return j4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public View c() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar) {
        ExpressOnePointFiveView expressOnePointFiveView = this.ux;
        if (expressOnePointFiveView != null) {
            expressOnePointFiveView.setExpressInteractionListener(wVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(String str) {
        com.bytedance.sdk.openadsdk.core.a.xv.w(gd(), str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar) {
        ExpressOnePointFiveView expressOnePointFiveView = this.ux;
        if (expressOnePointFiveView != null) {
            expressOnePointFiveView.setVideoAdListener(xvVar);
        }
    }

    public com.bytedance.sdk.openadsdk.ys.w.xv.w c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        w.c w3 = n.w(wVar);
        w3.ux(c(wVar.ys(), 1));
        return w3.c();
    }

    public String c(String str, int i4) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_tt_group_load_more", i4);
            return jSONObject.toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, List<me> list) {
        for (me meVar : list) {
            com.bytedance.sdk.openadsdk.core.video.xv.c.w(meVar);
            if (meVar.df() && meVar.nc() != null && !meVar.nc().isEmpty()) {
                for (gb gbVar : meVar.nc()) {
                    if (!TextUtils.isEmpty(gbVar.c())) {
                        com.bytedance.sdk.openadsdk.core.q.ux.c().xv().c(new com.bytedance.sdk.openadsdk.a.w(gbVar.c(), gbVar.r()), com.bytedance.sdk.openadsdk.core.q.c.c.w(), gbVar.w(), gbVar.xv(), null);
                    }
                }
            }
            if (me.w(meVar) && !TextUtils.isEmpty(ng.c(meVar))) {
                if (com.bytedance.sdk.openadsdk.core.ls.w().ux(String.valueOf(com.bytedance.sdk.openadsdk.core.eq.wv.gd(meVar))) && com.bytedance.sdk.openadsdk.core.ls.w().pu()) {
                    com.bykv.vk.openvk.component.video.api.xv.sr c4 = ng.c(4, meVar);
                    c4.c("material_meta", meVar);
                    c4.c("ad_slot", Integer.valueOf(wVar != null ? wVar.q() : 0));
                    com.bytedance.sdk.openadsdk.core.video.sr.w.c(c4, (c.InterfaceC0336c) null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.bytedance.sdk.openadsdk.core.u.c cVar, final List<me> list, final boolean z3, final long j4) {
        if (this.f34172t.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.3
                @Override // java.lang.Runnable
                public void run() {
                    me meVar;
                    try {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(cVar.w());
                        if (copyOnWriteArrayList.size() > 0) {
                            com.bytedance.sdk.openadsdk.core.a.xv.w((me) copyOnWriteArrayList.get(0), com.bytedance.sdk.openadsdk.core.eq.wv.w(q.this.f34169f.q()), j4);
                            q qVar = q.this;
                            List<me> list2 = qVar.f34173w;
                            if (list2 == null || list2.size() <= 0) {
                                meVar = null;
                            } else {
                                List<me> list3 = q.this.f34173w;
                                meVar = list3.get(list3.size() - 1);
                            }
                            qVar.fp = meVar;
                            q qVar2 = q.this;
                            qVar2.sr = copyOnWriteArrayList;
                            ExpressOnePointFiveView expressOnePointFiveView = qVar2.ux;
                            if (expressOnePointFiveView != null) {
                                qVar2.xv = expressOnePointFiveView.c(copyOnWriteArrayList);
                            }
                            q.this.xv(z3);
                        } else {
                            q.this.c(108, list);
                        }
                        List list4 = list;
                        if (list4 != null) {
                            list4.clear();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void c(List<com.bytedance.sdk.openadsdk.ys.w.w.ys> list) {
        if (list != null) {
            for (com.bytedance.sdk.openadsdk.ys.w.w.ys ysVar : list) {
                if (ysVar != null) {
                    try {
                        ysVar.ux();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i4, final List<me> list) {
        com.bytedance.sdk.openadsdk.core.fz.a.c().ux(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.4
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                List list2 = list;
                String a4 = (list2 == null || list2.size() <= 0) ? "" : com.bytedance.sdk.openadsdk.core.eq.wv.a((me) list.get(0));
                com.bytedance.sdk.openadsdk.core.fz.c.xv c4 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(5);
                com.bytedance.sdk.openadsdk.ys.w.xv.w wVar = q.this.f34169f;
                com.bytedance.sdk.openadsdk.core.fz.c.xv f4 = c4.xv(wVar != null ? wVar.f() : "").f(a4);
                f4.w(i4).r(com.bytedance.sdk.openadsdk.core.p.c(i4));
                return f4;
            }
        });
    }
}
