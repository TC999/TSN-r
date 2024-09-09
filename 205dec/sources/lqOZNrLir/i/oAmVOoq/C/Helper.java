package lqOZNrLir.i.oAmVOoq.C;

import android.app.ActivityThread;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.Map;
import ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class Helper {
    private static final Class CLASS_RESOURCES_KEY;
    private static final boolean HAS_IS_THEMEABLE;
    private static final boolean HAS_THEME_CONFIG_PARAMETER;

    static {
        Class findClass = XposedHelpers.findClass("android.content.res.ResourcesKey", null);
        CLASS_RESOURCES_KEY = findClass;
        boolean z3 = true;
        boolean z4 = XposedHelpers.findFieldIfExists(findClass, "mIsThemeable") != null;
        HAS_IS_THEMEABLE = z4;
        if (!z4 || XposedHelpers.findMethodExactIfExists("android.app.ResourcesManager", null, "getThemeConfig", new Object[0]) == null) {
            z3 = false;
        }
        HAS_THEME_CONFIG_PARAMETER = z3;
    }

    private Helper() {
    }

    public static void addActiveResource(String str, float f4, boolean z3, Resources resources) {
        addActiveResource(str, resources);
    }

    private static Object createResourcesKey(String str, String[] strArr, String[] strArr2, String[] strArr3, int i4, Configuration configuration, CompatibilityInfo compatibilityInfo) {
        try {
            return XposedHelpers.newInstance(CLASS_RESOURCES_KEY, str, strArr, strArr2, strArr3, Integer.valueOf(i4), configuration, compatibilityInfo);
        } catch (Throwable th) {
            XposedBridge.log(th);
            return null;
        }
    }

    public static Application currentApplication() {
        return ActivityThread.currentApplication();
    }

    public static ApplicationInfo currentApplicationInfo() {
        Object objectField;
        ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
        if (currentActivityThread == null || (objectField = XposedHelpers.getObjectField(currentActivityThread, "mBoundApplication")) == null) {
            return null;
        }
        return (ApplicationInfo) XposedHelpers.getObjectField(objectField, "appInfo");
    }

    public static String currentPackageName() {
        ApplicationInfo currentApplicationInfo = currentApplicationInfo();
        return currentApplicationInfo != null ? currentApplicationInfo.packageName : "android";
    }

    public static String currentProcessName() {
        String currentPackageName = ActivityThread.currentPackageName();
        return currentPackageName == null ? "android" : currentPackageName;
    }

    @Deprecated
    public static SharedPreferences getDefaultSharedPreferencesForPackage(String str) {
        return new XSharedPreferences(str);
    }

    private static Map getResourcesMap(ActivityThread activityThread) {
        return (Map) XposedHelpers.getObjectField(XposedHelpers.getObjectField(activityThread, "mResourcesManager"), "mResourceImpls");
    }

    @Deprecated
    public static SharedPreferences getSharedPreferencesForPackage(String str, String str2, int i4) {
        return new XSharedPreferences(str, str2);
    }

    @Deprecated
    public static void reloadSharedPreferencesIfNeeded(SharedPreferences sharedPreferences) {
        if (sharedPreferences instanceof XSharedPreferences) {
            ((XSharedPreferences) sharedPreferences).reload();
        }
    }

    public static void addActiveResource(String str, Resources resources) {
        ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
        if (currentActivityThread == null) {
            return;
        }
        CompatibilityInfo compatibilityInfo = (CompatibilityInfo) XposedHelpers.newInstance(CompatibilityInfo.class, new Object[0]);
        XposedHelpers.setFloatField(compatibilityInfo, "applicationScale", resources.hashCode());
        Object createResourcesKey = createResourcesKey(str, null, null, null, 0, null, compatibilityInfo);
        if (createResourcesKey != null) {
            getResourcesMap(currentActivityThread).put(createResourcesKey, new WeakReference(XposedHelpers.getObjectField(resources, "mResourcesImpl")));
        }
    }
}
