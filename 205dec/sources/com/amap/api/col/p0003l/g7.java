package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: StatisticsEntity.java */
/* renamed from: com.amap.api.col.3l.g7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g7 {

    /* renamed from: a  reason: collision with root package name */
    private Context f7878a;

    /* renamed from: b  reason: collision with root package name */
    private String f7879b;

    /* renamed from: c  reason: collision with root package name */
    private String f7880c;

    /* renamed from: d  reason: collision with root package name */
    private String f7881d;

    /* renamed from: e  reason: collision with root package name */
    private String f7882e;

    public g7(Context context, String str, String str2, String str3) throws fk {
        if (!TextUtils.isEmpty(str3) && str3.length() <= 256) {
            this.f7878a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f7880c = str;
            this.f7881d = str2;
            this.f7879b = str3;
            return;
        }
        throw new fk("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    private static byte[] c(int i4) {
        return new byte[]{(byte) ((i4 >> 24) & 255), (byte) ((i4 >> 16) & 255), (byte) ((i4 >> 8) & 255), (byte) (i4 & 255)};
    }

    private byte[] d(String str) {
        byte[] o4;
        if (!TextUtils.isEmpty(str) && (o4 = q4.o(this.f7882e)) != null) {
            return q4.n(o4.length);
        }
        return new byte[]{0, 0};
    }

    public final void a(String str) throws fk {
        if (!TextUtils.isEmpty(str) && str.length() <= 65536) {
            this.f7882e = str;
            return;
        }
        throw new fk("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    public final byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream;
        int i4 = 0;
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            q4.k(byteArrayOutputStream, this.f7880c);
            q4.k(byteArrayOutputStream, this.f7881d);
            q4.k(byteArrayOutputStream, this.f7879b);
            q4.k(byteArrayOutputStream, String.valueOf(i4.M(this.f7878a)));
            try {
                i4 = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable unused) {
            }
            byteArrayOutputStream.write(c(i4));
            byteArrayOutputStream.write(d(this.f7882e));
            byteArrayOutputStream.write(q4.o(this.f7882e));
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                u5.p(th, "se", "tds");
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                return bArr;
            } catch (Throwable th4) {
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th4;
            }
        }
        return bArr;
    }

    /* compiled from: StatisticsManager.java */
    /* renamed from: com.amap.api.col.3l.g7$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class a extends z7 {

        /* renamed from: e  reason: collision with root package name */
        static int f7883e = 1;

        /* renamed from: g  reason: collision with root package name */
        static int f7884g = 2;

        /* renamed from: h  reason: collision with root package name */
        static int f7885h = 3;

        /* renamed from: a  reason: collision with root package name */
        private Context f7886a;

        /* renamed from: b  reason: collision with root package name */
        private f7 f7887b;

        /* renamed from: c  reason: collision with root package name */
        private int f7888c;

        /* renamed from: d  reason: collision with root package name */
        private List<f7> f7889d;

        a(Context context, int i4) {
            this.f7886a = context;
            this.f7888c = i4;
        }

        /* JADX WARN: Type inference failed for: r13v0, types: [com.amap.api.col.3l.v7, com.amap.api.col.3l.q7] */
        /* JADX WARN: Type inference failed for: r15v0, types: [com.amap.api.col.3l.v7, com.amap.api.col.3l.s7] */
        /* JADX WARN: Type inference failed for: r2v11, types: [com.amap.api.col.3l.v7, com.amap.api.col.3l.u7] */
        /* JADX WARN: Type inference failed for: r2v13, types: [com.amap.api.col.3l.i7, com.amap.api.col.3l.o7] */
        /* JADX WARN: Type inference failed for: r3v23, types: [com.amap.api.col.3l.m7, com.amap.api.col.3l.o7] */
        /* JADX WARN: Type inference failed for: r5v4, types: [com.amap.api.col.3l.j7, com.amap.api.col.3l.o7] */
        /* JADX WARN: Type inference failed for: r6v3, types: [com.amap.api.col.3l.n7, com.amap.api.col.3l.o7] */
        /* JADX WARN: Type inference failed for: r7v2, types: [com.amap.api.col.3l.p7, com.amap.api.col.3l.o7] */
        public final void runTask() {
            f7 f7Var;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            int i4 = this.f7888c;
            if (i4 == 1) {
                try {
                    if (this.f7886a != null && this.f7887b != null) {
                        synchronized (g7.class) {
                            Context context = this.f7886a;
                            if (context != null && (f7Var = this.f7887b) != null) {
                                g7.c(context, f7Var.b());
                            }
                        }
                    }
                } catch (Throwable th2) {
                    t5.p(th2, "stm", "as");
                }
            } else if (i4 != 2) {
                if (i4 == 3) {
                    try {
                        if (this.f7886a == null) {
                            return;
                        }
                        a7 a4 = h7.a(g7.a());
                        h7.f(this.f7886a, a4, q5.h, 1000, 307200, "2");
                        if (a4.g == null) {
                            a4.g = new i7(new m7(this.f7886a, new j7((o7) new n7(new p7()))));
                        }
                        a4.h = 3600000;
                        if (TextUtils.isEmpty(a4.i)) {
                            a4.i = "cKey";
                        }
                        if (a4.f == null) {
                            Context context2 = this.f7886a;
                            a4.f = new u7(context2, a4.h, a4.i, new q7(a4.a, new s7(context2, g7.a, g7.g() * 1024, g7.b * 1024, "staticUpdate", g7.i() * 1024)));
                        }
                        b7.a(a4);
                    } catch (Throwable th3) {
                        t5.p(th3, "stm", "usd");
                    }
                }
            } else {
                try {
                    synchronized (g7.class) {
                        if (this.f7889d != null && this.f7886a != null) {
                            ByteArrayOutputStream byteArrayOutputStream2 = null;
                            byte[] bArr = new byte[0];
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                for (f7 f7Var2 : this.f7889d) {
                                    if (f7Var2 != null) {
                                        byteArrayOutputStream.write(f7Var2.b());
                                    }
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable th5) {
                                    th = th5;
                                    th.printStackTrace();
                                    g7.c(this.f7886a, bArr);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    t5.p(th, "stm", "aStB");
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th7) {
                                            th = th7;
                                            th.printStackTrace();
                                            g7.c(this.f7886a, bArr);
                                        }
                                    }
                                    g7.c(this.f7886a, bArr);
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
                            g7.c(this.f7886a, bArr);
                        }
                    }
                } catch (Throwable th10) {
                    t5.p(th10, "stm", "apb");
                }
            }
        }

        a(Context context, int i4, List<f7> list) {
            this(context, i4);
            this.f7889d = list;
        }

        a(Context context, int i4, f7 f7Var) {
            this(context, i4);
            this.f7887b = f7Var;
        }
    }
}
