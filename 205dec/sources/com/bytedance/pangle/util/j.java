package com.bytedance.pangle.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    static volatile ArrayList<String> f29009a;

    /* renamed from: b  reason: collision with root package name */
    private static String f29010b;

    public static List<String> a() {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e4) {
            ZeusLogger.errReport("Zeus/resources_pangle", "Execute 'AssetManager.class.newInstance()' failed. ", e4);
            assetManager = null;
        }
        return a(assetManager);
    }

    public static String b(AssetManager assetManager) {
        List<String> a4 = a(assetManager);
        StringBuilder sb = new StringBuilder("[");
        if (a4.size() > 0) {
            for (String str : a4) {
                sb.append(str);
                sb.append(" , ");
            }
            sb.delete(sb.lastIndexOf(" , "), sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    public static List<String> a(AssetManager assetManager) {
        ArrayList arrayList = new ArrayList();
        if (assetManager == null) {
            return arrayList;
        }
        try {
            if (i.j()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        arrayList.add((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                    }
                }
            } else {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                for (int i4 = 0; i4 < intValue; i4++) {
                    try {
                        String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i4 + 1));
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    } catch (IndexOutOfBoundsException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport("Zeus/resources_pangle", "ResUtils GetAssetsPaths error. ", th);
        }
        return arrayList;
    }

    public static synchronized List<String> b() {
        ArrayList<String> arrayList;
        synchronized (j.class) {
            if (f29009a == null) {
                synchronized (j.class) {
                    if (f29009a == null) {
                        f29009a = new ArrayList<>();
                        boolean z3 = false;
                        if (i.c()) {
                            try {
                                Resources resources = Zeus.getAppApplication().getResources();
                                f29009a.add(Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", "android")), 0).getApplicationInfo().sourceDir);
                            } catch (Exception e4) {
                                ZeusLogger.w("Zeus/load_pangle", "getWebViewPaths1 failed.", e4);
                            }
                        } else if (i.h()) {
                            try {
                                Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new Object[0]);
                                int i4 = Build.VERSION.SDK_INT;
                                if (i4 >= 29 || (i4 == 28 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                                    z3 = true;
                                }
                                if (z3) {
                                    Collections.addAll(f29009a, a(((Context) invokeStaticMethod).getApplicationInfo()));
                                } else {
                                    f29009a.add(((Context) invokeStaticMethod).getApplicationInfo().sourceDir);
                                }
                            } catch (Exception e5) {
                                ZeusLogger.w("Zeus/load_pangle", "getWebViewPaths2 failed.", e5);
                            }
                        }
                    }
                }
            }
            arrayList = f29009a;
        }
        return arrayList;
    }

    public static boolean a(AssetManager assetManager, String str) {
        try {
            if (i.j()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        if (TextUtils.equals((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]), str)) {
                            return true;
                        }
                    }
                }
            } else {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i4 = 0;
                while (i4 < intValue) {
                    i4++;
                    if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i4)), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport("Zeus/resources_pangle", "containsPath error. ", th);
        }
        return false;
    }

    @RequiresApi(api = 21)
    private static String[] a(ApplicationInfo applicationInfo) {
        String[] strArr;
        try {
            strArr = (String[]) com.bytedance.pangle.b.b.a.a(ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (Throwable th) {
            ZeusLogger.errReport("Zeus/load_pangle", "get resourceDirs failed.", th);
            strArr = new String[0];
        }
        String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
        ArrayList arrayList = new ArrayList(10);
        String str = applicationInfo.sourceDir;
        if (str != null) {
            arrayList.add(str);
        }
        for (int i4 = 0; i4 < 3; i4++) {
            String[] strArr3 = strArr2[i4];
            if (strArr3 != null) {
                arrayList.addAll(Arrays.asList(strArr3));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
