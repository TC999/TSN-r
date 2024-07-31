package com.kwad.components.p208ad.draw.p219c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.components.p208ad.p246j.C7813b;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.response.p409b.C10490h;
import com.kwad.sdk.core.video.p411a.InterfaceC10522c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11103l;

/* renamed from: com.kwad.components.ad.draw.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7399a extends C7813b {

    /* renamed from: bQ */
    private C9366b f25363bQ;

    /* renamed from: dc */
    private long f25364dc;

    /* renamed from: dd */
    private C9877a f25365dd;

    /* renamed from: de */
    private boolean f25366de;

    /* renamed from: df */
    private final InterfaceC10385c f25367df;
    private Context mContext;

    public C7399a(@NonNull AdTemplate adTemplate, @NonNull C9366b c9366b, @NonNull DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.f25367df = new InterfaceC10385c() { // from class: com.kwad.components.ad.draw.c.a.2
            @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
            /* renamed from: aM */
            public final void mo26182aM() {
                if (C7399a.this.f25365dd == null) {
                    C7399a c7399a = C7399a.this;
                    c7399a.f25365dd = C9877a.m27478bD(c7399a.mAdTemplate);
                    C7399a.this.f26355Hs.m29482a(C7399a.this.f25365dd);
                }
                if (C7399a.this.f25366de) {
                    return;
                }
                C7399a.this.resume();
            }

            @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
            /* renamed from: aN */
            public final void mo26181aN() {
                C7399a.this.pause();
            }
        };
        this.f25364dc = C10483a.m25934ab(C10487e.m25641dQ(this.mAdTemplate));
        this.f25363bQ = c9366b;
        this.mContext = detailVideoView.getContext();
        m33344aL();
        this.f26355Hs.m29476a(new InterfaceC10522c.InterfaceC10527e() { // from class: com.kwad.components.ad.draw.c.a.1
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10527e
            /* renamed from: a */
            public final void mo25501a(InterfaceC10522c interfaceC10522c) {
                try {
                    C7399a.this.start(C11103l.m23772em(C7399a.this.mAdTemplate));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    /* renamed from: aL */
    private void m33344aL() {
        this.f26355Hs.m29480a(new C9878b.C9879a(this.mAdTemplate).m27470cR(C10487e.m25639dS(this.mAdTemplate)).m27469cS(C10490h.m25611b(C10487e.m25640dR(this.mAdTemplate))).m27475a(this.mAdTemplate.mVideoPlayerStatus).m27474b(new C9877a(this.mAdTemplate, System.currentTimeMillis())).m27477Bb(), this.mDetailVideoView);
        this.f26355Hs.prepareAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j) {
        if (this.f25363bQ.mo28897dW()) {
            this.f26355Hs.m29482a(new C9877a(this.mAdTemplate, j));
            this.f26355Hs.start();
        }
    }

    /* renamed from: aJ */
    public final void m33346aJ() {
        long m23772em = C11103l.m23772em(this.mAdTemplate);
        if (this.f26355Hs.m29448rs() == null) {
            m33344aL();
        }
        start(m23772em);
        this.f25363bQ.mo26187a(this.f25367df);
    }

    /* renamed from: aK */
    public final void m33345aK() {
        this.f25365dd = null;
        this.f25363bQ.mo26186b(this.f25367df);
        this.f26355Hs.release();
    }

    /* renamed from: f */
    public final void m33339f(boolean z) {
        this.f25366de = z;
    }

    @Override // com.kwad.components.p208ad.p246j.C7813b, com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void resume() {
        super.resume();
        C8932a.m29575ah(this.mContext).m29576aN(false);
    }
}
