package com.amap.api.col.p0463l;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;

/* renamed from: com.amap.api.col.3l.j4 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class HttpsDecisionUtil {

    /* renamed from: a */
    private volatile C1847b f4566a = new C1847b((byte) 0);

    /* renamed from: b */
    private SPUtil f4567b = new SPUtil("HttpsDecisionUtil");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpsDecisionUtil.java */
    /* renamed from: com.amap.api.col.3l.j4$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1846a {

        /* renamed from: a */
        static HttpsDecisionUtil f4568a = new HttpsDecisionUtil();
    }

    /* renamed from: a */
    public static HttpsDecisionUtil m54673a() {
        return C1846a.f4568a;
    }

    /* renamed from: b */
    public static String m54672b(String str) {
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
    public static void m54668f(Context context) {
        m54667g(context, true);
    }

    /* renamed from: g */
    private static void m54667g(Context context, boolean z) {
        SharedPreferences.Editor m55232c = SPUtil.m55232c(context, "open_common");
        SPUtil.m55224k(m55232c, "a3", z);
        SPUtil.m55229f(m55232c);
    }

    /* renamed from: i */
    private static boolean m54665i() {
        return Build.VERSION.SDK_INT == 19;
    }

    /* renamed from: c */
    public final void m54671c(Context context) {
        if (this.f4566a == null) {
            this.f4566a = new C1847b((byte) 0);
        }
        this.f4566a.m54663b(SPUtil.m55223l(context, "open_common", "a3", true));
        this.f4566a.m54664a(context);
        AdiuManager.m55028a(context).m55027b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final void m54670d(Context context, boolean z) {
        if (this.f4566a == null) {
            this.f4566a = new C1847b((byte) 0);
        }
        m54667g(context, z);
        this.f4566a.m54663b(z);
    }

    /* renamed from: e */
    public final boolean m54669e(boolean z) {
        if (m54665i()) {
            return false;
        }
        return z || m54666h();
    }

    /* renamed from: h */
    public final boolean m54666h() {
        if (this.f4566a == null) {
            this.f4566a = new C1847b((byte) 0);
        }
        return this.f4566a.m54662c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpsDecisionUtil.java */
    /* renamed from: com.amap.api.col.3l.j4$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1847b {

        /* renamed from: a */
        private int f4569a;

        /* renamed from: b */
        protected boolean f4570b;

        /* renamed from: c */
        private final boolean f4571c;

        /* renamed from: d */
        private boolean f4572d;

        private C1847b() {
            this.f4569a = 0;
            this.f4570b = true;
            this.f4571c = true;
            this.f4572d = false;
        }

        /* renamed from: a */
        public final void m54664a(Context context) {
            if (context != null && this.f4569a <= 0) {
                this.f4569a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().targetSdkVersion;
            }
        }

        /* renamed from: b */
        public final void m54663b(boolean z) {
            this.f4570b = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x002e A[RETURN] */
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean m54662c() {
            /*
                r5 = this;
                boolean r0 = r5.f4572d
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
                boolean r4 = r5.f4570b
                if (r4 == 0) goto L23
                int r4 = r5.f4569a
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
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.HttpsDecisionUtil.C1847b.m54662c():boolean");
        }

        /* synthetic */ C1847b(byte b) {
            this();
        }
    }
}
