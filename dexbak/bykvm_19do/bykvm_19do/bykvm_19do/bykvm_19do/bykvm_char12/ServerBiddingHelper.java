package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.URLConst;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdNetworkConfValue;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdsenseRitConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.ServerBiddingModel;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.ServerBiddingWinner;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.TTNetClient;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.InitHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AES;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AESKey;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.DeviceUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.DigestUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.ToolUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.NetResponse;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.NetCallback;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.NetExecutor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.PostExecutor;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTMediationAdSdk;
import com.bytedance.msdk.base.Sdk;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.PathCenter;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ServerBiddingHelper {

    /* renamed from: a */
    private static final String f326a = "a";

    /* renamed from: b */
    private static volatile ServerBiddingHelper f327b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServerBiddingHelper.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0952b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0954d f330a;

        /* renamed from: b */
        final /* synthetic */ AdError f331b;

        RunnableC0952b(ServerBiddingHelper serverBiddingHelper, InterfaceC0954d interfaceC0954d, AdError adError) {
            this.f330a = interfaceC0954d;
            this.f331b = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0954d interfaceC0954d = this.f330a;
            if (interfaceC0954d != null) {
                interfaceC0954d.mo59643a(this.f331b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServerBiddingHelper.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0953c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0954d f332a;

        /* renamed from: b */
        final /* synthetic */ ServerBiddingModel f333b;

        RunnableC0953c(ServerBiddingHelper serverBiddingHelper, InterfaceC0954d interfaceC0954d, ServerBiddingModel serverBiddingModel) {
            this.f332a = interfaceC0954d;
            this.f333b = serverBiddingModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0954d interfaceC0954d = this.f332a;
            if (interfaceC0954d != null) {
                interfaceC0954d.mo59644a(this.f333b);
            }
        }
    }

    /* compiled from: ServerBiddingHelper.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC0954d {
        /* renamed from: a */
        void mo59644a(ServerBiddingModel serverBiddingModel);

        /* renamed from: a */
        void mo59643a(AdError adError);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m59810a(int r5) {
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.m59810a(int):int");
    }

    /* renamed from: a */
    static /* synthetic */ String m59811a() {
        while (true) {
            char c = '^';
            char c2 = 'K';
            while (true) {
                if (c == '\\') {
                    switch (c2) {
                        case 22:
                        case 23:
                            c = ']';
                            c2 = ']';
                    }
                } else if (c != ']') {
                    c = ']';
                    c2 = ']';
                }
            }
            while (true) {
                switch (c2) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c2 = '[';
                }
            }
        }
        return f326a;
    }

    /* renamed from: a */
    private String m59804a(AdSlot adSlot, WaterFallConfig waterFallConfig) {
        String linkedId = adSlot != null ? adSlot.getLinkedId() : null;
        if (waterFallConfig != null) {
            return (linkedId + "_") + waterFallConfig.m59480c();
        }
        return linkedId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private String m59803a(AdSlot adSlot, List<WaterFallConfig> list, AdsenseRitConfig adsenseRitConfig, int i) {
        boolean z;
        while (true) {
            char c = 'F';
            char c2 = StringUtil.CARRIAGE_RETURN;
            while (true) {
                switch (c) {
                    case 'E':
                        while (true) {
                            switch (c2) {
                                case '\n':
                                    break;
                                case 11:
                                    while (true) {
                                    }
                                case '\f':
                                    break;
                                default:
                                    c2 = '\f';
                            }
                        }
                        c = 'G';
                        break;
                    case 'F':
                        if (c2 != '\f' && c2 != '\r') {
                            break;
                        }
                        c = 'G';
                    case 'G':
                        break;
                    default:
                        c = 'G';
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        int i2 = 0;
        try {
            jSONObject.putOpt("request_id", adSlot.getLinkedId());
            jSONObject.putOpt("sdk_version", TTMediationAdSdk.getSdkVersion());
            jSONObject.putOpt("waterfall_id", Long.valueOf(adsenseRitConfig.m59529v()));
            jSONObject.putOpt("waterfall_version", adsenseRitConfig.m59534q());
            jSONObject.putOpt("req_bidding_type", 2);
            jSONObject.putOpt("segment_id", Integer.valueOf(adsenseRitConfig.m59538m()));
            jSONObject.putOpt("segment_version", adsenseRitConfig.m59537n());
            jSONObject.putOpt("transparent_params", adSlot.getTransparentParams());
            Object m59797b = m59797b();
            if (m59797b != null) {
                jSONObject.putOpt("app_abtest", m59797b);
            }
            Object m59801a = m59801a(adsenseRitConfig.m59531t());
            if (m59801a != null) {
                jSONObject.putOpt("waterfall_abtest", m59801a);
            }
            JSONArray jSONArray = new JSONArray();
            HashMap hashMap = new HashMap();
            hashMap.put(TTBaseAdapterConfiguration.TT_MSDK_ADSLOT_INFO, adSlot);
            hashMap.put(TTBaseAdapterConfiguration.TT_MSDK_WATER_FALL_LIST, list);
            hashMap.put(TTBaseAdapterConfiguration.TT_MSDK_WATER_FALL_AB_TEST, adsenseRitConfig.m59531t());
            boolean z2 = false;
            while (i2 < list.size()) {
                try {
                    WaterFallConfig waterFallConfig = list.get(i2);
                    if (waterFallConfig.m59450u()) {
                        JSONObject jSONObject2 = new JSONObject();
                        String m59477d = waterFallConfig.m59477d();
                        hashMap.put(TTBaseAdapterConfiguration.TT_MSDK_CLIENT_REQ_ID, m59804a(adSlot, waterFallConfig));
                        AdNetworkConfValue m59763a = InternalContainer.m59943f().m59763a(m59477d);
                        String m59277a = InitHelper.m59277a(hashMap, m59477d);
                        Logger.m37554i("tt_server_bidding", "adnName:" + m59477d + "token=" + m59277a);
                        jSONObject2.putOpt("name", m59477d);
                        jSONObject2.putOpt(BidResponsed.KEY_TOKEN, m59277a);
                        jSONObject2.putOpt("slot_id", waterFallConfig.m59480c());
                        if (m59763a != null) {
                            jSONObject2.putOpt("app_id", m59763a.m59573a());
                        }
                        jSONArray.put(jSONObject2);
                        if ("pangle".equals(m59477d)) {
                            z2 = true;
                        }
                    }
                    i2++;
                    z2 = z2;
                } catch (Exception e) {
                    e = e;
                    i2 = z2 ? 1 : 0;
                    Logger.m37554i("tt_server_bidding", "ServerBiddingHelper#serverBiddingRequest getParam() error:" + e.toString());
                    z = i2;
                    return m59798a(jSONObject, z);
                }
            }
            jSONObject.putOpt("bidders", jSONArray);
            if (!z2) {
                jSONObject.putOpt("bid_request", m59796b(adSlot));
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("primerit_req_type", i);
            jSONObject3.put("req_type", adSlot.getReqType());
            jSONObject3.putOpt("waterfall_extra", adSlot.getmWaterfallExtra());
            jSONObject.putOpt("bid_request_ext", jSONObject3);
            Logger.m37554i("serverBiddingRequest", "serverBiddingRequest-requestBody=" + jSONObject.toString());
            z = z2;
        } catch (Exception e2) {
            e = e2;
        }
        return m59798a(jSONObject, z);
    }

    /* renamed from: a */
    private String m59798a(JSONObject jSONObject, boolean z) {
        JSONObject m59257a = ToolUtils.m59257a(jSONObject);
        if (m59257a != null) {
            try {
                m59257a.putOpt("token_type", Integer.valueOf(z ? 1 : 0));
            } catch (Exception unused) {
            }
            return m59257a.toString();
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
    /* renamed from: a */
    private org.json.JSONObject m59805a(com.bytedance.msdk.api.AdSlot r6) {
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
            int r3 = m59810a(r1)     // Catch: java.lang.Exception -> L5c
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L5c
            java.lang.String r2 = "accepted_size"
            int r3 = r6.getImgAcceptedWidth()     // Catch: java.lang.Exception -> L5c
            int r4 = r6.getImgAcceptedHeight()     // Catch: java.lang.Exception -> L5c
            r5.m59799a(r0, r2, r3, r4)     // Catch: java.lang.Exception -> L5c
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.m59805a(com.bytedance.msdk.api.AdSlot):org.json.JSONObject");
    }

    /* renamed from: a */
    private JSONObject m59801a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private void m59809a(InterfaceC0954d interfaceC0954d, ServerBiddingModel serverBiddingModel) {
        ThreadHelper.runOnMSDKThread(new RunnableC0953c(this, interfaceC0954d, serverBiddingModel));
    }

    /* renamed from: a */
    private void m59808a(InterfaceC0954d interfaceC0954d, AdError adError) {
        ThreadHelper.runOnMSDKThread(new RunnableC0952b(this, interfaceC0954d, adError));
    }

    /* renamed from: a */
    static /* synthetic */ void m59807a(ServerBiddingHelper serverBiddingHelper, InterfaceC0954d interfaceC0954d, ServerBiddingModel serverBiddingModel) {
        serverBiddingHelper.m59809a(interfaceC0954d, serverBiddingModel);
        while (true) {
            char c = ']';
            char c2 = ']';
            while (true) {
                switch (c) {
                    case '\\':
                        switch (c2) {
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                default:
                                    c2 = '[';
                                case '[':
                                case '\\':
                                case ']':
                                    break;
                            }
                        }
                        c = '^';
                        c2 = 'K';
                    case '^':
                        if (c2 <= 4) {
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void m59806a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper r1, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.InterfaceC0954d r2, com.bytedance.msdk.api.AdError r3) {
        /*
            r1.m59808a(r2, r3)
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.m59806a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a$d, com.bytedance.msdk.api.AdError):void");
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
    /* renamed from: a */
    private void m59800a(org.json.JSONObject r6) {
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
            android.content.Context r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer.m59945d()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AdLocationUtils.m59243b(r0)
            if (r0 == 0) goto L30
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L30
            r1.<init>()     // Catch: java.lang.Exception -> L30
            java.lang.String r2 = "latitude"
            float r3 = r0.f638a     // Catch: java.lang.Exception -> L30
            double r3 = (double) r3     // Catch: java.lang.Exception -> L30
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L30
            java.lang.String r2 = "longitude"
            float r0 = r0.f639b     // Catch: java.lang.Exception -> L30
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.m59800a(org.json.JSONObject):void");
    }

    /* renamed from: a */
    private void m59799a(JSONObject jSONObject, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i);
            jSONObject2.put("height", i2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0010 A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject m59797b() {
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
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c r2 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer.m59943f()     // Catch: java.lang.Exception -> L23
            java.lang.String r2 = r2.m59745e()     // Catch: java.lang.Exception -> L23
            r0.<init>(r2)     // Catch: java.lang.Exception -> L23
            r1 = r0
            goto L27
        L23:
            r0 = move-exception
            r0.printStackTrace()
        L27:
            return r1
        L28:
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer.m59943f()
            java.lang.String r0 = r0.m59745e()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
        L34:
            r1 = 73
            r2 = 96
            goto L5
        L39:
            r1 = 72
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.m59797b():org.json.JSONObject");
    }

    /* renamed from: b */
    private JSONObject m59796b(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", adSlot.getLinkedId());
            jSONObject.put("ad_sdk_version", "2.9.2.1");
            jSONObject.put("source_type", Constants.JumpUrlConstants.SRC_TYPE_APP);
            jSONObject.put(Constants.JumpUrlConstants.SRC_TYPE_APP, m59794c());
            JSONObject m59221a = DeviceUtils.m59221a(InternalContainer.m59945d());
            if (m59221a != null && adSlot.getOrientation() > 0) {
                m59221a.put("orientation", adSlot.getOrientation());
            }
            jSONObject.put(ConstantHelper.LOG_DE, m59221a);
            jSONObject.put(PathCenter.f37685d, Sdk.f21749b);
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, DeviceUtils.m59223a());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(m59805a(adSlot));
            jSONObject.put("adslots", jSONArray);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("req_sign", DigestUtils.m59205a((adSlot.getAdUnitId() == null || adSlot.getLinkedId() == null) ? "" : String.valueOf(currentTimeMillis).concat(adSlot.getAdUnitId()).concat(adSlot.getLinkedId())));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    private void m59795b(JSONObject jSONObject) {
        while (true) {
            char c = '^';
            char c2 = 'K';
            while (true) {
                if (c == '\\') {
                    switch (c2) {
                    }
                } else if (c != ']') {
                    c = ']';
                    c2 = ']';
                }
            }
            while (true) {
                switch (c2) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c2 = '[';
                }
            }
        }
        try {
            jSONObject.put("package_name", ToolUtils.m59259a());
            jSONObject.put("version_code", ToolUtils.m59253d());
            jSONObject.put(ConstantHelper.LOG_VS, ToolUtils.m59252e());
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    private JSONObject m59794c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", SdkGlobalInfo.m59939B().m59921c());
            jSONObject.put("name", SdkGlobalInfo.m59939B().m59907g());
            m59795b(jSONObject);
            m59800a(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0002, code lost:
        continue;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper m59793d() {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a> r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.class
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
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a r1 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.f327b
            if (r1 != 0) goto L2f
            monitor-enter(r0)
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a r1 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.f327b     // Catch: java.lang.Throwable -> L2c
            if (r1 != 0) goto L2a
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a r1 = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a     // Catch: java.lang.Throwable -> L2c
            r1.<init>()     // Catch: java.lang.Throwable -> L2c
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.f327b = r1     // Catch: java.lang.Throwable -> L2c
        L2a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2c
            goto L2f
        L2c:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2c
            throw r1
        L2f:
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.f327b
            return r0
        L32:
            r1 = 72
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.m59793d():bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a");
    }

    /* renamed from: a */
    public void m59802a(AdSlot adSlot, List<WaterFallConfig> list, AdsenseRitConfig adsenseRitConfig, int i, InterfaceC0954d interfaceC0954d) {
        String m59803a = m59803a(adSlot, list, adsenseRitConfig, i);
        Logger.m37554i("serverBiddingRequest", "serverBiddingRequest-encryptBody=" + m59803a);
        PostExecutor m59082b = TTNetClient.m59292b().m59293a().m59082b();
        m59082b.m58997b(URLConst.m59448b());
        String m59898o = SdkGlobalInfo.m59939B().m59898o();
        if (!TextUtils.isEmpty(m59898o)) {
            m59082b.m58998a("X-Tt-Env", m59898o);
            m59082b.m58998a("x-use-ppe", "1");
        }
        m59082b.m58998a("User-Agent", Sdk.f21749b);
        m59082b.m58993c(m59803a);
        m59082b.m58996a(new C0951a(interfaceC0954d));
    }

    /* compiled from: ServerBiddingHelper.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C0951a extends NetCallback {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0954d f328a;

        C0951a(InterfaceC0954d interfaceC0954d) {
            this.f328a = interfaceC0954d;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.NetCallback
        /* renamed from: a */
        public void mo59049a(NetExecutor netExecutor, NetResponse netResponse) {
            JSONObject jSONObject;
            if (netResponse != null && netResponse.m59074a() != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(netResponse.m59074a());
                    int optInt = jSONObject2.optInt("cypher", -1);
                    if (optInt == 2) {
                        String m59258a = ToolUtils.m59258a(jSONObject2.optString("message"));
                        if (!TextUtils.isEmpty(m59258a)) {
                            jSONObject = new JSONObject(m59258a);
                        }
                        jSONObject = null;
                    } else if (optInt == 1) {
                        String m59265a = AES.m59265a(jSONObject2.optString("message"), AESKey.m59260a());
                        if (!TextUtils.isEmpty(m59265a)) {
                            jSONObject = new JSONObject(m59265a);
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
                        jSONObject.optInt(MediationConstant.KEY_REASON);
                        String optString = jSONObject.optString("desc");
                        if (!TextUtils.isEmpty(jSONObject.toString())) {
                            ServerBiddingModel serverBiddingModel = new ServerBiddingModel();
                            serverBiddingModel.m59510a(jSONObject.optString("request_id"));
                            serverBiddingModel.m59508b(jSONObject.optString("server_bidding_extra"));
                            serverBiddingModel.m59506c(jSONObject.optString("server_request_id"));
                            ServerBiddingWinner serverBiddingWinner = new ServerBiddingWinner();
                            JSONObject optJSONObject = jSONObject.optJSONObject("winner");
                            if (optJSONObject != null) {
                                serverBiddingWinner.m59491e(optJSONObject.optString(BidResponsed.KEY_PRICE));
                                serverBiddingWinner.m59499a(optJSONObject.optString("adm"));
                                serverBiddingWinner.m59497b(optJSONObject.optString("name"));
                                serverBiddingWinner.m59495c(optJSONObject.optString("app_id"));
                                serverBiddingWinner.m59490f(optJSONObject.optString("slot_id"));
                                serverBiddingWinner.m59489g(optJSONObject.optString("win_callback", null));
                                serverBiddingWinner.m59493d(optJSONObject.optString("fail_callback", null));
                                serverBiddingModel.m59511a(serverBiddingWinner);
                            }
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("waterfall");
                            if (optJSONObject2 != null) {
                                ServerBiddingModel.C0972a c0972a = new ServerBiddingModel.C0972a();
                                c0972a.m59503a(optJSONObject2.optString(ConstantHelper.LOG_VS));
                                JSONArray optJSONArray = optJSONObject2.optJSONArray("adn_rit_conf");
                                ArrayList arrayList = new ArrayList();
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                                        WaterFallConfig waterFallConfig = new WaterFallConfig();
                                        waterFallConfig.m59481b(optJSONObject3.optString(MediationConstant.EXTRA_ADN_NAME));
                                        waterFallConfig.m59484a(optJSONObject3.optString("adn_slot_id"));
                                        arrayList.add(waterFallConfig);
                                    }
                                }
                                c0972a.m59502a(arrayList);
                                serverBiddingModel.m59512a(c0972a);
                            }
                            ServerBiddingHelper.m59807a(ServerBiddingHelper.this, this.f328a, serverBiddingModel);
                            return;
                        }
                        Logger.m37557e(ServerBiddingHelper.m59811a(), "Server Bidding Request onResponse..data is null ,statusCode=" + optInt2 + ",error=" + optString);
                        ServerBiddingHelper.m59806a(ServerBiddingHelper.this, this.f328a, new AdError(-1, AdError.getMessage(-1)));
                        return;
                    }
                    Logger.m37557e(ServerBiddingHelper.m59811a(), "Server Bidding Request onResponse...data is null");
                    ServerBiddingHelper.m59806a(ServerBiddingHelper.this, this.f328a, new AdError(-1, AdError.getMessage(-1)));
                    return;
                } catch (Throwable th) {
                    Logger.m37557e(ServerBiddingHelper.m59811a(), "Server Bidding onResponse throwable ：" + th.toString());
                    ServerBiddingHelper.m59806a(ServerBiddingHelper.this, this.f328a, new AdError(-1, AdError.getMessage(-1)));
                    return;
                }
            }
            Logger.m37557e(ServerBiddingHelper.m59811a(), "Server Bidding Request onResponse...response is invalid");
            ServerBiddingHelper.m59806a(ServerBiddingHelper.this, this.f328a, new AdError(-1, AdError.getMessage(-1)));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.NetCallback
        /* renamed from: a */
        public void mo59048a(NetExecutor netExecutor, IOException iOException) {
            String message = AdError.getMessage(-16);
            if (iOException != null) {
                message = iOException.getMessage();
            }
            String m59811a = ServerBiddingHelper.m59811a();
            Logger.m37557e(m59811a, "Server Bidding Request onError...errorCode=-16");
            InterfaceC0954d interfaceC0954d = this.f328a;
            if (interfaceC0954d != null) {
                ServerBiddingHelper.m59806a(ServerBiddingHelper.this, interfaceC0954d, new AdError(-16, message));
            }
        }
    }
}
