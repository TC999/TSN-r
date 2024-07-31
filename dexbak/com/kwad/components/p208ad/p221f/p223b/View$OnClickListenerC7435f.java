package com.kwad.components.p208ad.p221f.p223b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.p221f.p222a.C7416a;
import com.kwad.components.p208ad.p221f.p222a.C7417b;
import com.kwad.components.p208ad.p221f.p224c.C7459a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.f.b.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7435f extends C7416a implements View.OnClickListener {

    /* renamed from: dE */
    private ImageView f25447dE;

    /* renamed from: dF */
    private TextView f25448dF;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    @Nullable
    private C8619c mApkDownloadHelper;

    /* renamed from: na */
    private ViewGroup f25449na;

    /* renamed from: nb */
    private TextView f25450nb;

    /* renamed from: nc */
    private KsAppDownloadListener f25451nc = new AbstractC10298a() { // from class: com.kwad.components.ad.f.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            View$OnClickListenerC7435f.this.f25450nb.setText(C10483a.m25957aE(View$OnClickListenerC7435f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            View$OnClickListenerC7435f.this.f25450nb.setText(C10483a.m25882bY(View$OnClickListenerC7435f.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            View$OnClickListenerC7435f.this.f25450nb.setText(C10483a.m25957aE(View$OnClickListenerC7435f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            View$OnClickListenerC7435f.this.f25450nb.setText(C10483a.m25933ac(View$OnClickListenerC7435f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
        }
    };

    /* renamed from: G */
    private void m33274G(int i) {
        C7459a c7459a;
        C8615a.C8616a m30189b = new C8615a.C8616a(this.f25449na.getContext()).m30198aq(this.mAdTemplate).m30205an(i).m30189b(this.mApkDownloadHelper);
        C7417b c7417b = this.f25416mN;
        C8615a.m30233a(m30189b.m30158v((c7417b == null || (c7459a = c7417b.f25418mO) == null) ? 0L : c7459a.getPlayDuration()).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.f.b.f.3
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                C9908c.m27349a(View$OnClickListenerC7435f.this.mAdTemplate, 2, View$OnClickListenerC7435f.this.f25416mN.f25417mI.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ex */
    public void m33268ex() {
        KSImageLoader.loadAppIcon(this.f25447dE, C10483a.m25820cf(this.mAdInfo), this.mAdTemplate, 12);
        this.f25448dF.setText(C10483a.m25914av(this.mAdInfo));
        this.f25450nb.setText(C10483a.m25957aE(this.mAdInfo));
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.m30151b(this.f25451nc);
        }
        this.f25449na.setOnClickListener(this);
        this.f25449na.setVisibility(0);
    }

    private void notifyAdClick() {
        this.f25416mN.f25420mw.mo33198l(this.f25449na);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AdTemplate adTemplate = this.f25416mN.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        this.mApkDownloadHelper = this.f25416mN.mApkDownloadHelper;
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.b.f.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                try {
                    View$OnClickListenerC7435f.this.m33268ex();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                    C8571a.reportSdkCaughtException(th);
                }
            }
        };
        this.mVideoPlayStateListener = c9002l;
        this.f25416mN.f25418mO.mo31843b((InterfaceC9001k) c9002l);
        this.f25449na.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f25449na) {
            m33274G(2);
            notifyAdClick();
        } else if (view == this.f25450nb) {
            m33274G(1);
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25449na = (ViewGroup) findViewById(C9659R.C9662id.ksad_video_complete_app_container);
        this.f25447dE = (ImageView) findViewById(C9659R.C9662id.ksad_app_icon);
        this.f25448dF = (TextView) findViewById(C9659R.C9662id.ksad_app_name);
        this.f25450nb = (TextView) findViewById(C9659R.C9662id.ksad_app_download);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.m30148c(this.f25451nc);
        }
    }
}
