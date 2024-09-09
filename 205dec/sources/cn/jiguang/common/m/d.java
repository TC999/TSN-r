package cn.jiguang.common.m;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f3495a;

    /* renamed from: b  reason: collision with root package name */
    public String f3496b;

    /* renamed from: c  reason: collision with root package name */
    public String f3497c;

    /* renamed from: d  reason: collision with root package name */
    public int f3498d;

    /* renamed from: e  reason: collision with root package name */
    public int f3499e;

    /* renamed from: f  reason: collision with root package name */
    public int f3500f;

    /* renamed from: g  reason: collision with root package name */
    public String f3501g;

    /* renamed from: h  reason: collision with root package name */
    public String f3502h;

    /* renamed from: i  reason: collision with root package name */
    public String f3503i;

    /* renamed from: j  reason: collision with root package name */
    public long f3504j;

    /* renamed from: k  reason: collision with root package name */
    public long f3505k;

    /* renamed from: l  reason: collision with root package name */
    public String[] f3506l;

    private static CharSequence a(CharSequence charSequence, int i4) {
        return (i4 < 0 || i4 >= charSequence.length()) ? charSequence : charSequence.subSequence(0, i4);
    }

    public JSONObject a(int i4) {
        try {
            return new JSONObject().put("name", this.f3495a).put("pkg", a(this.f3496b, i4)).put("ver_name", this.f3497c).put("ver_code", this.f3498d).put("install_type", this.f3499e).put("install_time", this.f3504j).put("update_time", this.f3505k).put("sign_md5", this.f3501g).put("sign_sha1", this.f3502h).put("sign_sha256", this.f3503i);
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject b(int i4) {
        try {
            return new JSONObject().put("name", this.f3495a).put("pkg", a(this.f3496b, i4)).put("ver_name", this.f3497c).put("ver_code", this.f3498d).put("pers", Arrays.toString(this.f3506l));
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject c(int i4) {
        try {
            return new JSONObject().put("name", this.f3495a).put("pkg", a(this.f3496b, i4)).put("ver_name", this.f3497c).put("ver_code", this.f3498d).put("install_type", this.f3499e).put("install_time", this.f3504j).put("update_time", this.f3505k);
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject d(int i4) {
        try {
            return new JSONObject().put("pkg", a(this.f3496b, i4)).put("ver_name", this.f3497c).put("third_sdk", this.f3500f);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f3498d != dVar.f3498d) {
            return false;
        }
        String str = this.f3496b;
        String str2 = dVar.f3496b;
        return str != null ? str.equals(str2) : str2 == null;
    }
}
