package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* compiled from: StatisticsManager.java */
/* renamed from: com.amap.api.col.s.h3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2070h3 {

    /* renamed from: a */
    static boolean f6163a = false;

    /* renamed from: b */
    static int f6164b = 20;

    /* renamed from: c */
    private static int f6165c = 20;

    /* renamed from: d */
    private static WeakReference<C2032c3> f6166d;

    /* renamed from: e */
    private static int f6167e;

    /* renamed from: b */
    public static void m52945b(Context context) {
        C2225y3.m52184e().m53246c(new C2071a(context, C2071a.f6170h));
    }

    /* renamed from: c */
    static /* synthetic */ void m52944c(Context context, byte[] bArr) throws IOException {
        C2032c3 m52901a = C2076i3.m52901a(f6166d);
        C2076i3.m52897e(context, m52901a, C2051e2.f6097h, 1000, 307200, "2");
        if (m52901a.f5975e == null) {
            m52901a.f5975e = new C2086k2();
        }
        Random random = new Random();
        try {
            C2042d3.m53082c(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, m52901a);
        } catch (Throwable th) {
            C2060g2.m52972o(th, ConstantHelper.LOG_STM, "wts");
        }
    }

    /* renamed from: d */
    public static synchronized void m52943d(C2064g3 c2064g3, Context context) {
        synchronized (C2070h3.class) {
            C2225y3.m52184e().m53246c(new C2071a(context, C2071a.f6168f, c2064g3));
        }
    }

    /* renamed from: e */
    public static synchronized void m52942e(List<C2064g3> list, Context context) {
        synchronized (C2070h3.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        C2225y3.m52184e().m53246c(new C2071a(context, C2071a.f6169g, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StatisticsManager.java */
    /* renamed from: com.amap.api.col.s.h3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2071a extends AbstractRunnableC2229z3 {

        /* renamed from: f */
        static int f6168f = 1;

        /* renamed from: g */
        static int f6169g = 2;

        /* renamed from: h */
        static int f6170h = 3;

        /* renamed from: b */
        private Context f6171b;

        /* renamed from: c */
        private C2064g3 f6172c;

        /* renamed from: d */
        private int f6173d;

        /* renamed from: e */
        private List<C2064g3> f6174e;

        C2071a(Context context, int i) {
            this.f6171b = context;
            this.f6173d = i;
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            C2064g3 c2064g3;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            int i = this.f6173d;
            if (i == 1) {
                try {
                    if (this.f6171b != null && this.f6172c != null) {
                        synchronized (C2070h3.class) {
                            Context context = this.f6171b;
                            if (context != null && (c2064g3 = this.f6172c) != null) {
                                C2070h3.m52944c(context, c2064g3.m52970b());
                            }
                        }
                    }
                } catch (Throwable th2) {
                    C2060g2.m52972o(th2, ConstantHelper.LOG_STM, CommonNetImpl.f39530AS);
                }
            } else if (i != 2) {
                if (i == 3) {
                    try {
                        if (this.f6171b == null) {
                            return;
                        }
                        C2032c3 m52901a = C2076i3.m52901a(C2070h3.f6166d);
                        C2076i3.m52897e(this.f6171b, m52901a, C2051e2.f6097h, 1000, 307200, "2");
                        if (m52901a.f5977g == null) {
                            m52901a.f5977g = new C2081j3(new C2103n3(this.f6171b, new C2087k3(new C2109o3(new C2125q3()))));
                        }
                        m52901a.f5978h = 3600000;
                        if (TextUtils.isEmpty(m52901a.f5979i)) {
                            m52901a.f5979i = "cKey";
                        }
                        if (m52901a.f5976f == null) {
                            Context context2 = this.f6171b;
                            m52901a.f5976f = new C2165u3(context2, m52901a.f5978h, m52901a.f5979i, new C2137r3(m52901a.f5971a, new C2142s3(context2, C2070h3.f6163a, C2070h3.f6165c * 1024, C2070h3.f6164b * 1024, "staticUpdate", C2070h3.f6167e * 1024)));
                        }
                        C2042d3.m53084a(m52901a);
                    } catch (Throwable th3) {
                        C2060g2.m52972o(th3, ConstantHelper.LOG_STM, "usd");
                    }
                }
            } else {
                try {
                    synchronized (C2070h3.class) {
                        if (this.f6174e != null && this.f6171b != null) {
                            ByteArrayOutputStream byteArrayOutputStream2 = null;
                            byte[] bArr = new byte[0];
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                for (C2064g3 c2064g32 : this.f6174e) {
                                    if (c2064g32 != null) {
                                        byteArrayOutputStream.write(c2064g32.m52970b());
                                    }
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable th5) {
                                    th = th5;
                                    th.printStackTrace();
                                    C2070h3.m52944c(this.f6171b, bArr);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    C2060g2.m52972o(th, ConstantHelper.LOG_STM, "aStB");
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th7) {
                                            th = th7;
                                            th.printStackTrace();
                                            C2070h3.m52944c(this.f6171b, bArr);
                                        }
                                    }
                                    C2070h3.m52944c(this.f6171b, bArr);
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
                            C2070h3.m52944c(this.f6171b, bArr);
                        }
                    }
                } catch (Throwable th10) {
                    C2060g2.m52972o(th10, ConstantHelper.LOG_STM, "apb");
                }
            }
        }

        C2071a(Context context, int i, List<C2064g3> list) {
            this(context, i);
            this.f6174e = list;
        }

        C2071a(Context context, int i, C2064g3 c2064g3) {
            this(context, i);
            this.f6172c = c2064g3;
        }
    }
}
