package cn.jiguang.bg;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2629a = cn.jiguang.bh.a.b(new byte[]{120, 122, 100, 87, 73, 119, 65, 114});

    /* renamed from: b  reason: collision with root package name */
    public static final String f2630b = cn.jiguang.bh.a.b(new byte[]{97, 92, 85, 126, 97, 120, 95, 81, 77, 124});

    /* renamed from: c  reason: collision with root package name */
    public static final String f2631c = cn.jiguang.bh.a.b(new byte[]{111, 109, 100, 98, 89, 79, 119});

    /* renamed from: d  reason: collision with root package name */
    public static final String f2632d = cn.jiguang.bh.a.b(new byte[]{70, 69, 107, 123, Byte.MAX_VALUE, 126, 94, 110, 120, 101, 115});

    /* renamed from: e  reason: collision with root package name */
    public static final String f2633e = cn.jiguang.bh.a.b(new byte[]{123, 117, 5});

    /* renamed from: f  reason: collision with root package name */
    public static final String f2634f = cn.jiguang.bh.a.b(new byte[]{84, 79, 110, 102, 122, 126, 81, 68, 76, 122, 122});

    /* renamed from: g  reason: collision with root package name */
    public static final String f2635g = cn.jiguang.bh.a.b(new byte[]{110, Byte.MAX_VALUE, 125, 85, 110, 120, 101, 115});

    /* renamed from: h  reason: collision with root package name */
    public static final String f2636h = cn.jiguang.bh.a.b(new byte[]{110, Byte.MAX_VALUE, 125, 85, 115, 112, 114, 115});

    /* renamed from: i  reason: collision with root package name */
    public static final String f2637i = cn.jiguang.bh.a.b(new byte[]{117, 85, 83, 122});

    /* renamed from: j  reason: collision with root package name */
    public static final String f2638j = cn.jiguang.bh.a.b(new byte[]{83, 109, 105, 98, 100, 67});

    /* renamed from: k  reason: collision with root package name */
    public static final String f2639k = cn.jiguang.bh.a.b(new byte[]{82, 124, 120, 121, 99, 68, 115, 110, 97, 98, 114, 88});

    /* renamed from: l  reason: collision with root package name */
    public static final String f2640l = cn.jiguang.bh.a.b(new byte[]{93, 85, 117, 124, 111, 66, 71, 73, 109, 107, 126});

    /* renamed from: o  reason: collision with root package name */
    public int f2643o;

    /* renamed from: q  reason: collision with root package name */
    public int f2645q;

    /* renamed from: v  reason: collision with root package name */
    public int f2650v;

    /* renamed from: x  reason: collision with root package name */
    public String f2652x;

    /* renamed from: m  reason: collision with root package name */
    public int f2641m = 0;

    /* renamed from: n  reason: collision with root package name */
    public String f2642n = "";

    /* renamed from: p  reason: collision with root package name */
    public String f2644p = "";

    /* renamed from: r  reason: collision with root package name */
    public String f2646r = "";

    /* renamed from: s  reason: collision with root package name */
    public String f2647s = "";

    /* renamed from: t  reason: collision with root package name */
    public String f2648t = "";

    /* renamed from: u  reason: collision with root package name */
    public String f2649u = "";

    /* renamed from: w  reason: collision with root package name */
    public String f2651w = "";

    /* renamed from: y  reason: collision with root package name */
    public boolean f2653y = false;

    /* renamed from: z  reason: collision with root package name */
    public boolean f2654z = false;

    public c(String str) {
        this.f2652x = str;
    }

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.bi.b.e("pif", "p i is empty.");
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            cn.jiguang.bi.b.g("pif", "p j i is empty.");
            return null;
        }
        c cVar = new c(jSONObject.toString());
        cVar.f2641m = jSONObject.optInt(f2629a);
        cVar.f2642n = jSONObject.optString(f2630b);
        cVar.f2649u = jSONObject.optString(f2635g);
        cVar.f2647s = jSONObject.optString(f2633e);
        cVar.f2643o = jSONObject.optInt(f2631c, 0);
        cVar.f2644p = jSONObject.optString(f2632d, "");
        cVar.f2645q = jSONObject.optInt(f2638j);
        cVar.f2646r = jSONObject.optString(f2634f);
        cVar.f2648t = jSONObject.optString(f2637i);
        cVar.f2650v = jSONObject.optInt(f2636h);
        cVar.f2653y = jSONObject.optBoolean(f2639k);
        cVar.f2654z = jSONObject.optBoolean(f2640l);
        return cVar;
    }

    public String toString() {
        return "P{pid=" + this.f2641m + ", pName='" + this.f2642n + "', vcode=" + this.f2643o + ", vname='" + this.f2644p + "', status=" + this.f2645q + ", dU='" + this.f2646r + "', m='" + this.f2647s + "', desc='" + this.f2648t + "', fileName='" + this.f2649u + "', fileSize=" + this.f2650v + ", pkgname='" + this.f2651w + "', reportSwitch='" + this.f2653y + "', multySwitch='" + this.f2654z + "'}";
    }
}
