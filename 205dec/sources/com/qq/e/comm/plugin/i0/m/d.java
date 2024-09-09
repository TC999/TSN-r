package com.qq.e.comm.plugin.i0.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.qq.e.comm.plugin.i0.m.a;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.i0.n.g;
import java.net.URLDecoder;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f44383a;

    private int b(f fVar, String str) throws Exception {
        String[] split;
        JSONObject jSONObject;
        if (fVar.getMethod() == f.a.GET) {
            jSONObject = new JSONObject(Uri.parse(str).getQueryParameter("ext"));
        } else {
            JSONObject jSONObject2 = null;
            for (String str2 : new String(fVar.k(), com.qq.e.comm.plugin.k.a.f44515a).split("&")) {
                if (str2.startsWith("ext")) {
                    jSONObject2 = new JSONObject(URLDecoder.decode(str2).substring(4));
                }
            }
            jSONObject = jSONObject2;
        }
        return jSONObject.optJSONObject("req").optInt("postype");
    }

    @Override // com.qq.e.comm.plugin.i0.m.a
    public g a(a.InterfaceC0847a interfaceC0847a) throws Exception {
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        f a5 = interfaceC0847a.a();
        SharedPreferences sharedPreferences = a4.getSharedPreferences("gdt_mock", 0);
        this.f44383a = sharedPreferences;
        int i4 = sharedPreferences.getInt("cs", -1);
        int i5 = this.f44383a.getInt("pt", -1);
        int i6 = this.f44383a.getInt("ifs", 0);
        int i7 = this.f44383a.getInt("scenes", -1);
        if (com.qq.e.comm.plugin.util.c.a(a5.i()) && i4 != -1 && i5 != -1) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pt", i5);
            jSONObject.put("cs", i4);
            jSONObject.put("scenes", i7);
            jSONObject.put("ifs", i6);
            jSONObject.put("c_os", "android");
            jSONObject.put("c_pkgname", a4.getPackageName());
            jSONObject.put("appid", com.qq.e.comm.plugin.d0.a.d().b().a());
            jSONObject.put("posid", a(a5, a5.i()));
            jSONObject.put("postype", b(a5, a5.i()));
            b(a5, a5.i());
            com.qq.e.comm.plugin.i0.n.c cVar = new com.qq.e.comm.plugin.i0.n.c("https://union.eff.qq.com/v2/query/gdtmview", f.a.POST, jSONObject.toString().getBytes("UTF-8"));
            cVar.addHeader("Content-Type", "application/json");
            cVar.d(a5.a());
            cVar.a(a5.d());
            return interfaceC0847a.a(cVar);
        }
        return interfaceC0847a.a(a5);
    }

    private String a(f fVar, String str) throws Exception {
        String[] split;
        if (fVar.getMethod() == f.a.GET) {
            return Uri.parse(str).getQueryParameter("posid");
        }
        String str2 = null;
        for (String str3 : new String(fVar.k(), com.qq.e.comm.plugin.k.a.f44515a).split("&")) {
            if (str3.startsWith("posid")) {
                str2 = str3.substring(6);
            }
        }
        return str2;
    }
}
