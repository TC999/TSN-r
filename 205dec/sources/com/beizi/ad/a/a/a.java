package com.beizi.ad.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.beizi.ad.R;
import com.beizi.ad.internal.utilities.ImageManager;
import com.beizi.ad.internal.utilities.SPUtils;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.ad.lance.a.l;
import com.beizi.ad.lance.a.p;
import com.beizi.fusion.model.AdSpacesBean;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: EulerAngleUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    private static final String f13117g = "a";

    /* renamed from: q  reason: collision with root package name */
    private static SensorManager f13118q;
    private float A;
    private InterfaceC0114a B;
    private String E;
    private AnimatorSet J;
    private boolean K;

    /* renamed from: h  reason: collision with root package name */
    private Context f13126h;

    /* renamed from: i  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f13127i;

    /* renamed from: j  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f13128j;

    /* renamed from: k  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f13129k;

    /* renamed from: l  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f13130l;

    /* renamed from: m  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f13131m;

    /* renamed from: n  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean f13132n;

    /* renamed from: r  reason: collision with root package name */
    private Sensor f13135r;

    /* renamed from: v  reason: collision with root package name */
    private String f13139v;

    /* renamed from: w  reason: collision with root package name */
    private String f13140w;

    /* renamed from: x  reason: collision with root package name */
    private String f13141x;

    /* renamed from: o  reason: collision with root package name */
    private float f13133o = 1.0E-9f;

    /* renamed from: p  reason: collision with root package name */
    private float[] f13134p = new float[3];

    /* renamed from: s  reason: collision with root package name */
    private double f13136s = 0.0d;

    /* renamed from: t  reason: collision with root package name */
    private double f13137t = 0.0d;

    /* renamed from: u  reason: collision with root package name */
    private double f13138u = 0.0d;

    /* renamed from: y  reason: collision with root package name */
    private boolean f13142y = false;

    /* renamed from: z  reason: collision with root package name */
    private int f13143z = 0;
    private boolean C = true;
    private boolean D = false;

    /* renamed from: a  reason: collision with root package name */
    String f13120a = "x";

    /* renamed from: b  reason: collision with root package name */
    String f13121b = "y";

    /* renamed from: c  reason: collision with root package name */
    String f13122c = "z";

    /* renamed from: d  reason: collision with root package name */
    String f13123d = "0";

    /* renamed from: e  reason: collision with root package name */
    String f13124e = "1";

    /* renamed from: f  reason: collision with root package name */
    String f13125f = "2";
    private int F = 350;
    private float G = 60.0f;
    private float H = 60.0f;
    private float I = 30.0f;

    /* renamed from: L  reason: collision with root package name */
    private SensorEventListener f13119L = new SensorEventListener() { // from class: com.beizi.ad.a.a.a.4
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                a.this.a(sensorEvent);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: EulerAngleUtil.java */
    /* renamed from: com.beizi.ad.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface InterfaceC0114a {
        void a();
    }

    public a(Context context, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean, String str, String str2) {
        this.E = null;
        this.K = false;
        this.f13126h = context;
        this.f13127i = eulerAngleViewBean;
        this.E = "beizi_cool_" + str;
        AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean a4 = a(this.f13127i.getOrderData(), str2);
        if (a4 != null && a4.getEulerAngleRule() != null) {
            this.f13128j = a4.getEulerAngleRule();
        }
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2 = this.f13127i;
        if (eulerAngleViewBean2 != null) {
            this.f13131m = eulerAngleViewBean2.getCoolRule();
        }
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean3 = this.f13128j;
        if (eulerAngleViewBean3 != null) {
            this.f13130l = eulerAngleViewBean3.getNomalRule();
            this.f13132n = this.f13128j.getRender();
        } else {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean4 = this.f13127i;
            if (eulerAngleViewBean4 != null) {
                this.f13130l = eulerAngleViewBean4.getNomalRule();
                this.f13132n = this.f13127i.getRender();
            }
        }
        if (!d()) {
            this.K = false;
            return;
        }
        this.K = true;
        e();
        k();
    }

    private boolean d() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f13130l;
        if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
            for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                if (eulerAngleRuleBean != null) {
                    String axis = eulerAngleRuleBean.getAxis();
                    double angle = eulerAngleRuleBean.getAngle();
                    if (!TextUtils.isEmpty(axis) && angle > 0.0d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021 A[Catch: Exception -> 0x0031, TryCatch #0 {Exception -> 0x0031, blocks: (B:2:0x0000, B:4:0x0007, B:7:0x000e, B:12:0x001d, B:14:0x0021, B:16:0x0029, B:8:0x0011, B:10:0x0017, B:11:0x001b), top: B:21:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029 A[Catch: Exception -> 0x0031, TRY_LEAVE, TryCatch #0 {Exception -> 0x0031, blocks: (B:2:0x0000, B:4:0x0007, B:7:0x000e, B:12:0x001d, B:14:0x0021, B:16:0x0029, B:8:0x0011, B:10:0x0017, B:11:0x001b), top: B:21:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            r2 = this;
            boolean r0 = r2.i()     // Catch: java.lang.Exception -> L31
            r1 = 0
            if (r0 != 0) goto L11
            boolean r0 = r2.h()     // Catch: java.lang.Exception -> L31
            if (r0 == 0) goto Le
            goto L11
        Le:
            r2.f13142y = r1     // Catch: java.lang.Exception -> L31
            goto L1d
        L11:
            boolean r0 = r2.g()     // Catch: java.lang.Exception -> L31
            if (r0 == 0) goto L1b
            r0 = 1
            r2.f13142y = r0     // Catch: java.lang.Exception -> L31
            goto L1d
        L1b:
            r2.f13142y = r1     // Catch: java.lang.Exception -> L31
        L1d:
            boolean r0 = r2.f13142y     // Catch: java.lang.Exception -> L31
            if (r0 == 0) goto L29
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$EulerAngleViewRuleBean r0 = r2.f13131m     // Catch: java.lang.Exception -> L31
            r2.f13129k = r0     // Catch: java.lang.Exception -> L31
            r2.f()     // Catch: java.lang.Exception -> L31
            return
        L29:
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$EulerAngleViewRuleBean r0 = r2.f13130l     // Catch: java.lang.Exception -> L31
            r2.f13129k = r0     // Catch: java.lang.Exception -> L31
            r2.f()     // Catch: java.lang.Exception -> L31
            goto L35
        L31:
            r0 = move-exception
            r0.printStackTrace()
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.a.a.a.e():void");
    }

    private void f() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f13129k;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                int passivationTime = this.f13129k.getPassivationTime();
                final double d4 = 0.0d;
                final double d5 = 0.0d;
                final double d6 = 0.0d;
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        if (this.f13120a.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > 0.0d) {
                                this.f13136s = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f13136s = eulerAngleRuleBean.getAngle();
                            }
                            d4 = eulerAngleRuleBean.getAngle();
                            this.f13139v = eulerAngleRuleBean.getDirection();
                        } else if (this.f13121b.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > 0.0d) {
                                this.f13137t = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f13137t = eulerAngleRuleBean.getAngle();
                            }
                            d5 = eulerAngleRuleBean.getAngle();
                            this.f13140w = eulerAngleRuleBean.getDirection();
                        } else if (this.f13122c.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > 0.0d) {
                                this.f13138u = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f13138u = eulerAngleRuleBean.getAngle();
                            }
                            d6 = eulerAngleRuleBean.getAngle();
                            this.f13141x = eulerAngleRuleBean.getDirection();
                        }
                    }
                }
                if (passivationTime > 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.ad.a.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a.this.A = 0.0f;
                                a.this.f13134p[0] = 0.0f;
                                a.this.f13134p[1] = 0.0f;
                                a.this.f13134p[2] = 0.0f;
                                a.this.f13136s = d4;
                                a.this.f13137t = d5;
                                a.this.f13138u = d6;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    }, a(passivationTime));
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean g() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f13131m;
            if (eulerAngleViewRuleBean != null && eulerAngleViewRuleBean != null && eulerAngleViewRuleBean.getRules() != null && this.f13131m.getRules().size() > 0) {
                if (this.f13131m.getStyle() != null) {
                    return true;
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return false;
    }

    private boolean h() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f13131m;
            if (eulerAngleViewRuleBean == null) {
                return false;
            }
            long coolTime = eulerAngleViewRuleBean.getCoolTime();
            long longValue = ((Long) SPUtils.getFromFusionSdk(this.f13126h, this.E, 0L)).longValue();
            if (longValue != 0) {
                return System.currentTimeMillis() - longValue < coolTime;
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private boolean i() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f13131m;
            if (eulerAngleViewRuleBean == null) {
                return false;
            }
            return System.currentTimeMillis() - this.f13126h.getPackageManager().getPackageInfo(this.f13126h.getPackageName(), 0).firstInstallTime < eulerAngleViewRuleBean.getUserProtectTime();
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private void j() {
        this.A = 0.0f;
        float[] fArr = this.f13134p;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    private void k() {
        try {
            if (f13118q == null) {
                f13118q = (SensorManager) StubApp.getOrigApplicationContext(this.f13126h.getApplicationContext()).getSystemService("sensor");
            }
            if (this.f13135r == null) {
                this.f13135r = f13118q.getDefaultSensor(4);
            }
            f13118q.registerListener(this.f13119L, this.f13135r, 1);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void l() {
        try {
            l.a(f13117g, "enter unRegisterListener");
            SensorManager sensorManager = f13118q;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.f13119L);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean m() {
        try {
            if (this.f13136s > 0.0d) {
                if (this.f13125f.equals(this.f13139v)) {
                    float[] fArr = this.f13134p;
                    if (fArr[0] > 0.0f && Math.abs(fArr[0]) >= this.f13136s) {
                        return true;
                    }
                } else if (this.f13124e.equals(this.f13139v)) {
                    float[] fArr2 = this.f13134p;
                    if (fArr2[0] < 0.0f && Math.abs(fArr2[0]) >= this.f13136s) {
                        return true;
                    }
                } else if (this.f13123d.equals(this.f13139v) && Math.abs(this.f13134p[0]) >= this.f13136s) {
                    return true;
                }
            }
            if (this.f13137t > 0.0d) {
                if (this.f13125f.equals(this.f13140w)) {
                    float[] fArr3 = this.f13134p;
                    if (fArr3[1] < 0.0f && Math.abs(fArr3[1]) >= this.f13137t) {
                        return true;
                    }
                } else if (this.f13124e.equals(this.f13140w)) {
                    float[] fArr4 = this.f13134p;
                    if (fArr4[1] > 0.0f && Math.abs(fArr4[1]) >= this.f13137t) {
                        return true;
                    }
                } else if (this.f13123d.equals(this.f13140w) && Math.abs(this.f13134p[1]) >= this.f13137t) {
                    return true;
                }
            }
            if (this.f13138u > 0.0d) {
                if (this.f13125f.equals(this.f13141x)) {
                    float[] fArr5 = this.f13134p;
                    if (fArr5[2] > 0.0f && Math.abs(fArr5[2]) >= this.f13138u) {
                        return true;
                    }
                } else if (this.f13124e.equals(this.f13141x)) {
                    float[] fArr6 = this.f13134p;
                    if (fArr6[2] < 0.0f && Math.abs(fArr6[2]) >= this.f13138u) {
                        return true;
                    }
                } else if (this.f13123d.equals(this.f13141x) && Math.abs(this.f13134p[2]) >= this.f13138u) {
                    return true;
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return false;
    }

    private void n() {
        try {
            if (this.B != null && this.C) {
                l.a(f13117g, "onEulerAngleHappened");
                b();
                if (!this.f13142y) {
                    SPUtils.putToFusionSdk(this.f13126h, this.E, Long.valueOf(System.currentTimeMillis()));
                }
                this.B.a();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c() {
        try {
            l();
            this.f13127i = null;
            this.f13128j = null;
            this.f13129k = null;
            this.f13130l = null;
            this.f13131m = null;
            this.f13132n = null;
            this.f13126h = null;
            this.B = null;
            f13118q = null;
            this.f13135r = null;
            AnimatorSet animatorSet = this.J;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.J = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void b() {
        this.C = false;
        j();
        l();
    }

    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean a(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBean : list) {
                List<String> orderList = orderDataEulerAngleViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataEulerAngleViewBean;
                }
            }
        }
        return null;
    }

    private int[] b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean;
        int parseInt;
        int parseInt2;
        int parseInt3;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                eulerAngleRenderBean = this.f13132n;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (eulerAngleRenderBean != null) {
                String centerX = eulerAngleRenderBean.getCenterX();
                String centerY = this.f13132n.getCenterY();
                String width = this.f13132n.getWidth();
                String height = this.f13132n.getHeight();
                centerX = (TextUtils.isEmpty(centerX) || "0".equals(centerX)) ? "10" : "10";
                centerY = (TextUtils.isEmpty(centerY) || "0".equals(centerY)) ? "10" : "10";
                viewGroup.measure(0, 0);
                int px2dip = ViewUtil.px2dip(this.f13126h, viewGroup.getMeasuredWidth());
                int px2dip2 = ViewUtil.px2dip(this.f13126h, viewGroup.getMeasuredHeight());
                if (px2dip <= 0) {
                    px2dip = p.k(this.f13126h);
                }
                String str = f13117g;
                l.a(str, "position containerWidth:" + px2dip + ";containerHeight:" + px2dip2 + ";" + viewGroup.getLayoutParams().width + ";" + viewGroup.getLayoutParams().height);
                width = (TextUtils.isEmpty(width) || "0".equals(width)) ? "20" : "20";
                height = (TextUtils.isEmpty(height) || "0".equals(height)) ? "20" : "20";
                if (centerX.endsWith("%")) {
                    parseInt = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * px2dip) / 100;
                } else {
                    parseInt = !TextUtils.isEmpty(centerX) ? Integer.parseInt(centerX) : 0;
                }
                if (centerY.endsWith("%")) {
                    parseInt2 = (px2dip2 * Integer.parseInt(centerY.substring(0, centerY.indexOf("%")))) / 100;
                } else {
                    parseInt2 = !TextUtils.isEmpty(centerY) ? Integer.parseInt(centerY) : 0;
                }
                int i4 = 20;
                if (width.endsWith("%")) {
                    parseInt3 = (px2dip * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100;
                } else {
                    parseInt3 = !TextUtils.isEmpty(width) ? Integer.parseInt(width) : 20;
                }
                if (height.endsWith("%")) {
                    i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * parseInt3) / 100;
                } else if (!TextUtils.isEmpty(width)) {
                    i4 = Integer.parseInt(height);
                }
                int dip2px = ViewUtil.dip2px(this.f13126h, parseInt3);
                int dip2px2 = ViewUtil.dip2px(this.f13126h, i4);
                int dip2px3 = ViewUtil.dip2px(this.f13126h, parseInt);
                int dip2px4 = ViewUtil.dip2px(this.f13126h, parseInt2);
                iArr[0] = dip2px;
                iArr[1] = dip2px2;
                if (dip2px3 > 0) {
                    iArr[2] = dip2px3;
                }
                if (dip2px4 > 0) {
                    iArr[3] = dip2px4;
                }
                l.a(str, "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + ";" + centerX + ";" + centerY);
                return iArr;
            }
        }
        int dip2px5 = ViewUtil.dip2px(this.f13126h, 20.0f);
        int dip2px6 = ViewUtil.dip2px(this.f13126h, 10.0f);
        iArr[0] = dip2px5;
        iArr[1] = dip2px5;
        iArr[2] = dip2px6;
        iArr[3] = dip2px6;
        return iArr;
    }

    public int a(int i4) {
        double random = Math.random();
        double d4 = i4;
        Double.isNaN(d4);
        return (int) ((random * d4) + 1.0d);
    }

    public void a() {
        if (this.D || !this.K) {
            return;
        }
        this.C = true;
        j();
        e();
        k();
    }

    public void a(InterfaceC0114a interfaceC0114a) {
        this.B = interfaceC0114a;
    }

    public void a(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.EulerAngleStyleBean style;
        List<String> imgs;
        if (viewGroup != null) {
            try {
                if (this.f13126h != null && this.K) {
                    final ImageView imageView = new ImageView(this.f13126h);
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.mipmap.beizi_interaction_icon_euler_angle);
                    String str = null;
                    AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f13129k;
                    if (eulerAngleViewRuleBean != null && (style = eulerAngleViewRuleBean.getStyle()) != null && (imgs = style.getImgs()) != null && imgs.size() > 0) {
                        str = imgs.get(0);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        ImageManager.with(this.f13126h).getCacheBitmap(str, new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.a.a.a.2
                            @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                            public void onBitmapLoadFailed() {
                            }

                            @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                            public void onBitmapLoaded(Bitmap bitmap) {
                                try {
                                    ImageView imageView2 = imageView;
                                    if (imageView2 == null || bitmap == null) {
                                        return;
                                    }
                                    imageView2.setImageBitmap(bitmap);
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                        });
                    }
                    int[] b4 = b(viewGroup);
                    if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        if (b4[0] > 0) {
                            layoutParams.width = b4[0];
                        }
                        if (b4[1] > 0) {
                            layoutParams.height = b4[1];
                        }
                        layoutParams.leftMargin = b4[2];
                        layoutParams.topMargin = b4[3];
                        layoutParams.addRule(17);
                        viewGroup.addView(imageView, layoutParams);
                    } else if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 17);
                        if (b4[0] > 0) {
                            layoutParams2.width = b4[0];
                        }
                        if (b4[1] > 0) {
                            layoutParams2.height = b4[1];
                        }
                        layoutParams2.leftMargin = b4[2];
                        layoutParams2.topMargin = b4[3];
                        viewGroup.addView(imageView, layoutParams2);
                    } else if (viewGroup instanceof LinearLayout) {
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 17.0f);
                        if (b4[0] > 0) {
                            layoutParams3.width = b4[0];
                        }
                        if (b4[1] > 0) {
                            layoutParams3.height = b4[1];
                        }
                        layoutParams3.leftMargin = b4[2];
                        layoutParams3.topMargin = b4[3];
                        viewGroup.addView(imageView, layoutParams3);
                    } else {
                        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                        if (b4[0] > 0) {
                            layoutParams4.width = b4[0];
                        }
                        if (b4[1] > 0) {
                            layoutParams4.height = b4[1];
                        }
                        viewGroup.addView(imageView, layoutParams4);
                    }
                    a(imageView);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private void a(ImageView imageView) {
        try {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.f13139v)) {
                if (this.f13125f.equals(this.f13139v)) {
                    a(imageView, arrayList, "rotationX", 0.0f, -this.G);
                    a(imageView, arrayList, "rotationX", -this.G, 0.0f);
                } else if (this.f13124e.equals(this.f13139v)) {
                    a(imageView, arrayList, "rotationX", 0.0f, this.G);
                    a(imageView, arrayList, "rotationX", this.G, 0.0f);
                } else {
                    a(imageView, arrayList, "rotationX", 0.0f, this.G);
                    a(imageView, arrayList, "rotationX", this.G, 0.0f);
                    a(imageView, arrayList, "rotationX", 0.0f, -this.G);
                    a(imageView, arrayList, "rotationX", -this.G, 0.0f);
                }
            }
            if (!TextUtils.isEmpty(this.f13140w)) {
                if (this.f13125f.equals(this.f13140w)) {
                    a(imageView, arrayList, "rotationY", 0.0f, -this.H);
                    a(imageView, arrayList, "rotationY", -this.H, 0.0f);
                } else if (this.f13124e.equals(this.f13140w)) {
                    a(imageView, arrayList, "rotationY", 0.0f, this.H);
                    a(imageView, arrayList, "rotationY", this.H, 0.0f);
                } else {
                    a(imageView, arrayList, "rotationY", 0.0f, this.H);
                    a(imageView, arrayList, "rotationY", this.H, 0.0f);
                    a(imageView, arrayList, "rotationY", 0.0f, -this.H);
                    a(imageView, arrayList, "rotationY", -this.H, 0.0f);
                }
            }
            if (!TextUtils.isEmpty(this.f13141x)) {
                if (this.f13125f.equals(this.f13141x)) {
                    a(imageView, arrayList, "rotation", 0.0f, -this.I);
                    a(imageView, arrayList, "rotation", -this.I, 0.0f);
                } else if (this.f13124e.equals(this.f13141x)) {
                    a(imageView, arrayList, "rotation", 0.0f, this.I);
                    a(imageView, arrayList, "rotation", this.I, 0.0f);
                } else {
                    a(imageView, arrayList, "rotation", 0.0f, this.I);
                    a(imageView, arrayList, "rotation", this.I, 0.0f);
                    a(imageView, arrayList, "rotation", 0.0f, -this.I);
                    a(imageView, arrayList, "rotation", -this.I, 0.0f);
                }
            }
            if (this.J != null) {
                this.J = null;
            }
            if (arrayList.size() > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.J = animatorSet;
                animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.beizi.ad.a.a.a.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            if (a.this.J != null) {
                                a.this.J.start();
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.J.playSequentially(arrayList);
                this.J.start();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(ImageView imageView, List<Animator> list, String str, float f4, float f5) {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, str, f4, f5);
            ofFloat.setDuration(this.F);
            list.add(ofFloat);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (this.C) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        float f4 = this.A;
                        if (f4 != 0.0f) {
                            float f5 = fArr[0];
                            float f6 = fArr[1];
                            float f7 = fArr[2];
                            float f8 = (((float) sensorEvent.timestamp) - f4) * this.f13133o;
                            float[] fArr2 = this.f13134p;
                            double d4 = fArr2[0];
                            double degrees = Math.toDegrees(f5 * f8);
                            Double.isNaN(d4);
                            fArr2[0] = (float) (d4 + degrees);
                            float[] fArr3 = this.f13134p;
                            double d5 = fArr3[1];
                            double degrees2 = Math.toDegrees(f6 * f8);
                            Double.isNaN(d5);
                            fArr3[1] = (float) (d5 + degrees2);
                            float[] fArr4 = this.f13134p;
                            double d6 = fArr4[2];
                            double degrees3 = Math.toDegrees(f7 * f8);
                            Double.isNaN(d6);
                            fArr4[2] = (float) (d6 + degrees3);
                            l.a(f13117g, "rotate  x: " + String.format("%.4f", Float.valueOf(this.f13134p[0])) + ",y: " + String.format("%.4f", Float.valueOf(this.f13134p[1])) + ",z: " + String.format("%.4f", Float.valueOf(this.f13134p[2])) + ",x : " + this.f13136s + ",y : " + this.f13137t + ",z : " + this.f13138u);
                            if (m()) {
                                n();
                            }
                        }
                        this.A = (float) sensorEvent.timestamp;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
