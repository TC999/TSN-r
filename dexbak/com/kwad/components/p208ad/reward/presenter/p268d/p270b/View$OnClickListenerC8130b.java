package com.kwad.components.p208ad.reward.presenter.p268d.p270b;

import android.view.View;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.C8141f;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.reward.presenter.d.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8130b extends C8094b implements View.OnClickListener, InterfaceC8132c {

    /* renamed from: vO */
    private View f27024vO;

    /* renamed from: vP */
    private boolean f27025vP;

    /* renamed from: vQ */
    private final Runnable f27026vQ = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.d.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (View$OnClickListenerC8130b.this.getActivity() == null || View$OnClickListenerC8130b.this.getActivity().isFinishing()) {
                return;
            }
            View$OnClickListenerC8130b.this.m31496iF();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iF */
    public void m31496iF() {
        C10331c.m26254d("RewardPlayEndCloseBtn", "showPageCloseBtn mPlayEndH5ShowSuccess: " + this.f26957qo.f26546pA + ", needHideCloseButton: " + this.f27025vP);
        if (this.f26957qo.f26546pA && this.f27025vP) {
            return;
        }
        this.f27024vO.setVisibility(0);
        this.f27024vO.setAlpha(0.0f);
        this.f27024vO.animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27025vP = C10484b.m25724dQ(C10487e.m25641dQ(this.f26957qo.mAdTemplate));
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p268d.p270b.InterfaceC8132c
    /* renamed from: iE */
    public final void mo31491iE() {
        C7907g c7907g = this.f26957qo;
        if (c7907g.f26561pj) {
            return;
        }
        long j = c7907g.f26572pu;
        if (j == 0) {
            this.f27026vQ.run();
        } else {
            C11064bn.runOnUiThreadDelay(this.f27026vQ, j);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f27024vO) {
            PlayableSource m32008fG = this.f26957qo.m32008fG();
            if (m32008fG != null && (m32008fG.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || m32008fG.equals(PlayableSource.PENDANT_CLICK_AUTO) || m32008fG.equals(PlayableSource.PENDANT_AUTO) || m32008fG.equals(PlayableSource.ACTIONBAR_CLICK))) {
                C7838a.m32198eX().m32197eY();
            } else {
                C8141f.m31458t(this.f26957qo);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View findViewById = findViewById(C9659R.C9662id.ksad_end_close_btn);
        this.f27024vO = findViewById;
        findViewById.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f27024vO.setVisibility(8);
        C11064bn.m23858c(this.f27026vQ);
    }
}
