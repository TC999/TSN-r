package com.kwad.components.core.internal.api;

import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.internal.api.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8681e {
    /* renamed from: a */
    public static String m30025a(KsVideoPlayConfig ksVideoPlayConfig) {
        if (ksVideoPlayConfig == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "showScene", ksVideoPlayConfig.getShowScene());
            C11126t.putValue(jSONObject, "showLandscape", ksVideoPlayConfig.isShowLandscape());
            C11126t.putValue(jSONObject, "skipThirtySecond", ksVideoPlayConfig.isSkipThirtySecond());
            C11126t.putValue(jSONObject, "videoSoundEnable", ksVideoPlayConfig.isVideoSoundEnable());
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static KsVideoPlayConfig m30024b(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            VideoPlayConfigImpl videoPlayConfigImpl = new VideoPlayConfigImpl();
            videoPlayConfigImpl.setShowScene(jSONObject.optString("showScene", null));
            videoPlayConfigImpl.setShowLandscape(jSONObject.optBoolean("showLandscape", false));
            videoPlayConfigImpl.setSkipThirtySecond(jSONObject.optBoolean("skipThirtySecond", false));
            videoPlayConfigImpl.setVideoSoundEnable(jSONObject.optBoolean("videoSoundEnable", true));
            return videoPlayConfigImpl;
        } catch (Exception unused) {
            return new VideoPlayConfigImpl();
        }
    }
}
