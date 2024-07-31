package com.bytedance.pangle.res.p124a;

import java.io.EOFException;
import java.io.InputStream;

/* renamed from: com.bytedance.pangle.res.a.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6206d {
    /* renamed from: a */
    private static <T> T m36984a(T t) {
        t.getClass();
        return t;
    }

    /* renamed from: a */
    public static void m36985a(InputStream inputStream, byte[] bArr, int i, int i2) {
        m36984a(inputStream);
        m36984a(bArr);
        int i3 = 0;
        if (i2 >= 0) {
            int i4 = i + i2;
            int length = bArr.length;
            if (i < 0 || i4 < i || i4 > length) {
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append(i4);
                sb.append(length);
                throw new IndexOutOfBoundsException(sb.toString());
            }
            while (i3 < i2) {
                int read = inputStream.read(bArr, i + i3, i2 - i3);
                if (read == -1) {
                    break;
                }
                i3 += read;
            }
            if (i3 == i2) {
                return;
            }
            throw new EOFException("reached end of stream after reading " + i3 + " bytes; " + i2 + " bytes expected");
        }
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
    }
}
