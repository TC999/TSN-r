package com.bytedance.msdk.core.r;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.core.gd.a;
import com.bytedance.msdk.core.gd.bk;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.f.ck;
import com.bytedance.msdk.f.fp;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class sr extends com.bytedance.msdk.core.admanager.sr {
    protected boolean wx;
    protected boolean yu;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public sr(Context context, String str, int i4) {
        super(context, str, i4);
        this.yu = false;
        this.wx = false;
    }

    private boolean p() {
        boolean ux = ck.ux(com.bytedance.msdk.core.c.getContext());
        boolean sr = ck.sr(com.bytedance.msdk.core.c.getContext());
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "setting \u4e0b\u53d1\u662f\u5426\u4e3a\u5f31\u7f51\u6267\u884c\uff1a" + com.bytedance.msdk.core.c.w().ev() + "\uff0c\u5f53\u524d\u7f51\u7edc\u73af\u5883\uff1a2G-type=" + ux + ",3G-type=" + sr);
        return com.bytedance.msdk.core.c.w().ev() && (ux || sr);
    }

    private boolean w(com.bytedance.msdk.c.ux uxVar, Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (!uxVar.isReady(this.gd) || uxVar.isHasShown()) {
            return false;
        }
        if (r()) {
            if (!uxVar.isCustomAd() && !com.bytedance.msdk.core.admanager.f.c(uxVar.getAdNetWorkName(), uxVar.getAdType(), uxVar.getSubAdType())) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.w(this.gd, uxVar.getAdNetworkSlotId()) + "\u5f31\u7f51\u60c5\u51b5\u4e0b\u6ca1\u6709\u7f13\u5b58\u597d\u7684\u5e7f\u544a,\u90a3\u4e48\u76f4\u63a5\u6839\u636e\u4f18\u5148\u7ea7\u5c55\u793a\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(uxVar.getAdNetworkPlatformId()) + ",isReady()\uff1a" + uxVar.isReady(this.gd));
                c(uxVar, activity, ritScenes, str);
                return true;
            }
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad\u4e2d\uff0c\u81ea\u5b9a\u4e49adn\u8df3\u8fc7");
            return false;
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.w(this.gd, uxVar.getAdNetworkSlotId()) + "\u5f31\u7f51\u60c5\u51b5\u4e0b\u6ca1\u6709\u7f13\u5b58\u597d\u7684\u5e7f\u544a,\u90a3\u4e48\u76f4\u63a5\u6839\u636e\u4f18\u5148\u7ea7\u5c55\u793a\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(uxVar.getAdNetworkPlatformId()) + ",isReady()\uff1a" + uxVar.isReady(this.gd));
        c(uxVar, activity, ritScenes, str);
        return true;
    }

    private boolean xv(com.bytedance.msdk.c.ux uxVar, Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (!uxVar.isReady(this.gd) || uxVar.isHasShown()) {
            return false;
        }
        if (r()) {
            if (!uxVar.isCustomAd() && !com.bytedance.msdk.core.admanager.f.c(uxVar.getAdNetWorkName(), uxVar.getAdType(), uxVar.getSubAdType())) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.w(this.gd, uxVar.getAdNetworkSlotId()) + "\u5f31\u7f51\u60c5\u51b5\u4e0b\u6ca1\u6709\u7f13\u5b58\u597d\u7684\u5e7f\u544a,\u90a3\u4e48\u76f4\u63a5\u6839\u636e\u4f18\u5148\u7ea7\u5c55\u793a\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(uxVar.getAdNetworkPlatformId()) + ",isReady()\uff1a" + uxVar.isReady(this.gd));
                sr(uxVar);
                c(uxVar, activity, ritScenes, str);
                return true;
            }
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- cache \u63d2\u5168\u5c4f\u8f6e\u64ad\u4e2d\uff0c\u81ea\u5b9a\u4e49adn\u8df3\u8fc7");
            return false;
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.w(this.gd, uxVar.getAdNetworkSlotId()) + "\u5f31\u7f51\u60c5\u51b5\u4e0b\u6ca1\u6709\u7f13\u5b58\u597d\u7684\u5e7f\u544a,\u90a3\u4e48\u76f4\u63a5\u6839\u636e\u4f18\u5148\u7ea7\u5c55\u793a\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(uxVar.getAdNetworkPlatformId()) + ",isReady()\uff1a" + uxVar.isReady(this.gd));
        sr(uxVar);
        c(uxVar, activity, ritScenes, str);
        return true;
    }

    public boolean a() {
        return this.yu;
    }

    public boolean bk() {
        List<p> list;
        try {
            list = be();
        } catch (Throwable th) {
            th.printStackTrace();
            list = null;
        }
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        return fp.c(this.f28162u, this.fz, this.f28160s, this.f28155k, this.au, this.ux, this.gd, u(), list, wVar != null ? wVar.mt() : null);
    }

    public void c(boolean z3) {
        this.yu = z3;
    }

    protected boolean r() {
        return false;
    }

    public void t() {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar == null || uxVar.getAdNetworkPlatformId() == 4) {
            return;
        }
        com.bytedance.msdk.core.ux.w.w.c().c(this.vc.get(), this.gd, u());
    }

    public void ys() {
        boolean z3;
        boolean z4 = true;
        if (this.bm.getAdType() == 10 || this.bm.getAdType() == 8 || this.bm.getAdType() == 7) {
            if (this.bm.adnHasAdVideoCachedApi() && this.bm.isCacheSuccess() && com.bytedance.msdk.core.ux.w.w.c().xv(this.gd, u())) {
                z4 = false;
            }
            z3 = this.bm.getAdNetworkPlatformId() == 4 ? false : z4;
        } else {
            z3 = true;
        }
        if (this.bm.canAdReuse() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, this.bm.getAdNetworkSlotId(), u())) {
            com.bytedance.msdk.core.ux.c.c.c().c(this.bm.getAdNetworkSlotId(), this.f28155k, this.f28153i, z3, this.xu, this.gb, this.vc.get());
        }
    }

    private boolean c(List<p> list, List<com.bytedance.msdk.c.ux> list2, boolean z3, Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        List<com.bytedance.msdk.core.ux.w.ev> c4;
        com.bytedance.msdk.c.ux uxVar;
        List<com.bytedance.msdk.core.ux.w.ev> c5;
        com.bytedance.msdk.c.ux uxVar2;
        HashMap<String, com.bytedance.msdk.c.ux> f4 = f(list2);
        for (p pVar : list) {
            if (pVar != null) {
                String ia = pVar.ia();
                com.bytedance.msdk.c.ux uxVar3 = f4.get(ia);
                if (uxVar3 != null) {
                    if (z3) {
                        if (uxVar3.isCacheSuccess() && w(uxVar3, activity, ritScenes, str)) {
                            return true;
                        }
                    } else if (w(uxVar3, activity, ritScenes, str)) {
                        return true;
                    }
                }
                if (pVar.fz() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, ia, u()) && com.bytedance.msdk.core.ux.c.c.c().c(ia, this.f28155k, false) == 3 && (c5 = com.bytedance.msdk.core.ux.c.c.c().c(ia, this.f28155k, u())) != null && c5.size() > 0 && (uxVar2 = c5.get(0).f28224c) != null) {
                    if (z3) {
                        if (uxVar2.isCacheSuccess() && xv(uxVar2, activity, ritScenes, str)) {
                            return true;
                        }
                    } else if (xv(uxVar2, activity, ritScenes, str)) {
                        return true;
                    }
                }
            }
        }
        if (z3 && this.bm == null) {
            for (p pVar2 : list) {
                if (pVar2 != null) {
                    String ia2 = pVar2.ia();
                    com.bytedance.msdk.c.ux uxVar4 = f4.get(ia2);
                    if (uxVar4 != null && w(uxVar4, activity, ritScenes, str)) {
                        return true;
                    }
                    if (pVar2.fz() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, ia2, u()) && com.bytedance.msdk.core.ux.c.c.c().c(ia2, this.f28155k, false) == 3 && (c4 = com.bytedance.msdk.core.ux.c.c.c().c(ia2, this.f28155k, u())) != null && c4.size() > 0 && (uxVar = c4.get(0).f28224c) != null && xv(uxVar, activity, ritScenes, str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void xv(final com.bytedance.msdk.c.ux uxVar) {
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.r.sr.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.c.ux uxVar2 = uxVar;
                if (uxVar2 == null || !uxVar2.adnHasAdVideoCachedApi() || !uxVar.isCacheSuccess() || (sr.this.bm instanceof com.bytedance.msdk.api.sr.c.w.xv)) {
                    return;
                }
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.w(sr.this.gd, uxVar.getAdNetworkSlotId()) + "\u5728show\u65f6\u89e6\u53d1\u4e86\u9884\u52a0\u8f7d\u3010" + uxVar.getAdNetWorkName() + "\u3011, loadSort: " + uxVar.getLoadSort() + ", showSort: " + uxVar.getShowSort());
                sr.this.wx = true;
                sr srVar = sr.this;
                com.bytedance.msdk.core.ux.w.w.c().w(sr.this.vc.get(), srVar.gd, srVar.u());
            }
        });
    }

    public void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str, c cVar) {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        List<p> list = null;
        String mt = wVar != null ? wVar.mt() : null;
        if (!r()) {
            com.bytedance.msdk.xv.r.c(this.f28155k, mt);
            if (this.au) {
                com.bytedance.msdk.xv.r.c((List<com.bytedance.msdk.c.ux>) null, this.f28155k, 0);
                if (cVar != null) {
                    cVar.c();
                    return;
                }
                return;
            }
            int w3 = com.bytedance.msdk.core.admanager.sr.w(this.gd);
            if (w3 != 0) {
                com.bytedance.msdk.xv.r.c((List<com.bytedance.msdk.c.ux>) null, this.f28155k, w3);
                if (cVar != null) {
                    cVar.c();
                    return;
                }
                return;
            }
        }
        boolean p3 = p();
        List<com.bytedance.msdk.c.ux> gw = gw();
        try {
            list = be();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        List<p> list2 = list;
        if (list2 == null || list2.size() <= 0 || !c(list2, gw, p3, activity, ritScenes, str)) {
            if (gw != null && gw.size() > 0) {
                for (com.bytedance.msdk.c.ux uxVar : gw) {
                    if (uxVar != null && (!p3 || uxVar.isCacheSuccess())) {
                        if (w(uxVar, activity, ritScenes, str)) {
                            return;
                        }
                    }
                }
                if (p3 && this.bm == null) {
                    for (com.bytedance.msdk.c.ux uxVar2 : gw) {
                        if (uxVar2 != null && w(uxVar2, activity, ritScenes, str)) {
                            return;
                        }
                    }
                }
            }
            com.bytedance.msdk.xv.r.c(gw, this.f28155k, 0);
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void c(final com.bytedance.msdk.c.ux uxVar, final Activity activity, final TTAdConstant.RitScenes ritScenes, final String str) {
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.r.sr.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.c.ux uxVar2 = uxVar;
                if (uxVar2 != null) {
                    sr.this.bm = uxVar2;
                    uxVar2.setHasShown(true);
                    sr srVar = sr.this;
                    srVar.bm.setTTAdatperCallback(srVar.up);
                    sr srVar2 = sr.this;
                    srVar2.bm.setTTAdatperRewardPlayAgainCallback(srVar2.mt);
                    if (sr.this.bm.canAdReuse()) {
                        com.bytedance.msdk.core.ux.c.c c4 = com.bytedance.msdk.core.ux.c.c.c();
                        sr srVar3 = sr.this;
                        if (c4.sr(srVar3.gd, srVar3.bm.getAdNetworkSlotId(), sr.this.u())) {
                            sr srVar4 = sr.this;
                            com.bytedance.msdk.c.ux uxVar3 = srVar4.bm;
                            srVar4.c(uxVar3, uxVar3.getAdNetworkSlotId());
                        }
                    }
                    com.bytedance.msdk.core.ux.c.c c5 = com.bytedance.msdk.core.ux.c.c.c();
                    List<com.bytedance.msdk.c.ux> gw = sr.this.gw();
                    sr srVar5 = sr.this;
                    c5.c(gw, srVar5.gd, srVar5.f28155k, srVar5.u(), sr.this.bm);
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.bytedance.msdk.adapter.sr.ux.c(sr.this.gd, "show"));
                    sb.append("\u5c55\u793a\u7684\u5e7f\u544a\u7c7b\u578b\uff1a");
                    sb.append(com.bytedance.msdk.c.c.c(sr.this.bm.getAdNetworkPlatformId()));
                    sb.append(",slotId\uff1a");
                    sb.append(sr.this.bm.getAdNetworkSlotId());
                    sb.append(",slotType:");
                    sb.append(sr.this.bm.getAdNetworkSlotType());
                    sb.append(",isReady()\uff1a");
                    sr srVar6 = sr.this;
                    sb.append(srVar6.bm.isReady(srVar6.gd));
                    sb.append("\uff0c\u662f\u5426\u4e3a\u7f13\u5b58\u5e7f\u544a:");
                    sb.append(sr.this.bm.isCacheSuccess());
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", sb.toString());
                    sr.this.bm.showAd(activity, ritScenes, str);
                    bk c6 = bk.c();
                    c6.w(sr.this.gd + "");
                    a c7 = a.c();
                    sr srVar7 = sr.this;
                    c7.w(srVar7.gd, srVar7.bm.getAdNetworkSlotId());
                    sr.this.au = true;
                    if (sr.this.bm != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(sr.this.bm);
                        sr.this.w(arrayList);
                    }
                    sr srVar8 = sr.this;
                    com.bytedance.msdk.xv.r.c(srVar8.bm, srVar8.f28155k, false, srVar8.r() ? 1 : 0);
                }
            }
        });
    }
}
