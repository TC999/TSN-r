package defpackage;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.util.ArrayMap;
import java.util.function.BiFunction;
import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;

/* renamed from: f0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1460f0 extends XC_MethodHook {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f54658a;

    public /* synthetic */ C1460f0(int i4) {
        this.f54658a = i4;
    }

    private static void a(XC_MethodHook.MethodHookParam methodHookParam) {
        AbstractC1457e.d("ActivityThread#handleBindApplication() starts");
        Object obj = methodHookParam.args[0];
        XposedHelpers.setObjectField(obj, "appInfo", E0.b((ApplicationInfo) XposedHelpers.getObjectField(obj, "appInfo")).applicationInfo);
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
    public final void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        switch (this.f54658a) {
            case 0:
                if ((((Integer) methodHookParam.args[0]).intValue() & 1) != 0) {
                    methodHookParam.setThrowable(null);
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
        switch (this.f54658a) {
            case 1:
                a(methodHookParam);
                return;
            case 2:
                try {
                    Object obj = methodHookParam.args[0];
                    if ((obj instanceof IBinder) && (obj = ((ArrayMap) XposedHelpers.getObjectField(methodHookParam.thisObject, "mActivities")).get(obj)) == null) {
                        return;
                    }
                    XposedHelpers.callMethod(methodHookParam.thisObject, Build.VERSION.SDK_INT >= 28 ? "callActivityOnSaveInstanceState" : "callCallActivityOnSaveInstanceState", obj);
                    final Bundle bundle = (Bundle) XposedHelpers.getObjectField(obj, "state");
                    final PersistableBundle persistableBundle = (PersistableBundle) XposedHelpers.getObjectField(obj, "persistentState");
                    ActivityInfo activityInfo = (ActivityInfo) XposedHelpers.getObjectField(obj, "activityInfo");
                    E0.f16c.compute(activityInfo.name, new BiFunction() { // from class: D0
                        @Override // java.util.function.BiFunction
                        public final Object apply(Object obj2, Object obj3) {
                            int i4 = r1;
                            Object obj4 = bundle;
                            switch (i4) {
                                case 0:
                                    String str = (String) obj2;
                                    Bundle bundle2 = (Bundle) obj3;
                                    return (Bundle) obj4;
                                default:
                                    String str2 = (String) obj2;
                                    PersistableBundle persistableBundle2 = (PersistableBundle) obj3;
                                    return (PersistableBundle) obj4;
                            }
                        }
                    });
                    E0.f17d.compute(activityInfo.name, new BiFunction() { // from class: D0
                        @Override // java.util.function.BiFunction
                        public final Object apply(Object obj2, Object obj3) {
                            int i4 = r1;
                            Object obj4 = persistableBundle;
                            switch (i4) {
                                case 0:
                                    String str = (String) obj2;
                                    Bundle bundle2 = (Bundle) obj3;
                                    return (Bundle) obj4;
                                default:
                                    String str2 = (String) obj2;
                                    PersistableBundle persistableBundle2 = (PersistableBundle) obj3;
                                    return (PersistableBundle) obj4;
                            }
                        }
                    });
                    AbstractC1457e.d("saving state of " + activityInfo.name);
                    return;
                } catch (Throwable th) {
                    AbstractC1457e.e("save state", th);
                    return;
                }
            default:
                super.beforeHookedMethod(methodHookParam);
                return;
        }
    }
}
