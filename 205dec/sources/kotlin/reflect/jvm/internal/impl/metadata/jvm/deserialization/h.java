package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: utfEncoding.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull
    public static final byte[] a(@NotNull String[] strings) {
        int i4;
        f0.p(strings, "strings");
        int length = strings.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            String str = strings[i5];
            i5++;
            i6 += str.length();
        }
        byte[] bArr = new byte[i6];
        int length2 = strings.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length2) {
            String str2 = strings[i7];
            i7++;
            int length3 = str2.length() - 1;
            if (length3 >= 0) {
                int i9 = 0;
                while (true) {
                    int i10 = i9 + 1;
                    i4 = i8 + 1;
                    bArr[i8] = (byte) str2.charAt(i9);
                    if (i9 == length3) {
                        break;
                    }
                    i9 = i10;
                    i8 = i4;
                }
                i8 = i4;
            }
        }
        return bArr;
    }
}
