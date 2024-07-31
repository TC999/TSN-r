package kotlin.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0002\u001a \u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0002\u001a \u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001a \u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0001\u001a \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0001¨\u0006\u000b"}, m12616d2 = {"", "a", "b", "e", "", "f", "c", CampaignEx.JSON_NATIVE_VIDEO_START, "end", "step", "d", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.internal.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class progressionUtil {
    /* renamed from: a */
    private static final int m8531a(int i, int i2, int i3) {
        return m8527e(m8527e(i, i3) - m8527e(i2, i3), i3);
    }

    /* renamed from: b */
    private static final long m8530b(long j, long j2, long j3) {
        return m8526f(m8526f(j, j3) - m8526f(j2, j3), j3);
    }

    @PublishedApi
    /* renamed from: c */
    public static final int m8529c(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - m8531a(i2, i, i3);
        } else if (i3 < 0) {
            return i <= i2 ? i2 : i2 + m8531a(i, i2, -i3);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    @PublishedApi
    /* renamed from: d */
    public static final long m8528d(long j, long j2, long j3) {
        if (j3 > 0) {
            return j >= j2 ? j2 : j2 - m8530b(j2, j, j3);
        } else if (j3 < 0) {
            return j <= j2 ? j2 : j2 + m8530b(j, j2, -j3);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    /* renamed from: e */
    private static final int m8527e(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    /* renamed from: f */
    private static final long m8526f(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }
}
