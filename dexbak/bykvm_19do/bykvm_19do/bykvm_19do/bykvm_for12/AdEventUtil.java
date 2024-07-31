package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.SdkSettingsHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdsenseRitConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.error.AdBreakError;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdEventUtil {
    /* renamed from: a */
    public static void m59332a() {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("apm_sdk_init");
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: a */
    public static void m59331a(int i, int i2, long j) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59367e(i).m59378a(j).m59366e("get_config_final").m59363g(i2);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: a */
    public static void m59330a(int i, String str, boolean z, String str2) {
        String str3 = str + (z ? "  mSdk已经初始化" : "  mSdk未初始化");
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("adn_init_fail").m59371c(i).m59368d(str3).m59372b(str2);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: a */
    public static void m59329a(long j, int i, int i2) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("sdk_init_end");
        m59380a.m59378a(j);
        m59380a.m59376a("adn_count", Integer.valueOf(i));
        HashMap hashMap = new HashMap();
        hashMap.put("is_from_local_config", Integer.valueOf(i2));
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, hashMap);
    }

    /* renamed from: a */
    public static void m59328a(WaterFallConfig waterFallConfig, AdSlot adSlot, int i, int i2) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("adapter_request_fail").m59378a(0L).m59377a((String) null).m59371c(-2).m59368d("adapter create fail !").m59376a("mediationrit_req_type", Integer.valueOf(i)).m59376a("mediationrit_req_type_src", Integer.valueOf(i2));
        m59324a(m59380a, adSlot, waterFallConfig, (TTBaseAd) null);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, new HashMap());
    }

    /* renamed from: a */
    public static void m59327a(WaterFallConfig waterFallConfig, AdSlot adSlot, String str) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("get_bidding_adm_to_adn").m59377a(str);
        m59324a(m59380a, adSlot, waterFallConfig, (TTBaseAd) null);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: a */
    public static void m59326a(WaterFallConfig waterFallConfig, AdSlot adSlot, String str, int i, int i2, int i3, AdError adError) {
        AdEventModel m59380a = AdEventModel.m59380a();
        if (adError instanceof AdBreakError) {
            m59380a.f589n = adError.code;
            m59380a.f586k = adError.message;
        }
        m59380a.m59366e("media_request").m59377a(str).m59376a("ad_count", Integer.valueOf(adSlot != null ? adSlot.getAdCount() : 0)).m59376a("adn_count", Integer.valueOf(i)).m59376a("mediationrit_req_type", Integer.valueOf(i2)).m59376a("mediationrit_req_type_src", Integer.valueOf(i3)).m59376a("grouping_params", SdkSettingsHelper.m59791a(InternalContainer.m59943f()).m59784b());
        m59324a(m59380a, adSlot, waterFallConfig, (TTBaseAd) null);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: a */
    private static void m59325a(AdEventModel adEventModel) {
        adEventModel.m59376a("block_pacing", "-1");
        adEventModel.m59376a("waterfall_show_rule_id", "-1");
        adEventModel.m59376a("block_show_count", "-1");
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

    /* JADX WARN: Removed duplicated region for block: B:32:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x021e -> B:33:0x0220). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0220 -> B:35:0x0224). Please submit an issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m59324a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventModel r5, com.bytedance.msdk.api.AdSlot r6, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig r7, com.bytedance.msdk.base.TTBaseAd r8) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil.m59324a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d, com.bytedance.msdk.api.AdSlot, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h, com.bytedance.msdk.base.TTBaseAd):void");
    }

    /* renamed from: a */
    public static void m59323a(AdError adError, AdSlot adSlot, WaterFallConfig waterFallConfig, int i, int i2, int i3, String str, long j, boolean z) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("media_fill_fail").m59378a(j).m59377a(str).m59371c(adError != null ? adError.thirdSdkErrorCode : -1).m59368d(adError != null ? adError.thirdSdkErrorMessage : "unknown error").m59376a("adn_count", Integer.valueOf(i)).m59376a("mediationrit_req_type", Integer.valueOf(i2)).m59376a("mediationrit_req_type_src", Integer.valueOf(i3)).m59376a("fill_type", Integer.valueOf(z ? 1 : 0));
        if (adError instanceof AdBreakError) {
            m59380a.f589n = adError.code;
            m59380a.f586k = adError.message;
        }
        m59324a(m59380a, adSlot, waterFallConfig, (TTBaseAd) null);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, new HashMap());
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
    public static void m59322a(com.bytedance.msdk.api.AdSlot r2) {
        /*
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventModel.m59380a()
            java.lang.String r1 = "media_will_show"
            r0.m59366e(r1)
            r1 = 0
            m59324a(r0, r2, r1, r1)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer.m59945d()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventManager.m59381a(r2, r0, r1)
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil.m59322a(com.bytedance.msdk.api.AdSlot):void");
    }

    /* renamed from: a */
    public static void m59321a(AdSlot adSlot, int i) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("get_config_error").m59371c(i);
        m59324a(m59380a, adSlot, (WaterFallConfig) null, (TTBaseAd) null);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
        while (true) {
            char c = 'J';
            char c2 = '7';
            while (true) {
                switch (c) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c2) {
                            case '^':
                                break;
                            case '_':
                            case '`':
                                return;
                            default:
                                if (c2 != '8' || c2 == '9') {
                                    return;
                                }
                                break;
                        }
                        c = 'I';
                        c2 = '`';
                        break;
                    case 'J':
                        if (c2 != '8') {
                            return;
                        }
                        return;
                    default:
                        c = 'H';
                }
            }
        }
    }

    /* renamed from: a */
    public static void m59320a(AdSlot adSlot, int i, long j, String str, String str2) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("return_bidding_result").m59378a(j).m59367e(i).m59379a(2).m59376a("waterfall_abtest", str).m59376a("server_bidding_extra", str2);
        m59324a(m59380a, adSlot, (WaterFallConfig) null, (TTBaseAd) null);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: a */
    public static void m59319a(AdSlot adSlot, AdsenseRitConfig adsenseRitConfig, long j, String str) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("mediation_fill").m59378a(j).m59376a("waterfall_abtest", adsenseRitConfig != null ? adsenseRitConfig.m59531t() : null).m59376a("server_bidding_extra", str).m59371c(0).m59368d("");
        m59324a(m59380a, adSlot, (WaterFallConfig) null, (TTBaseAd) null);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0099 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m59318a(@androidx.annotation.Nullable com.bytedance.msdk.api.AdSlot r3, com.bytedance.msdk.api.AdError r4, java.lang.String r5, java.lang.String r6) {
        /*
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventModel.m59380a()
            java.lang.String r1 = "total_load_fail"
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r1 = r0.m59366e(r1)
            java.lang.String r2 = "waterfall_abtest"
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r5 = r1.m59376a(r2, r5)
            java.lang.String r1 = "server_bidding_extra"
            r5.m59376a(r1, r6)
            int r5 = r4.code
            r6 = 10003(0x2713, float:1.4017E-41)
            if (r5 != r6) goto L2a
            r4 = 10010(0x271a, float:1.4027E-41)
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r4 = r0.m59371c(r4)
            java.lang.String r5 = "Ad load timeout!"
        L23:
            r4.m59368d(r5)
        L26:
            m59325a(r0)
            goto L82
        L2a:
            boolean r6 = r4 instanceof com.bytedance.msdk.api.error.AdPacingError
            java.lang.String r1 = "waterfall_show_rule_id"
            if (r6 == 0) goto L4d
            r6 = r4
            com.bytedance.msdk.api.error.AdPacingError r6 = (com.bytedance.msdk.api.error.AdPacingError) r6
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r5 = r0.m59371c(r5)
            java.lang.String r4 = r4.message
            r5.m59368d(r4)
            java.lang.String r4 = r6.getBlockPacing()
            java.lang.String r5 = "block_pacing"
            r0.m59376a(r5, r4)
            java.lang.String r4 = r6.getRuleId()
        L49:
            r0.m59376a(r1, r4)
            goto L82
        L4d:
            boolean r6 = r4 instanceof com.bytedance.msdk.api.error.AdFreqError
            if (r6 == 0) goto L6b
            r6 = r4
            com.bytedance.msdk.api.error.AdFreqError r6 = (com.bytedance.msdk.api.error.AdFreqError) r6
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r5 = r0.m59371c(r5)
            java.lang.String r4 = r4.message
            r5.m59368d(r4)
            java.lang.String r4 = r6.getBlockShowCount()
            java.lang.String r5 = "block_show_count"
            r0.m59376a(r5, r4)
            java.lang.String r4 = r6.getRuleId()
            goto L49
        L6b:
            boolean r6 = r4 instanceof com.bytedance.msdk.api.error.AdBreakError
            if (r6 == 0) goto L79
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r5 = r0.m59371c(r5)
            java.lang.String r4 = r4.message
            r5.m59368d(r4)
            goto L26
        L79:
            r4 = 10086(0x2766, float:1.4133E-41)
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r4 = r0.m59371c(r4)
            java.lang.String r5 = "Ad load fail all loadsorts! "
            goto L23
        L82:
            r4 = 0
            m59324a(r0, r3, r4, r4)
            android.content.Context r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer.m59945d()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventManager.m59381a(r3, r0, r4)
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil.m59318a(com.bytedance.msdk.api.AdSlot, com.bytedance.msdk.api.AdError, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public static void m59317a(AdSlot adSlot, TTBaseAd tTBaseAd) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("media_cache_success");
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
        while (true) {
            char c = 15;
            while (true) {
                switch (c) {
                    case '\r':
                        break;
                    case 14:
                        return;
                    case 15:
                    default:
                        c = 14;
                }
            }
        }
    }

    /* renamed from: a */
    public static void m59316a(AdSlot adSlot, TTBaseAd tTBaseAd, long j, int i, int i2, int i3, String str) {
        String message = i3 != 0 ? AdError.getMessage(i3) : "";
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("mediation_request_end").m59378a(j).m59376a("waterfall_abtest", str).m59371c(i3).m59368d(message);
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        HashMap hashMap = new HashMap();
        hashMap.put("requested_adn_count", Integer.valueOf(i));
        hashMap.put("requested_level_count", Integer.valueOf(i2));
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, hashMap);
    }

    /* renamed from: a */
    public static void m59315a(AdSlot adSlot, TTBaseAd tTBaseAd, long j, String str) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("mediation_video_cached").m59378a(j).m59376a("waterfall_abtest", str);
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
        while (true) {
            char c = 'J';
            char c2 = '7';
            while (true) {
                switch (c) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c2) {
                            case '^':
                                break;
                            case '_':
                            case '`':
                                return;
                            default:
                                if (c2 != '8' || c2 == '9') {
                                    return;
                                }
                                break;
                        }
                        c = 'I';
                        c2 = '`';
                        break;
                    case 'J':
                        if (c2 != '8') {
                            return;
                        }
                        return;
                    default:
                        c = 'H';
                }
            }
        }
    }

    /* renamed from: a */
    public static void m59314a(AdSlot adSlot, TTBaseAd tTBaseAd, String str) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("rit_cache_cannot_use").m59376a("cache_invalid_info", str);
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        m59380a.m59376a("mediationrit_req_type", 2);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: a */
    public static void m59313a(AdSlot adSlot, String str) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("cache_cannot_use").m59376a("cache_invalid_info", str);
        m59324a(m59380a, adSlot, (WaterFallConfig) null, (TTBaseAd) null);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
        while (true) {
            char c = 'J';
            char c2 = '7';
            while (true) {
                switch (c) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c2) {
                            case '^':
                                break;
                            case '_':
                            case '`':
                                return;
                            default:
                                if (c2 != '8' || c2 == '9') {
                                    return;
                                }
                                break;
                        }
                        c = 'I';
                        c2 = '`';
                        break;
                    case 'J':
                        if (c2 != '8') {
                            return;
                        }
                        return;
                    default:
                        c = 'H';
                }
            }
        }
    }

    /* renamed from: a */
    public static void m59312a(AdSlot adSlot, String str, String str2, int i) {
        String str3;
        if (i > 0) {
            str3 = AdError.getMessage(i);
        } else {
            i = 0;
            str3 = "";
        }
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("mediation_request").m59376a("waterfall_abtest", str).m59376a("server_bidding_extra", str2).m59371c(i).m59368d(str3);
        m59324a(m59380a, adSlot, (WaterFallConfig) null, (TTBaseAd) null);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: a */
    public static void m59311a(TTBaseAd tTBaseAd, int i, String str, long j, AdSlot adSlot, int i2, int i3, boolean z) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("media_fill").m59378a(j).m59371c(i).m59368d(str).m59376a("adn_count", Integer.valueOf(i2)).m59376a("ad_count", Integer.valueOf(i3)).m59376a("fill_type", Integer.valueOf(z ? 1 : 0));
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, new HashMap());
    }

    /* renamed from: a */
    public static void m59310a(TTBaseAd tTBaseAd, AdSlot adSlot) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("bidding_adm_cache");
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
        while (true) {
            char c = 15;
            while (true) {
                switch (c) {
                    case '\r':
                        break;
                    case 14:
                        return;
                    case 15:
                    default:
                        c = 14;
                }
            }
        }
    }

    /* renamed from: a */
    public static void m59309a(TTBaseAd tTBaseAd, AdSlot adSlot, AdError adError, int i) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59367e(i).m59371c(adError != null ? adError.thirdSdkErrorCode : 0).m59368d(adError != null ? adError.thirdSdkErrorMessage : null).m59366e("media_show_fail_listen");
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: a */
    public static void m59308a(List<TTBaseAd> list, AdSlot adSlot) {
        TTBaseAd tTBaseAd = (list == null || list.size() <= 0) ? null : list.get(0);
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("media_show_fail");
        if (tTBaseAd != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (TTBaseAd tTBaseAd2 : list) {
                    if (tTBaseAd2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(SplashAd.KEY_BIDFAIL_ADN, tTBaseAd2.getAdNetWorkName());
                        jSONObject.put("type", C6031a.m37436b(tTBaseAd2.getAdType()));
                        jSONObject.put("adnSlotId", tTBaseAd2.getAdNetworkSlotId());
                        jSONObject.put("loadSort", tTBaseAd2.getLoadSort());
                        jSONObject.put("showSort", tTBaseAd2.getShowSort());
                        jSONObject.put("isReady", tTBaseAd2.isReady() ? 1 : 0);
                        jSONObject.put("hasShown", tTBaseAd2.isHasShown() ? 1 : 0);
                        jSONObject.put("isAdCacheReady", tTBaseAd2.isAdCacheReady() ? 1 : 0);
                        jSONArray.put(jSONObject);
                    }
                }
                m59380a.m59371c(-1);
                m59380a.m59368d(jSONArray.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        m59380a.m59376a("is_video_cache_success", 0);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: a */
    public static void m59307a(List<TTBaseAd> list, List<TTBaseAd> list2, List<TTBaseAd> list3, AdSlot adSlot) {
        char c = 'Z';
        while (true) {
            char c2 = 'Y';
            char c3 = 31;
            while (true) {
                switch (c2) {
                    case 'W':
                        break;
                    case 'X':
                        if (c3 <= 22 && (c == '@' || c == 'B')) {
                        }
                        break;
                    case 'Y':
                        while (true) {
                            switch (c3) {
                                case 29:
                                case 31:
                                    c2 = 'X';
                                    c3 = 65494;
                                    c = 'B';
                                    break;
                                case 30:
                                    break;
                                default:
                                    c3 = 29;
                            }
                        }
                        break;
                    default:
                        c2 = 'W';
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
        int i = 0;
        TTBaseAd tTBaseAd = arrayList.size() > 0 ? (TTBaseAd) arrayList.get(0) : null;
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("media_show_is_ready");
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            boolean z = false;
            while (it.hasNext()) {
                TTBaseAd tTBaseAd2 = (TTBaseAd) it.next();
                if (tTBaseAd2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(SplashAd.KEY_BIDFAIL_ADN, tTBaseAd2.getAdNetWorkName());
                    jSONObject.put("type", C6031a.m37436b(tTBaseAd2.getAdType()));
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
                    if (!z) {
                        z = tTBaseAd2.isReady();
                    }
                }
            }
            if (!z) {
                i = -1;
            }
            m59380a.m59371c(i);
            m59380a.m59368d(jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: b */
    public static void m59306b() {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("get_config_start");
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: b */
    public static void m59305b(WaterFallConfig waterFallConfig, AdSlot adSlot, int i, int i2) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("adapter_request").m59376a("mediationrit_req_type", Integer.valueOf(i)).m59376a("mediationrit_req_type_src", Integer.valueOf(i2));
        m59324a(m59380a, adSlot, waterFallConfig, (TTBaseAd) null);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x001f, code lost:
        continue;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m59304b(com.bytedance.msdk.api.AdSlot r3, java.lang.String r4) {
        /*
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventModel.m59380a()
            java.lang.String r1 = "start_bidding_request"
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r1 = r0.m59366e(r1)
            r2 = 2
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r1 = r1.m59379a(r2)
            java.lang.String r2 = "waterfall_abtest"
            r1.m59376a(r2, r4)
            r4 = 0
            m59324a(r0, r3, r4, r4)
            android.content.Context r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer.m59945d()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventManager.m59381a(r3, r0, r4)
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil.m59304b(com.bytedance.msdk.api.AdSlot, java.lang.String):void");
    }

    /* renamed from: b */
    public static void m59303b(TTBaseAd tTBaseAd, AdSlot adSlot) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("bidding_adm_load");
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
        while (true) {
            char c = 15;
            while (true) {
                switch (c) {
                    case '\r':
                        break;
                    case 14:
                        return;
                    case 15:
                    default:
                        c = 14;
                }
            }
        }
    }

    /* renamed from: c */
    public static void m59302c() {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("sdk_init");
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
    }

    /* renamed from: c */
    public static void m59301c(TTBaseAd tTBaseAd, AdSlot adSlot) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("bidding_win_event");
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
        while (true) {
            char c = 15;
            while (true) {
                switch (c) {
                    case '\r':
                        break;
                    case 14:
                        return;
                    case 15:
                    default:
                        c = 14;
                }
            }
        }
    }

    /* renamed from: d */
    public static void m59300d(TTBaseAd tTBaseAd, AdSlot adSlot) {
        AdEventModel m59380a = AdEventModel.m59380a();
        m59380a.m59366e("media_click_listen");
        m59324a(m59380a, adSlot, (WaterFallConfig) null, tTBaseAd);
        AdEventManager.m59381a(InternalContainer.m59945d(), m59380a, null);
        while (true) {
            char c = 15;
            while (true) {
                switch (c) {
                    case '\r':
                        break;
                    case 14:
                        return;
                    case 15:
                    default:
                        c = 14;
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
    /* renamed from: e */
    public static void m59299e(com.bytedance.msdk.base.TTBaseAd r2, com.bytedance.msdk.api.AdSlot r3) {
        /*
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventModel.m59380a()
            java.lang.String r1 = "media_show"
            r0.m59366e(r1)
            r1 = 0
            m59324a(r0, r3, r1, r2)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer.m59945d()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventManager.m59381a(r2, r0, r1)
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil.m59299e(com.bytedance.msdk.base.TTBaseAd, com.bytedance.msdk.api.AdSlot):void");
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
    /* renamed from: f */
    public static void m59298f(com.bytedance.msdk.base.TTBaseAd r2, com.bytedance.msdk.api.AdSlot r3) {
        /*
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventModel.m59380a()
            java.lang.String r1 = "media_show_listen"
            r0.m59366e(r1)
            r1 = 0
            m59324a(r0, r3, r1, r2)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer.m59945d()
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventManager.m59381a(r2, r0, r1)
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil.m59298f(com.bytedance.msdk.base.TTBaseAd, com.bytedance.msdk.api.AdSlot):void");
    }
}
