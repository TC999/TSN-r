package cn.jpush.android.ac;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import com.stub.StubApp;
import java.util.LinkedList;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f3944a;

    public static cn.jpush.android.d.d a(Context context, String str, String str2) {
        return cn.jpush.android.d.d.a(context, str, str2);
    }

    private static void a(Context context, cn.jpush.android.d.d dVar) {
        Intent b4 = 2 == dVar.ac ? cn.jpush.android.x.b.b(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar) : cn.jpush.android.x.b.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar);
        if (b4 != null) {
            b4.addFlags(268435456);
            StubApp.getOrigApplicationContext(context.getApplicationContext()).startActivity(b4);
        }
    }

    private static void a(Context context, cn.jpush.android.d.d dVar, String str, int i4) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageArrived");
        cn.jpush.android.x.b.a(context, "cn.jpush.android.intent.NOTIFICATION_ARRIVED", dVar, (Intent) null);
        cn.jpush.android.helper.c.a(dVar.f4127d, str, dVar.ah, 1018L, context);
    }

    public static void a(Context context, String str, String str2, int i4, byte b4, int i5) {
        String str3;
        if (context == null) {
            str3 = "context was null";
        } else if (TextUtils.isEmpty(str)) {
            str3 = "content was null";
        } else {
            Logger.v("PluginPlatformsNotificationHelper", "message content:" + str);
            cn.jpush.android.d.d a4 = a(context, str, str2);
            Logger.v("PluginPlatformsNotificationHelper", "entity:" + a4);
            if (a4 == null) {
                str3 = "entity was null";
            } else if (!TextUtils.isEmpty(a4.f4127d)) {
                a4.ah = b4;
                a4.f4128e = i4;
                if (i5 == 0) {
                    c(context, a4, str2, i4);
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(a4.f4127d);
                    cn.jpush.android.x.d.a(context, linkedList);
                    return;
                } else if (i5 == 1) {
                    a(context, a4, str2, i4);
                    return;
                } else if (i5 != 2) {
                    return;
                } else {
                    b(context, a4, str2, i4);
                    return;
                }
            } else {
                str3 = "message id was empty";
            }
        }
        Logger.ww("PluginPlatformsNotificationHelper", str3);
    }

    private static void b(Context context, cn.jpush.android.d.d dVar, String str, int i4) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageUnShow in foreground");
        dVar.f4128e = i4;
        cn.jpush.android.x.b.a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
        cn.jpush.android.helper.c.a(dVar.f4127d, str, dVar.ah, 1060L, context);
    }

    private static void c(Context context, cn.jpush.android.d.d dVar, String str, int i4) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageClick");
        if (!dVar.X) {
            cn.jpush.android.x.b.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar, (Intent) null);
        } else if (dVar.ah == 8) {
            a(context, dVar);
        }
    }
}
