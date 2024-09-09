package com.tencent.turingfd.sdk.ams.au;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Ara {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j4 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j4;
            }
            outputStream.write(bArr, 0, read);
            j4 += read;
        }
    }
}
