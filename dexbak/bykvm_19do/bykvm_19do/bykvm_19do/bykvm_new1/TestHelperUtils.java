package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import com.bytedance.msdk.adapter.util.Logger;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TestHelperUtils {

    /* renamed from: a */
    private static String f633a;

    /* renamed from: a */
    public static String m59262a(String str) {
        try {
            if (m59261b()) {
                String m59926b = SdkGlobalInfo.m59939B().m59926b();
                if (TextUtils.isEmpty(m59926b)) {
                    return str;
                }
                Log.d("TestHelperUtils", "AnyDoorId=" + m59926b);
                return Uri.parse(str).buildUpon().appendQueryParameter(m59263a(), m59926b).appendQueryParameter(CommonNetImpl.AID, "5001121").toString();
            }
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: b */
    public static boolean m59261b() {
        return Logger.isDebug() && SdkGlobalInfo.m59939B().m59893t() && SdkGlobalInfo.m59939B().m59892u();
    }

    /* renamed from: a */
    public static String m59263a() {
        if (TextUtils.isEmpty(f633a)) {
            f633a = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return f633a;
    }
}
