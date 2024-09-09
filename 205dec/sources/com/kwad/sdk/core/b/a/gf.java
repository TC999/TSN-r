package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class gf implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo.MaterialFeature> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        a2(materialFeature, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        return b2(materialFeature, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialFeature.featureType = jSONObject.optInt("featureType");
        materialFeature.materialUrl = jSONObject.optString("materialUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.materialUrl)) {
            materialFeature.materialUrl = "";
        }
        materialFeature.photoId = jSONObject.optLong("photoId");
        materialFeature.coverUrl = jSONObject.optString("coverUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.coverUrl)) {
            materialFeature.coverUrl = "";
        }
        materialFeature.videoDuration = jSONObject.optInt("videoDuration");
        materialFeature.firstFrame = jSONObject.optString("firstFrame");
        if (JSONObject.NULL.toString().equals(materialFeature.firstFrame)) {
            materialFeature.firstFrame = "";
        }
        materialFeature.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.blurBackgroundUrl)) {
            materialFeature.blurBackgroundUrl = "";
        }
        materialFeature.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.webpCoverUrl)) {
            materialFeature.webpCoverUrl = "";
        }
        materialFeature.videoWidth = jSONObject.optInt("videoWidth");
        materialFeature.videoHeight = jSONObject.optInt("videoHeight");
        materialFeature.likeCount = jSONObject.optLong("likeCount");
        materialFeature.commentCount = jSONObject.optLong("commentCount");
        materialFeature.source = jSONObject.optInt("source");
        materialFeature.ruleId = jSONObject.optString("ruleId");
        if (JSONObject.NULL.toString().equals(materialFeature.ruleId)) {
            materialFeature.ruleId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = materialFeature.featureType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "featureType", i4);
        }
        String str = materialFeature.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "materialUrl", materialFeature.materialUrl);
        }
        long j4 = materialFeature.photoId;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoId", j4);
        }
        String str2 = materialFeature.coverUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "coverUrl", materialFeature.coverUrl);
        }
        int i5 = materialFeature.videoDuration;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoDuration", i5);
        }
        String str3 = materialFeature.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "firstFrame", materialFeature.firstFrame);
        }
        String str4 = materialFeature.blurBackgroundUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blurBackgroundUrl", materialFeature.blurBackgroundUrl);
        }
        String str5 = materialFeature.webpCoverUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "webpCoverUrl", materialFeature.webpCoverUrl);
        }
        int i6 = materialFeature.videoWidth;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoWidth", i6);
        }
        int i7 = materialFeature.videoHeight;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoHeight", i7);
        }
        long j5 = materialFeature.likeCount;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "likeCount", j5);
        }
        long j6 = materialFeature.commentCount;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "commentCount", j6);
        }
        int i8 = materialFeature.source;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "source", i8);
        }
        String str6 = materialFeature.ruleId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ruleId", materialFeature.ruleId);
        }
        return jSONObject;
    }
}
