package com.baidu.idl.face.platform.utils;

import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ImageExif {
    private static final String TAG = "CameraExif";

    public static int getOrientation(byte[] bArr) {
        int i4;
        int i5;
        if (bArr == null) {
            return 0;
        }
        int i6 = 0;
        while (i6 + 3 < bArr.length) {
            int i7 = i6 + 1;
            if ((bArr[i6] & 255) == 255) {
                int i8 = bArr[i7] & 255;
                if (i8 != 255) {
                    i7++;
                    if (i8 != 216 && i8 != 1) {
                        if (i8 != 217 && i8 != 218) {
                            int pack = pack(bArr, i7, 2, false);
                            if (pack >= 2 && (i5 = i7 + pack) <= bArr.length) {
                                if (i8 == 225 && pack >= 8 && pack(bArr, i7 + 2, 4, false) == 1165519206 && pack(bArr, i7 + 6, 2, false) == 0) {
                                    i6 = i7 + 8;
                                    i4 = pack - 8;
                                    break;
                                }
                                i6 = i5;
                            } else {
                                Log.e("CameraExif", "Invalid length");
                                return 0;
                            }
                        }
                    }
                }
                i6 = i7;
            }
            i6 = i7;
        }
        i4 = 0;
        if (i4 > 8) {
            int pack2 = pack(bArr, i6, 4, false);
            if (pack2 != 1229531648 && pack2 != 1296891946) {
                Log.e("CameraExif", "Invalid byte order");
                return 0;
            }
            boolean z3 = pack2 == 1229531648;
            int pack3 = pack(bArr, i6 + 4, 4, z3) + 2;
            if (pack3 >= 10 && pack3 <= i4) {
                int i9 = i6 + pack3;
                int i10 = i4 - pack3;
                int pack4 = pack(bArr, i9 - 2, 2, z3);
                while (true) {
                    int i11 = pack4 - 1;
                    if (pack4 <= 0 || i10 < 12) {
                        break;
                    } else if (pack(bArr, i9, 2, z3) == 274) {
                        int pack5 = pack(bArr, i9 + 8, 2, z3);
                        if (pack5 != 1) {
                            if (pack5 != 3) {
                                if (pack5 != 6) {
                                    if (pack5 != 8) {
                                        Log.i("CameraExif", "Unsupported orientation");
                                        return 0;
                                    }
                                    return 270;
                                }
                                return 90;
                            }
                            return 180;
                        }
                        return 0;
                    } else {
                        i9 += 12;
                        i10 -= 12;
                        pack4 = i11;
                    }
                }
            } else {
                Log.e("CameraExif", "Invalid offset");
                return 0;
            }
        }
        Log.i("CameraExif", "Orientation not found");
        return 0;
    }

    private static int pack(byte[] bArr, int i4, int i5, boolean z3) {
        int i6;
        if (z3) {
            i4 += i5 - 1;
            i6 = -1;
        } else {
            i6 = 1;
        }
        int i7 = 0;
        while (true) {
            int i8 = i5 - 1;
            if (i5 <= 0) {
                return i7;
            }
            if (i4 >= 0 && bArr != null && i4 < bArr.length) {
                i7 = (i7 << 8) | (bArr[i4] & 255);
            }
            i4 += i6;
            i5 = i8;
        }
    }
}
