package com.qq.e.comm.plugin.util.x2;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<X509Certificate> f46714a;

        public a(List<X509Certificate> list, List<Integer> list2) {
            this.f46714a = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(RandomAccessFile randomAccessFile, int i4) throws IOException, e {
        Pair<ByteBuffer, Long> a4 = a(randomAccessFile);
        ByteBuffer byteBuffer = (ByteBuffer) a4.first;
        long longValue = ((Long) a4.second).longValue();
        if (!h.a(randomAccessFile, longValue)) {
            long a5 = a(byteBuffer, longValue);
            Pair<ByteBuffer, Long> a6 = a(randomAccessFile, a5);
            return new d(a((ByteBuffer) a6.first, i4), ((Long) a6.second).longValue(), a5, longValue, byteBuffer);
        }
        throw new e("ZIP64 APK not supported");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer b(ByteBuffer byteBuffer, int i4) throws BufferUnderflowException {
        if (i4 >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i5 = i4 + position;
            if (i5 >= position && i5 <= limit) {
                byteBuffer.limit(i5);
                try {
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(i5);
                    return slice;
                } finally {
                    byteBuffer.limit(limit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: " + i4);
    }

    static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile) throws IOException, e {
        Pair<ByteBuffer, Long> a4 = h.a(randomAccessFile);
        if (a4 != null) {
            return a4;
        }
        throw new e("Not an APK file: ZIP End of Central Directory record not found");
    }

    static long a(ByteBuffer byteBuffer, long j4) throws e {
        long c4 = h.c(byteBuffer);
        if (c4 <= j4) {
            if (h.d(byteBuffer) + c4 == j4) {
                return c4;
            }
            throw new e("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new e("ZIP Central Directory offset out of range: " + c4 + ". ZIP End of Central Directory offset: " + j4);
    }

    static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, long j4) throws IOException, e {
        if (j4 >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j4 - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                long j5 = allocate.getLong(0);
                if (j5 < allocate.capacity() || j5 > 2147483639) {
                    throw new e("APK Signing Block size out of range: " + j5);
                }
                int i4 = (int) (8 + j5);
                long j6 = j4 - i4;
                if (j6 >= 0) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(i4);
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    randomAccessFile.seek(j6);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    long j7 = allocate2.getLong(0);
                    if (j7 == j5) {
                        return Pair.create(allocate2, Long.valueOf(j6));
                    }
                    throw new e("APK Signing Block sizes in header and footer do not match: " + j7 + " vs " + j5);
                }
                throw new e("APK Signing Block offset out of range: " + j6);
            }
            throw new e("No APK Signing Block before ZIP Central Directory");
        }
        throw new e("APK too small for APK Signing Block. ZIP Central Directory offset: " + j4);
    }

    static ByteBuffer a(ByteBuffer byteBuffer, int i4) throws e {
        a(byteBuffer);
        ByteBuffer a4 = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i5 = 0;
        while (a4.hasRemaining()) {
            i5++;
            if (a4.remaining() >= 8) {
                long j4 = a4.getLong();
                if (j4 >= 4 && j4 <= 2147483647L) {
                    int i6 = (int) j4;
                    int position = a4.position() + i6;
                    if (i6 <= a4.remaining()) {
                        if (a4.getInt() == i4) {
                            return b(a4, i6 - 4);
                        }
                        a4.position(position);
                    } else {
                        throw new e("APK Signing Block entry #" + i5 + " size out of range: " + i6 + ", available: " + a4.remaining());
                    }
                } else {
                    throw new e("APK Signing Block entry #" + i5 + " size out of range: " + j4);
                }
            } else {
                throw new e("Insufficient data to read size of APK Signing Block entry #" + i5);
            }
        }
        throw new e("No block with ID " + i4 + " in APK Signing Block.");
    }

    private static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    static ByteBuffer a(ByteBuffer byteBuffer, int i4, int i5) {
        if (i4 < 0) {
            throw new IllegalArgumentException("start: " + i4);
        } else if (i5 >= i4) {
            int capacity = byteBuffer.capacity();
            if (i5 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i5);
                    byteBuffer.position(i4);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i5 + " > " + capacity);
        } else {
            throw new IllegalArgumentException("end < start: " + i5 + " < " + i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(byte[] bArr, long j4, d dVar) throws SecurityException {
        if (bArr.length == 40) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.position(32);
            if (order.getLong() == j4 - (dVar.f46721c - dVar.f46720b)) {
                return Arrays.copyOfRange(bArr, 0, 32);
            }
            throw new SecurityException("APK content size did not verify");
        }
        throw new SecurityException("Verity digest size is wrong: " + bArr.length);
    }
}
