package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private String liveStartTime;
    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String originPrice;
    private int playableStyle;
    private String price;

    /* renamed from: qa  reason: collision with root package name */
    private String f38644qa;
    private String qb;
    private List<String> rP;
    private String rQ;
    private String rR;
    private String rS;
    private boolean rT;
    private String rU;
    private String rV = "\u67e5\u770b\u8be6\u60c5";
    private String rW = "\u7acb\u5373\u9884\u7ea6";
    private List<String> rX;
    @Nullable
    private AdTemplate rY;
    private String title;

    @Nullable
    public static a I(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo dQ = e.dQ(adTemplate);
        AdProductInfo cP = com.kwad.sdk.core.response.b.a.cP(dQ);
        a aVar = new a();
        String name = cP.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.b.a.ax(dQ);
        }
        aVar.f38644qa = cP.getIcon();
        aVar.qb = com.kwad.sdk.core.response.b.a.au(dQ);
        aVar.price = cP.getPrice();
        aVar.originPrice = cP.getOriginPrice();
        if (!cP.isCouponListEmpty() && (firstCouponList = cP.getFirstCouponList()) != null) {
            aVar.M(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.L(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    @Nullable
    public static a J(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo db = com.kwad.sdk.core.response.b.b.db(adTemplate);
        a aVar = new a();
        aVar.f38644qa = db.userHeadUrl;
        aVar.liveStartTime = db.liveStartTime;
        aVar.title = db.title;
        aVar.rT = db.needShowSubscriberCount();
        aVar.rU = db.getFormattedLiveSubscribeCount();
        aVar.rX = db.bookUserUrlList;
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = db.playEndCard;
        aVar.rV = liveReservationPlayEndInfo.detailBtnTitle;
        aVar.rW = liveReservationPlayEndInfo.reservationBtnTitle;
        aVar.rY = adTemplate;
        return aVar;
    }

    private void L(String str) {
        this.rR = str;
    }

    private void M(String str) {
        this.rS = str;
    }

    @Nullable
    public static a a(r rVar, boolean z3) {
        AdTemplate adTemplate;
        if (rVar == null || (adTemplate = rVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo dQ = e.dQ(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.b.a.cc(dQ);
        aVar.f38644qa = com.kwad.sdk.core.response.b.a.cf(dQ);
        aVar.qb = com.kwad.sdk.core.response.b.a.au(dQ);
        aVar.rP = com.kwad.sdk.core.response.b.d.dH(adTemplate);
        aVar.rQ = com.kwad.sdk.core.response.b.a.aE(dQ);
        aVar.playableStyle = e.j(adTemplate, z3);
        aVar.rY = adTemplate;
        aVar.mApkDownloadHelper = rVar.gZ();
        return aVar;
    }

    public final String gW() {
        return this.rS;
    }

    public final String gX() {
        return this.rR;
    }

    @Nullable
    public final AdTemplate gY() {
        return this.rY;
    }

    @Nullable
    public final com.kwad.components.core.e.d.c gZ() {
        return this.mApkDownloadHelper;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String gf() {
        return this.f38644qa;
    }

    public final String gg() {
        return this.qb;
    }

    public final List<String> ha() {
        return this.rP;
    }

    public final boolean hb() {
        List<String> list = this.rP;
        return list == null || list.size() == 0;
    }

    public final int hc() {
        return this.playableStyle;
    }

    public final String hd() {
        return this.rU;
    }

    public final String he() {
        return this.rW;
    }

    public final boolean hf() {
        return this.rT;
    }

    public final List<String> hg() {
        return this.rX;
    }

    public final String hh() {
        return this.liveStartTime;
    }
}
