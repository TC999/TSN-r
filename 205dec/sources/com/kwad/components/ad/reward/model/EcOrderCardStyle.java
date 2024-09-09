package com.kwad.components.ad.reward.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public enum EcOrderCardStyle {
    SPIKE_AND_COUPON(1),
    SPIKE(2),
    COUPON(3),
    NO_SPIKE_AND_NO_COUPON(4),
    DEFAULT(5);
    
    private int value;

    EcOrderCardStyle(int i4) {
        this.value = i4;
    }

    @Nullable
    public static EcOrderCardStyle createFromAdInfo(AdInfo adInfo) {
        if (com.kwad.components.ad.reward.a.b.k(adInfo) || com.kwad.components.ad.reward.a.b.j(adInfo)) {
            AdProductInfo cP = com.kwad.sdk.core.response.b.a.cP(adInfo);
            boolean hasSpike = cP.hasSpike();
            boolean hasCoupon = cP.hasCoupon();
            boolean hasOriginalPrice = cP.hasOriginalPrice();
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
