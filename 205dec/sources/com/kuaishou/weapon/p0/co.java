package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class co {

    /* renamed from: a  reason: collision with root package name */
    private Context f38208a;

    public co(Context context) {
        this.f38208a = context;
    }

    public String a(String str) {
        JSONObject a4;
        JSONObject a5;
        try {
            cm cmVar = new cm(str, ck.f38176l);
            String a6 = dl.a(cu.f38226a);
            String b4 = b(a6);
            if (TextUtils.isEmpty(b4) || (a4 = cmVar.a(this.f38208a)) == null) {
                return null;
            }
            String str2 = cu.f38233h + "?" + cv.a(this.f38208a);
            if (cu.a() && cu.f38226a.contains("api")) {
                str2 = "/api" + str2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", b4);
            jSONObject.put("host", a6);
            jSONObject.put("path", str2);
            String str3 = WeaponHI.cookieData;
            if (!TextUtils.isEmpty(str3) && str3.length() > 10) {
                jSONObject.put("cookie", str3);
            }
            jSONObject.put("head", a4);
            StringBuilder sb = new StringBuilder();
            sb.append("sdk=" + Build.VERSION.SDK_INT);
            jSONObject.put("parame", sb.toString());
            if (str.equals(ck.f38172h) && (a5 = a()) != null) {
                jSONObject.put("sjd", a5);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String hostAddress = InetAddress.getByName(dl.a(str)).getHostAddress();
            try {
                if (!TextUtils.isEmpty(hostAddress)) {
                    if (hostAddress.contains(".")) {
                        return hostAddress;
                    }
                }
                return "";
            } catch (UnknownHostException unused) {
                return hostAddress;
            }
        } catch (UnknownHostException unused2) {
            return "";
        }
    }

    private JSONObject a() {
        try {
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a4 = h.a(this.f38208a, "re_po_rt");
            a4.e("a1_p_s_p_s");
            a4.e("a1_p_s_p_s_c_b");
            aj ajVar = new aj(this.f38208a);
            jSONObject.put("0", ajVar.d());
            jSONObject.put("1", ajVar.a());
            jSONObject.put("2", ajVar.c());
            jSONObject.put("3", ajVar.f());
            jSONObject.put("24", ajVar.e());
            int i4 = 1;
            jSONObject.put("35", ab.b() ? 1 : 0);
            jSONObject.put("36", ab.a(this.f38208a) ? 1 : 0);
            JSONObject a5 = ai.a(this.f38208a);
            if (a5 != null) {
                jSONObject.put("4", a5);
            }
            a4.b("plc001_r_rcl_vl", 0);
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean a6 = acVar.a(this.f38208a);
            jSONObject.put("8", a6 ? 1 : 0);
            if (a6) {
                jSONObject.put("61", acVar.b(this.f38208a));
            }
            jSONObject.put("10", acVar.e(this.f38208a));
            jSONObject.put("11", acVar.c(this.f38208a));
            ae aeVar = new ae();
            jSONObject.put("26", aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean b4 = aoVar.b();
            jSONObject.put("66", b4 ? 1 : 0);
            if (b4) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put("69", aoVar.e());
            jSONObject.put("101", aoVar.c() ? 1 : 0);
            jSONObject.put("102", aoVar.g() ? 1 : 0);
            jSONObject.put("99", new af().a());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bv.a(this.f38208a));
            jSONObject2.put("03014", bh.g(this.f38208a));
            jSONObject2.put("03020", bv.b(this.f38208a));
            jSONObject2.put("03030", bg.d(this.f38208a));
            jSONObject.put("51", jSONObject2);
            jSONObject.put("107", new an().d());
            if (!ab.b(this.f38208a)) {
                i4 = 0;
            }
            jSONObject.put("60", i4);
            try {
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Is().Ir()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Is().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Is().getAppId()));
                jSONObject.put("11002", Engine.soVersion);
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
