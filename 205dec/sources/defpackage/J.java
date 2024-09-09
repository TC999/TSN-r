package defpackage;

import OcOsO.RddINbhi.wn.EFApGV.EE.r.HookBridge;
import android.util.Log;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;

/* renamed from: J  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class J {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f32a;

    private J(Executable executable) {
        this.f32a = new Object[]{executable, executable instanceof Method ? ((Method) executable).getReturnType() : null, Boolean.valueOf(Modifier.isStatic(executable.getModifiers()))};
    }

    public Object callback(Object[] objArr) {
        XposedBridge.LegacyApiSupport legacyApiSupport;
        C1340a0 c1340a0 = new C1340a0();
        Object[] objArr2 = this.f32a;
        Executable executable = (Executable) objArr2[0];
        Class cls = (Class) objArr2[1];
        c1340a0.f98a = executable;
        if (((Boolean) objArr2[2]).booleanValue()) {
            c1340a0.f99b = null;
            c1340a0.f100c = objArr;
        } else {
            c1340a0.f99b = objArr[0];
            c1340a0.f100c = new Object[objArr.length - 1];
            int i4 = 0;
            while (i4 < objArr.length - 1) {
                int i5 = i4 + 1;
                c1340a0.f100c[i4] = objArr[i5];
                i4 = i5;
            }
        }
        Object[][] callbackSnapshot = HookBridge.callbackSnapshot(I.class, executable);
        Object[] objArr3 = callbackSnapshot[0];
        Object[] objArr4 = callbackSnapshot[1];
        if (objArr3.length == 0 && objArr4.length == 0) {
            try {
                return HookBridge.invokeOriginalMethod(executable, c1340a0.f99b, c1340a0.f100c);
            } catch (InvocationTargetException e4) {
                throw ((Throwable) HookBridge.invokeOriginalMethod(K.f34a, e4, new Object[0]));
            }
        }
        Object[] objArr5 = new Object[objArr3.length];
        int i6 = 0;
        while (true) {
            if (i6 >= objArr3.length) {
                break;
            }
            try {
                I i7 = (I) objArr3[i6];
                if (i7.f29a == 0) {
                    objArr5[i6] = i7.beforeInvocation.invoke(null, new Object[0]);
                } else {
                    objArr5[i6] = i7.beforeInvocation.invoke(null, c1340a0);
                }
            } catch (Throwable th) {
                Method method = K.f34a;
                Log.e(XposedBridge.TAG, Log.getStackTraceString(th));
                c1340a0.setResult(null);
                c1340a0.f103f = false;
            }
            if (c1340a0.f103f) {
                i6++;
                break;
            }
            i6++;
        }
        if (c1340a0.f103f || objArr4.length == 0) {
            legacyApiSupport = null;
        } else {
            XposedBridge.LegacyApiSupport legacyApiSupport2 = new XposedBridge.LegacyApiSupport(c1340a0, objArr4);
            legacyApiSupport2.handleBefore();
            legacyApiSupport = legacyApiSupport2;
        }
        if (!c1340a0.f103f) {
            try {
                c1340a0.setResult(HookBridge.invokeOriginalMethod(executable, c1340a0.f99b, c1340a0.f100c));
            } catch (InvocationTargetException e5) {
                c1340a0.setThrowable((Throwable) HookBridge.invokeOriginalMethod(K.f34a, e5, new Object[0]));
            }
        }
        for (int i8 = i6 - 1; i8 >= 0; i8--) {
            Object result = c1340a0.getResult();
            Throwable throwable = c1340a0.getThrowable();
            I i9 = (I) objArr3[i8];
            try {
                int i10 = i9.f30b;
                if (i10 == 0) {
                    i9.afterInvocation.invoke(null, new Object[0]);
                } else if (i10 == 1) {
                    i9.afterInvocation.invoke(null, c1340a0);
                } else {
                    i9.afterInvocation.invoke(null, c1340a0, objArr5[i8]);
                }
            } catch (Throwable th2) {
                Method method2 = K.f34a;
                Log.e(XposedBridge.TAG, Log.getStackTraceString(th2));
                if (throwable == null) {
                    c1340a0.setResult(result);
                } else {
                    c1340a0.setThrowable(throwable);
                }
            }
        }
        if (legacyApiSupport != null) {
            legacyApiSupport.handleAfter();
        }
        Throwable throwable2 = c1340a0.getThrowable();
        if (throwable2 == null) {
            Object result2 = c1340a0.getResult();
            if (cls == null || cls.isPrimitive() || HookBridge.instanceOf(result2, cls)) {
                return result2;
            }
            throw new ClassCastException("Return value's type from hook callback does not match the hooked method");
        }
        throw throwable2;
    }
}
