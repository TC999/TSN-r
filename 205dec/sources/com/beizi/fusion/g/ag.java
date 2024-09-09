package com.beizi.fusion.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ShakeView;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NativeShakeUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ag {

    /* renamed from: b  reason: collision with root package name */
    private static SensorManager f14759b;

    /* renamed from: a  reason: collision with root package name */
    ShakeView f14760a;

    /* renamed from: c  reason: collision with root package name */
    private Context f14761c;

    /* renamed from: d  reason: collision with root package name */
    private double f14762d;

    /* renamed from: e  reason: collision with root package name */
    private double f14763e;

    /* renamed from: f  reason: collision with root package name */
    private double f14764f;

    /* renamed from: g  reason: collision with root package name */
    private int f14765g;

    /* renamed from: h  reason: collision with root package name */
    private int f14766h;

    /* renamed from: t  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.CoolShakeViewBean f14778t;

    /* renamed from: u  reason: collision with root package name */
    private String f14779u;

    /* renamed from: w  reason: collision with root package name */
    private boolean f14781w;

    /* renamed from: i  reason: collision with root package name */
    private int f14767i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f14768j = 0;

    /* renamed from: k  reason: collision with root package name */
    private float f14769k = -100.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f14770l = -100.0f;

    /* renamed from: m  reason: collision with root package name */
    private float f14771m = -100.0f;

    /* renamed from: n  reason: collision with root package name */
    private int f14772n = 0;

    /* renamed from: o  reason: collision with root package name */
    private a f14773o = null;

    /* renamed from: p  reason: collision with root package name */
    private boolean f14774p = false;

    /* renamed from: q  reason: collision with root package name */
    private int f14775q = 200;

    /* renamed from: r  reason: collision with root package name */
    private View f14776r = null;

    /* renamed from: s  reason: collision with root package name */
    private long f14777s = 0;

    /* renamed from: v  reason: collision with root package name */
    private boolean f14780v = false;

    /* renamed from: x  reason: collision with root package name */
    private final SensorEventListener f14782x = new SensorEventListener() { // from class: com.beizi.fusion.g.ag.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (System.currentTimeMillis() - ag.this.f14777s < 200) {
                return;
            }
            if (ay.a(ag.this.f14776r)) {
                if (ag.this.f14780v && ag.this.f14778t != null && !TextUtils.isEmpty(ag.this.f14779u) && ar.a().b(ag.this.f14779u) > 0) {
                    af.c("ShakeUtil", "mShakeCount isUserSensitiveScheme:" + ag.this.f14780v + ";coolShakeViewBean:" + ag.this.f14778t + ";coolConfigKey:" + ag.this.f14779u + ";getCoolTime:" + ar.a().b(ag.this.f14779u));
                    ag agVar = ag.this;
                    agVar.a(agVar.f14778t);
                }
                float[] fArr = sensorEvent.values;
                float f4 = fArr[0];
                float f5 = fArr[1];
                float f6 = fArr[2];
                if (ag.this.f14769k == -100.0f) {
                    ag.this.f14769k = f4;
                }
                if (ag.this.f14770l == -100.0f) {
                    ag.this.f14770l = f5;
                }
                if (ag.this.f14771m == -100.0f) {
                    ag.this.f14771m = f6;
                }
                af.b("ShakeUtil", "x = " + f4 + ",initialX = " + ag.this.f14769k + ",y = " + f5 + ",initialY = " + ag.this.f14770l + ",z = " + f6 + ",initialZ = " + ag.this.f14771m);
                double abs = (double) Math.abs(f4 - ag.this.f14769k);
                Double.isNaN(abs);
                double d4 = abs / 9.8d;
                double abs2 = (double) Math.abs(f5 - ag.this.f14770l);
                Double.isNaN(abs2);
                double d5 = abs2 / 9.8d;
                double abs3 = (double) Math.abs(f6 - ag.this.f14771m);
                Double.isNaN(abs3);
                double d6 = abs3 / 9.8d;
                af.b("ShakeUtil", "rotateX = " + d4 + ",rotateY = " + d5 + ",rotateZ = " + d6 + ",rotateAmplitude = " + ag.this.f14764f);
                if (d4 > ag.this.f14764f) {
                    ag.j(ag.this);
                    ag.this.f14769k = f4;
                }
                if (d5 > ag.this.f14764f) {
                    ag.j(ag.this);
                    ag.this.f14770l = f5;
                }
                if (d6 > ag.this.f14764f) {
                    ag.j(ag.this);
                    ag.this.f14771m = f6;
                }
                ag agVar2 = ag.this;
                if (agVar2.a(f4, f5, f6, agVar2.f14762d)) {
                    ag.this.f14772n = 1;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("mRotateCount:");
                sb.append(ag.this.f14768j);
                sb.append(";mShakeCount:");
                sb.append(ag.this.f14767i);
                sb.append(",mShakeState = ");
                sb.append(ag.this.f14772n);
                sb.append(",isShakeStart = ");
                ag agVar3 = ag.this;
                sb.append(agVar3.a(f4, f5, f6, agVar3.f14762d));
                sb.append(",isShakeEnd = ");
                ag agVar4 = ag.this;
                sb.append(agVar4.b(f4, f5, f6, agVar4.f14763e));
                af.b("ShakeUtil", sb.toString());
                if (ag.this.f14772n == 1) {
                    ag agVar5 = ag.this;
                    if (agVar5.b(f4, f5, f6, agVar5.f14763e)) {
                        ag.this.f14772n = 2;
                        ag.p(ag.this);
                    }
                }
                af.b("ShakeUtil", "mShakeCount = " + ag.this.f14767i + ",dstShakeCount = " + ag.this.f14765g + ",mRotateCount = " + ag.this.f14768j + ",dstRotateCount = " + ag.this.f14766h);
                if ((ag.this.f14765g > 0 && ag.this.f14767i >= ag.this.f14765g) || (ag.this.f14766h > 0 && ag.this.f14768j >= ag.this.f14766h)) {
                    ag.this.a();
                }
                ag.this.f14777s = System.currentTimeMillis();
                return;
            }
            af.b("ShakeUtil", "onShakeHappened mContainerView is not show");
            ag.this.d();
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: NativeShakeUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a();
    }

    public ag(Context context) {
        this.f14761c = context;
        f14759b = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("sensor");
    }

    static /* synthetic */ int j(ag agVar) {
        int i4 = agVar.f14768j;
        agVar.f14768j = i4 + 1;
        return i4;
    }

    static /* synthetic */ int p(ag agVar) {
        int i4 = agVar.f14767i;
        agVar.f14767i = i4 + 1;
        return i4;
    }

    public void d() {
        this.f14769k = -100.0f;
        this.f14770l = -100.0f;
        this.f14771m = -100.0f;
        this.f14772n = 0;
        this.f14775q = 200;
        this.f14767i = 0;
        this.f14768j = 0;
        this.f14774p = false;
    }

    public void c(double d4) {
        this.f14764f = d4;
    }

    public void b(double d4) {
        this.f14763e = d4;
    }

    public void c() {
        af.a("BeiZis", "enter unRegisterShakeListenerAndSetDefault");
        SensorManager sensorManager = f14759b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f14782x);
        }
        d();
        ShakeView shakeView = this.f14760a;
        if (shakeView != null) {
            shakeView.stopShake();
        }
        this.f14773o = null;
        this.f14761c = null;
        this.f14760a = null;
    }

    public void b(int i4) {
        this.f14766h = i4;
    }

    public void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            return;
        }
        af.a("BeiZis", "setShakeParams shakeCount:" + shakeViewBean.getShakeCount() + ";rotatCount:" + shakeViewBean.getRotatCount());
        try {
            this.f14780v = true;
            a(shakeViewBean.getShakeCount());
            a(shakeViewBean.getShakeStartAmplitude());
            b(shakeViewBean.getShakeEndAmplitude());
            c(shakeViewBean.getRotatAmplitude());
            b(shakeViewBean.getRotatCount());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void b(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        this.f14778t = coolShakeViewBean;
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

    public void b() {
        SensorManager sensorManager = f14759b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f14782x, sensorManager.getDefaultSensor(1), 100000);
        }
    }

    public void a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        if (coolShakeViewBean == null) {
            return;
        }
        af.c("ShakeUtil", "setShakeCoolParams mShakeCount:" + coolShakeViewBean.getShakeCount() + ";mRotateCount:" + coolShakeViewBean.getRotatCount());
        try {
            this.f14780v = false;
            a(coolShakeViewBean.getShakeCount());
            a(coolShakeViewBean.getShakeStartAmplitude());
            b(coolShakeViewBean.getShakeEndAmplitude());
            c(coolShakeViewBean.getRotatAmplitude());
            b(coolShakeViewBean.getRotatCount());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean, String str) {
        b(coolShakeViewBean);
        a(str);
    }

    public void a(double d4) {
        this.f14762d = d4;
    }

    public void a(int i4) {
        this.f14765g = i4;
    }

    public void a(a aVar) {
        this.f14773o = aVar;
    }

    public void a(String str) {
        this.f14779u = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f4, float f5, float f6, double d4) {
        double d5 = f4;
        Double.isNaN(d5);
        double pow = Math.pow(d5 / 9.8d, 2.0d);
        double d6 = f5;
        Double.isNaN(d6);
        double pow2 = pow + Math.pow(d6 / 9.8d, 2.0d);
        double d7 = f6;
        Double.isNaN(d7);
        return Math.sqrt(pow2 + Math.pow(d7 / 9.8d, 2.0d)) > d4;
    }

    protected void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.f14773o != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.f14774p);
        af.a("BeiZis", sb.toString());
        if (this.f14773o == null || this.f14774p) {
            return;
        }
        af.a("BeiZis", "callback onShakeHappened()");
        this.f14774p = true;
        this.f14773o.a();
    }

    public void a(View view) {
        this.f14776r = view;
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
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.g.ag.a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c0, code lost:
        if (r3 >= 400) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View a(int r10, int r11, com.beizi.fusion.model.AdSpacesBean.BuyerBean.PercentPositionBean r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.g.ag.a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean, java.lang.String):android.view.View");
    }

    public void a(Boolean bool) {
        this.f14781w = bool.booleanValue();
    }
}
