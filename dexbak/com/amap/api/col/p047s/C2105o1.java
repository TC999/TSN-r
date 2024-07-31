package com.amap.api.col.p047s;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: AAIDManager.java */
/* renamed from: com.amap.api.col.s.o1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2105o1 {

    /* renamed from: b */
    private static C2105o1 f6329b;

    /* renamed from: c */
    private static boolean f6330c;

    /* renamed from: d */
    private static boolean f6331d;

    /* renamed from: a */
    private Context f6332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AAIDManager.java */
    /* renamed from: com.amap.api.col.s.o1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2106a extends AbstractRunnableC2229z3 {
        C2106a() {
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            C2105o1.this.m52715d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AAIDManager.java */
    /* renamed from: com.amap.api.col.s.o1$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2107b extends AbstractRunnableC2229z3 {
        C2107b() {
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            C2105o1.this.m52713f();
        }
    }

    private C2105o1(Context context) {
        this.f6332a = context;
    }

    /* renamed from: a */
    public static C2105o1 m52718a(Context context) {
        if (f6329b == null) {
            synchronized (C2105o1.class) {
                if (f6329b == null) {
                    f6329b = new C2105o1(context);
                }
            }
        }
        return f6329b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m52715d() {
        try {
            if (f6330c) {
                f6330c = false;
                return;
            }
            f6330c = true;
            C2093m1 c2093m1 = new C2093m1(this.f6332a);
            new C2163u2();
            C2021b3 m52427d = C2163u2.m52427d(c2093m1);
            if (m52427d != null) {
                JSONObject jSONObject = new JSONObject(C2079j1.m52870g(C2101n1.m52743d(m52427d.f5893a, C2079j1.m52857t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    C2085k1.m52794m(this.f6332a, c2093m1.f6282n);
                    C2085k1.m52792o(this.f6332a, c2093m1.f6283o);
                    C2085k1.m52790q(this.f6332a, c2093m1.f6284p);
                    C2085k1.m52788s(this.f6332a, c2093m1.f6285q);
                    C2085k1.m52786u(this.f6332a, c2093m1.f6286r);
                    C2085k1.m52784w(this.f6332a, c2093m1.f6287s);
                    C2085k1.m52782y(this.f6332a, c2093m1.f6288t);
                    C2085k1.m52802e(this.f6332a, c2093m1.f6290v);
                    C2085k1.m52808A(this.f6332a, c2093m1.f6289u);
                    C2085k1.m52805b(this.f6332a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        C2085k1.m52800g(this.f6332a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        C2085k1.m52796k(this.f6332a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        C2085k1.m52798i(this.f6332a, optString3);
                    }
                }
            }
            f6330c = false;
        } catch (Throwable unused) {
            f6330c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m52713f() {
        try {
            if (f6331d) {
                f6331d = false;
                return;
            }
            f6331d = true;
            C2115p1 c2115p1 = new C2115p1(this.f6332a);
            new C2163u2();
            C2021b3 m52427d = C2163u2.m52427d(c2115p1);
            if (m52427d != null) {
                JSONObject jSONObject = new JSONObject(C2079j1.m52870g(C2101n1.m52743d(m52427d.f5893a, C2079j1.m52857t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    C2085k1.m52794m(this.f6332a, c2115p1.f6356n);
                    C2085k1.m52792o(this.f6332a, c2115p1.f6357o);
                    C2085k1.m52790q(this.f6332a, c2115p1.f6358p);
                    C2085k1.m52788s(this.f6332a, c2115p1.f6359q);
                    C2085k1.m52786u(this.f6332a, c2115p1.f6360r);
                    C2085k1.m52784w(this.f6332a, c2115p1.f6361s);
                    C2085k1.m52782y(this.f6332a, c2115p1.f6362t);
                    C2085k1.m52802e(this.f6332a, c2115p1.f6364v);
                    C2085k1.m52808A(this.f6332a, c2115p1.f6363u);
                    C2085k1.m52805b(this.f6332a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        C2085k1.m52800g(this.f6332a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        C2085k1.m52796k(this.f6332a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        C2085k1.m52798i(this.f6332a, optString3);
                    }
                }
            }
            f6331d = false;
        } catch (Throwable unused) {
            f6331d = false;
        }
    }

    /* renamed from: b */
    public final String m52717b() {
        String str = "";
        try {
            if (C2089l1.f6268d) {
                str = C2085k1.m52801f(this.f6332a);
                long m52799h = C2085k1.m52799h(this.f6332a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (TextUtils.isEmpty(str)) {
                    C2225y3.m52184e().m53246c(new C2106a());
                } else if (elapsedRealtime - m52799h > C2089l1.f6266b) {
                    C2225y3.m52184e().m53246c(new C2107b());
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }
}
