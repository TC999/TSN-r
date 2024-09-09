package com.kwad.components.core.internal.api;

import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    public static String a(KsVideoPlayConfig ksVideoPlayConfig) {
        if (ksVideoPlayConfig == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "showScene", ksVideoPlayConfig.getShowScene());
            t.putValue(jSONObject, "showLandscape", ksVideoPlayConfig.isShowLandscape());
            t.putValue(jSONObject, "skipThirtySecond", ksVideoPlayConfig.isSkipThirtySecond());
            t.putValue(jSONObject, "videoSoundEnable", ksVideoPlayConfig.isVideoSoundEnable());
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static KsVideoPlayConfig b(String str, boolean z3) {
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
