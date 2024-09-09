package defpackage;

import android.app.LoadedApk;
import android.content.pm.ApplicationInfo;
import io.github.libxposed.api.XposedModuleInterface;

/* renamed from: e0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1458e0 implements XposedModuleInterface.PackageLoadedParam {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoadedApk f54640a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClassLoader f54641b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f54642c;

    public C1458e0(LoadedApk loadedApk, ClassLoader classLoader, boolean z3) {
        this.f54640a = loadedApk;
        this.f54641b = classLoader;
        this.f54642c = z3;
    }

    @Override // io.github.libxposed.api.XposedModuleInterface.PackageLoadedParam
    public final ApplicationInfo getApplicationInfo() {
        return this.f54640a.getApplicationInfo();
    }

    @Override // io.github.libxposed.api.XposedModuleInterface.PackageLoadedParam
    public final ClassLoader getClassLoader() {
        return this.f54641b;
    }

    @Override // io.github.libxposed.api.XposedModuleInterface.PackageLoadedParam
    public final ClassLoader getDefaultClassLoader() {
        try {
            return (ClassLoader) C1464h0.f54731a.get(this.f54640a);
        } catch (Throwable th) {
            throw new IllegalStateException(th);
        }
    }

    @Override // io.github.libxposed.api.XposedModuleInterface.PackageLoadedParam
    public final String getPackageName() {
        return this.f54640a.getPackageName();
    }

    @Override // io.github.libxposed.api.XposedModuleInterface.PackageLoadedParam
    public final boolean isFirstPackage() {
        return this.f54642c;
    }
}
