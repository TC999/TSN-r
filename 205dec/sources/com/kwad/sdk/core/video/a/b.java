package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends com.kwad.sdk.core.video.a.a {
    private final MediaPlayer aBb;
    private final a aBc;
    private String aBd;
    private MediaDataSource aBe;
    private final Object aBf;
    private boolean aBg;
    private boolean aBh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        final WeakReference<b> mWeakMediaPlayer;

        a(b bVar) {
            this.mWeakMediaPlayer = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i4) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnBufferingUpdate(i4);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i4, int i5) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnError(i4, i5);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i4, int i5) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar == null) {
                return false;
            }
            if (i4 == 3) {
                if (bVar.aBh) {
                    return false;
                }
                b.a(bVar, true);
                return bVar.notifyOnInfo(i4, i5);
            }
            return bVar.notifyOnInfo(i4, i5);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.b(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i4, int i5) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.w(i4, i5);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.aBf = obj;
        this.aBh = false;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.aBb = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.aBc = new a(this);
        Ga();
        setLooping(false);
    }

    private void FY() {
        MediaDataSource mediaDataSource = this.aBe;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            this.aBe = null;
        }
    }

    private void Ga() {
        this.aBb.setOnPreparedListener(this.aBc);
        this.aBb.setOnBufferingUpdateListener(this.aBc);
        this.aBb.setOnCompletionListener(this.aBc);
        this.aBb.setOnSeekCompleteListener(this.aBc);
        this.aBb.setOnVideoSizeChangedListener(this.aBc);
        this.aBb.setOnErrorListener(this.aBc);
        this.aBb.setOnInfoListener(this.aBc);
        this.aBb.setOnTimedTextListener(this.aBc);
    }

    private void Gb() {
        this.aBb.setOnPreparedListener(null);
        this.aBb.setOnBufferingUpdateListener(null);
        this.aBb.setOnCompletionListener(null);
        this.aBb.setOnSeekCompleteListener(null);
        this.aBb.setOnVideoSizeChangedListener(null);
        this.aBb.setOnErrorListener(null);
        this.aBb.setOnInfoListener(null);
        this.aBb.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean FZ() {
        this.aBb.prepareAsync();
        FX();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aBb.getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        return "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aBb.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aBd;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aBb.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 1;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aBb.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aBb.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aBb.isLooping();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aBb.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aBb.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        this.aBb.prepareAsync();
        FX();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        try {
            this.aBg = true;
            this.aBb.release();
            FY();
            resetListeners();
            Gb();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        try {
            this.aBb.reset();
            this.aBh = false;
        } catch (IllegalStateException unused) {
        }
        FY();
        resetListeners();
        Ga();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j4) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.aBb.seekTo((int) j4, 3);
        } else {
            this.aBb.seekTo((int) j4);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i4) {
        this.aBb.setAudioStreamType(i4);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
        this.aBb.setDataSource(context, uri);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aBf) {
            if (!this.aBg) {
                this.aBb.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z3) {
        this.aBb.setLooping(z3);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z3) {
        this.aBb.setScreenOnWhilePlaying(z3);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f4) {
        if (Build.VERSION.SDK_INT >= 23) {
            PlaybackParams playbackParams = this.aBb.getPlaybackParams();
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            playbackParams.setSpeed(f4);
            this.aBb.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aBb.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f4, float f5) {
        this.aBb.setVolume(f4, f5);
        com.kwad.sdk.core.video.a.a.f(f4);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        this.aBb.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aBb.stop();
    }

    static /* synthetic */ boolean a(b bVar, boolean z3) {
        bVar.aBh = true;
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.aBb.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        if (bVar.isNoCache) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "video/mp4");
            hashMap.put("Accept-Ranges", "bytes");
            hashMap.put("Status", "206");
            hashMap.put("Cache-control", "no-cache");
            setDataSource(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext(), Uri.parse(bVar.videoUrl), hashMap);
            return;
        }
        setDataSource(bVar.videoUrl);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
        this.aBb.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        this.aBd = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.aBb.setDataSource(parse.getPath());
        } else {
            this.aBb.setDataSource(str);
        }
    }
}
