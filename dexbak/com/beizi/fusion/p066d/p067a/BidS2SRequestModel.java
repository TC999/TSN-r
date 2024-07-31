package com.beizi.fusion.p066d.p067a;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.beizi.fusion.model.JsonNode;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.List;

/* renamed from: com.beizi.fusion.d.a.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BidS2SRequestModel {
    @JsonNode(key = "request")

    /* renamed from: a */
    private C3066i f10992a;

    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3058a {
        @JsonNode(key = TTLiveConstants.BUNDLE_KEY)

        /* renamed from: a */
        private String f10993a;
        @JsonNode(key = "ver")

        /* renamed from: b */
        private String f10994b;
        @JsonNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)

        /* renamed from: c */
        private C3059b f10995c;

        /* renamed from: a */
        public void m48845a(String str) {
            this.f10993a = str;
        }

        /* renamed from: b */
        public void m48844b(String str) {
            this.f10994b = str;
        }

        /* renamed from: a */
        public void m48846a(C3059b c3059b) {
            this.f10995c = c3059b;
        }
    }

    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3059b {
        @JsonNode(key = "appId")

        /* renamed from: a */
        private String f10996a;

        /* renamed from: a */
        public void m48843a(String str) {
            this.f10996a = str;
        }
    }

    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3060c {
        @JsonNode(key = Constants.JumpUrlConstants.SRC_TYPE_APP)

        /* renamed from: a */
        private C3058a f10997a;
        @JsonNode(key = ConstantHelper.LOG_DE)

        /* renamed from: b */
        private C3061d f10998b;

        /* renamed from: a */
        public void m48842a(C3058a c3058a) {
            this.f10997a = c3058a;
        }

        /* renamed from: a */
        public void m48841a(C3061d c3061d) {
            this.f10998b = c3061d;
        }
    }

    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3061d {
        @JsonNode(key = "type")

        /* renamed from: a */
        private int f10999a;
        @JsonNode(key = PathCenter.f37685d)

        /* renamed from: b */
        private String f11000b;
        @JsonNode(key = "lmt")

        /* renamed from: c */
        private int f11001c;
        @JsonNode(key = "make")

        /* renamed from: d */
        private String f11002d;
        @JsonNode(key = C2624bk.f8685i)

        /* renamed from: e */
        private String f11003e;
        @JsonNode(key = "os")

        /* renamed from: f */
        private int f11004f;
        @JsonNode(key = "osv")

        /* renamed from: g */
        private String f11005g;
        @JsonNode(key = "h")

        /* renamed from: h */
        private float f11006h;
        @JsonNode(key = IAdInterListener.AdReqParam.WIDTH)

        /* renamed from: i */
        private float f11007i;
        @JsonNode(key = "ppi")

        /* renamed from: j */
        private String f11008j;
        @JsonNode(key = "pxratio")

        /* renamed from: k */
        private String f11009k;
        @JsonNode(key = "lang")

        /* renamed from: l */
        private String f11010l;
        @JsonNode(key = UMCommonContent.f37759P)

        /* renamed from: m */
        private String f11011m;
        @JsonNode(key = "contype")

        /* renamed from: n */
        private String f11012n;
        @JsonNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)

        /* renamed from: o */
        private C3062e f11013o;

        /* renamed from: a */
        public void m48839a(int i) {
            this.f10999a = i;
        }

        /* renamed from: b */
        public void m48835b(int i) {
            this.f11001c = i;
        }

        /* renamed from: c */
        public void m48832c(String str) {
            this.f11003e = str;
        }

        /* renamed from: d */
        public void m48831d(String str) {
            this.f11005g = str;
        }

        /* renamed from: e */
        public void m48830e(String str) {
            this.f11008j = str;
        }

        /* renamed from: f */
        public void m48829f(String str) {
            this.f11009k = str;
        }

        /* renamed from: g */
        public void m48828g(String str) {
            this.f11010l = str;
        }

        /* renamed from: h */
        public void m48827h(String str) {
            this.f11011m = str;
        }

        /* renamed from: i */
        public void m48826i(String str) {
            this.f11012n = str;
        }

        /* renamed from: a */
        public void m48837a(String str) {
            this.f11000b = str;
        }

        /* renamed from: b */
        public void m48834b(String str) {
            this.f11002d = str;
        }

        /* renamed from: c */
        public void m48833c(int i) {
            this.f11004f = i;
        }

        /* renamed from: a */
        public void m48840a(float f) {
            this.f11006h = f;
        }

        /* renamed from: b */
        public void m48836b(float f) {
            this.f11007i = f;
        }

        /* renamed from: a */
        public void m48838a(C3062e c3062e) {
            this.f11013o = c3062e;
        }
    }

    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3062e {
        @JsonNode(key = "sdkuid")

        /* renamed from: a */
        private String f11014a;
        @JsonNode(key = "oaid")

        /* renamed from: b */
        private String f11015b;

        /* renamed from: a */
        public void m48825a(String str) {
            this.f11014a = str;
        }

        /* renamed from: b */
        public void m48824b(String str) {
            this.f11015b = str;
        }
    }

    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3063f {
        @JsonNode(key = "id")

        /* renamed from: a */
        private String f11016a;
        @JsonNode(key = "qty")

        /* renamed from: b */
        private int f11017b;
        @JsonNode(key = RtspHeaders.Values.SEQ)

        /* renamed from: c */
        private int f11018c;
        @JsonNode(key = "dlvy")

        /* renamed from: d */
        private int f11019d;
        @JsonNode(key = "spec")

        /* renamed from: e */
        private C3064g f11020e;
        @JsonNode(key = "priv")

        /* renamed from: f */
        private int f11021f;

        /* renamed from: a */
        public void m48821a(String str) {
            this.f11016a = str;
        }

        /* renamed from: b */
        public void m48820b(int i) {
            this.f11018c = i;
        }

        /* renamed from: c */
        public void m48819c(int i) {
            this.f11019d = i;
        }

        /* renamed from: d */
        public void m48818d(int i) {
            this.f11021f = i;
        }

        /* renamed from: a */
        public void m48823a(int i) {
            this.f11017b = i;
        }

        /* renamed from: a */
        public void m48822a(C3064g c3064g) {
            this.f11020e = c3064g;
        }
    }

    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3064g {
        @JsonNode(key = "placement")

        /* renamed from: a */
        private C3065h f11022a;

        /* renamed from: a */
        public void m48817a(C3065h c3065h) {
            this.f11022a = c3065h;
        }
    }

    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$h */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3065h {
        @JsonNode(key = "tagid")

        /* renamed from: a */
        private String f11023a;
        @JsonNode(key = "sdk")

        /* renamed from: b */
        private String f11024b;
        @JsonNode(key = "sdkver")

        /* renamed from: c */
        private String f11025c;
        @JsonNode(key = "reward")

        /* renamed from: d */
        private int f11026d;

        /* renamed from: a */
        public void m48815a(String str) {
            this.f11023a = str;
        }

        /* renamed from: b */
        public void m48814b(String str) {
            this.f11024b = str;
        }

        /* renamed from: c */
        public void m48813c(String str) {
            this.f11025c = str;
        }

        /* renamed from: a */
        public void m48816a(int i) {
            this.f11026d = i;
        }
    }

    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$i */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3066i {
        @JsonNode(key = "id")

        /* renamed from: a */
        private String f11027a;
        @JsonNode(key = "test")

        /* renamed from: b */
        private int f11028b;
        @JsonNode(key = "tmax")

        /* renamed from: c */
        private int f11029c;
        @JsonNode(key = "at")

        /* renamed from: d */
        private int f11030d;
        @JsonNode(key = BidResponsed.KEY_CUR)

        /* renamed from: e */
        private List<String> f11031e;
        @JsonNode(key = "seat")

        /* renamed from: f */
        private List<String> f11032f;
        @JsonNode(key = "wseat")

        /* renamed from: g */
        private int f11033g;
        @JsonNode(key = "item")

        /* renamed from: h */
        private List<C3063f> f11034h;
        @JsonNode(key = "context")

        /* renamed from: i */
        private C3060c f11035i;
        @JsonNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)

        /* renamed from: j */
        private C3067j f11036j;

        /* renamed from: a */
        public void m48809a(String str) {
            this.f11027a = str;
        }

        /* renamed from: b */
        public void m48807b(int i) {
            this.f11029c = i;
        }

        /* renamed from: c */
        public void m48805c(int i) {
            this.f11030d = i;
        }

        /* renamed from: d */
        public void m48803d(int i) {
            this.f11033g = i;
        }

        /* renamed from: a */
        public void m48812a(int i) {
            this.f11028b = i;
        }

        /* renamed from: b */
        public void m48806b(List<String> list) {
            this.f11032f = list;
        }

        /* renamed from: c */
        public void m48804c(List<C3063f> list) {
            this.f11034h = list;
        }

        /* renamed from: a */
        public void m48808a(List<String> list) {
            this.f11031e = list;
        }

        /* renamed from: a */
        public void m48811a(C3060c c3060c) {
            this.f11035i = c3060c;
        }

        /* renamed from: a */
        public void m48810a(C3067j c3067j) {
            this.f11036j = c3067j;
        }
    }

    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$j */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3067j {
        @JsonNode(key = "seat")

        /* renamed from: a */
        private List<C3068k> f11037a;

        /* renamed from: a */
        public void m48802a(List<C3068k> list) {
            this.f11037a = list;
        }
    }

    /* compiled from: BidS2SRequestModel.java */
    /* renamed from: com.beizi.fusion.d.a.b$k */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3068k {
        @JsonNode(key = "seatid")

        /* renamed from: a */
        private String f11038a;
        @JsonNode(key = "seatname")

        /* renamed from: b */
        private String f11039b;
        @JsonNode(key = "seatappid")

        /* renamed from: c */
        private String f11040c;
        @JsonNode(key = "seattagid")

        /* renamed from: d */
        private String f11041d;
        @JsonNode(key = BidResponsed.KEY_TOKEN)

        /* renamed from: e */
        private String f11042e;
        @JsonNode(key = "sdkInfo")

        /* renamed from: f */
        private String f11043f;

        /* renamed from: a */
        public void m48801a(String str) {
            this.f11038a = str;
        }

        /* renamed from: b */
        public void m48800b(String str) {
            this.f11039b = str;
        }

        /* renamed from: c */
        public void m48799c(String str) {
            this.f11040c = str;
        }

        /* renamed from: d */
        public void m48798d(String str) {
            this.f11041d = str;
        }

        /* renamed from: e */
        public void m48797e(String str) {
            this.f11042e = str;
        }

        /* renamed from: f */
        public void m48796f(String str) {
            this.f11043f = str;
        }
    }

    /* renamed from: a */
    public void m48847a(C3066i c3066i) {
        this.f10992a = c3066i;
    }
}
