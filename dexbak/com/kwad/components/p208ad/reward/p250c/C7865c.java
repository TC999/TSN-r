package com.kwad.components.p208ad.reward.p250c;

import com.kwad.sdk.api.KsRewardVideoAd;
import java.lang.reflect.Method;

/* renamed from: com.kwad.components.ad.reward.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7865c {
    /* renamed from: a */
    public static void m32128a(C7864b c7864b, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (rewardAdInteractionListener == null || c7864b == null) {
            return;
        }
        try {
            rewardAdInteractionListener.onExtraRewardVerify(c7864b.getType());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: gP */
    public static C7864b m32126gP() {
        return new C7864b(1);
    }

    /* renamed from: a */
    public static boolean m32127a(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (rewardAdInteractionListener == null) {
            return false;
        }
        try {
            for (Method method : rewardAdInteractionListener.getClass().getMethods()) {
                if ("onExtraRewardVerify".equals(method.getName())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
