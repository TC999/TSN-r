package com.kuaishou.weapon.p205p0;

import android.location.Location;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cs */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7237cs {

    /* renamed from: a */
    private C7238ct f24727a = new C7238ct();

    /* renamed from: a */
    public JSONObject m34040a() {
        try {
            JSONObject jSONObject = new JSONObject();
            C7238ct c7238ct = new C7238ct();
            int m34036a = c7238ct.m34036a(TelephonyManager.class, "getDeviceId", new Object[0]);
            if (m34036a > 0) {
                jSONObject.put("0", m34036a);
            }
            int m34036a2 = c7238ct.m34036a(TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (m34036a2 > 0) {
                jSONObject.put("1", m34036a2);
            }
            int m34036a3 = c7238ct.m34036a(TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (m34036a3 > 0) {
                jSONObject.put("2", m34036a3);
            }
            int m34036a4 = c7238ct.m34036a(Location.class, "getLatitude", new Object[0]);
            if (m34036a4 > 0) {
                jSONObject.put("3", m34036a4);
            }
            int m34036a5 = c7238ct.m34036a(Location.class, "getLongitude", new Object[0]);
            if (m34036a5 > 0) {
                jSONObject.put("4", m34036a5);
            }
            int m34036a6 = c7238ct.m34036a(WifiInfo.class, "getMacAddress", new Object[0]);
            if (m34036a6 > 0) {
                jSONObject.put("6", m34036a6);
            }
            int m34036a7 = c7238ct.m34036a(WifiInfo.class, "getBSSID", new Object[0]);
            if (m34036a7 > 0) {
                jSONObject.put("7", m34036a7);
            }
            int m34036a8 = c7238ct.m34036a(WifiInfo.class, "getRssi", new Object[0]);
            if (m34036a8 > 0) {
                jSONObject.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, m34036a8);
            }
            int m34036a9 = c7238ct.m34036a(JSONObject.class, "toString", new Object[0]);
            if (m34036a9 > 0) {
                jSONObject.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, m34036a9);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public JSONObject m34039b() {
        try {
            JSONObject jSONObject = new JSONObject();
            int m34038a = this.f24727a.m34038a();
            if (m34038a <= 0) {
                return null;
            }
            int m34037a = this.f24727a.m34037a(m34038a, TelephonyManager.class, "getDeviceId", new Object[0]);
            if (m34037a > 0) {
                jSONObject.put("0", m34037a);
            }
            int m34037a2 = this.f24727a.m34037a(m34038a, TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (m34037a2 > 0) {
                jSONObject.put("1", m34037a2);
            }
            int m34037a3 = this.f24727a.m34037a(m34038a, TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (m34037a3 > 0) {
                jSONObject.put("2", m34037a3);
            }
            int m34037a4 = this.f24727a.m34037a(m34038a, Location.class, "getLatitude", new Object[0]);
            if (m34037a4 > 0) {
                jSONObject.put("3", m34037a4);
            }
            int m34037a5 = this.f24727a.m34037a(m34038a, Location.class, "getLongitude", new Object[0]);
            if (m34037a5 > 0) {
                jSONObject.put("4", m34037a5);
            }
            int m34037a6 = this.f24727a.m34037a(m34038a, WifiInfo.class, "getMacAddress", new Object[0]);
            if (m34037a6 > 0) {
                jSONObject.put("6", m34037a6);
            }
            int m34037a7 = this.f24727a.m34037a(m34038a, WifiInfo.class, "getBSSID", new Object[0]);
            if (m34037a7 > 0) {
                jSONObject.put("7", m34037a7);
            }
            int m34037a8 = this.f24727a.m34037a(m34038a, WifiInfo.class, "getRssi", new Object[0]);
            if (m34037a8 > 0) {
                jSONObject.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, m34037a8);
            }
            int m34037a9 = this.f24727a.m34037a(m34038a, JSONObject.class, "toString", new Object[0]);
            if (m34037a9 > 0) {
                jSONObject.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, m34037a9);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
