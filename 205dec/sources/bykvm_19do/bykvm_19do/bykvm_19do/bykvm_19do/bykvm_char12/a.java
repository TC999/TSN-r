package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.e;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.f;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b0;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.j;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTMediationAdSdk;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* compiled from: ServerBiddingHelper.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f323a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f324b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServerBiddingHelper.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f327a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AdError f328b;

        b(a aVar, d dVar, AdError adError) {
            this.f327a = dVar;
            this.f328b = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.f327a;
            if (dVar != null) {
                dVar.a(this.f328b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServerBiddingHelper.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f329a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f330b;

        c(a aVar, d dVar, e eVar) {
            this.f329a = dVar;
            this.f330b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.f329a;
            if (dVar != null) {
                dVar.a(this.f330b);
            }
        }
    }

    /* compiled from: ServerBiddingHelper.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface d {
        void a(e eVar);

        void a(AdError adError);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0027, code lost:
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0028, code lost:
        switch(r1) {
            case 91: goto L34;
            case 92: goto L32;
            case 93: goto L32;
            default: goto L30;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002c, code lost:
        return 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x002d, code lost:
        r1 = '[';
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(int r5) {
        /*
        L0:
            r0 = 94
            r1 = 75
            r2 = 93
        L6:
            r3 = 2
            r4 = 4
            switch(r0) {
                case 92: goto L21;
                case 93: goto L28;
                case 94: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L30
        Lc:
            if (r1 > r4) goto Lf
            goto L30
        Lf:
            r0 = 1
            if (r5 == r0) goto L27
            if (r5 == r3) goto L30
            r0 = 3
            if (r5 == r0) goto L25
            if (r5 == r4) goto L25
            r1 = 7
            if (r5 == r1) goto L25
            r1 = 8
            if (r5 == r1) goto L25
            return r0
        L21:
            switch(r1) {
                case 21: goto L2c;
                case 22: goto L27;
                case 23: goto L25;
                default: goto L24;
            }
        L24:
            goto L28
        L25:
            r5 = 5
            return r5
        L27:
            return r3
        L28:
            switch(r1) {
                case 91: goto L0;
                case 92: goto L2c;
                case 93: goto L2c;
                default: goto L2b;
            }
        L2b:
            goto L2d
        L2c:
            return r4
        L2d:
            r1 = 91
            goto L28
        L30:
            r0 = 93
            r1 = 93
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.a(int):int");
    }

    static /* synthetic */ String a() {
        while (true) {
            char c4 = '^';
            char c5 = 'K';
            while (true) {
                if (c4 == '\\') {
                    switch (c5) {
                        case 22:
                        case 23:
                            c4 = ']';
                            c5 = ']';
                    }
                } else if (c4 != ']') {
                    c4 = ']';
                    c5 = ']';
                }
            }
            while (true) {
                switch (c5) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c5 = '[';
                }
            }
        }
        return f323a;
    }

    private String a(AdSlot adSlot, h hVar) {
        String linkedId = adSlot != null ? adSlot.getLinkedId() : null;
        if (hVar != null) {
            return (linkedId + "_") + hVar.c();
        }
        return linkedId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String a(AdSlot adSlot, List<h> list, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar, int i4) {
        boolean z3;
        while (true) {
            char c4 = 'F';
            char c5 = '\r';
            while (true) {
                switch (c4) {
                    case 'E':
                        while (true) {
                            switch (c5) {
                                case '\n':
                                    break;
                                case 11:
                                    while (true) {
                                    }
                                case '\f':
                                    break;
                                default:
                                    c5 = '\f';
                            }
                        }
                        c4 = 'G';
                        break;
                    case 'F':
                        if (c5 != '\f' && c5 != '\r') {
                            break;
                        }
                        c4 = 'G';
                    case 'G':
                        break;
                    default:
                        c4 = 'G';
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        int i5 = 0;
        try {
            jSONObject.putOpt(ConstantAd.KEY_CACHE_AD, adSlot.getLinkedId());
            jSONObject.putOpt("sdk_version", TTMediationAdSdk.getSdkVersion());
            jSONObject.putOpt("waterfall_id", Long.valueOf(cVar.v()));
            jSONObject.putOpt("waterfall_version", cVar.q());
            jSONObject.putOpt("req_bidding_type", 2);
            jSONObject.putOpt("segment_id", Integer.valueOf(cVar.m()));
            jSONObject.putOpt("segment_version", cVar.n());
            jSONObject.putOpt("transparent_params", adSlot.getTransparentParams());
            Object b4 = b();
            if (b4 != null) {
                jSONObject.putOpt("app_abtest", b4);
            }
            Object a4 = a(cVar.t());
            if (a4 != null) {
                jSONObject.putOpt("waterfall_abtest", a4);
            }
            JSONArray jSONArray = new JSONArray();
            HashMap hashMap = new HashMap();
            hashMap.put(TTBaseAdapterConfiguration.TT_MSDK_ADSLOT_INFO, adSlot);
            hashMap.put(TTBaseAdapterConfiguration.TT_MSDK_WATER_FALL_LIST, list);
            hashMap.put(TTBaseAdapterConfiguration.TT_MSDK_WATER_FALL_AB_TEST, cVar.t());
            boolean z4 = false;
            while (i5 < list.size()) {
                try {
                    h hVar = list.get(i5);
                    if (hVar.u()) {
                        JSONObject jSONObject2 = new JSONObject();
                        String d4 = hVar.d();
                        hashMap.put(TTBaseAdapterConfiguration.TT_MSDK_CLIENT_REQ_ID, a(adSlot, hVar));
                        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a(d4);
                        String a6 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b.a(hashMap, d4);
                        Logger.i("tt_server_bidding", "adnName:" + d4 + "token=" + a6);
                        jSONObject2.putOpt("name", d4);
                        jSONObject2.putOpt("token", a6);
                        jSONObject2.putOpt("slot_id", hVar.c());
                        if (a5 != null) {
                            jSONObject2.putOpt("app_id", a5.a());
                        }
                        jSONArray.put(jSONObject2);
                        if ("pangle".equals(d4)) {
                            z4 = true;
                        }
                    }
                    i5++;
                    z4 = z4;
                } catch (Exception e4) {
                    e = e4;
                    i5 = z4 ? 1 : 0;
                    Logger.i("tt_server_bidding", "ServerBiddingHelper#serverBiddingRequest getParam() error:" + e.toString());
                    z3 = i5;
                    return a(jSONObject, z3);
                }
            }
            jSONObject.putOpt("bidders", jSONArray);
            if (!z4) {
                jSONObject.putOpt("bid_request", b(adSlot));
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("primerit_req_type", i4);
            jSONObject3.put("req_type", adSlot.getReqType());
            jSONObject3.putOpt("waterfall_extra", adSlot.getmWaterfallExtra());
            jSONObject.putOpt("bid_request_ext", jSONObject3);
            Logger.i("serverBiddingRequest", "serverBiddingRequest-requestBody=" + jSONObject.toString());
            z3 = z4;
        } catch (Exception e5) {
            e = e5;
        }
        return a(jSONObject, z3);
    }

    private String a(JSONObject jSONObject, boolean z3) {
        JSONObject a4 = b0.a(jSONObject);
        if (a4 != null) {
            try {
                a4.putOpt("token_type", Integer.valueOf(z3 ? 1 : 0));
            } catch (Exception unused) {
            }
            return a4.toString();
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private org.json.JSONObject a(com.bytedance.msdk.api.AdSlot r6) {
        /*
            r5 = this;
            r0 = 92
        L2:
            r1 = 14
        L4:
            switch(r1) {
                case 13: goto L5d;
                case 14: goto L5f;
                case 15: goto L8;
                default: goto L7;
            }
        L7:
            goto L2
        L8:
            switch(r0) {
                case 94: goto L5f;
                case 95: goto Lc;
                case 96: goto L5f;
                default: goto Lb;
            }
        Lb:
            goto L5f
        Lc:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            int r1 = r6.getAdType()     // Catch: java.lang.Exception -> L5c
            java.lang.String r2 = "id"
            java.lang.String r3 = r6.getAdUnitId()     // Catch: java.lang.Exception -> L5c
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L5c
            java.lang.String r2 = "adtype"
            r0.put(r2, r1)     // Catch: java.lang.Exception -> L5c
            java.lang.String r2 = "pos"
            int r3 = a(r1)     // Catch: java.lang.Exception -> L5c
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L5c
            java.lang.String r2 = "accepted_size"
            int r3 = r6.getImgAcceptedWidth()     // Catch: java.lang.Exception -> L5c
            int r4 = r6.getImgAcceptedHeight()     // Catch: java.lang.Exception -> L5c
            r5.a(r0, r2, r3, r4)     // Catch: java.lang.Exception -> L5c
            java.lang.String r2 = "is_support_dpl"
            boolean r3 = r6.isSupportDeepLink()     // Catch: java.lang.Exception -> L5c
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L5c
            int r6 = r6.getAdCount()     // Catch: java.lang.Exception -> L5c
            r2 = 1
            if (r6 >= r2) goto L4a
            r6 = 1
        L4a:
            r3 = 3
            if (r6 <= r3) goto L4e
            r6 = 3
        L4e:
            r3 = 7
            if (r1 == r3) goto L57
            r3 = 8
            if (r1 != r3) goto L56
            goto L57
        L56:
            r2 = r6
        L57:
            java.lang.String r6 = "ad_count"
            r0.put(r6, r2)     // Catch: java.lang.Exception -> L5c
        L5c:
            return r0
        L5d:
            r1 = 72
        L5f:
            r1 = 15
            r0 = 95
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.a(com.bytedance.msdk.api.AdSlot):org.json.JSONObject");
    }

    private JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private void a(d dVar, e eVar) {
        ThreadHelper.runOnMSDKThread(new c(this, dVar, eVar));
    }

    private void a(d dVar, AdError adError) {
        ThreadHelper.runOnMSDKThread(new b(this, dVar, adError));
    }

    static /* synthetic */ void a(a aVar, d dVar, e eVar) {
        aVar.a(dVar, eVar);
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c5) {
                                default:
                                    c5 = '[';
                                case '[':
                                case '\\':
                                case ']':
                                    break;
                            }
                        }
                        c4 = '^';
                        c5 = 'K';
                    case '^':
                        if (c5 <= 4) {
                            break;
                        } else {
                            return;
                        }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0017 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a r1, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.d r2, com.bytedance.msdk.api.AdError r3) {
        /*
            r1.a(r2, r3)
        L3:
            r1 = 94
            r2 = 75
            r3 = 93
        L9:
            r0 = 92
            if (r1 == r0) goto L10
            if (r1 == r3) goto L13
            goto L18
        L10:
            switch(r2) {
                case 21: goto L18;
                case 22: goto L18;
                case 23: goto L18;
                default: goto L13;
            }
        L13:
            switch(r2) {
                case 91: goto L3;
                case 92: goto L18;
                case 93: goto L17;
                default: goto L16;
            }
        L16:
            goto L1d
        L17:
            return
        L18:
            r1 = 93
            r2 = 93
            goto L9
        L1d:
            r2 = 91
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a$d, com.bytedance.msdk.api.AdError):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private void a(org.json.JSONObject r6) {
        /*
            r5 = this;
            r0 = 92
        L2:
            r1 = 14
        L4:
            switch(r1) {
                case 13: goto L31;
                case 14: goto L33;
                case 15: goto L8;
                default: goto L7;
            }
        L7:
            goto L2
        L8:
            switch(r0) {
                case 94: goto L33;
                case 95: goto Lc;
                case 96: goto L33;
                default: goto Lb;
            }
        Lb:
            goto L33
        Lc:
            android.content.Context r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.e.b(r0)
            if (r0 == 0) goto L30
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L30
            r1.<init>()     // Catch: java.lang.Exception -> L30
            java.lang.String r2 = "latitude"
            float r3 = r0.f631a     // Catch: java.lang.Exception -> L30
            double r3 = (double) r3     // Catch: java.lang.Exception -> L30
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L30
            java.lang.String r2 = "longitude"
            float r0 = r0.f632b     // Catch: java.lang.Exception -> L30
            double r3 = (double) r0     // Catch: java.lang.Exception -> L30
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L30
            java.lang.String r0 = "geo"
            r6.put(r0, r1)     // Catch: java.lang.Exception -> L30
        L30:
            return
        L31:
            r1 = 72
        L33:
            r1 = 15
            r0 = 95
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.a(org.json.JSONObject):void");
    }

    private void a(JSONObject jSONObject, String str, int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i4);
            jSONObject2.put("height", i5);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0010 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject b() {
        /*
            r3 = this;
            r0 = 0
        L1:
            r1 = 74
            r2 = 55
        L5:
            switch(r1) {
                case 72: goto L1;
                case 73: goto L9;
                case 74: goto Lc;
                default: goto L8;
            }
        L8:
            goto L39
        L9:
            switch(r2) {
                case 94: goto L34;
                case 95: goto L10;
                case 96: goto L10;
                default: goto Lc;
            }
        Lc:
            switch(r2) {
                case 55: goto L28;
                case 56: goto L10;
                case 57: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L34
        L10:
            r1 = 0
            if (r0 == 0) goto L14
            return r1
        L14:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L23
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c r2 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f()     // Catch: java.lang.Exception -> L23
            java.lang.String r2 = r2.e()     // Catch: java.lang.Exception -> L23
            r0.<init>(r2)     // Catch: java.lang.Exception -> L23
            r1 = r0
            goto L27
        L23:
            r0 = move-exception
            r0.printStackTrace()
        L27:
            return r1
        L28:
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f()
            java.lang.String r0 = r0.e()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
        L34:
            r1 = 73
            r2 = 96
            goto L5
        L39:
            r1 = 72
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.b():org.json.JSONObject");
    }

    private JSONObject b(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ConstantAd.KEY_CACHE_AD, adSlot.getLinkedId());
            jSONObject.put("ad_sdk_version", "2.9.2.1");
            jSONObject.put("source_type", "app");
            jSONObject.put("app", c());
            JSONObject a4 = i.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
            if (a4 != null && adSlot.getOrientation() > 0) {
                a4.put("orientation", adSlot.getOrientation());
            }
            jSONObject.put("device", a4);
            jSONObject.put("ua", com.bytedance.msdk.base.b.f27663b);
            jSONObject.put("ip", i.a());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(a(adSlot));
            jSONObject.put("adslots", jSONArray);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("req_sign", j.a((adSlot.getAdUnitId() == null || adSlot.getLinkedId() == null) ? "" : String.valueOf(currentTimeMillis).concat(adSlot.getAdUnitId()).concat(adSlot.getLinkedId())));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void b(JSONObject jSONObject) {
        while (true) {
            char c4 = '^';
            char c5 = 'K';
            while (true) {
                if (c4 == '\\') {
                    switch (c5) {
                    }
                } else if (c4 != ']') {
                    c4 = ']';
                    c5 = ']';
                }
            }
            while (true) {
                switch (c5) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c5 = '[';
                }
            }
        }
        try {
            jSONObject.put("package_name", b0.a());
            jSONObject.put("version_code", b0.d());
            jSONObject.put("version", b0.e());
        } catch (Exception unused) {
        }
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c());
            jSONObject.put("name", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().g());
            b(jSONObject);
            a(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0002, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a d() {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a> r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.class
        L2:
            r1 = 74
            r2 = 55
        L6:
            switch(r1) {
                case 72: goto L2;
                case 73: goto La;
                case 74: goto Ld;
                default: goto L9;
            }
        L9:
            goto L32
        La:
            switch(r2) {
                case 94: goto L15;
                case 95: goto L1a;
                case 96: goto L1a;
                default: goto Ld;
            }
        Ld:
            r1 = 56
            if (r2 == r1) goto L2
            r1 = 57
            if (r2 == r1) goto L1a
        L15:
            r1 = 73
            r2 = 96
            goto L6
        L1a:
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a r1 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.f324b
            if (r1 != 0) goto L2f
            monitor-enter(r0)
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a r1 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.f324b     // Catch: java.lang.Throwable -> L2c
            if (r1 != 0) goto L2a
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a r1 = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a     // Catch: java.lang.Throwable -> L2c
            r1.<init>()     // Catch: java.lang.Throwable -> L2c
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.f324b = r1     // Catch: java.lang.Throwable -> L2c
        L2a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2c
            goto L2f
        L2c:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2c
            throw r1
        L2f:
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.f324b
            return r0
        L32:
            r1 = 72
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.d():bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a");
    }

    public void a(AdSlot adSlot, List<h> list, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar, int i4, d dVar) {
        String a4 = a(adSlot, list, cVar, i4);
        Logger.i("serverBiddingRequest", "serverBiddingRequest-encryptBody=" + a4);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c b4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b.b().a().b();
        b4.b(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c.b());
        String o4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().o();
        if (!TextUtils.isEmpty(o4)) {
            b4.a("X-Tt-Env", o4);
            b4.a("x-use-ppe", "1");
        }
        b4.a("User-Agent", com.bytedance.msdk.base.b.f27663b);
        b4.c(a4);
        b4.a(new C0020a(dVar));
    }

    /* compiled from: ServerBiddingHelper.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class C0020a extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f325a;

        C0020a(d dVar) {
            this.f325a = dVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.b bVar2) {
            JSONObject jSONObject;
            if (bVar2 != null && bVar2.a() != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(bVar2.a());
                    int optInt = jSONObject2.optInt("cypher", -1);
                    if (optInt == 2) {
                        String a4 = b0.a(jSONObject2.optString("message"));
                        if (!TextUtils.isEmpty(a4)) {
                            jSONObject = new JSONObject(a4);
                        }
                        jSONObject = null;
                    } else if (optInt == 1) {
                        String a5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.a(jSONObject2.optString("message"), bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b.a());
                        if (!TextUtils.isEmpty(a5)) {
                            jSONObject = new JSONObject(a5);
                        }
                        jSONObject = null;
                    } else {
                        if (optInt == 0) {
                            jSONObject = new JSONObject(jSONObject2.optString("message"));
                        }
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        int optInt2 = jSONObject.optInt("status_code");
                        jSONObject.optInt("reason");
                        String optString = jSONObject.optString("desc");
                        if (!TextUtils.isEmpty(jSONObject.toString())) {
                            e eVar = new e();
                            eVar.a(jSONObject.optString(ConstantAd.KEY_CACHE_AD));
                            eVar.b(jSONObject.optString("server_bidding_extra"));
                            eVar.c(jSONObject.optString("server_request_id"));
                            f fVar = new f();
                            JSONObject optJSONObject = jSONObject.optJSONObject("winner");
                            if (optJSONObject != null) {
                                fVar.e(optJSONObject.optString(BidResponsed.KEY_PRICE));
                                fVar.a(optJSONObject.optString("adm"));
                                fVar.b(optJSONObject.optString("name"));
                                fVar.c(optJSONObject.optString("app_id"));
                                fVar.f(optJSONObject.optString("slot_id"));
                                fVar.g(optJSONObject.optString("win_callback", null));
                                fVar.d(optJSONObject.optString("fail_callback", null));
                                eVar.a(fVar);
                            }
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("waterfall");
                            if (optJSONObject2 != null) {
                                e.a aVar = new e.a();
                                aVar.a(optJSONObject2.optString("version"));
                                JSONArray optJSONArray = optJSONObject2.optJSONArray("adn_rit_conf");
                                ArrayList arrayList = new ArrayList();
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                        JSONObject optJSONObject3 = optJSONArray.optJSONObject(i4);
                                        h hVar = new h();
                                        hVar.b(optJSONObject3.optString("adn_name"));
                                        hVar.a(optJSONObject3.optString("adn_slot_id"));
                                        arrayList.add(hVar);
                                    }
                                }
                                aVar.a(arrayList);
                                eVar.a(aVar);
                            }
                            a.a(a.this, this.f325a, eVar);
                            return;
                        }
                        Logger.e(a.a(), "Server Bidding Request onResponse..data is null ,statusCode=" + optInt2 + ",error=" + optString);
                        a.a(a.this, this.f325a, new AdError(-1, AdError.getMessage(-1)));
                        return;
                    }
                    Logger.e(a.a(), "Server Bidding Request onResponse...data is null");
                    a.a(a.this, this.f325a, new AdError(-1, AdError.getMessage(-1)));
                    return;
                } catch (Throwable th) {
                    Logger.e(a.a(), "Server Bidding onResponse throwable \uff1a" + th.toString());
                    a.a(a.this, this.f325a, new AdError(-1, AdError.getMessage(-1)));
                    return;
                }
            }
            Logger.e(a.a(), "Server Bidding Request onResponse...response is invalid");
            a.a(a.this, this.f325a, new AdError(-1, AdError.getMessage(-1)));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, IOException iOException) {
            String message = AdError.getMessage(-16);
            if (iOException != null) {
                message = iOException.getMessage();
            }
            String a4 = a.a();
            Logger.e(a4, "Server Bidding Request onError...errorCode=-16");
            d dVar = this.f325a;
            if (dVar != null) {
                a.a(a.this, dVar, new AdError(-16, message));
            }
        }
    }
}
