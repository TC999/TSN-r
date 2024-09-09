package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bk.f;
import cn.jiguang.bk.g;
import cn.jiguang.bq.d;
import cn.jiguang.internal.JConstants;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class PushReceiver extends BroadcastReceiver {
    private static final String TAG = "PushReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (f.a()) {
                d.d(TAG, "[key-step]Your sdk is disabled already, no receiver task can be handled.");
            } else if (g.a()) {
                d.d(TAG, "[key-step]Your sdk is limited already, no receiver task can be handled.");
            } else {
                d.c(TAG, "onReceive:" + intent.getAction());
                if (!JConstants.isCallInit.get()) {
                    d.d(TAG, "please call init");
                    return;
                }
                JCoreManager.onEvent(StubApp.getOrigApplicationContext(context.getApplicationContext()), intent.getStringExtra("sdktype"), 31, null, null, intent);
            }
        } catch (Throwable unused) {
        }
    }
}
