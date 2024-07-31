package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.core.p397e.C10331c;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.UByte;

/* renamed from: com.kwad.sdk.pngencrypt.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10936n {
    public static Charset aLC = Charset.forName("ISO-8859-1");
    public static Charset aLD = Charset.forName("UTF-8");
    private static ThreadLocal<Boolean> aLE = new ThreadLocal<Boolean>() { // from class: com.kwad.sdk.pngencrypt.n.1
        /* renamed from: Ke */
        private static Boolean m24419Ke() {
            return Boolean.FALSE;
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Boolean initialValue() {
            return m24419Ke();
        }
    };

    /* renamed from: Kd */
    public static byte[] m24426Kd() {
        return new byte[]{-119, 80, 78, 71, 13, 10, BinaryMemcacheOpcodes.PREPENDQ, 10};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static final int m24425b(int i, int i2, int i3) {
        int i4 = (i + i2) - i3;
        int i5 = i4 >= i ? i4 - i : i - i4;
        int i6 = i4 >= i2 ? i4 - i2 : i2 - i4;
        int i7 = i4 >= i3 ? i4 - i3 : i3 - i4;
        return (i5 > i6 || i5 > i7) ? i6 <= i7 ? i2 : i3 : i;
    }

    /* renamed from: e */
    public static int m24424e(InputStream inputStream) {
        try {
            return inputStream.read();
        } catch (IOException e) {
            C10331c.printStackTrace(e);
            return -1;
        }
    }

    /* renamed from: f */
    public static int m24422f(InputStream inputStream) {
        try {
            int read = inputStream.read();
            int read2 = inputStream.read();
            int read3 = inputStream.read();
            int read4 = inputStream.read();
            if (read == -1 || read2 == -1 || read3 == -1 || read4 == -1) {
                return -1;
            }
            return (read << 24) | (read2 << 16) | ((read3 << 8) + read4);
        } catch (IOException e) {
            C10331c.printStackTrace(e);
            return -1;
        }
    }

    /* renamed from: g */
    public static final int m24420g(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.f41242c) | ((bArr[i] & UByte.f41242c) << 24) | ((bArr[i + 1] & UByte.f41242c) << 16) | ((bArr[i + 2] & UByte.f41242c) << 8);
    }

    /* renamed from: e */
    public static int m24423e(byte[] bArr, int i) {
        return bArr[i] & UByte.f41242c;
    }

    /* renamed from: f */
    public static int m24421f(byte[] bArr, int i) {
        return (bArr[i + 1] & UByte.f41242c) | ((bArr[i] & UByte.f41242c) << 8);
    }
}
