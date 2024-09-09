package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12271a = "none";

    /* renamed from: b  reason: collision with root package name */
    public static final String f12272b = "text";

    /* renamed from: c  reason: collision with root package name */
    public static final String f12273c = "static_image";

    /* renamed from: d  reason: collision with root package name */
    public static final String f12274d = "gif";

    /* renamed from: e  reason: collision with root package name */
    public static final String f12275e = "rich_media";

    /* renamed from: f  reason: collision with root package name */
    public static final String f12276f = "html";

    /* renamed from: g  reason: collision with root package name */
    public static final String f12277g = "hybrid";

    /* renamed from: h  reason: collision with root package name */
    public static final String f12278h = "video";

    /* renamed from: i  reason: collision with root package name */
    private static final long f12279i = 1750000;
    private String A;
    private String B;
    private String C;
    private int D;
    private String E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;

    /* renamed from: L  reason: collision with root package name */
    private String f12280L;
    private List<String> N;
    private JSONObject O;
    private long P;
    private long Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private JSONObject Y;
    private int Z;
    private int aa;
    private int ab;
    private List<String> ac;
    private String ae;
    private String af;
    private JSONObject ag;
    private JSONObject ah;

    /* renamed from: j  reason: collision with root package name */
    private String f12281j;

    /* renamed from: k  reason: collision with root package name */
    private String f12282k;

    /* renamed from: l  reason: collision with root package name */
    private String f12283l;

    /* renamed from: m  reason: collision with root package name */
    private String f12284m;

    /* renamed from: n  reason: collision with root package name */
    private int f12285n;

    /* renamed from: o  reason: collision with root package name */
    private int f12286o;

    /* renamed from: p  reason: collision with root package name */
    private String f12287p;

    /* renamed from: q  reason: collision with root package name */
    private long f12288q;

    /* renamed from: r  reason: collision with root package name */
    private int f12289r;

    /* renamed from: t  reason: collision with root package name */
    private String f12291t;

    /* renamed from: u  reason: collision with root package name */
    private String f12292u;

    /* renamed from: v  reason: collision with root package name */
    private String f12293v;

    /* renamed from: w  reason: collision with root package name */
    private String f12294w;

    /* renamed from: x  reason: collision with root package name */
    private String f12295x;

    /* renamed from: y  reason: collision with root package name */
    private String f12296y;

    /* renamed from: z  reason: collision with root package name */
    private String f12297z;

    /* renamed from: s  reason: collision with root package name */
    private int f12290s = 1;
    private String M = "none";
    private int ad = 0;

    /* JADX WARN: Removed duplicated region for block: B:43:0x0148 A[Catch: all -> 0x0177, JSONException -> 0x017c, TryCatch #4 {JSONException -> 0x017c, all -> 0x0177, blocks: (B:5:0x007e, B:8:0x0090, B:10:0x00a1, B:11:0x00b8, B:13:0x00c4, B:15:0x00cf, B:17:0x00d5, B:18:0x00d7, B:20:0x00dd, B:22:0x00e3, B:24:0x00eb, B:28:0x00f4, B:30:0x00fe, B:31:0x011b, B:33:0x0121, B:34:0x0127, B:36:0x012f, B:38:0x0135, B:40:0x013f, B:43:0x0148, B:45:0x0156, B:47:0x015d, B:48:0x0165, B:50:0x016b), top: B:109:0x007e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.mobads.sdk.internal.a a(org.json.JSONObject r17) {
        /*
            Method dump skipped, instructions count: 839
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.a.a(org.json.JSONObject):com.baidu.mobads.sdk.internal.a");
    }

    public static boolean a(int i4) {
        return (i4 < 28 || 31 == i4 || 32 == i4 || 38 == i4 || 39 == i4 || 40 == i4 || 42 < i4) ? false : true;
    }

    public String A() {
        return this.f12297z;
    }

    public String B() {
        return this.f12296y;
    }

    public String C() {
        return this.A;
    }

    public String D() {
        return this.B;
    }

    public String E() {
        return this.C;
    }

    public long F() {
        return this.Q;
    }

    public List<String> G() {
        return this.N;
    }

    public String H() {
        return this.R;
    }

    public JSONObject I() {
        return this.O;
    }

    public String J() {
        return this.U;
    }

    public String K() {
        return this.V;
    }

    public String L() {
        return this.W;
    }

    public String M() {
        String str = this.X;
        return (str == null || str.length() <= 4) ? this.X : "";
    }

    public int N() {
        return this.ab;
    }

    public List<String> O() {
        return this.ac;
    }

    public JSONObject P() {
        return this.Y;
    }

    public int Q() {
        return this.Z;
    }

    public int R() {
        return this.aa;
    }

    public int S() {
        return this.ad;
    }

    public JSONObject T() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.R);
            jSONObject.put("tit", this.f12281j);
            jSONObject.put("desc", this.f12282k);
            jSONObject.put("pk", this.f12293v);
            jSONObject.put("appname", this.f12287p);
            jSONObject.put("act", this.D);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String U() {
        return this.ae;
    }

    public String V() {
        if (TextUtils.isEmpty(this.af)) {
            return "";
        }
        try {
            long parseLong = Long.parseLong(this.af);
            int length = this.af.length();
            return (parseLong <= 100000 || length <= 5) ? "" : this.af.substring(length - 4, length);
        } catch (Throwable th) {
            az.b(th);
            return "";
        }
    }

    public String b() {
        return this.f12282k;
    }

    public String c() {
        return this.f12283l;
    }

    public String d() {
        return this.f12284m;
    }

    public int e() {
        return this.f12285n;
    }

    public int f() {
        return this.f12286o;
    }

    public String g() {
        return this.f12287p;
    }

    public String h() {
        return this.S;
    }

    public String i() {
        return this.T;
    }

    public long j() {
        return this.f12288q;
    }

    public int k() {
        return this.f12289r;
    }

    public int l() {
        return this.f12290s;
    }

    public String m() {
        return this.f12293v;
    }

    public String n() {
        return this.f12294w;
    }

    public String o() {
        return this.f12295x;
    }

    public int p() {
        return this.D;
    }

    public String q() {
        return this.E;
    }

    public int r() {
        return this.F;
    }

    public int s() {
        return this.G;
    }

    public int t() {
        return this.H;
    }

    public int u() {
        return this.I;
    }

    public int v() {
        return this.J;
    }

    public int w() {
        return this.K;
    }

    public String x() {
        return this.M;
    }

    public long y() {
        return this.P;
    }

    public String z() {
        if (!TextUtils.isEmpty(this.f12292u)) {
            return this.f12292u;
        }
        return this.f12291t;
    }

    public String a(String str) {
        if (this.ag == null) {
            return null;
        }
        JSONObject jSONObject = this.ah;
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("apo") : null;
        String optString = this.ag.optString(str);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        if (TextUtils.equals(optString, "fallback") && optJSONObject != null) {
            return optJSONObject.optString("fallback");
        }
        if (TextUtils.equals(optString, "page") && optJSONObject != null) {
            return optJSONObject.optString("page");
        }
        JSONObject jSONObject2 = this.ah;
        if (jSONObject2 != null) {
            return jSONObject2.optString(optString);
        }
        return null;
    }

    public static List<a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i4)));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static int a(JSONObject jSONObject, int i4, int i5) {
        String[] split;
        int i6 = 0;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("st_op");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("tp_id");
                    if (!TextUtils.isEmpty(optString) && optString.startsWith("opt_style_") && (split = optString.substring(10).split("_")) != null && split.length > 0) {
                        i6 = Integer.parseInt(split[0]);
                    }
                }
            } catch (Throwable th) {
                bv.a().d(th.getMessage());
            }
        }
        if (a(i6)) {
            i4 = i6;
        } else if (!a(i4)) {
            i4 = i5;
        }
        if (i4 == 42) {
            return 41;
        }
        return i4;
    }

    public String a() {
        return this.f12281j;
    }
}
