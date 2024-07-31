package com.kwad.sdk.core.p389b.p390a;

import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.p388c.C9912a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.C11126t;
import com.p518qq.p519e.comm.p520pi.IBidding;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ae */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9920ae implements InterfaceC10273d<C9912a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9912a c9912a, JSONObject jSONObject) {
        m27234a(c9912a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9912a c9912a, JSONObject jSONObject) {
        return m27233b(c9912a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27234a(C9912a c9912a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdTemplate adTemplate = new AdTemplate();
        c9912a.adTemplate = adTemplate;
        adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        c9912a.apH = jSONObject.optJSONObject("extData");
        c9912a.aoM = jSONObject.optInt("adActionType");
        c9912a.apI = jSONObject.optInt("photoPlaySecond");
        c9912a.apJ = jSONObject.optInt("awardReceiveStage");
        c9912a.f29528kl = jSONObject.optInt("itemClickType");
        c9912a.apK = jSONObject.optInt("itemCloseType");
        c9912a.apL = jSONObject.optInt("elementType");
        c9912a.apM = jSONObject.optString("adRenderArea");
        if (JSONObject.NULL.toString().equals(c9912a.apM)) {
            c9912a.apM = "";
        }
        c9912a.apN = jSONObject.optLong(IBidding.HIGHEST_LOSS_PRICE);
        c9912a.apO = jSONObject.optInt("impFailReason");
        c9912a.apP = jSONObject.optLong("winEcpm");
        c9912a.adnType = jSONObject.optInt("adnType");
        c9912a.adnName = jSONObject.optString("adnName");
        if (JSONObject.NULL.toString().equals(c9912a.adnName)) {
            c9912a.adnName = "";
        }
        c9912a.apQ = jSONObject.optInt("retainCodeType");
        c9912a.f29524KI = jSONObject.optInt("photoSizeStyle");
        c9912a.f29522KG = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(c9912a.f29522KG)) {
            c9912a.f29522KG = "";
        }
        c9912a.apR = jSONObject.optInt("deeplinkType");
        c9912a.apS = jSONObject.optString("deeplinkAppName");
        if (JSONObject.NULL.toString().equals(c9912a.apS)) {
            c9912a.apS = "";
        }
        c9912a.apT = jSONObject.optInt("deeplinkFailedReason");
        c9912a.downloadSource = jSONObject.optInt("downloadSource");
        c9912a.apU = jSONObject.optInt("isPackageChanged");
        c9912a.apV = jSONObject.optString("installedFrom");
        if (JSONObject.NULL.toString().equals(c9912a.apV)) {
            c9912a.apV = "";
        }
        c9912a.apW = jSONObject.optString("downloadFailedReason");
        if (JSONObject.NULL.toString().equals(c9912a.apW)) {
            c9912a.apW = "";
        }
        c9912a.apX = jSONObject.optInt("isChangedEndcard");
        c9912a.apY = jSONObject.optInt("adAggPageSource");
        c9912a.apZ = jSONObject.optString("serverPackageName");
        if (JSONObject.NULL.toString().equals(c9912a.apZ)) {
            c9912a.apZ = "";
        }
        c9912a.aqa = jSONObject.optString("installedPackageName");
        if (JSONObject.NULL.toString().equals(c9912a.aqa)) {
            c9912a.aqa = "";
        }
        c9912a.aqb = jSONObject.optInt("closeButtonImpressionTime");
        c9912a.aqc = jSONObject.optInt("closeButtonClickTime");
        c9912a.aqd = jSONObject.optLong("landingPageLoadedDuration");
        c9912a.f29526Li = jSONObject.optLong("leaveTime");
        c9912a.aqe = jSONObject.optLong("adItemClickBackDuration");
        c9912a.aqf = jSONObject.optInt("appStorePageType");
        c9912a.aqg = jSONObject.optInt("installStatus");
        c9912a.downloadStatus = jSONObject.optInt("downloadStatus");
        c9912a.aqh = jSONObject.optInt("downloadCardType");
        C9893a.C9894a c9894a = new C9893a.C9894a();
        c9912a.f29523KH = c9894a;
        c9894a.parseJson(jSONObject.optJSONObject("clientExtData"));
        c9912a.f29527Om = jSONObject.optInt("landingPageType");
        c9912a.f29531vz = jSONObject.optLong("playedDuration");
        c9912a.aqi = jSONObject.optInt("playedRate");
        c9912a.aqj = jSONObject.optInt("adOrder");
        c9912a.f29521KF = jSONObject.optInt("adInterstitialSource");
        c9912a.f29530ko = jSONObject.optDouble("splashShakeAcceleration");
        c9912a.aqk = jSONObject.optString("splashInteractionRotateAngle");
        if (JSONObject.NULL.toString().equals(c9912a.aqk)) {
            c9912a.aqk = "";
        }
        c9912a.aql = jSONObject.optInt("downloadInstallType");
        c9912a.aqm = jSONObject.optInt("businessSceneType");
        c9912a.adxResult = jSONObject.optInt("adxResult");
        c9912a.aqn = jSONObject.optInt("fingerSwipeType");
        c9912a.aqo = jSONObject.optInt("fingerSwipeDistance");
        c9912a.f29525KJ = jSONObject.optInt("triggerType");
        c9912a.aqp = jSONObject.optInt("cardCloseType");
        c9912a.aqq = jSONObject.optString("clientPkFailAdInfo");
        if (JSONObject.NULL.toString().equals(c9912a.aqq)) {
            c9912a.aqq = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27233b(C9912a c9912a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.m23678a(jSONObject, "adTemplate", c9912a.adTemplate);
        C11126t.putValue(jSONObject, "extData", c9912a.apH);
        int i = c9912a.aoM;
        if (i != 0) {
            C11126t.putValue(jSONObject, "adActionType", i);
        }
        int i2 = c9912a.apI;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "photoPlaySecond", i2);
        }
        int i3 = c9912a.apJ;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "awardReceiveStage", i3);
        }
        int i4 = c9912a.f29528kl;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "itemClickType", i4);
        }
        int i5 = c9912a.apK;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "itemCloseType", i5);
        }
        int i6 = c9912a.apL;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "elementType", i6);
        }
        String str = c9912a.apM;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "adRenderArea", c9912a.apM);
        }
        long j = c9912a.apN;
        if (j != 0) {
            C11126t.putValue(jSONObject, IBidding.HIGHEST_LOSS_PRICE, j);
        }
        int i7 = c9912a.apO;
        if (i7 != 0) {
            C11126t.putValue(jSONObject, "impFailReason", i7);
        }
        long j2 = c9912a.apP;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "winEcpm", j2);
        }
        int i8 = c9912a.adnType;
        if (i8 != 0) {
            C11126t.putValue(jSONObject, "adnType", i8);
        }
        String str2 = c9912a.adnName;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "adnName", c9912a.adnName);
        }
        int i9 = c9912a.apQ;
        if (i9 != 0) {
            C11126t.putValue(jSONObject, "retainCodeType", i9);
        }
        int i10 = c9912a.f29524KI;
        if (i10 != 0) {
            C11126t.putValue(jSONObject, "photoSizeStyle", i10);
        }
        String str3 = c9912a.f29522KG;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "payload", c9912a.f29522KG);
        }
        int i11 = c9912a.apR;
        if (i11 != 0) {
            C11126t.putValue(jSONObject, "deeplinkType", i11);
        }
        String str4 = c9912a.apS;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "deeplinkAppName", c9912a.apS);
        }
        int i12 = c9912a.apT;
        if (i12 != 0) {
            C11126t.putValue(jSONObject, "deeplinkFailedReason", i12);
        }
        int i13 = c9912a.downloadSource;
        if (i13 != 0) {
            C11126t.putValue(jSONObject, "downloadSource", i13);
        }
        int i14 = c9912a.apU;
        if (i14 != 0) {
            C11126t.putValue(jSONObject, "isPackageChanged", i14);
        }
        String str5 = c9912a.apV;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "installedFrom", c9912a.apV);
        }
        String str6 = c9912a.apW;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "downloadFailedReason", c9912a.apW);
        }
        int i15 = c9912a.apX;
        if (i15 != 0) {
            C11126t.putValue(jSONObject, "isChangedEndcard", i15);
        }
        int i16 = c9912a.apY;
        if (i16 != 0) {
            C11126t.putValue(jSONObject, "adAggPageSource", i16);
        }
        String str7 = c9912a.apZ;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "serverPackageName", c9912a.apZ);
        }
        String str8 = c9912a.aqa;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, "installedPackageName", c9912a.aqa);
        }
        int i17 = c9912a.aqb;
        if (i17 != 0) {
            C11126t.putValue(jSONObject, "closeButtonImpressionTime", i17);
        }
        int i18 = c9912a.aqc;
        if (i18 != 0) {
            C11126t.putValue(jSONObject, "closeButtonClickTime", i18);
        }
        long j3 = c9912a.aqd;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "landingPageLoadedDuration", j3);
        }
        long j4 = c9912a.f29526Li;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "leaveTime", j4);
        }
        long j5 = c9912a.aqe;
        if (j5 != 0) {
            C11126t.putValue(jSONObject, "adItemClickBackDuration", j5);
        }
        int i19 = c9912a.aqf;
        if (i19 != 0) {
            C11126t.putValue(jSONObject, "appStorePageType", i19);
        }
        int i20 = c9912a.aqg;
        if (i20 != 0) {
            C11126t.putValue(jSONObject, "installStatus", i20);
        }
        int i21 = c9912a.downloadStatus;
        if (i21 != 0) {
            C11126t.putValue(jSONObject, "downloadStatus", i21);
        }
        int i22 = c9912a.aqh;
        if (i22 != 0) {
            C11126t.putValue(jSONObject, "downloadCardType", i22);
        }
        C11126t.m23678a(jSONObject, "clientExtData", c9912a.f29523KH);
        int i23 = c9912a.f29527Om;
        if (i23 != 0) {
            C11126t.putValue(jSONObject, "landingPageType", i23);
        }
        long j6 = c9912a.f29531vz;
        if (j6 != 0) {
            C11126t.putValue(jSONObject, "playedDuration", j6);
        }
        int i24 = c9912a.aqi;
        if (i24 != 0) {
            C11126t.putValue(jSONObject, "playedRate", i24);
        }
        int i25 = c9912a.aqj;
        if (i25 != 0) {
            C11126t.putValue(jSONObject, "adOrder", i25);
        }
        int i26 = c9912a.f29521KF;
        if (i26 != 0) {
            C11126t.putValue(jSONObject, "adInterstitialSource", i26);
        }
        double d = c9912a.f29530ko;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "splashShakeAcceleration", d);
        }
        String str9 = c9912a.aqk;
        if (str9 != null && !str9.equals("")) {
            C11126t.putValue(jSONObject, "splashInteractionRotateAngle", c9912a.aqk);
        }
        int i27 = c9912a.aql;
        if (i27 != 0) {
            C11126t.putValue(jSONObject, "downloadInstallType", i27);
        }
        int i28 = c9912a.aqm;
        if (i28 != 0) {
            C11126t.putValue(jSONObject, "businessSceneType", i28);
        }
        int i29 = c9912a.adxResult;
        if (i29 != 0) {
            C11126t.putValue(jSONObject, "adxResult", i29);
        }
        int i30 = c9912a.aqn;
        if (i30 != 0) {
            C11126t.putValue(jSONObject, "fingerSwipeType", i30);
        }
        int i31 = c9912a.aqo;
        if (i31 != 0) {
            C11126t.putValue(jSONObject, "fingerSwipeDistance", i31);
        }
        int i32 = c9912a.f29525KJ;
        if (i32 != 0) {
            C11126t.putValue(jSONObject, "triggerType", i32);
        }
        int i33 = c9912a.aqp;
        if (i33 != 0) {
            C11126t.putValue(jSONObject, "cardCloseType", i33);
        }
        String str10 = c9912a.aqq;
        if (str10 != null && !str10.equals("")) {
            C11126t.putValue(jSONObject, "clientPkFailAdInfo", c9912a.aqq);
        }
        return jSONObject;
    }
}
