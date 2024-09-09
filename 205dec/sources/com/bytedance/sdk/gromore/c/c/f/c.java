package com.bytedance.sdk.gromore.c.c.f;

import com.bytedance.sdk.gromore.c.c.sr.ev;
import com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.r;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends r {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.gromore.c.c.ux.f f31151c;

    public c(com.bytedance.sdk.gromore.c.c.ux.f fVar) {
        this.f31151c = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.r
    public void destroy() {
        com.bytedance.sdk.gromore.c.c.ux.f fVar = this.f31151c;
        if (fVar != null) {
            fVar.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.w> getAdLoadInfo() {
        if (this.f31151c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31151c.w().size(); i4++) {
                linkedList.add(new ev(this.f31151c.w().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c getBestEcpm() {
        com.bytedance.sdk.gromore.c.c.ux.f fVar = this.f31151c;
        if (fVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.r(fVar.sr());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.r(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c> getCacheList() {
        if (this.f31151c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31151c.ux().size(); i4++) {
                linkedList.add(new com.bytedance.sdk.gromore.c.c.sr.r(this.f31151c.ux().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c> getMultiBiddingEcpm() {
        if (this.f31151c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31151c.xv().size(); i4++) {
                linkedList.add(new com.bytedance.sdk.gromore.c.c.sr.r(this.f31151c.xv().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c getShowEcpm() {
        com.bytedance.sdk.gromore.c.c.ux.f fVar = this.f31151c;
        if (fVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.r(fVar.f());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.r(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public boolean isReady() {
        com.bytedance.sdk.gromore.c.c.ux.f fVar = this.f31151c;
        if (fVar != null) {
            return fVar.c();
        }
        return false;
    }
}
