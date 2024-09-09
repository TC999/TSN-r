package cn.jiguang.ag;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class j {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream != null) {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return bArr;
        }
        throw new IOException("InputStream is null");
    }
}
