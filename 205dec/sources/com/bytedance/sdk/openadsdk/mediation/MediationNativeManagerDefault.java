package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.f;
import com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c;
import com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux;
import com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.w;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationNativeManagerDefault extends ux {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<w> getAdLoadInfo() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public c getBestEcpm() {
        return new MediationAdEcpmInfoDefault();
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
    public c getShowEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public boolean isExpress() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public void setShakeViewListener(f fVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public void setUseCustomVideo(boolean z3) {
    }
}
