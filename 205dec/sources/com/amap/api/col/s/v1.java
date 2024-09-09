package com.amap.api.col.s;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Base64Util.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class v1 {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f10336a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f10337b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f10338c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f10339d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f10340e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f10341f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: g  reason: collision with root package name */
    static final /* synthetic */ boolean f10342g = true;

    private v1() {
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = b(bArr, bArr.length);
        } catch (IOException e4) {
            if (!f10342g) {
                throw new AssertionError(e4.getMessage());
            }
            str = null;
        }
        if (f10342g || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    private static String b(byte[] bArr, int i4) throws IOException {
        if (bArr != null) {
            if (i4 >= 0) {
                if (i4 + 0 <= bArr.length) {
                    int i5 = ((i4 / 3) * 4) + (i4 % 3 <= 0 ? 0 : 4);
                    byte[] bArr2 = new byte[i5];
                    int i6 = i4 - 2;
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < i6) {
                        d(bArr, i7 + 0, 3, bArr2, i8);
                        i7 += 3;
                        i8 += 4;
                    }
                    if (i7 < i4) {
                        d(bArr, i7 + 0, i4 - i7, bArr2, i8);
                        i8 += 4;
                    }
                    if (i8 <= i5 - 1) {
                        byte[] bArr3 = new byte[i8];
                        System.arraycopy(bArr2, 0, bArr3, 0, i8);
                        bArr2 = bArr3;
                    }
                    try {
                        return new String(bArr2, "US-ASCII");
                    } catch (UnsupportedEncodingException unused) {
                        return new String(bArr2);
                    }
                }
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i4), Integer.valueOf(bArr.length)));
            }
            throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i4)));
        }
        throw new NullPointerException("Cannot serialize a null array.");
    }

    public static byte[] c(String str) throws IOException {
        return e(str);
    }

    private static byte[] d(byte[] bArr, int i4, int i5, byte[] bArr2, int i6) {
        byte[] bArr3 = f10336a;
        int i7 = (i5 > 0 ? (bArr[i4] << 24) >>> 8 : 0) | (i5 > 1 ? (bArr[i4 + 1] << 24) >>> 16 : 0) | (i5 > 2 ? (bArr[i4 + 2] << 24) >>> 24 : 0);
        if (i5 == 1) {
            bArr2[i6] = bArr3[i7 >>> 18];
            bArr2[i6 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i6 + 2] = 61;
            bArr2[i6 + 3] = 61;
            return bArr2;
        } else if (i5 == 2) {
            bArr2[i6] = bArr3[i7 >>> 18];
            bArr2[i6 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i6 + 2] = bArr3[(i7 >>> 6) & 63];
            bArr2[i6 + 3] = 61;
            return bArr2;
        } else if (i5 != 3) {
            return bArr2;
        } else {
            bArr2[i6] = bArr3[i7 >>> 18];
            bArr2[i6 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i6 + 2] = bArr3[(i7 >>> 6) & 63];
            bArr2[i6 + 3] = bArr3[i7 & 63];
            return bArr2;
        }
    }

    private static byte[] e(String str) throws IOException {
        byte[] bytes;
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        if (str != null) {
            try {
                bytes = str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                bytes = str.getBytes();
            }
            byte[] f4 = f(bytes, bytes.length);
            if (f4.length >= 4 && 35615 == ((f4[0] & 255) | ((f4[1] << 8) & 65280))) {
                byte[] bArr = new byte[2048];
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(f4);
                            try {
                                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                while (true) {
                                    try {
                                        int read = gZIPInputStream.read(bArr);
                                        if (read < 0) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr, 0, read);
                                    } catch (IOException e4) {
                                        e = e4;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        try {
                                            e.printStackTrace();
                                            byteArrayOutputStream.close();
                                            gZIPInputStream.close();
                                            byteArrayInputStream.close();
                                            return f4;
                                        } catch (Throwable th) {
                                            th = th;
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused2) {
                                            }
                                            try {
                                                gZIPInputStream.close();
                                            } catch (Exception unused3) {
                                            }
                                            try {
                                                byteArrayInputStream.close();
                                            } catch (Exception unused4) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        byteArrayOutputStream.close();
                                        gZIPInputStream.close();
                                        byteArrayInputStream.close();
                                        throw th;
                                    }
                                }
                                f4 = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.close();
                            } catch (IOException e5) {
                                e = e5;
                                gZIPInputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPInputStream = null;
                            }
                        } catch (IOException e6) {
                            e = e6;
                            byteArrayInputStream = null;
                            gZIPInputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            byteArrayInputStream = null;
                            gZIPInputStream = null;
                        }
                    } catch (IOException e7) {
                        e = e7;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    }
                } catch (Exception unused5) {
                }
                try {
                    gZIPInputStream.close();
                } catch (Exception unused6) {
                }
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused7) {
                }
            }
            return f4;
        }
        throw new NullPointerException("Input string was null.");
    }

    private static byte[] f(byte[] bArr, int i4) throws IOException {
        int i5;
        if (bArr != null) {
            int i6 = i4 + 0;
            int i7 = 1;
            if (i6 <= bArr.length) {
                if (i4 == 0) {
                    return new byte[0];
                }
                if (i4 >= 4) {
                    byte[] bArr2 = f10337b;
                    int i8 = (i4 * 3) / 4;
                    byte[] bArr3 = new byte[i8];
                    byte[] bArr4 = new byte[4];
                    int i9 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    while (i9 < i6) {
                        byte b4 = bArr2[bArr[i9] & 255];
                        if (b4 < -5) {
                            throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", Integer.valueOf(bArr[i9] & 255), Integer.valueOf(i9)));
                        }
                        if (b4 >= -1) {
                            int i12 = i10 + 1;
                            bArr4[i10] = bArr[i9];
                            if (i12 <= 3) {
                                i10 = i12;
                            } else if (i11 >= 0 && (i5 = i11 + 2) < i8) {
                                byte[] bArr5 = f10337b;
                                if (bArr4[2] == 61) {
                                    bArr3[i11] = (byte) ((((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i7]] & 255) << 12)) >>> 16);
                                } else if (bArr4[3] == 61) {
                                    int i13 = ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i7]] & 255) << 12) | ((bArr5[bArr4[2]] & 255) << 6);
                                    bArr3[i11] = (byte) (i13 >>> 16);
                                    bArr3[i11 + 1] = (byte) (i13 >>> 8);
                                    i7 = 2;
                                } else {
                                    int i14 = ((bArr5[bArr4[i7]] & 255) << 12) | ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[2]] & 255) << 6) | (bArr5[bArr4[3]] & 255);
                                    bArr3[i11] = (byte) (i14 >> 16);
                                    bArr3[i11 + 1] = (byte) (i14 >> 8);
                                    bArr3[i5] = (byte) i14;
                                    i7 = 3;
                                }
                                i11 += i7;
                                if (bArr[i9] == 61) {
                                    break;
                                }
                                i10 = 0;
                            } else {
                                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(i8), Integer.valueOf(i11)));
                            }
                        }
                        i9++;
                        i7 = 1;
                    }
                    byte[] bArr6 = new byte[i11];
                    System.arraycopy(bArr3, 0, bArr6, 0, i11);
                    return bArr6;
                }
                throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(i4)));
            }
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), 0, Integer.valueOf(i4)));
        }
        throw new NullPointerException("Cannot decode null source array.");
    }
}
