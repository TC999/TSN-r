package com.bytedance.pangle.transform;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Keep;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.FileProvider;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.activity.GenerateProxyActivity;
import com.bytedance.pangle.activity.GenerateProxyAppCompatActivity;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.pangle.service.PluginIntentService;
import com.bytedance.pangle.service.PluginService;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper;
import com.stub.StubApp;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ZeusTransformUtils {
    private static final String TAG = "PluginContextUtils";
    public static Class fragmentClazz;
    private static boolean sCanThrowException;
    private static boolean sSupportFragmentWrapper;
    static HashMap<String, WeakReference<Context>> contextCache = new HashMap<>();
    static boolean hasEnsure = false;
    static HashMap<String, Constructor<View>> sConstructorMap = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Activity _getActivity(Object obj, String str) {
        try {
            Activity activity = (Activity) MethodUtils.invokeMethod(obj, "getActivity", new Object[0]);
            Activity activity2 = (Activity) wrapperContext(activity, str);
            if (activity2 instanceof GenerateProxyActivity) {
                return ((GenerateProxyActivity) activity2).mTargetActivity;
            }
            if (!isSupportLibIso(str) && (activity2 instanceof GenerateProxyAppCompatActivity)) {
                return ((GenerateProxyAppCompatActivity) activity2).mTargetActivity;
            }
            return (Activity) wrapperContext(activity, str);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return null;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static boolean bindService(Object obj, Intent intent, ServiceConnection serviceConnection, int i4, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().bindServiceNative((Context) obj, intent, serviceConnection, i4, str);
        }
        try {
            return ((Boolean) MethodUtils.invokeMethod(obj, "bindService", new Object[]{intent, serviceConnection, Integer.valueOf(i4)}, new Class[]{Intent.class, ServiceConnection.class, Integer.TYPE})).booleanValue();
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static void canThrowException(boolean z3) {
        sCanThrowException = z3;
    }

    public static void clearConstructorCache() {
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                if (sConstructorMap == null) {
                    sConstructorMap = (HashMap) FieldUtils.readStaticField(LayoutInflater.class, "sConstructorMap");
                }
                for (String str : new HashSet(sConstructorMap.keySet())) {
                    if (!str.startsWith("android.view.") && !str.startsWith("android.widget.") && !str.startsWith("android.webkit.") && str.contains(".")) {
                        sConstructorMap.remove(str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static Context convertProxy2PluginActivity(Context context) {
        try {
            if ((context instanceof GenerateProxyActivity) || (context instanceof GenerateProxyAppCompatActivity)) {
                return (Activity) FieldUtils.readField(context, "mTargetActivity");
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/load_pangle", "convertProxy2PluginActivity failed.", th);
        }
        return context;
    }

    private static void ensureFragmentActivity() {
        if (hasEnsure) {
            return;
        }
        try {
            try {
                fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
        }
        hasEnsure = true;
    }

    private static boolean equalsFragmentActivity(Class cls) {
        ensureFragmentActivity();
        Class cls2 = fragmentClazz;
        return cls2 != null && cls == cls2;
    }

    public static Class forName(String str, String str2) {
        return Zeus.getPlugin(str2).mClassLoader.loadClass(str);
    }

    public static Activity getActivity(Object obj, String str) {
        return _getActivity(obj, str);
    }

    public static String getAssetPaths(AssetManager assetManager) {
        int i4;
        StringBuilder sb = new StringBuilder();
        if (assetManager == null) {
            return "";
        }
        try {
            i4 = Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            ZeusLogger.errReport("Zeus/resources_pangle", "TransformUtils GetAssetsPaths error. ", th);
        }
        if (i4 < 28 && (i4 != 27 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
            for (int i5 = 0; i5 < intValue; i5++) {
                try {
                    String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i5 + 1));
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            return sb.toString();
        }
        Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
            }
        }
        return sb.toString();
    }

    public static Context getContext(Object obj, String str) {
        try {
            Context context = (Context) MethodUtils.invokeMethod(obj, "getContext", new Object[0]);
            if (!isSupportLibIso(str) && instanceOfFragmentActivity(context)) {
                return wrapperContext(context, str);
            }
            if (context instanceof Activity) {
                return wrapperContext(context, str);
            }
            if (context instanceof Application) {
                return wrapperContext(context, str);
            }
            return context instanceof PluginContext ? context : wrapperContext(context, str);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    private static Context getContextIfNeedWrap(Context context, Context context2, String str) {
        Object readField;
        while (context2 != null) {
            if (context2 instanceof IPluginActivity) {
                if (TextUtils.equals(((IPluginActivity) context2).getPluginPkgName(), str)) {
                    return null;
                }
                return context;
            } else if (context2 instanceof PluginContext) {
                PluginContext pluginContext = (PluginContext) context2;
                if (TextUtils.equals(pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginContext.mOriginContext;
            } else if (context2 instanceof PluginActivityWrapper) {
                PluginActivityWrapper pluginActivityWrapper = (PluginActivityWrapper) context2;
                if (TextUtils.equals(pluginActivityWrapper.pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginActivityWrapper.mOriginActivity;
            } else if (!isSupportLibIso(str) && (context2 instanceof PluginFragmentActivityWrapper)) {
                if (TextUtils.equals(((PluginFragmentActivityWrapper) context2).pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                try {
                    try {
                        readField = ((PluginFragmentActivityWrapper) context2).getOriginActivity();
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                } catch (Throwable unused) {
                    readField = FieldUtils.readField(context2, "mOriginActivity");
                }
                return (Context) readField;
            } else if (context2 instanceof PluginApplicationWrapper) {
                PluginApplicationWrapper pluginApplicationWrapper = (PluginApplicationWrapper) context2;
                if (TextUtils.equals(pluginApplicationWrapper.mPluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginApplicationWrapper.mOriginApplication;
            } else if (context2.getResources() instanceof PluginResources) {
                PluginResources pluginResources = (PluginResources) context2.getResources();
                try {
                    String str2 = (String) FieldUtils.readField(pluginResources, "pluginPkg");
                    if (TextUtils.isEmpty(str2)) {
                        String assetPaths = getAssetPaths(pluginResources.getAssets());
                        if (!assetPaths.contains(TTPathConst.sSeparator + str + "/version")) {
                            return context;
                        }
                    } else if (!TextUtils.equals(str2, str)) {
                        return context;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return null;
            } else if (!(context2 instanceof ContextWrapper)) {
                return context;
            } else {
                try {
                    context2 = (Context) FieldUtils.readField(context2, "mBase");
                } catch (Throwable unused2) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
        }
        return null;
    }

    public static int getIdentifier(Object obj, String str, String str2, String str3, String str4) {
        if (obj instanceof Resources) {
            Resources resources = (Resources) obj;
            if (!TextUtils.equals("android", str3)) {
                str3 = str4;
            }
            return resources.getIdentifier(str, str2, str3);
        }
        try {
            return ((Integer) MethodUtils.invokeMethod(obj, "getIdentifier", str, str2, str3)).intValue();
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static Resources getResources(Object obj, String str) {
        try {
            Resources resources = (Resources) MethodUtils.invokeMethod(obj, "getResources", new Object[0]);
            if (resources == null) {
                return null;
            }
            if (resources instanceof PluginResources) {
                String str2 = (String) FieldUtils.readField(resources, "pluginPkg");
                if (TextUtils.isEmpty(str2)) {
                    String assetPaths = getAssetPaths(resources.getAssets());
                    if (assetPaths.contains(TTPathConst.sSeparator + str + "/version")) {
                        return resources;
                    }
                } else if (TextUtils.equals(str2, str)) {
                    return resources;
                }
            }
            return PluginManager.getInstance().getPlugin(str).mResources;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static Uri getUriForFile(Context context, String str, File file, String str2) {
        try {
            return FileProvider.getUriForFile(file);
        } catch (NoClassDefFoundError unused) {
            return Uri.parse("");
        }
    }

    public static Window getWindow(Activity activity, String str) {
        Window window = activity.getWindow();
        if (window == null) {
            try {
                return (Window) MethodUtils.invokeMethod(activity, "getWindow", new Object[0]);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
        return window;
    }

    private static Context getWrapperFromCache(Object obj, String str) {
        HashMap<String, WeakReference<Context>> hashMap = contextCache;
        WeakReference<Context> weakReference = hashMap.get(str + System.identityHashCode(obj));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static void handleAttrAfter(TypedArray typedArray, int[] iArr, int[] iArr2) {
        if (Arrays.equals(iArr, iArr2)) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < iArr.length; i4++) {
            hashMap.put(Integer.valueOf(iArr[i4]), Integer.valueOf(i4));
        }
        HashMap hashMap2 = new HashMap();
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            hashMap2.put((Integer) hashMap.get(Integer.valueOf(iArr2[i5])), Integer.valueOf(i5));
        }
        try {
            int[] iArr3 = (int[]) FieldUtils.readField(typedArray, "mData");
            int[] copyOf = Arrays.copyOf(iArr3, iArr3.length);
            for (Integer num : hashMap2.keySet()) {
                Integer num2 = (Integer) hashMap2.get(num);
                if (!num.equals(num2)) {
                    System.arraycopy(iArr3, num.intValue() * 7, copyOf, num2.intValue() * 7, 7);
                }
            }
            System.arraycopy(copyOf, 0, iArr3, 0, iArr3.length);
        } catch (IllegalAccessException unused) {
            ZeusLogger.errReport("Zeus/resources_pangle", "read mData failed.");
        }
    }

    private static int[] handleAttrBefore(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(copyOf);
        return copyOf;
    }

    public static View inflate(LayoutInflater layoutInflater, int i4, ViewGroup viewGroup, boolean z3, String str) {
        Context context = layoutInflater.getContext();
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && ((isSupportLibIso(str) || !(context instanceof PluginFragmentActivityWrapper)) && !(context instanceof PluginApplicationWrapper))) {
            Context wrapperContext = wrapperContext(context, str);
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            LayoutInflater.Factory2 factory2 = layoutInflater.getFactory2();
            LayoutInflater layoutInflater2 = (LayoutInflater) wrapperContext.getSystemService("layout_inflater");
            if (isSupportLibIso(str)) {
                if (factory != null) {
                    try {
                        FieldUtils.writeField(layoutInflater2, "mFactory", factory);
                    } catch (Throwable unused) {
                        ZeusLogger.w("Zeus/resources_pangle", "set Factory failed.");
                    }
                }
                if (factory2 != null) {
                    try {
                        FieldUtils.writeField(layoutInflater2, "mFactory2", factory2);
                    } catch (Throwable unused2) {
                        ZeusLogger.w("Zeus/resources_pangle", "set Factory2 failed.");
                    }
                }
            }
            layoutInflater = layoutInflater2;
        }
        clearConstructorCache();
        View inflate = layoutInflater.inflate(i4, viewGroup, z3);
        clearConstructorCache();
        return inflate;
    }

    public static boolean instanceOf(Class cls, Object obj) {
        return instanceOf(obj, cls);
    }

    private static boolean instanceOfFragmentActivity(Object obj) {
        ensureFragmentActivity();
        Class cls = fragmentClazz;
        if (cls == null) {
            return false;
        }
        return cls.isInstance(obj);
    }

    private static boolean isSupportLibIso(String str) {
        try {
            return PluginManager.getInstance().getPlugin(str).mIsSupportLibIso;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int mapRes(int i4, String str, String str2) {
        if (i4 < 2130706432) {
            return i4;
        }
        int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2, str, Zeus.getAppApplication().getPackageName());
        if (identifier == 0) {
            identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.replace("_", "."), str, Zeus.getAppApplication().getPackageName());
        }
        if (identifier == 0) {
            ZeusLogger.d("Zeus/resources_pangle", "Cant find res, resName = " + str2 + ", pluginResId = " + i4);
        }
        return identifier;
    }

    public static TypedArray obtainAttributes(Object obj, AttributeSet attributeSet, int[] iArr, String str) {
        if (obj instanceof Resources) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainAttributes = ((Resources) obj).obtainAttributes(attributeSet, handleAttrBefore);
            handleAttrAfter(obtainAttributes, handleAttrBefore, iArr);
            return obtainAttributes;
        }
        try {
            return (TypedArray) MethodUtils.invokeMethod(obj, "obtainAttributes", attributeSet, iArr);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static TypedArray obtainStyledAttributes(Object obj, AttributeSet attributeSet, int[] iArr, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(attributeSet, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        }
        try {
            return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", attributeSet, iArr);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static Object preCheckCast(Object obj, Class cls, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Context) {
            boolean z3 = !cls.isInstance(obj);
            if (equalsFragmentActivity(cls)) {
                return wrapperContext2FragmentActivity(obj, str);
            }
            if (cls == Activity.class) {
                return wrapperContext2Activity(obj, str);
            }
            if (cls == Application.class) {
                return wrapperContext2Application(obj, str);
            }
            if ((obj instanceof PluginContext) && z3) {
                return ((PluginContext) obj).mOriginContext;
            }
            if ((obj instanceof PluginFragmentActivityWrapper) && z3) {
                try {
                    try {
                        return ((PluginFragmentActivityWrapper) obj).getOriginActivity();
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                } catch (Throwable unused) {
                    return FieldUtils.readField(obj, "mOriginActivity");
                }
            } else if ((obj instanceof PluginActivityWrapper) && z3) {
                return ((PluginActivityWrapper) obj).mOriginActivity;
            } else {
                if ((obj instanceof PluginApplicationWrapper) && z3) {
                    return ((PluginApplicationWrapper) obj).mOriginApplication;
                }
                return ((obj instanceof GenerateProxyActivity) && z3) ? ((GenerateProxyActivity) obj).mTargetActivity : obj;
            }
        }
        return obj;
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str) {
        if (obj instanceof Context) {
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static void registerZeusActivityStub(String str, String[] strArr, String str2) {
        ComponentManager.registerActivity(str2, str, strArr);
    }

    public static void requestPermissions(Object obj, String[] strArr, int i4, String str) {
        if (obj instanceof IPluginActivity) {
            ((IPluginActivity) obj)._requestPermissions(strArr, i4);
            return;
        }
        if (obj instanceof Activity) {
            Object obj2 = null;
            try {
                obj2 = FieldUtils.readField(obj, "mOriginActivity");
            } catch (IllegalAccessException unused) {
            }
            if (obj2 != null) {
                obj = obj2;
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "requestPermissions", strArr, Integer.valueOf(i4));
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static void setComponentEnabledSetting(PackageManager packageManager, ComponentName componentName, int i4, int i5) {
        try {
            packageManager.setComponentEnabledSetting(componentName, i4, i5);
        } catch (Throwable unused) {
        }
    }

    public static void setResult(Object obj, int i4, Intent intent, String str) {
        if (obj instanceof Activity) {
            try {
                Object readField = FieldUtils.readField(obj, "mProxyActivity");
                if (readField == null) {
                    readField = FieldUtils.readField(obj, "mOriginActivity");
                }
                if (readField != null) {
                    MethodUtils.invokeMethod(readField, "setResult", Integer.valueOf(i4), intent);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i4), intent);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static void startActivity(Object obj, Intent intent, String str) {
        startActivity(obj, intent, null, str);
    }

    public static void startActivityForResult(Object obj, Intent intent, int i4, String str) {
        startActivityForResult(obj, intent, i4, null, str);
    }

    public static ComponentName startService(Object obj, Intent intent, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().startServiceNative((Context) obj, intent, str);
        }
        try {
            return (ComponentName) MethodUtils.invokeMethod(obj, "startService", intent);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static boolean stopService(Object obj, Intent intent, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().stopServiceNative((Context) obj, intent, str);
        }
        try {
            return ((Boolean) MethodUtils.invokeMethod(obj, "stopService", intent)).booleanValue();
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static void supportFragmentWrapper(boolean z3) {
        sSupportFragmentWrapper = z3;
    }

    public static void unbindService(Object obj, ServiceConnection serviceConnection, String str) {
        if (obj instanceof Context) {
            ServiceManagerNative.getInstance().unbindServiceNative(serviceConnection);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "unbindService", serviceConnection);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static void unregisterReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, String str) {
        if (obj instanceof Context) {
            ComponentManager.unregisterReceiver((Context) obj, pluginBroadcastReceiver);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "unregisterReceiver", pluginBroadcastReceiver);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static Context wrapperContext(Object obj, String str) {
        return wrapperContext(obj, str, null);
    }

    public static Activity wrapperContext2Activity(Object obj, String str) {
        while (obj != null) {
            StringBuilder sb = new StringBuilder();
            Context wrapperContext = wrapperContext(obj, str, sb);
            if (wrapperContext instanceof Activity) {
                return (Activity) wrapperContext;
            }
            if (wrapperContext instanceof PluginContext) {
                obj = ((PluginContext) wrapperContext).mOriginContext;
            } else {
                sb.append("SupportFragment=");
                sb.append(sSupportFragmentWrapper);
                if (!sCanThrowException) {
                    return (Activity) obj;
                }
                throw new RuntimeException("\u5f3a\u8f6c\u5931\u8d25 context:" + obj + " wrapperContext:" + wrapperContext + " log:" + ((Object) sb));
            }
        }
        return null;
    }

    public static Application wrapperContext2Application(Object obj, String str) {
        while (obj != null) {
            StringBuilder sb = new StringBuilder();
            Context wrapperContext = wrapperContext(obj, str, sb);
            if (wrapperContext instanceof Application) {
                return (Application) wrapperContext;
            }
            if (wrapperContext instanceof PluginContext) {
                obj = ((PluginContext) wrapperContext).mOriginContext;
            } else {
                sb.append("SupportFragment=");
                sb.append(sSupportFragmentWrapper);
                if (!sCanThrowException) {
                    return (Application) obj;
                }
                throw new RuntimeException("\u5f3a\u8f6c\u5931\u8d25 context:" + obj + " wrapperContext:" + wrapperContext + " log:" + ((Object) sb));
            }
        }
        return null;
    }

    private static Object wrapperContext2FragmentActivity(Object obj, String str) {
        while (obj != null) {
            StringBuilder sb = new StringBuilder();
            Context wrapperContext = wrapperContext(obj, str, sb);
            if (!isSupportLibIso(str) && instanceOfFragmentActivity(wrapperContext)) {
                return wrapperContext;
            }
            if (wrapperContext instanceof PluginContext) {
                obj = ((PluginContext) wrapperContext).mOriginContext;
            } else {
                sb.append("SupportFragment=");
                sb.append(sSupportFragmentWrapper);
                if (sCanThrowException) {
                    throw new RuntimeException("\u5f3a\u8f6c\u5931\u8d25 context:" + obj + " wrapperContext:" + wrapperContext + " log:" + ((Object) sb));
                }
                return obj;
            }
        }
        return null;
    }

    public static Object wrapperContextForParams(Object obj, Class cls, String str) {
        if (!(obj instanceof PluginService) && !(obj instanceof PluginIntentService) && (obj instanceof Context)) {
            Context convertProxy2PluginActivity = convertProxy2PluginActivity(wrapperContext(obj, str));
            if (cls.isInstance(convertProxy2PluginActivity)) {
                return convertProxy2PluginActivity;
            }
        }
        return obj;
    }

    public static boolean instanceOf(Object obj, Class cls) {
        Object readField;
        if (obj instanceof PluginContext) {
            return cls.isInstance(((PluginContext) obj).mOriginContext);
        }
        if (obj instanceof PluginActivityWrapper) {
            return cls.isInstance(((PluginActivityWrapper) obj).mOriginActivity);
        }
        if (obj instanceof PluginFragmentActivityWrapper) {
            try {
                try {
                    readField = ((PluginFragmentActivityWrapper) obj).getOriginActivity();
                } catch (Throwable unused) {
                    readField = FieldUtils.readField(obj, "mOriginActivity");
                }
                return cls.isInstance(readField);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        } else if (obj instanceof PluginApplicationWrapper) {
            return cls.isInstance(((PluginApplicationWrapper) obj).mOriginApplication);
        } else {
            if (obj instanceof GenerateProxyActivity) {
                return cls.isInstance(((GenerateProxyActivity) obj).mTargetActivity);
            }
            return cls.isInstance(obj);
        }
    }

    public static void startActivity(Object obj, Intent intent, Bundle bundle, String str) {
        try {
            ComponentManager.startActivity(obj, intent, bundle, str);
        } catch (Throwable unused) {
            if (obj instanceof Context) {
                ComponentManager.startActivity((Context) obj, intent, bundle, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "startActivity", new Object[]{intent, bundle}, new Class[]{Intent.class, Bundle.class});
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public static void startActivityForResult(Object obj, Intent intent, int i4, Bundle bundle, String str) {
        try {
            ComponentManager.startActivityForResult(obj, intent, i4, bundle, str);
        } catch (Throwable unused) {
            if (obj instanceof Activity) {
                ComponentManager.startActivityForResult((Activity) obj, intent, i4, bundle, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "startActivityForResult", new Object[]{intent, Integer.valueOf(i4), bundle}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public static Context wrapperContext(Object obj, String str, StringBuilder sb) {
        Context pluginContext;
        Application application;
        if (Zeus.getAppApplication() == null && (application = (Application) StubApp.getOrigApplicationContext(((Context) obj).getApplicationContext())) != null) {
            Zeus.setAppContext(application);
        }
        if (obj == null) {
            if (sb != null) {
                sb.append("context1 == null");
                return null;
            }
            return null;
        }
        Context wrapperFromCache = getWrapperFromCache(obj, str);
        if (wrapperFromCache != null) {
            if (sb != null) {
                sb.append("cache1:");
                sb.append(wrapperFromCache);
            }
            return wrapperFromCache;
        }
        Context context = (Context) obj;
        Context contextIfNeedWrap = getContextIfNeedWrap(context, context, str);
        if (contextIfNeedWrap == null) {
            if (sb != null) {
                sb.append("context2 == null");
                sb.append(obj);
            }
            return context;
        }
        if (!isSupportLibIso(str) && instanceOfFragmentActivity(contextIfNeedWrap) && sSupportFragmentWrapper) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            try {
                try {
                    pluginContext = new PluginFragmentActivityWrapper((Activity) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false));
                    if (sb != null) {
                        sb.append("new PluginFragmentActivityWrapper:");
                        sb.append(pluginContext);
                    }
                } catch (Throwable unused) {
                    if (sb != null) {
                        sb.append("context3 == null");
                        sb.append(contextIfNeedWrap);
                    }
                    return contextIfNeedWrap;
                }
            } catch (Throwable unused2) {
                pluginContext = (Context) MethodUtils.invokeConstructor(PluginFragmentActivityWrapper.class, new Object[]{contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false)}, new Class[]{fragmentClazz, PluginContext.class});
                if (sb != null) {
                    sb.append("new invokeConstructor:");
                    sb.append(pluginContext);
                }
            }
        } else if (contextIfNeedWrap instanceof Activity) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            pluginContext = new PluginActivityWrapper((Activity) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false));
            if (sb != null) {
                sb.append("new PluginActivityWrapper:");
                sb.append(pluginContext);
            }
        } else if (contextIfNeedWrap instanceof Application) {
            pluginContext = new PluginApplicationWrapper((Application) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), true));
            if (sb != null) {
                sb.append("new PluginApplicationWrapper:");
                sb.append(pluginContext);
            }
        } else {
            pluginContext = new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false);
            if (sb != null) {
                sb.append("new PluginContext:");
                sb.append(pluginContext);
            }
        }
        if (pluginContext != null) {
            HashMap<String, WeakReference<Context>> hashMap = contextCache;
            hashMap.put(str + System.identityHashCode(contextIfNeedWrap), new WeakReference<>(pluginContext));
        }
        if (sb != null) {
            sb.append("cache2:");
            sb.append(pluginContext);
        }
        return pluginContext;
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, String str2) {
        if (obj instanceof Context) {
            ZeusLogger.d("Zeus/receiver_pangle", "ZeusTransformUtils-registerReceiver-execute[4 params]");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, str2);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static TypedArray obtainStyledAttributes(Object obj, AttributeSet attributeSet, int[] iArr, int i4, int i5, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(attributeSet, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        } else if (obj instanceof Resources.Theme) {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(attributeSet, handleAttrBefore2, i4, i5);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        } else {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", attributeSet, iArr, Integer.valueOf(i4), Integer.valueOf(i5));
            } catch (Exception e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    public static void setResult(Object obj, int i4, String str) {
        if (obj instanceof Activity) {
            try {
                Object readField = FieldUtils.readField(obj, "mProxyActivity");
                if (readField != null) {
                    MethodUtils.invokeMethod(readField, "setResult", Integer.valueOf(i4));
                    return;
                }
            } catch (Exception unused) {
                ZeusLogger.d("Zeus/activity_pangle", "Cant find mProxyActivity, obj = ".concat(String.valueOf(obj)));
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i4));
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i4, String str) {
        if (obj instanceof Context) {
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, i4, str);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, Integer.valueOf(i4));
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i4, String str2) {
        if (obj instanceof Context) {
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, i4, str2);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler, Integer.valueOf(i4));
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static View inflate(LayoutInflater layoutInflater, int i4, ViewGroup viewGroup, String str) {
        return inflate(layoutInflater, i4, viewGroup, viewGroup != null, str);
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, String str) {
        return inflate(layoutInflater, xmlPullParser, viewGroup, viewGroup != null, str);
    }

    public static TypedArray obtainStyledAttributes(Object obj, int i4, int[] iArr, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(i4, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        } else if (obj instanceof Resources.Theme) {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(i4, handleAttrBefore2);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        } else {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", Integer.valueOf(i4), iArr);
            } catch (Exception e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z3, String str) {
        Context context = layoutInflater.getContext();
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && ((isSupportLibIso(str) || !(context instanceof PluginFragmentActivityWrapper)) && !(context instanceof PluginApplicationWrapper))) {
            context = wrapperContext(context, str);
        }
        clearConstructorCache();
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(xmlPullParser, viewGroup, z3);
        clearConstructorCache();
        return inflate;
    }

    public static View inflate(Context context, int i4, ViewGroup viewGroup, String str) {
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && ((isSupportLibIso(str) || !(context instanceof PluginFragmentActivityWrapper)) && !(context instanceof PluginApplicationWrapper))) {
            context = wrapperContext(context, str);
        }
        clearConstructorCache();
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i4, viewGroup);
        clearConstructorCache();
        return inflate;
    }

    public static TypedArray obtainStyledAttributes(Object obj, int[] iArr, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        } else if (obj instanceof Resources.Theme) {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(handleAttrBefore2);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        } else {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", iArr, new Class[]{int[].class});
            } catch (Exception e4) {
                throw new RuntimeException(e4);
            }
        }
    }
}
