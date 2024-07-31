package com.kwad.components.p208ad.reward.presenter.p268d.p270b;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.p409b.C10486d;

/* renamed from: com.kwad.components.ad.reward.presenter.d.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8128a extends C8094b implements View.OnClickListener, InterfaceC8132c {

    /* renamed from: vL */
    private TextView f27021vL;

    /* renamed from: vM */
    private TextView f27022vM;

    /* renamed from: cc */
    private void m31502cc() {
        C7907g c7907g = this.f26957qo;
        C9908c.m27337b(c7907g.mAdTemplate, 17, c7907g.mReportExtData);
    }

    /* renamed from: iB */
    private void m31499iB() {
        String m25658dE = C10486d.m25658dE(this.f26957qo.mAdTemplate);
        if (this.f26957qo.mScreenOrientation == 1) {
            this.f27022vM.setVisibility(8);
            this.f27021vL.setText(m25658dE);
            this.f27021vL.setVisibility(0);
            this.f27021vL.setOnClickListener(this);
        } else {
            this.f27021vL.setVisibility(8);
            this.f27022vM.setText(m25658dE);
            this.f27022vM.setVisibility(0);
            this.f27022vM.setOnClickListener(this);
        }
        m31502cc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iC */
    public void m31498iC() {
        C9913b m27266cK = new C9913b().m27247f(this.f26957qo.mRootContainer.getTouchCoords()).m27266cK(39);
        C7907g c7907g = this.f26957qo;
        C7955b.m31927a(c7907g.mAdTemplate, "native_id", "endTopBar", m27266cK, c7907g.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        this.f26957qo.f26528oI.mo32088bJ();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p268d.p270b.InterfaceC8132c
    /* renamed from: iE */
    public final void mo31491iE() {
        if (this.f26957qo.f26561pj) {
            return;
        }
        m31499iB();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f27021vL || view == this.f27022vM) {
            C8615a.m30233a(new C8615a.C8616a(view.getContext()).m30198aq(this.f26957qo.mAdTemplate).m30189b(this.f26957qo.mApkDownloadHelper).m30202ao(false).m30205an(1).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.reward.presenter.d.b.a.1
                @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                public final void onAdClicked() {
                    View$OnClickListenerC8128a.this.m31498iC();
                    View$OnClickListenerC8128a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27021vL = (TextView) findViewById(C9659R.C9662id.ksad_end_left_call_btn);
        this.f27022vM = (TextView) findViewById(C9659R.C9662id.ksad_end_right_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f27021vL.setVisibility(8);
        this.f27022vM.setVisibility(8);
    }
}
