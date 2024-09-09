package okio.internal;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.C;
import d2.p;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.jvm.internal.f0;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Buffer.kt */
@Metadata(bv = {}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000f\u001a0\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aA\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000b2\u001a\u0010\u0012\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\u0011H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0018\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\bH\u0000\u001a%\u0010\u001c\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u000b*\u00020\nH\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u001e*\u00020\nH\u0080\b\u001a\r\u0010!\u001a\u00020 *\u00020\nH\u0080\b\u001a\r\u0010\"\u001a\u00020\u0002*\u00020\nH\u0080\b\u001a\r\u0010#\u001a\u00020\u000b*\u00020\nH\u0080\b\u001a\u0015\u0010%\u001a\u00020\u001e*\u00020\n2\u0006\u0010$\u001a\u00020\u000bH\u0080\b\u001a\r\u0010'\u001a\u00020&*\u00020\nH\u0080\b\u001a\u0015\u0010(\u001a\u00020&*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a)\u0010+\u001a\u00020\n*\u00020\n2\u0006\u0010*\u001a\u00020)2\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010-\u001a\u00020\n*\u00020\n2\u0006\u0010,\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010.\u001a\u00020\n*\u00020\n2\u0006\u0010,\u001a\u00020\u000bH\u0080\b\u001a\u0015\u00100\u001a\u00020\u0000*\u00020\n2\u0006\u0010/\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010+\u001a\u00020\n*\u00020\n2\u0006\u00101\u001a\u00020\u0004H\u0080\b\u001a%\u0010+\u001a\u00020\n*\u00020\n2\u0006\u00101\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0080\b\u001a\r\u00102\u001a\u00020\u0004*\u00020\nH\u0080\b\u001a\u0015\u00102\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u0015\u00104\u001a\u00020\u0002*\u00020\n2\u0006\u00103\u001a\u00020\u0004H\u0080\b\u001a\u0015\u00105\u001a\u00020&*\u00020\n2\u0006\u00103\u001a\u00020\u0004H\u0080\b\u001a%\u00104\u001a\u00020\u0002*\u00020\n2\u0006\u00103\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0080\b\u001a\r\u00106\u001a\u00020\u000b*\u00020\nH\u0080\b\u001a\r\u00107\u001a\u00020\u000b*\u00020\nH\u0080\b\u001a\r\u00108\u001a\u00020)*\u00020\nH\u0080\b\u001a\u0015\u00108\u001a\u00020)*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u0015\u00109\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0080\b\u001a\u001d\u00105\u001a\u00020&*\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010;\u001a\u00020\u000b*\u00020\n2\u0006\u00103\u001a\u00020:H\u0080\b\u001a\u0015\u0010<\u001a\u00020\r*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u000f\u0010=\u001a\u0004\u0018\u00010\r*\u00020\nH\u0080\b\u001a\u0015\u0010?\u001a\u00020\r*\u00020\n2\u0006\u0010>\u001a\u00020\u000bH\u0080\b\u001a\r\u0010@\u001a\u00020\u0002*\u00020\nH\u0080\b\u001a%\u0010D\u001a\u00020\n*\u00020\n2\u0006\u0010A\u001a\u00020\r2\u0006\u0010B\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010F\u001a\u00020\n*\u00020\n2\u0006\u0010E\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010H\u001a\u00020\u000b*\u00020\n2\u0006\u00101\u001a\u00020GH\u0080\b\u001a\u001d\u0010+\u001a\u00020\n*\u00020\n2\u0006\u00101\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010J\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010,\u001a\u00020\u000bH\u0080\b\u001a\u001d\u0010+\u001a\u00020&*\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u001d\u00104\u001a\u00020\u000b*\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a%\u0010Q\u001a\u00020\u000b*\u00020\n2\u0006\u0010I\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000bH\u0080\b\u001a\u001d\u0010Q\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u000bH\u0080\b\u001a\u001d\u0010S\u001a\u00020\u000b*\u00020\n2\u0006\u0010R\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u000bH\u0080\b\u001a-\u0010T\u001a\u00020\b*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0080\b\u001a\u0017\u0010W\u001a\u00020\b*\u00020\n2\b\u0010V\u001a\u0004\u0018\u00010UH\u0080\b\u001a\r\u0010X\u001a\u00020\u0002*\u00020\nH\u0080\b\u001a\r\u0010Y\u001a\u00020\n*\u00020\nH\u0080\b\u001a\r\u0010Z\u001a\u00020)*\u00020\nH\u0080\b\u001a\u0015\u0010Z\u001a\u00020)*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0002H\u0080\b\"\u001a\u0010[\u001a\u00020\u00048\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0014\u0010_\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b_\u0010`\"\u0014\u0010a\u001a\u00020\u000b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\ba\u0010b\"\u0014\u0010c\u001a\u00020\u000b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\bc\u0010b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006d"}, d2 = {"Lokio/Segment;", "segment", "", "segmentPos", "", "bytes", "bytesOffset", "bytesLimit", "", "rangeEquals", "Lokio/Buffer;", "", "newline", "", "readUtf8Line", "T", "fromIndex", "Lkotlin/Function2;", "lambda", "seek", "(Lokio/Buffer;JLd2/p;)Ljava/lang/Object;", "Lokio/Options;", "options", "selectTruncated", "selectPrefix", "out", "offset", "byteCount", "commonCopyTo", "commonCompleteSegmentByteCount", "", "commonReadByte", "", "commonReadShort", "commonReadInt", "commonReadLong", "pos", "commonGet", "Lkotlin/f1;", "commonClear", "commonSkip", "Lokio/ByteString;", "byteString", "commonWrite", "v", "commonWriteDecimalLong", "commonWriteHexadecimalUnsignedLong", "minimumCapacity", "commonWritableSegment", "source", "commonReadByteArray", "sink", "commonRead", "commonReadFully", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonReadByteString", "commonSelect", "Lokio/Sink;", "commonReadAll", "commonReadUtf8", "commonReadUtf8Line", "limit", "commonReadUtf8LineStrict", "commonReadUtf8CodePoint", "string", "beginIndex", "endIndex", "commonWriteUtf8", "codePoint", "commonWriteUtf8CodePoint", "Lokio/Source;", "commonWriteAll", "b", "commonWriteByte", "s", "commonWriteShort", "i", "commonWriteInt", "commonWriteLong", "toIndex", "commonIndexOf", "targetBytes", "commonIndexOfElement", "commonRangeEquals", "", "other", "commonEquals", "commonHashCode", "commonCopy", "commonSnapshot", "HEX_DIGIT_BYTES", "[B", "getHEX_DIGIT_BYTES", "()[B", "SEGMENTING_THRESHOLD", "I", "OVERFLOW_ZONE", "J", "OVERFLOW_DIGIT_START", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class BufferKt {
    @NotNull
    private static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(@NotNull Buffer commonClear) {
        f0.p(commonClear, "$this$commonClear");
        commonClear.skip(commonClear.size());
    }

    public static final long commonCompleteSegmentByteCount(@NotNull Buffer commonCompleteSegmentByteCount) {
        f0.p(commonCompleteSegmentByteCount, "$this$commonCompleteSegmentByteCount");
        long size = commonCompleteSegmentByteCount.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = commonCompleteSegmentByteCount.head;
        f0.m(segment);
        Segment segment2 = segment.prev;
        f0.m(segment2);
        int i4 = segment2.limit;
        return (i4 >= 8192 || !segment2.owner) ? size : size - (i4 - segment2.pos);
    }

    @NotNull
    public static final Buffer commonCopy(@NotNull Buffer commonCopy) {
        f0.p(commonCopy, "$this$commonCopy");
        Buffer buffer = new Buffer();
        if (commonCopy.size() == 0) {
            return buffer;
        }
        Segment segment = commonCopy.head;
        f0.m(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            f0.m(segment3);
            f0.m(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer.setSize$okio(commonCopy.size());
        return buffer;
    }

    @NotNull
    public static final Buffer commonCopyTo(@NotNull Buffer commonCopyTo, @NotNull Buffer out, long j4, long j5) {
        f0.p(commonCopyTo, "$this$commonCopyTo");
        f0.p(out, "out");
        Util.checkOffsetAndCount(commonCopyTo.size(), j4, j5);
        if (j5 == 0) {
            return commonCopyTo;
        }
        out.setSize$okio(out.size() + j5);
        Segment segment = commonCopyTo.head;
        while (true) {
            f0.m(segment);
            int i4 = segment.limit;
            int i5 = segment.pos;
            if (j4 < i4 - i5) {
                break;
            }
            j4 -= i4 - i5;
            segment = segment.next;
        }
        while (j5 > 0) {
            f0.m(segment);
            Segment sharedCopy = segment.sharedCopy();
            int i6 = sharedCopy.pos + ((int) j4);
            sharedCopy.pos = i6;
            sharedCopy.limit = Math.min(i6 + ((int) j5), sharedCopy.limit);
            Segment segment2 = out.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                out.head = sharedCopy;
            } else {
                f0.m(segment2);
                Segment segment3 = segment2.prev;
                f0.m(segment3);
                segment3.push(sharedCopy);
            }
            j5 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j4 = 0;
        }
        return commonCopyTo;
    }

    public static final boolean commonEquals(@NotNull Buffer commonEquals, @Nullable Object obj) {
        f0.p(commonEquals, "$this$commonEquals");
        if (commonEquals == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            if (commonEquals.size() != buffer.size()) {
                return false;
            }
            if (commonEquals.size() == 0) {
                return true;
            }
            Segment segment = commonEquals.head;
            f0.m(segment);
            Segment segment2 = buffer.head;
            f0.m(segment2);
            int i4 = segment.pos;
            int i5 = segment2.pos;
            long j4 = 0;
            while (j4 < commonEquals.size()) {
                long min = Math.min(segment.limit - i4, segment2.limit - i5);
                long j5 = 0;
                while (j5 < min) {
                    int i6 = i4 + 1;
                    int i7 = i5 + 1;
                    if (segment.data[i4] != segment2.data[i5]) {
                        return false;
                    }
                    j5++;
                    i4 = i6;
                    i5 = i7;
                }
                if (i4 == segment.limit) {
                    segment = segment.next;
                    f0.m(segment);
                    i4 = segment.pos;
                }
                if (i5 == segment2.limit) {
                    segment2 = segment2.next;
                    f0.m(segment2);
                    i5 = segment2.pos;
                }
                j4 += min;
            }
            return true;
        }
        return false;
    }

    public static final byte commonGet(@NotNull Buffer commonGet, long j4) {
        f0.p(commonGet, "$this$commonGet");
        Util.checkOffsetAndCount(commonGet.size(), j4, 1L);
        Segment segment = commonGet.head;
        if (segment != null) {
            if (commonGet.size() - j4 < j4) {
                long size = commonGet.size();
                while (size > j4) {
                    segment = segment.prev;
                    f0.m(segment);
                    size -= segment.limit - segment.pos;
                }
                f0.m(segment);
                return segment.data[(int) ((segment.pos + j4) - size)];
            }
            long j5 = 0;
            while (true) {
                long j6 = (segment.limit - segment.pos) + j5;
                if (j6 > j4) {
                    f0.m(segment);
                    return segment.data[(int) ((segment.pos + j4) - j5)];
                }
                segment = segment.next;
                f0.m(segment);
                j5 = j6;
            }
        } else {
            f0.m(null);
            throw null;
        }
    }

    public static final int commonHashCode(@NotNull Buffer commonHashCode) {
        f0.p(commonHashCode, "$this$commonHashCode");
        Segment segment = commonHashCode.head;
        if (segment != null) {
            int i4 = 1;
            do {
                int i5 = segment.limit;
                for (int i6 = segment.pos; i6 < i5; i6++) {
                    i4 = (i4 * 31) + segment.data[i6];
                }
                segment = segment.next;
                f0.m(segment);
            } while (segment != commonHashCode.head);
            return i4;
        }
        return 0;
    }

    public static final long commonIndexOf(@NotNull Buffer commonIndexOf, byte b4, long j4, long j5) {
        Segment segment;
        int i4;
        f0.p(commonIndexOf, "$this$commonIndexOf");
        long j6 = 0;
        if (0 <= j4 && j5 >= j4) {
            if (j5 > commonIndexOf.size()) {
                j5 = commonIndexOf.size();
            }
            if (j4 == j5 || (segment = commonIndexOf.head) == null) {
                return -1L;
            }
            if (commonIndexOf.size() - j4 < j4) {
                j6 = commonIndexOf.size();
                while (j6 > j4) {
                    segment = segment.prev;
                    f0.m(segment);
                    j6 -= segment.limit - segment.pos;
                }
                while (j6 < j5) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + j5) - j6);
                    i4 = (int) ((segment.pos + j4) - j6);
                    while (i4 < min) {
                        if (bArr[i4] != b4) {
                            i4++;
                        }
                    }
                    j6 += segment.limit - segment.pos;
                    segment = segment.next;
                    f0.m(segment);
                    j4 = j6;
                }
                return -1L;
            }
            while (true) {
                long j7 = (segment.limit - segment.pos) + j6;
                if (j7 > j4) {
                    break;
                }
                segment = segment.next;
                f0.m(segment);
                j6 = j7;
            }
            while (j6 < j5) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min(segment.limit, (segment.pos + j5) - j6);
                i4 = (int) ((segment.pos + j4) - j6);
                while (i4 < min2) {
                    if (bArr2[i4] != b4) {
                        i4++;
                    }
                }
                j6 += segment.limit - segment.pos;
                segment = segment.next;
                f0.m(segment);
                j4 = j6;
            }
            return -1L;
            return (i4 - segment.pos) + j6;
        }
        throw new IllegalArgumentException(("size=" + commonIndexOf.size() + " fromIndex=" + j4 + " toIndex=" + j5).toString());
    }

    public static final long commonIndexOfElement(@NotNull Buffer commonIndexOfElement, @NotNull ByteString targetBytes, long j4) {
        int i4;
        int i5;
        f0.p(commonIndexOfElement, "$this$commonIndexOfElement");
        f0.p(targetBytes, "targetBytes");
        long j5 = 0;
        if (j4 >= 0) {
            Segment segment = commonIndexOfElement.head;
            if (segment != null) {
                if (commonIndexOfElement.size() - j4 < j4) {
                    j5 = commonIndexOfElement.size();
                    while (j5 > j4) {
                        segment = segment.prev;
                        f0.m(segment);
                        j5 -= segment.limit - segment.pos;
                    }
                    if (targetBytes.size() == 2) {
                        byte b4 = targetBytes.getByte(0);
                        byte b5 = targetBytes.getByte(1);
                        while (j5 < commonIndexOfElement.size()) {
                            byte[] bArr = segment.data;
                            i4 = (int) ((segment.pos + j4) - j5);
                            int i6 = segment.limit;
                            while (i4 < i6) {
                                byte b6 = bArr[i4];
                                if (b6 != b4 && b6 != b5) {
                                    i4++;
                                }
                                i5 = segment.pos;
                            }
                            j5 += segment.limit - segment.pos;
                            segment = segment.next;
                            f0.m(segment);
                            j4 = j5;
                        }
                    } else {
                        byte[] internalArray$okio = targetBytes.internalArray$okio();
                        while (j5 < commonIndexOfElement.size()) {
                            byte[] bArr2 = segment.data;
                            i4 = (int) ((segment.pos + j4) - j5);
                            int i7 = segment.limit;
                            while (i4 < i7) {
                                byte b7 = bArr2[i4];
                                for (byte b8 : internalArray$okio) {
                                    if (b7 == b8) {
                                        i5 = segment.pos;
                                    }
                                }
                                i4++;
                            }
                            j5 += segment.limit - segment.pos;
                            segment = segment.next;
                            f0.m(segment);
                            j4 = j5;
                        }
                    }
                    return -1L;
                }
                while (true) {
                    long j6 = (segment.limit - segment.pos) + j5;
                    if (j6 > j4) {
                        break;
                    }
                    segment = segment.next;
                    f0.m(segment);
                    j5 = j6;
                }
                if (targetBytes.size() == 2) {
                    byte b9 = targetBytes.getByte(0);
                    byte b10 = targetBytes.getByte(1);
                    while (j5 < commonIndexOfElement.size()) {
                        byte[] bArr3 = segment.data;
                        i4 = (int) ((segment.pos + j4) - j5);
                        int i8 = segment.limit;
                        while (i4 < i8) {
                            byte b11 = bArr3[i4];
                            if (b11 != b9 && b11 != b10) {
                                i4++;
                            }
                            i5 = segment.pos;
                        }
                        j5 += segment.limit - segment.pos;
                        segment = segment.next;
                        f0.m(segment);
                        j4 = j5;
                    }
                } else {
                    byte[] internalArray$okio2 = targetBytes.internalArray$okio();
                    while (j5 < commonIndexOfElement.size()) {
                        byte[] bArr4 = segment.data;
                        i4 = (int) ((segment.pos + j4) - j5);
                        int i9 = segment.limit;
                        while (i4 < i9) {
                            byte b12 = bArr4[i4];
                            for (byte b13 : internalArray$okio2) {
                                if (b12 == b13) {
                                    i5 = segment.pos;
                                }
                            }
                            i4++;
                        }
                        j5 += segment.limit - segment.pos;
                        segment = segment.next;
                        f0.m(segment);
                        j4 = j5;
                    }
                }
                return -1L;
                return (i4 - i5) + j5;
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j4).toString());
    }

    public static final boolean commonRangeEquals(@NotNull Buffer commonRangeEquals, long j4, @NotNull ByteString bytes, int i4, int i5) {
        f0.p(commonRangeEquals, "$this$commonRangeEquals");
        f0.p(bytes, "bytes");
        if (j4 < 0 || i4 < 0 || i5 < 0 || commonRangeEquals.size() - j4 < i5 || bytes.size() - i4 < i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (commonRangeEquals.getByte(i6 + j4) != bytes.getByte(i4 + i6)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(@NotNull Buffer commonRead, @NotNull byte[] sink) {
        f0.p(commonRead, "$this$commonRead");
        f0.p(sink, "sink");
        return commonRead.read(sink, 0, sink.length);
    }

    public static final long commonReadAll(@NotNull Buffer commonReadAll, @NotNull Sink sink) {
        f0.p(commonReadAll, "$this$commonReadAll");
        f0.p(sink, "sink");
        long size = commonReadAll.size();
        if (size > 0) {
            sink.write(commonReadAll, size);
        }
        return size;
    }

    public static final byte commonReadByte(@NotNull Buffer commonReadByte) {
        f0.p(commonReadByte, "$this$commonReadByte");
        if (commonReadByte.size() != 0) {
            Segment segment = commonReadByte.head;
            f0.m(segment);
            int i4 = segment.pos;
            int i5 = segment.limit;
            int i6 = i4 + 1;
            byte b4 = segment.data[i4];
            commonReadByte.setSize$okio(commonReadByte.size() - 1);
            if (i6 == i5) {
                commonReadByte.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i6;
            }
            return b4;
        }
        throw new EOFException();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer commonReadByteArray) {
        f0.p(commonReadByteArray, "$this$commonReadByteArray");
        return commonReadByteArray.readByteArray(commonReadByteArray.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer commonReadByteString) {
        f0.p(commonReadByteString, "$this$commonReadByteString");
        return commonReadByteString.readByteString(commonReadByteString.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x00c9 A[EDGE_INSN: B:109:0x00c9->B:101:0x00c9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(@org.jetbrains.annotations.NotNull okio.Buffer r17) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(@NotNull Buffer commonReadFully, @NotNull byte[] sink) {
        f0.p(commonReadFully, "$this$commonReadFully");
        f0.p(sink, "sink");
        int i4 = 0;
        while (i4 < sink.length) {
            int read = commonReadFully.read(sink, i4, sink.length - i4);
            if (read == -1) {
                throw new EOFException();
            }
            i4 += read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00b3 A[EDGE_INSN: B:93:0x00b3->B:86:0x00b3 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadHexadecimalUnsignedLong(@org.jetbrains.annotations.NotNull okio.Buffer r15) {
        /*
            java.lang.String r0 = "$this$commonReadHexadecimalUnsignedLong"
            kotlin.jvm.internal.f0.p(r15, r0)
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lbd
            r0 = 0
            r4 = r2
            r1 = 0
        L12:
            okio.Segment r6 = r15.head
            kotlin.jvm.internal.f0.m(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L1d:
            if (r8 >= r9) goto L9f
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L2e
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L2e
            int r11 = r10 - r11
            goto L48
        L2e:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L3d
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L3d
        L38:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L48
        L3d:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L80
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L80
            goto L38
        L48:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L58
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L1d
        L58:
            okio.Buffer r15 = new okio.Buffer
            r15.<init>()
            okio.Buffer r15 = r15.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r15 = r15.readUtf8()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L80:
            if (r0 == 0) goto L84
            r1 = 1
            goto L9f
        L84:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = okio.Util.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L9f:
            if (r8 != r9) goto Lab
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto Lad
        Lab:
            r6.pos = r8
        Lad:
            if (r1 != 0) goto Lb3
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L12
        Lb3:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lbd:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            goto Lc4
        Lc3:
            throw r15
        Lc4:
            goto Lc3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(@NotNull Buffer commonReadInt) {
        f0.p(commonReadInt, "$this$commonReadInt");
        if (commonReadInt.size() >= 4) {
            Segment segment = commonReadInt.head;
            f0.m(segment);
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 4) {
                return (commonReadInt.readByte() & 255) | ((commonReadInt.readByte() & 255) << 24) | ((commonReadInt.readByte() & 255) << 16) | ((commonReadInt.readByte() & 255) << 8);
            }
            byte[] bArr = segment.data;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = ((bArr[i4] & 255) << 24) | ((bArr[i6] & 255) << 16);
            int i9 = i7 + 1;
            int i10 = i8 | ((bArr[i7] & 255) << 8);
            int i11 = i9 + 1;
            int i12 = i10 | (bArr[i9] & 255);
            commonReadInt.setSize$okio(commonReadInt.size() - 4);
            if (i11 == i5) {
                commonReadInt.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i11;
            }
            return i12;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(@NotNull Buffer commonReadLong) {
        f0.p(commonReadLong, "$this$commonReadLong");
        if (commonReadLong.size() >= 8) {
            Segment segment = commonReadLong.head;
            f0.m(segment);
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 8) {
                return ((commonReadLong.readInt() & 4294967295L) << 32) | (4294967295L & commonReadLong.readInt());
            }
            byte[] bArr = segment.data;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j4 = ((bArr[i4] & 255) << 56) | ((bArr[i6] & 255) << 48) | ((bArr[i7] & 255) << 40);
            int i9 = i8 + 1;
            long j5 = ((bArr[i8] & 255) << 32) | j4;
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            long j6 = j5 | ((bArr[i9] & 255) << 24) | ((bArr[i10] & 255) << 16);
            int i12 = i11 + 1;
            int i13 = i12 + 1;
            long j7 = j6 | ((bArr[i11] & 255) << 8) | (bArr[i12] & 255);
            commonReadLong.setSize$okio(commonReadLong.size() - 8);
            if (i13 == i5) {
                commonReadLong.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return j7;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(@NotNull Buffer commonReadShort) {
        f0.p(commonReadShort, "$this$commonReadShort");
        if (commonReadShort.size() >= 2) {
            Segment segment = commonReadShort.head;
            f0.m(segment);
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 2) {
                return (short) ((commonReadShort.readByte() & 255) | ((commonReadShort.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = ((bArr[i4] & 255) << 8) | (bArr[i6] & 255);
            commonReadShort.setSize$okio(commonReadShort.size() - 2);
            if (i7 == i5) {
                commonReadShort.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i7;
            }
            return (short) i8;
        }
        throw new EOFException();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull Buffer commonReadUtf8, long j4) {
        f0.p(commonReadUtf8, "$this$commonReadUtf8");
        if (j4 >= 0 && j4 <= ((long) Integer.MAX_VALUE)) {
            if (commonReadUtf8.size() >= j4) {
                if (j4 == 0) {
                    return "";
                }
                Segment segment = commonReadUtf8.head;
                f0.m(segment);
                int i4 = segment.pos;
                if (i4 + j4 > segment.limit) {
                    return _Utf8Kt.commonToUtf8String$default(commonReadUtf8.readByteArray(j4), 0, 0, 3, null);
                }
                int i5 = (int) j4;
                String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i4, i4 + i5);
                segment.pos += i5;
                commonReadUtf8.setSize$okio(commonReadUtf8.size() - j4);
                if (segment.pos == segment.limit) {
                    commonReadUtf8.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return commonToUtf8String;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j4).toString());
    }

    public static final int commonReadUtf8CodePoint(@NotNull Buffer commonReadUtf8CodePoint) {
        int i4;
        int i5;
        int i6;
        f0.p(commonReadUtf8CodePoint, "$this$commonReadUtf8CodePoint");
        if (commonReadUtf8CodePoint.size() != 0) {
            byte b4 = commonReadUtf8CodePoint.getByte(0L);
            if ((b4 & 128) == 0) {
                i4 = b4 & Byte.MAX_VALUE;
                i5 = 1;
                i6 = 0;
            } else if ((b4 & 224) == 192) {
                i4 = b4 & 31;
                i5 = 2;
                i6 = 128;
            } else if ((b4 & 240) == 224) {
                i4 = b4 & 15;
                i5 = 3;
                i6 = 2048;
            } else if ((b4 & 248) != 240) {
                commonReadUtf8CodePoint.skip(1L);
                return 65533;
            } else {
                i4 = b4 & 7;
                i5 = 4;
                i6 = 65536;
            }
            long j4 = i5;
            if (commonReadUtf8CodePoint.size() >= j4) {
                for (int i7 = 1; i7 < i5; i7++) {
                    long j5 = i7;
                    byte b5 = commonReadUtf8CodePoint.getByte(j5);
                    if ((b5 & 192) != 128) {
                        commonReadUtf8CodePoint.skip(j5);
                        return 65533;
                    }
                    i4 = (i4 << 6) | (b5 & 63);
                }
                commonReadUtf8CodePoint.skip(j4);
                if (i4 > 1114111) {
                    return 65533;
                }
                if ((55296 <= i4 && 57343 >= i4) || i4 < i6) {
                    return 65533;
                }
                return i4;
            }
            throw new EOFException("size < " + i5 + ": " + commonReadUtf8CodePoint.size() + " (to read code point prefixed 0x" + Util.toHexString(b4) + ')');
        }
        throw new EOFException();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull Buffer commonReadUtf8Line) {
        f0.p(commonReadUtf8Line, "$this$commonReadUtf8Line");
        long indexOf = commonReadUtf8Line.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(commonReadUtf8Line, indexOf);
        }
        if (commonReadUtf8Line.size() != 0) {
            return commonReadUtf8Line.readUtf8(commonReadUtf8Line.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull Buffer commonReadUtf8LineStrict, long j4) {
        f0.p(commonReadUtf8LineStrict, "$this$commonReadUtf8LineStrict");
        if (j4 >= 0) {
            long j5 = j4 != Long.MAX_VALUE ? j4 + 1 : Long.MAX_VALUE;
            byte b4 = (byte) 10;
            long indexOf = commonReadUtf8LineStrict.indexOf(b4, 0L, j5);
            if (indexOf != -1) {
                return readUtf8Line(commonReadUtf8LineStrict, indexOf);
            }
            if (j5 < commonReadUtf8LineStrict.size() && commonReadUtf8LineStrict.getByte(j5 - 1) == ((byte) 13) && commonReadUtf8LineStrict.getByte(j5) == b4) {
                return readUtf8Line(commonReadUtf8LineStrict, j5);
            }
            Buffer buffer = new Buffer();
            commonReadUtf8LineStrict.copyTo(buffer, 0L, Math.min(32, commonReadUtf8LineStrict.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(commonReadUtf8LineStrict.size(), j4) + " content=" + buffer.readByteString().hex() + '\u2026');
        }
        throw new IllegalArgumentException(("limit < 0: " + j4).toString());
    }

    public static final int commonSelect(@NotNull Buffer commonSelect, @NotNull Options options) {
        f0.p(commonSelect, "$this$commonSelect");
        f0.p(options, "options");
        int selectPrefix$default = selectPrefix$default(commonSelect, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        commonSelect.skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(@NotNull Buffer commonSkip, long j4) {
        f0.p(commonSkip, "$this$commonSkip");
        while (j4 > 0) {
            Segment segment = commonSkip.head;
            if (segment != null) {
                int min = (int) Math.min(j4, segment.limit - segment.pos);
                long j5 = min;
                commonSkip.setSize$okio(commonSkip.size() - j5);
                j4 -= j5;
                int i4 = segment.pos + min;
                segment.pos = i4;
                if (i4 == segment.limit) {
                    commonSkip.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer commonSnapshot) {
        f0.p(commonSnapshot, "$this$commonSnapshot");
        if (commonSnapshot.size() <= ((long) Integer.MAX_VALUE)) {
            return commonSnapshot.snapshot((int) commonSnapshot.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + commonSnapshot.size()).toString());
    }

    @NotNull
    public static final Segment commonWritableSegment(@NotNull Buffer commonWritableSegment, int i4) {
        f0.p(commonWritableSegment, "$this$commonWritableSegment");
        boolean z3 = true;
        if ((i4 < 1 || i4 > 8192) ? false : false) {
            Segment segment = commonWritableSegment.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                commonWritableSegment.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            f0.m(segment);
            Segment segment2 = segment.prev;
            f0.m(segment2);
            return (segment2.limit + i4 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull ByteString byteString, int i4, int i5) {
        f0.p(commonWrite, "$this$commonWrite");
        f0.p(byteString, "byteString");
        byteString.write$okio(commonWrite, i4, i5);
        return commonWrite;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer commonWrite, ByteString byteString, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = byteString.size();
        }
        f0.p(commonWrite, "$this$commonWrite");
        f0.p(byteString, "byteString");
        byteString.write$okio(commonWrite, i4, i5);
        return commonWrite;
    }

    public static final long commonWriteAll(@NotNull Buffer commonWriteAll, @NotNull Source source) {
        f0.p(commonWriteAll, "$this$commonWriteAll");
        f0.p(source, "source");
        long j4 = 0;
        while (true) {
            long read = source.read(commonWriteAll, 8192);
            if (read == -1) {
                return j4;
            }
            j4 += read;
        }
    }

    @NotNull
    public static final Buffer commonWriteByte(@NotNull Buffer commonWriteByte, int i4) {
        f0.p(commonWriteByte, "$this$commonWriteByte");
        Segment writableSegment$okio = commonWriteByte.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i5 = writableSegment$okio.limit;
        writableSegment$okio.limit = i5 + 1;
        bArr[i5] = (byte) i4;
        commonWriteByte.setSize$okio(commonWriteByte.size() + 1);
        return commonWriteByte;
    }

    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull Buffer commonWriteDecimalLong, long j4) {
        f0.p(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (j4 == 0) {
            return commonWriteDecimalLong.writeByte(48);
        }
        boolean z3 = false;
        int i4 = 1;
        if (j4 < 0) {
            j4 = -j4;
            if (j4 < 0) {
                return commonWriteDecimalLong.writeUtf8("-9223372036854775808");
            }
            z3 = true;
        }
        if (j4 >= 100000000) {
            i4 = j4 < 1000000000000L ? j4 < 10000000000L ? j4 < C.NANOS_PER_SECOND ? 9 : 10 : j4 < 100000000000L ? 11 : 12 : j4 < 1000000000000000L ? j4 < 10000000000000L ? 13 : j4 < 100000000000000L ? 14 : 15 : j4 < 100000000000000000L ? j4 < 10000000000000000L ? 16 : 17 : j4 < 1000000000000000000L ? 18 : 19;
        } else if (j4 >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            i4 = j4 < C.MICROS_PER_SECOND ? j4 < 100000 ? 5 : 6 : j4 < 10000000 ? 7 : 8;
        } else if (j4 >= 100) {
            i4 = j4 < 1000 ? 3 : 4;
        } else if (j4 >= 10) {
            i4 = 2;
        }
        if (z3) {
            i4++;
        }
        Segment writableSegment$okio = commonWriteDecimalLong.writableSegment$okio(i4);
        byte[] bArr = writableSegment$okio.data;
        int i5 = writableSegment$okio.limit + i4;
        while (j4 != 0) {
            long j5 = 10;
            i5--;
            bArr[i5] = getHEX_DIGIT_BYTES()[(int) (j4 % j5)];
            j4 /= j5;
        }
        if (z3) {
            bArr[i5 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i4;
        commonWriteDecimalLong.setSize$okio(commonWriteDecimalLong.size() + i4);
        return commonWriteDecimalLong;
    }

    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer commonWriteHexadecimalUnsignedLong, long j4) {
        f0.p(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (j4 == 0) {
            return commonWriteHexadecimalUnsignedLong.writeByte(48);
        }
        long j5 = (j4 >>> 1) | j4;
        long j6 = j5 | (j5 >>> 2);
        long j7 = j6 | (j6 >>> 4);
        long j8 = j7 | (j7 >>> 8);
        long j9 = j8 | (j8 >>> 16);
        long j10 = j9 | (j9 >>> 32);
        long j11 = j10 - ((j10 >>> 1) & 6148914691236517205L);
        long j12 = ((j11 >>> 2) & 3689348814741910323L) + (j11 & 3689348814741910323L);
        long j13 = ((j12 >>> 4) + j12) & 1085102592571150095L;
        long j14 = j13 + (j13 >>> 8);
        long j15 = j14 + (j14 >>> 16);
        int i4 = (int) ((((j15 & 63) + ((j15 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = commonWriteHexadecimalUnsignedLong.writableSegment$okio(i4);
        byte[] bArr = writableSegment$okio.data;
        int i5 = writableSegment$okio.limit;
        for (int i6 = (i5 + i4) - 1; i6 >= i5; i6--) {
            bArr[i6] = getHEX_DIGIT_BYTES()[(int) (15 & j4)];
            j4 >>>= 4;
        }
        writableSegment$okio.limit += i4;
        commonWriteHexadecimalUnsignedLong.setSize$okio(commonWriteHexadecimalUnsignedLong.size() + i4);
        return commonWriteHexadecimalUnsignedLong;
    }

    @NotNull
    public static final Buffer commonWriteInt(@NotNull Buffer commonWriteInt, int i4) {
        f0.p(commonWriteInt, "$this$commonWriteInt");
        Segment writableSegment$okio = commonWriteInt.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i5 = writableSegment$okio.limit;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((i4 >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i4 >>> 8) & 255);
        bArr[i8] = (byte) (i4 & 255);
        writableSegment$okio.limit = i8 + 1;
        commonWriteInt.setSize$okio(commonWriteInt.size() + 4);
        return commonWriteInt;
    }

    @NotNull
    public static final Buffer commonWriteLong(@NotNull Buffer commonWriteLong, long j4) {
        f0.p(commonWriteLong, "$this$commonWriteLong");
        Segment writableSegment$okio = commonWriteLong.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i4 = writableSegment$okio.limit;
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j4 >>> 56) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j4 >>> 48) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j4 >>> 40) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j4 >>> 32) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j4 >>> 24) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((j4 >>> 16) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j4 >>> 8) & 255);
        bArr[i11] = (byte) (j4 & 255);
        writableSegment$okio.limit = i11 + 1;
        commonWriteLong.setSize$okio(commonWriteLong.size() + 8);
        return commonWriteLong;
    }

    @NotNull
    public static final Buffer commonWriteShort(@NotNull Buffer commonWriteShort, int i4) {
        f0.p(commonWriteShort, "$this$commonWriteShort");
        Segment writableSegment$okio = commonWriteShort.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i5 = writableSegment$okio.limit;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i6] = (byte) (i4 & 255);
        writableSegment$okio.limit = i6 + 1;
        commonWriteShort.setSize$okio(commonWriteShort.size() + 2);
        return commonWriteShort;
    }

    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull Buffer commonWriteUtf8, @NotNull String string, int i4, int i5) {
        f0.p(commonWriteUtf8, "$this$commonWriteUtf8");
        f0.p(string, "string");
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i4).toString());
        }
        if (i5 >= i4) {
            if (!(i5 <= string.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i5 + " > " + string.length()).toString());
            }
            while (i4 < i5) {
                char charAt = string.charAt(i4);
                if (charAt < '\u0080') {
                    Segment writableSegment$okio = commonWriteUtf8.writableSegment$okio(1);
                    byte[] bArr = writableSegment$okio.data;
                    int i6 = writableSegment$okio.limit - i4;
                    int min = Math.min(i5, 8192 - i6);
                    int i7 = i4 + 1;
                    bArr[i4 + i6] = (byte) charAt;
                    while (i7 < min) {
                        char charAt2 = string.charAt(i7);
                        if (charAt2 >= '\u0080') {
                            break;
                        }
                        bArr[i7 + i6] = (byte) charAt2;
                        i7++;
                    }
                    int i8 = writableSegment$okio.limit;
                    int i9 = (i6 + i7) - i8;
                    writableSegment$okio.limit = i8 + i9;
                    commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + i9);
                    i4 = i7;
                } else {
                    if (charAt < '\u0800') {
                        Segment writableSegment$okio2 = commonWriteUtf8.writableSegment$okio(2);
                        byte[] bArr2 = writableSegment$okio2.data;
                        int i10 = writableSegment$okio2.limit;
                        bArr2[i10] = (byte) ((charAt >> 6) | 192);
                        bArr2[i10 + 1] = (byte) ((charAt & '?') | 128);
                        writableSegment$okio2.limit = i10 + 2;
                        commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 2);
                    } else if (charAt >= '\ud800' && charAt <= '\udfff') {
                        int i11 = i4 + 1;
                        char charAt3 = i11 < i5 ? string.charAt(i11) : (char) 0;
                        if (charAt <= '\udbff' && '\udc00' <= charAt3 && '\udfff' >= charAt3) {
                            int i12 = (((charAt & '\u03ff') << 10) | (charAt3 & '\u03ff')) + 65536;
                            Segment writableSegment$okio3 = commonWriteUtf8.writableSegment$okio(4);
                            byte[] bArr3 = writableSegment$okio3.data;
                            int i13 = writableSegment$okio3.limit;
                            bArr3[i13] = (byte) ((i12 >> 18) | 240);
                            bArr3[i13 + 1] = (byte) (((i12 >> 12) & 63) | 128);
                            bArr3[i13 + 2] = (byte) (((i12 >> 6) & 63) | 128);
                            bArr3[i13 + 3] = (byte) ((i12 & 63) | 128);
                            writableSegment$okio3.limit = i13 + 4;
                            commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 4);
                            i4 += 2;
                        } else {
                            commonWriteUtf8.writeByte(63);
                            i4 = i11;
                        }
                    } else {
                        Segment writableSegment$okio4 = commonWriteUtf8.writableSegment$okio(3);
                        byte[] bArr4 = writableSegment$okio4.data;
                        int i14 = writableSegment$okio4.limit;
                        bArr4[i14] = (byte) ((charAt >> '\f') | 224);
                        bArr4[i14 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                        bArr4[i14 + 2] = (byte) ((charAt & '?') | 128);
                        writableSegment$okio4.limit = i14 + 3;
                        commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 3);
                    }
                    i4++;
                }
            }
            return commonWriteUtf8;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i5 + " < " + i4).toString());
    }

    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer commonWriteUtf8CodePoint, int i4) {
        f0.p(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (i4 < 128) {
            commonWriteUtf8CodePoint.writeByte(i4);
        } else if (i4 < 2048) {
            Segment writableSegment$okio = commonWriteUtf8CodePoint.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i5 = writableSegment$okio.limit;
            bArr[i5] = (byte) ((i4 >> 6) | 192);
            bArr[i5 + 1] = (byte) ((i4 & 63) | 128);
            writableSegment$okio.limit = i5 + 2;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 2);
        } else if (55296 <= i4 && 57343 >= i4) {
            commonWriteUtf8CodePoint.writeByte(63);
        } else if (i4 < 65536) {
            Segment writableSegment$okio2 = commonWriteUtf8CodePoint.writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i6 = writableSegment$okio2.limit;
            bArr2[i6] = (byte) ((i4 >> 12) | 224);
            bArr2[i6 + 1] = (byte) (((i4 >> 6) & 63) | 128);
            bArr2[i6 + 2] = (byte) ((i4 & 63) | 128);
            writableSegment$okio2.limit = i6 + 3;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 3);
        } else if (i4 <= 1114111) {
            Segment writableSegment$okio3 = commonWriteUtf8CodePoint.writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i7 = writableSegment$okio3.limit;
            bArr3[i7] = (byte) ((i4 >> 18) | 240);
            bArr3[i7 + 1] = (byte) (((i4 >> 12) & 63) | 128);
            bArr3[i7 + 2] = (byte) (((i4 >> 6) & 63) | 128);
            bArr3[i7 + 3] = (byte) ((i4 & 63) | 128);
            writableSegment$okio3.limit = i7 + 4;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i4));
        }
        return commonWriteUtf8CodePoint;
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(@NotNull Segment segment, int i4, @NotNull byte[] bytes, int i5, int i6) {
        f0.p(segment, "segment");
        f0.p(bytes, "bytes");
        int i7 = segment.limit;
        byte[] bArr = segment.data;
        while (i5 < i6) {
            if (i4 == i7) {
                segment = segment.next;
                f0.m(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i4 = segment.pos;
                i7 = segment.limit;
            }
            if (bArr[i4] != bytes[i5]) {
                return false;
            }
            i4++;
            i5++;
        }
        return true;
    }

    @NotNull
    public static final String readUtf8Line(@NotNull Buffer readUtf8Line, long j4) {
        f0.p(readUtf8Line, "$this$readUtf8Line");
        if (j4 > 0) {
            long j5 = j4 - 1;
            if (readUtf8Line.getByte(j5) == ((byte) 13)) {
                String readUtf8 = readUtf8Line.readUtf8(j5);
                readUtf8Line.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8Line.readUtf8(j4);
        readUtf8Line.skip(1L);
        return readUtf82;
    }

    public static final <T> T seek(@NotNull Buffer seek, long j4, @NotNull p<? super Segment, ? super Long, ? extends T> lambda) {
        f0.p(seek, "$this$seek");
        f0.p(lambda, "lambda");
        Segment segment = seek.head;
        if (segment != null) {
            if (seek.size() - j4 < j4) {
                long size = seek.size();
                while (size > j4) {
                    segment = segment.prev;
                    f0.m(segment);
                    size -= segment.limit - segment.pos;
                }
                return lambda.invoke(segment, Long.valueOf(size));
            }
            long j5 = 0;
            while (true) {
                long j6 = (segment.limit - segment.pos) + j5;
                if (j6 > j4) {
                    return lambda.invoke(segment, Long.valueOf(j5));
                }
                segment = segment.next;
                f0.m(segment);
                j5 = j6;
            }
        } else {
            return lambda.invoke(null, -1L);
        }
    }

    public static final int selectPrefix(@NotNull Buffer selectPrefix, @NotNull Options options, boolean z3) {
        int i4;
        int i5;
        int i6;
        int i7;
        Segment segment;
        f0.p(selectPrefix, "$this$selectPrefix");
        f0.p(options, "options");
        Segment segment2 = selectPrefix.head;
        if (segment2 == null) {
            return z3 ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i8 = segment2.pos;
        int i9 = segment2.limit;
        int[] trie$okio = options.getTrie$okio();
        Segment segment3 = segment2;
        int i10 = 0;
        int i11 = -1;
        loop0: while (true) {
            int i12 = i10 + 1;
            int i13 = trie$okio[i10];
            int i14 = i12 + 1;
            int i15 = trie$okio[i12];
            if (i15 != -1) {
                i11 = i15;
            }
            if (segment3 == null) {
                break;
            }
            if (i13 >= 0) {
                i4 = i8 + 1;
                int i16 = bArr[i8] & 255;
                int i17 = i14 + i13;
                while (i14 != i17) {
                    if (i16 == trie$okio[i14]) {
                        i5 = trie$okio[i14 + i13];
                        if (i4 == i9) {
                            segment3 = segment3.next;
                            f0.m(segment3);
                            i4 = segment3.pos;
                            bArr = segment3.data;
                            i9 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i14++;
                    }
                }
                return i11;
            }
            int i18 = i14 + (i13 * (-1));
            while (true) {
                int i19 = i8 + 1;
                int i20 = i14 + 1;
                if ((bArr[i8] & 255) != trie$okio[i14]) {
                    return i11;
                }
                boolean z4 = i20 == i18;
                if (i19 == i9) {
                    f0.m(segment3);
                    Segment segment4 = segment3.next;
                    f0.m(segment4);
                    i7 = segment4.pos;
                    byte[] bArr2 = segment4.data;
                    i6 = segment4.limit;
                    if (segment4 != segment2) {
                        segment = segment4;
                        bArr = bArr2;
                    } else if (!z4) {
                        break loop0;
                    } else {
                        bArr = bArr2;
                        segment = null;
                    }
                } else {
                    Segment segment5 = segment3;
                    i6 = i9;
                    i7 = i19;
                    segment = segment5;
                }
                if (z4) {
                    i5 = trie$okio[i20];
                    i4 = i7;
                    i9 = i6;
                    segment3 = segment;
                    break;
                }
                i8 = i7;
                i9 = i6;
                i14 = i20;
                segment3 = segment;
            }
            if (i5 >= 0) {
                return i5;
            }
            i10 = -i5;
            i8 = i4;
        }
        if (z3) {
            return -2;
        }
        return i11;
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return selectPrefix(buffer, options, z3);
    }

    public static final int commonRead(@NotNull Buffer commonRead, @NotNull byte[] sink, int i4, int i5) {
        f0.p(commonRead, "$this$commonRead");
        f0.p(sink, "sink");
        Util.checkOffsetAndCount(sink.length, i4, i5);
        Segment segment = commonRead.head;
        if (segment != null) {
            int min = Math.min(i5, segment.limit - segment.pos);
            byte[] bArr = segment.data;
            int i6 = segment.pos;
            o.W0(bArr, sink, i4, i6, i6 + min);
            segment.pos += min;
            commonRead.setSize$okio(commonRead.size() - min);
            if (segment.pos == segment.limit) {
                commonRead.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return min;
        }
        return -1;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer commonReadByteArray, long j4) {
        f0.p(commonReadByteArray, "$this$commonReadByteArray");
        if (j4 >= 0 && j4 <= ((long) Integer.MAX_VALUE)) {
            if (commonReadByteArray.size() >= j4) {
                byte[] bArr = new byte[(int) j4];
                commonReadByteArray.readFully(bArr);
                return bArr;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j4).toString());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer commonReadByteString, long j4) {
        f0.p(commonReadByteString, "$this$commonReadByteString");
        if (j4 >= 0 && j4 <= ((long) Integer.MAX_VALUE)) {
            if (commonReadByteString.size() >= j4) {
                if (j4 >= 4096) {
                    ByteString snapshot = commonReadByteString.snapshot((int) j4);
                    commonReadByteString.skip(j4);
                    return snapshot;
                }
                return new ByteString(commonReadByteString.readByteArray(j4));
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j4).toString());
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull byte[] source) {
        f0.p(commonWrite, "$this$commonWrite");
        f0.p(source, "source");
        return commonWrite.write(source, 0, source.length);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull byte[] source, int i4, int i5) {
        f0.p(commonWrite, "$this$commonWrite");
        f0.p(source, "source");
        long j4 = i5;
        Util.checkOffsetAndCount(source.length, i4, j4);
        int i6 = i5 + i4;
        while (i4 < i6) {
            Segment writableSegment$okio = commonWrite.writableSegment$okio(1);
            int min = Math.min(i6 - i4, 8192 - writableSegment$okio.limit);
            int i7 = i4 + min;
            o.W0(source, writableSegment$okio.data, writableSegment$okio.limit, i4, i7);
            writableSegment$okio.limit += min;
            i4 = i7;
        }
        commonWrite.setSize$okio(commonWrite.size() + j4);
        return commonWrite;
    }

    public static final void commonReadFully(@NotNull Buffer commonReadFully, @NotNull Buffer sink, long j4) {
        f0.p(commonReadFully, "$this$commonReadFully");
        f0.p(sink, "sink");
        if (commonReadFully.size() >= j4) {
            sink.write(commonReadFully, j4);
        } else {
            sink.write(commonReadFully, commonReadFully.size());
            throw new EOFException();
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer commonSnapshot, int i4) {
        f0.p(commonSnapshot, "$this$commonSnapshot");
        if (i4 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(commonSnapshot.size(), 0L, i4);
        Segment segment = commonSnapshot.head;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            f0.m(segment);
            int i8 = segment.limit;
            int i9 = segment.pos;
            if (i8 != i9) {
                i6 += i8 - i9;
                i7++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i7];
        int[] iArr = new int[i7 * 2];
        Segment segment2 = commonSnapshot.head;
        int i10 = 0;
        while (i5 < i4) {
            f0.m(segment2);
            bArr[i10] = segment2.data;
            i5 += segment2.limit - segment2.pos;
            iArr[i10] = Math.min(i5, i4);
            iArr[i10 + i7] = segment2.pos;
            segment2.shared = true;
            i10++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull Source source, long j4) {
        f0.p(commonWrite, "$this$commonWrite");
        f0.p(source, "source");
        while (j4 > 0) {
            long read = source.read(commonWrite, j4);
            if (read == -1) {
                throw new EOFException();
            }
            j4 -= read;
        }
        return commonWrite;
    }

    public static final long commonRead(@NotNull Buffer commonRead, @NotNull Buffer sink, long j4) {
        f0.p(commonRead, "$this$commonRead");
        f0.p(sink, "sink");
        if (j4 >= 0) {
            if (commonRead.size() == 0) {
                return -1L;
            }
            if (j4 > commonRead.size()) {
                j4 = commonRead.size();
            }
            sink.write(commonRead, j4);
            return j4;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
    }

    public static final void commonWrite(@NotNull Buffer commonWrite, @NotNull Buffer source, long j4) {
        Segment segment;
        Segment segment2;
        f0.p(commonWrite, "$this$commonWrite");
        f0.p(source, "source");
        if (source != commonWrite) {
            Util.checkOffsetAndCount(source.size(), 0L, j4);
            while (j4 > 0) {
                Segment segment3 = source.head;
                f0.m(segment3);
                int i4 = segment3.limit;
                f0.m(source.head);
                if (j4 < i4 - segment.pos) {
                    Segment segment4 = commonWrite.head;
                    if (segment4 != null) {
                        f0.m(segment4);
                        segment2 = segment4.prev;
                    } else {
                        segment2 = null;
                    }
                    if (segment2 != null && segment2.owner) {
                        if ((segment2.limit + j4) - (segment2.shared ? 0 : segment2.pos) <= 8192) {
                            Segment segment5 = source.head;
                            f0.m(segment5);
                            segment5.writeTo(segment2, (int) j4);
                            source.setSize$okio(source.size() - j4);
                            commonWrite.setSize$okio(commonWrite.size() + j4);
                            return;
                        }
                    }
                    Segment segment6 = source.head;
                    f0.m(segment6);
                    source.head = segment6.split((int) j4);
                }
                Segment segment7 = source.head;
                f0.m(segment7);
                long j5 = segment7.limit - segment7.pos;
                source.head = segment7.pop();
                Segment segment8 = commonWrite.head;
                if (segment8 == null) {
                    commonWrite.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    f0.m(segment8);
                    Segment segment9 = segment8.prev;
                    f0.m(segment9);
                    segment9.push(segment7).compact();
                }
                source.setSize$okio(source.size() - j5);
                commonWrite.setSize$okio(commonWrite.size() + j5);
                j4 -= j5;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonIndexOf(@NotNull Buffer commonIndexOf, @NotNull ByteString bytes, long j4) {
        long j5;
        int i4;
        long j6 = j4;
        f0.p(commonIndexOf, "$this$commonIndexOf");
        f0.p(bytes, "bytes");
        if (bytes.size() > 0) {
            long j7 = 0;
            if (j6 >= 0) {
                Segment segment = commonIndexOf.head;
                if (segment != null) {
                    if (commonIndexOf.size() - j6 < j6) {
                        j5 = commonIndexOf.size();
                        while (j5 > j6) {
                            segment = segment.prev;
                            f0.m(segment);
                            j5 -= segment.limit - segment.pos;
                        }
                        byte[] internalArray$okio = bytes.internalArray$okio();
                        byte b4 = internalArray$okio[0];
                        int size = bytes.size();
                        long size2 = (commonIndexOf.size() - size) + 1;
                        while (j5 < size2) {
                            byte[] bArr = segment.data;
                            int min = (int) Math.min(segment.limit, (segment.pos + size2) - j5);
                            i4 = (int) ((segment.pos + j6) - j5);
                            while (i4 < min) {
                                if (bArr[i4] != b4 || !rangeEquals(segment, i4 + 1, internalArray$okio, 1, size)) {
                                    i4++;
                                }
                            }
                            j5 += segment.limit - segment.pos;
                            segment = segment.next;
                            f0.m(segment);
                            j6 = j5;
                        }
                        return -1L;
                    }
                    while (true) {
                        long j8 = (segment.limit - segment.pos) + j7;
                        if (j8 > j6) {
                            break;
                        }
                        segment = segment.next;
                        f0.m(segment);
                        j7 = j8;
                    }
                    byte[] internalArray$okio2 = bytes.internalArray$okio();
                    byte b5 = internalArray$okio2[0];
                    int size3 = bytes.size();
                    long size4 = (commonIndexOf.size() - size3) + 1;
                    j5 = j7;
                    while (j5 < size4) {
                        byte[] bArr2 = segment.data;
                        long j9 = size4;
                        int min2 = (int) Math.min(segment.limit, (segment.pos + size4) - j5);
                        i4 = (int) ((segment.pos + j6) - j5);
                        while (i4 < min2) {
                            if (bArr2[i4] == b5 && rangeEquals(segment, i4 + 1, internalArray$okio2, 1, size3)) {
                            }
                            i4++;
                        }
                        j5 += segment.limit - segment.pos;
                        segment = segment.next;
                        f0.m(segment);
                        size4 = j9;
                        j6 = j5;
                    }
                    return -1L;
                    return (i4 - segment.pos) + j5;
                }
                return -1L;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j6).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }
}
