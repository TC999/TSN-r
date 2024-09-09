package com.bykv.vk.component.ttvideo.player;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.bykv.vk.component.ttvideo.utils.AVLogger;
import com.bykv.vk.component.ttvideo.utils.Util;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Locale;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AJVoice implements AudioTrack.OnPlaybackPositionUpdateListener {
    private static final int DISCONTINGUNITY_MS = 200;
    private static final int ERROR_FORMAT_ILLEGAL = -12;
    private static final int ERROR_NULL_BUFFER = -10;
    private static final int ERROR_SIZE_ILLEGAL = -11;
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final int MAX_LATENCY_MS = 5000;
    private static final int MIN_LATENCY_CHECK_MS = 500;
    private static final int MS_UNIT = 1000;
    private static final long RELEASE_WORKAROUND_TIME_MS = 80;
    private static final int START_NO_SET = -1;
    private static final int S_FAIL = -1;
    private static final int S_OK = 0;
    private static final long TIME_UNSET = -9223372036854775807L;
    private static final int kNoSettingVolume = -1;
    private AudioTrackPositionTracker audioTrackPositionTracker;
    private byte[] mMinBytes;
    private ConditionVariable mReleasingConditionVariable;
    private static final String TAG = AJVoice.class.getSimpleName();
    private static final int SDK_INT = Build.VERSION.SDK_INT;
    private static boolean mNeedReleaseWorkAround = false;
    private static String mDeviceName = null;
    private AudioTrack mAudioTrack = null;
    private TTPlayer mPlayer = null;
    private int mBlockSize = 2048;
    private int mSampleRate = 44100;
    private int mChannels = 2;
    private int mSampleBytes = 2;
    private int mSampleFormat = 0;
    private int mFrameSamples = 0;
    private AudioManager mAudioManager = null;
    private int mChannelsLayout = 0;
    private int mAudioFormat = 2;
    private float mLeftVolume = -1.0f;
    private int mMaxVolume = 0;
    private volatile boolean mStoped = true;
    private int mSerial = -1;
    private Method getLatencyMethod = null;
    private int mTrackBufferSize = 0;
    private int mLatencyMs = 0;
    private int mBufferSizeMs = 0;
    private long mLastGetLatencyMs = 0;
    private long mWrittenPcmBytes = 0;
    private long lastRawPlaybackHeadPosition = 0;
    private long forceResetWorkaroundTimeMs = -9223372036854775807L;
    private long mStartTime = 0;
    private int mStreamType = 3;
    private int mEnableAudioTrackSmoothClock = 0;
    @Keep
    private long mNativeObject = 0;
    private int mStartMediaTimeMs = -1;

    @CalledByNative
    public AJVoice() {
        if (mDeviceName == null) {
            String str = Build.DEVICE;
            mDeviceName = str;
            if (str.equals("OnePlus6T")) {
                Log.d(TAG, "device need workaround");
                mNeedReleaseWorkAround = true;
            }
        }
    }

    public static int getAudioTrackChannelConfig(int i4) {
        switch (i4) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM;
            case 6:
                return MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
            case 7:
                return 1276;
            case 8:
                int i5 = Build.VERSION.SDK_INT;
                return (i5 < 23 && i5 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int getPcmFrameSize(int i4, int i5) {
        if (i4 != 2) {
            if (i4 == 3) {
                return i5;
            }
            throw new IllegalArgumentException();
        }
        return i5 * 2;
    }

    private long getPlaybackBytes() {
        return getPlaybackHeadPosition() * getPcmFrameSize(this.mAudioFormat, this.mChannels);
    }

    private long getPlaybackHeadPosition() {
        int playState = this.mAudioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & this.mAudioTrack.getPlaybackHeadPosition();
        if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
            if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
            }
            return this.lastRawPlaybackHeadPosition;
        }
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition;
    }

    private long getPlaybackPositionMs() {
        return (getPlaybackHeadPosition() * 1000) / this.mSampleRate;
    }

    private long getWrittenDurationMs() {
        return ((this.mWrittenPcmBytes / getPcmFrameSize(this.mAudioFormat, this.mChannels)) * 1000) / this.mSampleRate;
    }

    private boolean needsReset() {
        return this.forceResetWorkaroundTimeMs != -9223372036854775807L && this.mWrittenPcmBytes > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= FORCE_RESET_WORKAROUND_TIMEOUT_MS;
    }

    private int reconfigure() {
        AudioManager audioManager = (AudioManager) this.mPlayer.getContext().getSystemService("audio");
        this.mAudioManager = audioManager;
        if (audioManager != null) {
            this.mMaxVolume = audioManager.getStreamMaxVolume(this.mStreamType);
        }
        int audioTrackChannelConfig = getAudioTrackChannelConfig(this.mChannels);
        this.mChannelsLayout = audioTrackChannelConfig;
        if (audioTrackChannelConfig == 0) {
            AVLogger.k(TAG, String.format(Locale.US, "not supoort channel:%d", Integer.valueOf(this.mChannels)));
            return -1;
        }
        int i4 = this.mSampleBytes;
        if (i4 == 1) {
            this.mAudioFormat = 3;
        } else if (i4 != 2) {
            return -12;
        } else {
            this.mAudioFormat = 2;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(this.mSampleRate, audioTrackChannelConfig, this.mAudioFormat);
        if (minBufferSize <= 0) {
            String str = TAG;
            Log.e(str, "getMinBufferSize failed, trace: sampleRate = " + this.mSampleRate + ", mChannelsLayout = " + this.mChannelsLayout + ", mAudioFormat = " + this.mAudioFormat);
            return minBufferSize;
        }
        this.mTrackBufferSize = minBufferSize;
        try {
            this.mMinBytes = new byte[minBufferSize];
            this.mBufferSizeMs = ((minBufferSize / getPcmFrameSize(this.mAudioFormat, this.mChannels)) * 1000) / this.mSampleRate;
            String str2 = TAG;
            Log.d(str2, "minbuffersize = " + minBufferSize + ", buffersizeMs = " + this.mBufferSizeMs);
            try {
                AudioTrack audioTrack = new AudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, minBufferSize, 1);
                this.mAudioTrack = audioTrack;
                if (audioTrack.getState() != 1) {
                    try {
                        this.mAudioTrack.release();
                        this.mAudioTrack = null;
                        Log.e(str2, "create audiotrack but failed to initialize");
                        return -3;
                    } catch (Exception unused) {
                        this.mAudioTrack = null;
                        Log.e(TAG, "create audiotrack but failed to initialize");
                        return -3;
                    } catch (Throwable unused2) {
                        this.mAudioTrack = null;
                        Log.e(TAG, "create audiotrack but failed to initialize");
                        return -3;
                    }
                }
                return 0;
            } catch (Throwable th) {
                String str3 = TAG;
                Log.e(str3, "create audio track failed ,detail = " + th);
                return -1;
            }
        } catch (OutOfMemoryError unused3) {
            Log.e(TAG, "out of memory error when new audio buffer for audiotrack");
            return -10;
        }
    }

    private int reset() {
        this.mWrittenPcmBytes = 0L;
        this.mLatencyMs = 0;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.mLastGetLatencyMs = 0L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.mLeftVolume = -1.0f;
        AudioTrack audioTrack = this.mAudioTrack;
        this.mAudioTrack = null;
        try {
            audioTrack.flush();
            audioTrack.release();
        } catch (Exception unused) {
        } catch (Throwable th) {
            reconfigure();
            throw th;
        }
        return reconfigure();
    }

    @CalledByNative
    public void close() {
        final AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            this.mAudioTrack = null;
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.player.AJVoice.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.i(AJVoice.TAG, "start release task");
                        AJVoice.this.releaseTrack(audioTrack);
                    }
                });
            } catch (Throwable th) {
                String str = TAG;
                Log.w(str, "create close thread fail = " + th);
                releaseTrack(audioTrack);
            }
        }
    }

    @CalledByNative
    public void flush() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.reset();
            }
            this.mStartMediaTimeMs = -1;
            this.mAudioTrack.flush();
            if (this.mWrittenPcmBytes > 0) {
                this.mWrittenPcmBytes = 0L;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @CalledByNative
    public int getCurrentPositionMs() {
        AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
        if (audioTrackPositionTracker != null) {
            return this.mStartMediaTimeMs + ((int) (audioTrackPositionTracker.getCurrentPositionUs(false) / 1000));
        }
        return 0;
    }

    @CalledByNative
    public int getEOSDelayMs() {
        return (int) ((getWrittenDurationMs() - getPlaybackPositionMs()) + (getLatency() > 0 ? this.mLatencyMs - this.mBufferSizeMs : 0L));
    }

    @CalledByNative
    public int getLatency() {
        getPlaybackHeadPosition();
        if (this.getLatencyMethod != null) {
            long nanoTime = System.nanoTime() / C.MICROS_PER_SECOND;
            if (nanoTime - this.mLastGetLatencyMs > 500) {
                try {
                    int intValue = ((Integer) this.getLatencyMethod.invoke(this.mAudioTrack, null)).intValue();
                    this.mLatencyMs = intValue;
                    int max = Math.max(intValue, 0);
                    this.mLatencyMs = max;
                    if (max > 5000) {
                        String str = TAG;
                        Log.w(str, "Ignoring impossibly large audio latency: " + this.mLatencyMs);
                        this.mLatencyMs = 0;
                    }
                } catch (Exception unused) {
                    this.getLatencyMethod = null;
                }
                this.mLastGetLatencyMs = nanoTime;
            }
        }
        return this.mLatencyMs;
    }

    @CalledByNative
    public int getMaxVolume() {
        Log.i("ttmn", "getMaxVolume:" + this.mMaxVolume);
        return this.mMaxVolume;
    }

    @CalledByNative
    public int getTrackBufferSize() {
        return this.mTrackBufferSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    @com.bykv.vk.component.ttvideo.player.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float getVolume() {
        /*
            r4 = this;
            com.bykv.vk.component.ttvideo.player.TTPlayer r0 = r4.mPlayer
            r1 = 0
            if (r0 == 0) goto L22
            float r0 = r4.mLeftVolume
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L22
            android.media.AudioManager r0 = r4.mAudioManager
            if (r0 == 0) goto L22
            int r2 = r4.mStreamType     // Catch: java.lang.Exception -> L22
            int r0 = r0.getStreamMaxVolume(r2)     // Catch: java.lang.Exception -> L22
            android.media.AudioManager r2 = r4.mAudioManager     // Catch: java.lang.Exception -> L20
            int r3 = r4.mStreamType     // Catch: java.lang.Exception -> L20
            int r1 = r2.getStreamVolume(r3)     // Catch: java.lang.Exception -> L20
            goto L23
        L20:
            goto L23
        L22:
            r0 = 0
        L23:
            if (r1 < 0) goto L27
            float r0 = (float) r1
            return r0
        L27:
            if (r0 <= 0) goto L2d
            int r0 = r0 / 4
            float r0 = (float) r0
            return r0
        L2d:
            r0 = 1092616192(0x41200000, float:10.0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.player.AJVoice.getVolume():float");
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onMarkerReached(AudioTrack audioTrack) {
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onPeriodicNotification(AudioTrack audioTrack) {
    }

    @CalledByNative
    public int open(long j4, TTPlayer tTPlayer) {
        this.mPlayer = tTPlayer;
        int reconfigure = reconfigure();
        if (reconfigure == 0) {
            float f4 = this.mLeftVolume;
            if (f4 != -1.0f) {
                setVolume(f4, f4);
            }
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
                } catch (NoSuchMethodException unused) {
                }
            }
        }
        return reconfigure;
    }

    @CalledByNative
    public void pause() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.pause();
            }
            this.mAudioTrack.pause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void releaseTrack(AudioTrack audioTrack) {
        if (audioTrack == null) {
            return;
        }
        try {
            if (mNeedReleaseWorkAround) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
                if (elapsedRealtime <= RELEASE_WORKAROUND_TIME_MS) {
                    Thread.sleep(RELEASE_WORKAROUND_TIME_MS - elapsedRealtime);
                }
            }
        } catch (Exception unused) {
        }
        try {
            audioTrack.release();
        } catch (Exception e4) {
            String str = TAG;
            Log.w(str, "release in invalid state = " + e4);
        }
    }

    @CalledByNative
    public void resume() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                int i4 = this.mAudioFormat;
                audioTrackPositionTracker.setAudioTrack(audioTrack, i4, getPcmFrameSize(i4, this.mChannels), this.mTrackBufferSize);
                this.audioTrackPositionTracker.start();
            }
            this.mAudioTrack.play();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @CalledByNative
    public void setAudioTrackSmoothClock(int i4) {
        if (Util.SDK_INT >= 21) {
            this.mEnableAudioTrackSmoothClock = i4;
            if (i4 > 0) {
                this.audioTrackPositionTracker = new AudioTrackPositionTracker(null);
                this.mReleasingConditionVariable = new ConditionVariable(true);
            }
        }
    }

    @CalledByNative
    public void setSampleInfo(int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mSampleRate = i5;
        this.mChannels = i6;
        this.mBlockSize = i7;
        this.mSampleBytes = i9;
        this.mSampleFormat = i4;
        this.mFrameSamples = i8;
    }

    @CalledByNative
    public void setStreamType(int i4) {
        String str = TAG;
        Log.d(str, "set Stream type : " + i4);
        this.mStreamType = i4;
        if (this.mPlayer != null && reset() == 0) {
            start();
        }
    }

    @CalledByNative
    public void setTrackVolume(float f4, float f5) {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            audioTrack.setStereoVolume(f4, f5);
        }
    }

    @CalledByNative
    public void setVolume(float f4, float f5) {
        AudioTrack audioTrack;
        try {
            int i4 = this.mMaxVolume;
            if (i4 < f4) {
                f4 = i4;
            }
            if (f5 == -1048575.0f && (audioTrack = this.mAudioTrack) != null) {
                audioTrack.setStereoVolume(f4, f5);
            } else {
                AudioManager audioManager = this.mAudioManager;
                if (audioManager != null) {
                    audioManager.setStreamVolume(this.mStreamType, (int) f4, 0);
                }
            }
            this.mLeftVolume = f4;
        } catch (Exception unused) {
        }
    }

    @CalledByNative
    public int start() {
        if (this.mAudioTrack == null) {
            Log.e(TAG, "audiotrack start before created");
            return -2;
        }
        this.mStoped = false;
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                int i4 = this.mAudioFormat;
                audioTrackPositionTracker.setAudioTrack(audioTrack, i4, getPcmFrameSize(i4, this.mChannels), this.mTrackBufferSize);
            }
            this.mAudioTrack.play();
            this.mSerial = -1;
            if (mNeedReleaseWorkAround) {
                this.mStartTime = SystemClock.elapsedRealtime();
            }
            return 0;
        } catch (Throwable th) {
            String str = TAG;
            Log.e(str, "audioTrack start failed = " + th);
            return -3;
        }
    }

    @CalledByNative
    public void stop() {
        if (this.mStoped) {
            return;
        }
        this.mStoped = true;
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.pause();
            }
            this.mAudioTrack.pause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @CalledByNative
    public int write(byte[] bArr, int i4, int i5, int i6) {
        if (bArr != null && bArr.length != 0) {
            int i7 = 0;
            if (this.mStoped) {
                return 0;
            }
            if (this.mSerial != i6) {
                this.mSerial = i6;
                if (this.mWrittenPcmBytes > 0) {
                    this.mAudioTrack.flush();
                }
            }
            try {
                int write = this.mAudioTrack.write(bArr, i4, i5);
                if (write < 0) {
                    Log.e(TAG, "write failed : ret: " + write + ", size = " + i5);
                    return write;
                }
                this.mWrittenPcmBytes += write;
                if (needsReset() && reset() == 0) {
                    i7 = start();
                }
                return i7 == 0 ? write : i7;
            } catch (Exception e4) {
                Log.d(TAG, "write fail = " + e4);
                e4.printStackTrace();
                return -1;
            }
        }
        AVLogger.e(TAG, "buffer is nullpoint");
        return -10;
    }

    @CalledByNative
    public int write(byte[] bArr, int i4, int i5, int i6, long j4) {
        if (bArr != null && bArr.length != 0) {
            int i7 = 0;
            if (this.mStoped) {
                return 0;
            }
            if (this.mSerial != i6) {
                this.mSerial = i6;
                AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
                if (audioTrackPositionTracker != null && this.mReleasingConditionVariable != null) {
                    if (this.mWrittenPcmBytes > 0) {
                        if (audioTrackPositionTracker.isPlaying()) {
                            this.mAudioTrack.pause();
                        }
                        this.audioTrackPositionTracker.reset();
                        this.mStartMediaTimeMs = -1;
                        this.mReleasingConditionVariable.close();
                        this.mWrittenPcmBytes = 0L;
                        final AudioTrack audioTrack = this.mAudioTrack;
                        this.mAudioTrack = null;
                        AVThreadPool.addTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.player.AJVoice.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    Log.d(AJVoice.TAG, "release old track");
                                    audioTrack.flush();
                                    audioTrack.release();
                                    Log.d(AJVoice.TAG, "release old track done");
                                } finally {
                                    AJVoice.this.mReleasingConditionVariable.open();
                                }
                            }
                        });
                        this.mReleasingConditionVariable.block();
                        reconfigure();
                        start();
                        this.mSerial = i6;
                    }
                } else if (this.mWrittenPcmBytes > 0) {
                    this.mAudioTrack.flush();
                }
            }
            int i8 = this.mStartMediaTimeMs;
            if (i8 == -1) {
                this.mStartMediaTimeMs = (int) Math.max(0L, j4);
            } else {
                long writtenDurationMs = i8 + getWrittenDurationMs();
                if (Math.abs(writtenDurationMs - j4) > FORCE_RESET_WORKAROUND_TIMEOUT_MS) {
                    Log.e(TAG, "Discontinuity detected [expected " + writtenDurationMs + ", got " + j4 + "]");
                    this.mStartMediaTimeMs = (int) (((long) this.mStartMediaTimeMs) + (j4 - writtenDurationMs));
                }
            }
            try {
                int write = this.mAudioTrack.write(bArr, i4, i5);
                if (write < 0) {
                    Log.e(TAG, "write failed : ret: " + write + ", size = " + i5);
                    return write;
                }
                this.mWrittenPcmBytes += write;
                if (needsReset() && reset() == 0) {
                    i7 = start();
                    this.mSerial = i6;
                }
                return i7 == 0 ? write : i7;
            } catch (Exception e4) {
                Log.d(TAG, "write fail = " + e4);
                e4.printStackTrace();
                return -1;
            }
        }
        AVLogger.e(TAG, "buffer is nullpoint");
        return -10;
    }

    @SuppressLint({"NewApi"})
    public int write(ByteBuffer byteBuffer, int i4) {
        if (byteBuffer == null) {
            AVLogger.e(TAG, "buffer is nullpoint");
            return -1;
        } else if (this.mAudioTrack.write(byteBuffer, 0, byteBuffer.capacity()) != byteBuffer.capacity()) {
            return -1;
        } else {
            byteBuffer.flip();
            return 0;
        }
    }
}
