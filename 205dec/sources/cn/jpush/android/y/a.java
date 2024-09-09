package cn.jpush.android.y;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ad.l;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f4548d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, String> f4549e = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private String f4550a;

    /* renamed from: b  reason: collision with root package name */
    private Resources f4551b;

    /* renamed from: c  reason: collision with root package name */
    private ClassLoader f4552c;

    private static PackageInfo a(Context context, String str) {
        return context.getPackageManager().getPackageArchiveInfo(str, 1);
    }

    public static a a(Context context) {
        try {
            Object dyInfo = JCoreHelper.getDyInfo(context, 2);
            Logger.d("LoadedResource", "load resouce:" + dyInfo);
            if (dyInfo != null && (dyInfo instanceof Map)) {
                Map map = (Map) dyInfo;
                String str = (String) map.get("p");
                Logger.d("LoadedResource", "jpush dex path:" + str);
                if (!TextUtils.isEmpty(str)) {
                    return a(context, str, (String) map.get("o"), (String) map.get("l"), false);
                }
            }
        } catch (Throwable th) {
            Logger.ww("LoadedResource", "l r failed:" + th.getMessage());
        }
        Logger.d("LoadedResource", "load resource failed");
        return null;
    }

    private static a a(Context context, String str, String str2, String str3, boolean z3) {
        String a4 = a(context, str, z3);
        PackageInfo a5 = a(context, a4);
        if (a5 == null) {
            Logger.d("LoadedResource", "info is null");
            return null;
        }
        Logger.d("LoadedResource", "pkg name:" + a5.packageName);
        AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
        AssetManager.class.getMethod("addAssetPath", String.class).invoke(assetManager, a4);
        Resources resources = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
        a aVar = new a();
        aVar.a(resources);
        aVar.a(a5.packageName);
        aVar.a(new b(a4, str2, str3, context.getClassLoader()));
        a(context, str, a4, z3);
        Logger.d("LoadedResource", "build resource:" + a4 + ", o: " + str);
        return aVar;
    }

    private static String a(Context context, String str, boolean z3) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                if (!z3 && JConstants.SDK_VERSION_INT >= 440) {
                    m.a((Closeable) null);
                    m.a((Closeable) null);
                    return str;
                }
                String c4 = c(str);
                Map<String, String> map = f4549e;
                if (map.containsKey(c4)) {
                    Logger.d("LoadedResource", "use d f cache");
                    String str2 = map.get(c4);
                    m.a((Closeable) null);
                    m.a((Closeable) null);
                    return str2;
                }
                String c5 = c(cn.jpush.android.ad.a.c(context));
                if (TextUtils.isEmpty(c5)) {
                    Logger.w("LoadedResource", "process name to hash failed");
                    m.a((Closeable) null);
                    m.a((Closeable) null);
                    return str;
                }
                File file = new File(str);
                String c6 = c(c5 + file.getName());
                if (TextUtils.isEmpty(c6)) {
                    Logger.w("LoadedResource", "process + fileName to hash failed");
                    m.a((Closeable) null);
                    m.a((Closeable) null);
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(context.getCacheDir());
                String str3 = File.separator;
                sb.append(str3);
                sb.append(".p");
                File file2 = new File(sb.toString(), c5 + str3 + c6 + ".d");
                if (file2.exists()) {
                    file2.delete();
                }
                file2.getParentFile().mkdirs();
                file2.createNewFile();
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            file2.setReadOnly();
                            f4549e.put(c4, file2.getAbsolutePath());
                            Logger.d("LoadedResource", "fix d success, name: " + file2.getName());
                            String absolutePath = file2.getAbsolutePath();
                            m.a(fileOutputStream);
                            m.a((Closeable) fileInputStream2);
                            return absolutePath;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    Throwable th3 = th;
                    fileInputStream = fileInputStream2;
                    th = th3;
                    try {
                        Logger.w("LoadedResource", "fix d file failed, " + th.getMessage());
                        return str;
                    } finally {
                        m.a(fileOutputStream2);
                        m.a((Closeable) fileInputStream);
                    }
                }
            }
            m.a((Closeable) null);
            m.a((Closeable) null);
            return str;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i4 = 0; i4 < bArr.length; i4++) {
            char[] cArr = f4548d;
            sb.append(cArr[(bArr[i4] & 240) >>> 4]);
            sb.append(cArr[bArr[i4] & 15]);
        }
        return sb.toString();
    }

    private static void a(Context context, String str, String str2, boolean z3) {
        if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (z3 || JConstants.SDK_VERSION_INT < 440) {
            try {
                String c4 = c(str);
                Map<String, String> map = f4549e;
                if (!map.containsKey(c4) || TextUtils.equals(str, str2)) {
                    return;
                }
                map.remove(c4);
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                    Logger.d("LoadedResource", "d d file success:" + file.getAbsolutePath());
                }
            } catch (Throwable th) {
                Logger.w("LoadedResource", "d dex f failed, " + th.getMessage());
            }
        }
    }

    private static String c(String str) {
        if (str != null && !"".equals(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(l.f4021a);
                messageDigest.update(str.getBytes());
                return a(messageDigest.digest());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public int a(String str, String str2) {
        String str3 = this.f4550a + ".R$" + str;
        Logger.d("LoadedResource", "resource class:" + str3 + ",fieldName:" + str2);
        try {
            return ((Integer) this.f4552c.loadClass(str3).getField(str2).get(null)).intValue();
        } catch (Throwable th) {
            Logger.ww("LoadedResource", "[getResourceID] failed:" + th.getMessage());
            return 0;
        }
    }

    public void a(Resources resources) {
        this.f4551b = resources;
    }

    public void a(ClassLoader classLoader) {
        this.f4552c = classLoader;
    }

    public void a(String str) {
        this.f4550a = str;
    }

    public Class b(String str) {
        try {
            return this.f4552c.loadClass(str);
        } catch (ClassNotFoundException e4) {
            Logger.ww("LoadedResource", "[getClass] failed:" + e4.getMessage());
            return null;
        }
    }
}
