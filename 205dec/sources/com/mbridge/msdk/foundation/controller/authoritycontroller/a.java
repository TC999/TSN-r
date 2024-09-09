package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SDKAuthorityController.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f39108c = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f39109f = true;

    /* renamed from: b  reason: collision with root package name */
    public CallBackForDeveloper f39111b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f39110a = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private int f39113e = 3;

    /* renamed from: d  reason: collision with root package name */
    private AuthorityInfoBean f39112d = new AuthorityInfoBean();

    private a() {
        try {
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
                this.f39112d.b(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
                this.f39112d.c(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
                this.f39112d.d(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b("authority_applist").equals("")) {
                this.f39112d.f(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b("authority_app_download").equals("")) {
                this.f39112d.g(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(com.mbridge.msdk.a.AUTHORITY_OA_ID).equals("")) {
                this.f39112d.e(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_OTHER).equals("")) {
                this.f39112d.h(1);
            }
            this.f39110a.add(MBridgeConstans.AUTHORITY_GENERAL_DATA);
            this.f39110a.add(MBridgeConstans.AUTHORITY_DEVICE_ID);
            this.f39110a.add("authority_applist");
            this.f39110a.add("authority_app_download");
            this.f39110a.add(MBridgeConstans.AUTHORITY_SERIAL_ID);
            this.f39110a.add(com.mbridge.msdk.a.AUTHORITY_OA_ID);
            this.f39110a.add(MBridgeConstans.AUTHORITY_OTHER);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static a a() {
        if (f39108c == null) {
            synchronized (a.class) {
                if (f39108c == null) {
                    f39108c = new a();
                }
            }
        }
        return f39108c;
    }

    private int c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String b4 = com.mbridge.msdk.foundation.a.a.a.a().b(str);
                if (TextUtils.isEmpty(b4)) {
                    return 0;
                }
                return Integer.parseInt(b4);
            }
        } catch (Exception e4) {
            x.d("SDKAuthorityController", e4.getMessage());
        }
        return 0;
    }

    private int d(String str) {
        com.mbridge.msdk.c.a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = b.a().b();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return b4.F();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return b4.G();
        }
        if (str.equals("authority_applist")) {
            return b4.M();
        }
        if (str.equals("authority_app_download")) {
            return b4.R();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            return b4.E();
        }
        if (str.equals(com.mbridge.msdk.a.AUTHORITY_OA_ID)) {
            return b4.G();
        }
        return -1;
    }

    public static boolean g() {
        return f39109f;
    }

    public final AuthorityInfoBean b() {
        AuthorityInfoBean authorityInfoBean = this.f39112d;
        return authorityInfoBean != null ? authorityInfoBean : new AuthorityInfoBean().a(1);
    }

    public final boolean e() {
        int i4 = this.f39113e;
        return i4 == 1 || i4 == 3;
    }

    public final int f() {
        return this.f39113e;
    }

    public final void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String optString = new JSONObject(str).optString(MBridgeConstans.AUTHORITY_CONSENTSTATUS);
            boolean z3 = true;
            if (!TextUtils.isEmpty(optString)) {
                this.f39113e = Integer.parseInt(optString) == 1 ? 1 : 2;
            }
            CallBackForDeveloper callBackForDeveloper = this.f39111b;
            if (callBackForDeveloper != null) {
                if (this.f39113e != 1) {
                    z3 = false;
                }
                callBackForDeveloper.onAuthorityCallback(z3);
            }
        } catch (Exception e4) {
            x.d("SDKAuthorityController", e4.getMessage());
        }
    }

    public final String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i4 = this.f39113e;
            int i5 = 1;
            if (i4 != 1 && i4 != 3) {
                i5 = 0;
            }
            jSONObject.put(MBridgeConstans.AUTHORITY_CONSENTSTATUS, String.valueOf(i5));
            return jSONObject.toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public final void a(String str, int i4) {
        if (this.f39112d != null) {
            if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                this.f39112d.b(i4);
            } else if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                this.f39112d.c(i4);
            } else if (str.equals("authority_applist")) {
                this.f39112d.f(i4);
            } else if (str.equals("authority_app_download")) {
                this.f39112d.g(i4);
            } else if (str.equals(MBridgeConstans.AUTHORITY_ALL_INFO)) {
                this.f39112d.a(i4);
            } else if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
                this.f39112d.d(i4);
            } else if (str.equals(com.mbridge.msdk.a.AUTHORITY_OA_ID)) {
                this.f39112d.e(i4);
            } else if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
                this.f39112d.h(i4);
            }
        }
    }

    public final void b(int i4) {
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_DNT, i4);
    }

    public final String d() {
        JSONArray jSONArray = new JSONArray();
        for (int i4 = 0; i4 < this.f39110a.size(); i4++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("keyname", String.valueOf(this.f39110a.get(i4)));
                jSONObject.put("client_status", c(this.f39110a.get(i4)));
                jSONObject.put("server_status", d(this.f39110a.get(i4)));
                jSONArray.put(jSONObject);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public final boolean a(String str) {
        boolean z3;
        com.mbridge.msdk.c.a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        boolean z4 = false;
        if (b4 == null) {
            b4 = b.a().b();
            z3 = true;
        } else {
            z3 = false;
        }
        int H = b4.H();
        boolean z5 = H != 0 ? H == 1 && d(str) == 1 : c(str) == 1 && d(str) == 1;
        if (str.equals("authority_applist") || str.equals("authority_app_download")) {
            z5 = d(str) != 0;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            z5 = c(str) == 1;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID) && a().f39113e == 2) {
            if (!b4.aT() && !z3 && c(str) == 1) {
                z4 = true;
            }
            z5 = z4;
        }
        return (str.equals("authority_imei_mac") || str.equals("authority_imsi_id") || str.equals("authority_android_id")) ? !b4.aT() : z5;
    }

    public final void a(int i4) {
        if (this.f39112d != null) {
            this.f39113e = i4 != 1 ? 2 : 1;
        }
    }

    public static void a(boolean z3) {
        f39109f = z3;
    }
}
