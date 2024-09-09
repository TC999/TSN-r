package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ae implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdTemplate adTemplate = new AdTemplate();
        aVar.adTemplate = adTemplate;
        adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        aVar.apH = jSONObject.optJSONObject("extData");
        aVar.aoM = jSONObject.optInt("adActionType");
        aVar.apI = jSONObject.optInt("photoPlaySecond");
        aVar.apJ = jSONObject.optInt("awardReceiveStage");
        aVar.kl = jSONObject.optInt("itemClickType");
        aVar.apK = jSONObject.optInt("itemCloseType");
        aVar.apL = jSONObject.optInt("elementType");
        aVar.apM = jSONObject.optString("adRenderArea");
        if (JSONObject.NULL.toString().equals(aVar.apM)) {
            aVar.apM = "";
        }
        aVar.apN = jSONObject.optLong("highestLossPrice");
        aVar.apO = jSONObject.optInt("impFailReason");
        aVar.apP = jSONObject.optLong("winEcpm");
        aVar.adnType = jSONObject.optInt("adnType");
        aVar.adnName = jSONObject.optString("adnName");
        if (JSONObject.NULL.toString().equals(aVar.adnName)) {
            aVar.adnName = "";
        }
        aVar.apQ = jSONObject.optInt("retainCodeType");
        aVar.KI = jSONObject.optInt("photoSizeStyle");
        aVar.KG = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(aVar.KG)) {
            aVar.KG = "";
        }
        aVar.apR = jSONObject.optInt("deeplinkType");
        aVar.apS = jSONObject.optString("deeplinkAppName");
        if (JSONObject.NULL.toString().equals(aVar.apS)) {
            aVar.apS = "";
        }
        aVar.apT = jSONObject.optInt("deeplinkFailedReason");
        aVar.downloadSource = jSONObject.optInt("downloadSource");
        aVar.apU = jSONObject.optInt("isPackageChanged");
        aVar.apV = jSONObject.optString("installedFrom");
        if (JSONObject.NULL.toString().equals(aVar.apV)) {
            aVar.apV = "";
        }
        aVar.apW = jSONObject.optString("downloadFailedReason");
        if (JSONObject.NULL.toString().equals(aVar.apW)) {
            aVar.apW = "";
        }
        aVar.apX = jSONObject.optInt("isChangedEndcard");
        aVar.apY = jSONObject.optInt("adAggPageSource");
        aVar.apZ = jSONObject.optString("serverPackageName");
        if (JSONObject.NULL.toString().equals(aVar.apZ)) {
            aVar.apZ = "";
        }
        aVar.aqa = jSONObject.optString("installedPackageName");
        if (JSONObject.NULL.toString().equals(aVar.aqa)) {
            aVar.aqa = "";
        }
        aVar.aqb = jSONObject.optInt("closeButtonImpressionTime");
        aVar.aqc = jSONObject.optInt("closeButtonClickTime");
        aVar.aqd = jSONObject.optLong("landingPageLoadedDuration");
        aVar.Li = jSONObject.optLong("leaveTime");
        aVar.aqe = jSONObject.optLong("adItemClickBackDuration");
        aVar.aqf = jSONObject.optInt("appStorePageType");
        aVar.aqg = jSONObject.optInt("installStatus");
        aVar.downloadStatus = jSONObject.optInt("downloadStatus");
        aVar.aqh = jSONObject.optInt("downloadCardType");
        a.C0688a c0688a = new a.C0688a();
        aVar.KH = c0688a;
        c0688a.parseJson(jSONObject.optJSONObject("clientExtData"));
        aVar.Om = jSONObject.optInt("landingPageType");
        aVar.vz = jSONObject.optLong("playedDuration");
        aVar.aqi = jSONObject.optInt("playedRate");
        aVar.aqj = jSONObject.optInt("adOrder");
        aVar.KF = jSONObject.optInt("adInterstitialSource");
        aVar.ko = jSONObject.optDouble("splashShakeAcceleration");
        aVar.aqk = jSONObject.optString("splashInteractionRotateAngle");
        if (JSONObject.NULL.toString().equals(aVar.aqk)) {
            aVar.aqk = "";
        }
        aVar.aql = jSONObject.optInt("downloadInstallType");
        aVar.aqm = jSONObject.optInt("businessSceneType");
        aVar.adxResult = jSONObject.optInt("adxResult");
        aVar.aqn = jSONObject.optInt("fingerSwipeType");
        aVar.aqo = jSONObject.optInt("fingerSwipeDistance");
        aVar.KJ = jSONObject.optInt("triggerType");
        aVar.aqp = jSONObject.optInt("cardCloseType");
        aVar.aqq = jSONObject.optString("clientPkFailAdInfo");
        if (JSONObject.NULL.toString().equals(aVar.aqq)) {
            aVar.aqq = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", aVar.adTemplate);
        com.kwad.sdk.utils.t.putValue(jSONObject, "extData", aVar.apH);
        int i4 = aVar.aoM;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adActionType", i4);
        }
        int i5 = aVar.apI;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoPlaySecond", i5);
        }
        int i6 = aVar.apJ;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "awardReceiveStage", i6);
        }
        int i7 = aVar.kl;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemClickType", i7);
        }
        int i8 = aVar.apK;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemCloseType", i8);
        }
        int i9 = aVar.apL;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "elementType", i9);
        }
        String str = aVar.apM;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adRenderArea", aVar.apM);
        }
        long j4 = aVar.apN;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "highestLossPrice", j4);
        }
        int i10 = aVar.apO;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "impFailReason", i10);
        }
        long j5 = aVar.apP;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "winEcpm", j5);
        }
        int i11 = aVar.adnType;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adnType", i11);
        }
        String str2 = aVar.adnName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adnName", aVar.adnName);
        }
        int i12 = aVar.apQ;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainCodeType", i12);
        }
        int i13 = aVar.KI;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoSizeStyle", i13);
        }
        String str3 = aVar.KG;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", aVar.KG);
        }
        int i14 = aVar.apR;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkType", i14);
        }
        String str4 = aVar.apS;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkAppName", aVar.apS);
        }
        int i15 = aVar.apT;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkFailedReason", i15);
        }
        int i16 = aVar.downloadSource;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadSource", i16);
        }
        int i17 = aVar.apU;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isPackageChanged", i17);
        }
        String str5 = aVar.apV;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installedFrom", aVar.apV);
        }
        String str6 = aVar.apW;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadFailedReason", aVar.apW);
        }
        int i18 = aVar.apX;
        if (i18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isChangedEndcard", i18);
        }
        int i19 = aVar.apY;
        if (i19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAggPageSource", i19);
        }
        String str7 = aVar.apZ;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "serverPackageName", aVar.apZ);
        }
        String str8 = aVar.aqa;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installedPackageName", aVar.aqa);
        }
        int i20 = aVar.aqb;
        if (i20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeButtonImpressionTime", i20);
        }
        int i21 = aVar.aqc;
        if (i21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeButtonClickTime", i21);
        }
        long j6 = aVar.aqd;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageLoadedDuration", j6);
        }
        long j7 = aVar.Li;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leaveTime", j7);
        }
        long j8 = aVar.aqe;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adItemClickBackDuration", j8);
        }
        int i22 = aVar.aqf;
        if (i22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStorePageType", i22);
        }
        int i23 = aVar.aqg;
        if (i23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installStatus", i23);
        }
        int i24 = aVar.downloadStatus;
        if (i24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadStatus", i24);
        }
        int i25 = aVar.aqh;
        if (i25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadCardType", i25);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clientExtData", aVar.KH);
        int i26 = aVar.Om;
        if (i26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageType", i26);
        }
        long j9 = aVar.vz;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playedDuration", j9);
        }
        int i27 = aVar.aqi;
        if (i27 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playedRate", i27);
        }
        int i28 = aVar.aqj;
        if (i28 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adOrder", i28);
        }
        int i29 = aVar.KF;
        if (i29 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adInterstitialSource", i29);
        }
        double d4 = aVar.ko;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "splashShakeAcceleration", d4);
        }
        String str9 = aVar.aqk;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "splashInteractionRotateAngle", aVar.aqk);
        }
        int i30 = aVar.aql;
        if (i30 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadInstallType", i30);
        }
        int i31 = aVar.aqm;
        if (i31 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "businessSceneType", i31);
        }
        int i32 = aVar.adxResult;
        if (i32 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adxResult", i32);
        }
        int i33 = aVar.aqn;
        if (i33 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fingerSwipeType", i33);
        }
        int i34 = aVar.aqo;
        if (i34 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fingerSwipeDistance", i34);
        }
        int i35 = aVar.KJ;
        if (i35 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "triggerType", i35);
        }
        int i36 = aVar.aqp;
        if (i36 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardCloseType", i36);
        }
        String str10 = aVar.aqq;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clientPkFailAdInfo", aVar.aqq);
        }
        return jSONObject;
    }
}
