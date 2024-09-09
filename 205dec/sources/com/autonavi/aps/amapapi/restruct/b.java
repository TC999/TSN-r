package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AmapSensorManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    SensorManager f11777a;

    /* renamed from: b  reason: collision with root package name */
    Sensor f11778b;

    /* renamed from: c  reason: collision with root package name */
    Sensor f11779c;

    /* renamed from: d  reason: collision with root package name */
    Sensor f11780d;

    /* renamed from: s  reason: collision with root package name */
    private Context f11795s;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11781e = false;

    /* renamed from: f  reason: collision with root package name */
    public double f11782f = 0.0d;

    /* renamed from: g  reason: collision with root package name */
    public float f11783g = 0.0f;

    /* renamed from: t  reason: collision with root package name */
    private float f11796t = 1013.25f;

    /* renamed from: u  reason: collision with root package name */
    private float f11797u = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    Handler f11784h = new Handler();

    /* renamed from: i  reason: collision with root package name */
    double f11785i = 0.0d;

    /* renamed from: j  reason: collision with root package name */
    double f11786j = 0.0d;

    /* renamed from: k  reason: collision with root package name */
    double f11787k = 0.0d;

    /* renamed from: l  reason: collision with root package name */
    double f11788l = 0.0d;

    /* renamed from: m  reason: collision with root package name */
    double[] f11789m = new double[3];

    /* renamed from: n  reason: collision with root package name */
    volatile double f11790n = 0.0d;

    /* renamed from: o  reason: collision with root package name */
    long f11791o = 0;

    /* renamed from: p  reason: collision with root package name */
    long f11792p = 0;

    /* renamed from: q  reason: collision with root package name */
    final int f11793q = 100;

    /* renamed from: r  reason: collision with root package name */
    final int f11794r = 30;

    public b(Context context) {
        this.f11795s = null;
        this.f11777a = null;
        this.f11778b = null;
        this.f11779c = null;
        this.f11780d = null;
        try {
            this.f11795s = context;
            if (this.f11777a == null) {
                this.f11777a = (SensorManager) context.getSystemService("sensor");
            }
            try {
                this.f11778b = this.f11777a.getDefaultSensor(6);
            } catch (Throwable unused) {
            }
            try {
                this.f11779c = this.f11777a.getDefaultSensor(11);
            } catch (Throwable unused2) {
            }
            try {
                this.f11780d = this.f11777a.getDefaultSensor(1);
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "AMapSensorManager", "<init>");
        }
    }

    public final void a() {
        SensorManager sensorManager = this.f11777a;
        if (sensorManager == null || this.f11781e) {
            return;
        }
        this.f11781e = true;
        try {
            Sensor sensor = this.f11778b;
            if (sensor != null) {
                sensorManager.registerListener(this, sensor, 3, this.f11784h);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "AMapSensorManager", "registerListener mPressure");
        }
        try {
            Sensor sensor2 = this.f11779c;
            if (sensor2 != null) {
                this.f11777a.registerListener(this, sensor2, 3, this.f11784h);
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "AMapSensorManager", "registerListener mRotationVector");
        }
        try {
            Sensor sensor3 = this.f11780d;
            if (sensor3 != null) {
                this.f11777a.registerListener(this, sensor3, 3, this.f11784h);
            }
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
        }
    }

    public final void b() {
        SensorManager sensorManager = this.f11777a;
        if (sensorManager == null || !this.f11781e) {
            return;
        }
        this.f11781e = false;
        try {
            Sensor sensor = this.f11778b;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
        } catch (Throwable unused) {
        }
        try {
            Sensor sensor2 = this.f11779c;
            if (sensor2 != null) {
                this.f11777a.unregisterListener(this, sensor2);
            }
        } catch (Throwable unused2) {
        }
        try {
            Sensor sensor3 = this.f11780d;
            if (sensor3 != null) {
                this.f11777a.unregisterListener(this, sensor3);
            }
        } catch (Throwable unused3) {
        }
    }

    public final double c() {
        return this.f11782f;
    }

    public final float d() {
        return this.f11797u;
    }

    public final double e() {
        return this.f11788l;
    }

    public final void f() {
        try {
            b();
            this.f11778b = null;
            this.f11779c = null;
            this.f11777a = null;
            this.f11780d = null;
            this.f11781e = false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "AMapSensorManager", "destroy");
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i4) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        try {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                if (this.f11780d != null) {
                    a((float[]) sensorEvent.values.clone());
                }
            } else if (type != 6) {
                if (type != 11) {
                    return;
                }
                try {
                    if (this.f11779c != null) {
                        c((float[]) sensorEvent.values.clone());
                    }
                } catch (Throwable unused) {
                }
            } else {
                try {
                    if (this.f11778b != null) {
                        float[] fArr = (float[]) sensorEvent.values.clone();
                        this.f11783g = fArr[0];
                        b(fArr);
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    private void c(float[] fArr) {
        if (fArr != null) {
            float[] fArr2 = new float[9];
            SensorManager.getRotationMatrixFromVector(fArr2, fArr);
            float[] fArr3 = new float[3];
            SensorManager.getOrientation(fArr2, fArr3);
            float degrees = (float) Math.toDegrees(fArr3[0]);
            this.f11797u = degrees;
            if (degrees <= 0.0f) {
                degrees += 360.0f;
            }
            this.f11797u = (float) Math.floor(degrees);
        }
    }

    private void b(float[] fArr) {
        if (fArr != null) {
            this.f11782f = com.autonavi.aps.amapapi.utils.j.a(SensorManager.getAltitude(this.f11796t, fArr[0]));
        }
    }

    private void a(float[] fArr) {
        double[] dArr = this.f11789m;
        double d4 = fArr[0] * 0.19999999f;
        Double.isNaN(d4);
        dArr[0] = (dArr[0] * 0.800000011920929d) + d4;
        double d5 = fArr[1] * 0.19999999f;
        Double.isNaN(d5);
        dArr[1] = (dArr[1] * 0.800000011920929d) + d5;
        double d6 = fArr[2] * 0.19999999f;
        Double.isNaN(d6);
        dArr[2] = (dArr[2] * 0.800000011920929d) + d6;
        double d7 = fArr[0];
        double d8 = dArr[0];
        Double.isNaN(d7);
        this.f11785i = d7 - d8;
        double d9 = fArr[1];
        double d10 = dArr[1];
        Double.isNaN(d9);
        this.f11786j = d9 - d10;
        double d11 = fArr[2];
        double d12 = dArr[2];
        Double.isNaN(d11);
        this.f11787k = d11 - d12;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f11791o < 100) {
            return;
        }
        double d13 = this.f11785i;
        double d14 = this.f11786j;
        double d15 = (d13 * d13) + (d14 * d14);
        double d16 = this.f11787k;
        double sqrt = Math.sqrt(d15 + (d16 * d16));
        this.f11792p++;
        this.f11791o = currentTimeMillis;
        this.f11790n += sqrt;
        if (this.f11792p >= 30) {
            double d17 = this.f11790n;
            double d18 = this.f11792p;
            Double.isNaN(d18);
            this.f11788l = d17 / d18;
            this.f11790n = 0.0d;
            this.f11792p = 0L;
        }
    }
}
