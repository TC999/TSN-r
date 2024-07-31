package com.beizi.fusion.p072g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.TwistView;
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;
import com.tencent.bugly.BUGLY;
import com.umeng.analytics.pro.UMCommonContent;

/* renamed from: com.beizi.fusion.g.an */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RollUtil {

    /* renamed from: a */
    private static final String f11278a = "an";

    /* renamed from: c */
    private static SensorManager f11279c;

    /* renamed from: n */
    private static String f11280n;

    /* renamed from: o */
    private static String f11281o;

    /* renamed from: p */
    private static String f11282p;

    /* renamed from: q */
    private static String f11283q;

    /* renamed from: b */
    private Context f11284b;

    /* renamed from: j */
    private long f11291j;

    /* renamed from: k */
    private double f11292k;

    /* renamed from: l */
    private double f11293l;

    /* renamed from: m */
    private TwistView f11294m;

    /* renamed from: d */
    private long f11285d = 0;

    /* renamed from: e */
    private double f11286e = -999.0d;

    /* renamed from: f */
    private double f11287f = -999.0d;

    /* renamed from: g */
    private boolean f11288g = false;

    /* renamed from: h */
    private boolean f11289h = false;

    /* renamed from: i */
    private int f11290i = 0;

    /* renamed from: r */
    private boolean f11295r = false;

    /* renamed from: s */
    private boolean f11296s = false;

    /* renamed from: t */
    private InterfaceC3128a f11297t = null;

    /* renamed from: u */
    private final SensorEventListener f11298u = new SensorEventListener() { // from class: com.beizi.fusion.g.an.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                if (System.currentTimeMillis() - RollUtil.this.f11285d < 80) {
                    return;
                }
                RollUtil.this.f11285d = System.currentTimeMillis();
                float[] fArr = sensorEvent.values;
                double d = fArr[0];
                Double.isNaN(d);
                double d2 = d / 9.8d;
                double d3 = fArr[1];
                Double.isNaN(d3);
                double d4 = d3 / 9.8d;
                double d5 = fArr[2];
                Double.isNaN(d5);
                double d6 = d5 / 9.8d;
                double degrees = Math.toDegrees(Math.atan2(d2, d4));
                double d7 = degrees <= Utils.DOUBLE_EPSILON ? (-degrees) - 180.0d : 180.0d - degrees;
                double degrees2 = Math.toDegrees(Math.atan2(d2, d6));
                double d8 = degrees2 <= Utils.DOUBLE_EPSILON ? (-degrees2) - 180.0d : 180.0d - degrees2;
                double degrees3 = Math.toDegrees(Math.atan2(d6, Math.sqrt((d2 * d2) + (d4 * d4)))) + 90.0d;
                if (degrees3 > 45.0d && degrees3 < 135.0d && (Math.abs((Math.sin(d4) / 3.141592653589793d) * 180.0d) >= 45.0d || !RollUtil.this.f11288g)) {
                    if (RollUtil.this.f11287f != -999.0d && RollUtil.this.f11289h) {
                        if ((d7 < RollUtil.this.f11287f || d7 - RollUtil.this.f11287f <= RollUtil.this.f11292k || d7 - RollUtil.this.f11287f > 180.0d) && (d7 >= RollUtil.this.f11287f || RollUtil.this.f11287f <= Utils.DOUBLE_EPSILON || (360.0d - RollUtil.this.f11287f) + d7 <= RollUtil.this.f11292k || (360.0d - RollUtil.this.f11287f) + d7 > 180.0d)) {
                            if (d7 < RollUtil.this.f11287f || ((d7 - RollUtil.this.f11287f >= RollUtil.this.f11293l || Math.abs(d7 - RollUtil.this.f11287f) > 180.0d) && (Math.abs(d7 - RollUtil.this.f11287f) < 180.0d || (-(360.0d - Math.abs(d7 - RollUtil.this.f11287f))) >= RollUtil.this.f11293l))) {
                                if (d7 >= RollUtil.this.f11287f) {
                                    return;
                                }
                                if ((d7 - RollUtil.this.f11287f >= RollUtil.this.f11293l || Math.abs(d7 - RollUtil.this.f11287f) > 180.0d) && (Math.abs(d7 - RollUtil.this.f11287f) < 180.0d || 360.0d - Math.abs(d7 - RollUtil.this.f11287f) >= RollUtil.this.f11293l)) {
                                    return;
                                }
                            }
                            if (RollUtil.this.f11290i == 1) {
                                RollUtil.this.f11290i = 2;
                                C3116af.m48496a(RollUtil.f11278a, "发生垂直状态回滚");
                                RollUtil.this.m48385i();
                                return;
                            }
                            return;
                        }
                        C3116af.m48494c(RollUtil.f11278a, "11111发生垂直状态滚动 rollStatus:" + RollUtil.this.f11290i);
                        RollUtil.this.f11290i = 1;
                        RollUtil.this.m48385i();
                        return;
                    }
                    RollUtil.this.f11287f = d7;
                    RollUtil.this.f11289h = true;
                    RollUtil.this.f11288g = false;
                    return;
                }
                if (RollUtil.this.f11286e != -999.0d && RollUtil.this.f11288g) {
                    if ((d8 < RollUtil.this.f11286e || d8 - RollUtil.this.f11286e <= RollUtil.this.f11292k || d8 - RollUtil.this.f11286e > 180.0d) && (d8 >= RollUtil.this.f11286e || RollUtil.this.f11286e <= Utils.DOUBLE_EPSILON || (360.0d - RollUtil.this.f11286e) + d8 <= RollUtil.this.f11292k || (360.0d - RollUtil.this.f11286e) + d8 > 180.0d)) {
                        if (d8 < RollUtil.this.f11286e || ((d8 - RollUtil.this.f11286e >= RollUtil.this.f11293l || Math.abs(d8 - RollUtil.this.f11286e) > 180.0d) && (Math.abs(d8 - RollUtil.this.f11286e) < 180.0d || (-(360.0d - Math.abs(d8 - RollUtil.this.f11286e))) >= RollUtil.this.f11293l))) {
                            if (d8 >= RollUtil.this.f11286e) {
                                return;
                            }
                            if ((d8 - RollUtil.this.f11286e >= RollUtil.this.f11293l || Math.abs(d8 - RollUtil.this.f11286e) > 180.0d) && (Math.abs(d8 - RollUtil.this.f11286e) < 180.0d || 360.0d - Math.abs(d8 - RollUtil.this.f11286e) >= RollUtil.this.f11293l)) {
                                return;
                            }
                        }
                        C3116af.m48496a(RollUtil.f11278a, "2222发生水平状态回滚 rollStatus:" + RollUtil.this.f11290i);
                        if (RollUtil.this.f11290i == 1) {
                            RollUtil.this.f11290i = 2;
                            C3116af.m48496a(RollUtil.f11278a, "发生水平状态回滚");
                            RollUtil.this.m48385i();
                            return;
                        }
                        return;
                    }
                    C3116af.m48494c(RollUtil.f11278a, "11111发生水平状态滚动 rollStatus:" + RollUtil.this.f11290i);
                    RollUtil.this.f11290i = 1;
                    RollUtil.this.m48385i();
                    return;
                }
                RollUtil.this.f11286e = d8;
                RollUtil.this.f11288g = true;
                RollUtil.this.f11289h = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    /* compiled from: RollUtil.java */
    /* renamed from: com.beizi.fusion.g.an$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3128a {
        /* renamed from: a */
        void mo46520a();

        /* renamed from: a */
        void mo46519a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public RollUtil(Context context) {
        this.f11284b = context;
        f11279c = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(UMCommonContent.f37799ac);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m48385i() {
        TwistView twistView = this.f11294m;
        if (twistView != null) {
            twistView.updateRollStatus(this.f11290i);
        }
    }

    /* renamed from: c */
    public void m48401c() {
        this.f11296s = false;
    }

    /* renamed from: b */
    public void m48407b() {
        SensorManager sensorManager = f11279c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f11298u);
        }
        TwistView twistView = this.f11294m;
        if (twistView != null) {
            twistView.destroyView();
            this.f11294m = null;
        }
        this.f11296s = false;
        this.f11295r = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d4, code lost:
        if (r4 >= 400) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m48417a(android.view.ViewGroup r11, int r12, int r13, com.beizi.fusion.model.AdSpacesBean.BuyerBean.RollViewBean r14) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.RollUtil.m48417a(android.view.ViewGroup, int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$RollViewBean):void");
    }

    /* renamed from: b */
    public void m48406b(double d) {
        this.f11293l = d;
    }

    /* renamed from: a */
    public void m48420a() {
        SensorManager sensorManager = f11279c;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f11298u, sensorManager.getDefaultSensor(1), BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH);
        }
    }

    /* renamed from: a */
    public void m48409a(AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        if (rollViewBean == null) {
            return;
        }
        try {
            String str = f11278a;
            C3116af.m48496a(str, "setRollParams getRollTime:" + rollViewBean.getRollTime() + ";getRollPlusAmplitude:" + rollViewBean.getRollPlusAmplitude() + ";getRollMinusAmplitude:" + rollViewBean.getRollMinusAmplitude());
            m48418a(rollViewBean.getRollTime());
            m48419a(rollViewBean.getRollPlusAmplitude());
            m48406b(rollViewBean.getRollMinusAmplitude());
            TwistView twistView = this.f11294m;
            if (twistView != null) {
                twistView.setDurationAnimation(rollViewBean.getRollTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m48410a(AdSpacesBean.BuyerBean.CoolRollViewBean coolRollViewBean) {
        if (coolRollViewBean == null) {
            return;
        }
        try {
            String str = f11278a;
            C3116af.m48496a(str, "setRollCoolParams getRollTime:" + coolRollViewBean.getRollTime() + ";getRollPlusAmplitude:" + coolRollViewBean.getRollPlusAmplitude() + ";getRollMinusAmplitude:" + coolRollViewBean.getRollMinusAmplitude());
            m48418a(coolRollViewBean.getRollTime());
            m48419a(coolRollViewBean.getRollPlusAmplitude());
            m48406b(coolRollViewBean.getRollMinusAmplitude());
            TwistView twistView = this.f11294m;
            if (twistView != null) {
                twistView.setDurationAnimation(coolRollViewBean.getRollTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m48418a(long j) {
        this.f11291j = j;
    }

    /* renamed from: a */
    public void m48419a(double d) {
        this.f11292k = d;
    }

    /* renamed from: a */
    public void m48416a(InterfaceC3128a interfaceC3128a) {
        this.f11297t = interfaceC3128a;
    }
}
