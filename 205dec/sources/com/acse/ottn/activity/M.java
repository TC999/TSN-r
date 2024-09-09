package com.acse.ottn.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.acse.ottn.util.ra;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class M extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TransparentActivity f4672a;

    M(TransparentActivity transparentActivity) {
        this.f4672a = transparentActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ra.a("TransparentActivity", "\u6536\u5230\u5e7f\u64ad");
        TransparentActivity transparentActivity = this.f4672a;
        transparentActivity.unregisterReceiver(transparentActivity.n);
        this.f4672a.finish();
    }
}
