package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.h;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class x {
    private static AtomicInteger aPg = new AtomicInteger(0);
    private static volatile boolean aPh = false;
    private static volatile boolean aPi;

    public static void LA() {
        Lt();
        int i4 = aPg.get();
        int Lz = Lz();
        boolean z3 = i4 != Lz;
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "needTransfer:" + z3);
        if (z3) {
            transfer(Lz);
        }
    }

    private static void LB() {
        g.execute(new ay() { // from class: com.kwad.sdk.utils.x.4
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                Context context;
                try {
                    context = y.getContext();
                } catch (Exception e4) {
                    com.kwad.sdk.core.e.c.e("Ks_UnionHelper", Log.getStackTraceString(e4));
                }
                if (context == null) {
                    return;
                }
                for (String str : h.a.akI) {
                    x.Q(context, str);
                }
                x.dZ(0);
                x.aPg.set(0);
            }
        });
    }

    private static void LC() {
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "transferToKv");
        g.execute(new ay() { // from class: com.kwad.sdk.utils.x.5
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                try {
                    Context context = y.getContext();
                    if (context != null) {
                        for (String str : h.a.akI) {
                            x.P(context, str);
                        }
                        x.dZ(1);
                        x.aPg.set(1);
                    }
                } catch (Exception e4) {
                    com.kwad.sdk.core.e.c.e("Ks_UnionHelper", Log.getStackTraceString(e4));
                }
            }
        });
    }

    private static int Ls() {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.e.c.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int yN = hVar.yN();
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "config mode:" + yN);
        return yN;
    }

    private static void Lt() {
        if (aPh) {
            return;
        }
        aPg.set(Lw());
        aPi = bf.m("kssdk_kv_mode", "downgrade", false);
        aPh = true;
    }

    public static void Lu() {
        if (Lx() || Ls() == 0) {
            return;
        }
        g.execute(new ay() { // from class: com.kwad.sdk.utils.x.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.utils.b.a Lv = x.Lv();
                if (Lv == null) {
                    return;
                }
                x.c(Lv);
                com.kwad.sdk.utils.b.b bVar = (com.kwad.sdk.utils.b.b) ServiceProvider.get(com.kwad.sdk.utils.b.b.class);
                if (bVar != null) {
                    bVar.a(Lv);
                }
            }
        });
    }

    @WorkerThread
    public static com.kwad.sdk.utils.b.a Lv() {
        Map<String, ?> all;
        com.kwad.sdk.utils.b.a aVar = new com.kwad.sdk.utils.b.a();
        SharedPreferences gO = bf.gO("ksadsdk_kv_perf");
        if (gO == null) {
            return null;
        }
        try {
            all = gO.getAll();
        } catch (Throwable unused) {
        }
        if (all == null) {
            return null;
        }
        int i4 = 0;
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            i4 += ((Integer) entry.getValue()).intValue();
        }
        aVar.aSj = i4;
        SharedPreferences.Editor edit = gO.edit();
        for (Map.Entry<String, ?> entry2 : all.entrySet()) {
            edit.putInt(entry2.getKey(), 0);
        }
        edit.apply();
        d(aVar);
        e(aVar);
        return aVar;
    }

    private static int Lw() {
        int b4 = bf.b("kssdk_kv_mode", "mode", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "local mode:" + b4);
        return b4;
    }

    public static boolean Lx() {
        Lt();
        return aPg.get() == 0;
    }

    private static boolean Ly() {
        return Build.VERSION.SDK_INT > 23;
    }

    private static int Lz() {
        Lt();
        int Ls = (aPi || !Ly()) ? 0 : Ls();
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "targetMode:" + Ls);
        return Ls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(Context context, String str) {
        SharedPreferences gO;
        com.kwad.sdk.utils.a.c av = com.kwad.sdk.utils.a.e.av(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (gO = bf.gO(str)) == null) {
            SharedPreferences.Editor edit = gO.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
            }
        } else if (av.contains("sp_to_kv_transfer_flag")) {
        } else {
            SharedPreferences gO2 = bf.gO(str);
            if (gO2 == null) {
                av.putBoolean("sp_to_kv_transfer_flag", true);
                return;
            }
            av.putAll(gO2.getAll());
            av.putBoolean("sp_to_kv_transfer_flag", true);
            bf.au(str, "kv_to_sp_transfer_flag");
            a(str, av);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(Context context, String str) {
        SharedPreferences gO = bf.gO(str);
        if (gO == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor edit = gO.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
            }
        } else if (gO.contains("kv_to_sp_transfer_flag")) {
        } else {
            com.kwad.sdk.utils.a.c av = com.kwad.sdk.utils.a.e.av(context, str);
            Map<String, Object> all = av.getAll();
            if (all.isEmpty()) {
                bf.l(str, "kv_to_sp_transfer_flag", true);
                return;
            }
            bf.a(str, all);
            bf.l(str, "kv_to_sp_transfer_flag", true);
            av.remove("sp_to_kv_transfer_flag");
            av.release();
        }
    }

    private static void a(String str, com.kwad.sdk.utils.a.c cVar) {
        if (h.a.akJ.contains(str)) {
            return;
        }
        cVar.release();
    }

    @WorkerThread
    public static void as(final String str, final String str2) {
        g.execute(new ay() { // from class: com.kwad.sdk.utils.x.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                int b4 = bf.b("ksadsdk_kv_perf", str, 0);
                if (TextUtils.isEmpty(str2)) {
                    bf.au("ksadsdk_kv_perf", str);
                    return;
                }
                bf.a("ksadsdk_kv_perf", str, b4 + 1);
            }
        });
    }

    public static void at(final String str, final String str2) {
        g.execute(new ay() { // from class: com.kwad.sdk.utils.x.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                SharedPreferences gO = bf.gO("ksadsdk_kv_perf");
                if (gO != null && gO.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        bf.a("ksadsdk_kv_perf_failed", str, bf.b("ksadsdk_kv_perf_failed", str, 0) + 1);
                        return;
                    }
                    bf.a("ksadsdk_kv_perf_success", str, bf.b("ksadsdk_kv_perf_success", str, 0) + 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(@NonNull com.kwad.sdk.utils.b.a aVar) {
        int i4 = aVar.aSk;
        double d4 = i4;
        double d5 = i4 + aVar.aSl;
        Double.isNaN(d4);
        Double.isNaN(d5);
        if (d4 / d5 > 0.10000000149011612d) {
            aPi = true;
            com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "need downgrade");
            bf.l("kssdk_kv_mode", "downgrade", true);
        }
        if (aPi) {
            LA();
        }
    }

    private static void d(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences gO = bf.gO("ksadsdk_kv_perf_failed");
        int i4 = 0;
        if (gO != null) {
            Map<String, ?> all = gO.getAll();
            if (all != null) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    i4 += ((Integer) entry.getValue()).intValue();
                }
            }
            aVar.aSk = i4;
            SharedPreferences.Editor edit = gO.edit();
            edit.clear();
            edit.apply();
            return;
        }
        aVar.aSk = 0;
    }

    static void dZ(int i4) {
        bf.a("kssdk_kv_mode", "mode", i4);
    }

    private static void e(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences gO = bf.gO("ksadsdk_kv_perf_success");
        int i4 = 0;
        if (gO != null) {
            Map<String, ?> all = gO.getAll();
            if (all != null) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    i4 += ((Integer) entry.getValue()).intValue();
                }
            }
            aVar.aSl = i4;
            SharedPreferences.Editor edit = gO.edit();
            edit.clear();
            edit.apply();
            return;
        }
        aVar.aSl = 0;
    }

    private static void transfer(int i4) {
        if (i4 == 0) {
            LB();
        } else if (i4 == 1) {
            LC();
        }
    }
}
