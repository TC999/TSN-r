package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import com.stub.StubApp;

/* renamed from: com.kwad.sdk.utils.ao */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11022ao {
    private static volatile C11022ao aPy = new C11022ao();
    private volatile long aPA = 0;
    private volatile PowerManager aPB;
    private volatile boolean aPz;

    /* renamed from: Ma */
    public static C11022ao m24092Ma() {
        return aPy;
    }

    /* renamed from: cs */
    public final boolean m24091cs(Context context) {
        if (this.aPA > 0 && SystemClock.elapsedRealtime() - this.aPA < 600) {
            return this.aPz;
        }
        boolean z = false;
        if (this.aPB == null && context != null) {
            synchronized (this) {
                if (this.aPB == null) {
                    this.aPB = (PowerManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("power");
                }
            }
        }
        if (this.aPB != null) {
            if (Build.VERSION.SDK_INT >= 20) {
                z = this.aPB.isInteractive();
            } else {
                z = this.aPB.isScreenOn();
            }
        }
        this.aPz = z;
        this.aPA = SystemClock.elapsedRealtime();
        return this.aPz;
    }
}
