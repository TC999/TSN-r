package com.bxkj.student.run.app.step.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* renamed from: com.bxkj.student.run.app.step.accelerometer.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StepDetector implements SensorEventListener {

    /* renamed from: a */
    float[] f19418a = new float[3];

    /* renamed from: b */
    final int f19419b = 4;

    /* renamed from: c */
    float[] f19420c = new float[4];

    /* renamed from: d */
    int f19421d = 0;

    /* renamed from: e */
    boolean f19422e = false;

    /* renamed from: f */
    int f19423f = 0;

    /* renamed from: g */
    int f19424g = 0;

    /* renamed from: h */
    boolean f19425h = false;

    /* renamed from: i */
    float f19426i = 0.0f;

    /* renamed from: j */
    float f19427j = 0.0f;

    /* renamed from: k */
    long f19428k = 0;

    /* renamed from: l */
    long f19429l = 0;

    /* renamed from: m */
    long f19430m = 0;

    /* renamed from: n */
    float f19431n = 0.0f;

    /* renamed from: o */
    float f19432o = 0.0f;

    /* renamed from: p */
    final float f19433p = 1.3f;

    /* renamed from: q */
    float f19434q = 2.0f;

    /* renamed from: r */
    int f19435r = 250;

    /* renamed from: s */
    private StepCountListener f19436s;

    /* renamed from: a */
    public float m39744a(float[] value, int n) {
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
    public void m39743b(float values) {
        float f = this.f19432o;
        if (f == 0.0f) {
            this.f19432o = values;
        } else if (m39742c(values, f)) {
            this.f19429l = this.f19428k;
            long currentTimeMillis = System.currentTimeMillis();
            this.f19430m = currentTimeMillis;
            if (currentTimeMillis - this.f19429l >= this.f19435r && this.f19426i - this.f19427j >= this.f19434q) {
                this.f19428k = currentTimeMillis;
                this.f19436s.mo39745a();
            }
            long j = this.f19430m;
            if (j - this.f19429l >= this.f19435r) {
                float f2 = this.f19426i;
                float f3 = this.f19427j;
                if (f2 - f3 >= 1.3f) {
                    this.f19428k = j;
                    this.f19434q = m39740e(f2 - f3);
                }
            }
        }
        this.f19432o = values;
    }

    /* renamed from: c */
    public boolean m39742c(float newValue, float oldValue) {
        boolean z = this.f19422e;
        this.f19425h = z;
        if (newValue >= oldValue) {
            this.f19422e = true;
            this.f19423f++;
        } else {
            this.f19424g = this.f19423f;
            this.f19423f = 0;
            this.f19422e = false;
        }
        boolean z2 = this.f19422e;
        if (!z2 && z && (this.f19424g >= 2 || oldValue >= 20.0f)) {
            this.f19426i = oldValue;
            return true;
        }
        if (!z && z2) {
            this.f19427j = oldValue;
        }
        return false;
    }

    /* renamed from: d */
    public void m39741d(StepCountListener listener) {
        this.f19436s = listener;
    }

    /* renamed from: e */
    public float m39740e(float value) {
        float f = this.f19434q;
        int i = this.f19421d;
        if (i < 4) {
            this.f19420c[i] = value;
            this.f19421d = i + 1;
        } else {
            f = m39744a(this.f19420c, 4);
            for (int i2 = 1; i2 < 4; i2++) {
                float[] fArr = this.f19420c;
                fArr[i2 - 1] = fArr[i2];
            }
            this.f19420c[3] = value;
        }
        return f;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        for (int i = 0; i < 3; i++) {
            this.f19418a[i] = event.values[i];
        }
        float[] fArr = this.f19418a;
        float sqrt = (float) Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
        this.f19431n = sqrt;
        m39743b(sqrt);
    }
}
