package com.kwad.components.core.p304n.p311b.p314c;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.video.C8978b;
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
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.video.p411a.InterfaceC10522c;
import com.kwad.sdk.core.video.p411a.p412a.C10519a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11023ap;
import com.kwad.sdk.utils.C11064bn;
import com.stub.StubApp;

/* renamed from: com.kwad.components.core.n.b.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C8738a implements IKsMediaPlayer {

    /* renamed from: Nr */
    private C8978b f28426Nr;

    /* renamed from: Ns */
    private C8744c f28427Ns;

    /* renamed from: Nt */
    private VideoMuteStateChangeListener f28428Nt;

    /* renamed from: Nu */
    private boolean f28429Nu;
    private Context mContext;
    private DetailVideoView mDetailVideoView;

    /* renamed from: xN */
    private boolean f28432xN;

    /* renamed from: xQ */
    private OfflineOnAudioConflictListener f28433xQ;

    /* renamed from: no */
    private boolean f28431no = true;

    /* renamed from: Nv */
    private int f28430Nv = -1;

    /* renamed from: oW */
    private OfflineOnAudioConflictListener m29975oW() {
        if (this.f28433xQ == null) {
            this.f28433xQ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.n.b.c.a.2
                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeOccupied() {
                    C8738a.this.f28432xN = true;
                    C8738a.m29977b(C8738a.this, false);
                    C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.n.b.c.a.2.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C8738a.this.f28426Nr.setAudioEnabled(false);
                            if (C8738a.this.f28428Nt != null) {
                                C8738a.this.f28428Nt.onMuteStateChanged(true);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeReleased() {
                    C8738a.this.f28432xN = false;
                }
            };
        }
        return this.f28433xQ;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.f28426Nr.m29477a(C8745d.m29967a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.f28426Nr.m29476a(C8745d.m29966a(getMediaPlayer(), onPreparedListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void clear() {
        this.f28426Nr.clear();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getBufferPercentage() {
        return this.f28426Nr.getBufferPercentage();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getCurrentPlayingUrl() {
        return this.f28426Nr.getCurrentPlayingUrl();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getCurrentPosition() {
        return this.f28426Nr.getCurrentPosition();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getDuration() {
        return this.f28426Nr.getDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMaxVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final IMediaPlayer getMediaPlayer() {
        InterfaceC10522c m29448rs = this.f28426Nr.m29448rs();
        if (m29448rs == null) {
            return null;
        }
        C8744c c8744c = this.f28427Ns;
        if (c8744c == null || c8744c.m29971oY() != m29448rs) {
            this.f28427Ns = new C8744c().m29972b(m29448rs);
        }
        return this.f28427Ns;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMediaPlayerType() {
        return this.f28426Nr.getMediaPlayerType();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getPlayDuration() {
        return this.f28426Nr.getPlayDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getStateString(int i) {
        return C8978b.getStateString(i);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoHeight() {
        return this.f28426Nr.getVideoHeight();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoWidth() {
        return this.f28426Nr.getVideoWidth();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof C8742b)) {
            C10331c.m26250e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
            return;
        }
        DetailVideoView m29973oX = ((C8742b) iKsMediaPlayerView).m29973oX();
        this.mDetailVideoView = m29973oX;
        this.mContext = StubApp.getOrigApplicationContext(m29973oX.getContext().getApplicationContext());
        this.f28426Nr.m29480a(C8745d.m29958a(playVideoInfo), this.mDetailVideoView);
        int i = this.f28430Nv;
        if (i != -1) {
            setVideoAdaptStrategy(i);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPlaying() {
        return this.f28426Nr.isPlaying();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPrepared() {
        return this.f28426Nr.isPrepared();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPreparing() {
        return this.f28426Nr.isPreparing();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void notifyOnInfoListener(IMediaPlayer iMediaPlayer, int i, int i2) {
        if (!(iMediaPlayer instanceof C8744c)) {
            C10331c.m26250e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        } else {
            this.f28426Nr.m29475a(((C8744c) iMediaPlayer).m29971oY(), i, i2);
        }
    }

    /* renamed from: oV */
    public final C8978b m29976oV() {
        return this.f28426Nr;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void onPlayStateChanged(int i) {
        this.f28426Nr.onPlayStateChanged(i);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean pause() {
        return this.f28426Nr.pause();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void prepareAsync() {
        this.f28426Nr.prepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoMuteStateListener(VideoMuteStateChangeListener videoMuteStateChangeListener) {
        this.f28428Nt = videoMuteStateChangeListener;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        this.f28426Nr.m29464c(C8745d.m29961a(offlineVideoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback, boolean z) {
        this.f28426Nr.m29486a(C8745d.m29960a(releaseCallback), z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void releaseSync() {
        this.f28426Nr.releaseSync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void removeInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.f28426Nr.m29467b(C8745d.m29967a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resetAndPlay(PlayVideoInfo playVideoInfo) {
        C8978b c8978b = this.f28426Nr;
        C8745d.m29958a(playVideoInfo);
        c8978b.m29445rv();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void restart() {
        this.f28426Nr.restart();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resume() {
        this.f28426Nr.resume();
        if (this.f28431no || (this.f28429Nu && this.f28432xN)) {
            C8932a.m29575ah(this.mContext).m29576aN(this.f28429Nu);
            if (this.f28429Nu && this.f28432xN) {
                this.f28432xN = false;
                setAudioEnabled(true);
                this.f28431no = true;
            } else if (this.f28432xN) {
                setAudioEnabled(false);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void seekTo(long j) {
        this.f28426Nr.seekTo(j);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setAudioEnabled(final boolean z) {
        if (z) {
            C8932a.m29575ah(this.mContext).m29576aN(true);
        }
        if (z == this.f28431no) {
            C10519a.m25561ev("autoVoice");
            return;
        }
        this.f28431no = z;
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.n.b.c.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8738a.this.f28426Nr.setAudioEnabled(z);
                if (C8738a.this.f28428Nt != null) {
                    C8738a.this.f28428Nt.onMuteStateChanged(!z);
                }
            }
        });
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setDataSource(@NonNull PlayVideoInfo playVideoInfo) {
        this.f28426Nr.m29481a(C8745d.m29958a(playVideoInfo));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setForceGetAudioFocus(boolean z) {
        this.f28429Nu = z;
        Context context = this.mContext;
        if (context != null) {
            C8932a.m29575ah(context).m29577a(m29975oW());
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setRadius(float f, float f2, float f3, float f4) {
        this.f28426Nr.setRadius(f, f2, f3, f4);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSpeed(float f) {
        this.f28426Nr.setSpeed(f);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSurface(Surface surface) {
        this.f28426Nr.setSurface(surface);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVideoAdaptStrategy(int i) {
        this.f28430Nv = i;
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.m29516g(true, i);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVolume(float f, float f2) {
        this.f28426Nr.setVolume(f, f2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start() {
        this.f28426Nr.start();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void stopAndPrepareAsync() {
        this.f28426Nr.stopAndPrepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void unRegisterVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        this.f28426Nr.m29461d(C8745d.m29961a(offlineVideoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void updateKsPlayLogParam(KsPlayerLogParams ksPlayerLogParams) {
        this.f28426Nr.m29482a(C8745d.m29959a(ksPlayerLogParams));
    }

    /* renamed from: b */
    static /* synthetic */ boolean m29977b(C8738a c8738a, boolean z) {
        c8738a.f28431no = false;
        return false;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback) {
        this.f28426Nr.m29487a(C8745d.m29960a(releaseCallback));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start(long j) {
        this.f28426Nr.start(j);
    }

    /* renamed from: a */
    public final C8738a m29979a(@NonNull C8978b c8978b) {
        C11023ap.checkNotNull(c8978b);
        this.f28426Nr = c8978b;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release() {
        this.f28426Nr.release();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, boolean z, boolean z2, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof C8742b)) {
            C10331c.m26250e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        } else {
            this.f28426Nr.m29478a(C8745d.m29958a(playVideoInfo), z, z2, ((C8742b) iKsMediaPlayerView).m29973oX());
        }
    }
}
