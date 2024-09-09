package okio;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.jvm.internal.f0;
import okio.internal.SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SegmentedByteString.kt */
@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\"0>\u0012\u0006\u0010D\u001a\u00020C\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0002\u001a\u00020\u0001H\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0001H\u0016J\b\u0010\f\u001a\u00020\u0001H\u0016J\u0017\u0010\u0010\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0010\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0001H\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0017\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0016H\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010!\u001a\u00020\u0016H\u0010\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H\u0016J'\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016H\u0010\u00a2\u0006\u0004\b.\u0010/J(\u00103\u001a\u0002022\u0006\u0010,\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016H\u0016J(\u00103\u001a\u0002022\u0006\u0010,\u001a\u00020\u00162\u0006\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016H\u0016J\u0018\u00105\u001a\u00020\u00162\u0006\u00100\u001a\u00020\"2\u0006\u00104\u001a\u00020\u0016H\u0016J\u0018\u00106\u001a\u00020\u00162\u0006\u00100\u001a\u00020\"2\u0006\u00104\u001a\u00020\u0016H\u0016J\u000f\u00109\u001a\u00020\"H\u0010\u00a2\u0006\u0004\b7\u00108J\u0013\u0010;\u001a\u0002022\b\u00100\u001a\u0004\u0018\u00010:H\u0096\u0002J\b\u0010<\u001a\u00020\u0016H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016R \u0010?\u001a\b\u0012\u0004\u0012\u00020\"0>8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001a\u0010D\u001a\u00020C8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\u00a8\u0006J"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "toByteString", "Ljava/lang/Object;", "writeReplace", "Ljava/nio/charset/Charset;", "charset", "", "string", "base64", "hex", "toAsciiLowercase", "toAsciiUppercase", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", DomainCampaignEx.LOOPBACK_KEY, "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "", "beginIndex", "endIndex", "substring", "pos", "", "internalGet$okio", "(I)B", "internalGet", "getSize$okio", "()I", "getSize", "", "toByteArray", "Ljava/nio/ByteBuffer;", "asByteBuffer", "Ljava/io/OutputStream;", "out", "Lkotlin/f1;", "write", "Lokio/Buffer;", "buffer", "offset", "byteCount", "write$okio", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "rangeEquals", "fromIndex", "indexOf", "lastIndexOf", "internalArray$okio", "()[B", "internalArray", "", "equals", "hashCode", "toString", "", "segments", "[[B", "getSegments$okio", "()[[B", "", "directory", "[I", "getDirectory$okio", "()[I", "<init>", "([[B[I)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SegmentedByteString extends ByteString {
    @NotNull
    private final transient int[] directory;
    @NotNull
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@NotNull byte[][] segments, @NotNull int[] directory) {
        super(ByteString.EMPTY.getData$okio());
        f0.p(segments, "segments");
        f0.p(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        if (byteString != null) {
            return byteString;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
    }

    @Override // okio.ByteString
    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        f0.o(asReadOnlyBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    @NotNull
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @NotNull
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        f0.p(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments$okio().length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = getDirectory$okio()[length + i4];
            int i7 = getDirectory$okio()[i4];
            messageDigest.update(getSegments$okio()[i4], i6, i7 - i5);
            i4++;
            i5 = i7;
        }
        byte[] digest = messageDigest.digest();
        f0.o(digest, "digest.digest()");
        return new ByteString(digest);
    }

    @Override // okio.ByteString
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final int[] getDirectory$okio() {
        return this.directory;
    }

    @NotNull
    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        while (i4 < length) {
            int i7 = getDirectory$okio()[length + i4];
            int i8 = getDirectory$okio()[i4];
            byte[] bArr = getSegments$okio()[i4];
            int i9 = (i8 - i6) + i7;
            while (i7 < i9) {
                i5 = (i5 * 31) + bArr[i7];
                i7++;
            }
            i4++;
            i6 = i8;
        }
        setHashCode$okio(i5);
        return i5;
    }

    @Override // okio.ByteString
    @NotNull
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) {
        f0.p(algorithm, "algorithm");
        f0.p(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments$okio().length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                int i6 = getDirectory$okio()[length + i4];
                int i7 = getDirectory$okio()[i4];
                mac.update(getSegments$okio()[i4], i6, i7 - i5);
                i4++;
                i5 = i7;
            }
            byte[] doFinal = mac.doFinal();
            f0.o(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    @Override // okio.ByteString
    public int indexOf(@NotNull byte[] other, int i4) {
        f0.p(other, "other");
        return toByteString().indexOf(other, i4);
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i4) {
        Util.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], i4, 1L);
        int segment = SegmentedByteStringKt.segment(this, i4);
        return getSegments$okio()[segment][(i4 - (segment == 0 ? 0 : getDirectory$okio()[segment - 1])) + getDirectory$okio()[getSegments$okio().length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(@NotNull byte[] other, int i4) {
        f0.p(other, "other");
        return toByteString().lastIndexOf(other, i4);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i4, @NotNull ByteString other, int i5, int i6) {
        f0.p(other, "other");
        if (i4 < 0 || i4 > size() - i6) {
            return false;
        }
        int i7 = i6 + i4;
        int segment = SegmentedByteStringKt.segment(this, i4);
        while (i4 < i7) {
            int i8 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i9 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i7, (getDirectory$okio()[segment] - i8) + i8) - i4;
            if (!other.rangeEquals(i5, getSegments$okio()[segment], i9 + (i4 - i8), min)) {
                return false;
            }
            i5 += min;
            i4 += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    @NotNull
    public String string(@NotNull Charset charset) {
        f0.p(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString substring(int i4, int i5) {
        Object[] M1;
        if (i4 >= 0) {
            if (!(i5 <= size())) {
                throw new IllegalArgumentException(("endIndex=" + i5 + " > length(" + size() + ')').toString());
            }
            int i6 = i5 - i4;
            if (i6 >= 0) {
                if (i4 == 0 && i5 == size()) {
                    return this;
                }
                if (i4 == i5) {
                    return ByteString.EMPTY;
                }
                int segment = SegmentedByteStringKt.segment(this, i4);
                int segment2 = SegmentedByteStringKt.segment(this, i5 - 1);
                M1 = o.M1(getSegments$okio(), segment, segment2 + 1);
                byte[][] bArr = (byte[][]) M1;
                int[] iArr = new int[bArr.length * 2];
                if (segment <= segment2) {
                    int i7 = segment;
                    int i8 = 0;
                    while (true) {
                        iArr[i8] = Math.min(getDirectory$okio()[i7] - i4, i6);
                        int i9 = i8 + 1;
                        iArr[i8 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i7];
                        if (i7 == segment2) {
                            break;
                        }
                        i7++;
                        i8 = i9;
                    }
                }
                int i10 = segment != 0 ? getDirectory$okio()[segment - 1] : 0;
                int length = bArr.length;
                iArr[length] = iArr[length] + (i4 - i10);
                return new SegmentedByteString(bArr, iArr);
            }
            throw new IllegalArgumentException(("endIndex=" + i5 + " < beginIndex=" + i4).toString());
        }
        throw new IllegalArgumentException(("beginIndex=" + i4 + " < 0").toString());
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            int i7 = getDirectory$okio()[length + i4];
            int i8 = getDirectory$okio()[i4];
            int i9 = i8 - i5;
            o.W0(getSegments$okio()[i4], bArr, i6, i7, i7 + i9);
            i6 += i9;
            i4++;
            i5 = i8;
        }
        return bArr;
    }

    @Override // okio.ByteString
    @NotNull
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(@NotNull OutputStream out) throws IOException {
        f0.p(out, "out");
        int length = getSegments$okio().length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = getDirectory$okio()[length + i4];
            int i7 = getDirectory$okio()[i4];
            out.write(getSegments$okio()[i4], i6, i7 - i5);
            i4++;
            i5 = i7;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@NotNull Buffer buffer, int i4, int i5) {
        f0.p(buffer, "buffer");
        int i6 = i5 + i4;
        int segment = SegmentedByteStringKt.segment(this, i4);
        while (i4 < i6) {
            int i7 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i8 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i6, (getDirectory$okio()[segment] - i7) + i7) - i4;
            int i9 = i8 + (i4 - i7);
            Segment segment2 = new Segment(getSegments$okio()[segment], i9, i9 + min, true, false);
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
        buffer.setSize$okio(buffer.size() + size());
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i4, @NotNull byte[] other, int i5, int i6) {
        f0.p(other, "other");
        if (i4 < 0 || i4 > size() - i6 || i5 < 0 || i5 > other.length - i6) {
            return false;
        }
        int i7 = i6 + i4;
        int segment = SegmentedByteStringKt.segment(this, i4);
        while (i4 < i7) {
            int i8 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i9 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i7, (getDirectory$okio()[segment] - i8) + i8) - i4;
            if (!Util.arrayRangeEquals(getSegments$okio()[segment], i9 + (i4 - i8), other, i5, min)) {
                return false;
            }
            i5 += min;
            i4 += min;
            segment++;
        }
        return true;
    }
}
