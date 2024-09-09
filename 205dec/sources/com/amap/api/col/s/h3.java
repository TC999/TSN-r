package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StatisticsManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class h3 {

    /* renamed from: a  reason: collision with root package name */
    static boolean f9891a = false;

    /* renamed from: b  reason: collision with root package name */
    static int f9892b = 20;

    /* renamed from: c  reason: collision with root package name */
    private static int f9893c = 20;

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference<c3> f9894d;

    /* renamed from: e  reason: collision with root package name */
    private static int f9895e;

    public static void b(Context context) {
        y3.e().c(new a(context, a.f9898h));
    }

    static /* synthetic */ void c(Context context, byte[] bArr) throws IOException {
        c3 a4 = i3.a(f9894d);
        i3.e(context, a4, e2.f9825h, 1000, 307200, "2");
        if (a4.f9703e == null) {
            a4.f9703e = new k2();
        }
        Random random = new Random();
        try {
            d3.c(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a4);
        } catch (Throwable th) {
            g2.o(th, "stm", "wts");
        }
    }

    public static synchronized void d(g3 g3Var, Context context) {
        synchronized (h3.class) {
            y3.e().c(new a(context, a.f9896f, g3Var));
        }
    }

    public static synchronized void e(List<g3> list, Context context) {
        synchronized (h3.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        y3.e().c(new a(context, a.f9897g, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: StatisticsManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a extends z3 {

        /* renamed from: f  reason: collision with root package name */
        static int f9896f = 1;

        /* renamed from: g  reason: collision with root package name */
        static int f9897g = 2;

        /* renamed from: h  reason: collision with root package name */
        static int f9898h = 3;

        /* renamed from: b  reason: collision with root package name */
        private Context f9899b;

        /* renamed from: c  reason: collision with root package name */
        private g3 f9900c;

        /* renamed from: d  reason: collision with root package name */
        private int f9901d;

        /* renamed from: e  reason: collision with root package name */
        private List<g3> f9902e;

        a(Context context, int i4) {
            this.f9899b = context;
            this.f9901d = i4;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            g3 g3Var;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            int i4 = this.f9901d;
            if (i4 == 1) {
                try {
                    if (this.f9899b != null && this.f9900c != null) {
                        synchronized (h3.class) {
                            Context context = this.f9899b;
                            if (context != null && (g3Var = this.f9900c) != null) {
                                h3.c(context, g3Var.b());
                            }
                        }
                    }
                } catch (Throwable th2) {
                    g2.o(th2, "stm", "as");
                }
            } else if (i4 != 2) {
                if (i4 == 3) {
                    try {
                        if (this.f9899b == null) {
                            return;
                        }
                        c3 a4 = i3.a(h3.f9894d);
                        i3.e(this.f9899b, a4, e2.f9825h, 1000, 307200, "2");
                        if (a4.f9705g == null) {
                            a4.f9705g = new j3(new n3(this.f9899b, new k3(new o3(new q3()))));
                        }
                        a4.f9706h = 3600000;
                        if (TextUtils.isEmpty(a4.f9707i)) {
                            a4.f9707i = "cKey";
                        }
                        if (a4.f9704f == null) {
                            Context context2 = this.f9899b;
                            a4.f9704f = new u3(context2, a4.f9706h, a4.f9707i, new r3(a4.f9699a, new s3(context2, h3.f9891a, h3.f9893c * 1024, h3.f9892b * 1024, "staticUpdate", h3.f9895e * 1024)));
                        }
                        d3.a(a4);
                    } catch (Throwable th3) {
                        g2.o(th3, "stm", "usd");
                    }
                }
            } else {
                try {
                    synchronized (h3.class) {
                        if (this.f9902e != null && this.f9899b != null) {
                            ByteArrayOutputStream byteArrayOutputStream2 = null;
                            byte[] bArr = new byte[0];
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                for (g3 g3Var2 : this.f9902e) {
                                    if (g3Var2 != null) {
                                        byteArrayOutputStream.write(g3Var2.b());
                                    }
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable th5) {
                                    th = th5;
                                    th.printStackTrace();
                                    h3.c(this.f9899b, bArr);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    g2.o(th, "stm", "aStB");
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th7) {
                                            th = th7;
                                            th.printStackTrace();
                                            h3.c(this.f9899b, bArr);
                                        }
                                    }
                                    h3.c(this.f9899b, bArr);
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
                            h3.c(this.f9899b, bArr);
                        }
                    }
                } catch (Throwable th10) {
                    g2.o(th10, "stm", "apb");
                }
            }
        }

        a(Context context, int i4, List<g3> list) {
            this(context, i4);
            this.f9902e = list;
        }

        a(Context context, int i4, g3 g3Var) {
            this(context, i4);
            this.f9900c = g3Var;
        }
    }
}
