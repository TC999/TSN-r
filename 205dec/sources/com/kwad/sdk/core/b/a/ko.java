package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ko implements com.kwad.sdk.core.d<PhotoInfo.VideoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        a2(videoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        return b2(videoInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoInfo.videoUrl = jSONObject.optString("videoUrl");
        if (JSONObject.NULL.toString().equals(videoInfo.videoUrl)) {
            videoInfo.videoUrl = "";
        }
        videoInfo.manifest = jSONObject.optString("manifest");
        if (JSONObject.NULL.toString().equals(videoInfo.manifest)) {
            videoInfo.manifest = "";
        }
        videoInfo.firstFrame = jSONObject.optString("firstFrame");
        if (JSONObject.NULL.toString().equals(videoInfo.firstFrame)) {
            videoInfo.firstFrame = "";
        }
        videoInfo.duration = jSONObject.optLong("duration");
        videoInfo.size = jSONObject.optInt("size");
        videoInfo.width = jSONObject.optInt("width");
        videoInfo.height = jSONObject.optInt("height");
        videoInfo.leftRatio = jSONObject.optDouble("leftRatio");
        videoInfo.topRatio = jSONObject.optDouble("topRatio");
        videoInfo.widthRatio = jSONObject.optDouble("widthRatio", new Double("1.0f").doubleValue());
        videoInfo.heightRatio = jSONObject.optDouble("heightRatio", new Double("1.0f").doubleValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = videoInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoUrl", videoInfo.videoUrl);
        }
        String str2 = videoInfo.manifest;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "manifest", videoInfo.manifest);
        }
        String str3 = videoInfo.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "firstFrame", videoInfo.firstFrame);
        }
        long j4 = videoInfo.duration;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration", j4);
        }
        int i4 = videoInfo.size;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "size", i4);
        }
        int i5 = videoInfo.width;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i5);
        }
        int i6 = videoInfo.height;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i6);
        }
        double d4 = videoInfo.leftRatio;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftRatio", d4);
        }
        double d5 = videoInfo.topRatio;
        if (d5 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topRatio", d5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "widthRatio", videoInfo.widthRatio);
        com.kwad.sdk.utils.t.putValue(jSONObject, "heightRatio", videoInfo.heightRatio);
        return jSONObject;
    }
}
