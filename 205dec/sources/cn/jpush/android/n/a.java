package cn.jpush.android.n;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    public static void a(Context context, String str) {
        Logger.dd("GeoCallbackHelper", "onGeofenceReceived,geos:" + str);
        a(context, "cn.jpush.android.intent.GEO_RECEIVED", str, 0.0d, 0.0d);
    }

    public static void a(Context context, String str, double d4, double d5) {
        Logger.dd("GeoCallbackHelper", "onGeofenceRegion,geo:" + str + ",lat:" + d4 + ",lng:" + d5);
        a(context, "cn.jpush.android.intent.GEO_REGION", str, d4, d5);
    }

    public static void a(Context context, String str, String str2, double d4, double d5) {
        if (context == null) {
            return;
        }
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.d("GeoCallbackHelper", "not found messageReceiver");
            } else {
                Intent intent = new Intent(context, Class.forName(messageReceiverClass));
                intent.setAction(str);
                intent.putExtra("geo", str2);
                intent.putExtra("geoLat", d4);
                intent.putExtra("geoLng", d5);
                cn.jpush.android.helper.a.a(context, intent);
            }
        } catch (Throwable th) {
            Logger.ww("GeoCallbackHelper", "onResult error:" + th);
        }
    }
}
