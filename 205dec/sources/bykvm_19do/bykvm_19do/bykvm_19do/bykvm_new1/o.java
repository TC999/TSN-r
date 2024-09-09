package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import java.util.concurrent.Executors;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: OAIDHelper.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f664a = "";

    static {
        Executors.newSingleThreadExecutor();
        try {
            if (TextUtils.isEmpty(f664a)) {
                f664a = r.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, "");
            }
        } catch (Throwable unused) {
        }
    }

    public static String a() {
        try {
            if (TextUtils.isEmpty(f664a)) {
                f664a = w.e();
                if (!TextUtils.isEmpty(f664a)) {
                    r.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).b(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, f664a);
                }
            }
        } catch (Throwable unused) {
        }
        return f664a == null ? "" : f664a;
    }
}
