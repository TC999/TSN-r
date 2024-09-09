package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import java.io.Serializable;
import java.text.DecimalFormat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class CouponInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
    private static final float COUPON_DISCOUNT_THRESHOLD = 20.0f;
    public static final String JINNIIU_DISCOUNT = "2";
    public static final String JINNIIU_PRICE_BREAK_DISCOUNT = "1";
    private static final long serialVersionUID = -9143537899646897962L;
    public String displayActionWords;
    public String displayBase;
    public String displayDiscount;
    public String displayName;
    public String displayTitle;
    public String displayType;
    public String displayValue;

    @Nullable
    public static String jinniuFormatCoupon(CouponInfo couponInfo) {
        String str = null;
        if (couponInfo == null) {
            return null;
        }
        String displayType = couponInfo.getDisplayType();
        String rinToYuan = rinToYuan(couponInfo.getDisplayValue());
        displayType.hashCode();
        if (!displayType.equals("1")) {
            if (displayType.equals("2") && !TextUtils.isEmpty(rinToYuan)) {
                try {
                    if (Float.parseFloat(rinToYuan) >= 20.0f) {
                        str = "\u00a5" + rinToYuan;
                    } else {
                        str = couponInfo.getFormattedDisplayDiscount() + "\u6298";
                    }
                    return str;
                } catch (Exception unused) {
                    return str;
                }
            }
            return null;
        }
        String rinToYuan2 = rinToYuan(couponInfo.getDisplayBase());
        if (TextUtils.isEmpty(rinToYuan2) || TextUtils.isEmpty(rinToYuan)) {
            return null;
        }
        if (couponInfo.isNoPreRequirement()) {
            return "\u00a5" + rinToYuan;
        }
        return rinToYuan2 + "\u51cf" + rinToYuan;
    }

    @Nullable
    public static String rinToYuan(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new DecimalFormat("#.#").format(Float.parseFloat(str) / 1000.0f);
        } catch (Exception e4) {
            c.printStackTraceOnly(e4);
            return null;
        }
    }

    public String getDisplayActionWords() {
        return this.displayActionWords;
    }

    public String getDisplayBase() {
        return this.displayBase;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDisplayTitle() {
        return this.displayTitle;
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    @Nullable
    public String getFormattedDisplayDiscount() {
        try {
            return new DecimalFormat("#.#").format(Float.valueOf(this.displayDiscount).floatValue() / 10.0f);
        } catch (Exception e4) {
            c.printStackTraceOnly(e4);
            return null;
        }
    }

    public String getFormattedJinniuPrefix() {
        String displayType = getDisplayType();
        if (isNoPreRequirement()) {
            return "\u5238";
        }
        if ("1".equals(displayType)) {
            return "\u6ee1";
        }
        if ("2".equals(displayType)) {
            return "\u5238";
        }
        return null;
    }

    public boolean isNoPreRequirement() {
        String str = this.displayBase;
        if (str == null) {
            return false;
        }
        try {
            return Float.parseFloat(str) <= 0.0f;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setDisplayDiscount(String str) {
        this.displayDiscount = str;
    }
}
