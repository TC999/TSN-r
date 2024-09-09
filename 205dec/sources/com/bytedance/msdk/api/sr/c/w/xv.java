package com.bytedance.msdk.api.sr.c.w;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.sr.c.w.ev.ev;
import com.bytedance.msdk.api.sr.c.w.ev.f;
import com.bytedance.msdk.api.sr.c.w.ev.gd;
import com.bytedance.msdk.api.sr.c.w.ev.k;
import com.bytedance.msdk.api.sr.c.w.ev.p;
import com.bytedance.msdk.api.sr.c.w.ev.r;
import com.bytedance.msdk.api.sr.c.w.ev.sr;
import com.bytedance.msdk.api.sr.t;
import com.bytedance.msdk.c.ux;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends ux {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.w.w.w f27608c;
    private f fp;
    private ev fz;
    private p ia;

    /* renamed from: s  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.w.ev.ux f27609s;
    private t sr;

    /* renamed from: t  reason: collision with root package name */
    private gd f27610t;
    private sr ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.s.c.w.c.c f27611w;
    private r xv;
    private k ys;

    @Override // com.bytedance.msdk.c.ux
    public void bidLoseNotify(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        int lossReason = MediationConstant.BiddingLossReason.OTHER.getLossReason();
        try {
            Object obj = map.get("bidding_lose_reason");
            if (obj instanceof MediationConstant.BiddingLossReason) {
                lossReason = ((MediationConstant.BiddingLossReason) obj).getLossReason();
            }
        } catch (Exception unused) {
        }
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27608c;
        if (wVar != null) {
            wVar.c(false, -1.0d, lossReason, null);
        }
        t tVar = this.sr;
        if (tVar != null) {
            tVar.c(false, -1.0d, lossReason, null);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void bidWinNotify(Map<String, Object> map) {
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27608c;
        if (wVar != null) {
            wVar.c(true, getCpm(), -1, null);
        }
        t tVar = this.sr;
        if (tVar != null) {
            tVar.c(true, getCpm(), -1, null);
        }
    }

    public void c(sr srVar) {
        this.ux = srVar;
    }

    @Override // com.bytedance.msdk.c.ux
    public void cancelDownload() {
        ev evVar = this.fz;
        if (evVar != null) {
            evVar.xv();
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void dislikeClick(String str, Map<String, Object> map) {
        super.dislikeClick(str, map);
        r rVar = this.xv;
        if (rVar != null) {
            rVar.c(str, map);
        }
    }

    public com.bytedance.sdk.openadsdk.s.c.w.c.c f() {
        return this.f27611w;
    }

    @Override // com.bytedance.msdk.c.ux
    @Nullable
    public View getAdView() {
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27608c;
        if (wVar != null && (wVar instanceof com.bytedance.msdk.api.sr.c.w.c.w)) {
            return ((com.bytedance.msdk.api.sr.c.w.c.w) wVar).f();
        }
        gd gdVar = this.f27610t;
        if (gdVar != null) {
            return gdVar.w();
        }
        return null;
    }

    @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
    public com.bytedance.sdk.openadsdk.ys.w.w.ev getDislikeDialog(Activity activity) {
        r rVar = this.xv;
        if (rVar != null) {
            return rVar.c(activity);
        }
        return super.getDislikeDialog(activity);
    }

    @Override // com.bytedance.msdk.c.ux
    public int getDownloadStatus() {
        ev evVar = this.fz;
        if (evVar != null) {
            return evVar.sr();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.c.ux
    @Nullable
    public com.bytedance.msdk.api.sr.c.r.f getGMNativeCustomVideoReporter() {
        com.bytedance.msdk.api.sr.c.w.ev.ux uxVar = this.f27609s;
        if (uxVar != null) {
            return uxVar.w();
        }
        return null;
    }

    @Override // com.bytedance.msdk.c.ux
    @Nullable
    public String getVideoUrl() {
        com.bytedance.msdk.api.sr.c.w.ev.ux uxVar = this.f27609s;
        if (uxVar != null) {
            return uxVar.c();
        }
        return null;
    }

    @Override // com.bytedance.msdk.c.ux
    public boolean hasDestroyed() {
        return false;
    }

    @Override // com.bytedance.msdk.c.ux
    public boolean hasDislike() {
        try {
            f fVar = this.fp;
            if (fVar != null) {
                return fVar.c();
            }
        } catch (Exception unused) {
        }
        return super.hasDislike();
    }

    @Override // com.bytedance.msdk.c.ux
    public final MediationConstant.AdIsReadyStatus isReadyStatus() {
        p pVar = this.ia;
        if (pVar != null) {
            return pVar.c();
        }
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27608c;
        if (wVar != null) {
            return wVar.bk();
        }
        return super.isReadyStatus();
    }

    @Override // com.bytedance.msdk.c.ux
    public void onDestroy() {
        super.onDestroy();
        k kVar = this.ys;
        if (kVar != null) {
            kVar.xv();
            return;
        }
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27608c;
        if (wVar != null) {
            try {
                wVar.sr();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void onPause() {
        super.onPause();
        k kVar = this.ys;
        if (kVar != null) {
            kVar.c();
            return;
        }
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27608c;
        if (wVar != null) {
            try {
                wVar.w();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void onResume() {
        super.onResume();
        k kVar = this.ys;
        if (kVar != null) {
            kVar.w();
            return;
        }
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27608c;
        if (wVar != null) {
            try {
                wVar.xv();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void pauseAppDownload() {
        ev evVar = this.fz;
        if (evVar != null) {
            evVar.c();
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.msdk.api.sr.c.r.k kVar) {
        registerViewForInteraction(null, viewGroup, list, list2, null, kVar);
    }

    @Override // com.bytedance.msdk.c.ux
    public void render() {
        gd gdVar = this.f27610t;
        if (gdVar != null) {
            gdVar.c();
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void resumeAppDownload() {
        ev evVar = this.fz;
        if (evVar != null) {
            evVar.w();
        }
    }

    @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
    public void setDislikeCallback(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        this.f27611w = cVar;
    }

    @Override // com.bytedance.msdk.c.ux
    public void showAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27608c;
        if (wVar == null || !(wVar instanceof com.bytedance.msdk.api.sr.c.w.w.xv)) {
            return;
        }
        ((com.bytedance.msdk.api.sr.c.w.w.xv) wVar).w(activity);
    }

    @Override // com.bytedance.msdk.c.ux
    public void showSplashAd(ViewGroup viewGroup) {
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27608c;
        if (wVar == null || !(wVar instanceof com.bytedance.msdk.api.sr.c.w.p.w)) {
            return;
        }
        ((com.bytedance.msdk.api.sr.c.w.p.w) wVar).w(viewGroup);
    }

    public com.bytedance.msdk.adapter.w.f sr() {
        return this.f27667a;
    }

    @Override // com.bytedance.msdk.c.ux
    public void unregisterView() {
        sr srVar = this.ux;
        if (srVar != null) {
            srVar.c();
        }
    }

    public com.bytedance.msdk.api.sr.c.xv.w ux() {
        return this.f27676k;
    }

    public com.bytedance.msdk.api.sr.c.r.gd w() {
        return this.f27681r;
    }

    public com.bytedance.msdk.api.sr.c.w xv() {
        return this.ev;
    }

    public void c(gd gdVar) {
        this.f27610t = gdVar;
    }

    @Override // com.bytedance.msdk.c.ux
    public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.sr.c.r.k kVar) {
        sr srVar = this.ux;
        if (srVar != null) {
            srVar.c(activity, viewGroup, list, list2, list3, kVar);
        }
    }

    public void c(k kVar) {
        this.ys = kVar;
    }

    public void c(f fVar) {
        this.fp = fVar;
    }

    public void c(p pVar) {
        this.ia = pVar;
    }

    public void c(com.bytedance.msdk.api.sr.c.w.ev.ux uxVar) {
        this.f27609s = uxVar;
    }

    public void c(ev evVar) {
        this.fz = evVar;
    }

    public void c(com.bytedance.msdk.api.sr.c.w.w.w wVar) {
        this.f27608c = wVar;
    }

    public void c(t tVar) {
        this.sr = tVar;
    }

    public com.bytedance.msdk.api.sr.c.r.xv c() {
        return this.f27671f;
    }

    public void c(r rVar) {
        this.xv = rVar;
    }

    public final void c(String str) {
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27608c;
        if (wVar != null) {
            wVar.c(this, str);
        }
    }
}
