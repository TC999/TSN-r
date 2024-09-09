package ulL.WeEFDVoZmmWVmW.yXd;

import java.util.function.Supplier;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public final /* synthetic */ class c implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f64425a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ XposedHelpers.MemberCacheKey.Method f64426b;

    public /* synthetic */ c(XposedHelpers.MemberCacheKey.Method method, int i4) {
        this.f64425a = i4;
        this.f64426b = method;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i4 = this.f64425a;
        XposedHelpers.MemberCacheKey.Method method = this.f64426b;
        switch (i4) {
            case 0:
                return XposedHelpers.lambda$findMethodBestMatch$5(method);
            default:
                return XposedHelpers.lambda$findMethodExact$3(method);
        }
    }
}
