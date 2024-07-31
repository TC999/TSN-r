package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.nio.charset.Charset;
import kotlin.UShort;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.u */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
final class Util {

    /* renamed from: a */
    public static final Charset f850a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static int m58868a(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    /* renamed from: a */
    public static short m58865a(short s) {
        int i = s & UShort.f40820c;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    /* renamed from: a */
    public static void m58867a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    /* renamed from: b */
    private static <T extends Throwable> void m58863b(Throwable th) throws Throwable {
        throw th;
    }

    /* renamed from: a */
    public static void m58866a(Throwable th) {
        m58863b(th);
        throw null;
    }

    /* renamed from: a */
    public static boolean m58864a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
