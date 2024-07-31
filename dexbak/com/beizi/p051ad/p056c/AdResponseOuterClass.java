package com.beizi.p051ad.p056c;

import com.beizi.p051ad.lance.p062a.AesUtil;
import com.beizi.p051ad.lance.p062a.KeyGenerator;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.p056c.EnumType;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.p518qq.p519e.comm.constants.Constants;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
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

/* renamed from: com.beizi.ad.c.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AdResponseOuterClass {

    /* compiled from: AdResponseOuterClass.java */
    /* renamed from: com.beizi.ad.c.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2792a {

        /* renamed from: a */
        private EnumType.EnumC2817f f9589a;

        /* renamed from: b */
        private String f9590b;

        /* renamed from: c */
        private List<C2800e> f9591c;

        /* renamed from: a */
        public EnumType.EnumC2817f m50049a() {
            return this.f9589a;
        }

        /* renamed from: b */
        public String m50045b() {
            return this.f9590b;
        }

        /* renamed from: c */
        public List<C2800e> m50044c() {
            return this.f9591c;
        }

        /* renamed from: d */
        public int m50043d() {
            List<C2800e> list = this.f9591c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* renamed from: a */
        public void m50048a(EnumType.EnumC2817f enumC2817f) {
            this.f9589a = enumC2817f;
        }

        /* renamed from: a */
        public void m50047a(String str) {
            this.f9590b = str;
        }

        /* renamed from: a */
        public void m50046a(List<C2800e> list) {
            this.f9591c = list;
        }
    }

    /* compiled from: AdResponseOuterClass.java */
    /* renamed from: com.beizi.ad.c.b$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2793b {

        /* renamed from: a */
        private String f9592a;

        /* renamed from: b */
        private String f9593b;

        /* renamed from: c */
        private int f9594c;

        /* renamed from: d */
        private String f9595d;

        /* renamed from: e */
        private String f9596e;

        /* renamed from: f */
        private String f9597f;

        /* renamed from: g */
        private String f9598g;

        /* renamed from: h */
        private String f9599h;

        /* renamed from: i */
        private String f9600i;

        /* renamed from: j */
        private boolean f9601j;

        /* renamed from: k */
        private int f9602k;

        /* renamed from: l */
        private C2803h f9603l;

        /* renamed from: m */
        private C2795b f9604m;

        /* renamed from: n */
        private C2796c f9605n;

        /* renamed from: o */
        private List<C2803h> f9606o;

        /* renamed from: p */
        private String f9607p;

        /* renamed from: q */
        private String f9608q;

        /* renamed from: r */
        private String f9609r;

        /* renamed from: s */
        private String f9610s;

        /* renamed from: t */
        private String f9611t;

        /* renamed from: u */
        private String f9612u;

        /* renamed from: v */
        private String f9613v;

        /* renamed from: w */
        private C2794a f9614w;

        /* compiled from: AdResponseOuterClass.java */
        /* renamed from: com.beizi.ad.c.b$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static class C2794a {

            /* renamed from: a */
            private int f9615a;

            /* renamed from: a */
            public int m50001a() {
                return this.f9615a;
            }

            /* renamed from: a */
            public void m50000a(int i) {
                this.f9615a = i;
            }
        }

        /* compiled from: AdResponseOuterClass.java */
        /* renamed from: com.beizi.ad.c.b$b$b */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static class C2795b implements Serializable {

            /* renamed from: a */
            private List<String> f9616a;

            /* renamed from: b */
            private List<String> f9617b;

            /* renamed from: c */
            private List<String> f9618c;

            /* renamed from: d */
            private List<String> f9619d;

            /* renamed from: e */
            private List<String> f9620e;

            /* renamed from: f */
            private List<String> f9621f;

            /* renamed from: g */
            private List<String> f9622g;

            /* renamed from: h */
            private List<String> f9623h;

            /* renamed from: i */
            private List<String> f9624i;

            /* renamed from: j */
            private List<String> f9625j;

            /* renamed from: k */
            private List<String> f9626k;

            /* renamed from: l */
            private List<String> f9627l;

            /* renamed from: m */
            private List<String> f9628m;

            /* renamed from: n */
            private List<String> f9629n;

            /* renamed from: o */
            private List<String> f9630o;

            /* renamed from: p */
            private List<String> f9631p;

            /* renamed from: a */
            public List<String> m49999a() {
                return this.f9616a;
            }

            /* renamed from: b */
            public List<String> m49997b() {
                return this.f9617b;
            }

            /* renamed from: c */
            public List<String> m49995c() {
                return this.f9618c;
            }

            /* renamed from: d */
            public List<String> m49993d() {
                return this.f9619d;
            }

            /* renamed from: e */
            public List<String> m49991e() {
                return this.f9620e;
            }

            /* renamed from: f */
            public void m49988f(List<String> list) {
                this.f9621f = list;
            }

            /* renamed from: g */
            public void m49986g(List<String> list) {
                this.f9622g = list;
            }

            /* renamed from: h */
            public void m49984h(List<String> list) {
                this.f9623h = list;
            }

            /* renamed from: i */
            public void m49982i(List<String> list) {
                this.f9624i = list;
            }

            /* renamed from: j */
            public void m49980j(List<String> list) {
                this.f9625j = list;
            }

            /* renamed from: k */
            public void m49979k(List<String> list) {
                this.f9626k = list;
            }

            /* renamed from: l */
            public void m49978l(List<String> list) {
                this.f9627l = list;
            }

            /* renamed from: m */
            public void m49977m(List<String> list) {
                this.f9628m = list;
            }

            /* renamed from: n */
            public void m49976n(List<String> list) {
                this.f9629n = list;
            }

            /* renamed from: o */
            public void m49975o(List<String> list) {
                this.f9630o = list;
            }

            /* renamed from: p */
            public void m49974p(List<String> list) {
                this.f9631p = list;
            }

            /* renamed from: a */
            public void m49998a(List<String> list) {
                this.f9616a = list;
            }

            /* renamed from: b */
            public void m49996b(List<String> list) {
                this.f9617b = list;
            }

            /* renamed from: c */
            public void m49994c(List<String> list) {
                this.f9618c = list;
            }

            /* renamed from: d */
            public void m49992d(List<String> list) {
                this.f9619d = list;
            }

            /* renamed from: e */
            public void m49990e(List<String> list) {
                this.f9620e = list;
            }

            /* renamed from: f */
            public List<String> m49989f() {
                return this.f9627l;
            }

            /* renamed from: g */
            public List<String> m49987g() {
                return this.f9628m;
            }

            /* renamed from: h */
            public List<String> m49985h() {
                return this.f9629n;
            }

            /* renamed from: i */
            public List<String> m49983i() {
                return this.f9630o;
            }

            /* renamed from: j */
            public List<String> m49981j() {
                return this.f9631p;
            }
        }

        /* compiled from: AdResponseOuterClass.java */
        /* renamed from: com.beizi.ad.c.b$b$c */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static class C2796c {

            /* renamed from: a */
            private List<String> f9632a;

            /* renamed from: b */
            private List<String> f9633b;

            /* renamed from: c */
            private List<String> f9634c;

            /* renamed from: d */
            private List<String> f9635d;

            /* renamed from: e */
            private List<String> f9636e;

            /* renamed from: f */
            private List<C2797a> f9637f;

            /* compiled from: AdResponseOuterClass.java */
            /* renamed from: com.beizi.ad.c.b$b$c$a */
            /* loaded from: E:\fuckcool\tsn\7241516.dex */
            public static class C2797a {

                /* renamed from: a */
                private int f9638a;

                /* renamed from: b */
                private List<String> f9639b;

                /* renamed from: a */
                public void m49967a(int i) {
                    this.f9638a = i;
                }

                /* renamed from: a */
                public void m49966a(List<String> list) {
                    this.f9639b = list;
                }
            }

            /* renamed from: a */
            public void m49973a(List<String> list) {
                this.f9632a = list;
            }

            /* renamed from: b */
            public void m49972b(List<String> list) {
                this.f9633b = list;
            }

            /* renamed from: c */
            public void m49971c(List<String> list) {
                this.f9634c = list;
            }

            /* renamed from: d */
            public void m49970d(List<String> list) {
                this.f9635d = list;
            }

            /* renamed from: e */
            public void m49969e(List<String> list) {
                this.f9636e = list;
            }

            /* renamed from: f */
            public void m49968f(List<C2797a> list) {
                this.f9637f = list;
            }
        }

        /* renamed from: a */
        public String m50042a() {
            return this.f9592a;
        }

        /* renamed from: b */
        public String m50034b() {
            return this.f9593b;
        }

        /* renamed from: c */
        public int m50031c() {
            return this.f9594c;
        }

        /* renamed from: d */
        public String m50029d() {
            return this.f9595d;
        }

        /* renamed from: e */
        public String m50027e() {
            return this.f9596e;
        }

        /* renamed from: f */
        public String m50025f() {
            return this.f9598g;
        }

        /* renamed from: g */
        public String m50023g() {
            return this.f9599h;
        }

        /* renamed from: h */
        public String m50021h() {
            return this.f9600i;
        }

        /* renamed from: i */
        public C2803h m50019i() {
            return this.f9603l;
        }

        /* renamed from: j */
        public C2795b m50017j() {
            return this.f9604m;
        }

        /* renamed from: k */
        public C2796c m50015k() {
            return this.f9605n;
        }

        /* renamed from: l */
        public List<C2803h> m50013l() {
            return this.f9606o;
        }

        /* renamed from: m */
        public String m50011m() {
            return this.f9607p;
        }

        /* renamed from: n */
        public String m50009n() {
            return this.f9608q;
        }

        /* renamed from: o */
        public String m50007o() {
            return this.f9609r;
        }

        /* renamed from: p */
        public String m50006p() {
            return this.f9610s;
        }

        /* renamed from: q */
        public String m50005q() {
            return this.f9611t;
        }

        /* renamed from: r */
        public String m50004r() {
            return this.f9612u;
        }

        /* renamed from: s */
        public String m50003s() {
            return this.f9613v;
        }

        /* renamed from: t */
        public C2794a m50002t() {
            return this.f9614w;
        }

        /* renamed from: a */
        public void m50037a(String str) {
            this.f9592a = str;
        }

        /* renamed from: b */
        public void m50032b(String str) {
            this.f9593b = str;
        }

        /* renamed from: c */
        public void m50030c(String str) {
            this.f9595d = str;
        }

        /* renamed from: d */
        public void m50028d(String str) {
            this.f9596e = str;
        }

        /* renamed from: e */
        public void m50026e(String str) {
            this.f9597f = str;
        }

        /* renamed from: f */
        public void m50024f(String str) {
            this.f9598g = str;
        }

        /* renamed from: g */
        public void m50022g(String str) {
            this.f9599h = str;
        }

        /* renamed from: h */
        public void m50020h(String str) {
            this.f9607p = str;
        }

        /* renamed from: i */
        public void m50018i(String str) {
            this.f9608q = str;
        }

        /* renamed from: j */
        public void m50016j(String str) {
            this.f9609r = str;
        }

        /* renamed from: k */
        public void m50014k(String str) {
            this.f9610s = str;
        }

        /* renamed from: l */
        public void m50012l(String str) {
            this.f9611t = str;
        }

        /* renamed from: m */
        public void m50010m(String str) {
            this.f9612u = str;
        }

        /* renamed from: n */
        public void m50008n(String str) {
            this.f9613v = str;
        }

        /* renamed from: a */
        public void m50041a(int i) {
            this.f9594c = i;
        }

        /* renamed from: b */
        public void m50033b(int i) {
            this.f9602k = i;
        }

        /* renamed from: a */
        public void m50035a(boolean z) {
            this.f9601j = z;
        }

        /* renamed from: a */
        public void m50039a(C2795b c2795b) {
            this.f9604m = c2795b;
        }

        /* renamed from: a */
        public void m50038a(C2796c c2796c) {
            this.f9605n = c2796c;
        }

        /* renamed from: a */
        public void m50036a(List<C2803h> list) {
            this.f9606o = list;
        }

        /* renamed from: a */
        public void m50040a(C2794a c2794a) {
            this.f9614w = c2794a;
        }
    }

    /* compiled from: AdResponseOuterClass.java */
    /* renamed from: com.beizi.ad.c.b$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2798c {

        /* renamed from: a */
        private String f9640a;

        /* renamed from: b */
        private String f9641b;

        /* renamed from: c */
        private String f9642c;

        /* renamed from: d */
        private String f9643d;

        /* renamed from: a */
        public String m49965a() {
            return this.f9640a;
        }

        /* renamed from: b */
        public String m49963b() {
            return this.f9641b;
        }

        /* renamed from: c */
        public String m49961c() {
            return this.f9642c;
        }

        /* renamed from: d */
        public String m49959d() {
            return this.f9643d;
        }

        /* renamed from: a */
        public void m49964a(String str) {
            this.f9640a = str;
        }

        /* renamed from: b */
        public void m49962b(String str) {
            this.f9641b = str;
        }

        /* renamed from: c */
        public void m49960c(String str) {
            this.f9642c = str;
        }

        /* renamed from: d */
        public void m49958d(String str) {
            this.f9643d = str;
        }
    }

    /* compiled from: AdResponseOuterClass.java */
    /* renamed from: com.beizi.ad.c.b$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2799d {

        /* renamed from: a */
        private String f9644a;

        /* renamed from: b */
        private C2793b f9645b;

        /* renamed from: c */
        private C2798c f9646c;

        /* renamed from: d */
        private List<C2792a> f9647d;

        /* renamed from: e */
        private List<C2801f> f9648e;

        /* renamed from: f */
        private String f9649f;

        /* renamed from: g */
        private String f9650g;

        /* renamed from: a */
        public String m49957a() {
            return this.f9644a;
        }

        /* renamed from: b */
        public String m49952b() {
            return this.f9650g;
        }

        /* renamed from: c */
        public C2793b m49950c() {
            return this.f9645b;
        }

        /* renamed from: d */
        public int m49948d() {
            List<C2792a> list = this.f9647d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* renamed from: e */
        public C2798c m49947e() {
            return this.f9646c;
        }

        /* renamed from: f */
        public List<C2792a> m49946f() {
            return this.f9647d;
        }

        /* renamed from: g */
        public List<C2801f> m49945g() {
            return this.f9648e;
        }

        /* renamed from: h */
        public int m49944h() {
            List<C2801f> list = this.f9648e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* renamed from: i */
        public String m49943i() {
            return this.f9649f;
        }

        /* renamed from: a */
        public void m49954a(String str) {
            this.f9644a = str;
        }

        /* renamed from: b */
        public void m49951b(String str) {
            this.f9650g = str;
        }

        /* renamed from: c */
        public void m49949c(String str) {
            this.f9649f = str;
        }

        /* renamed from: a */
        public void m49956a(C2793b c2793b) {
            this.f9645b = c2793b;
        }

        /* renamed from: a */
        public void m49955a(C2798c c2798c) {
            this.f9646c = c2798c;
        }

        /* renamed from: a */
        public void m49953a(List<C2792a> list) {
            this.f9647d = list;
        }
    }

    /* compiled from: AdResponseOuterClass.java */
    /* renamed from: com.beizi.ad.c.b$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2800e {

        /* renamed from: a */
        private String f9651a;

        /* renamed from: b */
        private String f9652b;

        /* renamed from: a */
        public String m49942a() {
            return this.f9651a;
        }

        /* renamed from: b */
        public String m49940b() {
            return this.f9652b;
        }

        /* renamed from: a */
        public void m49941a(String str) {
            this.f9651a = str;
        }

        /* renamed from: b */
        public void m49939b(String str) {
            this.f9652b = str;
        }
    }

    /* compiled from: AdResponseOuterClass.java */
    /* renamed from: com.beizi.ad.c.b$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2801f {

        /* renamed from: a */
        private String f9653a;

        /* renamed from: b */
        private String f9654b;

        /* renamed from: c */
        private String f9655c;

        /* renamed from: a */
        public String m49938a() {
            return this.f9653a;
        }

        /* renamed from: b */
        public String m49937b() {
            return this.f9654b;
        }

        /* renamed from: c */
        public String m49936c() {
            return this.f9655c;
        }
    }

    /* compiled from: AdResponseOuterClass.java */
    /* renamed from: com.beizi.ad.c.b$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2802g {

        /* renamed from: a */
        private String f9656a;

        /* renamed from: b */
        private String f9657b;

        /* renamed from: a */
        public String m49935a() {
            return this.f9656a;
        }

        /* renamed from: b */
        public String m49933b() {
            return this.f9657b;
        }

        /* renamed from: a */
        public void m49934a(String str) {
            this.f9656a = str;
        }

        /* renamed from: b */
        public void m49932b(String str) {
            this.f9657b = str;
        }
    }

    /* compiled from: AdResponseOuterClass.java */
    /* renamed from: com.beizi.ad.c.b$h */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2803h {

        /* renamed from: a */
        private String f9658a;

        /* renamed from: b */
        private String f9659b;

        /* renamed from: c */
        private String f9660c;

        /* renamed from: d */
        private String f9661d;

        /* renamed from: e */
        private String f9662e;

        /* renamed from: f */
        private String f9663f;

        /* renamed from: g */
        private String f9664g;

        /* renamed from: a */
        public String m49931a() {
            return this.f9658a;
        }

        /* renamed from: b */
        public String m49929b() {
            return this.f9659b;
        }

        /* renamed from: c */
        public String m49927c() {
            return this.f9660c;
        }

        /* renamed from: d */
        public String m49925d() {
            return this.f9661d;
        }

        /* renamed from: e */
        public String m49923e() {
            return this.f9662e;
        }

        /* renamed from: f */
        public void m49920f(String str) {
            this.f9663f = str;
        }

        /* renamed from: g */
        public void m49919g(String str) {
            this.f9664g = str;
        }

        /* renamed from: a */
        public void m49930a(String str) {
            this.f9658a = str;
        }

        /* renamed from: b */
        public void m49928b(String str) {
            this.f9659b = str;
        }

        /* renamed from: c */
        public void m49926c(String str) {
            this.f9660c = str;
        }

        /* renamed from: d */
        public void m49924d(String str) {
            this.f9661d = str;
        }

        /* renamed from: e */
        public void m49922e(String str) {
            this.f9662e = str;
        }

        /* renamed from: f */
        public String m49921f() {
            return this.f9664g;
        }
    }

    /* compiled from: AdResponseOuterClass.java */
    /* renamed from: com.beizi.ad.c.b$i */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2804i {

        /* renamed from: a */
        private int f9665a;

        /* renamed from: b */
        private String f9666b;

        /* renamed from: c */
        private String f9667c;

        /* renamed from: d */
        private long f9668d;

        /* renamed from: e */
        private List<C2805j> f9669e;

        /* renamed from: a */
        public int m49918a() {
            List<C2805j> list = this.f9669e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* renamed from: b */
        public int m49910b() {
            return this.f9665a;
        }

        /* renamed from: c */
        public String m49906c() {
            return this.f9666b;
        }

        /* renamed from: d */
        public String m49904d() {
            return this.f9667c;
        }

        /* renamed from: e */
        public List<C2805j> m49903e() {
            return this.f9669e;
        }

        /* renamed from: c */
        private static C2804i m49905c(String str) throws JSONException {
            String str2;
            C2804i c2804i;
            JSONArray jSONArray;
            String str3;
            C2804i c2804i2;
            int i;
            JSONArray jSONArray2;
            C2804i c2804i3;
            int i2;
            JSONArray jSONArray3;
            int i3;
            JSONArray jSONArray4;
            int i4;
            String m49090b = AesUtil.m49090b(KeyGenerator.m49047a(), str);
            String str4 = "ServerResponse";
            LogUtil.m49043d("ServerResponse", "decryptStr = " + m49090b);
            JSONObject jSONObject = new JSONObject(m49090b);
            C2804i c2804i4 = new C2804i();
            try {
                c2804i4.m49914a(jSONObject.optString("errcode"));
                c2804i4.m49908b(jSONObject.optString("errmsg"));
                c2804i4.m49917a(jSONObject.optInt("status"));
                c2804i4.m49916a(jSONObject.optLong("ts"));
                JSONArray optJSONArray = jSONObject.optJSONArray("spaceInfo");
                ArrayList arrayList = new ArrayList();
                if (m49907b(optJSONArray)) {
                    int i5 = 0;
                    while (i5 < optJSONArray.length()) {
                        C2805j c2805j = new C2805j();
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                        if (optJSONObject != null) {
                            c2805j.m49897a(optJSONObject.optString("spaceID"));
                            c2805j.m49892b(optJSONObject.optString("spaceParam"));
                            c2805j.m49899a(EnumType.EnumC2812a.m49788a(optJSONObject.optInt("adpType")));
                            c2805j.m49901a(optJSONObject.optInt("refreshInterval"));
                            c2805j.m49898a(EnumType.EnumC2819h.m49784a(optJSONObject.optInt("screenDirection")));
                            c2805j.m49888c(optJSONObject.optString("width"));
                            c2805j.m49884d(optJSONObject.optString("height"));
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("adpPosition");
                            C2802g c2802g = new C2802g();
                            c2802g.m49934a(optJSONObject2.optString("x"));
                            c2802g.m49932b(optJSONObject2.optString("y"));
                            c2805j.m49900a(c2802g);
                            c2805j.m49895a(optJSONObject.optBoolean("autoClose"));
                            c2805j.m49893b(optJSONObject.optInt("maxTime"));
                            c2805j.m49891b(optJSONObject.optBoolean("manualClosable"));
                            c2805j.m49889c(optJSONObject.optInt("minTime"));
                            c2805j.m49887c(optJSONObject.optBoolean("wifiPreload"));
                            c2805j.m49883d(optJSONObject.optBoolean(CampaignEx.JSON_NATIVE_VIDEO_MUTE));
                            c2805j.m49879e(optJSONObject.optBoolean("fullScreen"));
                            c2805j.m49877f(optJSONObject.optBoolean("autoPlay"));
                            c2805j.m49885d(optJSONObject.optInt("orgID"));
                            c2805j.m49881e(optJSONObject.optInt("contentType"));
                            c2805j.m49880e(optJSONObject.optString("appID"));
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("adResponse");
                            ArrayList arrayList2 = new ArrayList();
                            if (m49907b(optJSONArray2)) {
                                int i6 = 0;
                                while (i6 < optJSONArray2.length()) {
                                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i6);
                                    if (optJSONObject3 != null) {
                                        C2799d c2799d = new C2799d();
                                        c2799d.m49954a(optJSONObject3.optString("extInfo"));
                                        c2799d.m49951b(optJSONObject3.optString("adid"));
                                        JSONArray optJSONArray3 = optJSONObject3.optJSONArray("contentInfo");
                                        ArrayList arrayList3 = new ArrayList();
                                        if (m49907b(optJSONArray3)) {
                                            jSONArray2 = optJSONArray;
                                            int i7 = 0;
                                            while (i7 < optJSONArray3.length()) {
                                                JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i7);
                                                JSONArray jSONArray5 = optJSONArray2;
                                                C2792a c2792a = new C2792a();
                                                JSONArray jSONArray6 = optJSONArray3;
                                                c2792a.m50047a(optJSONObject4.optString("template"));
                                                c2792a.m50048a(EnumType.EnumC2817f.m49785a(optJSONObject4.optInt("renderType")));
                                                JSONArray optJSONArray4 = optJSONObject4.optJSONArray("adcontentSlot");
                                                if (m49907b(optJSONArray4)) {
                                                    ArrayList arrayList4 = new ArrayList();
                                                    str2 = str4;
                                                    c2804i3 = c2804i4;
                                                    int i8 = 0;
                                                    while (i8 < optJSONArray4.length()) {
                                                        try {
                                                            JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i8);
                                                            if (optJSONObject5 != null) {
                                                                jSONArray4 = optJSONArray4;
                                                                C2800e c2800e = new C2800e();
                                                                i4 = i5;
                                                                c2800e.m49941a(optJSONObject5.optString("md5"));
                                                                c2800e.m49939b(optJSONObject5.optString("content"));
                                                                arrayList4.add(c2800e);
                                                            } else {
                                                                jSONArray4 = optJSONArray4;
                                                                i4 = i5;
                                                            }
                                                            i8++;
                                                            optJSONArray4 = jSONArray4;
                                                            i5 = i4;
                                                        } catch (JSONException e) {
                                                            e = e;
                                                            c2804i = c2804i3;
                                                            LogUtil.m49044c(str2, "JSONException e = " + e.getMessage());
                                                            return c2804i;
                                                        }
                                                    }
                                                    i3 = i5;
                                                    c2792a.m50046a(arrayList4);
                                                } else {
                                                    str2 = str4;
                                                    c2804i3 = c2804i4;
                                                    i3 = i5;
                                                }
                                                arrayList3.add(c2792a);
                                                i7++;
                                                optJSONArray2 = jSONArray5;
                                                optJSONArray3 = jSONArray6;
                                                str4 = str2;
                                                c2804i4 = c2804i3;
                                                i5 = i3;
                                            }
                                            str2 = str4;
                                            c2804i3 = c2804i4;
                                            i2 = i5;
                                            jSONArray3 = optJSONArray2;
                                            c2799d.m49953a(arrayList3);
                                        } else {
                                            jSONArray2 = optJSONArray;
                                            str2 = str4;
                                            c2804i3 = c2804i4;
                                            i2 = i5;
                                            jSONArray3 = optJSONArray2;
                                        }
                                        JSONObject optJSONObject6 = optJSONObject3.optJSONObject("adLogo");
                                        if (optJSONObject6 != null) {
                                            C2798c c2798c = new C2798c();
                                            c2798c.m49962b(optJSONObject6.optString("adLabel"));
                                            c2798c.m49964a(optJSONObject6.optString("adLabelUrl"));
                                            c2798c.m49958d(optJSONObject6.optString("sourceLabel"));
                                            c2798c.m49960c(optJSONObject6.optString("sourceUrl"));
                                            c2799d.m49955a(c2798c);
                                        }
                                        c2799d.m49949c(optJSONObject3.optString(BidResponsed.KEY_PRICE));
                                        C2793b c2793b = new C2793b();
                                        JSONObject optJSONObject7 = optJSONObject3.optJSONObject("interactInfo");
                                        if (optJSONObject7 != null) {
                                            JSONArray optJSONArray5 = optJSONObject7.optJSONArray("thirdpartInfo");
                                            if (m49907b(optJSONArray5)) {
                                                ArrayList arrayList5 = new ArrayList();
                                                for (int i9 = 0; i9 < optJSONArray5.length(); i9++) {
                                                    JSONObject optJSONObject8 = optJSONArray5.optJSONObject(i9);
                                                    if (optJSONObject8 != null) {
                                                        C2803h c2803h = new C2803h();
                                                        c2803h.m49928b(optJSONObject8.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY));
                                                        c2803h.m49930a(optJSONObject8.optString("viewUrl"));
                                                        c2803h.m49926c(optJSONObject8.optString("convertUrl"));
                                                        c2803h.m49919g(optJSONObject8.optString("onFinish"));
                                                        c2803h.m49922e(optJSONObject8.optString("onPause"));
                                                        c2803h.m49920f(optJSONObject8.optString("onRecover"));
                                                        c2803h.m49924d(optJSONObject8.optString("onStart"));
                                                        arrayList5.add(c2803h);
                                                    }
                                                }
                                                c2793b.m50036a(arrayList5);
                                            }
                                            c2793b.m50030c(optJSONObject7.optString("apkName"));
                                            c2793b.m50024f(optJSONObject7.optString("appDesc"));
                                            c2793b.m50020h(optJSONObject7.optString("appVersion"));
                                            c2793b.m50018i(optJSONObject7.optString("appDeveloper"));
                                            c2793b.m50016j(optJSONObject7.optString("appPermissionsDesc"));
                                            c2793b.m50014k(optJSONObject7.optString("appPermissionsUrl"));
                                            c2793b.m50012l(optJSONObject7.optString("appPrivacyUrl"));
                                            c2793b.m50010m(optJSONObject7.optString("appIconURL"));
                                            c2793b.m50008n(optJSONObject7.optString("appintro"));
                                            c2793b.m50022g(optJSONObject7.optString("appDownloadURL"));
                                            c2793b.m50026e(optJSONObject7.optString("appStoreID"));
                                            c2793b.m50037a(optJSONObject7.optString("landingPageUrl"));
                                            c2793b.m50032b(optJSONObject7.optString("deeplinkUrl"));
                                            c2793b.m50041a(optJSONObject7.optInt("interactType"));
                                            c2793b.m50028d(optJSONObject7.optString(TTDownloadField.TT_PACKAGE_NAME));
                                            c2793b.m50035a(optJSONObject7.optBoolean("useBuiltInBrow"));
                                            c2793b.m50033b(optJSONObject7.optInt("openExternal"));
                                            JSONObject optJSONObject9 = optJSONObject7.optJSONObject("followTrackExt");
                                            C2793b.C2795b c2795b = new C2793b.C2795b();
                                            if (optJSONObject9 != null) {
                                                c2795b.m49998a(m49912a(optJSONObject9.optJSONArray("open")));
                                                c2795b.m49996b(m49912a(optJSONObject9.optJSONArray("beginDownload")));
                                                c2795b.m49994c(m49912a(optJSONObject9.optJSONArray("download")));
                                                c2795b.m49992d(m49912a(optJSONObject9.optJSONArray("beginInstall")));
                                                c2795b.m49990e(m49912a(optJSONObject9.optJSONArray("install")));
                                                c2795b.m49988f(m49912a(optJSONObject9.optJSONArray("active")));
                                                c2795b.m49986g(m49912a(optJSONObject9.optJSONArray("close")));
                                                c2795b.m49984h(m49912a(optJSONObject9.optJSONArray("showSlide")));
                                                c2795b.m49980j(m49912a(optJSONObject9.optJSONArray("pageClose")));
                                                c2795b.m49982i(m49912a(optJSONObject9.optJSONArray("pageLoad")));
                                                c2795b.m49979k(m49912a(optJSONObject9.optJSONArray("pageAction")));
                                                c2795b.m49978l(m49912a(optJSONObject9.optJSONArray("deepLinkSuccess")));
                                                c2795b.m49977m(m49912a(optJSONObject9.optJSONArray("realDeepLinkSuccess")));
                                                c2795b.m49976n(m49912a(optJSONObject9.optJSONArray("deepLinkFail")));
                                                c2795b.m49975o(m49912a(optJSONObject9.optJSONArray("dpAppInstalled")));
                                                c2795b.m49974p(m49912a(optJSONObject9.optJSONArray("dpAppNotInstalled")));
                                                c2793b.m50039a(c2795b);
                                            }
                                            JSONObject optJSONObject10 = optJSONObject7.optJSONObject("videoTrackExt");
                                            C2793b.C2796c c2796c = new C2793b.C2796c();
                                            if (optJSONObject10 != null) {
                                                c2796c.m49973a(m49912a(optJSONObject10.optJSONArray(CampaignEx.JSON_NATIVE_VIDEO_START)));
                                                c2796c.m49972b(m49912a(optJSONObject10.optJSONArray(CampaignEx.JSON_NATIVE_VIDEO_PAUSE)));
                                                c2796c.m49971c(m49912a(optJSONObject10.optJSONArray("continue")));
                                                c2796c.m49970d(m49912a(optJSONObject10.optJSONArray("exit")));
                                                c2796c.m49969e(m49912a(optJSONObject10.optJSONArray(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE)));
                                                JSONArray optJSONArray6 = optJSONObject10.optJSONArray("showTrack");
                                                ArrayList arrayList6 = new ArrayList();
                                                if (m49907b(optJSONArray6)) {
                                                    for (int i10 = 0; i10 < optJSONArray6.length(); i10++) {
                                                        JSONObject optJSONObject11 = optJSONArray6.optJSONObject(i10);
                                                        if (optJSONObject11 != null) {
                                                            C2793b.C2796c.C2797a c2797a = new C2793b.C2796c.C2797a();
                                                            c2797a.m49967a(optJSONObject11.optInt(UMCommonContent.f37782aL));
                                                            c2797a.m49966a(m49912a(optJSONObject11.optJSONArray("url")));
                                                            arrayList6.add(c2797a);
                                                        }
                                                    }
                                                    c2796c.m49968f(arrayList6);
                                                }
                                                c2793b.m50038a(c2796c);
                                            }
                                            try {
                                                if (optJSONObject7.has(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)) {
                                                    JSONObject jSONObject2 = optJSONObject7.getJSONObject(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
                                                    C2793b.C2794a c2794a = new C2793b.C2794a();
                                                    if (jSONObject2 != null) {
                                                        if (jSONObject2.has("isCanJump")) {
                                                            c2794a.m50000a(jSONObject2.optInt("isCanJump"));
                                                        }
                                                        c2793b.m50040a(c2794a);
                                                    }
                                                }
                                            } catch (JSONException e2) {
                                                e2.printStackTrace();
                                            }
                                            c2799d.m49956a(c2793b);
                                        }
                                        arrayList2.add(c2799d);
                                    } else {
                                        jSONArray2 = optJSONArray;
                                        str2 = str4;
                                        c2804i3 = c2804i4;
                                        i2 = i5;
                                        jSONArray3 = optJSONArray2;
                                    }
                                    i6++;
                                    optJSONArray = jSONArray2;
                                    optJSONArray2 = jSONArray3;
                                    str4 = str2;
                                    c2804i4 = c2804i3;
                                    i5 = i2;
                                }
                                jSONArray = optJSONArray;
                                str3 = str4;
                                c2804i2 = c2804i4;
                                i = i5;
                                c2805j.m49896a(arrayList2);
                            } else {
                                jSONArray = optJSONArray;
                                str3 = str4;
                                c2804i2 = c2804i4;
                                i = i5;
                            }
                            arrayList.add(c2805j);
                        } else {
                            jSONArray = optJSONArray;
                            str3 = str4;
                            c2804i2 = c2804i4;
                            i = i5;
                        }
                        i5 = i + 1;
                        optJSONArray = jSONArray;
                        str4 = str3;
                        c2804i4 = c2804i2;
                    }
                    str2 = str4;
                    c2804i = c2804i4;
                    try {
                        c2804i.m49913a(arrayList);
                        return c2804i;
                    } catch (JSONException e3) {
                        e = e3;
                        LogUtil.m49044c(str2, "JSONException e = " + e.getMessage());
                        return c2804i;
                    }
                }
                return c2804i4;
            } catch (JSONException e4) {
                e = e4;
                str2 = str4;
                c2804i = c2804i4;
            }
        }

        /* renamed from: a */
        public void m49917a(int i) {
            this.f9665a = i;
        }

        /* renamed from: b */
        public void m49908b(String str) {
            this.f9667c = str;
        }

        /* renamed from: b */
        private static String m49909b(InputStream inputStream) throws IOException {
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

        /* renamed from: a */
        public void m49914a(String str) {
            this.f9666b = str;
        }

        /* renamed from: a */
        public void m49916a(long j) {
            this.f9668d = j;
        }

        /* renamed from: a */
        public void m49913a(List<C2805j> list) {
            this.f9669e = list;
        }

        /* renamed from: a */
        public static C2804i m49915a(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            try {
                return m49905c(m49909b(inputStream));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        /* renamed from: b */
        private static boolean m49907b(JSONArray jSONArray) {
            return jSONArray != null && jSONArray.length() > 0;
        }

        /* renamed from: a */
        public static C2804i m49911a(byte[] bArr) throws JSONException {
            if (bArr == null) {
                return null;
            }
            try {
                return m49905c(new String(bArr, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* renamed from: a */
        private static ArrayList<String> m49912a(JSONArray jSONArray) throws JSONException {
            ArrayList<String> arrayList = new ArrayList<>();
            if (m49907b(jSONArray)) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            return arrayList;
        }
    }

    /* compiled from: AdResponseOuterClass.java */
    /* renamed from: com.beizi.ad.c.b$j */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2805j {

        /* renamed from: a */
        private String f9670a;

        /* renamed from: b */
        private String f9671b;

        /* renamed from: c */
        private EnumType.EnumC2812a f9672c;

        /* renamed from: d */
        private int f9673d;

        /* renamed from: e */
        private EnumType.EnumC2819h f9674e;

        /* renamed from: f */
        private String f9675f;

        /* renamed from: g */
        private String f9676g;

        /* renamed from: h */
        private C2802g f9677h;

        /* renamed from: i */
        private boolean f9678i;

        /* renamed from: j */
        private int f9679j;

        /* renamed from: k */
        private boolean f9680k;

        /* renamed from: l */
        private int f9681l;

        /* renamed from: m */
        private boolean f9682m;

        /* renamed from: n */
        private boolean f9683n;

        /* renamed from: o */
        private boolean f9684o;

        /* renamed from: p */
        private boolean f9685p;

        /* renamed from: q */
        private boolean f9686q;

        /* renamed from: r */
        private int f9687r;

        /* renamed from: s */
        private int f9688s;

        /* renamed from: t */
        private String f9689t;

        /* renamed from: u */
        private List<C2799d> f9690u;

        /* renamed from: a */
        public String m49902a() {
            return this.f9670a;
        }

        /* renamed from: b */
        public String m49894b() {
            return this.f9671b;
        }

        /* renamed from: c */
        public EnumType.EnumC2812a m49890c() {
            return this.f9672c;
        }

        /* renamed from: d */
        public int m49886d() {
            return this.f9673d;
        }

        /* renamed from: e */
        public EnumType.EnumC2819h m49882e() {
            return this.f9674e;
        }

        /* renamed from: f */
        public String m49878f() {
            return this.f9675f;
        }

        /* renamed from: g */
        public String m49876g() {
            return this.f9676g;
        }

        /* renamed from: h */
        public C2802g m49875h() {
            return this.f9677h;
        }

        /* renamed from: i */
        public boolean m49874i() {
            return this.f9678i;
        }

        /* renamed from: j */
        public int m49873j() {
            return this.f9679j;
        }

        /* renamed from: k */
        public boolean m49872k() {
            return this.f9680k;
        }

        /* renamed from: l */
        public int m49871l() {
            return this.f9681l;
        }

        /* renamed from: m */
        public boolean m49870m() {
            return this.f9682m;
        }

        /* renamed from: n */
        public boolean m49869n() {
            return this.f9683n;
        }

        /* renamed from: o */
        public boolean m49868o() {
            return this.f9684o;
        }

        /* renamed from: p */
        public boolean m49867p() {
            return this.f9685p;
        }

        /* renamed from: q */
        public boolean m49866q() {
            return this.f9686q;
        }

        /* renamed from: r */
        public List<C2799d> m49865r() {
            return this.f9690u;
        }

        /* renamed from: s */
        public int m49864s() {
            List<C2799d> list = this.f9690u;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* renamed from: a */
        public void m49897a(String str) {
            this.f9670a = str;
        }

        /* renamed from: b */
        public void m49892b(String str) {
            this.f9671b = str;
        }

        /* renamed from: c */
        public void m49888c(String str) {
            this.f9675f = str;
        }

        /* renamed from: d */
        public void m49884d(String str) {
            this.f9676g = str;
        }

        /* renamed from: e */
        public void m49879e(boolean z) {
            this.f9684o = z;
        }

        /* renamed from: f */
        public void m49877f(boolean z) {
            this.f9685p = z;
        }

        /* renamed from: a */
        public void m49899a(EnumType.EnumC2812a enumC2812a) {
            this.f9672c = enumC2812a;
        }

        /* renamed from: b */
        public void m49893b(int i) {
            this.f9679j = i;
        }

        /* renamed from: c */
        public void m49889c(int i) {
            this.f9681l = i;
        }

        /* renamed from: d */
        public void m49883d(boolean z) {
            this.f9683n = z;
        }

        /* renamed from: e */
        public void m49881e(int i) {
            this.f9688s = i;
        }

        /* renamed from: a */
        public void m49901a(int i) {
            this.f9673d = i;
        }

        /* renamed from: b */
        public void m49891b(boolean z) {
            this.f9680k = z;
        }

        /* renamed from: c */
        public void m49887c(boolean z) {
            this.f9682m = z;
        }

        /* renamed from: d */
        public void m49885d(int i) {
            this.f9687r = i;
        }

        /* renamed from: e */
        public void m49880e(String str) {
            this.f9689t = str;
        }

        /* renamed from: a */
        public void m49898a(EnumType.EnumC2819h enumC2819h) {
            this.f9674e = enumC2819h;
        }

        /* renamed from: a */
        public void m49900a(C2802g c2802g) {
            this.f9677h = c2802g;
        }

        /* renamed from: a */
        public void m49895a(boolean z) {
            this.f9678i = z;
        }

        /* renamed from: a */
        public void m49896a(List<C2799d> list) {
            this.f9690u = list;
        }
    }
}
