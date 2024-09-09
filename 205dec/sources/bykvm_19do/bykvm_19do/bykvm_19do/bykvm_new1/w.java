package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.IDataObserver;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.lang.reflect.Field;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: TTPangleUtil.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f680a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f681b = true;

    /* compiled from: TTPangleUtil.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class a implements IDataObserver {
        a() {
        }

        @Override // com.bytedance.embedapplog.IDataObserver
        public void onIdLoaded(String str, String str2, String str3) {
            Logger.i("TTMediationSDK", "pangel_applog_did=" + str);
            k.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), str);
        }

        @Override // com.bytedance.embedapplog.IDataObserver
        public void onRemoteAbConfigGet(boolean z3, JSONObject jSONObject) {
        }

        @Override // com.bytedance.embedapplog.IDataObserver
        public void onRemoteConfigGet(boolean z3, JSONObject jSONObject) {
        }

        @Override // com.bytedance.embedapplog.IDataObserver
        public void onRemoteIdGet(boolean z3, String str, String str2, String str3, String str4, String str5, String str6) {
        }
    }

    private static String a() {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 2);
        String str = (String) TTAdSdk.getAdManager().getExtra(String.class, bundle);
        Logger.e("TTMediationSDK", "pangel_getDidByFour:" + str);
        return str;
    }

    public static String b() {
        if (k()) {
            return a();
        }
        return c();
    }

    private static String c() {
        String did = AppLog.getDid();
        Logger.e("TTMediationSDK", "pangel_getDidByThree:" + did);
        return did;
    }

    private static String d() {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 3);
        String str = (String) TTAdSdk.getAdManager().getExtra(String.class, bundle);
        Logger.e("TTMediationSDK", "pangel_getOaidByFour:" + str);
        return str;
    }

    public static String e() {
        if (k()) {
            return d();
        }
        return f();
    }

    private static String f() {
        try {
            String a4 = r.a("ttopenadsdk", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, "");
            Logger.e("TTMediationSDK", "pangel_getOaidByThree:" + a4);
            return a4;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        try {
            return Integer.valueOf(TTAdSdk.getAdManager().getSDKVersion().replaceAll("\\.", "")).intValue() >= 4100;
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean h() {
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

    private static boolean i() {
        if (f680a) {
            return f681b;
        }
        try {
            Class<?> cls = Class.forName("com.bytedance.sdk.openadsdk.TTAdConstant");
            Field declaredField = cls.getDeclaredField("IS_P");
            declaredField.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredField.get(cls)).booleanValue();
            f681b = booleanValue;
            f680a = true;
            return booleanValue;
        } catch (Exception unused) {
            return true;
        }
    }

    public static void j() {
        if (k()) {
            return;
        }
        AppLog.addDataObserver(new a());
    }

    private static boolean k() {
        if (i()) {
            return h();
        }
        return g();
    }

    private static byte[] c(byte[] bArr, int i4) {
        Logger.e("TTMediationSDK", "pangel_encryptByThree......");
        return TTEncryptUtils.a(bArr, i4);
    }

    public static byte[] b(byte[] bArr, int i4) {
        if (k()) {
            return a(bArr, i4);
        }
        return c(bArr, i4);
    }

    private static byte[] a(byte[] bArr, int i4) {
        Logger.e("TTMediationSDK", "pangel_encryptByFour......");
        return EncryptorUtil.encrypt(bArr, i4);
    }
}
