package com.bytedance.sdk.openadsdk.core.live.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.gb;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.eq;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends c {

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f33854f = false;
    protected String sr;
    protected SoftReference<me> ux;
    protected String xv;

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        try {
            JSONObject optJSONObject = k.sr().fz().optJSONObject("com.byted.live.lite");
            if (optJSONObject != null) {
                TTLiveCommerceHelper.getInstance().updatePluginVersion(optJSONObject.optString("plugin_version"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private Bundle r() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("liveInitConfig", new com.bytedance.sdk.openadsdk.core.live.w());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("site_id", k.sr().ev());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        bundle.putString("liveInitExtra", jSONObject.toString());
        return bundle;
    }

    private int sr(me meVar) {
        String my = meVar.my();
        Integer num = (Integer) gb.c(meVar.iy(), (Class<Object>) Integer.class);
        if ((num == null || num.intValue() <= 0) && !TextUtils.isEmpty(my)) {
            try {
                return new JSONObject(my).optInt("auth_reward_gold");
            } catch (Throwable th) {
                a.sr("TTLiveSDkBridge", th);
                return 0;
            }
        }
        return 0;
    }

    public static String w(int i4) {
        switch (i4) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                return EnterMethod.LIVE_CELL.lowerName();
            case 5:
                return EnterMethod.LIVE_CARD.lowerName();
            default:
                return EnterMethod.NO_VALUE.lowerName();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01dd A[Catch: Exception -> 0x0289, TryCatch #3 {Exception -> 0x0289, blocks: (B:98:0x01b6, B:100:0x01dd, B:101:0x0230, B:103:0x025f, B:104:0x0262, B:106:0x026e, B:107:0x0274), top: B:129:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x025f A[Catch: Exception -> 0x0289, TryCatch #3 {Exception -> 0x0289, blocks: (B:98:0x01b6, B:100:0x01dd, B:101:0x0230, B:103:0x025f, B:104:0x0262, B:106:0x026e, B:107:0x0274), top: B:129:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x026e A[Catch: Exception -> 0x0289, TryCatch #3 {Exception -> 0x0289, blocks: (B:98:0x01b6, B:100:0x01dd, B:101:0x0230, B:103:0x025f, B:104:0x0262, B:106:0x026e, B:107:0x0274), top: B:129:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00eb A[Catch: Exception -> 0x00f9, TryCatch #4 {Exception -> 0x00f9, blocks: (B:45:0x00cf, B:52:0x00eb, B:54:0x00f5), top: B:131:0x00cf }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.os.Bundle xv(android.content.Context r23, com.bytedance.sdk.openadsdk.core.u.me r24, java.util.Map<java.lang.String, java.lang.Object> r25) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.c.ux.xv(android.content.Context, com.bytedance.sdk.openadsdk.core.u.me, java.util.Map):android.os.Bundle");
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    @Deprecated
    public int b_(me meVar) {
        return 2;
    }

    public boolean f() {
        if (this.f33848c != null && !this.f33854f) {
            Object call = this.f33848c.call(1, null, null);
            if (call instanceof AtomicBoolean) {
                this.f33854f = ((AtomicBoolean) call).get();
            }
        }
        return this.f33854f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public String ux() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public int xv(me meVar) {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.c, com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c(Bridge bridge) {
        super.c(bridge);
        Bridge bridge2 = this.f33848c;
        if (bridge2 == null) {
            return;
        }
        bridge2.call(6, b.a().h(0, new EventListener() { // from class: com.bytedance.sdk.openadsdk.core.live.c.ux.1
            @Override // com.bykv.vk.openvk.api.proto.EventListener
            public ValueSet onEvent(int i4, Result result) {
                ValueSet values;
                Bundle bundle;
                if (result == null || (values = result.values()) == null || (bundle = (Bundle) values.objectValue(0, Bundle.class)) == null) {
                    return null;
                }
                if (i4 == 2) {
                    com.bytedance.sdk.openadsdk.core.fz.a.c().c(bundle.getBoolean("live_sdk_init_status"));
                } else if (i4 == 3) {
                    boolean z3 = bundle.getBoolean("live_plugin_installed");
                    boolean z4 = bundle.getBoolean("live_plugin_inited");
                    com.bytedance.sdk.openadsdk.tools.w.xv(21, z3 ? "1" : "0");
                    com.bytedance.sdk.openadsdk.tools.w.xv(20, z4 ? "1" : "0");
                    ux.this.ev();
                }
                return null;
            }
        }).l(), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int w(android.content.Context r10, com.bytedance.sdk.openadsdk.core.u.me r11, java.util.Map<java.lang.String, java.lang.Object> r12) {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r2 = ""
            if (r12 == 0) goto L28
            java.lang.String r3 = "reward_countdown"
            java.lang.Object r3 = r12.get(r3)     // Catch: java.lang.Exception -> L1e
            java.lang.Long r3 = (java.lang.Long) r3     // Catch: java.lang.Exception -> L1e
            long r3 = r3.longValue()     // Catch: java.lang.Exception -> L1e
            java.lang.String r5 = "event_tag"
            java.lang.Object r5 = r12.get(r5)     // Catch: java.lang.Exception -> L1c
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L1c
            r2 = r5
            goto L29
        L1c:
            r5 = move-exception
            goto L20
        L1e:
            r5 = move-exception
            r3 = r0
        L20:
            java.lang.String r5 = r5.toString()
            com.bytedance.sdk.component.utils.a.xv(r5)
            goto L29
        L28:
            r3 = r0
        L29:
            r6 = r3
            r3 = 5
            if (r11 != 0) goto L2e
            return r3
        L2e:
            boolean r4 = com.bytedance.sdk.openadsdk.core.u.bw.c(r11)
            if (r4 != 0) goto L35
            return r3
        L35:
            boolean r3 = r9.a_(r11)
            if (r3 != 0) goto L3d
            r10 = 6
            return r10
        L3d:
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 >= 0) goto L44
            r10 = 8
            return r10
        L44:
            int r0 = com.bytedance.sdk.openadsdk.core.u.bw.w(r11)
            r1 = 1
            if (r0 != r1) goto L4e
            r10 = 9
            return r10
        L4e:
            r3 = r9
            r4 = r10
            r5 = r11
            r8 = r12
            int r12 = r3.c(r4, r5, r6, r8)
            if (r12 != 0) goto L6b
            r0 = 0
            boolean r0 = com.bytedance.sdk.openadsdk.core.live.xv.c.c(r10, r11, r0)
            if (r0 == 0) goto L6b
            com.bytedance.sdk.openadsdk.core.live.xv.c r0 = new com.bytedance.sdk.openadsdk.core.live.xv.c
            r0.<init>()
            com.bytedance.sdk.openadsdk.core.live.xv.c r0 = r0.c(r2)
            r0.c(r10, r11)
        L6b:
            com.bytedance.sdk.openadsdk.core.fz.a r10 = com.bytedance.sdk.openadsdk.core.fz.a.c()
            r10.c(r12, r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.c.ux.w(android.content.Context, com.bytedance.sdk.openadsdk.core.u.me, java.util.Map):int");
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.c, com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c() {
        if (this.f33848c != null) {
            a.xv("TTLiveSDkBridge", "liveSDkBridge init invoke");
            this.f33848c.call(5, b.a().h(0, r()).l(), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public int sr() {
        return (this.f33848c == null || !f()) ? false : ((Boolean) this.f33848c.call(4, null, Boolean.class)).booleanValue() ? 2 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.c, com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c(String str) {
        this.sr = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public int c(Context context, me meVar, Map<String, Object> map) {
        if (context == null || meVar == null) {
            return 5;
        }
        a.f("TTLiveSDkBridge", "openLive key:" + meVar.iy());
        if (a_(meVar)) {
            if (this.f33848c != null) {
                int intValue = ((Integer) this.f33848c.call(0, b.b(1).h(0, new y().c("context", context).c("bundle", xv(context, meVar, map))).l(), Integer.class)).intValue();
                meVar.ng(intValue);
                this.xv = meVar.iy();
                if (map != null) {
                    this.f33849w = (String) map.get("event_tag");
                }
                com.bytedance.sdk.openadsdk.core.fz.a.c().w(intValue, meVar);
                if (intValue == 0) {
                    this.ux = new SoftReference<>(meVar);
                    int c4 = com.bytedance.sdk.openadsdk.core.live.sr.xv.c(map);
                    if (c4 != 101 && c4 != 102) {
                        if (!com.bytedance.sdk.openadsdk.core.live.xv.c.c(context, meVar, c4 == 103)) {
                            return intValue;
                        }
                        try {
                            String str = this.f33849w;
                            if (str == null) {
                                str = "";
                            }
                            new com.bytedance.sdk.openadsdk.core.live.xv.c().c(str).c(context, meVar);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return intValue;
                        }
                    } else {
                        a.w("lqmt", "direct saas type");
                    }
                    return intValue | (c4 << 8);
                }
                return intValue;
            }
            return 4;
        }
        return 6;
    }

    private Bundle w(Context context, me meVar, long j4, Map<String, Object> map) {
        Bundle xv = xv(context, meVar, map);
        if (meVar.hl() == null) {
            return xv;
        }
        xv.putLong("csj.reward_countdown_duration_ms", j4);
        xv.putInt("android.app.activity.request_code", 1);
        if (map != null && map.containsKey("reward_live_scene") && ((Integer) map.get("reward_live_scene")).intValue() == 1) {
            xv.putInt("live_popup_reward_auth", 1);
            a.f("rewardAuthFlag", "liv pop rew auth:  1");
        }
        return xv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public int w() {
        eq ng = ls.w().ng();
        if (ng != null) {
            int c4 = ng.c();
            return c4 != 1 ? c4 != 2 ? 0 : -1 : f() ? 2 : 1;
        }
        return 0;
    }

    public static String c(int i4) {
        if (i4 == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION.lowerName();
        }
        if (i4 == 8) {
            return EnterFromMerge.AD_UNION_INSERT.lowerName();
        }
        if (i4 == 5) {
            return EnterFromMerge.AD_UNION_FEED.lowerName();
        }
        if (i4 == 9) {
            return EnterFromMerge.AD_UNION_DRAW.lowerName();
        }
        return i4 == 1 ? "ad_union_banner" : (i4 == 3 || i4 == 4) ? "ad_union_topview" : i4 == 2 ? "ad_union_former_insert" : i4 == 6 ? "ad_union_patch" : EnterFromMerge.NO_VALUE.lowerName();
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c(me meVar, String str, int i4) {
        com.bytedance.sdk.openadsdk.core.a.xv.c(meVar, str, i4);
    }

    private int c(Context context, me meVar, long j4, Map<String, Object> map) {
        if (context == null || meVar == null) {
            return 5;
        }
        if (context instanceof Activity) {
            if (this.f33848c != null) {
                return ((Integer) this.f33848c.call(0, b.b(1).h(0, new y().c("context", context).c("bundle", w(context, meVar, j4, map))).l(), Integer.class)).intValue();
            }
            return 4;
        }
        return 7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public boolean c(me meVar) {
        return a_(meVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.c, com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c(String str, me meVar, long j4) {
        com.bytedance.sdk.openadsdk.core.video.xv.c.c(str, meVar, j4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public void xv() {
        if (this.f33848c == null || !f()) {
            return;
        }
        this.f33848c.call(3, null, null);
    }
}
