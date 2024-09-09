package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.ux.c;
import com.bytedance.sdk.component.adexpress.c.w.r;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.xk;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ys.w.xv.w f34186c;
    private c ev;

    /* renamed from: f  reason: collision with root package name */
    private List<me> f34187f;

    /* renamed from: r  reason: collision with root package name */
    private List<me> f34190r;
    private com.bytedance.sdk.openadsdk.fz.c.w.c.f sr;
    private Context xv;
    private final AtomicBoolean ux = new AtomicBoolean(false);
    private int gd = 5;

    /* renamed from: p  reason: collision with root package name */
    private ScheduledFuture<?> f34189p = null;

    /* renamed from: k  reason: collision with root package name */
    private ScheduledFuture<?> f34188k = null;

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f34185a = new AtomicBoolean(false);

    /* renamed from: w  reason: collision with root package name */
    private final ck f34191w = com.bytedance.sdk.openadsdk.core.ls.c();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void c(List<me> list);
    }

    private sr(Context context) {
        if (context != null) {
            this.xv = StubApp.getOrigApplicationContext(context.getApplicationContext());
        } else {
            this.xv = com.bytedance.sdk.openadsdk.core.ls.getContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr(long j4) {
        List<com.bytedance.sdk.openadsdk.ys.w.w.ys> c4 = c();
        if (!c4.isEmpty()) {
            com.bytedance.sdk.openadsdk.core.a.xv.w(this.f34190r.get(0), wv.w(this.f34186c.q()), j4);
            this.sr.onNativeExpressAdLoad(c4);
        } else {
            this.sr.onError(104, com.bytedance.sdk.openadsdk.core.p.c(104));
            c(104);
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(final long j4) {
        com.bytedance.sdk.openadsdk.core.ugeno.f.c(this.f34190r, new t() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sr.5
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void c() {
                sr.this.xv(j4);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void w() {
                sr.this.xv(j4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final long j4) {
        com.bytedance.sdk.openadsdk.core.k.c.c(this.f34190r, new r.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sr.3
            @Override // com.bytedance.sdk.component.adexpress.c.w.r.c
            public void c() {
                sr.this.xv(j4);
            }

            @Override // com.bytedance.sdk.component.adexpress.c.w.r.c
            public void w() {
                sr.this.xv(j4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(final long j4) {
        if (this.f34185a.get()) {
            return;
        }
        this.f34185a.set(true);
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sr.4
            @Override // java.lang.Runnable
            public void run() {
                sr.this.sr(j4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        List<me> list = this.f34187f;
        if (list != null) {
            list.clear();
        }
        List<me> list2 = this.f34190r;
        if (list2 != null) {
            list2.clear();
        }
        c(true);
        w(true);
    }

    public static sr c(Context context) {
        return new sr(context);
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, int i4, com.bytedance.sdk.openadsdk.fz.c.w.c.f fVar, int i5) {
        c(wVar, i4, fVar, null, i5);
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, int i4, com.bytedance.sdk.openadsdk.fz.c.w.c.f fVar, c cVar, int i5) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.ux.get()) {
            com.bytedance.sdk.component.utils.a.f("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.gd = i4;
        this.ux.set(true);
        this.f34186c = wVar;
        this.sr = fVar;
        this.ev = cVar;
        c(wVar, currentTimeMillis);
    }

    private void w(boolean z3) {
        try {
            ScheduledFuture<?> scheduledFuture = this.f34188k;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            boolean cancel = this.f34188k.cancel(z3);
            com.bytedance.sdk.component.utils.a.w("ExpressAdLoadManager", "CheckValidDoneFutureTask-->cancel.....success=" + cancel);
        } catch (Throwable unused) {
        }
    }

    private void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final long j4) {
        if (wVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.u.wv wvVar = new com.bytedance.sdk.openadsdk.core.u.wv();
        wvVar.f34867r = 2;
        com.bytedance.sdk.openadsdk.fz.c.w.c.f fVar = this.sr;
        if (fVar != null && (fVar instanceof com.bytedance.sdk.openadsdk.core.c.w)) {
            wvVar.gd = ((com.bytedance.sdk.openadsdk.core.c.w) fVar).c();
        }
        this.f34191w.c(wVar, wvVar, this.gd, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sr.1
            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                sr.this.c(i4, str);
                wVar2.c(i4);
                com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                if (cVar.w() == null || cVar.w().isEmpty()) {
                    sr.this.c(-3, com.bytedance.sdk.openadsdk.core.p.c(-3));
                    wVar2.c(-3);
                    com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
                    return;
                }
                sr.this.f34187f = new CopyOnWriteArrayList(cVar.w());
                sr.this.f34190r = new CopyOnWriteArrayList(cVar.w());
                sr.this.c(wVar);
                sr.this.c(j4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        if (this.f34187f == null) {
            return;
        }
        String ux = (wVar == null || !(wVar.q() == 3 || wVar.q() == 4)) ? null : com.bytedance.sdk.openadsdk.n.ev.ux();
        for (me meVar : this.f34187f) {
            com.bytedance.sdk.openadsdk.core.video.xv.c.w(meVar);
            if (meVar.df() && meVar.nc() != null && !meVar.nc().isEmpty()) {
                for (gb gbVar : meVar.nc()) {
                    if (!TextUtils.isEmpty(gbVar.c())) {
                        com.bytedance.sdk.openadsdk.core.q.ux.c().xv().c(new com.bytedance.sdk.openadsdk.a.w(gbVar.c(), gbVar.r()), com.bytedance.sdk.openadsdk.core.q.c.c.w(), gbVar.w(), gbVar.xv(), ux);
                    }
                }
            }
            if (!TextUtils.isEmpty(ng.c(meVar))) {
                if (com.bytedance.sdk.openadsdk.core.ls.w().ux(String.valueOf(wv.gd(meVar))) && com.bytedance.sdk.openadsdk.core.ls.w().pu()) {
                    com.bykv.vk.openvk.component.video.api.xv.sr c4 = ng.c(4, meVar);
                    c4.c("material_meta", meVar);
                    c4.c("ad_slot", Integer.valueOf(wVar != null ? wVar.q() : 0));
                    com.bytedance.sdk.openadsdk.core.video.sr.w.c(c4, (c.InterfaceC0336c) null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final long j4) {
        this.f34185a.set(false);
        if (this.ux.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sr.2
                @Override // java.lang.Runnable
                public void run() {
                    if (sr.this.f34190r == null || sr.this.f34190r.size() <= 0) {
                        if (sr.this.sr != null) {
                            sr.this.sr.onError(108, com.bytedance.sdk.openadsdk.core.p.c(108));
                            sr.this.c(108);
                        }
                        if (sr.this.ev != null) {
                            sr.this.ev.c();
                        }
                        sr.this.w();
                        return;
                    }
                    if (sr.this.sr != null) {
                        sr srVar = sr.this;
                        if (srVar.c(srVar.f34190r)) {
                            sr.this.ux(j4);
                        } else {
                            sr.this.w(j4);
                        }
                    }
                    if (sr.this.ev != null) {
                        sr.this.ev.c(sr.this.f34190r);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(List<me> list) {
        if (list != null && list.size() != 0) {
            for (me meVar : list) {
                if (com.bytedance.sdk.openadsdk.core.ugeno.f.gd(meVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<com.bytedance.sdk.openadsdk.ys.w.w.ys> c() {
        if (this.gd != 5) {
            ArrayList arrayList = new ArrayList(this.f34190r.size());
            for (me meVar : this.f34190r) {
                com.bytedance.sdk.openadsdk.ys.w.w.ys c4 = c(meVar);
                if (c4 != null) {
                    arrayList.add(c4);
                }
            }
            return arrayList;
        }
        ArrayList<me> arrayList2 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (me meVar2 : this.f34190r) {
            if (meVar2 != null) {
                if (meVar2.nh() != null && !TextUtils.isEmpty(meVar2.nh().c())) {
                    xk nh = meVar2.nh();
                    List list = (List) linkedHashMap.get(nh.c());
                    if (list == null) {
                        list = new CopyOnWriteArrayList();
                        linkedHashMap.put(nh.c(), list);
                    }
                    list.add(meVar2);
                } else {
                    arrayList2.add(meVar2);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + linkedHashMap.size());
        if (linkedHashMap.size() > 0) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                List list2 = (List) entry.getValue();
                if (list2.size() > 1) {
                    arrayList3.add(new q(this.xv, list2, this.f34186c));
                } else if (list2.size() == 1) {
                    arrayList2.add(list2.get(0));
                }
            }
            linkedHashMap.clear();
        }
        if (arrayList2.size() > 0) {
            for (me meVar3 : arrayList2) {
                com.bytedance.sdk.openadsdk.ys.w.w.ys c5 = c(meVar3);
                if (c5 != null) {
                    arrayList3.add(c5);
                }
            }
            arrayList2.clear();
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i4) {
        com.bytedance.sdk.openadsdk.core.fz.a.c().ux(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sr.6
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv f4 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(sr.this.gd).xv(sr.this.f34186c.f()).f((sr.this.f34187f == null || sr.this.f34187f.size() <= 0) ? "" : wv.a((me) sr.this.f34187f.get(0)));
                f4.w(i4).r(com.bytedance.sdk.openadsdk.core.p.c(i4));
                return f4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, String str) {
        if (this.ux.getAndSet(false)) {
            com.bytedance.sdk.openadsdk.fz.c.w.c.f fVar = this.sr;
            if (fVar != null) {
                fVar.onError(i4, str);
            }
            c cVar = this.ev;
            if (cVar != null) {
                cVar.c();
            }
            w();
        }
    }

    private com.bytedance.sdk.openadsdk.ys.w.w.ys c(me meVar) {
        boolean z3 = ng.bk(meVar) != null;
        int i4 = this.gd;
        if (i4 == 1) {
            if (z3) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.xv(this.xv, meVar, this.f34186c);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.w(this.xv, meVar, this.f34186c);
        } else if (i4 == 5) {
            if (z3) {
                return new j(this.xv, meVar, this.f34186c);
            }
            return new fz(this.xv, meVar, this.f34186c);
        } else if (i4 != 9) {
            com.bytedance.sdk.component.utils.a.sr("ExpressAdLoadManager", "not support adslog:" + this.gd);
            return null;
        } else {
            return new u(this.xv, meVar, this.f34186c);
        }
    }

    private void c(boolean z3) {
        try {
            ScheduledFuture<?> scheduledFuture = this.f34189p;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            boolean cancel = this.f34189p.cancel(z3);
            com.bytedance.sdk.component.utils.a.f("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=" + cancel);
        } catch (Throwable unused) {
        }
    }
}
