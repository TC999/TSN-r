package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.core.p385a.C9886c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.p450a.C10999e;
import com.stub.StubApp;
import java.util.Map;

/* renamed from: com.kwad.sdk.utils.y */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11137y {
    private static String sAppTag = "";

    /* renamed from: LE */
    public static String m23640LE() {
        Context context = getContext();
        return context == null ? "" : m23592b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    /* renamed from: LF */
    public static String m23639LF() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (C11050be.m23943MP()) {
            return m23592b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
        }
        return m23592b(context, "ksadsdk_interstitial_aggregate_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
    }

    /* renamed from: LG */
    public static String m23638LG() {
        Context context = getContext();
        return context == null ? "" : m23592b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    /* renamed from: LH */
    public static String m23637LH() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (C11050be.m23947ML()) {
            return m23592b(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
        }
        return m23592b(context, "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    /* renamed from: LI */
    public static String m23636LI() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (C11050be.m23945MN()) {
            return m23572j("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
        }
        return m23592b(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    /* renamed from: LJ */
    public static String m23635LJ() {
        return m23572j("ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    /* renamed from: LK */
    public static String m23634LK() {
        if (!TextUtils.isEmpty(sAppTag)) {
            return sAppTag;
        }
        Context context = getContext();
        return context == null ? "" : m23592b(context, "ksadsdk_pref", "appTag", "");
    }

    /* renamed from: LL */
    public static String m23633LL() {
        Context context = getContext();
        return context == null ? "" : m23588bZ(context);
    }

    /* renamed from: LM */
    public static long m23632LM() {
        return m23589b("ksadsdk_push_ad_common", "key_push_last_show_time", -1L);
    }

    /* renamed from: LN */
    public static String m23631LN() {
        return getContext() == null ? "" : m23572j("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    /* renamed from: LO */
    public static void m23630LO() {
        m23612a("ksadsdk_perf", "image_load_total", m23590b("ksadsdk_perf", "image_load_total", 0) + 1);
    }

    /* renamed from: LP */
    public static void m23629LP() {
        m23612a("ksadsdk_perf", "image_load_suc", m23590b("ksadsdk_perf", "image_load_suc", 0) + 1);
    }

    /* renamed from: LQ */
    public static void m23628LQ() {
        m23612a("ksadsdk_perf", "image_load_failed", m23590b("ksadsdk_perf", "image_load_failed", 0) + 1);
    }

    /* renamed from: LR */
    public static double m23627LR() {
        int m23590b = m23590b("ksadsdk_perf", "image_load_complete_count", 0);
        long m23589b = m23589b("ksadsdk_perf", "image_load_complete_total", 0L);
        m23612a("ksadsdk_perf", "image_load_complete_count", 0);
        m23611a("ksadsdk_perf", "image_load_complete_total", 0L);
        if (m23590b == 0) {
            return Utils.DOUBLE_EPSILON;
        }
        double d = m23589b;
        double d2 = m23590b;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    /* renamed from: LS */
    public static int m23626LS() {
        int m23590b = m23590b("ksadsdk_perf", "image_load_total", 0);
        C10331c.m26254d("Ks_UnionUtils", "imageLoadTotal:" + m23590b);
        m23612a("ksadsdk_perf", "image_load_total", 0);
        return m23590b;
    }

    /* renamed from: LT */
    public static int m23625LT() {
        int m23590b = m23590b("ksadsdk_perf", "image_load_suc", 0);
        C10331c.m26254d("Ks_UnionUtils", "imageLoadSuccess:" + m23590b);
        m23612a("ksadsdk_perf", "image_load_suc", 0);
        return m23590b;
    }

    /* renamed from: LU */
    public static int m23624LU() {
        int m23590b = m23590b("ksadsdk_perf", "image_load_failed", 0);
        C10331c.m26254d("Ks_UnionUtils", "imageLoadFailed:" + m23590b);
        m23612a("ksadsdk_perf", "image_load_failed", 0);
        return m23590b;
    }

    /* renamed from: T */
    public static long m23623T(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return m23593b(context, "ksadsdk_pref", str, 0L);
    }

    /* renamed from: U */
    public static long m23622U(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return m23593b(context, "ksadsdk_download_package_length", str, 0L);
    }

    /* renamed from: V */
    public static String m23621V(Context context, String str) {
        return context == null ? "" : m23592b(context, "ksadsdk_download_package_md5", str, "");
    }

    /* renamed from: W */
    public static void m23620W(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        m23614a(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    /* renamed from: X */
    public static void m23619X(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        m23610a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    /* renamed from: Y */
    public static void m23618Y(Context context, String str) {
        if (context == null) {
            return;
        }
        m23614a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    /* renamed from: Z */
    public static void m23617Z(Context context, String str) {
        if (context == null) {
            return;
        }
        m23614a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", str);
        C11050be.m23944MO();
    }

    /* renamed from: a */
    public static void m23610a(String str, String str2, String str3, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        m23613a(context, str, str2, str3, true);
    }

    /* renamed from: aF */
    public static void m23609aF(long j) {
        m23611a("ksadsdk_push_ad_common", "key_push_last_show_time", j);
    }

    /* renamed from: aG */
    public static void m23608aG(long j) {
        m23612a("ksadsdk_perf", "image_load_complete_count", m23590b("ksadsdk_perf", "image_load_complete_count", 0) + 1);
        m23611a("ksadsdk_perf", "image_load_complete_total", m23589b("ksadsdk_perf", "image_load_complete_total", 0L) + j);
    }

    /* renamed from: aa */
    public static void m23607aa(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        m23614a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", str);
    }

    /* renamed from: ab */
    public static void m23606ab(Context context, String str) {
        if (context == null) {
            return;
        }
        m23614a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    /* renamed from: ac */
    public static void m23605ac(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        m23614a(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        C11050be.m23948MK();
    }

    /* renamed from: ad */
    public static void m23604ad(Context context, String str) {
        if (context == null) {
            return;
        }
        m23614a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        C11050be.m23946MM();
    }

    /* renamed from: ae */
    public static void m23603ae(Context context, String str) {
        if (context == null) {
            return;
        }
        m23614a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
    }

    /* renamed from: af */
    public static void m23602af(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        m23614a(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    /* renamed from: ag */
    public static void m23601ag(Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.utils.y.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C11137y.m23600ah(ServiceProvider.getContext(), str);
            }
        });
    }

    /* renamed from: ah */
    public static void m23600ah(Context context, String str) {
        if (context == null) {
            return;
        }
        m23614a(context, "ksadsdk_pref", "appTag", str);
    }

    /* renamed from: ai */
    public static void m23599ai(Context context, String str) {
        if (context == null) {
            return;
        }
        m23610a("ksadsdk_pref", "webview_ua", str, true);
    }

    @WorkerThread
    /* renamed from: aj */
    public static void m23598aj(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        C11050be.m23940j(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ksadsdk_sdk_config_data", str);
    }

    /* renamed from: ak */
    public static void m23597ak(Context context, String str) {
        if (context == null) {
            return;
        }
        m23573i("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    /* renamed from: al */
    public static Map<String, ?> m23596al(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (C11131x.m23655Lx()) {
            SharedPreferences m23931gO = C11052bf.m23931gO(str);
            if (m23931gO != null) {
                return m23931gO.getAll();
            }
            return null;
        }
        return C10999e.m24176av(context, str).getAll();
    }

    /* renamed from: au */
    public static void m23595au(String str, String str2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        m23574h(context, str, str2);
    }

    /* renamed from: b */
    public static long m23589b(String str, String str2, long j) {
        Context context = getContext();
        return context == null ? j : m23593b(context, str, str2, j);
    }

    /* renamed from: bZ */
    public static String m23588bZ(@NonNull Context context) {
        return context == null ? "" : m23592b(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    /* renamed from: c */
    private static boolean m23587c(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return z;
        }
        if (C11131x.m23655Lx()) {
            return C11052bf.m23926m(str, str2, z);
        }
        return C10999e.m24176av(context, str).getBoolean(str2, z);
    }

    /* renamed from: ca */
    public static long m23586ca(@NonNull Context context) {
        if (context == null) {
            return 0L;
        }
        return m23593b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    /* renamed from: cb */
    public static int m23585cb(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return m23594b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    /* renamed from: cc */
    public static String m23584cc(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        String m23592b = m23592b(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        C11052bf.m23928k(m23592b, "ksadsdk_model", "KEY_SDK_MODEL");
        return m23592b;
    }

    /* renamed from: cd */
    public static int m23583cd(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return m23594b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", 0);
    }

    /* renamed from: ce */
    public static String m23582ce(@NonNull Context context) {
        return context == null ? "" : m23592b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", "");
    }

    /* renamed from: cf */
    public static String m23581cf(@NonNull Context context) {
        return context == null ? "" : m23592b(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    /* renamed from: cg */
    public static String m23580cg(Context context) {
        if (context == null) {
            return "";
        }
        String m23572j = m23572j("ksadsdk_pref", "webview_ua", "");
        C11052bf.m23928k(m23572j, "ksadsdk_pref", "webview_ua");
        return m23572j;
    }

    @WorkerThread
    /* renamed from: ch */
    public static String m23579ch(Context context) {
        if (C11050be.m23950MI()) {
            return C11050be.m23942au(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ksadsdk_sdk_config_data");
        }
        String m23929j = C11052bf.m23929j("ksadsdk_sdk_config_data", "config_str", "");
        C11050be.m23941i(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ksadsdk_sdk_config_data", m23929j);
        return m23929j;
    }

    /* renamed from: d */
    public static void m23578d(@NonNull Context context, long j) {
        if (context == null) {
            return;
        }
        m23615a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j);
    }

    /* renamed from: e */
    public static void m23577e(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        m23615a(context, "ksadsdk_pref", str, j);
    }

    /* renamed from: f */
    public static void m23576f(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        m23615a(context, "ksadsdk_download_package_length", str, j);
    }

    /* renamed from: g */
    public static void m23575g(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        m23614a(context, "ksadsdk_download_package_md5", str, str2);
    }

    @Nullable
    public static Context getContext() {
        return ServiceProvider.m24363KO();
    }

    /* renamed from: h */
    public static void m23574h(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (C11131x.m23655Lx()) {
            C11052bf.m23934au(str, str2);
            return;
        }
        C10999e.m24176av(context, str).remove(str2);
        C11131x.m23647as(str2, "");
    }

    /* renamed from: i */
    public static void m23573i(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        m23614a(context, str, str2, str3);
    }

    /* renamed from: j */
    public static String m23572j(String str, String str2, String str3) {
        Context context = getContext();
        return context == null ? str3 : m23592b(context, str, str2, str3);
    }

    /* renamed from: k */
    public static void m23571k(@NonNull Context context, int i) {
        if (context == null) {
            return;
        }
        m23616a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i);
    }

    /* renamed from: l */
    public static void m23569l(@NonNull Context context, int i) {
        if (context == null) {
            return;
        }
        m23616a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", i);
    }

    /* renamed from: m */
    public static boolean m23567m(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return m23587c(context, str, str2, false);
    }

    /* renamed from: k */
    public static void m23570k(String str, String str2, String str3) {
        if (C11131x.m23655Lx()) {
            C11052bf.m23928k(str, str2, str3);
        }
    }

    /* renamed from: l */
    public static void m23568l(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        m23591b(context, str, str2, true);
    }

    /* renamed from: a */
    public static void m23611a(String str, String str2, long j) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        m23615a(context, str, str2, j);
    }

    /* renamed from: b */
    public static int m23590b(String str, String str2, int i) {
        Context context = getContext();
        if (context == null) {
            return 0;
        }
        return m23594b(context, str, str2, 0);
    }

    /* renamed from: a */
    public static void m23612a(String str, String str2, int i) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        m23616a(context, str, str2, i);
    }

    /* renamed from: b */
    public static String m23592b(Context context, String str, String str2, String str3) {
        String string;
        if (context == null) {
            return str3;
        }
        if (C11131x.m23655Lx()) {
            string = C11052bf.m23929j(str, str2, str3);
            if (C9425a.f29473md.booleanValue()) {
                C10331c.m26254d("Ks_UnionUtils", "getString From Sp key:" + str2 + " value:" + string);
            }
        } else {
            C10999e.m24176av(context, str);
            string = C10999e.m24176av(context, str).getString(str2, str3);
            C11131x.m23646at(str2, string);
            if (C9425a.f29473md.booleanValue()) {
                C10331c.m26254d("Ks_UnionUtils", "getString key:" + str2 + " value:" + string);
            }
        }
        return C9886c.m27437dJ(string) ? C9886c.m27438dI(string) : string;
    }

    /* renamed from: a */
    public static void m23614a(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        if (C11131x.m23655Lx()) {
            C11052bf.m23930i(str, str2, str3);
            if (C9425a.f29473md.booleanValue()) {
                C10331c.m26254d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        C10999e.m24176av(context, str).putString(str2, str3);
        if (C9425a.f29473md.booleanValue()) {
            C10331c.m26254d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        C11131x.m23647as(str2, str3);
    }

    /* renamed from: a */
    private static void m23613a(Context context, @NonNull String str, @NonNull String str2, String str3, boolean z) {
        if (context == null) {
            return;
        }
        if (C11131x.m23655Lx()) {
            C11052bf.m23936a(str, str2, str3, z);
            if (C9425a.f29473md.booleanValue()) {
                C10331c.m26254d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        C10999e.m24176av(context, str).putString(str2, str3);
        if (C9425a.f29473md.booleanValue()) {
            C10331c.m26254d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        C11131x.m23647as(str2, str3);
    }

    /* renamed from: b */
    private static long m23593b(Context context, String str, String str2, long j) {
        if (context == null) {
            return j;
        }
        if (C11131x.m23655Lx()) {
            return C11052bf.m23932b(str, str2, j);
        }
        return C10999e.m24176av(context, str).getLong(str2, j);
    }

    /* renamed from: b */
    private static int m23594b(Context context, String str, String str2, int i) {
        if (context == null) {
            return i;
        }
        if (C11131x.m23655Lx()) {
            return C11052bf.m23933b(str, str2, i);
        }
        return C10999e.m24176av(context, str).getInt(str2, i);
    }

    /* renamed from: b */
    private static void m23591b(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        if (C11131x.m23655Lx()) {
            C11052bf.m23927l(str, str2, z);
        } else {
            C10999e.m24176av(context, str).putBoolean(str2, z);
        }
    }

    /* renamed from: a */
    private static void m23615a(Context context, String str, String str2, long j) {
        if (context == null) {
            return;
        }
        if (C11131x.m23655Lx()) {
            C11052bf.m23937a(str, str2, j);
        } else {
            C10999e.m24176av(context, str).putLong(str2, j);
        }
    }

    /* renamed from: a */
    private static void m23616a(Context context, String str, String str2, int i) {
        if (context == null) {
            return;
        }
        if (C11131x.m23655Lx()) {
            C11052bf.m23938a(str, str2, i);
        } else {
            C10999e.m24176av(context, str).putInt(str2, i);
        }
    }
}
