package com.beizi.p051ad.p056c;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.beizi.p051ad.p056c.CommonInfo;
import com.beizi.p051ad.p056c.EnumType;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.beizi.ad.c.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AdRequest {

    /* compiled from: AdRequest.java */
    /* renamed from: com.beizi.ad.c.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2788a {

        /* renamed from: a */
        private String f9555a;

        /* renamed from: b */
        private String f9556b;

        /* renamed from: c */
        private String f9557c;

        /* renamed from: d */
        private long f9558d;

        /* renamed from: e */
        private String f9559e;

        /* compiled from: AdRequest.java */
        /* renamed from: com.beizi.ad.c.a$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static final class C2789a {

            /* renamed from: a */
            private String f9560a;

            /* renamed from: b */
            private String f9561b;

            /* renamed from: c */
            private String f9562c;

            /* renamed from: d */
            private long f9563d;

            /* renamed from: e */
            private String f9564e;

            /* renamed from: a */
            public C2789a m50078a(String str) {
                this.f9560a = str;
                return this;
            }

            /* renamed from: b */
            public C2789a m50077b(String str) {
                this.f9561b = str;
                return this;
            }

            /* renamed from: c */
            public C2789a m50076c(String str) {
                this.f9562c = str;
                return this;
            }

            /* renamed from: a */
            public C2788a m50079a() {
                C2788a c2788a = new C2788a();
                c2788a.f9558d = this.f9563d;
                c2788a.f9557c = this.f9562c;
                c2788a.f9559e = this.f9564e;
                c2788a.f9556b = this.f9561b;
                c2788a.f9555a = this.f9560a;
                return c2788a;
            }
        }

        private C2788a() {
        }

        /* renamed from: a */
        public JSONObject m50085a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("spaceID", this.f9555a);
                jSONObject.put("spaceParam", this.f9556b);
                jSONObject.put("requestUUID", this.f9557c);
                jSONObject.put("channelReserveTs", this.f9558d);
                jSONObject.put("sdkExtInfo", this.f9559e);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: AdRequest.java */
    /* renamed from: com.beizi.ad.c.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2790b {

        /* renamed from: a */
        private String f9565a;

        /* renamed from: b */
        private EnumType.EnumC2820i f9566b;

        /* renamed from: c */
        private EnumType.EnumC2818g f9567c;

        /* renamed from: d */
        private long f9568d;

        /* renamed from: e */
        private String f9569e;

        /* renamed from: f */
        private String f9570f;

        /* renamed from: g */
        private String f9571g;

        /* renamed from: h */
        private long f9572h;

        /* renamed from: i */
        private long f9573i;

        /* renamed from: j */
        private CommonInfo.C2807a f9574j;

        /* renamed from: k */
        private CommonInfo.C2810c f9575k;

        /* renamed from: l */
        private ArrayList<C2788a> f9576l;

        /* compiled from: AdRequest.java */
        /* renamed from: com.beizi.ad.c.a$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static final class C2791a {

            /* renamed from: a */
            private String f9577a;

            /* renamed from: b */
            private EnumType.EnumC2820i f9578b;

            /* renamed from: c */
            private EnumType.EnumC2818g f9579c;

            /* renamed from: d */
            private long f9580d;

            /* renamed from: e */
            private String f9581e;

            /* renamed from: f */
            private String f9582f;

            /* renamed from: g */
            private String f9583g;

            /* renamed from: h */
            private long f9584h;

            /* renamed from: i */
            private long f9585i;

            /* renamed from: j */
            private CommonInfo.C2807a f9586j;

            /* renamed from: k */
            private CommonInfo.C2810c f9587k;

            /* renamed from: l */
            private ArrayList<C2788a> f9588l = new ArrayList<>();

            /* renamed from: a */
            public C2791a m50055a(String str) {
                this.f9577a = str;
                return this;
            }

            /* renamed from: b */
            public C2791a m50053b(String str) {
                this.f9581e = str;
                return this;
            }

            /* renamed from: c */
            public C2791a m50051c(String str) {
                this.f9582f = str;
                return this;
            }

            /* renamed from: d */
            public C2791a m50050d(String str) {
                this.f9583g = str;
                return this;
            }

            /* renamed from: a */
            public C2791a m50056a(EnumType.EnumC2820i enumC2820i) {
                this.f9578b = enumC2820i;
                return this;
            }

            /* renamed from: b */
            public C2791a m50054b(long j) {
                this.f9584h = j;
                return this;
            }

            /* renamed from: c */
            public C2791a m50052c(long j) {
                this.f9585i = j;
                return this;
            }

            /* renamed from: a */
            public C2791a m50057a(EnumType.EnumC2818g enumC2818g) {
                this.f9579c = enumC2818g;
                return this;
            }

            /* renamed from: a */
            public C2791a m50061a(long j) {
                this.f9580d = j;
                return this;
            }

            /* renamed from: a */
            public C2791a m50059a(CommonInfo.C2807a c2807a) {
                this.f9586j = c2807a;
                return this;
            }

            /* renamed from: a */
            public C2791a m50058a(CommonInfo.C2810c c2810c) {
                this.f9587k = c2810c;
                return this;
            }

            /* renamed from: a */
            public C2790b m50062a() {
                C2790b c2790b = new C2790b();
                c2790b.f9569e = this.f9581e;
                c2790b.f9574j = this.f9586j;
                c2790b.f9567c = this.f9579c;
                c2790b.f9572h = this.f9584h;
                c2790b.f9566b = this.f9578b;
                c2790b.f9568d = this.f9580d;
                c2790b.f9571g = this.f9583g;
                c2790b.f9573i = this.f9585i;
                c2790b.f9575k = this.f9587k;
                c2790b.f9576l = this.f9588l;
                c2790b.f9570f = this.f9582f;
                c2790b.f9565a = this.f9577a;
                return c2790b;
            }

            /* renamed from: a */
            public void m50060a(C2788a c2788a) {
                this.f9588l.add(c2788a);
            }
        }

        public String toString() {
            return m50075a();
        }

        private C2790b() {
        }

        /* renamed from: a */
        private String m50075a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ConstantHelper.LOG_VS, this.f9565a);
                jSONObject.put("srcType", this.f9566b);
                jSONObject.put("reqType", this.f9567c);
                jSONObject.put("timeStamp", this.f9568d);
                jSONObject.put("appid", this.f9569e);
                jSONObject.put("appVersion", this.f9570f);
                jSONObject.put("apkName", this.f9571g);
                jSONObject.put("appInstallTime", this.f9572h);
                jSONObject.put("appUpdateTime", this.f9573i);
                CommonInfo.C2807a c2807a = this.f9574j;
                if (c2807a != null) {
                    jSONObject.put("devInfo", c2807a.m49847a());
                }
                CommonInfo.C2810c c2810c = this.f9575k;
                if (c2810c != null) {
                    jSONObject.put("envInfo", c2810c.m49796a());
                }
                ArrayList<C2788a> arrayList = this.f9576l;
                if (arrayList != null && arrayList.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < this.f9576l.size(); i++) {
                        jSONArray.put(this.f9576l.get(i).m50085a());
                    }
                    jSONObject.put("adReqInfo", jSONArray);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
