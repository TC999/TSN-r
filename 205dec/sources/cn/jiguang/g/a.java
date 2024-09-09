package cn.jiguang.g;

import cn.jiguang.f.g;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public static String f3650a = "cn.jiguang.sdk.share.profile";

    /* renamed from: b  reason: collision with root package name */
    public static String f3651b = "cn.jpush.preferences.v2";

    /* renamed from: c  reason: collision with root package name */
    String f3652c;

    /* renamed from: d  reason: collision with root package name */
    String f3653d;

    /* renamed from: e  reason: collision with root package name */
    T f3654e;

    /* renamed from: f  reason: collision with root package name */
    boolean f3655f;

    /* renamed from: g  reason: collision with root package name */
    boolean f3656g;

    public a(String str, String str2, T t3) {
        this.f3652c = str;
        this.f3653d = str2;
        if (t3 == null) {
            throw new IllegalArgumentException("default value can not be null");
        }
        this.f3654e = t3;
    }

    public a(String str, String str2, T t3, boolean z3, boolean z4) {
        this.f3652c = str;
        this.f3653d = str2;
        if (t3 == null) {
            throw new IllegalArgumentException("default value can not be null");
        }
        this.f3654e = t3;
        this.f3655f = z3;
        this.f3656g = z4;
    }

    public static a<String> A() {
        return (a<T>) new a("cn.jiguang.sdk.user.profile", "key_ww", "").aB().aC();
    }

    public static a<String> B() {
        return new a("cn.jiguang.sdk.user.profile", "key_pwd", "").aB();
    }

    public static a<Integer> C() {
        return new a("cn.jiguang.sdk.user.profile", "idc", -1).aB();
    }

    public static a<Long> D() {
        return new a<>("cn.jiguang.sdk.user.profile", "login_local_time", -1L);
    }

    public static a<Long> E() {
        return new a<>("cn.jiguang.sdk.user.profile", "login_server_time", -1L);
    }

    public static a<Long> F() {
        return new a<>("cn.jiguang.sdk.user.profile", "sync_auth", -1L);
    }

    public static a<String> G() {
        return new a(f3650a, "key_share_process_uuid", "").aB();
    }

    public static a<Long> H() {
        return new a(f3650a, "key_share_process_uuid_creattime", -1L).aB();
    }

    public static a<Integer> I() {
        return new a(f3650a, "sp_state", -1).aB();
    }

    public static a<String> J() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "option_channel", "");
    }

    public static a<String> K() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "analytics_account_id", "");
    }

    public static a<Boolean> L() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "is_ups_register", Boolean.TRUE);
    }

    public static a<Long> M() {
        return new a<>("Push_Page_Config", "css", 0L);
    }

    public static a<Long> N() {
        return new a<>("Push_Page_Config", "cse", 0L);
    }

    public static a<Long> O() {
        return new a<>("Push_Page_Config", "last_pause", -1L);
    }

    public static a<String> P() {
        return new a<>("Push_Page_Config", "session_id", "");
    }

    public static a<String> Q() {
        return new a("cn.jiguang.sdk.report", "report_urls", "").aC();
    }

    public static a<String> R() {
        return new a("cn.jiguang.sdk.report", "report_sis_urls", "").aC();
    }

    public static a<Long> S() {
        return new a<>("cn.jiguang.sdk.report", "last_update_report_urls", 0L);
    }

    public static a<Long> T() {
        return new a<>("cn.jiguang.sdk.report", "report_urls_ttl_millis", 3600000L);
    }

    public static a<String> U() {
        return new a(f3651b, "sdk_version", "").aB();
    }

    public static a<Long> V() {
        return new a<>(f3651b, "first_init", 0L);
    }

    public static a<Long> W() {
        return new a<>(f3651b, "exception_report_mill", 0L);
    }

    public static a<Long> X() {
        return new a<>(f3651b, "lbs_delay", 0L);
    }

    public static a<Boolean> Y() {
        return new a<>(f3651b, "jcore_lbs_enable", Boolean.TRUE);
    }

    public static a<Boolean> Z() {
        return new a<>("cn.jpush.android.user.profile", "is_tcp_close", Boolean.FALSE);
    }

    public static a<String> a() {
        return new a("cn.jpush.android.user.profile", "devcie_id_generated", "").aB();
    }

    public static a<String> a(String str) {
        return new a<>("cn.jpush.android.user.profile", "sdk_version_" + str, "");
    }

    public static a<String> a(boolean z3) {
        return (a<T>) new a("cn.jiguang.sdk.address", z3 ? "default_https_report" : "default_http_report", "").aB().aC();
    }

    public static a<Boolean> aA() {
        return new a<>("internal_debug", "net_m_switch", Boolean.TRUE);
    }

    private a<T> aB() {
        this.f3655f = true;
        return this;
    }

    private a<T> aC() {
        this.f3656g = true;
        return this;
    }

    public static a<Integer> aa() {
        return new a("cn.jpush.android.user.profile", "jpush_register_code", -1).aB();
    }

    public static a<String> ab() {
        return new a<>(f3651b, "device_config_appkey_n", "");
    }

    public static a<String> ac() {
        return new a<>(f3651b, "device_config_appkey", "");
    }

    public static a<String> ad() {
        return new a<>(f3651b, "i_new", "");
    }

    public static a<String> ae() {
        return new a<>(f3651b, "push_udid", "");
    }

    public static a<String> af() {
        return new a<>(f3651b, "last_connection_type", "");
    }

    public static a<String> ag() {
        return new a(f3651b, "sis_report_history", "").aC();
    }

    public static a<Boolean> ah() {
        return new a("internal_debug", "cmd_export_log", Boolean.FALSE).aB();
    }

    public static a<Long> ai() {
        return new a<>("cn.jpush.preferences.v2.rid", "next_rid", -1L);
    }

    public static a<Integer> aj() {
        return new a<>("cn.jpush.preferences.v2.rid", "seq_id", -1);
    }

    public static a<String> ak() {
        return new a("cn.jiguang.sdk.address", "ips_in_last_good_sis", "").aC();
    }

    public static a<String> al() {
        return new a("cn.jiguang.sdk.address", "ssl_ips_in_last_good_sis", "").aC();
    }

    public static a<Boolean> am() {
        return new a<>("cn.jiguang.sdk.address", "udp_data_report", Boolean.FALSE);
    }

    public static a<Long> an() {
        return new a<>("cn.jiguang.sdk.address", "sis_last_update", 0L);
    }

    public static a<Long> ao() {
        return new a<>("cn.jiguang.sdk.address", "last_sis_report_time", 0L);
    }

    public static a<String> ap() {
        return new a("cn.jiguang.sdk.address", "default_sis_ips", "").aC();
    }

    public static a<String> aq() {
        return new a("cn.jiguang.sdk.address", "default_conn", "").aC();
    }

    public static a<String> ar() {
        return new a("cn.jiguang.sdk.address", "default_conn_srv", "").aC();
    }

    public static a<String> as() {
        return (a<T>) new a("cn.jiguang.sdk.address", "tcp_report", "").aB().aC();
    }

    public static a<String> at() {
        return new a<>("PrefsFile", DomainCampaignEx.LOOPBACK_KEY, "");
    }

    public static a<Integer> au() {
        return new a("internal_debug", "log_enable", 0).aB();
    }

    public static a<Integer> av() {
        return new a("internal_debug", "cmd_print_log", 0).aB();
    }

    public static a<Long> aw() {
        return new a("internal_debug", "expire", 0L).aB();
    }

    public static a<Integer> ax() {
        return new a("internal_debug", "delay_upload", 0).aB();
    }

    public static a<Long> ay() {
        return new a<>("internal_debug", "sentry_time", 0L);
    }

    public static a<Boolean> az() {
        return new a<>("internal_debug", "sentry_sample_switch", Boolean.FALSE);
    }

    public static a<String> b() {
        return new a("cn.jpush.android.user.profile", "devcie_id_generated_n", "").aB();
    }

    public static a<String> b(String str) {
        return new a("cn.jiguang.sdk.address", "dns_" + str, "").aC();
    }

    public static a<String> b(boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append("last_good_sis_address");
        sb.append(z3 ? "_V4" : "_V6");
        return new a("cn.jiguang.sdk.address", sb.toString(), "").aC();
    }

    public static a<String> c() {
        return new a("cn.jpush.android.user.profile", "cid_desc_data", "").aB();
    }

    public static a<Long> c(String str) {
        return new a<>("cn.jiguang.sdk.address", "dns_last_update_" + str, 0L);
    }

    public static a<String> c(boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append("last_good_conn");
        sb.append(z3 ? "_V4" : "_V6");
        return new a("cn.jiguang.sdk.address", sb.toString(), "").aC();
    }

    public static a<Long> d() {
        return new a<>("cn.jpush.android.user.profile", "ex_report_time", 0L);
    }

    public static a<String> d(String str) {
        return new a("cn.jiguang.sdk.address", "srv_" + str, "").aC();
    }

    public static a<String> d(boolean z3) {
        return (a<T>) new a("cn.jiguang.sdk.address", z3 ? "default_https_report" : "default_http_report", "").aB().aC();
    }

    public static a<Boolean> e() {
        return new a<>("cn.jpush.android.user.profile", "enable_auto_wakeup", Boolean.TRUE);
    }

    public static a<Long> e(String str) {
        return new a<>("cn.jiguang.sdk.address", "srv_last_update_" + str, 0L);
    }

    public static a<Boolean> f() {
        return new a<>("cn.jpush.android.user.profile", "enable_ci", Boolean.FALSE);
    }

    public static a<String> f(String str) {
        return new a("IpInfos", str, "").aC();
    }

    public static a<Boolean> g() {
        return new a<>("cn.jpush.android.user.profile", "enable_dynamicload", Boolean.TRUE);
    }

    public static a<String> g(String str) {
        return new a("IpInfos", g.d(str), "").aC();
    }

    public static a<Boolean> h() {
        return new a<>("cn.jpush.android.user.profile", "enable_appterminate", Boolean.TRUE);
    }

    public static a<Integer> h(String str) {
        return new a<>("netinfo", str, 0);
    }

    public static a<Boolean> i() {
        return new a<>("cn.jpush.android.user.profile", "use_tcp_ssl", Boolean.FALSE);
    }

    public static a<Boolean> j() {
        return new a<>("cn.jpush.android.user.profile", "count_switch", Boolean.TRUE);
    }

    public static a<Boolean> k() {
        return new a<>("cn.jpush.android.user.profile", "android_tcpreport_switch", Boolean.TRUE);
    }

    public static a<Boolean> l() {
        return new a<>("cn.jpush.android.user.profile", "net_length_switch", Boolean.TRUE);
    }

    public static a<Long> m() {
        return new a<>("cn.jpush.android.user.profile", "net_count_threshold", Long.valueOf(cn.jiguang.cf.b.f3374b));
    }

    public static a<Long> n() {
        return new a<>("cn.jpush.android.user.profile", "net_length_threshold", Long.valueOf(cn.jiguang.cf.b.f3373a));
    }

    public static a<Long> o() {
        return new a<>("cn.jpush.android.user.profile", "net_conn_count_threshold", Long.valueOf(cn.jiguang.cf.b.f3376d));
    }

    public static a<Long> p() {
        return new a<>("cn.jpush.android.user.profile", "net_conn_length_threshold", Long.valueOf(cn.jiguang.cf.b.f3375c));
    }

    public static a<Long> q() {
        return new a<>("cn.jpush.android.user.profile", "net_req", 0L);
    }

    public static a<Long> r() {
        return new a<>("cn.jpush.android.user.profile", "net_count", 0L);
    }

    public static a<Long> s() {
        return new a<>("cn.jpush.android.user.profile", "net_res", 0L);
    }

    public static a<Long> t() {
        return new a<>("cn.jpush.android.user.profile", "net_conn_req", 0L);
    }

    public static a<Long> u() {
        return new a<>("cn.jpush.android.user.profile", "net_conn_count", 0L);
    }

    public static a<Long> v() {
        return new a<>("cn.jpush.android.user.profile", "net_conn_res", 0L);
    }

    public static a<Long> w() {
        return new a<>("cn.jpush.android.user.profile", "net_day_time", 0L);
    }

    public static a<Long> x() {
        return new a("cn.jiguang.sdk.user.profile", "key_uid", 0L).aB();
    }

    public static a<String> y() {
        return new a("cn.jiguang.sdk.user.profile", "key_rid", "").aB();
    }

    public static a<Long> z() {
        return new a("cn.jiguang.sdk.user.profile", "key_rid_time", 0L).aB();
    }

    public a<T> a(T t3) {
        this.f3654e = t3;
        return this;
    }

    public a<T> i(String str) {
        this.f3652c = str;
        return this;
    }

    public a<T> j(String str) {
        this.f3653d = str;
        return this;
    }
}
