package com.beizi.fusion.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.TwistView;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RollUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14822a = "ao";

    /* renamed from: c  reason: collision with root package name */
    private static SensorManager f14823c;

    /* renamed from: n  reason: collision with root package name */
    private static String f14824n;

    /* renamed from: o  reason: collision with root package name */
    private static String f14825o;

    /* renamed from: p  reason: collision with root package name */
    private static String f14826p;

    /* renamed from: q  reason: collision with root package name */
    private static String f14827q;

    /* renamed from: b  reason: collision with root package name */
    private Context f14828b;

    /* renamed from: j  reason: collision with root package name */
    private long f14835j;

    /* renamed from: k  reason: collision with root package name */
    private double f14836k;

    /* renamed from: l  reason: collision with root package name */
    private double f14837l;

    /* renamed from: m  reason: collision with root package name */
    private TwistView f14838m;

    /* renamed from: u  reason: collision with root package name */
    private Boolean f14842u;

    /* renamed from: d  reason: collision with root package name */
    private long f14829d = 0;

    /* renamed from: e  reason: collision with root package name */
    private double f14830e = -999.0d;

    /* renamed from: f  reason: collision with root package name */
    private double f14831f = -999.0d;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14832g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14833h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f14834i = 0;

    /* renamed from: r  reason: collision with root package name */
    private boolean f14839r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f14840s = false;

    /* renamed from: t  reason: collision with root package name */
    private a f14841t = null;

    /* renamed from: v  reason: collision with root package name */
    private final SensorEventListener f14843v = new SensorEventListener() { // from class: com.beizi.fusion.g.ao.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                if (System.currentTimeMillis() - ao.this.f14829d < 80) {
                    return;
                }
                ao.this.f14829d = System.currentTimeMillis();
                float[] fArr = sensorEvent.values;
                double d4 = fArr[0];
                Double.isNaN(d4);
                double d5 = d4 / 9.8d;
                double d6 = fArr[1];
                Double.isNaN(d6);
                double d7 = d6 / 9.8d;
                double d8 = fArr[2];
                Double.isNaN(d8);
                double d9 = d8 / 9.8d;
                double degrees = Math.toDegrees(Math.atan2(d5, d7));
                double d10 = degrees <= 0.0d ? (-degrees) - 180.0d : 180.0d - degrees;
                double degrees2 = Math.toDegrees(Math.atan2(d5, d9));
                double d11 = degrees2 <= 0.0d ? (-degrees2) - 180.0d : 180.0d - degrees2;
                double degrees3 = Math.toDegrees(Math.atan2(d9, Math.sqrt((d5 * d5) + (d7 * d7)))) + 90.0d;
                if (degrees3 > 45.0d && degrees3 < 135.0d && (Math.abs((Math.sin(d7) / 3.141592653589793d) * 180.0d) >= 45.0d || !ao.this.f14832g)) {
                    if (ao.this.f14831f != -999.0d && ao.this.f14833h) {
                        if ((d10 < ao.this.f14831f || d10 - ao.this.f14831f <= ao.this.f14836k || d10 - ao.this.f14831f > 180.0d) && (d10 >= ao.this.f14831f || ao.this.f14831f <= 0.0d || (360.0d - ao.this.f14831f) + d10 <= ao.this.f14836k || (360.0d - ao.this.f14831f) + d10 > 180.0d)) {
                            if (d10 < ao.this.f14831f || ((d10 - ao.this.f14831f >= ao.this.f14837l || Math.abs(d10 - ao.this.f14831f) > 180.0d) && (Math.abs(d10 - ao.this.f14831f) < 180.0d || (-(360.0d - Math.abs(d10 - ao.this.f14831f))) >= ao.this.f14837l))) {
                                if (d10 >= ao.this.f14831f) {
                                    return;
                                }
                                if ((d10 - ao.this.f14831f >= ao.this.f14837l || Math.abs(d10 - ao.this.f14831f) > 180.0d) && (Math.abs(d10 - ao.this.f14831f) < 180.0d || 360.0d - Math.abs(d10 - ao.this.f14831f) >= ao.this.f14837l)) {
                                    return;
                                }
                            }
                            if (ao.this.f14834i == 1) {
                                ao.this.f14834i = 2;
                                af.a(ao.f14822a, "\u53d1\u751f\u5782\u76f4\u72b6\u6001\u56de\u6eda");
                                ao.this.i();
                                return;
                            }
                            return;
                        }
                        af.c(ao.f14822a, "11111\u53d1\u751f\u5782\u76f4\u72b6\u6001\u6eda\u52a8 rollStatus:" + ao.this.f14834i);
                        ao.this.f14834i = 1;
                        ao.this.i();
                        return;
                    }
                    ao.this.f14831f = d10;
                    ao.this.f14833h = true;
                    ao.this.f14832g = false;
                    return;
                }
                if (ao.this.f14830e != -999.0d && ao.this.f14832g) {
                    if ((d11 < ao.this.f14830e || d11 - ao.this.f14830e <= ao.this.f14836k || d11 - ao.this.f14830e > 180.0d) && (d11 >= ao.this.f14830e || ao.this.f14830e <= 0.0d || (360.0d - ao.this.f14830e) + d11 <= ao.this.f14836k || (360.0d - ao.this.f14830e) + d11 > 180.0d)) {
                        if (d11 < ao.this.f14830e || ((d11 - ao.this.f14830e >= ao.this.f14837l || Math.abs(d11 - ao.this.f14830e) > 180.0d) && (Math.abs(d11 - ao.this.f14830e) < 180.0d || (-(360.0d - Math.abs(d11 - ao.this.f14830e))) >= ao.this.f14837l))) {
                            if (d11 >= ao.this.f14830e) {
                                return;
                            }
                            if ((d11 - ao.this.f14830e >= ao.this.f14837l || Math.abs(d11 - ao.this.f14830e) > 180.0d) && (Math.abs(d11 - ao.this.f14830e) < 180.0d || 360.0d - Math.abs(d11 - ao.this.f14830e) >= ao.this.f14837l)) {
                                return;
                            }
                        }
                        af.a(ao.f14822a, "2222\u53d1\u751f\u6c34\u5e73\u72b6\u6001\u56de\u6eda rollStatus:" + ao.this.f14834i);
                        if (ao.this.f14834i == 1) {
                            ao.this.f14834i = 2;
                            af.a(ao.f14822a, "\u53d1\u751f\u6c34\u5e73\u72b6\u6001\u56de\u6eda");
                            ao.this.i();
                            return;
                        }
                        return;
                    }
                    af.c(ao.f14822a, "11111\u53d1\u751f\u6c34\u5e73\u72b6\u6001\u6eda\u52a8 rollStatus:" + ao.this.f14834i);
                    ao.this.f14834i = 1;
                    ao.this.i();
                    return;
                }
                ao.this.f14830e = d11;
                ao.this.f14832g = true;
                ao.this.f14833h = false;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    };

    /* compiled from: RollUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a();

        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public ao(Context context) {
        this.f14828b = context;
        f14823c = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("sensor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        TwistView twistView = this.f14838m;
        if (twistView != null) {
            twistView.updateRollStatus(this.f14834i);
        }
    }

    public void c() {
        this.f14840s = false;
    }

    public void b() {
        SensorManager sensorManager = f14823c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f14843v);
        }
        TwistView twistView = this.f14838m;
        if (twistView != null) {
            twistView.destroyView();
            this.f14838m = null;
        }
        this.f14840s = false;
        this.f14839r = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d4, code lost:
        if (r4 >= 400) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.view.ViewGroup r11, int r12, int r13, com.beizi.fusion.model.AdSpacesBean.BuyerBean.RollViewBean r14) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.g.ao.a(android.view.ViewGroup, int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$RollViewBean):void");
    }

    public void b(double d4) {
        this.f14837l = d4;
    }

    public void a() {
        SensorManager sensorManager = f14823c;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f14843v, sensorManager.getDefaultSensor(1), 100000);
        }
    }

    public void a(AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        if (rollViewBean == null) {
            return;
        }
        try {
            String str = f14822a;
            af.a(str, "setRollParams getRollTime:" + rollViewBean.getRollTime() + ";getRollPlusAmplitude:" + rollViewBean.getRollPlusAmplitude() + ";getRollMinusAmplitude:" + rollViewBean.getRollMinusAmplitude());
            a(rollViewBean.getRollTime());
            a(rollViewBean.getRollPlusAmplitude());
            b(rollViewBean.getRollMinusAmplitude());
            TwistView twistView = this.f14838m;
            if (twistView != null) {
                twistView.setDurationAnimation(rollViewBean.getRollTime());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.CoolRollViewBean coolRollViewBean) {
        if (coolRollViewBean == null) {
            return;
        }
        try {
            String str = f14822a;
            af.a(str, "setRollCoolParams getRollTime:" + coolRollViewBean.getRollTime() + ";getRollPlusAmplitude:" + coolRollViewBean.getRollPlusAmplitude() + ";getRollMinusAmplitude:" + coolRollViewBean.getRollMinusAmplitude());
            a(coolRollViewBean.getRollTime());
            a(coolRollViewBean.getRollPlusAmplitude());
            b(coolRollViewBean.getRollMinusAmplitude());
            TwistView twistView = this.f14838m;
            if (twistView != null) {
                twistView.setDurationAnimation(coolRollViewBean.getRollTime());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(long j4) {
        this.f14835j = j4;
    }

    public void a(double d4) {
        this.f14836k = d4;
    }

    public void a(a aVar) {
        this.f14841t = aVar;
    }

    public void a(Boolean bool) {
        this.f14842u = bool;
    }
}
