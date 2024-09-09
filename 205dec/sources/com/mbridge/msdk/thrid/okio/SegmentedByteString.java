package com.mbridge.msdk.thrid.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SegmentedByteString(Buffer buffer, int i4) {
        super(null);
        Util.checkOffsetAndCount(buffer.size, 0L, i4);
        Segment segment = buffer.head;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
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
        this.segments = new byte[i7];
        this.directory = new int[i7 * 2];
        Segment segment2 = buffer.head;
        int i10 = 0;
        while (i5 < i4) {
            byte[][] bArr = this.segments;
            bArr[i10] = segment2.data;
            int i11 = segment2.limit;
            int i12 = segment2.pos;
            i5 += i11 - i12;
            if (i5 > i4) {
                i5 = i4;
            }
            int[] iArr = this.directory;
            iArr[i10] = i5;
            iArr[bArr.length + i10] = i12;
            segment2.shared = true;
            i10++;
            segment2 = segment2.next;
        }
    }

    private int segment(int i4) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i4 + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private Object writeReplace() {
        return toByteString();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public boolean equals(Object obj) {
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

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public byte getByte(int i4) {
        Util.checkOffsetAndCount(this.directory[this.segments.length - 1], i4, 1L);
        int segment = segment(i4);
        int i5 = segment == 0 ? 0 : this.directory[segment - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[segment][(i4 - i5) + iArr[bArr.length + segment]];
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public int hashCode() {
        int i4 = this.hashCode;
        if (i4 != 0) {
            return i4;
        }
        int length = this.segments.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i5 < length) {
            byte[] bArr = this.segments[i5];
            int[] iArr = this.directory;
            int i8 = iArr[length + i5];
            int i9 = iArr[i5];
            int i10 = (i9 - i6) + i8;
            while (i8 < i10) {
                i7 = (i7 * 31) + bArr[i8];
                i8++;
            }
            i5++;
            i6 = i9;
        }
        this.hashCode = i7;
        return i7;
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        return toByteString().hmacSha1(byteString);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        return toByteString().hmacSha256(byteString);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public int indexOf(byte[] bArr, int i4) {
        return toByteString().indexOf(bArr, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public byte[] internalArray() {
        return toByteArray();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public int lastIndexOf(byte[] bArr, int i4) {
        return toByteString().lastIndexOf(bArr, i4);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString md5() {
        return toByteString().md5();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public boolean rangeEquals(int i4, ByteString byteString, int i5, int i6) {
        if (i4 < 0 || i4 > size() - i6) {
            return false;
        }
        int segment = segment(i4);
        while (i6 > 0) {
            int i7 = segment == 0 ? 0 : this.directory[segment - 1];
            int min = Math.min(i6, ((this.directory[segment] - i7) + i7) - i4);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i5, bArr[segment], (i4 - i7) + iArr[bArr.length + segment], min)) {
                return false;
            }
            i4 += min;
            i5 += min;
            i6 -= min;
            segment++;
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString sha1() {
        return toByteString().sha1();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString sha256() {
        return toByteString().sha256();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String string(Charset charset) {
        return toByteString().string(charset);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString substring(int i4) {
        return toByteString().substring(i4);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr2 = this.directory;
            int i6 = iArr2[length + i4];
            int i7 = iArr2[i4];
            System.arraycopy(this.segments[i4], i6, bArr2, i5, i7 - i5);
            i4++;
            i5 = i7;
        }
        return bArr2;
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String utf8() {
        return toByteString().utf8();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            int length = this.segments.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                int[] iArr = this.directory;
                int i6 = iArr[length + i4];
                int i7 = iArr[i4];
                outputStream.write(this.segments[i4], i6, i7 - i5);
                i4++;
                i5 = i7;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString substring(int i4, int i5) {
        return toByteString().substring(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public void write(Buffer buffer) {
        int length = this.segments.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr = this.directory;
            int i6 = iArr[length + i4];
            int i7 = iArr[i4];
            Segment segment = new Segment(this.segments[i4], i6, (i6 + i7) - i5, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                segment2.prev.push(segment);
            }
            i4++;
            i5 = i7;
        }
        buffer.size += i5;
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public boolean rangeEquals(int i4, byte[] bArr, int i5, int i6) {
        if (i4 < 0 || i4 > size() - i6 || i5 < 0 || i5 > bArr.length - i6) {
            return false;
        }
        int segment = segment(i4);
        while (i6 > 0) {
            int i7 = segment == 0 ? 0 : this.directory[segment - 1];
            int min = Math.min(i6, ((this.directory[segment] - i7) + i7) - i4);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!Util.arrayRangeEquals(bArr2[segment], (i4 - i7) + iArr[bArr2.length + segment], bArr, i5, min)) {
                return false;
            }
            i4 += min;
            i5 += min;
            i6 -= min;
            segment++;
        }
        return true;
    }
}
