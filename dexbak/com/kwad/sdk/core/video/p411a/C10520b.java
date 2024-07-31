package com.kwad.sdk.core.video.p411a;

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
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.kwad.sdk.core.video.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10520b extends AbstractC10518a {
    private final MediaPlayer aBb;
    private final C10521a aBc;
    private String aBd;
    private MediaDataSource aBe;
    private final Object aBf;
    private boolean aBg;
    private boolean aBh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.video.a.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10521a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        final WeakReference<C10520b> mWeakMediaPlayer;

        C10521a(C10520b c10520b) {
            this.mWeakMediaPlayer = new WeakReference<>(c10520b);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            C10520b c10520b = this.mWeakMediaPlayer.get();
            if (c10520b != null) {
                c10520b.notifyOnBufferingUpdate(i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            C10520b c10520b = this.mWeakMediaPlayer.get();
            if (c10520b != null) {
                c10520b.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            C10520b c10520b = this.mWeakMediaPlayer.get();
            return c10520b != null && c10520b.notifyOnError(i, i2);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            C10520b c10520b = this.mWeakMediaPlayer.get();
            if (c10520b == null) {
                return false;
            }
            if (i == 3) {
                if (c10520b.aBh) {
                    return false;
                }
                C10520b.m25556a(c10520b, true);
                return c10520b.notifyOnInfo(i, i2);
            }
            return c10520b.notifyOnInfo(i, i2);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            C10520b c10520b = this.mWeakMediaPlayer.get();
            if (c10520b != null) {
                c10520b.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            C10520b c10520b = this.mWeakMediaPlayer.get();
            if (c10520b != null) {
                c10520b.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            C10520b c10520b = this.mWeakMediaPlayer.get();
            if (c10520b != null) {
                c10520b.m25564b(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            C10520b c10520b = this.mWeakMediaPlayer.get();
            if (c10520b != null) {
                c10520b.m25562w(i, i2);
            }
        }
    }

    public C10520b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.aBf = obj;
        this.aBh = false;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.aBb = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.aBc = new C10521a(this);
        m25559Ga();
        setLooping(false);
    }

    /* renamed from: FY */
    private void m25560FY() {
        MediaDataSource mediaDataSource = this.aBe;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.aBe = null;
        }
    }

    /* renamed from: Ga */
    private void m25559Ga() {
        this.aBb.setOnPreparedListener(this.aBc);
        this.aBb.setOnBufferingUpdateListener(this.aBc);
        this.aBb.setOnCompletionListener(this.aBc);
        this.aBb.setOnSeekCompleteListener(this.aBc);
        this.aBb.setOnVideoSizeChangedListener(this.aBc);
        this.aBb.setOnErrorListener(this.aBc);
        this.aBb.setOnInfoListener(this.aBc);
        this.aBb.setOnTimedTextListener(this.aBc);
    }

    /* renamed from: Gb */
    private void m25558Gb() {
        this.aBb.setOnPreparedListener(null);
        this.aBb.setOnBufferingUpdateListener(null);
        this.aBb.setOnCompletionListener(null);
        this.aBb.setOnSeekCompleteListener(null);
        this.aBb.setOnVideoSizeChangedListener(null);
        this.aBb.setOnErrorListener(null);
        this.aBb.setOnInfoListener(null);
        this.aBb.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: FZ */
    public final boolean mo25542FZ() {
        this.aBb.prepareAsync();
        m25565FX();
        return true;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final int getAudioSessionId() {
        return this.aBb.getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final String getCurrentPlayingUrl() {
        return "";
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final long getCurrentPosition() {
        try {
            return this.aBb.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final String getDataSource() {
        return this.aBd;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final long getDuration() {
        try {
            return this.aBb.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final int getMediaPlayerType() {
        return 1;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final int getVideoHeight() {
        return this.aBb.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final int getVideoWidth() {
        return this.aBb.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final boolean isLooping() {
        return this.aBb.isLooping();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final boolean isPlaying() {
        try {
            return this.aBb.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void pause() {
        this.aBb.pause();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final boolean prepareAsync() {
        this.aBb.prepareAsync();
        m25565FX();
        return true;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void release() {
        try {
            this.aBg = true;
            this.aBb.release();
            m25560FY();
            resetListeners();
            m25558Gb();
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void reset() {
        try {
            this.aBb.reset();
            this.aBh = false;
        } catch (IllegalStateException unused) {
        }
        m25560FY();
        resetListeners();
        m25559Ga();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void seekTo(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.aBb.seekTo((int) j, 3);
        } else {
            this.aBb.seekTo((int) j);
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setAudioStreamType(int i) {
        this.aBb.setAudioStreamType(i);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setDataSource(Context context, Uri uri) {
        this.aBb.setDataSource(context, uri);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aBf) {
            if (!this.aBg) {
                this.aBb.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setLooping(boolean z) {
        this.aBb.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setScreenOnWhilePlaying(boolean z) {
        this.aBb.setScreenOnWhilePlaying(z);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setSpeed(float f) {
        if (Build.VERSION.SDK_INT >= 23) {
            PlaybackParams playbackParams = this.aBb.getPlaybackParams();
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            playbackParams.setSpeed(f);
            this.aBb.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aBb.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setVolume(float f, float f2) {
        this.aBb.setVolume(f, f2);
        AbstractC10518a.m25563f(f);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void start() {
        this.aBb.start();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void stop() {
        this.aBb.stop();
    }

    /* renamed from: a */
    static /* synthetic */ boolean m25556a(C10520b c10520b, boolean z) {
        c10520b.aBh = true;
        return true;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    @TargetApi(14)
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.aBb.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: a */
    public final void mo25536a(@NonNull C9878b c9878b) {
        if (c9878b.isNoCache) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "video/mp4");
            hashMap.put(HttpHeaders.Names.ACCEPT_RANGES, "bytes");
            hashMap.put("Status", "206");
            hashMap.put("Cache-control", "no-cache");
            setDataSource(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext(), Uri.parse(c9878b.videoUrl), hashMap);
            return;
        }
        setDataSource(c9878b.videoUrl);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setDataSource(FileDescriptor fileDescriptor) {
        this.aBb.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setDataSource(String str) {
        this.aBd = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(IDataSource.f43973c)) {
            this.aBb.setDataSource(parse.getPath());
        } else {
            this.aBb.setDataSource(str);
        }
    }
}
