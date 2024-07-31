package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.umeng.analytics.pro.au */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class PathCenter {

    /* renamed from: A */
    public static final String f37677A = "rtd";

    /* renamed from: B */
    public static final String f37678B = "lepd";

    /* renamed from: C */
    public static final String f37679C = "ccfg";

    /* renamed from: D */
    private static Map<String, String> f37680D = null;

    /* renamed from: E */
    private static String f37681E = null;

    /* renamed from: a */
    public static final String f37682a = "env";

    /* renamed from: b */
    public static final String f37683b = "exp";

    /* renamed from: c */
    public static final String f37684c = "imp";

    /* renamed from: d */
    public static final String f37685d = "ua";

    /* renamed from: e */
    public static final String f37686e = "zc";

    /* renamed from: f */
    public static final String f37687f = "id";

    /* renamed from: g */
    public static final String f37688g = "zf";

    /* renamed from: h */
    public static final String f37689h = "exid";

    /* renamed from: i */
    public static final String f37690i = "ucc";

    /* renamed from: j */
    public static final String f37691j = "ugc";

    /* renamed from: k */
    public static final String f37692k = "usi";

    /* renamed from: l */
    public static final String f37693l = "uso";

    /* renamed from: m */
    public static final String f37694m = "user";

    /* renamed from: n */
    public static final String f37695n = "uspi";

    /* renamed from: o */
    public static final String f37696o = "dtfn";

    /* renamed from: p */
    public static final String f37697p = "pr";

    /* renamed from: q */
    public static final String f37698q = "upg";

    /* renamed from: r */
    public static final String f37699r = "pri";

    /* renamed from: s */
    public static final String f37700s = "probe";

    /* renamed from: t */
    public static final String f37701t = "bl";

    /* renamed from: u */
    public static final String f37702u = "wl";

    /* renamed from: v */
    public static final String f37703v = "subp";

    /* renamed from: w */
    public static final String f37704w = "subua";

    /* renamed from: x */
    public static final String f37705x = "sta";

    /* renamed from: y */
    public static final String f37706y = "emi";

    /* renamed from: z */
    public static final String f37707z = "sli";

    /* compiled from: PathCenter.java */
    /* renamed from: com.umeng.analytics.pro.au$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13114a {

        /* renamed from: a */
        private static final PathCenter f37708a = new PathCenter();

        private C13114a() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f37680D = hashMap;
        f37681E = "";
        hashMap.put(f37682a, "envelope");
        f37680D.put(f37683b, ".umeng");
        f37680D.put(f37684c, ".imprint");
        f37680D.put(f37685d, "ua.db");
        f37680D.put(f37686e, "umeng_zero_cache.db");
        f37680D.put("id", "umeng_it.cache");
        f37680D.put(f37688g, "umeng_zcfg_flag");
        f37680D.put(f37689h, "exid.dat");
        f37680D.put(f37690i, "umeng_common_config");
        f37680D.put(f37691j, "umeng_general_config");
        f37680D.put(f37692k, "um_session_id");
        f37680D.put(f37693l, "umeng_sp_oaid");
        f37680D.put(f37694m, "mobclick_agent_user_");
        f37680D.put(f37695n, "umeng_subprocess_info");
        f37680D.put(f37696o, "delayed_transmission_flag_new");
        f37680D.put("pr", "umeng_policy_result_flag");
        f37680D.put(f37698q, "um_policy_grant");
        f37680D.put(f37699r, "um_pri");
        f37680D.put(f37700s, "UM_PROBE_DATA");
        f37680D.put(f37701t, "ekv_bl");
        f37680D.put(f37702u, "ekv_wl");
        f37680D.put(f37703v, UMDBConfig.f38174a);
        f37680D.put(f37704w, "ua_");
        f37680D.put(f37705x, "stateless");
        f37680D.put(f37706y, ".emitter");
        f37680D.put(f37707z, "um_slmode_sp");
        f37680D.put(f37677A, "um_rtd_conf");
        f37680D.put(f37678B, "");
        f37680D.put(f37679C, ".dmpvedpogjhejs.cfg");
    }

    /* renamed from: a */
    public void m14696a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(f37681E)) {
            if (str.length() > 3) {
                f37681E = str.substring(0, 3) + "_";
                return;
            }
            f37681E = str + "_";
        }
    }

    /* renamed from: b */
    public String m14694b(String str) {
        if (f37680D.containsKey(str)) {
            String str2 = f37680D.get(str);
            if (!f37683b.equalsIgnoreCase(str) && !f37684c.equalsIgnoreCase(str) && !f37706y.equalsIgnoreCase(str)) {
                return f37681E + str2;
            }
            return "." + f37681E + str2.substring(1);
        }
        return "";
    }

    private PathCenter() {
    }

    /* renamed from: a */
    public void m14697a() {
        f37681E = "";
    }

    /* renamed from: b */
    public static PathCenter m14695b() {
        return C13114a.f37708a;
    }
}
