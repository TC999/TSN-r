package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003l.v5;
import com.stub.StubApp;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AMapLogManager.java */
/* renamed from: com.amap.api.col.3l.b5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b5 {

    /* renamed from: a  reason: collision with root package name */
    private Context f7243a;

    /* renamed from: b  reason: collision with root package name */
    private p4 f7244b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7245c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7246d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7247e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7248f = false;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f7249g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private d5 f7250h = new d5((byte) 0);

    /* renamed from: i  reason: collision with root package name */
    private d5 f7251i = new d5();

    /* renamed from: j  reason: collision with root package name */
    private v5.d f7252j = new a();

    /* renamed from: k  reason: collision with root package name */
    private v5.d f7253k = new b();

    /* renamed from: l  reason: collision with root package name */
    private Handler f7254l = null;

    /* renamed from: m  reason: collision with root package name */
    private b7 f7255m = null;

    /* renamed from: n  reason: collision with root package name */
    private b7 f7256n = null;

    /* compiled from: AMapLogManager.java */
    /* renamed from: com.amap.api.col.3l.b5$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements v5.d {

        /* compiled from: AMapLogManager.java */
        /* renamed from: com.amap.api.col.3l.b5$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        final class RunnableC0101a implements Runnable {
            RunnableC0101a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b5.this.s(false);
            }
        }

        a() {
        }

        @Override // com.amap.api.col.p0003l.v5.d
        public final void a(int i4) {
            if (i4 > 0 && b5.b(b5.this) != null) {
                ((c5) b5.this.p().f7269f).f(i4);
                b5.i(b5.this, "error", String.valueOf(((c5) b5.this.p().f7269f).h()));
                b5.b(b5.this).postDelayed(new RunnableC0101a(), 660000L);
            }
        }
    }

    /* compiled from: AMapLogManager.java */
    /* renamed from: com.amap.api.col.3l.b5$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements v5.d {

        /* compiled from: AMapLogManager.java */
        /* renamed from: com.amap.api.col.3l.b5$b$a */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b5.this.v(false);
            }
        }

        b() {
        }

        @Override // com.amap.api.col.p0003l.v5.d
        public final void a(int i4) {
            if (i4 <= 0) {
                return;
            }
            ((c5) b5.this.w().f7269f).f(i4);
            b5.i(b5.this, "info", String.valueOf(((c5) b5.this.w().f7269f).h()));
            if (b5.b(b5.this) == null) {
                return;
            }
            b5.b(b5.this).postDelayed(new a(), 660000L);
        }
    }

    /* compiled from: AMapLogManager.java */
    /* renamed from: com.amap.api.col.3l.b5$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class c {

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, b5> f7261a = new HashMap();
    }

    private b5(p4 p4Var) {
        this.f7244b = p4Var;
    }

    private String A() {
        Context context = this.f7243a;
        if (context == null) {
            return null;
        }
        return d(context, "CB5E100E5A9A3E7F6D1FD97512215282", this.f7244b);
    }

    private long a(String str) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            e5 a4 = e5.a(this.f7244b);
            Context context = this.f7243a;
            return Long.parseLong(a4.c(context, "", "", format + str));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    static /* synthetic */ Handler b(b5 b5Var) {
        Context context = b5Var.f7243a;
        if (context == null || context == null) {
            return null;
        }
        if (b5Var.f7254l == null) {
            b5Var.f7254l = new Handler(b5Var.f7243a.getMainLooper());
        }
        return b5Var.f7254l;
    }

    public static b5 c(p4 p4Var) {
        if (p4Var == null || TextUtils.isEmpty(p4Var.a())) {
            return null;
        }
        if (c.f7261a.get(p4Var.a()) == null) {
            c.f7261a.put(p4Var.a(), new b5(p4Var));
        }
        return c.f7261a.get(p4Var.a());
    }

    private static String d(Context context, String str, p4 p4Var) {
        String d4;
        if (context == null) {
            return null;
        }
        if (p4Var != null) {
            try {
                if (!TextUtils.isEmpty(p4Var.a())) {
                    d4 = m4.d(p4Var.a());
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getFilesDir().getAbsolutePath());
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append("EBDEC84EF205FEA2DF0719DEB822869E");
                    sb.append(str2);
                    sb.append(str);
                    sb.append(str2);
                    sb.append(d4);
                    return sb.toString();
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        d4 = "a";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getFilesDir().getAbsolutePath());
        String str22 = File.separator;
        sb2.append(str22);
        sb2.append("EBDEC84EF205FEA2DF0719DEB822869E");
        sb2.append(str22);
        sb2.append(str);
        sb2.append(str22);
        sb2.append(d4);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i4) {
        Context context;
        d5 l4 = l(i4);
        String d4 = a5.d(l4.a());
        if (TextUtils.isEmpty(d4) || "[]".equals(d4) || (context = this.f7243a) == null) {
            return;
        }
        v5.h(context, this.f7244b, a5.c(i4), q(i4), d4);
        l4.d();
    }

    static /* synthetic */ void i(b5 b5Var, String str, String str2) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            e5 a4 = e5.a(b5Var.f7244b);
            Context context = b5Var.f7243a;
            a4.d(context, "", "", format + str, str2);
        } catch (Throwable unused) {
        }
    }

    private d5 l(int i4) {
        if (i4 == a5.f7100f) {
            return this.f7251i;
        }
        return this.f7250h;
    }

    private void n(boolean z3) {
        s(z3);
        v(z3);
    }

    private boolean o() {
        return this.f7243a != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b7 p() {
        b7 b7Var = this.f7256n;
        if (b7Var != null) {
            return b7Var;
        }
        t();
        return this.f7256n;
    }

    private b7 q(int i4) {
        if (i4 == a5.f7100f) {
            if (this.f7256n == null) {
                this.f7256n = p();
            }
            return this.f7256n;
        }
        if (this.f7255m == null) {
            this.f7255m = w();
        }
        return this.f7255m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z3) {
        b7 q3 = q(a5.f7100f);
        if (z3) {
            ((c5) q3.f7269f).g(z3);
        }
        Context context = this.f7243a;
        if (context == null) {
            return;
        }
        v5.i(context, q3, this.f7252j);
    }

    private b7 t() {
        if (this.f7243a == null) {
            return null;
        }
        b7 b7Var = new b7();
        this.f7256n = b7Var;
        b7Var.f7264a = A();
        b7 b7Var2 = this.f7256n;
        b7Var2.f7265b = 512000000L;
        b7Var2.f7267d = 12500;
        b7Var2.f7266c = "1";
        b7Var2.f7271h = -1;
        b7Var2.f7272i = "elkey";
        long a4 = a("error");
        this.f7256n.f7269f = new c5(true, new x7(this.f7243a, this.f7246d), a4, 10000000);
        b7 b7Var3 = this.f7256n;
        b7Var3.f7270g = null;
        return b7Var3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z3) {
        b7 q3 = q(a5.f7099e);
        if (z3) {
            ((c5) q3.f7269f).g(z3);
        }
        Context context = this.f7243a;
        if (context == null) {
            return;
        }
        v5.i(context, q3, this.f7253k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b7 w() {
        b7 b7Var = this.f7255m;
        if (b7Var != null) {
            return b7Var;
        }
        y();
        return this.f7255m;
    }

    private b7 y() {
        if (this.f7243a == null) {
            return null;
        }
        b7 b7Var = new b7();
        this.f7255m = b7Var;
        b7Var.f7264a = z();
        b7 b7Var2 = this.f7255m;
        b7Var2.f7265b = 512000000L;
        b7Var2.f7267d = 12500;
        b7Var2.f7266c = "1";
        b7Var2.f7271h = -1;
        b7Var2.f7272i = "inlkey";
        long a4 = a("info");
        this.f7255m.f7269f = new c5(this.f7248f, new x7(this.f7243a, this.f7246d), a4, 30000000);
        b7 b7Var3 = this.f7255m;
        b7Var3.f7270g = null;
        return b7Var3;
    }

    private String z() {
        Context context = this.f7243a;
        if (context == null) {
            return null;
        }
        return d(context, "CAF9B6B99962BF5C2264824231D7A40C", this.f7244b);
    }

    public final void e() {
        if (o()) {
            f(a5.f7100f);
            f(a5.f7099e);
        }
    }

    public final void g(Context context) {
        this.f7243a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public final void h(a5 a5Var) {
        if (o() && this.f7245c && a5.e(a5Var)) {
            boolean z3 = true;
            if (a5Var != null) {
                List<String> list = this.f7249g;
                if (list != null && list.size() != 0) {
                    for (int i4 = 0; i4 < this.f7249g.size(); i4++) {
                        if (!TextUtils.isEmpty(this.f7249g.get(i4)) && a5Var.g().contains(this.f7249g.get(i4))) {
                            break;
                        }
                    }
                }
                z3 = false;
            }
            if (z3) {
                return;
            }
            if (this.f7247e || a5Var.a() != a5.f7099e) {
                d5 l4 = l(a5Var.a());
                if (l4.c(a5Var.g())) {
                    String d4 = a5.d(l4.a());
                    if (this.f7243a == null || TextUtils.isEmpty(d4) || "[]".equals(d4)) {
                        return;
                    }
                    v5.h(this.f7243a, this.f7244b, a5Var.i(), q(a5Var.a()), d4);
                    n(false);
                    l4.d();
                }
                l4.b(a5Var);
            }
        }
    }

    public final void j(boolean z3) {
        if (o()) {
            n(z3);
        }
    }

    public final void k(boolean z3, boolean z4, boolean z5, boolean z6, List<String> list) {
        this.f7245c = z3;
        this.f7246d = z4;
        this.f7247e = z5;
        this.f7248f = z6;
        this.f7249g = list;
        t();
        y();
    }
}
