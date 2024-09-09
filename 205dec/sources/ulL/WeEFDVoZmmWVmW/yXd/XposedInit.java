package ulL.WeEFDVoZmmWVmW.yXd;

import CyVHHabzCrUqKeyhTwFaxBD.ources;
import OcOsO.RddINbhi.wn.EFApGV.EE.r.ResourcesHook;
import android.app.ActivityThread;
import android.app.ResourcesManager;
import android.content.pm.ApplicationInfo;
import android.content.res.MiuiResources;
import android.content.res.Resources;
import android.content.res.ResourcesImpl;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.util.ArrayMap;
import android.util.Log;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import ulL.WeEFDVoZmmWVmW.yXd.IXposedHookInitPackageResources;
import ulL.WeEFDVoZmmWVmW.yXd.IXposedHookLoadPackage;
import ulL.WeEFDVoZmmWVmW.yXd.IXposedHookZygoteInit;
import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_InitPackageResources;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XCallback;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class XposedInit {
    private static final String TAG = "LSPosed-Bridge";
    public static volatile boolean disableResources = false;
    public static boolean startsSystemServer = false;
    public static AtomicBoolean resourceInit = new AtomicBoolean(false);
    private static final Map loadedModules = new ConcurrentHashMap();
    public static final Set loadedPackagesInProcess = ConcurrentHashMap.newKeySet(1);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [CyVHHabzCrUqKeyhTwFaxBD.ources, java.lang.Object, android.content.res.Resources] */
    public static ources cloneToXResources(XC_MethodHook.MethodHookParam methodHookParam, String str) {
        Object result = methodHookParam.getResult();
        if (result == null || (result instanceof ources)) {
            return null;
        }
        ?? ourcesVar = new ources((ClassLoader) XposedHelpers.getObjectField(methodHookParam.getResult(), "mClassLoader"), str);
        ourcesVar.setImpl((ResourcesImpl) XposedHelpers.getObjectField(methodHookParam.getResult(), "mResourcesImpl"));
        if (ourcesVar.isFirstLoad()) {
            String packageName = ourcesVar.getPackageName();
            XC_InitPackageResources.InitPackageResourcesParam initPackageResourcesParam = new XC_InitPackageResources.InitPackageResourcesParam(XposedBridge.sInitPackageResourcesCallbacks);
            initPackageResourcesParam.packageName = packageName;
            initPackageResourcesParam.res = ourcesVar;
            XCallback.callAll(initPackageResourcesParam);
        }
        methodHookParam.setResult(ourcesVar);
        return ourcesVar;
    }

    public static Map getLoadedModules() {
        return loadedModules;
    }

    public static void hookResources() {
        if (disableResources || !resourceInit.compareAndSet(false, true)) {
            return;
        }
        if (K0.f35a) {
            AbstractC1457e.a("boot_image_miui_res", null);
        }
        if (!ResourcesHook.initXResourcesNative()) {
            Log.e("LSPosed-Bridge", "Cannot hook resources");
            disableResources = true;
            return;
        }
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager", null, "getResourcesForApplication", ApplicationInfo.class, new XC_MethodHook() { // from class: ulL.WeEFDVoZmmWVmW.yXd.XposedInit.1
            @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
            public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
                ApplicationInfo applicationInfo = (ApplicationInfo) methodHookParam.args[0];
                ources.setPackageNameForResDir(applicationInfo.packageName, applicationInfo.uid == Process.myUid() ? applicationInfo.sourceDir : applicationInfo.publicSourceDir);
            }
        });
        ThreadLocal threadLocal = new ThreadLocal();
        ArrayList arrayList = new ArrayList();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31) {
            arrayList.add("createResources");
            arrayList.add("createResourcesForActivity");
        } else if (i4 == 30) {
            arrayList.add("createResources");
        } else {
            arrayList.add("getOrCreateResources");
        }
        final Class findClassIfExists = XposedHelpers.findClassIfExists("android.app.ResourcesManager$ActivityResource", ResourcesManager.class.getClassLoader());
        XC_MethodHook xC_MethodHook = new XC_MethodHook() { // from class: ulL.WeEFDVoZmmWVmW.yXd.XposedInit.2
            @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
            public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
                Object obj;
                Class cls;
                try {
                    obj = methodHookParam.args[XposedHelpers.getParameterIndexByType(methodHookParam.method, IBinder.class)];
                } catch (NoSuchFieldError unused) {
                    obj = null;
                }
                ources cloneToXResources = XposedInit.cloneToXResources(methodHookParam, (String) XposedHelpers.getObjectField(methodHookParam.args[XposedHelpers.getParameterIndexByType(methodHookParam.method, r1)], "mResDir"));
                if (cloneToXResources == null) {
                    return;
                }
                synchronized (methodHookParam.thisObject) {
                    try {
                        ArrayList arrayList2 = obj != null ? (ArrayList) XposedHelpers.getObjectField(XposedHelpers.callMethod(methodHookParam.thisObject, "getOrCreateActivityResourcesStructLocked", obj), "activityResources") : (ArrayList) XposedHelpers.getObjectField(methodHookParam.thisObject, "mResourceReferences");
                        if (obj != null && (cls = findClassIfExists) != null) {
                            Object newInstance = XposedHelpers.newInstance(cls, new Object[0]);
                            XposedHelpers.setObjectField(newInstance, "resources", new WeakReference(cloneToXResources));
                            arrayList2.add(newInstance);
                        }
                        arrayList2.add(new WeakReference(cloneToXResources));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            XposedBridge.hookAllMethods(ResourcesManager.class, (String) it.next(), xC_MethodHook);
        }
        XposedHelpers.findAndHookMethod(TypedArray.class, "obtain", Resources.class, Integer.TYPE, new XC_MethodHook() { // from class: ulL.WeEFDVoZmmWVmW.yXd.XposedInit.3
            @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
            public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
                if (!(methodHookParam.getResult() instanceof ources.XTypedArray) && (methodHookParam.args[0] instanceof ources)) {
                    ources.XTypedArray xTypedArray = new ources.XTypedArray((Resources) methodHookParam.args[0]);
                    int intValue = ((Integer) methodHookParam.args[1]).intValue();
                    Method findMethodBestMatch = XposedHelpers.findMethodBestMatch(TypedArray.class, "resize", Integer.TYPE);
                    findMethodBestMatch.setAccessible(true);
                    findMethodBestMatch.invoke(xTypedArray, Integer.valueOf(intValue));
                    methodHookParam.setResult(xTypedArray);
                }
            }
        });
        MiuiResources ourcesVar = new ources((ClassLoader) XposedHelpers.getObjectField(Resources.getSystem(), "mClassLoader"), null);
        ourcesVar.setImpl((ResourcesImpl) XposedHelpers.getObjectField(Resources.getSystem(), "mResourcesImpl"));
        XposedHelpers.setStaticObjectField(Resources.class, "mSystem", ourcesVar);
        ources.init(threadLocal);
    }

    private static boolean initModule(ClassLoader classLoader, String str, List list) {
        Iterator it = list.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            try {
                Log.i("LSPosed-Bridge", "  Loading class " + str2);
                Class<?> loadClass = classLoader.loadClass(str2);
                if (IXposedMod.class.isAssignableFrom(loadClass)) {
                    Object newInstance = loadClass.newInstance();
                    if (newInstance instanceof IXposedHookZygoteInit) {
                        IXposedHookZygoteInit.StartupParam startupParam = new IXposedHookZygoteInit.StartupParam();
                        startupParam.modulePath = str;
                        startupParam.startsSystemServer = startsSystemServer;
                        ((IXposedHookZygoteInit) newInstance).initZygote(startupParam);
                        i4++;
                    }
                    if (newInstance instanceof IXposedHookLoadPackage) {
                        XposedBridge.hookLoadPackage(new IXposedHookLoadPackage.Wrapper((IXposedHookLoadPackage) newInstance));
                        i4++;
                    }
                    if (newInstance instanceof IXposedHookInitPackageResources) {
                        hookResources();
                        XposedBridge.hookInitPackageResources(new IXposedHookInitPackageResources.Wrapper((IXposedHookInitPackageResources) newInstance));
                        i4++;
                    }
                } else {
                    Log.e("LSPosed-Bridge", "    This class doesn't implement any sub-interface of IXposedMod, skipping it");
                }
            } catch (Throwable th) {
                Log.e("LSPosed-Bridge", "    Failed to load class " + str2, th);
            }
        }
        return i4 > 0;
    }

    private static void initNativeModule(List list) {
        list.forEach(new O0(1));
    }

    public static /* synthetic */ void lambda$loadLegacyModules$0(u0 u0Var) {
        String str = u0Var.f64418c;
        String str2 = u0Var.f64416a;
        F0 f02 = u0Var.f64419d;
        Map map = loadedModules;
        map.put(str2, Optional.of(str));
        if (loadModule(str2, str, f02)) {
            return;
        }
        map.remove(str2);
    }

    public static /* synthetic */ void lambda$loadModules$1(ActivityThread activityThread, ArrayMap arrayMap, u0 u0Var) {
        Map map = loadedModules;
        map.put(u0Var.f64416a, Optional.empty());
        if (N.loadModule(activityThread, u0Var)) {
            arrayMap.remove(u0Var.f64416a);
        } else {
            map.remove(u0Var.f64416a);
        }
    }

    public static void loadLegacyModules() {
        C1455d.f54605b.d().forEach(new O0(0));
    }

    private static boolean loadModule(String str, String str2, F0 f02) {
        String[] strArr;
        Log.i("LSPosed-Bridge", "Loading legacy module " + str + " from " + str2);
        StringBuilder sb = new StringBuilder();
        for (String str3 : Process.is64Bit() ? Build.SUPPORTED_64_BIT_ABIS : Build.SUPPORTED_32_BIT_ABIS) {
            sb.append(str2);
            sb.append("!/lib/");
            sb.append(str3);
            sb.append(File.pathSeparator);
        }
        String sb2 = sb.toString();
        ClassLoader classLoader = XposedInit.class.getClassLoader();
        C1474m0 a4 = C1474m0.a(str2, f02.f18a, sb2, classLoader);
        try {
            if (a4.loadClass(XposedBridge.class.getName()).getClassLoader() == classLoader) {
                initNativeModule(f02.f20c);
                return initModule(a4, str2, f02.f19b);
            }
            Log.e("LSPosed-Bridge", "  Cannot load module: " + str);
            Log.e("LSPosed-Bridge", "  The Xposed API classes are compiled into the module's APK.");
            Log.e("LSPosed-Bridge", "  This may cause strange issues and must be fixed by the module developer.");
            Log.e("LSPosed-Bridge", "  For details, see: https://api.xposed.info/using.html");
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void loadModules(ActivityThread activityThread) {
        C1455d.f54605b.c().forEach(new N0(activityThread, (ArrayMap) XposedHelpers.getObjectField(activityThread, "mPackages"), 0));
    }
}
