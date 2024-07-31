package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;
import java.util.List;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdProductInfo extends C10482a implements Serializable {
    private static final long serialVersionUID = -7038691521398433079L;
    public List<CouponInfo> couponList;
    public String icon;
    public String name;
    public String originPrice;
    public String price;
    public String rating;
    public SpikeInfo seckillInfo;
    public String volume;

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class SpikeInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = -4379476990559885495L;
        public long endTime;
        public int originalStock;
        public int soldStock;
    }

    public List<CouponInfo> getCouponList() {
        return this.couponList;
    }

    @Nullable
    public CouponInfo getFirstCouponList() {
        if (isCouponListEmpty()) {
            return null;
        }
        return this.couponList.get(0);
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String getOriginPrice() {
        return this.originPrice;
    }

    public String getPrice() {
        return this.price;
    }

    public String getRating() {
        return this.rating;
    }

    public String getVolume() {
        return this.volume;
    }

    public boolean hasCoupon() {
        return !isCouponListEmpty();
    }

    public boolean hasOriginalPrice() {
        return !TextUtils.isEmpty(this.originPrice);
    }

    public boolean hasSpike() {
        SpikeInfo spikeInfo = this.seckillInfo;
        return spikeInfo != null && spikeInfo.endTime > 0;
    }

    public boolean isCouponListEmpty() {
        List<CouponInfo> list = this.couponList;
        return list == null || list.size() == 0;
    }
}
