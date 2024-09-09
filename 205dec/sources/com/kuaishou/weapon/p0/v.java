package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class v {

    /* renamed from: h  reason: collision with root package name */
    public static JSONObject f38488h = null;

    /* renamed from: i  reason: collision with root package name */
    public static final String f38489i = "1";

    /* renamed from: j  reason: collision with root package name */
    public static final String f38490j = "2";

    /* renamed from: k  reason: collision with root package name */
    public static final String f38491k = "3";

    /* renamed from: l  reason: collision with root package name */
    public static final String f38492l = "4";

    /* renamed from: m  reason: collision with root package name */
    public static final String f38493m = "5";

    /* renamed from: n  reason: collision with root package name */
    public static final String f38494n = "6";

    /* renamed from: o  reason: collision with root package name */
    public static final String f38495o = "7";

    /* renamed from: a  reason: collision with root package name */
    public int f38496a;

    /* renamed from: b  reason: collision with root package name */
    public long f38497b;

    /* renamed from: c  reason: collision with root package name */
    public long f38498c;

    /* renamed from: d  reason: collision with root package name */
    public String f38499d;

    /* renamed from: e  reason: collision with root package name */
    public String f38500e;

    /* renamed from: f  reason: collision with root package name */
    public String f38501f;

    /* renamed from: g  reason: collision with root package name */
    public int f38502g;

    /* renamed from: p  reason: collision with root package name */
    private PackageInfo f38503p;

    /* renamed from: q  reason: collision with root package name */
    private ApplicationInfo f38504q;

    /* renamed from: r  reason: collision with root package name */
    private Context f38505r;

    public v(PackageInfo packageInfo, Context context) {
        this.f38503p = packageInfo;
        this.f38505r = context;
    }

    public int a() {
        return this.f38496a;
    }

    public String b() {
        return this.f38500e;
    }

    public String c() {
        return this.f38501f;
    }

    public long d() {
        return this.f38497b;
    }

    public String e() {
        return this.f38499d;
    }

    public long f() {
        return this.f38498c;
    }

    public int g() {
        return this.f38502g;
    }

    public void h() {
        PackageInfo packageInfo = this.f38503p;
        if (packageInfo == null && this.f38504q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.f38504q != null) {
                    this.f38503p = this.f38505r.getPackageManager().getPackageInfo(this.f38504q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.f38503p;
        a(packageInfo2 == null ? this.f38504q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.f38503p;
        a((packageInfo3 == null ? this.f38504q : packageInfo3.applicationInfo).flags & 1);
        b(j());
        PackageInfo packageInfo4 = this.f38503p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.f38503p.lastUpdateTime);
            c(this.f38503p.versionName);
            b(this.f38503p.versionCode);
        }
    }

    public void i() {
        PackageInfo packageInfo = this.f38503p;
        if (packageInfo == null && this.f38504q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.f38504q != null) {
                    this.f38503p = this.f38505r.getPackageManager().getPackageInfo(this.f38504q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.f38503p;
        a(packageInfo2 == null ? this.f38504q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.f38503p;
        a((packageInfo3 == null ? this.f38504q : packageInfo3.applicationInfo).flags & 1);
        PackageInfo packageInfo4 = this.f38503p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.f38503p.lastUpdateTime);
            c(this.f38503p.versionName);
            b(this.f38503p.versionCode);
        }
    }

    public String j() {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = this.f38503p;
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                String charSequence = applicationInfo.loadLabel(this.f38505r.getPackageManager()).toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    return charSequence;
                }
            } else {
                ApplicationInfo applicationInfo2 = this.f38504q;
                if (applicationInfo2 != null) {
                    String charSequence2 = applicationInfo2.loadLabel(this.f38505r.getPackageManager()).toString();
                    if (!TextUtils.isEmpty(charSequence2)) {
                        return charSequence2;
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public JSONObject k() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", c());
            jSONObject.put("2", b());
            jSONObject.put("3", e());
            jSONObject.put("4", g());
            jSONObject.put("5", a());
            jSONObject.put("6", d());
            jSONObject.put("7", f());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(int i4) {
        this.f38496a = i4;
    }

    public void b(String str) {
        this.f38501f = str;
    }

    public void c(String str) {
        this.f38499d = str;
    }

    public void a(String str) {
        this.f38500e = str;
    }

    public void b(long j4) {
        this.f38498c = j4;
    }

    public v(ApplicationInfo applicationInfo, Context context) {
        this.f38504q = applicationInfo;
        this.f38505r = context;
    }

    public void a(long j4) {
        this.f38497b = j4;
    }

    public void b(int i4) {
        this.f38502g = i4;
    }
}
