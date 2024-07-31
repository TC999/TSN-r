package com.mbridge.msdk.mbbid.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.mbbid.common.AreaBidCommon;
import com.mbridge.msdk.mbbid.common.p491a.RequesManager;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BidManager {

    /* renamed from: a */
    private RequesManager f31241a;

    /* renamed from: b */
    private BidListennning f31242b;

    /* renamed from: c */
    private boolean f31243c;

    public BidManager(String str, String str2) {
        this(str, str2, "0");
    }

    public static String getBuyerUid(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return AreaBidCommon.m21703a(context, str);
    }

    public void bid() {
        RequesManager requesManager = this.f31241a;
        if (requesManager != null) {
            requesManager.m21689b(this.f31243c);
            return;
        }
        BidListennning bidListennning = this.f31242b;
        if (bidListennning != null) {
            bidListennning.onFailed("you need init the class :BidManager");
        }
    }

    public void setBidListener(BidListennning bidListennning) {
        this.f31242b = bidListennning;
        RequesManager requesManager = this.f31241a;
        if (requesManager != null) {
            requesManager.m21695a(bidListennning);
        }
    }

    public void setRewardPlus(boolean z) {
        this.f31243c = z;
    }

    public BidManager(String str, String str2, String str3) {
        this.f31243c = false;
        this.f31241a = new RequesManager(str, str2, str3);
    }

    public static String getBuyerUid(Context context) {
        return AreaBidCommon.m21703a(context, "");
    }

    public <T extends CommonBidRequestParams> BidManager(T t) {
        this(t == null ? "" : t.getmPlacementId(), t == null ? "" : t.getmUnitId(), t != null ? t.getmFloorPrice() : "");
        if (t instanceof BannerBidRequestParams) {
            BannerBidRequestParams bannerBidRequestParams = (BannerBidRequestParams) t;
            this.f31241a.m21701a(bannerBidRequestParams.getHeight());
            this.f31241a.m21691b(bannerBidRequestParams.getWidth());
            this.f31241a.m21692b(296);
            if (t instanceof SplashBidRequestParams) {
                SplashBidRequestParams splashBidRequestParams = (SplashBidRequestParams) t;
                this.f31241a.m21693a(splashBidRequestParams.m21683a());
                this.f31241a.m21702a(splashBidRequestParams.getOrientation());
                this.f31241a.m21692b(297);
            }
        } else if (t instanceof AdvancedNativeBidRequestParams) {
            AdvancedNativeBidRequestParams advancedNativeBidRequestParams = (AdvancedNativeBidRequestParams) t;
            this.f31241a.m21701a(advancedNativeBidRequestParams.getHeight());
            this.f31241a.m21691b(advancedNativeBidRequestParams.getWidth());
            this.f31241a.m21692b(298);
        }
    }
}
