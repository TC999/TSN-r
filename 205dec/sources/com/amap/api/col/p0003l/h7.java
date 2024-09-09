package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: StatisticsManager.java */
/* renamed from: com.amap.api.col.3l.h7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class h7 {

    /* renamed from: a  reason: collision with root package name */
    static boolean f8004a = false;

    /* renamed from: b  reason: collision with root package name */
    static int f8005b = 20;

    /* renamed from: c  reason: collision with root package name */
    private static int f8006c = 20;

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference<b7> f8007d;

    /* renamed from: e  reason: collision with root package name */
    private static int f8008e;

    public static void b(Context context) {
        z7.h().b(new a(context, a.f8011h));
    }

    static /* synthetic */ void c(Context context, byte[] bArr) throws IOException {
        b7 a4 = i7.a(f8007d);
        i7.f(context, a4, r5.f8899h, 1000, 307200, "2");
        if (a4.f7268e == null) {
            a4.f7268e = new g6();
        }
        Random random = new Random();
        try {
            c7.c(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a4);
        } catch (Throwable th) {
            u5.p(th, "stm", "wts");
        }
    }

    public static synchronized void d(g7 g7Var, Context context) {
        synchronized (h7.class) {
            z7.h().b(new a(context, a.f8009e, g7Var));
        }
    }

    public static synchronized void e(List<g7> list, Context context) {
        synchronized (h7.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        z7.h().b(new a(context, a.f8010g, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void f(boolean z3, int i4) {
        synchronized (h7.class) {
            f8004a = z3;
            f8008e = Math.max(0, i4);
        }
    }

    public static synchronized void h(List<g7> list, Context context) {
        synchronized (h7.class) {
            try {
                List<g7> q3 = u6.q();
                if (q3 != null && q3.size() > 0) {
                    list.addAll(q3);
                }
            } catch (Throwable unused) {
            }
            e(list, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StatisticsManager.java */
    /* renamed from: com.amap.api.col.3l.h7$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a extends a8 {

        /* renamed from: e  reason: collision with root package name */
        static int f8009e = 1;

        /* renamed from: g  reason: collision with root package name */
        static int f8010g = 2;

        /* renamed from: h  reason: collision with root package name */
        static int f8011h = 3;

        /* renamed from: a  reason: collision with root package name */
        private Context f8012a;

        /* renamed from: b  reason: collision with root package name */
        private g7 f8013b;

        /* renamed from: c  reason: collision with root package name */
        private int f8014c;

        /* renamed from: d  reason: collision with root package name */
        private List<g7> f8015d;

        a(Context context, int i4) {
            this.f8012a = context;
            this.f8014c = i4;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            g7 g7Var;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            int i4 = this.f8014c;
            if (i4 == 1) {
                try {
                    if (this.f8012a != null && this.f8013b != null) {
                        synchronized (h7.class) {
                            Context context = this.f8012a;
                            if (context != null && (g7Var = this.f8013b) != null) {
                                h7.c(context, g7Var.b());
                            }
                        }
                    }
                } catch (Throwable th2) {
                    u5.p(th2, "stm", "as");
                }
            } else if (i4 != 2) {
                if (i4 == 3) {
                    try {
                        if (this.f8012a == null) {
                            return;
                        }
                        b7 a4 = i7.a(h7.f8007d);
                        i7.f(this.f8012a, a4, r5.f8899h, 1000, 307200, "2");
                        if (a4.f7270g == null) {
                            a4.f7270g = new j7(new n7(this.f8012a, new k7(new o7(new q7()))));
                        }
                        a4.f7271h = 3600000;
                        if (TextUtils.isEmpty(a4.f7272i)) {
                            a4.f7272i = "cKey";
                        }
                        if (a4.f7269f == null) {
                            Context context2 = this.f8012a;
                            a4.f7269f = new v7(context2, a4.f7271h, a4.f7272i, new r7(a4.f7264a, new t7(context2, h7.f8004a, h7.f8006c * 1024, h7.f8005b * 1024, "staticUpdate", h7.f8008e * 1024)));
                        }
                        c7.a(a4);
                    } catch (Throwable th3) {
                        u5.p(th3, "stm", "usd");
                    }
                }
            } else {
                try {
                    synchronized (h7.class) {
                        if (this.f8015d != null && this.f8012a != null) {
                            ByteArrayOutputStream byteArrayOutputStream2 = null;
                            byte[] bArr = new byte[0];
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                for (g7 g7Var2 : this.f8015d) {
                                    if (g7Var2 != null) {
                                        byteArrayOutputStream.write(g7Var2.b());
                                    }
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable th5) {
                                    th = th5;
                                    th.printStackTrace();
                                    h7.c(this.f8012a, bArr);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    u5.p(th, "stm", "aStB");
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th7) {
                                            th = th7;
                                            th.printStackTrace();
                                            h7.c(this.f8012a, bArr);
                                        }
                                    }
                                    h7.c(this.f8012a, bArr);
                                } catch (Throwable th8) {
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th9) {
                                            th9.printStackTrace();
                                        }
                                    }
                                    throw th8;
                                }
                            }
                            h7.c(this.f8012a, bArr);
                        }
                    }
                } catch (Throwable th10) {
                    u5.p(th10, "stm", "apb");
                }
            }
        }

        a(Context context, int i4, List<g7> list) {
            this(context, i4);
            this.f8015d = list;
        }

        a(Context context, int i4, g7 g7Var) {
            this(context, i4);
            this.f8013b = g7Var;
        }
    }
}
