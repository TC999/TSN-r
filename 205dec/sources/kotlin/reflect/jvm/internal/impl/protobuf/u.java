package kotlin.reflect.jvm.internal.impl.protobuf;

/* compiled from: Utf8.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class u {
    private static int a(int i4) {
        if (i4 > -12) {
            return -1;
        }
        return i4;
    }

    private static int b(int i4, int i5) {
        if (i4 > -12 || i5 > -65) {
            return -1;
        }
        return i4 ^ (i5 << 8);
    }

    private static int c(int i4, int i5, int i6) {
        if (i4 > -12 || i5 > -65 || i6 > -65) {
            return -1;
        }
        return (i4 ^ (i5 << 8)) ^ (i6 << 16);
    }

    private static int d(byte[] bArr, int i4, int i5) {
        byte b4 = bArr[i4 - 1];
        int i6 = i5 - i4;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    return c(b4, bArr[i4], bArr[i4 + 1]);
                }
                throw new AssertionError();
            }
            return b(b4, bArr[i4]);
        }
        return a(b4);
    }

    public static boolean e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public static boolean f(byte[] bArr, int i4, int i5) {
        return h(bArr, i4, i5) == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        if (r7[r8] > (-65)) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
        if (r7[r8] > (-65)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x007f, code lost:
        if (r7[r8] > (-65)) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int g(int r6, byte[] r7, int r8, int r9) {
        /*
            if (r6 == 0) goto L82
            if (r8 < r9) goto L5
            return r6
        L5:
            byte r0 = (byte) r6
            r1 = -32
            r2 = -1
            r3 = -65
            if (r0 >= r1) goto L1c
            r6 = -62
            if (r0 < r6) goto L1b
            int r6 = r8 + 1
            r8 = r7[r8]
            if (r8 <= r3) goto L18
            goto L1b
        L18:
            r8 = r6
            goto L82
        L1b:
            return r2
        L1c:
            r4 = -16
            if (r0 >= r4) goto L49
            int r6 = r6 >> 8
            r6 = r6 ^ r2
            byte r6 = (byte) r6
            if (r6 != 0) goto L34
            int r6 = r8 + 1
            r8 = r7[r8]
            if (r6 < r9) goto L31
            int r6 = b(r0, r8)
            return r6
        L31:
            r5 = r8
            r8 = r6
            r6 = r5
        L34:
            if (r6 > r3) goto L48
            r4 = -96
            if (r0 != r1) goto L3c
            if (r6 < r4) goto L48
        L3c:
            r1 = -19
            if (r0 != r1) goto L42
            if (r6 >= r4) goto L48
        L42:
            int r6 = r8 + 1
            r8 = r7[r8]
            if (r8 <= r3) goto L18
        L48:
            return r2
        L49:
            int r1 = r6 >> 8
            r1 = r1 ^ r2
            byte r1 = (byte) r1
            r4 = 0
            if (r1 != 0) goto L5d
            int r6 = r8 + 1
            r1 = r7[r8]
            if (r6 < r9) goto L5b
            int r6 = b(r0, r1)
            return r6
        L5b:
            r8 = r6
            goto L60
        L5d:
            int r6 = r6 >> 16
            byte r4 = (byte) r6
        L60:
            if (r4 != 0) goto L6e
            int r6 = r8 + 1
            r4 = r7[r8]
            if (r6 < r9) goto L6d
            int r6 = c(r0, r1, r4)
            return r6
        L6d:
            r8 = r6
        L6e:
            if (r1 > r3) goto L81
            int r6 = r0 << 28
            int r1 = r1 + 112
            int r6 = r6 + r1
            int r6 = r6 >> 30
            if (r6 != 0) goto L81
            if (r4 > r3) goto L81
            int r6 = r8 + 1
            r8 = r7[r8]
            if (r8 <= r3) goto L18
        L81:
            return r2
        L82:
            int r6 = h(r7, r8, r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.u.g(int, byte[], int, int):int");
    }

    public static int h(byte[] bArr, int i4, int i5) {
        while (i4 < i5 && bArr[i4] >= 0) {
            i4++;
        }
        if (i4 >= i5) {
            return 0;
        }
        return i(bArr, i4, i5);
    }

    private static int i(byte[] bArr, int i4, int i5) {
        while (i4 < i5) {
            int i6 = i4 + 1;
            byte b4 = bArr[i4];
            if (b4 < 0) {
                if (b4 < -32) {
                    if (i6 >= i5) {
                        return b4;
                    }
                    if (b4 >= -62) {
                        i4 = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return -1;
                } else if (b4 >= -16) {
                    if (i6 >= i5 - 2) {
                        return d(bArr, i6, i5);
                    }
                    int i7 = i6 + 1;
                    byte b5 = bArr[i6];
                    if (b5 <= -65 && (((b4 << 28) + (b5 + 112)) >> 30) == 0) {
                        int i8 = i7 + 1;
                        if (bArr[i7] <= -65) {
                            i6 = i8 + 1;
                            if (bArr[i8] > -65) {
                            }
                        }
                    }
                    return -1;
                } else if (i6 >= i5 - 1) {
                    return d(bArr, i6, i5);
                } else {
                    int i9 = i6 + 1;
                    byte b6 = bArr[i6];
                    if (b6 <= -65 && ((b4 != -32 || b6 >= -96) && (b4 != -19 || b6 < -96))) {
                        i4 = i9 + 1;
                        if (bArr[i9] > -65) {
                        }
                    }
                    return -1;
                }
            }
            i4 = i6;
        }
        return 0;
    }
}
