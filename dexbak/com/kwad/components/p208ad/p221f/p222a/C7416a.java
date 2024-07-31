package com.kwad.components.p208ad.p221f.p222a;

import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.sdk.mvp.Presenter;

/* renamed from: com.kwad.components.ad.f.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7416a extends Presenter {

    /* renamed from: mN */
    public C7417b f25416mN;
    public InterfaceC9001k mVideoPlayStateListener;

    @Override // com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public void mo24610aj() {
        super.mo24610aj();
        this.f25416mN = (C7417b) m24613Jx();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.f25416mN.f25418mO.mo31844a(this.mVideoPlayStateListener);
    }
}
