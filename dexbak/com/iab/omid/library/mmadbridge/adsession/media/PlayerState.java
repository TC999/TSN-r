package com.iab.omid.library.mmadbridge.adsession.media;

import com.baidu.mobads.sdk.api.PrerollVideoResponse;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public enum PlayerState {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL(PrerollVideoResponse.NORMAL),
    EXPANDED("expanded"),
    FULLSCREEN("fullscreen");
    
    private final String playerState;

    PlayerState(String str) {
        this.playerState = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.playerState;
    }
}
