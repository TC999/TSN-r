package cn.jiguang.x;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.ah.c;
import cn.jiguang.ah.d;
import com.stub.StubApp;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    public static void a(Context context, int i4) {
        boolean z3;
        boolean z4;
        if (cn.jiguang.ar.a.a().a(1800)) {
            String h4 = c.h(context);
            boolean a4 = new a().a(context);
            if (!a4) {
                cn.jiguang.w.a.d("JNotificationState", "notification trigger is off, will not show notification");
            }
            boolean z5 = true;
            if (!TextUtils.isEmpty(h4)) {
                if (TextUtils.equals("ON", h4)) {
                    z3 = false;
                    z4 = true;
                } else {
                    z3 = !TextUtils.equals("OFF", h4);
                    z4 = false;
                }
                if (z3) {
                    cn.jiguang.w.a.b("JNotificationState", "notification state do not changed");
                    z5 = z3;
                } else if (z4 == a4) {
                    z5 = false;
                }
            }
            cn.jiguang.w.a.b("JNotificationState", "lastCacheNotificationState:" + h4 + ",currentNotificationSate:" + a4 + ",isNeedReport:" + z5 + ",triggerScene:" + i4);
            if (!z5) {
                cn.jiguang.w.a.b("JNotificationState", "do not need report notification state");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("notification_state", a4);
                if (cn.jiguang.ar.a.a().a(1801)) {
                    jSONObject.put("imei", d.e(context, ""));
                }
                if (cn.jiguang.ar.a.a().a(1802)) {
                    jSONObject.put("device_id", d.h(context));
                }
                jSONObject.put("trigger_scene", i4);
                d.a(context, jSONObject, "android_notification_state");
                d.a(context, (Object) jSONObject);
                c.t(context, a4 ? "ON" : "OFF");
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JNotificationState", "report notification state failed, error:" + th.getMessage());
            }
        }
    }

    private boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 24 ? b(context) : c(context);
    }

    @TargetApi(24)
    private boolean b(Context context) {
        try {
            return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JNotificationState", "invoke areNotificationsEnabled method failed, error:" + th.getMessage());
            return true;
        }
    }

    private boolean c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
            int i4 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i4), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JNotificationState", "getNotificationStateCommon failed, other error:" + th.getMessage());
            return true;
        }
    }
}
