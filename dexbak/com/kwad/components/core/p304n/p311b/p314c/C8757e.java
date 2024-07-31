package com.kwad.components.core.p304n.p311b.p314c;

import android.content.Context;
import com.kwad.components.core.video.C8978b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IVideo;

/* renamed from: com.kwad.components.core.n.b.c.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8757e implements IVideo {
    @Override // com.kwad.components.offline.api.core.video.IVideo
    public final IKsMediaPlayer createMediaPlayer(IKsMediaPlayerView iKsMediaPlayerView) {
        if (iKsMediaPlayerView instanceof C8742b) {
            return new C8738a().m29979a(new C8978b(((C8742b) iKsMediaPlayerView).m29973oX()));
        }
        throw new IllegalArgumentException("playerView not instanceof KsMediaPlayerView");
    }

    @Override // com.kwad.components.offline.api.core.video.IVideo
    public final BaseKsMediaPlayerView createMediaPlayerView(Context context) {
        DetailVideoView detailVideoView = new DetailVideoView(context);
        detailVideoView.setAd(true);
        detailVideoView.setFillXY(true);
        detailVideoView.updateTextureViewGravity(17);
        detailVideoView.m29516g(true, 1);
        return new C8742b(context).m29974a(detailVideoView);
    }
}
