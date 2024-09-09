package defpackage;

import OcOsO.RddINbhi.wn.EFApGV.EE.r.HookBridge;
import io.github.libxposed.api.XposedInterface;
import java.lang.reflect.Executable;

/* renamed from: H  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class H implements XposedInterface.MethodUnhooker {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executable f27a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ I f28b;

    public H(Executable executable, I i4) {
        this.f27a = executable;
        this.f28b = i4;
    }

    @Override // io.github.libxposed.api.XposedInterface.MethodUnhooker
    public final Object getOrigin() {
        return this.f27a;
    }

    @Override // io.github.libxposed.api.XposedInterface.MethodUnhooker
    public final void unhook() {
        HookBridge.unhookMethod(true, this.f27a, this.f28b);
    }
}
