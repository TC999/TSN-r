package com.bytedance.sdk.component.widget.recycler.c.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class w {

    /* renamed from: c  reason: collision with root package name */
    static final int[] f30581c = new int[0];

    /* renamed from: w  reason: collision with root package name */
    static final long[] f30582w = new long[0];
    static final Object[] xv = new Object[0];

    public static int c(int i4) {
        return w(i4 * 8) / 8;
    }

    public static int w(int i4) {
        for (int i5 = 4; i5 < 32; i5++) {
            int i6 = (1 << i5) - 12;
            if (i4 <= i6) {
                return i6;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int[] iArr, int i4, int i5) {
        int i6 = i4 - 1;
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) >>> 1;
            int i9 = iArr[i8];
            if (i9 < i5) {
                i7 = i8 + 1;
            } else if (i9 <= i5) {
                return i8;
            } else {
                i6 = i8 - 1;
            }
        }
        return i7 ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(long[] jArr, int i4, long j4) {
        int i5 = i4 - 1;
        int i6 = 0;
        while (i6 <= i5) {
            int i7 = (i6 + i5) >>> 1;
            long j5 = jArr[i7];
            if (j5 < j4) {
                i6 = i7 + 1;
            } else if (j5 <= j4) {
                return i7;
            } else {
                i5 = i7 - 1;
            }
        }
        return i6 ^ (-1);
    }
}
