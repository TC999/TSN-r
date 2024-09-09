package com.qq.e.comm.plugin.k0.e;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.qq.e.comm.plugin.k0.c;
import com.qq.e.comm.plugin.k0.d;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements com.qq.e.comm.plugin.k0.b, SensorEventListener {

    /* renamed from: d  reason: collision with root package name */
    private final float f44533d;

    /* renamed from: e  reason: collision with root package name */
    private final int f44534e;

    /* renamed from: f  reason: collision with root package name */
    private long f44535f;

    /* renamed from: g  reason: collision with root package name */
    private int f44536g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f44537h;

    /* renamed from: k  reason: collision with root package name */
    private float[] f44540k;

    /* renamed from: l  reason: collision with root package name */
    private double f44541l;

    /* renamed from: r  reason: collision with root package name */
    private long f44547r;

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f44530a = null;

    /* renamed from: b  reason: collision with root package name */
    private Sensor f44531b = null;

    /* renamed from: c  reason: collision with root package name */
    private a f44532c = null;

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f44538i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private final AtomicBoolean f44539j = new AtomicBoolean(false);

    /* renamed from: m  reason: collision with root package name */
    private boolean f44542m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f44543n = true;

    /* renamed from: o  reason: collision with root package name */
    private int f44544o = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f44545p = 0;

    /* renamed from: q  reason: collision with root package name */
    private int[] f44546q = null;

    /* renamed from: s  reason: collision with root package name */
    private float f44548s = 0.0f;

    /* renamed from: t  reason: collision with root package name */
    private float f44549t = 0.0f;

    /* renamed from: u  reason: collision with root package name */
    private float f44550u = 0.0f;

    public b(int i4, int i5) {
        this.f44533d = i4 / 100.0f;
        this.f44534e = i5;
    }

    private void d() {
        SensorManager sensorManager;
        if (this.f44538i.compareAndSet(true, false) && (sensorManager = this.f44530a) != null) {
            try {
                sensorManager.unregisterListener(this);
                d.f44529a--;
            } catch (Throwable th) {
                d.a(6, th);
            }
        }
    }

    private boolean e() {
        if (this.f44542m) {
            int[] iArr = this.f44546q;
            boolean z3 = iArr != null && iArr.length > 0;
            int i4 = this.f44544o;
            return z3 && (i4 > 0 && i4 < this.f44545p);
        }
        return false;
    }

    public void a(a aVar) {
        this.f44532c = aVar;
    }

    public void b(boolean z3) {
        this.f44542m = z3;
    }

    public void c(int i4) {
        this.f44544o = i4;
    }

    @Override // com.qq.e.comm.plugin.k0.b
    public boolean isComplete() {
        return this.f44537h;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i4) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a aVar = this.f44532c;
        if (aVar != null) {
            aVar.a();
        }
        if (this.f44537h || this.f44539j.get()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f44535f < 16) {
            return;
        }
        this.f44535f = currentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = this.f44543n ? fArr[2] * 0.5f : fArr[2];
        double sqrt = Math.sqrt((Math.pow(f4, 2.0d) + Math.pow(f5, 2.0d)) + Math.pow(f6, 2.0d)) / 9.8d;
        if (this.f44532c != null) {
            float f7 = this.f44533d;
            double d4 = this.f44536g * f7;
            Double.isNaN(d4);
            this.f44532c.a(Math.min(((float) (d4 + sqrt)) / (f7 * this.f44534e), 1.0f));
        }
        boolean e4 = e();
        if (sqrt >= this.f44533d) {
            if (e4) {
                a(f4, f5, f6);
            } else {
                int i4 = this.f44536g + 1;
                this.f44536g = i4;
                d1.a("gdt_tag_sensor", "\u5f53\u524d\u6447\u52a8\u6b21\u6570: %s", Integer.valueOf(i4));
            }
        }
        if (sqrt > this.f44541l) {
            this.f44541l = sqrt;
            this.f44540k = sensorEvent.values;
        }
        if (this.f44532c == null || this.f44537h) {
            return;
        }
        if (e4 ? a() : b()) {
            this.f44537h = true;
            this.f44532c.a(this.f44540k);
            d(0);
            d1.a("gdt_tag_sensor", "\u89e6\u53d1\u70b9\u51fb\uff0c\u5f53\u524d\u6447\u52a8\u6b21\u6570: %s", Integer.valueOf(this.f44536g));
        }
    }

    @Override // com.qq.e.comm.plugin.k0.b
    public boolean pause() {
        boolean compareAndSet = this.f44539j.compareAndSet(false, true);
        if (compareAndSet && c.a()) {
            d();
        }
        return compareAndSet;
    }

    @Override // com.qq.e.comm.plugin.k0.b
    public void reset() {
        this.f44535f = 0L;
        this.f44536g = 0;
        this.f44537h = false;
        this.f44548s = 0.0f;
        this.f44549t = 0.0f;
        this.f44550u = 0.0f;
        this.f44547r = 0L;
    }

    @Override // com.qq.e.comm.plugin.k0.b
    public boolean resume() {
        boolean compareAndSet = this.f44539j.compareAndSet(true, false);
        if (compareAndSet && c.a()) {
            c();
        }
        return compareAndSet;
    }

    @Override // com.qq.e.comm.plugin.k0.b
    public void start() {
        SensorManager sensorManager = (SensorManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("sensor");
        this.f44530a = sensorManager;
        this.f44531b = null;
        if (sensorManager != null) {
            if (!this.f44543n) {
                this.f44531b = sensorManager.getDefaultSensor(10);
            } else {
                this.f44531b = sensorManager.getDefaultSensor(1);
            }
        }
        if (this.f44531b == null) {
            return;
        }
        c();
    }

    @Override // com.qq.e.comm.plugin.k0.b
    public void stop() {
        d();
        this.f44530a = null;
        this.f44532c = null;
    }

    private void c() {
        SensorManager sensorManager;
        Sensor sensor;
        if (!this.f44538i.compareAndSet(false, true) || (sensorManager = this.f44530a) == null || (sensor = this.f44531b) == null) {
            return;
        }
        try {
            sensorManager.registerListener(this, sensor, 1);
            d.f44529a++;
        } catch (Throwable th) {
            d.a(2, th);
        }
    }

    public void a(boolean z3) {
        this.f44543n = z3;
    }

    public void b(int i4) {
        this.f44545p = i4;
    }

    private boolean b() {
        return this.f44536g >= this.f44534e;
    }

    public void a(int[] iArr) {
        this.f44546q = iArr;
    }

    private boolean a() {
        int i4 = this.f44536g;
        int i5 = this.f44534e;
        return i4 >= i5 && (i5 <= 1 || System.currentTimeMillis() - this.f44547r > ((long) this.f44544o));
    }

    private void a(float f4, float f5, float f6) {
        int i4;
        int i5;
        int i6;
        int[] iArr;
        d1.a("gdt_tag_sensor", "updateShakeInfoByShakeDirect: x:" + f4 + " y:" + f5 + " z:" + f6 + " last x:" + this.f44548s + " last y:" + this.f44549t + " last z:" + this.f44550u);
        if (this.f44548s == 0.0f) {
            this.f44548s = f4;
        }
        if (this.f44549t == 0.0f) {
            this.f44549t = f5;
        }
        if (this.f44550u == 0.0f) {
            this.f44550u = f6;
        }
        if (this.f44548s * f4 < 0.0f) {
            this.f44548s = f4;
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (this.f44549t * f5 < 0.0f) {
            this.f44549t = f5;
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (this.f44550u * f6 < 0.0f) {
            this.f44550u = f6;
            i6 = 1;
        } else {
            i6 = 0;
        }
        d1.a("gdt_tag_sensor", "onSensorChanged: xChange:" + i4 + " yChange:" + i5 + " zChange:" + i6);
        int i7 = (i4 << 2) | (i5 << 1) | i6;
        StringBuilder sb = new StringBuilder();
        sb.append("onSensorChanged: direct result:");
        sb.append(Integer.toBinaryString(i7));
        d1.a("gdt_tag_sensor", sb.toString());
        for (int i8 : this.f44546q) {
            d1.a("gdt_tag_sensor", "onSensorChanged: ShakeDirectcombine:" + Integer.toBinaryString(i8));
            if ((i7 & i8) == i8) {
                this.f44536g++;
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f44536g == 1) {
                    this.f44547r = currentTimeMillis;
                    d(1);
                    d1.a("gdt_tag_sensor", "mFirstShakeSuccessTime:" + this.f44547r);
                    return;
                } else if (currentTimeMillis - this.f44547r > this.f44545p) {
                    this.f44547r = currentTimeMillis;
                    this.f44536g = 1;
                    d(2);
                    d1.a("gdt_tag_sensor", "shake duration > mShakeMaxDuration, reset mFirstShakeSuccessTime to " + this.f44547r);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    private void d(int i4) {
        if (this.f44542m) {
            v.a(1300001, null, Integer.valueOf(i4), null, null);
        }
    }
}
