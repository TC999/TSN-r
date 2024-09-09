package io.github.libxposed.api;

import io.github.libxposed.api.XposedModuleInterface;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class XposedModule extends XposedInterfaceWrapper implements XposedModuleInterface {
    public XposedModule(XposedInterface xposedInterface, XposedModuleInterface.ModuleLoadedParam moduleLoadedParam) {
        super(xposedInterface);
    }
}
