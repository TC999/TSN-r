package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.j;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Integer> f28895a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private LinkedHashMap<String, Integer> f28896b;

    static {
        List<String> a4 = j.a();
        if (a4 == null || a4.size() <= 0) {
            return;
        }
        for (String str : a4) {
            f28895a.put(str, 0);
        }
    }

    public a() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.f28896b = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    private static AssetManager b(AssetManager assetManager, String str, boolean z3) {
        int intValue;
        String str2 = "addAssetPath";
        String str3 = z3 ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        int i4 = Build.VERSION.SDK_INT;
        if ((i4 >= 30 || (i4 == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) && !z3 && str.startsWith("/product/overlay/")) {
            str3 = "addOverlayPath";
        }
        Method accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, str3, String.class);
        if (accessibleMethod == null && z3) {
            accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", String.class);
            ZeusLogger.w("Zeus/load_pangle", "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
        } else {
            str2 = str3;
        }
        if (accessibleMethod != null) {
            int i5 = 3;
            while (true) {
                int i6 = i5 - 1;
                if (i5 < 0) {
                    break;
                }
                try {
                    intValue = ((Integer) accessibleMethod.invoke(assetManager, str)).intValue();
                } catch (Exception e4) {
                    ZeusLogger.w("Zeus/load_pangle", "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z3 + ", methodName = " + str2, e4);
                }
                if (intValue != 0) {
                    ZeusLogger.i("Zeus/load_pangle", "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + intValue + ", path = " + str);
                    break;
                }
                ZeusLogger.w("Zeus/load_pangle", "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + intValue + " " + str);
                i5 = i6;
            }
        } else {
            ZeusLogger.w("Zeus/load_pangle", "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + z3 + " methodName:" + str2);
        }
        return assetManager;
    }

    private static AssetManager c(AssetManager assetManager, String str, boolean z3) {
        int i4;
        int i5 = 3;
        Throwable th = null;
        int i6 = 3;
        while (true) {
            int i7 = i6 - 1;
            if (i6 < 0) {
                break;
            }
            try {
                synchronized (assetManager) {
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        i4 = 1;
                        if (i8 < i5) {
                            if (i.c()) {
                                i9 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                            } else {
                                int i10 = Build.VERSION.SDK_INT;
                                if (i10 >= 24 && i10 <= 25) {
                                    i9 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str, Boolean.valueOf(z3)}, new Class[]{String.class, Boolean.TYPE})).intValue();
                                }
                            }
                            if (i9 != 0) {
                                break;
                            }
                            i8++;
                        } else {
                            break;
                        }
                    }
                    if (i9 == 0) {
                        ZeusLogger.w("Zeus/load_pangle", "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + i9 + " " + str);
                    } else {
                        Object readField = FieldUtils.readField(assetManager, "mStringBlocks");
                        int length = readField != null ? Array.getLength(readField) : 0;
                        int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                        Object newInstance = Array.newInstance(readField.getClass().getComponentType(), intValue);
                        int i11 = 0;
                        while (i11 < intValue) {
                            if (i11 < length) {
                                Array.set(newInstance, i11, Array.get(readField, i11));
                            } else {
                                Object[] objArr = new Object[i4];
                                objArr[0] = Integer.valueOf(i11);
                                Class[] clsArr = new Class[i4];
                                clsArr[0] = Integer.TYPE;
                                Array.set(newInstance, i11, MethodUtils.invokeConstructor(readField.getClass().getComponentType(), new Object[]{Long.valueOf(((Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", objArr, clsArr)).longValue()), Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));
                            }
                            i11++;
                            i4 = 1;
                        }
                        FieldUtils.writeField(assetManager, "mStringBlocks", newInstance);
                        ZeusLogger.d("Zeus/load_pangle", "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                i6 = i7;
                i5 = 3;
            }
        }
        if (th != null) {
            if (!TextUtils.equals(Build.BRAND.toLowerCase(), "samsung")) {
                ZeusLogger.errReport("Zeus/load_pangle", "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            ZeusLogger.w("Zeus/load_pangle", "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
        }
        return assetManager;
    }

    public final AssetManager a(AssetManager assetManager, String str, boolean z3) {
        AssetManager a4;
        if (str.endsWith(".frro")) {
            ZeusLogger.w("Zeus/load_pangle", "AssetManagerProcessor updateAssetManager skip frro. ".concat(str));
            return assetManager;
        }
        if (i.a()) {
            if (i.e()) {
                a4 = c(assetManager, str, z3);
                if (!j.a(a4, str)) {
                    a4 = b(assetManager, str, z3);
                }
            } else {
                a4 = b(assetManager, str, z3);
            }
        } else {
            a4 = a(assetManager, str);
        }
        synchronized (this.f28896b) {
            this.f28896b.put(str, 0);
        }
        return a4;
    }

    private AssetManager a(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        List<String> a4 = j.a(assetManager);
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str2 : a4) {
            if (!f28895a.containsKey(str2) && !this.f28896b.containsKey(str2) && !str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        ZeusLogger.i("Zeus/load_pangle", "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets path = ".concat(String.valueOf(str)));
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            ZeusLogger.i("Zeus/load_pangle", "AssetManagerProcessor newAssetManager = ".concat(String.valueOf(assetManager2)));
            synchronized (this.f28896b) {
                for (Map.Entry<String, Integer> entry : this.f28896b.entrySet()) {
                    if (!f28895a.containsKey(entry.getKey())) {
                        sb.append(entry.getKey());
                        b(assetManager2, entry.getKey(), false);
                    }
                }
            }
            if (!sb.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                b(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                ZeusLogger.w("Zeus/load_pangle", "AssetManagerProcessor newAssetManager lost host path : " + f28895a.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb.append(str);
            b(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    sb.append(str3);
                    b(assetManager2, str3, false);
                }
            }
            if (i.d() && !sb.toString().toLowerCase().contains("webview")) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", "android")), 0).getApplicationInfo().sourceDir;
                    if (!TextUtils.isEmpty(str4)) {
                        b(assetManager2, str4, false);
                    }
                } catch (Exception e4) {
                    ZeusLogger.errReport("Zeus/load_pangle", "AssetManagerProcessor newAssetManager appendAsset webview failed.", e4);
                }
            }
            assetManager = assetManager2;
        } catch (Exception e5) {
            ZeusLogger.errReport("Zeus/load_pangle", "AssetManagerProcessor newAssetManager failed.", e5);
            b(assetManager, str, false);
        }
        try {
            MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new Object[0]);
            ZeusLogger.i("Zeus/load_pangle", "AssetManagerProcessor ensureStringBlocks");
        } catch (Exception e6) {
            ZeusLogger.errReport("Zeus/load_pangle", "AssetManagerProcessor ensureStringBlocks failed.", e6);
        }
        return assetManager;
    }
}
