package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.ITTBiddingCore;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTClientBiddingCore implements ITTBiddingCore {
    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.ITTBiddingCore
    /* renamed from: a */
    public void mo59647a(BiddingRequestModel biddingRequestModel, ITTBiddingCore.InterfaceC0962a interfaceC0962a) {
        Map<Integer, List<WaterFallConfig>> map = biddingRequestModel.f436b;
        TTBaseAd tTBaseAd = biddingRequestModel.f435a;
        for (Map.Entry<Integer, List<WaterFallConfig>> entry : map.entrySet()) {
            List<WaterFallConfig> value = entry.getValue();
            if (value != null && value.size() > 0 && value.get(0).m59474e() != 100) {
                Iterator<WaterFallConfig> it = value.iterator();
                while (it.hasNext()) {
                    WaterFallConfig next = it.next();
                    if (next.m59474e() != 1) {
                        if (tTBaseAd.getAdNetworkPlatformId() == 1) {
                            if (next.m59471f() <= tTBaseAd.getCpm()) {
                                it.remove();
                                if (interfaceC0962a instanceof ITTBiddingCore.InterfaceC0963b) {
                                    ((ITTBiddingCore.InterfaceC0963b) interfaceC0962a).mo37333a(next);
                                }
                            }
                        } else if (next.m59471f() <= tTBaseAd.getCpm() && (next.m59471f() != tTBaseAd.getCpm() || !next.m59477d().equals("pangle"))) {
                            it.remove();
                            if (interfaceC0962a instanceof ITTBiddingCore.InterfaceC0963b) {
                                ((ITTBiddingCore.InterfaceC0963b) interfaceC0962a).mo37333a(next);
                            }
                        }
                    }
                }
            }
        }
        if (interfaceC0962a != null) {
            BiddingModel biddingModel = new BiddingModel();
            biddingModel.f431a = map;
            interfaceC0962a.mo37332a(biddingModel);
        }
    }
}
