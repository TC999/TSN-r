package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class io implements com.kwad.sdk.core.d<SceneImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SceneImpl sceneImpl, JSONObject jSONObject) {
        a2(sceneImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SceneImpl sceneImpl, JSONObject jSONObject) {
        return b2(sceneImpl, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        URLPackage uRLPackage = new URLPackage();
        sceneImpl.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        sceneImpl.posId = jSONObject.optLong("posId");
        sceneImpl.entryScene = jSONObject.optLong("entryScene");
        sceneImpl.adNum = jSONObject.optInt("adNum");
        sceneImpl.action = jSONObject.optInt("action");
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
    private static JSONObject b2(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", sceneImpl.urlPackage);
        long j4 = sceneImpl.posId;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j4);
        }
        long j5 = sceneImpl.entryScene;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "entryScene", j5);
        }
        int i4 = sceneImpl.adNum;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adNum", i4);
        }
        int i5 = sceneImpl.action;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "action", i5);
        }
        int i6 = sceneImpl.width;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i6);
        }
        int i7 = sceneImpl.height;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i7);
        }
        int i8 = sceneImpl.adStyle;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i8);
        }
        int i9 = sceneImpl.screenOrientation;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenOrientation", i9);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mKsAdLabel", sceneImpl.mKsAdLabel);
        com.kwad.sdk.utils.t.a(jSONObject, "splashExtraData", sceneImpl.splashExtraData);
        com.kwad.sdk.utils.t.a(jSONObject, "nativeAdExtraData", sceneImpl.nativeAdExtraData);
        String str = sceneImpl.promoteId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "promoteId", sceneImpl.promoteId);
        }
        String str2 = sceneImpl.comment;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "comment", sceneImpl.comment);
        }
        long j6 = sceneImpl.userCommRateBuying;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userCommRateBuying", j6);
        }
        long j7 = sceneImpl.userCommRateSharing;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userCommRateSharing", j7);
        }
        String str3 = sceneImpl.backUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "backUrl", sceneImpl.backUrl);
        }
        String str4 = sceneImpl.bidResponse;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bidResponse", sceneImpl.bidResponse);
        }
        String str5 = sceneImpl.bidResponseV2;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bidResponseV2", sceneImpl.bidResponseV2);
        }
        return jSONObject;
    }
}
