package com.bytedance.sdk.gromore.c.c.xv;

import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.sr {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.gromore.c.c.ux.f f31232c;

    public gd(com.bytedance.sdk.gromore.c.c.ux.f fVar) {
        this.f31232c = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.sr
    public void destroy() {
        com.bytedance.sdk.gromore.c.c.ux.f fVar = this.f31232c;
        if (fVar != null) {
            fVar.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.w> getAdLoadInfo() {
        if (this.f31232c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31232c.w().size(); i4++) {
                linkedList.add(new com.bytedance.sdk.gromore.c.c.sr.ev(this.f31232c.w().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c getBestEcpm() {
        com.bytedance.sdk.gromore.c.c.ux.f fVar = this.f31232c;
        if (fVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.r(fVar.sr());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.r(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c> getCacheList() {
        if (this.f31232c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31232c.ux().size(); i4++) {
                linkedList.add(new com.bytedance.sdk.gromore.c.c.sr.r(this.f31232c.ux().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c> getMultiBiddingEcpm() {
        if (this.f31232c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31232c.xv().size(); i4++) {
                linkedList.add(new com.bytedance.sdk.gromore.c.c.sr.r(this.f31232c.xv().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c getShowEcpm() {
        com.bytedance.sdk.gromore.c.c.ux.f fVar = this.f31232c;
        if (fVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.r(fVar.f());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.r(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public boolean isReady() {
        com.bytedance.sdk.gromore.c.c.ux.f fVar = this.f31232c;
        if (fVar != null) {
            return fVar.c();
        }
        return false;
    }
}
