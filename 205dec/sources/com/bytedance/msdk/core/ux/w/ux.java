package com.bytedance.msdk.core.ux.w;

import android.content.Context;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.core.ux.w.w;
import com.bytedance.msdk.f.bw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class ux extends com.bytedance.msdk.core.r.c.c {

    /* renamed from: c  reason: collision with root package name */
    protected List<p> f28229c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.c.ux f28230w;

    /* JADX INFO: Access modifiers changed from: protected */
    public ux(Context context, String str, int i4) {
        super(context, str, i4);
        this.f28229c = new ArrayList();
    }

    @Override // com.bytedance.msdk.core.r.ux
    public void g_() {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.ux.w.ux.1
            @Override // java.lang.Runnable
            public void run() {
                ux.this.l_();
                ((com.bytedance.msdk.core.r.xv) ux.this).f28155k.f(1);
                if (((com.bytedance.msdk.core.r.ux) ux.this).gw != null) {
                    com.bytedance.msdk.core.k.w c4 = ((com.bytedance.msdk.core.r.ux) ux.this).gw.c(((com.bytedance.msdk.core.r.xv) ux.this).gd, ux.this.s(), 102);
                    ux uxVar = ux.this;
                    ((com.bytedance.msdk.core.r.xv) uxVar).f28159r = uxVar.c(c4, uxVar.f28230w);
                    com.bytedance.msdk.core.k.w c5 = com.bytedance.msdk.core.xv.xv.c(((com.bytedance.msdk.core.r.xv) ux.this).f28155k, ((com.bytedance.msdk.core.r.xv) ux.this).f28159r);
                    if (c5 != null) {
                        ((com.bytedance.msdk.core.r.xv) ux.this).f28159r = c5;
                    }
                    if (((com.bytedance.msdk.core.r.xv) ux.this).f28159r == null) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u9884\u7f13\u5b58\u8865\u5145\u8bf7\u6c42\u672a\u53d1\u8d77\uff0cmRitConfig\u4e3anull");
                        if (((com.bytedance.msdk.core.r.ux) ux.this).fm != null) {
                            ((com.bytedance.msdk.core.r.ux) ux.this).fm.c(((com.bytedance.msdk.core.r.xv) ux.this).gd, false, 0, null);
                            return;
                        }
                        return;
                    }
                    com.bytedance.msdk.core.k.w wVar = ((com.bytedance.msdk.core.r.xv) ux.this).f28159r;
                    double bw = ((com.bytedance.msdk.core.r.xv) ux.this).f28159r.bw();
                    double xv = ((com.bytedance.msdk.core.r.xv) ux.this).f28159r.xv();
                    Double.isNaN(bw);
                    wVar.f((long) (bw * xv));
                    com.bytedance.msdk.core.k.w wVar2 = ((com.bytedance.msdk.core.r.xv) ux.this).f28159r;
                    double pr = ((com.bytedance.msdk.core.r.xv) ux.this).f28159r.pr();
                    double w3 = ((com.bytedance.msdk.core.r.xv) ux.this).f28159r.w();
                    Double.isNaN(pr);
                    wVar2.ux((long) (pr * w3));
                    ((com.bytedance.msdk.core.r.xv) ux.this).f28159r.w(false);
                    ((com.bytedance.msdk.core.r.xv) ux.this).f28159r.c(false);
                    ux.this.bm();
                }
                ((com.bytedance.msdk.core.r.xv) ux.this).f28155k.c(((com.bytedance.msdk.core.r.xv) ux.this).f28159r);
                ((com.bytedance.msdk.core.r.xv) ux.this).f28155k.gd();
                List<p> up = ((com.bytedance.msdk.core.r.xv) ux.this).f28159r.up();
                if (up != null && up.size() > 0) {
                    ux.this.te();
                    ux uxVar2 = ux.this;
                    ((com.bytedance.msdk.core.r.xv) uxVar2).ev = ((com.bytedance.msdk.core.r.xv) uxVar2).f28159r.n();
                    ((com.bytedance.msdk.core.r.xv) ux.this).ia = new ArrayList(((com.bytedance.msdk.core.r.xv) ux.this).f28159r.wv());
                    ux uxVar3 = ux.this;
                    uxVar3.f28229c = ((com.bytedance.msdk.core.r.xv) uxVar3).f28159r.up();
                    ux uxVar4 = ux.this;
                    bw.c(uxVar4.f28229c, ((com.bytedance.msdk.core.r.ux) uxVar4).te);
                    if (com.bytedance.msdk.adapter.sr.xv.w()) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u9884\u7f13\u5b58\u8865\u5145\u8bf7\u6c42\uff0c\u8fc7\u6ee4\u540e\u7684waterfall\uff1a");
                        for (p pVar : ux.this.f28229c) {
                            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(((com.bytedance.msdk.core.r.xv) ux.this).gd) + "waterfall: " + pVar.t() + ", loadSort: " + pVar.j() + ", showSort: " + pVar.ls() + ", eCpm: " + pVar.q());
                        }
                    }
                    com.bytedance.msdk.core.r.w.c(((com.bytedance.msdk.core.r.xv) ux.this).ia);
                    ((com.bytedance.msdk.core.r.xv) ux.this).f28158q.c(((com.bytedance.msdk.core.r.xv) ux.this).ia);
                    ((com.bytedance.msdk.core.r.xv) ux.this).f28158q.c(((com.bytedance.msdk.core.r.xv) ux.this).f28159r.j());
                    if (((com.bytedance.msdk.core.r.xv) ux.this).f28157p != null) {
                        ((com.bytedance.msdk.core.r.xv) ux.this).f28157p.sendEmptyMessageDelayed(2, ((com.bytedance.msdk.core.r.ux) ux.this).f28112x);
                    }
                    ((com.bytedance.msdk.core.r.xv) ux.this).f28154j.set(true);
                    ux.this.ng();
                    return;
                }
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u9884\u7f13\u5b58\u8865\u5145\u8bf7\u6c42\u672a\u53d1\u8d77\uff0c\u8fc7\u6ee4\u540e\u7684waterfall\u4e3a\u7a7a");
                if (((com.bytedance.msdk.core.r.ux) ux.this).fm != null) {
                    ((com.bytedance.msdk.core.r.ux) ux.this).fm.c(((com.bytedance.msdk.core.r.xv) ux.this).gd, false, 0, null);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void l_() {
        this.f28155k.sr(u());
        this.f28155k.w(q());
        this.f28155k.c(com.bytedance.msdk.core.r.r.sr());
        this.f28155k.xv(w.c().w(this.gd, u()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux, com.bytedance.msdk.core.r.xv
    public void ev() {
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u9884\u7f13\u5b58\u8865\u5145\u8bf7\u6c42\uff1ainvokeAdLoaded");
        ge();
        if (this.sr.get() || this.ux.get()) {
            return;
        }
        this.sr.set(true);
        w.xv xvVar = this.fm;
        if (xvVar != null) {
            xvVar.c(this.gd, true, 0, this.f28160s);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux, com.bytedance.msdk.core.r.xv
    public void w(com.bytedance.msdk.api.c cVar, com.bytedance.msdk.core.k.xv xvVar) {
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u9884\u7f13\u5b58\u8865\u5145\u8bf7\u6c42\uff1ainvokeAdFailed");
        ge();
        if (this.ux.get() || this.sr.get()) {
            return;
        }
        this.ux.set(true);
        w.xv xvVar2 = this.fm;
        if (xvVar2 != null) {
            int i4 = 10003;
            xvVar2.c(this.gd, false, (cVar == null || cVar.f27444c != 10003) ? 10086 : 10086, null);
        }
    }

    public void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.c.ux uxVar, w.xv xvVar) {
        this.f28155k = wVar;
        this.f28230w = uxVar;
        this.up = null;
        this.fm = xvVar;
        g_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.msdk.core.k.w c(com.bytedance.msdk.core.k.w wVar, com.bytedance.msdk.c.ux uxVar) {
        if (wVar == null || uxVar == null) {
            return null;
        }
        double cpm = uxVar.getCpm();
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "\u7b5b\u9009\u9884\u7f13\u5b58 ecpm " + cpm);
        com.bytedance.msdk.core.k.w clone = wVar.clone();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (p pVar : clone.up()) {
            if (pVar != null && pVar.wv() && pVar.q() > cpm) {
                copyOnWriteArrayList.add(pVar);
            }
        }
        if (clone.k()) {
            clone.w(copyOnWriteArrayList);
        } else {
            clone.c(copyOnWriteArrayList);
        }
        return clone;
    }
}
