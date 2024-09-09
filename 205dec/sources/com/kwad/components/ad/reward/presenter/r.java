package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class r extends b implements com.kwad.components.ad.reward.e.g, com.kwad.components.ad.reward.e.j, aq.b {
    private com.kwad.components.core.webview.tachikoma.e.e gX;
    private float sC;
    private boolean sR;
    @Nullable
    private a sS;
    @Nullable
    private q sT;
    @Nullable
    private o sU;
    private p sV;
    private int sW;
    private boolean sX;
    private boolean sY;
    private boolean sZ;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class a extends com.kwad.components.core.video.l {
        private long tb;
        private long videoDuration;

        private a() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            super.onMediaPlayProgress(j4, j5);
            this.tb = j5;
            this.videoDuration = j4;
            if (r.this.qo.fx()) {
                return;
            }
            r.this.a(j4, j5, false);
        }

        /* synthetic */ a(r rVar, byte b4) {
            this();
        }
    }

    public r(AdTemplate adTemplate, boolean z3, boolean z4) {
        this.sW = 0;
        this.sX = false;
        this.sY = z3;
        this.sZ = z4;
        if (com.kwad.sdk.core.response.b.a.bH(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            p pVar = new p();
            this.sV = pVar;
            a(pVar);
        }
    }

    private com.kwad.components.core.webview.tachikoma.e.e bV() {
        if (this.gX == null) {
            this.gX = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.reward.presenter.r.2
                @Override // com.kwad.components.core.webview.tachikoma.e.b
                public final void q(String str) {
                    r.this.hE();
                }
            };
        }
        return this.gX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hE() {
        if (this.sZ) {
            q qVar = new q(this);
            this.sT = qVar;
            a((Presenter) qVar, true);
        }
        if (this.sY) {
            o oVar = new o(this);
            this.sU = oVar;
            a((Presenter) oVar, true);
        }
    }

    private boolean hF() {
        return this.sR;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bH(dQ)) {
            if (!this.qo.oZ) {
                bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.components.ad.reward.presenter.r.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        r.this.hE();
                    }
                }, 100L);
            } else {
                com.kwad.components.core.webview.tachikoma.d.b.tc().a(bV());
            }
        } else if (!com.kwad.sdk.core.response.b.a.bK(dQ)) {
            com.kwad.components.core.o.a.qi().av(this.qo.mAdTemplate);
        }
        this.qo.b(this);
        com.kwad.components.core.playable.a aVar = this.qo.oL;
        if (aVar != null) {
            aVar.a(this);
        }
        boolean gw = com.kwad.components.ad.reward.a.b.gw();
        this.sC = com.kwad.components.ad.reward.a.b.gv();
        if (gw) {
            a aVar2 = new a(this, (byte) 0);
            this.sS = aVar2;
            com.kwad.components.ad.reward.m.e eVar = this.qo.oJ;
            if (eVar != null) {
                eVar.a(aVar2);
            }
        }
        com.kwad.components.ad.reward.a.eX().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        RewardActionBarControl.ShowActionBarResult ig = this.qo.oM.ig();
        if (ig != null) {
            ig.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.sV == null || this.qo.fH()) {
            return;
        }
        if (hF()) {
            this.sV.e(PlayableSource.PLAY_FINISHED_NORMAL);
        } else {
            this.sV.hz();
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        this.qo.z(false);
        a aVar = this.sS;
        if (aVar == null || this.sW != 2) {
            return;
        }
        a(aVar.videoDuration, this.sS.tb, true);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public final boolean onBackPressed() {
        boolean fL = this.qo.fL();
        if (!this.qo.fx() || fL) {
            return false;
        }
        com.kwad.components.ad.reward.a.eX().eY();
        this.qo.z(false);
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.components.ad.reward.m.e eVar;
        super.onUnbind();
        this.qo.c(this);
        com.kwad.components.core.playable.a aVar = this.qo.oL;
        if (aVar != null) {
            aVar.b(this);
        }
        a aVar2 = this.sS;
        if (aVar2 != null && (eVar = this.qo.oJ) != null) {
            eVar.b(aVar2);
        }
        com.kwad.components.ad.reward.a.eX().b(this);
        com.kwad.components.core.webview.tachikoma.d.b.tc().b(this.gX);
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        a aVar2;
        boolean isSuccess = aVar.isSuccess();
        this.sR = isSuccess;
        if (!isSuccess || (aVar2 = this.sS) == null) {
            return;
        }
        a(aVar2.videoDuration, this.sS.tb, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j4, long j5, boolean z3) {
        q qVar;
        if (hF() && j5 >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT && ((float) j5) >= ((float) j4) * this.sC) {
            if (com.kwad.components.ad.reward.a.b.gx()) {
                if (this.sX || (qVar = this.sT) == null) {
                    return;
                }
                qVar.hA();
                this.sW = 1;
                this.sX = true;
                return;
            }
            o oVar = this.sU;
            if (oVar != null) {
                oVar.H(!z3);
                this.sW = 2;
            }
        }
    }

    public r(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        o oVar;
        q qVar;
        this.qo.z(true);
        int i4 = this.sW;
        if (i4 == 1 && (qVar = this.sT) != null) {
            qVar.hB();
        } else if (i4 != 2 || (oVar = this.sU) == null) {
        } else {
            oVar.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
