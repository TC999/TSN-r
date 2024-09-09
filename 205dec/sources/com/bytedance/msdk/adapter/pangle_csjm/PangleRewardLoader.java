package com.bytedance.msdk.adapter.pangle_csjm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.msdk.adapter.c;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.msdk.c.ux;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.fz.c.w.c.r;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.ys.w.c.w;
import com.bytedance.sdk.openadsdk.ys.w.w.fp;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleRewardLoader extends c {
    public static final String TAG = "PgRewardVideoAdapter";
    public static final String VERSION_00 = "0.0";
    public static final String VERSION_4400 = "4.4.0.0";

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class PangleRewardVideo extends ux {

        /* renamed from: c  reason: collision with root package name */
        r f27179c = new AnonymousClass1(null);
        private boolean sr;
        private Map<String, Object> ux;
        private fp xv;

        /* renamed from: com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader$PangleRewardVideo$1  reason: invalid class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        class AnonymousClass1 extends r {
            AnonymousClass1(Bridge bridge) {
                super(bridge);
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
            public void onError(int i4, String str) {
                xv.sr("TTMediationSDK", "pangle_reward_onError code:" + i4 + "  message:" + str);
                PangleRewardLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(i4, str));
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
            public void onRewardVideoAdLoad(fp fpVar) {
                xv.sr("TTMediationSDK", "pangle_reward_onRewardVideoAdLoad");
                if (fpVar == null) {
                    PangleRewardLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c("\u8bf7\u6c42\u6210\u529f\uff0c\u4f46\u65e0\u5e7f\u544a\u53ef\u7528"));
                    return;
                }
                PangleRewardVideo.this.xv = fpVar;
                PangleRewardVideo.this.setExpressAd(true);
                PangleRewardVideo pangleRewardVideo = PangleRewardVideo.this;
                pangleRewardVideo.setInteractionType(pangleRewardVideo.xv.c());
                Map<String, Object> w3 = PangleRewardVideo.this.xv.w();
                if (PangleRewardLoader.this.isClientBidding() && w3 != null) {
                    double value = PangleAdapterUtils.getValue(w3.get(BidResponsed.KEY_PRICE));
                    xv.c("TTMediationSDK_ECMP", com.bytedance.msdk.adapter.sr.ux.w(PangleRewardLoader.this.getAdapterRit(), PangleRewardLoader.this.getAdSlotId()) + "pangle reward \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
                    PangleRewardVideo pangleRewardVideo2 = PangleRewardVideo.this;
                    if (value <= 0.0d) {
                        value = 0.0d;
                    }
                    pangleRewardVideo2.setCpm(value);
                }
                if (w3 != null) {
                    Object obj = w3.get("materialMetaIsFromPreload");
                    if (obj instanceof Boolean) {
                        PangleRewardVideo.this.sr = ((Boolean) obj).booleanValue();
                        xv.c("TTMediationSDK", "pangle \u6fc0\u52b1 \u8fd4\u56de\u7684adnPreload\uff1a" + PangleRewardVideo.this.sr);
                    }
                }
                PangleRewardVideo.this.xv.w(new com.bytedance.sdk.openadsdk.gb.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.PangleRewardVideo.1.1
                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onAdClose() {
                        xv.sr("TTMediationSDK", "pangle_reward:onAdClose-----------2");
                        if (((ux) PangleRewardVideo.this).bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.c().s_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onAdShow() {
                        xv.sr("TTMediationSDK", "pangle_reward:onAdShow-----------2");
                        if (((ux) PangleRewardVideo.this).bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.c().c();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onAdVideoBarClick() {
                        xv.sr("TTMediationSDK", "pangle_reward:onAdVideoBarClick---------2");
                        if (((ux) PangleRewardVideo.this).bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.c().r_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onRewardArrived(final boolean z3, final int i4, final Bundle bundle) {
                        if (PangleRewardVideo.this.xv()) {
                            return;
                        }
                        xv.sr("TTMediationSDK", "pangle_reward:onRewardArrived-------------2");
                        if (((ux) PangleRewardVideo.this).bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.c().c(new com.bytedance.msdk.api.xv.c() { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.PangleRewardVideo.1.1.2
                                @Override // com.bytedance.msdk.api.xv.c
                                public float getAmount() {
                                    Bundle bundle2 = bundle;
                                    float f4 = bundle2 != null ? bundle2.getInt("reward_extra_key_reward_amount") : 0.0f;
                                    if (f4 >= 0.0f) {
                                        return f4;
                                    }
                                    if (((c) PangleRewardLoader.this).xv != null) {
                                        return ((c) PangleRewardLoader.this).xv.z();
                                    }
                                    return 0.0f;
                                }

                                @Override // com.bytedance.msdk.api.xv.c
                                public Map<String, Object> getCustomData() {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("extraInfo", bundle);
                                    hashMap.put("rewardType", Integer.valueOf(i4));
                                    return hashMap;
                                }

                                @Override // com.bytedance.msdk.api.xv.c
                                public String getRewardName() {
                                    Bundle bundle2 = bundle;
                                    String string = bundle2 != null ? bundle2.getString("reward_extra_key_reward_name") : "";
                                    return !TextUtils.isEmpty(string) ? string : ((c) PangleRewardLoader.this).xv != null ? ((c) PangleRewardLoader.this).xv.ck() : "";
                                }

                                @Override // com.bytedance.msdk.api.xv.c
                                public boolean rewardVerify() {
                                    return z3;
                                }
                            });
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    @Deprecated
                    public void onRewardVerify(final boolean z3, final int i4, final String str, final int i5, final String str2) {
                        if (PangleRewardVideo.this.xv()) {
                            xv.sr("TTMediationSDK", "pangle_reward:onRewardVerify-------------2");
                            if (((ux) PangleRewardVideo.this).bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                                PangleRewardVideo.this.c().c(new com.bytedance.msdk.api.xv.c() { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.PangleRewardVideo.1.1.1
                                    @Override // com.bytedance.msdk.api.xv.c
                                    public float getAmount() {
                                        int i6 = i4;
                                        if (i6 >= 0) {
                                            return i6;
                                        }
                                        if (((c) PangleRewardLoader.this).xv != null) {
                                            return ((c) PangleRewardLoader.this).xv.z();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.xv.c
                                    public Map<String, Object> getCustomData() {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("errorCode", Integer.valueOf(i5));
                                        hashMap.put("errorMsg", str2);
                                        return hashMap;
                                    }

                                    @Override // com.bytedance.msdk.api.xv.c
                                    public String getRewardName() {
                                        if (TextUtils.isEmpty(str)) {
                                            return ((c) PangleRewardLoader.this).xv != null ? ((c) PangleRewardLoader.this).xv.ck() : "";
                                        }
                                        return str;
                                    }

                                    @Override // com.bytedance.msdk.api.xv.c
                                    public boolean rewardVerify() {
                                        return z3;
                                    }
                                });
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onSkippedVideo() {
                        xv.sr("TTMediationSDK", "pangle_reward:onSkippedVideo-------------2");
                        if (((ux) PangleRewardVideo.this).bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.c().f();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onVideoComplete() {
                        xv.sr("TTMediationSDK", "pangle_reward:onVideoComplete----------2");
                        if (((ux) PangleRewardVideo.this).bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.c().t_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onVideoError() {
                        xv.sr("TTMediationSDK", "pangle_reward:onVideoError-----------2");
                        if (((ux) PangleRewardVideo.this).bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.c().ux();
                        }
                    }
                });
                PangleRewardVideo.this.xv.c(new com.bytedance.sdk.openadsdk.gb.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.PangleRewardVideo.1.2
                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onAdClose() {
                        xv.sr("TTMediationSDK", "pangle_reward:onAdClose");
                        if (((ux) PangleRewardVideo.this).f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.w().s_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onAdShow() {
                        xv.sr("TTMediationSDK", "pangle_reward:onAdShow");
                        if (((ux) PangleRewardVideo.this).f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.w().c();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onAdVideoBarClick() {
                        xv.sr("TTMediationSDK", "pangle_reward:onAdVideoBarClick");
                        if (((ux) PangleRewardVideo.this).f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.w().r_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onRewardArrived(final boolean z3, final int i4, final Bundle bundle) {
                        if (PangleRewardVideo.this.xv()) {
                            return;
                        }
                        xv.sr("TTMediationSDK", "pangle_reward:onRewardArrived-------------2");
                        if (((ux) PangleRewardVideo.this).f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.w().c(new com.bytedance.msdk.api.xv.c() { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.PangleRewardVideo.1.2.2
                                @Override // com.bytedance.msdk.api.xv.c
                                public float getAmount() {
                                    Bundle bundle2 = bundle;
                                    float f4 = bundle2 != null ? bundle2.getInt("reward_extra_key_reward_amount") : 0.0f;
                                    if (f4 >= 0.0f) {
                                        return f4;
                                    }
                                    if (((c) PangleRewardLoader.this).xv != null) {
                                        return ((c) PangleRewardLoader.this).xv.z();
                                    }
                                    return 0.0f;
                                }

                                @Override // com.bytedance.msdk.api.xv.c
                                public Map<String, Object> getCustomData() {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("extraInfo", bundle);
                                    hashMap.put("rewardType", Integer.valueOf(i4));
                                    return hashMap;
                                }

                                @Override // com.bytedance.msdk.api.xv.c
                                public String getRewardName() {
                                    Bundle bundle2 = bundle;
                                    String string = bundle2 != null ? bundle2.getString("reward_extra_key_reward_name") : "";
                                    return !TextUtils.isEmpty(string) ? string : ((c) PangleRewardLoader.this).xv != null ? ((c) PangleRewardLoader.this).xv.ck() : "";
                                }

                                @Override // com.bytedance.msdk.api.xv.c
                                public boolean rewardVerify() {
                                    return z3;
                                }
                            });
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    @Deprecated
                    public void onRewardVerify(final boolean z3, final int i4, final String str, final int i5, final String str2) {
                        if (PangleRewardVideo.this.xv()) {
                            xv.sr("TTMediationSDK", "pangle_reward:onRewardVerify-------------2");
                            if (((ux) PangleRewardVideo.this).f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                                PangleRewardVideo.this.w().c(new com.bytedance.msdk.api.xv.c() { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.PangleRewardVideo.1.2.1
                                    @Override // com.bytedance.msdk.api.xv.c
                                    public float getAmount() {
                                        int i6 = i4;
                                        if (i6 >= 0) {
                                            return i6;
                                        }
                                        if (((c) PangleRewardLoader.this).xv != null) {
                                            return ((c) PangleRewardLoader.this).xv.z();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.xv.c
                                    public Map<String, Object> getCustomData() {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("errorCode", Integer.valueOf(i5));
                                        hashMap.put("errorMsg", str2);
                                        return hashMap;
                                    }

                                    @Override // com.bytedance.msdk.api.xv.c
                                    public String getRewardName() {
                                        if (TextUtils.isEmpty(str)) {
                                            return ((c) PangleRewardLoader.this).xv != null ? ((c) PangleRewardLoader.this).xv.ck() : "";
                                        }
                                        return str;
                                    }

                                    @Override // com.bytedance.msdk.api.xv.c
                                    public boolean rewardVerify() {
                                        return z3;
                                    }
                                });
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onSkippedVideo() {
                        xv.sr("TTMediationSDK", "pangle_reward:onSkippedVideo");
                        if (((ux) PangleRewardVideo.this).f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.w().f();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onVideoComplete() {
                        xv.sr("TTMediationSDK", "pangle_reward:onVideoComplete");
                        if (((ux) PangleRewardVideo.this).f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.w().t_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.gb.c.w.c.c
                    public void onVideoError() {
                        xv.sr("TTMediationSDK", "pangle_reward:onVideoError");
                        if (((ux) PangleRewardVideo.this).f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                            PangleRewardVideo.this.w().ux();
                        }
                    }
                });
                PangleRewardVideo pangleRewardVideo3 = PangleRewardVideo.this;
                PangleRewardLoader.this.notifyAdLoaded(pangleRewardVideo3);
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
            public void onRewardVideoCached() {
                xv.sr("TTMediationSDK", "pangle_reward_onRewardVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
            public void onRewardVideoCached(fp fpVar) {
                xv.sr("TTMediationSDK", "pangle_reward_onRewardVideoCached 2");
                PangleRewardVideo pangleRewardVideo = PangleRewardVideo.this;
                PangleRewardLoader.this.notifyAdVideoCache(pangleRewardVideo, (com.bytedance.msdk.api.c) null);
            }
        }

        PangleRewardVideo(Map<String, Object> map) {
            this.ux = map;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getAdId() {
            fp fpVar = this.xv;
            if (fpVar != null) {
                return PangleAdapterUtils.getAdId(fpVar.w());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getCreativeId() {
            fp fpVar = this.xv;
            if (fpVar != null) {
                return PangleAdapterUtils.getCreativeId(fpVar.w());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> w3;
            fp fpVar = this.xv;
            if (fpVar == null || (w3 = fpVar.w()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, w3.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, w3.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, w3.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
            setMediaExtraInfo(hashMap);
            return super.getMediaExtraInfo();
        }

        @Override // com.bytedance.msdk.c.ux
        public String getReqId() {
            fp fpVar = this.xv;
            return fpVar != null ? PangleAdapterUtils.getReqId(fpVar.w()) : "";
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDestroyed() {
            return this.xv == null;
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean isAdnPreload() {
            return this.sr;
        }

        @Override // com.bytedance.msdk.c.ux
        public MediationConstant.AdIsReadyStatus isReadyStatus() {
            fp fpVar = this.xv;
            if (fpVar != null && fpVar.sr() > System.currentTimeMillis()) {
                return MediationConstant.AdIsReadyStatus.AD_IS_READY;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED;
        }

        @Override // com.bytedance.msdk.c.ux
        public void onDestroy() {
            fp fpVar = this.xv;
            if (fpVar != null) {
                fpVar.c((w) null);
                this.xv.c((com.bytedance.sdk.openadsdk.gb.c.w.c.c) null);
                this.xv = null;
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public void showAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
            fp fpVar = this.xv;
            if (fpVar != null) {
                if (ritScenes != null) {
                    fpVar.c(activity, ritScenes, str);
                } else {
                    fpVar.c(activity);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.api.sr.c.ev.c w() {
            return (com.bytedance.msdk.api.sr.c.ev.c) this.f27667a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean xv() {
            return !"0.0".equals(PangleRewardLoader.this.getSdkVersion()) && PangleRewardLoader.VERSION_4400.compareTo(PangleRewardLoader.this.getSdkVersion()) > 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.api.sr.c.ev.c c() {
            return (com.bytedance.msdk.api.sr.c.ev.c) this.bk;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void c(android.content.Context r9) {
            /*
                r8 = this;
                com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader r0 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.this
                com.bytedance.sdk.openadsdk.core.wv r9 = r0.getPluginCSJLoader(r9)
                if (r9 != 0) goto L9
                return
            L9:
                com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader r0 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.this
                com.bytedance.msdk.api.c.w r0 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.c(r0)
                java.util.Map r0 = r0.yu()
                if (r0 == 0) goto L28
                java.lang.String r1 = "pangle"
                java.lang.Object r0 = r0.get(r1)
                boolean r1 = r0 instanceof java.lang.String
                if (r1 == 0) goto L28
                java.lang.String r0 = (java.lang.String) r0
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L28
                goto L2a
            L28:
                java.lang.String r0 = ""
            L2a:
                com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader r1 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.this
                com.bytedance.msdk.api.c.w r2 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.w(r1)
                com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader r1 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.this
                java.lang.String r3 = r1.getAdSlotId()
                com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader r1 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.this
                java.lang.String r4 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.xv(r1)
                com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader r1 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.this
                java.lang.String r5 = r1.getClientReqId()
                com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader r1 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.this
                java.lang.String r6 = r1.getAdm()
                r7 = 0
                com.bytedance.sdk.openadsdk.ys.w.xv.w$c r1 = com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils.buildPangleAdSlot(r2, r3, r4, r5, r6, r7)
                com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader r2 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.this
                com.bytedance.msdk.api.c.w r2 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.r(r2)
                java.lang.String r2 = r2.y()
                com.bytedance.sdk.openadsdk.ys.w.xv.w$c r2 = r1.f(r2)
                com.bytedance.sdk.openadsdk.ys.w.xv.w$c r0 = r2.ux(r0)
                com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader r2 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.this
                com.bytedance.msdk.api.c.w r2 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.f(r2)
                java.lang.String r2 = r2.ck()
                com.bytedance.sdk.openadsdk.ys.w.xv.w$c r0 = r0.p(r2)
                com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader r2 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.this
                com.bytedance.msdk.api.c.w r2 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.ux(r2)
                int r2 = r2.z()
                com.bytedance.sdk.openadsdk.ys.w.xv.w$c r0 = r0.ev(r2)
                r2 = 1080(0x438, float:1.513E-42)
                com.bytedance.sdk.openadsdk.ys.w.xv.w$c r0 = r0.c(r2)
                r2 = 1920(0x780, float:2.69E-42)
                com.bytedance.sdk.openadsdk.ys.w.xv.w$c r0 = r0.w(r2)
                com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader r2 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.this
                com.bytedance.msdk.api.c.w r2 = com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.sr(r2)
                int r2 = r2.eq()
                r0.sr(r2)
                com.bytedance.sdk.openadsdk.ys.w.xv.w r0 = r1.c()
                com.bytedance.sdk.openadsdk.fz.c.w.c.r r1 = r8.f27179c
                r9.c(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader.PangleRewardVideo.c(android.content.Context):void");
        }
    }

    @Override // com.bytedance.msdk.adapter.c
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getAdNetWorkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getSdkVersion() {
        try {
            return com.bytedance.sdk.gromore.init.c.xv();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.c
    public void loadAd(Context context, Map<String, Object> map) {
        if (this.xv == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
        } else {
            new PangleRewardVideo(map).c(context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : com.bytedance.msdk.core.c.getContext());
        }
    }

    public void notifyLoadFailBecauseGMAdSlotIsNull() {
        notifyAdFailed(new com.bytedance.msdk.api.c("load ad fail adSlot is null"));
    }
}
