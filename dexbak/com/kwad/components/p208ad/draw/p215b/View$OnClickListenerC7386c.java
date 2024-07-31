package com.kwad.components.p208ad.draw.p215b;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p330s.C8951n;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.draw.p214a.C7357a;
import com.kwad.components.p208ad.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.ad.draw.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7386c extends C7357a implements View.OnClickListener {

    /* renamed from: co */
    private ViewGroup f25334co;

    /* renamed from: cp */
    private TextView f25335cp;

    /* renamed from: cq */
    private TextView f25336cq;

    /* renamed from: cr */
    private TextView f25337cr;

    /* renamed from: cs */
    private DrawDownloadProgressBar f25338cs;

    /* renamed from: ct */
    private ValueAnimator f25339ct;

    /* renamed from: cu */
    private int f25340cu;

    /* renamed from: cv */
    private int f25341cv;

    /* renamed from: cw */
    private int f25342cw;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    @Nullable
    private C8619c mApkDownloadHelper;
    private KsLogoView mLogoView;
    private InterfaceC9001k mVideoPlayStateListener = new C9002l() { // from class: com.kwad.components.ad.draw.b.c.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            if (j2 >= View$OnClickListenerC7386c.this.f25342cw * 1000) {
                View$OnClickListenerC7386c.this.f25273bO.f25276ch.m33408ap();
            } else if (j2 >= View$OnClickListenerC7386c.this.f25341cv * 1000) {
                View$OnClickListenerC7386c.this.m33371an();
            } else if (j2 >= View$OnClickListenerC7386c.this.f25340cu * 1000) {
                View$OnClickListenerC7386c.this.m33373al();
            }
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
        }
    };

    /* renamed from: cx */
    private KsAppDownloadListener f25343cx = new AbstractC10298a() { // from class: com.kwad.components.ad.draw.b.c.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            View$OnClickListenerC7386c.this.f25337cr.setText(C10483a.m25957aE(View$OnClickListenerC7386c.this.mAdInfo));
            View$OnClickListenerC7386c.this.f25338cs.m33337e(C10483a.m25957aE(View$OnClickListenerC7386c.this.mAdInfo), View$OnClickListenerC7386c.this.f25338cs.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            View$OnClickListenerC7386c.this.f25337cr.setText(C10483a.m25882bY(View$OnClickListenerC7386c.this.mAdTemplate));
            View$OnClickListenerC7386c.this.f25338cs.m33337e(C10483a.m25882bY(View$OnClickListenerC7386c.this.mAdTemplate), View$OnClickListenerC7386c.this.f25338cs.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            View$OnClickListenerC7386c.this.f25337cr.setText(C10483a.m25957aE(View$OnClickListenerC7386c.this.mAdInfo));
            View$OnClickListenerC7386c.this.f25338cs.m33337e(C10483a.m25957aE(View$OnClickListenerC7386c.this.mAdInfo), View$OnClickListenerC7386c.this.f25338cs.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            View$OnClickListenerC7386c.this.f25337cr.setText(C10483a.m25933ac(View$OnClickListenerC7386c.this.mAdInfo));
            View$OnClickListenerC7386c.this.f25338cs.m33337e(C10483a.m25933ac(View$OnClickListenerC7386c.this.mAdInfo), View$OnClickListenerC7386c.this.f25338cs.getMax());
        }

        @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
        public final void onPaused(int i) {
            super.onPaused(i);
            View$OnClickListenerC7386c.this.f25337cr.setText(C10483a.m25980Fg());
            View$OnClickListenerC7386c.this.f25338cs.m33337e(C10483a.m25980Fg(), i);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            TextView textView = View$OnClickListenerC7386c.this.f25337cr;
            textView.setText(i + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = View$OnClickListenerC7386c.this.f25338cs;
            drawDownloadProgressBar.m33337e(i + "%", i);
        }
    };

    /* renamed from: ak */
    private void m33374ak() {
        this.f25340cu = C10483a.m25865bo(this.mAdInfo);
        this.f25341cv = C10483a.m25864bp(this.mAdInfo);
        this.f25342cw = C10483a.m25863bq(this.mAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: al */
    public void m33373al() {
        if (this.f25337cr.getVisibility() == 0 || this.f25338cs.getVisibility() == 0) {
            return;
        }
        this.f25337cr.setOnClickListener(this);
        this.f25337cr.setVisibility(0);
        TextView textView = this.f25337cr;
        ValueAnimator m29528b = C8951n.m29528b(textView, 0, C10751a.m24924a(textView.getContext(), 44.0f));
        this.f25339ct = m29528b;
        m29528b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f25339ct.setDuration(300L);
        this.f25339ct.start();
    }

    /* renamed from: am */
    private void m33372am() {
        ValueAnimator valueAnimator = this.f25339ct;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f25339ct.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: an */
    public void m33371an() {
        if (this.f25338cs.getVisibility() == 0) {
            return;
        }
        this.f25338cs.setOnClickListener(this);
        this.f25338cs.setVisibility(0);
        this.f25337cr.setVisibility(8);
    }

    @Override // com.kwad.components.p208ad.draw.p214a.C7357a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AdTemplate adTemplate = this.f25273bO.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        this.mApkDownloadHelper = this.f25273bO.mApkDownloadHelper;
        m33374ak();
        this.mLogoView.m28912aD(this.mAdTemplate);
        this.f25337cr.setText(C10483a.m25957aE(this.mAdInfo));
        this.f25337cr.setVisibility(8);
        this.f25338cs.m33337e(C10483a.m25957aE(this.mAdInfo), this.f25338cs.getMax());
        this.f25338cs.setVisibility(8);
        this.f25334co.setVisibility(0);
        this.f25334co.setOnClickListener(this);
        if (C10483a.m25956aF(this.mAdInfo)) {
            this.f25335cp.setText(C10483a.m25914av(this.mAdInfo));
            this.f25335cp.setVisibility(0);
            C8619c c8619c = this.mApkDownloadHelper;
            if (c8619c != null) {
                c8619c.m30151b(this.f25343cx);
            }
        } else {
            this.f25335cp.setVisibility(8);
        }
        this.f25336cq.setText(C10483a.m25915au(this.mAdInfo));
        this.f25273bO.f25275bP.mo31843b(this.mVideoPlayStateListener);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f25334co) {
            m33371an();
            m33375a(false, 2);
        } else if (view == this.f25337cr) {
            m33371an();
            m33375a(true, 1);
        } else if (view == this.f25338cs) {
            m33375a(true, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25334co = (ViewGroup) findViewById(C9659R.C9662id.ksad_ad_normal_container);
        this.f25335cp = (TextView) findViewById(C9659R.C9662id.ksad_ad_normal_title);
        this.f25336cq = (TextView) findViewById(C9659R.C9662id.ksad_ad_normal_des);
        this.mLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_ad_normal_logo);
        this.f25337cr = (TextView) findViewById(C9659R.C9662id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(C9659R.C9662id.ksad_ad_light_convert_btn);
        this.f25338cs = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        KsAppDownloadListener ksAppDownloadListener;
        super.onUnbind();
        m33372am();
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null && (ksAppDownloadListener = this.f25343cx) != null) {
            c8619c.m30148c(ksAppDownloadListener);
        }
        this.f25273bO.f25275bP.mo31844a(this.mVideoPlayStateListener);
    }

    /* renamed from: a */
    private void m33375a(boolean z, int i) {
        C8615a.m30233a(new C8615a.C8616a(this.f25334co.getContext()).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30205an(i).m30202ao(z).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.draw.b.c.3
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                C9908c.m27349a(View$OnClickListenerC7386c.this.mAdTemplate, 1, View$OnClickListenerC7386c.this.f25273bO.mRootContainer.getTouchCoords());
                if (View$OnClickListenerC7386c.this.f25273bO.f25274bN != null) {
                    View$OnClickListenerC7386c.this.f25273bO.f25274bN.onAdClicked();
                }
            }
        }));
    }
}
