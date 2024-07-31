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

/* renamed from: com.beizi.ad.a.a.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ShakeUtil {

    /* renamed from: A */
    private long f9508A;

    /* renamed from: D */
    private String f9511D;

    /* renamed from: G */
    private AnimatorSet f9514G;

    /* renamed from: H */
    private String f9515H;

    /* renamed from: I */
    private boolean f9516I;

    /* renamed from: a */
    private Context f9518a;

    /* renamed from: b */
    private AdSpacesBean.BuyerBean.ShakeViewBean f9519b;

    /* renamed from: c */
    private AdSpacesBean.BuyerBean.ShakeViewBean f9520c;

    /* renamed from: d */
    private AdSpacesBean.BuyerBean.AliaseShakeViewBean f9521d;

    /* renamed from: e */
    private AdSpacesBean.BuyerBean.CoolShakeViewBean f9522e;

    /* renamed from: f */
    private AdSpacesBean.BuyerBean.PercentPositionBean f9523f;

    /* renamed from: l */
    private SensorManager f9529l;

    /* renamed from: m */
    private Sensor f9530m;

    /* renamed from: s */
    private double f9536s;

    /* renamed from: t */
    private double f9537t;

    /* renamed from: u */
    private double f9538u;

    /* renamed from: v */
    private int f9539v;

    /* renamed from: w */
    private int f9540w;

    /* renamed from: g */
    private double f9524g = 9.8d;

    /* renamed from: h */
    private int f9525h = -100;

    /* renamed from: i */
    private int f9526i = 0;

    /* renamed from: j */
    private int f9527j = 1;

    /* renamed from: k */
    private int f9528k = 2;

    /* renamed from: n */
    private InterfaceC2775a f9531n = null;

    /* renamed from: o */
    private float f9532o = -100;

    /* renamed from: p */
    private float f9533p = -100;

    /* renamed from: q */
    private float f9534q = -100;

    /* renamed from: r */
    private int f9535r = 0;

    /* renamed from: x */
    private int f9541x = 0;

    /* renamed from: y */
    private int f9542y = 0;

    /* renamed from: z */
    private boolean f9543z = true;

    /* renamed from: B */
    private boolean f9509B = false;

    /* renamed from: C */
    private boolean f9510C = false;

    /* renamed from: E */
    private int f9512E = 80;

    /* renamed from: F */
    private float f9513F = 30.0f;

    /* renamed from: J */
    private final SensorEventListener f9517J = new SensorEventListener() { // from class: com.beizi.ad.a.a.e.4
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            ShakeUtil.this.m50119a(sensorEvent);
        }
    };

    /* compiled from: ShakeUtil.java */
    /* renamed from: com.beizi.ad.a.a.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2775a {
        /* renamed from: a */
        void mo49676a();
    }

    public ShakeUtil(Context context, AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, String str, String str2) {
        this.f9511D = null;
        this.f9516I = false;
        try {
            this.f9518a = context;
            this.f9519b = shakeViewBean;
            this.f9511D = "beizi_cool_" + str;
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean m50112a = m50112a(shakeViewBean.getOrderData(), str2);
            if (m50112a != null && m50112a.getShakeView() != null) {
                this.f9520c = m50112a.getShakeView();
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.f9519b;
            if (shakeViewBean2 != null) {
                this.f9522e = shakeViewBean2.getCoolShakeView();
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = this.f9520c;
            if (shakeViewBean3 != null) {
                this.f9521d = shakeViewBean3.getAliaseShakeView();
                this.f9523f = this.f9520c.getPosition();
                List<String> imageURL = this.f9520c.getImageURL();
                if (imageURL != null && imageURL.size() > 0) {
                    this.f9515H = imageURL.get(0);
                }
            } else {
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean4 = this.f9519b;
                if (shakeViewBean4 != null) {
                    this.f9521d = shakeViewBean4.getAliaseShakeView();
                    this.f9523f = this.f9519b.getPosition();
                    List<String> imageURL2 = this.f9519b.getImageURL();
                    if (imageURL2 != null && imageURL2.size() > 0) {
                        this.f9515H = imageURL2.get(0);
                    }
                }
            }
            if (!m50103d()) {
                this.f9516I = false;
                return;
            }
            this.f9516I = true;
            m50100g();
            m50094m();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private boolean m50103d() {
        double d;
        double d2;
        int i;
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f9520c;
        if (shakeViewBean != null) {
            d = shakeViewBean.getShakeStartAmplitude();
            d2 = this.f9520c.getShakeEndAmplitude();
            i = this.f9520c.getShakeCount();
        } else {
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.f9519b;
            if (shakeViewBean2 != null) {
                d = shakeViewBean2.getShakeStartAmplitude();
                d2 = this.f9519b.getShakeEndAmplitude();
                i = this.f9519b.getShakeCount();
            } else {
                d = 0.0d;
                d2 = 0.0d;
                i = 0;
            }
        }
        return d > Utils.DOUBLE_EPSILON && d2 > Utils.DOUBLE_EPSILON && i > 0;
    }

    /* renamed from: e */
    private boolean m50102e() {
        AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean;
        try {
            coolShakeViewBean = this.f9522e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (coolShakeViewBean == null) {
            return false;
        }
        if (coolShakeViewBean.getShakeCount() <= 0) {
            return this.f9522e.getRotatCount() > 0;
        }
        return true;
    }

    /* renamed from: f */
    private boolean m50101f() {
        try {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeViewBean = this.f9521d;
            if (aliaseShakeViewBean != null && aliaseShakeViewBean != null && aliaseShakeViewBean.getPassivationTime() > 0) {
                if (this.f9521d.getShakeCount() > 0) {
                    return true;
                }
                if (this.f9521d.getRotatCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024 A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:2:0x0000, B:4:0x000a, B:7:0x0011, B:12:0x0020, B:14:0x0024, B:16:0x0028, B:18:0x002e, B:19:0x0032, B:8:0x0014, B:10:0x001a, B:11:0x001e), top: B:24:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0028 A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:2:0x0000, B:4:0x000a, B:7:0x0011, B:12:0x0020, B:14:0x0024, B:16:0x0028, B:18:0x002e, B:19:0x0032, B:8:0x0014, B:10:0x001a, B:11:0x001e), top: B:24:0x0000 }] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m50100g() {
        /*
            r2 = this;
            r2.m50092o()     // Catch: java.lang.Exception -> L36
            boolean r0 = r2.m50095l()     // Catch: java.lang.Exception -> L36
            r1 = 0
            if (r0 != 0) goto L14
            boolean r0 = r2.m50096k()     // Catch: java.lang.Exception -> L36
            if (r0 == 0) goto L11
            goto L14
        L11:
            r2.f9509B = r1     // Catch: java.lang.Exception -> L36
            goto L20
        L14:
            boolean r0 = r2.m50102e()     // Catch: java.lang.Exception -> L36
            if (r0 == 0) goto L1e
            r0 = 1
            r2.f9509B = r0     // Catch: java.lang.Exception -> L36
            goto L20
        L1e:
            r2.f9509B = r1     // Catch: java.lang.Exception -> L36
        L20:
            boolean r0 = r2.f9509B     // Catch: java.lang.Exception -> L36
            if (r0 == 0) goto L28
            r2.m50097j()     // Catch: java.lang.Exception -> L36
            return
        L28:
            boolean r0 = r2.m50101f()     // Catch: java.lang.Exception -> L36
            if (r0 == 0) goto L32
            r2.m50098i()     // Catch: java.lang.Exception -> L36
            goto L3a
        L32:
            r2.m50099h()     // Catch: java.lang.Exception -> L36
            goto L3a
        L36:
            r0 = move-exception
            r0.printStackTrace()
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.p052a.p053a.ShakeUtil.m50100g():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m50099h() {
        try {
            LogUtil.m49046a("ShakeUtil", "setShakeSensitivityNormal");
            m50092o();
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f9520c;
            if (shakeViewBean != null) {
                m50109b(shakeViewBean.getShakeCount());
                m50122a(this.f9520c.getShakeStartAmplitude());
                m50110b(this.f9520c.getShakeEndAmplitude());
                m50105c(this.f9520c.getRotatAmplitude());
                m50104c(this.f9520c.getRotatCount());
                return;
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.f9519b;
            if (shakeViewBean2 != null) {
                m50109b(shakeViewBean2.getShakeCount());
                m50122a(this.f9519b.getShakeStartAmplitude());
                m50110b(this.f9519b.getShakeEndAmplitude());
                m50105c(this.f9519b.getRotatAmplitude());
                m50104c(this.f9519b.getRotatCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: i */
    private void m50098i() {
        try {
            if (this.f9521d == null) {
                return;
            }
            LogUtil.m49046a("ShakeUtil", "setShakeSensitivityAliase");
            m50109b(this.f9521d.getShakeCount());
            m50122a(this.f9521d.getShakeStartAmplitude());
            m50110b(this.f9521d.getShakeEndAmplitude());
            m50105c(this.f9521d.getRotatAmplitude());
            m50104c(this.f9521d.getRotatCount());
            new Handler().postDelayed(new Runnable() { // from class: com.beizi.ad.a.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ShakeUtil.this.m50099h();
                }
            }, m50120a(this.f9521d.getPassivationTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    private void m50097j() {
        try {
            if (this.f9522e == null) {
                return;
            }
            LogUtil.m49046a("ShakeUtil", "setShakeSensitivityCool");
            m50109b(this.f9522e.getShakeCount());
            m50122a(this.f9522e.getShakeStartAmplitude());
            m50110b(this.f9522e.getShakeEndAmplitude());
            m50105c(this.f9522e.getRotatAmplitude());
            m50104c(this.f9522e.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    private boolean m50096k() {
        try {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f9522e;
            if (coolShakeViewBean == null) {
                return false;
            }
            long coolTime = coolShakeViewBean.getCoolTime();
            long longValue = ((Long) SPUtils.getFromFusionSdk(this.f9518a, this.f9511D, 0L)).longValue();
            if (longValue != 0) {
                return System.currentTimeMillis() - longValue < coolTime;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: l */
    private boolean m50095l() {
        try {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f9522e;
            if (coolShakeViewBean == null) {
                return false;
            }
            return System.currentTimeMillis() - this.f9518a.getPackageManager().getPackageInfo(this.f9518a.getPackageName(), 0).firstInstallTime < coolShakeViewBean.getUserProtectTime();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: m */
    private void m50094m() {
        try {
            LogUtil.m49046a("ShakeUtil", "registerShakeListener");
            this.f9510C = true;
            m50092o();
            if (this.f9529l == null) {
                this.f9529l = (SensorManager) StubApp.getOrigApplicationContext(this.f9518a.getApplicationContext()).getSystemService(UMCommonContent.f37799ac);
            }
            if (this.f9530m == null) {
                this.f9530m = this.f9529l.getDefaultSensor(1);
            }
            this.f9529l.registerListener(this.f9517J, this.f9530m, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: n */
    private void m50093n() {
        try {
            LogUtil.m49046a("ShakeUtil", "unRegisterShakeListener");
            this.f9510C = false;
            SensorManager sensorManager = this.f9529l;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.f9517J);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: o */
    private void m50092o() {
        this.f9541x = 0;
        this.f9542y = 0;
        int i = this.f9525h;
        this.f9532o = i;
        this.f9533p = i;
        this.f9534q = i;
        this.f9535r = this.f9526i;
    }

    /* renamed from: p */
    private void m50091p() {
        try {
            if (this.f9531n != null && this.f9543z) {
                LogUtil.m49046a("ShakeUtil", "callBackResult");
                m50111b();
                if (!this.f9509B) {
                    SPUtils.putToFusionSdk(this.f9518a, this.f9511D, Long.valueOf(System.currentTimeMillis()));
                }
                this.f9531n.mo49676a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void m50105c(double d) {
        this.f9538u = d;
    }

    /* renamed from: b */
    public void m50111b() {
        try {
            this.f9543z = false;
            m50093n();
            m50092o();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void m50104c(int i) {
        this.f9540w = i;
    }

    /* renamed from: a */
    public void m50123a() {
        try {
            if (!this.f9510C && this.f9516I) {
                this.f9543z = true;
                m50100g();
                m50094m();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void m50106c() {
        try {
            m50093n();
            this.f9519b = null;
            this.f9520c = null;
            this.f9522e = null;
            this.f9521d = null;
            this.f9523f = null;
            this.f9518a = null;
            this.f9529l = null;
            this.f9530m = null;
            this.f9531n = null;
            AnimatorSet animatorSet = this.f9514G;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.f9514G = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private int[] m50108b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean;
        int parseInt;
        int parseInt2;
        int parseInt3;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                percentPositionBean = this.f9523f;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (percentPositionBean != null) {
                String centerX = percentPositionBean.getCenterX();
                String centerY = this.f9523f.getCenterY();
                String width = this.f9523f.getWidth();
                String height = this.f9523f.getHeight();
                if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                    centerX = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
                }
                if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
                    centerY = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
                }
                viewGroup.measure(0, 0);
                int px2dip = ViewUtil.px2dip(this.f9518a, viewGroup.getMeasuredWidth());
                int px2dip2 = ViewUtil.px2dip(this.f9518a, viewGroup.getMeasuredHeight());
                if (px2dip <= 0) {
                    px2dip = SystemUtil.m49022k(this.f9518a);
                }
                LogUtil.m49046a("ShakeUtil", "position containerWidth:" + px2dip + ";containerHeight:" + px2dip2 + ";" + viewGroup.getLayoutParams().width + ";" + viewGroup.getLayoutParams().height);
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
                int dip2px = ViewUtil.dip2px(this.f9518a, parseInt3);
                int dip2px2 = ViewUtil.dip2px(this.f9518a, i);
                int dip2px3 = ViewUtil.dip2px(this.f9518a, parseInt);
                int dip2px4 = ViewUtil.dip2px(this.f9518a, parseInt2);
                iArr[0] = dip2px;
                iArr[1] = dip2px2;
                if (dip2px3 > 0) {
                    iArr[2] = dip2px3;
                }
                if (dip2px4 > 0) {
                    iArr[3] = dip2px4;
                }
                LogUtil.m49046a("ShakeUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + ";" + centerX + ";" + centerY);
                return iArr;
            }
        }
        int dip2px5 = ViewUtil.dip2px(this.f9518a, 20.0f);
        int dip2px6 = ViewUtil.dip2px(this.f9518a, 10.0f);
        iArr[0] = dip2px5;
        iArr[1] = dip2px5;
        iArr[2] = dip2px6;
        iArr[3] = dip2px6;
        return iArr;
    }

    /* renamed from: a */
    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean m50112a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean : list) {
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m50118a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f9518a != null && this.f9516I) {
                    final ImageView imageView = new ImageView(this.f9518a);
                    imageView.setVisibility(0);
                    imageView.setImageResource(C2750R.mipmap.beizi_interaction_icon_shake);
                    if (!TextUtils.isEmpty(this.f9515H)) {
                        ImageManager.with(this.f9518a).getCacheBitmap(this.f9515H, new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.a.a.e.2
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
                    int[] m50108b = m50108b(viewGroup);
                    if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        if (m50108b[0] > 0) {
                            layoutParams.width = m50108b[0];
                        }
                        if (m50108b[1] > 0) {
                            layoutParams.height = m50108b[1];
                        }
                        layoutParams.leftMargin = m50108b[2];
                        layoutParams.topMargin = m50108b[3];
                        layoutParams.addRule(17);
                        viewGroup.addView(imageView, layoutParams);
                    } else if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 17);
                        if (m50108b[0] > 0) {
                            layoutParams2.width = m50108b[0];
                        }
                        if (m50108b[1] > 0) {
                            layoutParams2.height = m50108b[1];
                        }
                        layoutParams2.leftMargin = m50108b[2];
                        layoutParams2.topMargin = m50108b[3];
                        viewGroup.addView(imageView, layoutParams2);
                    } else if (viewGroup instanceof LinearLayout) {
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 17.0f);
                        if (m50108b[0] > 0) {
                            layoutParams3.width = m50108b[0];
                        }
                        if (m50108b[1] > 0) {
                            layoutParams3.height = m50108b[1];
                        }
                        layoutParams3.leftMargin = m50108b[2];
                        layoutParams3.topMargin = m50108b[3];
                        viewGroup.addView(imageView, layoutParams3);
                    } else {
                        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                        if (m50108b[0] > 0) {
                            layoutParams4.width = m50108b[0];
                        }
                        if (m50108b[1] > 0) {
                            layoutParams4.height = m50108b[1];
                        }
                        viewGroup.addView(imageView, layoutParams4);
                    }
                    m50117a(imageView);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void m50110b(double d) {
        this.f9537t = d;
    }

    /* renamed from: b */
    public void m50109b(int i) {
        this.f9539v = i;
    }

    /* renamed from: a */
    private void m50117a(ImageView imageView) {
        try {
            ArrayList arrayList = new ArrayList();
            m50116a(imageView, arrayList, "rotation", 0.0f, this.f9513F);
            m50116a(imageView, arrayList, "rotation", this.f9513F, 0.0f);
            m50116a(imageView, arrayList, "rotation", 0.0f, -this.f9513F);
            m50116a(imageView, arrayList, "rotation", -this.f9513F, 0.0f);
            if (arrayList.size() > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f9514G = animatorSet;
                animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.beizi.ad.a.a.e.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            if (ShakeUtil.this.f9514G != null) {
                                ShakeUtil.this.f9514G.start();
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
                this.f9514G.playSequentially(arrayList);
                this.f9514G.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m50116a(ImageView imageView, List<Animator> list, String str, float f, float f2) {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, str, f, f2);
            ofFloat.setDuration(this.f9512E);
            list.add(ofFloat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public int m50120a(int i) {
        double random = Math.random();
        double d = i;
        Double.isNaN(d);
        return (int) ((random * d) + 1.0d);
    }

    /* renamed from: a */
    public void m50122a(double d) {
        this.f9536s = d;
    }

    /* renamed from: a */
    public void m50115a(InterfaceC2775a interfaceC2775a) {
        this.f9531n = interfaceC2775a;
    }

    /* renamed from: a */
    private double m50121a(float f, float f2, float f3) {
        double d = f;
        try {
            double d2 = this.f9524g;
            Double.isNaN(d);
            double pow = Math.pow(d / d2, 2.0d);
            double d3 = f2;
            double d4 = this.f9524g;
            Double.isNaN(d3);
            double pow2 = pow + Math.pow(d3 / d4, 2.0d);
            double d5 = f3;
            double d6 = this.f9524g;
            Double.isNaN(d5);
            return Math.sqrt(pow2 + Math.pow(d5 / d6, 2.0d));
        } catch (Exception e) {
            e.printStackTrace();
            return Utils.DOUBLE_EPSILON;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50119a(SensorEvent sensorEvent) {
        float[] fArr;
        try {
            if (System.currentTimeMillis() - this.f9508A >= 100 && sensorEvent != null && this.f9543z && (fArr = sensorEvent.values) != null) {
                this.f9508A = System.currentTimeMillis();
                double m50121a = m50121a(fArr[0], fArr[1], fArr[2]);
                if (m50121a > this.f9536s) {
                    this.f9535r = this.f9527j;
                } else if (m50121a <= this.f9537t && this.f9535r == this.f9527j) {
                    this.f9535r = this.f9528k;
                    this.f9541x++;
                }
                LogUtil.m49045b("ShakeUtil", " current: " + String.format("%.4f", Double.valueOf(m50121a)) + ", execute: " + this.f9541x + ", count: " + this.f9539v + "_" + this.f9540w + ", shake: " + this.f9536s + "_" + this.f9537t);
                int i = this.f9539v;
                if (i <= 0 || this.f9541x < i) {
                    return;
                }
                m50091p();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
