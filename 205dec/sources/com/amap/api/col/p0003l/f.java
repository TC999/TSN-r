package com.amap.api.col.p0003l;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SensorEventHelper.java */
/* renamed from: com.amap.api.col.3l.f  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f7653a;

    /* renamed from: b  reason: collision with root package name */
    private Sensor f7654b;

    /* renamed from: c  reason: collision with root package name */
    private Sensor f7655c;

    /* renamed from: d  reason: collision with root package name */
    private Sensor f7656d;

    /* renamed from: e  reason: collision with root package name */
    private Context f7657e;

    /* renamed from: f  reason: collision with root package name */
    private IAMapDelegate f7658f;

    /* renamed from: g  reason: collision with root package name */
    private Marker f7659g;

    /* renamed from: h  reason: collision with root package name */
    private float f7660h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f7661i = new float[3];

    /* renamed from: j  reason: collision with root package name */
    private float[] f7662j = new float[3];

    /* renamed from: k  reason: collision with root package name */
    private float[] f7663k = new float[3];

    /* renamed from: l  reason: collision with root package name */
    private float[] f7664l = new float[9];

    /* renamed from: m  reason: collision with root package name */
    private boolean f7665m = true;

    public f(Context context, IAMapDelegate iAMapDelegate) {
        this.f7657e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f7658f = iAMapDelegate;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f7653a = sensorManager;
            if (sensorManager != null && j()) {
                this.f7654b = this.f7653a.getDefaultSensor(3);
                return;
            }
            this.f7655c = this.f7653a.getDefaultSensor(1);
            this.f7656d = this.f7653a.getDefaultSensor(2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private float a(float f4) {
        return g(f4);
    }

    private float b(float[] fArr, float[] fArr2) {
        if (SensorManager.getRotationMatrix(this.f7664l, null, fArr, fArr2)) {
            SensorManager.getOrientation(this.f7664l, this.f7663k);
            float[] fArr3 = this.f7663k;
            fArr3[0] = (float) Math.toDegrees(fArr3[0]);
            return this.f7663k[0];
        }
        return 0.0f;
    }

    private static int c(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return 0;
        }
        try {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation != 1) {
                if (rotation != 2) {
                    return rotation != 3 ? 0 : -90;
                }
                return 180;
            }
            return 90;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private float g(float f4) {
        float c4 = (f4 + c(this.f7657e)) % 360.0f;
        if (c4 > 180.0f) {
            c4 -= 360.0f;
        } else if (c4 < -180.0f) {
            c4 += 360.0f;
        }
        if (Float.isNaN(c4)) {
            return 0.0f;
        }
        return c4;
    }

    private void i(float f4) {
        Marker marker = this.f7659g;
        if (marker != null) {
            try {
                if (this.f7665m) {
                    this.f7658f.moveCamera(m.q(f4));
                    this.f7659g.setRotateAngle(-f4);
                    return;
                }
                marker.setRotateAngle(360.0f - f4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean j() {
        SensorManager sensorManager = this.f7653a;
        if (sensorManager == null) {
            return false;
        }
        for (Sensor sensor : sensorManager.getSensorList(-1)) {
            int type = sensor.getType();
            sensor.getStringType();
            if (type == 3) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f7653a;
        if (sensorManager != null && (sensor2 = this.f7654b) != null) {
            sensorManager.registerListener(this, sensor2, 3);
        }
        SensorManager sensorManager2 = this.f7653a;
        if (sensorManager2 == null || (sensor = this.f7655c) == null || this.f7656d == null) {
            return;
        }
        sensorManager2.registerListener(this, sensor, 3);
        this.f7653a.registerListener(this, this.f7656d, 3);
    }

    public final void e(Marker marker) {
        this.f7659g = marker;
    }

    public final void f(boolean z3) {
        this.f7665m = z3;
    }

    public final void h() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f7653a;
        if (sensorManager != null && (sensor2 = this.f7654b) != null) {
            sensorManager.unregisterListener(this, sensor2);
        }
        SensorManager sensorManager2 = this.f7653a;
        if (sensorManager2 == null || (sensor = this.f7655c) == null || this.f7656d == null) {
            return;
        }
        sensorManager2.unregisterListener(this, sensor);
        this.f7653a.unregisterListener(this, this.f7656d);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i4) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (this.f7658f.getGLMapEngine() == null || this.f7658f.getGLMapEngine().getAnimateionsCount() <= 0) {
                int type = sensorEvent.sensor.getType();
                if (type == 3) {
                    float f4 = sensorEvent.values[0];
                    float a4 = a(f4);
                    if (Math.abs(this.f7660h - f4) < 3.0f) {
                        return;
                    }
                    this.f7660h = a4;
                    i(a4);
                    return;
                }
                if (type == 1) {
                    this.f7661i = (float[]) sensorEvent.values.clone();
                } else if (type == 2) {
                    this.f7662j = (float[]) sensorEvent.values.clone();
                }
                float b4 = b(this.f7661i, this.f7662j);
                if (Math.abs(this.f7660h - b4) < 3.0f) {
                    return;
                }
                this.f7660h = b4;
                i(b4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
