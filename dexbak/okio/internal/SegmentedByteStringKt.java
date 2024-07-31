package okio.internal;

import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections._ArraysJvm;
import kotlin.jvm.internal.C14342f0;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15285q;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: SegmentedByteString.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000P\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a$\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a]\u0010\u0012\u001a\u00020\u0010*\u00020\u00062K\u0010\u0011\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tH\u0080\bø\u0001\u0000\u001aj\u0010\u0012\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012K\u0010\u0011\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tH\u0082\b\u001a\u001d\u0010\u0016\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u0018\u001a\u00020\u0017*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0001*\u00020\u0006H\u0080\b\u001a\r\u0010\u001a\u001a\u00020\n*\u00020\u0006H\u0080\b\u001a%\u0010\u001d\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a-\u0010!\u001a\u00020 *\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a-\u0010!\u001a\u00020 *\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010#\u001a\u00020 *\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\"H\u0080\b\u001a\r\u0010$\u001a\u00020\u0001*\u00020\u0006H\u0080\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, m12616d2 = {"", "", DomainCampaignEx.LOOPBACK_VALUE, "fromIndex", "toIndex", "binarySearch", "Lokio/SegmentedByteString;", "pos", "segment", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "data", IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, "byteCount", "Lkotlin/f1;", CcgConstant.f38549t, "forEachSegment", "beginIndex", "endIndex", "Lokio/ByteString;", "commonSubstring", "", "commonInternalGet", "commonGetSize", "commonToByteArray", "Lokio/Buffer;", "buffer", "commonWrite", AdnName.OTHER, "otherOffset", "", "commonRangeEquals", "", "commonEquals", "commonHashCode", "okio"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SegmentedByteStringKt {
    public static final int binarySearch(@NotNull int[] binarySearch, int i, int i2, int i3) {
        C14342f0.m8184p(binarySearch, "$this$binarySearch");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = binarySearch[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else if (i6 <= i) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString commonEquals, @Nullable Object obj) {
        C14342f0.m8184p(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.size() && commonEquals.rangeEquals(0, byteString, 0, commonEquals.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@NotNull SegmentedByteString commonGetSize) {
        C14342f0.m8184p(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getDirectory$okio()[commonGetSize.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@NotNull SegmentedByteString commonHashCode) {
        C14342f0.m8184p(commonHashCode, "$this$commonHashCode");
        int hashCode$okio = commonHashCode.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = commonHashCode.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (i < length) {
            int i4 = commonHashCode.getDirectory$okio()[length + i];
            int i5 = commonHashCode.getDirectory$okio()[i];
            byte[] bArr = commonHashCode.getSegments$okio()[i];
            int i6 = (i5 - i2) + i4;
            while (i4 < i6) {
                i3 = (i3 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i2 = i5;
        }
        commonHashCode.setHashCode$okio(i3);
        return i3;
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString commonInternalGet, int i) {
        C14342f0.m8184p(commonInternalGet, "$this$commonInternalGet");
        Util.checkOffsetAndCount(commonInternalGet.getDirectory$okio()[commonInternalGet.getSegments$okio().length - 1], i, 1L);
        int segment = segment(commonInternalGet, i);
        return commonInternalGet.getSegments$okio()[segment][(i - (segment == 0 ? 0 : commonInternalGet.getDirectory$okio()[segment - 1])) + commonInternalGet.getDirectory$okio()[commonInternalGet.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString commonRangeEquals, int i, @NotNull ByteString other, int i2, int i3) {
        C14342f0.m8184p(commonRangeEquals, "$this$commonRangeEquals");
        C14342f0.m8184p(other, "other");
        if (i < 0 || i > commonRangeEquals.size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = segment(commonRangeEquals, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : commonRangeEquals.getDirectory$okio()[segment - 1];
            int i6 = commonRangeEquals.getDirectory$okio()[commonRangeEquals.getSegments$okio().length + segment];
            int min = Math.min(i4, (commonRangeEquals.getDirectory$okio()[segment] - i5) + i5) - i;
            if (!other.rangeEquals(i2, commonRangeEquals.getSegments$okio()[segment], i6 + (i - i5), min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull SegmentedByteString commonSubstring, int i, int i2) {
        Object[] m11704M1;
        C14342f0.m8184p(commonSubstring, "$this$commonSubstring");
        if (i >= 0) {
            if (!(i2 <= commonSubstring.size())) {
                throw new IllegalArgumentException(("endIndex=" + i2 + " > length(" + commonSubstring.size() + ')').toString());
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == commonSubstring.size()) {
                    return commonSubstring;
                }
                if (i == i2) {
                    return ByteString.EMPTY;
                }
                int segment = segment(commonSubstring, i);
                int segment2 = segment(commonSubstring, i2 - 1);
                m11704M1 = _ArraysJvm.m11704M1(commonSubstring.getSegments$okio(), segment, segment2 + 1);
                byte[][] bArr = (byte[][]) m11704M1;
                int[] iArr = new int[bArr.length * 2];
                if (segment <= segment2) {
                    int i4 = segment;
                    int i5 = 0;
                    while (true) {
                        iArr[i5] = Math.min(commonSubstring.getDirectory$okio()[i4] - i, i3);
                        int i6 = i5 + 1;
                        iArr[i5 + bArr.length] = commonSubstring.getDirectory$okio()[commonSubstring.getSegments$okio().length + i4];
                        if (i4 == segment2) {
                            break;
                        }
                        i4++;
                        i5 = i6;
                    }
                }
                int i7 = segment != 0 ? commonSubstring.getDirectory$okio()[segment - 1] : 0;
                int length = bArr.length;
                iArr[length] = iArr[length] + (i - i7);
                return new SegmentedByteString(bArr, iArr);
            }
            throw new IllegalArgumentException(("endIndex=" + i2 + " < beginIndex=" + i).toString());
        }
        throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString commonToByteArray) {
        C14342f0.m8184p(commonToByteArray, "$this$commonToByteArray");
        byte[] bArr = new byte[commonToByteArray.size()];
        int length = commonToByteArray.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = commonToByteArray.getDirectory$okio()[length + i];
            int i5 = commonToByteArray.getDirectory$okio()[i];
            int i6 = i5 - i2;
            _ArraysJvm.m11655W0(commonToByteArray.getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public static final void commonWrite(@NotNull SegmentedByteString commonWrite, @NotNull Buffer buffer, int i, int i2) {
        C14342f0.m8184p(commonWrite, "$this$commonWrite");
        C14342f0.m8184p(buffer, "buffer");
        int i3 = i2 + i;
        int segment = segment(commonWrite, i);
        while (i < i3) {
            int i4 = segment == 0 ? 0 : commonWrite.getDirectory$okio()[segment - 1];
            int i5 = commonWrite.getDirectory$okio()[commonWrite.getSegments$okio().length + segment];
            int min = Math.min(i3, (commonWrite.getDirectory$okio()[segment] - i4) + i4) - i;
            int i6 = i5 + (i - i4);
            Segment segment2 = new Segment(commonWrite.getSegments$okio()[segment], i6, i6 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                C14342f0.m8187m(segment3);
                Segment segment4 = segment3.prev;
                C14342f0.m8187m(segment4);
                segment4.push(segment2);
            }
            i += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + commonWrite.size());
    }

    public static final void forEachSegment(@NotNull SegmentedByteString forEachSegment, @NotNull InterfaceC15285q<? super byte[], ? super Integer, ? super Integer, Unit> action) {
        C14342f0.m8184p(forEachSegment, "$this$forEachSegment");
        C14342f0.m8184p(action, "action");
        int length = forEachSegment.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = forEachSegment.getDirectory$okio()[length + i];
            int i4 = forEachSegment.getDirectory$okio()[i];
            action.invoke(forEachSegment.getSegments$okio()[i], Integer.valueOf(i3), Integer.valueOf(i4 - i2));
            i++;
            i2 = i4;
        }
    }

    public static final int segment(@NotNull SegmentedByteString segment, int i) {
        C14342f0.m8184p(segment, "$this$segment");
        int binarySearch = binarySearch(segment.getDirectory$okio(), i + 1, 0, segment.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forEachSegment(SegmentedByteString segmentedByteString, int i, int i2, InterfaceC15285q<? super byte[], ? super Integer, ? super Integer, Unit> interfaceC15285q) {
        int segment = segment(segmentedByteString, i);
        while (i < i2) {
            int i3 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i4 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i2, (segmentedByteString.getDirectory$okio()[segment] - i3) + i3) - i;
            interfaceC15285q.invoke(segmentedByteString.getSegments$okio()[segment], Integer.valueOf(i4 + (i - i3)), Integer.valueOf(min));
            i += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString commonRangeEquals, int i, @NotNull byte[] other, int i2, int i3) {
        C14342f0.m8184p(commonRangeEquals, "$this$commonRangeEquals");
        C14342f0.m8184p(other, "other");
        if (i < 0 || i > commonRangeEquals.size() - i3 || i2 < 0 || i2 > other.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = segment(commonRangeEquals, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : commonRangeEquals.getDirectory$okio()[segment - 1];
            int i6 = commonRangeEquals.getDirectory$okio()[commonRangeEquals.getSegments$okio().length + segment];
            int min = Math.min(i4, (commonRangeEquals.getDirectory$okio()[segment] - i5) + i5) - i;
            if (!Util.arrayRangeEquals(commonRangeEquals.getSegments$okio()[segment], i6 + (i - i5), other, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }
}
