package top.zibin.luban;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.baidu.idl.face.platform.utils.BitmapUtils;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Engine.java */
/* renamed from: top.zibin.luban.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C16202b {

    /* renamed from: a */
    private ExifInterface f47107a;

    /* renamed from: b */
    private File f47108b;

    /* renamed from: c */
    private File f47109c;

    /* renamed from: d */
    private int f47110d;

    /* renamed from: e */
    private int f47111e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C16202b(File file, File file2) throws IOException {
        if (m300c(file)) {
            this.f47107a = new ExifInterface(file.getAbsolutePath());
        }
        this.f47109c = file2;
        this.f47108b = file;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        this.f47110d = options.outWidth;
        this.f47111e = options.outHeight;
    }

    /* renamed from: b */
    private int m301b() {
        int i;
        int i2 = this.f47110d;
        if (i2 % 2 == 1) {
            i2++;
        }
        this.f47110d = i2;
        int i3 = this.f47111e;
        if (i3 % 2 == 1) {
            i3++;
        }
        this.f47111e = i3;
        if (i2 > i3) {
            i2 = i3;
        }
        this.f47110d = i2;
        if (i2 > i3) {
            i3 = i2;
        }
        this.f47111e = i3;
        double d = i2;
        double d2 = i3;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        if (d3 > 1.0d || d3 <= 0.5625d) {
            if (d3 <= 0.5625d && d3 > 0.5d) {
                if (i3 / PredefinedCaptureConfigurations.f24405o == 0) {
                    return 1;
                }
                i = i3 / PredefinedCaptureConfigurations.f24405o;
            } else {
                double d4 = i3;
                Double.isNaN(d4);
                return (int) Math.ceil(d4 / (1280.0d / d3));
            }
        } else if (i3 < 1664) {
            return 1;
        } else {
            if (i3 >= 1664 && i3 < 4990) {
                return 2;
            }
            if (i3 >= 4990 && i3 < 10240) {
                return 4;
            }
            if (i3 / PredefinedCaptureConfigurations.f24405o == 0) {
                return 1;
            }
            i = i3 / PredefinedCaptureConfigurations.f24405o;
        }
        return i;
    }

    /* renamed from: c */
    private boolean m300c(File file) {
        return file.getAbsolutePath().contains("jpeg") || file.getAbsolutePath().contains("jpg");
    }

    /* renamed from: d */
    private Bitmap m299d(Bitmap bitmap) {
        if (this.f47107a == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        int i = 0;
        int attributeInt = this.f47107a.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 3) {
            i = 180;
        } else if (attributeInt == 6) {
            i = 90;
        } else if (attributeInt == 8) {
            i = BitmapUtils.ROTATE270;
        }
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public File m302a() throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = m301b();
        Bitmap decodeFile = BitmapFactory.decodeFile(this.f47108b.getAbsolutePath(), options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap m299d = m299d(decodeFile);
        m299d.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        m299d.recycle();
        FileOutputStream fileOutputStream = new FileOutputStream(this.f47109c);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        return this.f47109c;
    }
}
