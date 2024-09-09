package com.bytedance.msdk.core.ux.w;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.core.ux.w.w;
import com.bytedance.msdk.f.yu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bytedance.msdk.core.r.c.c {

    /* renamed from: c  reason: collision with root package name */
    private long f28252c;

    /* JADX INFO: Access modifiers changed from: protected */
    public xv(Context context, String str, int i4) {
        super(context, str, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux
    public void c(com.bytedance.msdk.api.c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.xv
    public boolean n_() {
        return true;
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void sr() {
    }

    @Override // com.bytedance.msdk.core.r.ux
    public void w(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.core.k.xv xvVar) {
        if (list == null) {
            return;
        }
        for (com.bytedance.msdk.c.ux uxVar : list) {
            if (uxVar != null) {
                w.c().c(this.gd, new ev(uxVar, xvVar, this.f28252c, this.f28155k));
            }
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void xv() {
    }

    public void c(com.bytedance.msdk.api.c.w wVar, w.xv xvVar) {
        this.f28252c = SystemClock.currentThreadTimeMillis();
        w.c().c(this.gd, this.f28252c);
        this.f28155k = wVar;
        this.up = null;
        this.fm = xvVar;
        g_();
    }

    @Override // com.bytedance.msdk.core.r.f, com.bytedance.msdk.core.r.ux, com.bytedance.msdk.adapter.c.InterfaceC0386c
    public void c(com.bytedance.msdk.api.c cVar, com.bytedance.msdk.core.k.xv xvVar) {
        super.c(cVar, xvVar);
        w.c().c(this.gd, xvVar.bk(), this.f28252c, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.xv
    public void c(List<p> list) {
        com.bytedance.msdk.c.ux uxVar;
        super.c(list);
        Map<String, List<ev>> ux = w.c().ux(this.gd);
        if (ux == null || ux.keySet() == null) {
            return;
        }
        CopyOnWriteArrayList<com.bytedance.msdk.c.ux> copyOnWriteArrayList = new CopyOnWriteArrayList();
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(ux.keySet());
        for (String str : arrayList) {
            List<ev> list2 = ux.get(str);
            if (list2 != null && list2.size() > 0) {
                for (ev evVar : list2) {
                    if (evVar != null && (uxVar = evVar.f28224c) != null && uxVar.isNormalAd()) {
                        copyOnWriteArrayList.add(evVar.f28224c);
                    }
                }
            }
        }
        if (copyOnWriteArrayList.size() == 0) {
            return;
        }
        if (!yu.c(list)) {
            for (com.bytedance.msdk.c.ux uxVar2 : copyOnWriteArrayList) {
                boolean z3 = true;
                Iterator<p> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    p next = it.next();
                    if (uxVar2 != null && next != null && uxVar2.getAdNetworkSlotId().equals(next.ia())) {
                        z3 = false;
                        break;
                    }
                }
                if (!z3) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5904\u7406\u9884\u7f13\u5b58\u903b\u8f91......\u5df2\u7ecf\u54cd\u5e94\u7684\u5e7f\u544a: " + uxVar2.getAdNetworkSlotId() + "  \u6ca1\u6709\u5728severBidding\u7684waterFall\u5217\u8868\u4e2d\uff0c\u9700\u8981\u88ab\u79fb\u9664\u6389");
                    copyOnWriteArrayList.remove(uxVar2);
                }
            }
            for (com.bytedance.msdk.c.ux uxVar3 : copyOnWriteArrayList) {
                if (uxVar3 != null) {
                    ux.remove(uxVar3.getAdNetworkSlotId());
                }
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5904\u7406\u9884\u7f13\u5b58\u903b\u8f91......\u6ca1\u6709\u80dc\u51fa\u7684\u666e\u901a\u5e7f\u544a\uff0c\u666e\u901a\u5e7f\u544a\u88ab\u5168\u90e8\u8fc7\u6ee4\u6389\u4e86");
    }
}
