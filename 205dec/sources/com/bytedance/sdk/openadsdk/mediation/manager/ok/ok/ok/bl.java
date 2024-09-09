package com.bytedance.sdk.openadsdk.mediation.manager.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl implements MediationFullScreenManager {
    private final Bridge ok;

    public bl(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager
    public void destroy() {
        this.ok.call(270007, com.bykv.ok.ok.ok.ok.a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        List<Bridge> list = (List) this.ok.call(270002, com.bykv.ok.ok.ok.ok.a.c(0).a(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new a(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getBestEcpm() {
        return new ok((Bridge) this.ok.call(270004, com.bykv.ok.ok.ok.ok.a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        List<Bridge> list = (List) this.ok.call(270005, com.bykv.ok.ok.ok.ok.a.c(0).a(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new ok(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getMultiBiddingEcpm() {
        List<Bridge> list = (List) this.ok.call(270003, com.bykv.ok.ok.ok.ok.a.c(0).a(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new ok(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getShowEcpm() {
        return new ok((Bridge) this.ok.call(270006, com.bykv.ok.ok.ok.ok.a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        return ((Boolean) this.ok.call(270001, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }
}
