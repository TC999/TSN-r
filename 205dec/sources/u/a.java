package u;

import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import com.bxkj.base.util.z;
import com.bxkj.base.v2.common.utils.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AppSecretInfo.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR%\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lu/a;", "", "", "", "paramMap", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f64412a = new a();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, Object> f64413b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appType", "Android");
        TsnSecret tsnSecret = TsnSecret.f16433a;
        BaseApp b4 = BaseApp.b();
        f0.o(b4, "getApp()");
        linkedHashMap.put("versionCode", Integer.valueOf(tsnSecret.getVersionCode(b4)));
        BaseApp b5 = BaseApp.b();
        f0.o(b5, "getApp()");
        linkedHashMap.put("versionName", tsnSecret.getVersionName(b5));
        BaseApp b6 = BaseApp.b();
        f0.o(b6, "getApp()");
        linkedHashMap.put("signatureMD5", tsnSecret.getSignatureMD5(b6));
        linkedHashMap.put("brand", z.d());
        linkedHashMap.put("model", z.e());
        linkedHashMap.put("system", z.f());
        linkedHashMap.put("version", z.c());
        linkedHashMap.put("uniqueCode", o.a(BaseApp.b()));
        f64413b = linkedHashMap;
    }

    private a() {
    }

    @NotNull
    public final Map<String, Object> a() {
        return f64413b;
    }
}
