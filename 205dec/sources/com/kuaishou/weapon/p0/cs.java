package com.kuaishou.weapon.p0;

import android.location.Location;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cs {

    /* renamed from: a  reason: collision with root package name */
    private ct f38223a = new ct();

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            ct ctVar = new ct();
            int a4 = ctVar.a(TelephonyManager.class, "getDeviceId", new Object[0]);
            if (a4 > 0) {
                jSONObject.put("0", a4);
            }
            int a5 = ctVar.a(TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (a5 > 0) {
                jSONObject.put("1", a5);
            }
            int a6 = ctVar.a(TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (a6 > 0) {
                jSONObject.put("2", a6);
            }
            int a7 = ctVar.a(Location.class, "getLatitude", new Object[0]);
            if (a7 > 0) {
                jSONObject.put("3", a7);
            }
            int a8 = ctVar.a(Location.class, "getLongitude", new Object[0]);
            if (a8 > 0) {
                jSONObject.put("4", a8);
            }
            int a9 = ctVar.a(WifiInfo.class, "getMacAddress", new Object[0]);
            if (a9 > 0) {
                jSONObject.put("6", a9);
            }
            int a10 = ctVar.a(WifiInfo.class, "getBSSID", new Object[0]);
            if (a10 > 0) {
                jSONObject.put("7", a10);
            }
            int a11 = ctVar.a(WifiInfo.class, "getRssi", new Object[0]);
            if (a11 > 0) {
                jSONObject.put("8", a11);
            }
            int a12 = ctVar.a(JSONObject.class, "toString", new Object[0]);
            if (a12 > 0) {
                jSONObject.put("9", a12);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            int a4 = this.f38223a.a();
            if (a4 <= 0) {
                return null;
            }
            int a5 = this.f38223a.a(a4, TelephonyManager.class, "getDeviceId", new Object[0]);
            if (a5 > 0) {
                jSONObject.put("0", a5);
            }
            int a6 = this.f38223a.a(a4, TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (a6 > 0) {
                jSONObject.put("1", a6);
            }
            int a7 = this.f38223a.a(a4, TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (a7 > 0) {
                jSONObject.put("2", a7);
            }
            int a8 = this.f38223a.a(a4, Location.class, "getLatitude", new Object[0]);
            if (a8 > 0) {
                jSONObject.put("3", a8);
            }
            int a9 = this.f38223a.a(a4, Location.class, "getLongitude", new Object[0]);
            if (a9 > 0) {
                jSONObject.put("4", a9);
            }
            int a10 = this.f38223a.a(a4, WifiInfo.class, "getMacAddress", new Object[0]);
            if (a10 > 0) {
                jSONObject.put("6", a10);
            }
            int a11 = this.f38223a.a(a4, WifiInfo.class, "getBSSID", new Object[0]);
            if (a11 > 0) {
                jSONObject.put("7", a11);
            }
            int a12 = this.f38223a.a(a4, WifiInfo.class, "getRssi", new Object[0]);
            if (a12 > 0) {
                jSONObject.put("8", a12);
            }
            int a13 = this.f38223a.a(a4, JSONObject.class, "toString", new Object[0]);
            if (a13 > 0) {
                jSONObject.put("9", a13);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
