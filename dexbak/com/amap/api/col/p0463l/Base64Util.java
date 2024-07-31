package com.amap.api.col.p0463l;

import androidx.core.view.MotionEventCompat;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import kotlin.UByte;
import okio.Utf8;

/* renamed from: com.amap.api.col.3l.h5 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class Base64Util {

    /* renamed from: a */
    private static final byte[] f4450a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b */
    private static final byte[] f4451b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, HttpConstants.EQUALS, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, BinaryMemcacheOpcodes.SETQ, BinaryMemcacheOpcodes.ADDQ, BinaryMemcacheOpcodes.REPLACEQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.APPENDQ, -9, -9, -9, -9, -9, -9, BinaryMemcacheOpcodes.PREPENDQ, 27, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.GAT, BinaryMemcacheOpcodes.GATQ, 31, 32, BinaryMemcacheOpcodes.SASL_AUTH, 34, BinaryMemcacheOpcodes.GATK, BinaryMemcacheOpcodes.GATKQ, 37, 38, 39, 40, 41, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c */
    private static final byte[] f4452c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: d */
    private static final byte[] f4453d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, HttpConstants.EQUALS, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, BinaryMemcacheOpcodes.SETQ, BinaryMemcacheOpcodes.ADDQ, BinaryMemcacheOpcodes.REPLACEQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.APPENDQ, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, BinaryMemcacheOpcodes.PREPENDQ, 27, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.GAT, BinaryMemcacheOpcodes.GATQ, 31, 32, BinaryMemcacheOpcodes.SASL_AUTH, 34, BinaryMemcacheOpcodes.GATK, BinaryMemcacheOpcodes.GATKQ, 37, 38, 39, 40, 41, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: e */
    private static final byte[] f4454e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: f */
    private static final byte[] f4455f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, BinaryMemcacheOpcodes.SETQ, BinaryMemcacheOpcodes.ADDQ, BinaryMemcacheOpcodes.REPLACEQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.APPENDQ, BinaryMemcacheOpcodes.PREPENDQ, 27, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.GAT, BinaryMemcacheOpcodes.GATQ, 31, 32, BinaryMemcacheOpcodes.SASL_AUTH, 34, BinaryMemcacheOpcodes.GATK, BinaryMemcacheOpcodes.GATKQ, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, HttpConstants.EQUALS, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: g */
    static final /* synthetic */ boolean f4456g = true;

    private Base64Util() {
    }

    /* renamed from: a */
    public static String m54756a(byte[] bArr) {
        String str;
        try {
            str = m54755b(bArr, bArr.length);
        } catch (IOException e) {
            if (!f4456g) {
                throw new AssertionError(e.getMessage());
            }
            str = null;
        }
        if (f4456g || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    private static String m54755b(byte[] bArr, int i) throws IOException {
        if (bArr != null) {
            if (i >= 0) {
                if (i + 0 <= bArr.length) {
                    int i2 = ((i / 3) * 4) + (i % 3 <= 0 ? 0 : 4);
                    byte[] bArr2 = new byte[i2];
                    int i3 = i - 2;
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < i3) {
                        m54753d(bArr, i4 + 0, 3, bArr2, i5);
                        i4 += 3;
                        i5 += 4;
                    }
                    if (i4 < i) {
                        m54753d(bArr, i4 + 0, i - i4, bArr2, i5);
                        i5 += 4;
                    }
                    if (i5 <= i2 - 1) {
                        byte[] bArr3 = new byte[i5];
                        System.arraycopy(bArr2, 0, bArr3, 0, i5);
                        bArr2 = bArr3;
                    }
                    try {
                        return new String(bArr2, "US-ASCII");
                    } catch (UnsupportedEncodingException unused) {
                        return new String(bArr2);
                    }
                }
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i), Integer.valueOf(bArr.length)));
            }
            throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i)));
        }
        throw new NullPointerException("Cannot serialize a null array.");
    }

    /* renamed from: c */
    public static byte[] m54754c(String str) throws IOException {
        return m54752e(str);
    }

    /* renamed from: d */
    private static byte[] m54753d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = f4450a;
        int i4 = (i2 > 0 ? (bArr[i] << BinaryMemcacheOpcodes.FLUSHQ) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << BinaryMemcacheOpcodes.FLUSHQ) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << BinaryMemcacheOpcodes.FLUSHQ) >>> 24 : 0);
        if (i2 == 1) {
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = HttpConstants.EQUALS;
            bArr2[i3 + 3] = HttpConstants.EQUALS;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
            bArr2[i3 + 3] = HttpConstants.EQUALS;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
            bArr2[i3 + 3] = bArr3[i4 & 63];
            return bArr2;
        }
    }

    /* renamed from: e */
    private static byte[] m54752e(String str) throws IOException {
        byte[] bytes;
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        if (str != null) {
            try {
                bytes = str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                bytes = str.getBytes();
            }
            byte[] m54751f = m54751f(bytes, bytes.length);
            if (m54751f.length >= 4 && 35615 == ((m54751f[0] & UByte.f41242c) | ((m54751f[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) {
                byte[] bArr = new byte[2048];
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(m54751f);
                            try {
                                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                while (true) {
                                    try {
                                        int read = gZIPInputStream.read(bArr);
                                        if (read < 0) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr, 0, read);
                                    } catch (IOException e) {
                                        e = e;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        try {
                                            e.printStackTrace();
                                            byteArrayOutputStream.close();
                                            gZIPInputStream.close();
                                            byteArrayInputStream.close();
                                            return m54751f;
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
                                m54751f = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.close();
                            } catch (IOException e2) {
                                e = e2;
                                gZIPInputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPInputStream = null;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            byteArrayInputStream = null;
                            gZIPInputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            byteArrayInputStream = null;
                            gZIPInputStream = null;
                        }
                    } catch (IOException e4) {
                        e = e4;
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
            return m54751f;
        }
        throw new NullPointerException("Input string was null.");
    }

    /* renamed from: f */
    private static byte[] m54751f(byte[] bArr, int i) throws IOException {
        int i2;
        if (bArr != null) {
            int i3 = i + 0;
            int i4 = 1;
            if (i3 <= bArr.length) {
                if (i == 0) {
                    return new byte[0];
                }
                if (i >= 4) {
                    byte[] bArr2 = f4451b;
                    int i5 = (i * 3) / 4;
                    byte[] bArr3 = new byte[i5];
                    byte[] bArr4 = new byte[4];
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    while (i6 < i3) {
                        byte b = bArr2[bArr[i6] & UByte.f41242c];
                        if (b < -5) {
                            throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", Integer.valueOf(bArr[i6] & UByte.f41242c), Integer.valueOf(i6)));
                        }
                        if (b >= -1) {
                            int i9 = i7 + 1;
                            bArr4[i7] = bArr[i6];
                            if (i9 <= 3) {
                                i7 = i9;
                            } else if (i8 >= 0 && (i2 = i8 + 2) < i5) {
                                byte[] bArr5 = f4451b;
                                if (bArr4[2] == 61) {
                                    bArr3[i8] = (byte) ((((bArr5[bArr4[0]] & UByte.f41242c) << 18) | ((bArr5[bArr4[i4]] & UByte.f41242c) << 12)) >>> 16);
                                } else if (bArr4[3] == 61) {
                                    int i10 = ((bArr5[bArr4[0]] & UByte.f41242c) << 18) | ((bArr5[bArr4[i4]] & UByte.f41242c) << 12) | ((bArr5[bArr4[2]] & UByte.f41242c) << 6);
                                    bArr3[i8] = (byte) (i10 >>> 16);
                                    bArr3[i8 + 1] = (byte) (i10 >>> 8);
                                    i4 = 2;
                                } else {
                                    int i11 = ((bArr5[bArr4[i4]] & UByte.f41242c) << 12) | ((bArr5[bArr4[0]] & UByte.f41242c) << 18) | ((bArr5[bArr4[2]] & UByte.f41242c) << 6) | (bArr5[bArr4[3]] & UByte.f41242c);
                                    bArr3[i8] = (byte) (i11 >> 16);
                                    bArr3[i8 + 1] = (byte) (i11 >> 8);
                                    bArr3[i2] = (byte) i11;
                                    i4 = 3;
                                }
                                i8 += i4;
                                if (bArr[i6] == 61) {
                                    break;
                                }
                                i7 = 0;
                            } else {
                                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(i5), Integer.valueOf(i8)));
                            }
                        }
                        i6++;
                        i4 = 1;
                    }
                    byte[] bArr6 = new byte[i8];
                    System.arraycopy(bArr3, 0, bArr6, 0, i8);
                    return bArr6;
                }
                throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(i)));
            }
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        }
        throw new NullPointerException("Cannot decode null source array.");
    }
}
