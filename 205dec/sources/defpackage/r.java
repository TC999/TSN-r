package defpackage;

import android.util.Log;
import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.annotations.BeforeInvocation;
import io.github.libxposed.api.annotations.XposedHooker;
import java.lang.reflect.Method;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;

@XposedHooker
/* renamed from: r  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class r implements XposedInterface.Hooker {
    @BeforeInvocation
    public static void a(XposedInterface.BeforeHookCallback beforeHookCallback) {
        try {
            Method method = K.f34a;
            Log.i(XposedBridge.TAG, "Crash unexpectedly: " + Log.getStackTraceString((Throwable) beforeHookCallback.getArgs()[0]));
        } catch (Throwable unused) {
        }
    }
}
