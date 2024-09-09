package com.bytedance.pangle.res.a;

import java.io.EOFException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class d {
    private static <T> T a(T t3) {
        t3.getClass();
        return t3;
    }

    public static void a(InputStream inputStream, byte[] bArr, int i4, int i5) {
        a(inputStream);
        a(bArr);
        int i6 = 0;
        if (i5 >= 0) {
            int i7 = i4 + i5;
            int length = bArr.length;
            if (i4 < 0 || i7 < i4 || i7 > length) {
                StringBuilder sb = new StringBuilder();
                sb.append(i4);
                sb.append(i7);
                sb.append(length);
                throw new IndexOutOfBoundsException(sb.toString());
            }
            while (i6 < i5) {
                int read = inputStream.read(bArr, i4 + i6, i5 - i6);
                if (read == -1) {
                    break;
                }
                i6 += read;
            }
            if (i6 == i5) {
                return;
            }
            throw new EOFException("reached end of stream after reading " + i6 + " bytes; " + i5 + " bytes expected");
        }
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i5)));
    }
}
