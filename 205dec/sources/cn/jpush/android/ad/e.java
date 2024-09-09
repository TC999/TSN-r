package cn.jpush.android.ad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import cn.jpush.android.helper.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {
    private static int a(int i4, int i5) {
        if (i4 % 2 == 1) {
            i4++;
        }
        if (i5 % 2 == 1) {
            i5++;
        }
        int max = Math.max(i4, i5);
        float min = Math.min(i4, i5) / max;
        if (min > 1.0f || min <= 0.5625d) {
            double d4 = min;
            if (d4 > 0.5625d || d4 <= 0.5d) {
                double d5 = max;
                Double.isNaN(d4);
                Double.isNaN(d5);
                return (int) Math.ceil(d5 / (1280.0d / d4));
            }
            int i6 = max / 1280;
            if (i6 == 0) {
                return 1;
            }
            return i6;
        } else if (max < 1664) {
            return 1;
        } else {
            if (max < 4990) {
                return 2;
            }
            if (max <= 4990 || max >= 10240) {
                int i7 = max / 1280;
                if (i7 == 0) {
                    return 1;
                }
                return i7;
            }
            return 4;
        }
    }

    private static Bitmap.CompressFormat a(String str) {
        str.hashCode();
        return !str.equals("image/png") ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
    }

    public static Bitmap a(String str, int i4, int i5) {
        return BitmapFactory.decodeFile(str, new BitmapFactory.Options());
    }

    public static void a(String str, String str2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = 1;
            BitmapFactory.decodeFile(str, options);
            int a4 = a(options.outWidth, options.outHeight);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            Logger.d("ImageUtils", "compressImage  computeSize=" + a4);
            options2.inSampleSize = a4;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options2);
            if (decodeFile == null) {
                Logger.d("ImageUtils", "compressImage  tagBitmap is null");
                return;
            }
            String a5 = a.a(str2);
            Logger.d("ImageUtils", "compressImage  file type=" + a5);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            boolean compress = decodeFile.compress(a(a5), 60, byteArrayOutputStream);
            Logger.d("ImageUtils", "compressImage  compress=" + compress);
            if (compress) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                decodeFile.recycle();
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                byteArrayOutputStream.close();
            }
        } catch (Throwable th) {
            Logger.d("ImageUtils", "compressImage throwable=" + th);
        }
    }
}
