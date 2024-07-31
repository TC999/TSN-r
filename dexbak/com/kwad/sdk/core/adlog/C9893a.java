package com.kwad.sdk.core.adlog;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.mikephil.charting.utils.Utils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.adlog.p388c.C9912a;
import com.kwad.sdk.core.network.AbstractC10410b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11126t;
import com.p518qq.p519e.comm.p520pi.IBidding;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.adlog.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9893a extends AbstractC10410b {
    int apa;
    @NonNull
    private final C9912a apb;
    private final AdTemplate mAdTemplate;

    @KsJson
    /* renamed from: com.kwad.sdk.core.adlog.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9894a extends C10482a {
        public String apd;
        public int ape;
        public int apf;
        public int apg;
        public JSONObject aph;
        public int api;
        public int apj;
        @Nullable
        public AdTrackLog apk;
        public String templateId;
        public int apc = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int showLiveStyle = -1;

        /* renamed from: a */
        public final AdTrackLog m27412a(AdTemplate adTemplate, String str, String str2, InterfaceC10761a<AdTrackLog> interfaceC10761a) {
            InterfaceC10970h interfaceC10970h;
            if (adTemplate == null || (interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)) == null || !interfaceC10970h.mo24304yT()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.apk = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            if (interfaceC10761a != null) {
                interfaceC10761a.accept(this.apk);
            }
            return this.apk;
        }

        @Override // com.kwad.sdk.core.response.p408a.C10482a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i = this.apc;
            if (i != -1) {
                C11126t.putValue(jSONObject, "shield_reason", i);
            }
            long j = this.duration;
            if (j != -1) {
                C11126t.putValue(jSONObject, "duration", j);
            }
            int i2 = this.showLiveStatus;
            if (i2 != -1) {
                C11126t.putValue(jSONObject, "show_live_status", i2);
            }
            int i3 = this.showLiveStyle;
            if (i3 != -1) {
                C11126t.putValue(jSONObject, "show_live_style", i3);
            }
            AdTrackLog adTrackLog = this.apk;
            if (adTrackLog != null) {
                C11126t.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
            }
            JSONObject jSONObject2 = this.aph;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, this.aph.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C9893a(@NonNull C9912a c9912a) {
        this.apb = c9912a;
        this.mAdTemplate = c9912a.adTemplate;
        this.apa = c9912a.aoM;
    }

    /* renamed from: Be */
    private void m27418Be() {
        JSONObject jSONObject = this.apb.apH;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "clientTimestamp", System.currentTimeMillis());
        putBody("extData", jSONObject.toString());
    }

    /* renamed from: a */
    private void m27417a(String str, @Nullable C9912a c9912a) {
        if (c9912a == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = c9912a.aqj;
        if (i >= 0) {
            putBody("adOrder", i);
        }
        int i2 = c9912a.f29521KF;
        if (i2 >= 0) {
            putBody("adInterstitialSource", i2);
        }
        if (!TextUtils.isEmpty(c9912a.apM)) {
            putBody("adRenderArea", c9912a.apM);
        }
        putBody("adxResult", c9912a.adxResult);
        int i3 = c9912a.aqn;
        if (i3 != 0) {
            putBody("fingerSwipeType", i3);
        }
        int i4 = c9912a.aqo;
        if (i4 != 0) {
            putBody("fingerSwipeDistance", i4);
        }
        int i5 = c9912a.aqg;
        if (i5 != -1) {
            putBody("installStatus", i5);
        }
        C9894a c9894a = c9912a.f29523KH;
        if (c9894a != null) {
            putBody("clientExtData", c9894a.toJson().toString());
        }
        String str2 = c9912a.aqq;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i6 = c9912a.f29525KJ;
        if (i6 != -1) {
            putBody("triggerType", i6);
        }
        int i7 = c9912a.f29524KI;
        if (i7 != 0) {
            putBody("photoSizeStyle", i7);
        }
    }

    /* renamed from: b */
    private void m27415b(String str, @Nullable C9912a c9912a) {
        if (c9912a == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = c9912a.f29528kl;
        if (i != 0) {
            putBody("itemClickType", i);
        }
        if (!TextUtils.isEmpty(c9912a.f29522KG)) {
            putBody("payload", c9912a.f29522KG);
        }
        int i2 = c9912a.apY;
        if (i2 != 0) {
            putBody("adAggPageSource", i2);
        }
        int i3 = c9912a.aqj;
        if (i3 >= 0) {
            putBody("adOrder", i3);
        }
        int i4 = c9912a.f29521KF;
        if (i4 >= 0) {
            putBody("adInterstitialSource", i4);
        }
        int i5 = c9912a.f29525KJ;
        if (i5 != -1) {
            putBody("triggerType", i5);
        }
        int i6 = c9912a.aqp;
        if (i6 != 0) {
            putBody("cardCloseType", i6);
        }
        putBody("adxResult", c9912a.adxResult);
        double d = c9912a.f29530ko;
        if (d > Utils.DOUBLE_EPSILON) {
            putBody("splashShakeAcceleration", d);
        }
        if (!TextUtils.isEmpty(c9912a.aqk)) {
            putBody("splashInteractionRotateAngle", c9912a.aqk);
        }
        int i7 = c9912a.aqn;
        if (i7 != 0) {
            putBody("fingerSwipeType", i7);
        }
        int i8 = c9912a.aqo;
        if (i8 != 0) {
            putBody("fingerSwipeDistance", i8);
        }
        long j = c9912a.f29531vz;
        if (j > 0) {
            putBody("playedDuration", j);
        }
        int i9 = c9912a.aqi;
        if (i9 > 0) {
            putBody("playedRate", i9);
        }
        String str2 = c9912a.aqq;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i10 = c9912a.apQ;
        if (i10 != -1) {
            putBody("retainCodeType", i10);
        }
        C9894a c9894a = c9912a.f29523KH;
        if (c9894a != null) {
            putBody("clientExtData", c9894a.toJson().toString());
        }
        int i11 = c9912a.f29524KI;
        if (i11 != 0) {
            putBody("photoSizeStyle", i11);
        }
    }

    /* renamed from: c */
    private void m27414c(String str, @Nullable C9912a c9912a) {
        if (c9912a == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = c9912a.apK;
        if (i != 0) {
            putBody("itemCloseType", i);
        }
        int i2 = c9912a.apI;
        if (i2 > 0) {
            putBody("photoPlaySecond", i2);
        }
        int i3 = c9912a.apJ;
        if (i3 != 0) {
            putBody("awardReceiveStage", i3);
        }
        int i4 = c9912a.apL;
        if (i4 != 0) {
            putBody("elementType", i4);
        }
        if (!TextUtils.isEmpty(c9912a.f29522KG)) {
            putBody("payload", c9912a.f29522KG);
        }
        C9894a c9894a = c9912a.f29523KH;
        if (c9894a != null) {
            putBody("clientExtData", c9894a.toJson().toString());
        }
        int i5 = c9912a.apR;
        if (i5 > 0) {
            putBody("deeplinkType", i5);
        }
        if (!TextUtils.isEmpty(c9912a.apS)) {
            putBody("deeplinkAppName", c9912a.apS);
        }
        int i6 = c9912a.apT;
        if (i6 != 0) {
            putBody("deeplinkFailedReason", i6);
        }
        int i7 = c9912a.downloadSource;
        if (i7 > 0) {
            putBody("downloadSource", i7);
        }
        int i8 = c9912a.aqp;
        if (i8 != 0) {
            putBody("cardCloseType", i8);
        }
        int i9 = c9912a.apU;
        if (i9 > 0) {
            putBody("isPackageChanged", i9);
        }
        putBody("installedFrom", c9912a.apV);
        putBody("isChangedEndcard", c9912a.apX);
        int i10 = c9912a.apY;
        if (i10 != 0) {
            putBody("adAggPageSource", i10);
        }
        String str2 = c9912a.apW;
        if (str2 != null) {
            putBody("downloadFailedReason", str2);
        }
        if (!C11053bg.isNullString(c9912a.aqa)) {
            putBody("installedPackageName", c9912a.aqa);
        }
        if (!C11053bg.isNullString(c9912a.apZ)) {
            putBody("serverPackageName", c9912a.apZ);
        }
        int i11 = c9912a.aqc;
        if (i11 > 0) {
            putBody("closeButtonClickTime", i11);
        }
        int i12 = c9912a.aqb;
        if (i12 > 0) {
            putBody("closeButtonImpressionTime", i12);
        }
        int i13 = c9912a.downloadStatus;
        if (i13 >= 0) {
            putBody("downloadStatus", i13);
        }
        long j = c9912a.aqd;
        if (j > 0) {
            putBody("landingPageLoadedDuration", j);
        }
        long j2 = c9912a.f29526Li;
        if (j2 > 0) {
            putBody("leaveTime", j2);
        }
        long j3 = c9912a.aqe;
        if (j3 > 0) {
            putBody("adItemClickBackDuration", j3);
        }
        int i14 = c9912a.apQ;
        if (i14 != -1) {
            putBody("retainCodeType", i14);
        }
        long j4 = c9912a.apN;
        if (j4 > -1) {
            putBody(IBidding.HIGHEST_LOSS_PRICE, j4);
        }
        int i15 = c9912a.apO;
        if (i15 >= 0) {
            putBody("impFailReason", i15);
        }
        long j5 = c9912a.apP;
        if (j5 > -1) {
            putBody("winEcpm", j5);
        }
        int i16 = c9912a.adnType;
        if (i16 > 0) {
            putBody("adnType", i16);
        }
        if (!TextUtils.isEmpty(c9912a.adnName)) {
            putBody("adnName", c9912a.adnName);
        }
        putBody("downloadCardType", c9912a.aqh);
        putBody("landingPageType", c9912a.f29527Om);
        int i17 = c9912a.f29521KF;
        if (i17 >= 0) {
            putBody("adInterstitialSource", i17);
        }
        int i18 = c9912a.aql;
        if (i18 > 0) {
            putBody("downloadInstallType", i18);
        }
        int i19 = c9912a.aqn;
        if (i19 != 0) {
            putBody("fingerSwipeType", i19);
        }
        int i20 = c9912a.aqo;
        if (i20 != 0) {
            putBody("fingerSwipeDistance", i20);
        }
        int i21 = c9912a.aqm;
        if (i21 > 0) {
            putBody("businessSceneType", i21);
        }
        long j6 = c9912a.f29531vz;
        if (j6 > 0) {
            putBody("playedDuration", j6);
        }
        int i22 = c9912a.aqi;
        if (i22 > 0) {
            putBody("playedRate", i22);
        }
        int i23 = c9912a.aqf;
        if (i23 != -1) {
            putBody("appStorePageType", i23);
        }
        int i24 = c9912a.f29525KJ;
        if (i24 != -1) {
            putBody("triggerType", i24);
        }
        int i25 = c9912a.f29524KI;
        if (i25 != 0) {
            putBody("photoSizeStyle", i25);
        }
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final String getUrl() {
        String replaceFirst;
        String replaceFirst2;
        Context context = ServiceProvider.getContext();
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        int i = this.apa;
        if (i == 1) {
            String str = m25641dQ.adBaseInfo.showUrl;
            if (this.mAdTemplate.mBidEcpm == 0 && ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24315yI()) {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(C10483a.m25944aR(C10487e.m25641dQ(this.mAdTemplate))));
            } else {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm));
            }
            replaceFirst = replaceFirst2.replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            m27417a(replaceFirst, this.apb);
            m27416a(replaceFirst, this.mAdTemplate, this.apb);
        } else if (i == 2) {
            replaceFirst = C11008ac.m24155am(context, C11008ac.m24156a(m25641dQ.adBaseInfo.clickUrl, this.apb.f29529kn)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            m27415b(replaceFirst, this.apb);
            m27416a(replaceFirst, this.mAdTemplate, this.apb);
        } else {
            replaceFirst = m25641dQ.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            m27414c(replaceFirst, this.apb);
        }
        m27418Be();
        return replaceFirst;
    }

    /* renamed from: a */
    private void m27416a(String str, AdTemplate adTemplate, @Nullable C9912a c9912a) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i = adTemplate.mInitVoiceStatus;
        if (i != 0) {
            putBody("initVoiceStatus", i);
        }
        if (this.mAdTemplate.mBidEcpm == 0) {
            putBody("ecpmType", 2);
        } else {
            putBody("ecpmType", 1);
        }
        if (c9912a == null) {
            return;
        }
        int i2 = c9912a.apY;
        if (i2 != 0) {
            putBody("adAggPageSource", i2);
        }
        if (TextUtils.isEmpty(c9912a.f29522KG)) {
            return;
        }
        putBody("payload", c9912a.f29522KG);
    }
}
