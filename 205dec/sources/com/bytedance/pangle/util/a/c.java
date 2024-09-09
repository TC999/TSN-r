package com.bytedance.pangle.util.a;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i4) {
        if (i4 >= 0 && i4 <= 65535) {
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i4, length - 22)) + 22);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            long capacity = length - allocate.capacity();
            randomAccessFile.seek(capacity);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            int b4 = b(allocate);
            if (b4 == -1) {
                return null;
            }
            allocate.position(b4);
            ByteBuffer slice = allocate.slice();
            slice.order(byteOrder);
            return Pair.create(slice, Long.valueOf(capacity + b4));
        }
        throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i4)));
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
            if (byteBuffer.getInt(i6) == 101010256 && (byteBuffer.getShort(i6 + 20) & 65535) == i5) {
                return i6;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(ByteBuffer byteBuffer, int i4) {
        return byteBuffer.getInt(i4) & 4294967295L;
    }

    public static void a(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (Throwable unused) {
        }
    }
}
