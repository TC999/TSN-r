package com.acse.ottn.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Z extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1417aa f6798a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(C1417aa c1417aa) {
        this.f6798a = c1417aa;
    }

    @Override // android.content.BroadcastReceiver
    @RequiresApi(api = 21)
    public void onReceive(Context context, Intent intent) {
        Activity activity;
        Activity activity2;
        String action = intent.getAction();
        Log.d(C1417aa.f6801b, "\u6536\u5230\u6ce8\u518c\u5e7f\u64ad2");
        if ("android.intent.action.SCREEN_OFF".equals(action)) {
            activity = this.f6798a.f6802c;
            if (activity == null) {
                Log.d(C1417aa.f6801b, "\u7ed3\u675f\u5f53\u524dactivity2 ==null");
                return;
            }
            Log.d(C1417aa.f6801b, "\u7ed3\u675f\u5f53\u524dactivity2");
            activity2 = this.f6798a.f6802c;
            activity2.finishAndRemoveTask();
        }
    }
}
