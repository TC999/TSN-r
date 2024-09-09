package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: PathCenter.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class au {
    public static final String A = "rtd";
    public static final String B = "lepd";
    public static final String C = "ccfg";
    private static Map<String, String> D = null;
    private static String E = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f52569a = "env";

    /* renamed from: b  reason: collision with root package name */
    public static final String f52570b = "exp";

    /* renamed from: c  reason: collision with root package name */
    public static final String f52571c = "imp";

    /* renamed from: d  reason: collision with root package name */
    public static final String f52572d = "ua";

    /* renamed from: e  reason: collision with root package name */
    public static final String f52573e = "zc";

    /* renamed from: f  reason: collision with root package name */
    public static final String f52574f = "id";

    /* renamed from: g  reason: collision with root package name */
    public static final String f52575g = "zf";

    /* renamed from: h  reason: collision with root package name */
    public static final String f52576h = "exid";

    /* renamed from: i  reason: collision with root package name */
    public static final String f52577i = "ucc";

    /* renamed from: j  reason: collision with root package name */
    public static final String f52578j = "ugc";

    /* renamed from: k  reason: collision with root package name */
    public static final String f52579k = "usi";

    /* renamed from: l  reason: collision with root package name */
    public static final String f52580l = "uso";

    /* renamed from: m  reason: collision with root package name */
    public static final String f52581m = "user";

    /* renamed from: n  reason: collision with root package name */
    public static final String f52582n = "uspi";

    /* renamed from: o  reason: collision with root package name */
    public static final String f52583o = "dtfn";

    /* renamed from: p  reason: collision with root package name */
    public static final String f52584p = "pr";

    /* renamed from: q  reason: collision with root package name */
    public static final String f52585q = "upg";

    /* renamed from: r  reason: collision with root package name */
    public static final String f52586r = "pri";

    /* renamed from: s  reason: collision with root package name */
    public static final String f52587s = "probe";

    /* renamed from: t  reason: collision with root package name */
    public static final String f52588t = "bl";

    /* renamed from: u  reason: collision with root package name */
    public static final String f52589u = "wl";

    /* renamed from: v  reason: collision with root package name */
    public static final String f52590v = "subp";

    /* renamed from: w  reason: collision with root package name */
    public static final String f52591w = "subua";

    /* renamed from: x  reason: collision with root package name */
    public static final String f52592x = "sta";

    /* renamed from: y  reason: collision with root package name */
    public static final String f52593y = "emi";

    /* renamed from: z  reason: collision with root package name */
    public static final String f52594z = "sli";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: PathCenter.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final au f52595a = new au();

        private a() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        D = hashMap;
        E = "";
        hashMap.put("env", "envelope");
        D.put("exp", ".umeng");
        D.put("imp", ".imprint");
        D.put("ua", "ua.db");
        D.put("zc", "umeng_zero_cache.db");
        D.put("id", "umeng_it.cache");
        D.put("zf", "umeng_zcfg_flag");
        D.put("exid", "exid.dat");
        D.put("ucc", "umeng_common_config");
        D.put("ugc", "umeng_general_config");
        D.put("usi", "um_session_id");
        D.put("uso", "umeng_sp_oaid");
        D.put("user", "mobclick_agent_user_");
        D.put("uspi", "umeng_subprocess_info");
        D.put("dtfn", "delayed_transmission_flag_new");
        D.put("pr", "umeng_policy_result_flag");
        D.put("upg", "um_policy_grant");
        D.put("pri", "um_pri");
        D.put("probe", "UM_PROBE_DATA");
        D.put("bl", "ekv_bl");
        D.put("wl", "ekv_wl");
        D.put("subp", "subprocess/");
        D.put("subua", "ua_");
        D.put("sta", "stateless");
        D.put("emi", ".emitter");
        D.put("sli", "um_slmode_sp");
        D.put("rtd", "um_rtd_conf");
        D.put("lepd", "");
        D.put("ccfg", ".dmpvedpogjhejs.cfg");
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(E)) {
            if (str.length() > 3) {
                E = str.substring(0, 3) + "_";
                return;
            }
            E = str + "_";
        }
    }

    public String b(String str) {
        if (D.containsKey(str)) {
            String str2 = D.get(str);
            if (!"exp".equalsIgnoreCase(str) && !"imp".equalsIgnoreCase(str) && !"emi".equalsIgnoreCase(str)) {
                return E + str2;
            }
            return "." + E + str2.substring(1);
        }
        return "";
    }

    private au() {
    }

    public void a() {
        E = "";
    }

    public static au b() {
        return a.f52595a;
    }
}
