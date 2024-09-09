package com.bykv.vk.component.ttvideo.player;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.utils.Util;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class AudioTrackPositionTracker {
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private AudioTimestampPoller audioTimestampPoller;
    private AudioTrack audioTrack;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;
    private Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastRawPlaybackHeadPosition;
    private long latencyUs;
    private final Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface Listener {
        void onInvalidLatency(long j4);

        void onPositionFramesMismatch(long j4, long j5, long j6, long j7);

        void onSystemTimeUsMismatch(long j4, long j5, long j6, long j7);

        void onUnderrun(int i4, long j4);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private @interface PlayState {
    }

    public AudioTrackPositionTracker(Listener listener) {
        this.listener = listener;
        if (Util.SDK_INT >= 18) {
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.playheadOffsets = new long[10];
    }

    private boolean forceHasPendingData() {
        return this.needsPassthroughWorkarounds && this.audioTrack.getPlayState() == 2 && getPlaybackHeadPosition() == 0;
    }

    private long framesToDurationUs(long j4) {
        return (j4 * C.MICROS_PER_SECOND) / this.outputSampleRate;
    }

    private long getPlaybackHeadPosition() {
        AudioTrack audioTrack = this.audioTrack;
        if (this.stopTimestampUs != -9223372036854775807L) {
            return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + ((((SystemClock.elapsedRealtime() * 1000) - this.stopTimestampUs) * this.outputSampleRate) / C.MICROS_PER_SECOND));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & audioTrack.getPlaybackHeadPosition();
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
            }
            playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
        }
        if (Util.SDK_INT <= 28) {
            if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                    this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        }
        if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
            this.rawPlaybackHeadWrapCount++;
        }
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
    }

    private long getPlaybackHeadPositionUs() {
        return framesToDurationUs(getPlaybackHeadPosition());
    }

    public static boolean isEncodingLinearPcm(int i4) {
        return i4 == 3 || i4 == 2 || i4 == Integer.MIN_VALUE || i4 == 1073741824 || i4 == 4;
    }

    private void maybePollAndCheckTimestamp(long j4, long j5) {
        AudioTimestampPoller audioTimestampPoller = this.audioTimestampPoller;
        if (audioTimestampPoller.maybePollTimestamp(j4)) {
            long timestampSystemTimeUs = audioTimestampPoller.getTimestampSystemTimeUs();
            long timestampPositionFrames = audioTimestampPoller.getTimestampPositionFrames();
            if (Math.abs(timestampSystemTimeUs - j4) > 5000000) {
                this.listener.onSystemTimeUsMismatch(timestampPositionFrames, timestampSystemTimeUs, j4, j5);
                audioTimestampPoller.rejectTimestamp();
            } else if (Math.abs(framesToDurationUs(timestampPositionFrames) - j5) > 5000000) {
                this.listener.onPositionFramesMismatch(timestampPositionFrames, timestampSystemTimeUs, j4, j5);
                audioTimestampPoller.rejectTimestamp();
            } else {
                audioTimestampPoller.acceptTimestamp();
            }
        }
    }

    private void maybeSampleSyncParams() {
        long playbackHeadPositionUs = getPlaybackHeadPositionUs();
        if (playbackHeadPositionUs == 0) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.lastPlayheadSampleTimeUs >= PolicyConfig.mServerBusyRetryBaseInternal) {
            long[] jArr = this.playheadOffsets;
            int i4 = this.nextPlayheadOffsetIndex;
            jArr[i4] = playbackHeadPositionUs - nanoTime;
            this.nextPlayheadOffsetIndex = (i4 + 1) % 10;
            int i5 = this.playheadOffsetCount;
            if (i5 < 10) {
                this.playheadOffsetCount = i5 + 1;
            }
            this.lastPlayheadSampleTimeUs = nanoTime;
            this.smoothedPlayheadOffsetUs = 0L;
            int i6 = 0;
            while (true) {
                int i7 = this.playheadOffsetCount;
                if (i6 >= i7) {
                    break;
                }
                this.smoothedPlayheadOffsetUs += this.playheadOffsets[i6] / i7;
                i6++;
            }
        }
        if (this.needsPassthroughWorkarounds) {
            return;
        }
        maybePollAndCheckTimestamp(nanoTime, playbackHeadPositionUs);
        maybeUpdateLatency(nanoTime);
    }

    private void maybeUpdateLatency(long j4) {
        Method method;
        if (!this.isOutputPcm || (method = this.getLatencyMethod) == null || j4 - this.lastLatencySampleTimeUs < 500000) {
            return;
        }
        try {
            long intValue = (((Integer) method.invoke(this.audioTrack, new Object[0])).intValue() * 1000) - this.bufferSizeUs;
            this.latencyUs = intValue;
            long max = Math.max(intValue, 0L);
            this.latencyUs = max;
            if (max > 5000000) {
                this.listener.onInvalidLatency(max);
                this.latencyUs = 0L;
            }
        } catch (Exception unused) {
            this.getLatencyMethod = null;
        }
        this.lastLatencySampleTimeUs = j4;
    }

    private static boolean needsPassthroughWorkarounds(int i4) {
        return Util.SDK_INT < 23 && (i4 == 5 || i4 == 6);
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0L;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0L;
    }

    public int getAvailableBufferSize(long j4) {
        return this.bufferSize - ((int) (j4 - (getPlaybackHeadPosition() * this.outputPcmFrameSize)));
    }

    public long getCurrentPositionUs(boolean z3) {
        long j4;
        if (this.audioTrack.getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long nanoTime = System.nanoTime() / 1000;
        AudioTimestampPoller audioTimestampPoller = this.audioTimestampPoller;
        if (audioTimestampPoller.hasTimestamp()) {
            long framesToDurationUs = framesToDurationUs(audioTimestampPoller.getTimestampPositionFrames());
            return !audioTimestampPoller.isTimestampAdvancing() ? framesToDurationUs : framesToDurationUs + (nanoTime - audioTimestampPoller.getTimestampSystemTimeUs());
        }
        if (this.playheadOffsetCount == 0) {
            j4 = getPlaybackHeadPositionUs();
        } else {
            j4 = nanoTime + this.smoothedPlayheadOffsetUs;
        }
        return !z3 ? j4 - this.latencyUs : j4;
    }

    public void handleEndOfStream(long j4) {
        this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
        this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
        this.endPlaybackHeadPosition = j4;
    }

    public boolean hasPendingData(long j4) {
        return j4 > getPlaybackHeadPosition() || forceHasPendingData();
    }

    public boolean isPlaying() {
        return this.audioTrack.getPlayState() == 3;
    }

    public boolean isStalled(long j4) {
        return this.forceResetWorkaroundTimeMs != -9223372036854775807L && j4 > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= FORCE_RESET_WORKAROUND_TIMEOUT_MS;
    }

    public boolean mayHandleBuffer(long j4) {
        Listener listener;
        int playState = this.audioTrack.getPlayState();
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2) {
                this.hasData = false;
                return false;
            } else if (playState == 1 && getPlaybackHeadPosition() == 0) {
                return false;
            }
        }
        boolean z3 = this.hasData;
        boolean hasPendingData = hasPendingData(j4);
        this.hasData = hasPendingData;
        if (z3 && !hasPendingData && playState != 1 && (listener = this.listener) != null) {
            listener.onUnderrun(this.bufferSize, this.bufferSizeUs / 1000);
        }
        return true;
    }

    public boolean pause() {
        resetSyncParams();
        if (this.stopTimestampUs == -9223372036854775807L) {
            this.audioTimestampPoller.reset();
            return true;
        }
        return false;
    }

    public void reset() {
        resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }

    public void setAudioTrack(AudioTrack audioTrack, int i4, int i5, int i6) {
        this.audioTrack = audioTrack;
        this.outputPcmFrameSize = i5;
        this.bufferSize = i6;
        this.audioTimestampPoller = new AudioTimestampPoller(audioTrack);
        this.outputSampleRate = audioTrack.getSampleRate();
        this.needsPassthroughWorkarounds = needsPassthroughWorkarounds(i4);
        boolean isEncodingLinearPcm = isEncodingLinearPcm(i4);
        this.isOutputPcm = isEncodingLinearPcm;
        this.bufferSizeUs = isEncodingLinearPcm ? framesToDurationUs(i6 / i5) : -9223372036854775807L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.rawPlaybackHeadWrapCount = 0L;
        this.passthroughWorkaroundPauseOffset = 0L;
        this.hasData = false;
        this.stopTimestampUs = -9223372036854775807L;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.latencyUs = 0L;
    }

    public void start() {
        this.audioTimestampPoller.reset();
    }
}
