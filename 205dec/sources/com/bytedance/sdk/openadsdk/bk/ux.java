package com.bytedance.sdk.openadsdk.bk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: a  reason: collision with root package name */
    public static int f31622a = 32;

    /* renamed from: c  reason: collision with root package name */
    protected static String f31623c = "images";
    public static int ev = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f31624f = 0;
    public static int gd = 4;

    /* renamed from: k  reason: collision with root package name */
    public static int f31625k = 16;

    /* renamed from: p  reason: collision with root package name */
    public static int f31626p = 8;

    /* renamed from: r  reason: collision with root package name */
    public static int f31627r = 1;
    protected static int sr = 30;
    protected static long ux = 15360;

    /* renamed from: w  reason: collision with root package name */
    protected static String f31628w = null;
    protected static int xv = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean c(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Bitmap w(String str) {
        byte[] decode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    @RequiresApi(api = 23)
    public static boolean w(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static File c() {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory, Environment.DIRECTORY_DCIM + File.separator + f31623c);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "JPG_Playable_Photo.jpg");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            f31628w = file2.getAbsolutePath();
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    protected static File c(String str) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + "Camera");
            if (!file.exists()) {
                file.mkdirs();
            }
            Calendar calendar = Calendar.getInstance();
            File file2 = new File(file, (calendar.get(12) + "_" + calendar.get(13) + "_" + calendar.get(14)) + "_" + str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static File c(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File c4 = c(str);
            if (c4 != null && c4.exists()) {
                byte[] decode = Base64.decode(str2, 2);
                fileOutputStream = new FileOutputStream(c4);
                try {
                    fileOutputStream.write(decode, 0, decode.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return c4;
                } catch (IOException unused) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (IOException unused2) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(Context context, int i4) {
        boolean c4;
        boolean c5;
        if (f31624f == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                c4 = c(context, "android.permission.READ_MEDIA_IMAGES");
                c5 = true;
            } else {
                c4 = c(context, "android.permission.READ_EXTERNAL_STORAGE");
                c5 = c(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            boolean c6 = c(context, "android.permission.CAMERA");
            boolean c7 = c(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (c4 && c5) {
                f31624f |= f31627r;
            }
            if (c6 && packageManager.hasSystemFeature("android.hardware.camera")) {
                f31624f |= ev;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                f31624f |= gd;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                f31624f |= f31626p;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                f31624f |= f31625k;
            }
            if (c7 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                f31624f |= f31622a;
            }
        }
        return (f31624f & i4) != 0;
    }

    @RequiresApi(api = 23)
    public static boolean c(Context context) {
        boolean z3;
        boolean z4;
        if (Build.VERSION.SDK_INT >= 33) {
            z3 = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
        } else {
            z3 = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z4 = false;
                return z4 && z3;
            }
        }
        z4 = true;
        if (z4) {
            return false;
        }
    }
}
