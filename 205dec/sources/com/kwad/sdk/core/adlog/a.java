package com.kwad.sdk.core.adlog;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.t;
import java.util.Iterator;
import org.json.JSONObject;
import xyz.adscope.ad.control.track.AdScopeTrackerTool;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends com.kwad.sdk.core.network.b {
    int apa;
    @NonNull
    private final com.kwad.sdk.core.adlog.c.a apb;
    private final AdTemplate mAdTemplate;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* renamed from: com.kwad.sdk.core.adlog.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0688a extends com.kwad.sdk.core.response.a.a {
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

        public final AdTrackLog a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            h hVar;
            if (adTemplate == null || (hVar = (h) ServiceProvider.get(h.class)) == null || !hVar.yT()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.apk = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            if (aVar != null) {
                aVar.accept(this.apk);
            }
            return this.apk;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i4 = this.apc;
            if (i4 != -1) {
                t.putValue(jSONObject, "shield_reason", i4);
            }
            long j4 = this.duration;
            if (j4 != -1) {
                t.putValue(jSONObject, "duration", j4);
            }
            int i5 = this.showLiveStatus;
            if (i5 != -1) {
                t.putValue(jSONObject, "show_live_status", i5);
            }
            int i6 = this.showLiveStyle;
            if (i6 != -1) {
                t.putValue(jSONObject, "show_live_style", i6);
            }
            AdTrackLog adTrackLog = this.apk;
            if (adTrackLog != null) {
                t.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
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

    public a(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        this.apb = aVar;
        this.mAdTemplate = aVar.adTemplate;
        this.apa = aVar.aoM;
    }

    private void Be() {
        JSONObject jSONObject = this.apb.apH;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        t.putValue(jSONObject, "clientTimestamp", System.currentTimeMillis());
        putBody("extData", jSONObject.toString());
    }

    private void a(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i4 = aVar.aqj;
        if (i4 >= 0) {
            putBody("adOrder", i4);
        }
        int i5 = aVar.KF;
        if (i5 >= 0) {
            putBody("adInterstitialSource", i5);
        }
        if (!TextUtils.isEmpty(aVar.apM)) {
            putBody("adRenderArea", aVar.apM);
        }
        putBody("adxResult", aVar.adxResult);
        int i6 = aVar.aqn;
        if (i6 != 0) {
            putBody("fingerSwipeType", i6);
        }
        int i7 = aVar.aqo;
        if (i7 != 0) {
            putBody("fingerSwipeDistance", i7);
        }
        int i8 = aVar.aqg;
        if (i8 != -1) {
            putBody("installStatus", i8);
        }
        C0688a c0688a = aVar.KH;
        if (c0688a != null) {
            putBody("clientExtData", c0688a.toJson().toString());
        }
        String str2 = aVar.aqq;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i9 = aVar.KJ;
        if (i9 != -1) {
            putBody("triggerType", i9);
        }
        int i10 = aVar.KI;
        if (i10 != 0) {
            putBody("photoSizeStyle", i10);
        }
    }

    private void b(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i4 = aVar.kl;
        if (i4 != 0) {
            putBody("itemClickType", i4);
        }
        if (!TextUtils.isEmpty(aVar.KG)) {
            putBody("payload", aVar.KG);
        }
        int i5 = aVar.apY;
        if (i5 != 0) {
            putBody("adAggPageSource", i5);
        }
        int i6 = aVar.aqj;
        if (i6 >= 0) {
            putBody("adOrder", i6);
        }
        int i7 = aVar.KF;
        if (i7 >= 0) {
            putBody("adInterstitialSource", i7);
        }
        int i8 = aVar.KJ;
        if (i8 != -1) {
            putBody("triggerType", i8);
        }
        int i9 = aVar.aqp;
        if (i9 != 0) {
            putBody("cardCloseType", i9);
        }
        putBody("adxResult", aVar.adxResult);
        double d4 = aVar.ko;
        if (d4 > 0.0d) {
            putBody("splashShakeAcceleration", d4);
        }
        if (!TextUtils.isEmpty(aVar.aqk)) {
            putBody("splashInteractionRotateAngle", aVar.aqk);
        }
        int i10 = aVar.aqn;
        if (i10 != 0) {
            putBody("fingerSwipeType", i10);
        }
        int i11 = aVar.aqo;
        if (i11 != 0) {
            putBody("fingerSwipeDistance", i11);
        }
        long j4 = aVar.vz;
        if (j4 > 0) {
            putBody("playedDuration", j4);
        }
        int i12 = aVar.aqi;
        if (i12 > 0) {
            putBody("playedRate", i12);
        }
        String str2 = aVar.aqq;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i13 = aVar.apQ;
        if (i13 != -1) {
            putBody("retainCodeType", i13);
        }
        C0688a c0688a = aVar.KH;
        if (c0688a != null) {
            putBody("clientExtData", c0688a.toJson().toString());
        }
        int i14 = aVar.KI;
        if (i14 != 0) {
            putBody("photoSizeStyle", i14);
        }
    }

    private void c(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i4 = aVar.apK;
        if (i4 != 0) {
            putBody("itemCloseType", i4);
        }
        int i5 = aVar.apI;
        if (i5 > 0) {
            putBody("photoPlaySecond", i5);
        }
        int i6 = aVar.apJ;
        if (i6 != 0) {
            putBody("awardReceiveStage", i6);
        }
        int i7 = aVar.apL;
        if (i7 != 0) {
            putBody("elementType", i7);
        }
        if (!TextUtils.isEmpty(aVar.KG)) {
            putBody("payload", aVar.KG);
        }
        C0688a c0688a = aVar.KH;
        if (c0688a != null) {
            putBody("clientExtData", c0688a.toJson().toString());
        }
        int i8 = aVar.apR;
        if (i8 > 0) {
            putBody("deeplinkType", i8);
        }
        if (!TextUtils.isEmpty(aVar.apS)) {
            putBody("deeplinkAppName", aVar.apS);
        }
        int i9 = aVar.apT;
        if (i9 != 0) {
            putBody("deeplinkFailedReason", i9);
        }
        int i10 = aVar.downloadSource;
        if (i10 > 0) {
            putBody("downloadSource", i10);
        }
        int i11 = aVar.aqp;
        if (i11 != 0) {
            putBody("cardCloseType", i11);
        }
        int i12 = aVar.apU;
        if (i12 > 0) {
            putBody("isPackageChanged", i12);
        }
        putBody("installedFrom", aVar.apV);
        putBody("isChangedEndcard", aVar.apX);
        int i13 = aVar.apY;
        if (i13 != 0) {
            putBody("adAggPageSource", i13);
        }
        String str2 = aVar.apW;
        if (str2 != null) {
            putBody("downloadFailedReason", str2);
        }
        if (!bg.isNullString(aVar.aqa)) {
            putBody("installedPackageName", aVar.aqa);
        }
        if (!bg.isNullString(aVar.apZ)) {
            putBody("serverPackageName", aVar.apZ);
        }
        int i14 = aVar.aqc;
        if (i14 > 0) {
            putBody("closeButtonClickTime", i14);
        }
        int i15 = aVar.aqb;
        if (i15 > 0) {
            putBody("closeButtonImpressionTime", i15);
        }
        int i16 = aVar.downloadStatus;
        if (i16 >= 0) {
            putBody("downloadStatus", i16);
        }
        long j4 = aVar.aqd;
        if (j4 > 0) {
            putBody("landingPageLoadedDuration", j4);
        }
        long j5 = aVar.Li;
        if (j5 > 0) {
            putBody("leaveTime", j5);
        }
        long j6 = aVar.aqe;
        if (j6 > 0) {
            putBody("adItemClickBackDuration", j6);
        }
        int i17 = aVar.apQ;
        if (i17 != -1) {
            putBody("retainCodeType", i17);
        }
        long j7 = aVar.apN;
        if (j7 > -1) {
            putBody("highestLossPrice", j7);
        }
        int i18 = aVar.apO;
        if (i18 >= 0) {
            putBody("impFailReason", i18);
        }
        long j8 = aVar.apP;
        if (j8 > -1) {
            putBody("winEcpm", j8);
        }
        int i19 = aVar.adnType;
        if (i19 > 0) {
            putBody("adnType", i19);
        }
        if (!TextUtils.isEmpty(aVar.adnName)) {
            putBody("adnName", aVar.adnName);
        }
        putBody("downloadCardType", aVar.aqh);
        putBody("landingPageType", aVar.Om);
        int i20 = aVar.KF;
        if (i20 >= 0) {
            putBody("adInterstitialSource", i20);
        }
        int i21 = aVar.aql;
        if (i21 > 0) {
            putBody("downloadInstallType", i21);
        }
        int i22 = aVar.aqn;
        if (i22 != 0) {
            putBody("fingerSwipeType", i22);
        }
        int i23 = aVar.aqo;
        if (i23 != 0) {
            putBody("fingerSwipeDistance", i23);
        }
        int i24 = aVar.aqm;
        if (i24 > 0) {
            putBody("businessSceneType", i24);
        }
        long j9 = aVar.vz;
        if (j9 > 0) {
            putBody("playedDuration", j9);
        }
        int i25 = aVar.aqi;
        if (i25 > 0) {
            putBody("playedRate", i25);
        }
        int i26 = aVar.aqf;
        if (i26 != -1) {
            putBody("appStorePageType", i26);
        }
        int i27 = aVar.KJ;
        if (i27 != -1) {
            putBody("triggerType", i27);
        }
        int i28 = aVar.KI;
        if (i28 != 0) {
            putBody("photoSizeStyle", i28);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        String replaceFirst;
        String replaceFirst2;
        Context context = ServiceProvider.getContext();
        AdInfo dQ = e.dQ(this.mAdTemplate);
        int i4 = this.apa;
        if (i4 == 1) {
            String str = dQ.adBaseInfo.showUrl;
            if (this.mAdTemplate.mBidEcpm == 0 && ((h) ServiceProvider.get(h.class)).yI()) {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(com.kwad.sdk.core.response.b.a.aR(e.dQ(this.mAdTemplate))));
            } else {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm));
            }
            replaceFirst = replaceFirst2.replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.apb);
            a(replaceFirst, this.mAdTemplate, this.apb);
        } else if (i4 == 2) {
            replaceFirst = ac.am(context, ac.a(dQ.adBaseInfo.clickUrl, this.apb.kn)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.apb);
            a(replaceFirst, this.mAdTemplate, this.apb);
        } else {
            replaceFirst = dQ.adBaseInfo.convUrl.replaceFirst(AdScopeTrackerTool.action, String.valueOf(i4)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(replaceFirst, this.apb);
        }
        Be();
        return replaceFirst;
    }

    private void a(String str, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i4 = adTemplate.mInitVoiceStatus;
        if (i4 != 0) {
            putBody("initVoiceStatus", i4);
        }
        if (this.mAdTemplate.mBidEcpm == 0) {
            putBody("ecpmType", 2);
        } else {
            putBody("ecpmType", 1);
        }
        if (aVar == null) {
            return;
        }
        int i5 = aVar.apY;
        if (i5 != 0) {
            putBody("adAggPageSource", i5);
        }
        if (TextUtils.isEmpty(aVar.KG)) {
            return;
        }
        putBody("payload", aVar.KG);
    }
}
