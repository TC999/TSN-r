package com.bxkj.student.run.app.step;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, LongRunningService.class));
    }
}
