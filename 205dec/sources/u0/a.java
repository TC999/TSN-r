package u0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: DeviceIdUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        String e4 = c.e(context);
        if (TextUtils.isEmpty(e4)) {
            e4 = b.e(context);
            if (TextUtils.isEmpty(e4)) {
                e4 = c.d(context);
                if (TextUtils.isEmpty(e4)) {
                    e4 = b.d(context);
                    if (TextUtils.isEmpty(e4)) {
                        e4 = b.c(context);
                        if (TextUtils.isEmpty(e4)) {
                            e4 = c.c(context);
                            if (TextUtils.isEmpty(e4)) {
                                return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                            }
                        }
                    }
                }
            }
        }
        return e4;
    }

    private static boolean b(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (str.charAt(i4) != '0') {
                return false;
            }
        }
        return true;
    }

    public static boolean c(Context context) {
        return b(a(context));
    }
}
