package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import org.jetbrains.annotations.NotNull;

/* compiled from: BitEncoding.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f57523a;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f57524b = false;

    static {
        String str;
        try {
            str = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            str = null;
        }
        f57523a = "true".equals(str);
    }

    private a() {
    }

    private static /* synthetic */ void a(int i4) {
        String str = (i4 == 1 || i4 == 3 || i4 == 6 || i4 == 8 || i4 == 10 || i4 == 12 || i4 == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 1 || i4 == 3 || i4 == 6 || i4 == 8 || i4 == 10 || i4 == 12 || i4 == 14) ? 2 : 3];
        if (i4 == 1 || i4 == 3 || i4 == 6 || i4 == 8 || i4 == 10 || i4 == 12 || i4 == 14) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[0] = "data";
        }
        if (i4 == 1) {
            objArr[1] = "encodeBytes";
        } else if (i4 == 3) {
            objArr[1] = "encode8to7";
        } else if (i4 == 6) {
            objArr[1] = "splitBytesToStringArray";
        } else if (i4 == 8) {
            objArr[1] = "decodeBytes";
        } else if (i4 == 10) {
            objArr[1] = "dropMarker";
        } else if (i4 == 12) {
            objArr[1] = "combineStringArrayIntoBytes";
        } else if (i4 != 14) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[1] = "decode7to8";
        }
        switch (i4) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                break;
            case 2:
                objArr[2] = "encode8to7";
                break;
            case 4:
                objArr[2] = "addModuloByte";
                break;
            case 5:
                objArr[2] = "splitBytesToStringArray";
                break;
            case 7:
                objArr[2] = "decodeBytes";
                break;
            case 9:
                objArr[2] = "dropMarker";
                break;
            case 11:
                objArr[2] = "combineStringArrayIntoBytes";
                break;
            case 13:
                objArr[2] = "decode7to8";
                break;
            default:
                objArr[2] = "encodeBytes";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 != 1 && i4 != 3 && i4 != 6 && i4 != 8 && i4 != 10 && i4 != 12 && i4 != 14) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    private static void b(@NotNull byte[] bArr, int i4) {
        if (bArr == null) {
            a(4);
        }
        int length = bArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            bArr[i5] = (byte) ((bArr[i5] + i4) & 127);
        }
    }

    @NotNull
    private static byte[] c(@NotNull String[] strArr) {
        if (strArr == null) {
            a(11);
        }
        int i4 = 0;
        for (String str : strArr) {
            i4 += str.length();
        }
        byte[] bArr = new byte[i4];
        int i5 = 0;
        for (String str2 : strArr) {
            int length = str2.length();
            int i6 = 0;
            while (i6 < length) {
                bArr[i5] = (byte) str2.charAt(i6);
                i6++;
                i5++;
            }
        }
        return bArr;
    }

    @NotNull
    private static byte[] d(@NotNull byte[] bArr) {
        if (bArr == null) {
            a(13);
        }
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            i4++;
            int i7 = i5 + 1;
            bArr2[i6] = (byte) (((bArr[i4] & 255) >>> i5) + ((bArr[i4] & ((1 << i7) - 1)) << (7 - i5)));
            if (i5 == 6) {
                i4++;
                i5 = 0;
            } else {
                i5 = i7;
            }
        }
        return bArr2;
    }

    @NotNull
    public static byte[] e(@NotNull String[] strArr) {
        if (strArr == null) {
            a(7);
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == 0) {
                byte[] a4 = h.a(f(strArr));
                if (a4 == null) {
                    a(8);
                }
                return a4;
            } else if (charAt == '\uffff') {
                strArr = f(strArr);
            }
        }
        byte[] c4 = c(strArr);
        b(c4, 127);
        return d(c4);
    }

    @NotNull
    private static String[] f(@NotNull String[] strArr) {
        if (strArr == null) {
            a(9);
        }
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        return strArr2;
    }
}
