package com.qq.e.comm.plugin.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.qq.e.comm.plugin.util.d1;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h implements g {

    /* renamed from: j  reason: collision with root package name */
    private static final long f42713j = com.qq.e.comm.plugin.d0.a.d().f().a("sksdrqst", 5) * 1000;

    /* renamed from: a  reason: collision with root package name */
    private final SensorManager f42714a;

    /* renamed from: b  reason: collision with root package name */
    private Sensor f42715b;

    /* renamed from: c  reason: collision with root package name */
    private Sensor f42716c;

    /* renamed from: d  reason: collision with root package name */
    private final b f42717d = new b();

    /* renamed from: e  reason: collision with root package name */
    private float[] f42718e = null;

    /* renamed from: f  reason: collision with root package name */
    private float[] f42719f = null;

    /* renamed from: g  reason: collision with root package name */
    private int[] f42720g = {-999, -999, -999};

    /* renamed from: h  reason: collision with root package name */
    private final AtomicBoolean f42721h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private long f42722i = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements SensorEventListener {
        private b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                h.this.f42718e = sensorEvent.values;
            } else if (type == 2) {
                h.this.f42719f = sensorEvent.values;
            }
            if (h.this.f42718e == null || h.this.f42719f == null) {
                return;
            }
            h.this.c();
            h.this.stop();
        }
    }

    public h(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f42714a = sensorManager;
        if (sensorManager != null) {
            this.f42715b = com.qq.e.comm.plugin.k0.a.b().a(1);
            this.f42716c = com.qq.e.comm.plugin.k0.a.b().a(2);
        }
    }

    private void d() {
        Sensor sensor;
        if (this.f42721h.compareAndSet(false, true)) {
            if (this.f42715b == null || this.f42716c == null) {
                this.f42715b = com.qq.e.comm.plugin.k0.a.b().a(1);
                this.f42716c = com.qq.e.comm.plugin.k0.a.b().a(2);
            }
            SensorManager sensorManager = this.f42714a;
            if (sensorManager == null || (sensor = this.f42715b) == null || this.f42716c == null) {
                return;
            }
            try {
                sensorManager.registerListener(this.f42717d, sensor, 1);
                this.f42714a.registerListener(this.f42717d, this.f42716c, 1);
                com.qq.e.comm.plugin.k0.d.f44529a++;
            } catch (Throwable th) {
                com.qq.e.comm.plugin.k0.d.a(1, th);
                d1.a("AntiSpam", "sensorManager.registerListener fail", th);
            }
        }
    }

    private void e() {
        if (this.f42721h.compareAndSet(true, false)) {
            SensorManager sensorManager = this.f42714a;
            if (sensorManager != null) {
                try {
                    sensorManager.unregisterListener(this.f42717d);
                    com.qq.e.comm.plugin.k0.d.f44529a--;
                } catch (Throwable th) {
                    com.qq.e.comm.plugin.k0.d.a(5, th);
                }
            }
            this.f42718e = null;
            this.f42719f = null;
        }
    }

    @Override // com.qq.e.comm.plugin.e.g
    public void start() {
        if (System.currentTimeMillis() - this.f42722i < f42713j) {
            return;
        }
        this.f42722i = System.currentTimeMillis();
        d();
    }

    @Override // com.qq.e.comm.plugin.e.g
    public void stop() {
        e();
    }

    @Override // com.qq.e.comm.plugin.e.g
    public int[] a() {
        return this.f42720g;
    }

    @Override // com.qq.e.comm.plugin.e.g
    public boolean b() {
        return this.f42721h.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.f42718e, this.f42719f);
        SensorManager.getOrientation(fArr2, fArr);
        this.f42720g = new int[]{(int) Math.toDegrees(fArr[1]), (int) Math.toDegrees(fArr[2]), (int) Math.toDegrees(fArr[0])};
    }
}
