package com.bytedance.sdk.openadsdk.mediation.manager.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import com.bytedance.sdk.openadsdk.mediation.ad.c.c.w.r;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class sr implements MediationNativeManager {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36201c;

    public sr(Bridge bridge) {
        this.f36201c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        List<Bridge> list = (List) this.f36201c.call(270002, b.b(0).l(), List.class);
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
        return new c((Bridge) this.f36201c.call(270004, b.b(0).l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        List<Bridge> list = (List) this.f36201c.call(270005, b.b(0).l(), List.class);
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
        List<Bridge> list = (List) this.f36201c.call(270003, b.b(0).l(), List.class);
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
        return new c((Bridge) this.f36201c.call(270006, b.b(0).l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public boolean hasDislike() {
        return this.f36201c.values().booleanValue(270008);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public boolean isExpress() {
        return this.f36201c.values().booleanValue(270011);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        return ((Boolean) this.f36201c.call(270001, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void onPause() {
        this.f36201c.call(271049, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void onResume() {
        this.f36201c.call(271048, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void setShakeViewListener(MediationShakeViewListener mediationShakeViewListener) {
        b b4 = b.b(1);
        b4.h(0, new r(mediationShakeViewListener));
        this.f36201c.call(270010, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void setUseCustomVideo(boolean z3) {
        b b4 = b.b(1);
        b4.j(0, z3);
        this.f36201c.call(270009, b4.l(), Void.class);
    }
}
