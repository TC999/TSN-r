package com.mbridge.msdk.mbbid.out;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.mbbid.common.a;
import com.mbridge.msdk.mbbid.common.a.b;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BidManager {

    /* renamed from: a  reason: collision with root package name */
    private b f40015a;

    /* renamed from: b  reason: collision with root package name */
    private BidListennning f40016b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f40017c;

    public BidManager(String str, String str2) {
        this(str, str2, "0");
    }

    public static String getBuyerUid(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return a.a(context, str);
    }

    public void bid() {
        b bVar = this.f40015a;
        if (bVar != null) {
            bVar.b(this.f40017c);
            return;
        }
        BidListennning bidListennning = this.f40016b;
        if (bidListennning != null) {
            bidListennning.onFailed("you need init the class :BidManager");
        }
    }

    public void setBidListener(BidListennning bidListennning) {
        this.f40016b = bidListennning;
        b bVar = this.f40015a;
        if (bVar != null) {
            bVar.a(bidListennning);
        }
    }

    public void setRewardPlus(boolean z3) {
        this.f40017c = z3;
    }

    public BidManager(String str, String str2, String str3) {
        this.f40017c = false;
        this.f40015a = new b(str, str2, str3);
    }

    public static String getBuyerUid(Context context) {
        return a.a(context, "");
    }

    public <T extends CommonBidRequestParams> BidManager(T t3) {
        this(t3 == null ? "" : t3.getmPlacementId(), t3 == null ? "" : t3.getmUnitId(), t3 != null ? t3.getmFloorPrice() : "");
        if (t3 instanceof BannerBidRequestParams) {
            BannerBidRequestParams bannerBidRequestParams = (BannerBidRequestParams) t3;
            this.f40015a.a(bannerBidRequestParams.getHeight());
            this.f40015a.b(bannerBidRequestParams.getWidth());
            this.f40015a.b(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL);
            if (t3 instanceof SplashBidRequestParams) {
                SplashBidRequestParams splashBidRequestParams = (SplashBidRequestParams) t3;
                this.f40015a.a(splashBidRequestParams.a());
                this.f40015a.a(splashBidRequestParams.getOrientation());
                this.f40015a.b(MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT);
            }
        } else if (t3 instanceof AdvancedNativeBidRequestParams) {
            AdvancedNativeBidRequestParams advancedNativeBidRequestParams = (AdvancedNativeBidRequestParams) t3;
            this.f40015a.a(advancedNativeBidRequestParams.getHeight());
            this.f40015a.b(advancedNativeBidRequestParams.getWidth());
            this.f40015a.b(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX);
        }
    }
}
