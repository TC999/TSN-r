package com.acse.ottn.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    String f6226a;

    /* renamed from: b  reason: collision with root package name */
    Handler f6227b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    Runnable f6228c = new e(this);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f6226a = intent.getStringExtra("url");
        this.f6227b.postDelayed(this.f6228c, 1000L);
    }
}
