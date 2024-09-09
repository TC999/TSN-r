package com.bytedance.sdk.gromore.c.c.sr;

import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p extends com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux {

    /* renamed from: c  reason: collision with root package name */
    private fz f31195c;

    public p(fz fzVar) {
        this.f31195c = fzVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.w> getAdLoadInfo() {
        if (this.f31195c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31195c.w().size(); i4++) {
                linkedList.add(new ev(this.f31195c.w().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c getBestEcpm() {
        fz fzVar = this.f31195c;
        if (fzVar != null) {
            return new r(fzVar.sr());
        }
        return new r(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c> getCacheList() {
        if (this.f31195c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31195c.ux().size(); i4++) {
                linkedList.add(new r(this.f31195c.ux().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public List<com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c> getMultiBiddingEcpm() {
        if (this.f31195c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < this.f31195c.xv().size(); i4++) {
                linkedList.add(new r(this.f31195c.xv().get(i4)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c getShowEcpm() {
        fz fzVar = this.f31195c;
        if (fzVar != null) {
            return new r(fzVar.f());
        }
        return new r(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public boolean hasDislike() {
        fz fzVar = this.f31195c;
        if (fzVar != null) {
            return fzVar.r();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public boolean isExpress() {
        fz fzVar = this.f31195c;
        if (fzVar != null) {
            return fzVar.ev();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    public boolean isReady() {
        fz fzVar = this.f31195c;
        if (fzVar != null) {
            return fzVar.c();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public void onPause() {
        fz fzVar = this.f31195c;
        if (fzVar != null) {
            fzVar.p();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public void onResume() {
        fz fzVar = this.f31195c;
        if (fzVar != null) {
            fzVar.gd();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public void setShakeViewListener(final com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.f fVar) {
        fz fzVar = this.f31195c;
        if (fzVar != null) {
            fzVar.c(new u() { // from class: com.bytedance.sdk.gromore.c.c.sr.p.1
                @Override // com.bytedance.sdk.gromore.c.c.sr.u
                public void c() {
                    com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.f fVar2 = fVar;
                    if (fVar2 != null) {
                        fVar2.c();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux
    public void setUseCustomVideo(boolean z3) {
        fz fzVar = this.f31195c;
        if (fzVar != null) {
            fzVar.c(z3);
        }
    }
}
