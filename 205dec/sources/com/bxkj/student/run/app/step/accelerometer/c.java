package com.bxkj.student.run.app.step.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StepDetector.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class c implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    float[] f22649a = new float[3];

    /* renamed from: b  reason: collision with root package name */
    final int f22650b = 4;

    /* renamed from: c  reason: collision with root package name */
    float[] f22651c = new float[4];

    /* renamed from: d  reason: collision with root package name */
    int f22652d = 0;

    /* renamed from: e  reason: collision with root package name */
    boolean f22653e = false;

    /* renamed from: f  reason: collision with root package name */
    int f22654f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f22655g = 0;

    /* renamed from: h  reason: collision with root package name */
    boolean f22656h = false;

    /* renamed from: i  reason: collision with root package name */
    float f22657i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    float f22658j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    long f22659k = 0;

    /* renamed from: l  reason: collision with root package name */
    long f22660l = 0;

    /* renamed from: m  reason: collision with root package name */
    long f22661m = 0;

    /* renamed from: n  reason: collision with root package name */
    float f22662n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    float f22663o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    final float f22664p = 1.3f;

    /* renamed from: q  reason: collision with root package name */
    float f22665q = 2.0f;

    /* renamed from: r  reason: collision with root package name */
    int f22666r = 250;

    /* renamed from: s  reason: collision with root package name */
    private b f22667s;

    public float a(float[] value, int n4) {
        float f4 = 0.0f;
        for (int i4 = 0; i4 < n4; i4++) {
            f4 += value[i4];
        }
        float f5 = f4 / 4.0f;
        if (f5 >= 8.0f) {
            return 4.3f;
        }
        if (f5 < 7.0f || f5 >= 8.0f) {
            if (f5 < 4.0f || f5 >= 7.0f) {
                return (f5 < 3.0f || f5 >= 4.0f) ? 1.3f : 2.0f;
            }
            return 2.3f;
        }
        return 3.3f;
    }

    public void b(float values) {
        float f4 = this.f22663o;
        if (f4 == 0.0f) {
            this.f22663o = values;
        } else if (c(values, f4)) {
            this.f22660l = this.f22659k;
            long currentTimeMillis = System.currentTimeMillis();
            this.f22661m = currentTimeMillis;
            if (currentTimeMillis - this.f22660l >= this.f22666r && this.f22657i - this.f22658j >= this.f22665q) {
                this.f22659k = currentTimeMillis;
                this.f22667s.a();
            }
            long j4 = this.f22661m;
            if (j4 - this.f22660l >= this.f22666r) {
                float f5 = this.f22657i;
                float f6 = this.f22658j;
                if (f5 - f6 >= 1.3f) {
                    this.f22659k = j4;
                    this.f22665q = e(f5 - f6);
                }
            }
        }
        this.f22663o = values;
    }

    public boolean c(float newValue, float oldValue) {
        boolean z3 = this.f22653e;
        this.f22656h = z3;
        if (newValue >= oldValue) {
            this.f22653e = true;
            this.f22654f++;
        } else {
            this.f22655g = this.f22654f;
            this.f22654f = 0;
            this.f22653e = false;
        }
        boolean z4 = this.f22653e;
        if (!z4 && z3 && (this.f22655g >= 2 || oldValue >= 20.0f)) {
            this.f22657i = oldValue;
            return true;
        }
        if (!z3 && z4) {
            this.f22658j = oldValue;
        }
        return false;
    }

    public void d(b listener) {
        this.f22667s = listener;
    }

    public float e(float value) {
        float f4 = this.f22665q;
        int i4 = this.f22652d;
        if (i4 < 4) {
            this.f22651c[i4] = value;
            this.f22652d = i4 + 1;
        } else {
            f4 = a(this.f22651c, 4);
            for (int i5 = 1; i5 < 4; i5++) {
                float[] fArr = this.f22651c;
                fArr[i5 - 1] = fArr[i5];
            }
            this.f22651c[3] = value;
        }
        return f4;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        for (int i4 = 0; i4 < 3; i4++) {
            this.f22649a[i4] = event.values[i4];
        }
        float[] fArr = this.f22649a;
        float sqrt = (float) Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
        this.f22662n = sqrt;
        b(sqrt);
    }
}
