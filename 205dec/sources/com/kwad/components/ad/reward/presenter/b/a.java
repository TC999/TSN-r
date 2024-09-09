package com.kwad.components.ad.reward.presenter.b;

import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b {
    private AdLiveHandleClickListener tN = new AdLiveHandleClickListener() { // from class: com.kwad.components.ad.reward.presenter.b.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i4) {
            if (i4 == 1) {
                a.this.qo.a(1, a.this.getContext(), 115, 1);
            } else if (i4 == 2) {
                a.this.qo.a(1, a.this.getContext(), 117, 1);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        IAdLiveOfflineView iAdLiveOfflineView = this.qo.oK;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.registerClickListener(this.tN);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        IAdLiveOfflineView iAdLiveOfflineView = this.qo.oK;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.unRegisterClickListener(this.tN);
        }
    }
}
