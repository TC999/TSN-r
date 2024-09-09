package com.beizi.fusion.d.a;

import com.beizi.fusion.model.JsonNode;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.List;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BidS2SRequestModel.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b {
    @JsonNode(key = "request")

    /* renamed from: a  reason: collision with root package name */
    private i f14531a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequestModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {
        @JsonNode(key = "bundle")

        /* renamed from: a  reason: collision with root package name */
        private String f14532a;
        @JsonNode(key = "ver")

        /* renamed from: b  reason: collision with root package name */
        private String f14533b;
        @JsonNode(key = "ext")

        /* renamed from: c  reason: collision with root package name */
        private C0135b f14534c;

        public void a(String str) {
            this.f14532a = str;
        }

        public void b(String str) {
            this.f14533b = str;
        }

        public void a(C0135b c0135b) {
            this.f14534c = c0135b;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class C0135b {
        @JsonNode(key = "appId")

        /* renamed from: a  reason: collision with root package name */
        private String f14535a;

        public void a(String str) {
            this.f14535a = str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequestModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {
        @JsonNode(key = "app")

        /* renamed from: a  reason: collision with root package name */
        private a f14536a;
        @JsonNode(key = "device")

        /* renamed from: b  reason: collision with root package name */
        private d f14537b;

        public void a(a aVar) {
            this.f14536a = aVar;
        }

        public void a(d dVar) {
            this.f14537b = dVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequestModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class d {
        @JsonNode(key = "type")

        /* renamed from: a  reason: collision with root package name */
        private int f14538a;
        @JsonNode(key = "ua")

        /* renamed from: b  reason: collision with root package name */
        private String f14539b;
        @JsonNode(key = "lmt")

        /* renamed from: c  reason: collision with root package name */
        private int f14540c;
        @JsonNode(key = "make")

        /* renamed from: d  reason: collision with root package name */
        private String f14541d;
        @JsonNode(key = "model")

        /* renamed from: e  reason: collision with root package name */
        private String f14542e;
        @JsonNode(key = "os")

        /* renamed from: f  reason: collision with root package name */
        private int f14543f;
        @JsonNode(key = "osv")

        /* renamed from: g  reason: collision with root package name */
        private String f14544g;
        @JsonNode(key = "h")

        /* renamed from: h  reason: collision with root package name */
        private float f14545h;
        @JsonNode(key = "w")

        /* renamed from: i  reason: collision with root package name */
        private float f14546i;
        @JsonNode(key = "ppi")

        /* renamed from: j  reason: collision with root package name */
        private String f14547j;
        @JsonNode(key = "pxratio")

        /* renamed from: k  reason: collision with root package name */
        private String f14548k;
        @JsonNode(key = "lang")

        /* renamed from: l  reason: collision with root package name */
        private String f14549l;
        @JsonNode(key = "carrier")

        /* renamed from: m  reason: collision with root package name */
        private String f14550m;
        @JsonNode(key = "contype")

        /* renamed from: n  reason: collision with root package name */
        private String f14551n;
        @JsonNode(key = "ext")

        /* renamed from: o  reason: collision with root package name */
        private e f14552o;

        public void a(int i4) {
            this.f14538a = i4;
        }

        public void b(int i4) {
            this.f14540c = i4;
        }

        public void c(String str) {
            this.f14542e = str;
        }

        public void d(String str) {
            this.f14544g = str;
        }

        public void e(String str) {
            this.f14547j = str;
        }

        public void f(String str) {
            this.f14548k = str;
        }

        public void g(String str) {
            this.f14549l = str;
        }

        public void h(String str) {
            this.f14550m = str;
        }

        public void i(String str) {
            this.f14551n = str;
        }

        public void a(String str) {
            this.f14539b = str;
        }

        public void b(String str) {
            this.f14541d = str;
        }

        public void c(int i4) {
            this.f14543f = i4;
        }

        public void a(float f4) {
            this.f14545h = f4;
        }

        public void b(float f4) {
            this.f14546i = f4;
        }

        public void a(e eVar) {
            this.f14552o = eVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequestModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class e {
        @JsonNode(key = AdRequestConstant.AD_REQUEST_DEVICE_EXT_SDKID_KEY)

        /* renamed from: a  reason: collision with root package name */
        private String f14553a;
        @JsonNode(key = AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY)

        /* renamed from: b  reason: collision with root package name */
        private String f14554b;

        public void a(String str) {
            this.f14553a = str;
        }

        public void b(String str) {
            this.f14554b = str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequestModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class f {
        @JsonNode(key = "id")

        /* renamed from: a  reason: collision with root package name */
        private String f14555a;
        @JsonNode(key = "qty")

        /* renamed from: b  reason: collision with root package name */
        private int f14556b;
        @JsonNode(key = "seq")

        /* renamed from: c  reason: collision with root package name */
        private int f14557c;
        @JsonNode(key = "dlvy")

        /* renamed from: d  reason: collision with root package name */
        private int f14558d;
        @JsonNode(key = "spec")

        /* renamed from: e  reason: collision with root package name */
        private g f14559e;
        @JsonNode(key = "priv")

        /* renamed from: f  reason: collision with root package name */
        private int f14560f;

        public void a(String str) {
            this.f14555a = str;
        }

        public void b(int i4) {
            this.f14557c = i4;
        }

        public void c(int i4) {
            this.f14558d = i4;
        }

        public void d(int i4) {
            this.f14560f = i4;
        }

        public void a(int i4) {
            this.f14556b = i4;
        }

        public void a(g gVar) {
            this.f14559e = gVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequestModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class g {
        @JsonNode(key = "placement")

        /* renamed from: a  reason: collision with root package name */
        private h f14561a;

        public void a(h hVar) {
            this.f14561a = hVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequestModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class h {
        @JsonNode(key = "tagid")

        /* renamed from: a  reason: collision with root package name */
        private String f14562a;
        @JsonNode(key = "sdk")

        /* renamed from: b  reason: collision with root package name */
        private String f14563b;
        @JsonNode(key = "sdkver")

        /* renamed from: c  reason: collision with root package name */
        private String f14564c;
        @JsonNode(key = "reward")

        /* renamed from: d  reason: collision with root package name */
        private int f14565d;

        public void a(String str) {
            this.f14562a = str;
        }

        public void b(String str) {
            this.f14563b = str;
        }

        public void c(String str) {
            this.f14564c = str;
        }

        public void a(int i4) {
            this.f14565d = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequestModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class i {
        @JsonNode(key = "id")

        /* renamed from: a  reason: collision with root package name */
        private String f14566a;
        @JsonNode(key = "test")

        /* renamed from: b  reason: collision with root package name */
        private int f14567b;
        @JsonNode(key = "tmax")

        /* renamed from: c  reason: collision with root package name */
        private int f14568c;
        @JsonNode(key = "at")

        /* renamed from: d  reason: collision with root package name */
        private int f14569d;
        @JsonNode(key = BidResponsed.KEY_CUR)

        /* renamed from: e  reason: collision with root package name */
        private List<String> f14570e;
        @JsonNode(key = "seat")

        /* renamed from: f  reason: collision with root package name */
        private List<String> f14571f;
        @JsonNode(key = "wseat")

        /* renamed from: g  reason: collision with root package name */
        private int f14572g;
        @JsonNode(key = "item")

        /* renamed from: h  reason: collision with root package name */
        private List<f> f14573h;
        @JsonNode(key = "context")

        /* renamed from: i  reason: collision with root package name */
        private c f14574i;
        @JsonNode(key = "ext")

        /* renamed from: j  reason: collision with root package name */
        private j f14575j;

        public void a(String str) {
            this.f14566a = str;
        }

        public void b(int i4) {
            this.f14568c = i4;
        }

        public void c(int i4) {
            this.f14569d = i4;
        }

        public void d(int i4) {
            this.f14572g = i4;
        }

        public void a(int i4) {
            this.f14567b = i4;
        }

        public void b(List<String> list) {
            this.f14571f = list;
        }

        public void c(List<f> list) {
            this.f14573h = list;
        }

        public void a(List<String> list) {
            this.f14570e = list;
        }

        public void a(c cVar) {
            this.f14574i = cVar;
        }

        public void a(j jVar) {
            this.f14575j = jVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequestModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class j {
        @JsonNode(key = "seat")

        /* renamed from: a  reason: collision with root package name */
        private List<k> f14576a;

        public void a(List<k> list) {
            this.f14576a = list;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequestModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class k {
        @JsonNode(key = "seatid")

        /* renamed from: a  reason: collision with root package name */
        private String f14577a;
        @JsonNode(key = "seatname")

        /* renamed from: b  reason: collision with root package name */
        private String f14578b;
        @JsonNode(key = "seatappid")

        /* renamed from: c  reason: collision with root package name */
        private String f14579c;
        @JsonNode(key = "seattagid")

        /* renamed from: d  reason: collision with root package name */
        private String f14580d;
        @JsonNode(key = "token")

        /* renamed from: e  reason: collision with root package name */
        private String f14581e;
        @JsonNode(key = "sdkInfo")

        /* renamed from: f  reason: collision with root package name */
        private String f14582f;

        public void a(String str) {
            this.f14577a = str;
        }

        public void b(String str) {
            this.f14578b = str;
        }

        public void c(String str) {
            this.f14579c = str;
        }

        public void d(String str) {
            this.f14580d = str;
        }

        public void e(String str) {
            this.f14581e = str;
        }

        public void f(String str) {
            this.f14582f = str;
        }
    }

    public void a(i iVar) {
        this.f14531a = iVar;
    }
}
