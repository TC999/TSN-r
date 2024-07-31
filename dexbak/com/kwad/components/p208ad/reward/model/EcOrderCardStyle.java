package com.kwad.components.p208ad.reward.model;

import androidx.annotation.Nullable;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.p409b.C10483a;

/* renamed from: com.kwad.components.ad.reward.model.EcOrderCardStyle */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public enum EcOrderCardStyle {
    SPIKE_AND_COUPON(1),
    SPIKE(2),
    COUPON(3),
    NO_SPIKE_AND_NO_COUPON(4),
    DEFAULT(5);
    
    private int value;

    EcOrderCardStyle(int i) {
        this.value = i;
    }

    @Nullable
    public static EcOrderCardStyle createFromAdInfo(AdInfo adInfo) {
        if (C7844b.m32176k(adInfo) || C7844b.m32177j(adInfo)) {
            AdProductInfo m25838cP = C10483a.m25838cP(adInfo);
            boolean hasSpike = m25838cP.hasSpike();
            boolean hasCoupon = m25838cP.hasCoupon();
            boolean hasOriginalPrice = m25838cP.hasOriginalPrice();
            if (hasSpike && hasCoupon) {
                return SPIKE_AND_COUPON;
            }
            if (hasSpike) {
                return SPIKE;
            }
            if (hasCoupon) {
                return COUPON;
            }
            if (hasOriginalPrice) {
                return NO_SPIKE_AND_NO_COUPON;
            }
            return DEFAULT;
        }
        return null;
    }

    public final int getValue() {
        return this.value;
    }
}
