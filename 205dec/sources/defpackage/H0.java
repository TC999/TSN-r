package defpackage;

import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.annotations.BeforeInvocation;
import io.github.libxposed.api.annotations.XposedHooker;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;
import ulL.WeEFDVoZmmWVmW.yXd.XposedInit;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_LoadPackage;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XCallback;

@XposedHooker
/* renamed from: H0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class H0 implements XposedInterface.Hooker {
    /* JADX WARN: Type inference failed for: r0v5, types: [io.github.libxposed.api.XposedModuleInterface$SystemServerLoadedParam, java.lang.Object] */
    @BeforeInvocation
    public static void a() {
        boolean z3 = K0.f35a;
        try {
            XposedInit.loadedPackagesInProcess.add("android");
            XC_LoadPackage.LoadPackageParam loadPackageParam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
            loadPackageParam.packageName = "android";
            loadPackageParam.processName = "android";
            loadPackageParam.classLoader = C1481s.f64365a;
            loadPackageParam.appInfo = null;
            loadPackageParam.isFirstApplication = true;
            XCallback.callAll(loadPackageParam);
            N.callOnSystemServerLoaded(new Object());
        } catch (Throwable th) {
            AbstractC1457e.e("error when hooking startBootstrapServices", th);
        }
    }
}
