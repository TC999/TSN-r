package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.error.AdBreakError;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdEventUtil.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class g {
    public static void a() {
        d a4 = d.a();
        a4.e("apm_sdk_init");
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void a(int i4, int i5, long j4) {
        d a4 = d.a();
        a4.e(i4).a(j4).e("get_config_final").g(i5);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void a(int i4, String str, boolean z3, String str2) {
        String str3 = str + (z3 ? "  mSdk\u5df2\u7ecf\u521d\u59cb\u5316" : "  mSdk\u672a\u521d\u59cb\u5316");
        d a4 = d.a();
        a4.e("adn_init_fail").c(i4).d(str3).b(str2);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void a(long j4, int i4, int i5) {
        d a4 = d.a();
        a4.e("sdk_init_end");
        a4.a(j4);
        a4.a("adn_count", Integer.valueOf(i4));
        HashMap hashMap = new HashMap();
        hashMap.put("is_from_local_config", Integer.valueOf(i5));
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, hashMap);
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar, AdSlot adSlot, int i4, int i5) {
        d a4 = d.a();
        a4.e("adapter_request_fail").a(0L).a((String) null).c(-2).d("adapter create fail !").a("mediationrit_req_type", Integer.valueOf(i4)).a("mediationrit_req_type_src", Integer.valueOf(i5));
        a(a4, adSlot, hVar, (TTBaseAd) null);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, new HashMap());
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar, AdSlot adSlot, String str) {
        d a4 = d.a();
        a4.e("get_bidding_adm_to_adn").a(str);
        a(a4, adSlot, hVar, (TTBaseAd) null);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar, AdSlot adSlot, String str, int i4, int i5, int i6, AdError adError) {
        d a4 = d.a();
        if (adError instanceof AdBreakError) {
            a4.f582n = adError.code;
            a4.f579k = adError.message;
        }
        a4.e("media_request").a(str).a("ad_count", Integer.valueOf(adSlot != null ? adSlot.getAdCount() : 0)).a("adn_count", Integer.valueOf(i4)).a("mediationrit_req_type", Integer.valueOf(i5)).a("mediationrit_req_type_src", Integer.valueOf(i6)).a("grouping_params", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f()).b());
        a(a4, adSlot, hVar, (TTBaseAd) null);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    private static void a(d dVar) {
        dVar.a("block_pacing", "-1");
        dVar.a("waterfall_show_rule_id", "-1");
        dVar.a("block_show_count", "-1");
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

    /* JADX WARN: Removed duplicated region for block: B:32:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x021e -> B:33:0x0220). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0220 -> B:35:0x0224). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r5, com.bytedance.msdk.api.AdSlot r6, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h r7, com.bytedance.msdk.base.TTBaseAd r8) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d, com.bytedance.msdk.api.AdSlot, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h, com.bytedance.msdk.base.TTBaseAd):void");
    }

    public static void a(AdError adError, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar, int i4, int i5, int i6, String str, long j4, boolean z3) {
        d a4 = d.a();
        a4.e("media_fill_fail").a(j4).a(str).c(adError != null ? adError.thirdSdkErrorCode : -1).d(adError != null ? adError.thirdSdkErrorMessage : "unknown error").a("adn_count", Integer.valueOf(i4)).a("mediationrit_req_type", Integer.valueOf(i5)).a("mediationrit_req_type_src", Integer.valueOf(i6)).a("fill_type", Integer.valueOf(z3 ? 1 : 0));
        if (adError instanceof AdBreakError) {
            a4.f582n = adError.code;
            a4.f579k = adError.message;
        }
        a(a4, adSlot, hVar, (TTBaseAd) null);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, new HashMap());
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
    public static void a(com.bytedance.msdk.api.AdSlot r2) {
        /*
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d.a()
            java.lang.String r1 = "media_will_show"
            r0.e(r1)
            r1 = 0
            a(r0, r2, r1, r1)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(r2, r0, r1)
            r2 = 92
        L16:
            r0 = 14
        L18:
            switch(r0) {
                case 13: goto L21;
                case 14: goto L23;
                case 15: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L16
        L1c:
            switch(r2) {
                case 94: goto L23;
                case 95: goto L20;
                case 96: goto L23;
                default: goto L1f;
            }
        L1f:
            goto L23
        L20:
            return
        L21:
            r0 = 72
        L23:
            r0 = 15
            r2 = 95
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(com.bytedance.msdk.api.AdSlot):void");
    }

    public static void a(AdSlot adSlot, int i4) {
        d a4 = d.a();
        a4.e("get_config_error").c(i4);
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, (TTBaseAd) null);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
        while (true) {
            char c4 = 'J';
            char c5 = '7';
            while (true) {
                switch (c4) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c5) {
                            case '^':
                                break;
                            case '_':
                            case '`':
                                return;
                            default:
                                if (c5 != '8' || c5 == '9') {
                                    return;
                                }
                                break;
                        }
                        c4 = 'I';
                        c5 = '`';
                        break;
                    case 'J':
                        if (c5 != '8') {
                            return;
                        }
                        return;
                    default:
                        c4 = 'H';
                }
            }
        }
    }

    public static void a(AdSlot adSlot, int i4, long j4, String str, String str2) {
        d a4 = d.a();
        a4.e("return_bidding_result").a(j4).e(i4).a(2).a("waterfall_abtest", str).a("server_bidding_extra", str2);
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, (TTBaseAd) null);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void a(AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar, long j4, String str) {
        d a4 = d.a();
        a4.e("mediation_fill").a(j4).a("waterfall_abtest", cVar != null ? cVar.t() : null).a("server_bidding_extra", str).c(0).d("");
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, (TTBaseAd) null);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0099 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(@androidx.annotation.Nullable com.bytedance.msdk.api.AdSlot r3, com.bytedance.msdk.api.AdError r4, java.lang.String r5, java.lang.String r6) {
        /*
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d.a()
            java.lang.String r1 = "total_load_fail"
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r1 = r0.e(r1)
            java.lang.String r2 = "waterfall_abtest"
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r5 = r1.a(r2, r5)
            java.lang.String r1 = "server_bidding_extra"
            r5.a(r1, r6)
            int r5 = r4.code
            r6 = 10003(0x2713, float:1.4017E-41)
            if (r5 != r6) goto L2a
            r4 = 10010(0x271a, float:1.4027E-41)
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r4 = r0.c(r4)
            java.lang.String r5 = "Ad load timeout!"
        L23:
            r4.d(r5)
        L26:
            a(r0)
            goto L82
        L2a:
            boolean r6 = r4 instanceof com.bytedance.msdk.api.error.AdPacingError
            java.lang.String r1 = "waterfall_show_rule_id"
            if (r6 == 0) goto L4d
            r6 = r4
            com.bytedance.msdk.api.error.AdPacingError r6 = (com.bytedance.msdk.api.error.AdPacingError) r6
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r5 = r0.c(r5)
            java.lang.String r4 = r4.message
            r5.d(r4)
            java.lang.String r4 = r6.getBlockPacing()
            java.lang.String r5 = "block_pacing"
            r0.a(r5, r4)
            java.lang.String r4 = r6.getRuleId()
        L49:
            r0.a(r1, r4)
            goto L82
        L4d:
            boolean r6 = r4 instanceof com.bytedance.msdk.api.error.AdFreqError
            if (r6 == 0) goto L6b
            r6 = r4
            com.bytedance.msdk.api.error.AdFreqError r6 = (com.bytedance.msdk.api.error.AdFreqError) r6
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r5 = r0.c(r5)
            java.lang.String r4 = r4.message
            r5.d(r4)
            java.lang.String r4 = r6.getBlockShowCount()
            java.lang.String r5 = "block_show_count"
            r0.a(r5, r4)
            java.lang.String r4 = r6.getRuleId()
            goto L49
        L6b:
            boolean r6 = r4 instanceof com.bytedance.msdk.api.error.AdBreakError
            if (r6 == 0) goto L79
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r5 = r0.c(r5)
            java.lang.String r4 = r4.message
            r5.d(r4)
            goto L26
        L79:
            r4 = 10086(0x2766, float:1.4133E-41)
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r4 = r0.c(r4)
            java.lang.String r5 = "Ad load fail all loadsorts! "
            goto L23
        L82:
            r4 = 0
            a(r0, r3, r4, r4)
            android.content.Context r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(r3, r0, r4)
            r3 = 10
        L94:
            switch(r3) {
                case 10: goto L99;
                case 11: goto L98;
                case 12: goto L99;
                default: goto L97;
            }
        L97:
            goto L9c
        L98:
            return
        L99:
            r3 = 11
            goto L94
        L9c:
            r3 = 12
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(com.bytedance.msdk.api.AdSlot, com.bytedance.msdk.api.AdError, java.lang.String, java.lang.String):void");
    }

    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd) {
        d a4 = d.a();
        a4.e("media_cache_success");
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
        while (true) {
            char c4 = 15;
            while (true) {
                switch (c4) {
                    case '\r':
                        break;
                    case 14:
                        return;
                    case 15:
                    default:
                        c4 = 14;
                }
            }
        }
    }

    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd, long j4, int i4, int i5, int i6, String str) {
        String message = i6 != 0 ? AdError.getMessage(i6) : "";
        d a4 = d.a();
        a4.e("mediation_request_end").a(j4).a("waterfall_abtest", str).c(i6).d(message);
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        HashMap hashMap = new HashMap();
        hashMap.put("requested_adn_count", Integer.valueOf(i4));
        hashMap.put("requested_level_count", Integer.valueOf(i5));
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, hashMap);
    }

    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd, long j4, String str) {
        d a4 = d.a();
        a4.e("mediation_video_cached").a(j4).a("waterfall_abtest", str);
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
        while (true) {
            char c4 = 'J';
            char c5 = '7';
            while (true) {
                switch (c4) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c5) {
                            case '^':
                                break;
                            case '_':
                            case '`':
                                return;
                            default:
                                if (c5 != '8' || c5 == '9') {
                                    return;
                                }
                                break;
                        }
                        c4 = 'I';
                        c5 = '`';
                        break;
                    case 'J':
                        if (c5 != '8') {
                            return;
                        }
                        return;
                    default:
                        c4 = 'H';
                }
            }
        }
    }

    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd, String str) {
        d a4 = d.a();
        a4.e("rit_cache_cannot_use").a("cache_invalid_info", str);
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        a4.a("mediationrit_req_type", 2);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void a(AdSlot adSlot, String str) {
        d a4 = d.a();
        a4.e("cache_cannot_use").a("cache_invalid_info", str);
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, (TTBaseAd) null);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
        while (true) {
            char c4 = 'J';
            char c5 = '7';
            while (true) {
                switch (c4) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c5) {
                            case '^':
                                break;
                            case '_':
                            case '`':
                                return;
                            default:
                                if (c5 != '8' || c5 == '9') {
                                    return;
                                }
                                break;
                        }
                        c4 = 'I';
                        c5 = '`';
                        break;
                    case 'J':
                        if (c5 != '8') {
                            return;
                        }
                        return;
                    default:
                        c4 = 'H';
                }
            }
        }
    }

    public static void a(AdSlot adSlot, String str, String str2, int i4) {
        String str3;
        if (i4 > 0) {
            str3 = AdError.getMessage(i4);
        } else {
            i4 = 0;
            str3 = "";
        }
        d a4 = d.a();
        a4.e("mediation_request").a("waterfall_abtest", str).a("server_bidding_extra", str2).c(i4).d(str3);
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, (TTBaseAd) null);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void a(TTBaseAd tTBaseAd, int i4, String str, long j4, AdSlot adSlot, int i5, int i6, boolean z3) {
        d a4 = d.a();
        a4.e("media_fill").a(j4).c(i4).d(str).a("adn_count", Integer.valueOf(i5)).a("ad_count", Integer.valueOf(i6)).a("fill_type", Integer.valueOf(z3 ? 1 : 0));
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, new HashMap());
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot) {
        d a4 = d.a();
        a4.e("bidding_adm_cache");
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
        while (true) {
            char c4 = 15;
            while (true) {
                switch (c4) {
                    case '\r':
                        break;
                    case 14:
                        return;
                    case 15:
                    default:
                        c4 = 14;
                }
            }
        }
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, AdError adError, int i4) {
        d a4 = d.a();
        a4.e(i4).c(adError != null ? adError.thirdSdkErrorCode : 0).d(adError != null ? adError.thirdSdkErrorMessage : null).e("media_show_fail_listen");
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void a(List<TTBaseAd> list, AdSlot adSlot) {
        TTBaseAd tTBaseAd = (list == null || list.size() <= 0) ? null : list.get(0);
        d a4 = d.a();
        a4.e("media_show_fail");
        if (tTBaseAd != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (TTBaseAd tTBaseAd2 : list) {
                    if (tTBaseAd2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("adn", tTBaseAd2.getAdNetWorkName());
                        jSONObject.put("type", com.bytedance.msdk.base.a.b(tTBaseAd2.getAdType()));
                        jSONObject.put("adnSlotId", tTBaseAd2.getAdNetworkSlotId());
                        jSONObject.put("loadSort", tTBaseAd2.getLoadSort());
                        jSONObject.put("showSort", tTBaseAd2.getShowSort());
                        jSONObject.put("isReady", tTBaseAd2.isReady() ? 1 : 0);
                        jSONObject.put("hasShown", tTBaseAd2.isHasShown() ? 1 : 0);
                        jSONObject.put("isAdCacheReady", tTBaseAd2.isAdCacheReady() ? 1 : 0);
                        jSONArray.put(jSONObject);
                    }
                }
                a4.c(-1);
                a4.d(jSONArray.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        a4.a("is_video_cache_success", 0);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void a(List<TTBaseAd> list, List<TTBaseAd> list2, List<TTBaseAd> list3, AdSlot adSlot) {
        char c4 = 'Z';
        while (true) {
            char c5 = 'Y';
            char c6 = 31;
            while (true) {
                switch (c5) {
                    case 'W':
                        break;
                    case 'X':
                        if (c6 <= 22 && (c4 == '@' || c4 == 'B')) {
                        }
                        break;
                    case 'Y':
                        while (true) {
                            switch (c6) {
                                case 29:
                                case 31:
                                    c5 = 'X';
                                    c6 = '\uffd6';
                                    c4 = 'B';
                                    break;
                                case 30:
                                    break;
                                default:
                                    c6 = 29;
                            }
                        }
                        break;
                    default:
                        c5 = 'W';
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        if (list3 != null && list3.size() > 0) {
            arrayList.addAll(list3);
        }
        int i4 = 0;
        TTBaseAd tTBaseAd = arrayList.size() > 0 ? (TTBaseAd) arrayList.get(0) : null;
        d a4 = d.a();
        a4.e("media_show_is_ready");
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                TTBaseAd tTBaseAd2 = (TTBaseAd) it.next();
                if (tTBaseAd2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("adn", tTBaseAd2.getAdNetWorkName());
                    jSONObject.put("type", com.bytedance.msdk.base.a.b(tTBaseAd2.getAdType()));
                    jSONObject.put("adnSlotId", tTBaseAd2.getAdNetworkSlotId());
                    jSONObject.put("loadSort", tTBaseAd2.getLoadSort());
                    jSONObject.put("showSort", tTBaseAd2.getShowSort());
                    jSONObject.put("isReady", tTBaseAd2.isReady() ? 1 : 0);
                    if (tTBaseAd2.adnHasAdExpiredApi()) {
                        jSONObject.put("isExpired", tTBaseAd2.isAdExpired() ? 1 : 0);
                    }
                    jSONObject.put("hasShown", tTBaseAd2.isHasShown() ? 1 : 0);
                    jSONObject.put("isAdCacheReady", tTBaseAd2.isAdCacheReady() ? 1 : 0);
                    if (tTBaseAd2.adnHasAdVideoCachedApi()) {
                        jSONObject.put("is_video_cache_success", tTBaseAd2.isCacheSuccess() ? 1 : 0);
                    }
                    jSONObject.put("mediationrit_req_type", tTBaseAd2.getMediationRitReqType(adSlot != null ? adSlot.getLinkedId() : null));
                    jSONObject.put("mediationrit_req_type_src", tTBaseAd2.getMediationRitReqTypeSrc(adSlot != null ? adSlot.getLinkedId() : null));
                    jSONArray.put(jSONObject);
                    if (!z3) {
                        z3 = tTBaseAd2.isReady();
                    }
                }
            }
            if (!z3) {
                i4 = -1;
            }
            a4.c(i4);
            a4.d(jSONArray.toString());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void b() {
        d a4 = d.a();
        a4.e("get_config_start");
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void b(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar, AdSlot adSlot, int i4, int i5) {
        d a4 = d.a();
        a4.e("adapter_request").a("mediationrit_req_type", Integer.valueOf(i4)).a("mediationrit_req_type_src", Integer.valueOf(i5));
        a(a4, adSlot, hVar, (TTBaseAd) null);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x001f, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(com.bytedance.msdk.api.AdSlot r3, java.lang.String r4) {
        /*
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d.a()
            java.lang.String r1 = "start_bidding_request"
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r1 = r0.e(r1)
            r2 = 2
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r1 = r1.a(r2)
            java.lang.String r2 = "waterfall_abtest"
            r1.a(r2, r4)
            r4 = 0
            a(r0, r3, r4, r4)
            android.content.Context r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(r3, r0, r4)
        L1f:
            r3 = 95
            r4 = 95
        L23:
            switch(r3) {
                case 94: goto L2e;
                case 95: goto L27;
                case 96: goto L2a;
                default: goto L26;
            }
        L26:
            goto L34
        L27:
            switch(r4) {
                case 94: goto L1f;
                case 95: goto L34;
                case 96: goto L1f;
                default: goto L2a;
            }
        L2a:
            switch(r4) {
                case 55: goto L34;
                case 56: goto L34;
                case 57: goto L34;
                default: goto L2d;
            }
        L2d:
            goto L33
        L2e:
            r3 = 39
            if (r4 != r3) goto L33
            goto L1f
        L33:
            return
        L34:
            r3 = 94
            r4 = 125(0x7d, float:1.75E-43)
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.b(com.bytedance.msdk.api.AdSlot, java.lang.String):void");
    }

    public static void b(TTBaseAd tTBaseAd, AdSlot adSlot) {
        d a4 = d.a();
        a4.e("bidding_adm_load");
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
        while (true) {
            char c4 = 15;
            while (true) {
                switch (c4) {
                    case '\r':
                        break;
                    case 14:
                        return;
                    case 15:
                    default:
                        c4 = 14;
                }
            }
        }
    }

    public static void c() {
        d a4 = d.a();
        a4.e("sdk_init");
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
    }

    public static void c(TTBaseAd tTBaseAd, AdSlot adSlot) {
        d a4 = d.a();
        a4.e("bidding_win_event");
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
        while (true) {
            char c4 = 15;
            while (true) {
                switch (c4) {
                    case '\r':
                        break;
                    case 14:
                        return;
                    case 15:
                    default:
                        c4 = 14;
                }
            }
        }
    }

    public static void d(TTBaseAd tTBaseAd, AdSlot adSlot) {
        d a4 = d.a();
        a4.e("media_click_listen");
        a(a4, adSlot, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h) null, tTBaseAd);
        c.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), a4, null);
        while (true) {
            char c4 = 15;
            while (true) {
                switch (c4) {
                    case '\r':
                        break;
                    case 14:
                        return;
                    case 15:
                    default:
                        c4 = 14;
                }
            }
        }
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
    public static void e(com.bytedance.msdk.base.TTBaseAd r2, com.bytedance.msdk.api.AdSlot r3) {
        /*
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d.a()
            java.lang.String r1 = "media_show"
            r0.e(r1)
            r1 = 0
            a(r0, r3, r1, r2)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(r2, r0, r1)
            r2 = 92
        L16:
            r3 = 14
        L18:
            switch(r3) {
                case 13: goto L21;
                case 14: goto L23;
                case 15: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L16
        L1c:
            switch(r2) {
                case 94: goto L23;
                case 95: goto L20;
                case 96: goto L23;
                default: goto L1f;
            }
        L1f:
            goto L23
        L20:
            return
        L21:
            r3 = 72
        L23:
            r3 = 15
            r2 = 95
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.e(com.bytedance.msdk.base.TTBaseAd, com.bytedance.msdk.api.AdSlot):void");
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
    public static void f(com.bytedance.msdk.base.TTBaseAd r2, com.bytedance.msdk.api.AdSlot r3) {
        /*
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d.a()
            java.lang.String r1 = "media_show_listen"
            r0.e(r1)
            r1 = 0
            a(r0, r3, r1, r2)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(r2, r0, r1)
            r2 = 92
        L16:
            r3 = 14
        L18:
            switch(r3) {
                case 13: goto L21;
                case 14: goto L23;
                case 15: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L16
        L1c:
            switch(r2) {
                case 94: goto L23;
                case 95: goto L20;
                case 96: goto L23;
                default: goto L1f;
            }
        L1f:
            goto L23
        L20:
            return
        L21:
            r3 = 72
        L23:
            r3 = 15
            r2 = 95
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.f(com.bytedance.msdk.base.TTBaseAd, com.bytedance.msdk.api.AdSlot):void");
    }
}
