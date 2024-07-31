package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.commercial.p374c.C9823b;
import com.kwad.sdk.commercial.p374c.C9824c;
import com.kwad.sdk.commercial.p379h.C9837a;
import com.kwad.sdk.core.network.C10424i;
import com.kwad.sdk.core.network.C10434j;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11065bo;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11126t;
import com.kwad.sdk.utils.p451b.C11038a;
import com.kwai.adclient.kscommerciallogger.C11155a;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.C11160a;
import com.kwai.adclient.kscommerciallogger.model.C11161b;
import com.kwai.adclient.kscommerciallogger.model.C11162c;
import com.kwai.adclient.kscommerciallogger.model.C11164d;
import com.kwai.adclient.kscommerciallogger.p453a.InterfaceC11158b;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.commercial.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9815b {
    private static float anQ = -1.0f;
    private static double anR = -1.0d;
    private static final AtomicBoolean anS = new AtomicBoolean();
    private static boolean anT;
    private static volatile boolean anU;
    private static List<C9821c> anV;
    private static InterfaceC9818a anW;
    private static Map<String, C9824c> anX;

    /* renamed from: com.kwad.sdk.commercial.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9818a {
        @WorkerThread
        /* renamed from: j */
        void mo24676j(String str, String str2, boolean z);

        @WorkerThread
        /* renamed from: zA */
        boolean mo24675zA();

        @WorkerThread
        /* renamed from: zB */
        boolean mo24674zB();

        @WorkerThread
        /* renamed from: zC */
        JSONObject mo24673zC();

        /* renamed from: zD */
        String mo24672zD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: AG */
    public static void m27699AG() {
        try {
            anX = new HashMap();
            JSONObject mo24673zC = anW.mo24673zC();
            if (mo24673zC == null) {
                return;
            }
            Iterator<String> keys = mo24673zC.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = mo24673zC.optJSONObject(next);
                if (optJSONObject != null) {
                    m27687a(next, optJSONObject.optJSONArray("ratio"));
                    m27677b(next, optJSONObject.optJSONArray("ratioApmRL"));
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static synchronized void m27695a(final InterfaceC9818a interfaceC9818a, final boolean z) {
        synchronized (C9815b.class) {
            if (anT) {
                return;
            }
            anT = true;
            anW = interfaceC9818a;
            C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.commercial.b.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C9815b.m27683b(InterfaceC9818a.this, z);
                    C9815b.m27699AG();
                    C9815b.anS.set(true);
                    C9815b.m27657mQ();
                }
            });
        }
    }

    /* renamed from: b */
    private static void m27677b(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        C9824c c9824c = new C9824c();
                        String m27694a = m27694a(c9824c, (String) obj);
                        C9824c c9824c2 = anX.get(m27694a);
                        if (c9824c2 != null) {
                            c9824c2.aov = true;
                            c9824c2.aos = Double.parseDouble(str);
                        } else {
                            c9824c.aov = true;
                            c9824c.aos = Double.parseDouble(str);
                            anX.put(m27694a, c9824c);
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* renamed from: d */
    public static synchronized void m27672d(C9821c c9821c) {
        synchronized (C9815b.class) {
            if (C9425a.f29473md.booleanValue()) {
                if (c9821c.category.equals(ILoggerReporter.Category.ERROR_LOG)) {
                    C10331c.m26250e("KCLogReporter", "reportItem: " + c9821c);
                } else {
                    C10331c.m26254d("KCLogReporter", "reportItem: " + c9821c);
                }
            }
            if (!anS.get()) {
                m27674c(c9821c);
            } else {
                m27682b(c9821c);
            }
        }
    }

    /* renamed from: e */
    public static void m27670e(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N("ad_sdk_reward_check_result", "check_type").m27634a(BusinessType.AD_REWARD).m27625u(abstractC9822a).m27632a(new C11161b("RESULT_CHECK_REWARD")));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: f */
    public static void m27668f(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.5d).m27635N("ad_sdk_webview_track", "scene_id").m27634a(BusinessType.AD_WEBVIEW).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: g */
    public static void m27666g(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(0.01d).m27635N("ad_sdk_reward_performance", "reward_type").m27634a(BusinessType.AD_REWARD).m27625u(abstractC9822a).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: h */
    public static void m27663h(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.1d).m27635N("ad_sdk_splash_load", "status").m27634a(BusinessType.AD_SPLASH).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: i */
    public static void m27662i(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.1d).m27635N("ad_sdk_splash_preload", "status").m27634a(BusinessType.AD_SPLASH).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: j */
    public static void m27661j(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N("ad_sdk_splash_cache", "cache").m27634a(BusinessType.AD_SPLASH).m27625u(abstractC9822a).m27632a(C11160a.aTK));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: k */
    public static void m27660k(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N("ad_sdk_splash_show", "status").m27634a(BusinessType.AD_SPLASH).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: l */
    public static void m27659l(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N("ad_sdk_splash_monitor_view_error", "status").m27634a(BusinessType.AD_SPLASH).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: m */
    public static void m27658m(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N("ad_sdk_splash_monitor_template_data_error", "status").m27634a(BusinessType.AD_SPLASH).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mQ */
    public static synchronized void m27657mQ() {
        synchronized (C9815b.class) {
            List<C9821c> list = anV;
            if (list == null) {
                return;
            }
            for (C9821c c9821c : list) {
                m27682b(c9821c);
            }
            anV.clear();
            anV = null;
        }
    }

    /* renamed from: n */
    public static void m27655n(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N("ad_sdk_splash_monitor_errorcode_error", "status").m27634a(BusinessType.AD_SPLASH).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: o */
    public static void m27654o(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N("ad_sdk_dynamic_run", "dynamic").m27632a(C11160a.aTL).m27625u(abstractC9822a));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: p */
    public static void m27653p(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N("ad_sdk_block_info", "block").m27632a(C11161b.aUe).m27625u(abstractC9822a));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: q */
    public static void m27652q(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N("ad_image_load_perf", "image_perf").m27625u(abstractC9822a).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: r */
    public static void m27651r(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(1.0d).m27635N("ad_thread_monitor", "thread_perf").m27625u(abstractC9822a).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: s */
    public static void m27650s(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.001d).m27635N("ad_video_load_perf", "video_load_perf").m27630cv("ad_video_load_perf").m27625u(abstractC9822a).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: t */
    public static void m27649t(AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.001d).m27635N("ad_video_load_failed", "video_load_failed").m27630cv("ad_video_load_failed").m27625u(abstractC9822a).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: c */
    private static void m27674c(C9821c c9821c) {
        if (anV == null) {
            anV = new CopyOnWriteArrayList();
        }
        anV.add(c9821c);
    }

    /* renamed from: c */
    public static void m27673c(boolean z, AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N(z ? "ad_sdk_reward_page_show" : "ad_sdk_fullscreen_page_show", "page_status").m27634a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).m27625u(abstractC9822a).m27632a(C11160a.aTB));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static void m27687a(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        C9824c c9824c = new C9824c();
                        String m27694a = m27694a(c9824c, (String) obj);
                        C9824c c9824c2 = anX.get(m27694a);
                        if (c9824c2 != null) {
                            c9824c2.aou = true;
                            c9824c2.aor = Double.parseDouble(str);
                        } else {
                            c9824c.aou = true;
                            c9824c.aor = Double.parseDouble(str);
                            anX.put(m27694a, c9824c);
                        }
                    }
                }
            } catch (JSONException e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
    }

    /* renamed from: d */
    public static void m27671d(boolean z, AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N(z ? "ad_sdk_reward_callback_interaction" : "ad_sdk_fullscreen_callback_interaction", "callback_type").m27634a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: e */
    public static void m27669e(boolean z, AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N(z ? "ad_sdk_reward_callback_load" : "ad_sdk_fullscreen_callback_load", "callback_type").m27634a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: f */
    public static void m27667f(boolean z, AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N(z ? "ad_sdk_reward_play_error" : "ad_sdk_fullscreen_play_error", "reward_type").m27634a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).m27625u(abstractC9822a).m27632a(C11161b.aUe));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: g */
    public static void m27664g(boolean z, AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(z ? 1.0d : 0.01d).m27635N("ad_sdk_splash_single_cache", "status").m27634a(BusinessType.AD_SPLASH).m27625u(abstractC9822a).m27632a(C11160a.aTK));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: b */
    private static void m27682b(C9821c c9821c) {
        C11162c.C11163a m23507Oo;
        if (anU) {
            C9823b m27693a = m27693a(c9821c);
            if (anQ == -1.0f) {
                anQ = new Random().nextFloat();
            }
            if (anR == -1.0d) {
                anR = new Random().nextFloat();
            }
            if ((anW.mo24674zB() || anQ <= m27693a.aor) && C11065bo.m23855az(BuildConfig.VERSION_NAME, m27693a.aot)) {
                try {
                    if (ILoggerReporter.Category.ERROR_LOG.equals(m27692a(c9821c.category, c9821c))) {
                        m23507Oo = C11162c.C11163a.m23508On();
                    } else {
                        m23507Oo = C11162c.C11163a.m23507Oo();
                    }
                    C11155a.m23525Oe().m23521a(m23507Oo.m23504b(c9821c.aod).m23503b(c9821c.aoe).m23494hl(TextUtils.isEmpty(c9821c.tag) ? c9821c.eventId : c9821c.tag).m23501b(c9821c.aof).m23493hm(c9821c.eventId).m23509A(m27686a(c9821c.msg, m27693a)).m23506Op());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    /* renamed from: g */
    public static void m27665g(JSONObject jSONObject) {
        String str;
        try {
            int optInt = jSONObject.optInt("load_status");
            if (optInt != 3 && optInt != 4 && optInt != 7) {
                str = ILoggerReporter.Category.APM_LOG;
                m27672d(C9821c.m27636AJ().m27631cu(str).m27628i(1.0d).m27627j(0.1d).m27626k(0.001d).m27635N("ad_sdk_dynamic_update", "load_status").m27632a(C11160a.aTL).m27629h(jSONObject));
            }
            str = ILoggerReporter.Category.ERROR_LOG;
            m27672d(C9821c.m27636AJ().m27631cu(str).m27628i(1.0d).m27627j(0.1d).m27626k(0.001d).m27635N("ad_sdk_dynamic_update", "load_status").m27632a(C11160a.aTL).m27629h(jSONObject));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static String m27694a(C9823b c9823b, String str) {
        try {
            int lastIndexOf = str.lastIndexOf(95);
            int length = str.length() - 1;
            if (str.charAt(length) >= '0' && str.charAt(length) <= '9' && lastIndexOf != -1) {
                c9823b.aot = str.substring(lastIndexOf + 1);
                return str.substring(0, lastIndexOf);
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    @NonNull
    /* renamed from: a */
    private static C9823b m27693a(C9821c c9821c) {
        double d;
        double d2;
        String str;
        C9824c c9824c;
        C9824c c9824c2;
        C9823b c9823b = new C9823b();
        try {
            Boolean bool = C9425a.f29473md;
            if (bool.booleanValue()) {
                c9823b.aor = c9821c.aob;
            } else {
                c9823b.aor = c9821c.aoa;
            }
            c9823b.aos = c9821c.aoc;
            if (!anX.containsKey(c9821c.eventId) || (c9824c2 = anX.get(c9821c.eventId)) == null) {
                d = -1.0d;
                d2 = -1.0d;
            } else {
                d = c9824c2.aou ? c9824c2.aor : -1.0d;
                d2 = c9824c2.aov ? c9824c2.aos : -1.0d;
                if (!TextUtils.isEmpty(c9824c2.aot)) {
                    c9823b.aot = c9824c2.aot;
                }
            }
            if (TextUtils.isEmpty(c9821c.primaryKey) && bool.booleanValue()) {
                throw new Exception("primaryKey为空");
            }
            String str2 = c9821c.eventId;
            if (!TextUtils.isEmpty(c9821c.primaryKey)) {
                if (c9821c.msg.has(c9821c.primaryKey)) {
                    str = str2 + "_" + c9821c.msg.opt(c9821c.primaryKey);
                } else {
                    str = str2 + "_" + c9821c.primaryKey;
                }
                if (anX.containsKey(str) && (c9824c = anX.get(str)) != null) {
                    if (c9824c.aou) {
                        d = c9824c.aor;
                    }
                    if (c9824c.aov) {
                        d2 = c9824c.aos;
                    }
                    if (!TextUtils.isEmpty(c9824c.aot)) {
                        c9823b.aot = c9824c.aot;
                    }
                }
            }
            if (d != -1.0d) {
                c9823b.aor = d;
            }
            if (d2 != -1.0d) {
                c9823b.aos = d2;
            } else {
                c9823b.aos = ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24309yO();
            }
            c9821c.aoa = c9823b.aor;
            c9821c.aoc = c9823b.aos;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return c9823b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m27683b(final InterfaceC9818a interfaceC9818a, boolean z) {
        boolean mo24675zA = interfaceC9818a.mo24675zA();
        anU = mo24675zA;
        if (mo24675zA) {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "publish_type", 0);
            C11126t.putValue(jSONObject, "plug_sdk", z ? 1 : 0);
            C11155a m23525Oe = C11155a.m23525Oe();
            C9812a c9812a = new C9812a();
            InterfaceC11158b interfaceC11158b = new InterfaceC11158b() { // from class: com.kwad.sdk.commercial.b.2
                /* renamed from: M */
                private void m27648M(String str, String str2) {
                    InterfaceC9818a.this.mo24676j(str, str2, false);
                }

                @Override // com.kwai.adclient.kscommerciallogger.p453a.InterfaceC11158b
                /* renamed from: L */
                public final void mo23518L(@NonNull String str, @NonNull String str2) {
                    m27648M(str, str2);
                }
            };
            Boolean bool = C9425a.f29473md;
            m23525Oe.m23522a(c9812a, interfaceC11158b, jSONObject, bool.booleanValue(), bool.booleanValue());
            C9837a.m27546AR().m27545cH(interfaceC9818a.mo24672zD());
        }
    }

    /* renamed from: b */
    public static void m27676b(boolean z, AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N(z ? "ad_sdk_reward_download_error" : "ad_sdk_fullscreen_download_error", "download_type").m27634a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).m27625u(abstractC9822a).m27632a(C11161b.aTY));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: b */
    public static void m27678b(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(str).m27628i(ILoggerReporter.Category.ERROR_LOG.equals(str) ? 1.0d : 0.001d).m27635N("union_web_cache_load_event", "state").m27634a(BusinessType.WEB_CACHE).m27625u(hybridLoadMsg).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static String m27692a(String str, C9821c c9821c) {
        return (!str.equals(ILoggerReporter.Category.APM_LOG) || anR >= c9821c.aoc) ? str : ILoggerReporter.Category.ERROR_LOG;
    }

    /* renamed from: a */
    public static void m27688a(String str, C11164d c11164d, AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(str).m27628i(0.001d).m27635N(ILoggerReporter.Category.ERROR_LOG.equals(str) ? "ad_sdk_init_error_performance" : "ad_sdk_init_performance", "init_status").m27634a(BusinessType.AD_SDK_INIT).m27625u(abstractC9822a).m27632a(c11164d));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: b */
    public static void m27680b(C10434j c10434j) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(1.0E-5d).m27635N("ad_perf_monitor_net_success", "network_monitor").m27625u(c10434j).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27685a(boolean z, AbstractC9822a abstractC9822a, C11164d c11164d) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N(z ? "ad_sdk_reward_load" : "ad_sdk_fullscreen_load", "load_status").m27634a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).m27625u(abstractC9822a).m27632a(c11164d));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: b */
    public static void m27681b(C10424i c10424i) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.1d).m27635N("ad_perf_monitor_net_error", "network_monitor").m27625u(c10424i).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27684a(boolean z, String str, AbstractC9822a abstractC9822a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N(str, "reward_type").m27634a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).m27625u(abstractC9822a).m27632a(C11161b.aUe));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: b */
    public static void m27679b(@NonNull C11038a c11038a) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N("ad_union_kv_fail_rate", "kv").m27625u(c11038a).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27691a(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(str).m27628i(1.0E-4d).m27635N("union_web_cache_download_event", "state").m27634a(BusinessType.WEB_CACHE).m27625u(hybridLoadMsg).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27689a(String str, WebViewLoadMsg webViewLoadMsg) {
        try {
            m27672d(C9821c.m27636AJ().m27631cu(str).m27628i(1.0d).m27635N("union_webview_load_event", "state").m27625u(webViewLoadMsg).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27690a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        try {
            double d = webViewCommercialMsg.rate;
            if (d >= Utils.DOUBLE_EPSILON) {
                C11126t.putValue(webViewCommercialMsg.msg, "ratio", d);
            }
            if (TextUtils.isEmpty(webViewCommercialMsg.primaryKey)) {
                webViewCommercialMsg.primaryKey = "web_log";
            }
            m27672d(C9821c.m27636AJ().m27631cu(str).m27628i(webViewCommercialMsg.rate).m27635N(webViewCommercialMsg.eventId, webViewCommercialMsg.primaryKey).m27634a(webViewCommercialMsg.biz).m27633a(webViewCommercialMsg.subBiz).m27629h(webViewCommercialMsg.msg).m27632a(C11164d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static JSONObject m27686a(JSONObject jSONObject, C9823b c9823b) {
        try {
            C11126t.putValue(jSONObject, "ratio", c9823b.aor);
            double d = c9823b.aor;
            if (d > Utils.DOUBLE_EPSILON) {
                C11126t.putValue(jSONObject, "ratio_count", m27696a(1.0d, d, 0));
            }
            C11126t.putValue(jSONObject, "debug_mode", C9425a.f29473md.booleanValue() ? 1 : 0);
            C11126t.putValue(jSONObject, "convert_ratio", c9823b.aos);
            double d2 = c9823b.aos;
            if (d2 > Utils.DOUBLE_EPSILON) {
                C11126t.putValue(jSONObject, "convert_ratio_count", m27696a(1.0d, d2, 0));
            }
            return jSONObject;
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            return jSONObject;
        }
    }

    /* renamed from: a */
    private static double m27696a(double d, double d2, int i) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d2)), 0, RoundingMode.HALF_UP).doubleValue();
    }
}
