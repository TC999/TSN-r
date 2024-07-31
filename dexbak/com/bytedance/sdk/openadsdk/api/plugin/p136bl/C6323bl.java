package com.bytedance.sdk.openadsdk.api.plugin.p136bl;

import kotlin.UByte;

/* renamed from: com.bytedance.sdk.openadsdk.api.plugin.bl.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6323bl {

    /* renamed from: ok */
    private static final char[] f22446ok = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: ok */
    public static String m36595ok(byte[] bArr) {
        if (bArr != null) {
            return m36594ok(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    /* renamed from: ok */
    public static String m36594ok(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i >= 0 && i + i2 <= bArr.length) {
                int i3 = i2 * 2;
                char[] cArr = new char[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = bArr[i5 + i] & UByte.f41242c;
                    int i7 = i4 + 1;
                    char[] cArr2 = f22446ok;
                    cArr[i4] = cArr2[i6 >> 4];
                    i4 = i7 + 1;
                    cArr[i7] = cArr2[i6 & 15];
                }
                return new String(cArr, 0, i3);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }
}
