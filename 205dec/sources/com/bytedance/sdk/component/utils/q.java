package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class q implements SensorEventListener {
    private Sensor bk;
    private Sensor fp;
    private float gb;
    private float gw;
    private float ia;

    /* renamed from: j  reason: collision with root package name */
    private int f30208j;

    /* renamed from: k  reason: collision with root package name */
    private SensorManager f30209k;
    private float pr;

    /* renamed from: r  reason: collision with root package name */
    private volatile long f30214r;

    /* renamed from: s  reason: collision with root package name */
    private int f30215s;
    private float sr;

    /* renamed from: t  reason: collision with root package name */
    private Sensor f30216t;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private volatile long f30218w;

    /* renamed from: x  reason: collision with root package name */
    private float f30219x;
    private JSONObject xk;
    private float xv;
    private Sensor ys;

    /* renamed from: c  reason: collision with root package name */
    private long f30205c = 2000;

    /* renamed from: f  reason: collision with root package name */
    private boolean f30206f = false;
    private float ev = 13.0f;
    private float gd = 50.0f;

    /* renamed from: p  reason: collision with root package name */
    private int f30212p = 0;

    /* renamed from: a  reason: collision with root package name */
    private c f30204a = null;
    private final long fz = 500;

    /* renamed from: u  reason: collision with root package name */
    private volatile long f30217u = 0;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f30207i = false;

    /* renamed from: q  reason: collision with root package name */
    private volatile boolean f30213q = false;
    private final float ls = 1.0E-9f;

    /* renamed from: n  reason: collision with root package name */
    private float[] f30211n = new float[3];
    private long ck = 0;

    /* renamed from: z  reason: collision with root package name */
    private float f30221z = 0.0f;
    private float ba = 4.0f;

    /* renamed from: y  reason: collision with root package name */
    private float f30220y = 0.0f;
    private int eq = 1;
    private float[] me = new float[3];
    private final float wv = 0.0f;
    private boolean yu = false;
    private boolean wx = false;
    private boolean bw = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f30210m = false;
    private int vc = 0;
    private int up = 0;
    private int mt = 0;
    private boolean oo = false;
    private float au = 0.0f;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(int i4);
    }

    public q(Context context, int i4) {
        this.f30209k = null;
        this.f30209k = (SensorManager) context.getSystemService("sensor");
        this.f30208j = i4;
    }

    private void a() {
        c("lqmt", "onShake-\u6447\u4e00\u6447 invoke!!");
        this.f30204a.c(1);
        this.f30218w = System.currentTimeMillis();
    }

    private void bk() {
        this.f30204a.c(1);
        this.f30218w = System.currentTimeMillis();
        this.f30217u = 0L;
        this.f30213q = false;
    }

    private float c(double d4) {
        return (float) ((d4 <= 0.0d || d4 > 180.0d) ? 50.0d : 50.0d);
    }

    private void c(String str, String str2) {
    }

    private boolean c(float f4, float f5) {
        return f5 > 0.0f && f4 > f5;
    }

    private boolean c(int i4, int i5) {
        return (i4 | i5) == 3;
    }

    private void ev() {
        if (this.eq == 1) {
            float[] fArr = this.me;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            c("lqmt", "resetIfNeedAngular  >>>>");
        }
    }

    private int f(float f4) {
        return f4 < 0.0f ? 1 : 2;
    }

    private void f() {
        try {
            if (this.bk == null) {
                this.bk = this.f30209k.getDefaultSensor(1);
            }
            this.f30209k.registerListener(this, this.bk, 3);
            gd();
        } catch (Throwable unused) {
        }
    }

    private void gd() {
        c("lqmt", "\u91cd\u7f6e\u6447\u4e00\u6447\u72b6\u6001....");
        this.f30217u = 0L;
        this.f30207i = false;
        this.f30213q = false;
        this.vc = 0;
        this.up = 0;
        this.mt = 0;
    }

    private boolean k() {
        return this.ia > this.ev;
    }

    private void p() {
        c("lqmt", "\u91cd\u7f6e\u626d\u4e00\u626d\u72b6\u6001....");
        this.vc = 0;
        this.up = 0;
        this.mt = 0;
    }

    private void r() {
        int i4;
        try {
            if (this.f30215s == 0) {
                if (this.f30216t == null) {
                    this.f30216t = this.f30209k.getDefaultSensor(15);
                }
                this.f30206f = false;
                if (Build.VERSION.SDK_INT > 18) {
                    this.f30209k.registerListener(this, this.f30216t, 1);
                }
            }
            int i5 = this.f30215s;
            if (i5 == 3 || i5 == 2 || i5 == 4) {
                if (this.ys == null) {
                    this.ys = this.f30209k.getDefaultSensor(4);
                }
                float f4 = this.ba;
                if (f4 != 0.0f && ((i4 = this.f30215s) == 2 || i4 == 4)) {
                    this.au = (float) Math.pow(f4, 2.0d);
                    if (this.fp == null) {
                        this.fp = this.f30209k.getDefaultSensor(10);
                    }
                    this.f30209k.registerListener(this, this.fp, 1);
                }
                this.f30209k.registerListener(this, this.ys, 1);
            }
            p();
        } catch (Throwable unused) {
        }
    }

    private void ux(float f4) {
        if (System.currentTimeMillis() - this.f30217u >= 500) {
            this.f30207i = false;
            bk();
        } else if (f4 >= this.ia) {
            this.f30207i = true;
            bk();
        }
    }

    public void c(c cVar) {
        this.f30204a = cVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i4) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        float abs = Math.abs(fArr[0]);
        boolean z3 = true;
        float abs2 = Math.abs(fArr[1]);
        float abs3 = Math.abs(fArr[2]);
        if (type == 1) {
            if (this.f30204a == null || System.currentTimeMillis() - this.f30218w <= this.f30205c) {
                return;
            }
            int i4 = this.f30212p;
            if (i4 == 1) {
                double sqrt = Math.sqrt(Math.pow(abs, 2.0d) + Math.pow(abs2, 2.0d) + Math.pow(abs3, 2.0d));
                c(sqrt > ((double) this.ev), sqrt);
            } else if (i4 != 2) {
                double c4 = c(abs, abs2, abs3);
                c(c4 > ((double) this.ev), c4);
            } else {
                double sqrt2 = Math.sqrt(Math.pow(abs, 2.0d) + Math.pow(abs2, 2.0d) + Math.pow(abs3, 2.0d));
                boolean z4 = sqrt2 > ((double) this.ev);
                c("lqmt", "values[0]: " + fArr[0] + "  values[1]: " + fArr[1] + "  values[2]: " + fArr[2] + "  shakeValue: " + sqrt2);
                c(z4, sensorEvent);
            }
        } else if (type == 4) {
            int i5 = this.f30215s;
            if (i5 == 3) {
                w(sensorEvent);
            } else if (i5 == 2 || i5 == 4) {
                c(sensorEvent);
            }
        } else if (type == 10) {
            float[] fArr2 = sensorEvent.values;
            this.f30220y = (float) (Math.pow(fArr2[0], 2.0d) + Math.pow(fArr2[1], 2.0d) + Math.pow(fArr2[2], 2.0d));
            c("lqmt", "TYPE_LINEAR_ACCELERATION -> mCurrentSensitivity: " + this.f30220y);
        } else if (type != 15) {
        } else {
            float abs4 = Math.abs(fArr[0]);
            float abs5 = Math.abs(fArr[1]);
            float abs6 = Math.abs(fArr[2]);
            if (abs4 == 0.0f && abs5 == 0.0f && abs6 == 0.0f) {
                return;
            }
            if (!this.f30206f) {
                this.f30206f = true;
                this.xv = abs4;
                this.sr = abs5;
                this.ux = abs6;
                return;
            }
            float abs7 = Math.abs(abs4 - this.xv) * 180.0f;
            float abs8 = Math.abs(abs5 - this.sr) * 180.0f;
            float abs9 = Math.abs(abs6 - this.ux) * 180.0f;
            if (this.yu) {
                boolean z5 = this.wx && abs7 > this.pr;
                boolean z6 = this.bw && abs8 > this.f30219x;
                z3 = (!this.f30210m || abs9 <= this.gw) ? false : false;
                if ((z5 || z6 || z3) && this.f30204a != null && System.currentTimeMillis() - this.f30214r > this.f30205c) {
                    this.f30204a.c(2);
                    this.f30214r = System.currentTimeMillis();
                    this.f30206f = false;
                    return;
                }
                return;
            }
            float f4 = this.gd;
            if ((abs7 > f4 || abs8 > f4 || abs9 > f4) && this.f30204a != null && System.currentTimeMillis() - this.f30214r > this.f30205c) {
                this.f30204a.c(2);
                this.f30214r = System.currentTimeMillis();
                this.f30206f = false;
            }
        }
    }

    public void sr() {
        this.oo = true;
        w();
    }

    public void w() {
        SensorManager sensorManager = this.f30209k;
        if (sensorManager == null) {
            return;
        }
        sensorManager.unregisterListener(this);
    }

    public void xv() {
        this.oo = false;
        c();
    }

    public void c() {
        if (this.f30209k == null || this.oo) {
            return;
        }
        int i4 = this.f30208j;
        if (i4 == 1) {
            f();
        } else if (i4 == 2) {
            r();
        }
    }

    private void sr(float f4) {
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = this.f30215s == 4;
        float abs = (float) Math.abs(Math.toDegrees(this.me[0]));
        float abs2 = (float) Math.abs(Math.toDegrees(this.me[1]));
        float abs3 = (float) Math.abs(Math.toDegrees(this.me[2]));
        c("lqmt", "isNeedDoubleDirection: " + z5 + "  angleX: " + abs + "  angleY: " + abs2 + "  angleZ: " + abs3);
        StringBuilder sb = new StringBuilder();
        sb.append("mCurrSensorValues[0]-x: ");
        sb.append(this.me[0]);
        sb.append(" mCurrSensorValues[1]-y: ");
        sb.append(this.me[1]);
        sb.append(" mCurrSensorValues[2]-z: ");
        sb.append(this.me[2]);
        c("lqmt", sb.toString());
        if (this.yu) {
            boolean z6 = this.wx && c(abs, this.pr);
            boolean z7 = this.bw && c(abs2, this.f30219x);
            z3 = (this.f30210m && c(abs3, this.gw)) ? false : false;
            if (z6 || z7 || z3) {
                c("lqmt", "\u89e6\u53d1\u9608\u503c \u5206\u8f74-xCan: " + z6 + " yCan: " + z7 + "  zCan: " + z3);
                z4 = c(z5, z6, z7, z3);
            }
        } else {
            boolean c4 = c(abs, f4);
            boolean c5 = c(abs2, f4);
            boolean c6 = c(abs3, f4);
            if (c4 || c5 || c6) {
                c("lqmt", "\u89e6\u53d1\u9608\u503c \u9ed8\u8ba4-xCan: " + c4 + " yCan: " + c5 + "  zCan: " + c6);
                z4 = c(z5, c4, c5, c6);
            }
        }
        if (!z4 || System.currentTimeMillis() - this.f30214r <= this.f30205c) {
            return;
        }
        c("lqmt", "onShake-\u626d\u4e00\u626d invoke!!");
        this.f30204a.c(2);
        this.f30214r = System.currentTimeMillis();
    }

    private void w(SensorEvent sensorEvent) {
        float f4 = this.gb;
        if (f4 != 0.0f) {
            float f5 = (((float) sensorEvent.timestamp) - f4) * 1.0E-9f;
            float[] fArr = this.f30211n;
            boolean z3 = false;
            float f6 = fArr[0];
            float[] fArr2 = sensorEvent.values;
            fArr[0] = f6 + (fArr2[0] * f5);
            fArr[1] = fArr[1] + (fArr2[1] * f5);
            fArr[2] = fArr[2] + (fArr2[2] * f5);
            float abs = Math.abs((float) Math.toDegrees(fArr[0]));
            float abs2 = Math.abs((float) Math.toDegrees(this.f30211n[1]));
            float abs3 = Math.abs((float) Math.toDegrees(this.f30211n[2]));
            if (this.yu) {
                boolean z4 = this.wx && c(abs, this.pr);
                boolean z5 = this.bw && c(abs2, this.f30219x);
                boolean z6 = this.f30210m && c(abs3, this.gw);
                if (z4 || z5 || z6) {
                    float[] fArr3 = this.f30211n;
                    fArr3[0] = 0.0f;
                    fArr3[1] = 0.0f;
                    fArr3[2] = 0.0f;
                    z3 = true;
                }
                if (z3 && System.currentTimeMillis() - this.f30214r > this.f30205c) {
                    this.f30204a.c(2);
                    this.f30214r = System.currentTimeMillis();
                }
            } else {
                if (c(abs, this.gd) || c(abs2, this.gd) || c(abs3, this.gd)) {
                    float[] fArr4 = this.f30211n;
                    fArr4[0] = 0.0f;
                    fArr4[1] = 0.0f;
                    fArr4[2] = 0.0f;
                    z3 = true;
                }
                if (z3) {
                    this.f30204a.c(2);
                    this.f30214r = System.currentTimeMillis();
                }
            }
        }
        this.gb = (float) sensorEvent.timestamp;
    }

    public void xv(float f4) {
        this.ia = f4;
    }

    private void c(SensorEvent sensorEvent) {
        long j4 = this.ck;
        if (j4 != 0) {
            float[] fArr = sensorEvent.values;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            float f7 = ((float) (sensorEvent.timestamp - j4)) * 1.0E-9f;
            float f8 = this.f30221z;
            if (f8 != 0.0f) {
                if (w(f8, f4) && w(this.f30221z, f5) && w(this.f30221z, f6)) {
                    c(f4, f5, f6, f7);
                } else {
                    ev();
                }
            } else {
                float f9 = this.au;
                if (f9 != 0.0f) {
                    if (this.f30220y < f9) {
                        c(f4, f5, f6, f7);
                    } else {
                        ev();
                    }
                } else {
                    c(f4, f5, f6, f7);
                }
            }
            sr(this.gd);
        }
        this.ck = sensorEvent.timestamp;
    }

    public boolean ux() {
        return this.f30207i;
    }

    private void c(float f4, float f5, float f6, float f7) {
        float[] fArr = this.me;
        fArr[0] = fArr[0] + (f4 * f7);
        fArr[1] = fArr[1] + (f5 * f7);
        fArr[2] = fArr[2] + (f6 * f7);
        c("lqmt", "updateCurrentSensorValue: " + f4 + "  " + f5 + "  " + f6 + "  dt: " + f7);
    }

    private boolean w(float f4, float f5) {
        return Math.abs(f5) < f4;
    }

    public static boolean w(Context context) {
        SensorManager sensorManager;
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        Sensor sensor = null;
        try {
            sensor = sensorManager.getDefaultSensor(15);
        } catch (Throwable unused) {
        }
        return sensor != null;
    }

    public static boolean c(Context context) {
        SensorManager sensorManager;
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        Sensor sensor = null;
        try {
            sensor = sensorManager.getDefaultSensor(1);
        } catch (Throwable unused) {
        }
        return sensor != null;
    }

    public void w(float f4) {
        this.gd = f4;
    }

    public void c(float f4) {
        this.ev = f4;
    }

    public void w(int i4) {
        SensorManager sensorManager;
        if (i4 != 3 && i4 != 2 && i4 != 4) {
            this.f30215s = 0;
            return;
        }
        if (this.ys == null && (sensorManager = this.f30209k) != null) {
            this.ys = sensorManager.getDefaultSensor(4);
        }
        if (this.ys == null) {
            this.f30215s = 0;
        } else {
            this.f30215s = i4;
        }
    }

    public void c(JSONObject jSONObject) {
        this.xk = jSONObject;
        boolean z3 = false;
        if (jSONObject == null) {
            this.wx = false;
            this.bw = false;
            this.f30210m = false;
        } else {
            this.wx = jSONObject.has("x_threshold");
            this.pr = c(this.xk.optDouble("x_threshold", 50.0d));
            this.bw = this.xk.has("y_threshold");
            this.f30219x = c(this.xk.optDouble("y_threshold", 50.0d));
            this.f30210m = this.xk.has("z_threshold");
            this.gw = c(this.xk.optDouble("z_threshold", 50.0d));
        }
        this.yu = (this.wx || this.bw || this.f30210m) ? true : true;
    }

    public void c(int i4) {
        this.f30212p = i4;
    }

    private float c(float f4, float f5, float f6) {
        return Math.max(Math.max(f5, f4), f6);
    }

    private void c(boolean z3, double d4) {
        if (!k() && z3) {
            a();
        } else if (z3) {
            this.f30217u = System.currentTimeMillis();
            this.f30213q = true;
            ux((float) d4);
        } else if (!this.f30213q || System.currentTimeMillis() - this.f30217u < 500) {
        } else {
            this.f30207i = false;
            bk();
        }
    }

    private void c(boolean z3, SensorEvent sensorEvent) {
        c("lqmt", "\u8fbe\u5230\u9608\u503c: " + z3);
        if (z3) {
            float[] fArr = sensorEvent.values;
            int f4 = fArr[0] != 0.0f ? f(fArr[0]) : 0;
            int f5 = fArr[1] != 0.0f ? f(fArr[1]) : 0;
            int f6 = fArr[2] != 0.0f ? f(fArr[2]) : 0;
            c("lqmt", "tempTagX: " + f4 + "  tempTagY: " + f5 + "  tempTagZ: " + f6);
            if (!c(f4, this.vc) && !c(f5, this.up) && !c(f6, this.mt)) {
                c(f4, f5, f6, false);
                return;
            }
            c(f4, f5, f6, true);
            a();
        }
    }

    private boolean c(boolean z3, boolean z4, boolean z5, boolean z6) {
        if (!z3) {
            float[] fArr = this.me;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            return true;
        }
        float[] fArr2 = this.me;
        int f4 = (fArr2[0] == 0.0f || !z4) ? 0 : f(fArr2[0]);
        float[] fArr3 = this.me;
        int f5 = (fArr3[1] == 0.0f || !z5) ? 0 : f(fArr3[1]);
        float[] fArr4 = this.me;
        int f6 = (fArr4[2] == 0.0f || !z6) ? 0 : f(fArr4[2]);
        float[] fArr5 = this.me;
        fArr5[0] = 0.0f;
        fArr5[1] = 0.0f;
        fArr5[2] = 0.0f;
        c("lqmt", "\u5f53\u6b21\u626d\u52a8 tempTagX: " + f4 + "  tempTagY: " + f5 + "  tempTagZ: " + f6);
        if (!c(f4, this.vc) && !c(f5, this.up) && !c(f6, this.mt)) {
            c(f4, f5, f6, false);
            return false;
        }
        c(f4, f5, f6, true);
        return true;
    }

    private void c(int i4, int i5, int i6, boolean z3) {
        if (!z3) {
            if (i4 == 0) {
                i4 = this.vc;
            }
            this.vc = i4;
            if (i5 == 0) {
                i5 = this.up;
            }
            this.up = i5;
            if (i6 == 0) {
                i6 = this.mt;
            }
            this.mt = i6;
            return;
        }
        this.vc = 0;
        this.up = 0;
        this.mt = 0;
        c("lqmt", "\u5386\u53f2 mReachAngleTagX: " + this.vc + "  mReachAngleTagY: " + this.up + "  mReachAngleTagZ: " + this.mt);
        c("lqmt", "x-y-z\u8f74\uff0c\u65b9\u5411\u5168\u90e8\u91cd\u7f6e\u4e3a0");
    }
}
