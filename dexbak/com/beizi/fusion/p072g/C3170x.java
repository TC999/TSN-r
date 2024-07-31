package com.beizi.fusion.p072g;

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
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.List;

/* compiled from: EulerAngleUtil.java */
/* renamed from: com.beizi.fusion.g.x */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3170x {

    /* renamed from: a */
    private static final String f11440a = RollUtil.class.getSimpleName();

    /* renamed from: k */
    private static SensorManager f11441k;

    /* renamed from: b */
    private Context f11442b;

    /* renamed from: c */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f11443c;

    /* renamed from: d */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f11444d;

    /* renamed from: e */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f11445e;

    /* renamed from: f */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f11446f;

    /* renamed from: g */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f11447g;

    /* renamed from: h */
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean f11448h;

    /* renamed from: l */
    private Sensor f11451l;

    /* renamed from: p */
    private String f11455p;

    /* renamed from: q */
    private String f11456q;

    /* renamed from: r */
    private String f11457r;

    /* renamed from: u */
    private float f11460u;

    /* renamed from: v */
    private EulerAngleView f11461v;

    /* renamed from: w */
    private InterfaceC3173a f11462w;

    /* renamed from: y */
    private String f11464y;

    /* renamed from: i */
    private float f11449i = 1.0E-9f;

    /* renamed from: j */
    private float[] f11450j = new float[3];

    /* renamed from: m */
    private double f11452m = Utils.DOUBLE_EPSILON;

    /* renamed from: n */
    private double f11453n = Utils.DOUBLE_EPSILON;

    /* renamed from: o */
    private double f11454o = Utils.DOUBLE_EPSILON;

    /* renamed from: s */
    private boolean f11458s = false;

    /* renamed from: t */
    private int f11459t = 0;

    /* renamed from: x */
    private boolean f11463x = false;

    /* renamed from: z */
    private SensorEventListener f11465z = new SensorEventListener() { // from class: com.beizi.fusion.g.x.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                C3170x.this.m48184a(sensorEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    /* compiled from: EulerAngleUtil.java */
    /* renamed from: com.beizi.fusion.g.x$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3173a {
        /* renamed from: a */
        void mo46518a();
    }

    public C3170x(Context context, String str, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2) {
        this.f11464y = null;
        f11441k = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(UMCommonContent.f37799ac);
        this.f11442b = context;
        this.f11443c = eulerAngleViewBean;
        this.f11444d = eulerAngleViewBean2;
        this.f11464y = "splash_cool_" + str;
        m48173c();
        m48171d();
    }

    /* renamed from: d */
    private void m48171d() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f11445e;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                int passivationTime = this.f11445e.getPassivationTime();
                final double d = 0.0d;
                final double d2 = 0.0d;
                final double d3 = 0.0d;
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > Utils.DOUBLE_EPSILON) {
                                this.f11452m = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f11452m = eulerAngleRuleBean.getAngle();
                            }
                            d = eulerAngleRuleBean.getAngle();
                            this.f11455p = eulerAngleRuleBean.getDirection();
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > Utils.DOUBLE_EPSILON) {
                                this.f11453n = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f11453n = eulerAngleRuleBean.getAngle();
                            }
                            d2 = eulerAngleRuleBean.getAngle();
                            this.f11456q = eulerAngleRuleBean.getDirection();
                        } else if (UMCommonContent.f37777aG.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > Utils.DOUBLE_EPSILON) {
                                this.f11454o = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f11454o = eulerAngleRuleBean.getAngle();
                            }
                            d3 = eulerAngleRuleBean.getAngle();
                            this.f11457r = eulerAngleRuleBean.getDirection();
                        }
                    }
                }
                if (passivationTime > 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.g.x.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C3170x.this.f11458s = true;
                                C3170x.this.f11460u = 0.0f;
                                C3170x.this.f11450j[0] = 0.0f;
                                C3170x.this.f11450j[1] = 0.0f;
                                C3170x.this.f11450j[2] = 0.0f;
                                C3170x.this.f11452m = d;
                                C3170x.this.f11453n = d2;
                                C3170x.this.f11454o = d3;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, RandomUtils.m48436b(passivationTime));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private boolean m48170e() {
        try {
            if (this.f11452m > Utils.DOUBLE_EPSILON) {
                if ("2".equals(this.f11455p)) {
                    float[] fArr = this.f11450j;
                    if (fArr[0] > 0.0f && Math.abs(fArr[0]) >= this.f11452m) {
                        return true;
                    }
                } else if ("1".equals(this.f11455p)) {
                    float[] fArr2 = this.f11450j;
                    if (fArr2[0] < 0.0f && Math.abs(fArr2[0]) >= this.f11452m) {
                        return true;
                    }
                } else if ("0".equals(this.f11455p) && Math.abs(this.f11450j[0]) >= this.f11452m) {
                    return true;
                }
            }
            if (this.f11453n > Utils.DOUBLE_EPSILON) {
                if ("2".equals(this.f11456q)) {
                    float[] fArr3 = this.f11450j;
                    if (fArr3[1] < 0.0f && Math.abs(fArr3[1]) >= this.f11453n) {
                        return true;
                    }
                } else if ("1".equals(this.f11456q)) {
                    float[] fArr4 = this.f11450j;
                    if (fArr4[1] > 0.0f && Math.abs(fArr4[1]) >= this.f11453n) {
                        return true;
                    }
                } else if ("0".equals(this.f11456q) && Math.abs(this.f11450j[1]) >= this.f11453n) {
                    return true;
                }
            }
            if (this.f11454o > Utils.DOUBLE_EPSILON) {
                if ("2".equals(this.f11457r)) {
                    float[] fArr5 = this.f11450j;
                    if (fArr5[2] > 0.0f && Math.abs(fArr5[2]) >= this.f11454o) {
                        return true;
                    }
                } else if ("1".equals(this.f11457r)) {
                    float[] fArr6 = this.f11450j;
                    if (fArr6[2] < 0.0f && Math.abs(fArr6[2]) >= this.f11454o) {
                        return true;
                    }
                } else if ("0".equals(this.f11457r) && Math.abs(this.f11450j[2]) >= this.f11454o) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: f */
    private void m48169f() {
        try {
            if (this.f11462w == null || this.f11463x || !ViewCheckUtil.m48280b(this.f11461v)) {
                return;
            }
            this.f11463x = true;
            if (this.f11458s && this.f11447g != null) {
                C3137at.m48315a(this.f11442b, this.f11464y, Long.valueOf(System.currentTimeMillis()));
            }
            this.f11462w.mo46518a();
            m48176b();
            C3116af.m48496a(f11440a, "onEulerAngleHappened");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private boolean m48175b(long j) {
        try {
            return System.currentTimeMillis() - this.f11442b.getPackageManager().getPackageInfo(this.f11442b.getPackageName(), 0).firstInstallTime < j;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private void m48173c() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean = this.f11443c;
            if (eulerAngleViewBean != null) {
                this.f11447g = eulerAngleViewBean.getCoolRule();
            }
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2 = this.f11444d;
            if (eulerAngleViewBean2 != null) {
                this.f11446f = eulerAngleViewBean2.getNomalRule();
                this.f11448h = this.f11444d.getRender();
            } else {
                AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean3 = this.f11443c;
                if (eulerAngleViewBean3 != null) {
                    this.f11446f = eulerAngleViewBean3.getNomalRule();
                    this.f11448h = this.f11443c.getRender();
                }
            }
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f11447g;
            if (eulerAngleViewRuleBean == null) {
                this.f11458s = true;
                this.f11445e = this.f11446f;
            } else if (m48185a(eulerAngleViewRuleBean.getCoolTime())) {
                this.f11458s = false;
                this.f11445e = this.f11447g;
            } else if (m48175b(this.f11447g.getUserProtectTime())) {
                this.f11458s = false;
                this.f11445e = this.f11447g;
            } else {
                this.f11458s = true;
                this.f11445e = this.f11446f;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private boolean m48185a(long j) {
        try {
            long longValue = ((Long) C3137at.m48313b(this.f11442b, this.f11464y, 0L)).longValue();
            if (longValue != 0) {
                return System.currentTimeMillis() - longValue < j;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public void m48176b() {
        try {
            C3116af.m48496a("BeiZis", "enter unRegisterListener");
            SensorManager sensorManager = f11441k;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.f11465z);
            }
            EulerAngleView eulerAngleView = this.f11461v;
            if (eulerAngleView != null) {
                eulerAngleView.onDestroy();
            }
            this.f11461v = null;
            this.f11442b = null;
            this.f11462w = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m48186a() {
        try {
            SensorManager sensorManager = f11441k;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.f11451l = defaultSensor;
                if (defaultSensor != null) {
                    f11441k.registerListener(this.f11465z, defaultSensor, 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m48183a(ViewGroup viewGroup, int i, int i2) {
        AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean;
        String str;
        String str2;
        String str3;
        int parseInt;
        int parseInt2;
        int parseInt3;
        int parseInt4;
        try {
            if (this.f11442b != null && (eulerAngleRenderBean = this.f11448h) != null && viewGroup != null) {
                String str4 = null;
                if (eulerAngleRenderBean != null) {
                    str4 = eulerAngleRenderBean.getCenterX();
                    str = this.f11448h.getCenterY();
                    str2 = this.f11448h.getWidth();
                    str3 = this.f11448h.getHeight();
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                str4 = (TextUtils.isEmpty(str4) || "0".equals(str4)) ? "85%" : "85%";
                str = (TextUtils.isEmpty(str) || "0".equals(str)) ? "50%" : "50%";
                str2 = (TextUtils.isEmpty(str2) || "0".equals(str2)) ? "120" : "120";
                str3 = (TextUtils.isEmpty(str3) || "0".equals(str3)) ? "120" : "120";
                float m48288j = C3138av.m48288j(this.f11442b);
                int i3 = 100;
                if (str4.endsWith("%")) {
                    parseInt = (Integer.parseInt(str4.substring(0, str4.indexOf("%"))) * i) / 100;
                } else {
                    parseInt = Integer.parseInt(str4);
                }
                if (str.endsWith("%")) {
                    parseInt2 = (Integer.parseInt(str.substring(0, str.indexOf("%"))) * i2) / 100;
                } else {
                    parseInt2 = Integer.parseInt(str);
                }
                if (str2.endsWith("%")) {
                    parseInt3 = (((int) m48288j) * Integer.parseInt(str2.substring(0, str2.indexOf("%")))) / 100;
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
                    i3 = parseInt4;
                }
                if (parseInt2 == 0) {
                    parseInt2 = C3138av.m48304a(this.f11442b, i2) / 2;
                }
                if (parseInt == 0) {
                    parseInt = C3138av.m48304a(this.f11442b, i) / 2;
                }
                int m48304a = C3138av.m48304a(this.f11442b, parseInt3);
                int m48304a2 = C3138av.m48304a(this.f11442b, i3);
                int m48304a3 = C3138av.m48304a(this.f11442b, parseInt);
                int m48304a4 = C3138av.m48304a(this.f11442b, parseInt2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                EulerAngleView eulerAngleView = new EulerAngleView(this.f11442b);
                this.f11461v = eulerAngleView;
                eulerAngleView.setEulerAngleViewRuleBean(this.f11445e);
                this.f11461v.setEulerAngleRenderBean(this.f11448h);
                this.f11461v.setAnimationViewWidthAndHeight(m48304a, m48304a2);
                this.f11461v.buildEulerAngleView();
                this.f11461v.measure(0, 0);
                int measuredWidth = this.f11461v.getMeasuredWidth();
                int measuredHeight = this.f11461v.getMeasuredHeight();
                C3116af.m48496a("BeiZis", "centerYInt = " + m48304a4 + ",centerXInt = " + m48304a3 + ",adWidthDp = " + i + ",adHeightDp = " + i2 + ",widthInt = " + m48304a + ",heightInt = " + m48304a2 + ",viewWidth = " + measuredWidth + ",viewHeight = " + measuredHeight);
                layoutParams.topMargin = m48304a4 - (measuredHeight / 2);
                layoutParams.leftMargin = m48304a3 - (measuredWidth / 2);
                viewGroup.addView(this.f11461v, layoutParams);
                this.f11461v.startContinuousRotations();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m48182a(InterfaceC3173a interfaceC3173a) {
        this.f11462w = interfaceC3173a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48184a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (this.f11463x) {
                    return;
                }
                Sensor sensor = sensorEvent.sensor;
                float[] fArr = sensorEvent.values;
                int type = sensor.getType();
                if (fArr != null && type == 4) {
                    float f = this.f11460u;
                    if (f != 0.0f) {
                        float f2 = fArr[0];
                        float f3 = fArr[1];
                        float f4 = fArr[2];
                        float f5 = (((float) sensorEvent.timestamp) - f) * this.f11449i;
                        float[] fArr2 = this.f11450j;
                        double d = fArr2[0];
                        double degrees = Math.toDegrees(f2 * f5);
                        Double.isNaN(d);
                        fArr2[0] = (float) (d + degrees);
                        float[] fArr3 = this.f11450j;
                        double d2 = fArr3[1];
                        double degrees2 = Math.toDegrees(f3 * f5);
                        Double.isNaN(d2);
                        fArr3[1] = (float) (d2 + degrees2);
                        float[] fArr4 = this.f11450j;
                        double d3 = fArr4[2];
                        double degrees3 = Math.toDegrees(f4 * f5);
                        Double.isNaN(d3);
                        fArr4[2] = (float) (d3 + degrees3);
                        EulerAngleView eulerAngleView = this.f11461v;
                        if (eulerAngleView != null) {
                            eulerAngleView.setAngle(this.f11452m, this.f11453n, this.f11454o);
                            EulerAngleView eulerAngleView2 = this.f11461v;
                            float[] fArr5 = this.f11450j;
                            eulerAngleView2.setCurrentProgress(fArr5[0], fArr5[1], fArr5[2]);
                        }
                        C3116af.m48496a(f11440a, "rotate  x: " + String.format("%.4f", Float.valueOf(this.f11450j[0])) + ",y: " + String.format("%.4f", Float.valueOf(this.f11450j[1])) + ",z: " + String.format("%.4f", Float.valueOf(this.f11450j[2])) + ",x : " + this.f11452m + ",y : " + this.f11453n + ",z : " + this.f11454o);
                        if (m48170e()) {
                            m48169f();
                        }
                    }
                    this.f11460u = (float) sensorEvent.timestamp;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
