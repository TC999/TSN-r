package com.amap.api.col.p0463l;

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
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* renamed from: com.amap.api.col.3l.w3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ServiceUtils {

    /* renamed from: a */
    private static AssetManager f5602a = null;

    /* renamed from: b */
    private static Resources f5603b = null;

    /* renamed from: c */
    private static Resources f5604c = null;

    /* renamed from: d */
    private static boolean f5605d = true;

    /* renamed from: e */
    private static Context f5606e = null;

    /* renamed from: f */
    private static String f5607f = "amap_resource";

    /* renamed from: g */
    private static String f5608g = "1_0_0";

    /* renamed from: i */
    private static String f5610i = ".jar";

    /* renamed from: j */
    private static String f5611j = f5607f + f5608g + f5610i;

    /* renamed from: h */
    private static String f5609h = ".png";

    /* renamed from: k */
    private static String f5612k = f5607f + f5608g + f5609h;

    /* renamed from: l */
    private static String f5613l = "";

    /* renamed from: m */
    private static String f5614m = f5613l + f5611j;

    /* renamed from: n */
    private static Resources.Theme f5615n = null;

    /* renamed from: o */
    private static Resources.Theme f5616o = null;

    /* renamed from: p */
    private static Field f5617p = null;

    /* renamed from: q */
    private static Field f5618q = null;

    /* renamed from: r */
    private static Activity f5619r = null;

    /* renamed from: s */
    public static int f5620s = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServiceUtils.java */
    /* renamed from: com.amap.api.col.3l.w3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1980a implements FilenameFilter {
        C1980a() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(ServiceUtils.f5608g);
            sb.append(ServiceUtils.f5610i);
            return str.startsWith(ServiceUtils.f5607f) && !str.endsWith(sb.toString());
        }
    }

    /* renamed from: a */
    private static AssetManager m53600a(String str) {
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
            SDKLogHandler.m53863p(th, "ResourcesUtil", "getAssetManager(String apkPath)");
            return assetManager2;
        }
    }

    /* renamed from: b */
    public static Resources m53599b() {
        Resources resources = f5603b;
        return resources == null ? f5606e.getResources() : resources;
    }

    /* renamed from: c */
    private static Resources m53598c(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
    }

    /* renamed from: d */
    public static View m53597d(Context context, int i) {
        XmlResourceParser xml = m53599b().getXml(i);
        View view = null;
        if (!f5605d) {
            return LayoutInflater.from(context).inflate(xml, (ViewGroup) null);
        }
        try {
            int i2 = f5620s;
            if (i2 == -1) {
                i2 = 0;
            }
            view = LayoutInflater.from(new PluginContext(context, i2, ServiceUtils.class.getClassLoader())).inflate(xml, (ViewGroup) null);
        } finally {
            try {
                return view;
            } finally {
            }
        }
        return view;
    }

    /* renamed from: e */
    private static OutputStream m53596e(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(f5613l, f5611j));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: f */
    public static boolean m53595f(Context context) {
        try {
            f5606e = context;
            File m53594g = m53594g(context);
            if (m53594g != null) {
                f5613l = m53594g.getAbsolutePath() + "/";
            }
            f5614m = f5613l + f5611j;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (f5605d) {
            if (m53590k(context)) {
                AssetManager m53600a = m53600a(f5614m);
                f5602a = m53600a;
                f5603b = m53598c(context, m53600a);
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: g */
    private static File m53594g(Context context) {
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
            } catch (Exception e) {
                e.printStackTrace();
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

    /* renamed from: i */
    private static boolean m53592i(InputStream inputStream) throws IOException {
        File file = new File(f5614m);
        long length = file.length();
        int available = inputStream.available();
        if (file.exists() && length == available) {
            inputStream.close();
            return true;
        }
        return false;
    }

    /* renamed from: k */
    private static boolean m53590k(Context context) {
        m53588m(context);
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(f5612k);
            if (m53592i(inputStream)) {
                return true;
            }
            m53587n();
            OutputStream m53596e = m53596e(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    SDKLogHandler.m53863p(e, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            }
            m53596e.close();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                SDKLogHandler.m53863p(th, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return false;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        SDKLogHandler.m53863p(e2, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                        return false;
                    }
                }
                return false;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        SDKLogHandler.m53863p(e3, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
            }
        }
    }

    /* renamed from: m */
    private static void m53588m(Context context) {
        f5613l = context.getFilesDir().getAbsolutePath();
        f5614m = f5613l + "/" + f5611j;
    }

    /* renamed from: n */
    private static void m53587n() {
        File[] listFiles = new File(f5613l).listFiles(new C1980a());
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }
}
