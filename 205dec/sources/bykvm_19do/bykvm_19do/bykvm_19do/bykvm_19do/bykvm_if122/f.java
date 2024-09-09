package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: TTClientBiddingCore.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f implements d {
    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d
    public void a(b bVar, d.a aVar) {
        Map<Integer, List<h>> map = bVar.f429b;
        TTBaseAd tTBaseAd = bVar.f428a;
        for (Map.Entry<Integer, List<h>> entry : map.entrySet()) {
            List<h> value = entry.getValue();
            if (value != null && value.size() > 0 && value.get(0).e() != 100) {
                Iterator<h> it = value.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.e() != 1) {
                        if (tTBaseAd.getAdNetworkPlatformId() == 1) {
                            if (next.f() <= tTBaseAd.getCpm()) {
                                it.remove();
                                if (aVar instanceof d.b) {
                                    ((d.b) aVar).a(next);
                                }
                            }
                        } else if (next.f() <= tTBaseAd.getCpm() && (next.f() != tTBaseAd.getCpm() || !next.d().equals("pangle"))) {
                            it.remove();
                            if (aVar instanceof d.b) {
                                ((d.b) aVar).a(next);
                            }
                        }
                    }
                }
            }
        }
        if (aVar != null) {
            a aVar2 = new a();
            aVar2.f424a = map;
            aVar.a(aVar2);
        }
    }
}
