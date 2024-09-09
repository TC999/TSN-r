package com.qq.e.comm.plugin.k0.f;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends a {

    /* renamed from: n  reason: collision with root package name */
    private final Sensor f44575n;

    /* renamed from: o  reason: collision with root package name */
    private double f44576o;

    /* renamed from: p  reason: collision with root package name */
    private double f44577p;

    /* renamed from: q  reason: collision with root package name */
    private double f44578q;

    /* renamed from: r  reason: collision with root package name */
    private long f44579r;

    public c(SensorManager sensorManager, Sensor sensor, int i4, int i5, int i6) {
        super(i4, i5, i6);
        this.f44576o = 0.0d;
        this.f44577p = 0.0d;
        this.f44578q = 0.0d;
        this.f44579r = 0L;
        this.f44551a = sensorManager;
        this.f44575n = sensor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.k0.f.a
    public void b() {
        super.b();
        if (this.f44561k.compareAndSet(false, true)) {
            try {
                if (this.f44551a != null) {
                    this.f44551a.registerListener(this, this.f44575n, 2);
                    com.qq.e.comm.plugin.k0.d.f44529a++;
                }
            } catch (Throwable th) {
                com.qq.e.comm.plugin.k0.d.a(4, th);
                d1.a("gdt_tag_sensor", "sensorManager.registerListener fail", th);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.k0.f.a
    protected void d() {
        SensorManager sensorManager;
        if (this.f44561k.compareAndSet(true, false) && (sensorManager = this.f44551a) != null) {
            try {
                sensorManager.unregisterListener(this);
                com.qq.e.comm.plugin.k0.d.f44529a--;
            } catch (Throwable th) {
                com.qq.e.comm.plugin.k0.d.a(8, th);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.k0.f.a, android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        super.onSensorChanged(sensorEvent);
        if (this.f44563m || this.f44562l.get() || sensorEvent.sensor.getType() != 4) {
            return;
        }
        long j4 = this.f44579r;
        if (j4 != 0) {
            long j5 = sensorEvent.timestamp;
            float f4 = ((float) (j5 - j4)) * 1.0E-9f;
            this.f44579r = j5;
            double d4 = this.f44576o;
            float[] fArr = sensorEvent.values;
            double d5 = fArr[0] * f4;
            Double.isNaN(d5);
            double d6 = d4 + d5;
            this.f44576o = d6;
            double d7 = this.f44577p;
            double d8 = fArr[1] * f4;
            Double.isNaN(d8);
            this.f44577p = d7 + d8;
            double d9 = this.f44578q;
            double d10 = fArr[2] * f4;
            Double.isNaN(d10);
            this.f44578q = d9 + d10;
            this.f44560j[0] = c(((int) Math.toDegrees(d6)) % 360);
            this.f44560j[1] = c(((int) Math.toDegrees(this.f44577p)) % 360);
            this.f44560j[2] = c(((int) Math.toDegrees(this.f44578q)) % 360);
            a();
            return;
        }
        this.f44579r = sensorEvent.timestamp;
    }

    @Override // com.qq.e.comm.plugin.k0.f.a, com.qq.e.comm.plugin.k0.b
    public void reset() {
        super.reset();
        this.f44576o = 0.0d;
        this.f44577p = 0.0d;
        this.f44578q = 0.0d;
        this.f44579r = 0L;
    }
}
