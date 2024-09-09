package defpackage;

import OcOsO.RddINbhi.wn.EFApGV.EE.r.NativeAPI;
import java.util.function.Consumer;
import ulL.WeEFDVoZmmWVmW.yXd.XposedInit;

/* renamed from: O0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final /* synthetic */ class O0 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f52a;

    public /* synthetic */ O0(int i4) {
        this.f52a = i4;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f52a) {
            case 0:
                XposedInit.b((u0) obj);
                return;
            default:
                NativeAPI.recordNativeEntrypoint((String) obj);
                return;
        }
    }
}
