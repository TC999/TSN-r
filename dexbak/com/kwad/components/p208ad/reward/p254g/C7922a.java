package com.kwad.components.p208ad.reward.p254g;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.p208ad.p210b.InterfaceC7349g;
import com.kwad.components.p208ad.reward.C7845b;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.AbstractC9863d;

/* renamed from: com.kwad.components.ad.reward.g.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7922a extends AbstractC9863d implements InterfaceC7349g {
    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class getComponentsType() {
        return InterfaceC7349g.class;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7349g
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        C7923b.m31985a(ksScene, new C7930c(ksScene.getPosId(), rewardVideoAdListener));
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7349g
    public final void notifyRewardVerify() {
        C7845b.m32173fb().notifyRewardVerify();
    }
}
