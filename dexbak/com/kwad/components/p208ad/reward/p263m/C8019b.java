package com.kwad.components.p208ad.reward.p263m;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.components.core.p296g.C8650c;
import com.kwad.components.core.video.InterfaceC8997h;
import com.kwad.components.p208ad.p246j.AbstractC7812a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.m.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8019b extends AbstractC7812a<InterfaceC8997h> implements C7907g.InterfaceC7920a {

    /* renamed from: xK */
    private C8650c f26732xK;

    public C8019b(@NonNull AdTemplate adTemplate) {
        super(adTemplate);
        long m25975M = C10483a.m25975M(C10487e.m25641dQ(adTemplate));
        C8650c c8650c = new C8650c();
        this.f26732xK = c8650c;
        c8650c.m30065z(m25975M);
    }

    /* renamed from: O */
    public final FrameLayout m31845O(Context context) {
        FrameLayout imagePlayerView = this.f26732xK.getImagePlayerView(context);
        this.f26732xK.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
        return imagePlayerView;
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    /* renamed from: a */
    public final void mo31844a(InterfaceC8997h interfaceC8997h) {
        this.f26732xK.m30067d(interfaceC8997h);
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    /* renamed from: b */
    public final void mo31843b(InterfaceC8997h interfaceC8997h) {
        this.f26732xK.m30068c(interfaceC8997h);
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fU */
    public final void mo31309fU() {
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fV */
    public final void mo31308fV() {
        resume();
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fW */
    public final void mo31307fW() {
        pause();
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fX */
    public final void mo31306fX() {
        this.f26732xK.destroy();
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final long getPlayDuration() {
        return this.f26732xK.getPlayDuration();
    }

    /* renamed from: jI */
    public final void m31842jI() {
        this.f26732xK.setURLs(C10483a.m25879ba(C10487e.m25641dQ(this.mAdTemplate)));
        this.f26732xK.play();
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void pause() {
        this.f26732xK.pause();
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void release() {
        super.release();
        this.f26732xK.destroy();
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void resume() {
        this.f26732xK.resume();
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void skipToEnd() {
        this.f26732xK.skipToEnd();
    }
}
