package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j extends b {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        try {
            this.qo.oJ.jI();
        } catch (Throwable th) {
            bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.presenter.j.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    ServiceProvider.reportSdkCaughtException(th);
                    j.this.hp();
                }
            });
        }
    }
}
