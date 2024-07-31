package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.C11126t;
import com.umeng.ccg.CcgConstant;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10052fb implements InterfaceC10273d<ImpInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(ImpInfo impInfo, JSONObject jSONObject) {
        m26984a(impInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(ImpInfo impInfo, JSONObject jSONObject) {
        return m26983b(impInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26984a(ImpInfo impInfo, JSONObject jSONObject) {
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
        impInfo.action = jSONObject.optInt(CcgConstant.f38549t);
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
    private static JSONObject m26983b(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = impInfo.pageScene;
        if (j != 0) {
            C11126t.putValue(jSONObject, "pageScene", j);
        }
        long j2 = impInfo.subPageScene;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "subPageScene", j2);
        }
        String str = impInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "sdkExtraData", impInfo.sdkExtraData);
        }
        long j3 = impInfo.posId;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "posId", j3);
        }
        long j4 = impInfo.entryScene;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "entryScene", j4);
        }
        int i = impInfo.adNum;
        if (i != 0) {
            C11126t.putValue(jSONObject, "adNum", i);
        }
        int i2 = impInfo.action;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, CcgConstant.f38549t, i2);
        }
        int i3 = impInfo.width;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "width", i3);
        }
        int i4 = impInfo.height;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "height", i4);
        }
        long j5 = impInfo.cpmBidFloor;
        if (j5 != 0) {
            C11126t.putValue(jSONObject, "cpmBidFloor", j5);
        }
        int i5 = impInfo.adStyle;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "adStyle", i5);
        }
        C11126t.m23678a(jSONObject, "urlPackage", impInfo.urlPackage);
        String str2 = impInfo.promoteId;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "promoteId", impInfo.promoteId);
        }
        String str3 = impInfo.comment;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "comment", impInfo.comment);
        }
        String str4 = impInfo.backUrl;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "backUrl", impInfo.backUrl);
        }
        long j6 = impInfo.userCommRateBuying;
        if (j6 != 0) {
            C11126t.putValue(jSONObject, "userCommRateBuying", j6);
        }
        long j7 = impInfo.userCommRateSharing;
        if (j7 != 0) {
            C11126t.putValue(jSONObject, "userCommRateSharing", j7);
        }
        int i6 = impInfo.screenOrientation;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "screenOrientation", i6);
        }
        String str5 = impInfo.extraData;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "extraData", impInfo.extraData);
        }
        return jSONObject;
    }
}
