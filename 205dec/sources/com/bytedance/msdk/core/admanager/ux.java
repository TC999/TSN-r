package com.bytedance.msdk.core.admanager;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.core.ev.c;
import com.bytedance.msdk.f.yu;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends sr {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.xv.xv f27808c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.xv f27809w;

    public ux(Context context, String str) {
        super(context, str, 9);
    }

    private List<com.bytedance.msdk.api.sr.c.xv.c> a() {
        com.bytedance.msdk.api.c.w wVar = this.f28155k;
        if (wVar == null) {
            return null;
        }
        int ls = wVar.ls();
        r(this.f28162u);
        r(this.fz);
        r(this.f28160s);
        p();
        return c(gw(), ls);
    }

    private void p() {
        try {
            List<com.bytedance.msdk.core.k.p> be = be();
            if (be == null || be.size() <= 0) {
                return;
            }
            for (com.bytedance.msdk.core.k.p pVar : be) {
                if (pVar != null) {
                    String ia = pVar.ia();
                    if (com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, ia, u())) {
                        if (pVar.s() == 100) {
                            c(ia, this.f28162u);
                        } else if (pVar.s() == 0) {
                            c(ia, this.f28160s);
                        }
                    }
                }
            }
            com.bytedance.msdk.core.r.r.c(this.f28162u, (Comparator<com.bytedance.msdk.c.ux>) null);
            com.bytedance.msdk.core.r.r.c(this.f28160s, (Comparator<com.bytedance.msdk.c.ux>) null);
            com.bytedance.msdk.core.r.r.c(this.fz, com.bytedance.msdk.core.r.r.c());
            com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==-- sorted ok");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void r(List<com.bytedance.msdk.c.ux> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<com.bytedance.msdk.c.ux> arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        list.clear();
        for (com.bytedance.msdk.c.ux uxVar : arrayList) {
            if (uxVar != null && !uxVar.isHasShown() && uxVar.isReady(pr())) {
                list.add(uxVar);
            }
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void sr() {
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void xv() {
        List<com.bytedance.msdk.api.sr.c.xv.c> a4;
        if (this.f27808c == null || (a4 = a()) == null || a4.size() <= 0) {
            return;
        }
        if (com.bytedance.msdk.adapter.sr.xv.w()) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u8fd4\u56de\u7ed9\u5916\u90e8\u5f00\u53d1\u8005\u7684\u5e7f\u544a\u6570\u91cf\uff1asumList.size=" + a4.size());
        }
        CopyOnWriteArrayList<com.bytedance.msdk.c.ux> copyOnWriteArrayList = new CopyOnWriteArrayList<>(gw());
        for (com.bytedance.msdk.api.sr.c.xv.c cVar : a4) {
            if (cVar != null) {
                if (cVar instanceof com.bytedance.msdk.core.ev.c) {
                    ((com.bytedance.msdk.core.ev.c) cVar).w(true);
                }
                if (cVar.q() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, cVar.t(), u())) {
                    c(cVar.w(), cVar.t());
                    c(copyOnWriteArrayList, cVar.w());
                }
            }
        }
        com.bytedance.msdk.core.ux.c.c.c().c(copyOnWriteArrayList, this.gd, this.f28155k, u(), null);
        this.f27808c.c(a4);
    }

    private void w(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.xv xvVar) {
        com.bytedance.msdk.core.k.w wVar2 = this.f28159r;
        if (wVar2 != null && wVar2.a()) {
            this.f27809w = xvVar;
            c(wVar);
        } else if (xvVar != null) {
            xvVar.c(new com.bytedance.msdk.api.c(10014, com.bytedance.msdk.api.c.c(10014)));
        }
    }

    public void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.xv.xv xvVar) {
        if (!com.bytedance.msdk.core.c.w().c(pr(), 9) && xvVar != null) {
            xvVar.c(new com.bytedance.msdk.api.c(840031, com.bytedance.msdk.api.c.c(840031)));
            return;
        }
        this.f27808c = xvVar;
        c(wVar);
    }

    private void c(com.bytedance.msdk.api.c.w wVar) {
        if (k()) {
            this.f28155k = wVar;
            g_();
        }
    }

    private boolean w(String str, List<com.bytedance.msdk.c.ux> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (com.bytedance.msdk.c.ux uxVar : list) {
            if (uxVar != null && TextUtils.equals(str, uxVar.getAdNetworkSlotId())) {
                return true;
            }
        }
        return false;
    }

    public void c(String str, com.bytedance.msdk.api.sr.c.xv.xv xvVar) {
        if (this.ba != 1) {
            if (xvVar != null) {
                xvVar.c(new com.bytedance.msdk.api.c(10015, com.bytedance.msdk.api.c.c(10015)));
            }
        } else if (this.f28164z) {
            if (xvVar != null) {
                xvVar.c(new com.bytedance.msdk.api.c(40047, com.bytedance.msdk.api.c.c(40047)));
            }
        } else if (this.bj) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u8c03\u7528\u8fc7\u9500\u6bc1\u65b9\u6cd5_destroy()\uff01\uff01\uff01");
            if (xvVar != null) {
                xvVar.c(new com.bytedance.msdk.api.c(41044, com.bytedance.msdk.api.c.c(41044)));
            }
        } else if (this.f28158q.c()) {
            if (xvVar != null) {
                xvVar.c(new com.bytedance.msdk.api.c(10010, "Ad load timeout!"));
            }
        } else {
            this.f28164z = true;
            this.f27808c = xvVar;
            sr(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.xv
    public void w(com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.api.sr.c.xv xvVar;
        super.w(cVar);
        if (this.ba != 0 || (xvVar = this.f27809w) == null) {
            return;
        }
        this.ba = 2;
        xvVar.c(cVar);
    }

    @Override // com.bytedance.msdk.core.r.ux
    public void w() {
        super.w();
        this.f27808c = null;
    }

    public void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.xv xvVar) {
        if (!com.bytedance.msdk.core.c.w().c(pr(), 9) && xvVar != null) {
            xvVar.c(new com.bytedance.msdk.api.c(840031, com.bytedance.msdk.api.c.c(840031)));
        } else {
            w(wVar, xvVar);
        }
    }

    private void c(CopyOnWriteArrayList<com.bytedance.msdk.c.ux> copyOnWriteArrayList, com.bytedance.msdk.c.ux uxVar) {
        Iterator<com.bytedance.msdk.c.ux> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.c.ux next = it.next();
            if (next == uxVar) {
                copyOnWriteArrayList.remove(next);
            }
        }
    }

    private void c(String str, List<com.bytedance.msdk.c.ux> list) {
        List<com.bytedance.msdk.core.ux.w.ev> c4;
        com.bytedance.msdk.c.ux uxVar;
        if (w(str, list) || com.bytedance.msdk.core.ux.c.c.c().c(str, this.f28155k, false) != 3 || (c4 = com.bytedance.msdk.core.ux.c.c.c().c(str, this.f28155k, u())) == null || c4.size() <= 0) {
            return;
        }
        for (com.bytedance.msdk.core.ux.w.ev evVar : c4) {
            if (evVar != null && (uxVar = evVar.f28224c) != null && !uxVar.isHasShown() && evVar.f28224c.isReady(this.gd)) {
                list.add(evVar.f28224c);
                sr(evVar.f28224c);
            }
        }
    }

    private List<com.bytedance.msdk.api.sr.c.xv.c> c(List<com.bytedance.msdk.c.ux> list, int i4) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Iterator<com.bytedance.msdk.c.ux> it = list.iterator();
        while (it.hasNext() && arrayList2.size() < i4) {
            com.bytedance.msdk.c.ux next = it.next();
            arrayList.add(next);
            if (com.bytedance.msdk.adapter.sr.xv.w()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "");
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd, "show") + "\u8fd4\u56de\u7ed9\u5f00\u53d1\u8005\u6700\u7ec8\u5e7f\u544a\uff1aslotId=" + next.getAdNetworkSlotId() + ",slotType:" + next.getAdNetworkSlotType() + ",cpm=" + next.getCpm() + ",\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(next.getAdNetworkPlatformId()) + ",ImageMode=" + next.getImageMode() + ",showSort=" + next.getShowSort() + ",isExpressAd=" + next.isExpressAd());
            }
            arrayList2.add(new com.bytedance.msdk.core.ev.c(next, this.f28155k, new c.InterfaceC0416c() { // from class: com.bytedance.msdk.core.admanager.ux.1
                @Override // com.bytedance.msdk.core.ev.c.InterfaceC0416c
                public void c() {
                    ((com.bytedance.msdk.core.r.ux) ux.this).au = true;
                }

                @Override // com.bytedance.msdk.core.ev.c.InterfaceC0416c
                public void c(com.bytedance.msdk.api.sr.c.xv.c cVar) {
                    int i5 = 0;
                    while (i5 < arrayList2.size() && cVar != arrayList2.get(i5)) {
                        i5++;
                    }
                    ux.this.c(cVar, i5);
                }
            }));
            it.remove();
        }
        w(arrayList);
        return arrayList2;
    }

    public void c(com.bytedance.msdk.api.sr.c.xv.c cVar, int i4) {
        com.bytedance.msdk.c.ux w3 = cVar.w();
        if (w3 != null && w3.canAdReuse() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, cVar.t(), u())) {
            com.bytedance.msdk.core.ux.c.c.c().c(cVar.t(), this.f28155k, this.f28153i, i4 == 0, this.xu, this.gb, this.vc.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux
    public void c(com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.api.sr.c.xv xvVar;
        com.bytedance.msdk.api.sr.c.xv.xv xvVar2 = this.f27808c;
        if (xvVar2 != null) {
            xvVar2.c(cVar);
        }
        if (this.ba != 0 || this.f28164z || (xvVar = this.f27809w) == null) {
            return;
        }
        this.ba = 2;
        xvVar.c(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.xv
    public void c(String str) {
        com.bytedance.msdk.api.sr.c.xv xvVar;
        super.c(str);
        if (this.ba != 0 || (xvVar = this.f27809w) == null) {
            return;
        }
        this.ba = 1;
        xvVar.c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.xv
    public void c(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.api.c cVar) {
        super.c(list, cVar);
        if (this.f27808c instanceof com.bytedance.msdk.api.sr.c.xv.f) {
            ArrayList arrayList = null;
            if (!yu.c(list)) {
                arrayList = new ArrayList();
                for (com.bytedance.msdk.c.ux uxVar : list) {
                    arrayList.add(new com.bytedance.msdk.core.ev.c(uxVar, this.f28155k, new c.InterfaceC0416c() { // from class: com.bytedance.msdk.core.admanager.ux.2
                        @Override // com.bytedance.msdk.core.ev.c.InterfaceC0416c
                        public void c() {
                            ((com.bytedance.msdk.core.r.ux) ux.this).au = true;
                        }

                        @Override // com.bytedance.msdk.core.ev.c.InterfaceC0416c
                        public void c(com.bytedance.msdk.api.sr.c.xv.c cVar2) {
                            ux.this.c(cVar2, -1);
                        }
                    }));
                }
            }
            ((com.bytedance.msdk.api.sr.c.xv.f) this.f27808c).c(arrayList, cVar);
        }
    }
}
