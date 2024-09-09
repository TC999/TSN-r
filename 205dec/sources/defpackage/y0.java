package defpackage;

import OcOsO.RddINbhi.wn.EFApGV.EE.r.HookBridge;
import android.os.Build;
import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.annotations.AfterInvocation;
import io.github.libxposed.api.annotations.XposedHooker;

@XposedHooker
/* renamed from: y0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class y0 implements XposedInterface.Hooker {
    @AfterInvocation
    public static void a(XposedInterface.AfterHookCallback afterHookCallback) {
        Object[] args;
        ClassLoader classLoader = null;
        for (Object obj : afterHookCallback.getArgs()) {
            if (obj instanceof ClassLoader) {
                classLoader = (ClassLoader) obj;
            }
        }
        if (Build.VERSION.SDK_INT == 28 && classLoader == null) {
            classLoader = K.class.getClassLoader();
        }
        while (classLoader != null) {
            if (classLoader == K.class.getClassLoader()) {
                HookBridge.setTrusted(afterHookCallback.getResult());
                return;
            }
            classLoader = classLoader.getParent();
        }
    }
}
