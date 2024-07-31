package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AES;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AESKey;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.SPUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TestHelperUtils;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class URLConst {

    /* renamed from: a */
    private static String f558a;

    /* renamed from: b */
    private static String f559b;

    /* renamed from: a */
    public static String m59449a() {
        return TestHelperUtils.m59262a("https://" + InternalContainer.m59943f().m59742f());
    }

    /* renamed from: b */
    public static String m59448b() {
        return TestHelperUtils.m59262a(m59447c() + "/api/ad/union/mediation/exchange/");
    }

    /* renamed from: c */
    private static String m59447c() {
        String m59445e = m59445e();
        return !TextUtils.isEmpty(m59445e) ? m59445e : "https://pangolin.snssdk.com";
    }

    /* renamed from: d */
    public static String m59446d() {
        return TestHelperUtils.m59262a(m59447c() + "/api/ad/union/mediation/stats/");
    }

    /* renamed from: e */
    private static String m59445e() {
        String m59120d = SPUtils.m59131a("tt_sdk_settings", InternalContainer.m59945d()).m59120d("server_dist_host");
        if (TextUtils.isEmpty(m59120d)) {
            return null;
        }
        if (TextUtils.equals(m59120d, f558a) && !TextUtils.isEmpty(f559b)) {
            return f559b;
        }
        f558a = m59120d;
        f559b = null;
        if (!TextUtils.isEmpty(m59120d)) {
            f559b = AES.m59265a(f558a, AESKey.m59260a());
        }
        if (TextUtils.isEmpty(f559b)) {
            return null;
        }
        String str = "https://" + f559b;
        f559b = str;
        return str;
    }

    /* renamed from: f */
    public static String m59444f() {
        return TestHelperUtils.m59262a(m59447c() + "/api/ad/union/mediation/config/");
    }
}
