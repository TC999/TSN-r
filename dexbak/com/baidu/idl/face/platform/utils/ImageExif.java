package com.baidu.idl.face.platform.utils;

import android.util.Log;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ImageExif {
    private static final String TAG = "CameraExif";

    public static int getOrientation(byte[] bArr) {
        int i;
        int i2;
        if (bArr == null) {
            return 0;
        }
        int i3 = 0;
        while (i3 + 3 < bArr.length) {
            int i4 = i3 + 1;
            if ((bArr[i3] & UByte.f41242c) == 255) {
                int i5 = bArr[i4] & UByte.f41242c;
                if (i5 != 255) {
                    i4++;
                    if (i5 != 216 && i5 != 1) {
                        if (i5 != 217 && i5 != 218) {
                            int pack = pack(bArr, i4, 2, false);
                            if (pack >= 2 && (i2 = i4 + pack) <= bArr.length) {
                                if (i5 == 225 && pack >= 8 && pack(bArr, i4 + 2, 4, false) == 1165519206 && pack(bArr, i4 + 6, 2, false) == 0) {
                                    i3 = i4 + 8;
                                    i = pack - 8;
                                    break;
                                }
                                i3 = i2;
                            } else {
                                Log.e(TAG, "Invalid length");
                                return 0;
                            }
                        }
                    }
                }
                i3 = i4;
            }
            i3 = i4;
        }
        i = 0;
        if (i > 8) {
            int pack2 = pack(bArr, i3, 4, false);
            if (pack2 != 1229531648 && pack2 != 1296891946) {
                Log.e(TAG, "Invalid byte order");
                return 0;
            }
            boolean z = pack2 == 1229531648;
            int pack3 = pack(bArr, i3 + 4, 4, z) + 2;
            if (pack3 >= 10 && pack3 <= i) {
                int i6 = i3 + pack3;
                int i7 = i - pack3;
                int pack4 = pack(bArr, i6 - 2, 2, z);
                while (true) {
                    int i8 = pack4 - 1;
                    if (pack4 <= 0 || i7 < 12) {
                        break;
                    } else if (pack(bArr, i6, 2, z) == 274) {
                        int pack5 = pack(bArr, i6 + 8, 2, z);
                        if (pack5 != 1) {
                            if (pack5 != 3) {
                                if (pack5 != 6) {
                                    if (pack5 != 8) {
                                        Log.i(TAG, "Unsupported orientation");
                                        return 0;
                                    }
                                    return BitmapUtils.ROTATE270;
                                }
                                return 90;
                            }
                            return 180;
                        }
                        return 0;
                    } else {
                        i6 += 12;
                        i7 -= 12;
                        pack4 = i8;
                    }
                }
            } else {
                Log.e(TAG, "Invalid offset");
                return 0;
            }
        }
        Log.i(TAG, "Orientation not found");
        return 0;
    }

    private static int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            if (i >= 0 && bArr != null && i < bArr.length) {
                i4 = (i4 << 8) | (bArr[i] & UByte.f41242c);
            }
            i += i3;
            i2 = i5;
        }
    }
}
