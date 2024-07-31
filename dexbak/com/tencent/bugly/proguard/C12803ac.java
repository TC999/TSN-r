package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ac */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12803ac {

    /* renamed from: a */
    public static int f36477a = 1000;

    /* renamed from: b */
    public static long f36478b = 259200000;

    /* renamed from: d */
    private static C12803ac f36479d;

    /* renamed from: i */
    private static String f36480i;

    /* renamed from: c */
    public final C12818ak f36481c;

    /* renamed from: e */
    private final List<AbstractC12903o> f36482e;

    /* renamed from: f */
    private final StrategyBean f36483f;

    /* renamed from: g */
    private StrategyBean f36484g = null;

    /* renamed from: h */
    private Context f36485h;

    private C12803ac(Context context, List<AbstractC12903o> list) {
        this.f36485h = context;
        if (C12786aa.m16009a(context) != null) {
            String str = C12786aa.m16009a(context).f36406H;
            if ("oversea".equals(str)) {
                StrategyBean.f36291a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.f36292b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.f36291a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.f36292b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
        this.f36483f = new StrategyBean();
        this.f36482e = list;
        this.f36481c = C12818ak.m15887a();
    }

    /* renamed from: d */
    public static StrategyBean m15940d() {
        byte[] bArr;
        List<C12923y> m15508a = C12920w.m15509a().m15508a(2);
        if (m15508a == null || m15508a.size() <= 0 || (bArr = m15508a.get(0).f36974g) == null) {
            return null;
        }
        return (StrategyBean) C12828ap.m15824a(bArr, StrategyBean.CREATOR);
    }

    /* renamed from: c */
    public final StrategyBean m15941c() {
        StrategyBean strategyBean = this.f36484g;
        if (strategyBean != null) {
            if (!C12828ap.m15809d(strategyBean.f36307q)) {
                this.f36484g.f36307q = StrategyBean.f36291a;
            }
            if (!C12828ap.m15809d(this.f36484g.f36308r)) {
                this.f36484g.f36308r = StrategyBean.f36292b;
            }
            return this.f36484g;
        }
        if (!C12828ap.m15817b(f36480i) && C12828ap.m15809d(f36480i)) {
            StrategyBean strategyBean2 = this.f36483f;
            String str = f36480i;
            strategyBean2.f36307q = str;
            strategyBean2.f36308r = str;
        }
        return this.f36483f;
    }

    /* renamed from: b */
    public final synchronized boolean m15943b() {
        return this.f36484g != null;
    }

    /* renamed from: a */
    public static synchronized C12803ac m15949a(Context context, List<AbstractC12903o> list) {
        C12803ac c12803ac;
        synchronized (C12803ac.class) {
            if (f36479d == null) {
                f36479d = new C12803ac(context, list);
            }
            c12803ac = f36479d;
        }
        return c12803ac;
    }

    /* renamed from: a */
    public static synchronized C12803ac m15950a() {
        C12803ac c12803ac;
        synchronized (C12803ac.class) {
            c12803ac = f36479d;
        }
        return c12803ac;
    }

    /* renamed from: a */
    protected final void m15948a(StrategyBean strategyBean, boolean z) {
        C12820al.m15874c("[Strategy] Notify %s", C12912s.class.getName());
        C12912s.m15541a(strategyBean, z);
        for (AbstractC12903o abstractC12903o : this.f36482e) {
            try {
                C12820al.m15874c("[Strategy] Notify %s", abstractC12903o.getClass().getName());
                abstractC12903o.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m15944a(String str) {
        if (!C12828ap.m15817b(str) && C12828ap.m15809d(str)) {
            f36480i = str;
        } else {
            C12820al.m15873d("URL user set is invalid.", new Object[0]);
        }
    }

    /* renamed from: a */
    public final void m15945a(C12887bt c12887bt) {
        if (c12887bt == null) {
            return;
        }
        StrategyBean strategyBean = this.f36484g;
        if (strategyBean == null || c12887bt.f36831h != strategyBean.f36305o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f36296f = c12887bt.f36824a;
            strategyBean2.f36298h = c12887bt.f36826c;
            strategyBean2.f36297g = c12887bt.f36825b;
            if (C12828ap.m15817b(f36480i) || !C12828ap.m15809d(f36480i)) {
                if (C12828ap.m15809d(c12887bt.f36827d)) {
                    C12820al.m15874c("[Strategy] Upload url changes to %s", c12887bt.f36827d);
                    strategyBean2.f36307q = c12887bt.f36827d;
                }
                if (C12828ap.m15809d(c12887bt.f36828e)) {
                    C12820al.m15874c("[Strategy] Exception upload url changes to %s", c12887bt.f36828e);
                    strategyBean2.f36308r = c12887bt.f36828e;
                }
            }
            C12886bs c12886bs = c12887bt.f36829f;
            if (c12886bs != null && !C12828ap.m15817b(c12886bs.f36819a)) {
                strategyBean2.f36309s = c12887bt.f36829f.f36819a;
            }
            long j = c12887bt.f36831h;
            if (j != 0) {
                strategyBean2.f36305o = j;
            }
            Map<String, String> map = c12887bt.f36830g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = c12887bt.f36830g;
                strategyBean2.f36310t = map2;
                String str = map2.get("B11");
                strategyBean2.f36299i = str != null && str.equals("1");
                String str2 = c12887bt.f36830g.get("B3");
                if (str2 != null) {
                    strategyBean2.f36313w = Long.parseLong(str2);
                }
                int i = c12887bt.f36835l;
                strategyBean2.f36306p = i;
                strategyBean2.f36312v = i;
                String str3 = c12887bt.f36830g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.f36311u = parseInt;
                        }
                    } catch (Exception e) {
                        if (!C12820al.m15877a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                String str4 = c12887bt.f36830g.get("B25");
                strategyBean2.f36301k = str4 != null && str4.equals("1");
            }
            C12820al.m15878a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f36296f), Boolean.valueOf(strategyBean2.f36298h), Boolean.valueOf(strategyBean2.f36297g), Boolean.valueOf(strategyBean2.f36299i), Boolean.valueOf(strategyBean2.f36300j), Boolean.valueOf(strategyBean2.f36303m), Boolean.valueOf(strategyBean2.f36304n), Long.valueOf(strategyBean2.f36306p), Boolean.valueOf(strategyBean2.f36301k), Long.valueOf(strategyBean2.f36305o));
            this.f36484g = strategyBean2;
            if (!C12828ap.m15809d(c12887bt.f36827d)) {
                C12820al.m15874c("[Strategy] download url is null", new Object[0]);
                this.f36484g.f36307q = "";
            }
            if (!C12828ap.m15809d(c12887bt.f36828e)) {
                C12820al.m15874c("[Strategy] download crashurl is null", new Object[0]);
                this.f36484g.f36308r = "";
            }
            C12920w.m15509a().m15487b(2);
            C12923y c12923y = new C12923y();
            c12923y.f36969b = 2;
            c12923y.f36968a = strategyBean2.f36294d;
            c12923y.f36972e = strategyBean2.f36295e;
            c12923y.f36974g = C12828ap.m15840a(strategyBean2);
            C12920w.m15509a().m15495a(c12923y);
            m15948a(strategyBean2, true);
        }
    }
}
