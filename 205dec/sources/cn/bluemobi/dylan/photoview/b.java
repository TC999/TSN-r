package cn.bluemobi.dylan.photoview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import com.bumptech.glide.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: DownLoadImageService.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f1876a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1877b;

    /* renamed from: c  reason: collision with root package name */
    private File f1878c;

    /* renamed from: d  reason: collision with root package name */
    private c f1879d;

    public b(Context context, String str, c cVar) {
        this.f1876a = str;
        this.f1877b = context;
        this.f1879d = cVar;
    }

    public static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        System.out.println("Drawable\u8f6cBitmap");
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
    public void b(Context context, Bitmap bitmap) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile(), "download");
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f1878c = new File(file, System.currentTimeMillis() + ".jpg");
        FileOutputStream fileOutputStream = 0;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        try {
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        try {
            try {
                FileOutputStream fileOutputStream4 = new FileOutputStream(this.f1878c);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream4);
                    fileOutputStream4.flush();
                    fileOutputStream4.close();
                } catch (FileNotFoundException e5) {
                    e = e5;
                    fileOutputStream2 = fileOutputStream4;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    fileOutputStream = Uri.fromFile(new File(this.f1878c.getPath()));
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", (Uri) fileOutputStream));
                } catch (IOException e6) {
                    e = e6;
                    fileOutputStream3 = fileOutputStream4;
                    e.printStackTrace();
                    if (fileOutputStream3 != null) {
                        fileOutputStream3.close();
                    }
                    fileOutputStream = Uri.fromFile(new File(this.f1878c.getPath()));
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", (Uri) fileOutputStream));
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream4;
                    if (fileOutputStream != 0) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e8) {
                e = e8;
            } catch (IOException e9) {
                e = e9;
            }
            fileOutputStream = Uri.fromFile(new File(this.f1878c.getPath()));
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", (Uri) fileOutputStream));
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        Bitmap bitmap = null;
        try {
            try {
                bitmap = a((Drawable) d.C(this.f1877b).a(this.f1876a).f1(Integer.MIN_VALUE, Integer.MIN_VALUE).get());
                if (bitmap != null) {
                    b(this.f1877b, bitmap);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                if (bitmap != null && this.f1878c.exists()) {
                    cVar2 = this.f1879d;
                    if (cVar2 == null) {
                        return;
                    }
                } else {
                    cVar = this.f1879d;
                    if (cVar == null) {
                        return;
                    }
                }
            }
            if (bitmap != null && this.f1878c.exists()) {
                cVar2 = this.f1879d;
                if (cVar2 == null) {
                    return;
                }
                cVar2.onSuccess();
                return;
            }
            cVar = this.f1879d;
            if (cVar == null) {
                return;
            }
            cVar.onFail();
        } catch (Throwable th) {
            if (bitmap != null && this.f1878c.exists()) {
                c cVar3 = this.f1879d;
                if (cVar3 != null) {
                    cVar3.onSuccess();
                }
            } else {
                c cVar4 = this.f1879d;
                if (cVar4 != null) {
                    cVar4.onFail();
                }
            }
            throw th;
        }
    }
}
