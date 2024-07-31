package com.acse.ottn.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* renamed from: com.acse.ottn.receiver.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1558f extends BroadcastReceiver {

    /* renamed from: a */
    String f2923a;

    /* renamed from: b */
    Handler f2924b = new Handler();

    /* renamed from: c */
    Runnable f2925c = new RunnableC1557e(this);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f2923a = intent.getStringExtra("url");
        this.f2924b.postDelayed(this.f2925c, 1000L);
    }
}
