package com.baidu.idl.face.platform.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class BitmapUtils {
    public static final int IMAGEBOUND = 128;
    public static final int MAXLENTH = 1024;
    public static final int PIC_COMPRESS_SIZE = 4;
    private static final int QUALITY = 100;
    public static final int ROTATE0 = 0;
    public static final int ROTATE180 = 180;
    public static final int ROTATE270 = 270;
    public static final int ROTATE360 = 360;
    public static final int ROTATE90 = 90;
    private static final String TAG = "ImageUtils";

    private BitmapUtils() {
    }

    public static Bitmap BGR2Bitmap(byte[] bArr, int i4, int i5) {
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        int i6 = i4 * i5;
        byte[] bArr2 = new byte[i6 * 4];
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 * 3;
            byte b4 = bArr[i8 + 0];
            byte b5 = bArr[i8 + 1];
            int i9 = i7 * 4;
            bArr2[i9 + 0] = bArr[i8 + 2];
            bArr2[i9 + 1] = b5;
            bArr2[i9 + 2] = b4;
            bArr2[i9 + 3] = -1;
        }
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr2));
        return createBitmap;
    }

    public static Bitmap Depth2Bitmap(byte[] bArr, int i4, int i5) {
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        int i6 = i4 * i5;
        int[] iArr = new int[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 * 2;
            int i9 = i8 + 1;
            iArr[i7] = ((((bArr[i8] + (bArr[i9] * 256)) / 10) & 255) << 16) | (((bArr[i8] + (bArr[i9] * 256)) / 10) & 255) | ((((bArr[i8] + (bArr[i9] * 256)) / 10) & 255) << 8) | (-16777216);
        }
        createBitmap.setPixels(iArr, 0, i4, 0, 0, i4, i5);
        return createBitmap;
    }

    public static byte[] bitmapCompress(Bitmap bitmap, int i4) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Exception unused) {
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return byteArray;
        } catch (Exception unused2) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String bitmapToJpegBase64(Bitmap bitmap, int i4, float f4) {
        try {
            float max = f4 / Math.max(bitmap.getWidth(), bitmap.getHeight());
            if (max < 1.0f) {
                bitmap = scale(bitmap, max);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return Base64Utils.encodeToString(byteArray, 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap calculateInSampleSize(Bitmap bitmap, int i4, int i5) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > i5 || width > i4) {
            float f4 = i5 / height;
            float f5 = i4 / width;
            if (f4 >= f5) {
                f4 = f5;
            }
            return scale(bitmap, f4);
        }
        return bitmap;
    }

    public static int computeInitialSampleSize(BitmapFactory.Options options, int i4, int i5) {
        int ceil;
        int min;
        double d4 = options.outWidth;
        double d5 = options.outHeight;
        if (i5 == -1) {
            ceil = 1;
        } else {
            Double.isNaN(d4);
            Double.isNaN(d5);
            double d6 = i5;
            Double.isNaN(d6);
            ceil = (int) Math.ceil(Math.sqrt((d4 * d5) / d6));
        }
        if (i4 == -1) {
            min = 128;
        } else {
            double d7 = i4;
            Double.isNaN(d4);
            Double.isNaN(d7);
            double floor = Math.floor(d4 / d7);
            Double.isNaN(d5);
            Double.isNaN(d7);
            min = (int) Math.min(floor, Math.floor(d5 / d7));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i5 == -1 && i4 == -1) {
            return 1;
        }
        return i4 == -1 ? ceil : min;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i4, int i5) {
        int computeInitialSampleSize = computeInitialSampleSize(options, i4, i5);
        if (computeInitialSampleSize <= 8) {
            int i6 = 1;
            while (i6 < computeInitialSampleSize) {
                i6 <<= 1;
            }
            return i6;
        }
        return ((computeInitialSampleSize + 7) / 8) * 8;
    }

    public static Bitmap createBitmap(Context context, byte[] bArr, float f4) {
        Bitmap rotateBitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = null;
        try {
            int min = Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = computeSampleSize(options, min, 1048576);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            rotateBitmap = rotateBitmap(f4, bitmap);
        } catch (OutOfMemoryError e4) {
            e4.printStackTrace();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            rotateBitmap = rotateBitmap(f4, bitmap);
        }
        if (rotateBitmap != bitmap && bitmap != null) {
            bitmap.recycle();
        }
        return rotateBitmap;
    }

    public static int decodeImageDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static Bitmap getInstaceBmp(BDFaceImageInstance bDFaceImageInstance) {
        BDFaceSDKCommon.BDFaceImageType bDFaceImageType = bDFaceImageInstance.imageType;
        if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_RGBA) {
            Bitmap createBitmap = Bitmap.createBitmap(bDFaceImageInstance.width, bDFaceImageInstance.height, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bDFaceImageInstance.data));
            return createBitmap;
        } else if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_BGR) {
            return BGR2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
        } else {
            if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21) {
                return yuv2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
            }
            if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_GRAY) {
                return Depth2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
            }
            return null;
        }
    }

    public static Bitmap rotateBitmap(float f4, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        if (f4 == 0.0f) {
            return bitmap;
        }
        matrix.setRotate(f4);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static boolean saveBitmap(File file, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    return true;
                } catch (Exception e5) {
                    e = e5;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    public static Bitmap scale(Bitmap bitmap, float f4) {
        Matrix matrix = new Matrix();
        matrix.postScale(f4, f4);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap yuv2Bitmap(byte[] bArr, int i4, int i5) {
        int i6 = i4 * i5;
        int[] iArr = new int[i6];
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = (i7 * i4) + i8;
                int i10 = 255;
                int i11 = bArr[i9] & 255;
                int i12 = ((i7 >> 1) * i4) + i6 + (i8 & (-2));
                int i13 = bArr[i12 + 0] & 255;
                int i14 = bArr[i12 + 1] & 255;
                if (i11 < 16) {
                    i11 = 16;
                }
                float f4 = (i11 - 16) * 1.164f;
                float f5 = i14 - 128;
                int round = Math.round((1.596f * f5) + f4);
                float f6 = i13 - 128;
                int round2 = Math.round((f4 - (f5 * 0.813f)) - (0.391f * f6));
                int round3 = Math.round(f4 + (f6 * 2.018f));
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = 255;
                }
                if (round2 < 0) {
                    round2 = 0;
                } else if (round2 > 255) {
                    round2 = 255;
                }
                if (round3 < 0) {
                    i10 = 0;
                } else if (round3 <= 255) {
                    i10 = round3;
                }
                iArr[i9] = ((i10 << 16) - 16777216) + (round2 << 8) + round;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i4, 0, 0, i4, i5);
        return createBitmap;
    }

    public static Bitmap scale(Bitmap bitmap, int i4, int i5) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i4 / width, i5 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap createBitmap(Context context, String str, int i4) {
        Bitmap rotateBitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = null;
        try {
            int min = Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = computeSampleSize(options, min, 1048576);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(str, options);
            rotateBitmap = rotateBitmap(i4, bitmap);
        } catch (OutOfMemoryError e4) {
            e4.printStackTrace();
            if (bitmap != null) {
                bitmap.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(str, options);
            rotateBitmap = rotateBitmap(i4, bitmap);
        }
        if (rotateBitmap != bitmap && bitmap != null) {
            bitmap.recycle();
        }
        return rotateBitmap;
    }

    public static Bitmap createBitmap(Context context, byte[] bArr, int i4) {
        Bitmap rotateBitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = null;
        try {
            Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            rotateBitmap = rotateBitmap(i4, bitmap);
        } catch (OutOfMemoryError e4) {
            e4.printStackTrace();
            if (bitmap != null) {
                bitmap.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            rotateBitmap = rotateBitmap(i4, bitmap);
        }
        if (rotateBitmap != bitmap && bitmap != null) {
            bitmap.recycle();
        }
        return rotateBitmap;
    }

    public static Bitmap createBitmap(Context context, int i4, int i5, int[] iArr) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = false;
            bitmap = Bitmap.createBitmap(iArr, i4, i5, Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError e4) {
            e4.printStackTrace();
            bitmap = null;
        }
        if (bitmap != null && bitmap != null) {
            bitmap.recycle();
        }
        return null;
    }
}
