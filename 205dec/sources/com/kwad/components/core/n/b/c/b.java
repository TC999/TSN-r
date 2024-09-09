package com.kwad.components.core.n.b.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.sdk.utils.ap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class b extends BaseKsMediaPlayerView {
    private DetailVideoView Ny;

    public b(Context context) {
        super(context);
    }

    public final b a(@NonNull DetailVideoView detailVideoView) {
        ap.checkNotNull(detailVideoView);
        addView(detailVideoView);
        this.Ny = detailVideoView;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void adaptVideoSize(int i4, int i5) {
        this.Ny.adaptVideoSize(i4, i5);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void fixWidth(boolean z3) {
        this.Ny.fixWidth(z3);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final int getTextureViewGravity() {
        return this.Ny.getTextureViewGravity();
    }

    public final DetailVideoView oX() {
        return this.Ny;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setAd(boolean z3) {
        this.Ny.setAd(z3);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setClickListener(final IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
        this.Ny.setClickListener(videoViewClickListener == null ? null : new DetailVideoView.a() { // from class: com.kwad.components.core.n.b.c.b.1
            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickRootView() {
                videoViewClickListener.onClickRootView();
            }

            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickVideoView() {
                videoViewClickListener.onClickVideoView();
            }
        });
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setForce(boolean z3) {
        this.Ny.setForce(z3);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setHorizontalVideo(boolean z3) {
        this.Ny.setHorizontalVideo(z3);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer) {
        if (iKsMediaPlayer instanceof a) {
            this.Ny.setMediaPlayer(((a) iKsMediaPlayer).oV());
            return;
        }
        throw new IllegalArgumentException("mediaPlayer not instanceof KsMediaPlayer");
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setRadius(float f4) {
        this.Ny.setRadius(f4);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void updateTextureViewGravity(int i4) {
        this.Ny.updateTextureViewGravity(i4);
    }
}
