package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.github.mikephil.charting.utils.Utils;
import com.umeng.analytics.pro.UMCommonContent;

/* renamed from: com.autonavi.aps.amapapi.restruct.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AmapSensorManager implements SensorEventListener {

    /* renamed from: a */
    SensorManager f8100a;

    /* renamed from: b */
    Sensor f8101b;

    /* renamed from: c */
    Sensor f8102c;

    /* renamed from: d */
    Sensor f8103d;

    /* renamed from: s */
    private Context f8118s;

    /* renamed from: e */
    public boolean f8104e = false;

    /* renamed from: f */
    public double f8105f = Utils.DOUBLE_EPSILON;

    /* renamed from: g */
    public float f8106g = 0.0f;

    /* renamed from: t */
    private float f8119t = 1013.25f;

    /* renamed from: u */
    private float f8120u = 0.0f;

    /* renamed from: h */
    Handler f8107h = new Handler();

    /* renamed from: i */
    double f8108i = Utils.DOUBLE_EPSILON;

    /* renamed from: j */
    double f8109j = Utils.DOUBLE_EPSILON;

    /* renamed from: k */
    double f8110k = Utils.DOUBLE_EPSILON;

    /* renamed from: l */
    double f8111l = Utils.DOUBLE_EPSILON;

    /* renamed from: m */
    double[] f8112m = new double[3];

    /* renamed from: n */
    volatile double f8113n = Utils.DOUBLE_EPSILON;

    /* renamed from: o */
    long f8114o = 0;

    /* renamed from: p */
    long f8115p = 0;

    /* renamed from: q */
    final int f8116q = 100;

    /* renamed from: r */
    final int f8117r = 30;

    public AmapSensorManager(Context context) {
        this.f8118s = null;
        this.f8100a = null;
        this.f8101b = null;
        this.f8102c = null;
        this.f8103d = null;
        try {
            this.f8118s = context;
            if (this.f8100a == null) {
                this.f8100a = (SensorManager) context.getSystemService(UMCommonContent.f37799ac);
            }
            try {
                this.f8101b = this.f8100a.getDefaultSensor(6);
            } catch (Throwable unused) {
            }
            try {
                this.f8102c = this.f8100a.getDefaultSensor(11);
            } catch (Throwable unused2) {
            }
            try {
                this.f8103d = this.f8100a.getDefaultSensor(1);
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMapSensorManager", "<init>");
        }
    }

    /* renamed from: a */
    public final void m51592a() {
        SensorManager sensorManager = this.f8100a;
        if (sensorManager == null || this.f8104e) {
            return;
        }
        this.f8104e = true;
        try {
            Sensor sensor = this.f8101b;
            if (sensor != null) {
                sensorManager.registerListener(this, sensor, 3, this.f8107h);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMapSensorManager", "registerListener mPressure");
        }
        try {
            Sensor sensor2 = this.f8102c;
            if (sensor2 != null) {
                this.f8100a.registerListener(this, sensor2, 3, this.f8107h);
            }
        } catch (Throwable th2) {
            C2428b.m51299a(th2, "AMapSensorManager", "registerListener mRotationVector");
        }
        try {
            Sensor sensor3 = this.f8103d;
            if (sensor3 != null) {
                this.f8100a.registerListener(this, sensor3, 3, this.f8107h);
            }
        } catch (Throwable th3) {
            C2428b.m51299a(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
        }
    }

    /* renamed from: b */
    public final void m51590b() {
        SensorManager sensorManager = this.f8100a;
        if (sensorManager == null || !this.f8104e) {
            return;
        }
        this.f8104e = false;
        try {
            Sensor sensor = this.f8101b;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
        } catch (Throwable unused) {
        }
        try {
            Sensor sensor2 = this.f8102c;
            if (sensor2 != null) {
                this.f8100a.unregisterListener(this, sensor2);
            }
        } catch (Throwable unused2) {
        }
        try {
            Sensor sensor3 = this.f8103d;
            if (sensor3 != null) {
                this.f8100a.unregisterListener(this, sensor3);
            }
        } catch (Throwable unused3) {
        }
    }

    /* renamed from: c */
    public final double m51588c() {
        return this.f8105f;
    }

    /* renamed from: d */
    public final float m51586d() {
        return this.f8120u;
    }

    /* renamed from: e */
    public final double m51585e() {
        return this.f8111l;
    }

    /* renamed from: f */
    public final void m51584f() {
        try {
            m51590b();
            this.f8101b = null;
            this.f8102c = null;
            this.f8100a = null;
            this.f8103d = null;
            this.f8104e = false;
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMapSensorManager", "destroy");
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        try {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                if (this.f8103d != null) {
                    m51591a((float[]) sensorEvent.values.clone());
                }
            } else if (type != 6) {
                if (type != 11) {
                    return;
                }
                try {
                    if (this.f8102c != null) {
                        m51587c((float[]) sensorEvent.values.clone());
                    }
                } catch (Throwable unused) {
                }
            } else {
                try {
                    if (this.f8101b != null) {
                        float[] fArr = (float[]) sensorEvent.values.clone();
                        this.f8106g = fArr[0];
                        m51589b(fArr);
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    /* renamed from: c */
    private void m51587c(float[] fArr) {
        if (fArr != null) {
            float[] fArr2 = new float[9];
            SensorManager.getRotationMatrixFromVector(fArr2, fArr);
            float[] fArr3 = new float[3];
            SensorManager.getOrientation(fArr2, fArr3);
            float degrees = (float) Math.toDegrees(fArr3[0]);
            this.f8120u = degrees;
            if (degrees <= 0.0f) {
                degrees += 360.0f;
            }
            this.f8120u = (float) Math.floor(degrees);
        }
    }

    /* renamed from: b */
    private void m51589b(float[] fArr) {
        if (fArr != null) {
            this.f8105f = C2432j.m51209a(SensorManager.getAltitude(this.f8119t, fArr[0]));
        }
    }

    /* renamed from: a */
    private void m51591a(float[] fArr) {
        double[] dArr = this.f8112m;
        double d = fArr[0] * 0.19999999f;
        Double.isNaN(d);
        dArr[0] = (dArr[0] * 0.800000011920929d) + d;
        double d2 = fArr[1] * 0.19999999f;
        Double.isNaN(d2);
        dArr[1] = (dArr[1] * 0.800000011920929d) + d2;
        double d3 = fArr[2] * 0.19999999f;
        Double.isNaN(d3);
        dArr[2] = (dArr[2] * 0.800000011920929d) + d3;
        double d4 = fArr[0];
        double d5 = dArr[0];
        Double.isNaN(d4);
        this.f8108i = d4 - d5;
        double d6 = fArr[1];
        double d7 = dArr[1];
        Double.isNaN(d6);
        this.f8109j = d6 - d7;
        double d8 = fArr[2];
        double d9 = dArr[2];
        Double.isNaN(d8);
        this.f8110k = d8 - d9;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f8114o < 100) {
            return;
        }
        double d10 = this.f8108i;
        double d11 = this.f8109j;
        double d12 = (d10 * d10) + (d11 * d11);
        double d13 = this.f8110k;
        double sqrt = Math.sqrt(d12 + (d13 * d13));
        this.f8115p++;
        this.f8114o = currentTimeMillis;
        this.f8113n += sqrt;
        if (this.f8115p >= 30) {
            double d14 = this.f8113n;
            double d15 = this.f8115p;
            Double.isNaN(d15);
            this.f8111l = d14 / d15;
            this.f8113n = Utils.DOUBLE_EPSILON;
            this.f8115p = 0L;
        }
    }
}
