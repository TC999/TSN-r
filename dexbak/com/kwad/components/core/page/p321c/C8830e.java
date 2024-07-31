package com.kwad.components.core.page.p321c;

import android.app.Activity;
import com.kwad.components.core.page.p323d.C8839a;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;

/* renamed from: com.kwad.components.core.page.c.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8830e extends AbstractC8828c {
    private C8839a mPlayModule;
    private InterfaceC9001k mVideoPlayStateListener = new C9002l() { // from class: com.kwad.components.core.page.c.e.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayError(int i, int i2) {
            Activity activity = C8830e.this.f28603OB.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
        }
    };

    @Override // com.kwad.components.core.page.p321c.AbstractC8828c, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C8839a c8839a = this.f28603OB.mPlayModule;
        this.mPlayModule = c8839a;
        c8839a.m29761a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mPlayModule.m29758b(this.mVideoPlayStateListener);
    }
}
