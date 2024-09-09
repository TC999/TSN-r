package defpackage;

import android.app.ActivityThread;
import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.annotations.AfterInvocation;
import io.github.libxposed.api.annotations.XposedHooker;
import ulL.WeEFDVoZmmWVmW.yXd.XposedInit;

@XposedHooker
/* renamed from: f  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1459f implements XposedInterface.Hooker {
    @AfterInvocation
    public static void a(XposedInterface.AfterHookCallback afterHookCallback) {
        XposedInit.loadModules((ActivityThread) afterHookCallback.getThisObject());
    }
}
