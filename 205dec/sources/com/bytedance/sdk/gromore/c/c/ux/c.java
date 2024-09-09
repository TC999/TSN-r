package com.bytedance.sdk.gromore.c.c.ux;

import com.bytedance.sdk.gromore.c.c.sr.ev;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.f {

    /* renamed from: c  reason: collision with root package name */
    private f f31207c;

    public c(f fVar) {
        this.f31207c = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.f
    public void destroy() {
        f fVar = this.f31207c;
        if (fVar != null) {
            fVar.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.w> getAdLoadInfo() {
        if (this.f31207c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31207c.w().size(); i4++) {
                linkedList.add(new ev(this.f31207c.w().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c getBestEcpm() {
        f fVar = this.f31207c;
        if (fVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.r(fVar.sr());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.r(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c> getCacheList() {
        if (this.f31207c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31207c.ux().size(); i4++) {
                linkedList.add(new com.bytedance.sdk.gromore.c.c.sr.r(this.f31207c.ux().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c> getMultiBiddingEcpm() {
        if (this.f31207c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31207c.xv().size(); i4++) {
                linkedList.add(new com.bytedance.sdk.gromore.c.c.sr.r(this.f31207c.xv().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c getShowEcpm() {
        f fVar = this.f31207c;
        if (fVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.r(fVar.f());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.r(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public boolean isReady() {
        f fVar = this.f31207c;
        if (fVar != null) {
            return fVar.c();
        }
        return false;
    }
}
