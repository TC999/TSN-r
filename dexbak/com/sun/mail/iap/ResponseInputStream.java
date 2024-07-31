package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.sun.mail.iap.i */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ResponseInputStream {

    /* renamed from: b */
    private static final int f35882b = 256;

    /* renamed from: c */
    private static final int f35883c = 262144;

    /* renamed from: d */
    private static final int f35884d = 16;

    /* renamed from: a */
    private BufferedInputStream f35885a;

    public ResponseInputStream(InputStream inputStream) {
        this.f35885a = new BufferedInputStream(inputStream, 2048);
    }

    /* renamed from: a */
    public ByteArray m16380a() throws IOException {
        return m16379b(null);
    }

    /* renamed from: b */
    public ByteArray m16379b(ByteArray byteArray) throws IOException {
        if (byteArray == null) {
            byteArray = new ByteArray(new byte[128], 0, 128);
        }
        byte[] m16428a = byteArray.m16428a();
        int i = 0;
        while (true) {
            boolean z = false;
            int i2 = 0;
            while (!z && (i2 = this.f35885a.read()) != -1) {
                if (i2 == 10 && i > 0 && m16428a[i - 1] == 13) {
                    z = true;
                }
                if (i >= m16428a.length) {
                    int length = m16428a.length;
                    if (length > 262144) {
                        length = 262144;
                    }
                    byteArray.m16424e(length);
                    m16428a = byteArray.m16428a();
                }
                m16428a[i] = (byte) i2;
                i++;
            }
            if (i2 == -1) {
                throw new IOException();
            }
            if (i < 5) {
                break;
            }
            int i3 = i - 3;
            if (m16428a[i3] != 125) {
                break;
            }
            int i4 = i - 4;
            while (i4 >= 0 && m16428a[i4] != 123) {
                i4--;
            }
            if (i4 < 0) {
                break;
            }
            try {
                int parseInt = ASCIIUtility.parseInt(m16428a, i4 + 1, i3);
                if (parseInt > 0) {
                    int length2 = m16428a.length - i;
                    int i5 = parseInt + 16;
                    if (i5 > length2) {
                        int i6 = i5 - length2;
                        if (256 > i6) {
                            i6 = 256;
                        }
                        byteArray.m16424e(i6);
                        m16428a = byteArray.m16428a();
                    }
                    while (parseInt > 0) {
                        int read = this.f35885a.read(m16428a, i, parseInt);
                        parseInt -= read;
                        i += read;
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        byteArray.m16423f(i);
        return byteArray;
    }
}
