package com.bytedance.msdk.core.sr;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.msdk.core.k.ev;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.core.sr.ux;
import com.bytedance.msdk.core.ys.c;
import com.bytedance.msdk.f.yu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements ux {
    @Override // com.bytedance.msdk.core.sr.ux
    public void c(Map<String, com.bytedance.msdk.adapter.c> map, Context context, final xv xvVar, @NonNull final ux.c cVar) {
        if (xvVar != null && xvVar.f28185c != null && xvVar.sr != null && !yu.c(xvVar.f28187w)) {
            String mt = xvVar.sr.mt();
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(xvVar.f28185c.u()) + "\u5f00\u542fserver bidding\u7f51\u7edc\u8bf7\u6c42......\uff1a");
            com.bytedance.msdk.xv.r.c(xvVar.f28185c, mt, (JSONObject) null);
            final long currentTimeMillis = System.currentTimeMillis();
            final int[] iArr = {4};
            com.bytedance.msdk.core.ys.c.c().c(map, context, xvVar.f28185c, xvVar.f28187w, xvVar.xv, xvVar.sr, xvVar.ux, xvVar.f28186f, new c.InterfaceC0423c() { // from class: com.bytedance.msdk.core.sr.r.1
                @Override // com.bytedance.msdk.core.ys.c.InterfaceC0423c
                public void c(com.bytedance.msdk.core.k.r rVar) {
                    r rVar2 = r.this;
                    long j4 = currentTimeMillis;
                    xv xvVar2 = xvVar;
                    rVar2.c(j4, xvVar2.f28185c, xvVar2.sr, iArr[0], rVar, cVar);
                }

                @Override // com.bytedance.msdk.core.ys.c.InterfaceC0423c
                public void c(com.bytedance.msdk.api.c cVar2) {
                    r.this.c(currentTimeMillis, iArr[0], cVar2, xvVar.f28185c, cVar);
                }
            });
            return;
        }
        cVar.c(null);
    }

    public void c(String str, final long j4, final com.bytedance.msdk.api.c.w wVar, final com.bytedance.msdk.core.k.w wVar2, @NonNull final ux.c cVar) {
        com.bytedance.msdk.core.ys.c.c().c(str, new c.InterfaceC0423c() { // from class: com.bytedance.msdk.core.sr.r.2
            @Override // com.bytedance.msdk.core.ys.c.InterfaceC0423c
            public void c(com.bytedance.msdk.core.k.r rVar) {
                r.this.c(j4, wVar, wVar2, 4, rVar, cVar);
            }

            @Override // com.bytedance.msdk.core.ys.c.InterfaceC0423c
            public void c(com.bytedance.msdk.api.c cVar2) {
                r.this.c(j4, 4, cVar2, wVar, cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j4, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.k.w wVar2, int i4, com.bytedance.msdk.core.k.r rVar, ux.c cVar) {
        w wVar3;
        int i5;
        p f4;
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(wVar.u()) + "server bidding\u7f51\u7edc\u8bf7\u6c42\u54cd\u8fd4\u56de.............");
        long currentTimeMillis = System.currentTimeMillis() - j4;
        if (wVar2 != null && rVar != null && !yu.c(rVar.sr())) {
            List<ev> sr = rVar.sr();
            wVar3 = new w();
            wVar3.f28177a = rVar.c();
            wVar3.bk = rVar.w();
            wVar3.f28183t = rVar.xv();
            wVar3.f28180k = rVar.r();
            wVar3.gd = sr.size();
            wVar3.f28178c = rVar.gd();
            wVar3.f28181p = wVar2.f();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            sb.append("winners : {");
            for (ev evVar : sr) {
                if (evVar != null && (f4 = wVar2.f(evVar.r())) != null) {
                    p sr2 = f4.sr();
                    sb.append(" [ AdnName:" + sr2.t() + ",slotId:" + sr2.ia() + ",loadSort:" + sr2.j() + ",showSort:" + sr2.ls() + "] ");
                    sr2.c(evVar);
                    arrayList.add(sr2);
                }
            }
            sb.append("}");
            if (yu.c(arrayList)) {
                r6 = yu.c(rVar.gd()) ? i4 : 2;
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(wVar.u()) + "server bidding\u7f51\u7edc\u8bf7\u6c42\u54cd\u5e94\u5931\u8d25......\uff1a\u6570\u636e\u6709\u8fd4\u56de\uff0c\u4f46\u6ca1\u6709\u8fd4\u56dewinner\u6570\u636e......");
            } else {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(wVar.u()) + "server bidding\u7f51\u7edc\u8bf7\u6c42\u54cd\u5e94\u6210\u529f......\uff1a" + sb.toString());
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.addAll(arrayList);
                List<p> c4 = c(rVar.gd(), wVar2, wVar3);
                if (c4 != null && c4.size() > 0) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(wVar.u()) + "server bidding\u7f51\u7edc\u8bf7\u6c42\u54cd\u5e94\u6210\u529f......waterfall+server bidding\u7269\u6599......");
                    copyOnWriteArrayList.addAll(c4);
                    i5 = 1;
                } else {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(wVar.u()) + "server bidding\u7f51\u7edc\u8bf7\u6c42\u54cd\u5e94\u6210\u529f......server bidding\u7269\u6599......");
                    i5 = 3;
                }
                wVar3.f28184w = copyOnWriteArrayList;
                r6 = i5;
            }
        } else {
            if (rVar == null || yu.c(rVar.gd())) {
                r6 = i4;
            }
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(wVar.u()) + "server bidding\u7f51\u7edc\u8bf7\u6c42\u54cd\u5e94\u5931\u8d25......\u6ca1\u6709\u8fd4\u56deserverBiddingModel\u76f8\u5173\u6570\u636e");
            wVar3 = null;
        }
        if (rVar != null) {
            String f5 = rVar.f();
            if (!TextUtils.isEmpty(f5)) {
                if (wVar3 == null) {
                    wVar3 = new w();
                }
                wVar3.sr = f5;
            }
            if (rVar.ev()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(wVar.u()) + "server bidding\u53d1\u73b0config\u8fc7\u671f\u4e86\uff0c\u9700\u8981\u91cd\u65b0\u62c9\u53d6\u914d\u7f6e......\uff1a");
                if (wVar3 == null) {
                    wVar3 = new w();
                }
                wVar3.xv = true;
            }
            if (!yu.c(rVar.ux())) {
                if (wVar3 == null) {
                    wVar3 = new w();
                }
                wVar3.ux = rVar.ux();
            }
        }
        if (wVar3 == null) {
            wVar3 = new w();
        }
        wVar3.f28179f = r6;
        wVar3.f28182r = currentTimeMillis;
        if (cVar != null) {
            cVar.c(wVar3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j4, int i4, com.bytedance.msdk.api.c cVar, com.bytedance.msdk.api.c.w wVar, ux.c cVar2) {
        int i5 = (cVar == null || cVar.f27444c != -1) ? 5 : 4;
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(wVar.u()) + "server bidding\u7f51\u7edc\u8bf7\u6c42\u54cd\u5e94\u5931\u8d25......onFail  result:" + i5);
        w wVar2 = new w();
        wVar2.f28179f = i5;
        wVar2.f28182r = System.currentTimeMillis() - j4;
        wVar2.ev = cVar;
        if (cVar2 != null) {
            cVar2.c(wVar2);
        }
    }

    private List<p> c(List<p> list, com.bytedance.msdk.core.k.w wVar, w wVar2) {
        List<p> up;
        if (list == null || list.size() == 0 || wVar == null) {
            return null;
        }
        boolean booleanValue = wVar.ux().get("serverBidding_timeout") instanceof Boolean ? ((Boolean) wVar.ux().get("serverBidding_timeout")).booleanValue() : false;
        if (wVar.f() == 4 && !booleanValue) {
            com.bytedance.msdk.core.k.w c4 = com.bytedance.msdk.ux.c.c.p().c(wVar.xk(), wVar.yu(), 102);
            if (c4 == null) {
                return null;
            }
            up = com.bytedance.msdk.core.p.xv.c(c4, c4.xk(), wVar2 == null ? 0.0d : wVar2.f28177a, wVar2 != null ? wVar2.f28183t : 0.0d);
            wVar.ux().putAll(c4.ux());
        } else {
            up = wVar.up();
        }
        if (up != null && up.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (p pVar : up) {
                Iterator<p> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        p next = it.next();
                        if (pVar != null && next != null && pVar.s() == 0 && !TextUtils.isEmpty(pVar.ia()) && pVar.ia().equals(next.ia())) {
                            arrayList.add(pVar);
                            break;
                        }
                    }
                }
            }
            return arrayList;
        }
        return null;
    }
}
