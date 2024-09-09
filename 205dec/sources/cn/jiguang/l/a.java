package cn.jiguang.l;

import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.ah.d;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    @TargetApi(11)
    public static String a(Context context, Uri uri) {
        try {
            String f4 = d.f("Oi3ZFT8+schQHSyFZbsdUg==");
            if (TextUtils.isEmpty(f4)) {
                return "";
            }
            int i4 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
            Bundle call = acquireUnstableContentProviderClient.call(f4, null, null);
            if (i4 >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                cn.jiguang.w.a.b("NubiaIdManager", "succeed:" + string);
                return string;
            }
            return call.getString("message");
        } catch (Exception e4) {
            cn.jiguang.w.a.f("NubiaIdManager", "get ids-o err:" + e4.getMessage());
            return null;
        }
    }
}
