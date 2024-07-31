package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import com.tencent.connect.share.QzonePublish;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gf */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10083gf implements InterfaceC10273d<AdInfo.AdMaterialInfo.MaterialFeature> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        m26922a(materialFeature, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        return m26921b(materialFeature, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26922a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
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
        materialFeature.videoDuration = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
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
        materialFeature.source = jSONObject.optInt(SocialConstants.PARAM_SOURCE);
        materialFeature.ruleId = jSONObject.optString("ruleId");
        if (JSONObject.NULL.toString().equals(materialFeature.ruleId)) {
            materialFeature.ruleId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26921b(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = materialFeature.featureType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "featureType", i);
        }
        String str = materialFeature.materialUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "materialUrl", materialFeature.materialUrl);
        }
        long j = materialFeature.photoId;
        if (j != 0) {
            C11126t.putValue(jSONObject, "photoId", j);
        }
        String str2 = materialFeature.coverUrl;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "coverUrl", materialFeature.coverUrl);
        }
        int i2 = materialFeature.videoDuration;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, i2);
        }
        String str3 = materialFeature.firstFrame;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "firstFrame", materialFeature.firstFrame);
        }
        String str4 = materialFeature.blurBackgroundUrl;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "blurBackgroundUrl", materialFeature.blurBackgroundUrl);
        }
        String str5 = materialFeature.webpCoverUrl;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "webpCoverUrl", materialFeature.webpCoverUrl);
        }
        int i3 = materialFeature.videoWidth;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "videoWidth", i3);
        }
        int i4 = materialFeature.videoHeight;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "videoHeight", i4);
        }
        long j2 = materialFeature.likeCount;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "likeCount", j2);
        }
        long j3 = materialFeature.commentCount;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "commentCount", j3);
        }
        int i5 = materialFeature.source;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, SocialConstants.PARAM_SOURCE, i5);
        }
        String str6 = materialFeature.ruleId;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "ruleId", materialFeature.ruleId);
        }
        return jSONObject;
    }
}
