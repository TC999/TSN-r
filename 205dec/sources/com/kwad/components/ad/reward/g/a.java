package com.kwad.components.ad.reward.g;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.b.g;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends d implements g {
    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return g.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.g
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        b.a(ksScene, new c(ksScene.getPosId(), rewardVideoAdListener));
    }

    @Override // com.kwad.components.ad.b.g
    public final void notifyRewardVerify() {
        com.kwad.components.ad.reward.b.fb().notifyRewardVerify();
    }
}
