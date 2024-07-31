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

/* renamed from: com.bxkj.base.util.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NotificationSettingUtils {

    /* renamed from: b */
    public static NotificationSettingUtils f14933b;

    /* renamed from: a */
    private InterfaceC3911a f14934a;

    /* compiled from: NotificationSettingUtils.java */
    /* renamed from: com.bxkj.base.util.q$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3911a {
        /* renamed from: a */
        void m44053a();

        /* renamed from: b */
        void m44052b();
    }

    /* renamed from: a */
    public static NotificationSettingUtils m44058a() {
        if (f14933b == null) {
            synchronized (NotificationSettingUtils.class) {
                if (f14933b == null) {
                    f14933b = new NotificationSettingUtils();
                }
            }
        }
        return f14933b;
    }

    /* renamed from: b */
    public void m44057b(Activity activity, int i) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivityForResult(intent, i);
    }

    @RequiresApi(api = 19)
    /* renamed from: c */
    public boolean m44056c(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequiresApi(api = 19)
    /* renamed from: d */
    public void m44055d(Context context, InterfaceC3911a interfaceC3911a) {
        if (m44056c(context)) {
            if (interfaceC3911a != null) {
                interfaceC3911a.m44053a();
            }
        } else if (interfaceC3911a != null) {
            interfaceC3911a.m44052b();
        }
    }

    /* renamed from: e */
    public void m44054e(InterfaceC3911a interfaceC3911a) {
        this.f14934a = this.f14934a;
    }
}
