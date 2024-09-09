package cn.jiguang.au;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import cn.jiguang.ag.e;
import cn.jiguang.ah.b;
import cn.jiguang.ah.d;
import com.stub.StubApp;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f2430c;

    /* renamed from: a  reason: collision with root package name */
    private Context f2431a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f2432b;

    /* renamed from: d  reason: collision with root package name */
    private String f2433d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2434e;

    /* renamed from: f  reason: collision with root package name */
    private DhcpInfo f2435f;

    private void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<cn.jiguang.av.a> list) {
        try {
            if (this.f2432b == null) {
                this.f2432b = new JSONObject();
            }
            if (cn.jiguang.ar.a.a().e(1608)) {
                this.f2432b.put("ssid", str);
            }
            if (cn.jiguang.ar.a.a().e(1601)) {
                this.f2432b.put("bssid", str2);
            }
            if (cn.jiguang.ar.a.a().e(1605)) {
                this.f2432b.put("local_ip", str3);
            }
            if (cn.jiguang.ar.a.a().e(1606)) {
                this.f2432b.put("local_mac", str4);
            }
            if (cn.jiguang.ar.a.a().e(1607)) {
                this.f2432b.put("netmask", str5);
            }
            if (cn.jiguang.ar.a.a().e(1604)) {
                this.f2432b.put("gateway", str8);
            }
            if (cn.jiguang.ar.a.a().e(1602)) {
                this.f2432b.put("dhcp", str9);
            }
            if (cn.jiguang.ar.a.a().e(1603)) {
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(str6)) {
                    jSONArray.put(str6);
                }
                if (!TextUtils.isEmpty(str7)) {
                    jSONArray.put(str7);
                }
                this.f2432b.put("dns", jSONArray);
            }
            JSONArray jSONArray2 = new JSONArray();
            for (cn.jiguang.av.a aVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ip", aVar.f2436a);
                jSONObject.put("mac", aVar.f2439d);
                jSONArray2.put(jSONObject);
            }
            this.f2432b.put("data", jSONArray2);
        } catch (JSONException e4) {
            cn.jiguang.w.a.f("JArp", "packageJson exception: " + e4.getMessage());
        }
    }

    private DhcpInfo c(Context context) {
        WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
        if (wifiManager == null) {
            cn.jiguang.w.a.b("JArp", "collect arp failed because get wifiManager failed");
            return this.f2435f;
        }
        int d4 = cn.jiguang.ar.a.a().d(1600);
        if (d4 <= 0) {
            d4 = 600000;
        }
        if (!e.a("getDhcpInfo", d4, 3)) {
            try {
                this.f2435f = wifiManager.getDhcpInfo();
                cn.jiguang.w.a.b("JArp", "get dhcp by api, value is: " + this.f2435f.toString());
            } catch (Throwable unused) {
            }
        }
        return this.f2435f;
    }

    public static a d() {
        if (f2430c == null) {
            synchronized (a.class) {
                if (f2430c == null) {
                    f2430c = new a();
                }
            }
        }
        return f2430c;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2431a = context;
        return "JArp";
    }

    @Override // cn.jiguang.ah.b
    protected void a(String str, JSONObject jSONObject) {
        if (cn.jiguang.ar.a.a().a(1600) && (!jSONObject.optJSONObject("content").optBoolean("disable"))) {
            this.f2434e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        if (this.f2434e) {
            return true;
        }
        return super.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        String str2;
        a aVar;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        DhcpInfo c4;
        DhcpInfo c5;
        DhcpInfo c6;
        DhcpInfo c7;
        DhcpInfo c8;
        String str9;
        if (cn.jiguang.ar.a.a().a(1600)) {
            if (!d.a(context, "android.permission.ACCESS_WIFI_STATE")) {
                str9 = "collect arp failed because has no permission Manifest.permission.ACCESS_WIFI_STATE";
            } else if (!d.w(context)) {
                str9 = "collect arp failed because networkType is not wifi";
            } else if (!TextUtils.isEmpty(d.d(context))) {
                str2 = "";
                String c9 = cn.jiguang.ar.a.a().a(1608) ? d.c(cn.jiguang.ag.a.a(context, false)) : "";
                String b4 = cn.jiguang.ar.a.a().a(1601) ? cn.jiguang.ag.a.b(context, false) : "";
                String str10 = TextUtils.isEmpty(b4) ? "" : b4;
                String str11 = TextUtils.isEmpty(c9) ? "" : c9;
                if (TextUtils.isEmpty(str10)) {
                    aVar = this;
                    str3 = str11;
                } else {
                    aVar = this;
                    str3 = str10;
                }
                aVar.f2433d = str3;
                byte[] bArr = new byte[0];
                if (!cn.jiguang.ar.a.a().e(1605) || (c8 = c(context)) == null) {
                    str4 = "";
                } else {
                    bArr = cn.jiguang.aw.a.a(c8.ipAddress);
                    String a4 = cn.jiguang.aw.a.a(c8.ipAddress);
                    if (TextUtils.equals(a4, "0.0.0.0")) {
                        a4 = "";
                    }
                    str4 = a4;
                }
                String c10 = cn.jiguang.ar.a.a().e(1606) ? d.c(context, "") : "";
                if (!cn.jiguang.ar.a.a().e(1607) || (c7 = c(context)) == null) {
                    str5 = "";
                } else {
                    String a5 = cn.jiguang.aw.a.a(c7.netmask);
                    if (TextUtils.equals(a5, "0.0.0.0")) {
                        a5 = "";
                    }
                    str5 = a5;
                }
                if (!cn.jiguang.ar.a.a().e(1603) || (c6 = c(context)) == null) {
                    str6 = "";
                    str7 = str6;
                } else {
                    String a6 = cn.jiguang.aw.a.a(c6.dns1);
                    if (TextUtils.equals(a6, "0.0.0.0")) {
                        a6 = "";
                    }
                    String a7 = cn.jiguang.aw.a.a(c6.dns2);
                    if (TextUtils.equals(a7, "0.0.0.0")) {
                        a7 = "";
                    }
                    str7 = a7;
                    str6 = a6;
                }
                if (!cn.jiguang.ar.a.a().e(1604) || (c5 = c(context)) == null) {
                    str8 = "";
                } else {
                    String a8 = cn.jiguang.aw.a.a(c5.gateway);
                    if (TextUtils.equals(a8, "0.0.0.0")) {
                        a8 = "";
                    }
                    str8 = a8;
                }
                if (cn.jiguang.ar.a.a().e(1602) && (c4 = c(context)) != null) {
                    String a9 = cn.jiguang.aw.a.a(c4.serverAddress);
                    str2 = TextUtils.equals(a9, "0.0.0.0") ? "" : a9;
                    cn.jiguang.aw.a.a(str2, bArr);
                }
                List<cn.jiguang.av.a> a10 = cn.jiguang.aw.a.a(str2, c(context));
                if (a10 == null || a10.isEmpty()) {
                    cn.jiguang.w.a.f("JArp", "collect arp failed because can't get arp info");
                } else {
                    cn.jiguang.w.a.b("JArp", "collect arp success");
                    a(str11, str10, str4, c10, str5, str6, str7, str8, str2, a10);
                }
                super.b(context, str);
                return;
            } else {
                str9 = "collect arp failed because can't get registerId";
            }
            cn.jiguang.w.a.f("JArp", str9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean b() {
        if (this.f2434e) {
            return true;
        }
        return super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (cn.jiguang.ar.a.a().a(1600)) {
            JSONObject jSONObject = this.f2432b;
            if (jSONObject == null) {
                cn.jiguang.w.a.b("JArp", "there are no data to report");
                return;
            }
            d.a(context, jSONObject, "mac_list");
            d.a(context, (Object) this.f2432b);
            this.f2432b = null;
            this.f2434e = false;
            super.c(context, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        if (cn.jiguang.ar.a.a().a(1600)) {
            if (this.f2434e) {
                return true;
            }
            return super.d(context, str);
        }
        return false;
    }
}
