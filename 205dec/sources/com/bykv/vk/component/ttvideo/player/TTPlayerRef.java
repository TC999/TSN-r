package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.os.RemoteException;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTPlayerRef extends ITTPlayerRef implements IPlayerNotifyer {
    private static final String TAG = "TTPlayerRef";
    private static String mAppPath;
    private static String mLoadErr;
    private TTPlayerClient mClient;
    private Context mContext;
    private long mId = System.currentTimeMillis();
    private TTPlayer mPlayer;

    public TTPlayerRef(Context context) {
        this.mContext = context;
    }

    public static final synchronized TTPlayerRef create(TTPlayerClient tTPlayerClient, Context context) {
        TTPlayerRef tTPlayerRef;
        synchronized (TTPlayerRef.class) {
            if (mAppPath == null) {
                mAppPath = TTPlayerConfiger.getAppFileCachePath(context);
                try {
                    if (TTPlayer.getAppPath() == null) {
                        TTPlayer.setTempFileDir(mAppPath);
                    }
                } catch (UnsatisfiedLinkError e4) {
                    mLoadErr = e4.getMessage();
                }
            }
            if (mLoadErr == null) {
                tTPlayerRef = new TTPlayerRef(context);
                tTPlayerRef.mClient = tTPlayerClient;
                TTPlayer tTPlayer = new TTPlayer(context, tTPlayerRef.mId);
                tTPlayerRef.mPlayer = tTPlayer;
                tTPlayer.setNotifyer(tTPlayerRef);
            } else {
                throw new UnsatisfiedLinkError(mLoadErr);
            }
        }
        return tTPlayerRef;
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void close() {
        this.mPlayer.close();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected double getDoubleOption(int i4, double d4) {
        return this.mPlayer.getDoubleOption(i4, d4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public float getFloatOption(int i4, float f4) {
        return this.mPlayer.getFloatOption(i4, f4);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int getIntOption(int i4, int i5) {
        return this.mPlayer.getIntOption(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int getLifeId() {
        return this.mPlayer.getIntOption(35, -1);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public long getLongOption(int i4, long j4) {
        return this.mPlayer.getLongOption(i4, j4);
    }

    public long getNativeObject() {
        return this.mPlayer.getNativePlayer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public Object getObjectOption(int i4) {
        return this.mPlayer.getObjectValue(i4);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public String getStringOption(int i4) {
        return this.mPlayer.getStringOption(i4);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int getType() {
        return 1;
    }

    @Override // com.bykv.vk.component.ttvideo.player.IPlayerNotifyer
    public void handleErrorNotify(long j4, int i4, int i5, String str) {
        this.mClient.onPlayLogInfo(i4, i5, str);
    }

    @Override // com.bykv.vk.component.ttvideo.player.IPlayerNotifyer
    public void handlePlayerNotify(long j4, int i4, int i5, int i6, String str) {
        this.mClient.onPlayerNotify(i4, i5, i6, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public boolean isValid() {
        return this.mPlayer != null;
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void mouseEvent(int i4, int i5, int i6) {
        this.mPlayer.mouseEvent(i4, i5, i6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void pause() {
        this.mPlayer.pause();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void prepare() {
        this.mPlayer.prepare();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void prevClose() {
        this.mPlayer.prevClose();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void release() {
        TTPlayer tTPlayer = this.mPlayer;
        this.mPlayer = null;
        tTPlayer.release();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void reset() {
        this.mPlayer.reset();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void rotateCamera(float f4, float f5) {
        this.mPlayer.rotateCamera(f4, f5);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void seekTo(int i4) {
        this.mPlayer.seekTo(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setAudioProcessor(AudioProcessor audioProcessor) {
        this.mPlayer.setAudioProcessor(audioProcessor);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setCacheFile(String str, int i4) {
        this.mPlayer.setCacheFile(str, i4);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setDataSource(String str) {
        this.mPlayer.setDataSource(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setDataSourceFd(int i4) {
        this.mPlayer.setDataSourceFd(i4);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected int setDoubleOption(int i4, double d4) {
        return this.mPlayer.setDoubleOption(i4, d4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setFloatOption(int i4, float f4) {
        return this.mPlayer.setFloatOption(i4, f4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
        this.mPlayer.setFrameMetadataListener(frameMetadataListener);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setIntOption(int i4, int i5) {
        try {
            return this.mPlayer.setIntOption(i4, i5);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setLoadControl(LoadControl loadControl) {
        this.mPlayer.setLoadControl(loadControl);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setLongOption(int i4, long j4) {
        return this.mPlayer.setLongOption(i4, j4);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setLooping(int i4) {
        this.mPlayer.setLooping(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setMaskInfo(MaskInfo maskInfo) {
        this.mPlayer.setMaskInfo(maskInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setMediaTransport(MediaTransport mediaTransport) {
        this.mPlayer.setMediaTransport(mediaTransport);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setNotifyState(long j4) {
        this.mPlayer.setNotifyerState(j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        this.mPlayer.setOnScreenshotListener(onScreenshotListener);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setStringOption(int i4, String str) {
        return this.mPlayer.setStringOption(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setSubInfo(SubInfo subInfo) {
        this.mPlayer.setSubInfo(subInfo);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setSurface(Surface surface) {
        this.mPlayer.setVideoSurface(surface);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setVolume(float f4, float f5) {
        this.mPlayer.setVolume(f4, f5);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void start() {
        this.mPlayer.start();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void stop() {
        this.mPlayer.stop();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void switchStream(int i4, int i5) {
        this.mPlayer.switchStream(i4, i5);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void takeScreenshot() {
        this.mPlayer.takeScreenshot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        this.mPlayer.setDataSource(iMediaDataSource);
    }
}
