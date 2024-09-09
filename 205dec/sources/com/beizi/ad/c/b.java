package com.beizi.ad.c;

import com.beizi.ad.c.e;
import com.beizi.ad.lance.a.k;
import com.beizi.ad.lance.a.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdResponseOuterClass.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdResponseOuterClass.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private e.f f13284a;

        /* renamed from: b  reason: collision with root package name */
        private String f13285b;

        /* renamed from: c  reason: collision with root package name */
        private List<e> f13286c;

        public e.f a() {
            return this.f13284a;
        }

        public String b() {
            return this.f13285b;
        }

        public List<e> c() {
            return this.f13286c;
        }

        public int d() {
            List<e> list = this.f13286c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void a(e.f fVar) {
            this.f13284a = fVar;
        }

        public void a(String str) {
            this.f13285b = str;
        }

        public void a(List<e> list) {
            this.f13286c = list;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdResponseOuterClass.java */
    /* renamed from: com.beizi.ad.c.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class C0119b {

        /* renamed from: a  reason: collision with root package name */
        private String f13287a;

        /* renamed from: b  reason: collision with root package name */
        private String f13288b;

        /* renamed from: c  reason: collision with root package name */
        private int f13289c;

        /* renamed from: d  reason: collision with root package name */
        private String f13290d;

        /* renamed from: e  reason: collision with root package name */
        private String f13291e;

        /* renamed from: f  reason: collision with root package name */
        private String f13292f;

        /* renamed from: g  reason: collision with root package name */
        private String f13293g;

        /* renamed from: h  reason: collision with root package name */
        private String f13294h;

        /* renamed from: i  reason: collision with root package name */
        private String f13295i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f13296j;

        /* renamed from: k  reason: collision with root package name */
        private int f13297k;

        /* renamed from: l  reason: collision with root package name */
        private h f13298l;

        /* renamed from: m  reason: collision with root package name */
        private C0120b f13299m;

        /* renamed from: n  reason: collision with root package name */
        private c f13300n;

        /* renamed from: o  reason: collision with root package name */
        private List<h> f13301o;

        /* renamed from: p  reason: collision with root package name */
        private String f13302p;

        /* renamed from: q  reason: collision with root package name */
        private String f13303q;

        /* renamed from: r  reason: collision with root package name */
        private String f13304r;

        /* renamed from: s  reason: collision with root package name */
        private String f13305s;

        /* renamed from: t  reason: collision with root package name */
        private String f13306t;

        /* renamed from: u  reason: collision with root package name */
        private String f13307u;

        /* renamed from: v  reason: collision with root package name */
        private String f13308v;

        /* renamed from: w  reason: collision with root package name */
        private a f13309w;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: AdResponseOuterClass.java */
        /* renamed from: com.beizi.ad.c.b$b$a */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f13310a;

            /* renamed from: b  reason: collision with root package name */
            private int f13311b;

            public int a() {
                return this.f13310a;
            }

            public int b() {
                return this.f13311b;
            }

            public void a(int i4) {
                this.f13310a = i4;
            }

            public void b(int i4) {
                this.f13311b = i4;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: AdResponseOuterClass.java */
        /* renamed from: com.beizi.ad.c.b$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class C0120b implements Serializable {

            /* renamed from: a  reason: collision with root package name */
            private List<String> f13312a;

            /* renamed from: b  reason: collision with root package name */
            private List<String> f13313b;

            /* renamed from: c  reason: collision with root package name */
            private List<String> f13314c;

            /* renamed from: d  reason: collision with root package name */
            private List<String> f13315d;

            /* renamed from: e  reason: collision with root package name */
            private List<String> f13316e;

            /* renamed from: f  reason: collision with root package name */
            private List<String> f13317f;

            /* renamed from: g  reason: collision with root package name */
            private List<String> f13318g;

            /* renamed from: h  reason: collision with root package name */
            private List<String> f13319h;

            /* renamed from: i  reason: collision with root package name */
            private List<String> f13320i;

            /* renamed from: j  reason: collision with root package name */
            private List<String> f13321j;

            /* renamed from: k  reason: collision with root package name */
            private List<String> f13322k;

            /* renamed from: l  reason: collision with root package name */
            private List<String> f13323l;

            /* renamed from: m  reason: collision with root package name */
            private List<String> f13324m;

            /* renamed from: n  reason: collision with root package name */
            private List<String> f13325n;

            /* renamed from: o  reason: collision with root package name */
            private List<String> f13326o;

            /* renamed from: p  reason: collision with root package name */
            private List<String> f13327p;

            public List<String> a() {
                return this.f13312a;
            }

            public List<String> b() {
                return this.f13313b;
            }

            public List<String> c() {
                return this.f13314c;
            }

            public List<String> d() {
                return this.f13315d;
            }

            public List<String> e() {
                return this.f13316e;
            }

            public void f(List<String> list) {
                this.f13317f = list;
            }

            public void g(List<String> list) {
                this.f13318g = list;
            }

            public void h(List<String> list) {
                this.f13319h = list;
            }

            public void i(List<String> list) {
                this.f13320i = list;
            }

            public void j(List<String> list) {
                this.f13321j = list;
            }

            public void k(List<String> list) {
                this.f13322k = list;
            }

            public void l(List<String> list) {
                this.f13323l = list;
            }

            public void m(List<String> list) {
                this.f13324m = list;
            }

            public void n(List<String> list) {
                this.f13325n = list;
            }

            public void o(List<String> list) {
                this.f13326o = list;
            }

            public void p(List<String> list) {
                this.f13327p = list;
            }

            public void a(List<String> list) {
                this.f13312a = list;
            }

            public void b(List<String> list) {
                this.f13313b = list;
            }

            public void c(List<String> list) {
                this.f13314c = list;
            }

            public void d(List<String> list) {
                this.f13315d = list;
            }

            public void e(List<String> list) {
                this.f13316e = list;
            }

            public List<String> f() {
                return this.f13323l;
            }

            public List<String> g() {
                return this.f13324m;
            }

            public List<String> h() {
                return this.f13325n;
            }

            public List<String> i() {
                return this.f13326o;
            }

            public List<String> j() {
                return this.f13327p;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: AdResponseOuterClass.java */
        /* renamed from: com.beizi.ad.c.b$b$c */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class c {

            /* renamed from: a  reason: collision with root package name */
            private List<String> f13328a;

            /* renamed from: b  reason: collision with root package name */
            private List<String> f13329b;

            /* renamed from: c  reason: collision with root package name */
            private List<String> f13330c;

            /* renamed from: d  reason: collision with root package name */
            private List<String> f13331d;

            /* renamed from: e  reason: collision with root package name */
            private List<String> f13332e;

            /* renamed from: f  reason: collision with root package name */
            private List<a> f13333f;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
            /* compiled from: AdResponseOuterClass.java */
            /* renamed from: com.beizi.ad.c.b$b$c$a */
            /* loaded from: E:\TSN-r\205dec\7502512.dex */
            public static class a {

                /* renamed from: a  reason: collision with root package name */
                private int f13334a;

                /* renamed from: b  reason: collision with root package name */
                private List<String> f13335b;

                public void a(int i4) {
                    this.f13334a = i4;
                }

                public void a(List<String> list) {
                    this.f13335b = list;
                }
            }

            public void a(List<String> list) {
                this.f13328a = list;
            }

            public void b(List<String> list) {
                this.f13329b = list;
            }

            public void c(List<String> list) {
                this.f13330c = list;
            }

            public void d(List<String> list) {
                this.f13331d = list;
            }

            public void e(List<String> list) {
                this.f13332e = list;
            }

            public void f(List<a> list) {
                this.f13333f = list;
            }
        }

        public String a() {
            return this.f13287a;
        }

        public String b() {
            return this.f13288b;
        }

        public int c() {
            return this.f13289c;
        }

        public String d() {
            return this.f13290d;
        }

        public String e() {
            return this.f13291e;
        }

        public String f() {
            return this.f13293g;
        }

        public String g() {
            return this.f13294h;
        }

        public String h() {
            return this.f13295i;
        }

        public h i() {
            return this.f13298l;
        }

        public C0120b j() {
            return this.f13299m;
        }

        public c k() {
            return this.f13300n;
        }

        public List<h> l() {
            return this.f13301o;
        }

        public String m() {
            return this.f13302p;
        }

        public String n() {
            return this.f13303q;
        }

        public String o() {
            return this.f13304r;
        }

        public String p() {
            return this.f13305s;
        }

        public String q() {
            return this.f13306t;
        }

        public String r() {
            return this.f13307u;
        }

        public String s() {
            return this.f13308v;
        }

        public a t() {
            return this.f13309w;
        }

        public void a(String str) {
            this.f13287a = str;
        }

        public void b(String str) {
            this.f13288b = str;
        }

        public void c(String str) {
            this.f13290d = str;
        }

        public void d(String str) {
            this.f13291e = str;
        }

        public void e(String str) {
            this.f13292f = str;
        }

        public void f(String str) {
            this.f13293g = str;
        }

        public void g(String str) {
            this.f13294h = str;
        }

        public void h(String str) {
            this.f13302p = str;
        }

        public void i(String str) {
            this.f13303q = str;
        }

        public void j(String str) {
            this.f13304r = str;
        }

        public void k(String str) {
            this.f13305s = str;
        }

        public void l(String str) {
            this.f13306t = str;
        }

        public void m(String str) {
            this.f13307u = str;
        }

        public void n(String str) {
            this.f13308v = str;
        }

        public void a(int i4) {
            this.f13289c = i4;
        }

        public void b(int i4) {
            this.f13297k = i4;
        }

        public void a(boolean z3) {
            this.f13296j = z3;
        }

        public void a(C0120b c0120b) {
            this.f13299m = c0120b;
        }

        public void a(c cVar) {
            this.f13300n = cVar;
        }

        public void a(List<h> list) {
            this.f13301o = list;
        }

        public void a(a aVar) {
            this.f13309w = aVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdResponseOuterClass.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private String f13336a;

        /* renamed from: b  reason: collision with root package name */
        private String f13337b;

        /* renamed from: c  reason: collision with root package name */
        private String f13338c;

        /* renamed from: d  reason: collision with root package name */
        private String f13339d;

        public String a() {
            return this.f13336a;
        }

        public String b() {
            return this.f13337b;
        }

        public String c() {
            return this.f13338c;
        }

        public String d() {
            return this.f13339d;
        }

        public void a(String str) {
            this.f13336a = str;
        }

        public void b(String str) {
            this.f13337b = str;
        }

        public void c(String str) {
            this.f13338c = str;
        }

        public void d(String str) {
            this.f13339d = str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdResponseOuterClass.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private String f13340a;

        /* renamed from: b  reason: collision with root package name */
        private C0119b f13341b;

        /* renamed from: c  reason: collision with root package name */
        private c f13342c;

        /* renamed from: d  reason: collision with root package name */
        private List<a> f13343d;

        /* renamed from: e  reason: collision with root package name */
        private List<f> f13344e;

        /* renamed from: f  reason: collision with root package name */
        private String f13345f;

        /* renamed from: g  reason: collision with root package name */
        private String f13346g;

        public String a() {
            return this.f13340a;
        }

        public String b() {
            return this.f13346g;
        }

        public C0119b c() {
            return this.f13341b;
        }

        public int d() {
            List<a> list = this.f13343d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public c e() {
            return this.f13342c;
        }

        public List<a> f() {
            return this.f13343d;
        }

        public List<f> g() {
            return this.f13344e;
        }

        public int h() {
            List<f> list = this.f13344e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String i() {
            return this.f13345f;
        }

        public void a(String str) {
            this.f13340a = str;
        }

        public void b(String str) {
            this.f13346g = str;
        }

        public void c(String str) {
            this.f13345f = str;
        }

        public void a(C0119b c0119b) {
            this.f13341b = c0119b;
        }

        public void a(c cVar) {
            this.f13342c = cVar;
        }

        public void a(List<a> list) {
            this.f13343d = list;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdResponseOuterClass.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private String f13347a;

        /* renamed from: b  reason: collision with root package name */
        private String f13348b;

        public String a() {
            return this.f13347a;
        }

        public String b() {
            return this.f13348b;
        }

        public void a(String str) {
            this.f13347a = str;
        }

        public void b(String str) {
            this.f13348b = str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdResponseOuterClass.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private String f13349a;

        /* renamed from: b  reason: collision with root package name */
        private String f13350b;

        /* renamed from: c  reason: collision with root package name */
        private String f13351c;

        public String a() {
            return this.f13349a;
        }

        public String b() {
            return this.f13350b;
        }

        public String c() {
            return this.f13351c;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdResponseOuterClass.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        private String f13352a;

        /* renamed from: b  reason: collision with root package name */
        private String f13353b;

        public String a() {
            return this.f13352a;
        }

        public String b() {
            return this.f13353b;
        }

        public void a(String str) {
            this.f13352a = str;
        }

        public void b(String str) {
            this.f13353b = str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdResponseOuterClass.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        private String f13354a;

        /* renamed from: b  reason: collision with root package name */
        private String f13355b;

        /* renamed from: c  reason: collision with root package name */
        private String f13356c;

        /* renamed from: d  reason: collision with root package name */
        private String f13357d;

        /* renamed from: e  reason: collision with root package name */
        private String f13358e;

        /* renamed from: f  reason: collision with root package name */
        private String f13359f;

        /* renamed from: g  reason: collision with root package name */
        private String f13360g;

        public String a() {
            return this.f13354a;
        }

        public String b() {
            return this.f13355b;
        }

        public String c() {
            return this.f13356c;
        }

        public String d() {
            return this.f13357d;
        }

        public String e() {
            return this.f13358e;
        }

        public void f(String str) {
            this.f13359f = str;
        }

        public void g(String str) {
            this.f13360g = str;
        }

        public void a(String str) {
            this.f13354a = str;
        }

        public void b(String str) {
            this.f13355b = str;
        }

        public void c(String str) {
            this.f13356c = str;
        }

        public void d(String str) {
            this.f13357d = str;
        }

        public void e(String str) {
            this.f13358e = str;
        }

        public String f() {
            return this.f13360g;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdResponseOuterClass.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        private int f13361a;

        /* renamed from: b  reason: collision with root package name */
        private String f13362b;

        /* renamed from: c  reason: collision with root package name */
        private String f13363c;

        /* renamed from: d  reason: collision with root package name */
        private long f13364d;

        /* renamed from: e  reason: collision with root package name */
        private List<j> f13365e;

        public int a() {
            List<j> list = this.f13365e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public int b() {
            return this.f13361a;
        }

        public String c() {
            return this.f13362b;
        }

        public String d() {
            return this.f13363c;
        }

        public List<j> e() {
            return this.f13365e;
        }

        private static i c(String str) throws JSONException {
            String str2;
            i iVar;
            JSONArray jSONArray;
            String str3;
            i iVar2;
            ArrayList arrayList;
            int i4;
            JSONArray jSONArray2;
            i iVar3;
            ArrayList arrayList2;
            int i5;
            JSONArray jSONArray3;
            ArrayList arrayList3;
            int i6;
            JSONArray jSONArray4;
            ArrayList arrayList4;
            String b4 = com.beizi.ad.lance.a.a.b(k.a(), str);
            String str4 = "ServerResponse";
            l.d("ServerResponse", "decryptStr = " + b4);
            JSONObject jSONObject = new JSONObject(b4);
            i iVar4 = new i();
            try {
                iVar4.a(jSONObject.optString("errcode"));
                iVar4.b(jSONObject.optString("errmsg"));
                iVar4.a(jSONObject.optInt("status"));
                iVar4.a(jSONObject.optLong("ts"));
                JSONArray optJSONArray = jSONObject.optJSONArray("spaceInfo");
                ArrayList arrayList5 = new ArrayList();
                if (b(optJSONArray)) {
                    int i7 = 0;
                    while (i7 < optJSONArray.length()) {
                        j jVar = new j();
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i7);
                        if (optJSONObject != null) {
                            jVar.a(optJSONObject.optString("spaceID"));
                            jVar.b(optJSONObject.optString("spaceParam"));
                            jVar.a(e.a.a(optJSONObject.optInt("adpType")));
                            jVar.a(optJSONObject.optInt("refreshInterval"));
                            jVar.a(e.h.a(optJSONObject.optInt("screenDirection")));
                            jVar.c(optJSONObject.optString("width"));
                            jVar.d(optJSONObject.optString("height"));
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("adpPosition");
                            g gVar = new g();
                            gVar.a(optJSONObject2.optString("x"));
                            gVar.b(optJSONObject2.optString("y"));
                            jVar.a(gVar);
                            jVar.a(optJSONObject.optBoolean("autoClose"));
                            jVar.b(optJSONObject.optInt("maxTime"));
                            jVar.b(optJSONObject.optBoolean("manualClosable"));
                            jVar.c(optJSONObject.optInt("minTime"));
                            jVar.c(optJSONObject.optBoolean("wifiPreload"));
                            jVar.d(optJSONObject.optBoolean(CampaignEx.JSON_NATIVE_VIDEO_MUTE));
                            jVar.e(optJSONObject.optBoolean("fullScreen"));
                            jVar.f(optJSONObject.optBoolean("autoPlay"));
                            jVar.d(optJSONObject.optInt("orgID"));
                            jVar.e(optJSONObject.optInt("contentType"));
                            jVar.e(optJSONObject.optString("appID"));
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("adResponse");
                            ArrayList arrayList6 = new ArrayList();
                            if (b(optJSONArray2)) {
                                int i8 = 0;
                                while (i8 < optJSONArray2.length()) {
                                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i8);
                                    if (optJSONObject3 != null) {
                                        d dVar = new d();
                                        dVar.a(optJSONObject3.optString("extInfo"));
                                        dVar.b(optJSONObject3.optString("adid"));
                                        JSONArray optJSONArray3 = optJSONObject3.optJSONArray("contentInfo");
                                        ArrayList arrayList7 = new ArrayList();
                                        if (b(optJSONArray3)) {
                                            jSONArray2 = optJSONArray;
                                            jSONArray3 = optJSONArray2;
                                            int i9 = 0;
                                            while (i9 < optJSONArray3.length()) {
                                                JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i9);
                                                JSONArray jSONArray5 = optJSONArray3;
                                                a aVar = new a();
                                                str2 = str4;
                                                try {
                                                    aVar.a(optJSONObject4.optString("template"));
                                                    aVar.a(e.f.a(optJSONObject4.optInt("renderType")));
                                                    JSONArray optJSONArray4 = optJSONObject4.optJSONArray("adcontentSlot");
                                                    if (b(optJSONArray4)) {
                                                        ArrayList arrayList8 = new ArrayList();
                                                        iVar3 = iVar4;
                                                        i6 = i7;
                                                        int i10 = 0;
                                                        while (i10 < optJSONArray4.length()) {
                                                            try {
                                                                JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i10);
                                                                if (optJSONObject5 != null) {
                                                                    jSONArray4 = optJSONArray4;
                                                                    e eVar = new e();
                                                                    arrayList4 = arrayList5;
                                                                    eVar.a(optJSONObject5.optString("md5"));
                                                                    eVar.b(optJSONObject5.optString("content"));
                                                                    arrayList8.add(eVar);
                                                                } else {
                                                                    jSONArray4 = optJSONArray4;
                                                                    arrayList4 = arrayList5;
                                                                }
                                                                i10++;
                                                                optJSONArray4 = jSONArray4;
                                                                arrayList5 = arrayList4;
                                                            } catch (JSONException e4) {
                                                                e = e4;
                                                                iVar = iVar3;
                                                                l.c(str2, "JSONException e = " + e.getMessage());
                                                                return iVar;
                                                            }
                                                        }
                                                        arrayList3 = arrayList5;
                                                        aVar.a(arrayList8);
                                                    } else {
                                                        iVar3 = iVar4;
                                                        arrayList3 = arrayList5;
                                                        i6 = i7;
                                                    }
                                                    arrayList7.add(aVar);
                                                    i9++;
                                                    optJSONArray3 = jSONArray5;
                                                    str4 = str2;
                                                    iVar4 = iVar3;
                                                    i7 = i6;
                                                    arrayList5 = arrayList3;
                                                } catch (JSONException e5) {
                                                    e = e5;
                                                    iVar = iVar4;
                                                    l.c(str2, "JSONException e = " + e.getMessage());
                                                    return iVar;
                                                }
                                            }
                                            str2 = str4;
                                            iVar3 = iVar4;
                                            arrayList2 = arrayList5;
                                            i5 = i7;
                                            dVar.a(arrayList7);
                                        } else {
                                            jSONArray2 = optJSONArray;
                                            str2 = str4;
                                            iVar3 = iVar4;
                                            arrayList2 = arrayList5;
                                            i5 = i7;
                                            jSONArray3 = optJSONArray2;
                                        }
                                        JSONObject optJSONObject6 = optJSONObject3.optJSONObject("adLogo");
                                        if (optJSONObject6 != null) {
                                            c cVar = new c();
                                            cVar.b(optJSONObject6.optString("adLabel"));
                                            cVar.a(optJSONObject6.optString("adLabelUrl"));
                                            cVar.d(optJSONObject6.optString("sourceLabel"));
                                            cVar.c(optJSONObject6.optString("sourceUrl"));
                                            dVar.a(cVar);
                                        }
                                        dVar.c(optJSONObject3.optString(BidResponsed.KEY_PRICE));
                                        C0119b c0119b = new C0119b();
                                        JSONObject optJSONObject7 = optJSONObject3.optJSONObject("interactInfo");
                                        if (optJSONObject7 != null) {
                                            JSONArray optJSONArray5 = optJSONObject7.optJSONArray("thirdpartInfo");
                                            if (b(optJSONArray5)) {
                                                ArrayList arrayList9 = new ArrayList();
                                                for (int i11 = 0; i11 < optJSONArray5.length(); i11++) {
                                                    JSONObject optJSONObject8 = optJSONArray5.optJSONObject(i11);
                                                    if (optJSONObject8 != null) {
                                                        h hVar = new h();
                                                        hVar.b(optJSONObject8.optString("clickUrl"));
                                                        hVar.a(optJSONObject8.optString("viewUrl"));
                                                        hVar.c(optJSONObject8.optString("convertUrl"));
                                                        hVar.g(optJSONObject8.optString("onFinish"));
                                                        hVar.e(optJSONObject8.optString("onPause"));
                                                        hVar.f(optJSONObject8.optString("onRecover"));
                                                        hVar.d(optJSONObject8.optString("onStart"));
                                                        arrayList9.add(hVar);
                                                    }
                                                }
                                                c0119b.a(arrayList9);
                                            }
                                            c0119b.c(optJSONObject7.optString("apkName"));
                                            c0119b.f(optJSONObject7.optString("appDesc"));
                                            c0119b.h(optJSONObject7.optString("appVersion"));
                                            c0119b.i(optJSONObject7.optString("appDeveloper"));
                                            c0119b.j(optJSONObject7.optString("appPermissionsDesc"));
                                            c0119b.k(optJSONObject7.optString("appPermissionsUrl"));
                                            c0119b.l(optJSONObject7.optString("appPrivacyUrl"));
                                            c0119b.m(optJSONObject7.optString("appIconURL"));
                                            c0119b.n(optJSONObject7.optString("appintro"));
                                            c0119b.g(optJSONObject7.optString("appDownloadURL"));
                                            c0119b.e(optJSONObject7.optString("appStoreID"));
                                            c0119b.a(optJSONObject7.optString("landingPageUrl"));
                                            c0119b.b(optJSONObject7.optString("deeplinkUrl"));
                                            c0119b.a(optJSONObject7.optInt("interactType"));
                                            c0119b.d(optJSONObject7.optString("packageName"));
                                            c0119b.a(optJSONObject7.optBoolean("useBuiltInBrow"));
                                            c0119b.b(optJSONObject7.optInt("openExternal"));
                                            JSONObject optJSONObject9 = optJSONObject7.optJSONObject("followTrackExt");
                                            C0119b.C0120b c0120b = new C0119b.C0120b();
                                            if (optJSONObject9 != null) {
                                                c0120b.a(a(optJSONObject9.optJSONArray("open")));
                                                c0120b.b(a(optJSONObject9.optJSONArray("beginDownload")));
                                                c0120b.c(a(optJSONObject9.optJSONArray("download")));
                                                c0120b.d(a(optJSONObject9.optJSONArray("beginInstall")));
                                                c0120b.e(a(optJSONObject9.optJSONArray(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY)));
                                                c0120b.f(a(optJSONObject9.optJSONArray("active")));
                                                c0120b.g(a(optJSONObject9.optJSONArray("close")));
                                                c0120b.h(a(optJSONObject9.optJSONArray("showSlide")));
                                                c0120b.j(a(optJSONObject9.optJSONArray("pageClose")));
                                                c0120b.i(a(optJSONObject9.optJSONArray("pageLoad")));
                                                c0120b.k(a(optJSONObject9.optJSONArray("pageAction")));
                                                c0120b.l(a(optJSONObject9.optJSONArray("deepLinkSuccess")));
                                                c0120b.m(a(optJSONObject9.optJSONArray("realDeepLinkSuccess")));
                                                c0120b.n(a(optJSONObject9.optJSONArray("deepLinkFail")));
                                                c0120b.o(a(optJSONObject9.optJSONArray("dpAppInstalled")));
                                                c0120b.p(a(optJSONObject9.optJSONArray("dpAppNotInstalled")));
                                                c0119b.a(c0120b);
                                            }
                                            JSONObject optJSONObject10 = optJSONObject7.optJSONObject("videoTrackExt");
                                            C0119b.c cVar2 = new C0119b.c();
                                            if (optJSONObject10 != null) {
                                                cVar2.a(a(optJSONObject10.optJSONArray(CampaignEx.JSON_NATIVE_VIDEO_START)));
                                                cVar2.b(a(optJSONObject10.optJSONArray(CampaignEx.JSON_NATIVE_VIDEO_PAUSE)));
                                                cVar2.c(a(optJSONObject10.optJSONArray("continue")));
                                                cVar2.d(a(optJSONObject10.optJSONArray("exit")));
                                                cVar2.e(a(optJSONObject10.optJSONArray(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE)));
                                                JSONArray optJSONArray6 = optJSONObject10.optJSONArray("showTrack");
                                                ArrayList arrayList10 = new ArrayList();
                                                if (b(optJSONArray6)) {
                                                    for (int i12 = 0; i12 < optJSONArray6.length(); i12++) {
                                                        JSONObject optJSONObject11 = optJSONArray6.optJSONObject(i12);
                                                        if (optJSONObject11 != null) {
                                                            C0119b.c.a aVar2 = new C0119b.c.a();
                                                            aVar2.a(optJSONObject11.optInt("t"));
                                                            aVar2.a(a(optJSONObject11.optJSONArray("url")));
                                                            arrayList10.add(aVar2);
                                                        }
                                                    }
                                                    cVar2.f(arrayList10);
                                                }
                                                c0119b.a(cVar2);
                                            }
                                            try {
                                                if (optJSONObject7.has("ext")) {
                                                    JSONObject jSONObject2 = optJSONObject7.getJSONObject("ext");
                                                    C0119b.a aVar3 = new C0119b.a();
                                                    if (jSONObject2 != null) {
                                                        if (jSONObject2.has("canJumpStore")) {
                                                            aVar3.a(jSONObject2.optInt("canJumpStore"));
                                                        }
                                                        if (jSONObject2.has("isCloseConfirm")) {
                                                            aVar3.b(jSONObject2.optInt("isCloseConfirm"));
                                                        }
                                                        c0119b.a(aVar3);
                                                    }
                                                }
                                            } catch (JSONException e6) {
                                                e6.printStackTrace();
                                            }
                                            dVar.a(c0119b);
                                        }
                                        arrayList6.add(dVar);
                                    } else {
                                        jSONArray2 = optJSONArray;
                                        str2 = str4;
                                        iVar3 = iVar4;
                                        arrayList2 = arrayList5;
                                        i5 = i7;
                                        jSONArray3 = optJSONArray2;
                                    }
                                    i8++;
                                    optJSONArray = jSONArray2;
                                    optJSONArray2 = jSONArray3;
                                    str4 = str2;
                                    iVar4 = iVar3;
                                    i7 = i5;
                                    arrayList5 = arrayList2;
                                }
                                jSONArray = optJSONArray;
                                str3 = str4;
                                iVar2 = iVar4;
                                i4 = i7;
                                jVar.a(arrayList6);
                                arrayList = arrayList5;
                            } else {
                                jSONArray = optJSONArray;
                                str3 = str4;
                                iVar2 = iVar4;
                                i4 = i7;
                                arrayList = arrayList5;
                            }
                            arrayList.add(jVar);
                        } else {
                            jSONArray = optJSONArray;
                            str3 = str4;
                            iVar2 = iVar4;
                            arrayList = arrayList5;
                            i4 = i7;
                        }
                        i7 = i4 + 1;
                        arrayList5 = arrayList;
                        optJSONArray = jSONArray;
                        str4 = str3;
                        iVar4 = iVar2;
                    }
                    str2 = str4;
                    iVar = iVar4;
                    try {
                        iVar.a(arrayList5);
                        return iVar;
                    } catch (JSONException e7) {
                        e = e7;
                        l.c(str2, "JSONException e = " + e.getMessage());
                        return iVar;
                    }
                }
                return iVar4;
            } catch (JSONException e8) {
                e = e8;
                str2 = str4;
            }
        }

        public void a(int i4) {
            this.f13361a = i4;
        }

        public void b(String str) {
            this.f13363c = str;
        }

        private static String b(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        }

        public void a(String str) {
            this.f13362b = str;
        }

        public void a(long j4) {
            this.f13364d = j4;
        }

        public void a(List<j> list) {
            this.f13365e = list;
        }

        public static i a(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            try {
                return c(b(inputStream));
            } catch (IOException e4) {
                e4.printStackTrace();
                return null;
            } catch (JSONException e5) {
                e5.printStackTrace();
                return null;
            }
        }

        private static boolean b(JSONArray jSONArray) {
            return jSONArray != null && jSONArray.length() > 0;
        }

        public static i a(byte[] bArr) throws JSONException {
            if (bArr == null) {
                return null;
            }
            try {
                return c(new String(bArr, "UTF-8"));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                return null;
            }
        }

        private static ArrayList<String> a(JSONArray jSONArray) throws JSONException {
            ArrayList<String> arrayList = new ArrayList<>();
            if (b(jSONArray)) {
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    arrayList.add(jSONArray.getString(i4));
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdResponseOuterClass.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        private String f13366a;

        /* renamed from: b  reason: collision with root package name */
        private String f13367b;

        /* renamed from: c  reason: collision with root package name */
        private e.a f13368c;

        /* renamed from: d  reason: collision with root package name */
        private int f13369d;

        /* renamed from: e  reason: collision with root package name */
        private e.h f13370e;

        /* renamed from: f  reason: collision with root package name */
        private String f13371f;

        /* renamed from: g  reason: collision with root package name */
        private String f13372g;

        /* renamed from: h  reason: collision with root package name */
        private g f13373h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f13374i;

        /* renamed from: j  reason: collision with root package name */
        private int f13375j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f13376k;

        /* renamed from: l  reason: collision with root package name */
        private int f13377l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f13378m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f13379n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f13380o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f13381p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f13382q;

        /* renamed from: r  reason: collision with root package name */
        private int f13383r;

        /* renamed from: s  reason: collision with root package name */
        private int f13384s;

        /* renamed from: t  reason: collision with root package name */
        private String f13385t;

        /* renamed from: u  reason: collision with root package name */
        private List<d> f13386u;

        public String a() {
            return this.f13366a;
        }

        public String b() {
            return this.f13367b;
        }

        public e.a c() {
            return this.f13368c;
        }

        public int d() {
            return this.f13369d;
        }

        public e.h e() {
            return this.f13370e;
        }

        public String f() {
            return this.f13371f;
        }

        public String g() {
            return this.f13372g;
        }

        public g h() {
            return this.f13373h;
        }

        public boolean i() {
            return this.f13374i;
        }

        public int j() {
            return this.f13375j;
        }

        public boolean k() {
            return this.f13376k;
        }

        public int l() {
            return this.f13377l;
        }

        public boolean m() {
            return this.f13378m;
        }

        public boolean n() {
            return this.f13379n;
        }

        public boolean o() {
            return this.f13380o;
        }

        public boolean p() {
            return this.f13381p;
        }

        public boolean q() {
            return this.f13382q;
        }

        public List<d> r() {
            return this.f13386u;
        }

        public int s() {
            List<d> list = this.f13386u;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void a(String str) {
            this.f13366a = str;
        }

        public void b(String str) {
            this.f13367b = str;
        }

        public void c(String str) {
            this.f13371f = str;
        }

        public void d(String str) {
            this.f13372g = str;
        }

        public void e(boolean z3) {
            this.f13380o = z3;
        }

        public void f(boolean z3) {
            this.f13381p = z3;
        }

        public void a(e.a aVar) {
            this.f13368c = aVar;
        }

        public void b(int i4) {
            this.f13375j = i4;
        }

        public void c(int i4) {
            this.f13377l = i4;
        }

        public void d(boolean z3) {
            this.f13379n = z3;
        }

        public void e(int i4) {
            this.f13384s = i4;
        }

        public void a(int i4) {
            this.f13369d = i4;
        }

        public void b(boolean z3) {
            this.f13376k = z3;
        }

        public void c(boolean z3) {
            this.f13378m = z3;
        }

        public void d(int i4) {
            this.f13383r = i4;
        }

        public void e(String str) {
            this.f13385t = str;
        }

        public void a(e.h hVar) {
            this.f13370e = hVar;
        }

        public void a(g gVar) {
            this.f13373h = gVar;
        }

        public void a(boolean z3) {
            this.f13374i = z3;
        }

        public void a(List<d> list) {
            this.f13386u = list;
        }
    }
}
