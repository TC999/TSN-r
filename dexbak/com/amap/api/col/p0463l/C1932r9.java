package com.amap.api.col.p0463l;

import kotlin.UByte;

/* compiled from: Base64.java */
/* renamed from: com.amap.api.col.3l.r9 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C1932r9 {

    /* renamed from: a */
    static final /* synthetic */ boolean f5199a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Base64.java */
    /* renamed from: com.amap.api.col.3l.r9$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractC1933a {

        /* renamed from: a */
        public byte[] f5200a;

        /* renamed from: b */
        public int f5201b;

        AbstractC1933a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Base64.java */
    /* renamed from: com.amap.api.col.3l.r9$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1934b extends AbstractC1933a {

        /* renamed from: f */
        private static final int[] f5202f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: g */
        private static final int[] f5203g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c */
        private int f5204c;

        /* renamed from: d */
        private int f5205d;

        /* renamed from: e */
        private final int[] f5206e;

        public C1934b(byte[] bArr) {
            this.f5200a = bArr;
            this.f5206e = f5202f;
            this.f5204c = 0;
            this.f5205d = 0;
        }

        /* renamed from: a */
        public final boolean m54019a(byte[] bArr, int i) {
            int i2 = this.f5204c;
            if (i2 == 6) {
                return false;
            }
            int i3 = i + 0;
            int i4 = this.f5205d;
            byte[] bArr2 = this.f5200a;
            int[] iArr = this.f5206e;
            int i5 = 0;
            int i6 = 0;
            while (i5 < i3) {
                if (i2 == 0) {
                    while (true) {
                        int i7 = i5 + 4;
                        if (i7 > i3) {
                            break;
                        }
                        i4 = iArr[bArr[i5 + 3] & UByte.f41242c] | (iArr[bArr[i5 + 1] & UByte.f41242c] << 12) | (iArr[bArr[i5] & UByte.f41242c] << 18) | (iArr[bArr[i5 + 2] & UByte.f41242c] << 6);
                        if (i4 < 0) {
                            break;
                        }
                        bArr2[i6 + 2] = (byte) i4;
                        bArr2[i6 + 1] = (byte) (i4 >> 8);
                        bArr2[i6] = (byte) (i4 >> 16);
                        i6 += 3;
                        i5 = i7;
                    }
                    if (i5 >= i3) {
                        break;
                    }
                }
                int i8 = i5 + 1;
                int i9 = iArr[bArr[i5] & UByte.f41242c];
                if (i2 != 0) {
                    if (i2 == 1) {
                        if (i9 < 0) {
                            if (i9 != -1) {
                                this.f5204c = 6;
                                return false;
                            }
                        }
                        i4 = (i4 << 6) | i9;
                        i2++;
                    } else if (i2 == 2) {
                        if (i9 < 0) {
                            if (i9 == -2) {
                                bArr2[i6] = (byte) (i4 >> 4);
                                i6++;
                                i5 = i8;
                                i2 = 4;
                            } else if (i9 != -1) {
                                this.f5204c = 6;
                                return false;
                            }
                        }
                        i4 = (i4 << 6) | i9;
                        i2++;
                    } else if (i2 != 3) {
                        if (i2 == 4) {
                            if (i9 != -2) {
                                if (i9 != -1) {
                                    this.f5204c = 6;
                                    return false;
                                }
                            }
                            i2++;
                        } else if (i2 == 5 && i9 != -1) {
                            this.f5204c = 6;
                            return false;
                        }
                    } else if (i9 >= 0) {
                        i4 = (i4 << 6) | i9;
                        bArr2[i6 + 2] = (byte) i4;
                        bArr2[i6 + 1] = (byte) (i4 >> 8);
                        bArr2[i6] = (byte) (i4 >> 16);
                        i6 += 3;
                        i5 = i8;
                        i2 = 0;
                    } else if (i9 == -2) {
                        bArr2[i6 + 1] = (byte) (i4 >> 2);
                        bArr2[i6] = (byte) (i4 >> 10);
                        i6 += 2;
                        i5 = i8;
                        i2 = 5;
                    } else if (i9 != -1) {
                        this.f5204c = 6;
                        return false;
                    }
                } else if (i9 >= 0) {
                    i2++;
                    i4 = i9;
                } else if (i9 != -1) {
                    this.f5204c = 6;
                    return false;
                }
                i5 = i8;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    bArr2[i6] = (byte) (i4 >> 4);
                    i6++;
                } else if (i2 == 3) {
                    int i10 = i6 + 1;
                    bArr2[i6] = (byte) (i4 >> 10);
                    i6 = i10 + 1;
                    bArr2[i10] = (byte) (i4 >> 2);
                } else if (i2 == 4) {
                    this.f5204c = 6;
                    return false;
                }
                this.f5204c = i2;
                this.f5201b = i6;
                return true;
            }
            this.f5204c = 6;
            return false;
        }
    }

    private C1932r9() {
    }

    /* renamed from: a */
    public static byte[] m54021a(byte[] bArr) {
        return m54020b(bArr, bArr.length);
    }

    /* renamed from: b */
    private static byte[] m54020b(byte[] bArr, int i) {
        C1934b c1934b = new C1934b(new byte[(i * 3) / 4]);
        if (c1934b.m54019a(bArr, i)) {
            int i2 = c1934b.f5201b;
            byte[] bArr2 = c1934b.f5200a;
            if (i2 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i2];
            System.arraycopy(bArr2, 0, bArr3, 0, i2);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
