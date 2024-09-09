package com.bytedance.adsdk.lottie;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class t {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f25748a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    static final long[] f25749b = new long[0];

    /* renamed from: c  reason: collision with root package name */
    static final Object[] f25750c = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int[] iArr, int i4, int i5) {
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
}
