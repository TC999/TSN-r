package p648u0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;

/* renamed from: u0.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DeviceIdUtil {
    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public static String m243a(Context context) {
        String m231e = ITelephonyUtil.m231e(context);
        if (TextUtils.isEmpty(m231e)) {
            m231e = IPhoneSubInfoUtil.m236e(context);
            if (TextUtils.isEmpty(m231e)) {
                m231e = ITelephonyUtil.m232d(context);
                if (TextUtils.isEmpty(m231e)) {
                    m231e = IPhoneSubInfoUtil.m237d(context);
                    if (TextUtils.isEmpty(m231e)) {
                        m231e = IPhoneSubInfoUtil.m238c(context);
                        if (TextUtils.isEmpty(m231e)) {
                            m231e = ITelephonyUtil.m233c(context);
                            if (TextUtils.isEmpty(m231e)) {
                                return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                            }
                        }
                    }
                }
            }
        }
        return m231e;
    }

    /* renamed from: b */
    private static boolean m242b(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m241c(Context context) {
        return m242b(m243a(context));
    }
}
