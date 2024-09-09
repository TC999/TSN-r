package kotlin.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.g1;
import kotlin.r0;
import kotlin.v0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: UProgressionUtil.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a*\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0004\u001a*\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0006\u001a*\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\u0004\u001a*\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\fH\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lkotlin/r0;", "a", "b", "c", "(III)I", "Lkotlin/v0;", "(JJJ)J", CampaignEx.JSON_NATIVE_VIDEO_START, "end", "", "step", "d", "", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    private static final int a(int i4, int i5, int i6) {
        int e4 = g1.e(i4, i6);
        int e5 = g1.e(i5, i6);
        int c4 = g1.c(e4, e5);
        int i7 = r0.i(e4 - e5);
        return c4 >= 0 ? i7 : r0.i(i7 + i6);
    }

    private static final long b(long j4, long j5, long j6) {
        long i4 = g1.i(j4, j6);
        long i5 = g1.i(j5, j6);
        int g4 = g1.g(i4, i5);
        long i6 = v0.i(i4 - i5);
        return g4 >= 0 ? i6 : v0.i(i6 + j6);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final long c(long j4, long j5, long j6) {
        if (j6 > 0) {
            return g1.g(j4, j5) >= 0 ? j5 : v0.i(j5 - b(j5, j4, v0.i(j6)));
        } else if (j6 < 0) {
            return g1.g(j4, j5) <= 0 ? j5 : v0.i(j5 + b(j4, j5, v0.i(-j6)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final int d(int i4, int i5, int i6) {
        if (i6 > 0) {
            return g1.c(i4, i5) >= 0 ? i5 : r0.i(i5 - a(i5, i4, r0.i(i6)));
        } else if (i6 < 0) {
            return g1.c(i4, i5) <= 0 ? i5 : r0.i(i5 + a(i4, i5, r0.i(-i6)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
