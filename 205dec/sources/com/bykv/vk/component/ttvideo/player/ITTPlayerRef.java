package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.util.Log;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.utils.HardWareInfo;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class ITTPlayerRef {
    public static synchronized ITTPlayerRef create(Context context, TTPlayerClient tTPlayerClient, HashMap<Integer, Integer> hashMap) {
        TTPlayerRef tTPlayerRef;
        synchronized (ITTPlayerRef.class) {
            tTPlayerRef = null;
            if (HardWareInfo.getCpuFamily() == 1 && (tTPlayerRef = TTPlayerRef.create(tTPlayerClient, context)) != null && TTPlayerConfiger.isPrintInfo()) {
                Log.i(TTPlayerConfiger.TAG, "---------->ttplayer on<------------");
            }
            if (tTPlayerRef == null) {
                Log.i(TTPlayerConfiger.TAG, TTPlayerConfiger.getValue(16, "not find start service info."));
                if (hashMap != null && hashMap.get(100).intValue() == 1) {
                    if (hashMap.get(7).intValue() == 0 && hashMap.get(10).intValue() < 3) {
                        hashMap.put(7, 1);
                    }
                } else if (!TTPlayerConfiger.getValue(7, false) && TTPlayerConfiger.getValue(10, 0) < 3) {
                    TTPlayerConfiger.setValue(7, true);
                }
            }
        }
        return tTPlayerRef;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void close();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Context getContext();

    protected abstract double getDoubleOption(int i4, double d4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract float getFloatOption(int i4, float f4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getIntOption(int i4, int i5);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getLifeId();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long getLongOption(int i4, long j4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object getObjectOption(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getStringOption(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getType();

    /* JADX INFO: Access modifiers changed from: protected */
    public void invalid() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isValid();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mouseEvent(int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void pause();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void prepare();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void prevClose();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void release();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void reset();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void rotateCamera(float f4, float f5);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void seekTo(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setAudioProcessor(AudioProcessor audioProcessor);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setCacheFile(String str, int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setDataSource(IMediaDataSource iMediaDataSource);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setDataSource(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setDataSourceFd(int i4);

    protected abstract int setDoubleOption(int i4, double d4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int setFloatOption(int i4, float f4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setFrameMetadataListener(FrameMetadataListener frameMetadataListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int setIntOption(int i4, int i5);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setLoadControl(LoadControl loadControl);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int setLongOption(int i4, long j4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setLooping(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setMaskInfo(MaskInfo maskInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setMediaTransport(MediaTransport mediaTransport);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setNotifyState(long j4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int setStringOption(int i4, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setSubInfo(SubInfo subInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setSurface(Surface surface);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setVolume(float f4, float f5);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void start();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void stop();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void switchStream(int i4, int i5);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void takeScreenshot();
}
