package cn.bluemobi.dylan.photoview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import com.bumptech.glide.Glide;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: cn.bluemobi.dylan.photoview.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DownLoadImageService implements Runnable {

    /* renamed from: a */
    private String f1891a;

    /* renamed from: b */
    private Context f1892b;

    /* renamed from: c */
    private File f1893c;

    /* renamed from: d */
    private ImageCallBack f1894d;

    public DownLoadImageService(Context context, String str, ImageCallBack imageCallBack) {
        this.f1891a = str;
        this.f1892b = context;
        this.f1894d = imageCallBack;
    }

    /* renamed from: a */
    public static Bitmap m57561a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        System.out.println("Drawable转Bitmap");
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.graphics.Bitmap] */
    /* renamed from: b */
    public void m57560b(Context context, Bitmap bitmap) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile(), "download");
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f1893c = new File(file, System.currentTimeMillis() + ".jpg");
        FileOutputStream fileOutputStream = 0;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                FileOutputStream fileOutputStream4 = new FileOutputStream(this.f1893c);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream4);
                    fileOutputStream4.flush();
                    fileOutputStream4.close();
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream4;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    fileOutputStream = Uri.fromFile(new File(this.f1893c.getPath()));
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", (Uri) fileOutputStream));
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream3 = fileOutputStream4;
                    e.printStackTrace();
                    if (fileOutputStream3 != null) {
                        fileOutputStream3.close();
                    }
                    fileOutputStream = Uri.fromFile(new File(this.f1893c.getPath()));
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", (Uri) fileOutputStream));
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream4;
                    if (fileOutputStream != 0) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
            } catch (IOException e6) {
                e = e6;
            }
            fileOutputStream = Uri.fromFile(new File(this.f1893c.getPath()));
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", (Uri) fileOutputStream));
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageCallBack imageCallBack;
        ImageCallBack imageCallBack2;
        Bitmap bitmap = null;
        try {
            try {
                bitmap = m57561a(Glide.m45751C(this.f1892b).mo45507a(this.f1891a).m45555e1(Integer.MIN_VALUE, Integer.MIN_VALUE).get());
                if (bitmap != null) {
                    m57560b(this.f1892b, bitmap);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (bitmap != null && this.f1893c.exists()) {
                    imageCallBack2 = this.f1894d;
                    if (imageCallBack2 == null) {
                        return;
                    }
                } else {
                    imageCallBack = this.f1894d;
                    if (imageCallBack == null) {
                        return;
                    }
                }
            }
            if (bitmap != null && this.f1893c.exists()) {
                imageCallBack2 = this.f1894d;
                if (imageCallBack2 == null) {
                    return;
                }
                imageCallBack2.onSuccess();
                return;
            }
            imageCallBack = this.f1894d;
            if (imageCallBack == null) {
                return;
            }
            imageCallBack.onFail();
        } catch (Throwable th) {
            if (bitmap != null && this.f1893c.exists()) {
                ImageCallBack imageCallBack3 = this.f1894d;
                if (imageCallBack3 != null) {
                    imageCallBack3.onSuccess();
                }
            } else {
                ImageCallBack imageCallBack4 = this.f1894d;
                if (imageCallBack4 != null) {
                    imageCallBack4.onFail();
                }
            }
            throw th;
        }
    }
}
