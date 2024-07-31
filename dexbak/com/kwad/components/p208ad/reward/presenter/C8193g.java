package com.kwad.components.p208ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.p298i.C8665a;
import com.kwad.components.core.p298i.C8674c;
import com.kwad.sdk.core.p392d.C10274a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.presenter.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8193g extends C8094b implements C8665a.InterfaceC8672a {
    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        boolean m26474DG = C10274a.m26474DG();
        C10331c.m26254d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + m26474DG);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl == null || !m26474DG) {
            return;
        }
        C8665a.m30045a(sceneImpl, this);
    }

    @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
    /* renamed from: e */
    public final void mo30038e(@Nullable List<C8674c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        C10331c.m26254d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean m25747cu = C10484b.m25747cu(adTemplate);
        List<C8665a.InterfaceC8672a> m32006fI = this.f26957qo.m32006fI();
        if (m25747cu) {
            C10274a.m26465e(C10484b.m25750cr(adTemplate), C10484b.m25749cs(adTemplate));
            if (m32006fI != null) {
                for (C8665a.InterfaceC8672a interfaceC8672a : m32006fI) {
                    interfaceC8672a.mo30038e(list);
                }
            }
        }
    }

    @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
    public final void onError(int i, String str) {
        List<C8665a.InterfaceC8672a> m32006fI = this.f26957qo.m32006fI();
        if (m32006fI != null) {
            for (C8665a.InterfaceC8672a interfaceC8672a : m32006fI) {
                interfaceC8672a.onError(i, str);
            }
        }
    }

    @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
    public final void onRequestResult(int i) {
        List<C8665a.InterfaceC8672a> m32006fI = this.f26957qo.m32006fI();
        if (m32006fI != null) {
            for (C8665a.InterfaceC8672a interfaceC8672a : m32006fI) {
                interfaceC8672a.onRequestResult(i);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
