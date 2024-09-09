package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AAIDManager.java */
/* renamed from: com.amap.api.col.3l.w4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class w4 {

    /* renamed from: b  reason: collision with root package name */
    private static w4 f9359b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f9360c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f9361d;

    /* renamed from: a  reason: collision with root package name */
    private Context f9362a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AAIDManager.java */
    /* renamed from: com.amap.api.col.3l.w4$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends a8 {
        a() {
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            w4.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AAIDManager.java */
    /* renamed from: com.amap.api.col.3l.w4$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b extends a8 {
        b() {
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            w4.this.f();
        }
    }

    private w4(Context context) {
        this.f9362a = context;
    }

    public static w4 a(Context context) {
        if (f9359b == null) {
            synchronized (w4.class) {
                if (f9359b == null) {
                    f9359b = new w4(context);
                }
            }
        }
        return f9359b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            if (f9360c) {
                f9360c = false;
                return;
            }
            f9360c = true;
            u4 u4Var = new u4(this.f9362a);
            new q6();
            y6 d4 = q6.d(u4Var);
            if (d4 != null) {
                JSONObject jSONObject = new JSONObject(q4.g(v4.d(d4.f9524a, q4.u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    r4.m(this.f9362a, u4Var.f9143j);
                    r4.o(this.f9362a, u4Var.f9144k);
                    r4.q(this.f9362a, u4Var.f9145p);
                    r4.s(this.f9362a, u4Var.f9146q);
                    r4.u(this.f9362a, u4Var.f9147r);
                    r4.w(this.f9362a, u4Var.f9148s);
                    r4.y(this.f9362a, u4Var.f9149t);
                    r4.e(this.f9362a, u4Var.f9151v);
                    r4.A(this.f9362a, u4Var.f9150u);
                    r4.b(this.f9362a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        r4.g(this.f9362a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        r4.k(this.f9362a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        r4.i(this.f9362a, optString3);
                    }
                }
            }
            f9360c = false;
        } catch (Throwable unused) {
            f9360c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (f9361d) {
                f9361d = false;
                return;
            }
            f9361d = true;
            x4 x4Var = new x4(this.f9362a);
            new q6();
            y6 d4 = q6.d(x4Var);
            if (d4 != null) {
                JSONObject jSONObject = new JSONObject(q4.g(v4.d(d4.f9524a, q4.u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    r4.m(this.f9362a, x4Var.f9407j);
                    r4.o(this.f9362a, x4Var.f9408k);
                    r4.q(this.f9362a, x4Var.f9409p);
                    r4.s(this.f9362a, x4Var.f9410q);
                    r4.u(this.f9362a, x4Var.f9411r);
                    r4.w(this.f9362a, x4Var.f9412s);
                    r4.y(this.f9362a, x4Var.f9413t);
                    r4.e(this.f9362a, x4Var.f9415v);
                    r4.A(this.f9362a, x4Var.f9414u);
                    r4.b(this.f9362a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        r4.g(this.f9362a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        r4.k(this.f9362a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        r4.i(this.f9362a, optString3);
                    }
                }
            }
            f9361d = false;
        } catch (Throwable unused) {
            f9361d = false;
        }
    }

    public final String b() {
        String str = "";
        try {
            if (s4.f8938d) {
                str = r4.f(this.f9362a);
                long h4 = r4.h(this.f9362a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (TextUtils.isEmpty(str)) {
                    z7.h().b(new a());
                } else if (elapsedRealtime - h4 > s4.f8936b) {
                    z7.h().b(new b());
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }
}
