package com.bytedance.sdk.openadsdk.core.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.ys.w.w.fp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.c$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f32225c;

        static {
            int[] iArr = new int[TTAdLoadType.values().length];
            f32225c = iArr;
            try {
                iArr[TTAdLoadType.LOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32225c[TTAdLoadType.PRELOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class C0476c extends com.bytedance.sdk.openadsdk.fz.c.w.c.sr {

        /* renamed from: c  reason: collision with root package name */
        boolean f32226c;

        /* renamed from: f  reason: collision with root package name */
        private boolean f32227f;

        /* renamed from: r  reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.ys.w.xv.w f32228r;
        private me sr;
        private boolean ux;

        /* renamed from: w  reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.ys.w.w.a f32229w;
        private com.bytedance.sdk.openadsdk.fz.c.w.c.sr xv;

        public C0476c(com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar) {
            super(null);
            this.f32226c = false;
            this.ux = false;
            this.f32227f = false;
            this.xv = srVar;
        }

        public long c() {
            com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar = this.xv;
            return srVar instanceof com.bytedance.sdk.openadsdk.core.c.w ? ((com.bytedance.sdk.openadsdk.core.c.w) srVar).c() : System.currentTimeMillis();
        }

        @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
        public void onError(int i4, String str) {
            sr.c((Context) null).w();
            com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar = this.xv;
            if (srVar != null) {
                srVar.onError(i4, str);
                if (this.f32226c) {
                    me meVar = this.sr;
                    String jr = meVar != null ? meVar.jr() : "0";
                    me meVar2 = this.sr;
                    c.w(jr, "fullscreen_interstitial_ad", meVar2 != null ? meVar2.cf() : "", 0, this.f32228r);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
        public void onFullScreenVideoAdLoad(com.bytedance.sdk.openadsdk.ys.w.w.a aVar) {
            if (this.xv != null) {
                if ((aVar instanceof a) && this.f32226c) {
                    a aVar2 = (a) aVar;
                    aVar2.w(true);
                    aVar2.c(103);
                }
                this.xv.onFullScreenVideoAdLoad(aVar);
                if (!this.f32226c || this.ux) {
                    return;
                }
                me meVar = this.sr;
                String jr = meVar != null ? meVar.jr() : "0";
                me meVar2 = this.sr;
                c.w(jr, "fullscreen_interstitial_ad", meVar2 != null ? meVar2.cf() : "", 0, this.f32228r);
                return;
            }
            this.f32229w = aVar;
        }

        @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
        public void onFullScreenVideoCached() {
            com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar = this.xv;
            if (srVar != null) {
                srVar.onFullScreenVideoCached();
                this.f32227f = true;
            }
        }

        public com.bytedance.sdk.openadsdk.fz.c.w.c.sr w() {
            return this.xv;
        }

        public void c(me meVar) {
            this.sr = meVar;
        }

        public boolean c(com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
            if (this.xv == null && srVar != null && ls.w().kk()) {
                this.xv = srVar;
                this.f32228r = wVar;
                this.f32226c = true;
            }
            return this.f32226c;
        }

        @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
        public void onFullScreenVideoCached(com.bytedance.sdk.openadsdk.ys.w.w.a aVar) {
            com.bytedance.sdk.openadsdk.ys.w.w.a aVar2;
            sr.c((Context) null).w();
            if (this.xv != null) {
                if (this.f32226c) {
                    a aVar3 = (a) aVar;
                    aVar3.w(true);
                    aVar3.c(103);
                }
                if (this.f32226c && (aVar2 = this.f32229w) != null) {
                    this.ux = true;
                    onFullScreenVideoAdLoad(aVar2);
                    if (!this.f32227f) {
                        onFullScreenVideoCached();
                    }
                    me meVar = this.sr;
                    String jr = meVar != null ? meVar.jr() : "0";
                    me meVar2 = this.sr;
                    c.w(jr, "fullscreen_interstitial_ad", meVar2 != null ? meVar2.cf() : "", 1, this.f32228r);
                }
                this.xv.onFullScreenVideoCached(aVar);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class w extends com.bytedance.sdk.openadsdk.fz.c.w.c.r {

        /* renamed from: c  reason: collision with root package name */
        boolean f32239c;

        /* renamed from: f  reason: collision with root package name */
        private boolean f32240f;

        /* renamed from: r  reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.ys.w.xv.w f32241r;
        private me sr;
        private boolean ux;

        /* renamed from: w  reason: collision with root package name */
        private fp f32242w;
        private com.bytedance.sdk.openadsdk.fz.c.w.c.r xv;

        public w(com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar) {
            super(null);
            this.f32239c = false;
            this.ux = false;
            this.f32240f = false;
            this.xv = rVar;
        }

        public long c() {
            com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar = this.xv;
            return rVar instanceof com.bytedance.sdk.openadsdk.core.c.w ? ((com.bytedance.sdk.openadsdk.core.c.w) rVar).c() : System.currentTimeMillis();
        }

        @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
        public void onError(int i4, String str) {
            k.c((Context) null).w();
            com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar = this.xv;
            if (rVar != null) {
                rVar.onError(i4, str);
                if (this.f32239c) {
                    me meVar = this.sr;
                    String jr = meVar != null ? meVar.jr() : "0";
                    me meVar2 = this.sr;
                    c.w(jr, "rewarded_video", meVar2 != null ? meVar2.cf() : "", 0, this.f32241r);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
        public void onRewardVideoAdLoad(fp fpVar) {
            if (this.xv != null) {
                if (this.f32239c) {
                    bk bkVar = (bk) fpVar;
                    bkVar.w(true);
                    bkVar.xv(103);
                }
                this.xv.onRewardVideoAdLoad(fpVar);
                if (!this.f32239c || this.ux) {
                    return;
                }
                me meVar = this.sr;
                String jr = meVar != null ? meVar.jr() : "0";
                me meVar2 = this.sr;
                c.w(jr, "rewarded_video", meVar2 != null ? meVar2.cf() : "", 0, this.f32241r);
                return;
            }
            this.f32242w = fpVar;
        }

        @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
        public void onRewardVideoCached() {
            com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar = this.xv;
            if (rVar != null) {
                rVar.onRewardVideoCached();
                this.f32240f = true;
            }
        }

        public com.bytedance.sdk.openadsdk.fz.c.w.c.r w() {
            return this.xv;
        }

        public void c(me meVar) {
            this.sr = meVar;
        }

        public boolean c(com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
            if (this.xv == null && rVar != null && ls.w().kk()) {
                this.xv = rVar;
                this.f32241r = wVar;
                this.f32239c = true;
            }
            return this.f32239c;
        }

        @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
        public void onRewardVideoCached(fp fpVar) {
            fp fpVar2;
            k.c((Context) null).w();
            if (this.xv != null) {
                if ((fpVar instanceof bk) && this.f32239c) {
                    bk bkVar = (bk) fpVar;
                    bkVar.w(true);
                    bkVar.xv(103);
                }
                if (this.f32239c && (fpVar2 = this.f32242w) != null) {
                    this.ux = true;
                    onRewardVideoAdLoad(fpVar2);
                    if (!this.f32240f) {
                        onRewardVideoCached();
                    }
                    me meVar = this.sr;
                    String jr = meVar != null ? meVar.jr() : "0";
                    me meVar2 = this.sr;
                    c.w(jr, "rewarded_video", meVar2 != null ? meVar2.cf() : "", 1, this.f32241r);
                }
                this.xv.onRewardVideoCached(fpVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(String str, String str2, String str3, final int i4, final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        new c.C0472c().ux(str).c(str2).w("get_preload_ad").sr(str3).c(new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.1
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("preload_ad_type", i4);
                com.bytedance.sdk.openadsdk.ys.w.xv.w wVar2 = wVar;
                if (wVar2 != null && wVar2.gb() != null) {
                    int i5 = AnonymousClass2.f32225c[wVar.gb().ordinal()];
                    if (i5 == 1) {
                        jSONObject2.put("req_type", 3);
                    } else if (i5 != 2) {
                        jSONObject2.put("req_type", -1);
                    } else {
                        jSONObject2.put("req_type", 1);
                    }
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }
}
