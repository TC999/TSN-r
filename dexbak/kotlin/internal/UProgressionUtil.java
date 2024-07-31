package kotlin.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedUtils;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a*\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0004\u001a*\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0006\u001a*\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0004\u001a*\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m12616d2 = {"Lkotlin/r0;", "a", "b", "c", "(III)I", "Lkotlin/v0;", "(JJJ)J", CampaignEx.JSON_NATIVE_VIDEO_START, "end", "", "step", "d", "", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.internal.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UProgressionUtil {
    /* renamed from: a */
    private static final int m8525a(int i, int i2, int i3) {
        int m8559e = UnsignedUtils.m8559e(i, i3);
        int m8559e2 = UnsignedUtils.m8559e(i2, i3);
        int m8561c = UnsignedUtils.m8561c(m8559e, m8559e2);
        int m7678h = UInt.m7678h(m8559e - m8559e2);
        return m8561c >= 0 ? m7678h : UInt.m7678h(m7678h + i3);
    }

    /* renamed from: b */
    private static final long m8524b(long j, long j2, long j3) {
        long m8555i = UnsignedUtils.m8555i(j, j3);
        long m8555i2 = UnsignedUtils.m8555i(j2, j3);
        int m8557g = UnsignedUtils.m8557g(m8555i, m8555i2);
        long m5889h = ULong.m5889h(m8555i - m8555i2);
        return m8557g >= 0 ? m5889h : ULong.m5889h(m5889h + j3);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: c */
    public static final long m8523c(long j, long j2, long j3) {
        if (j3 > 0) {
            return UnsignedUtils.m8557g(j, j2) >= 0 ? j2 : ULong.m5889h(j2 - m8524b(j2, j, ULong.m5889h(j3)));
        } else if (j3 < 0) {
            return UnsignedUtils.m8557g(j, j2) <= 0 ? j2 : ULong.m5889h(j2 + m8524b(j, j2, ULong.m5889h(-j3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: d */
    public static final int m8522d(int i, int i2, int i3) {
        if (i3 > 0) {
            return UnsignedUtils.m8561c(i, i2) >= 0 ? i2 : UInt.m7678h(i2 - m8525a(i2, i, UInt.m7678h(i3)));
        } else if (i3 < 0) {
            return UnsignedUtils.m8561c(i, i2) <= 0 ? i2 : UInt.m7678h(i2 + m8525a(i, i2, UInt.m7678h(-i3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
