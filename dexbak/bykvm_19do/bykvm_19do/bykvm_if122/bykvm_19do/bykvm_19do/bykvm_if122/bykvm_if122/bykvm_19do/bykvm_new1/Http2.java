package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import io.netty.handler.codec.http.HttpConstants;
import java.io.IOException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Http2 {

    /* renamed from: a */
    static final ByteString f1066a = ByteString.m58937c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    private static final String[] f1067b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c */
    static final String[] f1068c = new String[64];

    /* renamed from: d */
    static final String[] f1069d = new String[256];

    static {
        String[] strArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr2 = f1069d;
            if (i2 >= strArr2.length) {
                break;
            }
            strArr2[i2] = C1061c.m58464a("%8s", Integer.toBinaryString(i2)).replace(HttpConstants.SP_CHAR, '0');
            i2++;
        }
        String[] strArr3 = f1068c;
        strArr3[0] = "";
        strArr3[1] = "END_STREAM";
        int[] iArr = {1};
        strArr3[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            f1068c[i4 | 8] = strArr[i4] + "|PADDED";
        }
        String[] strArr4 = f1068c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = f1068c;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = f1068c;
            if (i >= strArr6.length) {
                return;
            }
            if (strArr6[i] == null) {
                strArr6[i] = f1069d[i];
            }
            i++;
        }
    }

    private Http2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static IllegalArgumentException m58648a(String str, Object... objArr) {
        throw new IllegalArgumentException(C1061c.m58464a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static IOException m58646b(String str, Object... objArr) throws IOException {
        throw new IOException(C1061c.m58464a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m58647a(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = f1067b;
        String m58464a = b < strArr.length ? strArr[b] : C1061c.m58464a("0x%02x", Byte.valueOf(b));
        String m58649a = m58649a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = m58464a;
        objArr[4] = m58649a;
        return C1061c.m58464a("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: a */
    static String m58649a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : f1069d[b2];
            } else if (b != 7 && b != 8) {
                String[] strArr = f1068c;
                String str = b2 < strArr.length ? strArr[b2] : f1069d[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f1069d[b2];
    }
}
