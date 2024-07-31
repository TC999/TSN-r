package com.kwad.components.p208ad.draw.p215b.p218c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.p208ad.draw.p214a.C7357a;
import com.kwad.components.p208ad.draw.p214a.C7358b;
import com.kwad.components.p208ad.p247k.C7824b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;

/* renamed from: com.kwad.components.ad.draw.b.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7392b extends C7357a {

    /* renamed from: cR */
    private InterfaceC10635a f25350cR = new InterfaceC10635a() { // from class: com.kwad.components.ad.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
        /* renamed from: a */
        public final void mo25245a(C10640a c10640a) {
            if (C7392b.this.f25273bO.f25274bN != null) {
                C7392b.this.f25273bO.f25274bN.onAdClicked();
            }
        }
    };
    @Nullable

    /* renamed from: ci */
    private C7824b f25351ci;

    /* renamed from: da */
    private FrameLayout f25352da;

    @Override // com.kwad.components.p208ad.draw.p214a.C7357a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7824b c7824b = this.f25273bO.f25277ci;
        this.f25351ci = c7824b;
        if (c7824b == null) {
            return;
        }
        c7824b.m32220a(this.f25350cR);
        C7824b c7824b2 = this.f25351ci;
        FrameLayout frameLayout = this.f25352da;
        C7358b c7358b = this.f25273bO;
        c7824b2.m32226a(frameLayout, c7358b.mRootContainer, c7358b.mAdTemplate, c7358b.mApkDownloadHelper);
        this.f25351ci.m32223a((C7824b.InterfaceC7829b) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25352da = (FrameLayout) findViewById(C9659R.C9662id.ksad_play_end_web_card_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C7824b c7824b = this.f25351ci;
        if (c7824b != null) {
            c7824b.m32213lW();
        }
    }
}
