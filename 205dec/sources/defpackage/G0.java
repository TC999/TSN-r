package defpackage;

import io.github.libxposed.api.XposedModuleInterface;
import org.slf4j.ILoggerFactory;

/* renamed from: G0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class G0 implements XposedModuleInterface.SystemServerLoadedParam, XposedModuleInterface.ModuleLoadedParam, ILoggerFactory {
    @Override // org.slf4j.ILoggerFactory
    public void a(String str) {
    }

    @Override // io.github.libxposed.api.XposedModuleInterface.SystemServerLoadedParam
    public ClassLoader getClassLoader() {
        return C1481s.f64365a;
    }

    @Override // io.github.libxposed.api.XposedModuleInterface.ModuleLoadedParam
    public String getProcessName() {
        return N.f40f;
    }

    @Override // io.github.libxposed.api.XposedModuleInterface.ModuleLoadedParam
    public boolean isSystemServer() {
        return N.f39e;
    }
}
