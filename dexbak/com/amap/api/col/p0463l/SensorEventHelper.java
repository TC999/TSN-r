package com.amap.api.col.p0463l;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.stub.StubApp;
import com.umeng.analytics.pro.UMCommonContent;

/* renamed from: com.amap.api.col.3l.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SensorEventHelper implements SensorEventListener {

    /* renamed from: a */
    private SensorManager f4075a;

    /* renamed from: b */
    private Sensor f4076b;

    /* renamed from: c */
    private Sensor f4077c;

    /* renamed from: d */
    private Sensor f4078d;

    /* renamed from: e */
    private Context f4079e;

    /* renamed from: f */
    private IAMapDelegate f4080f;

    /* renamed from: g */
    private Marker f4081g;

    /* renamed from: h */
    private float f4082h;

    /* renamed from: i */
    private float[] f4083i = new float[3];

    /* renamed from: j */
    private float[] f4084j = new float[3];

    /* renamed from: k */
    private float[] f4085k = new float[3];

    /* renamed from: l */
    private float[] f4086l = new float[9];

    /* renamed from: m */
    private boolean f4087m = true;

    public SensorEventHelper(Context context, IAMapDelegate iAMapDelegate) {
        this.f4079e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f4080f = iAMapDelegate;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService(UMCommonContent.f37799ac);
            this.f4075a = sensorManager;
            if (sensorManager != null && m55099j()) {
                this.f4076b = this.f4075a.getDefaultSensor(3);
                return;
            }
            this.f4077c = this.f4075a.getDefaultSensor(1);
            this.f4078d = this.f4075a.getDefaultSensor(2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private float m55108a(float f) {
        return m55102g(f);
    }

    /* renamed from: b */
    private float m55107b(float[] fArr, float[] fArr2) {
        if (SensorManager.getRotationMatrix(this.f4086l, null, fArr, fArr2)) {
            SensorManager.getOrientation(this.f4086l, this.f4085k);
            float[] fArr3 = this.f4085k;
            fArr3[0] = (float) Math.toDegrees(fArr3[0]);
            return this.f4085k[0];
        }
        return 0.0f;
    }

    /* renamed from: c */
    private static int m55106c(Context context) {
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

    /* renamed from: g */
    private float m55102g(float f) {
        float m55106c = (f + m55106c(this.f4079e)) % 360.0f;
        if (m55106c > 180.0f) {
            m55106c -= 360.0f;
        } else if (m55106c < -180.0f) {
            m55106c += 360.0f;
        }
        if (Float.isNaN(m55106c)) {
            return 0.0f;
        }
        return m55106c;
    }

    /* renamed from: i */
    private void m55100i(float f) {
        Marker marker = this.f4081g;
        if (marker != null) {
            try {
                if (this.f4087m) {
                    this.f4080f.moveCamera(CameraUpdateFactoryDelegate.m54538q(f));
                    this.f4081g.setRotateAngle(-f);
                    return;
                }
                marker.setRotateAngle(360.0f - f);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: j */
    private boolean m55099j() {
        SensorManager sensorManager = this.f4075a;
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

    /* renamed from: d */
    public final void m55105d() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f4075a;
        if (sensorManager != null && (sensor2 = this.f4076b) != null) {
            sensorManager.registerListener(this, sensor2, 3);
        }
        SensorManager sensorManager2 = this.f4075a;
        if (sensorManager2 == null || (sensor = this.f4077c) == null || this.f4078d == null) {
            return;
        }
        sensorManager2.registerListener(this, sensor, 3);
        this.f4075a.registerListener(this, this.f4078d, 3);
    }

    /* renamed from: e */
    public final void m55104e(Marker marker) {
        this.f4081g = marker;
    }

    /* renamed from: f */
    public final void m55103f(boolean z) {
        this.f4087m = z;
    }

    /* renamed from: h */
    public final void m55101h() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f4075a;
        if (sensorManager != null && (sensor2 = this.f4076b) != null) {
            sensorManager.unregisterListener(this, sensor2);
        }
        SensorManager sensorManager2 = this.f4075a;
        if (sensorManager2 == null || (sensor = this.f4077c) == null || this.f4078d == null) {
            return;
        }
        sensorManager2.unregisterListener(this, sensor);
        this.f4075a.unregisterListener(this, this.f4078d);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (this.f4080f.getGLMapEngine() == null || this.f4080f.getGLMapEngine().getAnimateionsCount() <= 0) {
                int type = sensorEvent.sensor.getType();
                if (type == 3) {
                    float f = sensorEvent.values[0];
                    float m55108a = m55108a(f);
                    if (Math.abs(this.f4082h - f) < 3.0f) {
                        return;
                    }
                    this.f4082h = m55108a;
                    m55100i(m55108a);
                    return;
                }
                if (type == 1) {
                    this.f4083i = (float[]) sensorEvent.values.clone();
                } else if (type == 2) {
                    this.f4084j = (float[]) sensorEvent.values.clone();
                }
                float m55107b = m55107b(this.f4083i, this.f4084j);
                if (Math.abs(this.f4082h - m55107b) < 3.0f) {
                    return;
                }
                this.f4082h = m55107b;
                m55100i(m55107b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
