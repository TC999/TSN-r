package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.C6253i;
import com.bytedance.pangle.util.C6254j;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.pangle.res.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6199a {

    /* renamed from: a */
    private static Map<String, Integer> f22134a = new HashMap();

    /* renamed from: b */
    private LinkedHashMap<String, Integer> f22135b;

    static {
        List<String> m36876a = C6254j.m36876a();
        if (m36876a == null || m36876a.size() <= 0) {
            return;
        }
        for (String str : m36876a) {
            f22134a.put(str, 0);
        }
    }

    public C6199a() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.f22135b = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    /* renamed from: b */
    private static AssetManager m37010b(AssetManager assetManager, String str, boolean z) {
        int intValue;
        String str2 = "addAssetPath";
        String str3 = z ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        int i = Build.VERSION.SDK_INT;
        if ((i >= 30 || (i == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) && !z && str.startsWith("/product/overlay/")) {
            str3 = "addOverlayPath";
        }
        Method accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, str3, String.class);
        if (accessibleMethod == null && z) {
            accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", String.class);
            ZeusLogger.m37077w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
        } else {
            str2 = str3;
        }
        if (accessibleMethod != null) {
            int i2 = 3;
            while (true) {
                int i3 = i2 - 1;
                if (i2 < 0) {
                    break;
                }
                try {
                    intValue = ((Integer) accessibleMethod.invoke(assetManager, str)).intValue();
                } catch (Exception e) {
                    ZeusLogger.m37076w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z + ", methodName = " + str2, e);
                }
                if (intValue != 0) {
                    ZeusLogger.m37081i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + intValue + ", path = " + str);
                    break;
                }
                ZeusLogger.m37077w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + intValue + " " + str);
                i2 = i3;
            }
        } else {
            ZeusLogger.m37077w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + z + " methodName:" + str2);
        }
        return assetManager;
    }

    /* renamed from: c */
    private static AssetManager m37009c(AssetManager assetManager, String str, boolean z) {
        int i;
        int i2 = 3;
        Throwable th = null;
        int i3 = 3;
        while (true) {
            int i4 = i3 - 1;
            if (i3 < 0) {
                break;
            }
            try {
                synchronized (assetManager) {
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        i = 1;
                        if (i5 < i2) {
                            if (C6253i.m36885c()) {
                                i6 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                            } else {
                                int i7 = Build.VERSION.SDK_INT;
                                if (i7 >= 24 && i7 <= 25) {
                                    i6 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str, Boolean.valueOf(z)}, new Class[]{String.class, Boolean.TYPE})).intValue();
                                }
                            }
                            if (i6 != 0) {
                                break;
                            }
                            i5++;
                        } else {
                            break;
                        }
                    }
                    if (i6 == 0) {
                        ZeusLogger.m37077w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + i6 + " " + str);
                    } else {
                        Object readField = FieldUtils.readField(assetManager, "mStringBlocks");
                        int length = readField != null ? Array.getLength(readField) : 0;
                        int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                        Object newInstance = Array.newInstance(readField.getClass().getComponentType(), intValue);
                        int i8 = 0;
                        while (i8 < intValue) {
                            if (i8 < length) {
                                Array.set(newInstance, i8, Array.get(readField, i8));
                            } else {
                                Object[] objArr = new Object[i];
                                objArr[0] = Integer.valueOf(i8);
                                Class[] clsArr = new Class[i];
                                clsArr[0] = Integer.TYPE;
                                Array.set(newInstance, i8, MethodUtils.invokeConstructor(readField.getClass().getComponentType(), new Object[]{Long.valueOf(((Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", objArr, clsArr)).longValue()), Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));
                            }
                            i8++;
                            i = 1;
                        }
                        FieldUtils.writeField(assetManager, "mStringBlocks", newInstance);
                        ZeusLogger.m37083d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                i3 = i4;
                i2 = 3;
            }
        }
        if (th != null) {
            if (!TextUtils.equals(Build.BRAND.toLowerCase(), "samsung")) {
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            ZeusLogger.m37076w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
        }
        return assetManager;
    }

    /* renamed from: a */
    public final AssetManager m37011a(AssetManager assetManager, String str, boolean z) {
        AssetManager m37012a;
        if (str.endsWith(".frro")) {
            ZeusLogger.m37077w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(str));
            return assetManager;
        }
        if (C6253i.m36887a()) {
            if (C6253i.m36883e()) {
                m37012a = m37009c(assetManager, str, z);
                if (!C6254j.m36873a(m37012a, str)) {
                    m37012a = m37010b(assetManager, str, z);
                }
            } else {
                m37012a = m37010b(assetManager, str, z);
            }
        } else {
            m37012a = m37012a(assetManager, str);
        }
        synchronized (this.f22135b) {
            this.f22135b.put(str, 0);
        }
        return m37012a;
    }

    /* renamed from: a */
    private AssetManager m37012a(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        List<String> m36874a = C6254j.m36874a(assetManager);
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str2 : m36874a) {
            if (!f22134a.containsKey(str2) && !this.f22135b.containsKey(str2) && !str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        ZeusLogger.m37081i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets path = ".concat(String.valueOf(str)));
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            ZeusLogger.m37081i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = ".concat(String.valueOf(assetManager2)));
            synchronized (this.f22135b) {
                for (Map.Entry<String, Integer> entry : this.f22135b.entrySet()) {
                    if (!f22134a.containsKey(entry.getKey())) {
                        sb.append(entry.getKey());
                        m37010b(assetManager2, entry.getKey(), false);
                    }
                }
            }
            if (!sb.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                m37010b(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                ZeusLogger.m37077w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + f22134a.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb.append(str);
            m37010b(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    sb.append(str3);
                    m37010b(assetManager2, str3, false);
                }
            }
            if (C6253i.m36884d() && !sb.toString().toLowerCase().contains("webview")) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", FaceEnvironment.f8430OS)), 0).getApplicationInfo().sourceDir;
                    if (!TextUtils.isEmpty(str4)) {
                        m37010b(assetManager2, str4, false);
                    }
                } catch (Exception e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e);
                }
            }
            assetManager = assetManager2;
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e2);
            m37010b(assetManager, str, false);
        }
        try {
            MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new Object[0]);
            ZeusLogger.m37081i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");
        } catch (Exception e3) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e3);
        }
        return assetManager;
    }
}
