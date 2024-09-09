package com.qq.e.comm.plugin.util.x2;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class h {
    public static boolean a(RandomAccessFile randomAccessFile, long j4) throws IOException {
        long j5 = j4 - 20;
        if (j5 < 0) {
            return false;
        }
        randomAccessFile.seek(j5);
        return randomAccessFile.readInt() == 1347094023;
    }

    private static int b(ByteBuffer byteBuffer) {
        a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i4 = capacity - 22;
        int min = Math.min(i4, 65535);
        for (int i5 = 0; i5 <= min; i5++) {
            int i6 = i4 - i5;
            if (byteBuffer.getInt(i6) == 101010256 && a(byteBuffer, i6 + 20) == i5) {
                return i6;
            }
        }
        return -1;
    }

    public static long c(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 16);
    }

    public static long d(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.getChannel().size() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> a4 = a(randomAccessFile, 0);
        return a4 != null ? a4 : a(randomAccessFile, 65535);
    }

    private static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i4) throws IOException {
        if (i4 >= 0 && i4 <= 65535) {
            long size = randomAccessFile.getChannel().size();
            if (size < 22) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i4, size - 22)) + 22);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            long capacity = size - allocate.capacity();
            randomAccessFile.seek(capacity);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            int b4 = b(allocate);
            if (b4 == -1) {
                return null;
            }
            allocate.position(b4);
            ByteBuffer slice = allocate.slice();
            slice.order(ByteOrder.LITTLE_ENDIAN);
            return Pair.create(slice, Long.valueOf(capacity + b4));
        }
        throw new IllegalArgumentException("maxCommentSize: " + i4);
    }

    private static long b(ByteBuffer byteBuffer, int i4) {
        return byteBuffer.getInt(i4) & 4294967295L;
    }

    private static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int a(ByteBuffer byteBuffer, int i4) {
        return byteBuffer.getShort(i4) & 65535;
    }
}
