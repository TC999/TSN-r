package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.msdk.adapter.util.Logger;

/* compiled from: TestHelperUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    private static String f626a;

    public static String a(String str) {
        try {
            if (b()) {
                String b4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().b();
                if (TextUtils.isEmpty(b4)) {
                    return str;
                }
                Log.d("TestHelperUtils", "AnyDoorId=" + b4);
                return Uri.parse(str).buildUpon().appendQueryParameter(a(), b4).appendQueryParameter("aid", "5001121").toString();
            }
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean b() {
        return Logger.isDebug() && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().t() && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().u();
    }

    public static String a() {
        if (TextUtils.isEmpty(f626a)) {
            f626a = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return f626a;
    }
}
