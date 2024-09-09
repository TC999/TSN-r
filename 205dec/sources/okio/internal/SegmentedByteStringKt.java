package okio.internal;

import d2.q;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SegmentedByteString.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a$\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a]\u0010\u0012\u001a\u00020\u0010*\u00020\u00062K\u0010\u0011\u001aG\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tH\u0080\b\u00f8\u0001\u0000\u001aj\u0010\u0012\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012K\u0010\u0011\u001aG\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tH\u0082\b\u001a\u001d\u0010\u0016\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u0018\u001a\u00020\u0017*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0001*\u00020\u0006H\u0080\b\u001a\r\u0010\u001a\u001a\u00020\n*\u00020\u0006H\u0080\b\u001a%\u0010\u001d\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a-\u0010!\u001a\u00020 *\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a-\u0010!\u001a\u00020 *\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010#\u001a\u00020 *\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\"H\u0080\b\u001a\r\u0010$\u001a\u00020\u0001*\u00020\u0006H\u0080\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006%"}, d2 = {"", "", "value", "fromIndex", "toIndex", "binarySearch", "Lokio/SegmentedByteString;", "pos", "segment", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "data", "offset", "byteCount", "Lkotlin/f1;", "action", "forEachSegment", "beginIndex", "endIndex", "Lokio/ByteString;", "commonSubstring", "", "commonInternalGet", "commonGetSize", "commonToByteArray", "Lokio/Buffer;", "buffer", "commonWrite", "other", "otherOffset", "", "commonRangeEquals", "", "commonEquals", "commonHashCode", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SegmentedByteStringKt {
    public static final int binarySearch(@NotNull int[] binarySearch, int i4, int i5, int i6) {
        f0.p(binarySearch, "$this$binarySearch");
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int i9 = binarySearch[i8];
            if (i9 < i4) {
                i5 = i8 + 1;
            } else if (i9 <= i4) {
                return i8;
            } else {
                i7 = i8 - 1;
            }
        }
        return (-i5) - 1;
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString commonEquals, @Nullable Object obj) {
        f0.p(commonEquals, "$this$commonEquals");
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
        f0.p(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getDirectory$okio()[commonGetSize.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@NotNull SegmentedByteString commonHashCode) {
        f0.p(commonHashCode, "$this$commonHashCode");
        int hashCode$okio = commonHashCode.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = commonHashCode.getSegments$okio().length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i4 < length) {
            int i7 = commonHashCode.getDirectory$okio()[length + i4];
            int i8 = commonHashCode.getDirectory$okio()[i4];
            byte[] bArr = commonHashCode.getSegments$okio()[i4];
            int i9 = (i8 - i5) + i7;
            while (i7 < i9) {
                i6 = (i6 * 31) + bArr[i7];
                i7++;
            }
            i4++;
            i5 = i8;
        }
        commonHashCode.setHashCode$okio(i6);
        return i6;
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString commonInternalGet, int i4) {
        f0.p(commonInternalGet, "$this$commonInternalGet");
        Util.checkOffsetAndCount(commonInternalGet.getDirectory$okio()[commonInternalGet.getSegments$okio().length - 1], i4, 1L);
        int segment = segment(commonInternalGet, i4);
        return commonInternalGet.getSegments$okio()[segment][(i4 - (segment == 0 ? 0 : commonInternalGet.getDirectory$okio()[segment - 1])) + commonInternalGet.getDirectory$okio()[commonInternalGet.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString commonRangeEquals, int i4, @NotNull ByteString other, int i5, int i6) {
        f0.p(commonRangeEquals, "$this$commonRangeEquals");
        f0.p(other, "other");
        if (i4 < 0 || i4 > commonRangeEquals.size() - i6) {
            return false;
        }
        int i7 = i6 + i4;
        int segment = segment(commonRangeEquals, i4);
        while (i4 < i7) {
            int i8 = segment == 0 ? 0 : commonRangeEquals.getDirectory$okio()[segment - 1];
            int i9 = commonRangeEquals.getDirectory$okio()[commonRangeEquals.getSegments$okio().length + segment];
            int min = Math.min(i7, (commonRangeEquals.getDirectory$okio()[segment] - i8) + i8) - i4;
            if (!other.rangeEquals(i5, commonRangeEquals.getSegments$okio()[segment], i9 + (i4 - i8), min)) {
                return false;
            }
            i5 += min;
            i4 += min;
            segment++;
        }
        return true;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull SegmentedByteString commonSubstring, int i4, int i5) {
        Object[] M1;
        f0.p(commonSubstring, "$this$commonSubstring");
        if (i4 >= 0) {
            if (!(i5 <= commonSubstring.size())) {
                throw new IllegalArgumentException(("endIndex=" + i5 + " > length(" + commonSubstring.size() + ')').toString());
            }
            int i6 = i5 - i4;
            if (i6 >= 0) {
                if (i4 == 0 && i5 == commonSubstring.size()) {
                    return commonSubstring;
                }
                if (i4 == i5) {
                    return ByteString.EMPTY;
                }
                int segment = segment(commonSubstring, i4);
                int segment2 = segment(commonSubstring, i5 - 1);
                M1 = o.M1(commonSubstring.getSegments$okio(), segment, segment2 + 1);
                byte[][] bArr = (byte[][]) M1;
                int[] iArr = new int[bArr.length * 2];
                if (segment <= segment2) {
                    int i7 = segment;
                    int i8 = 0;
                    while (true) {
                        iArr[i8] = Math.min(commonSubstring.getDirectory$okio()[i7] - i4, i6);
                        int i9 = i8 + 1;
                        iArr[i8 + bArr.length] = commonSubstring.getDirectory$okio()[commonSubstring.getSegments$okio().length + i7];
                        if (i7 == segment2) {
                            break;
                        }
                        i7++;
                        i8 = i9;
                    }
                }
                int i10 = segment != 0 ? commonSubstring.getDirectory$okio()[segment - 1] : 0;
                int length = bArr.length;
                iArr[length] = iArr[length] + (i4 - i10);
                return new SegmentedByteString(bArr, iArr);
            }
            throw new IllegalArgumentException(("endIndex=" + i5 + " < beginIndex=" + i4).toString());
        }
        throw new IllegalArgumentException(("beginIndex=" + i4 + " < 0").toString());
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString commonToByteArray) {
        f0.p(commonToByteArray, "$this$commonToByteArray");
        byte[] bArr = new byte[commonToByteArray.size()];
        int length = commonToByteArray.getSegments$okio().length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            int i7 = commonToByteArray.getDirectory$okio()[length + i4];
            int i8 = commonToByteArray.getDirectory$okio()[i4];
            int i9 = i8 - i5;
            o.W0(commonToByteArray.getSegments$okio()[i4], bArr, i6, i7, i7 + i9);
            i6 += i9;
            i4++;
            i5 = i8;
        }
        return bArr;
    }

    public static final void commonWrite(@NotNull SegmentedByteString commonWrite, @NotNull Buffer buffer, int i4, int i5) {
        f0.p(commonWrite, "$this$commonWrite");
        f0.p(buffer, "buffer");
        int i6 = i5 + i4;
        int segment = segment(commonWrite, i4);
        while (i4 < i6) {
            int i7 = segment == 0 ? 0 : commonWrite.getDirectory$okio()[segment - 1];
            int i8 = commonWrite.getDirectory$okio()[commonWrite.getSegments$okio().length + segment];
            int min = Math.min(i6, (commonWrite.getDirectory$okio()[segment] - i7) + i7) - i4;
            int i9 = i8 + (i4 - i7);
            Segment segment2 = new Segment(commonWrite.getSegments$okio()[segment], i9, i9 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                f0.m(segment3);
                Segment segment4 = segment3.prev;
                f0.m(segment4);
                segment4.push(segment2);
            }
            i4 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + commonWrite.size());
    }

    public static final void forEachSegment(@NotNull SegmentedByteString forEachSegment, @NotNull q<? super byte[], ? super Integer, ? super Integer, f1> action) {
        f0.p(forEachSegment, "$this$forEachSegment");
        f0.p(action, "action");
        int length = forEachSegment.getSegments$okio().length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = forEachSegment.getDirectory$okio()[length + i4];
            int i7 = forEachSegment.getDirectory$okio()[i4];
            action.invoke(forEachSegment.getSegments$okio()[i4], Integer.valueOf(i6), Integer.valueOf(i7 - i5));
            i4++;
            i5 = i7;
        }
    }

    public static final int segment(@NotNull SegmentedByteString segment, int i4) {
        f0.p(segment, "$this$segment");
        int binarySearch = binarySearch(segment.getDirectory$okio(), i4 + 1, 0, segment.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forEachSegment(SegmentedByteString segmentedByteString, int i4, int i5, q<? super byte[], ? super Integer, ? super Integer, f1> qVar) {
        int segment = segment(segmentedByteString, i4);
        while (i4 < i5) {
            int i6 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i5, (segmentedByteString.getDirectory$okio()[segment] - i6) + i6) - i4;
            qVar.invoke(segmentedByteString.getSegments$okio()[segment], Integer.valueOf(i7 + (i4 - i6)), Integer.valueOf(min));
            i4 += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString commonRangeEquals, int i4, @NotNull byte[] other, int i5, int i6) {
        f0.p(commonRangeEquals, "$this$commonRangeEquals");
        f0.p(other, "other");
        if (i4 < 0 || i4 > commonRangeEquals.size() - i6 || i5 < 0 || i5 > other.length - i6) {
            return false;
        }
        int i7 = i6 + i4;
        int segment = segment(commonRangeEquals, i4);
        while (i4 < i7) {
            int i8 = segment == 0 ? 0 : commonRangeEquals.getDirectory$okio()[segment - 1];
            int i9 = commonRangeEquals.getDirectory$okio()[commonRangeEquals.getSegments$okio().length + segment];
            int min = Math.min(i7, (commonRangeEquals.getDirectory$okio()[segment] - i8) + i8) - i4;
            if (!Util.arrayRangeEquals(commonRangeEquals.getSegments$okio()[segment], i9 + (i4 - i8), other, i5, min)) {
                return false;
            }
            i5 += min;
            i4 += min;
            segment++;
        }
        return true;
    }
}
