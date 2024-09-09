package com.kwad.components.ad.fullscreen.c;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.fullscreen.c.a.e;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements j {
    private View hc;
    private View hd;
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.c.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            c.this.i(false);
        }
    };

    public c() {
        a(new e());
        a(new com.kwad.components.ad.fullscreen.c.b.a());
    }

    private void bX() {
        com.kwad.components.ad.reward.g gVar = this.qo;
        if (gVar.pa || gVar.oZ) {
            return;
        }
        this.hc.setVisibility(0);
        this.hd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z3) {
        com.kwad.components.ad.reward.g gVar = this.qo;
        if ((gVar.pa || gVar.oZ) && !z3) {
            this.hc.setVisibility(8);
            this.hd.setVisibility(8);
            return;
        }
        this.hc.setVisibility(8);
        this.hd.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qo.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eX().a(this);
        this.hc.setVisibility(0);
        this.hd.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        bX();
        if (this.qo.oZ && this.hd.getVisibility() == 0) {
            this.hd.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
        i(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hc = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.hd = findViewById(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eX().b(this);
    }
}
