package com.acse.ottn.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Y extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final String f6794a = "reason";

    /* renamed from: b  reason: collision with root package name */
    final String f6795b = "homekey";

    /* renamed from: c  reason: collision with root package name */
    final String f6796c = "recentapps";

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1417aa f6797d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(C1417aa c1417aa) {
        this.f6797d = c1417aa;
    }

    @Override // android.content.BroadcastReceiver
    @RequiresApi(api = 21)
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        Activity activity;
        Activity activity2;
        Activity activity3;
        String action = intent.getAction();
        Log.d(C1417aa.f6801b, "\u6536\u5230\u6ce8\u518c\u5e7f\u64ad");
        if (!action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null) {
            return;
        }
        activity = this.f6797d.f6802c;
        if (activity != null) {
            C1417aa c1417aa = this.f6797d;
            activity2 = c1417aa.f6802c;
            if (c1417aa.a(activity2, true)) {
                Log.d(C1417aa.f6801b, "\u7ed3\u675f\u5f53\u524dactivity1");
                activity3 = this.f6797d.f6802c;
                activity3.finishAndRemoveTask();
            }
        } else {
            Log.d(C1417aa.f6801b, "\u7ed3\u675f\u5f53\u524dactivity1 ==null");
        }
        if (stringExtra.equals("homekey")) {
            return;
        }
        stringExtra.equals("recentapps");
    }
}
