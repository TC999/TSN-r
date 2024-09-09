package com.bytedance.msdk.core.r;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.msdk.adapter.c;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.sr.p;
import com.bytedance.msdk.core.gd.bk;
import com.bytedance.msdk.core.gd.gd;
import com.bytedance.msdk.core.ux.w.w;
import com.bytedance.msdk.f.fp;
import com.bytedance.msdk.f.fz;
import com.bytedance.msdk.f.j;
import com.bytedance.msdk.f.yu;
import com.bytedance.msdk.sr.c.a;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class ux extends xv implements c.InterfaceC0386c {
    protected com.bytedance.msdk.c.ux bm;
    protected long bw;
    protected w.xv fm;
    protected com.bytedance.msdk.core.fp.xv gw;

    /* renamed from: h  reason: collision with root package name */
    protected int f28109h;

    /* renamed from: m  reason: collision with root package name */
    protected long f28110m;
    protected com.bytedance.msdk.adapter.w.f mt;
    protected int oh;
    protected long pr;
    protected com.bytedance.msdk.adapter.w.f up;
    protected SoftReference<Context> vc;
    private boolean wx;

    /* renamed from: x  reason: collision with root package name */
    protected long f28112x;
    protected p xu;

    /* renamed from: c  reason: collision with root package name */
    private final long f28108c = 500;
    protected volatile boolean oo = false;
    protected volatile boolean au = false;
    protected volatile boolean bj = false;

    /* renamed from: w  reason: collision with root package name */
    private final Map<String, com.bytedance.msdk.adapter.c> f28111w = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    protected int f28107b = -1000;
    protected int wo = -1000;
    protected final AtomicBoolean ox = new AtomicBoolean(false);
    private ConcurrentHashMap<String, com.bytedance.msdk.api.w> xv = new ConcurrentHashMap<>();
    protected long ng = 0;
    private long yu = 0;
    private final Map<Integer, List<com.bytedance.msdk.core.k.p>> ge = new HashMap();
    protected boolean ok = false;
    private int ta = 0;
    private final Comparator<com.bytedance.msdk.core.k.p> eu = new Comparator<com.bytedance.msdk.core.k.p>() { // from class: com.bytedance.msdk.core.r.ux.11
        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(com.bytedance.msdk.core.k.p pVar, com.bytedance.msdk.core.k.p pVar2) {
            int j4;
            int j5;
            if (pVar.j() == pVar2.j()) {
                j4 = pVar.ls();
                j5 = pVar2.ls();
            } else {
                j4 = pVar.j();
                j5 = pVar2.j();
            }
            return j4 - j5;
        }
    };
    protected final Comparator<com.bytedance.msdk.core.k.p> te = new Comparator<com.bytedance.msdk.core.k.p>() { // from class: com.bytedance.msdk.core.r.ux.13
        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(com.bytedance.msdk.core.k.p pVar, com.bytedance.msdk.core.k.p pVar2) {
            if (pVar.q() > pVar2.q()) {
                return -1;
            }
            return pVar.q() < pVar2.q() ? 1 : 0;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public ux(Context context, String str, int i4) {
        Map<Integer, List<com.bytedance.msdk.core.k.p>> n4;
        this.vc = new SoftReference<>(context);
        this.gd = str;
        this.xk = i4;
        com.bytedance.msdk.core.fp.xv w3 = com.bytedance.msdk.core.c.w();
        this.gw = w3;
        this.wv = w3.w();
        com.bytedance.msdk.core.fp.xv xvVar = this.gw;
        if (xvVar != null) {
            sr(xvVar.pr());
            xv(this.gw.ux());
            this.f28159r = this.gw.c(this.gd, s(), 100);
            bm();
        }
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null && (n4 = wVar.n()) != null) {
            for (Map.Entry<Integer, List<com.bytedance.msdk.core.k.p>> entry : n4.entrySet()) {
                List<com.bytedance.msdk.core.k.p> value = entry.getValue();
                if (value != null && value.size() > 0 && value.get(0).s() == 100) {
                    this.ge.put(entry.getKey(), entry.getValue());
                }
            }
        }
        Looper w4 = com.bytedance.msdk.adapter.sr.f.w();
        if (w4 != null) {
            this.f28157p = new Handler(w4) { // from class: com.bytedance.msdk.core.r.ux.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    ux.this.c(message);
                }
            };
            return;
        }
        com.bytedance.msdk.adapter.sr.f.c();
        this.f28157p = new Handler(com.bytedance.msdk.adapter.sr.f.w()) { // from class: com.bytedance.msdk.core.r.ux.12
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ux.this.c(message);
            }
        };
    }

    private void a() {
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u5f00\u5c4f\u5e7f\u544a\u8d70\u4e86\u5f00\u53d1\u8005\u81ea\u5b9a\u4e49\u5f00\u5c4f\u515c\u5e95\uff0c\u6570\u636e\u4e3a: getAdNetworkFlatFromId = " + this.xu.c() + " getAppId = " + this.xu.xv() + " getAppKey = " + this.xu.sr() + " getAdNetworkSlotId = " + this.xu.w());
        p pVar = this.xu;
        if (pVar != null && !TextUtils.isEmpty(pVar.w()) && (!TextUtils.isEmpty(this.xu.xv()) || !TextUtils.isEmpty(this.xu.sr()))) {
            int c4 = this.xu.c();
            final String c5 = com.bytedance.msdk.c.c.c(c4);
            final String w3 = this.xu.w();
            if (TextUtils.isEmpty(c5)) {
                w(new com.bytedance.msdk.api.c(840027, com.bytedance.msdk.api.c.c(840027)), (com.bytedance.msdk.core.k.xv) null);
                return;
            } else if (c4 == 3) {
                new com.bytedance.msdk.sr.c.ux(this.xu).c(this.xu);
                Handler handler = this.f28157p;
                if (handler != null) {
                    handler.postDelayed(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.17
                        @Override // java.lang.Runnable
                        public void run() {
                            ux.this.c(c5, w3);
                        }
                    }, 500L);
                    return;
                }
                return;
            } else if (c4 == 1) {
                com.bytedance.msdk.sr.c.p.w(this.xu).c(this.xu, new com.bytedance.msdk.adapter.c.w() { // from class: com.bytedance.msdk.core.r.ux.18
                    @Override // com.bytedance.msdk.adapter.c.w
                    public void c() {
                        ux.this.c(c5, w3);
                    }

                    @Override // com.bytedance.msdk.adapter.c.w
                    public void c(@NonNull com.bytedance.msdk.api.c cVar) {
                    }
                });
                return;
            } else if (c4 == 7) {
                new com.bytedance.msdk.sr.c.r(this.xu).c(this.xu);
                c(c5, w3);
                return;
            } else if (c4 == 6) {
                new com.bytedance.msdk.sr.c.w(this.xu).c(this.xu);
                c(c5, w3);
                return;
            } else if (c4 == 4) {
                new com.bytedance.msdk.sr.c.ev(this.xu).c(this.xu);
                c(c5, w3);
                return;
            } else if (c4 == 8) {
                new a(this.xu).c(this.xu);
                c(c5, w3);
                return;
            } else if (c4 == 9) {
                new com.bytedance.msdk.sr.c.f(this.xu).c(this.xu, new com.bytedance.msdk.adapter.c.w() { // from class: com.bytedance.msdk.core.r.ux.19
                    @Override // com.bytedance.msdk.adapter.c.w
                    public void c() {
                        ux.this.c(c5, w3);
                    }

                    @Override // com.bytedance.msdk.adapter.c.w
                    public void c(@NonNull com.bytedance.msdk.api.c cVar) {
                    }
                });
                return;
            } else {
                w(new com.bytedance.msdk.api.c(840027, com.bytedance.msdk.api.c.c(840027)), (com.bytedance.msdk.core.k.xv) null);
                return;
            }
        }
        w(new com.bytedance.msdk.api.c(840027, com.bytedance.msdk.api.c.c(840027)), (com.bytedance.msdk.core.k.xv) null);
    }

    private int bk() {
        List<com.bytedance.msdk.core.k.p> list;
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        int i4 = 0;
        if (wVar == null) {
            return 0;
        }
        Map<Integer, List<com.bytedance.msdk.core.k.p>> n4 = wVar.n();
        if (n4 != null && n4.size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList();
            arrayList.addAll(n4.keySet());
            for (Integer num : arrayList) {
                if (this.f28158q.ux(num.intValue()) && (list = n4.get(num)) != null) {
                    i4 += list.size();
                }
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp() {
        com.bytedance.msdk.api.c.w wVar = this.f28155k;
        if ((wVar == null || wVar.fz() != 7) && this.f28155k.fz() != 8) {
            return;
        }
        com.bytedance.msdk.api.c.w wVar2 = this.f28155k;
        com.bytedance.msdk.c.ux uxVar = this.bm;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.yu;
        com.bytedance.msdk.core.k.w wVar3 = this.f28159r;
        com.bytedance.msdk.xv.r.c(wVar2, uxVar, elapsedRealtime, wVar3 != null ? wVar3.mt() : null);
    }

    private boolean ia() {
        return !n_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.ck = System.currentTimeMillis();
        Map<Integer, List<com.bytedance.msdk.core.k.p>> map = this.ev;
        if (map == null) {
            xv(new com.bytedance.msdk.api.c(840040, com.bytedance.msdk.api.c.c(840040)));
            return;
        }
        List<com.bytedance.msdk.core.k.p> list = map.get(0);
        if (yu.c(list)) {
            xv(new com.bytedance.msdk.api.c(840040, com.bytedance.msdk.api.c.c(840040)));
            return;
        }
        int xv = this.f28155k.xv();
        JSONObject jSONObject = new JSONObject();
        c(com.bytedance.msdk.core.ys.c.c().c(this.f28163y, this.vc.get(), this.f28155k, list, this.f28159r, xv, !n_(), jSONObject), jSONObject);
    }

    private double p() {
        com.bytedance.msdk.core.k.w c4 = com.bytedance.msdk.ux.c.c.p().c(this.gd, s(), 102);
        double d4 = 0.0d;
        if (c4 == null) {
            return 0.0d;
        }
        for (com.bytedance.msdk.core.k.p pVar : c4.up()) {
            if (pVar.wv() && pVar.q() > d4) {
                d4 = pVar.q();
            }
        }
        return d4;
    }

    private boolean t() {
        List<com.bytedance.msdk.c.ux> list = this.f28162u;
        if (list != null) {
            for (com.bytedance.msdk.c.ux uxVar : list) {
                if (uxVar.isCacheSuccess()) {
                    return true;
                }
            }
        }
        List<com.bytedance.msdk.c.ux> list2 = this.fz;
        if (list2 != null) {
            for (com.bytedance.msdk.c.ux uxVar2 : list2) {
                if (uxVar2.isCacheSuccess()) {
                    return true;
                }
            }
        }
        List<com.bytedance.msdk.c.ux> list3 = this.f28160s;
        if (list3 != null) {
            for (com.bytedance.msdk.c.ux uxVar3 : list3) {
                if (uxVar3.isCacheSuccess()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void ys() {
        if (this.f28157p != null) {
            if (t()) {
                if (!this.sr.get() || this.f28152f.get()) {
                    return;
                }
                this.f28152f.set(true);
                com.bytedance.msdk.api.c.w wVar = this.f28155k;
                if ((wVar != null && wVar.fz() == 7) || this.f28155k.fz() == 8) {
                    com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u4eceonAdLoaded\u7ed9\u5916\u90e8invokeAdVideoCache ...");
                }
                if (n_()) {
                    return;
                }
                fp();
                com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.8
                    @Override // java.lang.Runnable
                    public void run() {
                        ux.this.sr();
                    }
                });
                return;
            }
            this.f28157p.postDelayed(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.9
                @Override // java.lang.Runnable
                public void run() {
                    if (!ux.this.sr.get() || ux.this.f28152f.get()) {
                        return;
                    }
                    ux.this.f28152f.set(true);
                    com.bytedance.msdk.api.c.w wVar2 = ux.this.f28155k;
                    if ((wVar2 != null && wVar2.fz() == 7) || ux.this.f28155k.fz() == 8) {
                        com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(ux.this.gd) + "m-sdk----\u8bbe\u7f6e cacheTimeout \u5df2\u5230\u65f6\u95f4\u3010" + com.bytedance.msdk.core.c.w().c(ux.this.s(), ux.this.f28155k.u()) + "\u3011\uff0c\u7ed9\u5916\u90e8invokeAdVideoCache ...");
                    }
                    if (ux.this.n_()) {
                        return;
                    }
                    ux.this.fp();
                    com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ux.this.sr();
                        }
                    });
                }
            }, com.bytedance.msdk.core.c.w().c(s(), this.f28155k.u()));
        }
    }

    public ConcurrentHashMap<String, com.bytedance.msdk.api.w> b() {
        return this.xv;
    }

    public List<com.bytedance.msdk.core.k.p> be() {
        boolean z3;
        List<com.bytedance.msdk.core.k.p> arrayList = new ArrayList<>();
        if (this.bj) {
            return arrayList;
        }
        List<Integer> list = this.ia;
        int i4 = 0;
        if (list == null || list.size() <= 0) {
            z3 = false;
        } else {
            int i5 = 0;
            z3 = false;
            while (i4 < list.size()) {
                int intValue = list.get(i4).intValue();
                if (intValue == -100) {
                    i5 = 1;
                }
                if (intValue < -100) {
                    z3 = true;
                }
                if (this.ev.get(Integer.valueOf(intValue)) != null) {
                    arrayList.addAll(this.ev.get(Integer.valueOf(intValue)));
                }
                i4++;
            }
            i4 = i5;
        }
        if (i4 == 0 && eq() && !yu.w(this.fz)) {
            for (com.bytedance.msdk.c.ux uxVar : this.fz) {
                if (this.f28159r != null && (uxVar.isMultiBiddingAd() || uxVar.isClientBiddingAd())) {
                    com.bytedance.msdk.core.k.p f4 = this.f28159r.f(uxVar.getAdNetworkSlotId());
                    if (f4 != null) {
                        arrayList.add(f4);
                    }
                }
            }
        }
        if (!z3) {
            List<com.bytedance.msdk.core.k.p> z4 = z();
            if (!yu.c(z4)) {
                arrayList.addAll(z4);
            }
        }
        Iterator<com.bytedance.msdk.core.k.p> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
        if (!y() && !eq()) {
            Collections.sort(arrayList, this.eu);
            return arrayList;
        }
        return ev(arrayList);
    }

    public int bj() {
        return this.oh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bm() {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null) {
            this.pr = wVar.wx();
            this.bw = this.f28159r.pr();
            this.f28112x = this.f28159r.bw();
            this.f28110m = this.f28159r.i();
            this.bk = this.f28159r.eq();
            this.f28151a = this.f28159r.y();
            this.f28161t = this.f28159r.u() == 0;
            this.f28109h = this.f28159r.oo();
            this.oh = this.f28159r.au();
            this.f28153i.put("render_control", Integer.valueOf(this.f28159r.c()));
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "mRitConfig=" + this.f28159r.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(com.bytedance.msdk.api.c cVar);

    public int eu() {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            return uxVar.getInteractionType();
        }
        return -1;
    }

    protected int ev(int i4) {
        List<Integer> list = this.ia;
        if (list == null) {
            return -1;
        }
        return list.indexOf(Integer.valueOf(i4)) + 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(int i4) {
        com.bytedance.msdk.core.k.p pVar;
        List<com.bytedance.msdk.core.k.p> list = this.ev.get(Integer.valueOf(i4));
        if (list != null) {
            Iterator<com.bytedance.msdk.core.k.p> it = list.iterator();
            while (it.hasNext()) {
                pVar = it.next();
                if (pVar != null && pVar.ba() && TextUtils.equals(pVar.t(), "pangle")) {
                    break;
                }
            }
        }
        pVar = null;
        return pVar != null && pVar.gd() == 3;
    }

    protected void fm() {
        if (this.xu != null) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "settings config.......AdUnitId = " + this.gd + "  \u5f00\u5c4f\u5e7f\u544a\u8d70\u4e86\u5f00\u53d1\u8005\u81ea\u5b9a\u4e49\u515c\u5e95\u65b9\u6848   adnName:" + com.bytedance.msdk.c.c.c(this.xu.c()));
        }
        ux(AdError.ERROR_CODE_CONFIG_ERROR);
        com.bytedance.msdk.xv.r.w(this.f28155k, -4);
        a();
    }

    public void g_() {
        com.bytedance.msdk.api.c.w wVar = this.f28155k;
        if (wVar != null) {
            wVar.c(this.wv);
        }
        final boolean ck = com.bytedance.msdk.core.c.w().ck();
        final StackTraceElement[] stackTrace = ck ? Thread.currentThread().getStackTrace() : null;
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.15
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.core.fp.xv xvVar;
                ux.this.ng = SystemClock.elapsedRealtime();
                if (!com.bytedance.msdk.sr.xv.w()) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(ux.this.gd) + "MSDK\u672a\u8fdb\u884c\u521d\u59cb\u5316\uff01\uff01\uff01");
                    ux.this.ux(1);
                    ux.this.w(new com.bytedance.msdk.api.w.c(1, com.bytedance.msdk.api.c.c(1)), (com.bytedance.msdk.core.k.xv) null);
                } else if (ux.this.bj) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u8c03\u7528\u8fc7\u9500\u6bc1\u65b9\u6cd5_destroy()\uff01\uff01\uff01");
                    ux.this.ux(41044);
                    ux.this.w(new com.bytedance.msdk.api.w.c(41044, com.bytedance.msdk.api.c.c(41044)), (com.bytedance.msdk.core.k.xv) null);
                } else if (ux.this.vc.get() == null) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "Context\u4e3anull\uff01\uff01\uff01");
                    ux.this.ux(AdError.ERROR_CODE_CONTEXT_ERROR);
                    ux.this.w(new com.bytedance.msdk.api.w.c(AdError.ERROR_CODE_CONTEXT_ERROR, com.bytedance.msdk.api.c.c(AdError.ERROR_CODE_CONTEXT_ERROR)), (com.bytedance.msdk.core.k.xv) null);
                } else {
                    ux uxVar = ux.this;
                    if (uxVar.f28155k == null) {
                        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(ux.this.gd) + "AdSlot can't be null\uff01\uff01");
                        ux.this.ux(840026);
                        ux.this.w(new com.bytedance.msdk.api.w.c(840026, com.bytedance.msdk.api.c.c(840026)), (com.bytedance.msdk.core.k.xv) null);
                    } else if (TextUtils.isEmpty(uxVar.gd)) {
                        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(ux.this.gd) + "\u5e7f\u544a\u4f4did\u4e0d\u80fd\u4e3a\u7a7a");
                        ux.this.ux(840026);
                        ux.this.w(new com.bytedance.msdk.api.w.c(840026, "\u5e7f\u544a\u4f4did\u4e0d\u80fd\u4e3a\u7a7a"), (com.bytedance.msdk.core.k.xv) null);
                    } else {
                        ux uxVar2 = ux.this;
                        if (uxVar2.f28157p == null) {
                            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(ux.this.gd) + "msdk threadHandler can't be null\uff01\uff01");
                            ux.this.ux(41043);
                            ux.this.w(new com.bytedance.msdk.api.w.c(41043, com.bytedance.msdk.api.c.c(41043)), (com.bytedance.msdk.core.k.xv) null);
                            return;
                        }
                        if (uxVar2.f28159r == null && (xvVar = uxVar2.gw) != null) {
                            uxVar2.f28159r = xvVar.c(uxVar2.gd, uxVar2.s(), 100);
                            ux.this.bm();
                        }
                        ux uxVar3 = ux.this;
                        uxVar3.f28155k.c(uxVar3.f28159r);
                        ux.this.f28155k.gd();
                        ux.this.oo = true;
                        ux.this.te();
                        if (c.c().w()) {
                            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(ux.this.gd) + "\u8bf7\u6c42\u8fc7\u4e8e\u9891\u7e41\uff0c\u89e6\u53d1\u4e86\u7194\u65ad\u673a\u5236");
                            ux.this.ux(840043);
                            ux.this.w(new com.bytedance.msdk.api.w.c(840043, com.bytedance.msdk.api.c.c(840043)), (com.bytedance.msdk.core.k.xv) null);
                            return;
                        }
                        ux.this.l_();
                        ux uxVar4 = ux.this;
                        com.bytedance.msdk.core.k.w wVar2 = uxVar4.f28159r;
                        if (wVar2 == null) {
                            if (uxVar4.f28155k.fz() == 3 && !com.bytedance.msdk.core.c.w().j() && ux.this.xu != null) {
                                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u6267\u884c\u5f00\u542f\u5f00\u5c4f\u515c\u5e95...............");
                                ux.this.fm();
                                return;
                            }
                            if (ux.this.gw != null && !com.bytedance.msdk.ux.c.c.p().ev()) {
                                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(ux.this.gd) + "settings config.......\u6ce8\u610f\uff0cAdUnitId = " + ux.this.f28155k.u() + " \u7684\u914d\u7f6e\u4fe1\u606f\u4e3a null \uff01\uff01");
                                ux.this.ux(40045);
                                com.bytedance.msdk.xv.r.w(ux.this.f28155k, 2);
                            } else {
                                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(ux.this.gd) + "settings config.......\u6ca1\u6709settings config\u914d\u7f6e\u4fe1\u606f,AdUnitId = " + ux.this.f28155k.u());
                                ux.this.ux(40045);
                                com.bytedance.msdk.xv.r.w(ux.this.f28155k, 1);
                            }
                            ux uxVar5 = ux.this;
                            uxVar5.c(uxVar5.gd, uxVar5.ox);
                            r.ux();
                            return;
                        }
                        uxVar4.ev = wVar2.n();
                        ux.this.ia = new ArrayList(ux.this.f28159r.wv());
                        w.c(ux.this.ia);
                        com.bytedance.msdk.core.fp.xv w3 = com.bytedance.msdk.core.c.w();
                        ux uxVar6 = ux.this;
                        if (w3.w(uxVar6.gd, uxVar6.s()) && ux.this.f28159r.wv() != null && ux.this.f28159r.wv().size() != 0 && ux.this.f28159r.n() != null && ux.this.f28159r.n().size() != 0) {
                            long currentTimeMillis = System.currentTimeMillis();
                            bk c4 = bk.c();
                            boolean ev = c4.ev(ux.this.gd + "");
                            ux.this.c("check_freqctl_time", System.currentTimeMillis() - currentTimeMillis);
                            if (!ev) {
                                com.bytedance.msdk.adapter.sr.xv.c("TMe", "\u5e7f\u544a\u4f4d \u8bf7\u6c42\u89e6\u53d1\u6b21\u6570\u62e6\u622a............");
                                bk c5 = bk.c();
                                com.bytedance.msdk.core.gd.r p3 = c5.p(ux.this.gd + "");
                                Pair<String, String> f4 = bk.c().f(ux.this.gd);
                                if (p3 == null || f4 == null) {
                                    return;
                                }
                                com.bytedance.msdk.api.w.w wVar3 = new com.bytedance.msdk.api.w.w(840041, com.bytedance.msdk.api.c.c(840041), (String) f4.second, (String) f4.first);
                                ux.this.ux(wVar3.f27444c);
                                ux.this.w(wVar3, (com.bytedance.msdk.core.k.xv) null);
                                return;
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            bk c6 = bk.c();
                            boolean xv = c6.xv(ux.this.gd + "");
                            ux.this.c("check_pacing_time", System.currentTimeMillis() - currentTimeMillis2);
                            if (!xv && !ux.this.n_()) {
                                com.bytedance.msdk.adapter.sr.xv.c("TMe", "\u5e7f\u544a\u4f4d \u8bf7\u6c42\u89e6\u53d1\u65f6\u95f4\u95f4\u9694\u62e6\u622a............");
                                bk c7 = bk.c();
                                gd ux = c7.ux(ux.this.gd + "");
                                if (ux != null) {
                                    String c8 = com.bytedance.msdk.api.c.c(840042);
                                    com.bytedance.msdk.api.w.xv xvVar2 = new com.bytedance.msdk.api.w.xv(840042, c8, bk.c().c(ux.this.gd) + "", ux.p());
                                    ux.this.ux(xvVar2.f27444c);
                                    ux.this.w(xvVar2, (com.bytedance.msdk.core.k.xv) null);
                                    return;
                                }
                                return;
                            }
                            com.bytedance.msdk.core.ux.w.w c9 = com.bytedance.msdk.core.ux.w.w.c();
                            ux uxVar7 = ux.this;
                            if (c9.xv(uxVar7.gd, uxVar7.u())) {
                                boolean z3 = com.bytedance.msdk.core.ux.w.w.c().c(ux.this.gd) == null;
                                if (!ux.this.n_() && !z3 && ux.this.ox()) {
                                    ux uxVar8 = ux.this;
                                    uxVar8.ok = true;
                                    uxVar8.xu();
                                    return;
                                }
                                if (!ux.this.n_() && !z3) {
                                    ux.this.f28155k.w(3);
                                }
                                com.bytedance.msdk.core.ux.w.w c10 = com.bytedance.msdk.core.ux.w.w.c();
                                ux uxVar9 = ux.this;
                                c10.c(uxVar9.gd, uxVar9.f28155k);
                            }
                            ux uxVar10 = ux.this;
                            com.bytedance.msdk.core.k.w c11 = com.bytedance.msdk.core.xv.xv.c(uxVar10.f28155k, uxVar10.f28159r);
                            if (c11 != null) {
                                ux.this.f28159r = c11;
                                com.bytedance.msdk.adapter.sr.xv.w("TMe", "prime rit type " + ux.this.f28155k.xv());
                                if (ux.this.f28155k.xv() == 2 || ux.this.f28155k.xv() == 4 || ux.this.f28155k.xv() == 5) {
                                    com.bytedance.msdk.core.ux.w.w c12 = com.bytedance.msdk.core.ux.w.w.c();
                                    ux uxVar11 = ux.this;
                                    c12.c(uxVar11.gd, uxVar11.f28155k);
                                }
                                if (ux.this.f28159r.up() == null || ux.this.f28159r.up().size() == 0) {
                                    ux.this.ux(810085);
                                    ux.this.sr(new com.bytedance.msdk.api.c(810085, com.bytedance.msdk.api.c.c(810085)));
                                    return;
                                }
                            }
                            String c13 = com.bytedance.msdk.core.ia.c.c(ux.this.f28155k.wv());
                            if (!TextUtils.isEmpty(c13)) {
                                ux.this.i();
                                ux uxVar12 = ux.this;
                                uxVar12.f28159r = com.bytedance.msdk.core.ia.c.c(uxVar12.f28159r, c13);
                                com.bytedance.msdk.core.k.w wVar4 = ux.this.f28159r;
                                int j4 = wVar4 != null ? wVar4.j() : 0;
                                ux.this.bm();
                                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(ux.this.gd) + "\u6d4b\u8bd5\u5de5\u5177\u52a0\u8f7d\u5e7f\u544a........totalWaterFallCount: " + j4 + "  ,rit_id:" + ux.this.gd + " ,slot_id:" + c13);
                                ux uxVar13 = ux.this;
                                if (uxVar13.f28159r == null) {
                                    uxVar13.w(new com.bytedance.msdk.api.w.c(81012, com.bytedance.msdk.api.c.c(81012)), (com.bytedance.msdk.core.k.xv) null);
                                    return;
                                }
                            }
                            ux uxVar14 = ux.this;
                            uxVar14.ev = uxVar14.f28159r.n();
                            ux.this.ia = new ArrayList(ux.this.f28159r.wv());
                            w.c(ux.this.ia);
                            ux uxVar15 = ux.this;
                            uxVar15.f28155k.c(uxVar15.f28159r);
                            ux.this.f28155k.gd();
                            ux.this.ux(0);
                            ux.this.c(ck, stackTrace);
                            ux uxVar16 = ux.this;
                            uxVar16.f28158q.c(uxVar16.ia);
                            ux uxVar17 = ux.this;
                            uxVar17.f28158q.c(uxVar17.f28159r.j());
                            ux uxVar18 = ux.this;
                            Handler handler = uxVar18.f28157p;
                            if (handler != null) {
                                handler.sendEmptyMessageDelayed(2, uxVar18.f28112x);
                            }
                            if (ux.this.f28159r.a()) {
                                ux uxVar19 = ux.this;
                                uxVar19.ys = 0;
                                uxVar19.f28158q.w(true);
                                ux.this.k();
                            } else {
                                ux.this.ng();
                            }
                            com.bytedance.msdk.core.fp.w.c(com.bytedance.msdk.core.c.w()).w(1);
                            return;
                        }
                        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(ux.this.gd) + "settings config.......\u6ce8\u610f\uff0cAdUnitId = " + ux.this.f28155k.u() + "  \u6ca1\u6709\u5bf9\u5e94\u7684waterfall\u914d\u7f6e\u4fe1\u606f");
                        com.bytedance.msdk.xv.r.w(ux.this.f28155k, 3);
                        ux.this.ux(40045);
                        ux uxVar20 = ux.this;
                        uxVar20.c(uxVar20.gd, uxVar20.ox);
                    }
                }
            }
        });
    }

    public com.bytedance.msdk.api.xv gd() {
        if (this.bm == null || fz.c()) {
            return null;
        }
        return fp.c(this.f28155k, this.bm, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ge() {
        Handler handler = this.f28157p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u8d85\u8fc7\u5f53\u524d\u5c42\u6700\u77ed\u52a0\u8f7d\u65f6\u95f4.....");
        if (this.sr.get() || fz()) {
            return;
        }
        if (up()) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u8d85\u8fc7\u5f53\u524d\u5c42\u6700\u77ed\u52a0\u8f7d\u65f6\u95f4....\u6709P\u5c42\u5e7f\u544a\u56de\u8c03\u6210\u529f\u51fa\u53bb....");
            ev();
        }
        if (y() && !wv()) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u8d85\u8fc7\u5f53\u524d\u5c42\u6700\u77ed\u52a0\u8f7d\u65f6\u95f4.....  \u5f53\u524d\u6709serverBidding\u5e7f\u544a\uff0cserverBidding\u8bf7\u6c42\u8fd8\u672a\u53d1\u8d77\u6216\u8005\u8fd8\u6ca1\u6709\u8fd4\u56de.......");
        } else if (mt() && n()) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u8d85\u8fc7\u5f53\u524d\u5c42\u6700\u77ed\u52a0\u8f7d\u65f6\u95f4\u4e14\u6ee1\u8db3client bidding\u9650\u5236\u6761\u4ef6....\u6709\u5e7f\u544a\u56de\u8c03\u6210\u529f\u51fa\u53bb....");
            ev();
        }
    }

    protected void l_() {
        this.f28155k.sr(u());
        this.f28155k.w(q());
        this.f28155k.c(r.sr());
        this.f28155k.c(r.xv());
        this.f28155k.xv(com.bytedance.msdk.core.ux.w.w.c().w(this.gd, u()));
    }

    @Override // com.bytedance.msdk.adapter.c.InterfaceC0386c
    public void m_() {
        if (this.f28157p == null || this.ux.get() || this.f28152f.get() || !this.sr.get()) {
            return;
        }
        this.f28152f.set(true);
        oo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ng() {
        c(0, false);
    }

    public void oh() {
        List<com.bytedance.msdk.c.ux> list;
        List<com.bytedance.msdk.c.ux> list2;
        if (this.f28158q.w() != 0 || this.f28156n.get()) {
            return;
        }
        this.f28157p.removeMessages(5);
        if (y() && wv()) {
            if (mt()) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u6210\u529f\u8fd4\u56de...\u6240\u6709\u7684ClientBidding\u90fd\u6709\u8fd4\u56de\u7ed3\u679c\u4e14\u6ca1\u6709\u5230\u8fbe\u5176\u5c42\u8d85\u65f6...\u5f53\u524d\u5e7f\u544a\u6c60\u4e2d\u5e7f\u544a\u6570\u91cf\u6ee1\u8db3\u8981\u6c42...\u76f4\u63a5\u8fd4\u56de......");
                ev();
            }
            if (this.f28158q.c() || !this.f28158q.r()) {
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6240\u6709\u5e7f\u544a\u90fd\u5df2\u7ecf\u52a0\u8f7d\u5b8c\u6210....... ");
            List<com.bytedance.msdk.c.ux> list3 = this.f28162u;
            if ((list3 != null && list3.size() > 0) || (((list = this.f28160s) != null && list.size() > 0) || ((list2 = this.fz) != null && list2.size() > 0))) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u8fd4\u56de\u4e14\u5230\u8fbeClientBidding\u7684\u7b49\u5f85\u65f6\u95f4\uff0c\u6240\u6709\u5e7f\u544a\u90fd\u6709\u8fd4\u56de\u7ed3\u679c...\u76f4\u63a5\u8fd4\u56de......");
                ev();
                return;
            }
            w(new com.bytedance.msdk.api.c(20005, com.bytedance.msdk.api.c.c(20005)), (com.bytedance.msdk.core.k.xv) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ok() {
        List<com.bytedance.msdk.c.ux> list;
        List<com.bytedance.msdk.c.ux> list2;
        this.f28158q.c(true);
        com.bytedance.msdk.core.k.gd gdVar = this.gb;
        if (gdVar != null) {
            gdVar.f28034f = true;
        }
        if (this.sr.get() || this.ux.get()) {
            return;
        }
        List<com.bytedance.msdk.c.ux> list3 = this.f28162u;
        if ((list3 != null && list3.size() > 0) || (((list = this.f28160s) != null && list.size() > 0) || ((list2 = this.fz) != null && list2.size() > 0))) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u603b\u52a0\u8f7d\u65f6\u95f4\u8d85\u65f6.......\u6709\u5e7f\u544a\u56de\u8c03\u6210\u529f");
            ev();
            return;
        }
        if (com.bytedance.msdk.f.w.c.w(this.f28159r)) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u603b\u52a0\u8f7d\u65f6\u95f4\u8d85\u65f6.......isCallback:true");
            if (au()) {
                return;
            }
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u603b\u52a0\u8f7d\u65f6\u95f4\u8d85\u65f6.......\u6ca1\u6709\u5e7f\u544a\u56de\u8c03\u5931\u8d25");
        this.eq = true;
        w(new com.bytedance.msdk.api.c(10003, com.bytedance.msdk.api.c.c(10003)), (com.bytedance.msdk.core.k.xv) null);
    }

    @Override // com.bytedance.msdk.core.r.xv
    protected void oo() {
        com.bytedance.msdk.api.c.w wVar = this.f28155k;
        if ((wVar != null && wVar.fz() == 7) || this.f28155k.fz() == 8) {
            com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5e7f\u544a\u7f13\u5b58\u6210\u529f\uff01\u7ed9\u5916\u90e8\u56de\u8c03\uff1ainvokeAdVideoCacheOnMainUI........");
        }
        if (n_()) {
            return;
        }
        fp();
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.10
            @Override // java.lang.Runnable
            public void run() {
                ux.this.sr();
            }
        });
    }

    protected boolean ox() {
        List<com.bytedance.msdk.core.ux.w.ev> sr;
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "mLoadSortList: " + this.ia);
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (com.bytedance.msdk.core.ux.w.w.c().c(this.gd, this.f28155k, wVar != null ? wVar.mt() : null) && (sr = com.bytedance.msdk.core.ux.w.w.c().sr(this.gd)) != null && sr.size() > 0) {
            for (com.bytedance.msdk.core.ux.w.ev evVar : sr) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(evVar.f28224c);
                ux(arrayList);
            }
            if (this.f28162u.size() > 0 || this.fz.size() > 0 || this.f28160s.size() > 0) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "--==-- hit cache!!! -----");
                return true;
            }
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "--==-- not hit cache!!! -----");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r(int i4) {
        List<com.bytedance.msdk.core.k.p> list;
        long j4;
        Handler handler;
        Handler handler2;
        Map<Integer, List<com.bytedance.msdk.core.k.p>> map = this.ev;
        boolean z3 = false;
        if (map == null || (list = map.get(Integer.valueOf(i4))) == null || list.size() == 0) {
            return false;
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "loadAdByLoadSort start...\u6267\u884c\u5f53\u524d\u52a0\u8f7d\u5c42\u7ea7\uff1aloadSort:" + i4 + "  waterFallConfig.size:" + list.size());
        boolean z4 = list.get(0) != null && list.get(0).s() == 100;
        boolean z5 = list.get(0) != null && (list.get(0).s() == 1 || list.get(0).s() == 3);
        boolean z6 = list.get(0) != null && list.get(0).s() == 2;
        if (list.get(0) != null && list.get(0).s() == 0) {
            z3 = true;
        }
        if (z5) {
            this.f28158q.w(list.size());
        }
        this.f28158q.c(i4, list.size());
        Message message = new Message();
        if (z4) {
            message.what = 4;
        } else if (z5) {
            message.what = 5;
        } else if (z3) {
            message.what = 1;
            message.arg1 = 10003;
        }
        if (z5) {
            j4 = this.f28110m;
        } else {
            j4 = this.bw;
        }
        if (!z6 && (handler2 = this.f28157p) != null) {
            if (message.what == 4) {
                handler2.removeMessages(4);
            } else {
                handler2.removeMessages(1);
            }
            this.f28157p.sendMessageDelayed(message, j4);
        }
        if (this.pr != 0 && (handler = this.f28157p) != null) {
            handler.removeMessages(3);
            this.f28157p.sendEmptyMessageDelayed(3, this.pr);
        }
        return sr(list);
    }

    protected abstract void sr();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean sr(List<com.bytedance.msdk.core.k.p> list) {
        boolean z3 = false;
        for (int i4 = 0; i4 < list.size(); i4++) {
            try {
                if (c(list.get(i4), list.size())) {
                    z3 = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return z3;
    }

    public Map<String, Object> ta() {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        Map<String, Object> mediaExtraInfo = uxVar != null ? uxVar.getMediaExtraInfo() : null;
        if (mediaExtraInfo == null) {
            mediaExtraInfo = f(pr());
        }
        if (fz.c()) {
            String c4 = fz.c(fp.c(this.f28155k, this.bm, true));
            if (!TextUtils.isEmpty(c4)) {
                mediaExtraInfo.put("get_show_ecpm_info", c4);
            }
        }
        return mediaExtraInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void te() {
        this.ox.set(false);
        this.f28154j.set(false);
        this.fz.clear();
        this.f28160s.clear();
        this.f28162u.clear();
        this.sr.set(false);
        this.ux.set(false);
        this.f28152f.set(false);
        Handler handler = this.f28157p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ev evVar = this.f28158q;
        if (evVar != null) {
            evVar.ux();
        }
        com.bytedance.msdk.core.k.gd gdVar = this.gb;
        if (gdVar != null) {
            gdVar.f28033c = null;
        }
    }

    protected void ux(int i4) {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        com.bytedance.msdk.xv.r.c(this.f28155k, wVar != null ? wVar.mt() : null, !n_(), wx(), i4, this.me);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.core.k.xv xvVar) {
    }

    public List<com.bytedance.msdk.api.w> wo() {
        com.bytedance.msdk.api.w value;
        ArrayList arrayList = new ArrayList(this.xv.size());
        for (Map.Entry<String, com.bytedance.msdk.api.w> entry : this.xv.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !TextUtils.equals(AdLoadInfo.AD_LOADED, value.f()) && !TextUtils.equals(AdLoadInfo.AD_LOADING, value.f())) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    protected void xu() {
        com.bytedance.msdk.api.c.w w3 = com.bytedance.msdk.core.ux.w.w.c().w(this.gd);
        final int w4 = com.bytedance.msdk.core.ux.w.w.c().w(this.gd, u());
        if (w3 != null) {
            this.f28155k.c(w3.c());
            this.f28155k.w(w3.xv());
            if (w4 == 3 || w4 == 4) {
                this.f28155k.c(w3.k());
            }
        }
        com.bytedance.msdk.core.ux.w.w.c().c(this.gd, this.f28155k);
        ux(0);
        w((List<com.bytedance.msdk.c.ux>) null, false);
        com.bytedance.msdk.core.ux.w.xv xv = com.bytedance.msdk.core.ux.w.w.c().xv(this.gd);
        if (xv != null) {
            this.gb = xv.gb;
            this.xv = xv.b();
        }
        if (w4 == 2) {
            this.ta = 1;
            ev();
        } else if (w4 != 3 && w4 != 4) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u9884\u7f13\u5b58reqType\u9519\u8bef\uff1areqType = " + w4);
        } else if (this.f28155k.ev() == 1) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u6fc0\u52b1\u518d\u5f97\u60c5\u51b5\uff0c\u4e0d\u8fdb\u884c\u9884\u7f13\u5b58\u8865\u5145\uff0c\u76f4\u63a5\u5bf9\u5916\u7ed9\u51fa\u56de\u8c03");
            this.ta = 2;
            ev();
        } else {
            long f4 = com.bytedance.msdk.core.ux.w.w.f(this.gd);
            long currentTimeMillis = System.currentTimeMillis() - f4;
            if (f4 != -1 && currentTimeMillis < this.f28159r.sr()) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u9884\u7f13\u5b58\u8865\u5145\u8bf7\u6c42\u65e0\u9700\u53d1\u8d77\uff0c\u65f6\u95f4\u95f4\u9694\u4e0d\u591f\uff0cinterval\uff1a" + currentTimeMillis + ", config interval: " + this.f28159r.sr());
                this.ta = 3;
                ev();
                return;
            }
            List<com.bytedance.msdk.c.ux> gw = gw();
            com.bytedance.msdk.c.ux uxVar = (gw == null || gw.size() <= 0) ? null : gw.get(0);
            final double p3 = p();
            if (uxVar != null && !uxVar.isPAd() && uxVar.getCpm() < p3) {
                com.bytedance.msdk.core.ux.w.w.c().c(this.vc.get(), this.gd, w4, this.f28155k, uxVar, new w.xv() { // from class: com.bytedance.msdk.core.r.ux.14
                    @Override // com.bytedance.msdk.core.ux.w.w.xv
                    public void c(String str, boolean z3, int i4, List<com.bytedance.msdk.c.ux> list) {
                        ux.this.c(str, z3, i4, list, w4, p3);
                    }
                });
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u9884\u7f13\u5b58\u8865\u5145\u8bf7\u6c42\u65e0\u9700\u53d1\u8d77\uff0c\u5df2\u7ecf\u547d\u4e2d\u6700\u4f18");
            this.ta = 4;
            ev();
        }
    }

    protected abstract void xv();

    public void w(int i4, boolean z3) {
        c(i4 + 1, z3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xv(List<com.bytedance.msdk.core.k.p> list) {
        Context context = this.vc.get();
        if (context != null) {
            c(context, this.f28155k, list, !n_());
        }
    }

    private com.bytedance.msdk.api.sr.c.w.w.w w(com.bytedance.msdk.api.sr.c.w.xv.c cVar, com.bytedance.msdk.core.k.p pVar) {
        if (pVar.a() == 5) {
            return new com.bytedance.msdk.adapter.xv.c.sr.c(cVar.c());
        }
        if (pVar.a() == 9) {
            return new com.bytedance.msdk.adapter.xv.c.xv.w(cVar.c());
        }
        if (pVar.a() == 3) {
            return new com.bytedance.msdk.adapter.xv.c.r.c(cVar.c());
        }
        if (pVar.a() == 2) {
            return new com.bytedance.msdk.adapter.xv.c.c.c(cVar.c());
        }
        if (pVar.a() == 8) {
            return new com.bytedance.msdk.adapter.xv.c.ux.c(cVar.c());
        }
        if (pVar.a() == 10) {
            if (pVar.ux() == 1) {
                return new com.bytedance.msdk.adapter.xv.c.c.c(cVar.c());
            }
            if (pVar.ux() == 2) {
                return new com.bytedance.msdk.adapter.xv.c.ux.c(cVar.c());
            }
        } else if (pVar.a() == 1) {
            return new com.bytedance.msdk.adapter.xv.c.w.c(cVar.c());
        } else {
            if (pVar.a() == 7) {
                if (pVar.ux() == 6) {
                    return new com.bytedance.msdk.adapter.xv.c.f.c(cVar.c());
                }
                if (pVar.ux() == 7) {
                    return new com.bytedance.msdk.adapter.xv.c.ux.c(cVar.c());
                }
                return new com.bytedance.msdk.adapter.xv.c.f.c(cVar.c());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.xv
    public void ev() {
        ArrayList arrayList;
        ArrayList arrayList2;
        int size;
        Map<String, Object> map;
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + " load done..........s:" + this.sr.get() + "  f:" + this.ux.get() + "     p.size" + this.f28162u.size() + "   bidding.size:" + this.fz.size() + "   normal.size:" + this.f28160s.size());
        ge();
        j();
        this.eq = false;
        if (this.sr.get() || this.ux.get()) {
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5e7f\u544a\u52a0\u8f7d\u6210\u529f\uff01\u7ed9\u5916\u90e8\u56de\u8c03\uff1ainvokeAdLoadCallbackOnMainUI........P.size:" + this.f28162u.size() + "   bidding.size:" + this.fz.size() + "   normal.size:" + this.f28160s.size());
        this.sr.set(true);
        yu();
        if ((n_() || (ia() && !this.ok)) && (y() || eq())) {
            List<com.bytedance.msdk.c.ux> gw = gw();
            com.bytedance.msdk.c.ux uxVar = gw.size() > 0 ? gw.get(0) : null;
            int vc = vc();
            if (vc > 1) {
                arrayList = new ArrayList();
                for (int i4 = 1; i4 < vc; i4++) {
                    if (i4 < gw.size()) {
                        arrayList.add(gw.get(i4));
                    }
                }
                if (gw.size() > vc) {
                    arrayList2 = new ArrayList();
                    while (vc < gw.size()) {
                        com.bytedance.msdk.c.ux uxVar2 = gw.get(vc);
                        if (uxVar2 != null && uxVar2.isServerBiddingAd()) {
                            arrayList2.add(uxVar2);
                        }
                        vc++;
                    }
                } else {
                    arrayList2 = null;
                }
            } else {
                arrayList = null;
                arrayList2 = null;
            }
            com.bytedance.msdk.xv.r.c(uxVar, this.f28155k, arrayList, arrayList2);
        }
        if (!this.ok) {
            List<com.bytedance.msdk.c.ux> gw2 = gw();
            com.bytedance.msdk.core.p.sr.c(this.f28159r, !yu.w(gw2) ? gw2.get(0).getCpm() : 0.0d, this.gd, this.f28155k.fz());
        }
        if (n_()) {
            c(true);
            return;
        }
        if (this.f28162u.size() + this.f28160s.size() + this.fz.size() >= vc()) {
            size = vc();
        } else {
            size = this.f28162u.size() + this.f28160s.size() + this.fz.size();
        }
        int i5 = size;
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null) {
            Map<String, Object> ux = wVar.ux();
            ux.put("has_serverBidding", Boolean.valueOf(this.f28159r.y()));
            map = ux;
        } else {
            map = null;
        }
        com.bytedance.msdk.api.c.w wVar2 = this.f28155k;
        com.bytedance.msdk.c.ux uxVar3 = this.bm;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.ng;
        int bk = bk();
        int ev = ev(this.f28107b);
        com.bytedance.msdk.core.k.w wVar3 = this.f28159r;
        com.bytedance.msdk.xv.r.c(map, wVar2, uxVar3, elapsedRealtime, bk, ev, 0, wVar3 != null ? wVar3.mt() : null, i5, this.ta, this.f28159r);
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.3
            @Override // java.lang.Runnable
            public void run() {
                ux.this.xv();
            }
        });
        ys();
    }

    private com.bytedance.msdk.api.sr.c.w.w.w xv(com.bytedance.msdk.api.sr.c.w.xv.c cVar, com.bytedance.msdk.core.k.p pVar) {
        com.bytedance.msdk.api.sr.c.w.w.w wVar = null;
        try {
            Class<?> cls = Class.forName(cVar.c());
            if (c(cls, cVar.w(), pVar)) {
                try {
                    Object newInstance = cls.newInstance();
                    if (newInstance instanceof com.bytedance.msdk.api.sr.c.w.w.w) {
                        wVar = (com.bytedance.msdk.api.sr.c.w.w.w) newInstance;
                    }
                } catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                } catch (InstantiationException e5) {
                    e5.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e6) {
            e6.printStackTrace();
        }
        return wVar;
    }

    protected void sr(com.bytedance.msdk.api.c cVar) {
        this.wx = true;
        com.bytedance.msdk.core.k.gd gdVar = this.gb;
        if (gdVar != null) {
            gdVar.ux = true;
        }
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        com.bytedance.msdk.xv.r.c(this.f28155k, cVar, wVar != null ? wVar.mt() : null, wx());
    }

    public static Map<String, Object> f(String str) {
        j jVar = new j();
        jVar.put("prime_rit", str);
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str, String str2, String str3, String str4, int i4, String str5) {
        com.bytedance.msdk.api.w wVar = this.xv.get(str);
        if (wVar == null) {
            wVar = new com.bytedance.msdk.api.w();
        }
        wVar.w(str).xv(str2).sr(str3).c(i4).ux(str5).c(str4);
        this.xv.put(str, wVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ux(List<com.bytedance.msdk.c.ux> list) {
        if (yu.w(list)) {
            return;
        }
        if (this.f28158q.c()) {
            w((List<com.bytedance.msdk.c.ux>) null, new com.bytedance.msdk.api.c(10012, AdError.AD_LOAD_AD_TIME_OUT_ERROR_MSG));
        } else {
            w(list, (com.bytedance.msdk.api.c) null);
        }
        com.bytedance.msdk.c.ux uxVar = list.get(0);
        if (uxVar.isPAd()) {
            this.f28162u.addAll(list);
            r.c(this.f28162u, (Comparator<com.bytedance.msdk.c.ux>) null);
            if (com.bytedance.msdk.adapter.sr.xv.w()) {
                for (com.bytedance.msdk.c.ux uxVar2 : list) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5e7f\u544a\u52a0\u8f7d\u6210\u529f...........\u8fd4\u56de\u4e86P\u5c42\u5e7f\u544a_\u5f53\u524dP\u5c42\u5e7f\u544a\u7f13\u5b58\u6c60\u6570\u91cf\uff1a" + this.f28162u.size() + ",slotId\uff1a" + uxVar2.getAdNetworkSlotId() + ",\u5e7f\u544a\u7c7b\u578b\uff1a" + uxVar2.getAdNetWorkName() + ",loadSort=" + uxVar2.getLoadSort() + ",showSort=" + uxVar2.getShowSort() + ",CPM=" + uxVar2.getCpm());
                }
            }
        } else if (uxVar.isServerBiddingAd()) {
            this.fz.addAll(list);
            for (com.bytedance.msdk.c.ux uxVar3 : list) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5e7f\u544a\u52a0\u8f7d\u6210\u529f...........\u8fd4\u56de\u4e86ServerBidding\u5c42\u5e7f\u544a_\u5f53\u524dServerBidding\u5c42\u5e7f\u544a\u7f13\u5b58\u6c60\u6570\u91cf\uff1a" + this.fz.size() + ",slotId\uff1a" + uxVar3.getAdNetworkSlotId() + ",\u5e7f\u544a\u7c7b\u578b\uff1a" + uxVar3.getAdNetWorkName() + ",loadSort=" + uxVar3.getLoadSort() + ",showSort=" + uxVar3.getShowSort() + ",CPM=" + uxVar3.getCpm());
            }
        } else if (!uxVar.isMultiBiddingAd() && !uxVar.isClientBiddingAd()) {
            this.f28160s.addAll(list);
            r.c(this.f28160s, (Comparator<com.bytedance.msdk.c.ux>) null);
            if (com.bytedance.msdk.adapter.sr.xv.w()) {
                for (com.bytedance.msdk.c.ux uxVar4 : list) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5e7f\u544a\u52a0\u8f7d\u6210\u529f...........\u8fd4\u56de\u4e86\u666e\u901a\u5c42\u5e7f\u544a_\u5f53\u524d\u666e\u901a\u5e7f\u544a\u7f13\u5b58\u6c60\u6570\u91cf\uff1a" + this.f28160s.size() + ",slotId\uff1a" + uxVar4.getAdNetworkSlotId() + ",\u5e7f\u544a\u7c7b\u578b\uff1a" + uxVar4.getAdNetWorkName() + ",loadSort=" + uxVar4.getLoadSort() + ",showSort=" + uxVar4.getShowSort() + ",CPM=" + uxVar4.getCpm());
                }
            }
        } else {
            this.fz.addAll(list);
            String str = uxVar.isMultiBiddingAd() ? "\u591a\u9636\u5e95\u4ef7" : "clientBidding";
            for (com.bytedance.msdk.c.ux uxVar5 : list) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5e7f\u544a\u52a0\u8f7d\u6210\u529f...........\u8fd4\u56de\u4e86" + str + "\u5c42\u5e7f\u544a_\u5f53\u524d" + str + "\u5c42\u5e7f\u544a\u7f13\u5b58\u6c60\u6570\u91cf\uff1a" + this.fz.size() + ",slotId\uff1a" + uxVar5.getAdNetworkSlotId() + ",\u5e7f\u544a\u7c7b\u578b\uff1a" + uxVar5.getAdNetWorkName() + ",loadSort=" + uxVar5.getLoadSort() + ",showSort=" + uxVar5.getShowSort() + ",CPM=" + uxVar5.getCpm());
            }
            this.f28158q.xv();
            oh();
        }
    }

    public HashMap<String, com.bytedance.msdk.c.ux> f(List<com.bytedance.msdk.c.ux> list) {
        HashMap<String, com.bytedance.msdk.c.ux> hashMap = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (com.bytedance.msdk.c.ux uxVar : list) {
                if (uxVar != null) {
                    hashMap.put(uxVar.getAdNetworkSlotId(), uxVar);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, boolean z3, int i4, List<com.bytedance.msdk.c.ux> list, int i5, double d4) {
        if (z3) {
            if (i5 == 4) {
                com.bytedance.msdk.c.ux uxVar = (list == null || list.size() <= 0) ? null : list.get(0);
                if (uxVar != null && uxVar.getCpm() >= d4) {
                    this.ta = 6;
                } else {
                    this.ta = 7;
                }
            } else if (i5 == 3) {
                this.ta = 5;
            }
        } else if (i4 == 10003) {
            this.ta = 9;
        } else if (i4 == 10086) {
            this.ta = 8;
        }
        ux(list);
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u9884\u7f13\u5b58\u8865\u5145\u8bf7\u6c42\u7ed3\u675f\uff0c\u5bf9\u5916\u7ed9\u51fa\u56de\u8c03");
        ev();
    }

    public void sr(com.bytedance.msdk.c.ux uxVar) {
        com.bytedance.msdk.api.c.w wVar = this.f28155k;
        int mediationRitReqType = uxVar.getMediationRitReqType(wVar != null ? wVar.c() : null);
        uxVar.setMediationRitReqType(3);
        uxVar.setMediationRitReqTypeSrc(mediationRitReqType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xv(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.core.k.xv xvVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        String adNetworkSlotId = list.get(0).getAdNetworkSlotId();
        if (list.get(0).canAdReuse() && com.bytedance.msdk.core.ux.c.c.c().ux(this.gd, adNetworkSlotId, u()) == 1) {
            ArrayList arrayList = new ArrayList();
            for (com.bytedance.msdk.c.ux uxVar : list) {
                if (uxVar != null) {
                    arrayList.add(new com.bytedance.msdk.core.ux.w.ev(uxVar, xvVar, 0L, this.f28155k));
                }
            }
            if (arrayList.size() > 0) {
                com.bytedance.msdk.c.ux uxVar2 = ((com.bytedance.msdk.core.ux.w.ev) arrayList.get(0)).f28224c;
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:\u5e7f\u544a\u7f13\u5b58\u6210\u529f -------" + uxVar2.getAdNetWorkName() + ", adType: " + com.bytedance.msdk.c.c.c(uxVar2.getAdType(), uxVar2.getSubAdType()) + ", adnSlotId: " + uxVar2.getAdNetworkSlotId() + ", ad\u4e2a\u6570: " + arrayList.size());
                com.bytedance.msdk.core.ux.c.c.c().c(adNetworkSlotId, (List<com.bytedance.msdk.core.ux.w.ev>) arrayList, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.xv
    public void c(int i4, boolean z3) {
        if (this.sr.get() || fz()) {
            return;
        }
        if (i4 < this.ia.size()) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5f00\u59cb\u6267\u884cindex:" + i4 + "   \u5c42\u6570\uff1a" + this.ia.get(i4) + "  \u7684config\u914d\u7f6e............");
        }
        if (this.bj) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5df2\u7ecf\u8c03\u7528destroy\u65b9\u6cd5\uff0c\u4e0d\u518d\u7ee7\u7eed\u5e7f\u544a\u8bf7\u6c42");
            return;
        }
        if (i4 >= this.ia.size() || this.f28158q.ux(this.ia.get(i4).intValue())) {
            if (this.f28158q.r()) {
                if (this.f28162u.size() <= 0 && this.f28160s.size() <= 0 && this.fz.size() <= 0) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u6240\u6709\u5e7f\u544a\u5df2\u7ecf\u52a0\u8f7d\u5b8c\u6210\uff0c\u4e14\u65e0\u5e7f\u544a\u8fd4\u56de.......");
                    w(new com.bytedance.msdk.api.c(20005, com.bytedance.msdk.api.c.c(20005)), (com.bytedance.msdk.core.k.xv) null);
                } else {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u6240\u6709\u5e7f\u544a\u5df2\u7ecf\u52a0\u8f7d\u5b8c\u6210\uff0c\u4e14\u6709\u5e7f\u544a\u8fd4\u56de.......invokeAdLoadedOnMSDKThread");
                    if (n()) {
                        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5b58\u5728client bidding\u4e14\u6ee1\u8db3\u89e6\u53d1\u6210\u529f\u56de\u8c03\u7684\u6761\u4ef6\uff0c\u5219\u7ed9\u51fa\u6210\u529f\u56de\u8c03.....");
                        ev();
                    }
                }
            }
            if (z3) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u8be5\u5c42\u5e7f\u544a\u5df2\u7ecf\u52a0\u8f7d\u8fc7\uff0cisFromFailCallback\u4e3atrue.......");
                return;
            } else if (i4 >= this.ia.size()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......idx\u4e0b\u6807\u8d8a\u754c.......");
                return;
            } else if (this.ia.get(i4).intValue() == -100 && me()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u8be5\u5c42\u5e7f\u544a\u5df2\u7ecf\u52a0\u8f7d\u8fc7,p\u5c42\u548cclientBidding\u591a\u9636\u5e95\u4ef7\u5e7f\u544a\u5e76\u884c\u7684\u60c5\u51b5\u4e0b\uff0cP\u5c42\u5df2\u7ecf\u6267\u884c\u5b8c\u4e14\u5168\u90e8\u8bf7\u6c42\u5931\u8d25,\u4e0d\u7528\u8bf7\u6c42\u4e0b\u4e00\u5c42.......");
                return;
            }
        }
        int intValue = this.ia.get(i4).intValue();
        if (!this.f28158q.ux(intValue)) {
            if (intValue < -100) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5f00\u59cb\u6267\u884cP\u5c42\u5e7f\u544a............");
            } else if (intValue == -100) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5f00\u59cb\u6267\u884cClientBidding\u548c\u591a\u9636\u5e95\u4ef7\u5c42\u5e7f\u544a............");
            } else if (intValue == 0) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5f00\u59cb\u6267\u884cserverBidding\u5c42\u5e7f\u544a............hasServerBidding: " + y());
            } else {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5f00\u59cb\u6267\u884c\u666e\u901a\u5c42\u5e7f\u544a............");
            }
            if (intValue == 0 && y() && !this.f28158q.ev()) {
                this.f28158q.w(true);
                if (f(intValue)) {
                    w(new com.bytedance.msdk.api.c("\u6e32\u67d3\u7c7b\u578b\u9519\u8bef"), (com.bytedance.msdk.core.k.xv) null);
                    return;
                }
                xv(this.ev.get(Integer.valueOf(intValue)));
                w(i4, false);
                return;
            }
            if (intValue < -100) {
                this.wo = intValue;
            } else {
                this.f28107b = intValue;
            }
            this.f28158q.f(intValue);
            this.f28158q.c(intValue, true);
            if (!r(intValue)) {
                c(i4 + 1, false);
                return;
            } else if (intValue == -100 || intValue == 0) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......ClientBidding,ServerBidding ,\u666e\u901a\u5e7f\u544a\u540c\u65f6\u53d1\u8d77\u8bf7\u6c42............");
                c(i4 + 1, false);
                return;
            } else {
                return;
            }
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......index:" + i4 + "   \u5c42\u6570\uff1a" + this.ia.get(i4) + "\u7684\u5e7f\u544a\u5df2\u7ecf\u52a0\u8f7d\u8fc7\u4e86\uff0c\u5f00\u59cb\u6267\u884c\u4e0b\u4e00\u5c42............");
        c(i4 + 1, false);
    }

    private com.bytedance.msdk.adapter.c w(com.bytedance.msdk.core.k.p pVar) {
        if (pVar == null) {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "wfcBean is null getTTAbsAdLoaderAdapter fail");
            return null;
        } else if (TextUtils.equals("baidu", pVar.t()) && pVar.ba()) {
            return c(this.f28155k.c(), this.gd, pVar.ia());
        } else {
            return r.c(pVar);
        }
    }

    @Override // com.bytedance.msdk.core.r.xv
    protected final void xv(final com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.6
            @Override // java.lang.Runnable
            public void run() {
                ux.this.w(cVar);
            }
        });
    }

    private com.bytedance.msdk.c.ux xv(com.bytedance.msdk.core.k.p pVar) {
        if (pVar == null) {
            return null;
        }
        String ia = pVar.ia();
        String xv = pVar.ck() != null ? pVar.ck().xv() : null;
        if (TextUtils.isEmpty(ia)) {
            return null;
        }
        for (com.bytedance.msdk.c.ux uxVar : this.f28162u) {
            if (uxVar != null && ia.equals(uxVar.getAdNetworkSlotId())) {
                return uxVar;
            }
        }
        for (com.bytedance.msdk.c.ux uxVar2 : this.f28160s) {
            if (uxVar2 != null && ia.equals(uxVar2.getAdNetworkSlotId())) {
                return uxVar2;
            }
        }
        for (com.bytedance.msdk.c.ux uxVar3 : this.fz) {
            if (uxVar3 != null) {
                if (uxVar3.isServerBiddingAd() && !TextUtils.isEmpty(xv) && !TextUtils.isEmpty(uxVar3.getAid())) {
                    if (ia.equals(uxVar3.getAdNetworkSlotId()) && xv.equals(uxVar3.getAid())) {
                        return uxVar3;
                    }
                } else if (ia.equals(uxVar3.getAdNetworkSlotId())) {
                    return uxVar3;
                }
            }
        }
        return null;
    }

    private boolean w(int i4, int i5, com.bytedance.msdk.core.k.p pVar, int i6, long j4) {
        com.bytedance.msdk.adapter.c w3 = w(pVar);
        if (w3 != null) {
            Context context = this.vc.get();
            if (context != null) {
                w3.setAdapterListener(this);
                com.bytedance.msdk.core.k.gd gdVar = this.gb;
                if (gdVar != null) {
                    pVar.ev(gdVar.f28033c);
                }
                if (pVar.s() == 2 && pVar.ck() != null) {
                    com.bytedance.msdk.xv.r.c(pVar, this.f28155k, w3.getSdkVersion());
                }
                w3.loadAdInter(context, pVar, c(i4, i5, pVar, j4), this.f28155k, this.gb, i6);
                com.bytedance.msdk.core.ux.c.c.c().c(this.gd, pVar.ia(), pVar, i6);
                return true;
            }
            c(pVar, i4, i5);
        } else {
            c(pVar, i4, i5);
            StringBuilder sb = new StringBuilder();
            sb.append(pVar != null ? pVar.t() : "");
            sb.append("Adapter");
            String sb2 = sb.toString();
            for (int i7 = 0; i7 < 5; i7++) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "**********\u3010\u91cd\u8981\u3011" + sb2 + "\u521b\u5efa\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5adapter\u662f\u5426\u63a5\u5165 **********");
            }
        }
        return false;
    }

    private com.bytedance.msdk.c.ux r(List<com.bytedance.msdk.c.ux> list) {
        com.bytedance.msdk.c.ux uxVar = null;
        if (list != null && list.size() != 0) {
            for (com.bytedance.msdk.c.ux uxVar2 : list) {
                if (uxVar == null || uxVar2.getFillTime() < uxVar.getFillTime()) {
                    uxVar = uxVar2;
                }
            }
        }
        return uxVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(List<com.bytedance.msdk.c.ux> list, boolean z3) {
        com.bytedance.msdk.c.ux r3 = r(list);
        if (this.f28154j.get()) {
            return;
        }
        this.yu = SystemClock.elapsedRealtime();
        com.bytedance.msdk.xv.r.c(r3, this.f28155k, this.f28159r, this.yu - this.ng, wx(), !n_(), list != null ? list.size() : 0, this.wx, z3);
        this.f28154j.set(true);
    }

    private List<com.bytedance.msdk.core.k.p> ev(List<com.bytedance.msdk.core.k.p> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.bytedance.msdk.core.k.p> it = list.iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.core.k.p next = it.next();
            if (next.eq()) {
                it.remove();
                arrayList2.add(next);
            } else if (next.ba() || next.me() || next.y()) {
                it.remove();
                com.bytedance.msdk.core.k.p pVar = new com.bytedance.msdk.core.k.p();
                pVar.ux(next.ia());
                pVar.gd(next.s());
                pVar.xv(next.t());
                pVar.xv(next.r());
                pVar.c(next.f());
                pVar.p(next.j());
                pVar.k(next.ls());
                pVar.ev(next.a());
                pVar.f("" + next.q());
                pVar.w(next.bk());
                pVar.r(next.gb());
                pVar.ev(next.n());
                pVar.c(next.ck());
                com.bytedance.msdk.c.ux xv = xv(pVar);
                if (xv != null) {
                    pVar.f("" + xv.getBiddingCpmWithOutExchangeRate());
                }
                arrayList.add(pVar);
            }
        }
        list.addAll(arrayList);
        Collections.sort(list, this.te);
        Collections.sort(arrayList2, this.eu);
        list.addAll(0, arrayList2);
        return list;
    }

    public void w() {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Handler handler = ux.this.f28157p;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    List<com.bytedance.msdk.c.ux> list = ux.this.f28162u;
                    if (list != null) {
                        list.clear();
                    }
                    List<com.bytedance.msdk.c.ux> list2 = ux.this.f28160s;
                    if (list2 != null) {
                        list2.clear();
                    }
                    List<com.bytedance.msdk.c.ux> list3 = ux.this.fz;
                    if (list3 != null) {
                        list3.clear();
                    }
                    com.bytedance.msdk.c.ux uxVar = ux.this.bm;
                    if (uxVar != null) {
                        uxVar.onDestroy();
                    }
                    if (ux.this.f28111w != null) {
                        for (Map.Entry entry : ux.this.f28111w.entrySet()) {
                            if (entry != null) {
                                com.bytedance.msdk.adapter.c cVar = (com.bytedance.msdk.adapter.c) entry.getValue();
                                cVar.setAdapterListener(null);
                                cVar.destroy();
                            }
                        }
                        ux.this.f28111w.clear();
                    }
                    ux.this.f28158q.ux();
                } catch (Throwable th) {
                    if (com.bytedance.msdk.adapter.sr.xv.w()) {
                        th.printStackTrace();
                    }
                }
                ux uxVar2 = ux.this;
                uxVar2.up = null;
                uxVar2.mt = null;
                uxVar2.gw = null;
                uxVar2.ev = null;
                uxVar2.xu = null;
                uxVar2.bj = true;
                if (ux.this.oo) {
                    ux.this.w(new com.bytedance.msdk.api.w.c(41044, com.bytedance.msdk.api.c.c(41044)), (com.bytedance.msdk.core.k.xv) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.xv
    public void w(final com.bytedance.msdk.api.c cVar, com.bytedance.msdk.core.k.xv xvVar) {
        if (cVar == null) {
            cVar = new com.bytedance.msdk.api.c(20005, com.bytedance.msdk.api.c.c(20005));
        }
        j();
        if (!com.bytedance.msdk.f.w.c.c(this.f28159r) || cVar.f27444c != 10003) {
            ge();
        }
        if (this.ux.get() || this.sr.get()) {
            return;
        }
        this.ux.set(true);
        sr(cVar);
        if (n_()) {
            c(false);
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5e7f\u544a\u52a0\u8f7d\u5931\u8d25\uff01\u7ed9\u5916\u90e8\u56de\u8c03\uff1ainvokeAdLoadFailCallbackOnMainUI...... error Code = " + cVar.f27444c + " error Message = " + cVar.f27445w);
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.4
            @Override // java.lang.Runnable
            public void run() {
                ux.this.c(cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02b8  */
    @Override // com.bytedance.msdk.core.r.xv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(com.bytedance.msdk.core.k.p r23, int r24) {
        /*
            Method dump skipped, instructions count: 700
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.r.ux.c(com.bytedance.msdk.core.k.p, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.xv
    public final void w(final List<com.bytedance.msdk.c.ux> list, final com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar == null || !wVar.a()) {
            return;
        }
        if (this.bj) {
            list = null;
            cVar = new com.bytedance.msdk.api.c(41044, com.bytedance.msdk.api.c.c(41044));
        }
        if (n_()) {
            return;
        }
        if (!yu.c(list)) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5355\u4e2a\u5e7f\u544a\u52a0\u8f7d\u5b8c\u6210\uff01\u7ed9\u5916\u90e8\u56de\u8c03\uff1ainvokeSingleAdLoadCallbackUI......");
            for (com.bytedance.msdk.c.ux uxVar : list) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + uxVar.getAdNetWorkName() + "] AdUnitId[" + uxVar.getAdNetworkSlotId() + "]  \u8bf7\u6c42\u6210\u529f (loadSort=" + uxVar.getLoadSort() + ",showSort=" + uxVar.getShowSort() + ")");
            }
        }
        if (cVar != null) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5355\u4e2a\u5e7f\u544a\u52a0\u8f7d\u5931\u8d25\uff01\u7ed9\u5916\u90e8\u56de\u8c03\uff1ainvokeSingleAdLoadCallbackUI...... errorCode:" + cVar.f27444c + "  errorMsg:" + cVar.f27445w);
        }
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.7
            @Override // java.lang.Runnable
            public void run() {
                ux.this.c(list, cVar);
            }
        });
    }

    @Override // com.bytedance.msdk.core.r.xv
    public void w(com.bytedance.msdk.core.k.p pVar, int i4) {
        if (pVar == null) {
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "----------\u603b\u8d85\u65f6\u540e\u5c1d\u8bd5\u4ece\u590d\u7528\u6c60\u4e2d\u67e5\u627e\u5e7f\u544a\uff1aid:" + pVar.ia() + "   loadSort:" + pVar.j() + "  showSort:" + pVar.ls() + "   adnName:" + pVar.t());
        String ia = pVar.ia();
        if (pVar.fz() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, ia, u()) && com.bytedance.msdk.core.ux.c.c.c().c(ia, this.f28155k, true) == 3) {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "----------\u53ef\u590d\u7528\uff1aid:" + pVar.ia() + "   loadSort:" + pVar.j() + "  showSort:" + pVar.ls() + "   adnName:" + pVar.t());
            com.bytedance.msdk.core.ux.c.c.c().c(this.gd, ia, pVar, i4);
            List<com.bytedance.msdk.core.ux.w.ev> c4 = com.bytedance.msdk.core.ux.c.c.c().c(ia, this.f28155k, u());
            if (c4 == null || c4.size() <= 0) {
                return;
            }
            com.bytedance.msdk.c.ux uxVar = c4.get(0).f28224c;
            com.bytedance.msdk.api.c.w wVar = this.f28155k;
            int mediationRitReqType = uxVar.getMediationRitReqType(wVar != null ? wVar.c() : null);
            com.bytedance.msdk.xv.r.c(pVar, this.f28155k, com.bytedance.msdk.core.ux.c.c.c().c(ia), !n_(), 4, i4, 3, mediationRitReqType, (com.bytedance.msdk.api.c) null, -1L, this.wx, true);
            ArrayList arrayList = new ArrayList();
            for (com.bytedance.msdk.core.ux.w.ev evVar : c4) {
                evVar.f28224c.setMediationRitReqType(3);
                evVar.f28224c.setMediationRitReqTypeSrc(mediationRitReqType);
                evVar.f28224c.setTimeoutFill(this.wx);
                evVar.f28224c.setIsCallback(true);
                c(evVar.f28224c, ia);
                arrayList.add(evVar.f28224c);
            }
            com.bytedance.msdk.xv.r.c(c4.get(0).f28224c, 0, "adn cache\u547d\u4e2d", 0L, this.f28155k, i4, arrayList.size(), 4, (String) null, 0L, -1L);
            w((List<com.bytedance.msdk.c.ux>) arrayList, true);
            com.bytedance.msdk.c.ux uxVar2 = arrayList.get(0);
            if (uxVar2.isPAd()) {
                this.f28162u.addAll(arrayList);
                r.c(this.f28162u, (Comparator<com.bytedance.msdk.c.ux>) null);
                for (com.bytedance.msdk.c.ux uxVar3 : arrayList) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u590d\u7528\u6c60\u56de\u6eaf\u6210\u529f...........\u56de\u6eaf\u5230\u4e86P\u5c42\u5e7f\u544a_\u5f53\u524dP\u5c42\u5e7f\u544a\u7f13\u5b58\u6c60\u6570\u91cf\uff1a" + this.f28162u.size() + ",slotId\uff1a" + uxVar3.getAdNetworkSlotId() + ",\u5e7f\u544a\u7c7b\u578b\uff1a" + uxVar3.getAdNetWorkName() + ",loadSort=" + uxVar3.getLoadSort() + ",showSort=" + uxVar3.getShowSort() + ",CPM=" + uxVar3.getCpm());
                }
            } else if (uxVar2.isNormalAd()) {
                this.f28160s.addAll(arrayList);
                r.c(this.f28160s, (Comparator<com.bytedance.msdk.c.ux>) null);
                for (com.bytedance.msdk.c.ux uxVar4 : arrayList) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u590d\u7528\u6c60\u56de\u6eaf\u6210\u529f...........\u56de\u6eaf\u5230\u4e86\u666e\u901a\u5c42\u5e7f\u544a_\u5f53\u524d\u666e\u901a\u5e7f\u544a\u7f13\u5b58\u6c60\u6570\u91cf\uff1a" + this.f28160s.size() + ",slotId\uff1a" + uxVar4.getAdNetworkSlotId() + ",\u5e7f\u544a\u7c7b\u578b\uff1a" + uxVar4.getAdNetWorkName() + ",loadSort=" + uxVar4.getLoadSort() + ",showSort=" + uxVar4.getShowSort() + ",CPM=" + uxVar4.getCpm());
                }
            }
        }
    }

    private boolean c(com.bytedance.msdk.api.sr.c.w.xv.c cVar) {
        if (cVar != null) {
            Bridge f4 = com.bytedance.msdk.core.bk.c.c().f();
            if (f4 != null) {
                if (!TextUtils.isEmpty(cVar.c())) {
                    b a4 = b.a();
                    a4.i(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, cVar.c());
                    com.bytedance.msdk.adapter.sr.xv.w("TMe", "custom className is " + cVar.c());
                    return ((Boolean) f4.call(8229, a4.l(), Boolean.class)).booleanValue();
                }
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "custom className is empty");
                return false;
            }
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "load ad check custom name class loader is null ");
            return false;
        }
        return false;
    }

    private com.bytedance.msdk.api.sr.c.w.w.w c(com.bytedance.msdk.api.sr.c.w.xv.c cVar, com.bytedance.msdk.core.k.p pVar) {
        if (c(cVar)) {
            return w(cVar, pVar);
        }
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "getCheckMediationGMCustomBaseAdapter fail");
        return null;
    }

    public void w(ViewGroup viewGroup) {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            uxVar.showSplashClickEyeView(viewGroup);
        }
    }

    private boolean c(final int i4, final int i5, final com.bytedance.msdk.core.k.p pVar, final int i6, final long j4) {
        com.bytedance.msdk.api.sr.c.w.w.w xv;
        String str;
        com.bytedance.msdk.core.k.c c4 = com.bytedance.msdk.ux.c.c.p().c(pVar.t());
        if (c4 == null) {
            c(pVar, i4, i5);
            str = "\u81ea\u5b9a\u4e49Adapter \u914d\u7f6e\u4e3a\u7a7a";
        } else {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK_SDK_Init", "\u81ea\u5b9a\u4e49Adapter \u83b7\u53d6\u914d\u7f6ewfcBean = " + pVar);
            com.bytedance.msdk.api.sr.c.w.xv.c c5 = c4.xv().c(pVar.a(), pVar.ux());
            if (c5 == null) {
                str = "\u81ea\u5b9a\u4e49Adapter \u914d\u7f6e\u7684className\u4e3a\u7a7a\uff0c\u65e0\u6cd5\u53cd\u5c04\u521b\u5efa\u81ea\u5b9a\u4e49\u5e7f\u544aAdapter\u5bf9\u8c61 ";
            } else {
                if (com.bytedance.msdk.core.bk.c.c().xv()) {
                    xv = c(c5, pVar);
                } else {
                    xv = xv(c5, pVar);
                }
                final com.bytedance.msdk.api.sr.c.w.w.w wVar = xv;
                if (com.bytedance.msdk.sr.w.c.c(pVar.t()) == null) {
                    str = "\u81ea\u5b9a\u4e49Adapter \u521b\u5efa\u5e7f\u544a\u5bf9\u8c61\u5931\u8d25  ---------  \u6ca1\u6709\u521d\u59cb\u5316\uff0c\u4e0d\u80fd\u52a0\u8f7d\u5e7f\u544a\uff0c\u8bf7\u68c0\u67e5\u521d\u59cb\u5316\u914d\u7f6e";
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", "\u81ea\u5b9a\u4e49Adapter \u521b\u5efa\u5e7f\u544a\u5bf9\u8c61\u5931\u8d25  ---------  \u6ca1\u6709\u521d\u59cb\u5316\uff0c\u4e0d\u80fd\u52a0\u8f7d\u5e7f\u544a\uff0c\u8bf7\u68c0\u67e5\u521d\u59cb\u5316\u914d\u7f6e");
                    com.bytedance.msdk.xv.r.c("", this.bm, this.f28155k, pVar, new com.bytedance.msdk.api.c(49014, "\u81ea\u5b9a\u4e49Adapter \u521b\u5efa\u5e7f\u544a\u5bf9\u8c61\u5931\u8d25  ---------  \u6ca1\u6709\u521d\u59cb\u5316\uff0c\u4e0d\u80fd\u52a0\u8f7d\u5e7f\u544a\uff0c\u8bf7\u68c0\u67e5\u521d\u59cb\u5316\u914d\u7f6e"));
                    c(pVar, i4, i5);
                } else {
                    final Context context = this.vc.get();
                    if (context == null) {
                        str = "\u81ea\u5b9a\u4e49Adapter \u521b\u5efa\u5e7f\u544a\u5bf9\u8c61\u5931\u8d25  --------- context\u4e3anull";
                        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", "\u81ea\u5b9a\u4e49Adapter \u521b\u5efa\u5e7f\u544a\u5bf9\u8c61\u5931\u8d25  --------- context\u4e3anull");
                    } else if (wVar != null) {
                        com.bytedance.msdk.adapter.sr.f.sr(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.16
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    Context context2 = context;
                                    com.bytedance.msdk.core.k.p pVar2 = pVar;
                                    com.bytedance.msdk.sr.w.c(context2, pVar2 != null ? pVar2.t() : "");
                                    com.bytedance.msdk.api.sr.c.w.w.w wVar2 = wVar;
                                    Context context3 = context;
                                    ux uxVar = ux.this;
                                    com.bytedance.msdk.api.c.w wVar3 = uxVar.f28155k;
                                    com.bytedance.msdk.core.k.p pVar3 = pVar;
                                    Map<String, Object> c6 = uxVar.c(i4, i5, pVar3, j4);
                                    ux uxVar2 = ux.this;
                                    wVar2.c(context3, wVar3, pVar3, c6, uxVar2.gb, i6, uxVar2);
                                } catch (Exception e4) {
                                    ux uxVar3 = ux.this;
                                    com.bytedance.msdk.c.ux uxVar4 = uxVar3.bm;
                                    com.bytedance.msdk.api.c.w wVar4 = uxVar3.f28155k;
                                    com.bytedance.msdk.core.k.p pVar4 = pVar;
                                    com.bytedance.msdk.xv.r.c("", uxVar4, wVar4, pVar4, new com.bytedance.msdk.api.c(49014, "\u81ea\u5b9a\u4e49Adapter \u52a0\u8f7d\u5e7f\u544a\u5185\u90e8\u9519\u8bef " + e4.getClass().getName()));
                                    e4.printStackTrace();
                                }
                            }
                        });
                        return true;
                    } else {
                        str = "";
                    }
                }
            }
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", str);
        com.bytedance.msdk.xv.r.c("", this.bm, this.f28155k, pVar, new com.bytedance.msdk.api.c(49014, str));
        c(pVar, i4, i5);
        return false;
    }

    private boolean c(Class<?> cls, Class<?> cls2, com.bytedance.msdk.core.k.p pVar) {
        String c4;
        if (!com.bytedance.msdk.sr.w.w(cls, cls2)) {
            c4 = "\u81ea\u5b9a\u4e49ADN\u521d\u59cb\u5316\u5bf9\u8c61\u5931\u8d25  ---------  \u521d\u59cb\u5316\u7c7b " + cls.getSimpleName() + " \u9700\u8981\u7ee7\u627f\u81ea\u81ea\u5b9a\u4e49ADN\u7684\u5e7f\u544a\u5bf9\u8c61\u57fa\u7c7b " + cls2.getSimpleName();
        } else {
            c4 = com.bytedance.msdk.sr.w.c(cls, cls2);
        }
        if (TextUtils.isEmpty(c4)) {
            return true;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", c4);
        com.bytedance.msdk.xv.r.c("", this.bm, this.f28155k, pVar, new com.bytedance.msdk.api.c(49014, c4));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> c(int i4, int i5, com.bytedance.msdk.core.k.p pVar, long j4) {
        return r.c(pVar, this.f28155k, this.f28153i, this.xu, i4, i5, !n_(), j4);
    }

    protected void c(com.bytedance.msdk.core.k.p pVar, int i4, int i5) {
        if (pVar != null) {
            c(pVar);
            pVar.ev(wx());
            com.bytedance.msdk.xv.r.c(pVar, this.f28155k, i4, i5);
        }
    }

    private boolean c(String str, com.bytedance.msdk.core.k.p pVar, int i4) {
        com.bytedance.msdk.core.ux.c.c.c().c(this.gd, str, pVar, i4);
        List<com.bytedance.msdk.core.ux.w.ev> c4 = com.bytedance.msdk.core.ux.c.c.c().c(str, this.f28155k, u());
        if (c4 == null || c4.size() <= 0) {
            return false;
        }
        com.bytedance.msdk.c.ux uxVar = c4.get(0).f28224c;
        com.bytedance.msdk.api.c.w wVar = this.f28155k;
        int mediationRitReqType = uxVar.getMediationRitReqType(wVar != null ? wVar.c() : null);
        com.bytedance.msdk.xv.r.c(pVar, this.f28155k, com.bytedance.msdk.core.ux.c.c.c().c(str), !n_(), 1, i4, 3, mediationRitReqType, (com.bytedance.msdk.api.c) null, -1L, this.wx, false);
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.core.ux.w.ev evVar : c4) {
            evVar.f28224c.setMediationRitReqType(3);
            evVar.f28224c.setMediationRitReqTypeSrc(mediationRitReqType);
            evVar.f28224c.setTimeoutFill(this.wx);
            evVar.f28224c.setIsCallback(false);
            c(evVar.f28224c, str);
            arrayList.add(evVar.f28224c);
        }
        com.bytedance.msdk.xv.r.c(c4.get(0).f28224c, 0, "adn cache\u547d\u4e2d", 0L, this.f28155k, i4, arrayList.size(), 2, (String) null, 0L, -1L);
        c(arrayList, c4.get(0).f28225w);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Message message) {
        List<com.bytedance.msdk.c.ux> list;
        List<com.bytedance.msdk.c.ux> list2;
        int i4 = message.what;
        if (i4 == 1) {
            if (y() && !wv()) {
                com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....server Bidding \u8fd8\u6ca1\u6709\u63a5\u53e3\u8fd4\u56de\uff0c\u5c1d\u8bd5\u6267\u884c\u4e0b\u5c42(\u4e0d\u4e00\u5b9a\u6267\u884c)....mTTCommonAdPoolList.size()=" + this.f28160s.size());
                c(ev(this.f28107b), false);
            } else if (!mt()) {
                com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....\u666e\u901a\u5e7f\u544a\u6c60\u6ca1\u5e7f\u544a\u6216\u8005\u6570\u91cf\u4e0d\u8fbe\u6807,\u5c1d\u8bd5\u6267\u884c\u4e0b\u5c42(\u4e0d\u4e00\u5b9a\u6267\u884c)....mTTCommonAdPoolList.size()=" + this.f28160s.size());
                c(ev(this.f28107b), false);
            } else {
                com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....\u5e7f\u544a\u6c60\u5df2\u6709\u5e7f\u544a\u4e0d\u6267\u884c\u4e0b\u5c42....mTTCommonAdPoolList.size()=" + this.f28160s.size());
                if (n()) {
                    com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....\u5e7f\u544a\u6c60\u5df2\u6709\u5e7f\u544a\u4e0d\u6267\u884c\u4e0b\u5c42\u4e14\u6ee1\u8db3client bidding\u7684\u8fd4\u56de\u6761\u4ef6....mTTCommonAdPoolList.size()=" + this.f28160s.size());
                    ev();
                }
            }
        } else if (i4 == 2) {
            ok();
        } else if (i4 == 3) {
            h();
        } else if (i4 == 4) {
            if (!up()) {
                com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....P\u5c42\u5e7f\u544a\u6c60\u6ca1\u5e7f\u544a\u6216\u8005\u6570\u91cf\u4e0d\u8fbe\u6807\u5c1d\u8bd5\u6267\u884c\u4e0b\u5c42(\u4e0d\u4e00\u5b9a\u6267\u884c)....mTTPAdPoolList.size()=" + this.f28162u.size());
                c(ev(this.wo), false);
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....\u5e7f\u544a\u6c60\u5df2\u6709P\u5c42\u7c7b\u578b\u5e7f\u544a\u4e0d\u6267\u884c\u4e0b\u5c42....mTTPAdPoolList.size()=" + this.f28162u.size());
            ev();
        } else if (i4 != 5) {
        } else {
            this.f28156n.set(true);
            if (y() && wv()) {
                if (mt()) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u8fd4\u56de\u4e14\u5230\u8fbeClientBidding\u7684\u7b49\u5f85\u65f6\u95f4\uff0c\u5e7f\u544a\u6c60\u4e2d\u7684\u5e7f\u544a\u6570\u91cf\u6ee1\u8db3...\u76f4\u63a5\u8fd4\u56de......");
                    ev();
                }
                if (this.f28158q.c() || !this.f28158q.r()) {
                    return;
                }
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6240\u6709\u5e7f\u544a\u90fd\u5df2\u7ecf\u52a0\u8f7d\u5b8c\u6210....... ");
                List<com.bytedance.msdk.c.ux> list3 = this.f28162u;
                if ((list3 != null && list3.size() > 0) || (((list = this.f28160s) != null && list.size() > 0) || ((list2 = this.fz) != null && list2.size() > 0))) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u8fd4\u56de\u4e14\u5230\u8fbeClientBidding\u7684\u7b49\u5f85\u65f6\u95f4\uff0c\u6240\u6709\u5e7f\u544a\u90fd\u6709\u8fd4\u56de\u7ed3\u679c...\u76f4\u63a5\u8fd4\u56de......");
                    ev();
                    return;
                }
                w(new com.bytedance.msdk.api.c(20005, com.bytedance.msdk.api.c.c(20005)), (com.bytedance.msdk.core.k.xv) null);
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.c.InterfaceC0386c
    public void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.core.k.xv xvVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(uxVar);
        c(arrayList, xvVar);
    }

    public void c(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.core.k.xv xvVar) {
        if (this.f28157p == null || xvVar == null) {
            return;
        }
        c(list, this.f28159r);
        c(xvVar.bk(), xvVar.k(), xvVar.a(), com.bytedance.msdk.c.c.c(xvVar.w(), xvVar.c()), 0, AdLoadInfo.AD_LOADED);
        r.c(this.gd, xvVar, !yu.w(list) ? list.get(0) : null);
        xv(list, xvVar);
        if (xvVar.ev() == 0 && !yu.w(list)) {
            String adNetworkSlotId = list.get(0).getAdNetworkSlotId();
            if (ux(adNetworkSlotId)) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u8fd4\u56de\u7684\u666e\u901a\u5e7f\u544a\u88abserver Bidding\u8fc7\u6ee4\u4e86......slotId:" + adNetworkSlotId);
                return;
            }
        }
        this.f28158q.c(xvVar.bk());
        if (n_()) {
            w(list, xvVar);
        }
        ux(list);
        w(list, false);
        if (this.sr.get() || fz()) {
            return;
        }
        if (!yu.w(list) && list.get(0).isPAd() && up()) {
            com.bytedance.msdk.c.ux uxVar = list.get(0);
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "P\u5c42\u5e7f\u544a\u5df2\u7ecf\u6210\u529f\u8fd4\u56deloadSort:" + uxVar.getLoadSort() + " ,showSort:" + uxVar.getLoadSort() + "  mTTPAdPoolList.size:" + this.f28162u.size());
            ev();
        } else if (((!y() && !eq()) || (y() && wv())) && !yu.w(list) && c(list.get(0)) && mt()) {
            com.bytedance.msdk.c.ux uxVar2 = list.get(0);
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u666e\u901a\u5e7f\u544a\u5f53\u524d\u5c42\u4f18\u5148\u7ea7\u6700\u9ad8\u7684\u5e7f\u544a\u5df2\u7ecf\u6210\u529f\u8fd4\u56deloadSort:" + uxVar2.getLoadSort() + " ,showSort:" + uxVar2.getShowSort() + "  mTTCommonAdPoolList.size:" + this.f28160s.size());
            if (n()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6ee1\u8db3\u5e7f\u544a\u7684\u8fd4\u56de\u6761\u4ef6...\u76f4\u63a5\u8fd4\u56de...");
                ev();
            }
        } else {
            if (xvVar.xv() && mt()) {
                if (this.f28162u.size() >= vc()) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u6709\u8fd4\u56de\u65f6P\u5c42\u6c60\u4e2d\u6709\u5e7f\u544a\u76f4\u63a5\u8fd4\u56de......");
                    ev();
                    return;
                }
                for (com.bytedance.msdk.c.ux uxVar3 : this.f28160s) {
                    if (c(uxVar3) && n()) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u6709\u8fd4\u56de\u4e14\u6ee1\u8db3ClientBidding\u7b49\u5f85\u65f6\u95f4\u65f6\u666e\u901a\u6c60\u4e2d\u6709\u5e7f\u544a\u76f4\u63a5\u8fd4\u56de......");
                        ev();
                        return;
                    }
                }
            }
            if (this.f28158q.r() && n()) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6240\u6709\u5c42\u7ea7\u548c\u6240\u6709waterfall\u90fd\u5df2\u5b8c\u6210\u4e14\u6ee1\u8db3ClientBidding\u7b49\u5f85\u65f6\u95f4\u76f4\u63a5\u56de\u8c03...");
                ev();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.core.k.w wVar) {
        com.bytedance.msdk.core.p.sr.c(list, wVar);
        com.bytedance.msdk.core.w.c.c(list, wVar);
    }

    public void c(com.bytedance.msdk.api.c cVar, com.bytedance.msdk.core.k.xv xvVar) {
        List<com.bytedance.msdk.c.ux> list;
        List<com.bytedance.msdk.c.ux> list2;
        com.bytedance.msdk.api.c.w wVar;
        if (this.f28157p == null || xvVar == null) {
            return;
        }
        w((List<com.bytedance.msdk.c.ux>) null, cVar);
        if (cVar != null) {
            c(xvVar.bk(), xvVar.k(), xvVar.a(), com.bytedance.msdk.c.c.c(xvVar.w(), xvVar.c()), cVar.xv, cVar.sr);
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5e7f\u544a\u52a0\u8f7d\u5931\u8d25...........adnName:" + xvVar.k() + " ,slotId:" + xvVar.bk() + ",slotType:" + xvVar.ev() + ",loadSort:" + xvVar.gd() + ",showSort:" + xvVar.p() + " \uff0cadError:" + cVar.toString());
        }
        r.c(cVar, xvVar);
        if (xvVar.ev() == 0 && ux(xvVar.bk())) {
            return;
        }
        this.f28158q.c(xvVar.bk());
        this.f28158q.xv(xvVar.gd());
        if (xvVar.ux() || xvVar.sr()) {
            this.f28158q.xv();
            oh();
        }
        if (xvVar.xv() && mt()) {
            if (this.f28162u.size() >= vc()) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u6709\u8fd4\u56de\u7ed3\u679c\u65f6P\u5c42\u6c60\u4e2d\u6709\u5e7f\u544a\u76f4\u63a5\u8fd4\u56de......");
                ev();
                return;
            }
            for (com.bytedance.msdk.c.ux uxVar : this.f28160s) {
                if (c(uxVar) && n()) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u6709\u8fd4\u56de\u7ed3\u679c\u4e14\u6ee1\u8db3ClientBidding\u7b49\u5f85\u65f6\u95f4\u65f6\u666e\u901a\u6c60\u4e2d\u6709\u5e7f\u544a\u76f4\u63a5\u8fd4\u56de......");
                    ev();
                    return;
                }
            }
        }
        if (this.sr.get() || fz()) {
            return;
        }
        List<com.bytedance.msdk.c.ux> list3 = this.f28162u;
        if ((list3 != null && list3.size() > 0) || (((list = this.f28160s) != null && list.size() > 0) || ((list2 = this.fz) != null && list2.size() > 0))) {
            if (!this.f28158q.c() && this.f28158q.r() && n()) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5e7f\u544a\u6c60\u4e2d\u6709\u5e7f\u544a\u4e14\u6ee1\u8db3client bididing\u7684\u8fd4\u56de\u6761\u4ef6...\u7ed9\u51fa\u6210\u529f\u56de\u8c03...");
                ev();
                return;
            }
        } else if (!this.f28158q.c() && this.f28158q.r() && (wVar = this.f28155k) != null && !TextUtils.isEmpty(com.bytedance.msdk.core.ia.c.c(wVar.wv()))) {
            w(cVar, xvVar);
            return;
        }
        if (!c(xvVar) && this.f28158q.sr(xvVar.gd()) == 0) {
            int ev = ev(xvVar.gd());
            com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "onAdFailed--\u300b \u52a0\u8f7d\u4e0b\u4e00\u5c42-nextIdx=" + ev);
            if (ev < this.ia.size() && !this.f28158q.ux(this.ia.get(ev).intValue())) {
                if (xvVar.f()) {
                    Handler handler = this.f28157p;
                    if (handler != null) {
                        handler.removeMessages(4);
                    }
                } else {
                    Handler handler2 = this.f28157p;
                    if (handler2 != null) {
                        handler2.removeMessages(1);
                    }
                }
            }
            c(ev, true);
        }
        if (this.f28158q.c() || this.f28158q.r()) {
            if (!(this.f28158q.c() && com.bytedance.msdk.f.w.c.c(this.f28159r)) && n()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6240\u6709\u5e7f\u544a\u90fd\u52a0\u8f7d\u5931\u8d25....");
                w(new com.bytedance.msdk.api.c(20005, com.bytedance.msdk.api.c.c(20005)), xvVar);
            }
        }
    }

    protected void c(com.bytedance.msdk.core.k.p pVar) {
        if (pVar == null) {
            return;
        }
        this.f28158q.c(pVar.ia());
        this.f28158q.xv(pVar.j());
        if (pVar.me() || pVar.y()) {
            this.f28158q.xv();
            oh();
        }
    }

    public boolean c(com.bytedance.msdk.core.k.xv xvVar) {
        if (xvVar == null) {
            return false;
        }
        return xvVar.sr() || xvVar.ux() || xvVar.xv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        Handler handler;
        com.bytedance.msdk.core.k.p c4 = r.c(str2, str, -4, -4);
        if (this.pr != 0 && (handler = this.f28157p) != null) {
            handler.removeMessages(3);
            this.f28157p.sendEmptyMessageDelayed(3, this.pr);
        }
        c(c4, -1);
        com.bytedance.msdk.core.fp.w.c(com.bytedance.msdk.core.c.w()).w(1);
    }

    protected void c(String str, AtomicBoolean atomicBoolean) {
        if (n_()) {
            return;
        }
        com.bytedance.msdk.core.k.xv xvVar = new com.bytedance.msdk.core.k.xv();
        xvVar.sr(-1);
        xvVar.ux(-1);
        if (!com.bytedance.msdk.core.c.w().xv(str, s())) {
            w(new com.bytedance.msdk.api.c(44406, "\u5e7f\u544a\u4f4dID\u4e0d\u5408\u6cd5"), xvVar);
        } else {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "settings config.......AdUnitId = " + str + "  \u6682\u65e0config\u914d\u7f6e\u4fe1\u606f");
            w(new com.bytedance.msdk.api.c(840040, com.bytedance.msdk.api.c.c(840040)), xvVar);
        }
        com.bytedance.msdk.core.fp.w.c(com.bytedance.msdk.core.c.w()).w(1);
    }

    private void c(final boolean z3) {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.2
            @Override // java.lang.Runnable
            public void run() {
                ux uxVar = ux.this;
                w.xv xvVar = uxVar.fm;
                if (xvVar != null) {
                    xvVar.c(uxVar.gd, z3, 0, null);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.core.r.xv
    protected final void c(final String str, JSONObject jSONObject) {
        com.bytedance.msdk.xv.r.c(this.f28155k, this.f28159r.mt(), jSONObject);
        com.bytedance.msdk.adapter.sr.f.sr(new Runnable() { // from class: com.bytedance.msdk.core.r.ux.5
            @Override // java.lang.Runnable
            public void run() {
                ux.this.c(str);
            }
        });
    }

    public void c(ViewGroup viewGroup, Activity activity) {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            uxVar.showSplashCardView(viewGroup, activity);
        }
    }
}
