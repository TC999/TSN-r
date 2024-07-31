package com.kwad.components.p208ad.reward.presenter.p266b;

import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;
import com.kwad.components.p208ad.reward.presenter.C8094b;

/* renamed from: com.kwad.components.ad.reward.presenter.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8095a extends C8094b {

    /* renamed from: tN */
    private AdLiveHandleClickListener f26958tN = new AdLiveHandleClickListener() { // from class: com.kwad.components.ad.reward.presenter.b.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i) {
            if (i == 1) {
                C8095a.this.f26957qo.m32060a(1, C8095a.this.getContext(), 115, 1);
            } else if (i == 2) {
                C8095a.this.f26957qo.m32060a(1, C8095a.this.getContext(), 117, 1);
            }
        }
    };

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        IAdLiveOfflineView iAdLiveOfflineView = this.f26957qo.f26530oK;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.registerClickListener(this.f26958tN);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        IAdLiveOfflineView iAdLiveOfflineView = this.f26957qo.f26530oK;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.unRegisterClickListener(this.f26958tN);
        }
    }
}
