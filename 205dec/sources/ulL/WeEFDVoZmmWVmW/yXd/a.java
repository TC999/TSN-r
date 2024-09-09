package ulL.WeEFDVoZmmWVmW.yXd;

import java.util.function.Function;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f64422a;

    public /* synthetic */ a(int i4) {
        this.f64422a = i4;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f64422a) {
            case 0:
                return XposedHelpers.d((XposedHelpers.MemberCacheKey.Constructor) obj);
            case 1:
                return XposedHelpers.b((XposedHelpers.MemberCacheKey.Field) obj);
            case 2:
                return XposedHelpers.c((XposedHelpers.MemberCacheKey.Constructor) obj);
            case 3:
                return XposedHelpers.e((XposedHelpers.MemberCacheKey.Method) obj);
            default:
                return XposedHelpers.a((XposedHelpers.MemberCacheKey.Method) obj);
        }
    }
}
