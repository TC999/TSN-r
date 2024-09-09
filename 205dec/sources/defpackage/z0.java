package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.util.Log;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.BiFunction;
import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;

/* renamed from: z0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class z0 extends XC_MethodHook {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f65071a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ B f65072b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Serializable f65073c;

    public /* synthetic */ z0(B b4, Serializable serializable, int i4) {
        this.f65071a = i4;
        this.f65072b = b4;
        this.f65073c = serializable;
    }

    private void a(XC_MethodHook.MethodHookParam methodHookParam) {
        PackageInfo b4 = E0.b(null);
        if (b4 == null || XposedHelpers.getObjectField(methodHookParam.thisObject, "mApplicationInfo") != b4.applicationInfo) {
            return;
        }
        String str = b4.applicationInfo.sourceDir;
        Object result = methodHookParam.getResult();
        AbstractC1457e.d("LoadedApk getClassLoader " + result);
        if (!((List) XposedHelpers.callMethod(XposedHelpers.getObjectField(result, "pathList"), "getDexPaths", new Object[0])).contains(str)) {
            boolean z3 = K0.f35a;
            Log.w("LSPosed", "Could not find manager apk injected in classloader");
            XposedHelpers.callMethod(result, "addDexPath", str);
        }
        try {
        } catch (Throwable th) {
            boolean z4 = K0.f35a;
            Log.w("LSPosed", "Could not send binder to LSPosed Manager", th);
        }
        if (!((Boolean) XposedHelpers.callStaticMethod(XposedHelpers.findClass("org.lsposed.manager.Constants", (ClassLoader) result), "setBinder", new Class[]{IBinder.class}, ((C1488z) this.f65072b).f65070a)).booleanValue()) {
            throw new RuntimeException("setBinder: false");
        }
        ((XC_MethodHook.Unhook[]) this.f65073c)[0].unhook();
    }

    private void b(final XC_MethodHook.MethodHookParam methodHookParam) {
        ActivityInfo[] activityInfoArr;
        int i4 = 0;
        while (true) {
            Object[] objArr = methodHookParam.args;
            if (i4 >= objArr.length) {
                if (methodHookParam.method.getName().equals("scheduleLaunchActivity")) {
                    Class<?>[] parameterTypes = ((Method) methodHookParam.method).getParameterTypes();
                    ActivityInfo activityInfo = null;
                    for (final int i5 = 0; i5 < parameterTypes.length; i5++) {
                        Class<?> cls = parameterTypes[i5];
                        if (cls == ActivityInfo.class) {
                            activityInfo = (ActivityInfo) methodHookParam.args[i5];
                            AbstractC1457e.d("loading state of " + activityInfo.name);
                        } else if (cls == Bundle.class && activityInfo != null) {
                            E0.f16c.computeIfPresent(activityInfo.name, new BiFunction() { // from class: A0
                                @Override // java.util.function.BiFunction
                                public final Object apply(Object obj, Object obj2) {
                                    int i6 = r3;
                                    int i7 = i5;
                                    XC_MethodHook.MethodHookParam methodHookParam2 = methodHookParam;
                                    switch (i6) {
                                        case 0:
                                            String str = (String) obj;
                                            Bundle bundle = (Bundle) obj2;
                                            methodHookParam2.args[i7] = bundle;
                                            return bundle;
                                        default:
                                            String str2 = (String) obj;
                                            PersistableBundle persistableBundle = (PersistableBundle) obj2;
                                            methodHookParam2.args[i7] = persistableBundle;
                                            return persistableBundle;
                                    }
                                }
                            });
                        } else if (cls == PersistableBundle.class && activityInfo != null) {
                            E0.f17d.computeIfPresent(activityInfo.name, new BiFunction() { // from class: A0
                                @Override // java.util.function.BiFunction
                                public final Object apply(Object obj, Object obj2) {
                                    int i6 = r3;
                                    int i7 = i5;
                                    XC_MethodHook.MethodHookParam methodHookParam2 = methodHookParam;
                                    switch (i6) {
                                        case 0:
                                            String str = (String) obj;
                                            Bundle bundle = (Bundle) obj2;
                                            methodHookParam2.args[i7] = bundle;
                                            return bundle;
                                        default:
                                            String str2 = (String) obj;
                                            PersistableBundle persistableBundle = (PersistableBundle) obj2;
                                            methodHookParam2.args[i7] = persistableBundle;
                                            return persistableBundle;
                                    }
                                }
                            });
                        }
                    }
                    return;
                }
                return;
            }
            Object obj = objArr[i4];
            if (obj instanceof ActivityInfo) {
                PackageInfo b4 = E0.b(((ActivityInfo) obj).applicationInfo);
                if (b4 == null) {
                    return;
                }
                for (ActivityInfo activityInfo2 : b4.activities) {
                    if ("org.lsposed.manager.ui.activity.MainActivity".equals(activityInfo2.name)) {
                        activityInfo2.applicationInfo = b4.applicationInfo;
                        methodHookParam.args[i4] = activityInfo2;
                    }
                }
            }
            Object obj2 = methodHookParam.args[i4];
            if (obj2 instanceof Intent) {
                Intent intent = (Intent) obj2;
                E0.a(this.f65072b, intent);
                intent.setComponent(new ComponentName(intent.getComponent().getPackageName(), "org.lsposed.manager.ui.activity.MainActivity"));
            }
            i4++;
        }
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
    public final void afterHookedMethod(final XC_MethodHook.MethodHookParam methodHookParam) {
        switch (this.f65071a) {
            case 0:
                a(methodHookParam);
                return;
            default:
                for (int i4 = 0; i4 < methodHookParam.args.length && ((Class) this.f65073c).isInstance(methodHookParam.thisObject); i4++) {
                    Object obj = methodHookParam.args[i4];
                    if (obj instanceof ActivityInfo) {
                        ActivityInfo activityInfo = (ActivityInfo) obj;
                        AbstractC1457e.d("loading state of " + activityInfo.name);
                        E0.f16c.computeIfPresent(activityInfo.name, new BiFunction() { // from class: B0
                            @Override // java.util.function.BiFunction
                            public final Object apply(Object obj2, Object obj3) {
                                int i5 = r2;
                                XC_MethodHook.MethodHookParam methodHookParam2 = methodHookParam;
                                switch (i5) {
                                    case 0:
                                        String str = (String) obj2;
                                        Bundle bundle = (Bundle) obj3;
                                        XposedHelpers.setObjectField(methodHookParam2.thisObject, "state", bundle);
                                        return bundle;
                                    default:
                                        String str2 = (String) obj2;
                                        PersistableBundle persistableBundle = (PersistableBundle) obj3;
                                        XposedHelpers.setObjectField(methodHookParam2.thisObject, "persistentState", persistableBundle);
                                        return persistableBundle;
                                }
                            }
                        });
                        E0.f17d.computeIfPresent(activityInfo.name, new BiFunction() { // from class: B0
                            @Override // java.util.function.BiFunction
                            public final Object apply(Object obj2, Object obj3) {
                                int i5 = r2;
                                XC_MethodHook.MethodHookParam methodHookParam2 = methodHookParam;
                                switch (i5) {
                                    case 0:
                                        String str = (String) obj2;
                                        Bundle bundle = (Bundle) obj3;
                                        XposedHelpers.setObjectField(methodHookParam2.thisObject, "state", bundle);
                                        return bundle;
                                    default:
                                        String str2 = (String) obj2;
                                        PersistableBundle persistableBundle = (PersistableBundle) obj3;
                                        XposedHelpers.setObjectField(methodHookParam2.thisObject, "persistentState", persistableBundle);
                                        return persistableBundle;
                                }
                            }
                        });
                    }
                }
                return;
        }
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
    public final void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        switch (this.f65071a) {
            case 1:
                b(methodHookParam);
                return;
            default:
                super.beforeHookedMethod(methodHookParam);
                return;
        }
    }
}
