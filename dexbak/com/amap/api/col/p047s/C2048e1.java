package com.amap.api.col.p047s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;

/* compiled from: HttpsDecisionUtil.java */
/* renamed from: com.amap.api.col.s.e1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2048e1 {

    /* renamed from: a */
    private volatile C2050b f6083a = new C2050b((byte) 0);

    /* renamed from: b */
    private C2080j2 f6084b = new C2080j2("HttpsDecisionUtil");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpsDecisionUtil.java */
    /* renamed from: com.amap.api.col.s.e1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2049a {

        /* renamed from: a */
        static C2048e1 f6085a = new C2048e1();
    }

    /* renamed from: a */
    public static C2048e1 m53039a() {
        return C2049a.f6085a;
    }

    /* renamed from: b */
    public static String m53038b(String str) {
        Uri.Builder buildUpon;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.startsWith("https")) {
            try {
                buildUpon = Uri.parse(str).buildUpon();
                buildUpon.scheme("https");
            } catch (Throwable unused) {
                return str;
            }
        }
        return buildUpon.build().toString();
    }

    /* renamed from: f */
    public static void m53034f(Context context) {
        m53033g(context, true);
    }

    /* renamed from: g */
    private static void m53033g(Context context, boolean z) {
        SharedPreferences.Editor m52848c = C2080j2.m52848c(context, "open_common");
        C2080j2.m52840k(m52848c, "a3", z);
        C2080j2.m52845f(m52848c);
    }

    /* renamed from: j */
    private static boolean m53030j() {
        return Build.VERSION.SDK_INT == 19;
    }

    /* renamed from: c */
    public final void m53037c(Context context) {
        if (this.f6083a == null) {
            this.f6083a = new C2050b((byte) 0);
        }
        this.f6083a.m53028b(C2080j2.m52839l(context, "open_common", "a3", true));
        this.f6083a.m53029a(context);
        C2152t1.m52445a(context).m52444b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final void m53036d(Context context, boolean z) {
        if (this.f6083a == null) {
            this.f6083a = new C2050b((byte) 0);
        }
        m53033g(context, z);
        this.f6083a.m53028b(z);
    }

    /* renamed from: e */
    public final void m53035e(boolean z) {
        if (this.f6083a == null) {
            this.f6083a = new C2050b((byte) 0);
        }
        this.f6083a.m53026d(z);
    }

    /* renamed from: h */
    public final boolean m53032h() {
        if (this.f6083a == null) {
            this.f6083a = new C2050b((byte) 0);
        }
        return this.f6083a.m53027c();
    }

    /* renamed from: i */
    public final boolean m53031i(boolean z) {
        if (m53030j()) {
            return false;
        }
        return z || m53032h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpsDecisionUtil.java */
    /* renamed from: com.amap.api.col.s.e1$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2050b {

        /* renamed from: a */
        private int f6086a;

        /* renamed from: b */
        protected boolean f6087b;

        /* renamed from: c */
        private final boolean f6088c;

        /* renamed from: d */
        private boolean f6089d;

        private C2050b() {
            this.f6086a = 0;
            this.f6087b = true;
            this.f6088c = true;
            this.f6089d = false;
        }

        /* renamed from: a */
        public final void m53029a(Context context) {
            if (context != null && this.f6086a <= 0) {
                this.f6086a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().targetSdkVersion;
            }
        }

        /* renamed from: b */
        public final void m53028b(boolean z) {
            this.f6087b = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x002e A[RETURN] */
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean m53027c() {
            /*
                r5 = this;
                boolean r0 = r5.f6089d
                r1 = 1
                if (r0 != 0) goto L2f
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 28
                r3 = 0
                if (r0 < r2) goto Le
                r0 = 1
                goto Lf
            Le:
                r0 = 0
            Lf:
                boolean r4 = r5.f6087b
                if (r4 == 0) goto L23
                int r4 = r5.f6086a
                if (r4 > 0) goto L19
                r4 = 28
            L19:
                if (r4 < r2) goto L1d
                r2 = 1
                goto L1e
            L1d:
                r2 = 0
            L1e:
                if (r2 == 0) goto L21
                goto L23
            L21:
                r2 = 0
                goto L24
            L23:
                r2 = 1
            L24:
                if (r0 == 0) goto L2a
                if (r2 == 0) goto L2a
                r0 = 1
                goto L2b
            L2a:
                r0 = 0
            L2b:
                if (r0 == 0) goto L2e
                goto L2f
            L2e:
                return r3
            L2f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.C2048e1.C2050b.m53027c():boolean");
        }

        /* renamed from: d */
        public final void m53026d(boolean z) {
            this.f6089d = z;
        }

        /* synthetic */ C2050b(byte b) {
            this();
        }
    }
}
