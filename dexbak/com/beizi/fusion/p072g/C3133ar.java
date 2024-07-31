package com.beizi.fusion.p072g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Pair;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.update.ShakeArcView;
import com.beizi.fusion.widget.ShakeView;
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;
import com.tencent.bugly.BUGLY;
import com.umeng.analytics.pro.UMCommonContent;
import java.math.BigDecimal;

/* compiled from: ShakeUtil.java */
/* renamed from: com.beizi.fusion.g.ar */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3133ar {

    /* renamed from: b */
    private static SensorManager f11322b;

    /* renamed from: a */
    ShakeView f11323a;

    /* renamed from: c */
    private Context f11324c;

    /* renamed from: d */
    private double f11325d;

    /* renamed from: e */
    private double f11326e;

    /* renamed from: f */
    private double f11327f;

    /* renamed from: g */
    private int f11328g;

    /* renamed from: h */
    private int f11329h;

    /* renamed from: i */
    private int f11330i;

    /* renamed from: j */
    private int f11331j;

    /* renamed from: k */
    private int f11332k = 0;

    /* renamed from: l */
    private int f11333l = 0;

    /* renamed from: m */
    private float f11334m = -100.0f;

    /* renamed from: n */
    private float f11335n = -100.0f;

    /* renamed from: o */
    private float f11336o = -100.0f;

    /* renamed from: p */
    private int f11337p = 0;

    /* renamed from: q */
    private InterfaceC3136a f11338q = null;

    /* renamed from: r */
    private boolean f11339r = false;

    /* renamed from: s */
    private int f11340s = 200;

    /* renamed from: t */
    private long f11341t = 0;

    /* renamed from: u */
    private ShakeArcView f11342u = null;

    /* renamed from: v */
    private int f11343v = 0;

    /* renamed from: w */
    private final SensorEventListener f11344w = new SensorEventListener() { // from class: com.beizi.fusion.g.ar.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (System.currentTimeMillis() - C3133ar.this.f11341t < 200) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if (C3133ar.this.f11334m == -100.0f) {
                C3133ar.this.f11334m = f;
            }
            if (C3133ar.this.f11335n == -100.0f) {
                C3133ar.this.f11335n = f2;
            }
            if (C3133ar.this.f11336o == -100.0f) {
                C3133ar.this.f11336o = f3;
            }
            C3116af.m48495b("ShakeUtil", "x = " + f + ",initialX = " + C3133ar.this.f11334m + ",y = " + f2 + ",initialY = " + C3133ar.this.f11335n + ",z = " + f3 + ",initialZ = " + C3133ar.this.f11336o);
            double abs = (double) Math.abs(f - C3133ar.this.f11334m);
            Double.isNaN(abs);
            double d = abs / 9.8d;
            double abs2 = (double) Math.abs(f2 - C3133ar.this.f11335n);
            Double.isNaN(abs2);
            double d2 = abs2 / 9.8d;
            double abs3 = (double) Math.abs(f3 - C3133ar.this.f11336o);
            Double.isNaN(abs3);
            double d3 = abs3 / 9.8d;
            C3116af.m48495b("ShakeUtil", "rotateX = " + d + ",rotateY = " + d2 + ",rotateZ = " + d3 + ",rotateAmplitude = " + C3133ar.this.f11327f);
            if (d > C3133ar.this.f11327f) {
                C3133ar.m48328f(C3133ar.this);
                C3133ar.this.f11334m = f;
            }
            if (d2 > C3133ar.this.f11327f) {
                C3133ar.m48328f(C3133ar.this);
                C3133ar.this.f11335n = f2;
            }
            if (d3 > C3133ar.this.f11327f) {
                C3133ar.m48328f(C3133ar.this);
                C3133ar.this.f11336o = f3;
            }
            C3133ar c3133ar = C3133ar.this;
            double m48362a = c3133ar.m48362a(f, f2, f3, c3133ar.f11325d);
            if (m48362a > C3133ar.this.f11325d) {
                C3133ar.this.f11337p = 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("startSatisfy:");
            sb.append(m48362a);
            sb.append(";mShakeState = ");
            sb.append(C3133ar.this.f11337p);
            sb.append(",isShakeStart = ");
            C3133ar c3133ar2 = C3133ar.this;
            sb.append(c3133ar2.m48362a(f, f2, f3, c3133ar2.f11325d));
            sb.append(",isShakeEnd = ");
            C3133ar c3133ar3 = C3133ar.this;
            sb.append(c3133ar3.m48346b(f, f2, f3, c3133ar3.f11326e));
            C3116af.m48495b("ShakeUtil", sb.toString());
            if (C3133ar.this.f11337p == 1) {
                C3133ar c3133ar4 = C3133ar.this;
                if (c3133ar4.m48346b(f, f2, f3, c3133ar4.f11326e)) {
                    C3133ar.this.f11337p = 2;
                    C3133ar.m48323j(C3133ar.this);
                }
            }
            C3133ar.this.m48363a(d, d2, d3, m48362a);
            C3116af.m48495b("ShakeUtil", "mShakeCount = " + C3133ar.this.f11332k + ",dstShakeCount = " + C3133ar.this.f11328g + ",mRotateCount = " + C3133ar.this.f11333l + ",dstRotateCount = " + C3133ar.this.f11329h);
            if ((C3133ar.this.f11328g <= 0 || C3133ar.this.f11332k < C3133ar.this.f11328g) && (C3133ar.this.f11329h <= 0 || C3133ar.this.f11333l < C3133ar.this.f11329h)) {
                return;
            }
            C3133ar.this.m48365a();
        }
    };

    /* compiled from: ShakeUtil.java */
    /* renamed from: com.beizi.fusion.g.ar$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3136a {
        /* renamed from: b */
        void mo46561b();
    }

    public C3133ar(Context context) {
        this.f11324c = context;
        f11322b = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(UMCommonContent.f37799ac);
    }

    /* renamed from: f */
    static /* synthetic */ int m48328f(C3133ar c3133ar) {
        int i = c3133ar.f11333l;
        c3133ar.f11333l = i + 1;
        return i;
    }

    /* renamed from: j */
    static /* synthetic */ int m48323j(C3133ar c3133ar) {
        int i = c3133ar.f11332k;
        c3133ar.f11332k = i + 1;
        return i;
    }

    /* renamed from: e */
    private void m48333e() {
        int i;
        ShakeArcView shakeArcView = this.f11342u;
        if (shakeArcView == null || (i = this.f11343v) == 0) {
            return;
        }
        if (i != 1) {
            if (i == 2) {
                shakeArcView.setMaxProgress(this.f11328g);
                return;
            }
            return;
        }
        if (this.f11329h > 0) {
            double d = this.f11327f;
            if (d > Utils.DOUBLE_EPSILON) {
                shakeArcView.setMaxProgress(d);
                return;
            }
        }
        shakeArcView.setMaxProgress(this.f11325d);
    }

    /* renamed from: f */
    private void m48330f() {
        Pair<Integer, Boolean> m48329f = m48329f(this.f11331j);
        if (((Boolean) m48329f.second).booleanValue()) {
            HandlerUtil.m48514a(new Runnable() { // from class: com.beizi.fusion.g.ar.2
                @Override // java.lang.Runnable
                public void run() {
                    C3133ar.this.m48365a();
                }
            }, this.f11330i + (((Integer) m48329f.first).intValue() * 10));
        }
    }

    /* renamed from: d */
    public void m48335d(int i) {
        this.f11331j = i;
        if (i > 0) {
            m48330f();
        }
    }

    /* renamed from: g */
    public void m48327g(int i) {
        this.f11340s = i;
    }

    /* renamed from: c */
    public void m48340c(double d) {
        this.f11327f = d;
    }

    /* renamed from: b */
    public void m48347b(double d) {
        this.f11326e = d;
    }

    /* renamed from: c */
    public void m48339c(int i) {
        this.f11330i = i;
    }

    /* renamed from: d */
    protected void m48336d() {
        this.f11339r = false;
        this.f11332k = 0;
        this.f11333l = 0;
        this.f11334m = -100.0f;
        this.f11335n = -100.0f;
        this.f11336o = -100.0f;
        this.f11337p = 0;
        this.f11338q = null;
        this.f11324c = null;
        this.f11323a = null;
        this.f11340s = 200;
        this.f11342u = null;
    }

    /* renamed from: b */
    public void m48345b(int i) {
        this.f11328g = i;
    }

    /* renamed from: c */
    public void m48341c() {
        C3116af.m48496a("BeiZis", "enter unRegisterShakeListenerAndSetDefault");
        SensorManager sensorManager = f11322b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f11344w);
        }
        m48336d();
        ShakeView shakeView = this.f11323a;
        if (shakeView != null) {
            shakeView.stopShake();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m48346b(float f, float f2, float f3, double d) {
        double d2 = f;
        Double.isNaN(d2);
        double pow = Math.pow(d2 / 9.8d, 2.0d);
        double d3 = f2;
        Double.isNaN(d3);
        double pow2 = pow + Math.pow(d3 / 9.8d, 2.0d);
        double d4 = f3;
        Double.isNaN(d4);
        return Math.sqrt(pow2 + Math.pow(d4 / 9.8d, 2.0d)) < d;
    }

    /* renamed from: a */
    public void m48351a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            return;
        }
        C3116af.m48494c("ShakeUtil", "setShakeParams mShakeCount:" + shakeViewBean.getShakeCount() + ";mRotateCount:" + shakeViewBean.getRotatCount());
        try {
            this.f11334m = -100.0f;
            this.f11335n = -100.0f;
            this.f11336o = -100.0f;
            this.f11332k = 0;
            this.f11333l = 0;
            this.f11337p = 0;
            m48345b(shakeViewBean.getShakeCount());
            m48364a(shakeViewBean.getShakeStartAmplitude());
            m48347b(shakeViewBean.getShakeEndAmplitude());
            m48340c(shakeViewBean.getRotatAmplitude());
            m48332e(shakeViewBean.getRotatCount());
            m48339c(shakeViewBean.getRandomClickTime());
            m48335d(shakeViewBean.getRandomClickNum());
            m48327g(shakeViewBean.getAnimationInterval());
            m48333e();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public static Pair<Integer, Boolean> m48329f(int i) {
        int random = (int) ((Math.random() * 100.0d) + 1.0d);
        if (random <= i) {
            return new Pair<>(Integer.valueOf(random), Boolean.TRUE);
        }
        return new Pair<>(Integer.valueOf(random), Boolean.FALSE);
    }

    /* renamed from: b */
    public void m48348b() {
        SensorManager sensorManager = f11322b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f11344w, sensorManager.getDefaultSensor(1), BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH);
        }
    }

    /* renamed from: e */
    public void m48332e(int i) {
        this.f11329h = i;
    }

    /* renamed from: a */
    public void m48352a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        if (coolShakeViewBean == null) {
            return;
        }
        C3116af.m48494c("ShakeUtil", "setShakeCoolParams mShakeCount:" + coolShakeViewBean.getShakeCount() + ";mRotateCount:" + coolShakeViewBean.getRotatCount());
        try {
            m48345b(coolShakeViewBean.getShakeCount());
            m48364a(coolShakeViewBean.getShakeStartAmplitude());
            m48347b(coolShakeViewBean.getShakeEndAmplitude());
            m48340c(coolShakeViewBean.getRotatAmplitude());
            m48332e(coolShakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m48353a(AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeViewBean) {
        if (aliaseShakeViewBean == null) {
            return;
        }
        C3116af.m48494c("ShakeUtil", "setShakeAliaseParams mShakeCount:" + aliaseShakeViewBean.getShakeCount() + ";mRotateCount:" + aliaseShakeViewBean.getRotatCount());
        try {
            m48345b(aliaseShakeViewBean.getShakeCount());
            m48364a(aliaseShakeViewBean.getShakeStartAmplitude());
            m48347b(aliaseShakeViewBean.getShakeEndAmplitude());
            m48340c(aliaseShakeViewBean.getRotatAmplitude());
            m48332e(aliaseShakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m48349a(ShakeArcView shakeArcView, int i) {
        C3116af.m48494c("ShakeUtil", "setShakeFeedback feedback:" + i);
        m48350a(shakeArcView);
        m48361a(i);
        m48333e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48363a(double d, double d2, double d3, double d4) {
        ShakeArcView shakeArcView = this.f11342u;
        if (shakeArcView == null) {
            return;
        }
        if (this.f11343v == 2) {
            shakeArcView.setCurrentProgress(this.f11332k);
        } else if (this.f11329h > 0 && this.f11327f > Utils.DOUBLE_EPSILON) {
            double doubleValue = new BigDecimal((d < d2 || d < d3) ? (d2 < d || d2 < d3) ? (d3 < d || d3 < d2) ? 0.0d : d3 : d2 : d).setScale(2, 4).doubleValue();
            if (doubleValue >= 0.1d) {
                this.f11342u.setCurrentProgress(doubleValue);
            } else if (doubleValue < 0.1d) {
                this.f11342u.setCurrentProgress(Utils.DOUBLE_EPSILON);
            }
        } else {
            int i = this.f11328g;
            if (i > 0 && this.f11332k >= i) {
                shakeArcView.setCurrentProgress(this.f11325d);
                return;
            }
            double doubleValue2 = new BigDecimal(d4).setScale(2, 4).doubleValue();
            if (doubleValue2 >= 1.1d) {
                this.f11342u.setCurrentProgress(doubleValue2);
            } else if (doubleValue2 < 1.1d) {
                this.f11342u.setCurrentProgress(Utils.DOUBLE_EPSILON);
            }
        }
    }

    /* renamed from: a */
    public void m48361a(int i) {
        this.f11343v = i;
    }

    /* renamed from: a */
    public void m48364a(double d) {
        this.f11325d = d;
    }

    /* renamed from: a */
    public void m48359a(InterfaceC3136a interfaceC3136a) {
        this.f11338q = interfaceC3136a;
    }

    /* renamed from: a */
    public void m48350a(ShakeArcView shakeArcView) {
        this.f11342u = shakeArcView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public double m48362a(float f, float f2, float f3, double d) {
        double d2 = f;
        Double.isNaN(d2);
        double pow = Math.pow(d2 / 9.8d, 2.0d);
        double d3 = f2;
        Double.isNaN(d3);
        double pow2 = pow + Math.pow(d3 / 9.8d, 2.0d);
        double d4 = f3;
        Double.isNaN(d4);
        return Math.sqrt(pow2 + Math.pow(d4 / 9.8d, 2.0d));
    }

    /* renamed from: a */
    protected void m48365a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.f11338q != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.f11339r);
        C3116af.m48496a("BeiZis", sb.toString());
        if (this.f11338q == null || this.f11339r) {
            return;
        }
        C3116af.m48496a("BeiZis", "callback onShakeHappened()");
        ShakeArcView shakeArcView = this.f11342u;
        if (shakeArcView != null && !ViewCheckUtil.m48280b(shakeArcView)) {
            C3116af.m48495b("ShakeUtil", "mShakeCount onShakeHappened mShakeArcView is not show");
            this.f11334m = -100.0f;
            this.f11335n = -100.0f;
            this.f11336o = -100.0f;
            this.f11332k = 0;
            this.f11333l = 0;
            this.f11337p = 0;
            return;
        }
        this.f11338q.mo46561b();
        this.f11339r = true;
        ShakeView shakeView = this.f11323a;
        if (shakeView != null) {
            shakeView.stopShake();
            m48341c();
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View m48360a(int r10, int r11, com.beizi.fusion.model.AdSpacesBean.BuyerBean.PercentPositionBean r12) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.C3133ar.m48360a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean):android.view.View");
    }
}
