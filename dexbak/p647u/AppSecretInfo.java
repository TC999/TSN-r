package p647u;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import com.bxkj.base.p085v2.common.utils.OpenUDID;
import com.bxkj.base.util.SystemUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR%\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m12616d2 = {"Lu/a;", "", "", "", "paramMap", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: u.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AppSecretInfo {
    @NotNull

    /* renamed from: a */
    public static final AppSecretInfo f47135a = new AppSecretInfo();
    @NotNull

    /* renamed from: b */
    private static final Map<String, Object> f47136b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appType", "Android");
        TsnSecret tsnSecret = TsnSecret.f13210a;
        BaseApp m44341b = BaseApp.m44341b();
        C14342f0.m8185o(m44341b, "getApp()");
        linkedHashMap.put(TTDownloadField.TT_VERSION_CODE, Integer.valueOf(tsnSecret.getVersionCode(m44341b)));
        BaseApp m44341b2 = BaseApp.m44341b();
        C14342f0.m8185o(m44341b2, "getApp()");
        linkedHashMap.put(TTDownloadField.TT_VERSION_NAME, tsnSecret.getVersionName(m44341b2));
        BaseApp m44341b3 = BaseApp.m44341b();
        C14342f0.m8185o(m44341b3, "getApp()");
        linkedHashMap.put("signatureMD5", tsnSecret.getSignatureMD5(m44341b3));
        linkedHashMap.put(C2624bk.f8686j, SystemUtils.m44002d());
        linkedHashMap.put(C2624bk.f8685i, SystemUtils.m44001e());
        linkedHashMap.put(ConstantHelper.LOG_OS, SystemUtils.m44000f());
        linkedHashMap.put(ConstantHelper.LOG_VS, SystemUtils.m44003c());
        linkedHashMap.put("uniqueCode", OpenUDID.m43752a(BaseApp.m44341b()));
        f47136b = linkedHashMap;
    }

    private AppSecretInfo() {
    }

    @NotNull
    /* renamed from: a */
    public final Map<String, Object> m247a() {
        return f47136b;
    }
}
