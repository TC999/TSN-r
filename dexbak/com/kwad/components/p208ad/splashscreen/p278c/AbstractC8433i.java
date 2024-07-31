package com.kwad.components.p208ad.splashscreen.p278c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.components.p208ad.splashscreen.p284f.AbstractC8483a;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.splashscreen.c.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8433i extends C8421e implements InterfaceC10385c {

    /* renamed from: le */
    private static long f27755le = 400;

    /* renamed from: Dt */
    private AbstractC8483a f27756Dt;

    /* renamed from: eh */
    private Vibrator f27757eh;

    /* renamed from: lp */
    private void m30737lp() {
        C8489h c8489h = this.f27734Dg;
        if (c8489h != null) {
            AbstractC8483a abstractC8483a = this.f27756Dt;
            if (abstractC8483a == null) {
                this.f27756Dt = new AbstractC8483a(getContext(), this.f27734Dg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.c.i.1
                    {
                        super(r3);
                    }

                    @Override // com.kwad.components.p208ad.splashscreen.p284f.AbstractC8483a
                    @SuppressLint({"SetTextI18n"})
                    /* renamed from: k */
                    public final void mo30633k(int i, String str) {
                        AbstractC8433i.this.mo30728j(i, str);
                    }
                };
            } else {
                abstractC8483a.setAdTemplate(c8489h.mAdTemplate);
            }
            C8619c c8619c = this.f27734Dg.mApkDownloadHelper;
            if (c8619c != null) {
                c8619c.m30151b(this.f27756Dt);
            }
        }
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        if (this.f27734Dg.f27884Cv) {
            return;
        }
        mo30724lm();
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        mo30723ln();
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public void mo24610aj() {
        super.mo24610aj();
        C8489h c8489h = this.f27734Dg;
        if (c8489h == null) {
            return;
        }
        AdInfo m25641dQ = C10487e.m25641dQ(c8489h.mAdTemplate);
        mo30725ll();
        mo30727lj();
        if (C10483a.m25956aF(m25641dQ)) {
            m30737lp();
        }
        mo30726lk();
        mo30722lo();
        this.f27734Dg.f27881Cs.mo26187a(this);
    }

    protected abstract void initView();

    /* renamed from: j */
    protected abstract void mo30728j(int i, String str);

    /* renamed from: lj */
    protected abstract void mo30727lj();

    /* renamed from: lk */
    protected abstract void mo30726lk();

    /* renamed from: ll */
    protected abstract void mo30725ll();

    /* renamed from: lm */
    protected abstract void mo30724lm();

    /* renamed from: ln */
    protected abstract void mo30723ln();

    /* renamed from: lo */
    protected abstract void mo30722lo();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: lq */
    public final void m30736lq() {
        Context context = getContext();
        if (context != null) {
            this.f27757eh = (Vibrator) context.getSystemService("vibrator");
        }
        C11064bn.m23863a(getContext(), this.f27757eh);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.f27734Dg.f27881Cs.mo26186b(this);
        mo30723ln();
        C11064bn.m23861b(getContext(), this.f27757eh);
    }
}
