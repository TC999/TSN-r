package com.qq.e.comm.plugin.d0.d;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.d0.d.i;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    protected String f42243b;

    /* renamed from: c  reason: collision with root package name */
    protected a f42244c;

    /* renamed from: e  reason: collision with root package name */
    private String f42246e;

    /* renamed from: f  reason: collision with root package name */
    protected g f42247f;

    /* renamed from: k  reason: collision with root package name */
    private String f42252k;

    /* renamed from: m  reason: collision with root package name */
    private Context f42254m;

    /* renamed from: o  reason: collision with root package name */
    private boolean f42256o;

    /* renamed from: l  reason: collision with root package name */
    private String f42253l = "";

    /* renamed from: a  reason: collision with root package name */
    private a f42242a = new a();

    /* renamed from: d  reason: collision with root package name */
    private final a f42245d = new a();

    /* renamed from: g  reason: collision with root package name */
    private final g f42248g = new e();

    /* renamed from: h  reason: collision with root package name */
    protected f f42249h = new f();

    /* renamed from: i  reason: collision with root package name */
    private final d f42250i = new d();

    /* renamed from: j  reason: collision with root package name */
    private final c f42251j = new c();

    /* renamed from: n  reason: collision with root package name */
    private String f42255n = b1.a("e_qq_com_setting");

    public h(Context context) {
        this.f42254m = context;
        i();
        h();
        f();
        g();
        this.f42256o = true;
    }

    private void a(String str, g gVar) {
        this.f42246e = str;
        this.f42247f = gVar;
        if (!this.f42256o || gVar == null) {
            return;
        }
        com.qq.e.comm.plugin.n0.g.a(gVar.a());
    }

    private void d(String str) {
    }

    private void f() {
        i.b<a> b4 = i.b(this.f42254m);
        if (b4 != null) {
            a(b4.b(), b4.a());
        } else {
            GDTLogger.d("Load Local DEV Cloud setting fail");
        }
    }

    private void g() {
        i.b<f> c4 = i.c(this.f42254m);
        if (c4 != null) {
            a(c4.b(), c4.a());
        } else {
            GDTLogger.d("Load Local DEV Cloud setting fail");
        }
    }

    private void h() {
        i.b<g> d4 = i.d(this.f42254m);
        if (d4 != null) {
            a(d4.b(), d4.a());
        } else {
            GDTLogger.d("Load Local SDK Cloud setting fail");
        }
    }

    private void i() {
        try {
            this.f42252k = b1.d(new File(this.f42254m.getDir(this.f42255n, 0), "gdt_suid"));
        } catch (Throwable unused) {
            this.f42252k = null;
            GDTLogger.d("IO Exception while loading suid");
        }
    }

    public Object b(String str) {
        return this.f42250i.a(str);
    }

    public String c(String str) {
        d(str);
        Object a4 = a(str);
        if (a4 == null) {
            return null;
        }
        return a4.toString();
    }

    public void d(String str, String str2) {
        if (i.a(this.f42254m, str, str2)) {
            try {
                a(str, new a(i.a(str2)));
            } catch (UnsupportedEncodingException e4) {
                d1.a(e4.getMessage(), e4);
            }
        }
    }

    public void e(String str) {
        try {
            a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar = new a(i.a(str));
            }
            this.f42242a = aVar;
        } catch (Throwable unused) {
            GDTLogger.d("Exception while update Context Setting");
        }
    }

    public void j() {
        g gVar = this.f42247f;
        if (gVar != null) {
            com.qq.e.comm.plugin.n0.g.a(gVar.a());
        }
        a aVar = this.f42244c;
        if (aVar != null) {
            com.qq.e.comm.plugin.n0.g.a(aVar.a());
        }
    }

    public String b(String str, String str2) {
        d(str);
        Object a4 = a(str);
        return a4 == null ? str2 : a4.toString();
    }

    private void a(String str, a aVar) {
        this.f42243b = str;
        this.f42244c = aVar;
        if (!this.f42256o || aVar == null) {
            return;
        }
        com.qq.e.comm.plugin.n0.g.a(aVar.a());
    }

    public String d() {
        return this.f42253l;
    }

    public void f(String str, String str2) {
        if (i.c(this.f42254m, str, str2)) {
            try {
                a(str, new g(i.a(str2)));
            } catch (UnsupportedEncodingException e4) {
                d1.a(e4.getMessage(), e4);
            }
        }
    }

    public void g(String str) {
        this.f42252k = str;
        b1.c(new File(this.f42254m.getDir(this.f42255n, 0), "gdt_suid"), str);
    }

    public String c(String str, String str2) {
        return a(str, str2, (String) null);
    }

    public String b() {
        return this.f42246e;
    }

    public String c() {
        return this.f42255n;
    }

    public void e(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            i.a(this.f42254m);
            this.f42249h = new f();
        } else if (i.b(this.f42254m, str, str2)) {
            try {
                a(str, new f(i.a(str2)));
            } catch (UnsupportedEncodingException e4) {
                d1.a(e4.getMessage(), e4);
            }
        }
    }

    private void a(String str, f fVar) {
        this.f42249h = fVar;
    }

    public void a(String str, JSONObject jSONObject) {
        d1.a("display config %s", jSONObject);
        if (jSONObject == null) {
            this.f42251j.a((JSONObject) null);
            this.f42250i.a(str, (JSONObject) null);
            return;
        }
        this.f42251j.a(jSONObject.optJSONObject("app"));
        this.f42250i.a(str, jSONObject.optJSONObject("placement"));
    }

    public void f(String str) {
        this.f42253l = str;
    }

    public void a(String str, Object obj) {
        this.f42245d.a(str, obj);
    }

    public String e() {
        return this.f42252k;
    }

    public void a(String str, Object obj, String str2) {
        this.f42245d.a(str, obj, str2);
    }

    public Object a(String str) {
        Object a4;
        Object a5;
        Object a6;
        Object a7;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Object a8 = this.f42251j.a(str);
            if (a8 != null) {
                return a8;
            }
            if (this.f42242a == null || (a7 = this.f42242a.a(str)) == null) {
                if (this.f42244c == null || (a6 = this.f42244c.a(str)) == null) {
                    if (this.f42245d == null || (a5 = this.f42245d.a(str)) == null) {
                        if (this.f42247f == null || (a4 = this.f42247f.a(str)) == null) {
                            if (this.f42248g != null) {
                                return this.f42248g.a(str);
                            }
                            return null;
                        }
                        return a4;
                    }
                    return a5;
                }
                return a6;
            }
            return a7;
        } catch (Throwable unused) {
            GDTLogger.d("Exception in settingManager.get Setting for key");
            return null;
        }
    }

    public Object a(String str, String str2) {
        Object a4;
        Object a5;
        Object a6;
        Object a7;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            return a(str);
        }
        try {
            Object a8 = this.f42250i.a(str, str2);
            return a8 != null ? a8 : (this.f42249h == null || (a7 = this.f42249h.a(str, str2)) == null) ? (this.f42242a == null || (a6 = this.f42242a.a(str, str2)) == null) ? (this.f42244c == null || (a5 = this.f42244c.a(str, str2)) == null) ? (this.f42245d == null || (a4 = this.f42245d.a(str, str2)) == null) ? a(str) : a4 : a5 : a6 : a7;
        } catch (Throwable unused) {
            GDTLogger.d("Exception in settingManager.getForPlacement");
            return null;
        }
    }

    public int a(String str, int i4) {
        d(str);
        Object a4 = a(str);
        return (a4 == null || !(a4 instanceof Integer)) ? i4 : ((Integer) a4).intValue();
    }

    public String a(String str, String str2, String str3) {
        Object a4 = a(str, str2);
        return a4 == null ? str3 : a4.toString();
    }

    public int a(String str, String str2, int i4) {
        Object a4 = a(str, str2);
        return (a4 == null || !(a4 instanceof Integer)) ? i4 : ((Integer) a4).intValue();
    }

    public String a() {
        return this.f42243b;
    }

    public static String a(String str, com.qq.e.comm.plugin.b.g gVar) {
        return str + "_" + gVar.c();
    }
}
