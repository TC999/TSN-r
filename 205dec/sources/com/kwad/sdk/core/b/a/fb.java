package com.kwad.sdk.core.b.a;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class fb implements com.kwad.sdk.core.d<ImpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ImpInfo impInfo, JSONObject jSONObject) {
        a2(impInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ImpInfo impInfo, JSONObject jSONObject) {
        return b2(impInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        impInfo.pageScene = jSONObject.optLong("pageScene");
        impInfo.subPageScene = jSONObject.optLong("subPageScene");
        impInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (JSONObject.NULL.toString().equals(impInfo.sdkExtraData)) {
            impInfo.sdkExtraData = "";
        }
        impInfo.posId = jSONObject.optLong("posId");
        impInfo.entryScene = jSONObject.optLong("entryScene");
        impInfo.adNum = jSONObject.optInt("adNum");
        impInfo.action = jSONObject.optInt("action");
        impInfo.width = jSONObject.optInt("width");
        impInfo.height = jSONObject.optInt("height");
        impInfo.cpmBidFloor = jSONObject.optLong("cpmBidFloor");
        impInfo.adStyle = jSONObject.optInt("adStyle");
        URLPackage uRLPackage = new URLPackage();
        impInfo.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        impInfo.promoteId = jSONObject.optString("promoteId");
        if (JSONObject.NULL.toString().equals(impInfo.promoteId)) {
            impInfo.promoteId = "";
        }
        impInfo.comment = jSONObject.optString("comment");
        if (JSONObject.NULL.toString().equals(impInfo.comment)) {
            impInfo.comment = "";
        }
        impInfo.backUrl = jSONObject.optString("backUrl");
        if (JSONObject.NULL.toString().equals(impInfo.backUrl)) {
            impInfo.backUrl = "";
        }
        impInfo.userCommRateBuying = jSONObject.optLong("userCommRateBuying");
        impInfo.userCommRateSharing = jSONObject.optLong("userCommRateSharing");
        impInfo.screenOrientation = jSONObject.optInt("screenOrientation");
        impInfo.extraData = jSONObject.optString("extraData");
        if (JSONObject.NULL.toString().equals(impInfo.extraData)) {
            impInfo.extraData = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = impInfo.pageScene;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageScene", j4);
        }
        long j5 = impInfo.subPageScene;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "subPageScene", j5);
        }
        String str = impInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkExtraData", impInfo.sdkExtraData);
        }
        long j6 = impInfo.posId;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j6);
        }
        long j7 = impInfo.entryScene;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "entryScene", j7);
        }
        int i4 = impInfo.adNum;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adNum", i4);
        }
        int i5 = impInfo.action;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "action", i5);
        }
        int i6 = impInfo.width;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i6);
        }
        int i7 = impInfo.height;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i7);
        }
        long j8 = impInfo.cpmBidFloor;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cpmBidFloor", j8);
        }
        int i8 = impInfo.adStyle;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i8);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", impInfo.urlPackage);
        String str2 = impInfo.promoteId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "promoteId", impInfo.promoteId);
        }
        String str3 = impInfo.comment;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "comment", impInfo.comment);
        }
        String str4 = impInfo.backUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "backUrl", impInfo.backUrl);
        }
        long j9 = impInfo.userCommRateBuying;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userCommRateBuying", j9);
        }
        long j10 = impInfo.userCommRateSharing;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userCommRateSharing", j10);
        }
        int i9 = impInfo.screenOrientation;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenOrientation", i9);
        }
        String str5 = impInfo.extraData;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "extraData", impInfo.extraData);
        }
        return jSONObject;
    }
}
