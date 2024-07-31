package com.kwad.sdk.core.p389b.p390a;

import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ko */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10200ko implements InterfaceC10273d<PhotoInfo.VideoInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        m26688a(videoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        return m26687b(videoInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26688a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
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
    private static JSONObject m26687b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = videoInfo.videoUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "videoUrl", videoInfo.videoUrl);
        }
        String str2 = videoInfo.manifest;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "manifest", videoInfo.manifest);
        }
        String str3 = videoInfo.firstFrame;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "firstFrame", videoInfo.firstFrame);
        }
        long j = videoInfo.duration;
        if (j != 0) {
            C11126t.putValue(jSONObject, "duration", j);
        }
        int i = videoInfo.size;
        if (i != 0) {
            C11126t.putValue(jSONObject, "size", i);
        }
        int i2 = videoInfo.width;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "width", i2);
        }
        int i3 = videoInfo.height;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "height", i3);
        }
        double d = videoInfo.leftRatio;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "leftRatio", d);
        }
        double d2 = videoInfo.topRatio;
        if (d2 != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "topRatio", d2);
        }
        C11126t.putValue(jSONObject, "widthRatio", videoInfo.widthRatio);
        C11126t.putValue(jSONObject, "heightRatio", videoInfo.heightRatio);
        return jSONObject;
    }
}
