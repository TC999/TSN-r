package com.bytedance.msdk.core.admanager.reward;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.msdk.c.sr;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.f.ck;
import com.bytedance.msdk.f.fp;
import com.bytedance.msdk.f.m;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.msdk.api.c.w f27753a;
    private ux bk;

    /* renamed from: c  reason: collision with root package name */
    private int f27754c;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.msdk.api.xv.c f27755f;
    private w fp;

    /* renamed from: t  reason: collision with root package name */
    private long f27759t;

    /* renamed from: w  reason: collision with root package name */
    private int f27760w;
    private String ys;
    private boolean xv = false;
    private boolean sr = false;
    private long ux = -1;

    /* renamed from: r  reason: collision with root package name */
    private boolean f27758r = false;
    private boolean ev = false;
    private boolean gd = true;

    /* renamed from: p  reason: collision with root package name */
    private int f27757p = -1;

    /* renamed from: k  reason: collision with root package name */
    private String f27756k = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.core.admanager.reward.c$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.xv) {
                xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify\u56de\u8c03\u8fdb\u6765\uff0c\u5df2\u7ecfdestroy, \u76f4\u63a5return");
                return;
            }
            c.this.f27758r = true;
            if (c.this.f27755f != null) {
                if (c.this.fp == null || c.this.ev) {
                    return;
                }
                xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify\u56de\u8c03\u8fdb\u6765\uff0c\u5df2\u7ecf\u6709\u7ed3\u679c\uff0c\u76f4\u63a5\u7ed9\u5f00\u53d1\u8005\u56de\u8c03");
                c.this.ev = true;
                c.this.fp.c(c.this.f27755f);
                return;
            }
            if (c.this.ux != -1) {
                if (SystemClock.elapsedRealtime() - c.this.ux > 2000) {
                    xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify\u56de\u8c03\u8fdb\u6765\uff0c\u540e\u8fdb\u6765\u4f46\u5927\u4e8e2s\uff0c\u53d1\u8d77\u8bf7\u6c42");
                    if (c.this.gd) {
                        c.this.r();
                    } else {
                        xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify\u56de\u8c03\u8fdb\u6765\u51c6\u5907\u8bf7\u6c42\uff0c\u4f46\u662f\u4e0d\u80fd\u91cd\u8bd5");
                    }
                }
            } else {
                xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify\u56de\u8c03\u8fdb\u6765\uff0c\u5148\u8fdb\u6765\u53d1\u8d77\u8bf7\u6c42");
                c.this.ux = SystemClock.elapsedRealtime();
                if (c.this.gd) {
                    c.this.r();
                } else {
                    xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify\u56de\u8c03\u8fdb\u6765\u51c6\u5907\u8bf7\u6c42\uff0c\u4f46\u662f\u4e0d\u80fd\u91cd\u8bd5");
                }
            }
            f.c(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.c.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!c.this.xv) {
                        if (c.this.fp == null || c.this.ev) {
                            return;
                        }
                        xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify\u56de\u8c03\u515c\u5e95\u8fdb\u6765\uff0c\u7ed9\u5f00\u53d1\u8005verify\u56de\u8c03");
                        c.this.ev = true;
                        com.bytedance.msdk.api.xv.c cVar = new com.bytedance.msdk.api.xv.c() { // from class: com.bytedance.msdk.core.admanager.reward.c.3.1.1
                            @Override // com.bytedance.msdk.api.xv.c
                            public float getAmount() {
                                if (c.this.f27753a != null) {
                                    return c.this.f27753a.z();
                                }
                                return 0.0f;
                            }

                            @Override // com.bytedance.msdk.api.xv.c
                            public Map<String, Object> getCustomData() {
                                HashMap hashMap = new HashMap();
                                hashMap.put("isGroMoreServerSideVerify", Boolean.TRUE);
                                hashMap.put("transId", c.this.ys);
                                hashMap.put("reason", 0);
                                hashMap.put("gromoreExtra", (c.this.f27753a == null || c.this.f27753a.yu() == null) ? "" : c.this.f27753a.yu().get("gromoreExtra"));
                                hashMap.put("errorCode", Integer.valueOf(c.this.f27757p));
                                hashMap.put("errorMsg", c.this.f27756k);
                                com.bytedance.msdk.api.xv c4 = fp.c(c.this.f27753a, c.this.bk, true);
                                hashMap.put("adnName", c4 != null ? c4.k() : "");
                                hashMap.put("ecpm", c4 != null ? c4.a() : "");
                                return hashMap;
                            }

                            @Override // com.bytedance.msdk.api.xv.c
                            public String getRewardName() {
                                return c.this.f27753a != null ? c.this.f27753a.ck() : "";
                            }

                            @Override // com.bytedance.msdk.api.xv.c
                            public boolean rewardVerify() {
                                return false;
                            }
                        };
                        w wVar = c.this.fp;
                        if (c.this.f27755f != null) {
                            cVar = c.this.f27755f;
                        }
                        wVar.c(cVar);
                        return;
                    }
                    xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- verify\u56de\u8c03\u515c\u5e95\u8fdb\u6765\uff0c\u5df2\u7ecfdestroy\u4e86, \u76f4\u63a5return");
                }
            }, 3000L);
        }
    }

    /* renamed from: com.bytedance.msdk.core.admanager.reward.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class RunnableC0413c implements Runnable {

        /* renamed from: w  reason: collision with root package name */
        private final int f27776w;

        RunnableC0413c(int i4) {
            this.f27776w = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f27755f != null || c.this.ev || !c.this.gd || c.this.xv || c.this.sr) {
                return;
            }
            xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide reward verify \u8fdb\u884c\u7b2c" + this.f27776w + "\u6b21\u91cd\u8bd5\u8bf7\u6c42");
            c.this.r();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c(com.bytedance.msdk.api.xv.c cVar);
    }

    public c(String str) {
        com.bytedance.msdk.core.k.w c4;
        com.bytedance.msdk.core.fp.xv w3 = com.bytedance.msdk.core.c.w();
        if (w3 != null && (c4 = w3.c(str, 7, 101)) != null) {
            this.f27754c = c4.m();
            this.f27760w = c4.gw();
        }
        if (this.f27754c < 0) {
            this.f27754c = 15000;
        }
    }

    private String ev() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", sr.w());
            jSONObject.put("plugin_version", sr.sr());
            jSONObject.put("user_agent", sr.f27665c);
            jSONObject.put("network", ck.xv(com.bytedance.msdk.core.c.getContext()));
            jSONObject.put("play_start_ts", this.f27759t);
            jSONObject.put("play_end_ts", System.currentTimeMillis());
            com.bytedance.msdk.api.c.w wVar = this.f27753a;
            jSONObject.put("user_id", wVar != null ? wVar.y() : "");
            if (TextUtils.isEmpty(this.ys)) {
                str = UUID.randomUUID().toString();
                this.ys = str;
            } else {
                str = this.ys;
            }
            jSONObject.put("trans_id", str);
            com.bytedance.msdk.api.c.w wVar2 = this.f27753a;
            jSONObject.put("link_id", wVar2 != null ? wVar2.c() : "");
            com.bytedance.msdk.api.c.w wVar3 = this.f27753a;
            jSONObject.put("prime_rit", wVar3 != null ? wVar3.u() : "");
            ux uxVar = this.bk;
            jSONObject.put("adn_rit", uxVar != null ? uxVar.getAdNetworkSlotId() : "");
            com.bytedance.msdk.api.c.w wVar4 = this.f27753a;
            jSONObject.put("reward_name", wVar4 != null ? wVar4.ck() : "");
            com.bytedance.msdk.api.c.w wVar5 = this.f27753a;
            jSONObject.put("reward_amount", wVar5 != null ? wVar5.z() : 0);
            com.bytedance.msdk.api.c.w wVar6 = this.f27753a;
            jSONObject.put("media_extra", (wVar6 == null || wVar6.yu() == null) ? "" : this.f27753a.yu().get("gromoreExtra"));
            com.bytedance.msdk.api.c.w wVar7 = this.f27753a;
            if (wVar7 != null && wVar7.i() != null) {
                jSONObject.put("scenario_id", this.f27753a.i());
            }
            com.bytedance.msdk.api.xv c4 = fp.c(this.f27753a, this.bk, true);
            jSONObject.put("adn_name", c4 != null ? c4.k() : "");
            jSONObject.put("ecpm", c4 != null ? c4.a() : "");
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return m.c(jSONObject).toString();
    }

    private void f() {
        xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- showListen\u56de\u8c03\u8fdb\u6765\uff0c\u5f00\u59cb\u8ba1\u65f6");
        f.c(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ux == -1 && !c.this.xv && !c.this.sr) {
                    xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- showListen\u8ba1\u65f6\u5230\u65f6\u95f4\uff0c\u53d1\u8d77\u8bf7\u6c42");
                    c.this.r();
                    f.c(new RunnableC0413c(1), 3000L);
                    f.c(new RunnableC0413c(2), 6000L);
                    f.c(new RunnableC0413c(3), 9000L);
                    return;
                }
                xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- showListen\u8ba1\u65f6\u5230\u65f6\u95f4\uff0c\u5df2\u7ecfdestroy\uff0c\u6216\u8005skip\uff0c\u6216\u8005\u6bd4complete/verify\u56de\u8c03\u8fd8\u665a\uff0c\u76f4\u63a5return");
            }
        }, this.f27754c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.bytedance.sdk.component.ev.w.sr w3 = com.bytedance.msdk.w.w.c().w().w();
        w3.c(com.bytedance.msdk.core.xv.ux());
        String ev = com.bytedance.msdk.core.w.k().ev();
        if (!TextUtils.isEmpty(ev)) {
            w3.w("X-Tt-Env", ev);
            w3.w("x-use-ppe", "1");
        }
        w3.w("User-Agent", sr.f27665c);
        w3.xv(ev());
        w3.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.msdk.core.admanager.reward.c.7
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, final com.bytedance.sdk.component.ev.w wVar) {
                f.c(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.c.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.c(wVar);
                    }
                });
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, final IOException iOException) {
                f.c(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.c.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify http error: " + iOException.toString());
                    }
                });
            }
        });
    }

    public void ux() {
        f.c(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.xv) {
                    if (c.this.f27755f == null && !c.this.ev) {
                        if (c.this.ux != -1) {
                            if (SystemClock.elapsedRealtime() - c.this.ux > 2000) {
                                xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- complete\u56de\u8c03\u8fdb\u6765\uff0c\u540e\u8fdb\u6765\u4f46\u5927\u4e8e2s\uff0c\u53d1\u8d77\u8bf7\u6c42");
                                if (c.this.gd) {
                                    c.this.r();
                                    return;
                                } else {
                                    xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- complete\u56de\u8c03\u8fdb\u6765\u51c6\u5907\u8bf7\u6c42\uff0c\u4f46\u662f\u4e0d\u80fd\u91cd\u8bd5");
                                    return;
                                }
                            }
                            return;
                        }
                        xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- complete\u56de\u8c03\u8fdb\u6765\uff0c\u5148\u8fdb\u6765\u53d1\u8d77\u8bf7\u6c42");
                        c.this.ux = SystemClock.elapsedRealtime();
                        if (c.this.gd) {
                            c.this.r();
                            return;
                        } else {
                            xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- complete\u56de\u8c03\u8fdb\u6765\u51c6\u5907\u8bf7\u6c42\uff0c\u4f46\u662f\u4e0d\u80fd\u91cd\u8bd5");
                            return;
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("--==-- complete\u56de\u8c03\u8fdb\u6765\uff0c\u5df2\u7ecf\u6709\u54cd\u5e94(");
                    sb.append(c.this.f27755f != null);
                    sb.append(")\u6216\u5df2\u7ecf\u7ed9\u51fa\u5f00\u53d1\u8005\u56de\u8c03(");
                    sb.append(c.this.ev);
                    sb.append("), \u76f4\u63a5return");
                    xv.c("GROMORE_SS_REWARD_VERIFY", sb.toString());
                    return;
                }
                xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- complete\u56de\u8c03\u8fdb\u6765\uff0c\u5df2\u7ecfdestroy, \u76f4\u63a5return");
            }
        });
    }

    public void sr() {
        f.c(new AnonymousClass3());
    }

    public void w() {
        f.c(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.sr = true;
            }
        });
    }

    public void xv() {
        f.c(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.xv = true;
            }
        });
    }

    public boolean c() {
        boolean z3 = this.f27760w == 1;
        xv.c("GROMORE_SS_REWARD_VERIFY", "--==-- \u5224\u65ad\u662f\u5426\u5f00\u542f\u4e86M\u670d\u52a1\u7aef\u6fc0\u52b1\u9a8c\u8bc1\uff1a " + z3);
        return z3;
    }

    public void c(com.bytedance.msdk.api.c.w wVar, ux uxVar) {
        this.f27759t = System.currentTimeMillis();
        this.f27753a = wVar;
        this.bk = uxVar;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9 A[Catch: JSONException -> 0x0139, TryCatch #3 {JSONException -> 0x0139, blocks: (B:9:0x000f, B:11:0x003e, B:16:0x004c, B:19:0x0077, B:23:0x0080, B:43:0x00d9, B:45:0x0116, B:47:0x011a, B:49:0x011e, B:50:0x012d, B:30:0x00ad, B:51:0x0133, B:38:0x00ca, B:32:0x00bb, B:25:0x008a), top: B:56:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d A[Catch: JSONException -> 0x0139, TryCatch #3 {JSONException -> 0x0139, blocks: (B:9:0x000f, B:11:0x003e, B:16:0x004c, B:19:0x0077, B:23:0x0080, B:43:0x00d9, B:45:0x0116, B:47:0x011a, B:49:0x011e, B:50:0x012d, B:30:0x00ad, B:51:0x0133, B:38:0x00ca, B:32:0x00bb, B:25:0x008a), top: B:56:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(com.bytedance.sdk.component.ev.w r14) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.admanager.reward.c.c(com.bytedance.sdk.component.ev.w):void");
    }

    public void c(w wVar) {
        this.fp = wVar;
    }
}
