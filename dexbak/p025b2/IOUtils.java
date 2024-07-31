package p025b2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: b2.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IOUtils {
    /* renamed from: a */
    public static void m59956a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: b */
    public static void m59955b(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: c */
    public static byte[] m59954c(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: d */
    public static String m59953d(InputStream inputStream) {
        byte[] m59954c = m59954c(inputStream);
        if (m59954c == null) {
            return null;
        }
        return new String(m59954c);
    }
}
