package com.kwad.sdk.core.p389b.p390a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.report.C10464n;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hz */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10130hz implements InterfaceC10273d<C10464n> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10464n c10464n, JSONObject jSONObject) {
        m26828a(c10464n, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10464n c10464n, JSONObject jSONObject) {
        return m26827b(c10464n, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26828a(C10464n c10464n, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10464n.timestamp = jSONObject.optLong(CampaignEx.JSON_KEY_TIMESTAMP);
        c10464n.sessionId = jSONObject.optString("sessionId");
        if (JSONObject.NULL.toString().equals(c10464n.sessionId)) {
            c10464n.sessionId = "";
        }
        c10464n.f29564IE = jSONObject.optLong(RtspHeaders.Values.SEQ);
        c10464n.axI = jSONObject.optLong("listId");
        c10464n.actionType = jSONObject.optLong("actionType");
        c10464n.f29565KG = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(c10464n.f29565KG)) {
            c10464n.f29565KG = "";
        }
        c10464n.llsid = jSONObject.optLong("llsid");
        c10464n.axJ = jSONObject.optJSONObject("extra");
        c10464n.axK = jSONObject.optJSONObject("impAdExtra");
        c10464n.posId = jSONObject.optLong("posId");
        c10464n.contentType = jSONObject.optInt("contentType");
        c10464n.realShowType = jSONObject.optInt("realShowType");
        c10464n.photoId = jSONObject.optLong("photoId");
        c10464n.position = jSONObject.optLong("position");
        c10464n.axL = jSONObject.optLong("serverPosition");
        c10464n.axM = jSONObject.optLong("photoDuration");
        c10464n.axN = jSONObject.optLong("effectivePlayDuration");
        c10464n.f29571VU = jSONObject.optLong("playDuration");
        c10464n.blockDuration = jSONObject.optLong("blockDuration");
        c10464n.axO = jSONObject.optLong("intervalDuration");
        c10464n.axP = jSONObject.optLong("allIntervalDuration");
        c10464n.axQ = jSONObject.optLong("flowSdk");
        c10464n.axR = jSONObject.optLong("blockTimes");
        c10464n.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        c10464n.apY = jSONObject.optInt("adAggPageSource");
        c10464n.entryPageSource = jSONObject.optString("entryPageSource");
        if (JSONObject.NULL.toString().equals(c10464n.entryPageSource)) {
            c10464n.entryPageSource = "";
        }
        URLPackage uRLPackage = new URLPackage();
        c10464n.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        c10464n.axS = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        c10464n.f29570Sd = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        c10464n.axT = jSONObject.optString("photoSize");
        if (JSONObject.NULL.toString().equals(c10464n.axT)) {
            c10464n.axT = "";
        }
        c10464n.axU = jSONObject.optJSONArray("appInstalled");
        c10464n.axV = jSONObject.optJSONArray("appUninstalled");
        C10464n.C10465a c10465a = new C10464n.C10465a();
        c10464n.axW = c10465a;
        c10465a.parseJson(jSONObject.optJSONObject("clientExt"));
        c10464n.axX = jSONObject.optInt("playerType");
        c10464n.axY = jSONObject.optInt("uiType");
        c10464n.axZ = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        c10464n.f29573Xt = jSONObject.optInt("refreshType");
        c10464n.aya = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        c10464n.ayb = jSONObject.optString("failUrl");
        if (JSONObject.NULL.toString().equals(c10464n.ayb)) {
            c10464n.ayb = "";
        }
        c10464n.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (JSONObject.NULL.toString().equals(c10464n.errorMsg)) {
            c10464n.errorMsg = "";
        }
        c10464n.errorCode = jSONObject.optInt("errorCode", new Integer("0").intValue());
        c10464n.creativeId = jSONObject.optLong("creativeId");
        c10464n.aye = jSONObject.optString("cacheFailedReason");
        if (JSONObject.NULL.toString().equals(c10464n.aye)) {
            c10464n.aye = "";
        }
        c10464n.ayf = jSONObject.optJSONObject("appExt");
        c10464n.ayg = jSONObject.optJSONArray("appRunningInfoList");
        c10464n.downloadDuration = jSONObject.optLong("downloadDuration");
        c10464n.pageType = jSONObject.optInt("pageType", new Integer("0").intValue());
        c10464n.ayh = jSONObject.optInt("speedLimitStatus");
        c10464n.ayi = jSONObject.optInt("speedLimitThreshold");
        c10464n.ayj = jSONObject.optInt("currentRealDownloadSpeed");
        c10464n.ayl = jSONObject.optJSONArray("sdkPlatform");
        c10464n.aym = jSONObject.optBoolean("isKsUnion");
        c10464n.ayn = jSONObject.optString("trackMethodName");
        if (JSONObject.NULL.toString().equals(c10464n.ayn)) {
            c10464n.ayn = "";
        }
        c10464n.ayo = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        c10464n.clickTime = jSONObject.optLong("clickTime");
        c10464n.ayq = jSONObject.optLong("frameRenderTime");
        c10464n.ayr = jSONObject.optInt("playerEnterAction");
        c10464n.ays = jSONObject.optString("requestUrl");
        if (JSONObject.NULL.toString().equals(c10464n.ays)) {
            c10464n.ays = "";
        }
        c10464n.ayt = jSONObject.optLong("requestTotalTime");
        c10464n.ayu = jSONObject.optLong("requestResponseTime");
        c10464n.ayv = jSONObject.optLong("requestParseDataTime");
        c10464n.ayw = jSONObject.optLong("requestCallbackTime");
        c10464n.ayx = jSONObject.optString("requestFailReason");
        if (JSONObject.NULL.toString().equals(c10464n.ayx)) {
            c10464n.ayx = "";
        }
        c10464n.f29566Ra = jSONObject.optString("pageName");
        if (JSONObject.NULL.toString().equals(c10464n.f29566Ra)) {
            c10464n.f29566Ra = "";
        }
        c10464n.f29568Ri = jSONObject.optLong("pageCreateTime");
        c10464n.f29569Rj = jSONObject.optLong("pageResumeTime");
        c10464n.ayy = jSONObject.optInt("trackUrlType");
        c10464n.ayz = jSONObject.optJSONArray("trackUrlList");
        c10464n.f29567Rh = jSONObject.optLong("pageLaunchTime");
        c10464n.ayC = jSONObject.optJSONArray("appAuthorityInfoList");
        c10464n.ayD = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(c10464n.ayD)) {
            c10464n.ayD = "";
        }
        c10464n.ayE = jSONObject.optString("jsVersion");
        if (JSONObject.NULL.toString().equals(c10464n.ayE)) {
            c10464n.ayE = "";
        }
        c10464n.ayF = jSONObject.optString("jsFileName");
        if (JSONObject.NULL.toString().equals(c10464n.ayF)) {
            c10464n.ayF = "";
        }
        c10464n.ayG = jSONObject.optString("jsErrorMsg");
        if (JSONObject.NULL.toString().equals(c10464n.ayG)) {
            c10464n.ayG = "";
        }
        c10464n.ayH = jSONObject.optString("jsConfig");
        if (JSONObject.NULL.toString().equals(c10464n.ayH)) {
            c10464n.ayH = "";
        }
        c10464n.ayI = jSONObject.optInt("adBizType");
        c10464n.ayJ = jSONObject.optString("customKey");
        if (JSONObject.NULL.toString().equals(c10464n.ayJ)) {
            c10464n.ayJ = "";
        }
        c10464n.ayK = jSONObject.optString("customValue");
        if (JSONObject.NULL.toString().equals(c10464n.ayK)) {
            c10464n.ayK = "";
        }
        c10464n.trace = jSONObject.optString("trace");
        if (JSONObject.NULL.toString().equals(c10464n.trace)) {
            c10464n.trace = "";
        }
        c10464n.ayL = jSONObject.optInt("filterCode");
        c10464n.ayM = jSONObject.optInt("sdkVersionCode");
        c10464n.sdkVersion = jSONObject.optString("sdkVersion");
        if (JSONObject.NULL.toString().equals(c10464n.sdkVersion)) {
            c10464n.sdkVersion = "";
        }
        c10464n.ayN = jSONObject.optString("adSdkVersion");
        if (JSONObject.NULL.toString().equals(c10464n.ayN)) {
            c10464n.ayN = "";
        }
        c10464n.f29572WQ = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c10464n.f29572WQ)) {
            c10464n.f29572WQ = "";
        }
        c10464n.sdkType = jSONObject.optInt("sdkType");
        c10464n.ayO = jSONObject.optLong("appUseDuration");
        c10464n.ayP = jSONObject.optLong("appStartType");
        c10464n.auc = jSONObject.optLong("sequenceNumber");
        c10464n.f29562IB = jSONObject.optString("appColdStart");
        if (JSONObject.NULL.toString().equals(c10464n.f29562IB)) {
            c10464n.f29562IB = "";
        }
        c10464n.f29563IC = jSONObject.optString("appStart");
        if (JSONObject.NULL.toString().equals(c10464n.f29563IC)) {
            c10464n.f29563IC = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26827b(C10464n c10464n, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c10464n.timestamp;
        if (j != 0) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, j);
        }
        String str = c10464n.sessionId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "sessionId", c10464n.sessionId);
        }
        long j2 = c10464n.f29564IE;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, RtspHeaders.Values.SEQ, j2);
        }
        long j3 = c10464n.axI;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "listId", j3);
        }
        long j4 = c10464n.actionType;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "actionType", j4);
        }
        String str2 = c10464n.f29565KG;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "payload", c10464n.f29565KG);
        }
        long j5 = c10464n.llsid;
        if (j5 != 0) {
            C11126t.putValue(jSONObject, "llsid", j5);
        }
        C11126t.putValue(jSONObject, "extra", c10464n.axJ);
        C11126t.putValue(jSONObject, "impAdExtra", c10464n.axK);
        long j6 = c10464n.posId;
        if (j6 != 0) {
            C11126t.putValue(jSONObject, "posId", j6);
        }
        int i = c10464n.contentType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "contentType", i);
        }
        int i2 = c10464n.realShowType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "realShowType", i2);
        }
        long j7 = c10464n.photoId;
        if (j7 != 0) {
            C11126t.putValue(jSONObject, "photoId", j7);
        }
        long j8 = c10464n.position;
        if (j8 != 0) {
            C11126t.putValue(jSONObject, "position", j8);
        }
        long j9 = c10464n.axL;
        if (j9 != 0) {
            C11126t.putValue(jSONObject, "serverPosition", j9);
        }
        long j10 = c10464n.axM;
        if (j10 != 0) {
            C11126t.putValue(jSONObject, "photoDuration", j10);
        }
        long j11 = c10464n.axN;
        if (j11 != 0) {
            C11126t.putValue(jSONObject, "effectivePlayDuration", j11);
        }
        long j12 = c10464n.f29571VU;
        if (j12 != 0) {
            C11126t.putValue(jSONObject, "playDuration", j12);
        }
        long j13 = c10464n.blockDuration;
        if (j13 != 0) {
            C11126t.putValue(jSONObject, "blockDuration", j13);
        }
        long j14 = c10464n.axO;
        if (j14 != 0) {
            C11126t.putValue(jSONObject, "intervalDuration", j14);
        }
        long j15 = c10464n.axP;
        if (j15 != 0) {
            C11126t.putValue(jSONObject, "allIntervalDuration", j15);
        }
        long j16 = c10464n.axQ;
        if (j16 != 0) {
            C11126t.putValue(jSONObject, "flowSdk", j16);
        }
        long j17 = c10464n.axR;
        if (j17 != 0) {
            C11126t.putValue(jSONObject, "blockTimes", j17);
        }
        C11126t.putValue(jSONObject, "contentSourceType", c10464n.contentSourceType);
        int i3 = c10464n.apY;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "adAggPageSource", i3);
        }
        String str3 = c10464n.entryPageSource;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "entryPageSource", c10464n.entryPageSource);
        }
        C11126t.m23678a(jSONObject, "urlPackage", c10464n.urlPackage);
        C11126t.m23678a(jSONObject, "referURLPackage", c10464n.axS);
        long j18 = c10464n.f29570Sd;
        if (j18 != 0) {
            C11126t.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, j18);
        }
        String str4 = c10464n.axT;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "photoSize", c10464n.axT);
        }
        C11126t.putValue(jSONObject, "appInstalled", c10464n.axU);
        C11126t.putValue(jSONObject, "appUninstalled", c10464n.axV);
        C11126t.m23678a(jSONObject, "clientExt", c10464n.axW);
        int i4 = c10464n.axX;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "playerType", i4);
        }
        int i5 = c10464n.axY;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "uiType", i5);
        }
        C11126t.putValue(jSONObject, "isLeftSlipStatus", c10464n.axZ);
        int i6 = c10464n.f29573Xt;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "refreshType", i6);
        }
        C11126t.putValue(jSONObject, "photoResponseType", c10464n.aya);
        String str5 = c10464n.ayb;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "failUrl", c10464n.ayb);
        }
        String str6 = c10464n.errorMsg;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, c10464n.errorMsg);
        }
        C11126t.putValue(jSONObject, "errorCode", c10464n.errorCode);
        long j19 = c10464n.creativeId;
        if (j19 != 0) {
            C11126t.putValue(jSONObject, "creativeId", j19);
        }
        String str7 = c10464n.aye;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "cacheFailedReason", c10464n.aye);
        }
        C11126t.putValue(jSONObject, "appExt", c10464n.ayf);
        C11126t.putValue(jSONObject, "appRunningInfoList", c10464n.ayg);
        long j20 = c10464n.downloadDuration;
        if (j20 != 0) {
            C11126t.putValue(jSONObject, "downloadDuration", j20);
        }
        C11126t.putValue(jSONObject, "pageType", c10464n.pageType);
        int i7 = c10464n.ayh;
        if (i7 != 0) {
            C11126t.putValue(jSONObject, "speedLimitStatus", i7);
        }
        int i8 = c10464n.ayi;
        if (i8 != 0) {
            C11126t.putValue(jSONObject, "speedLimitThreshold", i8);
        }
        int i9 = c10464n.ayj;
        if (i9 != 0) {
            C11126t.putValue(jSONObject, "currentRealDownloadSpeed", i9);
        }
        C11126t.putValue(jSONObject, "sdkPlatform", c10464n.ayl);
        boolean z = c10464n.aym;
        if (z) {
            C11126t.putValue(jSONObject, "isKsUnion", z);
        }
        String str8 = c10464n.ayn;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, "trackMethodName", c10464n.ayn);
        }
        C11126t.putValue(jSONObject, "viewModeType", c10464n.ayo);
        long j21 = c10464n.clickTime;
        if (j21 != 0) {
            C11126t.putValue(jSONObject, "clickTime", j21);
        }
        long j22 = c10464n.ayq;
        if (j22 != 0) {
            C11126t.putValue(jSONObject, "frameRenderTime", j22);
        }
        int i10 = c10464n.ayr;
        if (i10 != 0) {
            C11126t.putValue(jSONObject, "playerEnterAction", i10);
        }
        String str9 = c10464n.ays;
        if (str9 != null && !str9.equals("")) {
            C11126t.putValue(jSONObject, "requestUrl", c10464n.ays);
        }
        long j23 = c10464n.ayt;
        if (j23 != 0) {
            C11126t.putValue(jSONObject, "requestTotalTime", j23);
        }
        long j24 = c10464n.ayu;
        if (j24 != 0) {
            C11126t.putValue(jSONObject, "requestResponseTime", j24);
        }
        long j25 = c10464n.ayv;
        if (j25 != 0) {
            C11126t.putValue(jSONObject, "requestParseDataTime", j25);
        }
        long j26 = c10464n.ayw;
        if (j26 != 0) {
            C11126t.putValue(jSONObject, "requestCallbackTime", j26);
        }
        String str10 = c10464n.ayx;
        if (str10 != null && !str10.equals("")) {
            C11126t.putValue(jSONObject, "requestFailReason", c10464n.ayx);
        }
        String str11 = c10464n.f29566Ra;
        if (str11 != null && !str11.equals("")) {
            C11126t.putValue(jSONObject, "pageName", c10464n.f29566Ra);
        }
        long j27 = c10464n.f29568Ri;
        if (j27 != 0) {
            C11126t.putValue(jSONObject, "pageCreateTime", j27);
        }
        long j28 = c10464n.f29569Rj;
        if (j28 != 0) {
            C11126t.putValue(jSONObject, "pageResumeTime", j28);
        }
        int i11 = c10464n.ayy;
        if (i11 != 0) {
            C11126t.putValue(jSONObject, "trackUrlType", i11);
        }
        C11126t.putValue(jSONObject, "trackUrlList", c10464n.ayz);
        long j29 = c10464n.f29567Rh;
        if (j29 != 0) {
            C11126t.putValue(jSONObject, "pageLaunchTime", j29);
        }
        C11126t.putValue(jSONObject, "appAuthorityInfoList", c10464n.ayC);
        String str12 = c10464n.ayD;
        if (str12 != null && !str12.equals("")) {
            C11126t.putValue(jSONObject, "tkVersion", c10464n.ayD);
        }
        String str13 = c10464n.ayE;
        if (str13 != null && !str13.equals("")) {
            C11126t.putValue(jSONObject, "jsVersion", c10464n.ayE);
        }
        String str14 = c10464n.ayF;
        if (str14 != null && !str14.equals("")) {
            C11126t.putValue(jSONObject, "jsFileName", c10464n.ayF);
        }
        String str15 = c10464n.ayG;
        if (str15 != null && !str15.equals("")) {
            C11126t.putValue(jSONObject, "jsErrorMsg", c10464n.ayG);
        }
        String str16 = c10464n.ayH;
        if (str16 != null && !str16.equals("")) {
            C11126t.putValue(jSONObject, "jsConfig", c10464n.ayH);
        }
        int i12 = c10464n.ayI;
        if (i12 != 0) {
            C11126t.putValue(jSONObject, "adBizType", i12);
        }
        String str17 = c10464n.ayJ;
        if (str17 != null && !str17.equals("")) {
            C11126t.putValue(jSONObject, "customKey", c10464n.ayJ);
        }
        String str18 = c10464n.ayK;
        if (str18 != null && !str18.equals("")) {
            C11126t.putValue(jSONObject, "customValue", c10464n.ayK);
        }
        String str19 = c10464n.trace;
        if (str19 != null && !str19.equals("")) {
            C11126t.putValue(jSONObject, "trace", c10464n.trace);
        }
        int i13 = c10464n.ayL;
        if (i13 != 0) {
            C11126t.putValue(jSONObject, "filterCode", i13);
        }
        int i14 = c10464n.ayM;
        if (i14 != 0) {
            C11126t.putValue(jSONObject, "sdkVersionCode", i14);
        }
        String str20 = c10464n.sdkVersion;
        if (str20 != null && !str20.equals("")) {
            C11126t.putValue(jSONObject, "sdkVersion", c10464n.sdkVersion);
        }
        String str21 = c10464n.ayN;
        if (str21 != null && !str21.equals("")) {
            C11126t.putValue(jSONObject, "adSdkVersion", c10464n.ayN);
        }
        String str22 = c10464n.f29572WQ;
        if (str22 != null && !str22.equals("")) {
            C11126t.putValue(jSONObject, "sdkApiVersion", c10464n.f29572WQ);
        }
        int i15 = c10464n.sdkType;
        if (i15 != 0) {
            C11126t.putValue(jSONObject, "sdkType", i15);
        }
        long j30 = c10464n.ayO;
        if (j30 != 0) {
            C11126t.putValue(jSONObject, "appUseDuration", j30);
        }
        long j31 = c10464n.ayP;
        if (j31 != 0) {
            C11126t.putValue(jSONObject, "appStartType", j31);
        }
        long j32 = c10464n.auc;
        if (j32 != 0) {
            C11126t.putValue(jSONObject, "sequenceNumber", j32);
        }
        String str23 = c10464n.f29562IB;
        if (str23 != null && !str23.equals("")) {
            C11126t.putValue(jSONObject, "appColdStart", c10464n.f29562IB);
        }
        String str24 = c10464n.f29563IC;
        if (str24 != null && !str24.equals("")) {
            C11126t.putValue(jSONObject, "appStart", c10464n.f29563IC);
        }
        return jSONObject;
    }
}
