package com.kwad.components.core.p304n.p311b.p314c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.sdk.utils.C11023ap;

/* renamed from: com.kwad.components.core.n.b.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C8742b extends BaseKsMediaPlayerView {

    /* renamed from: Ny */
    private DetailVideoView f28438Ny;

    public C8742b(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final C8742b m29974a(@NonNull DetailVideoView detailVideoView) {
        C11023ap.checkNotNull(detailVideoView);
        addView(detailVideoView);
        this.f28438Ny = detailVideoView;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void adaptVideoSize(int i, int i2) {
        this.f28438Ny.adaptVideoSize(i, i2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void fixWidth(boolean z) {
        this.f28438Ny.fixWidth(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final int getTextureViewGravity() {
        return this.f28438Ny.getTextureViewGravity();
    }

    /* renamed from: oX */
    public final DetailVideoView m29973oX() {
        return this.f28438Ny;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setAd(boolean z) {
        this.f28438Ny.setAd(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setClickListener(final IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
        this.f28438Ny.setClickListener(videoViewClickListener == null ? null : new DetailVideoView.InterfaceC8960a() { // from class: com.kwad.components.core.n.b.c.b.1
            @Override // com.kwad.components.core.video.DetailVideoView.InterfaceC8960a
            public final void onClickRootView() {
                videoViewClickListener.onClickRootView();
            }

            @Override // com.kwad.components.core.video.DetailVideoView.InterfaceC8960a
            public final void onClickVideoView() {
                videoViewClickListener.onClickVideoView();
            }
        });
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setForce(boolean z) {
        this.f28438Ny.setForce(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setHorizontalVideo(boolean z) {
        this.f28438Ny.setHorizontalVideo(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer) {
        if (iKsMediaPlayer instanceof C8738a) {
            this.f28438Ny.setMediaPlayer(((C8738a) iKsMediaPlayer).m29976oV());
            return;
        }
        throw new IllegalArgumentException("mediaPlayer not instanceof KsMediaPlayer");
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setRadius(float f) {
        this.f28438Ny.setRadius(f);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void updateTextureViewGravity(int i) {
        this.f28438Ny.updateTextureViewGravity(i);
    }
}
