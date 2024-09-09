package com.bytedance.pangle.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f28633b = "request_finish";

    /* renamed from: c  reason: collision with root package name */
    public static String f28634c = "download_start";

    /* renamed from: d  reason: collision with root package name */
    public static String f28635d = "download_finish";

    /* renamed from: e  reason: collision with root package name */
    public static String f28636e = "install_start";

    /* renamed from: f  reason: collision with root package name */
    public static String f28637f = "install_finish";

    /* renamed from: g  reason: collision with root package name */
    public static String f28638g = "7z_unzip_start";

    /* renamed from: h  reason: collision with root package name */
    public static String f28639h = "7z_unzip_finish";

    /* renamed from: i  reason: collision with root package name */
    public static String f28640i = "load_start";

    /* renamed from: j  reason: collision with root package name */
    public static String f28641j = "load_finish";

    /* renamed from: k  reason: collision with root package name */
    public static String f28642k = "rm_entry_finish";

    /* renamed from: l  reason: collision with root package name */
    private static volatile b f28643l;

    /* renamed from: a  reason: collision with root package name */
    public final List<com.bytedance.pangle.c.a> f28644a = new ArrayList();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a {
        public static int A = 32007;
        public static int B = 32008;
        public static int C = 32999;
        public static int D = 40000;
        public static int E = 41000;
        public static int F = 42000;
        public static int G = 50000;
        public static int H = 50004;

        /* renamed from: a  reason: collision with root package name */
        public static int f28645a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static int f28646b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static int f28647c = -1;

        /* renamed from: d  reason: collision with root package name */
        public static int f28648d = -2;

        /* renamed from: e  reason: collision with root package name */
        public static int f28649e = 12000;

        /* renamed from: f  reason: collision with root package name */
        public static int f28650f = 12001;

        /* renamed from: g  reason: collision with root package name */
        public static int f28651g = 12002;

        /* renamed from: h  reason: collision with root package name */
        public static int f28652h = 12003;

        /* renamed from: i  reason: collision with root package name */
        public static int f28653i = 12004;

        /* renamed from: j  reason: collision with root package name */
        public static int f28654j = 20000;

        /* renamed from: k  reason: collision with root package name */
        public static int f28655k = 21000;

        /* renamed from: l  reason: collision with root package name */
        public static int f28656l = 21001;

        /* renamed from: m  reason: collision with root package name */
        public static int f28657m = 21002;

        /* renamed from: n  reason: collision with root package name */
        public static int f28658n = 22000;

        /* renamed from: o  reason: collision with root package name */
        public static int f28659o = 22001;

        /* renamed from: p  reason: collision with root package name */
        public static int f28660p = 22002;

        /* renamed from: q  reason: collision with root package name */
        public static int f28661q = 22999;

        /* renamed from: r  reason: collision with root package name */
        public static int f28662r = 30000;

        /* renamed from: s  reason: collision with root package name */
        public static int f28663s = 31000;

        /* renamed from: t  reason: collision with root package name */
        public static int f28664t = 32000;

        /* renamed from: u  reason: collision with root package name */
        public static int f28665u = 32001;

        /* renamed from: v  reason: collision with root package name */
        public static int f28666v = 32002;

        /* renamed from: w  reason: collision with root package name */
        public static int f28667w = 32003;

        /* renamed from: x  reason: collision with root package name */
        public static int f28668x = 32004;

        /* renamed from: y  reason: collision with root package name */
        public static int f28669y = 32005;

        /* renamed from: z  reason: collision with root package name */
        public static int f28670z = 32006;
    }

    private b() {
    }

    public static b a() {
        if (f28643l == null) {
            synchronized (b.class) {
                f28643l = new b();
            }
        }
        return f28643l;
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.f28644a) {
            for (com.bytedance.pangle.c.a aVar : this.f28644a) {
                aVar.a(str, jSONObject, jSONObject2, jSONObject3);
            }
        }
    }
}
