package com.bxkj.student.run.app.step;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, LongRunningService.class));
    }
}
