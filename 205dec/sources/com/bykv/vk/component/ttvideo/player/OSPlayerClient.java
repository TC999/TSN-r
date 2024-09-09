package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.gd.sr.xv;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class OSPlayerClient extends MediaPlayerClient {
    protected MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    protected MediaPlayer.OnCompletionListener mOnCompletionListener;
    protected MediaPlayer.OnErrorListener mOnErrorListener;
    protected MediaPlayer.OnInfoListener mOnInfoListener;
    protected MediaPlayer.OnPreparedListener mOnPreparedListener;
    protected MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    protected MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private android.media.MediaPlayer mPlayer;
    private MediaPlayer mWrapper;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class WrapOnBufferingUpdateListener implements MediaPlayer.OnBufferingUpdateListener {
        private MediaPlayer.OnBufferingUpdateListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener, MediaPlayer mediaPlayer) {
            this.mWrapper = mediaPlayer;
            this.mListener = onBufferingUpdateListener;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(android.media.MediaPlayer mediaPlayer, int i4) {
            this.mListener.onBufferingUpdate(this.mWrapper, i4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class WrapOnCompletionListener implements MediaPlayer.OnCompletionListener {
        private MediaPlayer.OnCompletionListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer mediaPlayer) {
            this.mWrapper = mediaPlayer;
            this.mListener = onCompletionListener;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(android.media.MediaPlayer mediaPlayer) {
            this.mListener.onCompletion(this.mWrapper);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class WrapOnErrorListener implements MediaPlayer.OnErrorListener {
        private MediaPlayer.OnErrorListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnErrorListener(MediaPlayer.OnErrorListener onErrorListener, MediaPlayer mediaPlayer) {
            this.mWrapper = mediaPlayer;
            this.mListener = onErrorListener;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(android.media.MediaPlayer mediaPlayer, int i4, int i5) {
            return this.mListener.onError(this.mWrapper, i4, i5);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class WrapOnInfoListener implements MediaPlayer.OnInfoListener {
        private MediaPlayer.OnInfoListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnInfoListener(MediaPlayer.OnInfoListener onInfoListener, MediaPlayer mediaPlayer) {
            this.mWrapper = mediaPlayer;
            this.mListener = onInfoListener;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(android.media.MediaPlayer mediaPlayer, int i4, int i5) {
            return this.mListener.onInfo(this.mWrapper, i4, i5);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class WrapOnPreparedListener implements MediaPlayer.OnPreparedListener {
        private MediaPlayer.OnPreparedListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener, MediaPlayer mediaPlayer) {
            this.mListener = onPreparedListener;
            this.mWrapper = mediaPlayer;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(android.media.MediaPlayer mediaPlayer) {
            this.mListener.onPrepared(this.mWrapper);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class WrapOnSeekCompleteListener implements MediaPlayer.OnSeekCompleteListener {
        private MediaPlayer.OnSeekCompleteListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener, MediaPlayer mediaPlayer) {
            this.mListener = onSeekCompleteListener;
            this.mWrapper = mediaPlayer;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(android.media.MediaPlayer mediaPlayer) {
            this.mListener.onSeekComplete(this.mWrapper);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class WrapOnVideoSizeChangedListener implements MediaPlayer.OnVideoSizeChangedListener {
        private MediaPlayer.OnVideoSizeChangedListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener, MediaPlayer mediaPlayer) {
            this.mListener = onVideoSizeChangedListener;
            this.mWrapper = mediaPlayer;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(android.media.MediaPlayer mediaPlayer, int i4, int i5) {
            this.mListener.onVideoSizeChanged(this.mWrapper, i4, i5);
        }
    }

    public static final synchronized OSPlayerClient create(MediaPlayer mediaPlayer, Context context) {
        OSPlayerClient oSPlayerClient;
        synchronized (OSPlayerClient.class) {
            oSPlayerClient = new OSPlayerClient();
            oSPlayerClient.mPlayer = new android.media.MediaPlayer();
            oSPlayerClient.mWrapper = mediaPlayer;
        }
        return oSPlayerClient;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void deselectTrack(int i4) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.deselectTrack(i4);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public int getCurrentPosition() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.getCurrentPosition();
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public int getDuration() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.getDuration();
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public int getSelectedTrack(int i4) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.getSelectedTrack(i4);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return -1;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        MediaPlayer.TrackInfo[] trackInfoArr;
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                trackInfoArr = mediaPlayer.getTrackInfo();
            } catch (Exception unused) {
                trackInfoArr = null;
            }
            if (trackInfoArr != null) {
                MediaPlayer.TrackInfo[] trackInfoArr2 = new MediaPlayer.TrackInfo[trackInfoArr.length];
                int length = trackInfoArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    trackInfoArr2[i5] = new MediaPlayer.TrackInfo(trackInfoArr[i4]);
                    i4++;
                    i5++;
                }
            }
        }
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public int getType() {
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public int getVideoHeight() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.getVideoHeight();
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public int getVideoWidth() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.getVideoWidth();
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public boolean isLooping() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.isLooping();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public boolean isPlaying() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.isPlaying();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void pause() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.pause();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void prepare() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.prepare();
            } catch (IOException e4) {
                e4.printStackTrace();
            } catch (IllegalStateException e5) {
                e5.printStackTrace();
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void prepareAsync() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.prepareAsync();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void prevClose() {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void release() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.mPlayer = null;
                throw th;
            }
            this.mPlayer = null;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void releaseAsync() {
        new xv(new Runnable() { // from class: com.bykv.vk.component.ttvideo.player.OSPlayerClient.1
            @Override // java.lang.Runnable
            public void run() {
                OSPlayerClient.this.release();
            }
        }, "SPlayerClient").start();
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void reset() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void seekTo(int i4) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.seekTo(i4);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void selectTrack(int i4) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        this.mPlayer.setDataSource(context, uri, map);
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setDisplay(SurfaceHolder surfaceHolder) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.setDisplay(surfaceHolder);
        } catch (Exception unused) {
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
    }

    public void setLoadControl(LoadControl loadControl) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setLooping(boolean z3) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setLooping(z3);
            } catch (Exception unused) {
            }
        }
    }

    public void setMaskInfo(MaskInfo maskInfo) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setMediaTransport(MediaTransport mediaTransport) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
        this.mPlayer.setOnBufferingUpdateListener(new WrapOnBufferingUpdateListener(onBufferingUpdateListener, this.mWrapper));
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
        this.mPlayer.setOnCompletionListener(new WrapOnCompletionListener(onCompletionListener, this.mWrapper));
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
        this.mPlayer.setOnErrorListener(new WrapOnErrorListener(onErrorListener, this.mWrapper));
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener onExternInfoListener) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
        this.mPlayer.setOnInfoListener(new WrapOnInfoListener(onInfoListener, this.mWrapper));
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
        this.mPlayer.setOnPreparedListener(new WrapOnPreparedListener(onPreparedListener, this.mWrapper));
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener onsarchangedlistener) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
        this.mPlayer.setOnSeekCompleteListener(new WrapOnSeekCompleteListener(onSeekCompleteListener, this.mWrapper));
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mPlayer.setOnVideoSizeChangedListener(new WrapOnVideoSizeChangedListener(onVideoSizeChangedListener, this.mWrapper));
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setPlaybackParams(PlaybackParams playbackParams) {
        if (Build.VERSION.SDK_INT >= 23) {
            android.media.PlaybackParams playbackParams2 = new android.media.PlaybackParams();
            float speed = playbackParams.getSpeed();
            if (speed > 0.0f) {
                playbackParams2.setSpeed(speed);
            }
            int audioFallbackMode = playbackParams.getAudioFallbackMode();
            if (audioFallbackMode >= 0) {
                playbackParams2.setAudioFallbackMode(audioFallbackMode);
            }
            float pitch = playbackParams.getPitch();
            if (pitch > 0.0f) {
                playbackParams2.setPitch(pitch);
            }
            android.media.MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.setPlaybackParams(playbackParams2);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setScreenOnWhilePlaying(boolean z3) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setScreenOnWhilePlaying(z3);
            } catch (Exception unused) {
            }
        }
    }

    public void setSubInfo(SubInfo subInfo) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setSurface(Surface surface) {
        this.mPlayer.setSurface(surface);
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setVolume(float f4, float f5) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f4, f5);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setWakeMode(Context context, int i4) {
        this.mPlayer.setWakeMode(context, i4);
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void start() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.start();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void stop() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void switchStream(int i4, int i5) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void takeScreenshot(MediaPlayer.OnScreenshotListener onScreenshotListener) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setDataSource(String str) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        this.mPlayer.setDataSource(str);
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setDataSource(FileDescriptor fileDescriptor, long j4, long j5) throws IllegalStateException, IllegalArgumentException, IOException {
        this.mPlayer.setDataSource(fileDescriptor, j4, j5);
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayerClient
    public void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        this.mPlayer.setDataSource(context, uri);
    }
}
