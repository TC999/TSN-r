package com.qq.e.comm.plugin.apkmanager;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class ApkDownloadTask implements Parcelable {
    public static final Parcelable.Creator<ApkDownloadTask> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private int f41735c;

    /* renamed from: d  reason: collision with root package name */
    private final int f41736d;

    /* renamed from: e  reason: collision with root package name */
    private int f41737e;

    /* renamed from: f  reason: collision with root package name */
    private String f41738f;

    /* renamed from: g  reason: collision with root package name */
    private int f41739g;

    /* renamed from: h  reason: collision with root package name */
    private String f41740h;

    /* renamed from: i  reason: collision with root package name */
    private String f41741i;

    /* renamed from: j  reason: collision with root package name */
    private final String f41742j;

    /* renamed from: k  reason: collision with root package name */
    private final String f41743k;

    /* renamed from: l  reason: collision with root package name */
    private final String f41744l;

    /* renamed from: m  reason: collision with root package name */
    private final String f41745m;

    /* renamed from: n  reason: collision with root package name */
    private final String f41746n;

    /* renamed from: o  reason: collision with root package name */
    private final String f41747o;

    /* renamed from: p  reason: collision with root package name */
    private final String f41748p;

    /* renamed from: q  reason: collision with root package name */
    private final String f41749q;

    /* renamed from: r  reason: collision with root package name */
    private final long f41750r;

    /* renamed from: s  reason: collision with root package name */
    private int f41751s;

    /* renamed from: t  reason: collision with root package name */
    private final Bundle f41752t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f41753u;

    /* renamed from: v  reason: collision with root package name */
    private transient Bitmap f41754v;

    /* renamed from: w  reason: collision with root package name */
    private JSONObject f41755w;

    /* renamed from: x  reason: collision with root package name */
    private String f41756x;

    /* renamed from: y  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f41757y;

    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements Parcelable.Creator<ApkDownloadTask> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApkDownloadTask createFromParcel(Parcel parcel) {
            return new ApkDownloadTask(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApkDownloadTask[] newArray(int i4) {
            return new ApkDownloadTask[i4];
        }
    }

    /* synthetic */ ApkDownloadTask(Parcel parcel, a aVar) {
        this(parcel);
    }

    private Bundle n() {
        return this.f41752t;
    }

    public void a(boolean z3) {
        this.f41753u = z3;
    }

    public int b() {
        return this.f41739g;
    }

    public String c() {
        return this.f41743k;
    }

    public int d() {
        return this.f41736d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f41750r;
    }

    public void f(String str) {
        a("failReason", str);
    }

    public String g() {
        return this.f41746n;
    }

    public String h() {
        return this.f41756x;
    }

    public int i() {
        return this.f41751s;
    }

    public Bitmap j() {
        return this.f41754v;
    }

    public String k() {
        return this.f41744l;
    }

    public JSONObject l() {
        String d4 = d("launchParam");
        try {
            if (TextUtils.isEmpty(d4)) {
                return null;
            }
            return new JSONObject(d4);
        } catch (JSONException e4) {
            d1.a("JSON Parse launchParam Error,launchParam : " + d4, e4);
            return null;
        }
    }

    public String m() {
        return this.f41740h;
    }

    public int o() {
        return this.f41737e;
    }

    public String p() {
        return this.f41748p;
    }

    public String q() {
        return this.f41742j;
    }

    public String r() {
        return this.f41749q;
    }

    public String s() {
        return this.f41747o;
    }

    public int t() {
        return this.f41735c;
    }

    public String toString() {
        return "ApkDownloadTask{taskId=" + this.f41735c + ", createNetType=" + this.f41736d + ", status=" + this.f41737e + ", targetAppName='" + this.f41748p + "', targetPkgName='" + this.f41749q + "', createTime=" + this.f41750r + ", isReturned=" + this.f41753u + '}';
    }

    public String u() {
        return this.f41745m;
    }

    public com.qq.e.comm.plugin.g0.e v() {
        return this.f41757y;
    }

    public String w() {
        return this.f41741i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(a());
        parcel.writeInt(b());
        parcel.writeString(m());
        parcel.writeString(w());
        parcel.writeString(q());
        parcel.writeString(c());
        parcel.writeString(k());
        parcel.writeString(s());
        parcel.writeString(p());
        parcel.writeString(r());
        parcel.writeBundle(n());
        parcel.writeInt(d());
        parcel.writeLong(e());
        parcel.writeInt(o());
        parcel.writeString(u());
        parcel.writeString(g());
        parcel.writeInt(t());
        parcel.writeInt(i());
    }

    public boolean x() {
        return (this.f41751s & 1) != 0;
    }

    public boolean y() {
        return this.f41753u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle z() {
        Bundle bundle = new Bundle();
        bundle.putString("adId", this.f41738f);
        bundle.putInt("adType", this.f41739g);
        bundle.putString("posId", this.f41740h);
        bundle.putString("traceId", this.f41741i);
        bundle.putInt("taskId", this.f41735c);
        bundle.putString("targetId", this.f41742j);
        bundle.putString("clickId", this.f41743k);
        bundle.putString("iconUrl", this.f41744l);
        bundle.putString("targetUrl", this.f41747o);
        bundle.putString("targetAppName", this.f41748p);
        bundle.putString("targetPkgName", this.f41749q);
        bundle.putInt("createNetType", this.f41736d);
        bundle.putLong("createTime", this.f41750r);
        bundle.putInt("status", this.f41737e);
        bundle.putInt("flag", this.f41751s);
        bundle.putBundle("property", this.f41752t);
        bundle.putString("title", this.f41745m);
        bundle.putString("desc", this.f41746n);
        return bundle;
    }

    public ApkDownloadTask(String str) {
        this(null, 0, null, null, null, null, null, null, null, str, null, 0, System.currentTimeMillis(), 0, null, null);
    }

    public String a() {
        return this.f41738f;
    }

    public void b(int i4) {
        this.f41751s = i4;
    }

    public void c(int i4) {
        this.f41737e = i4;
    }

    public void d(int i4) {
        this.f41735c = i4;
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f41756x = str;
            a("extra", str);
            this.f41755w = new j0(str).a();
        }
        this.f41757y = com.qq.e.comm.plugin.g0.j0.a(this.f41738f, this.f41740h, this.f41739g, this.f41741i, this.f41755w);
    }

    public String f() {
        JSONObject l4 = l();
        if (l4 != null) {
            return l4.optString("customized_invoke_url");
        }
        return null;
    }

    public ApkDownloadTask(String str, com.qq.e.comm.plugin.g0.e eVar) {
        this(str);
        a(eVar);
    }

    public void a(int i4) {
        this.f41751s = i4 | this.f41751s;
    }

    public int b(String str) {
        return this.f41752t.getInt(str);
    }

    public long c(String str) {
        return this.f41752t.getLong(str);
    }

    public String d(String str) {
        return this.f41752t.getString(str);
    }

    public boolean a(String str) {
        return this.f41752t.getBoolean(str);
    }

    public ApkDownloadTask(com.qq.e.comm.plugin.g0.e eVar, String str, String str2, String str3, String str4, String str5, int i4) {
        this(eVar.k(), eVar.o().c(), eVar.q0(), eVar.K(), eVar.s0(), str, str2, str3, str4, str5, new Bundle(), i4, System.currentTimeMillis(), 0, eVar.J0(), eVar.F());
        a(eVar);
    }

    public void a(String str, int i4) {
        this.f41752t.putInt(str, i4);
    }

    public void a(String str, long j4) {
        this.f41752t.putLong(str, j4);
    }

    public void a(String str, boolean z3) {
        this.f41752t.putBoolean(str, z3);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f41752t.putString(str, str2);
    }

    public ApkDownloadTask a(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return this;
        }
        this.f41738f = eVar.k();
        this.f41740h = eVar.q0();
        this.f41741i = eVar.K();
        this.f41739g = eVar.o().c();
        com.qq.e.comm.plugin.g0.b q3 = eVar.q();
        if (q3 != null) {
            a("pkg_size", q3.f());
        }
        this.f41757y = eVar;
        JSONObject a4 = com.qq.e.comm.plugin.g0.j0.a(eVar);
        this.f41755w = a4;
        String jSONObject = a4.toString();
        this.f41756x = jSONObject;
        a("extra", jSONObject);
        return this;
    }

    public ApkDownloadTask(String str, int i4, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Bundle bundle, int i5, long j4, int i6, String str10, String str11) {
        this.f41751s = 0;
        this.f41738f = str;
        this.f41739g = i4;
        this.f41740h = str2;
        this.f41741i = str3;
        this.f41742j = str4;
        this.f41743k = str5;
        this.f41744l = str6;
        this.f41747o = str7;
        this.f41748p = str8;
        this.f41749q = str9;
        this.f41736d = i5;
        this.f41737e = i6;
        this.f41750r = j4;
        this.f41745m = str10;
        this.f41746n = str11;
        this.f41752t = bundle == null ? new Bundle() : bundle;
        a("notifyId", 0);
        a("notifyTag", "GDT_DOWNLOAD_NOTIFY_TAG_" + r());
        a("autoInstall", true);
        e(this.f41752t.getString("extra"));
    }

    public void a(Bitmap bitmap) {
        this.f41754v = bitmap;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            a("launchParam", jSONObject.toString());
        }
    }

    public void a(String str, JSONObject jSONObject, boolean z3) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("customized_invoke_url", str);
            jSONObject2.put("reportUrl", jSONObject);
            jSONObject2.put("autoInstall", z3);
        } catch (JSONException unused) {
        }
        a("launchParam", jSONObject2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ApkDownloadTask a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new ApkDownloadTask(bundle);
    }

    private ApkDownloadTask(Bundle bundle) {
        this(bundle.getString("adId"), bundle.getInt("adType"), bundle.getString("posId"), bundle.getString("traceId"), bundle.getString("targetId"), bundle.getString("clickId"), bundle.getString("iconUrl"), bundle.getString("targetUrl"), bundle.getString("targetAppName"), bundle.getString("targetPkgName"), bundle.getBundle("property"), bundle.getInt("createNetType"), bundle.getLong("createTime"), bundle.getInt("status"), bundle.getString("title"), bundle.getString("desc"));
        d(bundle.getInt("taskId"));
        b(bundle.getInt("flag"));
    }

    private ApkDownloadTask(Parcel parcel) {
        this(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readBundle(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readString());
        d(parcel.readInt());
        b(parcel.readInt());
    }
}
