package com.bytedance.sdk.openadsdk.mediation.manager.p167ok.p168ok.p169ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.manager.ok.ok.ok.kf */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6471kf implements MediationSplashManager {

    /* renamed from: ok */
    private final Bridge f22834ok;

    public C6471kf(Bridge bridge) {
        this.f22834ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager
    public void destroy() {
        this.f22834ok.call(270007, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        List<Bridge> list = (List) this.f22834ok.call(270002, C5930a.m37924c(0).m37926a(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new C6469a(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getBestEcpm() {
        return new C6473ok((Bridge) this.f22834ok.call(270004, C5930a.m37924c(0).m37926a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        List<Bridge> list = (List) this.f22834ok.call(270005, C5930a.m37924c(0).m37926a(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new C6473ok(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getMultiBiddingEcpm() {
        List<Bridge> list = (List) this.f22834ok.call(270003, C5930a.m37924c(0).m37926a(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new C6473ok(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getShowEcpm() {
        return new C6473ok((Bridge) this.f22834ok.call(270006, C5930a.m37924c(0).m37926a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        return ((Boolean) this.f22834ok.call(270001, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }
}
