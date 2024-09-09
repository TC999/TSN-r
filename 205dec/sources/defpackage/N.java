package defpackage;

import OcOsO.RddINbhi.wn.EFApGV.EE.r.HookBridge;
import android.app.ActivityThread;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.XposedModule;
import io.github.libxposed.api.XposedModuleInterface;
import io.github.libxposed.api.errors.XposedFrameworkError;
import io.github.libxposed.api.utils.DexParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* renamed from: N  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class N implements XposedInterface {

    /* renamed from: e  reason: collision with root package name */
    public static boolean f39e;

    /* renamed from: f  reason: collision with root package name */
    public static String f40f;

    /* renamed from: g  reason: collision with root package name */
    public static final ConcurrentHashMap.KeySetView f41g = ConcurrentHashMap.newKeySet();

    /* renamed from: a  reason: collision with root package name */
    public final String f42a;

    /* renamed from: b  reason: collision with root package name */
    public final ApplicationInfo f43b;

    /* renamed from: c  reason: collision with root package name */
    public final InterfaceC1487y f44c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentHashMap f45d = new ConcurrentHashMap();

    public N(String str, ApplicationInfo applicationInfo, InterfaceC1487y interfaceC1487y) {
        this.f42a = str;
        this.f43b = applicationInfo;
        this.f44c = interfaceC1487y;
    }

    public static boolean a(Executable executable) {
        if (Modifier.isAbstract(executable.getModifiers())) {
            throw new IllegalArgumentException("Cannot deoptimize abstract methods: " + executable);
        } else if (Proxy.isProxyClass(executable.getDeclaringClass())) {
            throw new IllegalArgumentException("Cannot deoptimize methods from proxy class: " + executable);
        } else {
            return HookBridge.deoptimizeMethod(executable);
        }
    }

    public static char[] b(Executable executable) {
        Class<?>[] parameterTypes = executable.getParameterTypes();
        int length = parameterTypes.length + 1;
        char[] cArr = new char[length];
        cArr[0] = c(executable instanceof Method ? ((Method) executable).getReturnType() : Void.TYPE);
        for (int i4 = 1; i4 < length; i4++) {
            cArr[i4] = c(parameterTypes[i4 - 1]);
        }
        return cArr;
    }

    public static char c(Class cls) {
        if (cls == Integer.TYPE) {
            return 'I';
        }
        if (cls == Long.TYPE) {
            return 'J';
        }
        if (cls == Float.TYPE) {
            return 'F';
        }
        if (cls == Double.TYPE) {
            return 'D';
        }
        if (cls == Boolean.TYPE) {
            return 'Z';
        }
        if (cls == Byte.TYPE) {
            return 'B';
        }
        if (cls == Character.TYPE) {
            return 'C';
        }
        if (cls == Short.TYPE) {
            return 'S';
        }
        return cls == Void.TYPE ? 'V' : 'L';
    }

    public static void callOnPackageLoaded(XposedModuleInterface.PackageLoadedParam packageLoadedParam) {
        for (XposedModule xposedModule : f41g) {
            try {
                xposedModule.onPackageLoaded(packageLoadedParam);
            } catch (Throwable th) {
                Log.e("LSPosedContext", "Error when calling onPackageLoaded of " + xposedModule.getApplicationInfo().packageName, th);
            }
        }
    }

    public static void callOnSystemServerLoaded(XposedModuleInterface.SystemServerLoadedParam systemServerLoadedParam) {
        for (XposedModule xposedModule : f41g) {
            try {
                xposedModule.onSystemServerLoaded(systemServerLoadedParam);
            } catch (Throwable th) {
                Log.e("LSPosedContext", "Error when calling onSystemServerLoaded of " + xposedModule.getApplicationInfo().packageName, th);
            }
        }
    }

    public static boolean loadModule(ActivityThread activityThread, u0 u0Var) {
        String[] strArr;
        try {
            String str = u0Var.f64416a;
            StringBuilder sb = new StringBuilder();
            for (String str2 : Process.is64Bit() ? Build.SUPPORTED_64_BIT_ABIS : Build.SUPPORTED_32_BIT_ABIS) {
                sb.append(u0Var.f64418c);
                sb.append("!/lib/");
                sb.append(str2);
                sb.append(File.pathSeparator);
            }
            String sb2 = sb.toString();
            ClassLoader classLoader = XposedModule.class.getClassLoader();
            C1474m0 a4 = C1474m0.a(u0Var.f64418c, u0Var.f64419d.f18a, sb2, classLoader);
            if (a4.loadClass(XposedModule.class.getName()).getClassLoader() != classLoader) {
                Log.e("LSPosedContext", "  Cannot load module: " + u0Var.f64416a);
                Log.e("LSPosedContext", "  The Xposed API classes are compiled into the module's APK.");
                Log.e("LSPosedContext", "  This may cause strange issues and must be fixed by the module developer.");
                return false;
            }
            N n4 = new N(u0Var.f64416a, u0Var.f64420e, u0Var.f64421f);
            for (String str3 : u0Var.f64419d.f19b) {
                Class<?> loadClass = a4.loadClass(str3);
                Objects.toString(loadClass);
                if (XposedModule.class.isAssignableFrom(loadClass)) {
                    f41g.add((XposedModule) loadClass.getConstructor(XposedInterface.class, XposedModuleInterface.ModuleLoadedParam.class).newInstance(n4, new Object()));
                } else {
                    Log.e("LSPosedContext", "    This class doesn't implement any sub-interface of XposedModule, skipping it");
                }
            }
            u0Var.f64419d.f20c.forEach(new L(0));
            return true;
        } catch (Throwable unused) {
            String str4 = u0Var.f64416a;
            return false;
        }
    }

    @Override // io.github.libxposed.api.XposedInterface
    public boolean deoptimize(Method method) {
        return a(method);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public ApplicationInfo getApplicationInfo() {
        return this.f43b;
    }

    @Override // io.github.libxposed.api.XposedInterface
    public String getFrameworkName() {
        return "LSPosed";
    }

    @Override // io.github.libxposed.api.XposedInterface
    public int getFrameworkPrivilege() {
        try {
            return ((C1485w) this.f44c).f();
        } catch (RemoteException unused) {
            return -1;
        }
    }

    @Override // io.github.libxposed.api.XposedInterface
    public String getFrameworkVersion() {
        return "1.9.3_mod";
    }

    @Override // io.github.libxposed.api.XposedInterface
    public long getFrameworkVersionCode() {
        return 7244L;
    }

    @Override // io.github.libxposed.api.XposedInterface
    public SharedPreferences getRemotePreferences(String str) {
        if (str != null) {
            return (SharedPreferences) this.f45d.computeIfAbsent(str, new Function() { // from class: M
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    String str2 = (String) obj;
                    N n4 = N.this;
                    n4.getClass();
                    try {
                        return new SharedPreferencesC1344c0(n4.f44c, str2);
                    } catch (RemoteException e4) {
                        n4.log("Failed to get remote preferences", e4);
                        throw new XposedFrameworkError(e4);
                    }
                }
            });
        }
        throw new IllegalArgumentException("name must not be null");
    }

    @Override // io.github.libxposed.api.XposedInterface
    public XposedInterface.MethodUnhooker hook(Method method, Class cls) {
        return K.a(method, 50, cls);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public Object invokeOrigin(Method method, Object obj, Object[] objArr) {
        return HookBridge.invokeOriginalMethod(method, obj, objArr);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public Object invokeSpecial(Method method, Object obj, Object... objArr) {
        if (Modifier.isStatic(method.getModifiers())) {
            throw new IllegalArgumentException("Cannot invoke special on static method: " + method);
        }
        return HookBridge.invokeSpecialMethod(method, b(method), method.getDeclaringClass(), obj, objArr);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public String[] listRemoteFiles() {
        try {
            return ((C1485w) this.f44c).g();
        } catch (RemoteException e4) {
            log("Failed to list remote files", e4);
            throw new XposedFrameworkError(e4);
        }
    }

    @Override // io.github.libxposed.api.XposedInterface
    public void log(String str) {
        Log.i("LSPosedContext", this.f42a + ": " + str);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public Object newInstanceOrigin(Constructor constructor, Object... objArr) {
        Object allocateObject = HookBridge.allocateObject(constructor.getDeclaringClass());
        HookBridge.invokeOriginalMethod(constructor, allocateObject, objArr);
        return allocateObject;
    }

    @Override // io.github.libxposed.api.XposedInterface
    public Object newInstanceSpecial(Constructor constructor, Class cls, Object... objArr) {
        Class declaringClass = constructor.getDeclaringClass();
        if (declaringClass.isAssignableFrom(cls)) {
            Object allocateObject = HookBridge.allocateObject(cls);
            HookBridge.invokeSpecialMethod(constructor, b(constructor), declaringClass, allocateObject, objArr);
            return allocateObject;
        }
        throw new IllegalArgumentException(cls + " is not inherited from " + declaringClass);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public ParcelFileDescriptor openRemoteFile(String str) {
        if (str != null) {
            try {
                return ((C1485w) this.f44c).h(str);
            } catch (RemoteException e4) {
                throw new FileNotFoundException(e4.getMessage());
            }
        }
        throw new IllegalArgumentException("name must not be null");
    }

    @Override // io.github.libxposed.api.XposedInterface
    public DexParser parseDex(ByteBuffer byteBuffer, boolean z3) {
        return new Z(byteBuffer, z3);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public boolean deoptimize(Constructor constructor) {
        return a(constructor);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public XposedInterface.MethodUnhooker hook(Method method, int i4, Class cls) {
        return K.a(method, i4, cls);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public void log(String str, Throwable th) {
        Log.e("LSPosedContext", this.f42a + ": " + str, th);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public XposedInterface.MethodUnhooker hook(Constructor constructor, Class cls) {
        return K.a(constructor, 50, cls);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public XposedInterface.MethodUnhooker hook(Constructor constructor, int i4, Class cls) {
        return K.a(constructor, i4, cls);
    }
}
