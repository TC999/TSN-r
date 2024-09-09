package kotlin.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.PublishedApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: progressionUtil.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0002\u001a \u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0002\u001a \u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001a \u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0001\u001a \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0001\u00a8\u0006\u000b"}, d2 = {"", "a", "b", "e", "", "f", "c", CampaignEx.JSON_NATIVE_VIDEO_START, "end", "step", "d", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    private static final int a(int i4, int i5, int i6) {
        return e(e(i4, i6) - e(i5, i6), i6);
    }

    private static final long b(long j4, long j5, long j6) {
        return f(f(j4, j6) - f(j5, j6), j6);
    }

    @PublishedApi
    public static final int c(int i4, int i5, int i6) {
        if (i6 > 0) {
            return i4 >= i5 ? i5 : i5 - a(i5, i4, i6);
        } else if (i6 < 0) {
            return i4 <= i5 ? i5 : i5 + a(i4, i5, -i6);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    @PublishedApi
    public static final long d(long j4, long j5, long j6) {
        if (j6 > 0) {
            return j4 >= j5 ? j5 : j5 - b(j5, j4, j6);
        } else if (j6 < 0) {
            return j4 <= j5 ? j5 : j5 + b(j4, j5, -j6);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    private static final int e(int i4, int i5) {
        int i6 = i4 % i5;
        return i6 >= 0 ? i6 : i6 + i5;
    }

    private static final long f(long j4, long j5) {
        long j6 = j4 % j5;
        return j6 >= 0 ? j6 : j6 + j5;
    }
}
