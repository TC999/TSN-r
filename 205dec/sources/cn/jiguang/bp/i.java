package cn.jiguang.bp;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static int a(Context context) {
        StringBuilder sb;
        String str;
        if (cn.jiguang.bm.f.k(context).booleanValue()) {
            h.e("NotificationHelper", "[key-step]Your sdk is disabled already, check notification status failed.");
            return 0;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    boolean areNotificationsEnabled = notificationManager.areNotificationsEnabled();
                    h.a("NotificationHelper", "from NotificationManager enable=" + areNotificationsEnabled);
                    return areNotificationsEnabled ? 1 : 0;
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                sb = new StringBuilder();
                str = "isNotificationEnabled e:";
            }
        } else if (i4 < 19) {
            h.a("NotificationHelper", "below 19 return true");
            return 1;
        } else {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
                int i5 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                ?? r12 = ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i5), packageName)).intValue() == 0 ? 1 : 0;
                h.a("NotificationHelper", "from AppOpsManager enable=" + ((boolean) r12));
                return r12;
            } catch (Throwable th2) {
                th = th2;
                sb = new StringBuilder();
                str = "appOps check e:";
            }
        }
        sb.append(str);
        sb.append(th);
        h.d("NotificationHelper", sb.toString());
        return -1;
    }
}
