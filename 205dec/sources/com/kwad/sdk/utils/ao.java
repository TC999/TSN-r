package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ao {
    private static volatile ao aPy = new ao();
    private volatile long aPA = 0;
    private volatile PowerManager aPB;
    private volatile boolean aPz;

    public static ao Ma() {
        return aPy;
    }

    public final boolean cs(Context context) {
        if (this.aPA > 0 && SystemClock.elapsedRealtime() - this.aPA < 600) {
            return this.aPz;
        }
        boolean z3 = false;
        if (this.aPB == null && context != null) {
            synchronized (this) {
                if (this.aPB == null) {
                    this.aPB = (PowerManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("power");
                }
            }
        }
        if (this.aPB != null) {
            if (Build.VERSION.SDK_INT >= 20) {
                z3 = this.aPB.isInteractive();
            } else {
                z3 = this.aPB.isScreenOn();
            }
        }
        this.aPz = z3;
        this.aPA = SystemClock.elapsedRealtime();
        return this.aPz;
    }
}
