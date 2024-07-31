package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hm */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10117hm implements InterfaceC10273d<PhotoInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(PhotoInfo photoInfo, JSONObject jSONObject) {
        m26854a(photoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(PhotoInfo photoInfo, JSONObject jSONObject) {
        return m26853b(photoInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26854a(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        photoInfo.mOriginJString = jSONObject.optString("mOriginJString");
        if (JSONObject.NULL.toString().equals(photoInfo.mOriginJString)) {
            photoInfo.mOriginJString = "";
        }
        PhotoInfo.BaseInfo baseInfo = new PhotoInfo.BaseInfo();
        photoInfo.baseInfo = baseInfo;
        baseInfo.parseJson(jSONObject.optJSONObject("baseInfo"));
        PhotoInfo.VideoInfo videoInfo = new PhotoInfo.VideoInfo();
        photoInfo.videoInfo = videoInfo;
        videoInfo.parseJson(jSONObject.optJSONObject("videoInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26853b(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = photoInfo.mOriginJString;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "mOriginJString", photoInfo.mOriginJString);
        }
        C11126t.m23678a(jSONObject, "baseInfo", photoInfo.baseInfo);
        C11126t.m23678a(jSONObject, "videoInfo", photoInfo.videoInfo);
        return jSONObject;
    }
}
