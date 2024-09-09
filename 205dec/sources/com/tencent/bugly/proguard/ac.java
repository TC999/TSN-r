package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public static int f50851a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static long f50852b = 259200000;

    /* renamed from: d  reason: collision with root package name */
    private static ac f50853d;

    /* renamed from: i  reason: collision with root package name */
    private static String f50854i;

    /* renamed from: c  reason: collision with root package name */
    public final ak f50855c;

    /* renamed from: e  reason: collision with root package name */
    private final List<o> f50856e;

    /* renamed from: f  reason: collision with root package name */
    private final StrategyBean f50857f;

    /* renamed from: g  reason: collision with root package name */
    private StrategyBean f50858g = null;

    /* renamed from: h  reason: collision with root package name */
    private Context f50859h;

    private ac(Context context, List<o> list) {
        this.f50859h = context;
        if (aa.a(context) != null) {
            String str = aa.a(context).H;
            if ("oversea".equals(str)) {
                StrategyBean.f50741a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.f50742b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.f50741a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.f50742b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
        this.f50857f = new StrategyBean();
        this.f50856e = list;
        this.f50855c = ak.a();
    }

    public static StrategyBean d() {
        byte[] bArr;
        List<y> a4 = w.a().a(2);
        if (a4 == null || a4.size() <= 0 || (bArr = a4.get(0).f51340g) == null) {
            return null;
        }
        return (StrategyBean) ap.a(bArr, StrategyBean.CREATOR);
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f50858g;
        if (strategyBean != null) {
            if (!ap.d(strategyBean.f50757q)) {
                this.f50858g.f50757q = StrategyBean.f50741a;
            }
            if (!ap.d(this.f50858g.f50758r)) {
                this.f50858g.f50758r = StrategyBean.f50742b;
            }
            return this.f50858g;
        }
        if (!ap.b(f50854i) && ap.d(f50854i)) {
            StrategyBean strategyBean2 = this.f50857f;
            String str = f50854i;
            strategyBean2.f50757q = str;
            strategyBean2.f50758r = str;
        }
        return this.f50857f;
    }

    public final synchronized boolean b() {
        return this.f50858g != null;
    }

    public static synchronized ac a(Context context, List<o> list) {
        ac acVar;
        synchronized (ac.class) {
            if (f50853d == null) {
                f50853d = new ac(context, list);
            }
            acVar = f50853d;
        }
        return acVar;
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            acVar = f50853d;
        }
        return acVar;
    }

    protected final void a(StrategyBean strategyBean, boolean z3) {
        al.c("[Strategy] Notify %s", s.class.getName());
        s.a(strategyBean, z3);
        for (o oVar : this.f50856e) {
            try {
                al.c("[Strategy] Notify %s", oVar.getClass().getName());
                oVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!ap.b(str) && ap.d(str)) {
            f50854i = str;
        } else {
            al.d("URL user set is invalid.", new Object[0]);
        }
    }

    public final void a(bt btVar) {
        if (btVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f50858g;
        if (strategyBean == null || btVar.f51198h != strategyBean.f50755o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f50746f = btVar.f51191a;
            strategyBean2.f50748h = btVar.f51193c;
            strategyBean2.f50747g = btVar.f51192b;
            if (ap.b(f50854i) || !ap.d(f50854i)) {
                if (ap.d(btVar.f51194d)) {
                    al.c("[Strategy] Upload url changes to %s", btVar.f51194d);
                    strategyBean2.f50757q = btVar.f51194d;
                }
                if (ap.d(btVar.f51195e)) {
                    al.c("[Strategy] Exception upload url changes to %s", btVar.f51195e);
                    strategyBean2.f50758r = btVar.f51195e;
                }
            }
            bs bsVar = btVar.f51196f;
            if (bsVar != null && !ap.b(bsVar.f51186a)) {
                strategyBean2.f50759s = btVar.f51196f.f51186a;
            }
            long j4 = btVar.f51198h;
            if (j4 != 0) {
                strategyBean2.f50755o = j4;
            }
            Map<String, String> map = btVar.f51197g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = btVar.f51197g;
                strategyBean2.f50760t = map2;
                String str = map2.get("B11");
                strategyBean2.f50749i = str != null && str.equals("1");
                String str2 = btVar.f51197g.get("B3");
                if (str2 != null) {
                    strategyBean2.f50763w = Long.parseLong(str2);
                }
                int i4 = btVar.f51202l;
                strategyBean2.f50756p = i4;
                strategyBean2.f50762v = i4;
                String str3 = btVar.f51197g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.f50761u = parseInt;
                        }
                    } catch (Exception e4) {
                        if (!al.a(e4)) {
                            e4.printStackTrace();
                        }
                    }
                }
                String str4 = btVar.f51197g.get("B25");
                strategyBean2.f50751k = str4 != null && str4.equals("1");
            }
            al.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f50746f), Boolean.valueOf(strategyBean2.f50748h), Boolean.valueOf(strategyBean2.f50747g), Boolean.valueOf(strategyBean2.f50749i), Boolean.valueOf(strategyBean2.f50750j), Boolean.valueOf(strategyBean2.f50753m), Boolean.valueOf(strategyBean2.f50754n), Long.valueOf(strategyBean2.f50756p), Boolean.valueOf(strategyBean2.f50751k), Long.valueOf(strategyBean2.f50755o));
            this.f50858g = strategyBean2;
            if (!ap.d(btVar.f51194d)) {
                al.c("[Strategy] download url is null", new Object[0]);
                this.f50858g.f50757q = "";
            }
            if (!ap.d(btVar.f51195e)) {
                al.c("[Strategy] download crashurl is null", new Object[0]);
                this.f50858g.f50758r = "";
            }
            w.a().b(2);
            y yVar = new y();
            yVar.f51335b = 2;
            yVar.f51334a = strategyBean2.f50744d;
            yVar.f51338e = strategyBean2.f50745e;
            yVar.f51340g = ap.a(strategyBean2);
            w.a().a(yVar);
            a(strategyBean2, true);
        }
    }
}
