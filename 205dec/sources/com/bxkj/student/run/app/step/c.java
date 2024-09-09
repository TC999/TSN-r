package com.bxkj.student.run.app.step;

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
    double[] f22668a = new double[3];

    /* renamed from: b  reason: collision with root package name */
    final int f22669b = 4;

    /* renamed from: c  reason: collision with root package name */
    float[] f22670c = new float[4];

    /* renamed from: d  reason: collision with root package name */
    int f22671d = 0;

    /* renamed from: e  reason: collision with root package name */
    boolean f22672e = false;

    /* renamed from: f  reason: collision with root package name */
    int f22673f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f22674g = 0;

    /* renamed from: h  reason: collision with root package name */
    boolean f22675h = false;

    /* renamed from: i  reason: collision with root package name */
    float f22676i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    float f22677j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    long f22678k = 0;

    /* renamed from: l  reason: collision with root package name */
    long f22679l = 0;

    /* renamed from: m  reason: collision with root package name */
    long f22680m = 0;

    /* renamed from: n  reason: collision with root package name */
    float f22681n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    float f22682o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    final float f22683p = 1.3f;

    /* renamed from: q  reason: collision with root package name */
    float f22684q = 2.0f;

    /* renamed from: r  reason: collision with root package name */
    int f22685r = 250;

    /* renamed from: s  reason: collision with root package name */
    private b f22686s;

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
        float f4 = this.f22682o;
        if (f4 == 0.0f) {
            this.f22682o = values;
        } else if (c(values, f4)) {
            this.f22679l = this.f22678k;
            long currentTimeMillis = System.currentTimeMillis();
            this.f22680m = currentTimeMillis;
            if (currentTimeMillis - this.f22679l >= this.f22685r && this.f22676i - this.f22677j >= this.f22684q) {
                this.f22678k = currentTimeMillis;
                b bVar = this.f22686s;
                if (bVar != null) {
                    bVar.a();
                }
            }
            long j4 = this.f22680m;
            if (j4 - this.f22679l >= this.f22685r) {
                float f5 = this.f22676i;
                float f6 = this.f22677j;
                if (f5 - f6 >= 1.3f) {
                    this.f22678k = j4;
                    this.f22684q = e(f5 - f6);
                }
            }
        }
        this.f22682o = values;
    }

    public boolean c(float newValue, float oldValue) {
        boolean z3 = this.f22672e;
        this.f22675h = z3;
        if (newValue >= oldValue) {
            this.f22672e = true;
            this.f22673f++;
        } else {
            this.f22674g = this.f22673f;
            this.f22673f = 0;
            this.f22672e = false;
        }
        boolean z4 = this.f22672e;
        if (!z4 && z3 && (this.f22674g >= 2 || oldValue >= 20.0f)) {
            this.f22676i = oldValue;
            return true;
        }
        if (!z3 && z4) {
            this.f22677j = oldValue;
        }
        return false;
    }

    public void d(b listener) {
        this.f22686s = listener;
    }

    public float e(float value) {
        float f4 = this.f22684q;
        int i4 = this.f22671d;
        if (i4 < 4) {
            this.f22670c[i4] = value;
            this.f22671d = i4 + 1;
        } else {
            f4 = a(this.f22670c, 4);
            for (int i5 = 1; i5 < 4; i5++) {
                float[] fArr = this.f22670c;
                fArr[i5 - 1] = fArr[i5];
            }
            this.f22670c[3] = value;
        }
        return f4;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        for (int i4 = 0; i4 < 3; i4++) {
            this.f22668a[i4] = event.values[i4];
        }
        b bVar = this.f22686s;
        if (bVar != null) {
            bVar.b(this.f22668a);
        }
        double[] dArr = this.f22668a;
        float sqrt = (float) Math.sqrt((dArr[0] * dArr[0]) + (dArr[1] * dArr[1]) + (dArr[2] * dArr[2]));
        this.f22681n = sqrt;
        b(sqrt);
    }
}
