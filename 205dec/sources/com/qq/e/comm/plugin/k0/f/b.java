package com.qq.e.comm.plugin.k0.f;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.SystemClock;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import java.util.Arrays;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends a {

    /* renamed from: n  reason: collision with root package name */
    private int f44564n;

    /* renamed from: o  reason: collision with root package name */
    private Sensor f44565o;

    /* renamed from: p  reason: collision with root package name */
    private Sensor f44566p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f44567q;

    /* renamed from: r  reason: collision with root package name */
    protected int[] f44568r;

    /* renamed from: s  reason: collision with root package name */
    private float[] f44569s;

    /* renamed from: t  reason: collision with root package name */
    private float[] f44570t;

    /* renamed from: u  reason: collision with root package name */
    private final float[] f44571u;

    /* renamed from: v  reason: collision with root package name */
    private final float[] f44572v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f44573w;

    /* renamed from: x  reason: collision with root package name */
    private long f44574x;

    public b(SensorManager sensorManager, Sensor sensor, Sensor sensor2, int i4, int i5, int i6) {
        super(i4, i5, i6);
        this.f44567q = false;
        this.f44568r = new int[3];
        this.f44571u = new float[3];
        this.f44572v = new float[9];
        this.f44573w = false;
        this.f44551a = sensorManager;
        if (sensor == null || sensor2 == null) {
            return;
        }
        this.f44564n = sensor.getType();
        this.f44565o = sensor;
        this.f44566p = sensor2;
    }

    @Override // com.qq.e.comm.plugin.k0.f.a, com.qq.e.comm.plugin.k0.f.e
    public void a(Sensor sensor, Sensor sensor2) {
        d1.a("PluginLogger.TAG_SENSOR", "onSensorReady");
        if (sensor == null || sensor2 == null) {
            return;
        }
        this.f44564n = sensor.getType();
        this.f44565o = sensor;
        this.f44566p = sensor2;
        if (this.f44573w) {
            b();
            v.a(9130020, null, Integer.valueOf(Math.min((int) ((SystemClock.elapsedRealtime() - this.f44574x) / 500), 20)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.k0.f.a
    public void b() {
        if (this.f44566p != null && this.f44565o != null) {
            super.b();
            if (this.f44561k.compareAndSet(false, true)) {
                try {
                    if (this.f44551a != null) {
                        this.f44551a.registerListener(this, this.f44565o, 2);
                        this.f44551a.registerListener(this, this.f44566p, 2);
                        com.qq.e.comm.plugin.k0.d.f44529a++;
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.qq.e.comm.plugin.k0.d.a(3, th);
                    d1.a("gdt_tag_sensor", "sensorManager.registerListener fail", th);
                    return;
                }
            }
            return;
        }
        this.f44573w = true;
        this.f44574x = SystemClock.elapsedRealtime();
    }

    @Override // com.qq.e.comm.plugin.k0.f.a
    protected void d() {
        SensorManager sensorManager;
        if (this.f44566p != null && this.f44565o != null) {
            if (this.f44561k.compareAndSet(true, false) && (sensorManager = this.f44551a) != null) {
                try {
                    sensorManager.unregisterListener(this);
                    com.qq.e.comm.plugin.k0.d.f44529a--;
                    return;
                } catch (Throwable th) {
                    com.qq.e.comm.plugin.k0.d.a(7, th);
                    return;
                }
            }
            return;
        }
        this.f44573w = false;
    }

    @Override // com.qq.e.comm.plugin.k0.f.a, android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        super.onSensorChanged(sensorEvent);
        if (this.f44563m || this.f44562l.get()) {
            return;
        }
        if (this.f44564n == sensorEvent.sensor.getType()) {
            float[] fArr = sensorEvent.values;
            this.f44569s = fArr;
            float[] fArr2 = this.f44570t;
            if (fArr2 == null) {
                return;
            }
            SensorManager.getRotationMatrix(this.f44572v, null, fArr, fArr2);
            SensorManager.getOrientation(this.f44572v, this.f44571u);
            int degrees = (int) Math.toDegrees(this.f44571u[1]);
            if (this.f44569s[2] < 0.0f) {
                degrees = degrees > 0 ? 180 - degrees : (-180) - degrees;
            }
            int degrees2 = (int) Math.toDegrees(this.f44571u[2]);
            int degrees3 = (int) Math.toDegrees(this.f44571u[0]);
            if (!this.f44567q) {
                int[] iArr = this.f44568r;
                iArr[0] = degrees;
                iArr[1] = degrees2;
                iArr[2] = degrees3;
                this.f44567q = true;
                return;
            }
            this.f44560j[0] = -c(degrees - this.f44568r[0]);
            this.f44560j[1] = c(degrees2 - this.f44568r[1]);
            this.f44560j[2] = -c(degrees3 - this.f44568r[2]);
            a();
        } else if (2 == sensorEvent.sensor.getType()) {
            this.f44570t = sensorEvent.values;
        }
    }

    @Override // com.qq.e.comm.plugin.k0.f.a, com.qq.e.comm.plugin.k0.b
    public void reset() {
        super.reset();
        this.f44567q = false;
        Arrays.fill(this.f44568r, 0);
        Arrays.fill(this.f44571u, 0.0f);
        Arrays.fill(this.f44572v, 0.0f);
        this.f44569s = null;
        this.f44570t = null;
    }
}
