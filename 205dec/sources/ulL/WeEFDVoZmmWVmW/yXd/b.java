package ulL.WeEFDVoZmmWVmW.yXd;

import java.util.function.Supplier;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public final /* synthetic */ class b implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f64423a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ XposedHelpers.MemberCacheKey f64424b;

    public /* synthetic */ b(XposedHelpers.MemberCacheKey memberCacheKey, int i4) {
        this.f64423a = i4;
        this.f64424b = memberCacheKey;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i4 = this.f64423a;
        XposedHelpers.MemberCacheKey memberCacheKey = this.f64424b;
        switch (i4) {
            case 0:
                return XposedHelpers.lambda$findConstructorBestMatch$9((XposedHelpers.MemberCacheKey.Constructor) memberCacheKey);
            case 1:
                return XposedHelpers.lambda$findConstructorExact$7((XposedHelpers.MemberCacheKey.Constructor) memberCacheKey);
            default:
                return XposedHelpers.lambda$findField$1((XposedHelpers.MemberCacheKey.Field) memberCacheKey);
        }
    }
}
