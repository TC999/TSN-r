package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import java.io.IOException;

/* compiled from: Http2.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1059a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f1060b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c  reason: collision with root package name */
    static final String[] f1061c = new String[64];

    /* renamed from: d  reason: collision with root package name */
    static final String[] f1062d = new String[256];

    static {
        String[] strArr;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr2 = f1062d;
            if (i5 >= strArr2.length) {
                break;
            }
            strArr2[i5] = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("%8s", Integer.toBinaryString(i5)).replace(' ', '0');
            i5++;
        }
        String[] strArr3 = f1061c;
        strArr3[0] = "";
        strArr3[1] = "END_STREAM";
        int[] iArr = {1};
        strArr3[8] = "PADDED";
        for (int i6 = 0; i6 < 1; i6++) {
            int i7 = iArr[i6];
            f1061c[i7 | 8] = strArr[i7] + "|PADDED";
        }
        String[] strArr4 = f1061c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i8 = 0; i8 < 3; i8++) {
            int i9 = iArr2[i8];
            for (int i10 = 0; i10 < 1; i10++) {
                int i11 = iArr[i10];
                String[] strArr5 = f1061c;
                int i12 = i11 | i9;
                strArr5[i12] = strArr5[i11] + '|' + strArr5[i9];
                strArr5[i12 | 8] = strArr5[i11] + '|' + strArr5[i9] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = f1061c;
            if (i4 >= strArr6.length) {
                return;
            }
            if (strArr6[i4] == null) {
                strArr6[i4] = f1062d[i4];
            }
            i4++;
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(boolean z3, int i4, int i5, byte b4, byte b5) {
        String[] strArr = f1060b;
        String a4 = b4 < strArr.length ? strArr[b4] : bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("0x%02x", Byte.valueOf(b4));
        String a5 = a(b4, b5);
        Object[] objArr = new Object[5];
        objArr[0] = z3 ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i4);
        objArr[2] = Integer.valueOf(i5);
        objArr[3] = a4;
        objArr[4] = a5;
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String a(byte b4, byte b5) {
        if (b5 == 0) {
            return "";
        }
        if (b4 != 2 && b4 != 3) {
            if (b4 == 4 || b4 == 6) {
                return b5 == 1 ? "ACK" : f1062d[b5];
            } else if (b4 != 7 && b4 != 8) {
                String[] strArr = f1061c;
                String str = b5 < strArr.length ? strArr[b5] : f1062d[b5];
                if (b4 != 5 || (b5 & 4) == 0) {
                    return (b4 != 0 || (b5 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f1062d[b5];
    }
}
