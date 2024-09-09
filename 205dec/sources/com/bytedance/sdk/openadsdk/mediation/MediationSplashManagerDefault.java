package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c;
import com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.r;
import com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.w;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationSplashManagerDefault extends r {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.r
    public void destroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<w> getAdLoadInfo() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<c> getCacheList() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<c> getMultiBiddingEcpm() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public MediationAdEcpmInfoDefault getBestEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public MediationAdEcpmInfoDefault getShowEcpm() {
        return new MediationAdEcpmInfoDefault();
    }
}
