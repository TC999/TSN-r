package com.bykv.vk.component.ttvideo.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTPlayer {
    private static final String TAG = "TTPlayer";
    private static String mAppPath;
    private static String mCachePath;
    private static String mCrashPath;
    private static ILibraryLoader mDebugLibLoader = new DefaultLibraryLoader(true);
    private static boolean mIsIPCPlayer;
    private static boolean mSetLibraryLoader;
    private static int mSupportSampleRateNB;
    private static int[] mSupportSampleRates;
    private Context mContext;
    private FrameMetadataListener mFrameMetadataListener;
    private long mHandle;
    private long mId;
    @Keep
    private long mMediaDataSource;
    private IPlayerNotifyer mNotifyer;
    private MediaPlayer.OnScreenshotListener mScreenshotListener;
    private long mNotifyerState = Long.MAX_VALUE;
    private int mTracker = 0;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class DefaultLibraryLoader implements ILibraryLoader {
        boolean mLoadLibraryPath;

        public DefaultLibraryLoader(boolean z3) {
            this.mLoadLibraryPath = z3;
        }

        @Override // com.bykv.vk.component.ttvideo.player.ILibraryLoader
        @SuppressLint({"UnsafeDynamicallyLoadedCode"})
        public boolean onLoadNativeLibs(List<String> list) {
            for (String str : list) {
                try {
                    if (this.mLoadLibraryPath) {
                        System.load(str);
                    } else {
                        System.loadLibrary(str);
                    }
                } catch (Throwable th) {
                    String str2 = TTPlayer.TAG;
                    Log.e(str2, "load lib failed = " + th.getMessage());
                    return false;
                }
            }
            return true;
        }
    }

    static {
        synchronized (TTPlayer.class) {
            TTPlayerLibLoader.loadLibrary();
            try {
                detectAudioFormat();
            } catch (UnsatisfiedLinkError e4) {
                String errorInfo = TTPlayerLibLoader.getErrorInfo();
                if (errorInfo != null) {
                    throw new UnsatisfiedLinkError(errorInfo);
                }
                throw e4;
            }
        }
    }

    public TTPlayer(Context context, long j4) throws Exception {
        this.mContext = context;
        create(j4);
    }

    private static final native void _close(long j4);

    private final native long _create(Context context, int i4, String str);

    private static final native String _getAppPath();

    private static final native int _getCurrentPosition(long j4);

    private static final native double _getDoubleValue(long j4, int i4, double d4);

    private static final native int _getDuration(long j4);

    private static final native float _getFloatValue(long j4, int i4, float f4);

    private static final native int _getIntValue(long j4, int i4, int i5);

    private static final native Object _getJObjectValue(long j4, int i4);

    private static final native long _getLongValue(long j4, int i4, long j5);

    private static final native String _getStringValue(long j4, int i4);

    private static final native int _getVideoHeight(long j4);

    private static final native int _getVideoWidth(long j4);

    private static final native int _isLooping(long j4);

    private static final native int _isPlaying(long j4);

    private static final native void _mouseEvent(long j4, int i4, int i5, int i6);

    private static final native int _pause(long j4);

    private static final native int _prepare(long j4);

    private static final native void _prevClose(long j4);

    private static final native void _registerPlayerInfo();

    private static final native void _release(long j4);

    private static final native int _reset(long j4);

    private static final native void _rotateCamera(long j4, float f4, float f5);

    private static final native int _seek(long j4, int i4);

    private static final native void _setAudioProcessor(long j4, AudioProcessor audioProcessor);

    private static final native void _setCacheFile(long j4, String str, int i4);

    private static final native void _setDataSource(long j4, IMediaDataSource iMediaDataSource);

    private static final native void _setDataSource(long j4, String str);

    private static final native void _setDataSourceFd(long j4, int i4);

    private static final native int _setDoubleValue(long j4, int i4, double d4);

    private static final native int _setFloatValue(long j4, int i4, float f4);

    private static final native int _setIntValue(long j4, int i4, int i5);

    private static final native void _setLoadControl(long j4, LoadControl loadControl);

    private static final native int _setLongValue(long j4, int i4, long j5);

    private static final native void _setLooping(long j4, int i4);

    private static final native void _setMaskInfo(long j4, MaskInfo maskInfo);

    private static final native void _setMediaTransport(long j4, MediaTransport mediaTransport);

    private static final native int _setStringValue(long j4, int i4, String str);

    private static final native void _setSubInfo(long j4, SubInfo subInfo);

    private static final native void _setSupportFormatNB(int i4);

    private static final native void _setSupprotSampleRates(int[] iArr, int i4);

    private static final native int _setSurfaceValue(long j4, long j5);

    private static final native int _setVideoSurface(long j4, Surface surface);

    private static final native void _setVolume(long j4, float f4, float f5);

    private static final native int _start(long j4);

    private static final native void _stop(long j4);

    private static final native void _switchStream(long j4, int i4, int i5);

    private static final native void _takeScreenshot(long j4);

    private static final void checkPlayerModel() {
    }

    private void create(long j4) throws Exception {
        this.mNotifyer = null;
        Context context = this.mContext;
        boolean z3 = mIsIPCPlayer;
        long _create = _create(context, z3 ? 1 : 0, mAppPath);
        this.mHandle = _create;
        this.mId = j4;
        if (_create == 0) {
            throw new Exception("create native player is fail.");
        }
    }

    private static void detectAudioFormat() {
        if (mSupportSampleRateNB == 0) {
            int[] iArr = new int[AudioFormats.getDefaultSampleRatesNB()];
            mSupportSampleRates = iArr;
            int maxSupportedSampleRates = AudioFormats.getMaxSupportedSampleRates(iArr);
            mSupportSampleRateNB = maxSupportedSampleRates;
            _setSupprotSampleRates(mSupportSampleRates, maxSupportedSampleRates);
        }
    }

    public static final String getAppPath() {
        return mAppPath;
    }

    public static final String getCachePath() {
        return mCachePath;
    }

    @CalledByNative
    public static final String getCrashPath() {
        return mCrashPath;
    }

    @CalledByNative
    public static int getThreadPoolStackSize() {
        return TTPlayerConfiger.getValue(25, 32);
    }

    @CalledByNative
    public static boolean isIPPlayer() {
        return mIsIPCPlayer;
    }

    @CalledByNative
    public static int isUsedThreadPool() {
        return TTPlayerConfiger.getValue(24, false) ? 1 : 0;
    }

    public static void registerPlayerInfo() {
        _registerPlayerInfo();
    }

    public static final void setCachePath(String str) {
        mCachePath = str;
    }

    public static final void setCrashPath(String str) {
        mCrashPath = str;
    }

    public static void setIsIPPlayer(boolean z3) {
        mIsIPCPlayer = z3;
    }

    public static final void setTempFileDir(String str) {
        mAppPath = str;
    }

    public int close() {
        long j4 = this.mHandle;
        if (j4 == 0) {
            return -1;
        }
        _close(j4);
        return 0;
    }

    @CalledByNative
    public void frameDTSNotify(int i4, long j4, long j5) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.frameDTSNotify(i4, j5, j4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public double getDoubleOption(int i4, double d4) {
        return _getDoubleValue(this.mHandle, i4, d4);
    }

    public float getFloatOption(int i4, float f4) {
        return _getFloatValue(this.mHandle, i4, f4);
    }

    public final long getHandle() {
        return this.mHandle;
    }

    public int getIntOption(int i4, int i5) {
        if (i4 != 11) {
            if (i4 != 51) {
                switch (i4) {
                    case 1:
                        return _getDuration(this.mHandle);
                    case 2:
                        return _getCurrentPosition(this.mHandle);
                    case 3:
                        return _getVideoWidth(this.mHandle);
                    case 4:
                        return _getVideoHeight(this.mHandle);
                    case 5:
                        return _isLooping(this.mHandle);
                    case 6:
                        return _isPlaying(this.mHandle);
                    default:
                        return _getIntValue(this.mHandle, i4, i5);
                }
            }
            return this.mTracker;
        }
        return _getIntValue(this.mHandle, i4, i5);
    }

    public long getLongOption(int i4, long j4) {
        if (i4 == 50) {
            return this.mHandle;
        }
        return _getLongValue(this.mHandle, i4, j4);
    }

    public long getNativePlayer() {
        return this.mHandle;
    }

    public Object getObjectValue(int i4) {
        return _getJObjectValue(this.mHandle, i4);
    }

    public String getStringOption(int i4) {
        return _getStringValue(this.mHandle, i4);
    }

    public void mouseEvent(int i4, int i5, int i6) {
        _mouseEvent(this.mHandle, i4, i5, i6);
    }

    @CalledByNative
    public void onFrameAboutToBeRendered(int i4, long j4, long j5, Map<Integer, String> map) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.onFrameAboutToBeRendered(i4, j4, j5, map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @CalledByNative
    public final void onLogInfo(int i4, int i5, String str) {
        IPlayerNotifyer iPlayerNotifyer = this.mNotifyer;
        if (iPlayerNotifyer != null) {
            try {
                iPlayerNotifyer.handleErrorNotify(this.mId, i4, i5, str);
            } catch (Throwable unused) {
            }
        }
    }

    @CalledByNative
    public void onNotify(int i4, int i5, int i6, String str) {
        if (((this.mNotifyerState >> i5) & 1) != 1) {
            return;
        }
        try {
            IPlayerNotifyer iPlayerNotifyer = this.mNotifyer;
            if (iPlayerNotifyer != null) {
                iPlayerNotifyer.handlePlayerNotify(this.mId, i4, i5, i6, str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int pause() {
        long j4 = this.mHandle;
        if (j4 == 0) {
            return -1;
        }
        return _pause(j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int prepare() {
        long j4 = this.mHandle;
        if (j4 == 0) {
            return -1;
        }
        return _prepare(j4);
    }

    public int prevClose() {
        long j4 = this.mHandle;
        if (j4 == 0) {
            return -1;
        }
        _setVideoSurface(j4, null);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void release() {
        this.mNotifyerState = 0L;
        long j4 = this.mHandle;
        if (j4 != 0) {
            _release(j4);
            this.mHandle = 0L;
        }
        this.mNotifyer = null;
        this.mScreenshotListener = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int reset() {
        long j4 = this.mHandle;
        if (j4 == 0) {
            return -1;
        }
        return _reset(j4);
    }

    public void rotateCamera(float f4, float f5) {
        _rotateCamera(this.mHandle, f4, f5);
    }

    public void seekTo(int i4) {
        _seek(this.mHandle, i4);
    }

    public void setAudioProcessor(AudioProcessor audioProcessor) {
        long j4 = this.mHandle;
        if (j4 != 0) {
            _setAudioProcessor(j4, audioProcessor);
        }
    }

    public void setCacheFile(String str, int i4) {
        _setCacheFile(this.mHandle, str, i4);
    }

    public void setDataSource(String str) {
        long j4 = this.mHandle;
        if (j4 != 0) {
            _setDataSource(j4, str);
        }
    }

    public void setDataSourceFd(int i4) {
        long j4 = this.mHandle;
        if (j4 != 0) {
            _setDataSourceFd(j4, i4);
        }
    }

    public int setDoubleOption(int i4, double d4) {
        return _setDoubleValue(this.mHandle, i4, d4);
    }

    public int setFloatOption(int i4, float f4) {
        return _setFloatValue(this.mHandle, i4, f4);
    }

    public void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
        this.mFrameMetadataListener = frameMetadataListener;
    }

    public int setIntOption(int i4, int i5) throws RemoteException {
        if (i4 == 22) {
            if (i5 == 0) {
                Log.i(TTPlayerConfiger.TAG, "will occur anr crash");
            } else if (i5 == 2) {
                Log.i(TTPlayerConfiger.TAG, "will occur native crash");
            } else if (i5 == 1) {
                Process.killProcess(Process.myPid());
                System.exit(0);
                Log.i(TTPlayerConfiger.TAG, "will occur java crash");
                throw null;
            }
        }
        if (i4 == 111) {
            int[] iArr = TTPlayerKeys.SupportSampleRates;
            int length = iArr.length;
            int[] iArr2 = new int[iArr.length];
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                if (((1 << i7) & i5) == 0) {
                    iArr2[i6] = TTPlayerKeys.SupportSampleRates[i7];
                    i6++;
                }
            }
            _setSupprotSampleRates(iArr2, i6);
            return 0;
        }
        return _setIntValue(this.mHandle, i4, i5);
    }

    public void setLoadControl(LoadControl loadControl) {
        long j4 = this.mHandle;
        if (j4 != 0) {
            _setLoadControl(j4, loadControl);
        }
    }

    public int setLongOption(int i4, long j4) {
        return _setLongValue(this.mHandle, i4, j4);
    }

    public void setLooping(int i4) {
        _setLooping(this.mHandle, i4);
    }

    public void setMaskInfo(MaskInfo maskInfo) {
        long j4 = this.mHandle;
        if (j4 != 0) {
            _setMaskInfo(j4, maskInfo);
        }
    }

    public void setMediaTransport(MediaTransport mediaTransport) {
        long j4 = this.mHandle;
        if (j4 != 0) {
            _setMediaTransport(j4, mediaTransport);
        }
    }

    public void setNotifyer(IPlayerNotifyer iPlayerNotifyer) {
        this.mNotifyer = iPlayerNotifyer;
    }

    public void setNotifyerState(long j4) {
        this.mNotifyerState = j4;
        _setIntValue(this.mHandle, 16, (int) j4);
        _setLongValue(this.mHandle, 16, j4);
    }

    public void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        this.mScreenshotListener = onScreenshotListener;
    }

    public int setStringOption(int i4, String str) {
        return _setStringValue(this.mHandle, i4, str);
    }

    public void setSubInfo(SubInfo subInfo) {
        long j4 = this.mHandle;
        if (j4 != 0) {
            _setSubInfo(j4, subInfo);
        }
    }

    public int setSurfaceValue(long j4) {
        return _setSurfaceValue(this.mHandle, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int setVideoSurface(Surface surface) {
        long j4 = this.mHandle;
        if (j4 != 0) {
            return _setVideoSurface(j4, surface);
        }
        return -1;
    }

    public void setVolume(float f4, float f5) {
        _setVolume(this.mHandle, f4, f5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int start() {
        long j4 = this.mHandle;
        if (j4 == 0) {
            return -1;
        }
        return _start(j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int stop() {
        long j4 = this.mHandle;
        if (j4 != 0) {
            _stop(j4);
            return 0;
        }
        return -1;
    }

    public void switchStream(int i4, int i5) {
        _switchStream(this.mHandle, i4, i5);
    }

    public void takeScreenshot() {
        _takeScreenshot(this.mHandle);
    }

    @CalledByNative
    public final void takeScreenshotComplete(Bitmap bitmap) {
        MediaPlayer.OnScreenshotListener onScreenshotListener = this.mScreenshotListener;
        if (onScreenshotListener != null) {
            onScreenshotListener.onTakeScreenShotCompletion(bitmap);
        }
    }

    @CalledByNative
    public void updateFrameTerminatedDTS(int i4, long j4, long j5) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.updateFrameTerminatedDTS(i4, j5, j4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        long j4 = this.mHandle;
        if (j4 != 0) {
            _setDataSource(j4, iMediaDataSource);
        }
    }
}
