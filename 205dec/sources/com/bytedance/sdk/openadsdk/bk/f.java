package com.bytedance.sdk.openadsdk.bk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private Context f31547c;

    /* renamed from: w  reason: collision with root package name */
    private WeakReference<ev> f31550w;
    private Map<String, c> xv = new HashMap();
    private SensorEventListener sr = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.bk.f.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            ev sr;
            if (sensorEvent.sensor.getType() != 1 || (sr = f.this.sr()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f4);
                jSONObject.put("y", f5);
                jSONObject.put("z", f6);
                sr.c("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener ux = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.bk.f.12
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            ev sr;
            if (sensorEvent.sensor.getType() != 4 || (sr = f.this.sr()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put("z", degrees3);
                sr.c("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private SensorEventListener f31548f = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.bk.f.23
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            ev sr;
            if (sensorEvent.sensor.getType() != 10 || (sr = f.this.sr()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f4);
                jSONObject.put("y", f5);
                jSONObject.put("z", f6);
                sr.c("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    /* renamed from: r  reason: collision with root package name */
    private SensorEventListener f31549r = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.bk.f.34
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float[] fArr2 = p.f31616w;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                float[] fArr3 = sensorEvent.values;
                float[] fArr4 = p.xv;
                System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
            }
            float[] fArr5 = p.sr;
            SensorManager.getRotationMatrix(fArr5, null, p.f31616w, p.xv);
            float[] fArr6 = p.ux;
            SensorManager.getOrientation(fArr5, fArr6);
            ev sr = f.this.sr();
            if (sr == null) {
                return;
            }
            float f4 = fArr6[0];
            float f5 = fArr6[1];
            float f6 = fArr6[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f4);
                jSONObject.put("beta", f5);
                jSONObject.put("gamma", f6);
                sr.c("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        JSONObject c(JSONObject jSONObject) throws Throwable;
    }

    public f(ev evVar) {
        this.f31547c = evVar.getContext();
        this.f31550w = new WeakReference<>(evVar);
        xv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ev sr() {
        WeakReference<ev> weakReference = this.f31550w;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.bk.c ux() {
        ev sr = sr();
        if (sr == null) {
            return null;
        }
        return sr.ia();
    }

    private void xv() {
        this.xv.put("adInfo", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.45
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                if (sr != null) {
                    JSONObject fz = sr.fz();
                    if (fz != null) {
                        fz.put("code", 1);
                        return fz;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -1);
                return jSONObject3;
            }
        });
        this.xv.put("appInfo", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.56
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                JSONArray jSONArray = new JSONArray();
                for (String str : f.this.c()) {
                    jSONArray.put(str);
                }
                jSONObject2.put("supportList", jSONArray);
                ev sr = f.this.sr();
                if (sr != null) {
                    jSONObject2.put("deviceId", sr.f());
                    jSONObject2.put("netType", sr.fp());
                    jSONObject2.put("innerAppName", sr.xv());
                    jSONObject2.put("appName", sr.sr());
                    jSONObject2.put("appVersion", sr.ux());
                    Map<String, String> c4 = sr.c();
                    for (String str2 : c4.keySet()) {
                        jSONObject2.put(str2, c4.get(str2));
                    }
                }
                return jSONObject2;
            }
        });
        this.xv.put("playableSDKInfo", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.61
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                jSONObject2.put("os", "android");
                return jSONObject2;
            }
        });
        this.xv.put("subscribe_app_ad", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.62
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.bk.c ux = f.this.ux();
                JSONObject jSONObject2 = new JSONObject();
                if (ux == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                ux.w(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("download_app_ad", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.63
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.bk.c ux = f.this.ux();
                JSONObject jSONObject2 = new JSONObject();
                if (ux == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                ux.xv(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("isViewable", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.2
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                if (sr == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("viewStatus", sr.ev());
                return jSONObject3;
            }
        });
        this.xv.put("getVolume", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.3
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                if (sr == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("endcard_mute", sr.r());
                return jSONObject3;
            }
        });
        this.xv.put("getScreenSize", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.4
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                if (sr == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject s3 = sr.s();
                s3.put("code", 1);
                return s3;
            }
        });
        this.xv.put("start_accelerometer_observer", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.5
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i4 = 2;
                if (jSONObject != null) {
                    try {
                        i4 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        r.c("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                p.c(f.this.f31547c, f.this.sr, i4);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("close_accelerometer_observer", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.6
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    p.c(f.this.f31547c, f.this.sr);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    r.c("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.xv.put("start_gyro_observer", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.7
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i4 = 2;
                if (jSONObject != null) {
                    try {
                        i4 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        r.c("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                p.w(f.this.f31547c, f.this.ux, i4);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("close_gyro_observer", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.8
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    p.c(f.this.f31547c, f.this.ux);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    r.c("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.xv.put("start_accelerometer_grativityless_observer", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.9
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i4 = 2;
                if (jSONObject != null) {
                    try {
                        i4 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        r.c("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                p.xv(f.this.f31547c, f.this.f31548f, i4);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("close_accelerometer_grativityless_observer", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.10
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    p.c(f.this.f31547c, f.this.f31548f);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    r.c("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.xv.put("start_rotation_vector_observer", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.11
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i4 = 2;
                if (jSONObject != null) {
                    try {
                        i4 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        r.c("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                p.sr(f.this.f31547c, f.this.f31549r, i4);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("close_rotation_vector_observer", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.13
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    p.c(f.this.f31547c, f.this.f31549r);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    r.c("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.xv.put("device_shake", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.14
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    p.c(f.this.f31547c, 300L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    r.c("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.xv.put("device_shake_short", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.15
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    p.c(f.this.f31547c, 150L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    r.c("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.xv.put("playable_style", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.16
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr != null) {
                    JSONObject w3 = sr.w();
                    w3.put("code", 1);
                    return w3;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.xv.put("sendReward", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.17
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr != null) {
                    sr.i();
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.xv.put("webview_time_track", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.18
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.xv.put("playable_event", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.19
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr != null && jSONObject != null) {
                    sr.w(jSONObject.optString("event", null), jSONObject.optJSONObject(EventMonitor.V3_PARAMS));
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.xv.put("reportAd", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.20
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.ys(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("close", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.21
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.fp(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("openAdLandPageLinks", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.22
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.ia(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("get_viewport", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.24
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject u3 = sr.u();
                u3.put("code", 1);
                return u3;
            }
        });
        this.xv.put("jssdk_load_finish", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.25
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.me();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_material_render_result", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.26
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.t(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("detect_change_playable_click", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.27
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject gd = sr.gd();
                gd.put("code", 1);
                return gd;
            }
        });
        this.xv.put("check_camera_permission", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.28
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject a4 = sr.a();
                a4.put("code", 1);
                return a4;
            }
        });
        this.xv.put("check_external_storage", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.29
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject bk = sr.bk();
                if (bk.isNull("result")) {
                    bk.put("code", -1);
                } else {
                    bk.put("code", 1);
                }
                return bk;
            }
        });
        this.xv.put("playable_open_camera", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.30
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.c(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_pick_photo", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.31
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.w(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_download_media_in_photos", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.32
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.xv(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_preventTouchEvent", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.33
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.sr(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_settings_info", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.35
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject t3 = sr.t();
                t3.put("code", 1);
                return t3;
            }
        });
        this.xv.put("playable_load_main_scene", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.36
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.q();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_enter_section", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.37
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.f(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_end", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.38
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.j();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_finish_play_playable", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.39
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.ls();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_transfrom_module_show", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.40
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.gb();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_transfrom_module_change_color", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.41
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.n();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_set_scroll_rect", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.42
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.r(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_click_area", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.43
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.ev(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_real_play_start", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.44
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.ck();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_material_first_frame_show", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.46
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.z();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_stuck_check_pong", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.47
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.eq();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_material_adnormal_mask", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.48
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.gd(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_long_press_panel", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.49
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.ba();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_alpha_player_play", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.50
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.p(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_transfrom_module_highlight", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.51
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.y();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_send_click_event", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.52
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                sr.k(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_query_media_permission_declare", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.53
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject a4 = sr.a(jSONObject);
                a4.put("code", 1);
                return a4;
            }
        });
        this.xv.put("playable_query_media_permission_enable", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.54
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                ev sr = f.this.sr();
                JSONObject jSONObject2 = new JSONObject();
                if (sr == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject bk = sr.bk(jSONObject);
                bk.put("code", 1);
                return bk;
            }
        });
        this.xv.put("playable_apply_media_permission", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.55
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.bk.c ux = f.this.ux();
                JSONObject jSONObject2 = new JSONObject();
                if (ux == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                ux.t(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_start_kws", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.57
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.bk.c ux = f.this.ux();
                JSONObject jSONObject2 = new JSONObject();
                if (ux == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                ux.ys(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_close_kws", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.58
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.bk.c ux = f.this.ux();
                JSONObject jSONObject2 = new JSONObject();
                if (ux == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                ux.k();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_video_preload_task_add", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.59
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.bk.c ux = f.this.ux();
                JSONObject jSONObject2 = new JSONObject();
                if (ux == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                ux.fp(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.xv.put("playable_video_preload_task_cancel", new c() { // from class: com.bytedance.sdk.openadsdk.bk.f.60
            @Override // com.bytedance.sdk.openadsdk.bk.f.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.bk.c ux = f.this.ux();
                JSONObject jSONObject2 = new JSONObject();
                if (ux == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                ux.ia(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
    }

    public Set<String> c() {
        return this.xv.keySet();
    }

    public void w() {
        p.c(this.f31547c, this.sr);
        p.c(this.f31547c, this.ux);
        p.c(this.f31547c, this.f31548f);
        p.c(this.f31547c, this.f31549r);
    }

    public JSONObject c(String str, JSONObject jSONObject) {
        try {
            c cVar = this.xv.get(str);
            if (cVar == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
            return cVar.c(jSONObject);
        } catch (Throwable th) {
            r.c("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }
}
