package com.bykv.vk.openvk.component.video.c.sr;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.component.sdk.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bykv.vk.openvk.component.video.c.sr.c {

    /* renamed from: f  reason: collision with root package name */
    private final Object f25034f;

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f25035r;
    private com.bykv.vk.openvk.component.video.c.c.c sr;
    private Surface ux;

    /* renamed from: w  reason: collision with root package name */
    private final MediaPlayer f25036w;
    private final c xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: c  reason: collision with root package name */
        private final WeakReference<w> f25037c;

        public c(w wVar) {
            this.f25037c = new WeakReference<>(wVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i4) {
            try {
                w wVar = this.f25037c.get();
                if (wVar != null) {
                    wVar.c(i4);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                w wVar = this.f25037c.get();
                if (wVar != null) {
                    wVar.xv();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i4, int i5) {
            try {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO", "onError: ", Integer.valueOf(i4), Integer.valueOf(i5));
                w wVar = this.f25037c.get();
                if (wVar != null) {
                    return wVar.c(i4, i5);
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i4, int i5) {
            try {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO", "onInfo: ");
                w wVar = this.f25037c.get();
                if (wVar != null) {
                    return wVar.w(i4, i5);
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                w wVar = this.f25037c.get();
                if (wVar != null) {
                    wVar.w();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                w wVar = this.f25037c.get();
                if (wVar != null) {
                    wVar.sr();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i4, int i5) {
            try {
                w wVar = this.f25037c.get();
                if (wVar != null) {
                    wVar.c(i4, i5, 1, 1);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }
    }

    public w() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.f25034f = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.f25036w = mediaPlayer;
        }
        c(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "setAudioStreamType error: ", th);
        }
        this.xv = new c(this);
        fp();
    }

    private void c(MediaPlayer mediaPlayer) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 19 || i4 >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object newInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.bykv.vk.openvk.component.video.api.xv.getContext(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, new Handler());
            declaredField.setAccessible(false);
            mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, newInstance, null);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "setSubtitleController error: ", th);
        }
    }

    private void fp() {
        this.f25036w.setOnPreparedListener(this.xv);
        this.f25036w.setOnBufferingUpdateListener(this.xv);
        this.f25036w.setOnCompletionListener(this.xv);
        this.f25036w.setOnSeekCompleteListener(this.xv);
        this.f25036w.setOnVideoSizeChangedListener(this.xv);
        this.f25036w.setOnErrorListener(this.xv);
        this.f25036w.setOnInfoListener(this.xv);
    }

    private void ia() {
        try {
            Surface surface = this.ux;
            if (surface != null) {
                surface.release();
                this.ux = null;
            }
        } catch (Throwable unused) {
        }
    }

    private void ys() {
        com.bykv.vk.openvk.component.video.c.c.c cVar;
        if (Build.VERSION.SDK_INT < 23 || (cVar = this.sr) == null) {
            return;
        }
        try {
            cVar.close();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "releaseMediaDataSource error: ", th);
        }
        this.sr = null;
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void a() throws Throwable {
        try {
            this.f25036w.reset();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "reset error: ", th);
        }
        ys();
        c();
        fp();
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public int bk() {
        MediaPlayer mediaPlayer = this.f25036w;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void ev() {
        MediaPlayer mediaPlayer = this.f25036w;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void f() throws Throwable {
        this.f25036w.stop();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        ia();
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public long gd() {
        try {
            return this.f25036w.getCurrentPosition();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void k() throws Throwable {
        synchronized (this.f25034f) {
            if (!this.f25035r) {
                this.f25036w.release();
                this.f25035r = true;
                ia();
                ys();
                c();
                fp();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public long p() {
        try {
            return this.f25036w.getDuration();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void r() throws Throwable {
        this.f25036w.pause();
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void sr(boolean z3) throws Throwable {
        MediaPlayer mediaPlayer = this.f25036w;
        if (mediaPlayer == null) {
            return;
        }
        if (z3) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public int t() {
        MediaPlayer mediaPlayer = this.f25036w;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void ux() throws Throwable {
        this.f25036w.start();
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void w(boolean z3) throws Throwable {
        this.f25036w.setScreenOnWhilePlaying(z3);
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void xv(boolean z3) throws Throwable {
        this.f25036w.setLooping(z3);
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void c(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.f25034f) {
            try {
                if (!this.f25035r && surfaceHolder != null && surfaceHolder.getSurface() != null && this.f24991c) {
                    this.f25036w.setDisplay(surfaceHolder);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    @TargetApi(14)
    public void c(Surface surface) {
        ia();
        this.ux = surface;
        this.f25036w.setSurface(surface);
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    @RequiresApi(api = 23)
    public void c(com.bykv.vk.openvk.component.video.api.w wVar) throws Throwable {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f25036w.setPlaybackParams(this.f25036w.getPlaybackParams().setSpeed(wVar.c()));
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void c(String str) throws Throwable {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.f25036w.setDataSource(parse.getPath());
        } else {
            this.f25036w.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void c(FileDescriptor fileDescriptor) throws Throwable {
        this.f25036w.setDataSource(fileDescriptor);
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    @RequiresApi(api = 23)
    public synchronized void c(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        this.sr = com.bykv.vk.openvk.component.video.c.c.c.c(com.bykv.vk.openvk.component.video.api.xv.getContext(), srVar);
        com.bykv.vk.openvk.component.video.c.c.w.xv.c(srVar);
        this.f25036w.setDataSource(this.sr);
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void c(long j4, int i4) throws Throwable {
        if (Build.VERSION.SDK_INT < 26) {
            this.f25036w.seekTo((int) j4);
        } else if (i4 == 0) {
            this.f25036w.seekTo((int) j4, 0);
        } else if (i4 == 1) {
            this.f25036w.seekTo((int) j4, 1);
        } else if (i4 == 2) {
            this.f25036w.seekTo((int) j4, 2);
        } else if (i4 != 3) {
            this.f25036w.seekTo((int) j4);
        } else {
            this.f25036w.seekTo((int) j4, 3);
        }
    }
}
