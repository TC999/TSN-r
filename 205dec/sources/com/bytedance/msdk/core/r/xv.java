package com.bytedance.msdk.core.r;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.msdk.core.gd.a;
import com.bytedance.msdk.core.gd.k;
import com.bytedance.msdk.core.k.gd;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.core.sr.ux;
import com.bytedance.msdk.f.fp;
import com.bytedance.msdk.f.i;
import com.bytedance.msdk.f.yu;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class xv {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f28151a;
    protected boolean bk;
    protected long ck;
    protected Map<Integer, List<p>> ev;
    protected String gd;
    protected List<Integer> ia;

    /* renamed from: k  reason: collision with root package name */
    protected com.bytedance.msdk.api.c.w f28155k;

    /* renamed from: p  reason: collision with root package name */
    protected Handler f28157p;

    /* renamed from: r  reason: collision with root package name */
    protected com.bytedance.msdk.core.k.w f28159r;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f28161t;
    protected boolean wv;
    protected final AtomicBoolean sr = new AtomicBoolean(false);
    protected final AtomicBoolean ux = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    protected final AtomicBoolean f28152f = new AtomicBoolean(false);
    protected int ys = -1;
    protected final List<p> fp = new CopyOnWriteArrayList();

    /* renamed from: s  reason: collision with root package name */
    protected List<com.bytedance.msdk.c.ux> f28160s = new CopyOnWriteArrayList();
    protected List<com.bytedance.msdk.c.ux> fz = new CopyOnWriteArrayList();

    /* renamed from: u  reason: collision with root package name */
    protected List<com.bytedance.msdk.c.ux> f28162u = new CopyOnWriteArrayList();

    /* renamed from: i  reason: collision with root package name */
    protected Map<String, Object> f28153i = new ConcurrentHashMap();

    /* renamed from: q  reason: collision with root package name */
    protected ev f28158q = new ev();

    /* renamed from: j  reason: collision with root package name */
    protected AtomicBoolean f28154j = new AtomicBoolean(false);
    protected boolean ls = true;
    protected gd gb = new gd();

    /* renamed from: n  reason: collision with root package name */
    protected final AtomicBoolean f28156n = new AtomicBoolean(false);

    /* renamed from: z  reason: collision with root package name */
    protected boolean f28164z = false;
    protected int ba = 0;

    /* renamed from: y  reason: collision with root package name */
    protected Map<String, com.bytedance.msdk.adapter.c> f28163y = new ConcurrentHashMap();
    protected boolean eq = false;
    protected Map<String, Object> me = new ConcurrentHashMap();
    protected int xk = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean au() {
        Map<Integer, List<p>> map;
        List<com.bytedance.msdk.c.ux> list;
        List<com.bytedance.msdk.c.ux> list2;
        List<Integer> list3 = this.ia;
        if (list3 != null && list3.size() != 0 && (map = this.ev) != null && map.size() != 0) {
            for (Integer num : this.ia) {
                List<p> list4 = this.ev.get(Integer.valueOf(num.intValue()));
                if (list4 != null && list4.size() != 0) {
                    for (p pVar : list4) {
                        if (pVar != null) {
                            if (!k.c().xv(this.gd, pVar.ia())) {
                                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "adn \u8bf7\u6c42\u89e6\u53d1\u6b21\u6570\u62e6\u622a............");
                            } else if (!a.c().xv(this.gd, pVar.ia())) {
                                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "adn \u8bf7\u6c42\u89e6\u53d1\u65f6\u95f4\u95f4\u9694\u62e6\u622a............");
                            } else if (com.bytedance.msdk.core.gd.xv.c().c(pVar.t(), pVar.ia())) {
                                w(pVar, list4.size());
                                if (mt()) {
                                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u56de\u6eaf\u5230\u4e86\u6ee1\u8db3\u6570\u91cf\u7684\u5e7f\u544a.......\u6709\u5e7f\u544a\u56de\u8c03\u6210\u529f");
                                    ev();
                                    return true;
                                }
                            } else {
                                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "adn \u8bf7\u6c42\u89e6\u53d1\u4e86\u9519\u8bef\u7801\u62e6\u622a............");
                            }
                        }
                    }
                    continue;
                }
            }
            List<com.bytedance.msdk.c.ux> list5 = this.f28162u;
            if ((list5 != null && list5.size() > 0) || (((list = this.f28160s) != null && list.size() > 0) || ((list2 = this.fz) != null && list2.size() > 0))) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u56de\u6eaf\u5230\u4e86\u5e7f\u544a.......\u6709\u5e7f\u544a\u56de\u8c03\u6210\u529f");
                ev();
                return true;
            }
        }
        return false;
    }

    protected List<p> ba() {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar == null || wVar.up() == null || this.f28159r.up().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.f28159r.up()) {
            if (pVar != null && (pVar.s() == 1 || pVar.s() == 3)) {
                arrayList.add(pVar);
            }
        }
        return arrayList;
    }

    public List<com.bytedance.msdk.api.xv> bw() {
        if (com.bytedance.msdk.core.c.w().fz()) {
            ArrayList arrayList = new ArrayList();
            for (com.bytedance.msdk.c.ux uxVar : this.fz) {
                if (uxVar != null) {
                    arrayList.add(fp.c(this.f28155k, uxVar, false));
                }
            }
            return arrayList;
        }
        return null;
    }

    abstract void c(int i4, boolean z3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
    }

    abstract void c(String str, JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.api.c cVar) {
    }

    abstract boolean c(p pVar, int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public void ck() {
        if (mt()) {
            if (this.f28162u.size() >= vc()) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u629b\u51fa\u6210\u529f\u56de\u8c03_P\u5c42\u6c60\u4e2d\u5e7f\u544a\u6ee1\u8db3\u6570\u91cf\uff0c\u76f4\u63a5\u8fd4\u56de......");
                ev();
                return;
            }
            for (com.bytedance.msdk.c.ux uxVar : this.f28160s) {
                if (c(uxVar) && n()) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u629b\u51fa\u6210\u529f\u56de\u8c03_\u666e\u901a\u5c42\u6c60\u4e2d\u5e7f\u544a\u6ee1\u8db3\u6570\u91cf\uff0c\u4e14\u6ee1\u8db3client bidding\u7684\u8fd4\u56de\u6761\u4ef6\uff0c\u7ed9\u51fa\u6210\u529f\u56de\u8c03\uff0c\u76f4\u63a5\u8fd4\u56de......");
                    ev();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eq() {
        return this.bk;
    }

    abstract void ev();

    public boolean fz() {
        if (this.ux.get()) {
            return (this.eq && com.bytedance.msdk.f.w.c.c(this.f28159r)) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gb() {
        c(0, false);
        ck();
    }

    public List<com.bytedance.msdk.c.ux> gw() {
        ArrayList arrayList = new ArrayList();
        if (!yu.c(this.f28160s)) {
            arrayList.addAll(this.f28160s);
        }
        if (!yu.c(this.fz)) {
            arrayList.addAll(this.fz);
        }
        r.c(arrayList, r.c());
        if (!yu.c(this.f28162u)) {
            arrayList.addAll(0, this.f28162u);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        gd gdVar = this.gb;
        if (gdVar != null) {
            gdVar.f28035w = 2;
        }
    }

    public abstract void j();

    public abstract void ls();

    public List<com.bytedance.msdk.api.xv> m() {
        if (com.bytedance.msdk.core.c.w().fz()) {
            ArrayList arrayList = new ArrayList();
            for (com.bytedance.msdk.c.ux uxVar : gw()) {
                if (uxVar != null) {
                    arrayList.add(fp.c(this.f28155k, uxVar, false));
                }
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean me() {
        return this.f28161t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean mt() {
        return this.f28162u.size() + this.f28160s.size() >= vc();
    }

    public boolean n() {
        return !eq() || this.f28156n.get() || this.f28158q.w() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n_() {
        return false;
    }

    abstract void oo();

    public String pr() {
        return this.gd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String q() {
        gd gdVar = this.gb;
        if (gdVar != null) {
            return gdVar.xv;
        }
        return null;
    }

    public int s() {
        com.bytedance.msdk.api.c.w wVar = this.f28155k;
        if (wVar != null) {
            return wVar.fz();
        }
        return this.xk;
    }

    public void sr(final String str) {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.r.xv.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.core.sr.r rVar = (com.bytedance.msdk.core.sr.r) com.bytedance.msdk.core.sr.f.c();
                String str2 = str;
                xv xvVar = xv.this;
                rVar.c(str2, xvVar.ck, xvVar.f28155k, xvVar.f28159r, new ux.c() { // from class: com.bytedance.msdk.core.r.xv.2.1
                    @Override // com.bytedance.msdk.core.sr.ux.c
                    public void c(com.bytedance.msdk.core.sr.w wVar) {
                        Map<Integer, List<p>> map = xv.this.ev;
                        List<p> list = map != null ? map.get(0) : null;
                        xv xvVar2 = xv.this;
                        xvVar2.c(xvVar2.f28155k, list, wVar);
                    }
                });
            }
        });
    }

    public int u() {
        gd gdVar = this.gb;
        if (gdVar != null) {
            return gdVar.f28035w;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean up() {
        return this.f28162u.size() >= vc();
    }

    public boolean ux(String str) {
        if (!TextUtils.isEmpty(str) && y() && xk()) {
            for (p pVar : this.fp) {
                if (str.equals(pVar.ia())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int vc() {
        com.bytedance.msdk.api.c.w wVar = this.f28155k;
        if (wVar == null) {
            return 1;
        }
        return wVar.ls();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(com.bytedance.msdk.api.c cVar) {
    }

    abstract void w(com.bytedance.msdk.api.c cVar, com.bytedance.msdk.core.k.xv xvVar);

    abstract void w(p pVar, int i4);

    public void w(List<com.bytedance.msdk.c.ux> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.msdk.core.sr.c.c(this.f28155k, this.f28159r, list, this.fz);
        ArrayList<com.bytedance.msdk.c.ux> arrayList = new ArrayList();
        arrayList.addAll(list);
        for (com.bytedance.msdk.c.ux uxVar : arrayList) {
            xv(uxVar);
        }
        if (this.fz.size() == 0) {
            return;
        }
        ArrayList<com.bytedance.msdk.c.ux> arrayList2 = new ArrayList();
        arrayList2.addAll(this.fz);
        for (com.bytedance.msdk.c.ux uxVar2 : arrayList2) {
            boolean z3 = true;
            Iterator<com.bytedance.msdk.c.ux> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.bytedance.msdk.c.ux next = it.next();
                if (next != null && uxVar2 != null && next == uxVar2) {
                    z3 = false;
                    break;
                }
            }
            if (z3) {
                c(uxVar2, MediationConstant.BiddingLossReason.LOW_PRICE);
            }
        }
    }

    abstract void w(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.api.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wv() {
        return this.ys > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String wx() {
        gd gdVar = this.gb;
        if (gdVar == null) {
            return null;
        }
        return gdVar.f28033c;
    }

    public com.bytedance.msdk.api.xv x() {
        List<com.bytedance.msdk.c.ux> gw;
        if (!com.bytedance.msdk.core.c.w().fz() || (gw = gw()) == null || gw.size() == 0) {
            return null;
        }
        return fp.c(this.f28155k, gw.get(0), false);
    }

    protected boolean xk() {
        return this.ys == 1;
    }

    abstract void xv(com.bytedance.msdk.api.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void xv(String str) {
        gd gdVar = this.gb;
        if (gdVar != null) {
            gdVar.xv = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean y() {
        return this.f28151a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yu() {
        gd gdVar;
        if (!y() || (gdVar = this.gb) == null || TextUtils.isEmpty(gdVar.f28033c)) {
            return;
        }
        for (com.bytedance.msdk.c.ux uxVar : this.f28162u) {
            uxVar.putEventParam("server_bidding_extra", this.gb.f28033c);
        }
        for (com.bytedance.msdk.c.ux uxVar2 : this.fz) {
            uxVar2.putEventParam("server_bidding_extra", this.gb.f28033c);
        }
        for (com.bytedance.msdk.c.ux uxVar3 : this.f28160s) {
            uxVar3.putEventParam("server_bidding_extra", this.gb.f28033c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<p> z() {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar == null || wVar.up() == null || this.f28159r.up().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.f28159r.up()) {
            if (pVar != null && pVar.s() == 100) {
                arrayList.add(pVar);
            }
        }
        return arrayList;
    }

    public void c(String str, long j4) {
        this.me.put(str, Long.valueOf(j4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sr(int i4) {
        gd gdVar = this.gb;
        if (gdVar != null) {
            gdVar.f28035w = i4;
        }
    }

    private void xv(com.bytedance.msdk.c.ux uxVar) {
        com.bytedance.msdk.api.c.w wVar;
        if (uxVar == null || (wVar = this.f28155k) == null || !wVar.xk()) {
            return;
        }
        if (uxVar.isMultiBiddingAd() || uxVar.isClientBiddingAd() || uxVar.isServerBiddingAd()) {
            uxVar.bidWinNotify(null);
        }
    }

    public com.bytedance.msdk.adapter.c c(String str, String str2, String str3) {
        return this.f28163y.get(String.format("%1$s_%2$s_%3$s", str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Context context, final com.bytedance.msdk.api.c.w wVar, final List<p> list, boolean z3) {
        com.bytedance.msdk.core.sr.ux c4 = com.bytedance.msdk.core.sr.f.c();
        if (c4 != null) {
            this.ys = 0;
            gd gdVar = this.gb;
            if (gdVar != null) {
                gdVar.sr = true;
            }
            com.bytedance.msdk.core.sr.xv xvVar = new com.bytedance.msdk.core.sr.xv();
            xvVar.f28185c = wVar;
            xvVar.f28187w = list;
            xvVar.sr = this.f28159r;
            xvVar.f28186f = z3;
            xvVar.ux = wVar != null ? wVar.xv() : 1;
            c4.c(this.f28163y, context, xvVar, new ux.c() { // from class: com.bytedance.msdk.core.r.xv.1
                @Override // com.bytedance.msdk.core.sr.ux.c
                public void c(com.bytedance.msdk.core.sr.w wVar2) {
                    xv.this.c(wVar, list, wVar2);
                }
            });
        }
    }

    public void w(com.bytedance.msdk.c.ux uxVar) {
        if (com.bytedance.msdk.core.c.w().ck()) {
            com.bytedance.msdk.xv.r.c(uxVar, this.f28155k, i.c(Thread.currentThread().getStackTrace()), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.msdk.api.c.w wVar, List<p> list, com.bytedance.msdk.core.sr.w wVar2) {
        List<com.bytedance.msdk.c.ux> list2;
        List<com.bytedance.msdk.c.ux> list3;
        List<com.bytedance.msdk.c.ux> list4;
        List<com.bytedance.msdk.c.ux> list5;
        if (this.gb != null && wVar2 != null && !TextUtils.isEmpty(wVar2.sr)) {
            this.gb.f28033c = wVar2.sr;
        }
        com.bytedance.msdk.core.k.w wVar3 = this.f28159r;
        if (wVar3 != null && wVar2 != null) {
            wVar3.ux().put("price_source", Integer.valueOf(wVar2.bk));
        }
        com.bytedance.msdk.core.k.w wVar4 = this.f28159r;
        String mt = wVar4 != null ? wVar4.mt() : null;
        if (wVar2 != null) {
            com.bytedance.msdk.xv.r.c(wVar, wVar2, mt, this.f28158q.c() ? 1 : 0);
        }
        if (wVar2 != null && !yu.c(wVar2.f28184w)) {
            this.ys = 1;
            if (this.sr.get() || this.ux.get()) {
                return;
            }
            Handler handler = this.f28157p;
            if (handler != null) {
                handler.removeMessages(4);
                this.f28157p.removeMessages(1);
                this.f28157p.removeMessages(3);
            }
            j();
            this.fp.clear();
            List<p> list6 = wVar2.f28184w;
            if (list6 != null) {
                this.fp.addAll(list6);
            }
            c(this.fp, this.f28159r.k());
            if (yu.c(this.fp)) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "serverBidding\u54cd\u5e94\u56de\u6765..........\u6ca1\u6709P\u5c42\uff0c\u4e14\u666e\u901a\u5e7f\u544a\u5168\u90fd\u6ca1\u6709\u80dc\u51fa.....\u76f4\u63a5\u8fd4\u56de");
                List<com.bytedance.msdk.c.ux> list7 = this.f28162u;
                if ((list7 != null && list7.size() > 0) || (((list4 = this.f28160s) != null && list4.size() > 0) || ((list5 = this.fz) != null && list5.size() > 0))) {
                    if (this.bk) {
                        if (n()) {
                            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5b58\u5728client bidding\u4e14\u6ee1\u8db3\u89e6\u53d1\u6210\u529f\u56de\u8c03\u7684\u6761\u4ef6\uff0c\u5219\u7ed9\u51fa\u6210\u529f\u56de\u8c03.....");
                            ev();
                        }
                    } else {
                        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6ca1\u6709client bidding....\u76f4\u63a5\u7ed9\u51fa\u6210\u529f\u56de\u8c03.....");
                        ev();
                    }
                } else {
                    w(new com.bytedance.msdk.api.c(20005, com.bytedance.msdk.api.c.c(20005)), (com.bytedance.msdk.core.k.xv) null);
                }
            } else {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "serverBidding\u54cd\u5e94\u56de\u6765..........\u5f00\u59cb\u4ece\u5934\u5f00\u59cb\u8bf7\u6c42waterFallConfig ");
                gb();
            }
        } else {
            this.ys = 2;
            if (this.sr.get() || this.ux.get()) {
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "serverBidding\u54cd\u5e94\u5931\u8d25\u4e86.......... ");
            if (list != null) {
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    this.f28158q.c((String) null);
                }
            }
            this.f28158q.c(0, true);
            if (!this.f28158q.c() && this.f28158q.r()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6240\u6709\u5e7f\u544a\u90fd\u5df2\u7ecf\u52a0\u8f7d\u5b8c\u6210....... ");
                List<com.bytedance.msdk.c.ux> list8 = this.f28162u;
                if ((list8 != null && list8.size() > 0) || (((list2 = this.f28160s) != null && list2.size() > 0) || ((list3 = this.fz) != null && list3.size() > 0))) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "exchange\u54cd\u5e94\u5931\u8d25\u4e14\u6240\u6709\u7684\u5e7f\u544a\u90fd\u5df2\u7ecf\u52a0\u8f7d\u5b8c\u6210\uff0c\u5219\u7ed9\u51fa\u6210\u529f\u56de\u8c03.....");
                    ev();
                } else {
                    com.bytedance.msdk.core.k.w wVar5 = this.f28159r;
                    if (wVar5 != null && wVar5.a()) {
                        w(new com.bytedance.msdk.api.c(10013, com.bytedance.msdk.api.c.c(10013)), (com.bytedance.msdk.core.k.xv) null);
                    } else {
                        w(new com.bytedance.msdk.api.c(20005, com.bytedance.msdk.api.c.c(20005)), (com.bytedance.msdk.core.k.xv) null);
                    }
                }
            } else {
                ls();
                ck();
            }
        }
        if (this.f28159r != null && wVar2 != null) {
            com.bytedance.msdk.core.p.w.sr().c(wVar2.f28177a, wVar2.f28183t, this.f28159r.xk(), this.f28159r.me());
        }
        if (wVar2 == null || !wVar2.xv) {
            return;
        }
        com.bytedance.msdk.core.fp.w.c(com.bytedance.msdk.core.c.w()).c().w(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(com.bytedance.msdk.c.ux uxVar) {
        Map<Integer, List<p>> map;
        if (uxVar == null || TextUtils.isEmpty(uxVar.getAdNetworkSlotId()) || !uxVar.isNormalAd() || (map = this.ev) == null) {
            return false;
        }
        List<p> list = map.get(Integer.valueOf(uxVar.getLoadSort()));
        if (yu.c(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList);
        return !yu.w(arrayList) && uxVar.getAdNetworkSlotId().equals(((p) arrayList.get(0)).ia());
    }

    protected void c(List<p> list, boolean z3) {
        Map<Integer, List<p>> c4;
        if (list == null) {
            list = new ArrayList<>();
        }
        if (z3) {
            c4 = com.bytedance.msdk.core.sr.sr.w(list);
        } else {
            c4 = com.bytedance.msdk.core.sr.sr.c(list);
        }
        if (c4 == null) {
            c4 = new HashMap<>();
        }
        this.ev = c4;
        ArrayList arrayList = new ArrayList();
        this.ia = arrayList;
        arrayList.addAll(this.ev.keySet());
        w.c(this.ia);
        this.f28158q.w(this.ia);
        this.f28158q.c(list, z(), ba());
        c(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(List<p> list) {
        if (list != null && list.size() != 0) {
            for (com.bytedance.msdk.c.ux uxVar : this.f28160s) {
                boolean z3 = true;
                Iterator<p> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    p next = it.next();
                    if (uxVar != null && next != null && uxVar.getAdNetworkSlotId().equals(next.ia())) {
                        z3 = false;
                        break;
                    }
                }
                if (z3) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5df2\u7ecf\u54cd\u5e94\u7684\u5e7f\u544a: " + uxVar.getAdNetworkSlotId() + "  \u6ca1\u6709\u5728severBidding\u7684waterFall\u5217\u8868\u4e2d\uff0c\u9700\u8981\u88ab\u79fb\u9664\u6389");
                    this.f28160s.remove(uxVar);
                }
            }
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5df2\u7ecf\u54cd\u5e94\u7684\u5e7f\u544a\u88abserverBidding\u8fc7\u6ee4\u5b8c\u8fd8\u5269: " + this.f28160s.size());
            return;
        }
        this.f28160s.clear();
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6ca1\u6709\u80dc\u51fa\u7684\u666e\u901a\u5e7f\u544a\uff0c\u666e\u901a\u5e7f\u544a\u88ab\u5168\u90e8\u8fc7\u6ee4\u6389\u4e86 :" + this.f28160s.size());
    }

    protected void c(com.bytedance.msdk.c.ux uxVar, MediationConstant.BiddingLossReason biddingLossReason) {
        com.bytedance.msdk.api.c.w wVar;
        if (uxVar == null || (wVar = this.f28155k) == null || biddingLossReason == null || !wVar.xk()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("bidding_lose_reason", biddingLossReason);
        uxVar.bidLoseNotify(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z3, StackTraceElement[] stackTraceElementArr) {
        if (z3) {
            com.bytedance.msdk.xv.r.c((com.bytedance.msdk.c.ux) null, this.f28155k, i.c(stackTraceElementArr), 3);
        }
    }

    public void c(com.bytedance.msdk.c.ux uxVar, String str) {
        p ux = com.bytedance.msdk.core.ux.c.c.c().ux(this.gd, str);
        if (uxVar == null || ux == null) {
            return;
        }
        uxVar.setLoadSort(ux.j());
        uxVar.setShowSort(ux.ls());
        uxVar.setExchangeRate(ux.bk());
        uxVar.setAdNetworkSlotType(ux.s());
        uxVar.setCpm(ux.q());
    }
}
