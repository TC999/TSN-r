package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HttpsDecisionUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e1 {

    /* renamed from: a  reason: collision with root package name */
    private volatile b f9811a = new b((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private j2 f9812b = new j2("HttpsDecisionUtil");

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpsDecisionUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static e1 f9813a = new e1();
    }

    public static e1 a() {
        return a.f9813a;
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
        SharedPreferences.Editor c4 = j2.c(context, "open_common");
        j2.k(c4, "a3", z3);
        j2.f(c4);
    }

    private static boolean j() {
        return Build.VERSION.SDK_INT == 19;
    }

    public final void c(Context context) {
        if (this.f9811a == null) {
            this.f9811a = new b((byte) 0);
        }
        this.f9811a.b(j2.l(context, "open_common", "a3", true));
        this.f9811a.a(context);
        t1.a(context).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(Context context, boolean z3) {
        if (this.f9811a == null) {
            this.f9811a = new b((byte) 0);
        }
        g(context, z3);
        this.f9811a.b(z3);
    }

    public final void e(boolean z3) {
        if (this.f9811a == null) {
            this.f9811a = new b((byte) 0);
        }
        this.f9811a.d(z3);
    }

    public final boolean h() {
        if (this.f9811a == null) {
            this.f9811a = new b((byte) 0);
        }
        return this.f9811a.c();
    }

    public final boolean i(boolean z3) {
        if (j()) {
            return false;
        }
        return z3 || h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpsDecisionUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private int f9814a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f9815b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f9816c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9817d;

        private b() {
            this.f9814a = 0;
            this.f9815b = true;
            this.f9816c = true;
            this.f9817d = false;
        }

        public final void a(Context context) {
            if (context != null && this.f9814a <= 0) {
                this.f9814a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z3) {
            this.f9815b = z3;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x002e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean c() {
            /*
                r5 = this;
                boolean r0 = r5.f9817d
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
                boolean r4 = r5.f9815b
                if (r4 == 0) goto L23
                int r4 = r5.f9814a
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
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.e1.b.c():boolean");
        }

        public final void d(boolean z3) {
            this.f9817d = z3;
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }
}
