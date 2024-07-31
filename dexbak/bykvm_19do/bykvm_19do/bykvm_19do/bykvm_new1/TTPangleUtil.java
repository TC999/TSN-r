package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.os.Bundle;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.IDataObserver;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.umeng.ccg.CcgConstant;
import java.lang.reflect.Field;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.w */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTPangleUtil {

    /* renamed from: a */
    private static boolean f687a = false;

    /* renamed from: b */
    private static boolean f688b = true;

    /* compiled from: TTPangleUtil.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.w$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C0989a implements IDataObserver {
        C0989a() {
        }

        public void onIdLoaded(String str, String str2, String str3) {
            Logger.m37554i("TTMediationSDK", "pangel_applog_did=" + str);
            IdUtils.m59200a(InternalContainer.m59945d(), str);
        }

        public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
        }

        public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
        }

        public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        }
    }

    /* renamed from: a */
    private static String m59106a() {
        Bundle bundle = new Bundle();
        bundle.putInt(CcgConstant.f38549t, 2);
        String str = (String) TTAdSdk.getAdManager().getExtra(String.class, bundle);
        Logger.m37557e("TTMediationSDK", "pangel_getDidByFour:" + str);
        return str;
    }

    /* renamed from: b */
    public static String m59104b() {
        if (m59093k()) {
            return m59106a();
        }
        return m59102c();
    }

    /* renamed from: c */
    private static String m59102c() {
        String did = AppLog.getDid();
        Logger.m37557e("TTMediationSDK", "pangel_getDidByThree:" + did);
        return did;
    }

    /* renamed from: d */
    private static String m59100d() {
        Bundle bundle = new Bundle();
        bundle.putInt(CcgConstant.f38549t, 3);
        String str = (String) TTAdSdk.getAdManager().getExtra(String.class, bundle);
        Logger.m37557e("TTMediationSDK", "pangel_getOaidByFour:" + str);
        return str;
    }

    /* renamed from: e */
    public static String m59099e() {
        if (m59093k()) {
            return m59100d();
        }
        return m59098f();
    }

    /* renamed from: f */
    private static String m59098f() {
        try {
            String m59130a = SPUtils.m59131a("ttopenadsdk", InternalContainer.m59945d()).m59130a("oaid", "");
            Logger.m37557e("TTMediationSDK", "pangel_getOaidByThree:" + m59130a);
            return m59130a;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: g */
    private static boolean m59097g() {
        try {
            return Integer.valueOf(TTAdSdk.getAdManager().getSDKVersion().replaceAll("\\.", "")).intValue() >= 4100;
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: h */
    private static boolean m59096h() {
        try {
            String sDKVersion = TTAdSdk.getAdManager().getSDKVersion();
            if (TextUtils.isEmpty(sDKVersion)) {
                return true;
            }
            return sDKVersion.charAt(0) >= '4';
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: i */
    private static boolean m59095i() {
        if (f687a) {
            return f688b;
        }
        try {
            Class<?> cls = Class.forName("com.bytedance.sdk.openadsdk.TTAdConstant");
            Field declaredField = cls.getDeclaredField("IS_P");
            declaredField.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredField.get(cls)).booleanValue();
            f688b = booleanValue;
            f687a = true;
            return booleanValue;
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: j */
    public static void m59094j() {
        if (m59093k()) {
            return;
        }
        AppLog.addDataObserver(new C0989a());
    }

    /* renamed from: k */
    private static boolean m59093k() {
        if (m59095i()) {
            return m59096h();
        }
        return m59097g();
    }

    /* renamed from: c */
    private static byte[] m59101c(byte[] bArr, int i) {
        Logger.m37557e("TTMediationSDK", "pangel_encryptByThree......");
        return TTEncryptUtils.a(bArr, i);
    }

    /* renamed from: b */
    public static byte[] m59103b(byte[] bArr, int i) {
        if (m59093k()) {
            return m59105a(bArr, i);
        }
        return m59101c(bArr, i);
    }

    /* renamed from: a */
    private static byte[] m59105a(byte[] bArr, int i) {
        Logger.m37557e("TTMediationSDK", "pangel_encryptByFour......");
        return EncryptorUtil.encrypt(bArr, i);
    }
}
