package com.kwad.components.core.n.b.c;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoMuteStateChangeListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class a implements IKsMediaPlayer {
    private com.kwad.components.core.video.b Nr;
    private c Ns;
    private VideoMuteStateChangeListener Nt;
    private boolean Nu;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private boolean xN;
    private OfflineOnAudioConflictListener xQ;
    private boolean no = true;
    private int Nv = -1;

    private OfflineOnAudioConflictListener oW() {
        if (this.xQ == null) {
            this.xQ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.n.b.c.a.2
                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeOccupied() {
                    a.this.xN = true;
                    a.b(a.this, false);
                    bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.n.b.c.a.2.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            a.this.Nr.setAudioEnabled(false);
                            if (a.this.Nt != null) {
                                a.this.Nt.onMuteStateChanged(true);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeReleased() {
                    a.this.xN = false;
                }
            };
        }
        return this.xQ;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.Nr.a(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.Nr.a(d.a(getMediaPlayer(), onPreparedListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void clear() {
        this.Nr.clear();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getBufferPercentage() {
        return this.Nr.getBufferPercentage();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getCurrentPlayingUrl() {
        return this.Nr.getCurrentPlayingUrl();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getCurrentPosition() {
        return this.Nr.getCurrentPosition();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getDuration() {
        return this.Nr.getDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMaxVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final IMediaPlayer getMediaPlayer() {
        com.kwad.sdk.core.video.a.c rs = this.Nr.rs();
        if (rs == null) {
            return null;
        }
        c cVar = this.Ns;
        if (cVar == null || cVar.oY() != rs) {
            this.Ns = new c().b(rs);
        }
        return this.Ns;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMediaPlayerType() {
        return this.Nr.getMediaPlayerType();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getPlayDuration() {
        return this.Nr.getPlayDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getStateString(int i4) {
        return com.kwad.components.core.video.b.getStateString(i4);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoHeight() {
        return this.Nr.getVideoHeight();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoWidth() {
        return this.Nr.getVideoWidth();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof b)) {
            com.kwad.sdk.core.e.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
            return;
        }
        DetailVideoView oX = ((b) iKsMediaPlayerView).oX();
        this.mDetailVideoView = oX;
        this.mContext = StubApp.getOrigApplicationContext(oX.getContext().getApplicationContext());
        this.Nr.a(d.a(playVideoInfo), this.mDetailVideoView);
        int i4 = this.Nv;
        if (i4 != -1) {
            setVideoAdaptStrategy(i4);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPlaying() {
        return this.Nr.isPlaying();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPrepared() {
        return this.Nr.isPrepared();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPreparing() {
        return this.Nr.isPreparing();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void notifyOnInfoListener(IMediaPlayer iMediaPlayer, int i4, int i5) {
        if (!(iMediaPlayer instanceof c)) {
            com.kwad.sdk.core.e.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        } else {
            this.Nr.a(((c) iMediaPlayer).oY(), i4, i5);
        }
    }

    public final com.kwad.components.core.video.b oV() {
        return this.Nr;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void onPlayStateChanged(int i4) {
        this.Nr.onPlayStateChanged(i4);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean pause() {
        return this.Nr.pause();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void prepareAsync() {
        this.Nr.prepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoMuteStateListener(VideoMuteStateChangeListener videoMuteStateChangeListener) {
        this.Nt = videoMuteStateChangeListener;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        this.Nr.c(d.a(offlineVideoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback, boolean z3) {
        this.Nr.a(d.a(releaseCallback), z3);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void releaseSync() {
        this.Nr.releaseSync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void removeInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.Nr.b(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resetAndPlay(PlayVideoInfo playVideoInfo) {
        com.kwad.components.core.video.b bVar = this.Nr;
        d.a(playVideoInfo);
        bVar.rv();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void restart() {
        this.Nr.restart();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resume() {
        this.Nr.resume();
        if (this.no || (this.Nu && this.xN)) {
            com.kwad.components.core.s.a.ah(this.mContext).aN(this.Nu);
            if (this.Nu && this.xN) {
                this.xN = false;
                setAudioEnabled(true);
                this.no = true;
            } else if (this.xN) {
                setAudioEnabled(false);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void seekTo(long j4) {
        this.Nr.seekTo(j4);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setAudioEnabled(final boolean z3) {
        if (z3) {
            com.kwad.components.core.s.a.ah(this.mContext).aN(true);
        }
        if (z3 == this.no) {
            com.kwad.sdk.core.video.a.a.a.ev("autoVoice");
            return;
        }
        this.no = z3;
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.n.b.c.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.Nr.setAudioEnabled(z3);
                if (a.this.Nt != null) {
                    a.this.Nt.onMuteStateChanged(!z3);
                }
            }
        });
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setDataSource(@NonNull PlayVideoInfo playVideoInfo) {
        this.Nr.a(d.a(playVideoInfo));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setForceGetAudioFocus(boolean z3) {
        this.Nu = z3;
        Context context = this.mContext;
        if (context != null) {
            com.kwad.components.core.s.a.ah(context).a(oW());
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setRadius(float f4, float f5, float f6, float f7) {
        this.Nr.setRadius(f4, f5, f6, f7);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSpeed(float f4) {
        this.Nr.setSpeed(f4);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSurface(Surface surface) {
        this.Nr.setSurface(surface);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVideoAdaptStrategy(int i4) {
        this.Nv = i4;
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.g(true, i4);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVolume(float f4, float f5) {
        this.Nr.setVolume(f4, f5);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start() {
        this.Nr.start();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void stopAndPrepareAsync() {
        this.Nr.stopAndPrepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void unRegisterVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        this.Nr.d(d.a(offlineVideoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void updateKsPlayLogParam(KsPlayerLogParams ksPlayerLogParams) {
        this.Nr.a(d.a(ksPlayerLogParams));
    }

    static /* synthetic */ boolean b(a aVar, boolean z3) {
        aVar.no = false;
        return false;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback) {
        this.Nr.a(d.a(releaseCallback));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start(long j4) {
        this.Nr.start(j4);
    }

    public final a a(@NonNull com.kwad.components.core.video.b bVar) {
        ap.checkNotNull(bVar);
        this.Nr = bVar;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release() {
        this.Nr.release();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, boolean z3, boolean z4, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof b)) {
            com.kwad.sdk.core.e.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        } else {
            this.Nr.a(d.a(playVideoInfo), z3, z4, ((b) iKsMediaPlayerView).oX());
        }
    }
}
