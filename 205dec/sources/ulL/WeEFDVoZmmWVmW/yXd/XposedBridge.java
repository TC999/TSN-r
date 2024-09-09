package ulL.WeEFDVoZmmWVmW.yXd;

import OcOsO.RddINbhi.wn.EFApGV.EE.r.HookBridge;
import OcOsO.RddINbhi.wn.EFApGV.EE.r.ResourcesHook;
import android.app.ActivityThread;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_InitPackageResources;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_LoadPackage;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class XposedBridge {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "LSPosed-Bridge";
    @Deprecated
    public static int XPOSED_BRIDGE_VERSION;
    public static final ClassLoader BOOTCLASSLOADER = XposedBridge.class.getClassLoader();
    private static final Object[] EMPTY_ARRAY = new Object[0];
    public static final CopyOnWriteArraySet sLoadedPackageCallbacks = new CopyOnWriteArraySet();
    static final CopyOnWriteArraySet sInitPackageResourcesCallbacks = new CopyOnWriteArraySet();
    public static volatile ClassLoader dummyClassLoader = null;

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public final class CopyOnWriteSortedSet {
        private volatile transient Object[] elements = XposedBridge.EMPTY_ARRAY;

        private int indexOf(Object obj) {
            for (int i4 = 0; i4 < this.elements.length; i4++) {
                if (obj.equals(this.elements[i4])) {
                    return i4;
                }
            }
            return -1;
        }

        public synchronized boolean add(Object obj) {
            if (indexOf(obj) >= 0) {
                return false;
            }
            Object[] objArr = new Object[this.elements.length + 1];
            System.arraycopy(this.elements, 0, objArr, 0, this.elements.length);
            objArr[this.elements.length] = obj;
            Arrays.sort(objArr);
            this.elements = objArr;
            return true;
        }

        public synchronized void clear() {
            this.elements = XposedBridge.EMPTY_ARRAY;
        }

        public Object[] getSnapshot() {
            return this.elements;
        }

        public synchronized boolean remove(Object obj) {
            int indexOf = indexOf(obj);
            if (indexOf == -1) {
                return false;
            }
            Object[] objArr = new Object[this.elements.length - 1];
            System.arraycopy(this.elements, 0, objArr, 0, indexOf);
            System.arraycopy(this.elements, indexOf + 1, objArr, indexOf, (this.elements.length - indexOf) - 1);
            this.elements = objArr;
            return true;
        }

        public Object[] getSnapshot(Object[] objArr) {
            Object[] snapshot = getSnapshot();
            return Arrays.copyOf(snapshot, snapshot.length, objArr.getClass());
        }
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public class LegacyApiSupport {
        private int beforeIdx;
        private final C1340a0 callback;
        private final XC_MethodHook.MethodHookParam param = new XC_MethodHook.MethodHookParam();
        private final Object[] snapshot;

        public LegacyApiSupport(C1340a0 c1340a0, Object[] objArr) {
            this.callback = c1340a0;
            this.snapshot = objArr;
        }

        private void syncronizeApi(XC_MethodHook.MethodHookParam methodHookParam, C1340a0 c1340a0, boolean z3) {
            if (z3) {
                methodHookParam.method = c1340a0.f98a;
                methodHookParam.thisObject = c1340a0.f99b;
                methodHookParam.args = c1340a0.f100c;
                methodHookParam.result = c1340a0.f101d;
                methodHookParam.throwable = c1340a0.f102e;
                methodHookParam.returnEarly = c1340a0.f103f;
                return;
            }
            c1340a0.f98a = methodHookParam.method;
            c1340a0.f99b = methodHookParam.thisObject;
            c1340a0.f100c = methodHookParam.args;
            c1340a0.f101d = methodHookParam.result;
            c1340a0.f102e = methodHookParam.throwable;
            c1340a0.f103f = methodHookParam.returnEarly;
        }

        public void handleAfter() {
            syncronizeApi(this.param, this.callback, true);
            for (int i4 = this.beforeIdx - 1; i4 >= 0; i4--) {
                Object result = this.param.getResult();
                Throwable throwable = this.param.getThrowable();
                try {
                    ((XC_MethodHook) this.snapshot[i4]).afterHookedMethod(this.param);
                } catch (Throwable th) {
                    XposedBridge.log(th);
                    if (throwable == null) {
                        this.param.setResult(result);
                    } else {
                        this.param.setThrowable(throwable);
                    }
                }
            }
            syncronizeApi(this.param, this.callback, false);
        }

        public void handleBefore() {
            syncronizeApi(this.param, this.callback, true);
            this.beforeIdx = 0;
            while (true) {
                int i4 = this.beforeIdx;
                Object[] objArr = this.snapshot;
                if (i4 >= objArr.length) {
                    break;
                }
                try {
                    ((XC_MethodHook) objArr[i4]).beforeHookedMethod(this.param);
                } catch (Throwable th) {
                    XposedBridge.log(th);
                    this.param.setResult(null);
                    this.param.returnEarly = false;
                }
                if (this.param.returnEarly) {
                    this.beforeIdx++;
                    break;
                }
                this.beforeIdx++;
            }
            syncronizeApi(this.param, this.callback, false);
        }
    }

    private XposedBridge() {
    }

    public static void deoptimizeMethod(Member member) {
        if (!(member instanceof Executable)) {
            throw new IllegalArgumentException("Only methods and constructors can be deoptimized: " + member);
        } else if (Modifier.isAbstract(member.getModifiers())) {
            throw new IllegalArgumentException("Cannot deoptimize abstract methods: " + member);
        } else if (!Proxy.isProxyClass(member.getDeclaringClass())) {
            HookBridge.deoptimizeMethod((Executable) member);
        } else {
            throw new IllegalArgumentException("Cannot deoptimize methods from proxy class: " + member);
        }
    }

    public static int getXposedVersion() {
        return 100;
    }

    public static Set hookAllConstructors(Class cls, XC_MethodHook xC_MethodHook) {
        HashSet hashSet = new HashSet();
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            hashSet.add(hookMethod(constructor, xC_MethodHook));
        }
        return hashSet;
    }

    public static Set hookAllMethods(Class cls, String str, XC_MethodHook xC_MethodHook) {
        Method[] declaredMethods;
        HashSet hashSet = new HashSet();
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals(str)) {
                hashSet.add(hookMethod(method, xC_MethodHook));
            }
        }
        return hashSet;
    }

    public static void hookInitPackageResources(XC_InitPackageResources xC_InitPackageResources) {
        CopyOnWriteArraySet copyOnWriteArraySet = sInitPackageResourcesCallbacks;
        synchronized (copyOnWriteArraySet) {
            copyOnWriteArraySet.add(xC_InitPackageResources);
        }
    }

    public static void hookLoadPackage(XC_LoadPackage xC_LoadPackage) {
        CopyOnWriteArraySet copyOnWriteArraySet = sLoadedPackageCallbacks;
        synchronized (copyOnWriteArraySet) {
            copyOnWriteArraySet.add(xC_LoadPackage);
        }
    }

    public static XC_MethodHook.Unhook hookMethod(Member member, XC_MethodHook xC_MethodHook) {
        if (!(member instanceof Executable)) {
            throw new IllegalArgumentException("Only methods and constructors can be hooked: " + member);
        } else if (Modifier.isAbstract(member.getModifiers())) {
            throw new IllegalArgumentException("Cannot hook abstract methods: " + member);
        } else if (member.getDeclaringClass().getClassLoader() != XposedBridge.class.getClassLoader()) {
            if (member.getDeclaringClass() == Method.class && member.getName().equals("invoke")) {
                throw new IllegalArgumentException("Cannot hook Method.invoke");
            }
            if (xC_MethodHook != null) {
                if (HookBridge.hookMethod(false, (Executable) member, J.class, xC_MethodHook.priority, xC_MethodHook)) {
                    return new XC_MethodHook.Unhook(member);
                }
                log("Failed to hook " + member);
                return null;
            }
            throw new IllegalArgumentException("callback should not be null!");
        } else {
            throw new IllegalArgumentException("Do not allow hooking inner methods");
        }
    }

    public static void initXResources() {
        if (dummyClassLoader != null) {
            return;
        }
        try {
            Resources system = Resources.getSystem();
            Class<?> cls = system.getClass();
            Class<?> cls2 = TypedArray.class;
            try {
                try {
                    TypedArray obtainTypedArray = system.obtainTypedArray(system.getIdentifier("preloaded_drawables", "array", "android"));
                    cls2 = obtainTypedArray.getClass();
                    obtainTypedArray.recycle();
                } catch (Resources.NotFoundException e4) {
                    log(e4);
                }
            } catch (NullPointerException unused) {
                XposedHelpers.setStaticObjectField(ActivityThread.class, "sCurrentActivityThread", XposedHelpers.newInstance(ActivityThread.class, new Object[0]));
                try {
                    TypedArray obtainTypedArray2 = system.obtainTypedArray(system.getIdentifier("preloaded_drawables", "array", "android"));
                    cls2 = obtainTypedArray2.getClass();
                    obtainTypedArray2.recycle();
                    XposedHelpers.setStaticObjectField(ActivityThread.class, "sCurrentActivityThread", null);
                } catch (Throwable th) {
                    XposedHelpers.setStaticObjectField(ActivityThread.class, "sCurrentActivityThread", null);
                    throw th;
                }
            }
            ResourcesHook.makeInheritable(cls);
            ResourcesHook.makeInheritable(cls2);
            ClassLoader classLoader = XposedBridge.class.getClassLoader();
            dummyClassLoader = ResourcesHook.buildDummyClassLoader(classLoader.getParent(), cls.getName(), cls2.getName());
            dummyClassLoader.loadClass("xposed.dummy.XResourcesSuperClass");
            dummyClassLoader.loadClass("xposed.dummy.XTypedArraySuperClass");
            XposedHelpers.setObjectField(classLoader, "parent", dummyClassLoader);
        } catch (Throwable th2) {
            log(th2);
            XposedInit.disableResources = true;
        }
    }

    public static Object invokeOriginalMethod(Member member, Object obj, Object[] objArr) {
        if (objArr == null) {
            objArr = EMPTY_ARRAY;
        }
        if (member instanceof Executable) {
            return HookBridge.invokeOriginalMethod((Executable) member, obj, objArr);
        }
        throw new IllegalArgumentException("method must be of type Method or Constructor");
    }

    public static synchronized void log(String str) {
        synchronized (XposedBridge.class) {
            Log.i(TAG, str);
        }
    }

    @Deprecated
    public static void unhookMethod(Member member, XC_MethodHook xC_MethodHook) {
        if (member instanceof Executable) {
            HookBridge.unhookMethod(false, (Executable) member, xC_MethodHook);
        }
    }

    public static synchronized void log(Throwable th) {
        synchronized (XposedBridge.class) {
            Log.e(TAG, Log.getStackTraceString(th));
        }
    }
}
