package io.github.libxposed.api;

import android.content.pm.ApplicationInfo;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public interface XposedModuleInterface {

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface ModuleLoadedParam {
        String getProcessName();

        boolean isSystemServer();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface PackageLoadedParam {
        ApplicationInfo getApplicationInfo();

        ClassLoader getClassLoader();

        ClassLoader getDefaultClassLoader();

        String getPackageName();

        boolean isFirstPackage();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface SystemServerLoadedParam {
        ClassLoader getClassLoader();
    }

    default void onPackageLoaded(PackageLoadedParam packageLoadedParam) {
    }

    default void onSystemServerLoaded(SystemServerLoadedParam systemServerLoadedParam) {
    }
}
