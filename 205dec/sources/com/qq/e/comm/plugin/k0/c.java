package com.qq.e.comm.plugin.k0;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.o2;
import com.qq.e.comm.plugin.util.x1;
import com.qq.e.dl.l.h;
import java.util.Set;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static long f44527a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static int f44528b = -1;

    public static long a(String str) {
        return com.qq.e.comm.plugin.d0.a.d().f().a("nusmi", str, 3) * 1000;
    }

    public static void a(e eVar, b bVar, String str) {
    }

    public static void a(b bVar, String str) {
    }

    public static boolean a(int i4) {
        return i4 > -1;
    }

    private static String b(g gVar) {
        if (gVar.k()) {
            return "sdaxfe_3";
        }
        if (gVar.h()) {
            return "sdaxfe_8";
        }
        if (gVar.g()) {
            return "sdaxfe_9";
        }
        if (gVar.j()) {
            return "sdaxfe_5";
        }
        if (gVar.e()) {
            return "sdaxfe_7";
        }
        if (gVar.f()) {
            return "sdaxfe_4";
        }
        if (gVar.i()) {
            return "sdaxfe_6";
        }
        return null;
    }

    public static void b(e eVar, b bVar, String str) {
    }

    public static int c(e eVar) {
        if (eVar == null) {
            return -1;
        }
        g o4 = eVar.o();
        int a4 = com.qq.e.comm.plugin.t.c.a("skstcv_" + o4.c(), eVar.q0(), -1, eVar.p0());
        return a4 >= 0 ? a4 : com.qq.e.comm.plugin.t.c.a("skstcv", eVar.q0(), -1, (b0) null);
    }

    public static void d() {
        f44527a = System.currentTimeMillis();
    }

    public static int e(e eVar) {
        int g4 = g(eVar);
        if (g4 > 0) {
            return g4;
        }
        d1.a("gdt_tag_sensor", "\u81ea\u6e32\u67d3\u6447\u4e00\u6447\u7075\u654f\u5ea6\u4f7f\u7528\u3010\u515c\u5e95\u503c: %s\u3011", 140);
        return 140;
    }

    public static boolean f(e eVar, com.qq.e.dl.l.j.c cVar) {
        int a4;
        int a5;
        if (eVar == null) {
            a4 = com.qq.e.comm.plugin.d0.a.d().f().a("svaugg", -1);
        } else {
            String a6 = a(eVar.o());
            if (a6 != null && (a5 = com.qq.e.comm.plugin.t.c.a(a6, eVar.q0(), -1, eVar.p0())) >= 0) {
                d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u8ba1\u7b97\u662f\u5426\u5e26G\u4f7f\u7528\u3010\u5f62\u6001\u5f00\u5173: %s, \u503c: %s\u3011", a6, Integer.valueOf(a5));
                return a5 == 1;
            }
            a4 = com.qq.e.comm.plugin.t.c.a("svaugg", eVar.q0(), -1, eVar.p0());
        }
        if (a4 >= 0) {
            d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u8ba1\u7b97\u662f\u5426\u5e26G\u4f7f\u7528\u3010\u603b\u5f00\u5173: %s, \u503c: %s\u3011", "svaugg", Integer.valueOf(a4));
            return a4 == 1;
        }
        int optInt = cVar.f47122c.optInt("bg", 1);
        d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u662f\u5426\u5e26G\u8ba1\u7b97\u4f7f\u7528\u3010DSL\u53c2\u6570\u503c\u6216\u515c\u5e95\u503c: %s\u3011", Integer.valueOf(optInt));
        return optInt == 1;
    }

    private static String g(g gVar) {
        if (gVar.k()) {
            return "sss";
        }
        if (gVar.h()) {
            return "sss_ihs";
        }
        if (gVar.g()) {
            return "sss_ifs";
        }
        if (gVar.j()) {
            return "sss_reward";
        }
        if (gVar.e()) {
            return "sss_banner";
        }
        if (gVar.f()) {
            return "sss_express";
        }
        if (gVar.i()) {
            return "sss_native";
        }
        return null;
    }

    public static int h(e eVar) {
        if (eVar == null) {
            return com.qq.e.comm.plugin.d0.a.d().f().a("shake_mode_control", -1);
        }
        return com.qq.e.comm.plugin.t.c.a("shake_mode_control", eVar.q0(), -1, eVar.p0());
    }

    public static long i(e eVar) {
        if (eVar == null) {
            return com.qq.e.comm.plugin.d0.a.d().f().a("nusmi", 3) * 1000;
        }
        return a(eVar.q0());
    }

    private static String j(g gVar) {
        if (gVar.k()) {
            return "skstt";
        }
        if (gVar.h()) {
            return "skstt_ihs";
        }
        if (gVar.g()) {
            return "skstt_ifs";
        }
        if (gVar.j()) {
            return "skstt_reward";
        }
        if (gVar.e()) {
            return "skstt_banner";
        }
        if (gVar.f()) {
            return "skstt_express";
        }
        if (gVar.i()) {
            return "skstt_native";
        }
        return null;
    }

    private static int k(e eVar) {
        int a4;
        if (eVar == null) {
            return com.qq.e.comm.plugin.d0.a.d().f().a("skstt_all", 45);
        }
        String j4 = j(eVar.o());
        if (j4 == null || (a4 = com.qq.e.comm.plugin.t.c.a(j4, eVar.q0(), -1, eVar.p0())) <= 0) {
            return com.qq.e.comm.plugin.t.c.a("skstt_all", eVar.q0(), 45, eVar.p0());
        }
        d1.a("gdt_tag_sensor", "\u626d\u4e00\u626d\u89d2\u5ea6\u9608\u503c\u4f7f\u7528\u3010\u5f62\u6001\u5f00\u5173: %s, \u503c: %s\u3011", j4, Integer.valueOf(a4));
        return a4;
    }

    public static int l(e eVar) {
        if (eVar == null) {
            return com.qq.e.comm.plugin.d0.a.d().f().a("stcvmr", 50);
        }
        return com.qq.e.comm.plugin.d0.a.d().f().a("stcvmr", eVar.q0(), 50);
    }

    public static int a(e eVar) {
        if (eVar == null) {
            return com.qq.e.comm.plugin.d0.a.d().f().a("stcvim", 500);
        }
        return com.qq.e.comm.plugin.d0.a.d().f().a("stcvim", eVar.q0(), 500);
    }

    private static String d(g gVar) {
        if (gVar.k()) {
            return "skefes_3";
        }
        if (gVar.h()) {
            return "skefes_8";
        }
        if (gVar.g()) {
            return "skefes_9";
        }
        if (gVar.j()) {
            return "skefes_5";
        }
        if (gVar.e()) {
            return "skefes_7";
        }
        if (gVar.f()) {
            return "skefes_4";
        }
        if (gVar.i()) {
            return "skefes_6";
        }
        return null;
    }

    public static int i(e eVar, com.qq.e.dl.l.j.c cVar) {
        int a4;
        int a5;
        if (eVar == null) {
            a4 = com.qq.e.comm.plugin.d0.a.d().f().a("skefes", -1);
        } else {
            String d4 = d(eVar.o());
            if (d4 != null && (a5 = com.qq.e.comm.plugin.t.c.a(d4, eVar.q0(), -1, eVar.p0())) > 0) {
                d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u6700\u5c0f\u65f6\u957f\u4f7f\u7528\u3010\u5f62\u6001\u5f00\u5173: %s, \u503c: %s\u3011", d4, Integer.valueOf(a5));
                return a5;
            }
            a4 = com.qq.e.comm.plugin.t.c.a("skefes", eVar.q0(), -1, eVar.p0());
        }
        if (a4 > 0) {
            d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u6700\u5c0f\u65f6\u957f\u4f7f\u7528\u3010\u603b\u5f00\u5173: %s, \u503c: %s\u3011", "skefes", Integer.valueOf(a4));
            return a4;
        }
        int optInt = cVar.f47122c.optInt("bn", -1);
        d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u6700\u5c0f\u6301\u7eed\u65f6\u95f4\u8ba1\u7b97\u4f7f\u7528\u3010DSL\u53c2\u6570\u503c\u6216\u515c\u5e95\u503c: %s\u3011", Integer.valueOf(optInt));
        return optInt;
    }

    private static String e(g gVar) {
        if (gVar.k()) {
            return "ssst";
        }
        if (gVar.h()) {
            return "ssst_ihs";
        }
        if (gVar.g()) {
            return "ssst_ifs";
        }
        if (gVar.j()) {
            return "ssst_reward";
        }
        if (gVar.e()) {
            return "ssst_banner";
        }
        if (gVar.f()) {
            return "ssst_express";
        }
        if (gVar.i()) {
            return "ssst_native";
        }
        return null;
    }

    public static int h(e eVar, com.qq.e.dl.l.j.c cVar) {
        int a4;
        int a5;
        if (eVar == null) {
            a4 = com.qq.e.comm.plugin.d0.a.d().f().a("seroas", -1);
        } else {
            String c4 = c(eVar.o());
            if (c4 != null && (a5 = com.qq.e.comm.plugin.t.c.a(c4, eVar.q0(), -1, eVar.p0())) > 0) {
                d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u6700\u5927\u65f6\u957f\u4f7f\u7528\u3010\u5f62\u6001\u5f00\u5173: %s, \u503c: %s\u3011", c4, Integer.valueOf(a5));
                return a5;
            }
            a4 = com.qq.e.comm.plugin.t.c.a("seroas", eVar.q0(), -1, eVar.p0());
        }
        if (a4 > 0) {
            d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u6700\u5927\u65f6\u957f\u4f7f\u7528\u3010\u603b\u5f00\u5173: %s, \u503c: %s\u3011", "seroas", Integer.valueOf(a4));
            return a4;
        }
        int optInt = cVar.f47122c.optInt("bx", -1);
        d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u6700\u5927\u6301\u7eed\u65f6\u95f4\u8ba1\u7b97\u4f7f\u7528\u3010DSL\u53c2\u6570\u503c\u6216\u515c\u5e95\u503c: %s\u3011", Integer.valueOf(optInt));
        return optInt;
    }

    public static boolean a(long j4) {
        if (System.currentTimeMillis() - f44527a < j4) {
            d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447/\u626d\u4e00\u626d\u8fc7\u4e8e\u9891\u7e41");
            return true;
        }
        return false;
    }

    public static h a(Set<h> set, int i4, int i5) {
        for (h hVar : set) {
            if (a(hVar, i4, i5)) {
                return hVar;
            }
        }
        return null;
    }

    private static boolean a(h hVar, int i4, int i5) {
        View m4;
        if (hVar == null || (m4 = hVar.m()) == null || !o2.a(m4.getContext(), m4, i4, true)) {
            return false;
        }
        if (i5 <= 0) {
            return true;
        }
        Pair<Boolean, Integer> a4 = o2.a(m4, i5);
        d1.c("gdt_tag_sensor", "\u88ab\u8986\u76d6\u6bd4\u4f8b\uff1a" + a4.second);
        return !((Boolean) a4.first).booleanValue();
    }

    public static int b(e eVar, com.qq.e.dl.l.j.c cVar) {
        int a4;
        int a5;
        if (eVar == null) {
            a4 = com.qq.e.comm.plugin.d0.a.d().f().a("sstms", -1);
        } else {
            String f4 = f(eVar.o());
            if (f4 != null && (a5 = com.qq.e.comm.plugin.t.c.a(f4, eVar.q0(), -1, eVar.p0())) > 0) {
                d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u91c7\u6837\u6b21\u6570\u4f7f\u7528\u3010\u5f62\u6001\u5f00\u5173: %s, \u503c: %s\u3011", f4, Integer.valueOf(a5));
                return a5;
            }
            a4 = com.qq.e.comm.plugin.t.c.a("sstms", eVar.q0(), -1, eVar.p0());
        }
        if (a4 > 0) {
            d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u91c7\u6837\u6b21\u6570\u4f7f\u7528\u3010\u603b\u5f00\u5173: %s, \u503c: %s\u3011", "sstms", Integer.valueOf(a4));
            return a4;
        }
        int optInt = cVar.f47122c.optInt("bc", 2);
        d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u91c7\u6837\u6b21\u6570\u4f7f\u7528\u3010DSL\u53c2\u6570\u503c\u6216\u515c\u5e95\u503c: %s\u3011", Integer.valueOf(optInt));
        return optInt;
    }

    private static String c(g gVar) {
        if (gVar.k()) {
            return "seroas_3";
        }
        if (gVar.h()) {
            return "seroas_8";
        }
        if (gVar.g()) {
            return "seroas_9";
        }
        if (gVar.j()) {
            return "seroas_5";
        }
        if (gVar.e()) {
            return "seroas_7";
        }
        if (gVar.f()) {
            return "seroas_4";
        }
        if (gVar.i()) {
            return "seroas_6";
        }
        return null;
    }

    private static int g(e eVar) {
        int a4;
        if (eVar == null) {
            return com.qq.e.comm.plugin.d0.a.d().f().a("sss_all", 140);
        }
        String g4 = g(eVar.o());
        if (g4 == null || (a4 = com.qq.e.comm.plugin.t.c.a(g4, eVar.q0(), -1, eVar.p0())) <= 0) {
            return com.qq.e.comm.plugin.t.c.a("sss_all", eVar.q0(), 140, eVar.p0());
        }
        d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u7075\u654f\u5ea6\u4f7f\u7528\u3010\u5f62\u6001\u5f00\u5173: %s, \u503c: %s\u3011", g4, Integer.valueOf(a4));
        return a4;
    }

    private static int j(e eVar) {
        int a4;
        if (eVar == null) {
            return com.qq.e.comm.plugin.d0.a.d().f().a("skstm_all", -1);
        }
        String i4 = i(eVar.o());
        if (i4 == null || (a4 = com.qq.e.comm.plugin.t.c.a(i4, eVar.q0(), -1, eVar.p0())) <= 0) {
            return com.qq.e.comm.plugin.t.c.a("skstm_all", eVar.q0(), -1, eVar.p0());
        }
        d1.a("gdt_tag_sensor", "\u626d\u4e00\u626d\u8f6c\u52a8\u65b9\u5411\u4f7f\u7528\u3010\u5f62\u6001\u5f00\u5173: %s, \u503c: %s\u3011", i4, Integer.valueOf(a4));
        return a4;
    }

    public static int d(e eVar) {
        int f4 = f(eVar);
        if (f4 > 0) {
            return f4;
        }
        d1.a("gdt_tag_sensor", "\u81ea\u6e32\u67d3\u6447\u4e00\u6447\u91c7\u6837\u6b21\u6570\u4f7f\u7528\u3010\u515c\u5e95\u503c: %s\u3011", 1);
        return 1;
    }

    public static int e(e eVar, com.qq.e.dl.l.j.c cVar) {
        int k4 = k(eVar);
        if (k4 > 0) {
            return k4;
        }
        int optInt = cVar.f47122c.optInt("tt", 45);
        d1.a("gdt_tag_sensor", "\u626d\u4e00\u626d\u89d2\u5ea6\u9608\u503c\u4f7f\u7528\u3010DSL\u53c2\u6570\u503c\u6216\u515c\u5e95\u503c: %s\u3011", Integer.valueOf(optInt));
        return optInt;
    }

    public static int d(e eVar, com.qq.e.dl.l.j.c cVar) {
        int j4 = j(eVar);
        if (j4 > 0) {
            return j4;
        }
        int optInt = cVar.f47122c.optInt("tm", 60);
        d1.a("gdt_tag_sensor", "\u626d\u4e00\u626d\u8f6c\u52a8\u65b9\u5411\u4f7f\u7528\u3010DSL\u53c2\u6570\u503c\u6216\u515c\u5e95\u503c: %s\u3011", Integer.valueOf(optInt));
        return optInt;
    }

    private static String f(g gVar) {
        if (gVar.k()) {
            return "sstms_3";
        }
        if (gVar.h()) {
            return "sstms_8";
        }
        if (gVar.g()) {
            return "sstms_9";
        }
        if (gVar.j()) {
            return "sstms_5";
        }
        if (gVar.e()) {
            return "sstms_7";
        }
        if (gVar.f()) {
            return "sstms_4";
        }
        if (gVar.i()) {
            return "sstms_6";
        }
        return null;
    }

    public static int c(e eVar, com.qq.e.dl.l.j.c cVar) {
        int g4 = g(eVar);
        if (g4 > 0) {
            return g4;
        }
        int optInt = cVar.f47122c.optInt("bv", 140);
        d1.a("gdt_tag_sensor", "\u539f\u751f\u5316\u6447\u4e00\u6447\u7075\u654f\u5ea6\u4f7f\u7528\u3010DSL\u53c2\u6570\u503c\u6216\u515c\u5e95\u503c: %s\u3011", Integer.valueOf(optInt));
        return optInt;
    }

    private static String i(g gVar) {
        if (gVar.k()) {
            return "skstm";
        }
        if (gVar.h()) {
            return "skstm_ihs";
        }
        if (gVar.g()) {
            return "skstm_ifs";
        }
        if (gVar.j()) {
            return "skstm_reward";
        }
        if (gVar.e()) {
            return "skstm_banner";
        }
        if (gVar.f()) {
            return "skstm_express";
        }
        if (gVar.i()) {
            return "skstm_native";
        }
        return null;
    }

    public static int[] g(e eVar, com.qq.e.dl.l.j.c cVar) {
        String str;
        String str2;
        String[] split;
        String valueOf = String.valueOf(-1);
        int[] iArr = {0};
        if (eVar == null) {
            str2 = com.qq.e.comm.plugin.d0.a.d().f().b("sdaxfe", valueOf);
            valueOf.equals(str2);
        } else {
            String b4 = b(eVar.o());
            if (!valueOf.equals(valueOf) || b4 == null) {
                str = valueOf;
            } else {
                str = com.qq.e.comm.plugin.t.c.a(b4, eVar.q0(), valueOf, eVar.p0());
                valueOf.equals(str);
            }
            if (valueOf.equals(str)) {
                str2 = com.qq.e.comm.plugin.t.c.a("sdaxfe", eVar.q0(), valueOf, eVar.p0());
                valueOf.equals(str2);
            } else {
                str2 = str;
            }
        }
        if (valueOf.equals(str2)) {
            str2 = cVar.f47122c.optString("bd", valueOf);
        }
        if (!valueOf.equals(str2) && !TextUtils.isEmpty(str2) && (split = str2.split(",")) != null && split.length != 0) {
            int[] iArr2 = new int[split.length];
            for (int i4 = 0; i4 < split.length; i4++) {
                try {
                    iArr2[i4] = Integer.parseInt(split[i4]);
                } catch (Exception unused) {
                }
            }
            return iArr2;
        }
        return iArr;
    }

    private static String h(g gVar) {
        if (gVar.k()) {
            return "tstspct_splash";
        }
        if (gVar.h()) {
            return "tstspct_ihs";
        }
        if (gVar.g()) {
            return "tstspct_ifs";
        }
        if (gVar.j()) {
            return "tstspct_reward";
        }
        if (gVar.e()) {
            return "tstspct_banner";
        }
        if (gVar.f()) {
            return "tstspct_feed";
        }
        if (gVar.i()) {
            return "tstspct_native";
        }
        return null;
    }

    public static float c() {
        return x1.a(com.qq.e.comm.plugin.d0.a.d().f().b("sttimed_t", "0.2"), 0.0f);
    }

    public static int b(e eVar) {
        String h4 = h(eVar.o());
        if (h4 != null) {
            return com.qq.e.comm.plugin.t.c.a(h4, eVar.q0(), -1, eVar.p0());
        }
        return -1;
    }

    private static int f(e eVar) {
        int a4;
        if (eVar == null) {
            return com.qq.e.comm.plugin.d0.a.d().f().a("ssst_all", 1);
        }
        String e4 = e(eVar.o());
        if (e4 == null || (a4 = com.qq.e.comm.plugin.t.c.a(e4, eVar.q0(), -1, eVar.p0())) <= 0) {
            return com.qq.e.comm.plugin.t.c.a("ssst_all", eVar.q0(), 1, eVar.p0());
        }
        d1.a("gdt_tag_sensor", "\u6447\u4e00\u6447\u91c7\u6837\u6b21\u6570\u4f7f\u7528\u3010\u5f62\u6001\u5f00\u5173: %s, \u503c: %s\u3011", e4, Integer.valueOf(a4));
        return a4;
    }

    private static String a(g gVar) {
        if (gVar.k()) {
            return "svaugg_3";
        }
        if (gVar.h()) {
            return "svaugg_8";
        }
        if (gVar.g()) {
            return "svaugg_9";
        }
        if (gVar.j()) {
            return "svaugg_5";
        }
        if (gVar.e()) {
            return "svaugg_7";
        }
        if (gVar.f()) {
            return "svaugg_4";
        }
        if (gVar.i()) {
            return "svaugg_6";
        }
        return null;
    }

    public static float b() {
        return x1.a(com.qq.e.comm.plugin.d0.a.d().f().b("sttimed_s", "0.5"), 0.0f);
    }

    public static int a(e eVar, com.qq.e.dl.l.j.c cVar) {
        int f4 = f(eVar);
        if (f4 > 0) {
            return f4;
        }
        int optInt = cVar.f47122c.optInt("bc", 1);
        d1.a("gdt_tag_sensor", "\u539f\u751f\u5316\u6447\u4e00\u6447\u91c7\u6837\u6b21\u6570\u4f7f\u7528\u3010DSL\u53c2\u6570\u503c\u6216\u515c\u5e95\u503c: %s\u3011", Integer.valueOf(optInt));
        return optInt;
    }

    public static int a(com.qq.e.dl.l.j.c cVar) {
        int optInt = cVar.f47122c.optInt("tts", -1);
        d1.a("gdt_tag_sensor", "\u626d\u4e00\u626d\u7b2c\u4e8c\u6b21\u89d2\u5ea6\u9608\u503c\u4f7f\u7528\u3010DSL\u53c2\u6570\u503c: %s\u3011", Integer.valueOf(optInt));
        return optInt;
    }

    public static boolean a() {
        if (f44528b == -1) {
            f44528b = com.qq.e.comm.plugin.d0.a.d().f().a("sbgur", 1);
        }
        return f44528b == 1;
    }
}
