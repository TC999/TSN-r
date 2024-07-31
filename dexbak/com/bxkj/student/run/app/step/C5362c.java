package com.bxkj.student.run.app.step;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: StepDetector.java */
/* renamed from: com.bxkj.student.run.app.step.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C5362c implements SensorEventListener {

    /* renamed from: a */
    double[] f19437a = new double[3];

    /* renamed from: b */
    final int f19438b = 4;

    /* renamed from: c */
    float[] f19439c = new float[4];

    /* renamed from: d */
    int f19440d = 0;

    /* renamed from: e */
    boolean f19441e = false;

    /* renamed from: f */
    int f19442f = 0;

    /* renamed from: g */
    int f19443g = 0;

    /* renamed from: h */
    boolean f19444h = false;

    /* renamed from: i */
    float f19445i = 0.0f;

    /* renamed from: j */
    float f19446j = 0.0f;

    /* renamed from: k */
    long f19447k = 0;

    /* renamed from: l */
    long f19448l = 0;

    /* renamed from: m */
    long f19449m = 0;

    /* renamed from: n */
    float f19450n = 0.0f;

    /* renamed from: o */
    float f19451o = 0.0f;

    /* renamed from: p */
    final float f19452p = 1.3f;

    /* renamed from: q */
    float f19453q = 2.0f;

    /* renamed from: r */
    int f19454r = 250;

    /* renamed from: s */
    private InterfaceC5361b f19455s;

    /* renamed from: a */
    public float m39737a(float[] value, int n) {
        float f = 0.0f;
        for (int i = 0; i < n; i++) {
            f += value[i];
        }
        float f2 = f / 4.0f;
        if (f2 >= 8.0f) {
            return 4.3f;
        }
        if (f2 < 7.0f || f2 >= 8.0f) {
            if (f2 < 4.0f || f2 >= 7.0f) {
                return (f2 < 3.0f || f2 >= 4.0f) ? 1.3f : 2.0f;
            }
            return 2.3f;
        }
        return 3.3f;
    }

    /* renamed from: b */
    public void m39736b(float values) {
        float f = this.f19451o;
        if (f == 0.0f) {
            this.f19451o = values;
        } else if (m39735c(values, f)) {
            this.f19448l = this.f19447k;
            long currentTimeMillis = System.currentTimeMillis();
            this.f19449m = currentTimeMillis;
            if (currentTimeMillis - this.f19448l >= this.f19454r && this.f19445i - this.f19446j >= this.f19453q) {
                this.f19447k = currentTimeMillis;
                InterfaceC5361b interfaceC5361b = this.f19455s;
                if (interfaceC5361b != null) {
                    interfaceC5361b.m39739a();
                }
            }
            long j = this.f19449m;
            if (j - this.f19448l >= this.f19454r) {
                float f2 = this.f19445i;
                float f3 = this.f19446j;
                if (f2 - f3 >= 1.3f) {
                    this.f19447k = j;
                    this.f19453q = m39733e(f2 - f3);
                }
            }
        }
        this.f19451o = values;
    }

    /* renamed from: c */
    public boolean m39735c(float newValue, float oldValue) {
        boolean z = this.f19441e;
        this.f19444h = z;
        if (newValue >= oldValue) {
            this.f19441e = true;
            this.f19442f++;
        } else {
            this.f19443g = this.f19442f;
            this.f19442f = 0;
            this.f19441e = false;
        }
        boolean z2 = this.f19441e;
        if (!z2 && z && (this.f19443g >= 2 || oldValue >= 20.0f)) {
            this.f19445i = oldValue;
            return true;
        }
        if (!z && z2) {
            this.f19446j = oldValue;
        }
        return false;
    }

    /* renamed from: d */
    public void m39734d(InterfaceC5361b listener) {
        this.f19455s = listener;
    }

    /* renamed from: e */
    public float m39733e(float value) {
        float f = this.f19453q;
        int i = this.f19440d;
        if (i < 4) {
            this.f19439c[i] = value;
            this.f19440d = i + 1;
        } else {
            f = m39737a(this.f19439c, 4);
            for (int i2 = 1; i2 < 4; i2++) {
                float[] fArr = this.f19439c;
                fArr[i2 - 1] = fArr[i2];
            }
            this.f19439c[3] = value;
        }
        return f;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        for (int i = 0; i < 3; i++) {
            this.f19437a[i] = event.values[i];
        }
        InterfaceC5361b interfaceC5361b = this.f19455s;
        if (interfaceC5361b != null) {
            interfaceC5361b.m39738b(this.f19437a);
        }
        double[] dArr = this.f19437a;
        float sqrt = (float) Math.sqrt((dArr[0] * dArr[0]) + (dArr[1] * dArr[1]) + (dArr[2] * dArr[2]));
        this.f19450n = sqrt;
        m39736b(sqrt);
    }
}
