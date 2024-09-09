package com.bxkj.base.util;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: NotificationSettingUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class q {

    /* renamed from: b  reason: collision with root package name */
    public static q f18417b;

    /* renamed from: a  reason: collision with root package name */
    private a f18418a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: NotificationSettingUtils.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a();

        void b();
    }

    public static q a() {
        if (f18417b == null) {
            synchronized (q.class) {
                if (f18417b == null) {
                    f18417b = new q();
                }
            }
        }
        return f18417b;
    }

    public void b(Activity activity, int i4) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivityForResult(intent, i4);
    }

    @RequiresApi(api = 19)
    public boolean c(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
        int i4 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i4), packageName)).intValue() == 0;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @RequiresApi(api = 19)
    public void d(Context context, a aVar) {
        if (c(context)) {
            if (aVar != null) {
                aVar.a();
            }
        } else if (aVar != null) {
            aVar.b();
        }
    }

    public void e(a aVar) {
        this.f18418a = this.f18418a;
    }
}
