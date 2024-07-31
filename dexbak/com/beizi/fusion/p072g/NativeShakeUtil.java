package com.beizi.fusion.p072g;

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
import com.tencent.bugly.BUGLY;
import com.umeng.analytics.pro.UMCommonContent;

/* renamed from: com.beizi.fusion.g.ag */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeShakeUtil {

    /* renamed from: b */
    private static SensorManager f11241b;

    /* renamed from: a */
    ShakeView f11242a;

    /* renamed from: c */
    private Context f11243c;

    /* renamed from: d */
    private double f11244d;

    /* renamed from: e */
    private double f11245e;

    /* renamed from: f */
    private double f11246f;

    /* renamed from: g */
    private int f11247g;

    /* renamed from: h */
    private int f11248h;

    /* renamed from: t */
    private AdSpacesBean.BuyerBean.CoolShakeViewBean f11260t;

    /* renamed from: u */
    private String f11261u;

    /* renamed from: i */
    private int f11249i = 0;

    /* renamed from: j */
    private int f11250j = 0;

    /* renamed from: k */
    private float f11251k = -100.0f;

    /* renamed from: l */
    private float f11252l = -100.0f;

    /* renamed from: m */
    private float f11253m = -100.0f;

    /* renamed from: n */
    private int f11254n = 0;

    /* renamed from: o */
    private InterfaceC3118a f11255o = null;

    /* renamed from: p */
    private boolean f11256p = false;

    /* renamed from: q */
    private int f11257q = 200;

    /* renamed from: r */
    private View f11258r = null;

    /* renamed from: s */
    private long f11259s = 0;

    /* renamed from: v */
    private boolean f11262v = false;

    /* renamed from: w */
    private final SensorEventListener f11263w = new SensorEventListener() { // from class: com.beizi.fusion.g.ag.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (System.currentTimeMillis() - NativeShakeUtil.this.f11259s < 200) {
                return;
            }
            if (ViewCheckUtil.m48281a(NativeShakeUtil.this.f11258r)) {
                if (NativeShakeUtil.this.f11262v && NativeShakeUtil.this.f11260t != null && !TextUtils.isEmpty(NativeShakeUtil.this.f11261u) && ShakeCoolConfig.m48369a().m48366b(NativeShakeUtil.this.f11261u) > 0) {
                    C3116af.m48494c("ShakeUtil", "mShakeCount isUserSensitiveScheme:" + NativeShakeUtil.this.f11262v + ";coolShakeViewBean:" + NativeShakeUtil.this.f11260t + ";coolConfigKey:" + NativeShakeUtil.this.f11261u + ";getCoolTime:" + ShakeCoolConfig.m48369a().m48366b(NativeShakeUtil.this.f11261u));
                    NativeShakeUtil nativeShakeUtil = NativeShakeUtil.this;
                    nativeShakeUtil.m48480a(nativeShakeUtil.f11260t);
                }
                float[] fArr = sensorEvent.values;
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = fArr[2];
                if (NativeShakeUtil.this.f11251k == -100.0f) {
                    NativeShakeUtil.this.f11251k = f;
                }
                if (NativeShakeUtil.this.f11252l == -100.0f) {
                    NativeShakeUtil.this.f11252l = f2;
                }
                if (NativeShakeUtil.this.f11253m == -100.0f) {
                    NativeShakeUtil.this.f11253m = f3;
                }
                C3116af.m48495b("ShakeUtil", "x = " + f + ",initialX = " + NativeShakeUtil.this.f11251k + ",y = " + f2 + ",initialY = " + NativeShakeUtil.this.f11252l + ",z = " + f3 + ",initialZ = " + NativeShakeUtil.this.f11253m);
                double abs = (double) Math.abs(f - NativeShakeUtil.this.f11251k);
                Double.isNaN(abs);
                double d = abs / 9.8d;
                double abs2 = (double) Math.abs(f2 - NativeShakeUtil.this.f11252l);
                Double.isNaN(abs2);
                double d2 = abs2 / 9.8d;
                double abs3 = (double) Math.abs(f3 - NativeShakeUtil.this.f11253m);
                Double.isNaN(abs3);
                double d3 = abs3 / 9.8d;
                C3116af.m48495b("ShakeUtil", "rotateX = " + d + ",rotateY = " + d2 + ",rotateZ = " + d3 + ",rotateAmplitude = " + NativeShakeUtil.this.f11246f);
                if (d > NativeShakeUtil.this.f11246f) {
                    NativeShakeUtil.m48457j(NativeShakeUtil.this);
                    NativeShakeUtil.this.f11251k = f;
                }
                if (d2 > NativeShakeUtil.this.f11246f) {
                    NativeShakeUtil.m48457j(NativeShakeUtil.this);
                    NativeShakeUtil.this.f11252l = f2;
                }
                if (d3 > NativeShakeUtil.this.f11246f) {
                    NativeShakeUtil.m48457j(NativeShakeUtil.this);
                    NativeShakeUtil.this.f11253m = f3;
                }
                NativeShakeUtil nativeShakeUtil2 = NativeShakeUtil.this;
                if (nativeShakeUtil2.m48491a(f, f2, f3, nativeShakeUtil2.f11244d)) {
                    NativeShakeUtil.this.f11254n = 1;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("mRotateCount:");
                sb.append(NativeShakeUtil.this.f11250j);
                sb.append(";mShakeCount:");
                sb.append(NativeShakeUtil.this.f11249i);
                sb.append(",mShakeState = ");
                sb.append(NativeShakeUtil.this.f11254n);
                sb.append(",isShakeStart = ");
                NativeShakeUtil nativeShakeUtil3 = NativeShakeUtil.this;
                sb.append(nativeShakeUtil3.m48491a(f, f2, f3, nativeShakeUtil3.f11244d));
                sb.append(",isShakeEnd = ");
                NativeShakeUtil nativeShakeUtil4 = NativeShakeUtil.this;
                sb.append(nativeShakeUtil4.m48474b(f, f2, f3, nativeShakeUtil4.f11245e));
                C3116af.m48495b("ShakeUtil", sb.toString());
                if (NativeShakeUtil.this.f11254n == 1) {
                    NativeShakeUtil nativeShakeUtil5 = NativeShakeUtil.this;
                    if (nativeShakeUtil5.m48474b(f, f2, f3, nativeShakeUtil5.f11245e)) {
                        NativeShakeUtil.this.f11254n = 2;
                        NativeShakeUtil.m48451p(NativeShakeUtil.this);
                    }
                }
                C3116af.m48495b("ShakeUtil", "mShakeCount = " + NativeShakeUtil.this.f11249i + ",dstShakeCount = " + NativeShakeUtil.this.f11247g + ",mRotateCount = " + NativeShakeUtil.this.f11250j + ",dstRotateCount = " + NativeShakeUtil.this.f11248h);
                if ((NativeShakeUtil.this.f11247g > 0 && NativeShakeUtil.this.f11249i >= NativeShakeUtil.this.f11247g) || (NativeShakeUtil.this.f11248h > 0 && NativeShakeUtil.this.f11250j >= NativeShakeUtil.this.f11248h)) {
                    NativeShakeUtil.this.m48493a();
                }
                NativeShakeUtil.this.f11259s = System.currentTimeMillis();
                return;
            }
            C3116af.m48495b("ShakeUtil", "onShakeHappened mContainerView is not show");
            NativeShakeUtil.this.m48464d();
        }
    };

    /* compiled from: NativeShakeUtil.java */
    /* renamed from: com.beizi.fusion.g.ag$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3118a {
        /* renamed from: a */
        void mo46796a();
    }

    public NativeShakeUtil(Context context) {
        this.f11243c = context;
        f11241b = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(UMCommonContent.f37799ac);
    }

    /* renamed from: j */
    static /* synthetic */ int m48457j(NativeShakeUtil nativeShakeUtil) {
        int i = nativeShakeUtil.f11250j;
        nativeShakeUtil.f11250j = i + 1;
        return i;
    }

    /* renamed from: p */
    static /* synthetic */ int m48451p(NativeShakeUtil nativeShakeUtil) {
        int i = nativeShakeUtil.f11249i;
        nativeShakeUtil.f11249i = i + 1;
        return i;
    }

    /* renamed from: d */
    public void m48464d() {
        this.f11251k = -100.0f;
        this.f11252l = -100.0f;
        this.f11253m = -100.0f;
        this.f11254n = 0;
        this.f11257q = 200;
        this.f11249i = 0;
        this.f11250j = 0;
        this.f11256p = false;
    }

    /* renamed from: c */
    public void m48467c(double d) {
        this.f11246f = d;
    }

    /* renamed from: b */
    public void m48475b(double d) {
        this.f11245e = d;
    }

    /* renamed from: c */
    public void m48468c() {
        C3116af.m48496a("BeiZis", "enter unRegisterShakeListenerAndSetDefault");
        SensorManager sensorManager = f11241b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f11263w);
        }
        m48464d();
        ShakeView shakeView = this.f11242a;
        if (shakeView != null) {
            shakeView.stopShake();
        }
        this.f11255o = null;
        this.f11243c = null;
        this.f11242a = null;
    }

    /* renamed from: b */
    public void m48473b(int i) {
        this.f11248h = i;
    }

    /* renamed from: a */
    public void m48478a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            return;
        }
        C3116af.m48496a("BeiZis", "setShakeParams shakeCount:" + shakeViewBean.getShakeCount() + ";rotatCount:" + shakeViewBean.getRotatCount());
        try {
            this.f11262v = true;
            m48490a(shakeViewBean.getShakeCount());
            m48492a(shakeViewBean.getShakeStartAmplitude());
            m48475b(shakeViewBean.getShakeEndAmplitude());
            m48467c(shakeViewBean.getRotatAmplitude());
            m48473b(shakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m48469b(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        this.f11260t = coolShakeViewBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m48474b(float f, float f2, float f3, double d) {
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

    /* renamed from: b */
    public void m48476b() {
        SensorManager sensorManager = f11241b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f11263w, sensorManager.getDefaultSensor(1), BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH);
        }
    }

    /* renamed from: a */
    public void m48480a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        if (coolShakeViewBean == null) {
            return;
        }
        C3116af.m48494c("ShakeUtil", "setShakeCoolParams mShakeCount:" + coolShakeViewBean.getShakeCount() + ";mRotateCount:" + coolShakeViewBean.getRotatCount());
        try {
            this.f11262v = false;
            m48490a(coolShakeViewBean.getShakeCount());
            m48492a(coolShakeViewBean.getShakeStartAmplitude());
            m48475b(coolShakeViewBean.getShakeEndAmplitude());
            m48467c(coolShakeViewBean.getRotatAmplitude());
            m48473b(coolShakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m48479a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean, String str) {
        m48469b(coolShakeViewBean);
        m48477a(str);
    }

    /* renamed from: a */
    public void m48492a(double d) {
        this.f11244d = d;
    }

    /* renamed from: a */
    public void m48490a(int i) {
        this.f11247g = i;
    }

    /* renamed from: a */
    public void m48486a(InterfaceC3118a interfaceC3118a) {
        this.f11255o = interfaceC3118a;
    }

    /* renamed from: a */
    public void m48477a(String str) {
        this.f11261u = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m48491a(float f, float f2, float f3, double d) {
        double d2 = f;
        Double.isNaN(d2);
        double pow = Math.pow(d2 / 9.8d, 2.0d);
        double d3 = f2;
        Double.isNaN(d3);
        double pow2 = pow + Math.pow(d3 / 9.8d, 2.0d);
        double d4 = f3;
        Double.isNaN(d4);
        return Math.sqrt(pow2 + Math.pow(d4 / 9.8d, 2.0d)) > d;
    }

    /* renamed from: a */
    protected void m48493a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.f11255o != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.f11256p);
        C3116af.m48496a("BeiZis", sb.toString());
        if (this.f11255o == null || this.f11256p) {
            return;
        }
        C3116af.m48496a("BeiZis", "callback onShakeHappened()");
        this.f11256p = true;
        this.f11255o.mo46796a();
    }

    /* renamed from: a */
    public void m48487a(View view) {
        this.f11258r = view;
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
    public android.view.View m48489a(int r10, int r11, com.beizi.fusion.model.AdSpacesBean.BuyerBean.PercentPositionBean r12) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.NativeShakeUtil.m48489a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean):android.view.View");
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x0170  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View m48488a(int r10, int r11, com.beizi.fusion.model.AdSpacesBean.BuyerBean.PercentPositionBean r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.NativeShakeUtil.m48488a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean, java.lang.String):android.view.View");
    }
}
