package com.bytedance.pangle.sdk.component.log.impl.event.policy;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PolicyConfig {
    public static final int BLOCK_TIMEOUT_COUNT = 4;
    public static final long EVENT_LIFE_FOREVER = -1;
    public static final int SAMPLE_STATISTIC_COUNT = 200;
    public static final long THREAD_BLOCK_TIMEOUT = 120000;
    public static final long mRoutineRetryInternal = 15000;
    public static final long mServerBusyRetryBaseInternal = 30000;
    final int mAtMostBatchSendCount;
    final int mMaxCacheCount;

    PolicyConfig(int i4, int i5, long j4) {
        if (i5 >= i4) {
            this.mMaxCacheCount = i4;
            this.mAtMostBatchSendCount = i5;
            return;
        }
        throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
    }

    public static PolicyConfig create(int i4, int i5, long j4) {
        return new PolicyConfig(i4, i5, j4);
    }

    public static PolicyConfig createDefault() {
        return new PolicyConfig(1, 100, 172800000L);
    }

    public static PolicyConfig createFromSetting(int i4, int i5) {
        return new PolicyConfig(i4, i5, 172800000L);
    }

    public static PolicyConfig createHighPriority() {
        return new PolicyConfig(1, 100, -1L);
    }

    public static PolicyConfig createStatsBatchDefault() {
        return new PolicyConfig(3, 100, 172800000L);
    }

    public int getmAtMostBatchSendCount() {
        return this.mAtMostBatchSendCount;
    }

    public int getmMaxCacheCount() {
        return this.mMaxCacheCount;
    }

    public long getmRoutineRetryInternal() {
        return 15000L;
    }
}
