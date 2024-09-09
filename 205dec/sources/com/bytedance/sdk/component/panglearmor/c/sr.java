package com.bytedance.sdk.component.panglearmor.c;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.panglearmor.f;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ys;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements SensorEventListener {

    /* renamed from: c  reason: collision with root package name */
    private static volatile sr f29988c;
    private c bk;
    private Sensor ev;
    private Sensor gd;

    /* renamed from: w  reason: collision with root package name */
    private final List<Float> f29996w = new ArrayList(50);
    private final List<Float> xv = new ArrayList(50);
    private final List<Float> sr = new ArrayList(50);
    private final List<Float> ux = new ArrayList(50);

    /* renamed from: f  reason: collision with root package name */
    private final List<Float> f29990f = new ArrayList(50);

    /* renamed from: r  reason: collision with root package name */
    private final List<Float> f29993r = new ArrayList(50);

    /* renamed from: p  reason: collision with root package name */
    private long f29992p = 0;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f29991k = false;

    /* renamed from: a  reason: collision with root package name */
    private volatile int f29989a = 0;

    /* renamed from: t  reason: collision with root package name */
    private final int f29995t = 0;
    private final int ys = 1;
    private final int fp = 2;
    private final int ia = 16;

    /* renamed from: s  reason: collision with root package name */
    private final int f29994s = 32;
    private volatile int fz = 0;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(JSONObject jSONObject);
    }

    private sr() {
        this.ev = null;
        this.gd = null;
        SensorManager sensorManager = (SensorManager) StubApp.getOrigApplicationContext(f.ux().getApplicationContext()).getSystemService("sensor");
        if (sensorManager != null) {
            try {
                this.ev = sensorManager.getDefaultSensor(1);
                this.gd = sensorManager.getDefaultSensor(2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i4) {
    }

    @Override // android.hardware.SensorEventListener
    @RequiresApi(api = 20)
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f29989a++;
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            if (this.f29996w.size() < 50) {
                this.f29996w.add(Float.valueOf(sensorEvent.values[0]));
                this.xv.add(Float.valueOf(sensorEvent.values[1]));
                this.sr.add(Float.valueOf(sensorEvent.values[2]));
                return;
            }
            f();
        } else if (type != 2) {
        } else {
            if (this.ux.size() < 50) {
                this.ux.add(Float.valueOf(sensorEvent.values[0]));
                this.f29990f.add(Float.valueOf(sensorEvent.values[1]));
                this.f29993r.add(Float.valueOf(sensorEvent.values[2]));
                return;
            }
            f();
        }
    }

    private void f() {
        if (this.f29996w.size() >= 50 && this.ux.size() >= 50) {
            ux();
            ev.w(new p("har") { // from class: com.bytedance.sdk.component.panglearmor.c.sr.1
                @Override // java.lang.Runnable
                public void run() {
                    float[] c4 = xv.c(sr.this.f29996w, sr.this.xv, sr.this.sr, sr.this.ux, sr.this.f29990f, sr.this.f29993r);
                    sr.this.c(c4);
                    long currentTimeMillis = System.currentTimeMillis();
                    SoftDecTool.acs = 0;
                    a.w("HARLOG", "acs result = " + SoftDecTool.acs);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        long f4 = ux.c().f();
                        long r3 = ux.c().r();
                        int xv = (int) (((ux.c().xv() / 1000) / 60) / 60);
                        if (xv <= 0) {
                            xv = 1;
                        }
                        jSONObject.put("azimuth_unit", f4);
                        jSONObject.put("angle_unit", r3);
                        LinkedList<JSONObject> c5 = w.c().c(0L);
                        jSONObject.put("active", Arrays.toString(xv.c(c5, xv)));
                        com.bytedance.sdk.component.panglearmor.c.c.c().c(xv);
                        jSONObject.put("screen", Arrays.toString(com.bytedance.sdk.component.panglearmor.c.c.c().xv()));
                        jSONObject.put("network", Arrays.toString(com.bytedance.sdk.component.panglearmor.c.c.c().w()));
                        jSONObject.put("support_net", com.bytedance.sdk.component.panglearmor.c.c.c().sr());
                        jSONObject.put("sim_status", com.bytedance.sdk.component.panglearmor.c.c.c().ux());
                        int[][] c6 = xv.c(c5, f4, r3);
                        jSONObject.put("ax", Arrays.toString(c6[0]));
                        jSONObject.put("ay", Arrays.toString(c6[1]));
                        jSONObject.put("az", Arrays.toString(c6[2]));
                        int[][] c7 = xv.c(w.c().c(10800000L), f4, r3);
                        jSONObject.put("ax3", Arrays.toString(c7[0]));
                        jSONObject.put("ay3", Arrays.toString(c7[1]));
                        jSONObject.put("az3", Arrays.toString(c7[2]));
                        int[][] c8 = xv.c(w.c().c(21600000L), f4, r3);
                        jSONObject.put("ax6", Arrays.toString(c8[0]));
                        jSONObject.put("ay6", Arrays.toString(c8[1]));
                        jSONObject.put("az6", Arrays.toString(c8[2]));
                        jSONObject.put("angleAvg", Arrays.toString(c4));
                        jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, currentTimeMillis);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    sr.this.bk.c(jSONObject);
                    sr.this.f29991k = false;
                    sr.this.r();
                }
            });
        } else if (this.f29989a > 300) {
            ux();
            this.f29991k = false;
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.f29996w.clear();
        this.xv.clear();
        this.sr.clear();
        this.ux.clear();
        this.f29990f.clear();
        this.f29993r.clear();
    }

    private void ux() {
        this.f29989a = 0;
        SensorManager sensorManager = (SensorManager) StubApp.getOrigApplicationContext(f.ux().getApplicationContext()).getSystemService("sensor");
        if (sensorManager != null) {
            Sensor sensor = this.ev;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.gd;
            if (sensor2 != null) {
                sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    public long sr() {
        return this.f29992p;
    }

    public synchronized boolean w() {
        a.w("HARLOG", "registerSensors enter...");
        this.fz = 0;
        if (this.f29991k) {
            a.w("HARLOG", "sensors are running, not register again");
            return false;
        }
        if (this.ev != null && this.gd != null) {
            this.f29991k = false;
            SensorManager sensorManager = (SensorManager) StubApp.getOrigApplicationContext(f.ux().getApplicationContext()).getSystemService("sensor");
            if (sensorManager != null) {
                try {
                    boolean registerListener = sensorManager.registerListener(this, this.ev, 1);
                    boolean registerListener2 = sensorManager.registerListener(this, this.gd, 1);
                    if (registerListener && registerListener2) {
                        this.f29991k = true;
                    }
                    this.fz |= 32;
                    ux();
                    r();
                } catch (Exception unused) {
                    this.fz |= 32;
                }
            } else {
                this.fz |= 1;
            }
        } else {
            this.fz |= this.ev == null ? 2 : 0;
            this.fz = (this.gd == null ? 16 : 0) | this.fz;
        }
        return this.f29991k;
    }

    public boolean xv() {
        return this.f29991k;
    }

    public static sr c() {
        if (f29988c == null) {
            synchronized (sr.class) {
                if (f29988c == null) {
                    f29988c = new sr();
                }
            }
        }
        return f29988c;
    }

    public void c(c cVar) {
        this.bk = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr) {
        this.f29992p = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", sr());
            if (Build.VERSION.SDK_INT >= 19) {
                jSONObject.put("val", new JSONArray(fArr));
            }
            w.c().c(jSONObject, "sp_angle");
            w.c().c(ys.xv(f.ux()));
        } catch (JSONException e4) {
            throw new RuntimeException(e4);
        }
    }
}
