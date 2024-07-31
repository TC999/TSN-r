package com.kwad.components.p208ad.fullscreen.p229c.p230a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.p409b.C10486d;

/* renamed from: com.kwad.components.ad.fullscreen.c.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7616b extends C8094b implements View.OnClickListener {

    /* renamed from: gO */
    private C9002l f25872gO = new C9002l() { // from class: com.kwad.components.ad.fullscreen.c.a.b.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            View$OnClickListenerC7616b.this.m32764g(j2);
        }
    };

    /* renamed from: hl */
    private TextView f25873hl;

    /* renamed from: hm */
    private String f25874hm;

    /* renamed from: hn */
    private long f25875hn;
    private C8619c mApkDownloadHelper;

    /* renamed from: ca */
    private void m32767ca() {
        this.f25875hn = C10486d.m25660dC(this.mAdTemplate);
        String m25659dD = C10486d.m25659dD(this.mAdTemplate);
        this.f25874hm = m25659dD;
        if (TextUtils.isEmpty(m25659dD)) {
            return;
        }
        C7907g c7907g = this.f26957qo;
        this.mApkDownloadHelper = c7907g.mApkDownloadHelper;
        c7907g.f26529oJ.m31828a(this.f25872gO);
    }

    /* renamed from: cb */
    private void m32766cb() {
        if (this.f25873hl.getVisibility() == 0) {
            return;
        }
        this.f25873hl.setText(C10486d.m25659dD(this.mAdTemplate));
        this.f25873hl.setVisibility(0);
        this.f25873hl.setOnClickListener(this);
        m32765cc();
    }

    /* renamed from: cc */
    private void m32765cc() {
        C9908c.m27337b(this.mAdTemplate, 18, this.f26957qo.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m32764g(long j) {
        if (j >= this.f25875hn) {
            m32766cb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        C9908c.m27340a(this.mAdTemplate, new C9913b().m27247f(this.f26957qo.mRootContainer.getTouchCoords()).m27266cK(40), this.f26957qo.mReportExtData);
        this.f26957qo.f26528oI.mo32088bJ();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        m32767ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f25873hl) {
            C8615a.m30233a(new C8615a.C8616a(view.getContext()).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30207am(40).m30209al(1).m30202ao(false).m30213af(this.f26957qo.m31993fz()).m30205an(1).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.fullscreen.c.a.b.2
                @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                public final void onAdClicked() {
                    View$OnClickListenerC7616b.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25873hl = (TextView) findViewById(C9659R.C9662id.ksad_detail_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.f25873hl = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (TextUtils.isEmpty(this.f25874hm)) {
            return;
        }
        this.f26957qo.f26529oJ.m31826b(this.f25872gO);
    }
}
