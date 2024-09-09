package defpackage;

import OcOsO.RddINbhi.wn.EFApGV.EE.r.HookBridge;
import android.app.ActivityThread;
import android.app.LoadedApk;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.os.ZygoteInit;
import dalvik.system.DexFile;
import io.github.libxposed.api.errors.HookFailedError;
import java.io.PrintStream;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;

/* renamed from: e  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class AbstractC1457e {

    /* renamed from: a  reason: collision with root package name */
    public static final Class[] f54630a = new Class[0];

    /* renamed from: b  reason: collision with root package name */
    public static final Object[] f54631b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f54632c;

    public static void a(String str, ClassLoader classLoader) {
        Object[][] objArr = (Object[][]) G.f22a.get(str);
        if (objArr == null) {
            return;
        }
        for (Object[] objArr2 : objArr) {
            try {
                if (objArr2.length >= 2 && (objArr2[0] instanceof String) && (objArr2[1] instanceof String)) {
                    int length = objArr2.length - 2;
                    Object[] objArr3 = new Object[length];
                    System.arraycopy(objArr2, 2, objArr3, 0, length);
                    Executable findConstructorExactIfExists = "<init>".equals(objArr2[1]) ? XposedHelpers.findConstructorExactIfExists((String) objArr2[0], classLoader, objArr3) : XposedHelpers.findMethodExactIfExists((String) objArr2[0], classLoader, (String) objArr2[1], objArr3);
                    if (findConstructorExactIfExists != null) {
                        d("deoptimizing " + findConstructorExactIfExists);
                        HookBridge.deoptimizeMethod(findConstructorExactIfExists);
                    }
                }
            } catch (Throwable th) {
                K0.a("error when deopting method: " + Arrays.toString(objArr2), th);
            }
        }
    }

    public static Parcel b(long j4) {
        RuntimeException runtimeException;
        if (j4 == 0) {
            return null;
        }
        if (f54632c == null) {
            try {
                Method declaredMethod = Parcel.class.getDeclaredMethod("obtain", Long.TYPE);
                f54632c = declaredMethod;
                declaredMethod.setAccessible(true);
            } finally {
            }
        }
        try {
            return (Parcel) f54632c.invoke(null, Long.valueOf(j4));
        } finally {
        }
    }

    public static void c(Class cls, Class cls2, String str) {
        Method[] declaredMethods;
        HashSet hashSet = new HashSet();
        for (Method method : cls2.getDeclaredMethods()) {
            if (method.getName().equals(str)) {
                hashSet.add(K.a(method, 50, cls));
            }
        }
    }

    public static void d(String str) {
        String format = String.format("%s: pkg=%s, prc=%s", str, ActivityThread.currentPackageName(), ActivityThread.currentProcessName());
        boolean z3 = K0.f35a;
        format.toString();
    }

    public static void e(String str, Throwable th) {
        K0.a(String.format("%s: pkg=%s, prc=%s", str, ActivityThread.currentPackageName(), ActivityThread.currentProcessName()), th);
    }

    public static Object f(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static Object g(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static Object h(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static Object i(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static final void j(String str) {
        PrintStream printStream = System.err;
        printStream.println("SLF4J: " + str);
    }

    public static final void k(String str, Throwable th) {
        PrintStream printStream = System.err;
        printStream.println(str);
        printStream.println("Reported exception:");
        th.printStackTrace();
    }

    public static boolean l(Parcel parcel, String str) {
        try {
            parcel.enforceInterface(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void m(boolean z3) {
        boolean z4 = K0.f35a;
        ("startBootstrapHook starts: isSystem = " + z3).getClass();
        try {
            K.a(Thread.class.getDeclaredMethod("dispatchUncaughtException", Throwable.class), 50, r.class);
            if (z3) {
                c(C1481s.class, ZygoteInit.class, "handleSystemServerProcess");
            } else {
                c(y0.class, DexFile.class, "openDexFile");
                c(y0.class, DexFile.class, "openInMemoryDexFile");
                c(y0.class, DexFile.class, "openInMemoryDexFiles");
            }
            Class cls = Boolean.TYPE;
            try {
                K.a(LoadedApk.class.getDeclaredConstructor(ActivityThread.class, ApplicationInfo.class, CompatibilityInfo.class, ClassLoader.class, cls, cls, cls), 50, C1466i0.class);
                try {
                    K.a(LoadedApk.class.getDeclaredMethod("createOrUpdateClassLoaderLocked", List.class), 50, C1464h0.class);
                    c(C1459f.class, ActivityThread.class, "attach");
                } catch (NoSuchMethodException e4) {
                    throw new HookFailedError(e4);
                }
            } catch (NoSuchMethodException e5) {
                throw new HookFailedError(e5);
            }
        } catch (NoSuchMethodException e6) {
            throw new HookFailedError(e6);
        }
    }

    public static void n(Parcel parcel, ArrayList arrayList, int i4) {
        if (arrayList == null) {
            parcel.writeInt(-1);
            return;
        }
        int size = arrayList.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            q(parcel, (Parcelable) arrayList.get(i5), i4);
        }
    }

    public static void o(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void p(Parcel parcel, Parcelable parcelable, int i4) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, i4);
    }

    public static void q(Parcel parcel, Parcelable parcelable, int i4) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, i4);
    }

    public static void r(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
