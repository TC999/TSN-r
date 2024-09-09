package com.amap.api.col.s;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AAIDManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class o1 {

    /* renamed from: b  reason: collision with root package name */
    private static o1 f10057b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f10058c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f10059d;

    /* renamed from: a  reason: collision with root package name */
    private Context f10060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AAIDManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends z3 {
        a() {
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            o1.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AAIDManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b extends z3 {
        b() {
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            o1.this.f();
        }
    }

    private o1(Context context) {
        this.f10060a = context;
    }

    public static o1 a(Context context) {
        if (f10057b == null) {
            synchronized (o1.class) {
                if (f10057b == null) {
                    f10057b = new o1(context);
                }
            }
        }
        return f10057b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            if (f10058c) {
                f10058c = false;
                return;
            }
            f10058c = true;
            m1 m1Var = new m1(this.f10060a);
            new u2();
            b3 d4 = u2.d(m1Var);
            if (d4 != null) {
                JSONObject jSONObject = new JSONObject(j1.g(n1.d(d4.f9643a, j1.t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    k1.m(this.f10060a, m1Var.f10010n);
                    k1.o(this.f10060a, m1Var.f10011o);
                    k1.q(this.f10060a, m1Var.f10012p);
                    k1.s(this.f10060a, m1Var.f10013q);
                    k1.u(this.f10060a, m1Var.f10014r);
                    k1.w(this.f10060a, m1Var.f10015s);
                    k1.y(this.f10060a, m1Var.f10016t);
                    k1.e(this.f10060a, m1Var.f10018v);
                    k1.A(this.f10060a, m1Var.f10017u);
                    k1.b(this.f10060a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        k1.g(this.f10060a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        k1.k(this.f10060a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        k1.i(this.f10060a, optString3);
                    }
                }
            }
            f10058c = false;
        } catch (Throwable unused) {
            f10058c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (f10059d) {
                f10059d = false;
                return;
            }
            f10059d = true;
            p1 p1Var = new p1(this.f10060a);
            new u2();
            b3 d4 = u2.d(p1Var);
            if (d4 != null) {
                JSONObject jSONObject = new JSONObject(j1.g(n1.d(d4.f9643a, j1.t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    k1.m(this.f10060a, p1Var.f10084n);
                    k1.o(this.f10060a, p1Var.f10085o);
                    k1.q(this.f10060a, p1Var.f10086p);
                    k1.s(this.f10060a, p1Var.f10087q);
                    k1.u(this.f10060a, p1Var.f10088r);
                    k1.w(this.f10060a, p1Var.f10089s);
                    k1.y(this.f10060a, p1Var.f10090t);
                    k1.e(this.f10060a, p1Var.f10092v);
                    k1.A(this.f10060a, p1Var.f10091u);
                    k1.b(this.f10060a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        k1.g(this.f10060a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        k1.k(this.f10060a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        k1.i(this.f10060a, optString3);
                    }
                }
            }
            f10059d = false;
        } catch (Throwable unused) {
            f10059d = false;
        }
    }

    public final String b() {
        String str = "";
        try {
            if (l1.f9996d) {
                str = k1.f(this.f10060a);
                long h4 = k1.h(this.f10060a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (TextUtils.isEmpty(str)) {
                    y3.e().c(new a());
                } else if (elapsedRealtime - h4 > l1.f9994b) {
                    y3.e().c(new b());
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }
}
