package com.acse.ottn.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.acse.ottn.util.C1694ra;

/* renamed from: com.acse.ottn.activity.M */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1275M extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TransparentActivity f2119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1275M(TransparentActivity transparentActivity) {
        this.f2119a = transparentActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1694ra.m55917a("TransparentActivity", "收到广播");
        TransparentActivity transparentActivity = this.f2119a;
        transparentActivity.unregisterReceiver(transparentActivity.f2169n);
        this.f2119a.finish();
    }
}
