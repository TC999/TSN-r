package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cm {

    /* renamed from: a  reason: collision with root package name */
    private String f38194a;

    /* renamed from: b  reason: collision with root package name */
    private String f38195b;

    /* renamed from: c  reason: collision with root package name */
    private String f38196c;

    /* renamed from: d  reason: collision with root package name */
    private String f38197d;

    /* renamed from: e  reason: collision with root package name */
    private String f38198e;

    /* renamed from: f  reason: collision with root package name */
    private String f38199f;

    /* renamed from: g  reason: collision with root package name */
    private String f38200g;

    /* renamed from: h  reason: collision with root package name */
    private String f38201h;

    /* renamed from: i  reason: collision with root package name */
    private String f38202i;

    /* renamed from: j  reason: collision with root package name */
    private String f38203j;

    /* renamed from: k  reason: collision with root package name */
    private String f38204k;

    /* renamed from: l  reason: collision with root package name */
    private String f38205l;

    public cm(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        this.f38202i = sb.toString();
        this.f38196c = str;
        this.f38200g = str2;
    }

    public static String m() {
        try {
            return !TextUtils.isEmpty(WeaponHI.skProductName) ? WeaponHI.skProductName : "UNKNOWN_PRODUCT";
        } catch (Exception unused) {
            return "UNKNOWN_PRODUCT";
        }
    }

    private JSONObject n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", this.f38194a);
            jSONObject.put("2", this.f38195b);
            jSONObject.put("3", this.f38196c);
            jSONObject.put("4", this.f38197d);
            jSONObject.put("5", this.f38198e);
            jSONObject.put("6", this.f38199f);
            jSONObject.put("7", this.f38200g);
            jSONObject.put("8", this.f38201h);
            jSONObject.put("9", this.f38202i);
            jSONObject.put("11", this.f38203j);
            jSONObject.put("12", this.f38205l);
            jSONObject.put("13", "com.kuaishou.weapon");
            jSONObject.put("14", WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        return this.f38194a;
    }

    public String b() {
        return this.f38195b;
    }

    public String c() {
        return this.f38196c;
    }

    public String d() {
        return this.f38197d;
    }

    public String e() {
        return this.f38198e;
    }

    public String f() {
        return this.f38199f;
    }

    public String g() {
        return this.f38200g;
    }

    public String h() {
        return this.f38201h;
    }

    public String i() {
        return this.f38202i;
    }

    public String j() {
        return this.f38203j;
    }

    public String k() {
        return this.f38204k;
    }

    public String l() {
        return this.f38205l;
    }

    public void a(String str) {
        this.f38194a = str;
    }

    public void b(String str) {
        this.f38195b = str;
    }

    public void c(String str) {
        this.f38196c = str;
    }

    public void d(String str) {
        this.f38197d = str;
    }

    public void e(String str) {
        this.f38198e = str;
    }

    public void f(String str) {
        this.f38199f = str;
    }

    public void g(String str) {
        this.f38200g = str;
    }

    public void h(String str) {
        this.f38201h = str;
    }

    public void i(String str) {
        this.f38202i = str;
    }

    public void j(String str) {
        this.f38203j = str;
    }

    public void k(String str) {
        this.f38204k = str;
    }

    public void l(String str) {
        this.f38205l = str;
    }

    public static String b(Context context) {
        try {
            String str = WeaponHI.sKDeviceId;
            if (!TextUtils.isEmpty(str)) {
                bi.f38086v = 1;
                return str;
            }
        } catch (Exception unused) {
        }
        try {
            h a4 = h.a(context, "re_po_rt");
            boolean e4 = a4.e("a1_p_s_p_s");
            boolean e5 = a4.e("a1_p_s_p_s_c_b");
            if (e4 || e5) {
                String str2 = "ANDROID_" + Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(str2)) {
                    bi.f38086v = 3;
                    return str2;
                }
            }
        } catch (Exception unused2) {
        }
        bi.f38086v = 4;
        return "";
    }

    public JSONObject a(Context context) {
        try {
            a(b(context));
            b(m());
            d(bh.q(context));
            e(bh.r(context));
            f(bh.s(context));
            h("5.3.0");
            j(bt.a(context));
            l(WeaponHI.sKSAppkey);
            return n();
        } catch (Throwable unused) {
            return null;
        }
    }
}
