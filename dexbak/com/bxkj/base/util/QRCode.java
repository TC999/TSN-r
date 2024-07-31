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

/* renamed from: com.bxkj.base.util.u */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class QRCode {

    /* renamed from: a */
    private static int f14941a = 50;

    /* renamed from: b */
    private static final int f14942b = -16777216;

    /* renamed from: c */
    private static final int f14943c = -1;

    /* renamed from: d */
    private static BarcodeFormat f14944d = BarcodeFormat.CODE_128;

    /* renamed from: a */
    public static Bitmap m44029a(String str, int i, int i2) {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(str, f14944d, i, i2);
        } catch (WriterException e) {
            e.printStackTrace();
            bitMatrix = null;
        }
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] iArr = new int[width * height];
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = i3 * width;
            for (int i5 = 0; i5 < width; i5++) {
                iArr[i4 + i5] = bitMatrix.get(i5, i3) ? -16777216 : -1;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    /* renamed from: b */
    public static Bitmap m44028b(String str) {
        return m44027c(str, 500);
    }

    /* renamed from: c */
    public static Bitmap m44027c(String str, int i) {
        try {
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i, i, hashtable);
            int[] iArr = new int[i * i];
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    if (encode.get(i3, i2)) {
                        iArr[(i2 * i) + i3] = -16777216;
                    } else {
                        iArr[(i2 * i) + i3] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i);
            return createBitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public static Bitmap m44026d(String str, int i, Bitmap bitmap) {
        try {
            f14941a = i / 10;
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i, i, hashtable);
            int width = encode.getWidth();
            int i2 = width / 2;
            int height = encode.getHeight() / 2;
            Matrix matrix = new Matrix();
            matrix.setScale((f14941a * 2.0f) / bitmap.getWidth(), (f14941a * 2.0f) / bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            int[] iArr = new int[i * i];
            for (int i3 = 0; i3 < i; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    int i5 = f14941a;
                    if (i4 > i2 - i5 && i4 < i2 + i5 && i3 > height - i5 && i3 < height + i5) {
                        iArr[(i3 * width) + i4] = createBitmap.getPixel((i4 - i2) + i5, (i3 - height) + i5);
                    } else if (encode.get(i4, i3)) {
                        iArr[(i3 * i) + i4] = -16777216;
                    } else {
                        iArr[(i3 * i) + i4] = -1;
                    }
                }
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            createBitmap2.setPixels(iArr, 0, i, 0, 0, i, i);
            return createBitmap2;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public static Bitmap m44025e(String str, Bitmap bitmap) {
        return m44026d(str, 500, bitmap);
    }

    /* renamed from: f */
    public static Bitmap m44024f(String str, int i, Bitmap bitmap) {
        try {
            int i2 = i / 10;
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hashtable.put(EncodeHintType.MARGIN, 0);
            BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i, i, hashtable);
            int width = encode.getWidth();
            int i3 = width / 2;
            int height = encode.getHeight() / 2;
            Matrix matrix = new Matrix();
            float f = i2 * 2.0f;
            matrix.setScale(f / bitmap.getWidth(), f / bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            int[] iArr = new int[i * i];
            for (int i4 = 0; i4 < i; i4++) {
                for (int i5 = 0; i5 < i; i5++) {
                    if (i5 > i3 - i2 && i5 < i3 + i2 && i4 > height - i2 && i4 < height + i2) {
                        iArr[(i4 * width) + i5] = createBitmap.getPixel((i5 - i3) + i2, (i4 - height) + i2);
                    } else if (encode.get(i5, i4)) {
                        iArr[(i4 * i) + i5] = -16777216;
                    } else {
                        iArr[(i4 * i) + i5] = -1;
                    }
                }
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            createBitmap2.setPixels(iArr, 0, i, 0, 0, i, i);
            return createBitmap2;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: g */
    public static Bitmap m44023g(String str, int i, int i2) {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(str, f14944d, i, i2);
        } catch (WriterException e) {
            e.printStackTrace();
            bitMatrix = null;
        }
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] iArr = new int[width * height];
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = i3 * width;
            for (int i5 = 0; i5 < width; i5++) {
                iArr[i4 + i5] = bitMatrix.get(i5, i3) ? -16777216 : -1;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        return Bitmap.createBitmap(createBitmap, 0, 0, width, height, matrix, true);
    }
}
