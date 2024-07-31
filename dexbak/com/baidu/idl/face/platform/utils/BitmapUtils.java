package com.baidu.idl.face.platform.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import androidx.core.view.ViewCompat;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    public static Bitmap BGR2Bitmap(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3 * 4];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * 3;
            byte b = bArr[i5 + 0];
            byte b2 = bArr[i5 + 1];
            int i6 = i4 * 4;
            bArr2[i6 + 0] = bArr[i5 + 2];
            bArr2[i6 + 1] = b2;
            bArr2[i6 + 2] = b;
            bArr2[i6 + 3] = -1;
        }
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr2));
        return createBitmap;
    }

    public static Bitmap Depth2Bitmap(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * 2;
            int i6 = i5 + 1;
            iArr[i4] = ((((bArr[i5] + (bArr[i6] * 256)) / 10) & 255) << 16) | (((bArr[i5] + (bArr[i6] * 256)) / 10) & 255) | ((((bArr[i5] + (bArr[i6] * 256)) / 10) & 255) << 8) | ViewCompat.MEASURED_STATE_MASK;
        }
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    public static byte[] bitmapCompress(Bitmap bitmap, int i) {
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
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArray;
        } catch (Exception unused2) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String bitmapToJpegBase64(Bitmap bitmap, int i, float f) {
        try {
            float max = f / Math.max(bitmap.getWidth(), bitmap.getHeight());
            if (max < 1.0f) {
                bitmap = scale(bitmap, max);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return Base64Utils.encodeToString(byteArray, 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap calculateInSampleSize(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > i2 || width > i) {
            float f = i2 / height;
            float f2 = i / width;
            if (f >= f2) {
                f = f2;
            }
            return scale(bitmap, f);
        }
        return bitmap;
    }

    public static int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
        int ceil;
        int min;
        double d = options.outWidth;
        double d2 = options.outHeight;
        if (i2 == -1) {
            ceil = 1;
        } else {
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = i2;
            Double.isNaN(d3);
            ceil = (int) Math.ceil(Math.sqrt((d * d2) / d3));
        }
        if (i == -1) {
            min = 128;
        } else {
            double d4 = i;
            Double.isNaN(d);
            Double.isNaN(d4);
            double floor = Math.floor(d / d4);
            Double.isNaN(d2);
            Double.isNaN(d4);
            min = (int) Math.min(floor, Math.floor(d2 / d4));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? ceil : min;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int computeInitialSampleSize = computeInitialSampleSize(options, i, i2);
        if (computeInitialSampleSize <= 8) {
            int i3 = 1;
            while (i3 < computeInitialSampleSize) {
                i3 <<= 1;
            }
            return i3;
        }
        return ((computeInitialSampleSize + 7) / 8) * 8;
    }

    public static Bitmap createBitmap(Context context, byte[] bArr, float f) {
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
            rotateBitmap = rotateBitmap(f, bitmap);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            rotateBitmap = rotateBitmap(f, bitmap);
        }
        if (rotateBitmap != bitmap && bitmap != null) {
            bitmap.recycle();
        }
        return rotateBitmap;
    }

    public static int decodeImageDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    return ROTATE270;
                }
                return 90;
            }
            return 180;
        } catch (Exception e) {
            e.printStackTrace();
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

    public static Bitmap rotateBitmap(float f, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        if (f == 0.0f) {
            return bitmap;
        }
        matrix.setRotate(f);
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
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Exception e3) {
                            e3.printStackTrace();
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
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public static Bitmap scale(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap yuv2Bitmap(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = (i4 * i) + i5;
                int i7 = 255;
                int i8 = bArr[i6] & UByte.f41242c;
                int i9 = ((i4 >> 1) * i) + i3 + (i5 & (-2));
                int i10 = bArr[i9 + 0] & UByte.f41242c;
                int i11 = bArr[i9 + 1] & UByte.f41242c;
                if (i8 < 16) {
                    i8 = 16;
                }
                float f = (i8 - 16) * 1.164f;
                float f2 = i11 - 128;
                int round = Math.round((1.596f * f2) + f);
                float f3 = i10 - 128;
                int round2 = Math.round((f - (f2 * 0.813f)) - (0.391f * f3));
                int round3 = Math.round(f + (f3 * 2.018f));
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
                    i7 = 0;
                } else if (round3 <= 255) {
                    i7 = round3;
                }
                iArr[i6] = (i7 << 16) + ViewCompat.MEASURED_STATE_MASK + (round2 << 8) + round;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    public static Bitmap scale(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap createBitmap(Context context, String str, int i) {
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
            rotateBitmap = rotateBitmap(i, bitmap);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if (bitmap != null) {
                bitmap.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(str, options);
            rotateBitmap = rotateBitmap(i, bitmap);
        }
        if (rotateBitmap != bitmap && bitmap != null) {
            bitmap.recycle();
        }
        return rotateBitmap;
    }

    public static Bitmap createBitmap(Context context, byte[] bArr, int i) {
        Bitmap rotateBitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = null;
        try {
            Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            rotateBitmap = rotateBitmap(i, bitmap);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if (bitmap != null) {
                bitmap.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            rotateBitmap = rotateBitmap(i, bitmap);
        }
        if (rotateBitmap != bitmap && bitmap != null) {
            bitmap.recycle();
        }
        return rotateBitmap;
    }

    public static Bitmap createBitmap(Context context, int i, int i2, int[] iArr) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = false;
            bitmap = Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            bitmap = null;
        }
        if (bitmap != null && bitmap != null) {
            bitmap.recycle();
        }
        return null;
    }
}
