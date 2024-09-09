package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bk.f;
import cn.jiguang.bk.g;
import cn.jiguang.bq.d;
import cn.jiguang.cn.a;
import cn.jiguang.internal.JConstants;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "AlarmReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d.c(TAG, "onReceive");
        if (f.a()) {
            d.d(TAG, "[key-step]Your sdk is disabled already, no receiver task can be handled.");
        } else if (g.a()) {
            d.d(TAG, "[key-step]Your sdk is limited already, no receiver task can be handled.");
        } else if (Build.VERSION.SDK_INT >= 31 && context.getApplicationInfo().targetSdkVersion >= 31) {
            d.d(TAG, "sdk is android 12, return");
        } else if (!a.b(context)) {
            d.d(TAG, "auto wakeup is closed");
        } else if (!JConstants.isCallInit.get()) {
            d.d(TAG, "please call init");
        } else {
            cn.jiguang.bx.a.b(context);
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 10, "a2", null, new Object[0]);
        }
    }
}
