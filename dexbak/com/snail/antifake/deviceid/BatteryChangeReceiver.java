package com.snail.antifake.deviceid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BatteryChangeReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private boolean f33795a;

    /* renamed from: b */
    private int f33796b;

    /* renamed from: a */
    public int m19707a() {
        return this.f33796b;
    }

    /* renamed from: b */
    public boolean m19706b() {
        return this.f33795a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("status", 0);
        this.f33796b = intent.getIntExtra("level", 0);
        if (intExtra != 1 && intExtra != 2) {
            if (intExtra == 3 || intExtra == 4) {
                this.f33795a = false;
                return;
            } else if (intExtra != 5) {
                return;
            }
        }
        this.f33795a = true;
    }
}
