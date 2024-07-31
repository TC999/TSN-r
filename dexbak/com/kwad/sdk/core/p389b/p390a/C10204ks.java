package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ks */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10204ks implements InterfaceC10273d<VideoPlayerStatus> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        m26680a(videoPlayerStatus, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        return m26679b(videoPlayerStatus, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26680a(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = jSONObject.optInt("mVideoPlayerType");
        videoPlayerStatus.mVideoPlayerBehavior = jSONObject.optInt("mVideoPlayerBehavior", new Integer("1").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26679b(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = videoPlayerStatus.mVideoPlayerType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "mVideoPlayerType", i);
        }
        C11126t.putValue(jSONObject, "mVideoPlayerBehavior", videoPlayerStatus.mVideoPlayerBehavior);
        return jSONObject;
    }
}
