package com.beizi.p051ad.p052a.p053a;

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
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.utilities.ImageManager;
import com.beizi.p051ad.internal.utilities.SPUtils;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.lance.p062a.SystemUtil;
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.beizi.ad.a.a.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class EulerAngleUtil {

    /* renamed from: g */
    private static final String f9401g = "a";

    /* renamed from: q */
    private static SensorManager f9402q;

    /* renamed from: A */
    private float f9403A;

    /* renamed from: B */
    private InterfaceC2762a f9404B;

    /* renamed from: E */
    private String f9407E;

    /* renamed from: J */
    private AnimatorSet f9412J;

    /* renamed from: K */
    private boolean f9413K;

    /* renamed from: h */
    private Context f9421h;

    /* renamed from: i */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f9422i;

    /* renamed from: j */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f9423j;

    /* renamed from: k */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f9424k;

    /* renamed from: l */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f9425l;

    /* renamed from: m */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f9426m;

    /* renamed from: n */
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean f9427n;

    /* renamed from: r */
    private Sensor f9430r;

    /* renamed from: v */
    private String f9434v;

    /* renamed from: w */
    private String f9435w;

    /* renamed from: x */
    private String f9436x;

    /* renamed from: o */
    private float f9428o = 1.0E-9f;

    /* renamed from: p */
    private float[] f9429p = new float[3];

    /* renamed from: s */
    private double f9431s = Utils.DOUBLE_EPSILON;

    /* renamed from: t */
    private double f9432t = Utils.DOUBLE_EPSILON;

    /* renamed from: u */
    private double f9433u = Utils.DOUBLE_EPSILON;

    /* renamed from: y */
    private boolean f9437y = false;

    /* renamed from: z */
    private int f9438z = 0;

    /* renamed from: C */
    private boolean f9405C = true;

    /* renamed from: D */
    private boolean f9406D = false;

    /* renamed from: a */
    String f9415a = "x";

    /* renamed from: b */
    String f9416b = "y";

    /* renamed from: c */
    String f9417c = UMCommonContent.f37777aG;

    /* renamed from: d */
    String f9418d = "0";

    /* renamed from: e */
    String f9419e = "1";

    /* renamed from: f */
    String f9420f = "2";

    /* renamed from: F */
    private int f9408F = 350;

    /* renamed from: G */
    private float f9409G = 60.0f;

    /* renamed from: H */
    private float f9410H = 60.0f;

    /* renamed from: I */
    private float f9411I = 30.0f;

    /* renamed from: L */
    private SensorEventListener f9414L = new SensorEventListener() { // from class: com.beizi.ad.a.a.a.4
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                EulerAngleUtil.this.m50186a(sensorEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    /* compiled from: EulerAngleUtil.java */
    /* renamed from: com.beizi.ad.a.a.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2762a {
        /* renamed from: a */
        void mo49673a();
    }

    public EulerAngleUtil(Context context, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean, String str, String str2) {
        this.f9407E = null;
        this.f9413K = false;
        this.f9421h = context;
        this.f9422i = eulerAngleViewBean;
        this.f9407E = "beizi_cool_" + str;
        AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean m50177a = m50177a(this.f9422i.getOrderData(), str2);
        if (m50177a != null && m50177a.getEulerAngleRule() != null) {
            this.f9423j = m50177a.getEulerAngleRule();
        }
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2 = this.f9422i;
        if (eulerAngleViewBean2 != null) {
            this.f9426m = eulerAngleViewBean2.getCoolRule();
        }
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean3 = this.f9423j;
        if (eulerAngleViewBean3 != null) {
            this.f9425l = eulerAngleViewBean3.getNomalRule();
            this.f9427n = this.f9423j.getRender();
        } else {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean4 = this.f9422i;
            if (eulerAngleViewBean4 != null) {
                this.f9425l = eulerAngleViewBean4.getNomalRule();
                this.f9427n = this.f9422i.getRender();
            }
        }
        if (!m50170d()) {
            this.f9413K = false;
            return;
        }
        this.f9413K = true;
        m50169e();
        m50163k();
    }

    /* renamed from: d */
    private boolean m50170d() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f9425l;
        if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
            for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                if (eulerAngleRuleBean != null) {
                    String axis = eulerAngleRuleBean.getAxis();
                    double angle = eulerAngleRuleBean.getAngle();
                    if (!TextUtils.isEmpty(axis) && angle > Utils.DOUBLE_EPSILON) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021 A[Catch: Exception -> 0x0031, TryCatch #0 {Exception -> 0x0031, blocks: (B:2:0x0000, B:4:0x0007, B:7:0x000e, B:12:0x001d, B:14:0x0021, B:16:0x0029, B:8:0x0011, B:10:0x0017, B:11:0x001b), top: B:21:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029 A[Catch: Exception -> 0x0031, TRY_LEAVE, TryCatch #0 {Exception -> 0x0031, blocks: (B:2:0x0000, B:4:0x0007, B:7:0x000e, B:12:0x001d, B:14:0x0021, B:16:0x0029, B:8:0x0011, B:10:0x0017, B:11:0x001b), top: B:21:0x0000 }] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m50169e() {
        /*
            r2 = this;
            boolean r0 = r2.m50165i()     // Catch: java.lang.Exception -> L31
            r1 = 0
            if (r0 != 0) goto L11
            boolean r0 = r2.m50166h()     // Catch: java.lang.Exception -> L31
            if (r0 == 0) goto Le
            goto L11
        Le:
            r2.f9437y = r1     // Catch: java.lang.Exception -> L31
            goto L1d
        L11:
            boolean r0 = r2.m50167g()     // Catch: java.lang.Exception -> L31
            if (r0 == 0) goto L1b
            r0 = 1
            r2.f9437y = r0     // Catch: java.lang.Exception -> L31
            goto L1d
        L1b:
            r2.f9437y = r1     // Catch: java.lang.Exception -> L31
        L1d:
            boolean r0 = r2.f9437y     // Catch: java.lang.Exception -> L31
            if (r0 == 0) goto L29
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$EulerAngleViewRuleBean r0 = r2.f9426m     // Catch: java.lang.Exception -> L31
            r2.f9424k = r0     // Catch: java.lang.Exception -> L31
            r2.m50168f()     // Catch: java.lang.Exception -> L31
            return
        L29:
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$EulerAngleViewRuleBean r0 = r2.f9425l     // Catch: java.lang.Exception -> L31
            r2.f9424k = r0     // Catch: java.lang.Exception -> L31
            r2.m50168f()     // Catch: java.lang.Exception -> L31
            goto L35
        L31:
            r0 = move-exception
            r0.printStackTrace()
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.p052a.p053a.EulerAngleUtil.m50169e():void");
    }

    /* renamed from: f */
    private void m50168f() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f9424k;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                int passivationTime = this.f9424k.getPassivationTime();
                final double d = 0.0d;
                final double d2 = 0.0d;
                final double d3 = 0.0d;
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        if (this.f9415a.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > Utils.DOUBLE_EPSILON) {
                                this.f9431s = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f9431s = eulerAngleRuleBean.getAngle();
                            }
                            d = eulerAngleRuleBean.getAngle();
                            this.f9434v = eulerAngleRuleBean.getDirection();
                        } else if (this.f9416b.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > Utils.DOUBLE_EPSILON) {
                                this.f9432t = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f9432t = eulerAngleRuleBean.getAngle();
                            }
                            d2 = eulerAngleRuleBean.getAngle();
                            this.f9435w = eulerAngleRuleBean.getDirection();
                        } else if (this.f9417c.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime > 0 && eulerAngleRuleBean.getPangle() > Utils.DOUBLE_EPSILON) {
                                this.f9433u = eulerAngleRuleBean.getPangle();
                            } else {
                                this.f9433u = eulerAngleRuleBean.getAngle();
                            }
                            d3 = eulerAngleRuleBean.getAngle();
                            this.f9436x = eulerAngleRuleBean.getDirection();
                        }
                    }
                }
                if (passivationTime > 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.ad.a.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                EulerAngleUtil.this.f9403A = 0.0f;
                                EulerAngleUtil.this.f9429p[0] = 0.0f;
                                EulerAngleUtil.this.f9429p[1] = 0.0f;
                                EulerAngleUtil.this.f9429p[2] = 0.0f;
                                EulerAngleUtil.this.f9431s = d;
                                EulerAngleUtil.this.f9432t = d2;
                                EulerAngleUtil.this.f9433u = d3;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, m50187a(passivationTime));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private boolean m50167g() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f9426m;
            if (eulerAngleViewRuleBean != null && eulerAngleViewRuleBean != null && eulerAngleViewRuleBean.getRules() != null && this.f9426m.getRules().size() > 0) {
                if (this.f9426m.getStyle() != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: h */
    private boolean m50166h() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f9426m;
            if (eulerAngleViewRuleBean == null) {
                return false;
            }
            long coolTime = eulerAngleViewRuleBean.getCoolTime();
            long longValue = ((Long) SPUtils.getFromFusionSdk(this.f9421h, this.f9407E, 0L)).longValue();
            if (longValue != 0) {
                return System.currentTimeMillis() - longValue < coolTime;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: i */
    private boolean m50165i() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f9426m;
            if (eulerAngleViewRuleBean == null) {
                return false;
            }
            return System.currentTimeMillis() - this.f9421h.getPackageManager().getPackageInfo(this.f9421h.getPackageName(), 0).firstInstallTime < eulerAngleViewRuleBean.getUserProtectTime();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: j */
    private void m50164j() {
        this.f9403A = 0.0f;
        float[] fArr = this.f9429p;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    /* renamed from: k */
    private void m50163k() {
        try {
            if (f9402q == null) {
                f9402q = (SensorManager) StubApp.getOrigApplicationContext(this.f9421h.getApplicationContext()).getSystemService(UMCommonContent.f37799ac);
            }
            if (this.f9430r == null) {
                this.f9430r = f9402q.getDefaultSensor(4);
            }
            f9402q.registerListener(this.f9414L, this.f9430r, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: l */
    private void m50162l() {
        try {
            LogUtil.m49046a(f9401g, "enter unRegisterListener");
            SensorManager sensorManager = f9402q;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.f9414L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: m */
    private boolean m50161m() {
        try {
            if (this.f9431s > Utils.DOUBLE_EPSILON) {
                if (this.f9420f.equals(this.f9434v)) {
                    float[] fArr = this.f9429p;
                    if (fArr[0] > 0.0f && Math.abs(fArr[0]) >= this.f9431s) {
                        return true;
                    }
                } else if (this.f9419e.equals(this.f9434v)) {
                    float[] fArr2 = this.f9429p;
                    if (fArr2[0] < 0.0f && Math.abs(fArr2[0]) >= this.f9431s) {
                        return true;
                    }
                } else if (this.f9418d.equals(this.f9434v) && Math.abs(this.f9429p[0]) >= this.f9431s) {
                    return true;
                }
            }
            if (this.f9432t > Utils.DOUBLE_EPSILON) {
                if (this.f9420f.equals(this.f9435w)) {
                    float[] fArr3 = this.f9429p;
                    if (fArr3[1] < 0.0f && Math.abs(fArr3[1]) >= this.f9432t) {
                        return true;
                    }
                } else if (this.f9419e.equals(this.f9435w)) {
                    float[] fArr4 = this.f9429p;
                    if (fArr4[1] > 0.0f && Math.abs(fArr4[1]) >= this.f9432t) {
                        return true;
                    }
                } else if (this.f9418d.equals(this.f9435w) && Math.abs(this.f9429p[1]) >= this.f9432t) {
                    return true;
                }
            }
            if (this.f9433u > Utils.DOUBLE_EPSILON) {
                if (this.f9420f.equals(this.f9436x)) {
                    float[] fArr5 = this.f9429p;
                    if (fArr5[2] > 0.0f && Math.abs(fArr5[2]) >= this.f9433u) {
                        return true;
                    }
                } else if (this.f9419e.equals(this.f9436x)) {
                    float[] fArr6 = this.f9429p;
                    if (fArr6[2] < 0.0f && Math.abs(fArr6[2]) >= this.f9433u) {
                        return true;
                    }
                } else if (this.f9418d.equals(this.f9436x) && Math.abs(this.f9429p[2]) >= this.f9433u) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: n */
    private void m50160n() {
        try {
            if (this.f9404B != null && this.f9405C) {
                LogUtil.m49046a(f9401g, "onEulerAngleHappened");
                m50176b();
                if (!this.f9437y) {
                    SPUtils.putToFusionSdk(this.f9421h, this.f9407E, Long.valueOf(System.currentTimeMillis()));
                }
                this.f9404B.mo49673a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void m50172c() {
        try {
            m50162l();
            this.f9422i = null;
            this.f9423j = null;
            this.f9424k = null;
            this.f9425l = null;
            this.f9426m = null;
            this.f9427n = null;
            this.f9421h = null;
            this.f9404B = null;
            f9402q = null;
            this.f9430r = null;
            AnimatorSet animatorSet = this.f9412J;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.f9412J = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m50176b() {
        this.f9405C = false;
        m50164j();
        m50162l();
    }

    /* renamed from: a */
    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean m50177a(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
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

    /* renamed from: b */
    private int[] m50175b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean;
        int parseInt;
        int parseInt2;
        int parseInt3;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                eulerAngleRenderBean = this.f9427n;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (eulerAngleRenderBean != null) {
                String centerX = eulerAngleRenderBean.getCenterX();
                String centerY = this.f9427n.getCenterY();
                String width = this.f9427n.getWidth();
                String height = this.f9427n.getHeight();
                if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                    centerX = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
                }
                if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
                    centerY = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
                }
                viewGroup.measure(0, 0);
                int px2dip = ViewUtil.px2dip(this.f9421h, viewGroup.getMeasuredWidth());
                int px2dip2 = ViewUtil.px2dip(this.f9421h, viewGroup.getMeasuredHeight());
                if (px2dip <= 0) {
                    px2dip = SystemUtil.m49022k(this.f9421h);
                }
                String str = f9401g;
                LogUtil.m49046a(str, "position containerWidth:" + px2dip + ";containerHeight:" + px2dip2 + ";" + viewGroup.getLayoutParams().width + ";" + viewGroup.getLayoutParams().height);
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
                int i = 20;
                if (width.endsWith("%")) {
                    parseInt3 = (px2dip * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100;
                } else {
                    parseInt3 = !TextUtils.isEmpty(width) ? Integer.parseInt(width) : 20;
                }
                if (height.endsWith("%")) {
                    i = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * parseInt3) / 100;
                } else if (!TextUtils.isEmpty(width)) {
                    i = Integer.parseInt(height);
                }
                int dip2px = ViewUtil.dip2px(this.f9421h, parseInt3);
                int dip2px2 = ViewUtil.dip2px(this.f9421h, i);
                int dip2px3 = ViewUtil.dip2px(this.f9421h, parseInt);
                int dip2px4 = ViewUtil.dip2px(this.f9421h, parseInt2);
                iArr[0] = dip2px;
                iArr[1] = dip2px2;
                if (dip2px3 > 0) {
                    iArr[2] = dip2px3;
                }
                if (dip2px4 > 0) {
                    iArr[3] = dip2px4;
                }
                LogUtil.m49046a(str, "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + ";" + centerX + ";" + centerY);
                return iArr;
            }
        }
        int dip2px5 = ViewUtil.dip2px(this.f9421h, 20.0f);
        int dip2px6 = ViewUtil.dip2px(this.f9421h, 10.0f);
        iArr[0] = dip2px5;
        iArr[1] = dip2px5;
        iArr[2] = dip2px6;
        iArr[3] = dip2px6;
        return iArr;
    }

    /* renamed from: a */
    public int m50187a(int i) {
        double random = Math.random();
        double d = i;
        Double.isNaN(d);
        return (int) ((random * d) + 1.0d);
    }

    /* renamed from: a */
    public void m50188a() {
        if (this.f9406D || !this.f9413K) {
            return;
        }
        this.f9405C = true;
        m50164j();
        m50169e();
        m50163k();
    }

    /* renamed from: a */
    public void m50182a(InterfaceC2762a interfaceC2762a) {
        this.f9404B = interfaceC2762a;
    }

    /* renamed from: a */
    public void m50185a(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.EulerAngleStyleBean style;
        List<String> imgs;
        if (viewGroup != null) {
            try {
                if (this.f9421h != null && this.f9413K) {
                    final ImageView imageView = new ImageView(this.f9421h);
                    imageView.setVisibility(0);
                    imageView.setImageResource(C2750R.mipmap.beizi_interaction_icon_euler_angle);
                    String str = null;
                    AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f9424k;
                    if (eulerAngleViewRuleBean != null && (style = eulerAngleViewRuleBean.getStyle()) != null && (imgs = style.getImgs()) != null && imgs.size() > 0) {
                        str = imgs.get(0);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        ImageManager.with(this.f9421h).getCacheBitmap(str, new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.a.a.a.2
                            @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                            public void onBitmapLoadFailed() {
                            }

                            @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                            public void onBitmapLoaded(Bitmap bitmap) {
                                try {
                                    ImageView imageView2 = imageView;
                                    if (imageView2 == null || bitmap == null) {
                                        return;
                                    }
                                    imageView2.setImageBitmap(bitmap);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    int[] m50175b = m50175b(viewGroup);
                    if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        if (m50175b[0] > 0) {
                            layoutParams.width = m50175b[0];
                        }
                        if (m50175b[1] > 0) {
                            layoutParams.height = m50175b[1];
                        }
                        layoutParams.leftMargin = m50175b[2];
                        layoutParams.topMargin = m50175b[3];
                        layoutParams.addRule(17);
                        viewGroup.addView(imageView, layoutParams);
                    } else if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 17);
                        if (m50175b[0] > 0) {
                            layoutParams2.width = m50175b[0];
                        }
                        if (m50175b[1] > 0) {
                            layoutParams2.height = m50175b[1];
                        }
                        layoutParams2.leftMargin = m50175b[2];
                        layoutParams2.topMargin = m50175b[3];
                        viewGroup.addView(imageView, layoutParams2);
                    } else if (viewGroup instanceof LinearLayout) {
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 17.0f);
                        if (m50175b[0] > 0) {
                            layoutParams3.width = m50175b[0];
                        }
                        if (m50175b[1] > 0) {
                            layoutParams3.height = m50175b[1];
                        }
                        layoutParams3.leftMargin = m50175b[2];
                        layoutParams3.topMargin = m50175b[3];
                        viewGroup.addView(imageView, layoutParams3);
                    } else {
                        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                        if (m50175b[0] > 0) {
                            layoutParams4.width = m50175b[0];
                        }
                        if (m50175b[1] > 0) {
                            layoutParams4.height = m50175b[1];
                        }
                        viewGroup.addView(imageView, layoutParams4);
                    }
                    m50184a(imageView);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m50184a(ImageView imageView) {
        try {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.f9434v)) {
                if (this.f9420f.equals(this.f9434v)) {
                    m50183a(imageView, arrayList, "rotationX", 0.0f, -this.f9409G);
                    m50183a(imageView, arrayList, "rotationX", -this.f9409G, 0.0f);
                } else if (this.f9419e.equals(this.f9434v)) {
                    m50183a(imageView, arrayList, "rotationX", 0.0f, this.f9409G);
                    m50183a(imageView, arrayList, "rotationX", this.f9409G, 0.0f);
                } else {
                    m50183a(imageView, arrayList, "rotationX", 0.0f, this.f9409G);
                    m50183a(imageView, arrayList, "rotationX", this.f9409G, 0.0f);
                    m50183a(imageView, arrayList, "rotationX", 0.0f, -this.f9409G);
                    m50183a(imageView, arrayList, "rotationX", -this.f9409G, 0.0f);
                }
            }
            if (!TextUtils.isEmpty(this.f9435w)) {
                if (this.f9420f.equals(this.f9435w)) {
                    m50183a(imageView, arrayList, "rotationY", 0.0f, -this.f9410H);
                    m50183a(imageView, arrayList, "rotationY", -this.f9410H, 0.0f);
                } else if (this.f9419e.equals(this.f9435w)) {
                    m50183a(imageView, arrayList, "rotationY", 0.0f, this.f9410H);
                    m50183a(imageView, arrayList, "rotationY", this.f9410H, 0.0f);
                } else {
                    m50183a(imageView, arrayList, "rotationY", 0.0f, this.f9410H);
                    m50183a(imageView, arrayList, "rotationY", this.f9410H, 0.0f);
                    m50183a(imageView, arrayList, "rotationY", 0.0f, -this.f9410H);
                    m50183a(imageView, arrayList, "rotationY", -this.f9410H, 0.0f);
                }
            }
            if (!TextUtils.isEmpty(this.f9436x)) {
                if (this.f9420f.equals(this.f9436x)) {
                    m50183a(imageView, arrayList, "rotation", 0.0f, -this.f9411I);
                    m50183a(imageView, arrayList, "rotation", -this.f9411I, 0.0f);
                } else if (this.f9419e.equals(this.f9436x)) {
                    m50183a(imageView, arrayList, "rotation", 0.0f, this.f9411I);
                    m50183a(imageView, arrayList, "rotation", this.f9411I, 0.0f);
                } else {
                    m50183a(imageView, arrayList, "rotation", 0.0f, this.f9411I);
                    m50183a(imageView, arrayList, "rotation", this.f9411I, 0.0f);
                    m50183a(imageView, arrayList, "rotation", 0.0f, -this.f9411I);
                    m50183a(imageView, arrayList, "rotation", -this.f9411I, 0.0f);
                }
            }
            if (this.f9412J != null) {
                this.f9412J = null;
            }
            if (arrayList.size() > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f9412J = animatorSet;
                animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.beizi.ad.a.a.a.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            if (EulerAngleUtil.this.f9412J != null) {
                                EulerAngleUtil.this.f9412J.start();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.f9412J.playSequentially(arrayList);
                this.f9412J.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m50183a(ImageView imageView, List<Animator> list, String str, float f, float f2) {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, str, f, f2);
            ofFloat.setDuration(this.f9408F);
            list.add(ofFloat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50186a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (this.f9405C) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        float f = this.f9403A;
                        if (f != 0.0f) {
                            float f2 = fArr[0];
                            float f3 = fArr[1];
                            float f4 = fArr[2];
                            float f5 = (((float) sensorEvent.timestamp) - f) * this.f9428o;
                            float[] fArr2 = this.f9429p;
                            double d = fArr2[0];
                            double degrees = Math.toDegrees(f2 * f5);
                            Double.isNaN(d);
                            fArr2[0] = (float) (d + degrees);
                            float[] fArr3 = this.f9429p;
                            double d2 = fArr3[1];
                            double degrees2 = Math.toDegrees(f3 * f5);
                            Double.isNaN(d2);
                            fArr3[1] = (float) (d2 + degrees2);
                            float[] fArr4 = this.f9429p;
                            double d3 = fArr4[2];
                            double degrees3 = Math.toDegrees(f4 * f5);
                            Double.isNaN(d3);
                            fArr4[2] = (float) (d3 + degrees3);
                            LogUtil.m49046a(f9401g, "rotate  x: " + String.format("%.4f", Float.valueOf(this.f9429p[0])) + ",y: " + String.format("%.4f", Float.valueOf(this.f9429p[1])) + ",z: " + String.format("%.4f", Float.valueOf(this.f9429p[2])) + ",x : " + this.f9431s + ",y : " + this.f9432t + ",z : " + this.f9433u);
                            if (m50161m()) {
                                m50160n();
                            }
                        }
                        this.f9403A = (float) sensorEvent.timestamp;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
