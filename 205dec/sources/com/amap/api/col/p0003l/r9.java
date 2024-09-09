package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: INetwork.java */
/* renamed from: com.amap.api.col.3l.r9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface r9 {

    /* compiled from: Base64.java */
    /* renamed from: com.amap.api.col.3l.r9$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f8915a;

        /* renamed from: b  reason: collision with root package name */
        public int f8916b;

        a() {
        }
    }

    /* compiled from: Base64.java */
    /* renamed from: com.amap.api.col.3l.r9$b */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class b extends a {

        /* renamed from: f  reason: collision with root package name */
        private static final int[] f8917f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: g  reason: collision with root package name */
        private static final int[] f8918g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c  reason: collision with root package name */
        private int f8919c;

        /* renamed from: d  reason: collision with root package name */
        private int f8920d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f8921e;

        public b(byte[] bArr) {
            this.f8915a = bArr;
            this.f8921e = f8917f;
            this.f8919c = 0;
            this.f8920d = 0;
        }

        public final boolean a(byte[] bArr, int i4) {
            int i5 = this.f8919c;
            if (i5 == 6) {
                return false;
            }
            int i6 = i4 + 0;
            int i7 = this.f8920d;
            byte[] bArr2 = this.f8915a;
            int[] iArr = this.f8921e;
            int i8 = 0;
            int i9 = 0;
            while (i8 < i6) {
                if (i5 == 0) {
                    while (true) {
                        int i10 = i8 + 4;
                        if (i10 > i6) {
                            break;
                        }
                        i7 = iArr[bArr[i8 + 3] & 255] | (iArr[bArr[i8 + 1] & 255] << 12) | (iArr[bArr[i8] & 255] << 18) | (iArr[bArr[i8 + 2] & 255] << 6);
                        if (i7 < 0) {
                            break;
                        }
                        bArr2[i9 + 2] = (byte) i7;
                        bArr2[i9 + 1] = (byte) (i7 >> 8);
                        bArr2[i9] = (byte) (i7 >> 16);
                        i9 += 3;
                        i8 = i10;
                    }
                    if (i8 >= i6) {
                        break;
                    }
                }
                int i11 = i8 + 1;
                int i12 = iArr[bArr[i8] & 255];
                if (i5 != 0) {
                    if (i5 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.f8919c = 6;
                                return false;
                            }
                        }
                        i7 = (i7 << 6) | i12;
                        i5++;
                    } else if (i5 == 2) {
                        if (i12 < 0) {
                            if (i12 == -2) {
                                bArr2[i9] = (byte) (i7 >> 4);
                                i9++;
                                i8 = i11;
                                i5 = 4;
                            } else if (i12 != -1) {
                                this.f8919c = 6;
                                return false;
                            }
                        }
                        i7 = (i7 << 6) | i12;
                        i5++;
                    } else if (i5 != 3) {
                        if (i5 == 4) {
                            if (i12 != -2) {
                                if (i12 != -1) {
                                    this.f8919c = 6;
                                    return false;
                                }
                            }
                            i5++;
                        } else if (i5 == 5 && i12 != -1) {
                            this.f8919c = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        i7 = (i7 << 6) | i12;
                        bArr2[i9 + 2] = (byte) i7;
                        bArr2[i9 + 1] = (byte) (i7 >> 8);
                        bArr2[i9] = (byte) (i7 >> 16);
                        i9 += 3;
                        i8 = i11;
                        i5 = 0;
                    } else if (i12 == -2) {
                        bArr2[i9 + 1] = (byte) (i7 >> 2);
                        bArr2[i9] = (byte) (i7 >> 10);
                        i9 += 2;
                        i8 = i11;
                        i5 = 5;
                    } else if (i12 != -1) {
                        this.f8919c = 6;
                        return false;
                    }
                } else if (i12 >= 0) {
                    i5++;
                    i7 = i12;
                } else if (i12 != -1) {
                    this.f8919c = 6;
                    return false;
                }
                i8 = i11;
            }
            if (i5 != 1) {
                if (i5 == 2) {
                    bArr2[i9] = (byte) (i7 >> 4);
                    i9++;
                } else if (i5 == 3) {
                    int i13 = i9 + 1;
                    bArr2[i9] = (byte) (i7 >> 10);
                    i9 = i13 + 1;
                    bArr2[i13] = (byte) (i7 >> 2);
                } else if (i5 == 4) {
                    this.f8919c = 6;
                    return false;
                }
                this.f8919c = i5;
                this.f8916b = i9;
                return true;
            }
            this.f8919c = 6;
            return false;
        }
    }

    q9 a(o9 o9Var);
}
