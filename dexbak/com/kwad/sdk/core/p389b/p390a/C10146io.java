package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import com.kwad.sdk.utils.C11126t;
import com.umeng.ccg.CcgConstant;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.io */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10146io implements InterfaceC10273d<SceneImpl> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(SceneImpl sceneImpl, JSONObject jSONObject) {
        m26796a(sceneImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(SceneImpl sceneImpl, JSONObject jSONObject) {
        return m26795b(sceneImpl, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26796a(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        URLPackage uRLPackage = new URLPackage();
        sceneImpl.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        sceneImpl.posId = jSONObject.optLong("posId");
        sceneImpl.entryScene = jSONObject.optLong("entryScene");
        sceneImpl.adNum = jSONObject.optInt("adNum");
        sceneImpl.action = jSONObject.optInt(CcgConstant.f38549t);
        sceneImpl.width = jSONObject.optInt("width");
        sceneImpl.height = jSONObject.optInt("height");
        sceneImpl.adStyle = jSONObject.optInt("adStyle");
        sceneImpl.screenOrientation = jSONObject.optInt("screenOrientation");
        AdLabelImpl adLabelImpl = new AdLabelImpl();
        sceneImpl.mKsAdLabel = adLabelImpl;
        adLabelImpl.parseJson(jSONObject.optJSONObject("mKsAdLabel"));
        SplashExtraDataImpl splashExtraDataImpl = new SplashExtraDataImpl();
        sceneImpl.splashExtraData = splashExtraDataImpl;
        splashExtraDataImpl.parseJson(jSONObject.optJSONObject("splashExtraData"));
        NativeAdExtraDataImpl nativeAdExtraDataImpl = new NativeAdExtraDataImpl();
        sceneImpl.nativeAdExtraData = nativeAdExtraDataImpl;
        nativeAdExtraDataImpl.parseJson(jSONObject.optJSONObject("nativeAdExtraData"));
        sceneImpl.promoteId = jSONObject.optString("promoteId");
        if (JSONObject.NULL.toString().equals(sceneImpl.promoteId)) {
            sceneImpl.promoteId = "";
        }
        sceneImpl.comment = jSONObject.optString("comment");
        if (JSONObject.NULL.toString().equals(sceneImpl.comment)) {
            sceneImpl.comment = "";
        }
        sceneImpl.userCommRateBuying = jSONObject.optLong("userCommRateBuying");
        sceneImpl.userCommRateSharing = jSONObject.optLong("userCommRateSharing");
        sceneImpl.backUrl = jSONObject.optString("backUrl");
        if (JSONObject.NULL.toString().equals(sceneImpl.backUrl)) {
            sceneImpl.backUrl = "";
        }
        sceneImpl.bidResponse = jSONObject.optString("bidResponse");
        if (JSONObject.NULL.toString().equals(sceneImpl.bidResponse)) {
            sceneImpl.bidResponse = "";
        }
        sceneImpl.bidResponseV2 = jSONObject.optString("bidResponseV2");
        if (JSONObject.NULL.toString().equals(sceneImpl.bidResponseV2)) {
            sceneImpl.bidResponseV2 = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26795b(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.m23678a(jSONObject, "urlPackage", sceneImpl.urlPackage);
        long j = sceneImpl.posId;
        if (j != 0) {
            C11126t.putValue(jSONObject, "posId", j);
        }
        long j2 = sceneImpl.entryScene;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "entryScene", j2);
        }
        int i = sceneImpl.adNum;
        if (i != 0) {
            C11126t.putValue(jSONObject, "adNum", i);
        }
        int i2 = sceneImpl.action;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, CcgConstant.f38549t, i2);
        }
        int i3 = sceneImpl.width;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "width", i3);
        }
        int i4 = sceneImpl.height;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "height", i4);
        }
        int i5 = sceneImpl.adStyle;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "adStyle", i5);
        }
        int i6 = sceneImpl.screenOrientation;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "screenOrientation", i6);
        }
        C11126t.m23678a(jSONObject, "mKsAdLabel", sceneImpl.mKsAdLabel);
        C11126t.m23678a(jSONObject, "splashExtraData", sceneImpl.splashExtraData);
        C11126t.m23678a(jSONObject, "nativeAdExtraData", sceneImpl.nativeAdExtraData);
        String str = sceneImpl.promoteId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "promoteId", sceneImpl.promoteId);
        }
        String str2 = sceneImpl.comment;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "comment", sceneImpl.comment);
        }
        long j3 = sceneImpl.userCommRateBuying;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "userCommRateBuying", j3);
        }
        long j4 = sceneImpl.userCommRateSharing;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "userCommRateSharing", j4);
        }
        String str3 = sceneImpl.backUrl;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "backUrl", sceneImpl.backUrl);
        }
        String str4 = sceneImpl.bidResponse;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "bidResponse", sceneImpl.bidResponse);
        }
        String str5 = sceneImpl.bidResponseV2;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "bidResponseV2", sceneImpl.bidResponseV2);
        }
        return jSONObject;
    }
}
