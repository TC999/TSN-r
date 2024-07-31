package com.acse.ottn.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.Y */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1655Y extends BroadcastReceiver {

    /* renamed from: a */
    final String f3284a = MediationConstant.KEY_REASON;

    /* renamed from: b */
    final String f3285b = "homekey";

    /* renamed from: c */
    final String f3286c = "recentapps";

    /* renamed from: d */
    final /* synthetic */ C1658aa f3287d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1655Y(C1658aa c1658aa) {
        this.f3287d = c1658aa;
    }

    @Override // android.content.BroadcastReceiver
    @RequiresApi(api = 21)
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        Activity activity;
        Activity activity2;
        Activity activity3;
        String action = intent.getAction();
        Log.d(C1658aa.f3291b, "收到注册广播");
        if (!action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON)) == null) {
            return;
        }
        activity = this.f3287d.f3292c;
        if (activity != null) {
            C1658aa c1658aa = this.f3287d;
            activity2 = c1658aa.f3292c;
            if (c1658aa.m56109a(activity2, true)) {
                Log.d(C1658aa.f3291b, "结束当前activity1");
                activity3 = this.f3287d.f3292c;
                activity3.finishAndRemoveTask();
            }
        } else {
            Log.d(C1658aa.f3291b, "结束当前activity1 ==null");
        }
        if (stringExtra.equals("homekey")) {
            return;
        }
        stringExtra.equals("recentapps");
    }
}
