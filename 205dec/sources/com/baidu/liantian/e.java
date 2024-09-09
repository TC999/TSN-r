package com.baidu.liantian;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.liantian.ac.F;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Preferences.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f12228a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f12229b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f12230c;

    /* renamed from: d  reason: collision with root package name */
    public SharedPreferences.Editor f12231d;

    /* renamed from: e  reason: collision with root package name */
    public SharedPreferences f12232e;

    /* renamed from: f  reason: collision with root package name */
    public SharedPreferences.Editor f12233f;

    /* renamed from: g  reason: collision with root package name */
    private Context f12234g;

    public e(Context context) {
        try {
            this.f12234g = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadliantiancfg", 4);
            this.f12228a = sharedPreferences;
            this.f12230c = sharedPreferences.edit();
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("leroadcfg", 4);
            this.f12229b = sharedPreferences2;
            this.f12231d = sharedPreferences2.edit();
            SharedPreferences sharedPreferences3 = context.getSharedPreferences("reliantian_po_rt", 4);
            this.f12232e = sharedPreferences3;
            this.f12233f = sharedPreferences3.edit();
        } catch (Throwable th) {
            th.getMessage();
            b.b();
        }
    }

    public final void a(long j4) {
        this.f12230c.putLong("npuct", j4);
        this.f12230c.commit();
    }

    public final String b() {
        return this.f12228a.getString("svi_n", "");
    }

    public final String c() {
        return this.f12228a.getString("ses_ic", "");
    }

    public final boolean d() {
        return this.f12228a.getBoolean("bka", true);
    }

    public final String e() {
        try {
            String str = new String(F.getInstance().ad(Base64.decode(this.f12228a.getString("lsl", ""), 0), Base64.decode("MzAyMTIxMDJkaWN1ZGlhYg==", 0)));
            b.a();
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public final long f() {
        return this.f12228a.getLong("lslt", 0L);
    }

    public final void g() {
        this.f12230c.putLong("pu_ap_fd", System.currentTimeMillis());
        this.f12230c.commit();
    }

    public final int h() {
        return this.f12228a.getInt("wi_fa_pu_ap", 0);
    }

    public final int i() {
        return this.f12228a.getInt("mo_fa_pu_ap", 0);
    }

    public final void j() {
        this.f12230c.putLong("pu_cl_fd", System.currentTimeMillis());
        this.f12230c.commit();
    }

    public final void k() {
        this.f12230c.putLong("se_ae_fd", System.currentTimeMillis());
        this.f12230c.commit();
    }

    public final int l() {
        return this.f12228a.getInt("wi_fa_pu_cl", 0);
    }

    public final int m() {
        return this.f12228a.getInt("mo_fa_pu_cl", 0);
    }

    public final int n() {
        return this.f12228a.getInt("mo_ae_fa_ct", 0);
    }

    public final boolean o() {
        return this.f12228a.getBoolean("hac", false);
    }

    public final List<Integer> p() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.f12228a.getString("hcpk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e4) {
                    e4.getMessage();
                    b.b();
                }
            }
        }
        return arrayList;
    }

    public final List<Integer> q() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.f12228a.getString("glspk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e4) {
                    e4.getMessage();
                    b.b();
                }
            }
        }
        return arrayList;
    }

    public final int r() {
        return this.f12228a.getInt("rtqe", 0);
    }

    public final void s() {
        this.f12230c.putBoolean("lpcf", true);
        this.f12230c.commit();
    }

    public final int t() {
        return this.f12228a.getInt("pdcg", 0);
    }

    public final int u() {
        return this.f12228a.getInt("sustfd", 0);
    }

    public final int v() {
        return this.f12228a.getInt("sufzfd", 0);
    }

    public final List<com.baidu.liantian.rp.a.a> w() {
        String[] split;
        com.baidu.liantian.rp.a.a a4;
        String string = this.f12232e.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : string.split("\\|\\|")) {
            if (!TextUtils.isEmpty(str) && (a4 = com.baidu.liantian.rp.a.a.a(str)) != null) {
                arrayList.add(a4);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r0 < 24) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int x() {
        /*
            r5 = this;
            android.content.Context r0 = r5.f12234g
            java.lang.String r0 = r0.getPackageName()
            java.lang.String r1 = "com.baidu.BaiduMap.meizu"
            boolean r0 = r1.equals(r0)
            java.lang.String r1 = "re_net_hr"
            r2 = 24
            if (r0 == 0) goto L19
            android.content.SharedPreferences r0 = r5.f12232e
            int r0 = r0.getInt(r1, r2)
            return r0
        L19:
            android.content.SharedPreferences r0 = r5.f12232e
            r3 = 3
            int r0 = r0.getInt(r1, r3)
            android.content.Context r1 = r5.f12234g     // Catch: java.lang.Throwable -> L5b
            java.lang.String[] r1 = com.baidu.liantian.b.e.g(r1)     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L59
            int r3 = r1.length     // Catch: java.lang.Throwable -> L5b
            r4 = 2
            if (r3 != r4) goto L59
            r3 = 0
            r4 = r1[r3]     // Catch: java.lang.Throwable -> L5b
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L5b
            if (r4 != 0) goto L59
            r4 = 1
            r4 = r1[r4]     // Catch: java.lang.Throwable -> L5b
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L5b
            if (r4 != 0) goto L59
            java.lang.String r4 = "200080"
            r1 = r1[r3]     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r4.equals(r1)     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L59
            java.lang.String r1 = "com.baidu.BaiduMap"
            android.content.Context r3 = r5.f12234g     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L59
            if (r0 >= r2) goto L59
            goto L5a
        L59:
            r2 = r0
        L5a:
            r0 = r2
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.e.x():int");
    }

    public final int y() {
        return this.f12232e.getInt("up_nu_li", 100);
    }

    public final void b(int i4) {
        this.f12230c.putInt("mo_fa_pu_ap", i4);
        this.f12230c.commit();
    }

    public final void c(int i4) {
        this.f12230c.putInt("mo_ae_fa_ct", i4);
        this.f12230c.commit();
    }

    public final void d(int i4) {
        this.f12230c.putInt("rtqe", i4);
        this.f12230c.commit();
    }

    public final void f(int i4) {
        this.f12230c.putInt("sustfd", i4);
        this.f12230c.commit();
    }

    public final void h(int i4) {
        this.f12233f.putInt("g_r_d_d_n", i4);
        this.f12233f.commit();
    }

    public final boolean a() {
        return this.f12228a.getBoolean("iio", false);
    }

    public final void g(int i4) {
        this.f12230c.putInt("sufzfd", i4);
        this.f12230c.commit();
    }

    public final void a(String str) {
        this.f12230c.putString("ses_ic", str);
        this.f12230c.commit();
    }

    public final void b(long j4) {
        String str;
        try {
            if (j4 == 0) {
                this.f12230c.putString("pdcgts", "");
                this.f12230c.commit();
                return;
            }
            String string = this.f12228a.getString("pdcgts", "");
            if (TextUtils.isEmpty(string)) {
                str = String.valueOf(j4);
            } else if (string.split("_").length >= 20) {
                return;
            } else {
                str = string + "_" + String.valueOf(j4);
            }
            b.a();
            this.f12230c.putString("pdcgts", str);
            this.f12230c.commit();
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final void c(long j4) {
        this.f12230c.putLong("slruct", j4);
        this.f12230c.commit();
    }

    public final void d(long j4) {
        this.f12233f.putLong("re_last_ofline_time", j4);
        this.f12233f.commit();
    }

    public final void f(long j4) {
        this.f12233f.putLong("re_day_b_t", j4);
        this.f12233f.commit();
    }

    public final void a(String str, long j4) {
        b.a();
        try {
            this.f12230c.putString("lsl", Base64.encodeToString(F.getInstance().ae(str.getBytes(), Base64.decode("MzAyMTIxMDJkaWN1ZGlhYg==", 0)), 0));
            this.f12230c.putLong("lslt", j4);
            this.f12230c.commit();
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final void e(int i4) {
        this.f12230c.putInt("pdcg", i4);
        this.f12230c.commit();
    }

    public final void e(long j4) {
        this.f12233f.putLong("re_day_len", j4);
        this.f12233f.commit();
    }

    public final void a(int i4) {
        this.f12230c.putInt("wi_fa_pu_ap", i4);
        this.f12230c.commit();
    }

    public final String b(String str) {
        SharedPreferences sharedPreferences = this.f12232e;
        return sharedPreferences.getString("al_da" + str, "");
    }

    public final void a(int... iArr) {
        if (iArr.length == 0) {
            this.f12230c.putString("hcpk", "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < iArr.length; i4++) {
                sb.append(iArr[i4]);
                if (i4 != iArr.length - 1) {
                    sb.append("-");
                }
            }
            this.f12230c.putString("hcpk", sb.toString());
        }
        this.f12230c.commit();
    }

    public final void a(List<Integer> list) {
        if (list.size() == 0) {
            this.f12230c.putString("glspk", "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < list.size(); i4++) {
                sb.append(list.get(i4));
                if (i4 != list.size() - 1) {
                    sb.append("-");
                }
            }
            this.f12230c.putString("glspk", sb.toString());
        }
        this.f12230c.commit();
    }

    public final void a(int i4, int i5, int i6) {
        String str = i4 != 0 ? i4 != 1 ? "" : "suetfite" : "sustfits";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor editor = this.f12230c;
        editor.putInt(str + i5, i6);
        this.f12230c.commit();
    }

    public final int a(int i4, int i5) {
        String str = i4 != 0 ? i4 != 1 ? "" : "suetfite" : "sustfits";
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        SharedPreferences sharedPreferences = this.f12228a;
        return sharedPreferences.getInt(str + i5, 0);
    }

    public final void a(com.baidu.liantian.rp.a.a aVar) {
        String string = this.f12232e.getString("re_con", "");
        SharedPreferences.Editor editor = this.f12233f;
        editor.putString("re_con", string + "||" + com.baidu.liantian.rp.a.a.a(aVar));
        this.f12233f.commit();
    }
}
