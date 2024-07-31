package com.umeng.socialize.p571c.p572a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.p571c.p573b.C13339b;
import com.umeng.socialize.p571c.p573b.ImageConstants;
import com.umeng.socialize.p571c.p573b.ImageFormat;
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

/* renamed from: com.umeng.socialize.c.a.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ImageImpl {
    /* renamed from: a */
    public static byte[] m13313a(UMImage uMImage, int i) {
        if (uMImage == null) {
            return DefaultClass.getBytes();
        }
        if (uMImage.asBinImage() != null && m13314a(uMImage) >= i) {
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
                    while (byteArrayOutputStream.toByteArray().length > i) {
                        double length = asBinImage.length;
                        Double.isNaN(length);
                        double d = i;
                        Double.isNaN(d);
                        double sqrt = Math.sqrt((length * 1.0d) / d);
                        double width = decodeByteArray.getWidth();
                        Double.isNaN(width);
                        int i2 = (int) (width / sqrt);
                        double height = decodeByteArray.getHeight();
                        Double.isNaN(height);
                        decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i2, (int) (height / sqrt), true);
                        byteArrayOutputStream.reset();
                        if (decodeByteArray != null) {
                            decodeByteArray.compress(uMImage.compressFormat, 100, byteArrayOutputStream);
                            asBinImage = byteArrayOutputStream.toByteArray();
                        }
                    }
                    if (byteArrayOutputStream.toByteArray().length > i) {
                        return null;
                    }
                    return asBinImage;
                } catch (Throwable th) {
                    SLog.error(th);
                    return DefaultClass.getBytes();
                }
            }
            return m13308a(uMImage.asBinImage(), i, uMImage.compressFormat);
        }
        return uMImage.asBinImage();
    }

    /* renamed from: b */
    private static byte[] m13305b(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            float rowBytes = (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
                            float f = ImageConstants.f39405b;
                            bitmap.compress(compressFormat, rowBytes > f ? (int) ((f / rowBytes) * 100) : 100, byteArrayOutputStream2);
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e) {
                                SLog.error(UmengText.IMAGE.CLOSE, e);
                            }
                            return byteArray;
                        } catch (Exception e2) {
                            e = e2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            SLog.error(UmengText.IMAGE.BITMAOTOBINARY, e);
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e3) {
                                    SLog.error(UmengText.IMAGE.CLOSE, e3);
                                }
                            }
                            return DefaultClass.getBytes();
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e4) {
                                    SLog.error(UmengText.IMAGE.CLOSE, e4);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static String m13302c(byte[] bArr) {
        return ImageFormat.m13291a(bArr);
    }

    /* renamed from: d */
    private static BitmapFactory.Options m13301d(byte[] bArr) {
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

    /* renamed from: e */
    private static int m13300e(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    /* renamed from: b */
    public static File m13303b(byte[] bArr) {
        try {
            return m13306a(bArr, C13339b.m13296a().m13294b());
        } catch (IOException e) {
            SLog.error(UmengText.IMAGE.BINARYTOFILE, e);
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m13304b(File file, Bitmap.CompressFormat compressFormat) {
        if (file != null && file.getAbsoluteFile().exists()) {
            byte[] m13295a = C13339b.m13296a().m13295a(file);
            if (SocializeUtils.assertBinaryInvalid(m13295a)) {
                return ImageFormat.f39418m[1].equals(ImageFormat.m13291a(m13295a)) ? m13295a : m13307a(m13295a, compressFormat);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static byte[] m13310a(String str) {
        return SocializeNetUtils.getNetData(str);
    }

    /* renamed from: a */
    public static Bitmap m13309a(byte[] bArr) {
        if (bArr != null) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    /* renamed from: a */
    private static File m13306a(byte[] bArr, File file) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
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
                            } catch (IOException e2) {
                                SLog.error(UmengText.IMAGE.CLOSE, e2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            SLog.error(UmengText.IMAGE.CLOSE, e4);
        }
        return file;
    }

    /* renamed from: a */
    public static byte[] m13316a(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return m13305b(bitmap, compressFormat);
    }

    /* renamed from: a */
    private static Bitmap m13315a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public static byte[] m13317a(Context context, int i, boolean z, Bitmap.CompressFormat compressFormat) {
        Drawable drawable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!z) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT >= 21) {
                drawable = resources.getDrawable(i, null);
            } else {
                drawable = resources.getDrawable(i);
            }
            Bitmap m13315a = m13315a(drawable);
            if (m13315a != null) {
                m13315a.compress(compressFormat, 100, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        }
        byte[] bArr = new byte[0];
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap decodeStream = BitmapFactory.decodeStream(context.getResources().openRawResource(i), null, options);
            if (decodeStream != null) {
                decodeStream.compress(compressFormat, 100, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Error e) {
            SLog.error(UmengText.IMAGE.TOOBIG, e);
            return bArr;
        }
    }

    /* renamed from: a */
    public static byte[] m13311a(File file, Bitmap.CompressFormat compressFormat) {
        return m13304b(file, compressFormat);
    }

    /* renamed from: a */
    public static int m13314a(UMImage uMImage) {
        if (uMImage.getImageStyle() == UMImage.FILE_IMAGE) {
            return m13312a(uMImage.asFileImage());
        }
        return m13300e(uMImage.asBinImage());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] m13307a(byte[] r4, android.graphics.Bitmap.CompressFormat r5) {
        /*
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = m13301d(r4)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
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
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.p571c.p572a.ImageImpl.m13307a(byte[], android.graphics.Bitmap$CompressFormat):byte[]");
    }

    /* renamed from: a */
    public static byte[] m13308a(byte[] bArr, int i, Bitmap.CompressFormat compressFormat) {
        if (bArr == null || bArr.length < i) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        int i2 = 1;
        while (!z && i2 <= 10) {
            int pow = (int) (Math.pow(0.8d, i2) * 100.0d);
            if (decodeByteArray != null) {
                decodeByteArray.compress(compressFormat, pow, byteArrayOutputStream);
            }
            if (byteArrayOutputStream.size() < i) {
                z = true;
            } else {
                byteArrayOutputStream.reset();
                i2++;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!decodeByteArray.isRecycled()) {
            decodeByteArray.recycle();
        }
        if (byteArray != null && byteArray.length <= 0) {
            SLog.m13211E(UmengText.IMAGE.THUMB_ERROR);
        }
        return byteArray;
    }

    /* renamed from: a */
    private static int m13312a(File file) {
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
