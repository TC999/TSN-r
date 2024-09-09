package com.snail.antifake.deviceid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BatteryChangeReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private boolean f48129a;

    /* renamed from: b  reason: collision with root package name */
    private int f48130b;

    public int a() {
        return this.f48130b;
    }

    public boolean b() {
        return this.f48129a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("status", 0);
        this.f48130b = intent.getIntExtra("level", 0);
        if (intExtra != 1 && intExtra != 2) {
            if (intExtra == 3 || intExtra == 4) {
                this.f48129a = false;
                return;
            } else if (intExtra != 5) {
                return;
            }
        }
        this.f48129a = true;
    }
}
