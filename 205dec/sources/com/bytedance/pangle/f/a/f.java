package com.bytedance.pangle.f.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    int[] f28766a;

    /* renamed from: b  reason: collision with root package name */
    int[] f28767b;

    public final String a(int i4) {
        int[] iArr;
        if (i4 < 0 || (iArr = this.f28766a) == null || i4 >= iArr.length) {
            return null;
        }
        int i5 = iArr[i4];
        int a4 = a(this.f28767b, i5);
        StringBuilder sb = new StringBuilder(a4);
        while (a4 != 0) {
            i5 += 2;
            sb.append((char) a(this.f28767b, i5));
            a4--;
        }
        return sb.toString();
    }

    private static final int a(int[] iArr, int i4) {
        int i5 = iArr[i4 / 4];
        return (i4 % 4) / 2 == 0 ? i5 & 65535 : i5 >>> 16;
    }
}
