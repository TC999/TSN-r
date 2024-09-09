package com.beizi.fusion.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.EulerAngleView;
import com.stub.StubApp;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: EulerAngleUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14995a = ao.class.getSimpleName();

    /* renamed from: k  reason: collision with root package name */
    private static SensorManager f14996k;

    /* renamed from: b  reason: collision with root package name */
    private Context f14997b;

    /* renamed from: c  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f14998c;

    /* renamed from: d  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f14999d;

    /* renamed from: e  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f15000e;

    /* renamed from: f  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f15001f;

    /* renamed from: g  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f15002g;

    /* renamed from: h  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean f15003h;

    /* renamed from: l  reason: collision with root package name */
    private Sensor f15006l;

    /* renamed from: p  reason: collision with root package name */
    private String f15010p;

    /* renamed from: q  reason: collision with root package name */
    private String f15011q;

    /* renamed from: r  reason: collision with root package name */
    private String f15012r;

    /* renamed from: u  reason: collision with root package name */
    private float f15015u;

    /* renamed from: v  reason: collision with root package name */
    private EulerAngleView f15016v;

    /* renamed from: w  reason: collision with root package name */
    private a f15017w;

    /* renamed from: y  reason: collision with root package name */
    private String f15019y;

    /* renamed from: z  reason: collision with root package name */
    private Boolean f15020z;

    /* renamed from: i  reason: collision with root package name */
    private float f15004i = 1.0E-9f;

    /* renamed from: j  reason: collision with root package name */
    private float[] f15005j = new float[3];

    /* renamed from: m  reason: collision with root package name */
    private double f15007m = 0.0d;

    /* renamed from: n  reason: collision with root package name */
    private double f15008n = 0.0d;

    /* renamed from: o  reason: collision with root package name */
    private double f15009o = 0.0d;

    /* renamed from: s  reason: collision with root package name */
    private boolean f15013s = false;

    /* renamed from: t  reason: collision with root package name */
    private int f15014t = 0;

    /* renamed from: x  reason: collision with root package name */
    private boolean f15018x = false;
    private SensorEventListener A = new SensorEventListener() { // from class: com.beizi.fusion.g.x.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                x.this.a(sensorEvent);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: EulerAngleUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a();
    }

    public x(Context context, String str, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2) {
        this.f15019y = null;
        f14996k = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("sensor");
        this.f14997b = context;
        this.f14998c = eulerAngleViewBean;
        this.f14999d = eulerAngleViewBean2;
        this.f15019y = "splash_cool_" + str;
        c();
        d();
    }

    private void d() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f15000e;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                int passivationTime = this.f15000e.getPassivationTime();
                final double d4 = 0.0d;
                final double d5 = 0.0d;
                final double d6 = 0.0d;
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > 0.0d) {
                                this.f15007m = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f15007m = eulerAngleRuleBean.getAngle();
                            }
                            d4 = eulerAngleRuleBean.getAngle();
                            this.f15010p = eulerAngleRuleBean.getDirection();
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > 0.0d) {
                                this.f15008n = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f15008n = eulerAngleRuleBean.getAngle();
                            }
                            d5 = eulerAngleRuleBean.getAngle();
                            this.f15011q = eulerAngleRuleBean.getDirection();
                        } else if ("z".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > 0.0d) {
                                this.f15009o = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f15009o = eulerAngleRuleBean.getAngle();
                            }
                            d6 = eulerAngleRuleBean.getAngle();
                            this.f15012r = eulerAngleRuleBean.getDirection();
                        }
                    }
                }
                if (passivationTime > 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.g.x.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                x.this.f15013s = true;
                                x.this.f15015u = 0.0f;
                                x.this.f15005j[0] = 0.0f;
                                x.this.f15005j[1] = 0.0f;
                                x.this.f15005j[2] = 0.0f;
                                x.this.f15007m = d4;
                                x.this.f15008n = d5;
                                x.this.f15009o = d6;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    }, am.b(passivationTime));
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean e() {
        try {
            if (this.f15007m > 0.0d) {
                if ("2".equals(this.f15010p)) {
                    float[] fArr = this.f15005j;
                    if (fArr[0] > 0.0f && Math.abs(fArr[0]) >= this.f15007m) {
                        return true;
                    }
                } else if ("1".equals(this.f15010p)) {
                    float[] fArr2 = this.f15005j;
                    if (fArr2[0] < 0.0f && Math.abs(fArr2[0]) >= this.f15007m) {
                        return true;
                    }
                } else if ("0".equals(this.f15010p) && Math.abs(this.f15005j[0]) >= this.f15007m) {
                    return true;
                }
            }
            if (this.f15008n > 0.0d) {
                if ("2".equals(this.f15011q)) {
                    float[] fArr3 = this.f15005j;
                    if (fArr3[1] < 0.0f && Math.abs(fArr3[1]) >= this.f15008n) {
                        return true;
                    }
                } else if ("1".equals(this.f15011q)) {
                    float[] fArr4 = this.f15005j;
                    if (fArr4[1] > 0.0f && Math.abs(fArr4[1]) >= this.f15008n) {
                        return true;
                    }
                } else if ("0".equals(this.f15011q) && Math.abs(this.f15005j[1]) >= this.f15008n) {
                    return true;
                }
            }
            if (this.f15009o > 0.0d) {
                if ("2".equals(this.f15012r)) {
                    float[] fArr5 = this.f15005j;
                    if (fArr5[2] > 0.0f && Math.abs(fArr5[2]) >= this.f15009o) {
                        return true;
                    }
                } else if ("1".equals(this.f15012r)) {
                    float[] fArr6 = this.f15005j;
                    if (fArr6[2] < 0.0f && Math.abs(fArr6[2]) >= this.f15009o) {
                        return true;
                    }
                } else if ("0".equals(this.f15012r) && Math.abs(this.f15005j[2]) >= this.f15009o) {
                    return true;
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return false;
    }

    private void f() {
        try {
            if (this.f15017w == null || this.f15018x || !ay.b(this.f15016v)) {
                return;
            }
            this.f15018x = true;
            if (this.f15013s && this.f15002g != null) {
                au.a(this.f14997b, this.f15019y, Long.valueOf(System.currentTimeMillis()));
            }
            this.f15017w.a();
            b();
            af.a(f14995a, "onEulerAngleHappened");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean b(long j4) {
        try {
            return System.currentTimeMillis() - this.f14997b.getPackageManager().getPackageInfo(this.f14997b.getPackageName(), 0).firstInstallTime < j4;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private void c() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean = this.f14998c;
            if (eulerAngleViewBean != null) {
                this.f15002g = eulerAngleViewBean.getCoolRule();
            }
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2 = this.f14999d;
            if (eulerAngleViewBean2 != null) {
                this.f15001f = eulerAngleViewBean2.getNomalRule();
                this.f15003h = this.f14999d.getRender();
            } else {
                AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean3 = this.f14998c;
                if (eulerAngleViewBean3 != null) {
                    this.f15001f = eulerAngleViewBean3.getNomalRule();
                    this.f15003h = this.f14998c.getRender();
                }
            }
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f15002g;
            if (eulerAngleViewRuleBean == null) {
                this.f15013s = true;
                this.f15000e = this.f15001f;
            } else if (a(eulerAngleViewRuleBean.getCoolTime())) {
                this.f15013s = false;
                this.f15000e = this.f15002g;
            } else if (b(this.f15002g.getUserProtectTime())) {
                this.f15013s = false;
                this.f15000e = this.f15002g;
            } else {
                this.f15013s = true;
                this.f15000e = this.f15001f;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean a(long j4) {
        try {
            long longValue = ((Long) au.b(this.f14997b, this.f15019y, 0L)).longValue();
            if (longValue != 0) {
                return System.currentTimeMillis() - longValue < j4;
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public void b() {
        try {
            af.a("BeiZis", "enter unRegisterListener");
            SensorManager sensorManager = f14996k;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.A);
            }
            EulerAngleView eulerAngleView = this.f15016v;
            if (eulerAngleView != null) {
                eulerAngleView.onDestroy();
            }
            this.f15016v = null;
            this.f14997b = null;
            this.f15017w = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a() {
        try {
            SensorManager sensorManager = f14996k;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.f15006l = defaultSensor;
                if (defaultSensor != null) {
                    f14996k.registerListener(this.A, defaultSensor, 1);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(ViewGroup viewGroup, int i4, int i5) {
        AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean;
        String str;
        String str2;
        String str3;
        int parseInt;
        int parseInt2;
        int parseInt3;
        int parseInt4;
        try {
            if (this.f14997b != null && (eulerAngleRenderBean = this.f15003h) != null && viewGroup != null) {
                String str4 = null;
                if (eulerAngleRenderBean != null) {
                    str4 = eulerAngleRenderBean.getCenterX();
                    str = this.f15003h.getCenterY();
                    str2 = this.f15003h.getWidth();
                    str3 = this.f15003h.getHeight();
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                str4 = (TextUtils.isEmpty(str4) || "0".equals(str4)) ? "85%" : "85%";
                str = (TextUtils.isEmpty(str) || "0".equals(str)) ? "50%" : "50%";
                str2 = (TextUtils.isEmpty(str2) || "0".equals(str2)) ? "120" : "120";
                str3 = (TextUtils.isEmpty(str3) || "0".equals(str3)) ? "120" : "120";
                float j4 = aw.j(this.f14997b);
                int i6 = 100;
                if (str4.endsWith("%")) {
                    parseInt = (Integer.parseInt(str4.substring(0, str4.indexOf("%"))) * i4) / 100;
                } else {
                    parseInt = Integer.parseInt(str4);
                }
                if (str.endsWith("%")) {
                    parseInt2 = (Integer.parseInt(str.substring(0, str.indexOf("%"))) * i5) / 100;
                } else {
                    parseInt2 = Integer.parseInt(str);
                }
                if (str2.endsWith("%")) {
                    parseInt3 = (((int) j4) * Integer.parseInt(str2.substring(0, str2.indexOf("%")))) / 100;
                } else {
                    parseInt3 = Integer.parseInt(str2);
                }
                if (str3.endsWith("%")) {
                    parseInt4 = (Integer.parseInt(str3.substring(0, str3.indexOf("%"))) * parseInt3) / 100;
                } else {
                    parseInt4 = Integer.parseInt(str3);
                }
                if (parseInt3 == 0) {
                    parseInt3 = 100;
                }
                if (parseInt4 != 0) {
                    i6 = parseInt4;
                }
                if (parseInt2 == 0) {
                    parseInt2 = aw.a(this.f14997b, i5) / 2;
                }
                if (parseInt == 0) {
                    parseInt = aw.a(this.f14997b, i4) / 2;
                }
                int a4 = aw.a(this.f14997b, parseInt3);
                int a5 = aw.a(this.f14997b, i6);
                int a6 = aw.a(this.f14997b, parseInt);
                int a7 = aw.a(this.f14997b, parseInt2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                EulerAngleView eulerAngleView = new EulerAngleView(this.f14997b);
                this.f15016v = eulerAngleView;
                eulerAngleView.setEulerAngleViewRuleBean(this.f15000e);
                this.f15016v.setEulerAngleRenderBean(this.f15003h);
                this.f15016v.setAnimationViewWidthAndHeight(a4, a5);
                this.f15016v.setDownloadApp(this.f15020z);
                this.f15016v.buildEulerAngleView();
                this.f15016v.measure(0, 0);
                int measuredWidth = this.f15016v.getMeasuredWidth();
                int measuredHeight = this.f15016v.getMeasuredHeight();
                af.a("BeiZis", "centerYInt = " + a7 + ",centerXInt = " + a6 + ",adWidthDp = " + i4 + ",adHeightDp = " + i5 + ",widthInt = " + a4 + ",heightInt = " + a5 + ",viewWidth = " + measuredWidth + ",viewHeight = " + measuredHeight);
                layoutParams.topMargin = a7 - (measuredHeight / 2);
                layoutParams.leftMargin = a6 - (measuredWidth / 2);
                viewGroup.addView(this.f15016v, layoutParams);
                this.f15016v.startContinuousRotations();
            }
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.f15017w = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (this.f15018x) {
                    return;
                }
                Sensor sensor = sensorEvent.sensor;
                float[] fArr = sensorEvent.values;
                int type = sensor.getType();
                if (fArr != null && type == 4) {
                    float f4 = this.f15015u;
                    if (f4 != 0.0f) {
                        float f5 = fArr[0];
                        float f6 = fArr[1];
                        float f7 = fArr[2];
                        float f8 = (((float) sensorEvent.timestamp) - f4) * this.f15004i;
                        float[] fArr2 = this.f15005j;
                        double d4 = fArr2[0];
                        double degrees = Math.toDegrees(f5 * f8);
                        Double.isNaN(d4);
                        fArr2[0] = (float) (d4 + degrees);
                        float[] fArr3 = this.f15005j;
                        double d5 = fArr3[1];
                        double degrees2 = Math.toDegrees(f6 * f8);
                        Double.isNaN(d5);
                        fArr3[1] = (float) (d5 + degrees2);
                        float[] fArr4 = this.f15005j;
                        double d6 = fArr4[2];
                        double degrees3 = Math.toDegrees(f7 * f8);
                        Double.isNaN(d6);
                        fArr4[2] = (float) (d6 + degrees3);
                        EulerAngleView eulerAngleView = this.f15016v;
                        if (eulerAngleView != null) {
                            eulerAngleView.setAngle(this.f15007m, this.f15008n, this.f15009o);
                            EulerAngleView eulerAngleView2 = this.f15016v;
                            float[] fArr5 = this.f15005j;
                            eulerAngleView2.setCurrentProgress(fArr5[0], fArr5[1], fArr5[2]);
                        }
                        af.a(f14995a, "rotate  x: " + String.format("%.4f", Float.valueOf(this.f15005j[0])) + ",y: " + String.format("%.4f", Float.valueOf(this.f15005j[1])) + ",z: " + String.format("%.4f", Float.valueOf(this.f15005j[2])) + ",x : " + this.f15007m + ",y : " + this.f15008n + ",z : " + this.f15009o);
                        if (e()) {
                            f();
                        }
                    }
                    this.f15015u = (float) sensorEvent.timestamp;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void a(Boolean bool) {
        this.f15020z = bool;
    }
}
