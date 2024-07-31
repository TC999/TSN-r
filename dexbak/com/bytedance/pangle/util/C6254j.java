package com.bytedance.pangle.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p115b.p117b.C6068a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bytedance.pangle.util.j */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6254j {

    /* renamed from: a */
    static volatile ArrayList<String> f22239a;

    /* renamed from: b */
    private static String f22240b;

    /* renamed from: a */
    public static List<String> m36876a() {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e);
            assetManager = null;
        }
        return m36874a(assetManager);
    }

    /* renamed from: b */
    public static String m36871b(AssetManager assetManager) {
        List<String> m36874a = m36874a(assetManager);
        StringBuilder sb = new StringBuilder("[");
        if (m36874a.size() > 0) {
            for (String str : m36874a) {
                sb.append(str);
                sb.append(" , ");
            }
            sb.delete(sb.lastIndexOf(" , "), sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    public static List<String> m36874a(AssetManager assetManager) {
        ArrayList arrayList = new ArrayList();
        if (assetManager == null) {
            return arrayList;
        }
        try {
            if (C6253i.m36878j()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        arrayList.add((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                    }
                }
            } else {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                for (int i = 0; i < intValue; i++) {
                    try {
                        String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i + 1));
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    } catch (IndexOutOfBoundsException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "ResUtils GetAssetsPaths error. ", th);
        }
        return arrayList;
    }

    /* renamed from: b */
    public static synchronized List<String> m36872b() {
        ArrayList<String> arrayList;
        synchronized (C6254j.class) {
            if (f22239a == null) {
                synchronized (C6254j.class) {
                    if (f22239a == null) {
                        f22239a = new ArrayList<>();
                        boolean z = false;
                        if (C6253i.m36885c()) {
                            try {
                                Resources resources = Zeus.getAppApplication().getResources();
                                f22239a.add(Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", FaceEnvironment.f8430OS)), 0).getApplicationInfo().sourceDir);
                            } catch (Exception e) {
                                ZeusLogger.m37076w(ZeusLogger.TAG_LOAD, "getWebViewPaths1 failed.", e);
                            }
                        } else if (C6253i.m36880h()) {
                            try {
                                Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new Object[0]);
                                int i = Build.VERSION.SDK_INT;
                                if (i >= 29 || (i == 28 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                                    z = true;
                                }
                                if (z) {
                                    Collections.addAll(f22239a, m36875a(((Context) invokeStaticMethod).getApplicationInfo()));
                                } else {
                                    f22239a.add(((Context) invokeStaticMethod).getApplicationInfo().sourceDir);
                                }
                            } catch (Exception e2) {
                                ZeusLogger.m37076w(ZeusLogger.TAG_LOAD, "getWebViewPaths2 failed.", e2);
                            }
                        }
                    }
                }
            }
            arrayList = f22239a;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m36873a(AssetManager assetManager, String str) {
        try {
            if (C6253i.m36878j()) {
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
                int i = 0;
                while (i < intValue) {
                    i++;
                    if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i)), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
        }
        return false;
    }

    @RequiresApi(api = 21)
    /* renamed from: a */
    private static String[] m36875a(ApplicationInfo applicationInfo) {
        String[] strArr;
        try {
            strArr = (String[]) C6068a.m37259a(ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
            strArr = new String[0];
        }
        String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
        ArrayList arrayList = new ArrayList(10);
        String str = applicationInfo.sourceDir;
        if (str != null) {
            arrayList.add(str);
        }
        for (int i = 0; i < 3; i++) {
            String[] strArr3 = strArr2[i];
            if (strArr3 != null) {
                arrayList.addAll(Arrays.asList(strArr3));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
