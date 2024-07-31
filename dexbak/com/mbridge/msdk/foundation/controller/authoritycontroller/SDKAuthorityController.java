package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.text.TextUtils;
import com.mbridge.msdk.DomainMBridgeConstans;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.controller.authoritycontroller.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SDKAuthorityController {

    /* renamed from: c */
    private static volatile SDKAuthorityController f30281c = null;

    /* renamed from: f */
    private static boolean f30282f = true;

    /* renamed from: b */
    public CallBackForDeveloper f30284b;

    /* renamed from: a */
    public ArrayList<String> f30283a = new ArrayList<>();

    /* renamed from: e */
    private int f30286e = 3;

    /* renamed from: d */
    private AuthorityInfoBean f30285d = new AuthorityInfoBean();

    private SDKAuthorityController() {
        try {
            if (SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
                this.f30285d.m22849b(1);
            }
            if (SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
                this.f30285d.m22848c(1);
            }
            if (SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
                this.f30285d.m22847d(1);
            }
            if (SharedPerferenceManager.m22949a().m22944b("authority_applist").equals("")) {
                this.f30285d.m22845f(1);
            }
            if (SharedPerferenceManager.m22949a().m22944b("authority_app_download").equals("")) {
                this.f30285d.m22844g(1);
            }
            if (SharedPerferenceManager.m22949a().m22944b(DomainMBridgeConstans.AUTHORITY_OA_ID).equals("")) {
                this.f30285d.m22846e(1);
            }
            if (SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.AUTHORITY_OTHER).equals("")) {
                this.f30285d.m22843h(1);
            }
            this.f30283a.add(MBridgeConstans.AUTHORITY_GENERAL_DATA);
            this.f30283a.add(MBridgeConstans.AUTHORITY_DEVICE_ID);
            this.f30283a.add("authority_applist");
            this.f30283a.add("authority_app_download");
            this.f30283a.add(MBridgeConstans.AUTHORITY_SERIAL_ID);
            this.f30283a.add(DomainMBridgeConstans.AUTHORITY_OA_ID);
            this.f30283a.add(MBridgeConstans.AUTHORITY_OTHER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static SDKAuthorityController m22842a() {
        if (f30281c == null) {
            synchronized (SDKAuthorityController.class) {
                if (f30281c == null) {
                    f30281c = new SDKAuthorityController();
                }
            }
        }
        return f30281c;
    }

    /* renamed from: c */
    private int m22833c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String m22944b = SharedPerferenceManager.m22949a().m22944b(str);
                if (TextUtils.isEmpty(m22944b)) {
                    return 0;
                }
                return Integer.parseInt(m22944b);
            }
        } catch (Exception e) {
            SameLogTool.m21733d("SDKAuthorityController", e.getMessage());
        }
        return 0;
    }

    /* renamed from: d */
    private int m22831d(String str) {
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return m23252b.m23442F();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return m23252b.m23440G();
        }
        if (str.equals("authority_applist")) {
            return m23252b.m23428M();
        }
        if (str.equals("authority_app_download")) {
            return m23252b.m23418R();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            return m23252b.m23444E();
        }
        if (str.equals(DomainMBridgeConstans.AUTHORITY_OA_ID)) {
            return m23252b.m23440G();
        }
        return -1;
    }

    /* renamed from: g */
    public static boolean m22828g() {
        return f30282f;
    }

    /* renamed from: b */
    public final AuthorityInfoBean m22837b() {
        AuthorityInfoBean authorityInfoBean = this.f30285d;
        return authorityInfoBean != null ? authorityInfoBean : new AuthorityInfoBean().m22850a(1);
    }

    /* renamed from: e */
    public final boolean m22830e() {
        int i = this.f30286e;
        return i == 1 || i == 3;
    }

    /* renamed from: f */
    public final int m22829f() {
        return this.f30286e;
    }

    /* renamed from: b */
    public final void m22835b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String optString = new JSONObject(str).optString(MBridgeConstans.AUTHORITY_CONSENTSTATUS);
            boolean z = true;
            if (!TextUtils.isEmpty(optString)) {
                this.f30286e = Integer.parseInt(optString) == 1 ? 1 : 2;
            }
            CallBackForDeveloper callBackForDeveloper = this.f30284b;
            if (callBackForDeveloper != null) {
                if (this.f30286e != 1) {
                    z = false;
                }
                callBackForDeveloper.onAuthorityCallback(z);
            }
        } catch (Exception e) {
            SameLogTool.m21733d("SDKAuthorityController", e.getMessage());
        }
    }

    /* renamed from: c */
    public final String m22834c() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = this.f30286e;
            int i2 = 1;
            if (i != 1 && i != 3) {
                i2 = 0;
            }
            jSONObject.put(MBridgeConstans.AUTHORITY_CONSENTSTATUS, String.valueOf(i2));
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public final void m22839a(String str, int i) {
        if (this.f30285d != null) {
            if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                this.f30285d.m22849b(i);
            } else if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                this.f30285d.m22848c(i);
            } else if (str.equals("authority_applist")) {
                this.f30285d.m22845f(i);
            } else if (str.equals("authority_app_download")) {
                this.f30285d.m22844g(i);
            } else if (str.equals(MBridgeConstans.AUTHORITY_ALL_INFO)) {
                this.f30285d.m22850a(i);
            } else if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
                this.f30285d.m22847d(i);
            } else if (str.equals(DomainMBridgeConstans.AUTHORITY_OA_ID)) {
                this.f30285d.m22846e(i);
            } else if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
                this.f30285d.m22843h(i);
            }
        }
    }

    /* renamed from: b */
    public final void m22836b(int i) {
        SharedPerferenceManager.m22949a().m22947a(MBridgeConstans.AUTHORITY_DNT, i);
    }

    /* renamed from: d */
    public final String m22832d() {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.f30283a.size(); i++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("keyname", String.valueOf(this.f30283a.get(i)));
                jSONObject.put("client_status", m22833c(this.f30283a.get(i)));
                jSONObject.put("server_status", m22831d(this.f30283a.get(i)));
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    /* renamed from: a */
    public final boolean m22840a(String str) {
        boolean z;
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        boolean z2 = false;
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
            z = true;
        } else {
            z = false;
        }
        int m23438H = m23252b.m23438H();
        boolean z3 = m23438H != 0 ? m23438H == 1 && m22831d(str) == 1 : m22833c(str) == 1 && m22831d(str) == 1;
        if (str.equals("authority_applist") || str.equals("authority_app_download")) {
            z3 = m22831d(str) != 0;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            z3 = m22833c(str) == 1;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID) && m22842a().f30286e == 2) {
            if (!m23252b.m23378aT() && !z && m22833c(str) == 1) {
                z2 = true;
            }
            z3 = z2;
        }
        return (str.equals("authority_imei_mac") || str.equals("authority_imsi_id") || str.equals("authority_android_id")) ? !m23252b.m23378aT() : z3;
    }

    /* renamed from: a */
    public final void m22841a(int i) {
        if (this.f30285d != null) {
            this.f30286e = i != 1 ? 2 : 1;
        }
    }

    /* renamed from: a */
    public static void m22838a(boolean z) {
        f30282f = z;
    }
}
