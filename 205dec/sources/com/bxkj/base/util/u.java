package com.bxkj.base.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Hashtable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: QRCode.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static int f18425a = 50;

    /* renamed from: b  reason: collision with root package name */
    private static final int f18426b = -16777216;

    /* renamed from: c  reason: collision with root package name */
    private static final int f18427c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static BarcodeFormat f18428d = BarcodeFormat.CODE_128;

    public static Bitmap a(String str, int i4, int i5) {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(str, f18428d, i4, i5);
        } catch (WriterException e4) {
            e4.printStackTrace();
            bitMatrix = null;
        }
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] iArr = new int[width * height];
        for (int i6 = 0; i6 < height; i6++) {
            int i7 = i6 * width;
            for (int i8 = 0; i8 < width; i8++) {
                iArr[i7 + i8] = bitMatrix.get(i8, i6) ? -16777216 : -1;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    public static Bitmap b(String str) {
        return c(str, 500);
    }

    public static Bitmap c(String str, int i4) {
        try {
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i4, i4, hashtable);
            int[] iArr = new int[i4 * i4];
            for (int i5 = 0; i5 < i4; i5++) {
                for (int i6 = 0; i6 < i4; i6++) {
                    if (encode.get(i6, i5)) {
                        iArr[(i5 * i4) + i6] = -16777216;
                    } else {
                        iArr[(i5 * i4) + i6] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i4, 0, 0, i4, i4);
            return createBitmap;
        } catch (WriterException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static Bitmap d(String str, int i4, Bitmap bitmap) {
        try {
            f18425a = i4 / 10;
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i4, i4, hashtable);
            int width = encode.getWidth();
            int i5 = width / 2;
            int height = encode.getHeight() / 2;
            Matrix matrix = new Matrix();
            matrix.setScale((f18425a * 2.0f) / bitmap.getWidth(), (f18425a * 2.0f) / bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            int[] iArr = new int[i4 * i4];
            for (int i6 = 0; i6 < i4; i6++) {
                for (int i7 = 0; i7 < i4; i7++) {
                    int i8 = f18425a;
                    if (i7 > i5 - i8 && i7 < i5 + i8 && i6 > height - i8 && i6 < height + i8) {
                        iArr[(i6 * width) + i7] = createBitmap.getPixel((i7 - i5) + i8, (i6 - height) + i8);
                    } else if (encode.get(i7, i6)) {
                        iArr[(i6 * i4) + i7] = -16777216;
                    } else {
                        iArr[(i6 * i4) + i7] = -1;
                    }
                }
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
            createBitmap2.setPixels(iArr, 0, i4, 0, 0, i4, i4);
            return createBitmap2;
        } catch (WriterException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static Bitmap e(String str, Bitmap bitmap) {
        return d(str, 500, bitmap);
    }

    public static Bitmap f(String str, int i4, Bitmap bitmap) {
        try {
            int i5 = i4 / 10;
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hashtable.put(EncodeHintType.MARGIN, 0);
            BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i4, i4, hashtable);
            int width = encode.getWidth();
            int i6 = width / 2;
            int height = encode.getHeight() / 2;
            Matrix matrix = new Matrix();
            float f4 = i5 * 2.0f;
            matrix.setScale(f4 / bitmap.getWidth(), f4 / bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            int[] iArr = new int[i4 * i4];
            for (int i7 = 0; i7 < i4; i7++) {
                for (int i8 = 0; i8 < i4; i8++) {
                    if (i8 > i6 - i5 && i8 < i6 + i5 && i7 > height - i5 && i7 < height + i5) {
                        iArr[(i7 * width) + i8] = createBitmap.getPixel((i8 - i6) + i5, (i7 - height) + i5);
                    } else if (encode.get(i8, i7)) {
                        iArr[(i7 * i4) + i8] = -16777216;
                    } else {
                        iArr[(i7 * i4) + i8] = -1;
                    }
                }
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
            createBitmap2.setPixels(iArr, 0, i4, 0, 0, i4, i4);
            return createBitmap2;
        } catch (WriterException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static Bitmap g(String str, int i4, int i5) {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(str, f18428d, i4, i5);
        } catch (WriterException e4) {
            e4.printStackTrace();
            bitMatrix = null;
        }
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] iArr = new int[width * height];
        for (int i6 = 0; i6 < height; i6++) {
            int i7 = i6 * width;
            for (int i8 = 0; i8 < width; i8++) {
                iArr[i7 + i8] = bitMatrix.get(i8, i6) ? -16777216 : -1;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        return Bitmap.createBitmap(createBitmap, 0, 0, width, height, matrix, true);
    }
}
