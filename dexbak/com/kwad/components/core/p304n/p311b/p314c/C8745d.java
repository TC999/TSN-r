package com.kwad.components.core.p304n.p311b.p314c;

import android.media.TimedText;
import com.kwad.components.core.video.C8978b;
import com.kwad.components.core.video.InterfaceC8997h;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.video.p411a.InterfaceC10522c;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.core.n.b.c.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8745d {
    /* renamed from: a */
    public static C9878b m29958a(PlayVideoInfo playVideoInfo) {
        if (playVideoInfo == null) {
            return null;
        }
        return new C9878b.C9879a(playVideoInfo.videoUrl).m27469cS(playVideoInfo.manifest).m27474b(m29959a(playVideoInfo.ksplayerLogParams)).m27475a(playVideoInfo.videoPlayerStatus).m27472bl(playVideoInfo.isNoCache).m27477Bb();
    }

    /* renamed from: a */
    public static C9877a m29959a(KsPlayerLogParams ksPlayerLogParams) {
        if (ksPlayerLogParams == null) {
            return null;
        }
        C9877a c9877a = new C9877a();
        c9877a.photoId = ksPlayerLogParams.photoId;
        c9877a.clickTime = ksPlayerLogParams.clickTime;
        c9877a.adStyle = ksPlayerLogParams.adStyle;
        c9877a.contentType = ksPlayerLogParams.contentType;
        return c9877a;
    }

    /* renamed from: a */
    public static InterfaceC10522c.InterfaceC10527e m29966a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener == null) {
            return null;
        }
        return new InterfaceC10522c.InterfaceC10527e() { // from class: com.kwad.components.core.n.b.c.d.1
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10527e
            /* renamed from: a */
            public final void mo25501a(InterfaceC10522c interfaceC10522c) {
                try {
                    IMediaPlayer.OnPreparedListener.this.onPrepared(iMediaPlayer);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
    }

    /* renamed from: a */
    public static InterfaceC10522c.InterfaceC10524b m29969a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener == null) {
            return null;
        }
        return new InterfaceC10522c.InterfaceC10524b() { // from class: com.kwad.components.core.n.b.c.d.4
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10524b
            /* renamed from: oZ */
            public final void mo25499oZ() {
                IMediaPlayer.OnCompletionListener.this.onCompletion(iMediaPlayer);
            }
        };
    }

    /* renamed from: a */
    public static InterfaceC10522c.InterfaceC10523a m29970a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener == null) {
            return null;
        }
        return new InterfaceC10522c.InterfaceC10523a() { // from class: com.kwad.components.core.n.b.c.d.5
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10523a
            /* renamed from: av */
            public final void mo25496av(int i) {
                IMediaPlayer.OnBufferingUpdateListener.this.onBufferingUpdate(iMediaPlayer, i);
            }
        };
    }

    /* renamed from: a */
    public static InterfaceC10522c.InterfaceC10529g m29965a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener == null) {
            return null;
        }
        return new InterfaceC10522c.InterfaceC10529g() { // from class: com.kwad.components.core.n.b.c.d.6
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10529g
            /* renamed from: pa */
            public final void mo25545pa() {
                IMediaPlayer.OnSeekCompleteListener.this.onSeekComplete(iMediaPlayer);
            }
        };
    }

    /* renamed from: a */
    public static InterfaceC10522c.InterfaceC10531i m29963a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return null;
        }
        return new InterfaceC10522c.InterfaceC10531i() { // from class: com.kwad.components.core.n.b.c.d.7
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10531i
            /* renamed from: k */
            public final void mo25500k(int i, int i2) {
                IMediaPlayer.OnVideoSizeChangedListener.this.onVideoSizeChanged(iMediaPlayer, i, i2);
            }
        };
    }

    /* renamed from: a */
    public static InterfaceC10522c.InterfaceC10525c m29968a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener == null) {
            return null;
        }
        return new InterfaceC10522c.InterfaceC10525c() { // from class: com.kwad.components.core.n.b.c.d.8
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10525c
            /* renamed from: l */
            public final boolean mo25498l(int i, int i2) {
                return IMediaPlayer.OnErrorListener.this.onError(iMediaPlayer, i, i2);
            }
        };
    }

    /* renamed from: a */
    public static InterfaceC10522c.InterfaceC10526d m29967a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener == null) {
            return null;
        }
        return new InterfaceC10522c.InterfaceC10526d() { // from class: com.kwad.components.core.n.b.c.d.9
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10526d
            /* renamed from: m */
            public final boolean mo25497m(int i, int i2) {
                return IMediaPlayer.OnInfoListener.this.onInfo(iMediaPlayer, i, i2);
            }
        };
    }

    /* renamed from: a */
    public static InterfaceC10522c.InterfaceC10530h m29964a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener == null) {
            return null;
        }
        return new InterfaceC10522c.InterfaceC10530h() { // from class: com.kwad.components.core.n.b.c.d.10
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10530h
            /* renamed from: a */
            public final void mo25544a(TimedText timedText) {
                IMediaPlayer.OnTimedTextListener.this.onTimedText(iMediaPlayer, timedText);
            }
        };
    }

    /* renamed from: a */
    public static InterfaceC9001k m29961a(final OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        if (offlineVideoPlayStateListener == null) {
            return null;
        }
        return new InterfaceC9001k() { // from class: com.kwad.components.core.n.b.c.d.11
            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                OfflineVideoPlayStateListener.this.onMediaPlayCompleted();
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
                OfflineVideoPlayStateListener.this.onMediaPlayError(i, i2);
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayPaused() {
                OfflineVideoPlayStateListener.this.onMediaPlayPaused();
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayProgress(long j, long j2) {
                OfflineVideoPlayStateListener.this.onMediaPlayProgress(j, j2);
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                OfflineVideoPlayStateListener.this.onMediaPlayStart();
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlaying() {
                OfflineVideoPlayStateListener.this.onMediaPlaying();
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPrepared() {
                OfflineVideoPlayStateListener.this.onMediaPrepared();
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPreparing() {
                OfflineVideoPlayStateListener.this.onMediaPreparing();
            }

            @Override // com.kwad.components.core.video.InterfaceC9001k
            public final void onVideoPlayBufferingPaused() {
                OfflineVideoPlayStateListener.this.onVideoPlayBufferingPaused();
            }

            @Override // com.kwad.components.core.video.InterfaceC9001k
            public final void onVideoPlayBufferingPlaying() {
                OfflineVideoPlayStateListener.this.onVideoPlayBufferingPlaying();
            }
        };
    }

    /* renamed from: a */
    public static InterfaceC8997h m29962a(final OfflineMediaPlayStateListener offlineMediaPlayStateListener) {
        if (offlineMediaPlayStateListener == null) {
            return null;
        }
        return new InterfaceC8997h() { // from class: com.kwad.components.core.n.b.c.d.2
            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                OfflineMediaPlayStateListener.this.onMediaPlayCompleted();
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
                OfflineMediaPlayStateListener.this.onMediaPlayError(i, i2);
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayPaused() {
                OfflineMediaPlayStateListener.this.onMediaPlayPaused();
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayProgress(long j, long j2) {
                OfflineMediaPlayStateListener.this.onMediaPlayProgress(j, j2);
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                OfflineMediaPlayStateListener.this.onMediaPlayStart();
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlaying() {
                OfflineMediaPlayStateListener.this.onMediaPlaying();
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPrepared() {
                OfflineMediaPlayStateListener.this.onMediaPrepared();
            }

            @Override // com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPreparing() {
                OfflineMediaPlayStateListener.this.onMediaPreparing();
            }
        };
    }

    /* renamed from: a */
    public static C8978b.InterfaceC8990a m29960a(final ReleaseCallback releaseCallback) {
        if (releaseCallback == null) {
            return null;
        }
        return new C8978b.InterfaceC8990a() { // from class: com.kwad.components.core.n.b.c.d.3
            @Override // com.kwad.components.core.video.C8978b.InterfaceC8990a
            public final void onReleaseSuccess() {
                ReleaseCallback.this.onReleaseSuccess();
            }
        };
    }
}
