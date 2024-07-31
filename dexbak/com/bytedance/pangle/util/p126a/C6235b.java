package com.bytedance.pangle.util.p126a;

import com.bytedance.pangle.util.C6250f;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.bytedance.pangle.util.a.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6235b {

    /* renamed from: a */
    private static String f22210a = "";

    /* renamed from: a */
    public static String[] m36937a(File file) {
        String str;
        ByteBuffer m36935b;
        boolean z;
        String str2 = "";
        try {
            m36935b = m36935b(file);
        } catch (Exception unused) {
            str = "";
        }
        if (m36935b.order() == ByteOrder.LITTLE_ENDIAN) {
            ByteBuffer m36936a = m36936a(m36935b, m36935b.capacity() - 24);
            int i = 0;
            while (m36936a.hasRemaining()) {
                i++;
                if (m36936a.remaining() >= 8) {
                    long j = m36936a.getLong();
                    if (j >= 4 && j <= 2147483647L) {
                        int i2 = (int) j;
                        int position = m36936a.position() + i2;
                        if (i2 <= m36936a.remaining()) {
                            int i3 = m36936a.getInt();
                            if (i3 == -262969152) {
                                f22210a = "V3";
                            } else if (i3 == 1896449818) {
                                f22210a = "V2";
                            } else {
                                m36936a.position(position);
                            }
                            z = true;
                            break;
                        }
                        throw new Exception("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + m36936a.remaining());
                    }
                    throw new Exception("APK Signing Block entry #" + i + " size out of range: " + j);
                }
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
            }
            z = false;
            if (z) {
                str2 = C6250f.m36902a(m36935b.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
            return new String[]{str2, f22210a, str};
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b A[Catch: all -> 0x018c, TryCatch #0 {all -> 0x018c, blocks: (B:4:0x0008, B:12:0x0024, B:14:0x003a, B:19:0x004b, B:21:0x005d, B:25:0x0075, B:27:0x00a8, B:29:0x00b5, B:33:0x00c9, B:35:0x00d3, B:37:0x00f4, B:40:0x0104, B:41:0x011f, B:42:0x0120, B:43:0x012f, B:44:0x0130, B:45:0x013f, B:46:0x0140, B:47:0x0147, B:48:0x0148, B:49:0x0157, B:50:0x0158, B:51:0x015f, B:52:0x0160, B:53:0x017b, B:54:0x017c, B:55:0x0183, B:56:0x0184, B:57:0x018b, B:7:0x0014, B:10:0x001b), top: B:64:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017c A[Catch: all -> 0x018c, TryCatch #0 {all -> 0x018c, blocks: (B:4:0x0008, B:12:0x0024, B:14:0x003a, B:19:0x004b, B:21:0x005d, B:25:0x0075, B:27:0x00a8, B:29:0x00b5, B:33:0x00c9, B:35:0x00d3, B:37:0x00f4, B:40:0x0104, B:41:0x011f, B:42:0x0120, B:43:0x012f, B:44:0x0130, B:45:0x013f, B:46:0x0140, B:47:0x0147, B:48:0x0148, B:49:0x0157, B:50:0x0158, B:51:0x015f, B:52:0x0160, B:53:0x017b, B:54:0x017c, B:55:0x0183, B:56:0x0184, B:57:0x018b, B:7:0x0014, B:10:0x001b), top: B:64:0x0008 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.nio.ByteBuffer m36935b(java.io.File r13) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.p126a.C6235b.m36935b(java.io.File):java.nio.ByteBuffer");
    }

    /* renamed from: a */
    private static ByteBuffer m36936a(ByteBuffer byteBuffer, int i) {
        if (i >= 8) {
            int capacity = byteBuffer.capacity();
            if (i <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i);
                    byteBuffer.position(8);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i + " > " + capacity);
        }
        throw new IllegalArgumentException("end < start: " + i + " < 8");
    }
}
