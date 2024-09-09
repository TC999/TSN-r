package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.widget.ImageView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class t {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f46604a;

        /* renamed from: b  reason: collision with root package name */
        private int f46605b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f46606c;

        public final int b() {
            return this.f46604a;
        }

        public final int a() {
            return this.f46605b;
        }
    }

    public static Bitmap a(File file, ImageView imageView, boolean z3) {
        if (z3 || c(file)) {
            d1.a("gdt_tag_avif", "file is avif");
            Bitmap a4 = a(file, imageView);
            if (a4 != null) {
                return a4;
            }
            if (Build.VERSION.SDK_INT < 31 || com.qq.e.comm.plugin.d0.a.d().f().a("ausl", 0) == 0) {
                return null;
            }
        }
        return a(file.getAbsolutePath(), imageView);
    }

    public static Bitmap b(File file, ImageView imageView) {
        return a(file, imageView, false);
    }

    public static boolean c(File file) {
        boolean z3 = false;
        if (file == null) {
            d1.a("image file is null");
            return false;
        } else if (!file.exists()) {
            d1.a(file.getAbsolutePath() + " not exist");
            return false;
        } else if (file.length() < 12) {
            d1.a(file.getAbsolutePath() + " size too short, len = " + file.length());
            return false;
        } else {
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[12];
                        int read = fileInputStream2.read(bArr);
                        if (read < 12) {
                            d1.a(file.getAbsolutePath() + " only read " + read + " bytes!");
                            try {
                                fileInputStream2.close();
                            } catch (Exception e4) {
                                d1.a(e4.getMessage(), e4);
                            }
                            return false;
                        }
                        if (bArr[4] == 102 && bArr[5] == 116 && bArr[6] == 121 && bArr[7] == 112 && ((bArr[8] == 97 || bArr[9] == 118) && bArr[10] == 105 && bArr[11] == 102)) {
                            z3 = true;
                        }
                        try {
                            fileInputStream2.close();
                        } catch (Exception e5) {
                            d1.a(e5.getMessage(), e5);
                        }
                        return z3;
                    } catch (Exception e6) {
                        e = e6;
                        fileInputStream = fileInputStream2;
                        d1.a(e.getMessage(), e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e7) {
                                d1.a(e7.getMessage(), e7);
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e8) {
                                d1.a(e8.getMessage(), e8);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e9) {
                e = e9;
            }
        }
    }

    public static boolean d(File file) {
        boolean z3 = false;
        if (file == null) {
            d1.a("image file is null");
            return false;
        } else if (!file.exists()) {
            d1.a(file.getAbsolutePath() + " not exist");
            return false;
        } else if (file.length() < 6) {
            d1.a(file.getAbsolutePath() + " size too short, len = " + file.length());
            return false;
        } else {
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[6];
                        int read = fileInputStream2.read(bArr);
                        if (read < 6) {
                            d1.a(file.getAbsolutePath() + " only read " + read + " bytes!");
                            try {
                                fileInputStream2.close();
                            } catch (Exception e4) {
                                d1.a(e4.getMessage(), e4);
                            }
                            return false;
                        }
                        if (bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && ((bArr[4] == 55 || bArr[4] == 57) && bArr[5] == 97)) {
                            z3 = true;
                        }
                        try {
                            fileInputStream2.close();
                        } catch (Exception e5) {
                            d1.a(e5.getMessage(), e5);
                        }
                        return z3;
                    } catch (Exception e6) {
                        e = e6;
                        fileInputStream = fileInputStream2;
                        d1.a(e.getMessage(), e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e7) {
                                d1.a(e7.getMessage(), e7);
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e8) {
                                d1.a(e8.getMessage(), e8);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e9) {
                    e = e9;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Movie b(java.io.File r10) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.t.b(java.io.File):android.graphics.Movie");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap a(java.io.File r11, android.widget.ImageView r12) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.t.a(java.io.File, android.widget.ImageView):android.graphics.Bitmap");
    }

    private static byte[] a(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static Bitmap a(String str, ImageView imageView) {
        long currentTimeMillis = System.currentTimeMillis();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        BitmapFactory.decodeFile(str, options);
        a a4 = a(imageView, options.outWidth, options.outHeight);
        options.inSampleSize = a(options, a4.f46604a, a4.f46605b);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (a4.f46606c) {
            decodeFile = a(decodeFile, a4.f46604a, a4.f46605b);
        }
        if (decodeFile != null && g.e().g()) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 1000) {
                currentTimeMillis2 = 1000;
            }
            com.qq.e.comm.plugin.n0.v.a(9130066, null, 2, Integer.valueOf((int) (currentTimeMillis2 / 10)), null);
        }
        return decodeFile;
    }

    private static int a(BitmapFactory.Options options, int i4, int i5) {
        return a(options.outWidth, options.outHeight, i4, i5);
    }

    private static int a(int i4, int i5, int i6, int i7) {
        if (i4 > i6 || i5 > i7) {
            return Math.max(Math.round((i4 * 1.0f) / i6), Math.round((i5 * 1.0f) / i7));
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.qq.e.comm.plugin.util.t.a a(android.widget.ImageView r7, int r8, int r9) {
        /*
            com.qq.e.comm.plugin.util.t$a r0 = new com.qq.e.comm.plugin.util.t$a
            r0.<init>()
            r1 = 0
            if (r7 == 0) goto L60
            int r2 = r7.getWidth()
            int r3 = r7.getHeight()
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            if (r7 == 0) goto L5e
            if (r2 > 0) goto L1d
            int r4 = r7.width
            if (r4 <= 0) goto L1d
            r2 = r4
        L1d:
            if (r3 > 0) goto L24
            int r4 = r7.height
            if (r4 <= 0) goto L24
            r3 = r4
        L24:
            if (r8 <= 0) goto L62
            if (r9 <= 0) goto L62
            r4 = 1
            r5 = -2
            if (r2 <= 0) goto L44
            int r6 = r7.width
            if (r6 == r5) goto L44
            int r6 = r7.height
            if (r6 != r5) goto L44
            int r9 = r9 * r2
            float r7 = (float) r9
            float r9 = (float) r8
            float r7 = r7 / r9
            int r3 = java.lang.Math.round(r7)
            if (r8 <= r2) goto L40
            r1 = 1
        L40:
            com.qq.e.comm.plugin.util.t.a.a(r0, r1)
            goto L62
        L44:
            if (r3 <= 0) goto L62
            int r6 = r7.height
            if (r6 == r5) goto L62
            int r7 = r7.width
            if (r7 != r5) goto L62
            int r8 = r8 * r3
            float r7 = (float) r8
            float r8 = (float) r9
            float r7 = r7 / r8
            int r2 = java.lang.Math.round(r7)
            if (r9 <= r3) goto L5a
            r1 = 1
        L5a:
            com.qq.e.comm.plugin.util.t.a.a(r0, r1)
            goto L62
        L5e:
            r1 = r2
            goto L61
        L60:
            r3 = 0
        L61:
            r2 = r1
        L62:
            com.qq.e.comm.plugin.d0.a r7 = com.qq.e.comm.plugin.d0.a.d()
            android.content.Context r7 = r7.a()
            if (r2 > 0) goto L70
            int r2 = com.qq.e.comm.plugin.util.f1.c(r7)
        L70:
            if (r3 > 0) goto L76
            int r3 = com.qq.e.comm.plugin.util.f1.a(r7)
        L76:
            com.qq.e.comm.plugin.util.t.a.a(r0, r2)
            com.qq.e.comm.plugin.util.t.a.b(r0, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.t.a(android.widget.ImageView, int, int):com.qq.e.comm.plugin.util.t$a");
    }

    private static Bitmap a(Bitmap bitmap, int i4, int i5) {
        if (bitmap == null || i4 == 0 || i5 == 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i4 && i5 == height) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(i4 / width, i5 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static com.qq.e.lib.a.b.a a(File file, String str) {
        if (file != null && file.exists() && com.qq.e.lib.a.b.b.d.a(file)) {
            return com.qq.e.lib.a.b.a.a(file, str);
        }
        return null;
    }

    public static Bitmap a(Context context, int i4) {
        if (i4 <= 0) {
            return null;
        }
        try {
            return BitmapFactory.decodeResource(context.getResources(), i4);
        } catch (Exception e4) {
            d1.a(e4.getMessage(), e4);
            return null;
        }
    }

    public static Bitmap a(byte[] bArr) {
        int length;
        if (bArr != null && (length = bArr.length) > 0) {
            try {
                return BitmapFactory.decodeByteArray(bArr, 0, length);
            } catch (Exception e4) {
                d1.a(e4.getMessage(), e4);
            }
        }
        return null;
    }

    public static byte[] a(Bitmap bitmap, boolean z3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        if (z3) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e4) {
            d1.a(e4.getMessage(), e4);
        }
        return byteArray;
    }
}
