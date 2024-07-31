package com.mbridge.msdk.shake;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;

/* renamed from: com.mbridge.msdk.shake.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class ShakeSensorEventListener implements SensorEventListener {

    /* renamed from: a */
    private int f31691a;

    /* renamed from: b */
    private int f31692b;

    /* renamed from: d */
    public float f31693d = 0.0f;

    /* renamed from: e */
    public float f31694e = 0.0f;

    /* renamed from: f */
    public float f31695f = 0.0f;

    /* renamed from: g */
    public long f31696g = 0;

    public ShakeSensorEventListener(int i, int i2) {
        this.f31691a = i;
        this.f31692b = i2;
    }

    /* renamed from: a */
    public abstract void mo20983a();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
        if (java.lang.Math.abs(r10 - r2) > r9.f31691a) goto L5;
     */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSensorChanged(android.hardware.SensorEvent r10) {
        /*
            r9 = this;
            float[] r10 = r10.values
            r0 = 0
            r0 = r10[r0]
            float r0 = -r0
            r1 = 1
            r1 = r10[r1]
            float r1 = -r1
            r2 = 2
            r10 = r10[r2]
            float r10 = -r10
            float r2 = r9.f31693d
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 == 0) goto L22
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r4 = r9.f31691a
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L48
        L22:
            float r2 = r9.f31694e
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 == 0) goto L35
            float r2 = r1 - r2
            float r2 = java.lang.Math.abs(r2)
            int r4 = r9.f31691a
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L48
        L35:
            float r2 = r9.f31695f
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 == 0) goto L5c
            float r2 = r10 - r2
            float r2 = java.lang.Math.abs(r2)
            int r3 = r9.f31691a
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L5c
        L48:
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r9.f31696g
            long r4 = r2 - r4
            int r6 = r9.f31692b
            long r6 = (long) r6
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L5c
            r9.f31696g = r2
            r9.mo20983a()
        L5c:
            r9.f31693d = r0
            r9.f31694e = r1
            r9.f31695f = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.shake.ShakeSensorEventListener.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
