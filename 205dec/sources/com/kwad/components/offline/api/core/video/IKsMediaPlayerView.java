package com.kwad.components.offline.api.core.video;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IKsMediaPlayerView {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface VideoViewClickListener {
        void onClickRootView();

        void onClickVideoView();
    }

    void adaptVideoSize(int i4, int i5);

    void fixWidth(boolean z3);

    int getTextureViewGravity();

    void setAd(boolean z3);

    void setClickListener(VideoViewClickListener videoViewClickListener);

    void setForce(boolean z3);

    void setHorizontalVideo(boolean z3);

    void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer);

    void setRadius(float f4);

    void updateTextureViewGravity(int i4);
}
