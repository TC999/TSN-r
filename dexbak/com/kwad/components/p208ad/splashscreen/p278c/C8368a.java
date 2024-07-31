package com.kwad.components.p208ad.splashscreen.p278c;

import android.view.View;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;

/* renamed from: com.kwad.components.ad.splashscreen.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8368a extends C8421e implements InterfaceC11145c {

    /* renamed from: CV */
    private View f27637CV;

    /* renamed from: CW */
    private boolean f27638CW;

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        this.f27734Dg.m30618c(1, view.getContext(), 53, 2);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C8489h c8489h = this.f27734Dg;
        if (c8489h == null) {
            return;
        }
        this.f27638CW = C10486d.m25657dF(c8489h.mAdTemplate);
        boolean m30597n = C8489h.m30597n(C10487e.m25641dQ(this.f27734Dg.mAdTemplate));
        this.f27637CV.setVisibility(m30597n ? 0 : 8);
        if (m30597n) {
            new GestureDetector$OnGestureListenerC11148f(this.f27637CV.getContext(), this.f27637CV, this);
        }
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        C10331c.m26254d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.f27638CW);
        if (this.f27638CW) {
            this.f27734Dg.m30618c(1, view.getContext(), 153, 2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27637CV = findViewById(C9659R.C9662id.ksad_splash_actionbar_full_screen);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
