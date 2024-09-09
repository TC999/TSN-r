package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.i.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g extends b implements a.InterfaceC0636a {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        boolean DG = com.kwad.sdk.core.d.a.DG();
        com.kwad.sdk.core.e.c.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + DG);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl == null || !DG) {
            return;
        }
        com.kwad.components.core.i.a.a(sceneImpl, this);
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0636a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.e.c.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean cu = com.kwad.sdk.core.response.b.b.cu(adTemplate);
        List<a.InterfaceC0636a> fI = this.qo.fI();
        if (cu) {
            com.kwad.sdk.core.d.a.e(com.kwad.sdk.core.response.b.b.cr(adTemplate), com.kwad.sdk.core.response.b.b.cs(adTemplate));
            if (fI != null) {
                for (a.InterfaceC0636a interfaceC0636a : fI) {
                    interfaceC0636a.e(list);
                }
            }
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0636a
    public final void onError(int i4, String str) {
        List<a.InterfaceC0636a> fI = this.qo.fI();
        if (fI != null) {
            for (a.InterfaceC0636a interfaceC0636a : fI) {
                interfaceC0636a.onError(i4, str);
            }
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0636a
    public final void onRequestResult(int i4) {
        List<a.InterfaceC0636a> fI = this.qo.fI();
        if (fI != null) {
            for (a.InterfaceC0636a interfaceC0636a : fI) {
                interfaceC0636a.onRequestResult(i4);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
