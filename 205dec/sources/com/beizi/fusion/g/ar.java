package com.beizi.fusion.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ShakeCoolConfig.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ar {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ar f14872a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Long> f14873b = new HashMap();

    /* compiled from: ShakeUtil.java */
    /* renamed from: com.beizi.fusion.g.ar$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class AnonymousClass1 implements SensorEventListener {
        AnonymousClass1() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (System.currentTimeMillis() - ar.a(ar.this) < 200) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            if (ar.b(ar.this) == -100.0f) {
                ar.a(ar.this, f4);
            }
            if (ar.c(ar.this) == -100.0f) {
                ar.b(ar.this, f5);
            }
            if (ar.d(ar.this) == -100.0f) {
                ar.c(ar.this, f6);
            }
            af.b("ShakeUtil", "x = " + f4 + ",initialX = " + ar.b(ar.this) + ",y = " + f5 + ",initialY = " + ar.c(ar.this) + ",z = " + f6 + ",initialZ = " + ar.d(ar.this));
            double abs = (double) Math.abs(f4 - ar.b(ar.this));
            Double.isNaN(abs);
            double d4 = abs / 9.8d;
            double abs2 = (double) Math.abs(f5 - ar.c(ar.this));
            Double.isNaN(abs2);
            double d5 = abs2 / 9.8d;
            double abs3 = (double) Math.abs(f6 - ar.d(ar.this));
            Double.isNaN(abs3);
            double d6 = abs3 / 9.8d;
            af.b("ShakeUtil", "rotateX = " + d4 + ",rotateY = " + d5 + ",rotateZ = " + d6 + ",rotateAmplitude = " + ar.e(ar.this));
            if (d4 > ar.e(ar.this)) {
                ar.f(ar.this);
                ar.a(ar.this, f4);
            }
            if (d5 > ar.e(ar.this)) {
                ar.f(ar.this);
                ar.b(ar.this, f5);
            }
            if (d6 > ar.e(ar.this)) {
                ar.f(ar.this);
                ar.c(ar.this, f6);
            }
            ar arVar = ar.this;
            double a4 = ar.a(arVar, f4, f5, f6, ar.g(arVar));
            if (a4 > ar.g(ar.this)) {
                ar.a(ar.this, 1);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("startSatisfy:");
            sb.append(a4);
            sb.append(";mShakeState = ");
            sb.append(ar.h(ar.this));
            sb.append(",isShakeStart = ");
            ar arVar2 = ar.this;
            sb.append(ar.a(arVar2, f4, f5, f6, ar.g(arVar2)));
            sb.append(",isShakeEnd = ");
            ar arVar3 = ar.this;
            sb.append(ar.b(arVar3, f4, f5, f6, ar.i(arVar3)));
            af.b("ShakeUtil", sb.toString());
            if (ar.h(ar.this) == 1) {
                ar arVar4 = ar.this;
                if (ar.b(arVar4, f4, f5, f6, ar.i(arVar4))) {
                    ar.a(ar.this, 2);
                    ar.j(ar.this);
                }
            }
            ar.a(ar.this, d4, d5, d6, a4);
            af.b("ShakeUtil", "mShakeCount = " + ar.k(ar.this) + ",dstShakeCount = " + ar.l(ar.this) + ",mRotateCount = " + ar.m(ar.this) + ",dstRotateCount = " + ar.n(ar.this));
            if ((ar.l(ar.this) <= 0 || ar.k(ar.this) < ar.l(ar.this)) && (ar.n(ar.this) <= 0 || ar.m(ar.this) < ar.n(ar.this))) {
                return;
            }
            ar.this.a();
        }
    }

    /* compiled from: ShakeUtil.java */
    /* renamed from: com.beizi.fusion.g.ar$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ar.this.a();
        }
    }

    /* compiled from: ShakeUtil.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void b();
    }

    public static ar a() {
        if (f14872a == null) {
            synchronized (ar.class) {
                if (f14872a == null) {
                    f14872a = new ar();
                }
            }
        }
        return f14872a;
    }

    public long b(String str) {
        if (this.f14873b.containsKey(str)) {
            return this.f14873b.get(str).longValue();
        }
        return 0L;
    }

    public void a(String str, long j4) {
        this.f14873b.put(str, Long.valueOf(j4));
    }

    public void a(String str) {
        if (this.f14873b.containsKey(str)) {
            this.f14873b.remove(str);
        }
    }
}
