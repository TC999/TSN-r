package com.beizi.fusion.d.a;

import com.beizi.fusion.model.JsonNode;
import com.beizi.fusion.model.JsonResolver;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BidS2SResponseModel.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c {
    @JsonNode(key = "seatbid")

    /* renamed from: a  reason: collision with root package name */
    private List<C0136c> f14583a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SResponseModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {
        @JsonNode(key = BidResponsed.KEY_PRICE)

        /* renamed from: a  reason: collision with root package name */
        private String f14584a;
        @JsonNode(key = "ext")

        /* renamed from: b  reason: collision with root package name */
        private d f14585b;

        public String a() {
            return this.f14584a;
        }

        public d b() {
            return this.f14585b;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SResponseModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {
        @JsonNode(key = "impAdInfo")

        /* renamed from: a  reason: collision with root package name */
        private String f14586a;

        public String a() {
            return this.f14586a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SResponseModel.java */
    /* renamed from: com.beizi.fusion.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class C0136c {
        @JsonNode(key = "seat")

        /* renamed from: a  reason: collision with root package name */
        private String f14587a;
        @JsonNode(key = BidResponsed.KEY_BID_ID)

        /* renamed from: b  reason: collision with root package name */
        private List<a> f14588b;
        @JsonNode(key = "ext")

        /* renamed from: c  reason: collision with root package name */
        private b f14589c;

        public String a() {
            return this.f14587a;
        }

        public List<a> b() {
            return this.f14588b;
        }

        public b c() {
            return this.f14589c;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SResponseModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class d {
        @JsonNode(key = "token")

        /* renamed from: a  reason: collision with root package name */
        private String f14590a;

        public String a() {
            return this.f14590a;
        }
    }

    public static c a(String str) {
        try {
            return (c) JsonResolver.fromJson(str, (Class<Object>) c.class);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public List<C0136c> a() {
        return this.f14583a;
    }
}
