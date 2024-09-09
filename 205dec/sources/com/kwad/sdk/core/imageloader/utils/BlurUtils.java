package com.kwad.sdk.core.imageloader.utils;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import java.lang.reflect.Array;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BlurUtils {
    public static Bitmap stackBlur(Bitmap bitmap, @IntRange(from = 1, to = 180) int i4, boolean z3) {
        int[] iArr;
        int i5 = i4;
        Bitmap copy = z3 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i5 <= 0) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i6 = width * height;
        int[] iArr2 = new int[i6];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i7 = width - 1;
        int i8 = height - 1;
        int i9 = i5 + i5 + 1;
        int[] iArr3 = new int[i6];
        int[] iArr4 = new int[i6];
        int[] iArr5 = new int[i6];
        int[] iArr6 = new int[Math.max(width, height)];
        int i10 = (i9 + 1) >> 1;
        int i11 = i10 * i10;
        int i12 = i11 * 256;
        int[] iArr7 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            iArr7[i13] = i13 / i11;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, i9, 3);
        int i14 = i5 + 1;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i15 < height) {
            Bitmap bitmap2 = copy;
            int i18 = height;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = -i5;
            int i28 = 0;
            while (i27 <= i5) {
                int i29 = i8;
                int[] iArr9 = iArr6;
                int i30 = iArr2[i16 + Math.min(i7, Math.max(i27, 0))];
                int[] iArr10 = iArr8[i27 + i5];
                iArr10[0] = (i30 & 16711680) >> 16;
                iArr10[1] = (i30 & 65280) >> 8;
                iArr10[2] = i30 & 255;
                int abs = i14 - Math.abs(i27);
                i28 += iArr10[0] * abs;
                i19 += iArr10[1] * abs;
                i20 += iArr10[2] * abs;
                if (i27 > 0) {
                    i24 += iArr10[0];
                    i25 += iArr10[1];
                    i26 += iArr10[2];
                } else {
                    i21 += iArr10[0];
                    i22 += iArr10[1];
                    i23 += iArr10[2];
                }
                i27++;
                i8 = i29;
                iArr6 = iArr9;
            }
            int i31 = i8;
            int[] iArr11 = iArr6;
            int i32 = i5;
            int i33 = i28;
            int i34 = 0;
            while (i34 < width) {
                iArr3[i16] = iArr7[i33];
                iArr4[i16] = iArr7[i19];
                iArr5[i16] = iArr7[i20];
                int i35 = i33 - i21;
                int i36 = i19 - i22;
                int i37 = i20 - i23;
                int[] iArr12 = iArr8[((i32 - i5) + i9) % i9];
                int i38 = i21 - iArr12[0];
                int i39 = i22 - iArr12[1];
                int i40 = i23 - iArr12[2];
                if (i15 == 0) {
                    iArr = iArr7;
                    iArr11[i34] = Math.min(i34 + i5 + 1, i7);
                } else {
                    iArr = iArr7;
                }
                int i41 = iArr2[i17 + iArr11[i34]];
                iArr12[0] = (i41 & 16711680) >> 16;
                iArr12[1] = (i41 & 65280) >> 8;
                iArr12[2] = i41 & 255;
                int i42 = i24 + iArr12[0];
                int i43 = i25 + iArr12[1];
                int i44 = i26 + iArr12[2];
                i33 = i35 + i42;
                i19 = i36 + i43;
                i20 = i37 + i44;
                i32 = (i32 + 1) % i9;
                int[] iArr13 = iArr8[i32 % i9];
                i21 = i38 + iArr13[0];
                i22 = i39 + iArr13[1];
                i23 = i40 + iArr13[2];
                i24 = i42 - iArr13[0];
                i25 = i43 - iArr13[1];
                i26 = i44 - iArr13[2];
                i16++;
                i34++;
                iArr7 = iArr;
            }
            i17 += width;
            i15++;
            copy = bitmap2;
            height = i18;
            i8 = i31;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = copy;
        int i45 = i8;
        int[] iArr14 = iArr6;
        int i46 = height;
        int[] iArr15 = iArr7;
        int i47 = 0;
        while (i47 < width) {
            int i48 = -i5;
            int i49 = i9;
            int[] iArr16 = iArr2;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            int i57 = i48;
            int i58 = i48 * width;
            int i59 = 0;
            int i60 = 0;
            while (i57 <= i5) {
                int i61 = width;
                int max = Math.max(0, i58) + i47;
                int[] iArr17 = iArr8[i57 + i5];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i14 - Math.abs(i57);
                i59 += iArr3[max] * abs2;
                i60 += iArr4[max] * abs2;
                i50 += iArr5[max] * abs2;
                if (i57 > 0) {
                    i54 += iArr17[0];
                    i55 += iArr17[1];
                    i56 += iArr17[2];
                } else {
                    i51 += iArr17[0];
                    i52 += iArr17[1];
                    i53 += iArr17[2];
                }
                int i62 = i45;
                if (i57 < i62) {
                    i58 += i61;
                }
                i57++;
                i45 = i62;
                width = i61;
            }
            int i63 = width;
            int i64 = i45;
            int i65 = i5;
            int i66 = i47;
            int i67 = i60;
            int i68 = i46;
            int i69 = i59;
            int i70 = 0;
            while (i70 < i68) {
                iArr16[i66] = (iArr16[i66] & (-16777216)) | (iArr15[i69] << 16) | (iArr15[i67] << 8) | iArr15[i50];
                int i71 = i69 - i51;
                int i72 = i67 - i52;
                int i73 = i50 - i53;
                int[] iArr18 = iArr8[((i65 - i5) + i49) % i49];
                int i74 = i51 - iArr18[0];
                int i75 = i52 - iArr18[1];
                int i76 = i53 - iArr18[2];
                if (i47 == 0) {
                    iArr14[i70] = Math.min(i70 + i14, i64) * i63;
                }
                int i77 = iArr14[i70] + i47;
                iArr18[0] = iArr3[i77];
                iArr18[1] = iArr4[i77];
                iArr18[2] = iArr5[i77];
                int i78 = i54 + iArr18[0];
                int i79 = i55 + iArr18[1];
                int i80 = i56 + iArr18[2];
                i69 = i71 + i78;
                i67 = i72 + i79;
                i50 = i73 + i80;
                i65 = (i65 + 1) % i49;
                int[] iArr19 = iArr8[i65];
                i51 = i74 + iArr19[0];
                i52 = i75 + iArr19[1];
                i53 = i76 + iArr19[2];
                i54 = i78 - iArr19[0];
                i55 = i79 - iArr19[1];
                i56 = i80 - iArr19[2];
                i66 += i63;
                i70++;
                i5 = i4;
            }
            i47++;
            i5 = i4;
            i45 = i64;
            i46 = i68;
            i9 = i49;
            iArr2 = iArr16;
            width = i63;
        }
        int i81 = width;
        bitmap3.setPixels(iArr2, 0, i81, 0, 0, i81, i46);
        return bitmap3;
    }
}
