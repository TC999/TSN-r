package com.umeng.socialize.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.umeng.socialize.c.b.b;
import com.umeng.socialize.c.b.c;
import com.umeng.socialize.c.b.d;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ImageImpl.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    public static byte[] a(UMImage uMImage, int i4) {
        if (uMImage == null) {
            return DefaultClass.getBytes();
        }
        if (uMImage.asBinImage() != null && a(uMImage) >= i4) {
            if (uMImage.compressStyle != UMImage.CompressStyle.QUALITY) {
                try {
                    byte[] asBinImage = uMImage.asBinImage();
                    if (asBinImage == null) {
                        return new byte[1];
                    }
                    if (asBinImage.length <= 0) {
                        return uMImage.asBinImage();
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(asBinImage, 0, asBinImage.length);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(asBinImage, 0, asBinImage.length);
                    while (byteArrayOutputStream.toByteArray().length > i4) {
                        double length = asBinImage.length;
                        Double.isNaN(length);
                        double d4 = i4;
                        Double.isNaN(d4);
                        double sqrt = Math.sqrt((length * 1.0d) / d4);
                        double width = decodeByteArray.getWidth();
                        Double.isNaN(width);
                        int i5 = (int) (width / sqrt);
                        double height = decodeByteArray.getHeight();
                        Double.isNaN(height);
                        decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i5, (int) (height / sqrt), true);
                        byteArrayOutputStream.reset();
                        if (decodeByteArray != null) {
                            decodeByteArray.compress(uMImage.compressFormat, 100, byteArrayOutputStream);
                            asBinImage = byteArrayOutputStream.toByteArray();
                        }
                    }
                    if (byteArrayOutputStream.toByteArray().length > i4) {
                        return null;
                    }
                    return asBinImage;
                } catch (Throwable th) {
                    SLog.error(th);
                    return DefaultClass.getBytes();
                }
            }
            return a(uMImage.asBinImage(), i4, uMImage.compressFormat);
        }
        return uMImage.asBinImage();
    }

    private static byte[] b(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            float rowBytes = (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
                            float f4 = c.f53992b;
                            bitmap.compress(compressFormat, rowBytes > f4 ? (int) ((f4 / rowBytes) * 100) : 100, byteArrayOutputStream2);
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e4) {
                                SLog.error(UmengText.IMAGE.CLOSE, e4);
                            }
                            return byteArray;
                        } catch (Exception e5) {
                            e = e5;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            SLog.error(UmengText.IMAGE.BITMAOTOBINARY, e);
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e6) {
                                    SLog.error(UmengText.IMAGE.CLOSE, e6);
                                }
                            }
                            return DefaultClass.getBytes();
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e7) {
                                    SLog.error(UmengText.IMAGE.CLOSE, e7);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e8) {
                        e = e8;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public static String c(byte[] bArr) {
        return d.a(bArr);
    }

    private static BitmapFactory.Options d(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int ceil = (int) Math.ceil(options.outWidth / UMImage.MAX_WIDTH);
        int ceil2 = (int) Math.ceil(options.outHeight / UMImage.MAX_HEIGHT);
        if (ceil2 <= 1 || ceil <= 1) {
            if (ceil2 > 2) {
                options.inSampleSize = ceil2;
            } else if (ceil > 2) {
                options.inSampleSize = ceil;
            }
        } else if (ceil2 > ceil) {
            options.inSampleSize = ceil2;
        } else {
            options.inSampleSize = ceil;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    private static int e(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public static File b(byte[] bArr) {
        try {
            return a(bArr, b.a().b());
        } catch (IOException e4) {
            SLog.error(UmengText.IMAGE.BINARYTOFILE, e4);
            return null;
        }
    }

    private static byte[] b(File file, Bitmap.CompressFormat compressFormat) {
        if (file != null && file.getAbsoluteFile().exists()) {
            byte[] a4 = b.a().a(file);
            if (SocializeUtils.assertBinaryInvalid(a4)) {
                return d.f54005m[1].equals(d.a(a4)) ? a4 : a(a4, compressFormat);
            }
        }
        return null;
    }

    public static byte[] a(String str) {
        return SocializeNetUtils.getNetData(str);
    }

    public static Bitmap a(byte[] bArr) {
        if (bArr != null) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    private static File a(byte[] bArr, File file) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.close();
                    } catch (Exception e4) {
                        e = e4;
                        bufferedOutputStream = bufferedOutputStream2;
                        SLog.error(UmengText.IMAGE.GET_FILE_FROM_BINARY, e);
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return file;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e5) {
                                SLog.error(UmengText.IMAGE.CLOSE, e5);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (IOException e7) {
            SLog.error(UmengText.IMAGE.CLOSE, e7);
        }
        return file;
    }

    public static byte[] a(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return b(bitmap, compressFormat);
    }

    private static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static byte[] a(Context context, int i4, boolean z3, Bitmap.CompressFormat compressFormat) {
        Drawable drawable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!z3) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT >= 21) {
                drawable = resources.getDrawable(i4, null);
            } else {
                drawable = resources.getDrawable(i4);
            }
            Bitmap a4 = a(drawable);
            if (a4 != null) {
                a4.compress(compressFormat, 100, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        }
        byte[] bArr = new byte[0];
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap decodeStream = BitmapFactory.decodeStream(context.getResources().openRawResource(i4), null, options);
            if (decodeStream != null) {
                decodeStream.compress(compressFormat, 100, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Error e4) {
            SLog.error(UmengText.IMAGE.TOOBIG, e4);
            return bArr;
        }
    }

    public static byte[] a(File file, Bitmap.CompressFormat compressFormat) {
        return b(file, compressFormat);
    }

    public static int a(UMImage uMImage) {
        if (uMImage.getImageStyle() == UMImage.FILE_IMAGE) {
            return a(uMImage.asFileImage());
        }
        return e(uMImage.asBinImage());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(byte[] r4, android.graphics.Bitmap.CompressFormat r5) {
        /*
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = d(r4)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r2 = 0
            int r3 = r4.length     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeByteArray(r4, r2, r3, r1)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r1.<init>()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r4 == 0) goto L1d
            r2 = 100
            r4.compress(r5, r2, r1)     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3d
            r4.recycle()     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3d
            java.lang.System.gc()     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3d
        L1d:
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3d
            r1.close()     // Catch: java.io.IOException -> L25
            goto L3c
        L25:
            r4 = move-exception
            java.lang.String r5 = com.umeng.socialize.utils.UmengText.IMAGE.CLOSE
            com.umeng.socialize.utils.SLog.error(r5, r4)
            goto L3c
        L2c:
            r4 = move-exception
            goto L32
        L2e:
            r4 = move-exception
            goto L3f
        L30:
            r4 = move-exception
            r1 = r0
        L32:
            java.lang.String r5 = com.umeng.socialize.utils.UmengText.IMAGE.FILE_TO_BINARY_ERROR     // Catch: java.lang.Throwable -> L3d
            com.umeng.socialize.utils.SLog.error(r5, r4)     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.io.IOException -> L25
        L3c:
            return r0
        L3d:
            r4 = move-exception
            r0 = r1
        L3f:
            if (r0 == 0) goto L4b
            r0.close()     // Catch: java.io.IOException -> L45
            goto L4b
        L45:
            r5 = move-exception
            java.lang.String r0 = com.umeng.socialize.utils.UmengText.IMAGE.CLOSE
            com.umeng.socialize.utils.SLog.error(r0, r5)
        L4b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.c.a.a.a(byte[], android.graphics.Bitmap$CompressFormat):byte[]");
    }

    public static byte[] a(byte[] bArr, int i4, Bitmap.CompressFormat compressFormat) {
        if (bArr == null || bArr.length < i4) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z3 = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        int i5 = 1;
        while (!z3 && i5 <= 10) {
            int pow = (int) (Math.pow(0.8d, i5) * 100.0d);
            if (decodeByteArray != null) {
                decodeByteArray.compress(compressFormat, pow, byteArrayOutputStream);
            }
            if (byteArrayOutputStream.size() < i4) {
                z3 = true;
            } else {
                byteArrayOutputStream.reset();
                i5++;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!decodeByteArray.isRecycled()) {
            decodeByteArray.recycle();
        }
        if (byteArray != null && byteArray.length <= 0) {
            SLog.E(UmengText.IMAGE.THUMB_ERROR);
        }
        return byteArray;
    }

    private static int a(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file).available();
            } catch (Throwable th) {
                SLog.error(UmengText.IMAGE.GET_IMAGE_SCALE_ERROR, th);
                return 0;
            }
        }
        return 0;
    }
}
