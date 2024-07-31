package com.kwad.components.p208ad.p221f.p223b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.p221f.p222a.C7416a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.f.b.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7441h extends C7416a implements View.OnClickListener {

    /* renamed from: ng */
    private ViewGroup f25457ng;

    /* renamed from: nh */
    private TextView f25458nh;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ex */
    public void m33262ex() {
        this.f25458nh.setText(C10483a.m25957aE(C10487e.m25641dQ(this.f25416mN.mAdTemplate)));
        this.f25457ng.setOnClickListener(this);
        this.f25457ng.setVisibility(0);
    }

    /* renamed from: ez */
    private void m33261ez() {
        C8615a.m30233a(new C8615a.C8616a(this.f25457ng.getContext()).m30198aq(this.f25416mN.mAdTemplate).m30205an(2).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.f.b.h.2
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                C9908c.m27349a(View$OnClickListenerC7441h.this.f25416mN.mAdTemplate, 2, View$OnClickListenerC7441h.this.f25416mN.f25417mI.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.f25416mN.f25420mw.mo33198l(this.f25457ng);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.b.h.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                View$OnClickListenerC7441h.this.m33262ex();
            }
        };
        this.mVideoPlayStateListener = c9002l;
        this.f25416mN.f25418mO.mo31843b((InterfaceC9001k) c9002l);
        this.f25457ng.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m33261ez();
        notifyAdClick();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25457ng = (ViewGroup) findViewById(C9659R.C9662id.ksad_video_complete_h5_container);
        this.f25458nh = (TextView) findViewById(C9659R.C9662id.ksad_h5_open);
    }
}
