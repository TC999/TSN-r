package com.bxkj.base.chat.heart;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* renamed from: com.bxkj.base.chat.heart.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AlarmChatTimer {

    /* renamed from: a */
    private final long f14772a = 5000;

    /* renamed from: b */
    private Context f14773b;

    /* renamed from: c */
    private AlarmManager f14774c;

    /* renamed from: d */
    private PendingIntent f14775d;

    public AlarmChatTimer(Context context) {
        this.f14773b = context;
        this.f14774c = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(context, AlarmChatService.class);
        intent.setAction("CHAT_HEART");
        intent.putExtra("msg", "心跳包");
        this.f14775d = PendingIntent.getService(this.f14773b, 0, intent, 0);
    }

    /* renamed from: a */
    public void m44222a() {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = this.f14774c;
        if (alarmManager == null || (pendingIntent = this.f14775d) == null) {
            return;
        }
        alarmManager.cancel(pendingIntent);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void m44221b() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            this.f14774c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f14775d);
        } else if (i >= 19) {
            this.f14774c.setExact(0, System.currentTimeMillis() + 5000, this.f14775d);
        } else {
            this.f14774c.set(0, System.currentTimeMillis() + 5000, this.f14775d);
        }
    }
}
