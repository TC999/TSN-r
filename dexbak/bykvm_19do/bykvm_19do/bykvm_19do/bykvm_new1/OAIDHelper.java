package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import java.util.concurrent.Executors;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.o */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class OAIDHelper {

    /* renamed from: a */
    private static volatile String f671a = "";

    static {
        Executors.newSingleThreadExecutor();
        try {
            if (TextUtils.isEmpty(f671a)) {
                f671a = SPUtils.m59131a("tt_device_info", InternalContainer.m59945d()).m59130a("oaid", "");
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static String m59164a() {
        try {
            if (TextUtils.isEmpty(f671a)) {
                f671a = TTPangleUtil.m59099e();
                if (!TextUtils.isEmpty(f671a)) {
                    SPUtils.m59131a("tt_device_info", InternalContainer.m59945d()).m59123b("oaid", f671a);
                }
            }
        } catch (Throwable unused) {
        }
        return f671a == null ? "" : f671a;
    }
}
