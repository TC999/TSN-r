package cn.jiguang.bx;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import cn.jpush.android.service.AlarmReceiver;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    public static void a(Context context) {
        if (Build.VERSION.SDK_INT >= 31 && context.getApplicationInfo().targetSdkVersion >= 31) {
            cn.jiguang.bq.d.c("AlarmHelper", "sdk is android 12, return");
            return;
        }
        try {
            ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), TTAdConstant.KEY_CLICK_AREA));
        } catch (Throwable unused) {
            cn.jiguang.bq.d.i("AlarmHelper", "Cancel heartbeat alarm failed.");
        }
    }

    public static void b(Context context) {
        String str;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31 && context.getApplicationInfo().targetSdkVersion >= 31) {
            str = "sdk is android 12, return";
        } else if (cn.jiguang.cn.a.b(context)) {
            h.a().e();
            long h4 = h.a().h() * 1000;
            long currentTimeMillis = System.currentTimeMillis() + h4;
            cn.jiguang.bq.d.f("AlarmHelper", "Reset heartbeat alarm, wait " + h4 + "ms.");
            try {
                PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), TTAdConstant.KEY_CLICK_AREA);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                if (i4 >= 19) {
                    alarmManager.setWindow(0, currentTimeMillis, 0L, broadcast);
                } else {
                    alarmManager.setInexactRepeating(0, currentTimeMillis, h4, broadcast);
                }
                return;
            } catch (Throwable th) {
                cn.jiguang.bq.d.j("AlarmHelper", "can't trigger alarm cause by exception:" + th);
                return;
            }
        } else {
            str = "auto wakeup is closed";
        }
        cn.jiguang.bq.d.c("AlarmHelper", str);
    }
}
