package defpackage;

import CyVHHabzCrUqKeyhTwFaxBD.ources;
import android.app.LoadedApk;
import android.util.Log;
import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.annotations.AfterInvocation;
import io.github.libxposed.api.annotations.XposedHooker;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;
import ulL.WeEFDVoZmmWVmW.yXd.XposedInit;

@XposedHooker
/* renamed from: i0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1466i0 implements XposedInterface.Hooker {
    @AfterInvocation
    public static void a(XposedInterface.AfterHookCallback afterHookCallback) {
        AbstractC1457e.d("LoadedApk#<init> starts");
        try {
            LoadedApk loadedApk = (LoadedApk) afterHookCallback.getThisObject();
            String packageName = loadedApk.getPackageName();
            Object objectField = XposedHelpers.getObjectField(loadedApk, "mAppDir");
            AbstractC1457e.d("LoadedApk#<init> ends: " + objectField);
            if (!XposedInit.disableResources) {
                ources.setPackageNameForResDir(packageName, loadedApk.getResDir());
            }
            if (packageName.equals("android")) {
                if (XposedInit.startsSystemServer) {
                    AbstractC1457e.d("LoadedApk#<init> is android, skip: " + objectField);
                    return;
                }
                packageName = "system";
            }
            if (!XposedInit.loadedPackagesInProcess.add(packageName)) {
                AbstractC1457e.d("LoadedApk#<init> has been loaded before, skip: " + objectField);
            } else if (Log.getStackTraceString(new Throwable()).contains("android.app.ActivityThread$ApplicationThread.schedulePreload")) {
                AbstractC1457e.d("LoadedApk#<init> maybe oneplus's custom opt, skip");
            } else {
                C1464h0.f54732b.add(loadedApk);
            }
        } catch (Throwable th) {
            AbstractC1457e.e("error when hooking LoadedApk.<init>", th);
        }
    }
}
