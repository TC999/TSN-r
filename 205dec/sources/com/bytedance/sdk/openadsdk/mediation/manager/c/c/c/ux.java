package com.bytedance.sdk.openadsdk.mediation.manager.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ux implements MediationRewardManager {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36202c;

    public ux(Bridge bridge) {
        this.f36202c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager
    public void destroy() {
        this.f36202c.call(270007, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        List<Bridge> list = (List) this.f36202c.call(270002, b.b(0).l(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new w(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getBestEcpm() {
        return new c((Bridge) this.f36202c.call(270004, b.b(0).l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        List<Bridge> list = (List) this.f36202c.call(270005, b.b(0).l(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new c(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getMultiBiddingEcpm() {
        List<Bridge> list = (List) this.f36202c.call(270003, b.b(0).l(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new c(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getShowEcpm() {
        return new c((Bridge) this.f36202c.call(270006, b.b(0).l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        return ((Boolean) this.f36202c.call(270001, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }
}
