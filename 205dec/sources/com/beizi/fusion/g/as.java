package com.beizi.fusion.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Pair;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.update.ShakeArcView;
import com.beizi.fusion.widget.ShakeView;
import com.stub.StubApp;
import java.math.BigDecimal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ShakeUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class as {

    /* renamed from: b  reason: collision with root package name */
    private static SensorManager f14876b;

    /* renamed from: a  reason: collision with root package name */
    ShakeView f14877a;

    /* renamed from: c  reason: collision with root package name */
    private Context f14878c;

    /* renamed from: d  reason: collision with root package name */
    private double f14879d;

    /* renamed from: e  reason: collision with root package name */
    private double f14880e;

    /* renamed from: f  reason: collision with root package name */
    private double f14881f;

    /* renamed from: g  reason: collision with root package name */
    private int f14882g;

    /* renamed from: h  reason: collision with root package name */
    private int f14883h;

    /* renamed from: i  reason: collision with root package name */
    private int f14884i;

    /* renamed from: j  reason: collision with root package name */
    private int f14885j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f14898w;

    /* renamed from: k  reason: collision with root package name */
    private int f14886k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f14887l = 0;

    /* renamed from: m  reason: collision with root package name */
    private float f14888m = -100.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f14889n = -100.0f;

    /* renamed from: o  reason: collision with root package name */
    private float f14890o = -100.0f;

    /* renamed from: p  reason: collision with root package name */
    private int f14891p = 0;

    /* renamed from: q  reason: collision with root package name */
    private a f14892q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f14893r = false;

    /* renamed from: s  reason: collision with root package name */
    private int f14894s = 200;

    /* renamed from: t  reason: collision with root package name */
    private long f14895t = 0;

    /* renamed from: u  reason: collision with root package name */
    private ShakeArcView f14896u = null;

    /* renamed from: v  reason: collision with root package name */
    private int f14897v = 0;

    /* renamed from: x  reason: collision with root package name */
    private final SensorEventListener f14899x = new SensorEventListener() { // from class: com.beizi.fusion.g.as.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (System.currentTimeMillis() - as.this.f14895t < 200) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            if (as.this.f14888m == -100.0f) {
                as.this.f14888m = f4;
            }
            if (as.this.f14889n == -100.0f) {
                as.this.f14889n = f5;
            }
            if (as.this.f14890o == -100.0f) {
                as.this.f14890o = f6;
            }
            af.b("ShakeUtil", "x = " + f4 + ",initialX = " + as.this.f14888m + ",y = " + f5 + ",initialY = " + as.this.f14889n + ",z = " + f6 + ",initialZ = " + as.this.f14890o);
            double abs = (double) Math.abs(f4 - as.this.f14888m);
            Double.isNaN(abs);
            double d4 = abs / 9.8d;
            double abs2 = (double) Math.abs(f5 - as.this.f14889n);
            Double.isNaN(abs2);
            double d5 = abs2 / 9.8d;
            double abs3 = (double) Math.abs(f6 - as.this.f14890o);
            Double.isNaN(abs3);
            double d6 = abs3 / 9.8d;
            af.b("ShakeUtil", "rotateX = " + d4 + ",rotateY = " + d5 + ",rotateZ = " + d6 + ",rotateAmplitude = " + as.this.f14881f);
            if (d4 > as.this.f14881f) {
                as.f(as.this);
                as.this.f14888m = f4;
            }
            if (d5 > as.this.f14881f) {
                as.f(as.this);
                as.this.f14889n = f5;
            }
            if (d6 > as.this.f14881f) {
                as.f(as.this);
                as.this.f14890o = f6;
            }
            as asVar = as.this;
            double a4 = asVar.a(f4, f5, f6, asVar.f14879d);
            if (a4 > as.this.f14879d) {
                as.this.f14891p = 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("startSatisfy:");
            sb.append(a4);
            sb.append(";mShakeState = ");
            sb.append(as.this.f14891p);
            sb.append(",isShakeStart = ");
            as asVar2 = as.this;
            sb.append(asVar2.a(f4, f5, f6, asVar2.f14879d));
            sb.append(",isShakeEnd = ");
            as asVar3 = as.this;
            sb.append(asVar3.b(f4, f5, f6, asVar3.f14880e));
            af.b("ShakeUtil", sb.toString());
            if (as.this.f14891p == 1) {
                as asVar4 = as.this;
                if (asVar4.b(f4, f5, f6, asVar4.f14880e)) {
                    as.this.f14891p = 2;
                    as.j(as.this);
                }
            }
            as.this.a(d4, d5, d6, a4);
            af.b("ShakeUtil", "mShakeCount = " + as.this.f14886k + ",dstShakeCount = " + as.this.f14882g + ",mRotateCount = " + as.this.f14887l + ",dstRotateCount = " + as.this.f14883h);
            if ((as.this.f14882g <= 0 || as.this.f14886k < as.this.f14882g) && (as.this.f14883h <= 0 || as.this.f14887l < as.this.f14883h)) {
                return;
            }
            as.this.a();
        }
    };

    /* compiled from: ShakeUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void b();
    }

    public as(Context context) {
        this.f14878c = context;
        f14876b = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("sensor");
    }

    static /* synthetic */ int f(as asVar) {
        int i4 = asVar.f14887l;
        asVar.f14887l = i4 + 1;
        return i4;
    }

    static /* synthetic */ int j(as asVar) {
        int i4 = asVar.f14886k;
        asVar.f14886k = i4 + 1;
        return i4;
    }

    private void e() {
        int i4;
        ShakeArcView shakeArcView = this.f14896u;
        if (shakeArcView == null || (i4 = this.f14897v) == 0) {
            return;
        }
        if (i4 != 1) {
            if (i4 == 2) {
                shakeArcView.setMaxProgress(this.f14882g);
                return;
            }
            return;
        }
        if (this.f14883h > 0) {
            double d4 = this.f14881f;
            if (d4 > 0.0d) {
                shakeArcView.setMaxProgress(d4);
                return;
            }
        }
        shakeArcView.setMaxProgress(this.f14879d);
    }

    private void f() {
        Pair<Integer, Boolean> f4 = f(this.f14885j);
        if (((Boolean) f4.second).booleanValue()) {
            aa.a(new Runnable() { // from class: com.beizi.fusion.g.as.2
                @Override // java.lang.Runnable
                public void run() {
                    as.this.a();
                }
            }, this.f14884i + (((Integer) f4.first).intValue() * 10));
        }
    }

    public void d(int i4) {
        this.f14885j = i4;
        if (i4 > 0) {
            f();
        }
    }

    public void g(int i4) {
        this.f14894s = i4;
    }

    public void c(double d4) {
        this.f14881f = d4;
    }

    public void b(double d4) {
        this.f14880e = d4;
    }

    public void c(int i4) {
        this.f14884i = i4;
    }

    protected void d() {
        this.f14893r = false;
        this.f14886k = 0;
        this.f14887l = 0;
        this.f14888m = -100.0f;
        this.f14889n = -100.0f;
        this.f14890o = -100.0f;
        this.f14891p = 0;
        this.f14892q = null;
        this.f14878c = null;
        this.f14877a = null;
        this.f14894s = 200;
        this.f14896u = null;
    }

    public void b(int i4) {
        this.f14882g = i4;
    }

    public void c() {
        af.a("BeiZis", "enter unRegisterShakeListenerAndSetDefault");
        SensorManager sensorManager = f14876b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f14899x);
        }
        d();
        ShakeView shakeView = this.f14877a;
        if (shakeView != null) {
            shakeView.stopShake();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(float f4, float f5, float f6, double d4) {
        double d5 = f4;
        Double.isNaN(d5);
        double pow = Math.pow(d5 / 9.8d, 2.0d);
        double d6 = f5;
        Double.isNaN(d6);
        double pow2 = pow + Math.pow(d6 / 9.8d, 2.0d);
        double d7 = f6;
        Double.isNaN(d7);
        return Math.sqrt(pow2 + Math.pow(d7 / 9.8d, 2.0d)) < d4;
    }

    public void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            return;
        }
        af.c("ShakeUtil", "setShakeParams mShakeCount:" + shakeViewBean.getShakeCount() + ";mRotateCount:" + shakeViewBean.getRotatCount());
        try {
            this.f14888m = -100.0f;
            this.f14889n = -100.0f;
            this.f14890o = -100.0f;
            this.f14886k = 0;
            this.f14887l = 0;
            this.f14891p = 0;
            b(shakeViewBean.getShakeCount());
            a(shakeViewBean.getShakeStartAmplitude());
            b(shakeViewBean.getShakeEndAmplitude());
            c(shakeViewBean.getRotatAmplitude());
            e(shakeViewBean.getRotatCount());
            c(shakeViewBean.getRandomClickTime());
            d(shakeViewBean.getRandomClickNum());
            g(shakeViewBean.getAnimationInterval());
            e();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static Pair<Integer, Boolean> f(int i4) {
        int random = (int) ((Math.random() * 100.0d) + 1.0d);
        if (random <= i4) {
            return new Pair<>(Integer.valueOf(random), Boolean.TRUE);
        }
        return new Pair<>(Integer.valueOf(random), Boolean.FALSE);
    }

    public void b() {
        SensorManager sensorManager = f14876b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f14899x, sensorManager.getDefaultSensor(1), 100000);
        }
    }

    public void e(int i4) {
        this.f14883h = i4;
    }

    public void a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        if (coolShakeViewBean == null) {
            return;
        }
        af.c("ShakeUtil", "setShakeCoolParams mShakeCount:" + coolShakeViewBean.getShakeCount() + ";mRotateCount:" + coolShakeViewBean.getRotatCount());
        try {
            b(coolShakeViewBean.getShakeCount());
            a(coolShakeViewBean.getShakeStartAmplitude());
            b(coolShakeViewBean.getShakeEndAmplitude());
            c(coolShakeViewBean.getRotatAmplitude());
            e(coolShakeViewBean.getRotatCount());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeViewBean) {
        if (aliaseShakeViewBean == null) {
            return;
        }
        af.c("ShakeUtil", "setShakeAliaseParams mShakeCount:" + aliaseShakeViewBean.getShakeCount() + ";mRotateCount:" + aliaseShakeViewBean.getRotatCount());
        try {
            b(aliaseShakeViewBean.getShakeCount());
            a(aliaseShakeViewBean.getShakeStartAmplitude());
            b(aliaseShakeViewBean.getShakeEndAmplitude());
            c(aliaseShakeViewBean.getRotatAmplitude());
            e(aliaseShakeViewBean.getRotatCount());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(ShakeArcView shakeArcView, int i4) {
        af.c("ShakeUtil", "setShakeFeedback feedback:" + i4);
        a(shakeArcView);
        a(i4);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d4, double d5, double d6, double d7) {
        ShakeArcView shakeArcView = this.f14896u;
        if (shakeArcView == null) {
            return;
        }
        if (this.f14897v == 2) {
            shakeArcView.setCurrentProgress(this.f14886k);
        } else if (this.f14883h > 0 && this.f14881f > 0.0d) {
            double doubleValue = new BigDecimal((d4 < d5 || d4 < d6) ? (d5 < d4 || d5 < d6) ? (d6 < d4 || d6 < d5) ? 0.0d : d6 : d5 : d4).setScale(2, 4).doubleValue();
            if (doubleValue >= 0.1d) {
                this.f14896u.setCurrentProgress(doubleValue);
            } else if (doubleValue < 0.1d) {
                this.f14896u.setCurrentProgress(0.0d);
            }
        } else {
            int i4 = this.f14882g;
            if (i4 > 0 && this.f14886k >= i4) {
                shakeArcView.setCurrentProgress(this.f14879d);
                return;
            }
            double doubleValue2 = new BigDecimal(d7).setScale(2, 4).doubleValue();
            if (doubleValue2 >= 1.1d) {
                this.f14896u.setCurrentProgress(doubleValue2);
            } else if (doubleValue2 < 1.1d) {
                this.f14896u.setCurrentProgress(0.0d);
            }
        }
    }

    public void a(int i4) {
        this.f14897v = i4;
    }

    public void a(double d4) {
        this.f14879d = d4;
    }

    public void a(a aVar) {
        this.f14892q = aVar;
    }

    public void a(ShakeArcView shakeArcView) {
        this.f14896u = shakeArcView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double a(float f4, float f5, float f6, double d4) {
        double d5 = f4;
        Double.isNaN(d5);
        double pow = Math.pow(d5 / 9.8d, 2.0d);
        double d6 = f5;
        Double.isNaN(d6);
        double pow2 = pow + Math.pow(d6 / 9.8d, 2.0d);
        double d7 = f6;
        Double.isNaN(d7);
        return Math.sqrt(pow2 + Math.pow(d7 / 9.8d, 2.0d));
    }

    protected void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.f14892q != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.f14893r);
        af.a("BeiZis", sb.toString());
        if (this.f14892q == null || this.f14893r) {
            return;
        }
        af.a("BeiZis", "callback onShakeHappened()");
        ShakeArcView shakeArcView = this.f14896u;
        if (shakeArcView != null && !ay.b(shakeArcView)) {
            af.b("ShakeUtil", "mShakeCount onShakeHappened mShakeArcView is not show");
            this.f14888m = -100.0f;
            this.f14889n = -100.0f;
            this.f14890o = -100.0f;
            this.f14886k = 0;
            this.f14887l = 0;
            this.f14891p = 0;
            return;
        }
        this.f14892q.b();
        this.f14893r = true;
        ShakeView shakeView = this.f14877a;
        if (shakeView != null) {
            shakeView.stopShake();
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cb, code lost:
        if (r3 >= 400) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View a(int r10, int r11, com.beizi.fusion.model.AdSpacesBean.BuyerBean.PercentPositionBean r12) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.g.as.a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean):android.view.View");
    }

    public void a(Boolean bool) {
        this.f14898w = bool.booleanValue();
    }
}
