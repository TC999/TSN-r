package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.scene.URLPackage;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class hz implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.timestamp = jSONObject.optLong(CampaignEx.JSON_KEY_TIMESTAMP);
        nVar.sessionId = jSONObject.optString("sessionId");
        if (JSONObject.NULL.toString().equals(nVar.sessionId)) {
            nVar.sessionId = "";
        }
        nVar.IE = jSONObject.optLong("seq");
        nVar.axI = jSONObject.optLong("listId");
        nVar.actionType = jSONObject.optLong("actionType");
        nVar.KG = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(nVar.KG)) {
            nVar.KG = "";
        }
        nVar.llsid = jSONObject.optLong("llsid");
        nVar.axJ = jSONObject.optJSONObject("extra");
        nVar.axK = jSONObject.optJSONObject("impAdExtra");
        nVar.posId = jSONObject.optLong("posId");
        nVar.contentType = jSONObject.optInt("contentType");
        nVar.realShowType = jSONObject.optInt("realShowType");
        nVar.photoId = jSONObject.optLong("photoId");
        nVar.position = jSONObject.optLong("position");
        nVar.axL = jSONObject.optLong("serverPosition");
        nVar.axM = jSONObject.optLong("photoDuration");
        nVar.axN = jSONObject.optLong("effectivePlayDuration");
        nVar.VU = jSONObject.optLong("playDuration");
        nVar.blockDuration = jSONObject.optLong("blockDuration");
        nVar.axO = jSONObject.optLong("intervalDuration");
        nVar.axP = jSONObject.optLong("allIntervalDuration");
        nVar.axQ = jSONObject.optLong("flowSdk");
        nVar.axR = jSONObject.optLong("blockTimes");
        nVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        nVar.apY = jSONObject.optInt("adAggPageSource");
        nVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (JSONObject.NULL.toString().equals(nVar.entryPageSource)) {
            nVar.entryPageSource = "";
        }
        URLPackage uRLPackage = new URLPackage();
        nVar.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        nVar.axS = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        nVar.Sd = jSONObject.optLong("authorId");
        nVar.axT = jSONObject.optString("photoSize");
        if (JSONObject.NULL.toString().equals(nVar.axT)) {
            nVar.axT = "";
        }
        nVar.axU = jSONObject.optJSONArray("appInstalled");
        nVar.axV = jSONObject.optJSONArray("appUninstalled");
        n.a aVar = new n.a();
        nVar.axW = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExt"));
        nVar.axX = jSONObject.optInt("playerType");
        nVar.axY = jSONObject.optInt("uiType");
        nVar.axZ = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        nVar.Xt = jSONObject.optInt("refreshType");
        nVar.aya = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        nVar.ayb = jSONObject.optString("failUrl");
        if (JSONObject.NULL.toString().equals(nVar.ayb)) {
            nVar.ayb = "";
        }
        nVar.errorMsg = jSONObject.optString("errorMsg");
        if (JSONObject.NULL.toString().equals(nVar.errorMsg)) {
            nVar.errorMsg = "";
        }
        nVar.errorCode = jSONObject.optInt("errorCode", new Integer("0").intValue());
        nVar.creativeId = jSONObject.optLong("creativeId");
        nVar.aye = jSONObject.optString("cacheFailedReason");
        if (JSONObject.NULL.toString().equals(nVar.aye)) {
            nVar.aye = "";
        }
        nVar.ayf = jSONObject.optJSONObject("appExt");
        nVar.ayg = jSONObject.optJSONArray("appRunningInfoList");
        nVar.downloadDuration = jSONObject.optLong("downloadDuration");
        nVar.pageType = jSONObject.optInt("pageType", new Integer("0").intValue());
        nVar.ayh = jSONObject.optInt("speedLimitStatus");
        nVar.ayi = jSONObject.optInt("speedLimitThreshold");
        nVar.ayj = jSONObject.optInt("currentRealDownloadSpeed");
        nVar.ayl = jSONObject.optJSONArray("sdkPlatform");
        nVar.aym = jSONObject.optBoolean("isKsUnion");
        nVar.ayn = jSONObject.optString("trackMethodName");
        if (JSONObject.NULL.toString().equals(nVar.ayn)) {
            nVar.ayn = "";
        }
        nVar.ayo = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        nVar.clickTime = jSONObject.optLong("clickTime");
        nVar.ayq = jSONObject.optLong("frameRenderTime");
        nVar.ayr = jSONObject.optInt("playerEnterAction");
        nVar.ays = jSONObject.optString("requestUrl");
        if (JSONObject.NULL.toString().equals(nVar.ays)) {
            nVar.ays = "";
        }
        nVar.ayt = jSONObject.optLong("requestTotalTime");
        nVar.ayu = jSONObject.optLong("requestResponseTime");
        nVar.ayv = jSONObject.optLong("requestParseDataTime");
        nVar.ayw = jSONObject.optLong("requestCallbackTime");
        nVar.ayx = jSONObject.optString("requestFailReason");
        if (JSONObject.NULL.toString().equals(nVar.ayx)) {
            nVar.ayx = "";
        }
        nVar.Ra = jSONObject.optString("pageName");
        if (JSONObject.NULL.toString().equals(nVar.Ra)) {
            nVar.Ra = "";
        }
        nVar.Ri = jSONObject.optLong("pageCreateTime");
        nVar.Rj = jSONObject.optLong("pageResumeTime");
        nVar.ayy = jSONObject.optInt("trackUrlType");
        nVar.ayz = jSONObject.optJSONArray("trackUrlList");
        nVar.Rh = jSONObject.optLong("pageLaunchTime");
        nVar.ayC = jSONObject.optJSONArray("appAuthorityInfoList");
        nVar.ayD = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(nVar.ayD)) {
            nVar.ayD = "";
        }
        nVar.ayE = jSONObject.optString("jsVersion");
        if (JSONObject.NULL.toString().equals(nVar.ayE)) {
            nVar.ayE = "";
        }
        nVar.ayF = jSONObject.optString("jsFileName");
        if (JSONObject.NULL.toString().equals(nVar.ayF)) {
            nVar.ayF = "";
        }
        nVar.ayG = jSONObject.optString("jsErrorMsg");
        if (JSONObject.NULL.toString().equals(nVar.ayG)) {
            nVar.ayG = "";
        }
        nVar.ayH = jSONObject.optString("jsConfig");
        if (JSONObject.NULL.toString().equals(nVar.ayH)) {
            nVar.ayH = "";
        }
        nVar.ayI = jSONObject.optInt("adBizType");
        nVar.ayJ = jSONObject.optString("customKey");
        if (JSONObject.NULL.toString().equals(nVar.ayJ)) {
            nVar.ayJ = "";
        }
        nVar.ayK = jSONObject.optString("customValue");
        if (JSONObject.NULL.toString().equals(nVar.ayK)) {
            nVar.ayK = "";
        }
        nVar.trace = jSONObject.optString("trace");
        if (JSONObject.NULL.toString().equals(nVar.trace)) {
            nVar.trace = "";
        }
        nVar.ayL = jSONObject.optInt("filterCode");
        nVar.ayM = jSONObject.optInt("sdkVersionCode");
        nVar.sdkVersion = jSONObject.optString("sdkVersion");
        if (JSONObject.NULL.toString().equals(nVar.sdkVersion)) {
            nVar.sdkVersion = "";
        }
        nVar.ayN = jSONObject.optString("adSdkVersion");
        if (JSONObject.NULL.toString().equals(nVar.ayN)) {
            nVar.ayN = "";
        }
        nVar.WQ = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(nVar.WQ)) {
            nVar.WQ = "";
        }
        nVar.sdkType = jSONObject.optInt("sdkType");
        nVar.ayO = jSONObject.optLong("appUseDuration");
        nVar.ayP = jSONObject.optLong("appStartType");
        nVar.auc = jSONObject.optLong("sequenceNumber");
        nVar.IB = jSONObject.optString("appColdStart");
        if (JSONObject.NULL.toString().equals(nVar.IB)) {
            nVar.IB = "";
        }
        nVar.IC = jSONObject.optString("appStart");
        if (JSONObject.NULL.toString().equals(nVar.IC)) {
            nVar.IC = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = nVar.timestamp;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, j4);
        }
        String str = nVar.sessionId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sessionId", nVar.sessionId);
        }
        long j5 = nVar.IE;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "seq", j5);
        }
        long j6 = nVar.axI;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "listId", j6);
        }
        long j7 = nVar.actionType;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionType", j7);
        }
        String str2 = nVar.KG;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", nVar.KG);
        }
        long j8 = nVar.llsid;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j8);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "extra", nVar.axJ);
        com.kwad.sdk.utils.t.putValue(jSONObject, "impAdExtra", nVar.axK);
        long j9 = nVar.posId;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j9);
        }
        int i4 = nVar.contentType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "contentType", i4);
        }
        int i5 = nVar.realShowType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "realShowType", i5);
        }
        long j10 = nVar.photoId;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoId", j10);
        }
        long j11 = nVar.position;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "position", j11);
        }
        long j12 = nVar.axL;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "serverPosition", j12);
        }
        long j13 = nVar.axM;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoDuration", j13);
        }
        long j14 = nVar.axN;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "effectivePlayDuration", j14);
        }
        long j15 = nVar.VU;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j15);
        }
        long j16 = nVar.blockDuration;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockDuration", j16);
        }
        long j17 = nVar.axO;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "intervalDuration", j17);
        }
        long j18 = nVar.axP;
        if (j18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "allIntervalDuration", j18);
        }
        long j19 = nVar.axQ;
        if (j19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "flowSdk", j19);
        }
        long j20 = nVar.axR;
        if (j20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockTimes", j20);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "contentSourceType", nVar.contentSourceType);
        int i6 = nVar.apY;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAggPageSource", i6);
        }
        String str3 = nVar.entryPageSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "entryPageSource", nVar.entryPageSource);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", nVar.urlPackage);
        com.kwad.sdk.utils.t.a(jSONObject, "referURLPackage", nVar.axS);
        long j21 = nVar.Sd;
        if (j21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "authorId", j21);
        }
        String str4 = nVar.axT;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoSize", nVar.axT);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appInstalled", nVar.axU);
        com.kwad.sdk.utils.t.putValue(jSONObject, "appUninstalled", nVar.axV);
        com.kwad.sdk.utils.t.a(jSONObject, "clientExt", nVar.axW);
        int i7 = nVar.axX;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playerType", i7);
        }
        int i8 = nVar.axY;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "uiType", i8);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "isLeftSlipStatus", nVar.axZ);
        int i9 = nVar.Xt;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshType", i9);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "photoResponseType", nVar.aya);
        String str5 = nVar.ayb;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failUrl", nVar.ayb);
        }
        String str6 = nVar.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorMsg", nVar.errorMsg);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "errorCode", nVar.errorCode);
        long j22 = nVar.creativeId;
        if (j22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", j22);
        }
        String str7 = nVar.aye;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cacheFailedReason", nVar.aye);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appExt", nVar.ayf);
        com.kwad.sdk.utils.t.putValue(jSONObject, "appRunningInfoList", nVar.ayg);
        long j23 = nVar.downloadDuration;
        if (j23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadDuration", j23);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "pageType", nVar.pageType);
        int i10 = nVar.ayh;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speedLimitStatus", i10);
        }
        int i11 = nVar.ayi;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speedLimitThreshold", i11);
        }
        int i12 = nVar.ayj;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentRealDownloadSpeed", i12);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "sdkPlatform", nVar.ayl);
        boolean z3 = nVar.aym;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isKsUnion", z3);
        }
        String str8 = nVar.ayn;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trackMethodName", nVar.ayn);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "viewModeType", nVar.ayo);
        long j24 = nVar.clickTime;
        if (j24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickTime", j24);
        }
        long j25 = nVar.ayq;
        if (j25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "frameRenderTime", j25);
        }
        int i13 = nVar.ayr;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playerEnterAction", i13);
        }
        String str9 = nVar.ays;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestUrl", nVar.ays);
        }
        long j26 = nVar.ayt;
        if (j26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestTotalTime", j26);
        }
        long j27 = nVar.ayu;
        if (j27 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestResponseTime", j27);
        }
        long j28 = nVar.ayv;
        if (j28 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestParseDataTime", j28);
        }
        long j29 = nVar.ayw;
        if (j29 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestCallbackTime", j29);
        }
        String str10 = nVar.ayx;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestFailReason", nVar.ayx);
        }
        String str11 = nVar.Ra;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageName", nVar.Ra);
        }
        long j30 = nVar.Ri;
        if (j30 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageCreateTime", j30);
        }
        long j31 = nVar.Rj;
        if (j31 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageResumeTime", j31);
        }
        int i14 = nVar.ayy;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trackUrlType", i14);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "trackUrlList", nVar.ayz);
        long j32 = nVar.Rh;
        if (j32 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageLaunchTime", j32);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appAuthorityInfoList", nVar.ayC);
        String str12 = nVar.ayD;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tkVersion", nVar.ayD);
        }
        String str13 = nVar.ayE;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsVersion", nVar.ayE);
        }
        String str14 = nVar.ayF;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsFileName", nVar.ayF);
        }
        String str15 = nVar.ayG;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsErrorMsg", nVar.ayG);
        }
        String str16 = nVar.ayH;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsConfig", nVar.ayH);
        }
        int i15 = nVar.ayI;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adBizType", i15);
        }
        String str17 = nVar.ayJ;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "customKey", nVar.ayJ);
        }
        String str18 = nVar.ayK;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "customValue", nVar.ayK);
        }
        String str19 = nVar.trace;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trace", nVar.trace);
        }
        int i16 = nVar.ayL;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "filterCode", i16);
        }
        int i17 = nVar.ayM;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkVersionCode", i17);
        }
        String str20 = nVar.sdkVersion;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkVersion", nVar.sdkVersion);
        }
        String str21 = nVar.ayN;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adSdkVersion", nVar.ayN);
        }
        String str22 = nVar.WQ;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", nVar.WQ);
        }
        int i18 = nVar.sdkType;
        if (i18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i18);
        }
        long j33 = nVar.ayO;
        if (j33 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appUseDuration", j33);
        }
        long j34 = nVar.ayP;
        if (j34 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStartType", j34);
        }
        long j35 = nVar.auc;
        if (j35 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sequenceNumber", j35);
        }
        String str23 = nVar.IB;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appColdStart", nVar.IB);
        }
        String str24 = nVar.IC;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStart", nVar.IC);
        }
        return jSONObject;
    }
}
