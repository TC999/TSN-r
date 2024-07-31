package com.acse.ottn.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.Z */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1656Z extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C1658aa f3288a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1656Z(C1658aa c1658aa) {
        this.f3288a = c1658aa;
    }

    @Override // android.content.BroadcastReceiver
    @RequiresApi(api = 21)
    public void onReceive(Context context, Intent intent) {
        Activity activity;
        Activity activity2;
        String action = intent.getAction();
        Log.d(C1658aa.f3291b, "收到注册广播2");
        if ("android.intent.action.SCREEN_OFF".equals(action)) {
            activity = this.f3288a.f3292c;
            if (activity == null) {
                Log.d(C1658aa.f3291b, "结束当前activity2 ==null");
                return;
            }
            Log.d(C1658aa.f3291b, "结束当前activity2");
            activity2 = this.f3288a.f3292c;
            activity2.finishAndRemoveTask();
        }
    }
}
