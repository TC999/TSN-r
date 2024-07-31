package com.kwad.components.p208ad.reward.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.p208ad.reward.p264n.C8074r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.model.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8026a {
    private String liveStartTime;
    @Nullable
    private C8619c mApkDownloadHelper;
    private String originPrice;
    private int playableStyle;
    private String price;

    /* renamed from: qa */
    private String f26754qa;

    /* renamed from: qb */
    private String f26755qb;

    /* renamed from: rP */
    private List<String> f26756rP;

    /* renamed from: rQ */
    private String f26757rQ;

    /* renamed from: rR */
    private String f26758rR;

    /* renamed from: rS */
    private String f26759rS;

    /* renamed from: rT */
    private boolean f26760rT;

    /* renamed from: rU */
    private String f26761rU;

    /* renamed from: rV */
    private String f26762rV = "查看详情";

    /* renamed from: rW */
    private String f26763rW = "立即预约";

    /* renamed from: rX */
    private List<String> f26764rX;
    @Nullable

    /* renamed from: rY */
    private AdTemplate f26765rY;
    private String title;

    @Nullable
    /* renamed from: I */
    public static C8026a m31818I(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        AdProductInfo m25838cP = C10483a.m25838cP(m25641dQ);
        C8026a c8026a = new C8026a();
        String name = m25838cP.getName();
        c8026a.title = name;
        if (TextUtils.isEmpty(name)) {
            c8026a.title = C10483a.m25912ax(m25641dQ);
        }
        c8026a.f26754qa = m25838cP.getIcon();
        c8026a.f26755qb = C10483a.m25915au(m25641dQ);
        c8026a.price = m25838cP.getPrice();
        c8026a.originPrice = m25838cP.getOriginPrice();
        if (!m25838cP.isCouponListEmpty() && (firstCouponList = m25838cP.getFirstCouponList()) != null) {
            c8026a.m31815M(CouponInfo.jinniuFormatCoupon(firstCouponList));
            c8026a.m31816L(firstCouponList.getFormattedJinniuPrefix());
        }
        return c8026a;
    }

    @Nullable
    /* renamed from: J */
    public static C8026a m31817J(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo m25717db = C10484b.m25717db(adTemplate);
        C8026a c8026a = new C8026a();
        c8026a.f26754qa = m25717db.userHeadUrl;
        c8026a.liveStartTime = m25717db.liveStartTime;
        c8026a.title = m25717db.title;
        c8026a.f26760rT = m25717db.needShowSubscriberCount();
        c8026a.f26761rU = m25717db.getFormattedLiveSubscribeCount();
        c8026a.f26764rX = m25717db.bookUserUrlList;
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = m25717db.playEndCard;
        c8026a.f26762rV = liveReservationPlayEndInfo.detailBtnTitle;
        c8026a.f26763rW = liveReservationPlayEndInfo.reservationBtnTitle;
        c8026a.f26765rY = adTemplate;
        return c8026a;
    }

    /* renamed from: L */
    private void m31816L(String str) {
        this.f26758rR = str;
    }

    /* renamed from: M */
    private void m31815M(String str) {
        this.f26759rS = str;
    }

    @Nullable
    /* renamed from: a */
    public static C8026a m31814a(C8074r c8074r, boolean z) {
        AdTemplate adTemplate;
        if (c8074r == null || (adTemplate = c8074r.getAdTemplate()) == null) {
            return null;
        }
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C8026a c8026a = new C8026a();
        c8026a.title = C10483a.m25823cc(m25641dQ);
        c8026a.f26754qa = C10483a.m25820cf(m25641dQ);
        c8026a.f26755qb = C10483a.m25915au(m25641dQ);
        c8026a.f26756rP = C10486d.m25655dH(adTemplate);
        c8026a.f26757rQ = C10483a.m25957aE(m25641dQ);
        c8026a.playableStyle = C10487e.m25623j(adTemplate, z);
        c8026a.f26765rY = adTemplate;
        c8026a.mApkDownloadHelper = c8074r.m31645gZ();
        return c8026a;
    }

    /* renamed from: gW */
    public final String m31813gW() {
        return this.f26759rS;
    }

    /* renamed from: gX */
    public final String m31812gX() {
        return this.f26758rR;
    }

    @Nullable
    /* renamed from: gY */
    public final AdTemplate m31811gY() {
        return this.f26765rY;
    }

    @Nullable
    /* renamed from: gZ */
    public final C8619c m31810gZ() {
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

    /* renamed from: gf */
    public final String m31809gf() {
        return this.f26754qa;
    }

    /* renamed from: gg */
    public final String m31808gg() {
        return this.f26755qb;
    }

    /* renamed from: ha */
    public final List<String> m31807ha() {
        return this.f26756rP;
    }

    /* renamed from: hb */
    public final boolean m31806hb() {
        List<String> list = this.f26756rP;
        return list == null || list.size() == 0;
    }

    /* renamed from: hc */
    public final int m31805hc() {
        return this.playableStyle;
    }

    /* renamed from: hd */
    public final String m31804hd() {
        return this.f26761rU;
    }

    /* renamed from: he */
    public final String m31803he() {
        return this.f26763rW;
    }

    /* renamed from: hf */
    public final boolean m31802hf() {
        return this.f26760rT;
    }

    /* renamed from: hg */
    public final List<String> m31801hg() {
        return this.f26764rX;
    }

    /* renamed from: hh */
    public final String m31800hh() {
        return this.liveStartTime;
    }
}
