package com.kwad.components.p208ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.reward.presenter.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8210j extends C8094b {
    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        try {
            this.f26957qo.f26529oJ.m31824jI();
        } catch (Throwable th) {
            C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.j.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    ServiceProvider.reportSdkCaughtException(th);
                    C8210j.this.m31613hp();
                }
            });
        }
    }
}
