package defpackage;

import java.io.File;
import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook;
import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodReplacement;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_LoadPackage;

/* renamed from: g0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1462g0 extends XC_MethodReplacement {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XC_LoadPackage.LoadPackageParam f54716a;

    public C1462g0(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        this.f54716a = loadPackageParam;
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodReplacement
    public final Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        return new File(C1455d.f54605b.e(this.f54716a.packageName));
    }
}
