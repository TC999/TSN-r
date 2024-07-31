package com.kwad.components.p208ad.reward.presenter.platdetail.p275a;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8240b extends C8094b implements View.OnClickListener {

    /* renamed from: gO */
    private C9002l f27228gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            View$OnClickListenerC8240b.this.m31223g(j2);
        }
    };

    /* renamed from: hl */
    private TextView f27229hl;

    /* renamed from: hn */
    private long f27230hn;
    private C8619c mApkDownloadHelper;

    /* renamed from: ca */
    private void m31226ca() {
        this.mApkDownloadHelper = this.f26957qo.mApkDownloadHelper;
        this.f27230hn = C10486d.m25660dC(this.mAdTemplate);
        this.f26957qo.f26529oJ.m31828a(this.f27228gO);
    }

    /* renamed from: cb */
    private void m31225cb() {
        if (this.f27229hl.getVisibility() == 0) {
            return;
        }
        this.f27229hl.setText(C10486d.m25659dD(this.mAdTemplate));
        this.f27229hl.setVisibility(0);
        this.f27229hl.setOnClickListener(this);
        this.f27229hl.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                View$OnClickListenerC8240b.this.m31224cc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cc */
    public void m31224cc() {
        this.f26957qo.m31990x("native_id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m31223g(long j) {
        if (j >= this.f27230hn) {
            m31225cb();
        }
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        m31226ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f27229hl) {
            this.f26957qo.m32059a(1, view.getContext(), 40, 1, this.f26957qo.f26529oJ.getPlayDuration());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        TextView textView = (TextView) findViewById(C9659R.C9662id.ksad_detail_call_btn);
        this.f27229hl = textView;
        textView.setContentDescription("topBarCallLabel");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26529oJ.m31826b(this.f27228gO);
        this.f27229hl.setVisibility(8);
    }
}
