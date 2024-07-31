package com.bytedance.pangle.p118c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.pangle.c.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6073b {

    /* renamed from: b */
    public static String f21864b = "request_finish";

    /* renamed from: c */
    public static String f21865c = "download_start";

    /* renamed from: d */
    public static String f21866d = "download_finish";

    /* renamed from: e */
    public static String f21867e = "install_start";

    /* renamed from: f */
    public static String f21868f = "install_finish";

    /* renamed from: g */
    public static String f21869g = "7z_unzip_start";

    /* renamed from: h */
    public static String f21870h = "7z_unzip_finish";

    /* renamed from: i */
    public static String f21871i = "load_start";

    /* renamed from: j */
    public static String f21872j = "load_finish";

    /* renamed from: k */
    public static String f21873k = "rm_entry_finish";

    /* renamed from: l */
    private static volatile C6073b f21874l;

    /* renamed from: a */
    public final List<InterfaceC6072a> f21875a = new ArrayList();

    /* renamed from: com.bytedance.pangle.c.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6074a {

        /* renamed from: A */
        public static int f21876A = 32007;

        /* renamed from: B */
        public static int f21877B = 32008;

        /* renamed from: C */
        public static int f21878C = 32999;

        /* renamed from: D */
        public static int f21879D = 40000;

        /* renamed from: E */
        public static int f21880E = 41000;

        /* renamed from: F */
        public static int f21881F = 42000;

        /* renamed from: G */
        public static int f21882G = 50000;

        /* renamed from: H */
        public static int f21883H = 50004;

        /* renamed from: a */
        public static int f21884a = 1;

        /* renamed from: b */
        public static int f21885b = 2;

        /* renamed from: c */
        public static int f21886c = -1;

        /* renamed from: d */
        public static int f21887d = -2;

        /* renamed from: e */
        public static int f21888e = 12000;

        /* renamed from: f */
        public static int f21889f = 12001;

        /* renamed from: g */
        public static int f21890g = 12002;

        /* renamed from: h */
        public static int f21891h = 12003;

        /* renamed from: i */
        public static int f21892i = 12004;

        /* renamed from: j */
        public static int f21893j = 20000;

        /* renamed from: k */
        public static int f21894k = 21000;

        /* renamed from: l */
        public static int f21895l = 21001;

        /* renamed from: m */
        public static int f21896m = 21002;

        /* renamed from: n */
        public static int f21897n = 22000;

        /* renamed from: o */
        public static int f21898o = 22001;

        /* renamed from: p */
        public static int f21899p = 22002;

        /* renamed from: q */
        public static int f21900q = 22999;

        /* renamed from: r */
        public static int f21901r = 30000;

        /* renamed from: s */
        public static int f21902s = 31000;

        /* renamed from: t */
        public static int f21903t = 32000;

        /* renamed from: u */
        public static int f21904u = 32001;

        /* renamed from: v */
        public static int f21905v = 32002;

        /* renamed from: w */
        public static int f21906w = 32003;

        /* renamed from: x */
        public static int f21907x = 32004;

        /* renamed from: y */
        public static int f21908y = 32005;

        /* renamed from: z */
        public static int f21909z = 32006;
    }

    private C6073b() {
    }

    /* renamed from: a */
    public static C6073b m37254a() {
        if (f21874l == null) {
            synchronized (C6073b.class) {
                f21874l = new C6073b();
            }
        }
        return f21874l;
    }

    /* renamed from: a */
    public final void m37253a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.f21875a) {
            for (InterfaceC6072a interfaceC6072a : this.f21875a) {
                interfaceC6072a.mo37085a(str, jSONObject, jSONObject2, jSONObject3);
            }
        }
    }
}
