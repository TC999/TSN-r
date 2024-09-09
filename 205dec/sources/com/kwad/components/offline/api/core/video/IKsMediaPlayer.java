package com.kwad.components.offline.api.core.video;

import android.view.Surface;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoMuteStateChangeListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IKsMediaPlayer {
    void addOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener);

    void addOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener);

    void clear();

    int getBufferPercentage();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    long getDuration();

    int getMaxVolume();

    IMediaPlayer getMediaPlayer();

    int getMediaPlayerType();

    long getPlayDuration();

    String getStateString(int i4);

    int getVideoHeight();

    int getVideoWidth();

    int getVolume();

    void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, @NonNull IKsMediaPlayerView iKsMediaPlayerView);

    void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, boolean z3, boolean z4, @NonNull IKsMediaPlayerView iKsMediaPlayerView);

    boolean isPlaying();

    boolean isPrepared();

    boolean isPreparing();

    void notifyOnInfoListener(IMediaPlayer iMediaPlayer, int i4, int i5);

    void onPlayStateChanged(int i4);

    boolean pause();

    void prepareAsync();

    void registerVideoMuteStateListener(VideoMuteStateChangeListener videoMuteStateChangeListener);

    void registerVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener);

    void release();

    void release(ReleaseCallback releaseCallback);

    void release(ReleaseCallback releaseCallback, boolean z3);

    void releaseSync();

    void removeInfoListener(IMediaPlayer.OnInfoListener onInfoListener);

    void resetAndPlay(PlayVideoInfo playVideoInfo);

    void restart();

    void resume();

    void seekTo(long j4);

    void setAudioEnabled(boolean z3);

    void setDataSource(@NonNull PlayVideoInfo playVideoInfo);

    void setForceGetAudioFocus(boolean z3);

    void setRadius(float f4, float f5, float f6, float f7);

    void setSpeed(float f4);

    void setSurface(Surface surface);

    void setVideoAdaptStrategy(int i4);

    void setVolume(float f4, float f5);

    void start();

    void start(long j4);

    void stopAndPrepareAsync();

    void unRegisterVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener);

    void updateKsPlayLogParam(KsPlayerLogParams ksPlayerLogParams);
}
