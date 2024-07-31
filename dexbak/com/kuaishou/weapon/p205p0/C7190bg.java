package com.kuaishou.weapon.p205p0;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.bg */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7190bg {

    /* renamed from: a */
    private int f24552a = -1;

    /* renamed from: d */
    public static int m34274d(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: g */
    private boolean m34271g(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.widget.LockPatternUtils");
            return ((Boolean) cls.getMethod("isSecure", new Class[0]).invoke(cls.getConstructor(Context.class).newInstance(context), new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public String m34278a(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return C7193bi.f24567b;
            }
            int streamMaxVolume = audioManager.getStreamMaxVolume(0);
            int streamVolume = audioManager.getStreamVolume(0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", streamMaxVolume + ":" + streamVolume);
            int streamMaxVolume2 = audioManager.getStreamMaxVolume(1);
            int streamVolume2 = audioManager.getStreamVolume(1);
            jSONObject.put("1", streamMaxVolume2 + ":" + streamVolume2);
            int streamMaxVolume3 = audioManager.getStreamMaxVolume(2);
            int streamVolume3 = audioManager.getStreamVolume(2);
            jSONObject.put("2", streamMaxVolume3 + ":" + streamVolume3);
            int streamMaxVolume4 = audioManager.getStreamMaxVolume(3);
            int streamVolume4 = audioManager.getStreamVolume(3);
            jSONObject.put("3", streamMaxVolume4 + ":" + streamVolume4);
            int streamMaxVolume5 = audioManager.getStreamMaxVolume(4);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("4", streamMaxVolume5 + ":" + streamVolume5);
            String jSONObject2 = jSONObject.toString();
            return TextUtils.isEmpty(jSONObject2) ? C7193bi.f24568c : jSONObject2;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: b */
    public boolean m34276b(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    /* renamed from: c */
    public boolean m34275c(Context context) {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (Build.VERSION.SDK_INT >= 28) {
                return keyguardManager.isKeyguardLocked();
            }
            return keyguardManager.inKeyguardRestrictedInputMode();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: e */
    public boolean m34273e(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure();
    }

    /* renamed from: f */
    public JSONObject m34272f(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService(UMCommonContent.f37799ac);
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (Sensor sensor : sensorList) {
                jSONObject.put(sensor.getName(), sensor.getVendor());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public int m34277b() {
        return this.f24552a;
    }

    /* renamed from: a */
    public boolean m34279a() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
