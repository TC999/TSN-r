package com.beizi.fusion.p066d.p067a;

import com.beizi.fusion.model.JsonNode;
import com.beizi.fusion.model.JsonResolver;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.List;

/* renamed from: com.beizi.fusion.d.a.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BidS2SResponseModel {
    @JsonNode(key = "seatbid")

    /* renamed from: a */
    private List<C3071c> f11044a;

    /* compiled from: BidS2SResponseModel.java */
    /* renamed from: com.beizi.fusion.d.a.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3069a {
        @JsonNode(key = BidResponsed.KEY_PRICE)

        /* renamed from: a */
        private String f11045a;
        @JsonNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)

        /* renamed from: b */
        private C3072d f11046b;

        /* renamed from: a */
        public String m48793a() {
            return this.f11045a;
        }

        /* renamed from: b */
        public C3072d m48792b() {
            return this.f11046b;
        }
    }

    /* compiled from: BidS2SResponseModel.java */
    /* renamed from: com.beizi.fusion.d.a.c$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3070b {
        @JsonNode(key = "impAdInfo")

        /* renamed from: a */
        private String f11047a;

        /* renamed from: a */
        public String m48791a() {
            return this.f11047a;
        }
    }

    /* compiled from: BidS2SResponseModel.java */
    /* renamed from: com.beizi.fusion.d.a.c$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3071c {
        @JsonNode(key = "seat")

        /* renamed from: a */
        private String f11048a;
        @JsonNode(key = BidResponsed.KEY_BID_ID)

        /* renamed from: b */
        private List<C3069a> f11049b;
        @JsonNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)

        /* renamed from: c */
        private C3070b f11050c;

        /* renamed from: a */
        public String m48790a() {
            return this.f11048a;
        }

        /* renamed from: b */
        public List<C3069a> m48789b() {
            return this.f11049b;
        }

        /* renamed from: c */
        public C3070b m48788c() {
            return this.f11050c;
        }
    }

    /* compiled from: BidS2SResponseModel.java */
    /* renamed from: com.beizi.fusion.d.a.c$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3072d {
        @JsonNode(key = BidResponsed.KEY_TOKEN)

        /* renamed from: a */
        private String f11051a;

        /* renamed from: a */
        public String m48787a() {
            return this.f11051a;
        }
    }

    /* renamed from: a */
    public static BidS2SResponseModel m48794a(String str) {
        try {
            return (BidS2SResponseModel) JsonResolver.fromJson(str, (Class<Object>) BidS2SResponseModel.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public List<C3071c> m48795a() {
        return this.f11044a;
    }
}
