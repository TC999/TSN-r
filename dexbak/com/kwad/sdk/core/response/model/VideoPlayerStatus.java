package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoPlayerStatus extends C10482a implements Serializable {
    private static final long serialVersionUID = -9021213312245598171L;
    public int mVideoPlayerBehavior = 1;
    public int mVideoPlayerType;

    public void setVideoPlayerBehavior(int i) {
        this.mVideoPlayerBehavior = i;
    }

    public void setVideoPlayerType(int i) {
        this.mVideoPlayerType = i;
    }
}
