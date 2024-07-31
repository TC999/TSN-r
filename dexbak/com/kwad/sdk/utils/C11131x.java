package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.C10769h;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.p450a.C10990c;
import com.kwad.sdk.utils.p450a.C10999e;
import com.kwad.sdk.utils.p451b.C11038a;
import com.kwad.sdk.utils.p451b.InterfaceC11039b;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwad.sdk.utils.x */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11131x {
    private static AtomicInteger aPg = new AtomicInteger(0);
    private static volatile boolean aPh = false;
    private static volatile boolean aPi;

    /* renamed from: LA */
    public static void m23664LA() {
        m23659Lt();
        int i = aPg.get();
        int m23653Lz = m23653Lz();
        boolean z = i != m23653Lz;
        C10331c.m26254d("Ks_UnionHelper", "needTransfer:" + z);
        if (z) {
            transfer(m23653Lz);
        }
    }

    /* renamed from: LB */
    private static void m23663LB() {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.utils.x.4
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                Context context;
                try {
                    context = C11137y.getContext();
                } catch (Exception e) {
                    C10331c.m26250e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
                if (context == null) {
                    return;
                }
                for (String str : C10769h.C10770a.akI) {
                    C11131x.m23651Q(context, str);
                }
                C11131x.m23643dZ(0);
                C11131x.aPg.set(0);
            }
        });
    }

    /* renamed from: LC */
    private static void m23662LC() {
        C10331c.m26254d("Ks_UnionHelper", "transferToKv");
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.utils.x.5
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                try {
                    Context context = C11137y.getContext();
                    if (context != null) {
                        for (String str : C10769h.C10770a.akI) {
                            C11131x.m23652P(context, str);
                        }
                        C11131x.m23643dZ(1);
                        C11131x.aPg.set(1);
                    }
                } catch (Exception e) {
                    C10331c.m26250e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
            }
        });
    }

    /* renamed from: Ls */
    private static int m23660Ls() {
        InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
        if (interfaceC10970h == null) {
            C10331c.m26246w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int mo24310yN = interfaceC10970h.mo24310yN();
        C10331c.m26254d("Ks_UnionHelper", "config mode:" + mo24310yN);
        return mo24310yN;
    }

    /* renamed from: Lt */
    private static void m23659Lt() {
        if (aPh) {
            return;
        }
        aPg.set(m23656Lw());
        aPi = C11052bf.m23926m("kssdk_kv_mode", "downgrade", false);
        aPh = true;
    }

    /* renamed from: Lu */
    public static void m23658Lu() {
        if (m23655Lx() || m23660Ls() == 0) {
            return;
        }
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.utils.x.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C11038a m23657Lv = C11131x.m23657Lv();
                if (m23657Lv == null) {
                    return;
                }
                C11131x.m23645c(m23657Lv);
                InterfaceC11039b interfaceC11039b = (InterfaceC11039b) ServiceProvider.get(InterfaceC11039b.class);
                if (interfaceC11039b != null) {
                    interfaceC11039b.mo23975a(m23657Lv);
                }
            }
        });
    }

    @WorkerThread
    /* renamed from: Lv */
    public static C11038a m23657Lv() {
        Map<String, ?> all;
        C11038a c11038a = new C11038a();
        SharedPreferences m23931gO = C11052bf.m23931gO("ksadsdk_kv_perf");
        if (m23931gO == null) {
            return null;
        }
        try {
            all = m23931gO.getAll();
        } catch (Throwable unused) {
        }
        if (all == null) {
            return null;
        }
        int i = 0;
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            i += ((Integer) entry.getValue()).intValue();
        }
        c11038a.aSj = i;
        SharedPreferences.Editor edit = m23931gO.edit();
        for (Map.Entry<String, ?> entry2 : all.entrySet()) {
            edit.putInt(entry2.getKey(), 0);
        }
        edit.apply();
        m23644d(c11038a);
        m23642e(c11038a);
        return c11038a;
    }

    /* renamed from: Lw */
    private static int m23656Lw() {
        int m23933b = C11052bf.m23933b("kssdk_kv_mode", RtspHeaders.Values.MODE, 0);
        C10331c.m26254d("Ks_UnionHelper", "local mode:" + m23933b);
        return m23933b;
    }

    /* renamed from: Lx */
    public static boolean m23655Lx() {
        m23659Lt();
        return aPg.get() == 0;
    }

    /* renamed from: Ly */
    private static boolean m23654Ly() {
        return Build.VERSION.SDK_INT > 23;
    }

    /* renamed from: Lz */
    private static int m23653Lz() {
        m23659Lt();
        int m23660Ls = (aPi || !m23654Ly()) ? 0 : m23660Ls();
        C10331c.m26254d("Ks_UnionHelper", "targetMode:" + m23660Ls);
        return m23660Ls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public static void m23652P(Context context, String str) {
        SharedPreferences m23931gO;
        C10990c m24176av = C10999e.m24176av(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (m23931gO = C11052bf.m23931gO(str)) == null) {
            SharedPreferences.Editor edit = m23931gO.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
            }
        } else if (m24176av.contains("sp_to_kv_transfer_flag")) {
        } else {
            SharedPreferences m23931gO2 = C11052bf.m23931gO(str);
            if (m23931gO2 == null) {
                m24176av.putBoolean("sp_to_kv_transfer_flag", true);
                return;
            }
            m24176av.putAll(m23931gO2.getAll());
            m24176av.putBoolean("sp_to_kv_transfer_flag", true);
            C11052bf.m23934au(str, "kv_to_sp_transfer_flag");
            m23648a(str, m24176av);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public static void m23651Q(Context context, String str) {
        SharedPreferences m23931gO = C11052bf.m23931gO(str);
        if (m23931gO == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor edit = m23931gO.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
            }
        } else if (m23931gO.contains("kv_to_sp_transfer_flag")) {
        } else {
            C10990c m24176av = C10999e.m24176av(context, str);
            Map<String, Object> all = m24176av.getAll();
            if (all.isEmpty()) {
                C11052bf.m23927l(str, "kv_to_sp_transfer_flag", true);
                return;
            }
            C11052bf.m23935a(str, all);
            C11052bf.m23927l(str, "kv_to_sp_transfer_flag", true);
            m24176av.remove("sp_to_kv_transfer_flag");
            m24176av.release();
        }
    }

    /* renamed from: a */
    private static void m23648a(String str, C10990c c10990c) {
        if (C10769h.C10770a.akJ.contains(str)) {
            return;
        }
        c10990c.release();
    }

    @WorkerThread
    /* renamed from: as */
    public static void m23647as(final String str, final String str2) {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.utils.x.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                int m23933b = C11052bf.m23933b("ksadsdk_kv_perf", str, 0);
                if (TextUtils.isEmpty(str2)) {
                    C11052bf.m23934au("ksadsdk_kv_perf", str);
                    return;
                }
                C11052bf.m23938a("ksadsdk_kv_perf", str, m23933b + 1);
            }
        });
    }

    /* renamed from: at */
    public static void m23646at(final String str, final String str2) {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.utils.x.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                SharedPreferences m23931gO = C11052bf.m23931gO("ksadsdk_kv_perf");
                if (m23931gO != null && m23931gO.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        C11052bf.m23938a("ksadsdk_kv_perf_failed", str, C11052bf.m23933b("ksadsdk_kv_perf_failed", str, 0) + 1);
                        return;
                    }
                    C11052bf.m23938a("ksadsdk_kv_perf_success", str, C11052bf.m23933b("ksadsdk_kv_perf_success", str, 0) + 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m23645c(@NonNull C11038a c11038a) {
        int i = c11038a.aSk;
        double d = i;
        double d2 = i + c11038a.aSl;
        Double.isNaN(d);
        Double.isNaN(d2);
        if (d / d2 > 0.10000000149011612d) {
            aPi = true;
            C10331c.m26254d("Ks_UnionHelper", "need downgrade");
            C11052bf.m23927l("kssdk_kv_mode", "downgrade", true);
        }
        if (aPi) {
            m23664LA();
        }
    }

    /* renamed from: d */
    private static void m23644d(C11038a c11038a) {
        SharedPreferences m23931gO = C11052bf.m23931gO("ksadsdk_kv_perf_failed");
        int i = 0;
        if (m23931gO != null) {
            Map<String, ?> all = m23931gO.getAll();
            if (all != null) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    i += ((Integer) entry.getValue()).intValue();
                }
            }
            c11038a.aSk = i;
            SharedPreferences.Editor edit = m23931gO.edit();
            edit.clear();
            edit.apply();
            return;
        }
        c11038a.aSk = 0;
    }

    /* renamed from: dZ */
    static void m23643dZ(int i) {
        C11052bf.m23938a("kssdk_kv_mode", RtspHeaders.Values.MODE, i);
    }

    /* renamed from: e */
    private static void m23642e(C11038a c11038a) {
        SharedPreferences m23931gO = C11052bf.m23931gO("ksadsdk_kv_perf_success");
        int i = 0;
        if (m23931gO != null) {
            Map<String, ?> all = m23931gO.getAll();
            if (all != null) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    i += ((Integer) entry.getValue()).intValue();
                }
            }
            c11038a.aSl = i;
            SharedPreferences.Editor edit = m23931gO.edit();
            edit.clear();
            edit.apply();
            return;
        }
        c11038a.aSl = 0;
    }

    private static void transfer(int i) {
        if (i == 0) {
            m23663LB();
        } else if (i == 1) {
            m23662LC();
        }
    }
}
