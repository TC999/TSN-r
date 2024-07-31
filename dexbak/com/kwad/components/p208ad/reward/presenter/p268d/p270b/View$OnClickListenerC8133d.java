package com.kwad.components.p208ad.reward.presenter.p268d.p270b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.p208ad.reward.C7845b;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7892l;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.presenter.d.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8133d extends C8094b implements View.OnClickListener, InterfaceC8132c {

    /* renamed from: vW */
    private static final String[] f27028vW = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    private final InterfaceC7892l mRewardVerifyListener = new InterfaceC7892l() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7892l
        public final void onRewardVerify() {
            if (C7907g.m32062G(View$OnClickListenerC8133d.this.f26957qo.mAdTemplate)) {
                View$OnClickListenerC8133d.this.m31489iH();
            }
        }
    };

    /* renamed from: vS */
    private ViewGroup f27029vS;

    /* renamed from: vT */
    private ImageView f27030vT;

    /* renamed from: vU */
    private ViewGroup f27031vU;

    /* renamed from: vV */
    private TextView f27032vV;

    /* renamed from: ca */
    private void m31492ca() {
        C7845b.m32173fb().m32175a(this.mRewardVerifyListener);
        this.f27029vS.setVisibility(0);
        this.f27031vU.setVisibility(C7907g.m32062G(this.f26957qo.mAdTemplate) ? 0 : 8);
    }

    /* renamed from: iG */
    private void m31490iG() {
        ImageView imageView = this.f27030vT;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f27030vT.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.f27029vS;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.f27029vS.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iH */
    public void m31489iH() {
        this.f27032vV.setText(f27028vW[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        C9913b m27266cK = new C9913b().m27247f(this.f26957qo.mRootContainer.getTouchCoords()).m27266cK(41);
        C7907g c7907g = this.f26957qo;
        C7955b.m31927a(c7907g.mAdTemplate, (String) null, (String) null, m27266cK, c7907g.mReportExtData);
        this.f26957qo.f26528oI.mo32088bJ();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        m31492ca();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p268d.p270b.InterfaceC8132c
    /* renamed from: iE */
    public final void mo31491iE() {
        C7907g c7907g = this.f26957qo;
        if (c7907g.f26561pj) {
            if (C10483a.m25917as(C10487e.m25641dQ(c7907g.mAdTemplate))) {
                this.f27031vU.setVisibility(8);
            }
        } else if (!C7907g.m32065E(c7907g.mAdTemplate) && !C7907g.m32063F(this.f26957qo.mAdTemplate)) {
            if (this.f26957qo.m32001fN()) {
                m31490iG();
            }
        } else if (this.f26957qo.m32001fN()) {
        } else {
            this.f27032vV.setText(this.f26957qo.f26556pe ? f27028vW[1] : f27028vW[0]);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f27030vT || view == this.f27029vS) {
            C8615a.m30233a(new C8615a.C8616a(view.getContext()).m30198aq(this.f26957qo.mAdTemplate).m30189b(this.f26957qo.mApkDownloadHelper).m30202ao(false).m30205an(2).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.2
                @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                public final void onAdClicked() {
                    View$OnClickListenerC8133d.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27029vS = (ViewGroup) findViewById(C9659R.C9662id.ksad_end_reward_icon_layout);
        this.f27030vT = (ImageView) findViewById(C9659R.C9662id.ksad_end_reward_icon);
        this.f27031vU = (ViewGroup) findViewById(C9659R.C9662id.ksad_detail_reward_deep_task_view_playend);
        this.f27032vV = (TextView) findViewById(C9659R.C9662id.ksad_reward_deep_task_count_down_playend);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C7845b.m32173fb().m32174b(this.mRewardVerifyListener);
        this.f27029vS.setVisibility(8);
        this.f27030vT.setVisibility(8);
        this.f27031vU.setVisibility(8);
    }
}
