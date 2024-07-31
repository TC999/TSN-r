package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* renamed from: com.amap.api.col.3l.g7 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class StatisticsManager {

    /* renamed from: a */
    static boolean f4281a = false;

    /* renamed from: b */
    static int f4282b = 20;

    /* renamed from: c */
    private static int f4283c = 20;

    /* renamed from: d */
    private static WeakReference<LogConfig> f4284d;

    /* renamed from: e */
    private static int f4285e;

    /* renamed from: b */
    public static void m54913b(Context context) {
        ThreadPool.m53398h().m55654b(new C1821a(context, C1821a.f4288h));
    }

    /* renamed from: c */
    static /* synthetic */ void m54912c(Context context, byte[] bArr) throws IOException {
        LogConfig m54750a = Utils.m54750a(f4284d);
        Utils.m54745f(context, m54750a, Log.f5125h, 1000, 307200, "2");
        if (m54750a.f3558e == null) {
            m54750a.f3558e = new NoneEncryptProcessor();
        }
        Random random = new Random();
        try {
            LogEngine.m55539c(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, m54750a);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, ConstantHelper.LOG_STM, "wts");
        }
    }

    /* renamed from: d */
    public static synchronized void m54911d(StatisticsEntity statisticsEntity, Context context) {
        synchronized (StatisticsManager.class) {
            ThreadPool.m53398h().m55654b(new C1821a(context, C1821a.f4286e, statisticsEntity));
        }
    }

    /* renamed from: e */
    public static synchronized void m54910e(List<StatisticsEntity> list, Context context) {
        synchronized (StatisticsManager.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        ThreadPool.m53398h().m55654b(new C1821a(context, C1821a.f4287g, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: f */
    public static synchronized void m54909f(boolean z, int i) {
        synchronized (StatisticsManager.class) {
            f4281a = z;
            f4285e = Math.max(0, i);
        }
    }

    /* renamed from: h */
    public static synchronized void m54907h(List<StatisticsEntity> list, Context context) {
        synchronized (StatisticsManager.class) {
            try {
                List<StatisticsEntity> m53844q = HttpLimitUtil.m53844q();
                if (m53844q != null && m53844q.size() > 0) {
                    list.addAll(m53844q);
                }
            } catch (Throwable unused) {
            }
            m54910e(list, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StatisticsManager.java */
    /* renamed from: com.amap.api.col.3l.g7$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1821a extends ThreadTask {

        /* renamed from: e */
        static int f4286e = 1;

        /* renamed from: g */
        static int f4287g = 2;

        /* renamed from: h */
        static int f4288h = 3;

        /* renamed from: a */
        private Context f4289a;

        /* renamed from: b */
        private StatisticsEntity f4290b;

        /* renamed from: c */
        private int f4291c;

        /* renamed from: d */
        private List<StatisticsEntity> f4292d;

        C1821a(Context context, int i) {
            this.f4289a = context;
            this.f4291c = i;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            StatisticsEntity statisticsEntity;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            int i = this.f4291c;
            if (i == 1) {
                try {
                    if (this.f4289a != null && this.f4290b != null) {
                        synchronized (StatisticsManager.class) {
                            Context context = this.f4289a;
                            if (context != null && (statisticsEntity = this.f4290b) != null) {
                                StatisticsManager.m54912c(context, statisticsEntity.m55024b());
                            }
                        }
                    }
                } catch (Throwable th2) {
                    SDKLogHandler.m53863p(th2, ConstantHelper.LOG_STM, CommonNetImpl.f39530AS);
                }
            } else if (i != 2) {
                if (i == 3) {
                    try {
                        if (this.f4289a == null) {
                            return;
                        }
                        LogConfig m54750a = Utils.m54750a(StatisticsManager.f4284d);
                        Utils.m54745f(this.f4289a, m54750a, Log.f5125h, 1000, 307200, "2");
                        if (m54750a.f3560g == null) {
                            m54750a.f3560g = new ByteJoinDataStrategy(new StatisticsHeaderDataStrategy(this.f4289a, new EncryptRsaDataStrategy(new StatisticsPubDataStrategy(new ZipUpdateDataStrategy()))));
                        }
                        m54750a.f3561h = 3600000;
                        if (TextUtils.isEmpty(m54750a.f3562i)) {
                            m54750a.f3562i = "cKey";
                        }
                        if (m54750a.f3559f == null) {
                            Context context2 = this.f4289a;
                            m54750a.f3559f = new TimeUpdateStrategy(context2, m54750a.f3561h, m54750a.f3562i, new FileNumUpdateStrategy(m54750a.f3554a, new MobileUpdateStrategy(context2, StatisticsManager.f4281a, StatisticsManager.f4283c * 1024, StatisticsManager.f4282b * 1024, "staticUpdate", StatisticsManager.f4285e * 1024)));
                        }
                        LogEngine.m55541a(m54750a);
                    } catch (Throwable th3) {
                        SDKLogHandler.m53863p(th3, ConstantHelper.LOG_STM, "usd");
                    }
                }
            } else {
                try {
                    synchronized (StatisticsManager.class) {
                        if (this.f4292d != null && this.f4289a != null) {
                            ByteArrayOutputStream byteArrayOutputStream2 = null;
                            byte[] bArr = new byte[0];
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                for (StatisticsEntity statisticsEntity2 : this.f4292d) {
                                    if (statisticsEntity2 != null) {
                                        byteArrayOutputStream.write(statisticsEntity2.m55024b());
                                    }
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable th5) {
                                    th = th5;
                                    th.printStackTrace();
                                    StatisticsManager.m54912c(this.f4289a, bArr);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    SDKLogHandler.m53863p(th, ConstantHelper.LOG_STM, "aStB");
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th7) {
                                            th = th7;
                                            th.printStackTrace();
                                            StatisticsManager.m54912c(this.f4289a, bArr);
                                        }
                                    }
                                    StatisticsManager.m54912c(this.f4289a, bArr);
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
                            StatisticsManager.m54912c(this.f4289a, bArr);
                        }
                    }
                } catch (Throwable th10) {
                    SDKLogHandler.m53863p(th10, ConstantHelper.LOG_STM, "apb");
                }
            }
        }

        C1821a(Context context, int i, List<StatisticsEntity> list) {
            this(context, i);
            this.f4292d = list;
        }

        C1821a(Context context, int i, StatisticsEntity statisticsEntity) {
            this(context, i);
            this.f4290b = statisticsEntity;
        }
    }
}
