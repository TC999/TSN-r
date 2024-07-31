package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10220r implements InterfaceC10273d<AdInfo.AdFeedInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        m26648a(adFeedInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        return m26647b(adFeedInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26648a(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adFeedInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        adFeedInfo.videoAutoPlayType = jSONObject.optInt("videoAutoPlayType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26647b(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adFeedInfo.videoSoundType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "videoSoundType", i);
        }
        int i2 = adFeedInfo.videoAutoPlayType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "videoAutoPlayType", i2);
        }
        return jSONObject;
    }
}
