package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OfflineLocEntity.java */
/* renamed from: com.amap.api.col.3l.e7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e7 {

    /* renamed from: a  reason: collision with root package name */
    private Context f7496a;

    /* renamed from: b  reason: collision with root package name */
    private p4 f7497b;

    /* renamed from: c  reason: collision with root package name */
    private String f7498c;

    public e7(Context context, p4 p4Var, String str) {
        this.f7496a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f7497b = p4Var;
        this.f7498c = str;
    }

    private static String a(Context context, p4 p4Var, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(p4Var.f());
            sb.append("\",\"product\":\"");
            sb.append(p4Var.a());
            sb.append("\",\"nt\":\"");
            sb.append(i4.y(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] b() {
        return q4.o(a(this.f7496a, this.f7497b, this.f7498c));
    }

    /* compiled from: OfflineLocManager.java */
    /* renamed from: com.amap.api.col.3l.e7$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class a extends z7 {

        /* renamed from: a  reason: collision with root package name */
        private int f7499a;

        /* renamed from: b  reason: collision with root package name */
        private Context f7500b;

        /* renamed from: c  reason: collision with root package name */
        private d7 f7501c;

        a(Context context, int i4) {
            this.f7500b = context;
            this.f7499a = i4;
        }

        /* JADX WARN: Type inference failed for: r10v1, types: [com.amap.api.col.3l.k7, com.amap.api.col.3l.o7] */
        /* JADX WARN: Type inference failed for: r12v0, types: [com.amap.api.col.3l.v7, com.amap.api.col.3l.s7] */
        /* JADX WARN: Type inference failed for: r1v4, types: [com.amap.api.col.3l.v7, com.amap.api.col.3l.u7] */
        /* JADX WARN: Type inference failed for: r3v10, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.h6] */
        /* JADX WARN: Type inference failed for: r3v4, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.j6] */
        /* JADX WARN: Type inference failed for: r3v5, types: [com.amap.api.col.3l.l7, com.amap.api.col.3l.o7] */
        /* JADX WARN: Type inference failed for: r4v2, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.k6] */
        /* JADX WARN: Type inference failed for: r4v9, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.j6] */
        /* JADX WARN: Type inference failed for: r5v4, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.k6] */
        /* JADX WARN: Type inference failed for: r6v2, types: [com.amap.api.col.3l.p7, com.amap.api.col.3l.o7] */
        /* JADX WARN: Type inference failed for: r6v4, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.j6] */
        /* JADX WARN: Type inference failed for: r7v2, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.h6] */
        public final void runTask() {
            int i4 = this.f7499a;
            if (i4 == 1) {
                try {
                    synchronized (e7.class) {
                        String l4 = Long.toString(System.currentTimeMillis());
                        a7 a4 = h7.a(e7.a());
                        h7.f(this.f7500b, a4, q5.i, e7.a, 2097152, "6");
                        if (a4.e == null) {
                            a4.e = new h6((i6) new j6((i6) new k6((i6) new j6())));
                        }
                        b7.c(l4, this.f7501c.b(), a4);
                    }
                } catch (Throwable th) {
                    t5.p(th, "ofm", "aple");
                }
            } else if (i4 == 2) {
                try {
                    a7 a5 = h7.a(e7.a());
                    h7.f(this.f7500b, a5, q5.i, e7.a, 2097152, "6");
                    a5.h = 14400000;
                    if (a5.g == null) {
                        a5.g = new l7(new k7(this.f7500b, new p7(), new h6((i6) new j6((i6) new k6())), new String(e5.c()), new Object[]{e4.j(this.f7500b), h4.P(), h4.I(), h4.F(this.f7500b), h4.n(), Build.MANUFACTURER, Build.DEVICE, h4.U(), e4.g(this.f7500b), Build.MODEL, e4.h(this.f7500b), e4.e(this.f7500b), h4.D(this.f7500b), h4.o(this.f7500b), String.valueOf(Build.VERSION.SDK_INT), v4.a(this.f7500b).b()}));
                    }
                    if (TextUtils.isEmpty(a5.i)) {
                        a5.i = "fKey";
                    }
                    Context context = this.f7500b;
                    a5.f = new u7(context, a5.h, a5.i, new s7(context, e7.b, e7.f() * 1024, e7.d * 1024, "offLocKey", e7.f * 1024));
                    b7.a(a5);
                } catch (Throwable th2) {
                    t5.p(th2, "ofm", "uold");
                }
            }
        }

        a(Context context, d7 d7Var) {
            this(context, 1);
            this.f7501c = d7Var;
        }
    }
}
