package com.qq.e.comm.plugin.k0.f;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.util.Pair;
import com.qq.e.comm.plugin.n0.v;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    protected SensorManager f44551a;

    /* renamed from: b  reason: collision with root package name */
    private final int f44552b;

    /* renamed from: g  reason: collision with root package name */
    private final int f44557g;

    /* renamed from: h  reason: collision with root package name */
    private d f44558h;

    /* renamed from: c  reason: collision with root package name */
    private int f44553c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f44554d = -1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f44555e = false;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f44556f = new boolean[6];

    /* renamed from: i  reason: collision with root package name */
    private long f44559i = 0;

    /* renamed from: j  reason: collision with root package name */
    protected int[] f44560j = new int[3];

    /* renamed from: k  reason: collision with root package name */
    protected final AtomicBoolean f44561k = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    protected final AtomicBoolean f44562l = new AtomicBoolean(false);

    /* renamed from: m  reason: collision with root package name */
    protected boolean f44563m = false;

    public a(int i4, int i5, int i6) {
        this.f44552b = i4;
        for (int i7 = 0; i7 < 6; i7++) {
            boolean[] zArr = this.f44556f;
            boolean z3 = true;
            int i8 = 1 << i7;
            if ((i5 & i8) != i8) {
                z3 = false;
            }
            zArr[i7] = z3;
        }
        this.f44557g = i6;
    }

    private void c() {
        this.f44559i = System.currentTimeMillis();
        com.qq.e.comm.plugin.k0.c.a(this, "reset twist time: " + this.f44559i);
    }

    private void d(int i4) {
        this.f44555e = true;
        if (this.f44553c <= 0 || this.f44554d > -1) {
            return;
        }
        this.f44554d = i4;
        e(1);
    }

    private void e(int i4) {
        if (this.f44553c <= 0) {
            return;
        }
        v.a(1310001, null, Integer.valueOf(i4), null, null);
    }

    @Override // com.qq.e.comm.plugin.k0.f.e
    public void a(Sensor sensor, Sensor sensor2) {
    }

    @Override // com.qq.e.comm.plugin.k0.f.e
    public void a(d dVar) {
        this.f44558h = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(int i4) {
        return i4 > 180 ? i4 - 360 : i4 <= -180 ? i4 + 360 : i4;
    }

    protected abstract void d();

    @Override // com.qq.e.comm.plugin.k0.b
    public boolean isComplete() {
        return this.f44563m;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i4) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        d dVar = this.f44558h;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.qq.e.comm.plugin.k0.b
    public boolean pause() {
        boolean compareAndSet = this.f44562l.compareAndSet(false, true);
        if (compareAndSet && com.qq.e.comm.plugin.k0.c.a()) {
            d();
        }
        return compareAndSet;
    }

    @Override // com.qq.e.comm.plugin.k0.b
    public void reset() {
        c();
        Arrays.fill(this.f44560j, 0);
        this.f44563m = false;
        d dVar = this.f44558h;
        if (dVar != null) {
            dVar.c();
        }
        this.f44554d = -1;
        this.f44555e = false;
    }

    @Override // com.qq.e.comm.plugin.k0.b
    public boolean resume() {
        boolean compareAndSet = this.f44562l.compareAndSet(true, false);
        if (compareAndSet && com.qq.e.comm.plugin.k0.c.a()) {
            b();
        }
        return compareAndSet;
    }

    @Override // com.qq.e.comm.plugin.k0.b
    public void start() {
        b();
    }

    @Override // com.qq.e.comm.plugin.k0.b
    public void stop() {
        d();
        this.f44551a = null;
        this.f44558h = null;
    }

    private float b(int i4) {
        int i5 = this.f44553c;
        if (i5 <= 0) {
            return Math.min(i4 / this.f44552b, 1.0f);
        }
        if (!this.f44555e) {
            return Math.min(i4 / this.f44552b, 1.0f) * 0.5f;
        }
        return (Math.min(i4 / i5, 1.0f) * 0.5f) + 0.5f;
    }

    @Override // com.qq.e.comm.plugin.k0.f.e
    public void a(int i4) {
        this.f44553c = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.f44563m || this.f44562l.get()) {
            return;
        }
        int[] iArr = this.f44560j;
        Pair<Integer, Integer> a4 = a(iArr[0], iArr[1], iArr[2]);
        int intValue = ((Integer) a4.first).intValue();
        if (intValue < 5 && !this.f44555e) {
            c();
        }
        if (this.f44558h != null) {
            float b4 = b(intValue);
            com.qq.e.comm.plugin.k0.c.a(this, "twist progress: " + b4);
            d dVar = this.f44558h;
            int[] iArr2 = this.f44560j;
            dVar.a(iArr2[0], iArr2[1], iArr2[2], this.f44552b, b4);
        }
        boolean z3 = intValue >= (this.f44555e ? this.f44553c : this.f44552b);
        long currentTimeMillis = System.currentTimeMillis() - this.f44559i;
        boolean a5 = a(z3, currentTimeMillis);
        if (z3) {
            d(((Integer) a4.second).intValue());
        }
        if (!a5 || this.f44558h == null) {
            return;
        }
        this.f44563m = true;
        e(0);
        d dVar2 = this.f44558h;
        int[] iArr3 = this.f44560j;
        dVar2.a(iArr3[0], iArr3[1], iArr3[2], this.f44552b, currentTimeMillis);
    }

    private Pair<Integer, Integer> a(int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = 0;
        if (!this.f44556f[0] || i4 <= 0 || this.f44554d == 0) {
            i7 = -1;
        } else {
            i11 = i4;
            i7 = 0;
        }
        if (this.f44556f[1] && i4 < 0 && (i10 = -i4) > i11 && this.f44554d != 1) {
            i11 = i10;
            i7 = 1;
        }
        if (this.f44556f[2] && i5 > i11 && this.f44554d != 2) {
            i11 = i5;
            i7 = 2;
        }
        if (this.f44556f[3] && i5 < 0 && (i9 = -i5) > i11 && this.f44554d != 3) {
            i11 = i9;
            i7 = 3;
        }
        if (this.f44556f[4] && i6 > i11 && this.f44554d != 4) {
            i11 = i6;
            i7 = 4;
        }
        if (this.f44556f[5] && i6 < 0 && (i8 = -i6) > i11 && this.f44554d != 5) {
            i11 = i8;
            i7 = 5;
        }
        return new Pair<>(Integer.valueOf(i11), Integer.valueOf(i7));
    }

    private boolean a(boolean z3, long j4) {
        int i4 = this.f44557g;
        if (i4 > 0) {
            z3 = z3 && j4 >= ((long) i4);
        }
        return this.f44553c > 0 ? z3 && this.f44555e : z3;
    }
}
