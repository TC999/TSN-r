package com.bxkj.base.chat.heart;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AlarmChatTimer.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final long f18257a = 5000;

    /* renamed from: b  reason: collision with root package name */
    private Context f18258b;

    /* renamed from: c  reason: collision with root package name */
    private AlarmManager f18259c;

    /* renamed from: d  reason: collision with root package name */
    private PendingIntent f18260d;

    public a(Context context) {
        this.f18258b = context;
        this.f18259c = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(context, AlarmChatService.class);
        intent.setAction("CHAT_HEART");
        intent.putExtra("msg", "\u5fc3\u8df3\u5305");
        this.f18260d = PendingIntent.getService(this.f18258b, 0, intent, 0);
    }

    public void a() {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = this.f18259c;
        if (alarmManager == null || (pendingIntent = this.f18260d) == null) {
            return;
        }
        alarmManager.cancel(pendingIntent);
    }

    @SuppressLint({"NewApi"})
    public void b() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            this.f18259c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f18260d);
        } else if (i4 >= 19) {
            this.f18259c.setExact(0, System.currentTimeMillis() + 5000, this.f18260d);
        } else {
            this.f18259c.set(0, System.currentTimeMillis() + 5000, this.f18260d);
        }
    }
}
