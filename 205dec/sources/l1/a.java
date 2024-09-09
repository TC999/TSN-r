package l1;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: IAndroidIdUtil.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class a {
    public static String a(Context context) {
        String b4 = b.b(context, "android_id");
        if (TextUtils.isEmpty(b4)) {
            b4 = b.a(context, "android_id");
            if (TextUtils.isEmpty(b4)) {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
        }
        return b4;
    }
}
