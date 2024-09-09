package top.zibin.luban;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: Engine.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private ExifInterface f64383a;

    /* renamed from: b  reason: collision with root package name */
    private File f64384b;

    /* renamed from: c  reason: collision with root package name */
    private File f64385c;

    /* renamed from: d  reason: collision with root package name */
    private int f64386d;

    /* renamed from: e  reason: collision with root package name */
    private int f64387e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(File file, File file2) throws IOException {
        if (c(file)) {
            this.f64383a = new ExifInterface(file.getAbsolutePath());
        }
        this.f64385c = file2;
        this.f64384b = file;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        this.f64386d = options.outWidth;
        this.f64387e = options.outHeight;
    }

    private int b() {
        int i4;
        int i5 = this.f64386d;
        if (i5 % 2 == 1) {
            i5++;
        }
        this.f64386d = i5;
        int i6 = this.f64387e;
        if (i6 % 2 == 1) {
            i6++;
        }
        this.f64387e = i6;
        if (i5 > i6) {
            i5 = i6;
        }
        this.f64386d = i5;
        if (i5 > i6) {
            i6 = i5;
        }
        this.f64387e = i6;
        double d4 = i5;
        double d5 = i6;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d6 = d4 / d5;
        if (d6 > 1.0d || d6 <= 0.5625d) {
            if (d6 <= 0.5625d && d6 > 0.5d) {
                if (i6 / 1280 == 0) {
                    return 1;
                }
                i4 = i6 / 1280;
            } else {
                double d7 = i6;
                Double.isNaN(d7);
                return (int) Math.ceil(d7 / (1280.0d / d6));
            }
        } else if (i6 < 1664) {
            return 1;
        } else {
            if (i6 >= 1664 && i6 < 4990) {
                return 2;
            }
            if (i6 >= 4990 && i6 < 10240) {
                return 4;
            }
            if (i6 / 1280 == 0) {
                return 1;
            }
            i4 = i6 / 1280;
        }
        return i4;
    }

    private boolean c(File file) {
        return file.getAbsolutePath().contains("jpeg") || file.getAbsolutePath().contains("jpg");
    }

    private Bitmap d(Bitmap bitmap) {
        if (this.f64383a == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        int i4 = 0;
        int attributeInt = this.f64383a.getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            i4 = 180;
        } else if (attributeInt == 6) {
            i4 = 90;
        } else if (attributeInt == 8) {
            i4 = 270;
        }
        matrix.postRotate(i4);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a() throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = b();
        Bitmap decodeFile = BitmapFactory.decodeFile(this.f64384b.getAbsolutePath(), options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap d4 = d(decodeFile);
        d4.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        d4.recycle();
        FileOutputStream fileOutputStream = new FileOutputStream(this.f64385c);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        return this.f64385c;
    }
}
