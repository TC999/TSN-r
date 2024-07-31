package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.v */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7308v {

    /* renamed from: h */
    public static JSONObject f25097h = null;

    /* renamed from: i */
    public static final String f25098i = "1";

    /* renamed from: j */
    public static final String f25099j = "2";

    /* renamed from: k */
    public static final String f25100k = "3";

    /* renamed from: l */
    public static final String f25101l = "4";

    /* renamed from: m */
    public static final String f25102m = "5";

    /* renamed from: n */
    public static final String f25103n = "6";

    /* renamed from: o */
    public static final String f25104o = "7";

    /* renamed from: a */
    public int f25105a;

    /* renamed from: b */
    public long f25106b;

    /* renamed from: c */
    public long f25107c;

    /* renamed from: d */
    public String f25108d;

    /* renamed from: e */
    public String f25109e;

    /* renamed from: f */
    public String f25110f;

    /* renamed from: g */
    public int f25111g;

    /* renamed from: p */
    private PackageInfo f25112p;

    /* renamed from: q */
    private ApplicationInfo f25113q;

    /* renamed from: r */
    private Context f25114r;

    public C7308v(PackageInfo packageInfo, Context context) {
        this.f25112p = packageInfo;
        this.f25114r = context;
    }

    /* renamed from: a */
    public int m33744a() {
        return this.f25105a;
    }

    /* renamed from: b */
    public String m33740b() {
        return this.f25109e;
    }

    /* renamed from: c */
    public String m33736c() {
        return this.f25110f;
    }

    /* renamed from: d */
    public long m33734d() {
        return this.f25106b;
    }

    /* renamed from: e */
    public String m33733e() {
        return this.f25108d;
    }

    /* renamed from: f */
    public long m33732f() {
        return this.f25107c;
    }

    /* renamed from: g */
    public int m33731g() {
        return this.f25111g;
    }

    /* renamed from: h */
    public void m33730h() {
        PackageInfo packageInfo = this.f25112p;
        if (packageInfo == null && this.f25113q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.f25113q != null) {
                    this.f25112p = this.f25114r.getPackageManager().getPackageInfo(this.f25113q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.f25112p;
        m33741a(packageInfo2 == null ? this.f25113q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.f25112p;
        m33743a((packageInfo3 == null ? this.f25113q : packageInfo3.applicationInfo).flags & 1);
        m33737b(m33728j());
        PackageInfo packageInfo4 = this.f25112p;
        if (packageInfo4 != null) {
            m33742a(packageInfo4.firstInstallTime);
            m33738b(this.f25112p.lastUpdateTime);
            m33735c(this.f25112p.versionName);
            m33739b(this.f25112p.versionCode);
        }
    }

    /* renamed from: i */
    public void m33729i() {
        PackageInfo packageInfo = this.f25112p;
        if (packageInfo == null && this.f25113q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.f25113q != null) {
                    this.f25112p = this.f25114r.getPackageManager().getPackageInfo(this.f25113q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.f25112p;
        m33741a(packageInfo2 == null ? this.f25113q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.f25112p;
        m33743a((packageInfo3 == null ? this.f25113q : packageInfo3.applicationInfo).flags & 1);
        PackageInfo packageInfo4 = this.f25112p;
        if (packageInfo4 != null) {
            m33742a(packageInfo4.firstInstallTime);
            m33738b(this.f25112p.lastUpdateTime);
            m33735c(this.f25112p.versionName);
            m33739b(this.f25112p.versionCode);
        }
    }

    /* renamed from: j */
    public String m33728j() {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = this.f25112p;
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                String charSequence = applicationInfo.loadLabel(this.f25114r.getPackageManager()).toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    return charSequence;
                }
            } else {
                ApplicationInfo applicationInfo2 = this.f25113q;
                if (applicationInfo2 != null) {
                    String charSequence2 = applicationInfo2.loadLabel(this.f25114r.getPackageManager()).toString();
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

    /* renamed from: k */
    public JSONObject m33727k() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", m33736c());
            jSONObject.put("2", m33740b());
            jSONObject.put("3", m33733e());
            jSONObject.put("4", m33731g());
            jSONObject.put("5", m33744a());
            jSONObject.put("6", m33734d());
            jSONObject.put("7", m33732f());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void m33743a(int i) {
        this.f25105a = i;
    }

    /* renamed from: b */
    public void m33737b(String str) {
        this.f25110f = str;
    }

    /* renamed from: c */
    public void m33735c(String str) {
        this.f25108d = str;
    }

    /* renamed from: a */
    public void m33741a(String str) {
        this.f25109e = str;
    }

    /* renamed from: b */
    public void m33738b(long j) {
        this.f25107c = j;
    }

    public C7308v(ApplicationInfo applicationInfo, Context context) {
        this.f25113q = applicationInfo;
        this.f25114r = context;
    }

    /* renamed from: a */
    public void m33742a(long j) {
        this.f25106b = j;
    }

    /* renamed from: b */
    public void m33739b(int i) {
        this.f25111g = i;
    }
}
