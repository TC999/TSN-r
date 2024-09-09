package com.amap.api.col.p0003l;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ServiceUtils.java */
/* renamed from: com.amap.api.col.3l.w3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class w3 {

    /* renamed from: a  reason: collision with root package name */
    private static AssetManager f9340a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Resources f9341b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Resources f9342c = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f9343d = true;

    /* renamed from: e  reason: collision with root package name */
    private static Context f9344e = null;

    /* renamed from: f  reason: collision with root package name */
    private static String f9345f = "amap_resource";

    /* renamed from: g  reason: collision with root package name */
    private static String f9346g = "1_0_0";

    /* renamed from: i  reason: collision with root package name */
    private static String f9348i = ".jar";

    /* renamed from: j  reason: collision with root package name */
    private static String f9349j = f9345f + f9346g + f9348i;

    /* renamed from: h  reason: collision with root package name */
    private static String f9347h = ".png";

    /* renamed from: k  reason: collision with root package name */
    private static String f9350k = f9345f + f9346g + f9347h;

    /* renamed from: l  reason: collision with root package name */
    private static String f9351l = "";

    /* renamed from: m  reason: collision with root package name */
    private static String f9352m = f9351l + f9349j;

    /* renamed from: n  reason: collision with root package name */
    private static Resources.Theme f9353n = null;

    /* renamed from: o  reason: collision with root package name */
    private static Resources.Theme f9354o = null;

    /* renamed from: p  reason: collision with root package name */
    private static Field f9355p = null;

    /* renamed from: q  reason: collision with root package name */
    private static Field f9356q = null;

    /* renamed from: r  reason: collision with root package name */
    private static Activity f9357r = null;

    /* renamed from: s  reason: collision with root package name */
    public static int f9358s = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ServiceUtils.java */
    /* renamed from: com.amap.api.col.3l.w3$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(w3.f9346g);
            sb.append(w3.f9348i);
            return str.startsWith(w3.f9345f) && !str.endsWith(sb.toString());
        }
    }

    private static AssetManager a(String str) {
        Class<?> cls;
        AssetManager assetManager;
        AssetManager assetManager2 = null;
        try {
            cls = Class.forName("android.content.res.AssetManager");
            assetManager = (AssetManager) cls.getConstructor(null).newInstance(null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Throwable th2) {
            th = th2;
            assetManager2 = assetManager;
            u5.p(th, "ResourcesUtil", "getAssetManager(String apkPath)");
            return assetManager2;
        }
    }

    public static Resources b() {
        Resources resources = f9341b;
        return resources == null ? f9344e.getResources() : resources;
    }

    private static Resources c(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
    }

    public static View d(Context context, int i4) {
        XmlResourceParser xml = b().getXml(i4);
        View view = null;
        if (!f9343d) {
            return LayoutInflater.from(context).inflate(xml, (ViewGroup) null);
        }
        try {
            int i5 = f9358s;
            if (i5 == -1) {
                i5 = 0;
            }
            view = LayoutInflater.from(new v3(context, i5, w3.class.getClassLoader())).inflate(xml, (ViewGroup) null);
        } finally {
            try {
                return view;
            } finally {
            }
        }
        return view;
    }

    private static OutputStream e(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(f9351l, f9349j));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean f(Context context) {
        try {
            f9344e = context;
            File g4 = g(context);
            if (g4 != null) {
                f9351l = g4.getAbsolutePath() + TTPathConst.sSeparator;
            }
            f9352m = f9351l + f9349j;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (f9343d) {
            if (k(context)) {
                AssetManager a4 = a(f9352m);
                f9340a = a4;
                f9341b = c(context, a4);
                return true;
            }
            return false;
        }
        return true;
    }

    private static File g(Context context) {
        File filesDir;
        try {
            if (context == null) {
                if (context != null) {
                    context.getFilesDir();
                }
                return null;
            }
            try {
                if (Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().canWrite()) {
                    filesDir = context.getExternalFilesDir("LBS");
                } else {
                    filesDir = context.getFilesDir();
                }
                if (filesDir == null) {
                    context.getFilesDir();
                }
                return filesDir;
            } catch (Exception e4) {
                e4.printStackTrace();
                if (0 == 0) {
                    return context.getFilesDir();
                }
                return null;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                context.getFilesDir();
            }
            throw th;
        }
    }

    private static boolean i(InputStream inputStream) throws IOException {
        File file = new File(f9352m);
        long length = file.length();
        int available = inputStream.available();
        if (file.exists() && length == available) {
            inputStream.close();
            return true;
        }
        return false;
    }

    private static boolean k(Context context) {
        m(context);
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(f9350k);
            if (i(inputStream)) {
                return true;
            }
            n();
            OutputStream e4 = e(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                    u5.p(e5, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            }
            e4.close();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                u5.p(th, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return false;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        u5.p(e6, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                        return false;
                    }
                }
                return false;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        u5.p(e7, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
            }
        }
    }

    private static void m(Context context) {
        f9351l = context.getFilesDir().getAbsolutePath();
        f9352m = f9351l + TTPathConst.sSeparator + f9349j;
    }

    private static void n() {
        File[] listFiles = new File(f9351l).listFiles(new a());
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }
}
