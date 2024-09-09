package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class MediaPlayerClient {
    public static final int IsAudioVoiceWaitTimeout = 1;
    public static final int IsBuffering = 0;
    public static final int MAX_LOG_LINES = 40;

    public abstract void deselectTrack(int i4);

    public abstract int getCurrentPosition();

    public String getDataSource() {
        return null;
    }

    public double getDoubleOption(int i4, double d4) {
        return d4;
    }

    public abstract int getDuration();

    public float getFloatOption(int i4, float f4) {
        return f4;
    }

    public int getIntOption(int i4, int i5) {
        return i5;
    }

    public long getLongOption(int i4, long j4) {
        return j4;
    }

    public abstract int getSelectedTrack(int i4);

    public String getStringOption(int i4) {
        return null;
    }

    public abstract MediaPlayer.TrackInfo[] getTrackInfo();

    public abstract int getType();

    public abstract int getVideoHeight();

    public int getVideoType() {
        return 0;
    }

    public abstract int getVideoWidth();

    public abstract boolean isLooping();

    public boolean isMute() {
        return false;
    }

    public abstract boolean isPlaying();

    public void mouseEvent(int i4, int i5, int i6) {
    }

    public abstract void pause();

    public abstract void prepare();

    public abstract void prepareAsync();

    @Deprecated
    public abstract void prevClose();

    public abstract void release();

    public abstract void releaseAsync();

    public abstract void reset();

    public void rotateCamera(float f4, float f5) {
        Log.i(TTPlayerConfiger.TAG, "<MediaPlayerClient.java,rotateCamera,55>rotateCamera is not implemented");
    }

    public abstract void seekTo(int i4);

    public abstract void selectTrack(int i4);

    public void setCacheFile(String str, int i4) {
    }

    public abstract void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(FileDescriptor fileDescriptor, long j4, long j5) throws IllegalStateException, IllegalArgumentException, IOException;

    public abstract void setDataSource(String str) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDisplay(SurfaceHolder surfaceHolder);

    public int setDoubleOption(int i4, double d4) {
        return -1;
    }

    public int setFloatOption(int i4, float f4) {
        return -1;
    }

    public abstract void setFrameMetadataListener(FrameMetadataListener frameMetadataListener);

    public int setIntOption(int i4, int i5) {
        Log.i(TTPlayerConfiger.TAG, "<MediaPlayerClient.java,setIntOption,65>set os player is not inval");
        return -1;
    }

    public void setIsMute(boolean z3) {
    }

    public int setLongOption(int i4, long j4) {
        return -1;
    }

    public abstract void setLooping(boolean z3);

    public abstract void setMediaTransport(MediaTransport mediaTransport);

    public abstract void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    public abstract void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener);

    public abstract void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener);

    public abstract void setOnExternInfoListener(MediaPlayer.OnExternInfoListener onExternInfoListener);

    public abstract void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener);

    public void setOnLogListener(MediaPlayer.OnLogListener onLogListener) {
    }

    public abstract void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener);

    public abstract void setOnSARChangedListener(MediaPlayer.onSARChangedListener onsarchangedlistener);

    public abstract void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    public abstract void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    public void setPanoVideoControlModel(int i4) {
    }

    public abstract void setPlaybackParams(PlaybackParams playbackParams);

    public abstract void setScreenOnWhilePlaying(boolean z3);

    public int setStringOption(int i4, String str) {
        return -1;
    }

    public abstract void setSurface(Surface surface);

    public abstract void setVolume(float f4, float f5);

    public abstract void setWakeMode(Context context, int i4);

    public abstract void start();

    public abstract void stop();

    public abstract void switchStream(int i4, int i5);

    public abstract void takeScreenshot(MediaPlayer.OnScreenshotListener onScreenshotListener);
}
