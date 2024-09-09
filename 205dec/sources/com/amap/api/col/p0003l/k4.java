package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: HttpsDecisionUtil.java */
/* renamed from: com.amap.api.col.3l.k4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k4 {

    /* renamed from: a  reason: collision with root package name */
    private volatile b f8235a = new b((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private f6 f8236b = new f6("HttpsDecisionUtil");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpsDecisionUtil.java */
    /* renamed from: com.amap.api.col.3l.k4$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static k4 f8237a = new k4();
    }

    public static k4 a() {
        return a.f8237a;
    }

    public static String b(String str) {
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

    public static void f(Context context) {
        g(context, true);
    }

    private static void g(Context context, boolean z3) {
        SharedPreferences.Editor c4 = f6.c(context, "open_common");
        f6.k(c4, "a3", z3);
        f6.f(c4);
    }

    private static boolean i() {
        return Build.VERSION.SDK_INT == 19;
    }

    public final void c(Context context) {
        if (this.f8235a == null) {
            this.f8235a = new b((byte) 0);
        }
        this.f8235a.b(f6.l(context, "open_common", "a3", true));
        this.f8235a.a(context);
        g5.a(context).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(Context context, boolean z3) {
        if (this.f8235a == null) {
            this.f8235a = new b((byte) 0);
        }
        g(context, z3);
        this.f8235a.b(z3);
    }

    public final boolean e(boolean z3) {
        if (i()) {
            return false;
        }
        return z3 || h();
    }

    public final boolean h() {
        if (this.f8235a == null) {
            this.f8235a = new b((byte) 0);
        }
        return this.f8235a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpsDecisionUtil.java */
    /* renamed from: com.amap.api.col.3l.k4$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private int f8238a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f8239b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f8240c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8241d;

        private b() {
            this.f8238a = 0;
            this.f8239b = true;
            this.f8240c = true;
            this.f8241d = false;
        }

        public final void a(Context context) {
            if (context != null && this.f8238a <= 0) {
                this.f8238a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z3) {
            this.f8239b = z3;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x002e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean c() {
            /*
                r5 = this;
                boolean r0 = r5.f8241d
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
                boolean r4 = r5.f8239b
                if (r4 == 0) goto L23
                int r4 = r5.f8238a
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
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.k4.b.c():boolean");
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }
}
