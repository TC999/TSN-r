package defpackage;

import android.app.ActivityThread;
import android.app.LoadedApk;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.IBinder;
import java.util.List;
import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;

/* renamed from: d0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1456d0 extends XC_MethodHook {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f54619a;

    /* renamed from: b  reason: collision with root package name */
    public Object f54620b;

    public /* synthetic */ C1456d0(int i4, Object obj) {
        this.f54619a = i4;
        this.f54620b = obj;
    }

    private void a(XC_MethodHook.MethodHookParam methodHookParam) {
        AbstractC1457e.d("before install provider");
        int i4 = -1;
        int i5 = 0;
        Context context = null;
        ProviderInfo providerInfo = null;
        while (true) {
            Object[] objArr = methodHookParam.args;
            if (i5 >= objArr.length) {
                break;
            }
            Object obj = objArr[i5];
            if (obj instanceof Context) {
                context = (Context) obj;
                i4 = i5;
            } else if (obj instanceof ProviderInfo) {
                providerInfo = (ProviderInfo) obj;
            }
            i5++;
        }
        PackageInfo b4 = E0.b(null);
        if (context == null || providerInfo == null || b4 == null) {
            AbstractC1457e.e("Failed to reload provider", new RuntimeException());
            return;
        }
        String str = b4.applicationInfo.packageName;
        if (providerInfo.applicationInfo.packageName.equals(str)) {
            if (((Context) this.f54620b) == null) {
                providerInfo.applicationInfo.packageName = str + ".origin";
                LoadedApk packageInfoNoCheck = ActivityThread.currentActivityThread().getPackageInfoNoCheck(providerInfo.applicationInfo, context.getResources().getCompatibilityInfo());
                XposedHelpers.setObjectField(packageInfoNoCheck, "mPackageName", str);
                this.f54620b = (Context) XposedHelpers.callStaticMethod(XposedHelpers.findClass("android.app.ContextImpl", null), "createAppContext", ActivityThread.currentActivityThread(), packageInfoNoCheck);
                providerInfo.applicationInfo.packageName = str;
            }
            methodHookParam.args[i4] = (Context) this.f54620b;
        }
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
    public final void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        switch (this.f54619a) {
            case 0:
                if (((String) methodHookParam.args[0]).equals("LSPosed")) {
                    methodHookParam.setResult((IBinder) this.f54620b);
                    return;
                }
                return;
            default:
                super.afterHookedMethod(methodHookParam);
                return;
        }
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
    public final void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        switch (this.f54619a) {
            case 1:
                a(methodHookParam);
                return;
            case 2:
                Object obj = methodHookParam.args[1];
                if (obj == null) {
                    return;
                }
                for (Intent intent : (List) obj) {
                    E0.a((B) this.f54620b, intent);
                }
                return;
            default:
                super.beforeHookedMethod(methodHookParam);
                return;
        }
    }

    public C1456d0() {
        this.f54619a = 1;
        this.f54620b = null;
    }
}
